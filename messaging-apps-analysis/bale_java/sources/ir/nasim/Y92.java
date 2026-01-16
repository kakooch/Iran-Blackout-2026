package ir.nasim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class Y92 extends DialogFragment {
    private Dialog a;
    private DialogInterface.OnCancelListener b;
    private Dialog c;

    public static Y92 a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Y92 y92 = new Y92();
        Dialog dialog2 = (Dialog) AbstractC3795Cj5.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        y92.a = dialog2;
        if (onCancelListener != null) {
            y92.b = onCancelListener;
        }
        return y92;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.c == null) {
            this.c = new AlertDialog.Builder((Context) AbstractC3795Cj5.j(getActivity())).create();
        }
        return this.c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
