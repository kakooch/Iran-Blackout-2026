package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class RB6 {
    private static final a d = new a(null);
    public static final int e = 8;
    private final C9057Yh4 a;
    private final InterfaceC3570Bk5 b;
    private final MQ c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return RB6.this.a(this);
        }
    }

    public RB6(C9057Yh4 c9057Yh4, InterfaceC3570Bk5 interfaceC3570Bk5, MQ mq) {
        AbstractC13042fc3.i(c9057Yh4, "modules");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(mq, "authRepository");
        this.a = c9057Yh4;
        this.b = interfaceC3570Bk5;
        this.c = mq;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.RB6.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.RB6$b r0 = (ir.nasim.RB6.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.RB6$b r0 = new ir.nasim.RB6$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.a
            ir.nasim.RB6 r0 = (ir.nasim.RB6) r0
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L4c
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L3b:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.MQ r5 = r4.c
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.k(r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            boolean r1 = ir.nasim.C9475a16.j(r5)
            if (r1 == 0) goto L6d
            r1 = r5
            ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
            ir.nasim.Bk5 r1 = r0.b
            java.lang.String r2 = "push.google.token"
            java.lang.String r1 = r1.e(r2)
            if (r1 == 0) goto L68
            ir.nasim.Yh4 r2 = r0.a
            ir.nasim.mz5 r2 = r2.P()
            r2.G(r1)
        L68:
            ir.nasim.Yh4 r0 = r0.a
            r0.k0()
        L6d:
            java.lang.Throwable r5 = ir.nasim.C9475a16.e(r5)
            if (r5 == 0) goto L7a
            java.lang.String r0 = "SignOutUseCase"
            java.lang.String r1 = "Failed to logout"
            ir.nasim.C19406qI3.c(r0, r1, r5)
        L7a:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.RB6.a(ir.nasim.rm1):java.lang.Object");
    }
}
