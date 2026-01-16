package ir.nasim;

/* renamed from: ir.nasim.k61, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15746k61 {
    public static final C15746k61 a = new C15746k61();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-499199393, false, a.a);

    /* renamed from: ir.nasim.k61$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(l66, "$this$Button");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(l66) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.invite_bottomsheet_submit, interfaceC22053ub1, 0), l66.c(androidx.compose.ui.e.a, InterfaceC12529em.a.i()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(WX0.a(TA5.color3_2, interfaceC22053ub1, 0), AbstractC13784go7.g(16), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, M10.p(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, C6399Nk7.b.a(), 0, 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16744412, (ED1) null), interfaceC22053ub1, 0, 0, 65532);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
