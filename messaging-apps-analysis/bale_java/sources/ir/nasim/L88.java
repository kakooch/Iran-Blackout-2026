package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class L88 extends AbstractC6360Ng4 {
    public static final a o = new a(null);
    public static final int p = 8;
    private final C9057Yh4 m;
    private final InterfaceC9173Yu3 n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L88(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.K88
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return L88.j0(this.a);
            }
        });
    }

    private final String f0() {
        return (String) this.n.getValue();
    }

    private final void g0() {
        O78 o78 = O78.a;
        OK okC = this.m.T().C();
        AbstractC13042fc3.h(okC, "getBlobEngine(...)");
        o78.i(okC);
        try {
            h0(f0());
        } catch (Exception e) {
            C19406qI3.c("WebViewRouter", "onInitializeWebViewActor: failed to refresh", e);
        }
    }

    private final void h0(String str) {
        O78.a.d(str).E(new InterfaceC24449ye1() { // from class: ir.nasim.J88
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                L88.i0((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Exception exc) {
        C19406qI3.c("WebViewRouter", "failed to refresh", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j0(L88 l88) {
        AbstractC13042fc3.i(l88, "this$0");
        return l88.m.S().v4();
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof A73) {
            g0();
        } else if (obj instanceof C19444qM5) {
            h0(((C19444qM5) obj).a());
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        r().d(new A73());
    }
}
