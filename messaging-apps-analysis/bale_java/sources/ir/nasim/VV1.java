package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
final class VV1 implements InterfaceC4557Fq2 {
    private final InterfaceC4557Fq2 a;
    public final UA2 b;
    public final InterfaceC14603iB2 c;

    static final class a implements InterfaceC4806Gq2 {
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ InterfaceC4806Gq2 c;

        /* renamed from: ir.nasim.VV1$a$a, reason: collision with other inner class name */
        static final class C0705a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int c;

            C0705a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return a.this.a(null, this);
            }
        }

        a(C12889fL5 c12889fL5, InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.b = c12889fL5;
            this.c = interfaceC4806Gq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof ir.nasim.VV1.a.C0705a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.VV1$a$a r0 = (ir.nasim.VV1.a.C0705a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.VV1$a$a r0 = new ir.nasim.VV1$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r7)
                goto L67
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.VV1 r7 = ir.nasim.VV1.this
                ir.nasim.UA2 r7 = r7.b
                java.lang.Object r7 = r7.invoke(r6)
                ir.nasim.fL5 r2 = r5.b
                java.lang.Object r2 = r2.a
                ir.nasim.i47 r4 = ir.nasim.AbstractC12225eF4.a
                if (r2 == r4) goto L58
                ir.nasim.VV1 r4 = ir.nasim.VV1.this
                ir.nasim.iB2 r4 = r4.c
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L55
                goto L58
            L55:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L58:
                ir.nasim.fL5 r2 = r5.b
                r2.a = r7
                ir.nasim.Gq2 r7 = r5.c
                r0.c = r3
                java.lang.Object r6 = r7.a(r6, r0)
                if (r6 != r1) goto L67
                return r1
            L67:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VV1.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    public VV1(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC4557Fq2;
        this.b = ua2;
        this.c = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = AbstractC12225eF4.a;
        Object objB = this.a.b(new a(c12889fL5, interfaceC4806Gq2), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }
}
