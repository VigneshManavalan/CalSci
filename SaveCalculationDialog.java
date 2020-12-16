package com.dev.calsci;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class SaveCalculationDialog extends AppCompatDialogFragment {
    private EditText etTitle;
    private SaveCalculationDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SaveCalculationDialogListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.save_calculation_dialog,null);
        builder.setView(view)
                .setTitle("SAVE CALCULATION")
                .setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = etTitle.getText().toString();
                listener.saveCalculation(title);
            }
        });
        etTitle = view.findViewById(R.id.etSavingPurpose);
        return builder.create();
    }
    public interface SaveCalculationDialogListener{
        void saveCalculation(String title);
    }
}
