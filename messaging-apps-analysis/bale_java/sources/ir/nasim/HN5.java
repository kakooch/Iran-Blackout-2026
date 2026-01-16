package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public final class HN5 {
    private final C9057Yh4 a;

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
            Object objA = HN5.this.a(0L, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public HN5(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "modules");
        this.a = c9057Yh4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r5, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.HN5.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.HN5$a r0 = (ir.nasim.HN5.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.HN5$a r0 = new ir.nasim.HN5$a
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
            java.lang.Object r5 = r7.l()
            goto L53
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Yh4 r7 = r4.a
            ir.nasim.oe4 r7 = r7.H()
            ir.nasim.Nv5 r5 = r7.l1(r5)
            java.lang.String r6 = "removeMyAvatar(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r6)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L53
            return r1
        L53:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HN5.a(long, ir.nasim.rm1):java.lang.Object");
    }
}
