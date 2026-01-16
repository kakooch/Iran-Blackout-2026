package ir.nasim.features.payment.data;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19670qk5;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21557tk5;
import ir.nasim.AbstractC22147uk5;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C19938rB7;
import ir.nasim.C4772Gm4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC23475wz1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;

/* loaded from: classes6.dex */
public final class BankingRepository {
    public static final a c = new a(null);
    public static final int d = 8;
    private final InterfaceC23475wz1 a;
    private final AbstractC13778go1 b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b {
        public static final b a = new b();
        private static final AbstractC19670qk5.a b = AbstractC21557tk5.f("card_otp_request_time");

        private b() {
        }

        public final AbstractC19670qk5.a a() {
            return b;
        }
    }

    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.features.payment.data.BankingRepository$c$a$a, reason: collision with other inner class name */
            public static final class C1182a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1182a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.features.payment.data.BankingRepository.c.a.C1182a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.features.payment.data.BankingRepository$c$a$a r0 = (ir.nasim.features.payment.data.BankingRepository.c.a.C1182a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.features.payment.data.BankingRepository$c$a$a r0 = new ir.nasim.features.payment.data.BankingRepository$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.qk5 r5 = (ir.nasim.AbstractC19670qk5) r5
                    ir.nasim.features.payment.data.BankingRepository$b r2 = ir.nasim.features.payment.data.BankingRepository.b.a
                    ir.nasim.qk5$a r2 = r2.a()
                    java.lang.Object r5 = r5.b(r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.data.BankingRepository.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ((C4772Gm4) this.c).j(b.a.a(), this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public BankingRepository(InterfaceC23475wz1 interfaceC23475wz1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC23475wz1, "dataStore");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC23475wz1;
        this.b = abstractC13778go1;
    }

    public final Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC6459Nq2.G(AbstractC6459Nq2.V(AbstractC6459Nq2.X(new c(this.a.getData()), new BankingRepository$getCardOtpRequestTimePair$3(null)), this.b), interfaceC20295rm1);
    }

    public final Object b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(this.a, new d(str, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
