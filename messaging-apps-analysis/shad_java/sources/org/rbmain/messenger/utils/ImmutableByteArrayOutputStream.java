package org.rbmain.messenger.utils;

import java.io.OutputStream;
import java.util.Arrays;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes4.dex */
public class ImmutableByteArrayOutputStream extends OutputStream {
    public byte[] buf;
    protected int count;

    public ImmutableByteArrayOutputStream(int i) {
        this.buf = new byte[i];
    }

    private void ensureCapacity(int i) {
        if (i - this.buf.length > 0) {
            grow(i);
        }
    }

    private void grow(int i) {
        int length = this.buf.length << 1;
        if (length - i < 0) {
            length = i;
        }
        if (length - 2147483639 > 0) {
            length = hugeCapacity(i);
        }
        this.buf = Arrays.copyOf(this.buf, length);
    }

    private static int hugeCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > 2147483639) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        return 2147483639;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        ensureCapacity(this.count + 1);
        byte[] bArr = this.buf;
        int i2 = this.count;
        bArr[i2] = (byte) i;
        this.count = i2 + 1;
    }

    public void writeInt(int i) {
        ensureCapacity(this.count + 4);
        byte[] bArr = this.buf;
        int i2 = this.count;
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.count = i2 + 4;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (i >= 0) {
            if (i <= bArr.length && i2 >= 0 && (i + i2) - bArr.length <= 0) {
                ensureCapacity(this.count + i2);
                System.arraycopy(bArr, i, this.buf, this.count, i2);
                this.count += i2;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public synchronized void reset() {
        this.count = 0;
    }
}
