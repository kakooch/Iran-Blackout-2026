package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Pg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6855Pg5 {
    private final C21892uJ3 a = new C21892uJ3(0, 1, null);

    /* renamed from: ir.nasim.Pg5$a */
    private static final class a {
        private final long a;
        private final long b;
        private final boolean c;

        public /* synthetic */ a(long j, long j2, boolean z, ED1 ed1) {
            this(j, j2, z);
        }

        public final boolean a() {
            return this.c;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.a;
        }

        private a(long j, long j2, boolean z) {
            this.a = j;
            this.b = j2;
            this.c = z;
        }
    }

    public final void a() {
        this.a.c();
    }

    public final C7286Rb3 b(C7099Qg5 c7099Qg5, InterfaceC8058Ui5 interfaceC8058Ui5) {
        long jK;
        boolean zA;
        long jP;
        C21892uJ3 c21892uJ3 = new C21892uJ3(c7099Qg5.b().size());
        List listB = c7099Qg5.b();
        int size = listB.size();
        for (int i = 0; i < size; i++) {
            C7333Rg5 c7333Rg5 = (C7333Rg5) listB.get(i);
            a aVar = (a) this.a.f(c7333Rg5.d());
            if (aVar == null) {
                jK = c7333Rg5.k();
                jP = c7333Rg5.f();
                zA = false;
            } else {
                long jC = aVar.c();
                jK = jC;
                zA = aVar.a();
                jP = interfaceC8058Ui5.p(aVar.b());
            }
            c21892uJ3.l(c7333Rg5.d(), new C6616Og5(c7333Rg5.d(), c7333Rg5.k(), c7333Rg5.f(), c7333Rg5.b(), c7333Rg5.h(), jK, jP, zA, false, c7333Rg5.j(), c7333Rg5.c(), c7333Rg5.i(), c7333Rg5.e(), null));
            if (c7333Rg5.b()) {
                this.a.l(c7333Rg5.d(), new a(c7333Rg5.k(), c7333Rg5.g(), c7333Rg5.b(), null));
            } else {
                this.a.m(c7333Rg5.d());
            }
        }
        return new C7286Rb3(c21892uJ3, c7099Qg5);
    }
}
