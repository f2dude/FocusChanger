package org.rbt.focuschanger;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextView.OnEditorActionListener, AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button submit, reset;
    private EditText password, username, fullname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        submit = (Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);
        password = (EditText) findViewById(R.id.password);
        password.setOnEditorActionListener(this);
        username = (EditText) findViewById(R.id.username);
        fullname = (EditText) findViewById(R.id.fullname);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            password.clearFocus();
            spinner.requestFocus();
            spinner.performClick();

        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = spinner.getSelectedItem().toString();
        if (!text.equalsIgnoreCase("select")){
            username.clearFocus();
            fullname.clearFocus();
            password.clearFocus();
            submit.requestFocus();
            submit.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
                break;

            case R.id.reset:
                Toast.makeText(this, "reset", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
