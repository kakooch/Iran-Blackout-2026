package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public final class DG2 {
    private final int a;
    private final InterfaceC11621dJ7 b;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = DG2.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public DG2(int i, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = i;
        this.b = interfaceC11621dJ7;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.DG2.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.DG2$a r0 = (ir.nasim.DG2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.DG2$a r0 = new ir.nasim.DG2$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r7 = r7.l()
            goto L48
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.dJ7 r7 = r6.b
            int r2 = r6.a
            long r4 = (long) r2
            r0.c = r3
            java.lang.Object r7 = r7.i(r4, r0)
            if (r7 != r1) goto L48
            return r1
        L48:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DG2.a(ir.nasim.rm1):java.lang.Object");
    }
}
