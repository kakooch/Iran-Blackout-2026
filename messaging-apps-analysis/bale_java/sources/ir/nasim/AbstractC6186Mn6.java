package ir.nasim;

import androidx.compose.ui.semantics.SemanticsConfiguration;

/* renamed from: ir.nasim.Mn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6186Mn6 {
    public static final SemanticsConfiguration a(InterfaceC5953Ln6 interfaceC5953Ln6) {
        SemanticsConfiguration semanticsConfigurationE = interfaceC5953Ln6.e();
        if (semanticsConfigurationE != null && semanticsConfigurationE.C() && !semanticsConfigurationE.B()) {
            semanticsConfigurationE = semanticsConfigurationE.o();
            C3587Bm4 c3587Bm4 = new C3587Bm4(interfaceC5953Ln6.t().size());
            c3587Bm4.r(interfaceC5953Ln6.t());
            while (c3587Bm4.h()) {
                InterfaceC5953Ln6 interfaceC5953Ln62 = (InterfaceC5953Ln6) c3587Bm4.A(c3587Bm4.b - 1);
                SemanticsConfiguration semanticsConfigurationE2 = interfaceC5953Ln62.e();
                if (semanticsConfigurationE2 != null && !semanticsConfigurationE2.C()) {
                    semanticsConfigurationE.E(semanticsConfigurationE2);
                    if (!semanticsConfigurationE2.B()) {
                        c3587Bm4.r(interfaceC5953Ln62.t());
                    }
                }
            }
        }
        return semanticsConfigurationE;
    }
}
