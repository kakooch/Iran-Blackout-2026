package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: ir.nasim.cV3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10961cV3 {
    static AbstractC11317co1 a(int i) {
        return i != 0 ? i != 1 ? b() : new C6271Mx1() : new O46();
    }

    static AbstractC11317co1 b() {
        return new O46();
    }

    static C11465d32 c() {
        return new C11465d32();
    }

    public static void d(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof C10345bV3) {
            ((C10345bV3) background).a0(f);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof C10345bV3) {
            f(view, (C10345bV3) background);
        }
    }

    public static void f(View view, C10345bV3 c10345bV3) {
        if (c10345bV3.S()) {
            c10345bV3.f0(AbstractC10402bY7.i(view));
        }
    }
}
