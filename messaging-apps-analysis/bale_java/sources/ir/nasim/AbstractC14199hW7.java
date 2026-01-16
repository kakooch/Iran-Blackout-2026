package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* renamed from: ir.nasim.hW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14199hW7 {

    /* renamed from: ir.nasim.hW7$a */
    static class a {
        public static AutofillId a(View view) {
            return view.getAutofillId();
        }
    }

    /* renamed from: ir.nasim.hW7$b */
    private static class b {
        static ContentCaptureSession a(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* renamed from: ir.nasim.hW7$c */
    private static class c {
        static void a(View view, int i) {
            view.setImportantForContentCapture(i);
        }
    }

    public static C21330tU a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C21330tU.b(a.a(view));
        }
        return null;
    }

    public static C19666qk1 b(View view) {
        ContentCaptureSession contentCaptureSessionA;
        if (Build.VERSION.SDK_INT < 29 || (contentCaptureSessionA = b.a(view)) == null) {
            return null;
        }
        return C19666qk1.g(contentCaptureSessionA, view);
    }

    public static void c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(view, i);
        }
    }
}
