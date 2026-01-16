package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Fw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4612Fw3 {

    /* renamed from: ir.nasim.Fw3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C4378Ew3 e;

        /* renamed from: ir.nasim.Fw3$a$a, reason: collision with other inner class name */
        public static final class C0380a implements KV1 {
            final /* synthetic */ C4378Ew3 a;

            public C0380a(C4378Ew3 c4378Ew3) {
                this.a = c4378Ew3;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.d();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C4378Ew3 c4378Ew3) {
            super(1);
            this.e = c4378Ew3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new C0380a(this.e);
        }
    }

    /* renamed from: ir.nasim.Fw3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Object e;
        final /* synthetic */ int f;
        final /* synthetic */ C4861Gw3 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, int i, C4861Gw3 c4861Gw3, InterfaceC14603iB2 interfaceC14603iB2, int i2) {
            super(2);
            this.e = obj;
            this.f = i;
            this.g = c4861Gw3;
            this.h = interfaceC14603iB2;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC4612Fw3.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Object obj, int i, C4861Gw3 c4861Gw3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2079116560);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(obj) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(c4861Gw3) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i3 & 1171) != 1170, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2079116560, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:50)");
            }
            boolean zV = interfaceC22053ub1J.V(obj) | interfaceC22053ub1J.V(c4861Gw3);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C4378Ew3(obj, c4861Gw3);
                interfaceC22053ub1J.s(objB);
            }
            C4378Ew3 c4378Ew3 = (C4378Ew3) objB;
            c4378Ew3.e(i);
            c4378Ew3.f((InterfaceC8013Ud5) interfaceC22053ub1J.H(AbstractC8247Vd5.a()));
            boolean zV2 = interfaceC22053ub1J.V(c4378Ew3);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new a(c4378Ew3);
                interfaceC22053ub1J.s(objB2);
            }
            AbstractC10721c52.a(c4378Ew3, (UA2) objB2, interfaceC22053ub1J, 0);
            AbstractC11024cc1.a(AbstractC8247Vd5.a().d(c4378Ew3), interfaceC14603iB2, interfaceC22053ub1J, ((i3 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | C7252Qx5.i);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(obj, i, c4861Gw3, interfaceC14603iB2, i2));
        }
    }
}
