package scu.book.campus.com.campusbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
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

    ImageView bookImage;
    TextView bookName;
    TextView bookPrice;
    TextView isbn;

    ImageView bookImageSecondPage;

    TextView sellerName;
    TextView sellerEmail;
    TextView sellerPhone;


    LinearLayout page1;
    LinearLayout page2;
    LinearLayout page3;


    ImageView bookImageSThirdPAge;

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
        Button showMap = (Button) rootView.findViewById(R.id.map_button);
        bookImage = (ImageView) rootView.findViewById(R.id.book_image);
        bookName = (TextView) rootView.findViewById(R.id.book_name);
        bookPrice = (TextView) rootView.findViewById(R.id.book_price);
        isbn = (TextView) rootView.findViewById(R.id.isbn);

        bookImageSecondPage = (ImageView) rootView.findViewById(R.id.book_image_second_page);

        sellerName = (TextView) rootView.findViewById(R.id.seller_name);
        sellerEmail = (TextView) rootView.findViewById(R.id.seller_email);
        sellerPhone = (TextView) rootView.findViewById(R.id.seller_phone);

        bookImageSThirdPAge = (ImageView) rootView.findViewById(R.id.book_image_third_page);
        page1 = (LinearLayout) rootView.findViewById(R.id.buyer_page1);
        page2 = (LinearLayout) rootView.findViewById(R.id.buyer_page2);
        page3 = (LinearLayout) rootView.findViewById(R.id.buyer_page3);

        final LinearLayout soldPage = (LinearLayout) rootView.findViewById(R.id.seller_page_sold);
//        final SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
//        if (bookSelected == true) {
//            SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
//            String json = myPrefs.getString("selectedbook", "");
//            Log.d("Book obj", json);
//            Gson gson = new Gson();
//            bookObj = gson.fromJson(json, Books.class);
//            if (json != null && json != "")
//                bookName.setText(bookObj.getBookName());
//            bookPrice.setText(bookObj.getBookPrice());
//
//            Bitmap bookImageBitmap = SharedData.getDecodedImageFromString(bookObj.getBookImage());
//            bookImage.setImageBitmap(bookImageBitmap);
//
//>>>>>>> aebe56ae62be1e0a5e510efc17dcb5f8004c2786
//
        page1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookSelected == true) {
                    page1.setVisibility(View.GONE);
                    page2.setVisibility(View.VISIBLE);
                    page3.setVisibility(View.GONE);

                    sellerName.setText(bookObj.sellerName);
                    sellerEmail.setText(bookObj.sellerEmail);
                    bookImageSecondPage.setImageBitmap(SharedData.getDecodedImageFromString(bookObj.getBookImage()));
                }
            }
        });
        page2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.GONE);
                page3.setVisibility(View.VISIBLE);
                bookImageSThirdPAge.setImageBitmap(SharedData.getDecodedImageFromString(bookObj.getBookImage()));

            }
        });
        page3Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page3.setVisibility(View.GONE);
                soldPage.setVisibility(View.VISIBLE);

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
        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                intent.putExtra("location_name", bookObj.sellerLocation);
                intent.putExtra("seller",bookObj.sellerName);
                intent.putExtra("seller_email",bookObj.sellerEmail);
                startActivity(intent);
            }
        });
        return rootView;
    }


//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        System.out.println("Buyer page fragment visible onHIddenChanged " + hidden);
//        if (!hidden) {
//
//            if (bookSelected == true) {
//                SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
//                String json = myPrefs.getString("selectedbook", "");
//                Log.d("Book obj", json);
//                Gson gson = new Gson();
//                bookObj = gson.fromJson(json, Books.class);
//                if (json != null || json != "")
//                    bookName.setText(bookObj.getBookName());
//                bookPrice.setText(bookObj.getBookPrice());
//                Bitmap bookImageBitmap = SharedData.getDecodedImageFromString(bookObj.getBookImage());
//                bookImage.setImageBitmap(bookImageBitmap);
//
//
//                bookSelected = false;
//
//            }
//
//        }
//    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("Book obj", "SetUserVisibliitHint " + isVisibleToUser + " is book selected" + bookSelected);
        if (isVisibleToUser) {

            page1.setVisibility(View.VISIBLE);
            page2.setVisibility(View.GONE);
            page3.setVisibility(View.GONE);

            if (bookSelected == true) {
                SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
                String json = myPrefs.getString("selectedbook", "");
                Log.d("Book obj", json);
                Gson gson = new Gson();
                bookObj = gson.fromJson(json, Books.class);
                if (json != null || json != "")
                    bookName.setText(bookObj.getBookName());
                bookPrice.setText(bookObj.getBookPrice());
                isbn.setText(bookObj.getIsbn());

                Bitmap bookImageBitmap = SharedData.getDecodedImageFromString(bookObj.getBookImage());
                bookImage.setImageBitmap(bookImageBitmap);


            }
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        System.out.println("Buyer page fragment visible  OnResume");

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        System.out.println("Buyer page fragment visible  OnResume" + bookSelected);
//
//        if (bookSelected == true) {
//            SharedPreferences myPrefs = getContext().getSharedPreferences("myPrefs", getContext().MODE_PRIVATE);
//            String json = myPrefs.getString("selectedbook", "");
//            Log.d("Book obj", json);
//            Gson gson = new Gson();
//            bookObj = gson.fromJson(json, Books.class);
//            if (json != null || json != "")
//                bookName.setText(bookObj.getBookName());
//            bookPrice.setText(bookObj.getBookPrice());
//
//            Bitmap bookImageBitmap = SharedData.getDecodedImageFromString(bookObj.getBookImage());
//            bookImage.setImageBitmap(bookImageBitmap);
//
//
//        }
//
//    }
}

