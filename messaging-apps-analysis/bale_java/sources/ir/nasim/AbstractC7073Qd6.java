package ir.nasim;

import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Qd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7073Qd6 {
    private static final boolean a(C7631Sn6 c7631Sn6) {
        InterfaceC14603iB2 interfaceC14603iB2C = c(c7631Sn6);
        C5629Kd6 c5629Kd6 = (C5629Kd6) AbstractC5719Kn6.a(c7631Sn6.w(), C8838Xn6.a.M());
        return (interfaceC14603iB2C == null || c5629Kd6 == null || ((Number) c5629Kd6.a().invoke()).floatValue() <= 0.0f) ? false : true;
    }

    private static final List b(C7631Sn6 c7631Sn6) {
        return c7631Sn6.l(false, false, false);
    }

    public static final InterfaceC14603iB2 c(C7631Sn6 c7631Sn6) {
        return (InterfaceC14603iB2) AbstractC5719Kn6.a(c7631Sn6.w(), C5485Jn6.a.v());
    }

    private static final void d(C7631Sn6 c7631Sn6, int i, UA2 ua2) {
        C7631Sn6 c7631Sn62;
        C12544en4 c12544en4 = new C12544en4(new C7631Sn6[16], 0);
        List listB = b(c7631Sn6);
        while (true) {
            c12544en4.h(c12544en4.o(), listB);
            while (c12544en4.o() != 0) {
                c7631Sn62 = (C7631Sn6) c12544en4.w(c12544en4.o() - 1);
                if (!AbstractC13192fo6.f(c7631Sn62) && !c7631Sn62.w().i(C8838Xn6.a.f())) {
                    XA4 xa4E = c7631Sn62.e();
                    if (xa4E == null) {
                        M73.c("Expected semantics node to have a coordinator.");
                        throw new KotlinNothingValueException();
                    }
                    InterfaceC11379cu3 interfaceC11379cu3K1 = xa4E.k1();
                    C25005za3 c25005za3B = AbstractC3239Aa3.b(AbstractC12000du3.c(interfaceC11379cu3K1));
                    if (c25005za3B.m()) {
                        continue;
                    } else {
                        if (!a(c7631Sn62)) {
                            break;
                        }
                        int i2 = i + 1;
                        ua2.invoke(new C6829Pd6(c7631Sn62, i2, c25005za3B, interfaceC11379cu3K1));
                        d(c7631Sn62, i2, ua2);
                    }
                }
            }
            return;
            listB = b(c7631Sn62);
        }
    }

    static /* synthetic */ void e(C7631Sn6 c7631Sn6, int i, UA2 ua2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        d(c7631Sn6, i, ua2);
    }
}
