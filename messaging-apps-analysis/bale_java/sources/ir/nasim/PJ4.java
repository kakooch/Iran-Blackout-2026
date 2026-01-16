package ir.nasim;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class PJ4 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C12544en4 a = new C12544en4(new C3419Au3[16], 0);
    private C3419Au3[] b;

    public static final class a {

        /* renamed from: ir.nasim.PJ4$a$a, reason: collision with other inner class name */
        private static final class C0572a implements Comparator {
            public static final C0572a a = new C0572a();

            private C0572a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C3419Au3 c3419Au3, C3419Au3 c3419Au32) {
                int iK = AbstractC13042fc3.k(c3419Au32.U(), c3419Au3.U());
                return iK != 0 ? iK : AbstractC13042fc3.k(c3419Au3.hashCode(), c3419Au32.hashCode());
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void b(C3419Au3 c3419Au3) {
        c3419Au3.J();
        c3419Au3.Q1(false);
        C12544en4 c12544en4G0 = c3419Au3.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            b((C3419Au3) objArr[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r4 = this;
            ir.nasim.en4 r0 = r4.a
            ir.nasim.PJ4$a$a r1 = ir.nasim.PJ4.a.C0572a.a
            r0.C(r1)
            ir.nasim.en4 r0 = r4.a
            int r0 = r0.o()
            ir.nasim.Au3[] r1 = r4.b
            if (r1 == 0) goto L14
            int r2 = r1.length
            if (r2 >= r0) goto L22
        L14:
            ir.nasim.en4 r1 = r4.a
            int r1 = r1.o()
            r2 = 16
            int r1 = java.lang.Math.max(r2, r1)
            ir.nasim.Au3[] r1 = new ir.nasim.C3419Au3[r1]
        L22:
            r2 = 0
            r4.b = r2
            r2 = 0
        L26:
            if (r2 >= r0) goto L33
            ir.nasim.en4 r3 = r4.a
            java.lang.Object[] r3 = r3.a
            r3 = r3[r2]
            r1[r2] = r3
            int r2 = r2 + 1
            goto L26
        L33:
            ir.nasim.en4 r2 = r4.a
            r2.k()
            int r0 = r0 + (-1)
        L3a:
            r2 = -1
            if (r2 >= r0) goto L4e
            r2 = r1[r0]
            ir.nasim.AbstractC13042fc3.f(r2)
            boolean r3 = r2.s0()
            if (r3 == 0) goto L4b
            r4.b(r2)
        L4b:
            int r0 = r0 + (-1)
            goto L3a
        L4e:
            r4.b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PJ4.a():void");
    }

    public final boolean c() {
        return this.a.o() != 0;
    }

    public final void d(C3419Au3 c3419Au3) {
        this.a.d(c3419Au3);
        c3419Au3.Q1(true);
    }

    public final void e(C3419Au3 c3419Au3) {
        this.a.k();
        this.a.d(c3419Au3);
        c3419Au3.Q1(true);
    }

    public final void f(C3419Au3 c3419Au3) {
        this.a.t(c3419Au3);
    }
}
