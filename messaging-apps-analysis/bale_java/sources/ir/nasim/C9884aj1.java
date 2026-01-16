package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.aj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9884aj1 extends YT4 {
    public static final d e = new d(null);
    public static final int f = 8;
    private final C8054Ui1 b;
    private final String c;
    private final InterfaceC9173Yu3 d;

    /* renamed from: ir.nasim.aj1$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C9884aj1.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.aj1$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        int d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C9884aj1.this.m(0, 0, null, this);
        }
    }

    /* renamed from: ir.nasim.aj1$c */
    static final class c implements GB3 {
        final /* synthetic */ InterfaceC20295rm1 a;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.GB3
        public final void a(List list, long j, long j2) {
            AbstractC13042fc3.i(list, "items");
            this.a.resumeWith(C9475a16.b(list));
        }
    }

    /* renamed from: ir.nasim.aj1$d */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public C9884aj1(C8054Ui1 c8054Ui1, String str) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(str, "query");
        this.b = c8054Ui1;
        this.c = str;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Zi1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9884aj1.l(this.a);
            }
        });
    }

    private final WK j() {
        return (WK) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK l(C9884aj1 c9884aj1) {
        AbstractC13042fc3.i(c9884aj1, "this$0");
        DB3 db3M0 = c9884aj1.b.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.C9884aj1.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.aj1$a r0 = (ir.nasim.C9884aj1.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.aj1$a r0 = new ir.nasim.aj1$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            int r9 = r0.c
            java.lang.Object r1 = r0.b
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r0 = r0.a
            ir.nasim.YT4$a r0 = (ir.nasim.YT4.a) r0
            ir.nasim.AbstractC10685c16.b(r10)
            goto L75
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            ir.nasim.AbstractC10685c16.b(r10)
            java.lang.Object r10 = r9.a()
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L4c
            int r10 = r10.intValue()
            goto L4d
        L4c:
            r10 = 0
        L4d:
            if (r10 != 0) goto L51
            r2 = r3
            goto L5b
        L51:
            int r2 = r9.b()
            int r2 = r10 - r2
            java.lang.Integer r2 = ir.nasim.AbstractC6392Nk0.d(r2)
        L5b:
            int r5 = r9.b()
            java.lang.String r6 = r8.c
            r0.a = r9
            r0.b = r2
            r0.c = r10
            r0.f = r4
            java.lang.Object r0 = r8.m(r10, r5, r6, r0)
            if (r0 != r1) goto L70
            return r1
        L70:
            r1 = r2
            r7 = r0
            r0 = r9
            r9 = r10
            r10 = r7
        L75:
            java.util.List r10 = (java.util.List) r10
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L7e
            goto L87
        L7e:
            int r0 = r0.b()
            int r9 = r9 + r0
            java.lang.Integer r3 = ir.nasim.AbstractC6392Nk0.d(r9)
        L87:
            ir.nasim.YT4$b$c r9 = new ir.nasim.YT4$b$c
            r9.<init>(r10, r1, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9884aj1.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r5, int r6, java.lang.String r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C9884aj1.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.aj1$b r0 = (ir.nasim.C9884aj1.b) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.aj1$b r0 = new ir.nasim.aj1$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.a
            ir.nasim.aj1 r5 = (ir.nasim.C9884aj1) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6b
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r4
            r0.b = r7
            r0.c = r5
            r0.d = r6
            r0.g = r3
            ir.nasim.m96 r8 = new ir.nasim.m96
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r8.<init>(r2)
            ir.nasim.aj1$c r2 = new ir.nasim.aj1$c
            r2.<init>(r8)
            ir.nasim.WK r3 = r4.j()
            r3.I(r7, r5, r6, r2)
            java.lang.Object r8 = r8.a()
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            if (r8 != r5) goto L68
            ir.nasim.WA1.c(r0)
        L68:
            if (r8 != r1) goto L6b
            return r1
        L6b:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9884aj1.m(int, int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
