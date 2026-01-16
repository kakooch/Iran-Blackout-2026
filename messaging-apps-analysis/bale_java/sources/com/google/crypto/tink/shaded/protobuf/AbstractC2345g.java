package com.google.crypto.tink.shaded.protobuf;

import ir.nasim.AbstractC6189Mo0;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2345g implements Iterable, Serializable {
    public static final AbstractC2345g b = new j(AbstractC2360w.d);
    private static final f c;
    private static final Comparator d;
    private int a = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$a */
    class a extends c {
        private int a = 0;
        private final int b;

        a() {
            this.b = AbstractC2345g.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.InterfaceC0197g
        public byte j() {
            int i = this.a;
            if (i >= this.b) {
                throw new NoSuchElementException();
            }
            this.a = i + 1;
            return AbstractC2345g.this.L(i);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$b */
    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC2345g abstractC2345g, AbstractC2345g abstractC2345g2) {
            InterfaceC0197g interfaceC0197gO = abstractC2345g.O();
            InterfaceC0197g interfaceC0197gO2 = abstractC2345g2.O();
            while (interfaceC0197gO.hasNext() && interfaceC0197gO2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC2345g.Y(interfaceC0197gO.j())).compareTo(Integer.valueOf(AbstractC2345g.Y(interfaceC0197gO2.j())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC2345g.size()).compareTo(Integer.valueOf(abstractC2345g2.size()));
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$c */
    static abstract class c implements InterfaceC0197g {
        c() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(j());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$d */
    private static final class d implements f {
        private d() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.f
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$e */
    private static final class e extends j {
        private final int f;
        private final int g;

        e(byte[] bArr, int i, int i2) {
            super(bArr);
            AbstractC2345g.w(i, i + i2, bArr.length);
            this.f = i;
            this.g = i2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.j, com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        protected void F(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.e, i0() + i, bArr, i2, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.j, com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        byte L(int i) {
            return this.e[this.f + i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.j
        protected int i0() {
            return this.f;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.j, com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public byte j(int i) {
            AbstractC2345g.r(i, size());
            return this.e[this.f + i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.j, com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public int size() {
            return this.g;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$f */
    private interface f {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$g, reason: collision with other inner class name */
    public interface InterfaceC0197g extends Iterator {
        byte j();
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$h */
    static final class h {
        private final CodedOutputStream a;
        private final byte[] b;

        /* synthetic */ h(int i, a aVar) {
            this(i);
        }

        public AbstractC2345g a() {
            this.a.c();
            return new j(this.b);
        }

        public CodedOutputStream b() {
            return this.a;
        }

        private h(int i) {
            byte[] bArr = new byte[i];
            this.b = bArr;
            this.a = CodedOutputStream.U(bArr);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$i */
    static abstract class i extends AbstractC2345g {
        i() {
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.O();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$j */
    private static class j extends i {
        protected final byte[] e;

        j(byte[] bArr) {
            bArr.getClass();
            this.e = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        protected void F(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.e, i, bArr, i2, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        byte L(int i) {
            return this.e[i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public final boolean N() {
            int iI0 = i0();
            return e0.n(this.e, iI0, size() + iI0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public final AbstractC2346h Q() {
            return AbstractC2346h.j(this.e, i0(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        protected final int R(int i, int i2, int i3) {
            return AbstractC2360w.h(i, this.e, i0() + i2, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public final AbstractC2345g V(int i, int i2) {
            int iW = AbstractC2345g.w(i, i2, size());
            return iW == 0 ? AbstractC2345g.b : new e(this.e, i0() + i, iW);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        protected final String a0(Charset charset) {
            return new String(this.e, i0(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC2345g) || size() != ((AbstractC2345g) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iS = S();
            int iS2 = jVar.S();
            if (iS == 0 || iS2 == 0 || iS == iS2) {
                return h0(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        final void g0(AbstractC6189Mo0 abstractC6189Mo0) {
            abstractC6189Mo0.a(this.e, i0(), size());
        }

        final boolean h0(AbstractC2345g abstractC2345g, int i, int i2) {
            if (i2 > abstractC2345g.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 > abstractC2345g.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + abstractC2345g.size());
            }
            if (!(abstractC2345g instanceof j)) {
                return abstractC2345g.V(i, i3).equals(V(0, i2));
            }
            j jVar = (j) abstractC2345g;
            byte[] bArr = this.e;
            byte[] bArr2 = jVar.e;
            int iI0 = i0() + i2;
            int iI02 = i0();
            int iI03 = jVar.i0() + i;
            while (iI02 < iI0) {
                if (bArr[iI02] != bArr2[iI03]) {
                    return false;
                }
                iI02++;
                iI03++;
            }
            return true;
        }

        protected int i0() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public byte j(int i) {
            return this.e[i];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g
        public int size() {
            return this.e.length;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.g$k */
    private static final class k implements f {
        private k() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2345g.f
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        c = AbstractC2342d.c() ? new k(aVar) : new d(aVar);
        d = new b();
    }

    AbstractC2345g() {
    }

    public static AbstractC2345g C(byte[] bArr) {
        return D(bArr, 0, bArr.length);
    }

    public static AbstractC2345g D(byte[] bArr, int i2, int i3) {
        w(i2, i2 + i3, bArr.length);
        return new j(c.a(bArr, i2, i3));
    }

    public static AbstractC2345g E(String str) {
        return new j(str.getBytes(AbstractC2360w.b));
    }

    static h P(int i2) {
        return new h(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int Y(byte b2) {
        return b2 & 255;
    }

    private String c0() {
        if (size() <= 50) {
            return Z.a(this);
        }
        return Z.a(V(0, 47)) + "...";
    }

    static AbstractC2345g d0(byte[] bArr) {
        return new j(bArr);
    }

    static AbstractC2345g f0(byte[] bArr, int i2, int i3) {
        return new e(bArr, i2, i3);
    }

    static void r(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    static int w(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        }
        throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
    }

    protected abstract void F(byte[] bArr, int i2, int i3, int i4);

    abstract byte L(int i2);

    public abstract boolean N();

    public InterfaceC0197g O() {
        return new a();
    }

    public abstract AbstractC2346h Q();

    protected abstract int R(int i2, int i3, int i4);

    protected final int S() {
        return this.a;
    }

    public abstract AbstractC2345g V(int i2, int i3);

    public final byte[] W() {
        int size = size();
        if (size == 0) {
            return AbstractC2360w.d;
        }
        byte[] bArr = new byte[size];
        F(bArr, 0, 0, size);
        return bArr;
    }

    public final String Z(Charset charset) {
        return size() == 0 ? "" : a0(charset);
    }

    protected abstract String a0(Charset charset);

    public final String b0() {
        return Z(AbstractC2360w.b);
    }

    public abstract boolean equals(Object obj);

    abstract void g0(AbstractC6189Mo0 abstractC6189Mo0);

    public final int hashCode() {
        int iR = this.a;
        if (iR == 0) {
            int size = size();
            iR = R(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.a = iR;
        }
        return iR;
    }

    public abstract byte j(int i2);

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), c0());
    }
}
