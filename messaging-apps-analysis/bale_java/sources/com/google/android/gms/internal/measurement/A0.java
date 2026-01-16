package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC20933sq8;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class A0 implements Iterable, Serializable {
    public static final A0 b = new C2156y0(R0.d);
    private static final Comparator c;
    private static final C2158z0 d;
    private int a = 0;

    static {
        int i = AbstractC2141q0.a;
        d = new C2158z0(null);
        c = new C2148u0();
    }

    A0() {
    }

    static int L(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static A0 O(byte[] bArr, int i, int i2) {
        L(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C2156y0(bArr2);
    }

    public static A0 P(String str) {
        return new C2156y0(str.getBytes(R0.b));
    }

    public abstract A0 C(int i, int i2);

    protected abstract String D(Charset charset);

    abstract void E(AbstractC20933sq8 abstractC20933sq8);

    public abstract boolean F();

    protected final int N() {
        return this.a;
    }

    public final String Q(Charset charset) {
        return r() == 0 ? "" : D(charset);
    }

    public abstract boolean equals(Object obj);

    public abstract byte f(int i);

    public final int hashCode() {
        int iW = this.a;
        if (iW == 0) {
            int iR = r();
            iW = w(iR, 0, iR);
            if (iW == 0) {
                iW = 1;
            }
            this.a = iW;
        }
        return iW;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new C2146t0(this);
    }

    abstract byte j(int i);

    public abstract int r();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(r()), r() <= 50 ? r1.a(this) : r1.a(C(0, 47)).concat("..."));
    }

    protected abstract int w(int i, int i2, int i3);
}
