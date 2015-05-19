package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ggarcia on 17/05/15.
 */
public class ExampleDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        Button btn = (Button) findViewById(R.id.btnDialog);
        Button btn2 = (Button) findViewById(R.id.btnDialogCustomView);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //alert dialog with yes and no options
                AlertDialog.Builder yesNoDialog = new AlertDialog.Builder(ExampleDialog.this);

                yesNoDialog.setIcon(R.drawable.info_square_blue_48x48);
                yesNoDialog.setTitle(R.string.title_yes_no_dialog);
                yesNoDialog.setMessage(R.string.txt_yes_no_dialog);

                //if chosen yes, execute this event
                yesNoDialog.setPositiveButton(R.string.lbl_yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ExampleDialog.this, R.string.lbl_yes, Toast.LENGTH_SHORT).show();
                    }

                });

                //if chosen no, execute this event
                yesNoDialog.setNegativeButton(R.string.lbl_no, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ExampleDialog.this, R.string.lbl_no, Toast.LENGTH_SHORT).show();
                    }

                });

                //dont forget to show the dialog
                yesNoDialog.show();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //inflate the XML (if you using API 21 or higher, you can use dialog.setView(R.layout.[layoutId]) too
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_with_custom_view, null);

                //alert dialog with custom view
                AlertDialog.Builder dialog = new AlertDialog.Builder(ExampleDialog.this);

                dialog.setIcon(R.drawable.info_square_green_48x48);
                dialog.setTitle(R.string.title_dialog_custom_view);
                dialog.setView(view);
                dialog.setCancelable(true);

                dialog.setNegativeButton(R.string.lbl_close, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });

                //get the button from dialog_with_custom_view.xml view
                Button btn3 = (Button) view.findViewById(R.id.btnDoSomethink);

                btn3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ExampleDialog.this, R.string.txt_anythink, Toast.LENGTH_SHORT).show();
                    }

                });

                dialog.show();

            }

        });


    }
}
