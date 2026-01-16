package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xbill.DNS.TTL;

/* loaded from: classes8.dex */
public abstract class d implements Iterable {
    public static final d a = new k(new byte[0]);

    public interface a extends Iterator {
        byte j();
    }

    d() {
    }

    public static b B() {
        return new b(128);
    }

    private static d f(Iterator it, int i) {
        if (i == 1) {
            return (d) it.next();
        }
        int i2 = i >>> 1;
        return f(it, i2).h(f(it, i - i2));
    }

    public static d i(Iterable iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add((d) it.next());
            }
        }
        return arrayList.isEmpty() ? a : f(arrayList.iterator(), arrayList.size());
    }

    public static d j(byte[] bArr) {
        return o(bArr, 0, bArr.length);
    }

    public static d o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new k(bArr2);
    }

    public static d r(String str) {
        try {
            return new k(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public abstract boolean A();

    protected abstract int C(int i, int i2, int i3);

    protected abstract int D(int i, int i2, int i3);

    protected abstract int E();

    public byte[] F() {
        int size = size();
        if (size == 0) {
            return i.a;
        }
        byte[] bArr = new byte[size];
        v(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String I(String str);

    public String L() {
        try {
            return I("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    void N(OutputStream outputStream, int i, int i2) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i3 = i + i2;
        if (i3 <= size()) {
            if (i2 > 0) {
                O(outputStream, i, i2);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    abstract void O(OutputStream outputStream, int i, int i2);

    public d h(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 < TTL.MAX_VALUE) {
            return m.S(this, dVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public void t(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i3 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i4 = i + i3;
        if (i4 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i4);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i5 = i2 + i3;
        if (i5 <= bArr.length) {
            if (i3 > 0) {
                v(bArr, i, i2, i3);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i5);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract void v(byte[] bArr, int i, int i2, int i3);

    protected abstract int w();

    protected abstract boolean x();

    public static final class b extends OutputStream {
        private static final byte[] f = new byte[0];
        private final int a;
        private final ArrayList b;
        private int c;
        private byte[] d;
        private int e;

        b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.a = i;
            this.b = new ArrayList();
            this.d = new byte[i];
        }

        private byte[] a(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        private void b(int i) {
            this.b.add(new k(this.d));
            int length = this.c + this.d.length;
            this.c = length;
            this.d = new byte[Math.max(this.a, Math.max(i, length >>> 1))];
            this.e = 0;
        }

        private void c() {
            int i = this.e;
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.b.add(new k(this.d));
                this.d = f;
            } else if (i > 0) {
                this.b.add(new k(a(bArr, i)));
            }
            this.c += this.e;
            this.e = 0;
        }

        public synchronized int d() {
            return this.c + this.e;
        }

        public synchronized d e() {
            c();
            return d.i(this.b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            try {
                if (this.e == this.d.length) {
                    b(1);
                }
                byte[] bArr = this.d;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr[i2] = (byte) i;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            try {
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i3 = this.e;
                if (i2 <= length - i3) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this.e += i2;
                } else {
                    int length2 = bArr2.length - i3;
                    System.arraycopy(bArr, i, bArr2, i3, length2);
                    int i4 = i2 - length2;
                    b(i4);
                    System.arraycopy(bArr, i + length2, this.d, 0, i4);
                    this.e = i4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
