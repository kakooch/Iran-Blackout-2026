package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.e;
import ir.nasim.C15116j22;

/* loaded from: classes.dex */
public abstract class w {
    public static final Range a = new Range(0, 0);

    public static abstract class a {
        a() {
        }

        public abstract w a();

        public abstract a b(C15116j22 c15116j22);

        public abstract a c(Range range);

        public abstract a d(j jVar);

        public abstract a e(Size size);

        public abstract a f(boolean z);
    }

    public static a a(Size size) {
        return new e.b().e(size).c(a).b(C15116j22.d).f(false);
    }

    public abstract C15116j22 b();

    public abstract Range c();

    public abstract j d();

    public abstract Size e();

    public abstract boolean f();

    public abstract a g();
}
