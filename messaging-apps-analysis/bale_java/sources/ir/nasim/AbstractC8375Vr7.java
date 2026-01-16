package ir.nasim;

import android.os.Build;
import android.view.View;

/* renamed from: ir.nasim.Vr7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8375Vr7 {

    /* renamed from: ir.nasim.Vr7$a */
    static class a {
        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            ViewOnLongClickListenerC9150Yr7.h(view, charSequence);
        }
    }
}
