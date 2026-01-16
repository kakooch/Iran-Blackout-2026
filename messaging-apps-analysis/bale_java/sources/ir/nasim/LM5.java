package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
final class LM5 {
    private final int a;
    private final InterfaceC14603iB2 b;
    private float c;

    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return LM5.this.e(0.0f, this);
        }
    }

    public LM5(int i, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = i;
        this.b = interfaceC14603iB2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(float r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.LM5.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.LM5$a r0 = (ir.nasim.LM5.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.LM5$a r0 = new ir.nasim.LM5$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.LM5 r5 = (ir.nasim.LM5) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.iB2 r6 = r4.b
            java.lang.Float r5 = ir.nasim.AbstractC6392Nk0.c(r5)
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r0 = r5.c
            float r0 = r0 + r6
            r5.c = r0
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LM5.e(float, ir.nasim.rm1):java.lang.Object");
    }

    public final float b() {
        return this.c;
    }

    public final int c(int i) {
        return AbstractC23053wG5.m(i - AbstractC20723sV3.d(this.c), 0, this.a);
    }

    public final void d() {
        this.c = 0.0f;
    }

    public final Object f(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (i > i2) {
            throw new IllegalArgumentException(("Expected min=" + i + " ≤ max=" + i2).toString());
        }
        int i3 = i2 - i;
        int i4 = this.a;
        if (i3 > i4) {
            throw new IllegalArgumentException(("Expected range (" + i3 + ") to be ≤ viewportSize=" + this.a).toString());
        }
        float f = i;
        float f2 = this.c;
        if (f >= f2 && i2 <= i4 + f2) {
            return C19938rB7.a;
        }
        if (f >= f2) {
            i = i2 - i4;
        }
        Object objG = g(i, interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final Object g(float f, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = e(f - this.c, interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }
}
