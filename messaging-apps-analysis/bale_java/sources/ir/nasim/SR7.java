package ir.nasim;

import ai.bale.proto.SapOuterClass$ResponseTransferMoneyByCard;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.SR7;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.features.payment.data.BankingRepository;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.Map;

/* loaded from: classes6.dex */
public final class SR7 extends VW7 implements InterfaceC24754z90, InterfaceC7274Ra0 {
    private final BankingModule b;
    private final BankingRepository c;
    private final AbstractC13778go1 d;
    private final NR e;
    private InterfaceC14371ho1 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private InterfaceC13730gj3 i;

    public static abstract class a {

        /* renamed from: ir.nasim.SR7$a$a, reason: collision with other inner class name */
        public static final class C0620a extends a {
            public static final C0620a a = new C0620a();

            private C0620a() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0620a);
            }

            public int hashCode() {
                return -423760852;
            }

            public String toString() {
                return "Idle";
            }
        }

        public static final class b extends a {
            public static final b a = new b();

            private b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof b);
            }

            public int hashCode() {
                return 327912332;
            }

            public String toString() {
                return "MakingRequest";
            }
        }

        public static final class c extends a {
            private final int a;

            public c(int i) {
                super(null);
                this.a = i;
            }

            public final int a() {
                return this.a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

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
            return SR7.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BankingRepository bankingRepository = SR7.this.c;
                this.b = 1;
                obj = bankingRepository.a(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Long l = (Long) ((Map) obj).get(this.d);
            if (l == null) {
                return C19938rB7.a;
            }
            long jCurrentTimeMillis = SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER - ((System.currentTimeMillis() - l.longValue()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            if (jCurrentTimeMillis > 0) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = SR7.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, new a.c((int) jCurrentTimeMillis)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ SR7 d;

            /* renamed from: ir.nasim.SR7$c$a$a, reason: collision with other inner class name */
            static final class C0621a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                Object b;
                int c;
                final /* synthetic */ SR7 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0621a(SR7 sr7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = sr7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0621a(this.d, interfaceC20295rm1);
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004c -> B:18:0x004f). Please report as a decompilation issue!!! */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                        int r1 = r6.c
                        r2 = 1
                        if (r1 == 0) goto L1b
                        if (r1 != r2) goto L13
                        java.lang.Object r1 = r6.b
                        ir.nasim.dL5 r1 = (ir.nasim.C11637dL5) r1
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4f
                    L13:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1b:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.SR7 r7 = r6.d
                        ir.nasim.Zm4 r7 = ir.nasim.SR7.W0(r7)
                        java.lang.Object r7 = r7.getValue()
                        ir.nasim.SR7$a r7 = (ir.nasim.SR7.a) r7
                        boolean r1 = r7 instanceof ir.nasim.SR7.a.c
                        if (r1 != 0) goto L31
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    L31:
                        ir.nasim.dL5 r1 = new ir.nasim.dL5
                        r1.<init>()
                        ir.nasim.SR7$a$c r7 = (ir.nasim.SR7.a.c) r7
                        int r7 = r7.a()
                        r1.a = r7
                    L3e:
                        int r7 = r1.a
                        if (r7 <= 0) goto L70
                        r6.b = r1
                        r6.c = r2
                        r3 = 1000(0x3e8, double:4.94E-321)
                        java.lang.Object r7 = ir.nasim.HG1.b(r3, r6)
                        if (r7 != r0) goto L4f
                        return r0
                    L4f:
                        int r7 = r1.a
                        int r7 = r7 + (-1)
                        r1.a = r7
                        ir.nasim.SR7 r7 = r6.d
                        ir.nasim.Zm4 r7 = ir.nasim.SR7.W0(r7)
                    L5b:
                        java.lang.Object r3 = r7.getValue()
                        r4 = r3
                        ir.nasim.SR7$a r4 = (ir.nasim.SR7.a) r4
                        ir.nasim.SR7$a$c r4 = new ir.nasim.SR7$a$c
                        int r5 = r1.a
                        r4.<init>(r5)
                        boolean r3 = r7.f(r3, r4)
                        if (r3 == 0) goto L5b
                        goto L3e
                    L70:
                        ir.nasim.SR7 r7 = r6.d
                        ir.nasim.Zm4 r7 = ir.nasim.SR7.W0(r7)
                    L76:
                        java.lang.Object r0 = r7.getValue()
                        r1 = r0
                        ir.nasim.SR7$a r1 = (ir.nasim.SR7.a) r1
                        ir.nasim.SR7$a$a r1 = ir.nasim.SR7.a.C0620a.a
                        boolean r0 = r7.f(r0, r1)
                        if (r0 == 0) goto L76
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.SR7.c.a.C0621a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0621a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SR7 sr7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = sr7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((a) this.c) instanceof a.c) {
                    InterfaceC13730gj3 interfaceC13730gj3 = this.d.i;
                    if (interfaceC13730gj3 != null) {
                        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                    }
                    SR7 sr7 = this.d;
                    sr7.i = AbstractC10533bm0.d(AbstractC9773aX7.a(sr7), null, null, new C0621a(this.d, null), 3, null);
                } else {
                    InterfaceC13730gj3 interfaceC13730gj32 = this.d.i;
                    if (interfaceC13730gj32 != null) {
                        InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(a aVar, a aVar2) {
            return AbstractC13042fc3.d(aVar.getClass(), aVar2.getClass());
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SR7.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(SR7.this.g, new InterfaceC14603iB2() { // from class: ir.nasim.TR7
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(SR7.c.y((SR7.a) obj2, (SR7.a) obj3));
                    }
                });
                a aVar = new a(SR7.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2W, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SR7.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BankingRepository bankingRepository = SR7.this.c;
                this.b = 1;
                obj = bankingRepository.a(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Map mapA = AbstractC20051rO3.A((Map) obj);
            mapA.put(this.d, AbstractC6392Nk0.e(System.currentTimeMillis()));
            String strT = new KS2().t(mapA);
            BankingRepository bankingRepository2 = SR7.this.c;
            AbstractC13042fc3.f(strT);
            this.b = 2;
            if (bankingRepository2.b(strT, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SR7.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NR nr = SR7.this.e;
                SR sr = SR.a;
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
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = AH0.a;
                BankCreditCard bankCreditCard = new BankCreditCard(null, this.c, null, null, null, this.d, false, BankCreditCard.c.b, false, false, false, 1885, null);
                this.b = 1;
                if (ah0.e(bankCreditCard, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(BankCreditCard bankCreditCard, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bankCreditCard;
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = AH0.a;
                BankCreditCard bankCreditCard = this.c;
                Integer expirationMonth = bankCreditCard.getExpirationMonth();
                AbstractC13042fc3.f(expirationMonth);
                int iIntValue = expirationMonth.intValue();
                Integer expirationYear = this.c.getExpirationYear();
                AbstractC13042fc3.f(expirationYear);
                int iIntValue2 = expirationYear.intValue();
                String str = this.d;
                this.b = 1;
                if (ah0.i(bankCreditCard, iIntValue, iIntValue2, str, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public SR7(BankingModule bankingModule, BankingRepository bankingRepository, AbstractC13778go1 abstractC13778go1, NR nr) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        AbstractC13042fc3.i(bankingRepository, "bankingRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        this.b = bankingModule;
        this.c = bankingRepository;
        this.d = abstractC13778go1;
        this.e = nr;
        this.f = new e(InterfaceC14371ho1.h0);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(a.C0620a.a);
        this.g = interfaceC9336Zm4A;
        this.h = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        a1();
    }

    private final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(SR7 sr7, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(sr7, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "it");
        c7234Qv5.b((String) AbstractC9913am0.b(null, sr7.new f(null), 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e1(final SR7 sr7, final BankCreditCard bankCreditCard, final String str, int i, String str2, final String str3, String str4, String str5, HistoryMessageData historyMessageData, Integer num, String str6, final boolean z, final String str7, String str8) {
        AbstractC13042fc3.i(sr7, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$sourceCard");
        AbstractC13042fc3.i(str, "$destinationCardNumber");
        AbstractC13042fc3.i(str2, "$pin2");
        AbstractC13042fc3.i(str3, "$cvv2");
        AbstractC13042fc3.i(str4, "$approvalCode");
        AbstractC13042fc3.i(str5, "$encrypted");
        AbstractC13042fc3.i(str6, "$description");
        AbstractC13042fc3.i(str7, "$holderName");
        BankingModule bankingModule = sr7.b;
        String id = bankCreditCard.getId();
        AbstractC13042fc3.f(id);
        return bankingModule.R2(GY6.b(id), str, i, str2, str3, "", GY6.b(str4), str5, historyMessageData, num != null ? Long.valueOf(num.intValue()) : null, str6, str8).m0(new InterfaceC24449ye1() { // from class: ir.nasim.RR7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                SR7.f1(z, sr7, str, str7, bankCreditCard, str3, (SapOuterClass$ResponseTransferMoneyByCard) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(boolean z, SR7 sr7, String str, String str2, BankCreditCard bankCreditCard, String str3, SapOuterClass$ResponseTransferMoneyByCard sapOuterClass$ResponseTransferMoneyByCard) {
        AbstractC13042fc3.i(sr7, "this$0");
        AbstractC13042fc3.i(str, "$destinationCardNumber");
        AbstractC13042fc3.i(str2, "$holderName");
        AbstractC13042fc3.i(bankCreditCard, "$sourceCard");
        AbstractC13042fc3.i(str3, "$cvv2");
        if (z) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(sr7), sr7.f, null, new g(str, str2, null), 2, null);
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(sr7), sr7.f, null, new h(bankCreditCard, str3, null), 2, null);
    }

    public final InterfaceC10258bL6 Y0() {
        return this.h;
    }

    public final void Z0(String str) {
        AbstractC13042fc3.i(str, "srcCardNumber");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.d, null, new b(str, null), 2, null);
    }

    public final void b1(String str) {
        AbstractC13042fc3.i(str, "srcCardNumber");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.d, null, new d(str, null), 2, null);
    }

    public final C6517Nv5 c1(final BankCreditCard bankCreditCard, final String str, final int i, final String str2, final String str3, final String str4, final String str5, final String str6, final HistoryMessageData historyMessageData, final Integer num, final boolean z, final String str7) {
        AbstractC13042fc3.i(bankCreditCard, "sourceCard");
        AbstractC13042fc3.i(str, "destinationCardNumber");
        AbstractC13042fc3.i(str2, "approvalCode");
        AbstractC13042fc3.i(str3, "pin2");
        AbstractC13042fc3.i(str4, "cvv2");
        AbstractC13042fc3.i(str5, "holderName");
        AbstractC13042fc3.i(str6, "encrypted");
        AbstractC13042fc3.i(str7, "description");
        C6517Nv5 c6517Nv5H = new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.PR7
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                SR7.d1(this.a, c7234Qv5);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.QR7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return SR7.e1(this.a, bankCreditCard, str, i, str3, str4, str2, str6, historyMessageData, num, str7, z, str5, (String) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void g1(UA2 ua2) {
        Object value;
        AbstractC13042fc3.i(ua2, "update");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, (a) ua2.invoke((a) value)));
    }

    public static final class e extends L0 implements InterfaceC14371ho1 {
        public e(InterfaceC14371ho1.a aVar) {
            super(aVar);
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
        }
    }
}
