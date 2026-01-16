package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class LoadingDialog extends Dialog {
    private void init() {
    }

    public LoadingDialog(Context context) {
        super(context, R.style.DialogLoading);
        if (ApplicationLoader.applicationActivity != null) {
            try {
                show();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.loading_dialog);
        getWindow().setLayout(-2, -2);
        setCancelable(false);
        findViews();
        init();
    }

    private void findViews() {
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.progressBarFrame);
        if (ApplicationLoader.applicationActivity != null) {
            UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, frameLayout);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.dialog.LoadingDialog.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LoadingDialog.this.setCancelable(true);
                    frameLayout.setVisibility(0);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (ApplicationLoader.applicationActivity != null) {
                super.dismiss();
            }
        } catch (Exception unused) {
        }
    }
}
