package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC25160zp8;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class K implements Serializable, Iterable {
    public static final K b = new U(AbstractC2184m0.c);
    private static final P c;
    private static final Comparator d;
    private int a = 0;

    static {
        J j = null;
        c = E.b() ? new T(j) : new O(j);
        d = new M();
    }

    K() {
    }

    public static K D(String str) {
        return new U(str.getBytes(AbstractC2184m0.a));
    }

    public static K E(byte[] bArr, int i, int i2) {
        P(i, i + i2, bArr.length);
        return new U(c.a(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int O(byte b2) {
        return b2 & 255;
    }

    static int P(int i, int i2, int i3) {
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

    static S R(int i) {
        return new S(i, null);
    }

    public abstract K C(int i, int i2);

    protected abstract String F(Charset charset);

    abstract void L(AbstractC25160zp8 abstractC25160zp8);

    abstract byte N(int i);

    public final String Q() {
        return j() == 0 ? "" : F(AbstractC2184m0.a);
    }

    protected final int S() {
        return this.a;
    }

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    public abstract byte f(int i);

    public final int hashCode() {
        int iW = this.a;
        if (iW == 0) {
            int iJ = j();
            iW = w(iJ, 0, iJ);
            if (iW == 0) {
                iW = 1;
            }
            this.a = iW;
        }
        return iW;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return new J(this);
    }

    public abstract int j();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(j()), j() <= 50 ? c1.a(this) : String.valueOf(c1.a(C(0, 47))).concat("..."));
    }

    protected abstract int w(int i, int i2, int i3);
}
