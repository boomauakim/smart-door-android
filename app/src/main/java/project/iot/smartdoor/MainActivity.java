package project.iot.smartdoor;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add click listener
        openButtonListener();
        lockButtonListener();
        addButtonListener();
        removeButtonListener();
    }

    private void createDialog(String dialogMsg){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCancelable(true);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));

        Button okButton = dialog.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        TextView dialogText = dialog.findViewById(R.id.dialogText);
        dialogText.setText(dialogMsg);

        dialog.show();
    }

    private void openButtonListener(){
        Button openBtn = findViewById(R.id.openButton);
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog("THE DOOR IS OPEN !");
            }
        });
    }

    private void lockButtonListener(){
        final Button lockBtn = findViewById(R.id.lockButton);
        lockBtn.setText("LOCK");
        lockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lockBtn.getText().toString().equals("LOCK")) {
                    lockBtn.setText("UNLOCK");
                    createDialog("THE DOOR IS LOCKED !");
                }
                else if (lockBtn.getText().toString().equals("UNLOCK")) {
                    lockBtn.setText("LOCK");
                    createDialog("THE DOOR IS UNLOCKED !");
                }
            }
        });
    }

    private void addButtonListener(){
        Button addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog("PLEASE TOUCH RFID TAG !");
            }
        });
    }

    private void removeButtonListener(){
        Button removeBtn = findViewById(R.id.removeButton);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog("PLEASE TOUCH RFID TAG !");
            }
        });
    }
}
