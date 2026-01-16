package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.rg6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20238rg6 extends YT4 {
    private final QT4 b;

    /* renamed from: ir.nasim.rg6$a */
    public static final class a {
        public static final C1503a c = new C1503a(null);
        private final int a;
        private final int b;

        /* renamed from: ir.nasim.rg6$a$a, reason: collision with other inner class name */
        public static final class C1503a {
            private C1503a() {
            }

            public final a a(int i) {
                return new a(0, i);
            }

            public /* synthetic */ C1503a(ED1 ed1) {
                this();
            }
        }

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ a d(a aVar, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = aVar.b;
            }
            return aVar.c(z, i, i2);
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final a c(boolean z, int i, int i2) {
            if (z) {
                return null;
            }
            return new a(this.a + i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "SearchPage(offset=" + this.a + ", loadSize=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.rg6$b */
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
            return C20238rg6.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.rg6$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C20238rg6.this.k(null, this);
        }
    }

    public C20238rg6(QT4 qt4) {
        AbstractC13042fc3.i(qt4, "searchListDataLoader");
        this.b = qt4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.C20238rg6.a r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C20238rg6.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.rg6$c r0 = (ir.nasim.C20238rg6.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.rg6$c r0 = new ir.nasim.rg6$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.QT4 r6 = r4.b
            int r2 = r5.b()
            int r5 = r5.a()
            r0.c = r3
            java.lang.Object r6 = r6.a(r2, r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r6.next()
            r2 = r1
            ir.nasim.Cg6 r2 = (ir.nasim.AbstractC3769Cg6) r2
            ir.nasim.d25 r2 = r2.d()
            long r2 = r2.u()
            java.lang.Long r2 = ir.nasim.AbstractC6392Nk0.e(r2)
            boolean r2 = r5.add(r2)
            if (r2 == 0) goto L57
            r0.add(r1)
            goto L57
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20238rg6.k(ir.nasim.rg6$a, ir.nasim.rm1):java.lang.Object");
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
            boolean r0 = r10 instanceof ir.nasim.C20238rg6.b
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.rg6$b r0 = (ir.nasim.C20238rg6.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.rg6$b r0 = new ir.nasim.rg6$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r9 = r0.a
            ir.nasim.rg6$a r9 = (ir.nasim.C20238rg6.a) r9
            ir.nasim.AbstractC10685c16.b(r10)
        L2c:
            r2 = r9
            goto L58
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            ir.nasim.AbstractC10685c16.b(r10)
            java.lang.Object r10 = r9.a()
            ir.nasim.rg6$a r10 = (ir.nasim.C20238rg6.a) r10
            if (r10 != 0) goto L4c
            ir.nasim.rg6$a$a r10 = ir.nasim.C20238rg6.a.c
            int r9 = r9.b()
            ir.nasim.rg6$a r9 = r10.a(r9)
            goto L4d
        L4c:
            r9 = r10
        L4d:
            r0.a = r9
            r0.d = r3
            java.lang.Object r10 = r8.k(r9, r0)
            if (r10 != r1) goto L2c
            return r1
        L58:
            java.util.List r10 = (java.util.List) r10
            boolean r3 = r10.isEmpty()
            ir.nasim.YT4$b$c r9 = new ir.nasim.YT4$b$c
            int r4 = r10.size()
            r6 = 4
            r7 = 0
            r5 = 0
            ir.nasim.rg6$a r0 = ir.nasim.C20238rg6.a.d(r2, r3, r4, r5, r6, r7)
            r1 = 0
            r9.<init>(r10, r1, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20238rg6.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        int i = zt4.d().a;
        Integer numC = zt4.c();
        return numC != null ? new a(Math.max(numC.intValue() - (i / 2), 0), i) : a.c.a(i);
    }
}
