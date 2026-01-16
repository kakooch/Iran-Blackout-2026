package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Bi6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3553Bi6 extends AbstractC6360Ng4 {
    private final C22674ve2 m;

    /* renamed from: ir.nasim.Bi6$a */
    public static final class a {
    }

    /* renamed from: ir.nasim.Bi6$b */
    public static final class b {
    }

    /* renamed from: ir.nasim.Bi6$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, C3553Bi6.class, "handleRefreshTlsPublicKeyHashResult", "handleRefreshTlsPublicKeyHashResult(Z)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Boolean) obj).booleanValue());
            return C19938rB7.a;
        }

        public final void y(boolean z) {
            ((C3553Bi6) this.receiver).e0(z);
        }
    }

    /* renamed from: ir.nasim.Bi6$d */
    /* synthetic */ class d extends EB2 implements UA2 {
        d(Object obj) {
            super(1, obj, C3553Bi6.class, "handleRefreshTlsPublicKeyHashResult", "handleRefreshTlsPublicKeyHashResult(Z)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Boolean) obj).booleanValue());
            return C19938rB7.a;
        }

        public final void y(boolean z) {
            ((C3553Bi6) this.receiver).e0(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3553Bi6(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = new C22674ve2(60000, 300000, 25);
        b0("sequences_synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(boolean z) {
        if (z) {
            this.m.c();
        } else {
            this.m.b();
            q(new b(), this.m.a());
        }
    }

    private final void f0() {
        AbstractC4021Di6.c(new d(this));
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        f0();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof b) {
            f0();
        } else if (obj instanceof a) {
            AbstractC4021Di6.e(new c(this));
        } else {
            super.m(obj);
        }
    }
}
