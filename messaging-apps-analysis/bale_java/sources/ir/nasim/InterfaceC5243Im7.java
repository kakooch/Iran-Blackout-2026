package ir.nasim;

import ir.nasim.InterfaceC5243Im7;

/* renamed from: ir.nasim.Im7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5243Im7 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.Im7$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC5243Im7 b = new InterfaceC5243Im7() { // from class: ir.nasim.Fm7
            @Override // ir.nasim.InterfaceC5243Im7
            public final boolean a(CK5 ck5, CK5 ck52) {
                return InterfaceC5243Im7.a.d(ck5, ck52);
            }
        };
        private static final InterfaceC5243Im7 c = new InterfaceC5243Im7() { // from class: ir.nasim.Gm7
            @Override // ir.nasim.InterfaceC5243Im7
            public final boolean a(CK5 ck5, CK5 ck52) {
                return InterfaceC5243Im7.a.e(ck5, ck52);
            }
        };
        private static final InterfaceC5243Im7 d = new InterfaceC5243Im7() { // from class: ir.nasim.Hm7
            @Override // ir.nasim.InterfaceC5243Im7
            public final boolean a(CK5 ck5, CK5 ck52) {
                return InterfaceC5243Im7.a.f(ck5, ck52);
            }
        };

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(CK5 ck5, CK5 ck52) {
            return ck5.q(ck52);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean e(CK5 ck5, CK5 ck52) {
            return !ck52.p() && ck5.i() >= ck52.i() && ck5.j() <= ck52.j() && ck5.l() >= ck52.l() && ck5.e() <= ck52.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(CK5 ck5, CK5 ck52) {
            return ck52.b(ck5.h());
        }

        public final InterfaceC5243Im7 g() {
            return b;
        }

        public final InterfaceC5243Im7 h() {
            return d;
        }
    }

    boolean a(CK5 ck5, CK5 ck52);
}
