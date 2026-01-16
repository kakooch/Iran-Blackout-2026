package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Px5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7008Px5 {

    /* renamed from: ir.nasim.Px5$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ C9348Zn7 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = j;
            this.f = c9348Zn7;
            this.g = interfaceC14603iB2;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC7008Px5.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(long j, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-716124955);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.f(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c9348Zn7) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-716124955, i2, -1, "androidx.compose.material3.internal.ProvideContentColorTextStyle (ProvideContentColorTextStyle.kt:38)");
            }
            AbstractC11024cc1.b(new C7252Qx5[]{AbstractC21553tk1.a().d(C24381yX0.k(j)), AbstractC9339Zm7.d().d(((C9348Zn7) interfaceC22053ub1J.H(AbstractC9339Zm7.d())).J(c9348Zn7))}, interfaceC14603iB2, interfaceC22053ub1J, ((i2 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | C7252Qx5.i);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(j, c9348Zn7, interfaceC14603iB2, i));
        }
    }
}
