package scu.book.campus.com.campusbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.ByteArrayOutputStream;

/**
 * Created by qizhao on 5/22/16.
 */
public class Uplaod extends AppCompatActivity{
    Firebase myFirebaseRef;
    ImageView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadbook);
        Firebase.setAndroidContext(this);
        Button upload = (Button) findViewById(R.id.button3);
        Button showimage = (Button) findViewById(R.id.button8);
        show = (ImageView) findViewById(R.id.imageView2);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirebaseRef = new Firebase("https://flickering-torch-3960.firebaseio.com/");
                Firebase alanRef = myFirebaseRef.child("Books").child("Book1");
                alanRef.child("price").setValue("13");
                alanRef.child("name").setValue("book1");

                Firebase alanRef2 = myFirebaseRef.child("Books").child("Book2");
                Books alan = new Books("15", "book2");
                alanRef2.setValue(alan);
                storeImageToFirebase();

                alanRef.child("price").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                    }
                    @Override public void onCancelled(FirebaseError error) { }
                });
            }
        });
        showimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previewStoredFirebaseImage();
            }
        });

    }

    private void storeImageToFirebase() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8; // shrink it down otherwise we will use stupid amounts of memory
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.book_cover_1, options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        String base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);

        // we finally have our base64 string version of the image, save it.
        myFirebaseRef.child("pic").setValue(base64Image);
        System.out.println("Stored image with length: " + bytes.length);
    }
    private void previewStoredFirebaseImage() {
        myFirebaseRef.child("pic").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String base64Image = (String) snapshot.getValue();
                byte[] imageAsBytes = Base64.decode(base64Image.getBytes(), Base64.DEFAULT);
                show.setImageBitmap(
                        BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length)
                );
                System.out.println("Downloaded image with length: " + imageAsBytes.length);
            }

            @Override
            public void onCancelled(FirebaseError error) {}
        });
    }
}
