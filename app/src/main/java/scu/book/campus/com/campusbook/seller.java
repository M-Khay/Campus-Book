package scu.book.campus.com.campusbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by qizhao on 5/18/16.
 */
public class seller extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.seller_page, container, false);
        Button page1Next = (Button) rootView.findViewById(R.id.button_seller1_1);
        Button page2Next = (Button) rootView.findViewById(R.id.button_seller2_1);
        Button page3Next = (Button) rootView.findViewById(R.id.button_seller3_1);
        Button page2Back = (Button) rootView.findViewById(R.id.button4);
        Button page3Back = (Button) rootView.findViewById(R.id.button7);
        final LinearLayout page1 = (LinearLayout) rootView.findViewById(R.id.seller_page1);
        final LinearLayout page2 = (LinearLayout) rootView.findViewById(R.id.seller_page2);
        final LinearLayout page3 = (LinearLayout) rootView.findViewById(R.id.seller_page3);

        page1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.GONE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.GONE);
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