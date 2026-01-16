package ir.eitaa.ui;

import android.app.Activity;
import android.app.Dialog;
import ir.eitaa.messenger.FileLog;

/* loaded from: classes3.dex */
public class BlockAdsActivity extends Activity {
    boolean blockAds;
    String host = null;
    boolean showAlert;
    private Dialog visibleDialog;

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r18) throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.BlockAdsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.visibleDialog.dismiss();
            this.visibleDialog = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }
}
