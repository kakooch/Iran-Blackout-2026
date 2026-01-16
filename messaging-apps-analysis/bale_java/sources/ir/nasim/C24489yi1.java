package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.yi1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24489yi1 extends YT4 {
    private final ir.nasim.contact.data.d b;

    /* renamed from: ir.nasim.yi1$a */
    public static final class a {
        public static final C1793a c = new C1793a(null);
        private final int a;
        private final int b;

        /* renamed from: ir.nasim.yi1$a$a, reason: collision with other inner class name */
        public static final class C1793a {
            private C1793a() {
            }

            public final a a(int i) {
                return new a(0, i);
            }

            public /* synthetic */ C1793a(ED1 ed1) {
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

        public static /* synthetic */ a f(a aVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aVar.b;
            }
            return aVar.e(i);
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

        public final a e(int i) {
            int i2 = this.a;
            if (i2 == 0) {
                return null;
            }
            return new a(Math.max(i2 - i, 0), Math.min(i, this.a));
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
            return "ContactsPage(offset=" + this.a + ", loadSize=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.yi1$b */
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
            return C24489yi1.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.yi1$c */
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
            return C24489yi1.this.k(null, this);
        }
    }

    public C24489yi1(ir.nasim.contact.data.d dVar) {
        AbstractC13042fc3.i(dVar, "baleContactDataLoader");
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.C24489yi1.a r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C24489yi1.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.yi1$c r0 = (ir.nasim.C24489yi1.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.yi1$c r0 = new ir.nasim.yi1$c
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
            ir.nasim.contact.data.d r6 = r4.b
            int r2 = r5.b()
            int r5 = r5.a()
            r0.c = r3
            java.lang.Object r6 = r6.a(r2, r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r5 = ir.nasim.ZW0.j0(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24489yi1.k(ir.nasim.yi1$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.C24489yi1.b
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.yi1$b r0 = (ir.nasim.C24489yi1.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.yi1$b r0 = new ir.nasim.yi1$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.a
            ir.nasim.yi1$a r11 = (ir.nasim.C24489yi1.a) r11
            ir.nasim.AbstractC10685c16.b(r12)
        L2c:
            r4 = r11
            goto L58
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            ir.nasim.AbstractC10685c16.b(r12)
            java.lang.Object r12 = r11.a()
            ir.nasim.yi1$a r12 = (ir.nasim.C24489yi1.a) r12
            if (r12 != 0) goto L4c
            ir.nasim.yi1$a$a r12 = ir.nasim.C24489yi1.a.c
            int r11 = r11.b()
            ir.nasim.yi1$a r11 = r12.a(r11)
            goto L4d
        L4c:
            r11 = r12
        L4d:
            r0.a = r11
            r0.d = r3
            java.lang.Object r12 = r10.k(r11, r0)
            if (r12 != r1) goto L2c
            return r1
        L58:
            java.util.List r12 = (java.util.List) r12
            boolean r5 = r12.isEmpty()
            ir.nasim.YT4$b$c r11 = new ir.nasim.YT4$b$c
            r0 = 0
            r1 = 0
            ir.nasim.yi1$a r0 = ir.nasim.C24489yi1.a.f(r4, r0, r3, r1)
            int r6 = r12.size()
            r8 = 4
            r9 = 0
            r7 = 0
            ir.nasim.yi1$a r1 = ir.nasim.C24489yi1.a.d(r4, r5, r6, r7, r8, r9)
            r11.<init>(r12, r0, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24489yi1.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
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
