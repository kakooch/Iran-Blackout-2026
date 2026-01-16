package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.List;

/* renamed from: ir.nasim.f30, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12697f30 {
    private final int a;
    private final InterfaceC11463d30 b;
    private final InterfaceC20315ro1 c;
    private final BJ d;
    private final C21254tN3 e;
    private final InterfaceC4557Fq2 f;

    /* renamed from: ir.nasim.f30$a */
    public interface a {
        static /* synthetic */ C12697f30 a(a aVar, InterfaceC11463d30 interfaceC11463d30, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if ((i2 & 2) != 0) {
                i = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            }
            return aVar.b(interfaceC11463d30, i);
        }

        C12697f30 b(InterfaceC11463d30 interfaceC11463d30, int i);
    }

    /* renamed from: ir.nasim.f30$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                List listM = AbstractC10360bX0.m();
                this.b = 1;
                if (interfaceC4806Gq2.a(listM, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.f30$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C12697f30 b;

        /* renamed from: ir.nasim.f30$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C12697f30 b;

            /* renamed from: ir.nasim.f30$c$a$a, reason: collision with other inner class name */
            public static final class C1068a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1068a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C12697f30 c12697f30) {
                this.a = interfaceC4806Gq2;
                this.b = c12697f30;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C12697f30.c.a.C1068a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.f30$c$a$a r0 = (ir.nasim.C12697f30.c.a.C1068a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.f30$c$a$a r0 = new ir.nasim.f30$c$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L6f
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.a30 r6 = (ir.nasim.C9489a30) r6
                    ir.nasim.f30 r2 = r5.b
                    ir.nasim.BJ r2 = ir.nasim.C12697f30.b(r2)
                    int r2 = r2.size()
                    ir.nasim.f30 r4 = r5.b
                    int r4 = ir.nasim.C12697f30.a(r4)
                    if (r2 < r4) goto L53
                    ir.nasim.f30 r2 = r5.b
                    ir.nasim.BJ r2 = ir.nasim.C12697f30.b(r2)
                    r2.removeFirst()
                L53:
                    ir.nasim.f30 r2 = r5.b
                    ir.nasim.BJ r2 = ir.nasim.C12697f30.b(r2)
                    r2.addLast(r6)
                    ir.nasim.f30 r6 = r5.b
                    ir.nasim.BJ r6 = ir.nasim.C12697f30.b(r6)
                    java.util.List r6 = ir.nasim.ZW0.m1(r6)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L6f
                    return r1
                L6f:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12697f30.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C12697f30 c12697f30) {
            this.a = interfaceC4557Fq2;
            this.b = c12697f30;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C12697f30(int i, InterfaceC11463d30 interfaceC11463d30, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC11463d30, "bandwidthOptimizer");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = i;
        this.b = interfaceC11463d30;
        this.c = interfaceC20315ro1;
        this.d = new BJ(i);
        C21254tN3 c21254tN3 = new C21254tN3();
        this.e = c21254tN3;
        this.f = AbstractC6459Nq2.m0(AbstractC6459Nq2.c0(new c(AbstractC6459Nq2.F(interfaceC11463d30.b()), this), new b(null)), interfaceC20315ro1, c21254tN3, 1);
    }

    public final boolean c() {
        return this.e.c();
    }
}
