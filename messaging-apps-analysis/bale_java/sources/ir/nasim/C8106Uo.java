package ir.nasim;

import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.Uo, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8106Uo implements HV1 {
    private final InterfaceC13730gj3 a;

    public C8106Uo(InterfaceC13730gj3 interfaceC13730gj3) {
        AbstractC13042fc3.i(interfaceC13730gj3, "job");
        this.a = interfaceC13730gj3;
    }

    @Override // ir.nasim.HV1
    public void dispose() {
        if (this.a.b()) {
            InterfaceC13730gj3.a.a(this.a, null, 1, null);
        }
    }
}
