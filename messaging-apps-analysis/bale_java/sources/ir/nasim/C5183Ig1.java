package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ig1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5183Ig1 implements InterfaceC20468s37 {
    private final C14375ho5 a;
    private final Context b;

    /* renamed from: ir.nasim.Ig1$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C5183Ig1 b;

        /* renamed from: ir.nasim.Ig1$a$a, reason: collision with other inner class name */
        public static final class C0421a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C5183Ig1 b;

            /* renamed from: ir.nasim.Ig1$a$a$a, reason: collision with other inner class name */
            public static final class C0422a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0422a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0421a.this.a(null, this);
                }
            }

            public C0421a(InterfaceC4806Gq2 interfaceC4806Gq2, C5183Ig1 c5183Ig1) {
                this.a = interfaceC4806Gq2;
                this.b = c5183Ig1;
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
                    boolean r0 = r9 instanceof ir.nasim.C5183Ig1.a.C0421a.C0422a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Ig1$a$a$a r0 = (ir.nasim.C5183Ig1.a.C0421a.C0422a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ig1$a$a$a r0 = new ir.nasim.Ig1$a$a$a
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
                    ir.nasim.Ig1 r2 = r7.b
                    android.content.Context r2 = r2.b()
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5183Ig1.a.C0421a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, C5183Ig1 c5183Ig1) {
            this.a = interfaceC4557Fq2;
            this.b = c5183Ig1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0421a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ig1$b */
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
            return C5183Ig1.this.c(0, this);
        }
    }

    /* renamed from: ir.nasim.Ig1$c */
    static final class c extends AbstractC22163um1 {
        int a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C5183Ig1.this.a(null, this);
        }
    }

    public C5183Ig1(C14375ho5 c14375ho5, Context context) {
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(context, "context");
        this.a = c14375ho5;
        this.b = context;
    }

    public final Context b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C5183Ig1.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Ig1$b r0 = (ir.nasim.C5183Ig1.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Ig1$b r0 = new ir.nasim.Ig1$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.Ig1 r7 = (ir.nasim.C5183Ig1) r7
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
            ir.nasim.Ig1$a r0 = new ir.nasim.Ig1$a
            r0.<init>(r8, r7)
            goto L58
        L51:
            r7 = 0
            java.lang.String[] r7 = new java.lang.String[r7]
            ir.nasim.Fq2 r0 = ir.nasim.AbstractC6459Nq2.U(r7)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5183Ig1.c(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.database.entity.ContactEntity r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.C5183Ig1.c
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.Ig1$c r0 = (ir.nasim.C5183Ig1.c) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.Ig1$c r0 = new ir.nasim.Ig1$c
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            boolean r14 = r0.d
            int r1 = r0.a
            java.lang.Object r2 = r0.c
            ir.nasim.core.modules.profile.entity.Avatar r2 = (ir.nasim.core.modules.profile.entity.Avatar) r2
            java.lang.Object r0 = r0.b
            java.lang.String r0 = (java.lang.String) r0
            ir.nasim.AbstractC10685c16.b(r15)
            r10 = r14
            r8 = r0
            r7 = r1
            r9 = r2
            goto L6e
        L39:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L41:
            ir.nasim.AbstractC10685c16.b(r15)
            int r15 = r14.getId()
            java.lang.String r2 = r14.getName()
            boolean r4 = r14.isBot()
            ir.nasim.core.modules.profile.entity.Avatar r5 = ir.nasim.AbstractC17773nY.a(r14)
            int r14 = r14.getId()
            r0.b = r2
            r0.c = r5
            r0.a = r15
            r0.d = r4
            r0.g = r3
            java.lang.Object r14 = r13.c(r14, r0)
            if (r14 != r1) goto L69
            return r1
        L69:
            r7 = r15
            r8 = r2
            r10 = r4
            r9 = r5
            r15 = r14
        L6e:
            r12 = r15
            ir.nasim.Fq2 r12 = (ir.nasim.InterfaceC4557Fq2) r12
            ir.nasim.wY r14 = new ir.nasim.wY
            r11 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5183Ig1.a(ir.nasim.database.entity.ContactEntity, ir.nasim.rm1):java.lang.Object");
    }
}
