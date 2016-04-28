package team1_5115.cscc_laundryapp;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Leet on 4/26/2016.
 */
public class MaintenanceDryer extends AppCompatActivity implements MaintenanceIssueFragment.OnFragmentInteractionListener, MaintenanceConfirmFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_dryer);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MaintenanceIssueFragment issueFragment = new MaintenanceIssueFragment();
        transaction.add(R.id.maintenance_dryer_container, issueFragment, "dryer_fragment");
        transaction.commit();
    }

    public void onIssueSubmitButtonClicked(View view) {
        MaintenanceIssueFragment oldFragment = (MaintenanceIssueFragment) getSupportFragmentManager().findFragmentById(R.id.maintenance_issue_fragment);
        MaintenanceConfirmFragment newFragment = new MaintenanceConfirmFragment();
        Bundle args = new Bundle();
        newFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.maintenance_dryer_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onConfirmSubmitButtonClicked(View view) {
        Toast.makeText(this.getBaseContext(), "A maintenance request has sent", Toast.LENGTH_LONG).show();
        finish();
    }

    public void onRadioButtonClicked(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.maintenance_radio_group);
        RadioButton radio_1 = (RadioButton) findViewById(R.id.issues_1_radio);
        RadioButton radio_2 = (RadioButton) findViewById(R.id.issues_2_radio);
        RadioButton radio_3 = (RadioButton) findViewById(R.id.issues_3_radio);
        radio_1.setTypeface(null, Typeface.NORMAL);
        radio_2.setTypeface(null, Typeface.NORMAL);
        radio_3.setTypeface(null, Typeface.NORMAL);
        RadioButton newRadio = (RadioButton) radioGroup.findViewById(view.getId());
        newRadio.setTypeface(null, Typeface.BOLD);
    }

    public void onCancelButtonClicked(View view) {
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}