package ir.nasim;

import java.io.OutputStream;

/* renamed from: ir.nasim.Py3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C7025Py3 extends OutputStream {
    private long a = 0;

    C7025Py3() {
    }

    long a() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.a += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i >= 0 && i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
            this.a += i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
