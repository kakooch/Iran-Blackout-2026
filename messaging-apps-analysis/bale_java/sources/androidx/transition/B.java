package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import ir.nasim.AbstractC12990fW7;

/* loaded from: classes2.dex */
abstract class B {
    private static final H a;
    static final Property b;
    static final Property c;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(B.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            B.h(view, f.floatValue());
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return AbstractC12990fW7.t(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            AbstractC12990fW7.w0(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new G();
        } else {
            a = new F();
        }
        b = new a(Float.class, "translationAlpha");
        c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        a.a(view);
    }

    static A b(View view) {
        return new z(view);
    }

    static float c(View view) {
        return a.b(view);
    }

    static J d(View view) {
        return new I(view);
    }

    static void e(View view) {
        a.c(view);
    }

    static void f(View view, Matrix matrix) {
        a.d(view, matrix);
    }

    static void g(View view, int i, int i2, int i3, int i4) {
        a.e(view, i, i2, i3, i4);
    }

    static void h(View view, float f) {
        a.f(view, f);
    }

    static void i(View view, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        a.g(view, i);
    }

    static void j(View view, Matrix matrix) {
        a.h(view, matrix);
    }

    static void k(View view, Matrix matrix) {
        a.i(view, matrix);
    }
}
