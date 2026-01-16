package ir.nasim;

import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public abstract class RF5 {
    private static final float a = C17784nZ1.q(24);
    private static final float b;
    private static final float c;
    private static final float d;
    private static final float e;
    private static final float f;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
            super(1);
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            float fW1 = interfaceC17460n02.w1(RF5.f);
            float f = fW1 / 2;
            InterfaceC17460n02.L(interfaceC17460n02, ((C24381yX0) this.e.getValue()).y(), interfaceC17460n02.w1(RF5.d) - f, 0L, 0.0f, new C23815xZ6(fW1, 0.0f, 0, 0, null, 30, null), null, 0, Type.EUI48, null);
            if (C17784nZ1.p(((C17784nZ1) this.f.getValue()).v(), C17784nZ1.q(0)) > 0) {
                InterfaceC17460n02.L(interfaceC17460n02, ((C24381yX0) this.e.getValue()).y(), interfaceC17460n02.w1(((C17784nZ1) this.f.getValue()).v()) - f, 0L, 0.0f, C8568Wn2.a, null, 0, Type.EUI48, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ InterfaceC18507om4 i;
        final /* synthetic */ NF5 j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, SA2 sa2, androidx.compose.ui.e eVar, boolean z2, InterfaceC18507om4 interfaceC18507om4, NF5 nf5, int i, int i2) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = eVar;
            this.h = z2;
            this.i = interfaceC18507om4;
            this.j = nf5;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            RF5.a(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float f2 = 2;
        b = C17784nZ1.q(f2);
        float fQ = C17784nZ1.q(20);
        c = fQ;
        d = C17784nZ1.q(fQ / f2);
        e = C17784nZ1.q(12);
        f = C17784nZ1.q(f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(boolean r27, ir.nasim.SA2 r28, androidx.compose.ui.e r29, boolean r30, ir.nasim.InterfaceC18507om4 r31, ir.nasim.NF5 r32, ir.nasim.InterfaceC22053ub1 r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.RF5.a(boolean, ir.nasim.SA2, androidx.compose.ui.e, boolean, ir.nasim.om4, ir.nasim.NF5, ir.nasim.ub1, int, int):void");
    }
}
