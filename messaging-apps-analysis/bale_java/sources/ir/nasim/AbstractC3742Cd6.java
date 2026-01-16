package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Cd6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3742Cd6 {
    private static final Resources a;
    private static final int b;
    private static final int c;
    private static final float d;
    private static final float e;

    static {
        Resources system = Resources.getSystem();
        a = system;
        b = system.getDisplayMetrics().widthPixels;
        c = system.getDisplayMetrics().heightPixels;
        d = system.getDisplayMetrics().density;
        e = system.getDisplayMetrics().scaledDensity;
    }

    public static final void a(Window window, int i) {
        AbstractC13042fc3.i(window, "<this>");
        window.setNavigationBarColor(i);
    }

    public static /* synthetic */ void b(Window window, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = RecyclerView.UNDEFINED_DURATION;
        }
        a(window, i);
    }

    public static final float c() {
        return d;
    }

    public static final int d() {
        return b;
    }

    public static final void e(Window window, Context context) {
        AbstractC13042fc3.i(window, "<this>");
        AbstractC13042fc3.i(context, "context");
        window.setNavigationBarColor(AbstractC4043Dl1.c(context, IA5.n10));
    }
}
