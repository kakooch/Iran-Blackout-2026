package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.pH1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18804pH1 {
    private final C10299bQ2 a;
    private final E84 b;

    /* renamed from: ir.nasim.pH1$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C18804pH1.this.c(0, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    public C18804pH1(C10299bQ2 c10299bQ2, E84 e84) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        this.a = c10299bQ2;
        this.b = e84;
    }

    public final void a(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C10431bb8.a.e(c11458d25.getPeerId(), c11458d25.z(), 6L);
        this.b.s0(c11458d25);
    }

    public final void b(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C10431bb8.a.e(c11458d25.getPeerId(), c11458d25.z(), 6L);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C18804pH1.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.pH1$a r0 = (ir.nasim.C18804pH1.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.pH1$a r0 = new ir.nasim.pH1$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r7 = r8.l()
            goto L92
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            int r7 = r0.b
            java.lang.Object r2 = r0.a
            ir.nasim.pH1 r2 = (ir.nasim.C18804pH1) r2
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L62
        L4b:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.bQ2 r8 = r6.a
            ir.nasim.Nv5 r8 = r8.w2(r7)
            r0.a = r6
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r5, r0, r4, r5)
            if (r8 != r1) goto L61
            return r1
        L61:
            r2 = r6
        L62:
            boolean r8 = ir.nasim.C9475a16.j(r8)
            if (r8 != 0) goto L78
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "leave group failed"
            r7.<init>(r8)
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r7)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            goto Lae
        L78:
            ir.nasim.E84 r8 = r2.b
            ir.nasim.d25 r7 = ir.nasim.C11458d25.y(r7)
            ir.nasim.Nv5 r7 = r8.r0(r7)
            java.lang.String r8 = "deleteChat(...)"
            ir.nasim.AbstractC13042fc3.h(r7, r8)
            r0.a = r5
            r0.e = r3
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r5, r0, r4, r5)
            if (r7 != r1) goto L92
            return r1
        L92:
            boolean r7 = ir.nasim.C9475a16.j(r7)
            if (r7 != 0) goto La8
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "delete chat failed"
            r7.<init>(r8)
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r7)
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            goto Lae
        La8:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
        Lae:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18804pH1.c(int, ir.nasim.rm1):java.lang.Object");
    }
}
