package ir.nasim;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.Yp6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9131Yp6 {

    /* renamed from: ir.nasim.Yp6$a */
    public static final class a implements InterfaceC23384wp6 {
        final /* synthetic */ InterfaceC14603iB2 a;

        public a(InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return AbstractC9131Yp6.a(this.a);
        }
    }

    public static Iterator a(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        C23974xp6 c23974xp6 = new C23974xp6();
        c23974xp6.h(AbstractC14251hc3.a(interfaceC14603iB2, c23974xp6, c23974xp6));
        return c23974xp6;
    }

    public static InterfaceC23384wp6 b(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return new a(interfaceC14603iB2);
    }
}
