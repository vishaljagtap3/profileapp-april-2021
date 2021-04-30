package in.bitcode.profileapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImgCountry;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;

    private int [] mArrImageIds = {
            R.drawable.in_flag, R.drawable.flag_canda, R.drawable.flag_us, R.drawable.flag
    };
    private int mCurrentImageIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        /*
        mBtnLogin.setOnTouchListener( new BtnLoginTouchListener() );
        mBtnLogin.setOnKeyListener( new BtnLoginKeyListener() );
        */

        mBtnLogin.setOnClickListener(new BtnLoginClickListener());
        mImgCountry.setOnClickListener(new ImgCountryClickListener());
    }

    private void init() {
        setContentView(R.layout.activity_main);
        mImgCountry = findViewById(R.id.imgCountry);
        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);
        mBtnLogin = findViewById(R.id.btnLogin);

        mImgCountry.setImageResource( mArrImageIds[mCurrentImageIndex] );
    }

    private class ImgCountryClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mCurrentImageIndex = (mCurrentImageIndex+1) % mArrImageIds.length;
            mImgCountry.setImageResource( mArrImageIds[mCurrentImageIndex] );
        }
    }


    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if( mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode") ) {
                log("Login Successful!");
            }
            else {
                log("Login failed!");
            }

            System.out.println("Button login is Clicked!");
            //Log.e("profileapp", "Button login is touched!");
            log("Button is Clicked!");

        }
    }

    class BtnLoginKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            if( mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode") ) {
                log("Login Successful!");
            }
            else {
                log("Login failed!");
            }

            System.out.println("Button login is touched!");
            //Log.e("profileapp", "Button login is touched!");
            log("Button is touched!");


            return false;
        }
    }

    class BtnLoginTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            if( mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode") ) {
                log("Login Successful!");
            }
            else {
                log("Login failed!");
            }

            System.out.println("Button login is touched!");
            //Log.e("profileapp", "Button login is touched!");
            log("Button is touched!");

            return false;
        }
    }

    private void log(String text) {
        Log.e("profileapp", text);
    }
}

