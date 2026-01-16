package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Tw4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7949Tw4 extends VW7 {
    private final InterfaceC3570Bk5 b;
    private final InterfaceC3570Bk5 c;
    private final C15346jR d;
    private final MQ e;
    private final AK6 f;
    private final C12328eR g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;
    private List j;

    /* renamed from: ir.nasim.Tw4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7949Tw4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            U75 u75;
            Object value;
            SB6 sb6;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String strE = C7949Tw4.this.b.e("PREF_KEY_COUNTRY_CODE");
            String string = C7949Tw4.this.b.getString("PREF_KEY_COUNTRY_NAME", "");
            String string2 = C7949Tw4.this.c.getString("PREF_KEY_PHONE_NUMBER", "");
            if (strE != null) {
                AbstractC13042fc3.f(string);
                AbstractC13042fc3.f(string2);
                u75 = new U75(strE, string, string2);
            } else {
                u75 = new U75(null, null, null, 7, null);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C7949Tw4.this.h;
            do {
                value = interfaceC9336Zm4.getValue();
                sb6 = (SB6) value;
            } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : null, (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : u75, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tw4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ List e;
        final /* synthetic */ SQ f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, List list, SQ sq, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = list;
            this.f = sq;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7949Tw4.this.new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AK6 ak6 = C7949Tw4.this.f;
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
            C7949Tw4 c7949Tw4 = C7949Tw4.this;
            if (C9475a16.j(objA)) {
                c7949Tw4.h1((TQ) objA);
            }
            C7949Tw4 c7949Tw42 = C7949Tw4.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                c7949Tw42.g1(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tw4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C7949Tw4.this.new c(this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            InterfaceC20315ro1 interfaceC20315ro1;
            String name;
            Object value;
            SB6 sb6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                MQ mq = C7949Tw4.this.e;
                String str = this.e;
                List listB = C7949Tw4.this.g.b();
                this.c = interfaceC20315ro12;
                this.b = 1;
                objG = mq.g("", str, listB, true, this);
                if (objG == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C7949Tw4 c7949Tw4 = C7949Tw4.this;
            if (C9475a16.j(objG)) {
                IP ip = (IP) objG;
                if (ip.b()) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c7949Tw4.h;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        sb6 = (SB6) value;
                    } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : new LP.a(null, null, null, true, EnumC10415ba2.b, null, 7, null), (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
                } else {
                    C17213mb2.a.f("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(2))));
                    c7949Tw4.c1(ip);
                }
            }
            C7949Tw4 c7949Tw42 = C7949Tw4.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                c7949Tw42.i1(thE);
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
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C7949Tw4(InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC3570Bk5 interfaceC3570Bk52, C15346jR c15346jR, MQ mq, AK6 ak6, C12328eR c12328eR) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(interfaceC3570Bk52, "sharedPreferences");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(mq, "authRepository");
        AbstractC13042fc3.i(ak6, "startPhoneAuthUseCase");
        AbstractC13042fc3.i(c12328eR, "encryptedSharedPreferences");
        this.b = interfaceC3570Bk5;
        this.c = interfaceC3570Bk52;
        this.d = c15346jR;
        this.e = mq;
        this.f = ak6;
        this.g = c12328eR;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new SB6(false, false, null, 0L, null, null, null, 0L, null, 0L, 1023, null));
        this.h = interfaceC9336Zm4A;
        this.i = interfaceC9336Zm4A;
        j1();
        this.j = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(IP ip) {
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.d.f(ip.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Rw4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C7949Tw4.d1(this.a, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Sw4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C7949Tw4.e1(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(C7949Tw4 c7949Tw4, Boolean bool) {
        Object value;
        SB6 sb6;
        AbstractC13042fc3.i(c7949Tw4, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c7949Tw4.h;
        do {
            value = interfaceC9336Zm4.getValue();
            sb6 = (SB6) value;
        } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : true, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : LP.c.b, (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
        c7949Tw4.m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(C7949Tw4 c7949Tw4, Exception exc) {
        Object value;
        SB6 sb6;
        LP.b bVar;
        String name;
        AbstractC13042fc3.i(c7949Tw4, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c7949Tw4.h;
        do {
            value = interfaceC9336Zm4.getValue();
            sb6 = (SB6) value;
            bVar = LP.a;
            AbstractC13042fc3.f(exc);
        } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : bVar.a(exc, EnumC10415ba2.c), (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
        c7949Tw4.i1(exc);
        if (C7949Tw4.class.isAnonymousClass()) {
            name = C7949Tw4.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C7949Tw4.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.b(name, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(Throwable th) {
        Object value;
        SB6 sb6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            sb6 = (SB6) value;
        } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : LP.a.a(th, EnumC10415ba2.b), (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(TQ tq) {
        Object value;
        SB6 sb6;
        l1(this.b, tq);
        if (tq.a() == SP.d) {
            s1(tq.h());
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            sb6 = (SB6) value;
        } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : false, (991 & 4) != 0 ? sb6.c : LP.c.b, (991 & 8) != 0 ? sb6.d : 0L, (991 & 16) != 0 ? sb6.e : tq.h(), (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : tq.g(), (991 & 128) != 0 ? sb6.h : tq.c(), (991 & 256) != 0 ? sb6.i : tq.e(), (991 & 512) != 0 ? sb6.j : tq.f())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(Throwable th) {
        if ((th instanceof RpcException) && AbstractC13042fc3.d(((RpcException) th).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "FUTURE_TOKEN_INVALID")) {
            p1(this, ((SB6) this.h.getValue()).i(), this.b.getLong("PREF_KET_FULL_NUMBER", 0L), this.j, null, 8, null);
        } else {
            g1(th);
        }
    }

    private final InterfaceC13730gj3 j1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(null), 2, null);
    }

    private final InterfaceC3570Bk5 k1(U75 u75, long j) {
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.b;
        interfaceC3570Bk5.putString("PREF_KEY_COUNTRY_CODE", u75.a());
        interfaceC3570Bk5.putString("PREF_KEY_COUNTRY_NAME", u75.b());
        this.c.putString("PREF_KEY_PHONE_NUMBER", u75.c());
        interfaceC3570Bk5.putLong("PREF_KET_FULL_NUMBER", j);
        return interfaceC3570Bk5;
    }

    private final void l1(InterfaceC3570Bk5 interfaceC3570Bk5, TQ tq) {
        interfaceC3570Bk5.putLong("PREF_KEY_SEND_CODE_TIME", tq.c());
        interfaceC3570Bk5.putLong("PREF_KEY_SEND_NEXT_CODE_TIME", tq.f());
        interfaceC3570Bk5.putString("PREF_KEY_TRANSACTION_HASH", tq.h());
        KS2 ks2 = new KS2();
        interfaceC3570Bk5.putString("PREF_KEY_SEND_CODE_TYPE", ks2.t(tq.g()));
        interfaceC3570Bk5.putString("PREF_KEY_SEND_NEXT_CODE_TYPE", ks2.t(tq.e()));
    }

    private final void m1() {
        String name;
        try {
            String version = AbstractC20507s76.d.getVersion();
            if (version != null && version.length() != 0) {
                String strK = new C20644sM5("-").k(version, "");
                String strSubstring = strK.substring(AbstractC20762sZ6.l0(strK, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(strK, Separators.RPAREN, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                C17213mb2.i("First_version_displayed", strSubstring + " signIn");
            }
        } catch (Exception e) {
            if (C7949Tw4.class.isAnonymousClass()) {
                name = C7949Tw4.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C7949Tw4.class.getSimpleName();
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

    public static /* synthetic */ void p1(C7949Tw4 c7949Tw4, U75 u75, long j, List list, SQ sq, int i, Object obj) {
        if ((i & 8) != 0) {
            sq = SQ.b;
        }
        c7949Tw4.o1(u75, j, list, sq);
    }

    private final void q1(long j, List list, SQ sq) {
        Object value;
        SB6 sb6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            sb6 = (SB6) value;
        } while (!interfaceC9336Zm4.f(value, sb6.a((991 & 1) != 0 ? sb6.a : false, (991 & 2) != 0 ? sb6.b : true, (991 & 4) != 0 ? sb6.c : LP.c.b, (991 & 8) != 0 ? sb6.d : j, (991 & 16) != 0 ? sb6.e : null, (991 & 32) != 0 ? sb6.f : null, (991 & 64) != 0 ? sb6.g : null, (991 & 128) != 0 ? sb6.h : 0L, (991 & 256) != 0 ? sb6.i : null, (991 & 512) != 0 ? sb6.j : 0L)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(j, list, sq, null), 3, null);
    }

    private final InterfaceC13730gj3 s1(String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(str, null), 3, null);
    }

    public final InterfaceC10258bL6 f1() {
        return this.i;
    }

    public final void o1(U75 u75, long j, List list, SQ sq) {
        AbstractC13042fc3.i(u75, "phoneData");
        AbstractC13042fc3.i(sq, "authType");
        this.j = list == null ? AbstractC10360bX0.m() : list;
        k1(u75, j);
        q1(j, list, sq);
    }
}
