package ir.nasim;

import ir.nasim.AbstractC3769Cg6;
import ir.nasim.P88;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class P88 extends VW7 {
    private final NR b;
    private final C6409Nm c;
    private int d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ Long g;
        final /* synthetic */ UA2 h;

        /* renamed from: ir.nasim.P88$a$a, reason: collision with other inner class name */
        static final class C0570a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ P88 c;
            final /* synthetic */ Long d;
            final /* synthetic */ UA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0570a(P88 p88, Long l, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = p88;
                this.d = l;
                this.e = ua2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0570a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NR nr = this.c.b;
                    SR sr = SR.c;
                    this.b = 1;
                    obj = nr.c(sr, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                String str = (String) obj;
                if (str != null && (!AbstractC20762sZ6.n0(str))) {
                    this.c.U0(this.d);
                    this.e.invoke(str);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0570a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[RQ.values().length];
                try {
                    iArr[RQ.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RQ.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RQ.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, SA2 sa2, UA2 ua22, Long l, UA2 ua23, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = sa2;
            this.f = ua22;
            this.g = l;
            this.h = ua23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(P88 p88, Long l, UA2 ua2, boolean z) {
            if (z) {
                AbstractC10533bm0.d(AbstractC9773aX7.a(p88), null, null, new C0570a(p88, l, ua2, null), 3, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return P88.this.new a(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NR nr = P88.this.b;
                this.b = 1;
                obj = nr.g(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) obj).a();
            if (c19493qS0 != null) {
                SA2 sa2 = this.e;
                UA2 ua2 = this.f;
                int i2 = b.a[AbstractC20084rS0.a(c19493qS0).ordinal()];
                if (i2 == 1) {
                    sa2.invoke();
                } else if (i2 == 2) {
                    ua2.invoke(AbstractC6392Nk0.a(true));
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ua2.invoke(AbstractC6392Nk0.a(false));
                }
            }
            UA2 ua22 = this.d;
            final P88 p88 = P88.this;
            final Long l = this.g;
            final UA2 ua23 = this.h;
            ua22.invoke(new UA2() { // from class: ir.nasim.O88
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return P88.a.y(p88, l, ua23, ((Boolean) obj2).booleanValue());
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public P88(NR nr, C6409Nm c6409Nm) {
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        this.b = nr;
        this.c = c6409Nm;
        this.d = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(Long l) {
        this.c.d("authentication_bots", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", Integer.valueOf(AbstractC3769Cg6.d.a.d().getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(ExPeerType.BOT.getValue())), AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Long.valueOf(l != null ? l.longValue() : -1L)), AbstractC4616Fw7.a("random_id", Integer.valueOf(this.d)), AbstractC4616Fw7.a("source_type", Integer.valueOf(EnumC16528lR.b.j()))));
    }

    public final void S0(Long l, SA2 sa2, UA2 ua2, UA2 ua22, UA2 ua23) {
        AbstractC13042fc3.i(sa2, "navigateToCreatePass");
        AbstractC13042fc3.i(ua2, "navigateToValidatePass");
        AbstractC13042fc3.i(ua22, "registerForResult");
        AbstractC13042fc3.i(ua23, "evaluateWebView");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(ua22, sa2, ua2, l, ua23, null), 3, null);
    }

    public final int T0() {
        return this.d;
    }

    public final void V0(int i) {
        this.d = i;
    }
}
