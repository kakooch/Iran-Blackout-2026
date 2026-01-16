package ir.nasim;

import androidx.compose.ui.e;

/* loaded from: classes2.dex */
public abstract class WA4 {
    private static final a a;

    public static final class a extends e.c {
        a() {
        }

        public String toString() {
            return "<Head>";
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12544en4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12544en4 c12544en4) {
            super(1);
            this.e = c12544en4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e.b bVar) {
            this.e.d(bVar);
            return Boolean.TRUE;
        }
    }

    static {
        a aVar = new a();
        aVar.k2(-1);
        a = aVar;
    }

    public static final int d(e.b bVar, e.b bVar2) {
        if (AbstractC13042fc3.d(bVar, bVar2)) {
            return 2;
        }
        return AbstractC15754k7.a(bVar, bVar2) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12544en4 e(androidx.compose.ui.e eVar, C12544en4 c12544en4) {
        C12544en4 c12544en42 = new C12544en4(new androidx.compose.ui.e[AbstractC23053wG5.e(c12544en4.o(), 16)], 0);
        c12544en42.d(eVar);
        b bVar = null;
        while (c12544en42.o() != 0) {
            androidx.compose.ui.e eVar2 = (androidx.compose.ui.e) c12544en42.w(c12544en42.o() - 1);
            if (eVar2 instanceof androidx.compose.ui.a) {
                androidx.compose.ui.a aVar = (androidx.compose.ui.a) eVar2;
                c12544en42.d(aVar.f());
                c12544en42.d(aVar.k());
            } else if (eVar2 instanceof e.b) {
                c12544en4.d(eVar2);
            } else {
                if (bVar == null) {
                    bVar = new b(c12544en4);
                }
                eVar2.c(bVar);
                bVar = bVar;
            }
        }
        return c12544en4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AbstractC25066zg4 abstractC25066zg4, e.c cVar) {
        AbstractC13042fc3.g(cVar, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        abstractC25066zg4.k(cVar);
    }
}
