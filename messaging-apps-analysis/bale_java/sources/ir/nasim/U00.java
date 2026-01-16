package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.widget.Toast;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public final class U00 {
    private static WeakReference e;
    public static final U00 a = new U00();
    private static final Runnable b = new Runnable() { // from class: ir.nasim.T00
        @Override // java.lang.Runnable
        public final void run() {
            U00.b();
        }
    };
    private static final long c = 300;
    private static String d = "";
    public static final int f = 8;

    private U00() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        WeakReference weakReference;
        Context context;
        if (d.length() == 0 || (weakReference = e) == null || (context = (Context) weakReference.get()) == null) {
            return;
        }
        Toast.makeText(context, d, 0).show();
    }

    private final void c(Context context, String str) {
        e = new WeakReference(context);
        if (AbstractC13042fc3.d(d, str)) {
            return;
        }
        Runnable runnable = b;
        AbstractC21455b.t(runnable);
        runnable.run();
        if (str == null) {
            str = "";
        }
        d = str;
        AbstractC21455b.n1(runnable, c);
    }

    public static final void d(Context context, String str) {
        a.c(context, str);
    }

    public static final void e(Context context) {
        a.c(context, "The feature will enabled later!");
    }

    public static final void f(Context context, String str) {
        AbstractC13042fc3.i(str, "featureName");
        a.c(context, "The feature will enabled later! <" + str + Separators.GREATER_THAN);
    }
}
