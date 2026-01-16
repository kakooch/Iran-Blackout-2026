package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class HG2 {
    private final InterfaceC22366v68 a;

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
            Object objA = HG2.this.a(null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public HG2(InterfaceC22366v68 interfaceC22366v68) {
        AbstractC13042fc3.i(interfaceC22366v68, "webAppRepository");
        this.a = interfaceC22366v68;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.T68 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.HG2.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.HG2$a r0 = (ir.nasim.HG2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.HG2$a r0 = new ir.nasim.HG2$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L5f
            if (r2 == r6) goto L55
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto La9
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto L97
        L4b:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto L85
        L55:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto L73
        L5f:
            ir.nasim.AbstractC10685c16.b(r9)
            boolean r9 = r8 instanceof ir.nasim.T68.d
            if (r9 == 0) goto L74
            ir.nasim.v68 r9 = r7.a
            ir.nasim.T68$d r8 = (ir.nasim.T68.d) r8
            r0.c = r6
            java.lang.Object r8 = r9.f(r8, r0)
            if (r8 != r1) goto L73
            return r1
        L73:
            return r8
        L74:
            boolean r9 = r8 instanceof ir.nasim.T68.b
            if (r9 == 0) goto L86
            ir.nasim.v68 r9 = r7.a
            ir.nasim.T68$b r8 = (ir.nasim.T68.b) r8
            r0.c = r5
            java.lang.Object r8 = r9.b(r8, r0)
            if (r8 != r1) goto L85
            return r1
        L85:
            return r8
        L86:
            boolean r9 = r8 instanceof ir.nasim.T68.c
            if (r9 == 0) goto L98
            ir.nasim.v68 r9 = r7.a
            ir.nasim.T68$c r8 = (ir.nasim.T68.c) r8
            r0.c = r4
            java.lang.Object r8 = r9.e(r8, r0)
            if (r8 != r1) goto L97
            return r1
        L97:
            return r8
        L98:
            boolean r9 = r8 instanceof ir.nasim.T68.a
            if (r9 == 0) goto Laa
            ir.nasim.v68 r9 = r7.a
            ir.nasim.T68$a r8 = (ir.nasim.T68.a) r8
            r0.c = r3
            java.lang.Object r8 = r9.d(r8, r0)
            if (r8 != r1) goto La9
            return r1
        La9:
            return r8
        Laa:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HG2.a(ir.nasim.T68, ir.nasim.rm1):java.lang.Object");
    }
}
