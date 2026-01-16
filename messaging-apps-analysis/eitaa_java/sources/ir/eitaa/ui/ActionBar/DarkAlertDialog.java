package ir.eitaa.ui.ActionBar;

import android.content.Context;
import ir.eitaa.ui.ActionBar.AlertDialog;

/* loaded from: classes3.dex */
public class DarkAlertDialog extends AlertDialog {
    public DarkAlertDialog(Context context, int progressStyle) {
        super(context, progressStyle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    @Override // ir.eitaa.ui.ActionBar.AlertDialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int getThemedColor(java.lang.String r3) {
        /*
            r2 = this;
            r3.hashCode()
            int r0 = r3.hashCode()
            r1 = -1
            switch(r0) {
                case -1849805674: goto L2e;
                case -451706526: goto L23;
                case -93324646: goto L18;
                case 1828201066: goto Ld;
                default: goto Lb;
            }
        Lb:
            r0 = -1
            goto L38
        Ld:
            java.lang.String r0 = "dialogTextBlack"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L16
            goto Lb
        L16:
            r0 = 3
            goto L38
        L18:
            java.lang.String r0 = "dialogButton"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L21
            goto Lb
        L21:
            r0 = 2
            goto L38
        L23:
            java.lang.String r0 = "dialogScrollGlow"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L2c
            goto Lb
        L2c:
            r0 = 1
            goto L38
        L2e:
            java.lang.String r0 = "dialogBackground"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L37
            goto Lb
        L37:
            r0 = 0
        L38:
            switch(r0) {
                case 0: goto L41;
                case 1: goto L40;
                case 2: goto L40;
                case 3: goto L40;
                default: goto L3b;
            }
        L3b:
            int r3 = super.getThemedColor(r3)
            return r3
        L40:
            return r1
        L41:
            r3 = -14277082(0xffffffffff262626, float:-2.2084993E38)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.DarkAlertDialog.getThemedColor(java.lang.String):int");
    }

    public static class Builder extends AlertDialog.Builder {
        public Builder(Context context) {
            super(new DarkAlertDialog(context, 0));
        }
    }
}
