package ir.nasim;

import ir.nasim.C9475a16;
import java.util.List;

/* renamed from: ir.nasim.ak1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9894ak1 extends VW7 {
    private final C10299bQ2 b;
    private final E84 c;
    private final InterfaceC21103t7 d;
    private InterfaceC4557Fq2 e;
    private String f;
    private List g;

    /* renamed from: ir.nasim.ak1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ C9894ak1 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, C9894ak1 c9894ak1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = c9894ak1;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua22 = this.d;
                InterfaceC21103t7 interfaceC21103t7 = this.e.d;
                int i2 = this.f;
                this.b = ua22;
                this.c = 1;
                Object objD = interfaceC21103t7.d(i2, this);
                if (objD == objE) {
                    return objE;
                }
                ua2 = ua22;
                objL = objD;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua2 = (UA2) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            Boolean boolA = AbstractC6392Nk0.a(false);
            if (C9475a16.g(objL)) {
                objL = boolA;
            }
            ua2.invoke(objL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ak1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
            this.f = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9894ak1.this.new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC21103t7 interfaceC21103t7 = C9894ak1.this.d;
                int i2 = this.d;
                this.b = 1;
                objF = interfaceC21103t7.f(i2, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objF)) {
                C9894ak1.this.a1(this.d, this.e, this.f);
            } else {
                this.f.invoke(C9475a16.a(objF));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ak1$c */
    public static final class c implements InterfaceC15419jZ0 {
        final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            UA2 ua2 = this.a;
            C9475a16.a aVar = C9475a16.b;
            ua2.invoke(C9475a16.a(C9475a16.b(C19938rB7.a)));
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            UA2 ua2 = this.a;
            C9475a16.a aVar = C9475a16.b;
            if (exc == null) {
                exc = new Exception("Unknown error");
            }
            ua2.invoke(C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    public C9894ak1(C8054Ui1 c8054Ui1, C10299bQ2 c10299bQ2, E84 e84, InterfaceC21103t7 interfaceC21103t7) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC21103t7, "adRepository");
        this.b = c10299bQ2;
        this.c = e84;
        this.d = interfaceC21103t7;
        this.f = "";
        List listK = c8054Ui1.m0().k();
        AbstractC13042fc3.h(listK, "getAllValue(...)");
        this.g = AbstractC15401jX0.m1(listK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 V0(String str, C9894ak1 c9894ak1) {
        AbstractC13042fc3.i(str, "$search");
        AbstractC13042fc3.i(c9894ak1, "this$0");
        return new C10504bj1(str, c9894ak1.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C9894ak1 c9894ak1, int i, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c9894ak1, "this$0");
        c9894ak1.c.r0(C11458d25.y(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(int i, int i2, UA2 ua2) {
        this.b.I3(i, i2).a(new c(ua2));
    }

    public final InterfaceC4557Fq2 U0(final String str) {
        AbstractC13042fc3.i(str, "search");
        if (this.e == null || !AbstractC13042fc3.d(str, this.f)) {
            this.f = str;
            this.e = AbstractC9395Zt0.a(new C12960fT4(new MT4(10, 0, false, 0, 0, 0, 58, null), null, new SA2() { // from class: ir.nasim.Sj1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C9894ak1.V0(str, this);
                }
            }, 2, null).a(), AbstractC9773aX7.a(this));
        }
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.e;
        AbstractC13042fc3.f(interfaceC4557Fq2);
        return interfaceC4557Fq2;
    }

    public final C6517Nv5 W0(final int i) {
        C6517Nv5 c6517Nv5M0 = this.b.w2(i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Uj1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C9894ak1.X0(this.a, i, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final void Y0(int i, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onResult");
        if (z) {
            ua2.invoke(Boolean.FALSE);
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(ua2, this, i, null), 3, null);
        }
    }

    public final void Z0(int i, int i2, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onResult");
        if (z) {
            a1(i, i2, ua2);
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(i, i2, ua2, null), 3, null);
        }
    }
}
