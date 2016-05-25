package scu.book.campus.com.campusbook;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.gson.Gson;

import scu.book.campus.com.campusbook.Constants.SharedData;
import scu.book.campus.com.campusbook.model.Books;
import scu.book.campus.com.campusbook.model.User;

/**
 * Created by qizhao on 5/18/16.
 */
public class Buyer extends Fragment {

    public static boolean bookSelected = false;
    Books bookObj;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Firebase firebaseRef;
        View rootView = inflater.inflate(
                R.layout.buyer_page, container, false);

        Firebase.setAndroidContext(getContext());
        firebaseRef = new Firebase("https://flickering-torch-3960.firebaseio.com/Books");


        System.out.println("Buyer page started");

        Query query = firebaseRef.orderByChild("sellerEmail").equalTo("kkju@gmail.com");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Books books = dataSnapshot.getValue(Books.class);

                System.out.println("book name retrived is " + books.getBookName());

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
        Button page1Next = (Button) rootView.findViewById(R.id.button_buyer1_1);
        Button page2Next = (Button) rootView.findViewById(R.id.button_buyer2_1);
        Button page3Next = (Button) rootView.findViewById(R.id.button_buyer3_1);
        Button page2Back = (Button) rootView.findViewById(R.id.button5);
        Button page3Back = (Button) rootView.findViewById(R.id.button6);
        final ImageView bookImage = (ImageView) rootView.findViewById(R.id.book_image);
        TextView bookName = (TextView) rootView.findViewById(R.id.book_name);
        TextView bookPrice = (TextView) rootView.findViewById(R.id.book_price);
        TextView isbn = (TextView) rootView.findViewById(R.id.isbn);

        final ImageView bookImageSecondPage = (ImageView) rootView.findViewById(R.id.book_image_second_page);
        final TextView sellerName = (TextView) rootView.findViewById(R.id.seller_name);
        final TextView sellerEmail = (TextView) rootView.findViewById(R.id.seller_email);
        final TextView sellerPhone = (TextView) rootView.findViewById(R.id.seller_phone);

        final LinearLayout page1 = (LinearLayout) rootView.findViewById(R.id.buyer_page1);
        final LinearLayout page2 = (LinearLayout) rootView.findViewById(R.id.buyer_page2);
        final LinearLayout page3 = (LinearLayout) rootView.findViewById(R.id.buyer_page3);

//        final SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
        if (bookSelected == true) {
            SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
            String json = myPrefs.getString("selectedbook", "");
            Log.d("Book obj", json);
            Gson gson = new Gson();
            bookObj = gson.fromJson(json, Books.class);
            if (json != null || json != "")
                bookName.setText(bookObj.getBookName());
            bookPrice.setText(bookObj.getBookPrice());

            Bitmap bookImageBitmap = SharedData.getDecodedImageFromString(bookObj.getBookImage());
            bookImage.setImageBitmap(bookImageBitmap);


        }
        page1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.GONE);

                sellerName.setText(bookObj.sellerName);
                sellerEmail.setText(bookObj.sellerEmail);
                bookImageSecondPage.setImageBitmap(SharedData.getDecodedImageFromString(bookObj.getBookImage()));
            }
        });
        page2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.GONE);
                page3.setVisibility(View.VISIBLE);
            }
        });
        page3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        page2Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.VISIBLE);
                page2.setVisibility(View.GONE);
                page3.setVisibility(View.GONE);
            }
        });
        page3Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.GONE);
            }
        });
        return rootView;
    }
}
