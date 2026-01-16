package ir.nasim;

import java.io.InputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public final class OB2 extends InputStream {
    private final ReentrantLock a;
    private final Condition b;
    private InputStream c;

    public OB2() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.b = reentrantLock.newCondition();
    }

    public final void a(InputStream inputStream) {
        this.c = inputStream;
        this.a.lock();
        this.b.signalAll();
        this.a.unlock();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws InterruptedException {
        if (this.c == null) {
            this.a.lock();
            this.b.await();
            this.a.unlock();
        }
        InputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read() throws InterruptedException {
        if (this.c == null) {
            this.a.lock();
            this.b.await();
            this.a.unlock();
        }
        InputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}
