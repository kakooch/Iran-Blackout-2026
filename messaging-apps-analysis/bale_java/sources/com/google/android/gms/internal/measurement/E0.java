package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC20933sq8;
import ir.nasim.Qr8;
import ir.nasim.Uq8;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class E0 extends AbstractC20933sq8 {
    private static final Logger b = Logger.getLogger(E0.class.getName());
    private static final boolean c = z1.C();
    F0 a;

    /* synthetic */ E0(Uq8 uq8) {
    }

    static int A(Qr8 qr8, o1 o1Var) {
        int iA = ((AbstractC2137o0) qr8).a(o1Var);
        return a(iA) + iA;
    }

    public static int B(String str) {
        int length;
        try {
            length = E1.c(str);
        } catch (D1 unused) {
            length = str.getBytes(R0.b).length;
        }
        return a(length) + length;
    }

    public static int C(int i) {
        return a(i << 3);
    }

    public static int a(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int b(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static E0 c(byte[] bArr) {
        return new D0(bArr, 0, bArr.length);
    }

    public static int x(A0 a0) {
        int iR = a0.r();
        return a(iR) + iR;
    }

    static int y(int i, Qr8 qr8, o1 o1Var) {
        int iA = a(i << 3);
        return iA + iA + ((AbstractC2137o0) qr8).a(o1Var);
    }

    public static int z(int i) {
        if (i >= 0) {
            return a(i);
        }
        return 10;
    }

    public final void d() {
        if (g() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void e(String str, D1 d1) throws zzjk {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) d1);
        byte[] bytes = str.getBytes(R0.b);
        try {
            int length = bytes.length;
            u(length);
            q(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzjk(e);
        }
    }

    public abstract int g();

    public abstract void h(byte b2);

    public abstract void i(int i, boolean z);

    public abstract void j(int i, A0 a0);

    public abstract void k(int i, int i2);

    public abstract void l(int i);

    public abstract void m(int i, long j);

    public abstract void n(long j);

    public abstract void o(int i, int i2);

    public abstract void p(int i);

    public abstract void q(byte[] bArr, int i, int i2);

    public abstract void r(int i, String str);

    public abstract void s(int i, int i2);

    public abstract void t(int i, int i2);

    public abstract void u(int i);

    public abstract void v(int i, long j);

    public abstract void w(long j);
}
