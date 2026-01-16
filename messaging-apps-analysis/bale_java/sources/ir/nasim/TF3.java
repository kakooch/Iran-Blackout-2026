package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public final class TF3 {
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
            return TF3.this.a(this);
        }
    }

    public TF3(int i, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = i;
        this.b = interfaceC11621dJ7;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.TF3.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.TF3$a r0 = (ir.nasim.TF3.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.TF3$a r0 = new ir.nasim.TF3$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            r5.l()
            goto L46
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.dJ7 r5 = r4.b
            int r2 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.o(r2, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TF3.a(ir.nasim.rm1):java.lang.Object");
    }
}
