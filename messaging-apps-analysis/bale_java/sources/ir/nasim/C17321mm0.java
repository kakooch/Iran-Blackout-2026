package ir.nasim;

import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.mm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17321mm0 extends AbstractC22476vI6 {
    public static final C17321mm0 n = new C17321mm0();

    /* renamed from: ir.nasim.mm0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ JC6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(JC6 jc6) {
            super(1);
            this.e = jc6;
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            Map mapI = AbstractC22476vI6.a.i();
            String strD = AbstractC6597Oe4.d(this.e);
            if (mapI != null) {
                return mapI.containsKey(strD);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    private C17321mm0() {
    }

    public final List i(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        List list = (List) AbstractC22476vI6.a.e().get(c6432No4);
        return list == null ? AbstractC10360bX0.m() : list;
    }

    public final C6432No4 j(JC6 jc6) {
        AbstractC13042fc3.i(jc6, "functionDescriptor");
        Map mapI = AbstractC22476vI6.a.i();
        String strD = AbstractC6597Oe4.d(jc6);
        if (strD == null) {
            return null;
        }
        return (C6432No4) mapI.get(strD);
    }

    public final boolean k(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "<this>");
        return AbstractC22476vI6.a.f().contains(c6432No4);
    }

    public final boolean l(JC6 jc6) {
        AbstractC13042fc3.i(jc6, "functionDescriptor");
        return AbstractC19738qr3.e0(jc6) && PI1.d(jc6, false, new a(jc6), 1, null) != null;
    }

    public final boolean m(JC6 jc6) {
        AbstractC13042fc3.i(jc6, "<this>");
        return AbstractC13042fc3.d(jc6.getName().h(), "removeAt") && AbstractC13042fc3.d(AbstractC6597Oe4.d(jc6), AbstractC22476vI6.a.g().b());
    }
}
