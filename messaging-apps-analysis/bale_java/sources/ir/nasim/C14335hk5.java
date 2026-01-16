package ir.nasim;

/* renamed from: ir.nasim.hk5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C14335hk5 implements RP {
    private InterfaceC3570Bk5 a;

    public C14335hk5(InterfaceC3570Bk5 interfaceC3570Bk5) {
        this.a = interfaceC3570Bk5;
    }

    @Override // ir.nasim.RP
    public byte[] a() {
        return this.a.b("auth_master_key");
    }

    @Override // ir.nasim.RP
    public void b(long j) {
        this.a.putLong("auth_id", j);
    }

    @Override // ir.nasim.RP
    public void c(byte[] bArr) {
        this.a.f("auth_master_key", bArr);
    }

    @Override // ir.nasim.RP
    public long d() {
        return this.a.getLong("auth_id", 0L);
    }
}
