package in.bitcode.profileapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        setContentView(mContainer);

    }
}
