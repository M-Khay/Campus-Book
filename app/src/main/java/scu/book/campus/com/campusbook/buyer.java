package scu.book.campus.com.campusbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by qizhao on 5/18/16.
 */
public class buyer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_page);

        Button page1Next = (Button) findViewById(R.id.button_buyer1_1);
        Button page2Next = (Button) findViewById(R.id.button_buyer2_1);
        Button page3Next = (Button) findViewById(R.id.button_buyer3_1);
        Button page2Back = (Button) findViewById(R.id.button5);
        Button page3Back = (Button) findViewById(R.id.button6);
        final LinearLayout page1 = (LinearLayout) findViewById(R.id.buyer_page1);
        final LinearLayout page2 = (LinearLayout) findViewById(R.id.buyer_page2);
        final LinearLayout page3 = (LinearLayout) findViewById(R.id.buyer_page3);

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
    }
}
