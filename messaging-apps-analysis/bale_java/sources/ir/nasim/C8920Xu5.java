package ir.nasim;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.Xu5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8920Xu5 {
    private static ProgressDialog b;
    public static final C8920Xu5 a = new C8920Xu5();
    public static final int c = 8;

    private C8920Xu5() {
    }

    public static final boolean c() {
        ProgressDialog progressDialog = b;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return false;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.Vu5
            @Override // java.lang.Runnable
            public final void run() {
                C8920Xu5.d();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        ProgressDialog progressDialog = b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        b = null;
    }

    public static final ProgressDialog e(Context context, boolean z) {
        AbstractC13042fc3.i(context, "context");
        c();
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(z);
        progressDialog.setCancelable(z);
        progressDialog.setMessage(context.getString(UD5.progress_common));
        b = progressDialog;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.Wu5
            @Override // java.lang.Runnable
            public final void run() {
                C8920Xu5.f();
            }
        });
        ProgressDialog progressDialog2 = b;
        AbstractC13042fc3.f(progressDialog2);
        return progressDialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        ProgressDialog progressDialog = b;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }
}
