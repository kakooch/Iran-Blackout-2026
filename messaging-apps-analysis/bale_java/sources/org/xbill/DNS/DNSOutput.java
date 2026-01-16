package org.xbill.DNS;

/* loaded from: classes8.dex */
public class DNSOutput {
    private byte[] array;
    private int pos;
    private int savedPos;

    public DNSOutput(int i) {
        this.array = new byte[i];
        this.pos = 0;
        this.savedPos = -1;
    }

    private void check(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + " out of range for " + i + " bit value");
        }
    }

    private void need(int i) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i2 = this.pos;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.array = bArr2;
    }

    static byte[] toU16(int i) {
        return new byte[]{(byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i) {
        if (i > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i;
    }

    public void restore() {
        int i = this.savedPos;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i;
        this.savedPos = -1;
    }

    public void save() {
        this.savedPos = this.pos;
    }

    public byte[] toByteArray() {
        int i = this.pos;
        byte[] bArr = new byte[i];
        System.arraycopy(this.array, 0, bArr, 0, i);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        need(i2);
        System.arraycopy(bArr, i, this.array, this.pos, i2);
        this.pos += i2;
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i = this.pos;
        this.pos = i + 1;
        bArr2[i] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeU16(int i) {
        check(i, 16);
        need(2);
        byte[] bArr = this.array;
        int i2 = this.pos;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.pos = i2 + 2;
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public void writeU16At(int i, int i2) {
        check(i, 16);
        if (i2 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
    }

    public void writeU32(long j) {
        check(j, 32);
        need(4);
        byte[] bArr = this.array;
        int i = this.pos;
        bArr[i] = (byte) ((j >>> 24) & 255);
        bArr[i + 1] = (byte) ((j >>> 16) & 255);
        bArr[i + 2] = (byte) ((j >>> 8) & 255);
        this.pos = i + 4;
        bArr[i + 3] = (byte) (j & 255);
    }

    public void writeU8(int i) {
        check(i, 8);
        need(1);
        byte[] bArr = this.array;
        int i2 = this.pos;
        this.pos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public DNSOutput() {
        this(32);
    }
}
