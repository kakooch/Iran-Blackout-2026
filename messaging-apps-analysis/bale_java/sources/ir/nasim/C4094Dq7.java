package ir.nasim;

import ir.nasim.InterfaceC21050t16;

/* renamed from: ir.nasim.Dq7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4094Dq7 implements InterfaceC21050t16 {
    private final long d;
    private final InterfaceC21050t16 e;

    public C4094Dq7(long j, InterfaceC21050t16 interfaceC21050t16) {
        AbstractC4980Hj5.b(j >= 0, "Timeout must be non-negative.");
        this.d = j;
        this.e = interfaceC21050t16;
    }

    @Override // ir.nasim.InterfaceC21050t16
    public long a() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC21050t16
    public InterfaceC21050t16.c d(InterfaceC21050t16.b bVar) {
        InterfaceC21050t16.c cVarD = this.e.d(bVar);
        return (a() <= 0 || bVar.b() < a() - cVarD.b()) ? cVarD : InterfaceC21050t16.c.d;
    }
}
