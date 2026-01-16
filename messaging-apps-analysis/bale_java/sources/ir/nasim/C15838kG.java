package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.kG, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15838kG {
    private final C4627Fy0 a;

    /* renamed from: ir.nasim.kG$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C15838kG.this.a(null, this);
        }
    }

    public C15838kG(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = c4627Fy0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.C22376v78 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C15838kG.a
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.kG$a r0 = (ir.nasim.C15838kG.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.kG$a r0 = new ir.nasim.kG$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 10
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r10 = r0.b
            ir.nasim.v78 r10 = (ir.nasim.C22376v78) r10
            java.lang.Object r0 = r0.a
            ir.nasim.kG r0 = (ir.nasim.C15838kG) r0
            ir.nasim.AbstractC10685c16.b(r11)
            goto L89
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            ir.nasim.AbstractC10685c16.b(r11)
            java.util.List r11 = r10.a()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L4b
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        L4b:
            ir.nasim.Fy0 r11 = r9.a
            java.util.List r2 = r10.a()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = ir.nasim.ZW0.x(r2, r3)
            r5.<init>(r6)
            java.util.Iterator r2 = r2.iterator()
        L60:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L7b
            java.lang.Object r6 = r2.next()
            ir.nasim.G26 r6 = (ir.nasim.G26) r6
            ir.nasim.d25 r7 = new ir.nasim.d25
            ir.nasim.W25 r8 = ir.nasim.W25.a
            int r6 = r6.b()
            r7.<init>(r8, r6)
            r5.add(r7)
            goto L60
        L7b:
            r0.a = r9
            r0.b = r10
            r0.e = r4
            java.lang.Object r11 = r11.A1(r5, r0)
            if (r11 != r1) goto L88
            return r1
        L88:
            r0 = r9
        L89:
            ir.nasim.Fy0 r11 = r0.a
            java.util.List r10 = r10.a()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = ir.nasim.ZW0.x(r10, r3)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        L9e:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto Lc4
            java.lang.Object r1 = r10.next()
            ir.nasim.G26 r1 = (ir.nasim.G26) r1
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r1.a()
            r6 = 90000(0x15f90, double:4.4466E-319)
            long r4 = r4 + r6
            long r4 = r4 - r2
            ir.nasim.ve3 r2 = new ir.nasim.ve3
            int r1 = r1.b()
            r2.<init>(r1, r4)
            r0.add(r2)
            goto L9e
        Lc4:
            r11.m1(r0)
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15838kG.a(ir.nasim.v78, ir.nasim.rm1):java.lang.Object");
    }
}
