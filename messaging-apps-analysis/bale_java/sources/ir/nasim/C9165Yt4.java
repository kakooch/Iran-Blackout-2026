package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21761u53;
import ir.nasim.InterfaceC18490ok7;

/* renamed from: ir.nasim.Yt4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9165Yt4 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final Context a;
    private final C15346jR b;
    private final C4627Fy0 c;
    private final C13576gT2 d;

    /* renamed from: ir.nasim.Yt4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Yt4$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9165Yt4.this.d(null, this);
        }
    }

    /* renamed from: ir.nasim.Yt4$c */
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
            return C9165Yt4.this.f(null, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.Yt4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9165Yt4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, C9165Yt4.this.a, true, null, 4, null).b());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C9165Yt4(Context context, C15346jR c15346jR, C4627Fy0 c4627Fy0, C13576gT2 c13576gT2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c13576gT2, "handleIncomingNotificationUseCase");
        this.a = context;
        this.b = c15346jR;
        this.c = c4627Fy0;
        this.d = c13576gT2;
    }

    private final boolean c(AbstractC21761u53 abstractC21761u53) {
        return abstractC21761u53.a() == this.b.p() && !(abstractC21761u53 instanceof AbstractC21761u53.b);
    }

    private final boolean e(long j) {
        return AbstractC20507s76.o() - j > 90000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.AbstractC21761u53 r9, long r10, ir.nasim.C17448mz0.a r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof ir.nasim.C9165Yt4.c
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.Yt4$c r0 = (ir.nasim.C9165Yt4.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Yt4$c r0 = new ir.nasim.Yt4$c
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
            ir.nasim.Yt4$d r10 = new ir.nasim.Yt4$d
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9165Yt4.f(ir.nasim.u53, long, ir.nasim.mz0$a, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean g(AbstractC21761u53 abstractC21761u53, long j) {
        if (abstractC21761u53.b() == j) {
            C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because I'm already in this call.", new Object[0]);
            return true;
        }
        if (c(abstractC21761u53)) {
            C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because I'm starter.", new Object[0]);
            return true;
        }
        if (!e(abstractC21761u53.d())) {
            return false;
        }
        C19406qI3.a("IncomingCallUseCase", "Ignore incoming call because it is expired.", new Object[0]);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.AbstractC21761u53 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9165Yt4.d(ir.nasim.u53, ir.nasim.rm1):java.lang.Object");
    }
}
