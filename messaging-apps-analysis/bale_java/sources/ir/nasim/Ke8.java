package ir.nasim;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class Ke8 implements InterfaceC11618dJ4 {
    final /* synthetic */ BG1 a;

    Ke8(BG1 bg1) {
        this.a = bg1;
    }

    @Override // ir.nasim.InterfaceC11618dJ4
    public final void a(InterfaceC15678jz3 interfaceC15678jz3) {
        this.a.a = interfaceC15678jz3;
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((Gf8) it.next()).a(this.a.a);
        }
        this.a.c.clear();
        this.a.b = null;
    }
}
