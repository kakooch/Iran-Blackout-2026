package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.hW, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14191hW {
    private static final a a = new a();
    private static final UA2 b = b.e;
    private static final UA2 c = c.e;

    /* renamed from: ir.nasim.hW$a */
    public static final class a implements InterfaceC24472yg4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC24472yg4
        public Object t(AbstractC19629qg4 abstractC19629qg4) {
            return abstractC19629qg4.a().invoke();
        }
    }

    /* renamed from: ir.nasim.hW$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(C13600gW c13600gW) {
            c13600gW.y2();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13600gW) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hW$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final void a(C13600gW c13600gW) {
            c13600gW.B2();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13600gW) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(C13600gW c13600gW) {
        e.c cVarP = KG1.o(c13600gW).t0().p();
        AbstractC13042fc3.g(cVarP, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((C16707lj7) cVarP).v2();
    }
}
