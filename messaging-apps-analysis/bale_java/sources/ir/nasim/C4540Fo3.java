package ir.nasim;

/* renamed from: ir.nasim.Fo3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4540Fo3 implements TT0 {
    private byte[] a;

    public C4540Fo3(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public byte[] a() {
        return this.a;
    }

    public C4540Fo3(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
