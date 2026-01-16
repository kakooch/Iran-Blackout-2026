package ir.nasim;

/* renamed from: ir.nasim.oV3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC18341oV3 {

    /* renamed from: ir.nasim.oV3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC18341oV3.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1322912246);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (interfaceC22053ub1J.o((i2 & 3) != 2, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1322912246, i2, -1, "androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)");
            }
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf(i2 & 14));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(interfaceC14603iB2, i));
        }
    }
}
