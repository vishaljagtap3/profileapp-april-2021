package in.bitcode.profileapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ProfileEditorActivity extends Activity {

    private EditText mEdtName, mEdtPhone, mEdtEmail, mEdtSkills;
    private Button mBtnSaveProfile;

    private Profile mProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        mBtnSaveProfile.setOnClickListener(new BtnSaveProfileClickListener());

        getInput();

    }

    private void getInput() {
        //extract the input if any
        mProfile = (Profile) getIntent().getSerializableExtra(Profile.KEY_PROFILE);
        if(mProfile != null) {
            mEdtName.setText(mProfile.getName());
            mEdtPhone.setText(mProfile.getPhone());
            mEdtEmail.setText(mProfile.getEmail());
            mEdtSkills.setText(mProfile.getSkills());
        }
    }

    private class BtnSaveProfileClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Intent resIntent = new Intent();

            Profile profile = new Profile(
                    mEdtName.getText().toString(),
                    mEdtPhone.getText().toString(),
                    mEdtEmail.getText().toString(),
                    mEdtSkills.getText().toString()
            );
            resIntent.putExtra(Profile.KEY_PROFILE, profile);

            /*resIntent.putExtra("name", mEdtName.getText().toString());
            resIntent.putExtra("phone", mEdtPhone.getText().toString());
            resIntent.putExtra("email", mEdtEmail.getText().toString());
            resIntent.putExtra("skills", mEdtSkills.getText().toString());*/

            setResult(1, resIntent);
            finish();
        }
    }

    private void init() {
        setContentView(R.layout.profile_editor_activity);

        mEdtName = findViewById(R.id.edtName);
        mEdtPhone = findViewById(R.id.edtPhone);
        mEdtEmail = findViewById(R.id.edtEmail);
        mEdtSkills = findViewById(R.id.edtSkills);
        mBtnSaveProfile = findViewById(R.id.btnSaveProfile);
    }
}
