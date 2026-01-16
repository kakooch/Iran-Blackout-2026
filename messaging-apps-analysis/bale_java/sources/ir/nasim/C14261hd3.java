package ir.nasim;

/* renamed from: ir.nasim.hd3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14261hd3 extends AbstractC20633sL3 {
    private final AbstractC20633sL3 c;

    public C14261hd3(AbstractC20633sL3 abstractC20633sL3) {
        super(abstractC20633sL3.d(), abstractC20633sL3.a());
        this.c = abstractC20633sL3;
    }

    @Override // ir.nasim.AbstractC20633sL3
    public byte[] b() {
        byte[] bArrB = this.c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i = 0; i < iD; i++) {
            bArr[i] = (byte) (255 - (bArrB[i] & 255));
        }
        return bArr;
    }

    @Override // ir.nasim.AbstractC20633sL3
    public byte[] c(int i, byte[] bArr) {
        byte[] bArrC = this.c.c(i, bArr);
        int iD = d();
        for (int i2 = 0; i2 < iD; i2++) {
            bArrC[i2] = (byte) (255 - (bArrC[i2] & 255));
        }
        return bArrC;
    }

    @Override // ir.nasim.AbstractC20633sL3
    public boolean f() {
        return this.c.f();
    }

    @Override // ir.nasim.AbstractC20633sL3
    public AbstractC20633sL3 g() {
        return new C14261hd3(this.c.g());
    }
}
