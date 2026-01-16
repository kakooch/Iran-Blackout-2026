package ir.nasim;

import androidx.compose.ui.semantics.SemanticsConfiguration;

/* renamed from: ir.nasim.jn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15557jn {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(SemanticsConfiguration semanticsConfiguration) {
        return semanticsConfiguration.A().b(C5485Jn6.a.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(SemanticsConfiguration semanticsConfiguration) {
        return semanticsConfiguration.A().b(C8838Xn6.a.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(SemanticsConfiguration semanticsConfiguration) {
        if (!semanticsConfiguration.A().b(C5485Jn6.a.k())) {
            C7386Rm4 c7386Rm4A = semanticsConfiguration.A();
            C8838Xn6 c8838Xn6 = C8838Xn6.a;
            if (!c7386Rm4A.b(c8838Xn6.e()) && !semanticsConfiguration.A().b(c8838Xn6.c())) {
                return false;
            }
        }
        return true;
    }
}
