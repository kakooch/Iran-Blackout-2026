package com.google.protobuf;

import ir.nasim.AbstractC6428No0;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* renamed from: com.google.protobuf.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2383g implements Iterable, Serializable {
    public static final AbstractC2383g b = new j(B.d);
    private static final f c;
    private static final Comparator d;
    private int a = 0;

    /* renamed from: com.google.protobuf.g$a */
    class a extends c {
        private int a = 0;
        private final int b;

        a() {
            this.b = AbstractC2383g.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // com.google.protobuf.AbstractC2383g.InterfaceC0206g
        public byte j() {
            int i = this.a;
            if (i >= this.b) {
                throw new NoSuchElementException();
            }
            this.a = i + 1;
            return AbstractC2383g.this.P(i);
        }
    }

    /* renamed from: com.google.protobuf.g$b */
    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC2383g abstractC2383g, AbstractC2383g abstractC2383g2) {
            InterfaceC0206g it = abstractC2383g.iterator();
            InterfaceC0206g it2 = abstractC2383g2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC2383g.b0(it.j())).compareTo(Integer.valueOf(AbstractC2383g.b0(it2.j())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC2383g.size()).compareTo(Integer.valueOf(abstractC2383g2.size()));
        }
    }

    /* renamed from: com.google.protobuf.g$c */
    static abstract class c implements InterfaceC0206g {
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

    /* renamed from: com.google.protobuf.g$d */
    private static final class d implements f {
        private d() {
        }

        @Override // com.google.protobuf.AbstractC2383g.f
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.g$e */
    private static final class e extends j {
        private final int f;
        private final int g;

        e(byte[] bArr, int i, int i2) {
            super(bArr);
            AbstractC2383g.C(i, i + i2, bArr.length);
            this.f = i;
            this.g = i2;
        }

        @Override // com.google.protobuf.AbstractC2383g.j, com.google.protobuf.AbstractC2383g
        protected void O(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.e, n0() + i, bArr, i2, i3);
        }

        @Override // com.google.protobuf.AbstractC2383g.j, com.google.protobuf.AbstractC2383g
        byte P(int i) {
            return this.e[this.f + i];
        }

        @Override // com.google.protobuf.AbstractC2383g.j
        protected int n0() {
            return this.f;
        }

        @Override // com.google.protobuf.AbstractC2383g.j, com.google.protobuf.AbstractC2383g
        public byte r(int i) {
            AbstractC2383g.w(i, size());
            return this.e[this.f + i];
        }

        @Override // com.google.protobuf.AbstractC2383g.j, com.google.protobuf.AbstractC2383g
        public int size() {
            return this.g;
        }
    }

    /* renamed from: com.google.protobuf.g$f */
    private interface f {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.google.protobuf.g$g, reason: collision with other inner class name */
    public interface InterfaceC0206g extends Iterator {
        byte j();
    }

    /* renamed from: com.google.protobuf.g$h */
    static final class h {
        private final CodedOutputStream a;
        private final byte[] b;

        /* synthetic */ h(int i, a aVar) {
            this(i);
        }

        public AbstractC2383g a() {
            this.a.d();
            return new j(this.b);
        }

        public CodedOutputStream b() {
            return this.a;
        }

        private h(int i) {
            byte[] bArr = new byte[i];
            this.b = bArr;
            this.a = CodedOutputStream.d0(bArr);
        }
    }

    /* renamed from: com.google.protobuf.g$i */
    static abstract class i extends AbstractC2383g {
        i() {
        }
    }

    /* renamed from: com.google.protobuf.g$j */
    private static class j extends i {
        protected final byte[] e;

        j(byte[] bArr) {
            bArr.getClass();
            this.e = bArr;
        }

        @Override // com.google.protobuf.AbstractC2383g
        protected void O(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.e, i, bArr, i2, i3);
        }

        @Override // com.google.protobuf.AbstractC2383g
        byte P(int i) {
            return this.e[i];
        }

        @Override // com.google.protobuf.AbstractC2383g
        public final boolean Q() {
            int iN0 = n0();
            return p0.t(this.e, iN0, size() + iN0);
        }

        @Override // com.google.protobuf.AbstractC2383g
        public final AbstractC2384h V() {
            return AbstractC2384h.n(this.e, n0(), size(), true);
        }

        @Override // com.google.protobuf.AbstractC2383g
        protected final int W(int i, int i2, int i3) {
            return B.i(i, this.e, n0() + i2, i3);
        }

        @Override // com.google.protobuf.AbstractC2383g
        public final AbstractC2383g Z(int i, int i2) {
            int iC = AbstractC2383g.C(i, i2, size());
            return iC == 0 ? AbstractC2383g.b : new e(this.e, n0() + i, iC);
        }

        @Override // com.google.protobuf.AbstractC2383g
        protected final String d0(Charset charset) {
            return new String(this.e, n0(), size(), charset);
        }

        @Override // com.google.protobuf.AbstractC2383g
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC2383g) || size() != ((AbstractC2383g) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iY = Y();
            int iY2 = jVar.Y();
            if (iY == 0 || iY2 == 0 || iY == iY2) {
                return l0(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractC2383g
        public final ByteBuffer j() {
            return ByteBuffer.wrap(this.e, n0(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.AbstractC2383g
        final void k0(AbstractC6428No0 abstractC6428No0) {
            abstractC6428No0.b(this.e, n0(), size());
        }

        final boolean l0(AbstractC2383g abstractC2383g, int i, int i2) {
            if (i2 > abstractC2383g.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 > abstractC2383g.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + abstractC2383g.size());
            }
            if (!(abstractC2383g instanceof j)) {
                return abstractC2383g.Z(i, i3).equals(Z(0, i2));
            }
            j jVar = (j) abstractC2383g;
            byte[] bArr = this.e;
            byte[] bArr2 = jVar.e;
            int iN0 = n0() + i2;
            int iN02 = n0();
            int iN03 = jVar.n0() + i;
            while (iN02 < iN0) {
                if (bArr[iN02] != bArr2[iN03]) {
                    return false;
                }
                iN02++;
                iN03++;
            }
            return true;
        }

        protected int n0() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC2383g
        public byte r(int i) {
            return this.e[i];
        }

        @Override // com.google.protobuf.AbstractC2383g
        public int size() {
            return this.e.length;
        }
    }

    /* renamed from: com.google.protobuf.g$k */
    private static final class k implements f {
        private k() {
        }

        @Override // com.google.protobuf.AbstractC2383g.f
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
        c = AbstractC2380d.c() ? new k(aVar) : new d(aVar);
        d = new b();
    }

    AbstractC2383g() {
    }

    static int C(int i2, int i3, int i4) {
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

    public static AbstractC2383g D(ByteBuffer byteBuffer) {
        return E(byteBuffer, byteBuffer.remaining());
    }

    public static AbstractC2383g E(ByteBuffer byteBuffer, int i2) {
        C(0, i2, byteBuffer.remaining());
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new j(bArr);
    }

    public static AbstractC2383g F(byte[] bArr) {
        return L(bArr, 0, bArr.length);
    }

    public static AbstractC2383g L(byte[] bArr, int i2, int i3) {
        C(i2, i2 + i3, bArr.length);
        return new j(c.a(bArr, i2, i3));
    }

    public static AbstractC2383g N(String str) {
        return new j(str.getBytes(B.b));
    }

    static h S(int i2) {
        return new h(i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b0(byte b2) {
        return b2 & 255;
    }

    private String g0() {
        if (size() <= 50) {
            return k0.a(this);
        }
        return k0.a(Z(0, 47)) + "...";
    }

    static AbstractC2383g h0(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new X(byteBuffer);
        }
        return j0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static AbstractC2383g i0(byte[] bArr) {
        return new j(bArr);
    }

    static AbstractC2383g j0(byte[] bArr, int i2, int i3) {
        return new e(bArr, i2, i3);
    }

    static void w(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    protected abstract void O(byte[] bArr, int i2, int i3, int i4);

    abstract byte P(int i2);

    public abstract boolean Q();

    @Override // java.lang.Iterable
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public InterfaceC0206g iterator() {
        return new a();
    }

    public abstract AbstractC2384h V();

    protected abstract int W(int i2, int i3, int i4);

    protected final int Y() {
        return this.a;
    }

    public abstract AbstractC2383g Z(int i2, int i3);

    public final byte[] a0() {
        int size = size();
        if (size == 0) {
            return B.d;
        }
        byte[] bArr = new byte[size];
        O(bArr, 0, 0, size);
        return bArr;
    }

    public final String c0(Charset charset) {
        return size() == 0 ? "" : d0(charset);
    }

    protected abstract String d0(Charset charset);

    public abstract boolean equals(Object obj);

    public final String f0() {
        return c0(B.b);
    }

    public final int hashCode() {
        int iW = this.a;
        if (iW == 0) {
            int size = size();
            iW = W(size, 0, size);
            if (iW == 0) {
                iW = 1;
            }
            this.a = iW;
        }
        return iW;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract ByteBuffer j();

    abstract void k0(AbstractC6428No0 abstractC6428No0);

    public abstract byte r(int i2);

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), g0());
    }
}
