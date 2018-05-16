package project.iot.smartdoor;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    private Button openBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openButtonListener();
    }

    private void openButtonListener(){
        openBtn = (Button) findViewById(R.id.openButton);
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    private void createDialog(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alertDialogBuilder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog);
        }
        else {
            alertDialogBuilder = new AlertDialog.Builder(this);
        }

        alertDialogBuilder.setTitle("Hello")
                .setMessage("Hello")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // continue with delete it !
                    }
                })
                .show();
    }
}
