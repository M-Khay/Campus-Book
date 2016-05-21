package scu.book.campus.com.campusbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by qizhao on 5/18/16.
 */
public class ProfileSignup extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_signup);
        Button create = (Button) findViewById(R.id.button3);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileSignup.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

}
