package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21761u53;
import ir.nasim.C17448mz0;
import ir.nasim.InterfaceC18490ok7;

/* loaded from: classes5.dex */
public final class E53 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final InterfaceC20315ro1 a;
    private final Context b;
    private final C15346jR c;
    private final C4627Fy0 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC21761u53 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21761u53 abstractC21761u53, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC21761u53;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return E53.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 unused = E53.this.d;
                C17448mz0 c17448mz0 = (C17448mz0) C18039nz0.a.d().getValue();
                if (E53.this.i(this.d, c17448mz0.c())) {
                    return C19938rB7.a;
                }
                E53 e53 = E53.this;
                AbstractC21761u53 abstractC21761u53 = this.d;
                long jC = c17448mz0.c();
                C17448mz0.a aVarE = c17448mz0.e();
                this.b = 1;
                obj = e53.h(abstractC21761u53, jC, aVarE, this);
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
            if (((Boolean) obj).booleanValue()) {
                E53.this.d.U(this.d.b());
                return C19938rB7.a;
            }
            C4627Fy0 c4627Fy0 = E53.this.d;
            AbstractC21761u53 abstractC21761u532 = this.d;
            this.b = 2;
            if (c4627Fy0.x1(abstractC21761u532, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return E53.this.h(null, 0L, null, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return E53.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, E53.this.b, true, null, 4, null).b());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public E53(InterfaceC20315ro1 interfaceC20315ro1, Context context, C15346jR c15346jR, C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = interfaceC20315ro1;
        this.b = context;
        this.c = c15346jR;
        this.d = c4627Fy0;
    }

    private final boolean e(AbstractC21761u53 abstractC21761u53) {
        return abstractC21761u53.a() == this.c.p() && !(abstractC21761u53 instanceof AbstractC21761u53.b);
    }

    private final boolean g(long j) {
        return AbstractC20507s76.o() - j > 90000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.AbstractC21761u53 r9, long r10, ir.nasim.C17448mz0.a r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.E53.c
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.E53$c r0 = (ir.nasim.E53.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.E53$c r0 = new ir.nasim.E53$c
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            java.lang.String r3 = "IncomingCallUseCase"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L34
            if (r2 != r5) goto L2c
            ir.nasim.AbstractC10685c16.b(r13)
            goto L6a
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            ir.nasim.AbstractC10685c16.b(r13)
            r6 = -1
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 == 0) goto L4e
            long r6 = r9.b()
            int r9 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r9 == 0) goto L4e
            java.lang.String r9 = "Decline incoming call because I'm busy. im in personal call"
            java.lang.Object[] r10 = new java.lang.Object[r4]
            ir.nasim.C19406qI3.a(r3, r9, r10)
        L4c:
            r4 = r5
            goto L82
        L4e:
            ir.nasim.mz0$a r9 = ir.nasim.C17448mz0.a.g
            if (r12 == r9) goto L7a
            ir.nasim.mz0$a r9 = ir.nasim.C17448mz0.a.e
            if (r12 != r9) goto L57
            goto L7a
        L57:
            ir.nasim.WM3 r9 = ir.nasim.C12366eV1.c()
            ir.nasim.E53$d r10 = new ir.nasim.E53$d
            r11 = 0
            r10.<init>(r11)
            r0.c = r5
            java.lang.Object r13 = ir.nasim.AbstractC9323Zl0.g(r9, r10, r0)
            if (r13 != r1) goto L6a
            return r1
        L6a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r9 = r13.booleanValue()
            if (r9 == 0) goto L82
            java.lang.String r9 = "Decline incoming call because I'm busy. my phone is in call"
            java.lang.Object[] r10 = new java.lang.Object[r4]
            ir.nasim.C19406qI3.a(r3, r9, r10)
            goto L4c
        L7a:
            java.lang.String r9 = "Decline incoming call because I'm busy. im in group call"
            java.lang.Object[] r10 = new java.lang.Object[r4]
            ir.nasim.C19406qI3.a(r3, r9, r10)
            goto L4c
        L82:
            java.lang.Boolean r9 = ir.nasim.AbstractC6392Nk0.a(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.E53.h(ir.nasim.u53, long, ir.nasim.mz0$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(AbstractC21761u53 abstractC21761u53, long j) {
        if (abstractC21761u53.b() == j) {
            C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because I'm already in this call.", new Object[0]);
            return true;
        }
        if (e(abstractC21761u53)) {
            C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because I'm starter.", new Object[0]);
            return true;
        }
        if (!g(abstractC21761u53.d())) {
            return false;
        }
        C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because it is expired.", new Object[0]);
        return true;
    }

    public final InterfaceC13730gj3 f(AbstractC21761u53 abstractC21761u53) {
        AbstractC13042fc3.i(abstractC21761u53, "incomingCall");
        return AbstractC10533bm0.d(this.a, null, null, new b(abstractC21761u53, null), 3, null);
    }
}
