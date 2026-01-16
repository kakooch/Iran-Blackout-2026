package ir.nasim;

import ir.nasim.QR;
import ir.nasim.core.modules.settings.SettingsModule;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.e73, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12149e73 extends VW7 implements InterfaceC24754z90, InterfaceC7274Ra0 {
    private final NR b;
    private final SettingsModule c;
    private boolean d;
    private final int e;

    /* renamed from: ir.nasim.e73$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12149e73.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C12149e73 c12149e73;
            boolean zA;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12149e73 c12149e732 = C12149e73.this;
                NR nr = c12149e732.b;
                this.b = c12149e732;
                this.c = 1;
                Object objG = nr.g(this);
                if (objG == objE) {
                    return objE;
                }
                c12149e73 = c12149e732;
                obj = objG;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c12149e73 = (C12149e73) this.b;
                AbstractC10685c16.b(obj);
            }
            QR qr = (QR) obj;
            if (qr instanceof QR.c) {
                zA = ((C19493qS0) ((QR.c) qr).b()).a();
            } else {
                if (!(qr instanceof QR.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                zA = false;
            }
            c12149e73.d = zA;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.e73$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ C12149e73 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, C12149e73 c12149e73, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = c12149e73;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua22 = this.d;
                NR nr = this.e.b;
                SR sr = SR.a;
                this.b = ua22;
                this.c = 1;
                Object objJ = nr.j(sr, this);
                if (objJ == objE) {
                    return objE;
                }
                ua2 = ua22;
                obj = objJ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua2 = (UA2) this.b;
                AbstractC10685c16.b(obj);
            }
            ua2.invoke(AbstractC6392Nk0.a(!((Boolean) obj).booleanValue()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12149e73(NR nr, SettingsModule settingsModule) {
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = nr;
        this.c = settingsModule;
        this.e = AbstractC17026mG5.a.g(Integer.MAX_VALUE);
    }

    public final void S0() {
        if (this.c.i5() || !C8386Vt0.a.x4()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        }
    }

    public final int T0() {
        return this.e;
    }

    public final boolean U0() {
        return this.d;
    }

    public final void V0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "callback");
        if (this.c.i5() || C8386Vt0.a.x4()) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(ua2, this, null), 3, null);
        } else {
            ua2.invoke(Boolean.FALSE);
        }
    }
}
