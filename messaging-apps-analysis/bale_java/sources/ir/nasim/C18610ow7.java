package ir.nasim;

/* renamed from: ir.nasim.ow7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C18610ow7 {
    private boolean a = false;
    private final String b;
    private long c;
    private byte[] d;

    public C18610ow7(String str) {
        this.b = str;
    }

    private synchronized void c() {
        if (!this.a) {
            this.a = true;
            this.d = AbstractC22589vV2.a(this.b);
            byte[] bArr = new byte[32];
            CT1 ct1H = AbstractC7464Rv1.h();
            byte[] bArr2 = this.d;
            ct1H.c(bArr2, 0, bArr2.length);
            ct1H.a(bArr, 0);
            this.c = AbstractC8107Uo0.c(bArr);
        }
    }

    public byte[] a() {
        c();
        return this.d;
    }

    public long b() {
        c();
        return this.c;
    }
}
