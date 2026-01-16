package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.pK7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18837pK7 implements InterfaceC20468s37 {
    private final C14375ho5 a;
    private final Context b;

    /* renamed from: ir.nasim.pK7$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C18837pK7 b;

        /* renamed from: ir.nasim.pK7$a$a, reason: collision with other inner class name */
        public static final class C1443a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C18837pK7 b;

            /* renamed from: ir.nasim.pK7$a$a$a, reason: collision with other inner class name */
            public static final class C1444a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1444a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C1443a.this.a(null, this);
                }
            }

            public C1443a(InterfaceC4806Gq2 interfaceC4806Gq2, C18837pK7 c18837pK7) {
                this.a = interfaceC4806Gq2;
                this.b = c18837pK7;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C18837pK7.a.C1443a.C1444a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.pK7$a$a$a r0 = (ir.nasim.C18837pK7.a.C1443a.C1444a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.pK7$a$a$a r0 = new ir.nasim.pK7$a$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L4e
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    ir.nasim.PI7 r8 = (ir.nasim.PI7) r8
                    ir.nasim.pK7 r2 = r7.b
                    android.content.Context r2 = r2.c()
                    r4 = 4
                    r5 = 0
                    r6 = 0
                    java.lang.String r8 = ir.nasim.C14593iA1.y(r2, r8, r6, r4, r5)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L4e
                    return r1
                L4e:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18837pK7.a.C1443a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, C18837pK7 c18837pK7) {
            this.a = interfaceC4557Fq2;
            this.b = c18837pK7;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C1443a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pK7$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C18837pK7.this.d(0, this);
        }
    }

    /* renamed from: ir.nasim.pK7$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        int e;
        /* synthetic */ Object f;
        int h;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C18837pK7.this.a(null, this);
        }
    }

    public C18837pK7(C14375ho5 c14375ho5, Context context) {
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(context, "context");
        this.a = c14375ho5;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C18837pK7.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.pK7$b r0 = (ir.nasim.C18837pK7.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.pK7$b r0 = new ir.nasim.pK7$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.pK7 r7 = (ir.nasim.C18837pK7) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.ho5 r8 = r6.a
            long r4 = (long) r7
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = r8.F(r4, r0)
            if (r8 != r1) goto L46
            return r1
        L46:
            r7 = r6
        L47:
            ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
            if (r8 == 0) goto L51
            ir.nasim.pK7$a r0 = new ir.nasim.pK7$a
            r0.<init>(r8, r7)
            goto L58
        L51:
            r7 = 0
            java.lang.String[] r7 = new java.lang.String[r7]
            ir.nasim.Fq2 r0 = ir.nasim.AbstractC6459Nq2.U(r7)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18837pK7.d(int, ir.nasim.rm1):java.lang.Object");
    }

    public final Context c() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C17637nI7 r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof ir.nasim.C18837pK7.c
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.pK7$c r2 = (ir.nasim.C18837pK7.c) r2
            int r3 = r2.h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.h = r3
            goto L1c
        L17:
            ir.nasim.pK7$c r2 = new ir.nasim.pK7$c
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.f
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.h
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L49
            if (r4 != r6) goto L41
            int r3 = r2.e
            int r4 = r2.d
            java.lang.Object r7 = r2.c
            ir.nasim.core.modules.profile.entity.Avatar r7 = (ir.nasim.core.modules.profile.entity.Avatar) r7
            java.lang.Object r8 = r2.b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r2.a
            ir.nasim.nI7 r2 = (ir.nasim.C17637nI7) r2
            ir.nasim.AbstractC10685c16.b(r1)
            r10 = r7
        L3e:
            r9 = r8
            r8 = r4
            goto L7a
        L41:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L49:
            ir.nasim.AbstractC10685c16.b(r1)
            int r4 = r17.n0()
            java.lang.String r8 = r17.getName()
            java.lang.String r1 = "getName(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r1)
            ir.nasim.core.modules.profile.entity.Avatar r7 = r17.S()
            int r1 = r17.n0()
            r9 = r17
            r2.a = r9
            r2.b = r8
            r2.c = r7
            r2.d = r4
            r2.e = r5
            r2.h = r6
            java.lang.Object r1 = r0.d(r1, r2)
            if (r1 != r3) goto L76
            return r3
        L76:
            r3 = r5
            r10 = r7
            r2 = r9
            goto L3e
        L7a:
            r12 = r1
            ir.nasim.Fq2 r12 = (ir.nasim.InterfaceC4557Fq2) r12
            boolean r13 = r2.p0()
            ir.nasim.BI7 r1 = new ir.nasim.BI7
            if (r3 == 0) goto L87
            r11 = r6
            goto L88
        L87:
            r11 = r5
        L88:
            r14 = 8
            r15 = 0
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18837pK7.a(ir.nasim.nI7, ir.nasim.rm1):java.lang.Object");
    }
}
