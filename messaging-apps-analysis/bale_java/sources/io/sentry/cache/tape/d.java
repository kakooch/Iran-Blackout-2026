package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class d implements Closeable, Iterable {
    private static final byte[] m = new byte[4096];
    RandomAccessFile a;
    final File b;
    long d;
    int e;
    b f;
    private b g;
    private final boolean j;
    private final int k;
    boolean l;
    final int c = 32;
    private final byte[] h = new byte[32];
    int i = 0;

    public static final class a {
        final File a;
        boolean b = true;
        int c = -1;

        public a(File file) {
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            this.a = file;
        }

        public d a() throws IOException {
            RandomAccessFile randomAccessFileF0 = d.f0(this.a);
            try {
                return new d(this.a, randomAccessFileF0, this.b, this.c);
            } catch (Throwable th) {
                randomAccessFileF0.close();
                throw th;
            }
        }

        public a b(int i) {
            this.c = i;
            return this;
        }
    }

    static final class b {
        static final b c = new b(0, 0);
        final long a;
        final int b;

        b(long j, int i) {
            this.a = j;
            this.b = i;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position=" + this.a + ", length=" + this.b + "]";
        }
    }

    private final class c implements Iterator {
        int a = 0;
        private long b;
        int c;

        c() {
            this.b = d.this.f.a;
            this.c = d.this.i;
        }

        private void a() {
            if (d.this.i != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] next() {
            if (d.this.l) {
                throw new IllegalStateException("closed");
            }
            a();
            if (d.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            int i = this.a;
            d dVar = d.this;
            if (i >= dVar.e) {
                throw new NoSuchElementException();
            }
            try {
                try {
                    b bVarX0 = dVar.x0(this.b);
                    byte[] bArr = new byte[bVarX0.b];
                    long jU1 = d.this.U1(bVarX0.a + 4);
                    this.b = jU1;
                    if (!d.this.G1(jU1, bArr, 0, bVarX0.b)) {
                        this.a = d.this.e;
                        return d.m;
                    }
                    this.b = d.this.U1(bVarX0.a + 4 + bVarX0.b);
                    this.a++;
                    return bArr;
                } catch (IOException e) {
                    throw ((Error) d.d0(e));
                }
            } catch (IOException e2) {
                throw ((Error) d.d0(e2));
            } catch (OutOfMemoryError unused) {
                d.this.R0();
                this.a = d.this.e;
                return d.m;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (d.this.l) {
                throw new IllegalStateException("closed");
            }
            a();
            return this.a != d.this.e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            if (d.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.a != 1) {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
            try {
                d.this.J0();
                this.c = d.this.i;
                this.a--;
            } catch (IOException e) {
                throw ((Error) d.d0(e));
            }
        }
    }

    d(File file, RandomAccessFile randomAccessFile, boolean z, int i) throws IOException {
        this.b = file;
        this.a = randomAccessFile;
        this.j = z;
        this.k = i;
        A0();
    }

    private void A0() throws IOException {
        this.a.seek(0L);
        this.a.readFully(this.h);
        this.d = C0(this.h, 4);
        this.e = B0(this.h, 12);
        long jC0 = C0(this.h, 16);
        long jC02 = C0(this.h, 24);
        if (this.d > this.a.length()) {
            throw new IOException("File is truncated. Expected length: " + this.d + ", Actual length: " + this.a.length());
        }
        if (this.d > 32) {
            this.f = x0(jC0);
            this.g = x0(jC02);
        } else {
            throw new IOException("File is corrupt; length stored in header (" + this.d + ") is invalid.");
        }
    }

    private static int B0(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private static long C0(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 56) + ((bArr[i + 1] & 255) << 48) + ((bArr[i + 2] & 255) << 40) + ((bArr[i + 3] & 255) << 32) + ((bArr[i + 4] & 255) << 24) + ((bArr[i + 5] & 255) << 16) + ((bArr[i + 6] & 255) << 8) + (bArr[i + 7] & 255);
    }

    private long D0() {
        return this.d - T1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() throws IOException {
        this.a.close();
        this.b.delete();
        this.a = f0(this.b);
        A0();
    }

    private void R1(long j, byte[] bArr, int i, int i2) throws IOException {
        long jU1 = U1(j);
        long j2 = i2 + jU1;
        long j3 = this.d;
        if (j2 <= j3) {
            this.a.seek(jU1);
            this.a.write(bArr, i, i2);
            return;
        }
        int i3 = (int) (j3 - jU1);
        this.a.seek(jU1);
        this.a.write(bArr, i, i3);
        this.a.seek(32L);
        this.a.write(bArr, i + i3, i2 - i3);
    }

    private void S1(long j) throws IOException {
        this.a.setLength(j);
        this.a.getChannel().force(true);
    }

    private long T1() {
        if (this.e == 0) {
            return 32L;
        }
        long j = this.g.a;
        long j2 = this.f.a;
        return j >= j2 ? (j - j2) + 4 + r0.b + 32 : (((j + 4) + r0.b) + this.d) - j2;
    }

    private void V1(long j, int i, long j2, long j3) throws IOException {
        this.a.seek(0L);
        W1(this.h, 0, -2147483647);
        X1(this.h, 4, j);
        W1(this.h, 12, i);
        X1(this.h, 16, j2);
        X1(this.h, 24, j3);
        this.a.write(this.h, 0, 32);
    }

    private static void W1(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private void X0(long j, long j2) throws IOException {
        while (j2 > 0) {
            byte[] bArr = m;
            int iMin = (int) Math.min(j2, bArr.length);
            R1(j, bArr, 0, iMin);
            long j3 = iMin;
            j2 -= j3;
            j += j3;
        }
    }

    private static void X1(byte[] bArr, int i, long j) {
        bArr[i] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) j;
    }

    private void Z(long j) throws IOException {
        long j2;
        long j3;
        long j4 = j + 4;
        long jD0 = D0();
        if (jD0 >= j4) {
            return;
        }
        long j5 = this.d;
        while (true) {
            jD0 += j5;
            j2 = j5 << 1;
            if (jD0 >= j4) {
                break;
            } else {
                j5 = j2;
            }
        }
        S1(j2);
        long jU1 = U1(this.g.a + 4 + r2.b);
        if (jU1 <= this.f.a) {
            FileChannel channel = this.a.getChannel();
            channel.position(this.d);
            j3 = jU1 - 32;
            if (channel.transferTo(32L, j3, channel) != j3) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        } else {
            j3 = 0;
        }
        long j6 = j3;
        long j7 = this.g.a;
        long j8 = this.f.a;
        if (j7 < j8) {
            long j9 = (this.d + j7) - 32;
            V1(j2, this.e, j8, j9);
            this.g = new b(j9, this.g.b);
        } else {
            V1(j2, this.e, j8, j7);
        }
        this.d = j2;
        if (this.j) {
            X0(32L, j6);
        }
    }

    static RandomAccessFile f0(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFileS0 = s0(file2);
            try {
                randomAccessFileS0.setLength(4096L);
                randomAccessFileS0.seek(0L);
                randomAccessFileS0.writeInt(-2147483647);
                randomAccessFileS0.writeLong(4096L);
                randomAccessFileS0.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFileS0.close();
                throw th;
            }
        }
        return s0(file);
    }

    private static RandomAccessFile s0(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    boolean G1(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            long jU1 = U1(j);
            long j2 = i2 + jU1;
            long j3 = this.d;
            if (j2 <= j3) {
                this.a.seek(jU1);
                this.a.readFully(bArr, i, i2);
                return true;
            }
            int i3 = (int) (j3 - jU1);
            this.a.seek(jU1);
            this.a.readFully(bArr, i, i3);
            this.a.seek(32L);
            this.a.readFully(bArr, i + i3, i2 - i3);
            return true;
        } catch (EOFException unused) {
            R0();
            return false;
        } catch (IOException e) {
            throw e;
        } catch (Throwable unused2) {
            R0();
            return false;
        }
    }

    public void J0() throws IOException {
        N0(1);
    }

    public void N0(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Cannot remove negative (" + i + ") number of elements.");
        }
        if (i == 0) {
            return;
        }
        if (i == this.e) {
            clear();
            return;
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (i > this.e) {
            throw new IllegalArgumentException("Cannot remove more elements (" + i + ") than present in queue (" + this.e + ").");
        }
        b bVar = this.f;
        long j = bVar.a;
        int iB0 = bVar.b;
        long j2 = 0;
        int i2 = 0;
        long j3 = j;
        while (i2 < i) {
            j2 += iB0 + 4;
            long jU1 = U1(j3 + 4 + iB0);
            if (!G1(jU1, this.h, 0, 4)) {
                return;
            }
            iB0 = B0(this.h, 0);
            i2++;
            j3 = jU1;
        }
        V1(this.d, this.e - i, j3, this.g.a);
        this.e -= i;
        this.i++;
        this.f = new b(j3, iB0);
        if (this.j) {
            X0(j, j2);
        }
    }

    public void S(byte[] bArr, int i, int i2) throws IOException {
        long jU1;
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (this.l) {
            throw new IllegalStateException("closed");
        }
        if (k0()) {
            J0();
        }
        Z(i2);
        boolean zIsEmpty = isEmpty();
        if (zIsEmpty) {
            jU1 = 32;
        } else {
            jU1 = U1(this.g.a + 4 + r0.b);
        }
        b bVar = new b(jU1, i2);
        W1(this.h, 0, i2);
        R1(bVar.a, this.h, 0, 4);
        R1(bVar.a + 4, bArr, i, i2);
        V1(this.d, this.e + 1, zIsEmpty ? bVar.a : this.f.a, bVar.a);
        this.g = bVar;
        this.e++;
        this.i++;
        if (zIsEmpty) {
            this.f = bVar;
        }
    }

    long U1(long j) {
        long j2 = this.d;
        return j < j2 ? j : (j + 32) - j2;
    }

    public void clear() throws IOException {
        if (this.l) {
            throw new IllegalStateException("closed");
        }
        V1(4096L, 0, 0L, 0L);
        if (this.j) {
            this.a.seek(32L);
            this.a.write(m, 0, 4064);
        }
        this.e = 0;
        b bVar = b.c;
        this.f = bVar;
        this.g = bVar;
        if (this.d > 4096) {
            S1(4096L);
        }
        this.d = 4096L;
        this.i++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l = true;
        this.a.close();
    }

    public boolean isEmpty() {
        return this.e == 0;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new c();
    }

    public boolean k0() {
        return this.k != -1 && size() == this.k;
    }

    public int size() {
        return this.e;
    }

    public String toString() {
        return "QueueFile{file=" + this.b + ", zero=" + this.j + ", length=" + this.d + ", size=" + this.e + ", first=" + this.f + ", last=" + this.g + '}';
    }

    b x0(long j) {
        return j == 0 ? b.c : !G1(j, this.h, 0, 4) ? b.c : new b(j, B0(this.h, 0));
    }

    static Throwable d0(Throwable th) throws Throwable {
        throw th;
    }
}
