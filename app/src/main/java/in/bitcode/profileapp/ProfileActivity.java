package in.bitcode.profileapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProfileActivity extends Activity {

    private String mUsername;
    private int mUserImageId;

    private TextView mTxtUsername;
    private ImageView mImgUserCountry;
    private LinearLayout mContainer;

    private TextView mTxtName, mTxtPhone, mTxtEmail, mTxtSkills;
    private EditText mEdtName, mEdtPhone, mEdtEmail, mEdtSkills;

    private Button mBtnEditProfile;

    private String mName, mPhone, mEmail, mSkills;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();


        mBtnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProfileActivity.this, ProfileEditorActivity.class);
                startActivityForResult(intent, 1);

            }
        });


    }

    private void init() {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        mUsername = params.getString("username");
        mUserImageId = params.getInt("userimageid");

        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        mContainer = new LinearLayout(this);
        mContainer.setOrientation(LinearLayout.VERTICAL);
        mContainer.setLayoutParams(layoutParams);
        mContainer.setPadding(20, 20, 20, 10);

        mTxtUsername = new TextView(this);
        mTxtUsername.setText("Welcome " + mUsername);
        mTxtUsername.setTextSize(35);
        mTxtUsername.setTextColor(Color.BLUE);
        mTxtUsername.setLayoutParams(layoutParams);
        mContainer.addView(mTxtUsername);


        //setContentView(mTxtUsername);

        mImgUserCountry = new ImageView(this);
        mImgUserCountry.setImageResource(mUserImageId);
        mImgUserCountry.setLayoutParams(
                new ViewGroup.LayoutParams( 300, 150)
        );
        mContainer.addView(mImgUserCountry, 0);
        //setContentView(mImgUserCountry);

        mBtnEditProfile = new Button(this);
        mBtnEditProfile.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        mBtnEditProfile.setText("Edit Profile");
        mContainer.addView(mBtnEditProfile);


        mTxtName = new TextView(this);
        mTxtName.setTextSize(20);
        mTxtName.setText("Name");
        mContainer.addView(mTxtName, layoutParams);

        mEdtName = new EditText(this);
        mEdtName.setLayoutParams(layoutParams);
        mContainer.addView(mEdtName);

        mTxtPhone = new TextView(this);
        mTxtPhone.setText("Phone");
        mTxtPhone.setLayoutParams(layoutParams);
        mContainer.addView(mTxtPhone);

        mEdtPhone = new EditText(this);
        mEdtPhone.setLayoutParams(layoutParams);
        mContainer.addView(mEdtPhone);

        mTxtEmail = new TextView(this);
        mTxtEmail.setText("Phone");
        mTxtEmail.setLayoutParams(layoutParams);
        mContainer.addView(mTxtEmail);

        mEdtEmail = new EditText(this);
        mEdtEmail.setLayoutParams(layoutParams);
        mContainer.addView(mEdtEmail);

        mTxtSkills = new TextView(this);
        mTxtSkills.setText("Phone");
        mTxtSkills.setLayoutParams(layoutParams);
        mContainer.addView(mTxtSkills);

        mEdtSkills = new EditText(this);
        mEdtSkills.setLayoutParams(layoutParams);
        mContainer.addView(mEdtSkills);


        setContentView(mContainer);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) {
            return;
        }

        Bundle res = data.getExtras();
        mName = res.getString("name");
        mPhone = res.getString("phone");
        mEmail = res.getString("email");
        mSkills = res.getString("skills");

        mEdtName.setText(mName);
        mEdtPhone.setText(mPhone);
        mEdtEmail.setText(mEmail);
        mEdtSkills.setText(mSkills);
    }
}
