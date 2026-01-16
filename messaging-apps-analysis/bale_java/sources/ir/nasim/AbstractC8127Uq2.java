package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Uq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC8127Uq2 {

    /* renamed from: ir.nasim.Uq2$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC8127Uq2.c(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Uq2$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC15796kB2 b;

        /* renamed from: ir.nasim.Uq2$b$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return b.this.b(null, this);
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC15796kB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r9, ir.nasim.InterfaceC20295rm1 r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof ir.nasim.AbstractC8127Uq2.b.a
                if (r0 == 0) goto L13
                r0 = r10
                ir.nasim.Uq2$b$a r0 = (ir.nasim.AbstractC8127Uq2.b.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Uq2$b$a r0 = new ir.nasim.Uq2$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L54
                if (r2 == r5) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.d
                ir.nasim.j96 r9 = (ir.nasim.C15190j96) r9
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L34
                goto L88
            L34:
                r10 = move-exception
                goto L92
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                ir.nasim.AbstractC10685c16.b(r10)
                goto Lac
            L46:
                java.lang.Object r9 = r0.e
                ir.nasim.Gq2 r9 = (ir.nasim.InterfaceC4806Gq2) r9
                java.lang.Object r2 = r0.d
                ir.nasim.Uq2$b r2 = (ir.nasim.AbstractC8127Uq2.b) r2
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L52
                goto L67
            L52:
                r9 = move-exception
                goto L98
            L54:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.Fq2 r10 = r8.a     // Catch: java.lang.Throwable -> L96
                r0.d = r8     // Catch: java.lang.Throwable -> L96
                r0.e = r9     // Catch: java.lang.Throwable -> L96
                r0.b = r5     // Catch: java.lang.Throwable -> L96
                java.lang.Object r10 = r10.b(r9, r0)     // Catch: java.lang.Throwable -> L96
                if (r10 != r1) goto L66
                return r1
            L66:
                r2 = r8
            L67:
                ir.nasim.j96 r10 = new ir.nasim.j96
                ir.nasim.do1 r4 = r0.getContext()
                r10.<init>(r9, r4)
                ir.nasim.kB2 r9 = r2.b     // Catch: java.lang.Throwable -> L8e
                r0.d = r10     // Catch: java.lang.Throwable -> L8e
                r0.e = r6     // Catch: java.lang.Throwable -> L8e
                r0.b = r3     // Catch: java.lang.Throwable -> L8e
                r2 = 6
                ir.nasim.Y73.c(r2)     // Catch: java.lang.Throwable -> L8e
                java.lang.Object r9 = r9.q(r10, r6, r0)     // Catch: java.lang.Throwable -> L8e
                r0 = 7
                ir.nasim.Y73.c(r0)     // Catch: java.lang.Throwable -> L8e
                if (r9 != r1) goto L87
                return r1
            L87:
                r9 = r10
            L88:
                r9.releaseIntercepted()
                ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                return r9
            L8e:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L92:
                r9.releaseIntercepted()
                throw r10
            L96:
                r9 = move-exception
                r2 = r8
            L98:
                ir.nasim.up7 r10 = new ir.nasim.up7
                r10.<init>(r9)
                ir.nasim.kB2 r2 = r2.b
                r0.d = r9
                r0.e = r6
                r0.b = r4
                java.lang.Object r10 = ir.nasim.AbstractC8127Uq2.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lac
                return r1
            Lac:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8127Uq2.b.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Uq2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ InterfaceC4557Fq2 b;

        /* renamed from: ir.nasim.Uq2$c$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;
            Object f;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return c.this.b(null, this);
            }
        }

        public c(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC14603iB2;
            this.b = interfaceC4557Fq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r7, ir.nasim.InterfaceC20295rm1 r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof ir.nasim.AbstractC8127Uq2.c.a
                if (r0 == 0) goto L13
                r0 = r8
                ir.nasim.Uq2$c$a r0 = (ir.nasim.AbstractC8127Uq2.c.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Uq2$c$a r0 = new ir.nasim.Uq2$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                ir.nasim.AbstractC10685c16.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f
                ir.nasim.j96 r7 = (ir.nasim.C15190j96) r7
                java.lang.Object r2 = r0.e
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                java.lang.Object r4 = r0.d
                ir.nasim.Uq2$c r4 = (ir.nasim.AbstractC8127Uq2.c) r4
                ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.j96 r8 = new ir.nasim.j96
                ir.nasim.do1 r2 = r0.getContext()
                r8.<init>(r7, r2)
                ir.nasim.iB2 r2 = r6.a     // Catch: java.lang.Throwable -> L86
                r0.d = r6     // Catch: java.lang.Throwable -> L86
                r0.e = r7     // Catch: java.lang.Throwable -> L86
                r0.f = r8     // Catch: java.lang.Throwable -> L86
                r0.b = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                ir.nasim.Y73.c(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                ir.nasim.Y73.c(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                return r1
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                ir.nasim.Fq2 r7 = r4.b
                r8 = 0
                r0.d = r8
                r0.e = r8
                r0.f = r8
                r0.b = r3
                java.lang.Object r7 = r7.b(r2, r0)
                if (r7 != r1) goto L83
                return r1
            L83:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            L86:
                r7 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
            L8a:
                r7.releaseIntercepted()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8127Uq2.c.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    public static final void b(InterfaceC4806Gq2 interfaceC4806Gq2) {
        if (interfaceC4806Gq2 instanceof C22199up7) {
            throw ((C22199up7) interfaceC4806Gq2).a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.InterfaceC4806Gq2 r4, ir.nasim.InterfaceC15796kB2 r5, java.lang.Throwable r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.AbstractC8127Uq2.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Uq2$a r0 = (ir.nasim.AbstractC8127Uq2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Uq2$a r0 = new ir.nasim.Uq2$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L46
        L2e:
            r4 = move-exception
            goto L49
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r6     // Catch: java.lang.Throwable -> L2e
            r0.c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.q(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            ir.nasim.AbstractC16041kc2.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8127Uq2.c(ir.nasim.Gq2, ir.nasim.kB2, java.lang.Throwable, ir.nasim.rm1):java.lang.Object");
    }

    public static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
        return new b(interfaceC4557Fq2, interfaceC15796kB2);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return new c(interfaceC14603iB2, interfaceC4557Fq2);
    }
}
