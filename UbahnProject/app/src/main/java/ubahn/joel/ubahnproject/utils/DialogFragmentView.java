package ubahn.joel.ubahnproject.utils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog.Builder;
/**
 * Created by Usuario on 07/02/2017.
 */
public class DialogFragmentView extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Builder builder = new Builder(getActivity());

        builder.setMessage("Rellene los campos vacios")
                .setTitle("Aviso Importante")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    //ona

}