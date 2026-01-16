package ir.nasim;

/* renamed from: ir.nasim.dy6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12063dy6 extends Y1 {
    public long a = -1;
    public InterfaceC20295rm1 b;

    @Override // ir.nasim.Y1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(C10656by6 c10656by6) {
        if (this.a >= 0) {
            return false;
        }
        this.a = c10656by6.a0();
        return true;
    }

    @Override // ir.nasim.Y1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC20295rm1[] b(C10656by6 c10656by6) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return c10656by6.Z(j);
    }
}
