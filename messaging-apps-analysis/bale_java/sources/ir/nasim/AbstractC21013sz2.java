package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.sz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21013sz2 {

    /* renamed from: ir.nasim.sz2$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9102Ym4 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C19814qz2 c19814qz2) {
            return c19814qz2.a();
        }
    }

    /* renamed from: ir.nasim.sz2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19814qz2 invoke(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return new C19814qz2(interfaceC9102Ym4);
        }
    }

    /* renamed from: ir.nasim.sz2$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19814qz2 invoke() {
            return new C19814qz2(null, 1, null);
        }
    }

    private static final InterfaceC8230Vb6 a() {
        return AbstractC8464Wb6.a(a.e, b.e);
    }

    public static final C19814qz2 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-496803845);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-496803845, i, -1, "androidx.fragment.compose.rememberFragmentState (FragmentState.kt:31)");
        }
        C19814qz2 c19814qz2 = (C19814qz2) AbstractC9681aN5.e(new Object[0], a(), null, c.e, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return c19814qz2;
    }
}
