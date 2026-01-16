package ir.nasim;

import android.app.Dialog;
import android.os.Bundle;

/* loaded from: classes.dex */
public class ZD extends androidx.fragment.app.l {
    @Override // androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        return new YD(G5(), A8());
    }

    @Override // androidx.fragment.app.l
    public void J8(Dialog dialog, int i) {
        if (!(dialog instanceof YD)) {
            super.J8(dialog, i);
            return;
        }
        YD yd = (YD) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        yd.h(1);
    }
}
