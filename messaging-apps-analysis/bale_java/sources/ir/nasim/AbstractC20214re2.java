package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC20214re2;

/* renamed from: ir.nasim.re2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20214re2 {

    /* renamed from: ir.nasim.re2$a */
    static final class a implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44) {
            this.a = interfaceC9102Ym4;
            this.b = interfaceC9102Ym42;
            this.c = interfaceC9102Ym43;
            this.d = interfaceC9102Ym44;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44, ZG4 zg4, ZG4 zg42, float f, float f2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$scale$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$boxSize$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym43, "$parentSize$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym44, "$offset$delegate");
            AbstractC20214re2.n(interfaceC9102Ym4, AbstractC23053wG5.l(AbstractC20214re2.i(interfaceC9102Ym4) * f, 1.0f, 5.0f));
            float fMax = Math.max(0.0f, ((((int) (AbstractC20214re2.g(interfaceC9102Ym42) >> 32)) * AbstractC20214re2.i(interfaceC9102Ym4)) - ((int) (AbstractC20214re2.q(interfaceC9102Ym43) >> 32))) / 2.0f);
            float fMax2 = Math.max(0.0f, ((((int) (AbstractC20214re2.g(interfaceC9102Ym42) & 4294967295L)) * AbstractC20214re2.i(interfaceC9102Ym4)) - ((int) (AbstractC20214re2.q(interfaceC9102Ym43) & 4294967295L))) / 2.0f);
            float fL = AbstractC23053wG5.l(Float.intBitsToFloat((int) (AbstractC20214re2.o(interfaceC9102Ym44) >> 32)) + Float.intBitsToFloat((int) (zg42.t() >> 32)), -fMax, fMax);
            float fL2 = AbstractC23053wG5.l(Float.intBitsToFloat((int) (AbstractC20214re2.o(interfaceC9102Ym44) & 4294967295L)) + Float.intBitsToFloat((int) (zg42.t() & 4294967295L)), -fMax2, fMax2);
            AbstractC20214re2.p(interfaceC9102Ym44, ZG4.e((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L)));
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym43 = this.c;
            final InterfaceC9102Ym4 interfaceC9102Ym44 = this.d;
            Object objH = AbstractC12627ev7.h(interfaceC9049Yg5, false, new InterfaceC16978mB2() { // from class: ir.nasim.qe2
                @Override // ir.nasim.InterfaceC16978mB2
                public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AbstractC20214re2.a.b(interfaceC9102Ym4, interfaceC9102Ym42, interfaceC9102Ym43, interfaceC9102Ym44, (ZG4) obj, (ZG4) obj2, ((Float) obj3).floatValue(), ((Float) obj4).floatValue());
                }
            }, interfaceC20295rm1, 1, null);
            return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0383  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final ir.nasim.InterfaceC10258bL6 r43, final ir.nasim.SA2 r44, ir.nasim.InterfaceC22053ub1 r45, final int r46) {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20214re2.e(ir.nasim.bL6, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    private static final M26 f(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
    }

    private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(C4414Fa3.b(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$parentSize$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        r(interfaceC9102Ym4, interfaceC11379cu3.a());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$boxSize$delegate");
        AbstractC13042fc3.i(interfaceC11379cu3, "coordinates");
        h(interfaceC9102Ym4, interfaceC11379cu3.a());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$minimizeScreenClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$participantFlow");
        AbstractC13042fc3.i(sa2, "$minimizeScreenClicked");
        e(interfaceC10258bL6, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        interfaceC9102Ym4.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((ZG4) interfaceC9102Ym4.getValue()).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(ZG4.d(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long q(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C4414Fa3) interfaceC9102Ym4.getValue()).j();
    }

    private static final void r(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(C4414Fa3.b(j));
    }
}
