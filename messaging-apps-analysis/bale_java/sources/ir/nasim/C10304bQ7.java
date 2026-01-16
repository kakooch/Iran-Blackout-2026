package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;
import ir.nasim.XP7;
import java.util.List;

/* renamed from: ir.nasim.bQ7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10304bQ7 extends VW7 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final C15346jR b;
    private final MQ c;
    private final InterfaceC3570Bk5 d;
    private final InterfaceC21014sz3 e;
    private final AK6 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private final InterfaceC9173Yu3 i;

    /* renamed from: ir.nasim.bQ7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bQ7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10304bQ7.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C10304bQ7.this.d.g("PREF_KEY_IS_IN_SING_UP", true);
            C10304bQ7.this.d.putString("PREF_KEY_TRANSACTION_HASH", this.d);
            InterfaceC9336Zm4 interfaceC9336Zm4 = C10304bQ7.this.g;
            String str = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, new XP7.d(str)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bQ7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ List e;
        final /* synthetic */ SQ f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, List list, SQ sq, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = list;
            this.f = sq;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10304bQ7.this.new c(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AK6 ak6 = C10304bQ7.this.f;
                long j = this.d;
                List list = this.e;
                SQ sq = this.f;
                this.b = 1;
                objA = ak6.a(j, list, sq, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C10304bQ7 c10304bQ7 = C10304bQ7.this;
            long j2 = this.d;
            if (C9475a16.j(objA)) {
                TQ tq = (TQ) objA;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10304bQ7.g;
                while (true) {
                    Object value2 = interfaceC9336Zm4.getValue();
                    long j3 = j2;
                    if (interfaceC9336Zm4.f(value2, new XP7.f(j2, tq.h(), tq.g(), tq.c(), tq.e(), tq.f()))) {
                        break;
                    }
                    j2 = j3;
                }
            }
            C10304bQ7 c10304bQ72 = C10304bQ7.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c10304bQ72.g;
                do {
                    value = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value, new XP7.a(LP.a.a(thE, EnumC10415ba2.b))));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bQ7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
            this.f = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C10304bQ7.this.new d(this.e, this.f, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objL;
            String name;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                MQ mq = C10304bQ7.this.c;
                String str = this.e;
                String str2 = this.f;
                List listM = AbstractC10360bX0.m();
                this.c = interfaceC20315ro12;
                this.b = 1;
                Object objG = mq.g(str, str2, listM, true, this);
                if (objG == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
                objL = objG;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C10304bQ7 c10304bQ7 = C10304bQ7.this;
            String str3 = this.f;
            if (C9475a16.j(objL)) {
                IP ip = (IP) objL;
                if (ip.b()) {
                    C17213mb2.a.f("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(1))));
                    c10304bQ7.c1(str3);
                } else {
                    C17213mb2.a.f("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(2))));
                    PQ pqA = ip.a();
                    AbstractC13042fc3.h(pqA, "getResult(...)");
                    c10304bQ7.e1(pqA);
                }
            }
            C10304bQ7 c10304bQ72 = C10304bQ7.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, thE.getMessage());
                C17213mb2.a.f("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(0))));
                InterfaceC9336Zm4 interfaceC9336Zm4 = c10304bQ72.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, new XP7.a(LP.a.a(thE, EnumC10415ba2.a))));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10304bQ7(C15346jR c15346jR, MQ mq, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC21014sz3 interfaceC21014sz3, AK6 ak6, final androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(mq, "authRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(interfaceC21014sz3, "lifecycleRuntime");
        AbstractC13042fc3.i(ak6, "startPhoneAuthUseCase");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = c15346jR;
        this.c = mq;
        this.d = interfaceC3570Bk5;
        this.e = interfaceC21014sz3;
        this.f = ak6;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(XP7.b.c);
        this.g = interfaceC9336Zm4A;
        this.h = interfaceC9336Zm4A;
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aQ7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10304bQ7.Z0(yVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Z0(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        String str = (String) yVar.c("ARG_KEY_CODE_FROM_TELEGRAM");
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(String str) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(str, null), 2, null);
    }

    private final void d1() {
        String name;
        try {
            String version = this.e.getVersion();
            if (version != null && version.length() != 0) {
                String strK = new C20644sM5("-").k(version, "");
                String strSubstring = strK.substring(AbstractC20762sZ6.l0(strK, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(strK, Separators.RPAREN, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                C17213mb2.i("First_version_displayed", strSubstring + " signIn");
            }
        } catch (Exception e) {
            if (C10304bQ7.class.isAnonymousClass()) {
                name = C10304bQ7.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C10304bQ7.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(PQ pq) {
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.b.f(pq).m0(new InterfaceC24449ye1() { // from class: ir.nasim.YP7
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C10304bQ7.f1(this.a, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.ZP7
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C10304bQ7.g1(this.a, (Exception) obj);
                }
            });
            d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C10304bQ7 c10304bQ7, Boolean bool) {
        Object value;
        AbstractC13042fc3.i(c10304bQ7, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c10304bQ7.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, XP7.e.c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(C10304bQ7 c10304bQ7, Exception exc) {
        Object value;
        LP.b bVar;
        AbstractC13042fc3.i(c10304bQ7, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c10304bQ7.g;
        do {
            value = interfaceC9336Zm4.getValue();
            bVar = LP.a;
            AbstractC13042fc3.f(exc);
        } while (!interfaceC9336Zm4.f(value, new XP7.a(bVar.a(exc, EnumC10415ba2.c))));
    }

    public final String a1() {
        return (String) this.i.getValue();
    }

    public final InterfaceC10258bL6 b1() {
        return this.h;
    }

    public final void h1(long j2, List list, SQ sq) {
        Object value;
        AbstractC13042fc3.i(list, "imeiList");
        AbstractC13042fc3.i(sq, "authSendCodeType");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new XP7.c(false, 1, null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(j2, list, sq, null), 3, null);
    }

    public final void i1(String str, String str2) {
        Object value;
        AbstractC13042fc3.i(str, "transactionHash");
        AbstractC13042fc3.i(str2, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new XP7.c(false, 1, null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str2, str, null), 3, null);
    }
}
