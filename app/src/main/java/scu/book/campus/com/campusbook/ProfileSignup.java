package scu.book.campus.com.campusbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import scu.book.campus.com.campusbook.model.Books;
import scu.book.campus.com.campusbook.model.User;

/**
 * Created by qizhao on 5/18/16.
 */
public class ProfileSignup extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    EditText name;
    EditText email;
    EditText phone;
    String name_s;
    String email_s;
    String phone_s;
    Firebase myFirebaseRef;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_signup);
        Firebase.setAndroidContext(this);

        Button signUp = (Button) findViewById(R.id.sign_up);
        Button googleSignIn = (Button) findViewById(R.id.sign_in_button);

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        phone = (EditText) findViewById(R.id.input_phone);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this , this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirebaseRef = new Firebase("https://flickering-torch-3960.firebaseio.com/");
                name_s = name.getText().toString();
                email_s = email.getText().toString();
                phone_s = phone.getText().toString();

                if (name_s == null || name_s.length() == 0){
                    Toast.makeText(getApplicationContext(), "Your name is invalid, please re-enter!", Toast.LENGTH_SHORT).show();
                } else if (!isEmailValid(email_s) || email_s == null || email_s.length() == 0){
                    Toast.makeText(getApplicationContext(),"Your email address is invalid, please re-enter!" , Toast.LENGTH_SHORT).show();

                }else {
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


             }
        });

    }
    public boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
