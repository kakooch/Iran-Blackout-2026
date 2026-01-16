package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.gu6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13843gu6 {
    private final C4627Fy0 a;

    /* renamed from: ir.nasim.gu6$a */
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
            Object objA = C13843gu6.this.a(0L, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public C13843gu6(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = c4627Fy0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r5, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C13843gu6.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.gu6$a r0 = (ir.nasim.C13843gu6.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.gu6$a r0 = new ir.nasim.gu6$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Fy0 r8 = r4.a
            r0.c = r3
            java.lang.Object r5 = r8.k1(r5, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13843gu6.a(long, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
