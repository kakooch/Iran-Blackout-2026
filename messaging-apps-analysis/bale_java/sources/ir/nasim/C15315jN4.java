package ir.nasim;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;

/* renamed from: ir.nasim.jN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15315jN4 {
    private final a a;

    /* renamed from: ir.nasim.jN4$a */
    interface a {
        void a(long j);

        void b(Surface surface);

        void c(long j);

        void d(String str);

        String e();

        void f();

        void g(int i);

        Surface getSurface();

        Object h();
    }

    public C15315jN4(int i, Surface surface) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.a = new C17679nN4(i, surface);
            return;
        }
        if (i2 >= 28) {
            this.a = new C17088mN4(i, surface);
        } else if (i2 >= 26) {
            this.a = new C16497lN4(i, surface);
        } else {
            this.a = new C15906kN4(i, surface);
        }
    }

    public static C15315jN4 j(Object obj) {
        if (obj == null) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        a aVarM = i >= 33 ? C17679nN4.m((OutputConfiguration) obj) : i >= 28 ? C17088mN4.l((OutputConfiguration) obj) : i >= 26 ? C16497lN4.k((OutputConfiguration) obj) : C15906kN4.j((OutputConfiguration) obj);
        if (aVarM == null) {
            return null;
        }
        return new C15315jN4(aVarM);
    }

    public void a(Surface surface) {
        this.a.b(surface);
    }

    public void b() {
        this.a.f();
    }

    public String c() {
        return this.a.e();
    }

    public Surface d() {
        return this.a.getSurface();
    }

    public void e(long j) {
        this.a.c(j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C15315jN4) {
            return this.a.equals(((C15315jN4) obj).a);
        }
        return false;
    }

    public void f(int i) {
        this.a.g(i);
    }

    public void g(String str) {
        this.a.d(str);
    }

    public void h(long j) {
        this.a.a(j);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object i() {
        return this.a.h();
    }

    public C15315jN4(OutputConfiguration outputConfiguration) {
        this.a = C17679nN4.m(outputConfiguration);
    }

    private C15315jN4(a aVar) {
        this.a = aVar;
    }
}
