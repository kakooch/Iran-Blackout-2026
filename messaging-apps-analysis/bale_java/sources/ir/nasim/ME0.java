package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
final class ME0 implements LE0 {
    private final InterfaceC4557Fq2 a;

    static final class a implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC4806Gq2 a;

        /* renamed from: ir.nasim.ME0$a$a, reason: collision with other inner class name */
        static final class C0494a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int c;

            C0494a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return a.this.a(null, this);
            }
        }

        a(InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.a = interfaceC4806Gq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof ir.nasim.ME0.a.C0494a
                if (r0 == 0) goto L13
                r0 = r6
                ir.nasim.ME0$a$a r0 = (ir.nasim.ME0.a.C0494a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.ME0$a$a r0 = new ir.nasim.ME0$a$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r6)
                goto L46
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.do1 r6 = r0.getContext()
                ir.nasim.AbstractC19067pj3.n(r6)
                ir.nasim.Gq2 r6 = r4.a
                r0.c = r3
                java.lang.Object r5 = r6.a(r5, r0)
                if (r5 != r1) goto L46
                return r1
            L46:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ME0.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    public ME0(InterfaceC4557Fq2 interfaceC4557Fq2) {
        this.a = interfaceC4557Fq2;
    }

    @Override // ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }
}
