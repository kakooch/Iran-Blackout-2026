package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* renamed from: ir.nasim.q98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19329q98 {

    /* renamed from: ir.nasim.q98$a */
    static class a {
        static void a(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* renamed from: ir.nasim.q98$b */
    static class b {
        static void a(Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    public static C18391oa8 a(Window window, View view) {
        return new C18391oa8(window, view);
    }

    public static void b(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.a(window, z);
        } else {
            a.a(window, z);
        }
    }
}
