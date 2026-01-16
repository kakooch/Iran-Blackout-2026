package ir.eitaa.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import org.acra.dialog.BaseCrashReportDialog;

/* loaded from: classes.dex */
public class CrashReportDialog extends BaseCrashReportDialog {
    @Override // org.acra.dialog.BaseCrashReportDialog
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher).setPositiveButton(LocaleController.formatString("Done", R.string.Done, new Object[0]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.CrashReportDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CrashReportDialog.this.finish();
            }
        }).setCancelable(false).setMessage(LocaleController.formatString("CrashReportMessage", R.string.CrashReportMessage, new Object[0]));
        builder.create().show();
        sendCrash("", "");
    }
}
