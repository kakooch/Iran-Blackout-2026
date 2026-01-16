package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ds8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C11985ds8 extends Vh8 {
    final /* synthetic */ InterfaceC11995dt8 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C11985ds8(C24006xs8 c24006xs8, String str, InterfaceC11995dt8 interfaceC11995dt8) {
        super("getValue");
        this.c = interfaceC11995dt8;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        AbstractC9951ap8.h("getValue", 2, list);
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
        InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
        String strA = this.c.a(interfaceC22720vi8B.j());
        return strA != null ? new Ei8(strA) : interfaceC22720vi8B2;
    }
}
