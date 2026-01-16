package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* renamed from: ir.nasim.rR, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20074rR implements InterfaceC19483qR {
    private static final a d = new a(null);
    private final C12328eR a;
    private final InterfaceC19699qn4 b;
    private HashMap c;

    /* renamed from: ir.nasim.rR$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rR$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.a(this);
        }
    }

    /* renamed from: ir.nasim.rR$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.c(this);
        }
    }

    /* renamed from: ir.nasim.rR$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.b(null, this);
        }
    }

    /* renamed from: ir.nasim.rR$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.d(this);
        }
    }

    /* renamed from: ir.nasim.rR$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.e(null, this);
        }
    }

    /* renamed from: ir.nasim.rR$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.rR$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20074rR.this.g(null, null, this);
        }
    }

    public C20074rR(C12328eR c12328eR) {
        AbstractC13042fc3.i(c12328eR, "encryptedSharedPreferences");
        this.a = c12328eR;
        this.b = AbstractC20899sn4.b(false, 1, null);
        this.c = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC19483qR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C20074rR.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.rR$b r0 = (ir.nasim.C20074rR.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.rR$b r0 = new ir.nasim.rR$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qn4 r6 = r5.b
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.a(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            java.util.HashMap r6 = r0.c     // Catch: java.lang.Throwable -> L60
            r6.clear()     // Catch: java.lang.Throwable -> L60
            ir.nasim.eR r6 = r0.a     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = "AUTHENTICATOR_PASSWORD_KEY"
            r6.e(r0)     // Catch: java.lang.Throwable -> L60
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L60
            r1.e(r4)
            return r6
        L60:
            r6 = move-exception
            r1.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC19483qR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.SR r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C20074rR.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.rR$d r0 = (ir.nasim.C20074rR.d) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.rR$d r0 = new ir.nasim.rR$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.c
            ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
            java.lang.Object r1 = r0.b
            ir.nasim.SR r1 = (ir.nasim.SR) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.qn4 r7 = r5.b
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r3
            java.lang.Object r0 = r7.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.HashMap r0 = r0.c     // Catch: java.lang.Throwable -> L60
            r0.remove(r6)     // Catch: java.lang.Throwable -> L60
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L60
            r7.e(r4)
            return r6
        L60:
            r6 = move-exception
            r7.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.b(ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C20074rR.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.rR$c r0 = (ir.nasim.C20074rR.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.rR$c r0 = new ir.nasim.rR$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qn4 r6 = r5.b
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.a(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            ir.nasim.eR r6 = r0.a     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = "AUTHENTICATOR_PASSWORD_KEY"
            r6.e(r0)     // Catch: java.lang.Throwable -> L5b
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L5b
            r1.e(r4)
            return r6
        L5b:
            r6 = move-exception
            r1.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.c(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C20074rR.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.rR$e r0 = (ir.nasim.C20074rR.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.rR$e r0 = new ir.nasim.rR$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qn4 r6 = r5.b
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.a(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            ir.nasim.eR r6 = r0.a     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = "AUTHENTICATOR_PASSWORD_KEY"
            r2 = 2
            java.lang.String r6 = ir.nasim.C12328eR.d(r6, r0, r4, r2, r4)     // Catch: java.lang.Throwable -> L5b
            r1.e(r4)
            return r6
        L5b:
            r6 = move-exception
            r1.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.d(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(ir.nasim.SR r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C20074rR.f
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.rR$f r0 = (ir.nasim.C20074rR.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.rR$f r0 = new ir.nasim.rR$f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.c
            ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
            java.lang.Object r1 = r0.b
            ir.nasim.SR r1 = (ir.nasim.SR) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.qn4 r7 = r5.b
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r3
            java.lang.Object r0 = r7.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.HashMap r0 = r0.c     // Catch: java.lang.Throwable -> L61
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L61
            r7.e(r4)
            return r6
        L61:
            r6 = move-exception
            r7.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.e(ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C20074rR.g
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.rR$g r0 = (ir.nasim.C20074rR.g) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.rR$g r0 = new ir.nasim.rR$g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.c
            ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
            java.lang.Object r1 = r0.b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.qn4 r7 = r5.b
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r3
            java.lang.Object r0 = r7.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            ir.nasim.eR r0 = r0.a     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "AUTHENTICATOR_PASSWORD_KEY"
            r0.f(r1, r6)     // Catch: java.lang.Throwable -> L62
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L62
            r7.e(r4)
            return r6
        L62:
            r6 = move-exception
            r7.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.f(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(java.lang.String r6, ir.nasim.SR r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C20074rR.h
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.rR$h r0 = (ir.nasim.C20074rR.h) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.rR$h r0 = new ir.nasim.rR$h
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.d
            ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
            java.lang.Object r7 = r0.c
            ir.nasim.SR r7 = (ir.nasim.SR) r7
            java.lang.Object r1 = r0.b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.a
            ir.nasim.rR r0 = (ir.nasim.C20074rR) r0
            ir.nasim.AbstractC10685c16.b(r8)
            r8 = r6
            r6 = r1
            goto L5b
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.qn4 r8 = r5.b
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.d = r8
            r0.g = r3
            java.lang.Object r0 = r8.a(r4, r0)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r5
        L5b:
            java.util.HashMap r0 = r0.c     // Catch: java.lang.Throwable -> L66
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L66
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L66
            r8.e(r4)
            return r6
        L66:
            r6 = move-exception
            r8.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20074rR.g(java.lang.String, ir.nasim.SR, ir.nasim.rm1):java.lang.Object");
    }
}
