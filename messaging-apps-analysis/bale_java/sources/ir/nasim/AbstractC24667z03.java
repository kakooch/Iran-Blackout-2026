package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.graphics.vector.VectorPainter;

/* renamed from: ir.nasim.z03, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24667z03 {
    private static final androidx.compose.ui.e a = androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24));

    /* renamed from: ir.nasim.z03$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ EV4 e;
        final /* synthetic */ String f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EV4 ev4, String str, androidx.compose.ui.e eVar, long j, int i, int i2) {
            super(2);
            this.e = ev4;
            this.f = str;
            this.g = eVar;
            this.h = j;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC24667z03.b(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.z03$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.e = str;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.e0(interfaceC11943do6, this.e);
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.e());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    public static final void a(C12700f33 c12700f33, String str, androidx.compose.ui.e eVar, long j, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2 = (i2 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        long jO = (i2 & 8) != 0 ? C24381yX0.o(((C24381yX0) interfaceC22053ub1.H(AbstractC20866sk1.a())).y(), ((Number) interfaceC22053ub1.H(AbstractC16711lk1.a())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-800853103, i, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        b(VQ7.g(c12700f33, interfaceC22053ub1, i & 14), str, eVar2, jO, interfaceC22053ub1, VectorPainter.n | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (i & 7168), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.EV4 r24, java.lang.String r25, androidx.compose.ui.e r26, long r27, ir.nasim.InterfaceC22053ub1 r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24667z03.b(ir.nasim.EV4, java.lang.String, androidx.compose.ui.e, long, ir.nasim.ub1, int, int):void");
    }

    private static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, EV4 ev4) {
        return eVar.i((OD6.f(ev4.getIntrinsicSize(), OD6.b.a()) || d(ev4.getIntrinsicSize())) ? a : androidx.compose.ui.e.a);
    }

    private static final boolean d(long j) {
        return Float.isInfinite(OD6.i(j)) && Float.isInfinite(OD6.g(j));
    }
}
