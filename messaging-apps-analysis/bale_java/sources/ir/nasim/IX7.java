package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public final class IX7 {
    private final LX6 a;
    private final MX6 b;
    private final ES6 c;

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
            return IX7.this.c(null, this);
        }
    }

    public IX7(LX6 lx6, MX6 mx6, ES6 es6) {
        AbstractC13042fc3.i(lx6, "storyWidgetLocalDataSource");
        AbstractC13042fc3.i(mx6, "storyWidgetRemoteDataSource");
        AbstractC13042fc3.i(es6, "storyPreferences");
        this.a = lx6;
        this.b = mx6;
        this.c = es6;
    }

    public final Object a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.a.a(j, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final int b() {
        return this.c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.QQ6 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.IX7.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.IX7$a r0 = (ir.nasim.IX7.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.IX7$a r0 = new ir.nasim.IX7$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.a
            java.util.List r8 = (java.util.List) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L9c
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.a
            ir.nasim.IX7 r8 = (ir.nasim.IX7) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L8a
        L44:
            java.lang.Object r8 = r0.b
            ir.nasim.QQ6 r8 = (ir.nasim.QQ6) r8
            java.lang.Object r2 = r0.a
            ir.nasim.IX7 r2 = (ir.nasim.IX7) r2
            ir.nasim.AbstractC10685c16.b(r9)
            r6 = r9
            r9 = r8
            r8 = r2
            r2 = r6
            goto L6d
        L54:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.LX6 r9 = r7.a
            java.lang.String r2 = r8.l()
            r0.a = r7
            r0.b = r8
            r0.e = r5
            java.lang.Object r9 = r9.b(r2, r0)
            if (r9 != r1) goto L6a
            return r1
        L6a:
            r2 = r9
            r9 = r8
            r8 = r7
        L6d:
            java.util.List r2 = (java.util.List) r2
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L7a
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L9f
        L7a:
            ir.nasim.MX6 r2 = r8.b
            r0.a = r8
            r5 = 0
            r0.b = r5
            r0.e = r4
            java.lang.Object r9 = r2.a(r9, r0)
            if (r9 != r1) goto L8a
            return r1
        L8a:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L9e
            ir.nasim.LX6 r8 = r8.a
            r0.a = r9
            r0.e = r3
            java.lang.Object r8 = r8.c(r9, r0)
            if (r8 != r1) goto L9b
            return r1
        L9b:
            r8 = r9
        L9c:
            r2 = r8
            goto L9f
        L9e:
            r2 = r9
        L9f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IX7.c(ir.nasim.QQ6, ir.nasim.rm1):java.lang.Object");
    }

    public final void d(int i) {
        this.c.b(i);
    }
}
