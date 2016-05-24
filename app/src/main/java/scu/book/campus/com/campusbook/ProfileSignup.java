package scu.book.campus.com.campusbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

import scu.book.campus.com.campusbook.model.Books;
import scu.book.campus.com.campusbook.model.User;

/**
 * Created by qizhao on 5/18/16.
 */
public class ProfileSignup extends AppCompatActivity{
    EditText name;
    EditText email;
    EditText phone;
    String name_s;
    String email_s;
    String phone_s;
    Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_signup);
        Firebase.setAndroidContext(this);

        Button signUp = (Button) findViewById(R.id.sign_up);
        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        phone = (EditText) findViewById(R.id.input_phone);




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirebaseRef = new Firebase("https://flickering-torch-3960.firebaseio.com/");
                name_s = name.getText().toString();
                email_s = email.getText().toString();
                phone_s = phone.getText().toString();
                Firebase usersRef = myFirebaseRef.child("Users");
                //System.out.println(name_s);
                /*Log.d("name", name_s);
                Log.d("email", email_s);
                Log.d("phone", phone_s);
*/              /*Map<String, String> user_temp = new HashMap<String, String>();
                user_temp.put("name", name_s);
                user_temp.put("email", email_s);
                user_temp.put("phone", phone_s);
                usersRef.push().setValue(user_temp);*/

                User user_1 = new User(name_s, email_s, phone_s);
                usersRef.push().setValue(user_1);


                /*Firebase alanRef2 = myFirebaseRef.child("Books").child("Book2");
                Books alan = new Books("15", "book2");
                alanRef2.setValue(alan);*/


                Intent homePage = new Intent(ProfileSignup.this,HomeActivity.class);
                startActivity(homePage);

             }
        });

    }

}
