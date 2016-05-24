package scu.book.campus.com.campusbook.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.List;

import scu.book.campus.com.campusbook.R;
import scu.book.campus.com.campusbook.model.Books;

/**
 * Created by kushahuja on 5/17/16.
 */
public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {
    private List<Books> booksList;
    Context context;
Firebase firebaseRef;

    public ImageListAdapter(Context context) {
        List<Books> booksList = new ArrayList<>();
        this.context = context;
        firebaseRef= new FireBaseAdapter(context).getFirebase();

        firebaseRef.child("Books-Kush2");
        Query query = firebaseRef.orderByValue();
        Drawable myDrawable = context.getResources().getDrawable(R.drawable.book_cover_1);
        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();

        booksList.add(new Books("kush","22","333","444","55","333","3233","333"));
        System.out.println("the data retrived is ");

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println("the data retrived is "+dataSnapshot.child("name").getValue());
                System.out.println("the data retrived is "+dataSnapshot.child("pic").getValue());
                System.out.println("the data retrived is "+dataSnapshot.child("name").getValue());


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        this.booksList = booksList;


    }

    @Override
    public ImageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_page_grid, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ImageListAdapter.MyViewHolder holder, int position) {

        Books book = booksList.get(position);
        holder.bookName.setText(book.bookName);
        holder.bookPrice.setText(book.bookPrice);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8; // Experiment with different sizes
    }

    @Override
    public int getItemCount() {
//        Toast.makeText(context, "The new image list size when retyurning to main Activity is " + imageList.size(), Toast.LENGTH_SHORT).show();
        return 1;


    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName;
        public TextView bookPrice;
        public ImageView img_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            bookPrice= (TextView) itemView.findViewById(R.id.book_price);

            img_icon = (ImageView) itemView.findViewById(R.id.book_img);
        }
    }

    public Books getImageObjectAtPosition(int position) {

        Books image = booksList.get(position);
        return image;
    }


}
