package com.example.calculadora;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class alerta extends DialogFragment {
@Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

    AlertDialog.Builder builder =
            new AlertDialog.Builder(getActivity());

    builder.setMessage("Por favor llenar ambos campos")
            .setTitle("Advertencia")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

    return builder.create();
}
}
