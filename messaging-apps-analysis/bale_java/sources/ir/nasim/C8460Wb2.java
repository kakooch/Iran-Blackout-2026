package ir.nasim;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: ir.nasim.Wb2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8460Wb2 extends InputStream {
    private static final Queue c = YM7.g(0);
    private InputStream a;
    private IOException b;

    C8460Wb2() {
    }

    public static C8460Wb2 b(InputStream inputStream) {
        C8460Wb2 c8460Wb2;
        Queue queue = c;
        synchronized (queue) {
            c8460Wb2 = (C8460Wb2) queue.poll();
        }
        if (c8460Wb2 == null) {
            c8460Wb2 = new C8460Wb2();
        }
        c8460Wb2.d(inputStream);
        return c8460Wb2;
    }

    public IOException a() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    public void c() {
        this.b = null;
        this.a = null;
        Queue queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    void d(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.a.skip(j);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
