package ir.nasim;

/* loaded from: classes7.dex */
public final class Y71 {
    public static final Y71 a = new Y71();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(210409701, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(KB5.question, interfaceC22053ub1, 0), UY6.c(QD5.premium_question_content_desc, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).G(), interfaceC22053ub1, 0, 4);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }
}
