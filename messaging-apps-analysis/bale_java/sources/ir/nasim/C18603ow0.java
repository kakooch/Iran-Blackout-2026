package ir.nasim;

import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.ow0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18603ow0 implements InterfaceC18012nw0 {
    private final InterfaceC18160oB2 a = Z21.a.a();

    @Override // ir.nasim.InterfaceC18012nw0
    public Fragment a(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2, InterfaceC4557Fq2 interfaceC4557Fq22) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "toolbarActionFlow");
        AbstractC13042fc3.i(ua2, "getAppBarState");
        C6760Ow0 c6760Ow0A = C6760Ow0.INSTANCE.a();
        c6760Ow0A.Ya(ua2);
        c6760Ow0A.Za(interfaceC4557Fq2);
        if (interfaceC4557Fq22 != null) {
            c6760Ow0A.Wa(interfaceC4557Fq22);
        }
        return c6760Ow0A;
    }

    @Override // ir.nasim.InterfaceC18012nw0
    public Fragment b() {
        return C6760Ow0.INSTANCE.a();
    }
}
