package com.google.android.gms.internal.clearcut;

import ir.nasim.Dj8;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.clearcut.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2081f implements Serializable, Iterable {
    public static final AbstractC2081f b = new C2089m(B.c);
    private static final InterfaceC2086j c;
    private int a = 0;

    static {
        C2083g c2083g = null;
        c = AbstractC2075c.b() ? new C2090n(c2083g) : new C2084h(c2083g);
    }

    AbstractC2081f() {
    }

    static int E(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public static AbstractC2081f F(byte[] bArr, int i, int i2) {
        return new C2089m(c.a(bArr, i, i2));
    }

    public static AbstractC2081f L(String str) {
        return new C2089m(str.getBytes(B.a));
    }

    static C2087k O(int i) {
        return new C2087k(i, null);
    }

    public abstract boolean C();

    protected final int D() {
        return this.a;
    }

    public abstract byte N(int i);

    public final String P() {
        return size() == 0 ? "" : r(B.a);
    }

    public abstract boolean equals(Object obj);

    protected abstract int f(int i, int i2, int i3);

    public final int hashCode() {
        int iF = this.a;
        if (iF == 0) {
            int size = size();
            iF = f(size, 0, size);
            if (iF == 0) {
                iF = 1;
            }
            this.a = iF;
        }
        return iF;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return new C2083g(this);
    }

    public abstract AbstractC2081f j(int i, int i2);

    protected abstract String r(Charset charset);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    abstract void w(Dj8 dj8);
}
