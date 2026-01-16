package ir.nasim.database.dailogLists;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C19938rB7;
import ir.nasim.C7681St2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class c {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return c.h(c.this, 0, this);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.c$c, reason: collision with other inner class name */
    static final class C1013c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        C1013c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return c.n(c.this, 0, null, null, null, this);
        }
    }

    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.database.dailogLists.c$d$a$a, reason: collision with other inner class name */
            public static final class C1014a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1014a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
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
                    boolean r0 = r9 instanceof ir.nasim.database.dailogLists.c.d.a.C1014a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.database.dailogLists.c$d$a$a r0 = (ir.nasim.database.dailogLists.c.d.a.C1014a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.database.dailogLists.c$d$a$a r0 = new ir.nasim.database.dailogLists.c$d$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L6f
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = ir.nasim.ZW0.x(r8, r4)
                    r2.<init>(r4)
                    java.util.Iterator r8 = r8.iterator()
                L49:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L66
                    java.lang.Object r4 = r8.next()
                    ir.nasim.Xs2 r4 = (ir.nasim.C8879Xs2) r4
                    ir.nasim.Ws2 r5 = new ir.nasim.Ws2
                    int r6 = r4.a()
                    int r4 = r4.b()
                    r5.<init>(r6, r4)
                    r2.add(r5)
                    goto L49
                L66:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L6f
                    return r1
                L6f:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

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
            return c.L(c.this, null, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        /* synthetic */ Object f;
        int h;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return c.O(c.this, null, this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return c.S(c.this, null, null, this);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return c.R(c.this, null, this);
        }
    }

    static final class i extends AbstractC22163um1 {
        Object a;
        int b;
        long c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return c.W(c.this, 0, 0L, false, this);
        }
    }

    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        /* synthetic */ Object e;
        int g;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return c.e0(c.this, null, this);
        }
    }

    public static /* synthetic */ InterfaceC4557Fq2 D(c cVar, int i2, boolean z, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrderedDialogPeerUIDSInFolder");
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return cVar.C(i2, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object L(ir.nasim.database.dailogLists.c r8, ir.nasim.C7681St2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            boolean r0 = r10 instanceof ir.nasim.database.dailogLists.c.e
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.database.dailogLists.c$e r0 = (ir.nasim.database.dailogLists.c.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$e r0 = new ir.nasim.database.dailogLists.c$e
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L61
            if (r2 == r6) goto L54
            if (r2 == r5) goto L48
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            ir.nasim.AbstractC10685c16.b(r10)
            goto Ld1
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.b
            ir.nasim.St2 r8 = (ir.nasim.C7681St2) r8
            java.lang.Object r9 = r0.a
            ir.nasim.database.dailogLists.c r9 = (ir.nasim.database.dailogLists.c) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto Lbf
        L48:
            java.lang.Object r8 = r0.b
            ir.nasim.St2 r8 = (ir.nasim.C7681St2) r8
            java.lang.Object r9 = r0.a
            ir.nasim.database.dailogLists.c r9 = (ir.nasim.database.dailogLists.c) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto Lb2
        L54:
            java.lang.Object r8 = r0.b
            r9 = r8
            ir.nasim.St2 r9 = (ir.nasim.C7681St2) r9
            java.lang.Object r8 = r0.a
            ir.nasim.database.dailogLists.c r8 = (ir.nasim.database.dailogLists.c) r8
            ir.nasim.AbstractC10685c16.b(r10)
            goto L75
        L61:
            ir.nasim.AbstractC10685c16.b(r10)
            java.util.List r10 = r9.d()
            r0.a = r8
            r0.b = r9
            r0.e = r6
            java.lang.Object r10 = r8.d0(r10, r0)
            if (r10 != r1) goto L75
            return r1
        L75:
            java.util.List r10 = r9.d()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r6 = 10
            int r6 = ir.nasim.ZW0.x(r10, r6)
            r2.<init>(r6)
            java.util.Iterator r10 = r10.iterator()
        L8a:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto La2
            java.lang.Object r6 = r10.next()
            ir.nasim.database.dailogLists.DialogFolderEntity r6 = (ir.nasim.database.dailogLists.DialogFolderEntity) r6
            int r6 = r6.getId()
            java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r6)
            r2.add(r6)
            goto L8a
        La2:
            r0.a = r8
            r0.b = r9
            r0.e = r5
            java.lang.Object r10 = r8.i(r2, r0)
            if (r10 != r1) goto Laf
            return r1
        Laf:
            r7 = r9
            r9 = r8
            r8 = r7
        Lb2:
            r0.a = r9
            r0.b = r8
            r0.e = r4
            java.lang.Object r10 = r9.b(r0)
            if (r10 != r1) goto Lbf
            return r1
        Lbf:
            java.util.List r8 = r8.c()
            r10 = 0
            r0.a = r10
            r0.b = r10
            r0.e = r3
            java.lang.Object r8 = r9.a(r8, r0)
            if (r8 != r1) goto Ld1
            return r1
        Ld1:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.L(ir.nasim.database.dailogLists.c, ir.nasim.St2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0088 -> B:24:0x008a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object O(ir.nasim.database.dailogLists.c r7, java.util.List r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.database.dailogLists.c.f
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.database.dailogLists.c$f r0 = (ir.nasim.database.dailogLists.c.f) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$f r0 = new ir.nasim.database.dailogLists.c$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r7 = r0.e
            java.lang.Object r8 = r0.d
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r2 = r0.c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.b
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.a
            ir.nasim.database.dailogLists.c r5 = (ir.nasim.database.dailogLists.c) r5
            ir.nasim.AbstractC10685c16.b(r9)
            r9 = r7
            r7 = r5
            goto L8a
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            ir.nasim.AbstractC10685c16.b(r9)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r8, r2)
            r9.<init>(r2)
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r6 = r2
            r2 = r8
            r8 = r9
            r9 = r6
        L5e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L91
            java.lang.Object r4 = r2.next()
            int r5 = r9 + 1
            if (r9 >= 0) goto L6f
            ir.nasim.ZW0.w()
        L6f:
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r0.a = r7
            r0.b = r8
            r0.c = r2
            r0.d = r8
            r0.e = r5
            r0.h = r3
            java.lang.Object r9 = r7.M(r4, r9, r0)
            if (r9 != r1) goto L88
            return r1
        L88:
            r4 = r8
            r9 = r5
        L8a:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            r8.add(r5)
            r8 = r4
            goto L5e
        L91:
            java.util.List r8 = (java.util.List) r8
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.O(ir.nasim.database.dailogLists.c, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object R(ir.nasim.database.dailogLists.c r5, ir.nasim.C7681St2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.database.dailogLists.c.h
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.database.dailogLists.c$h r0 = (ir.nasim.database.dailogLists.c.h) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$h r0 = new ir.nasim.database.dailogLists.c$h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r7)
            goto L67
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.b
            r6 = r5
            ir.nasim.St2 r6 = (ir.nasim.C7681St2) r6
            java.lang.Object r5 = r0.a
            ir.nasim.database.dailogLists.c r5 = (ir.nasim.database.dailogLists.c) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L55
        L41:
            ir.nasim.AbstractC10685c16.b(r7)
            java.util.List r7 = r6.d()
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.d0(r7, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            java.util.List r6 = r6.c()
            r7 = 0
            r0.a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r5 = r5.a(r6, r0)
            if (r5 != r1) goto L67
            return r1
        L67:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.R(ir.nasim.database.dailogLists.c, ir.nasim.St2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object S(ir.nasim.database.dailogLists.c r5, ir.nasim.database.dailogLists.DialogFolderEntity r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.database.dailogLists.c.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.database.dailogLists.c$g r0 = (ir.nasim.database.dailogLists.c.g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$g r0 = new ir.nasim.database.dailogLists.c$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.b
            r7 = r5
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r5 = r0.a
            ir.nasim.database.dailogLists.c r5 = (ir.nasim.database.dailogLists.c) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L51
        L41:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r5
            r0.b = r7
            r0.e = r4
            java.lang.Object r6 = r5.c0(r6, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            r6 = 0
            r0.a = r6
            r0.b = r6
            r0.e = r3
            java.lang.Object r5 = r5.a(r7, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.S(ir.nasim.database.dailogLists.c, ir.nasim.database.dailogLists.DialogFolderEntity, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object U(c cVar, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB0 = cVar.b0(i3, true, i2, interfaceC20295rm1);
        return objB0 == AbstractC14862ic3.e() ? objB0 : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object W(ir.nasim.database.dailogLists.c r18, int r19, long r20, boolean r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r6 = r18
            r0 = r23
            boolean r1 = r0 instanceof ir.nasim.database.dailogLists.c.i
            if (r1 == 0) goto L18
            r1 = r0
            ir.nasim.database.dailogLists.c$i r1 = (ir.nasim.database.dailogLists.c.i) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.g = r2
        L16:
            r7 = r1
            goto L1e
        L18:
            ir.nasim.database.dailogLists.c$i r1 = new ir.nasim.database.dailogLists.c$i
            r1.<init>(r0)
            goto L16
        L1e:
            java.lang.Object r0 = r7.e
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.g
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L4c
            if (r1 == r2) goto L3b
            if (r1 != r9) goto L33
            ir.nasim.AbstractC10685c16.b(r0)
            goto L9b
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            boolean r1 = r7.d
            long r2 = r7.c
            int r4 = r7.b
            java.lang.Object r5 = r7.a
            ir.nasim.database.dailogLists.c r5 = (ir.nasim.database.dailogLists.c) r5
            ir.nasim.AbstractC10685c16.b(r0)
            r15 = r1
            r11 = r2
            r13 = r4
            goto L72
        L4c:
            ir.nasim.AbstractC10685c16.b(r0)
            r7.a = r6
            r10 = r19
            r7.b = r10
            r11 = r20
            r7.c = r11
            r13 = r22
            r7.d = r13
            r7.g = r2
            r0 = r18
            r1 = r19
            r2 = r20
            r4 = r22
            r5 = r7
            java.lang.Object r0 = r0.a0(r1, r2, r4, r5)
            if (r0 != r8) goto L6f
            return r8
        L6f:
            r5 = r6
            r15 = r13
            r13 = r10
        L72:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 != 0) goto L9e
            ir.nasim.database.dailogLists.DialogFolderEntity r0 = new ir.nasim.database.dailogLists.DialogFolderEntity
            java.lang.Long r14 = ir.nasim.AbstractC6392Nk0.e(r11)
            r16 = 0
            r17 = 1
            java.lang.String r12 = ""
            r10 = r0
            r11 = r13
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            java.util.List r0 = ir.nasim.ZW0.e(r0)
            r1 = 0
            r7.a = r1
            r7.g = r9
            java.lang.Object r0 = r5.J(r0, r7)
            if (r0 != r8) goto L9b
            return r8
        L9b:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        L9e:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.W(ir.nasim.database.dailogLists.c, int, long, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00af -> B:31:0x00b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object e0(ir.nasim.database.dailogLists.c r11, java.util.List r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            boolean r0 = r13 instanceof ir.nasim.database.dailogLists.c.j
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.database.dailogLists.c$j r0 = (ir.nasim.database.dailogLists.c.j) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$j r0 = new ir.nasim.database.dailogLists.c$j
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L50
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            int r11 = r0.d
            java.lang.Object r12 = r0.c
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.b
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.a
            ir.nasim.database.dailogLists.c r4 = (ir.nasim.database.dailogLists.c) r4
            ir.nasim.AbstractC10685c16.b(r13)
            goto Lb2
        L3b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L43:
            java.lang.Object r11 = r0.b
            r12 = r11
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r11 = r0.a
            ir.nasim.database.dailogLists.c r11 = (ir.nasim.database.dailogLists.c) r11
            ir.nasim.AbstractC10685c16.b(r13)
            goto L60
        L50:
            ir.nasim.AbstractC10685c16.b(r13)
            r0.a = r11
            r0.b = r12
            r0.g = r4
            java.lang.Object r13 = r11.J(r12, r0)
            if (r13 != r1) goto L60
            return r1
        L60:
            java.util.List r13 = (java.util.List) r13
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
            r2 = 0
        L69:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto Lb8
            java.lang.Object r4 = r12.next()
            int r10 = r2 + 1
            if (r2 >= 0) goto L7a
            ir.nasim.ZW0.w()
        L7a:
            ir.nasim.database.dailogLists.DialogFolderEntity r4 = (ir.nasim.database.dailogLists.DialogFolderEntity) r4
            java.lang.Object r2 = r13.get(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            long r5 = r2.longValue()
            r7 = -1
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto Lb6
            int r5 = r4.getId()
            java.lang.String r6 = r4.getName()
            int r7 = r4.getSortIndex()
            boolean r8 = r4.isActive()
            r0.a = r11
            r0.b = r13
            r0.c = r12
            r0.d = r10
            r0.g = r3
            r4 = r11
            r9 = r0
            java.lang.Object r2 = r4.Z(r5, r6, r7, r8, r9)
            if (r2 != r1) goto Laf
            return r1
        Laf:
            r4 = r11
            r2 = r13
            r11 = r10
        Lb2:
            r13 = r2
            r2 = r11
            r11 = r4
            goto L69
        Lb6:
            r2 = r10
            goto L69
        Lb8:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.e0(ir.nasim.database.dailogLists.c, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object h(ir.nasim.database.dailogLists.c r5, int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.database.dailogLists.c.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.database.dailogLists.c$b r0 = (ir.nasim.database.dailogLists.c.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$b r0 = new ir.nasim.database.dailogLists.c$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r7)
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            int r6 = r0.b
            java.lang.Object r5 = r0.a
            ir.nasim.database.dailogLists.c r5 = (ir.nasim.database.dailogLists.c) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4e
        L3e:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.e(r6, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            r7 = 0
            r0.a = r7
            r0.e = r3
            java.lang.Object r5 = r5.d(r6, r0)
            if (r5 != r1) goto L5a
            return r1
        L5a:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.h(ir.nasim.database.dailogLists.c, int, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object k(c cVar, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB0 = cVar.b0(i2, false, i2, interfaceC20295rm1);
        return objB0 == AbstractC14862ic3.e() ? objB0 : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object n(ir.nasim.database.dailogLists.c r7, int r8, java.lang.String r9, java.util.List r10, java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            boolean r0 = r12 instanceof ir.nasim.database.dailogLists.c.C1013c
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.database.dailogLists.c$c r0 = (ir.nasim.database.dailogLists.c.C1013c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.database.dailogLists.c$c r0 = new ir.nasim.database.dailogLists.c$c
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L56
            if (r2 == r5) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r12)
            goto L86
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.a
            ir.nasim.database.dailogLists.c r8 = (ir.nasim.database.dailogLists.c) r8
            ir.nasim.AbstractC10685c16.b(r12)
            goto L79
        L44:
            java.lang.Object r7 = r0.c
            r11 = r7
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r7 = r0.b
            r10 = r7
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r7 = r0.a
            ir.nasim.database.dailogLists.c r7 = (ir.nasim.database.dailogLists.c) r7
            ir.nasim.AbstractC10685c16.b(r12)
            goto L68
        L56:
            ir.nasim.AbstractC10685c16.b(r12)
            r0.a = r7
            r0.b = r10
            r0.c = r11
            r0.f = r5
            java.lang.Object r8 = r7.l(r8, r9, r0)
            if (r8 != r1) goto L68
            return r1
        L68:
            r0.a = r7
            r0.b = r11
            r0.c = r6
            r0.f = r4
            java.lang.Object r8 = r7.a(r10, r0)
            if (r8 != r1) goto L77
            return r1
        L77:
            r8 = r7
            r7 = r11
        L79:
            r0.a = r6
            r0.b = r6
            r0.f = r3
            java.lang.Object r7 = r8.f(r7, r0)
            if (r7 != r1) goto L86
            return r1
        L86:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.database.dailogLists.c.n(ir.nasim.database.dailogLists.c, int, java.lang.String, java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object p(c cVar, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveFolders");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        return cVar.o(z, interfaceC20295rm1);
    }

    public static /* synthetic */ Object u(c cVar, int i2, int i3, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDialogIdsSortedWithPinPriority");
        }
        if ((i4 & 4) != 0) {
            z = true;
        }
        return cVar.t(i2, i3, z, interfaceC20295rm1);
    }

    public abstract InterfaceC4557Fq2 A();

    public abstract Object B(InterfaceC20295rm1 interfaceC20295rm1);

    public final InterfaceC4557Fq2 C(int i2, boolean z, boolean z2) {
        return i2 == 10 ? F(z) : E(i2, z2);
    }

    protected abstract InterfaceC4557Fq2 E(int i2, boolean z);

    protected abstract InterfaceC4557Fq2 F(boolean z);

    public abstract Object G(int i2, int i3, int i4, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract InterfaceC4557Fq2 H(int i2);

    public abstract Object I(int i2, int i3, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object J(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public Object K(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
        return L(this, c7681St2, interfaceC20295rm1);
    }

    public abstract Object M(int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1);

    public Object N(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return O(this, list, interfaceC20295rm1);
    }

    public Object P(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
        return R(this, c7681St2, interfaceC20295rm1);
    }

    public Object Q(DialogFolderEntity dialogFolderEntity, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return S(this, dialogFolderEntity, list, interfaceC20295rm1);
    }

    public Object T(int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        return U(this, i2, i3, interfaceC20295rm1);
    }

    public Object V(int i2, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return W(this, i2, j2, z, interfaceC20295rm1);
    }

    public abstract Object X(int i2, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object Y(List list, int i2, InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object Z(int i2, String str, int i3, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object a(List list, InterfaceC20295rm1 interfaceC20295rm1);

    protected abstract Object a0(int i2, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object b(InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object b0(int i2, boolean z, int i3, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object c(long j2, InterfaceC20295rm1 interfaceC20295rm1);

    public final Object c0(DialogFolderEntity dialogFolderEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD0 = d0(AbstractC9766aX0.e(dialogFolderEntity), interfaceC20295rm1);
        return objD0 == AbstractC14862ic3.e() ? objD0 : C19938rB7.a;
    }

    public abstract Object d(int i2, InterfaceC20295rm1 interfaceC20295rm1);

    public Object d0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return e0(this, list, interfaceC20295rm1);
    }

    public abstract Object e(int i2, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object f(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object f0(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public Object g(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return h(this, i2, interfaceC20295rm1);
    }

    public abstract Object i(List list, InterfaceC20295rm1 interfaceC20295rm1);

    public Object j(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return k(this, i2, interfaceC20295rm1);
    }

    public abstract Object l(int i2, String str, InterfaceC20295rm1 interfaceC20295rm1);

    public Object m(int i2, String str, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
        return n(this, i2, str, list, list2, interfaceC20295rm1);
    }

    public abstract Object o(boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract InterfaceC4557Fq2 q(boolean z);

    public abstract InterfaceC4557Fq2 r();

    public abstract InterfaceC4557Fq2 s(int i2, int i3);

    public abstract Object t(int i2, int i3, boolean z, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object v(int i2, InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object w(InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object x(int i2, InterfaceC20295rm1 interfaceC20295rm1);

    public final InterfaceC4557Fq2 y(boolean z) {
        return z ? new d(z()) : A();
    }

    public abstract InterfaceC4557Fq2 z();
}
