package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.mo2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC17343mo2 {

    /* renamed from: ir.nasim.mo2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16752lo2.values().length];
            try {
                iArr[EnumC16752lo2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16752lo2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16752lo2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final long a(EnumC16752lo2 enumC16752lo2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        long jH;
        AbstractC13042fc3.i(enumC16752lo2, "<this>");
        interfaceC22053ub1.W(-1808657389);
        int i2 = a.a[enumC16752lo2.ordinal()];
        if (i2 == 1) {
            interfaceC22053ub1.W(133489911);
            interfaceC22053ub1.Q();
            jH = C24381yX0.b.h();
        } else if (i2 == 2) {
            interfaceC22053ub1.W(133492181);
            jH = G10.a.a(interfaceC22053ub1, G10.b).G();
            interfaceC22053ub1.Q();
        } else {
            if (i2 != 3) {
                interfaceC22053ub1.W(133488380);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(133494357);
            jH = G10.a.a(interfaceC22053ub1, G10.b).G();
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return jH;
    }
}
