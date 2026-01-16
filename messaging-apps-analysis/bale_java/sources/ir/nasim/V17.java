package ir.nasim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes3.dex */
public class V17 extends androidx.fragment.app.l {
    private Dialog m1;
    private DialogInterface.OnCancelListener n1;
    private Dialog o1;

    public static V17 M8(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        V17 v17 = new V17();
        Dialog dialog2 = (Dialog) AbstractC3795Cj5.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        v17.m1 = dialog2;
        if (onCancelListener != null) {
            v17.n1 = onCancelListener;
        }
        return v17;
    }

    @Override // androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        Dialog dialog = this.m1;
        if (dialog != null) {
            return dialog;
        }
        H8(false);
        if (this.o1 == null) {
            this.o1 = new AlertDialog.Builder((Context) AbstractC3795Cj5.j(G5())).create();
        }
        return this.o1;
    }

    @Override // androidx.fragment.app.l
    public void K8(FragmentManager fragmentManager, String str) {
        super.K8(fragmentManager, str);
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.n1;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
