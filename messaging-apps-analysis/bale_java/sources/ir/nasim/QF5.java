package ir.nasim;

import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public abstract class QF5 {
    private static final float a;
    private static final float b = C17784nZ1.q(12);
    private static final float c;

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
            float fW1 = interfaceC17460n02.w1(QF5.c);
            float f = 2;
            float f2 = fW1 / f;
            InterfaceC17460n02.L(interfaceC17460n02, ((C24381yX0) this.e.getValue()).y(), interfaceC17460n02.w1(C17784nZ1.q(SF5.a.c() / f)) - f2, 0L, 0.0f, new C23815xZ6(fW1, 0.0f, 0, 0, null, 30, null), null, 0, Type.EUI48, null);
            if (C17784nZ1.p(((C17784nZ1) this.f.getValue()).v(), C17784nZ1.q(0)) > 0) {
                InterfaceC17460n02.L(interfaceC17460n02, ((C24381yX0) this.e.getValue()).y(), interfaceC17460n02.w1(((C17784nZ1) this.f.getValue()).v()) - f2, 0L, 0.0f, C8568Wn2.a, null, 0, Type.EUI48, null);
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
        final /* synthetic */ MF5 i;
        final /* synthetic */ InterfaceC18507om4 j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, SA2 sa2, androidx.compose.ui.e eVar, boolean z2, MF5 mf5, InterfaceC18507om4 interfaceC18507om4, int i, int i2) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = eVar;
            this.h = z2;
            this.i = mf5;
            this.j = interfaceC18507om4;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            QF5.a(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float f = 2;
        a = C17784nZ1.q(f);
        c = C17784nZ1.q(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(boolean r22, ir.nasim.SA2 r23, androidx.compose.ui.e r24, boolean r25, ir.nasim.MF5 r26, ir.nasim.InterfaceC18507om4 r27, ir.nasim.InterfaceC22053ub1 r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QF5.a(boolean, ir.nasim.SA2, androidx.compose.ui.e, boolean, ir.nasim.MF5, ir.nasim.om4, ir.nasim.ub1, int, int):void");
    }
}
