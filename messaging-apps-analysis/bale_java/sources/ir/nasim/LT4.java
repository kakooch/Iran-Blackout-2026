package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class LT4 implements InterfaceC7645Sp2 {
    private final InterfaceC4031Dj7 a;
    private final GT4 b;

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
            return LT4.this.a(null, 0.0f, this);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC8748Xd6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC8748Xd6 interfaceC8748Xd6) {
            super(1);
            this.f = interfaceC8748Xd6;
        }

        public final void a(float f) {
            LT4.this.d().o0(this.f, AbstractC20723sV3.d(LT4.this.d().J() != 0 ? f / LT4.this.d().J() : 0.0f) + LT4.this.d().v());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    public LT4(InterfaceC4031Dj7 interfaceC4031Dj7, GT4 gt4) {
        this.a = interfaceC4031Dj7;
        this.b = gt4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC7645Sp2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC8748Xd6 r6, float r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.LT4.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.LT4$a r0 = (ir.nasim.LT4.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.LT4$a r0 = new ir.nasim.LT4$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.a
            ir.nasim.LT4 r6 = (ir.nasim.LT4) r6
            ir.nasim.AbstractC10685c16.b(r8)
            goto L4b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Dj7 r8 = r5.a
            ir.nasim.LT4$b r2 = new ir.nasim.LT4$b
            r2.<init>(r6)
            r0.a = r5
            r0.d = r3
            java.lang.Object r8 = r8.b(r6, r7, r2, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            r6 = r5
        L4b:
            java.lang.Number r8 = (java.lang.Number) r8
            float r7 = r8.floatValue()
            ir.nasim.GT4 r8 = r6.b
            float r8 = r8.w()
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 != 0) goto L5d
            goto L7d
        L5d:
            ir.nasim.GT4 r8 = r6.b
            float r8 = r8.w()
            float r8 = java.lang.Math.abs(r8)
            double r1 = (double) r8
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L7d
            ir.nasim.GT4 r6 = r6.b
            int r8 = r6.v()
            r1 = 2
            r2 = 0
            ir.nasim.GT4.a0(r6, r8, r0, r1, r2)
            goto L82
        L7d:
            ir.nasim.GT4 r6 = r6.b
            r6.w()
        L82:
            java.lang.Float r6 = ir.nasim.AbstractC6392Nk0.c(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LT4.a(ir.nasim.Xd6, float, ir.nasim.rm1):java.lang.Object");
    }

    public final GT4 d() {
        return this.b;
    }
}
