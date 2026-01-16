package ir.nasim;

import android.os.Parcel;
import android.util.Base64;
import ir.nasim.C13193fo7;
import ir.nasim.C14377ho7;
import ir.nasim.C24381yX0;
import ir.nasim.C3418Au2;
import ir.nasim.C3657Bu2;
import org.xbill.DNS.Flags;

/* loaded from: classes.dex */
public final class R72 {
    private Parcel a = Parcel.obtain();

    public final void a(byte b) {
        this.a.writeByte(b);
    }

    public final void b(float f) {
        this.a.writeFloat(f);
    }

    public final void c(int i) {
        this.a.writeInt(i);
    }

    public final void d(C4593Fu2 c4593Fu2) {
        c(c4593Fu2.t());
    }

    public final void e(C5566Jw6 c5566Jw6) {
        m(c5566Jw6.c());
        b(Float.intBitsToFloat((int) (c5566Jw6.d() >> 32)));
        b(Float.intBitsToFloat((int) (c5566Jw6.d() & 4294967295L)));
        b(c5566Jw6.b());
    }

    public final void f(C12863fI6 c12863fI6) {
        long jG = c12863fI6.g();
        C24381yX0.a aVar = C24381yX0.b;
        if (!C24381yX0.q(jG, aVar.i())) {
            a((byte) 1);
            m(c12863fI6.g());
        }
        long jK = c12863fI6.k();
        C13193fo7.a aVar2 = C13193fo7.b;
        if (!C13193fo7.e(jK, aVar2.a())) {
            a((byte) 2);
            j(c12863fI6.k());
        }
        C4593Fu2 c4593Fu2N = c12863fI6.n();
        if (c4593Fu2N != null) {
            a((byte) 3);
            d(c4593Fu2N);
        }
        C3418Au2 c3418Au2L = c12863fI6.l();
        if (c3418Au2L != null) {
            int i = c3418Au2L.i();
            a((byte) 4);
            o(i);
        }
        C3657Bu2 c3657Bu2M = c12863fI6.m();
        if (c3657Bu2M != null) {
            int iM = c3657Bu2M.m();
            a((byte) 5);
            l(iM);
        }
        String strJ = c12863fI6.j();
        if (strJ != null) {
            a((byte) 6);
            i(strJ);
        }
        if (!C13193fo7.e(c12863fI6.o(), aVar2.a())) {
            a((byte) 7);
            j(c12863fI6.o());
        }
        C18413od0 c18413od0E = c12863fI6.e();
        if (c18413od0E != null) {
            float fH = c18413od0E.h();
            a((byte) 8);
            k(fH);
        }
        C3590Bm7 c3590Bm7U = c12863fI6.u();
        if (c3590Bm7U != null) {
            a((byte) 9);
            h(c3590Bm7U);
        }
        if (!C24381yX0.q(c12863fI6.d(), aVar.i())) {
            a((byte) 10);
            m(c12863fI6.d());
        }
        C24525yl7 c24525yl7S = c12863fI6.s();
        if (c24525yl7S != null) {
            a(Flags.CD);
            g(c24525yl7S);
        }
        C5566Jw6 c5566Jw6R = c12863fI6.r();
        if (c5566Jw6R != null) {
            a((byte) 12);
            e(c5566Jw6R);
        }
    }

    public final void g(C24525yl7 c24525yl7) {
        c(c24525yl7.e());
    }

    public final void h(C3590Bm7 c3590Bm7) {
        b(c3590Bm7.b());
        b(c3590Bm7.c());
    }

    public final void i(String str) {
        this.a.writeString(str);
    }

    public final void j(long j) {
        long jG = C13193fo7.g(j);
        C14377ho7.a aVar = C14377ho7.b;
        byte b = 0;
        if (!C14377ho7.g(jG, aVar.c())) {
            if (C14377ho7.g(jG, aVar.b())) {
                b = 1;
            } else if (C14377ho7.g(jG, aVar.a())) {
                b = 2;
            }
        }
        a(b);
        if (C14377ho7.g(C13193fo7.g(j), aVar.c())) {
            return;
        }
        b(C13193fo7.h(j));
    }

    public final void k(float f) {
        b(f);
    }

    public final void l(int i) {
        C3657Bu2.a aVar = C3657Bu2.b;
        byte b = 0;
        if (!C3657Bu2.h(i, aVar.b())) {
            if (C3657Bu2.h(i, aVar.a())) {
                b = 1;
            } else if (C3657Bu2.h(i, aVar.d())) {
                b = 2;
            } else if (C3657Bu2.h(i, aVar.c())) {
                b = 3;
            }
        }
        a(b);
    }

    public final void m(long j) {
        n(j);
    }

    public final void n(long j) {
        this.a.writeLong(j);
    }

    public final void o(int i) {
        C3418Au2.a aVar = C3418Au2.b;
        byte b = 0;
        if (!C3418Au2.f(i, aVar.b()) && C3418Au2.f(i, aVar.a())) {
            b = 1;
        }
        a(b);
    }

    public final String p() {
        return Base64.encodeToString(this.a.marshall(), 0);
    }

    public final void q() {
        this.a.recycle();
        this.a = Parcel.obtain();
    }
}
