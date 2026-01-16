package androidx.datastore.preferences.protobuf;

import ir.nasim.AbstractC6688Oo0;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1937f implements Iterable, Serializable {
    public static final AbstractC1937f b = new i(AbstractC1952v.c);
    private static final InterfaceC0081f c;
    private static final Comparator d;
    private int a = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.f$a */
    class a extends c {
        private int a = 0;
        private final int b;

        a() {
            this.b = AbstractC1937f.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.g
        public byte j() {
            int i = this.a;
            if (i >= this.b) {
                throw new NoSuchElementException();
            }
            this.a = i + 1;
            return AbstractC1937f.this.F(i);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$b */
    static class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1937f abstractC1937f, AbstractC1937f abstractC1937f2) {
            g gVarN = abstractC1937f.N();
            g gVarN2 = abstractC1937f2.N();
            while (gVarN.hasNext() && gVarN2.hasNext()) {
                int iCompare = Integer.compare(AbstractC1937f.R(gVarN.j()), AbstractC1937f.R(gVarN2.j()));
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return Integer.compare(abstractC1937f.size(), abstractC1937f2.size());
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$c */
    static abstract class c implements g {
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

    /* renamed from: androidx.datastore.preferences.protobuf.f$d */
    private static final class d implements InterfaceC0081f {
        private d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.InterfaceC0081f
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$e */
    private static final class e extends i {
        private final int f;
        private final int g;

        e(byte[] bArr, int i, int i2) {
            super(bArr);
            AbstractC1937f.w(i, i + i2, bArr.length);
            this.f = i;
            this.g = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.i, androidx.datastore.preferences.protobuf.AbstractC1937f
        byte F(int i) {
            return this.e[this.f + i];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.i
        protected int c0() {
            return this.f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.i, androidx.datastore.preferences.protobuf.AbstractC1937f
        public byte j(int i) {
            AbstractC1937f.r(i, size());
            return this.e[this.f + i];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.i, androidx.datastore.preferences.protobuf.AbstractC1937f
        public int size() {
            return this.g;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    private interface InterfaceC0081f {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$g */
    public interface g extends Iterator {
        byte j();
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$h */
    static abstract class h extends AbstractC1937f {
        h() {
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.N();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$i */
    private static class i extends h {
        protected final byte[] e;

        i(byte[] bArr) {
            bArr.getClass();
            this.e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        byte F(int i) {
            return this.e[i];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        public final boolean L() {
            int iC0 = c0();
            return f0.n(this.e, iC0, size() + iC0);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        protected final int O(int i, int i2, int i3) {
            return AbstractC1952v.i(i, this.e, c0() + i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        public final AbstractC1937f Q(int i, int i2) {
            int iW = AbstractC1937f.w(i, i2, size());
            return iW == 0 ? AbstractC1937f.b : new e(this.e, c0() + i, iW);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        protected final String V(Charset charset) {
            return new String(this.e, c0(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        final void a0(AbstractC6688Oo0 abstractC6688Oo0) {
            abstractC6688Oo0.a(this.e, c0(), size());
        }

        final boolean b0(AbstractC1937f abstractC1937f, int i, int i2) {
            if (i2 > abstractC1937f.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 > abstractC1937f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + abstractC1937f.size());
            }
            if (!(abstractC1937f instanceof i)) {
                return abstractC1937f.Q(i, i3).equals(Q(0, i2));
            }
            i iVar = (i) abstractC1937f;
            byte[] bArr = this.e;
            byte[] bArr2 = iVar.e;
            int iC0 = c0() + i2;
            int iC02 = c0();
            int iC03 = iVar.c0() + i;
            while (iC02 < iC0) {
                if (bArr[iC02] != bArr2[iC03]) {
                    return false;
                }
                iC02++;
                iC03++;
            }
            return true;
        }

        protected int c0() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1937f) || size() != ((AbstractC1937f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int iP = P();
            int iP2 = iVar.P();
            if (iP == 0 || iP2 == 0 || iP == iP2) {
                return b0(iVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        public byte j(int i) {
            return this.e[i];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f
        public int size() {
            return this.e.length;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$j */
    private static final class j implements InterfaceC0081f {
        private j() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1937f.InterfaceC0081f
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        c = AbstractC1935d.c() ? new j(aVar) : new d(aVar);
        d = new b();
    }

    AbstractC1937f() {
    }

    public static AbstractC1937f C(byte[] bArr) {
        return D(bArr, 0, bArr.length);
    }

    public static AbstractC1937f D(byte[] bArr, int i2, int i3) {
        w(i2, i2 + i3, bArr.length);
        return new i(c.a(bArr, i2, i3));
    }

    public static AbstractC1937f E(String str) {
        return new i(str.getBytes(AbstractC1952v.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int R(byte b2) {
        return b2 & 255;
    }

    static AbstractC1937f Y(byte[] bArr) {
        return new i(bArr);
    }

    static AbstractC1937f Z(byte[] bArr, int i2, int i3) {
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

    abstract byte F(int i2);

    public abstract boolean L();

    public g N() {
        return new a();
    }

    protected abstract int O(int i2, int i3, int i4);

    protected final int P() {
        return this.a;
    }

    public abstract AbstractC1937f Q(int i2, int i3);

    public final String S(Charset charset) {
        return size() == 0 ? "" : V(charset);
    }

    protected abstract String V(Charset charset);

    public final String W() {
        return S(AbstractC1952v.a);
    }

    abstract void a0(AbstractC6688Oo0 abstractC6688Oo0);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iO = this.a;
        if (iO == 0) {
            int size = size();
            iO = O(size, 0, size);
            if (iO == 0) {
                iO = 1;
            }
            this.a = iO;
        }
        return iO;
    }

    public abstract byte j(int i2);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
