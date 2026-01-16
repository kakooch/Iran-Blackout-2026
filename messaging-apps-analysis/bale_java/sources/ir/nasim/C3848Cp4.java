package ir.nasim;

/* renamed from: ir.nasim.Cp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3848Cp4 {
    private byte[] a;
    private byte[] b;
    private byte[] c;
    private byte[] d;

    public C3848Cp4(byte[] bArr) {
        this.a = AbstractC8107Uo0.h(bArr, 0, 32);
        this.b = AbstractC8107Uo0.h(bArr, 32, 32);
        this.c = AbstractC8107Uo0.h(bArr, 64, 32);
        this.d = AbstractC8107Uo0.h(bArr, 96, 32);
    }

    public byte[] a() {
        return this.c;
    }

    public byte[] b() {
        return this.a;
    }

    public byte[] c() {
        return this.d;
    }

    public byte[] d() {
        return this.b;
    }
}
