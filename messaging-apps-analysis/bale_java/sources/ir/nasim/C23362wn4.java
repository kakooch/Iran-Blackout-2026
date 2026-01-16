package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.wn4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23362wn4 extends YT4 {
    private final C23952xn4 b;

    /* renamed from: ir.nasim.wn4$a */
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
            return C23362wn4.this.f(null, this);
        }
    }

    public C23362wn4(C23952xn4 c23952xn4) {
        AbstractC13042fc3.i(c23952xn4, "mutualGroupRepository");
        this.b = c23952xn4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r4, ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof ir.nasim.C23362wn4.a
            if (r4 == 0) goto L13
            r4 = r5
            ir.nasim.wn4$a r4 = (ir.nasim.C23362wn4.a) r4
            int r0 = r4.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.c = r0
            goto L18
        L13:
            ir.nasim.wn4$a r4 = new ir.nasim.wn4$a
            r4.<init>(r5)
        L18:
            java.lang.Object r5 = r4.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            ir.nasim.AbstractC10685c16.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.xn4 r5 = r3.b
            r4.c = r2
            java.lang.Object r5 = r5.d(r4)
            if (r5 != r0) goto L3f
            return r0
        L3f:
            java.util.List r5 = (java.util.List) r5
            ir.nasim.YT4$b$c r4 = new ir.nasim.YT4$b$c
            r0 = 0
            r4.<init>(r5, r0, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23362wn4.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return Boolean.FALSE;
    }
}
