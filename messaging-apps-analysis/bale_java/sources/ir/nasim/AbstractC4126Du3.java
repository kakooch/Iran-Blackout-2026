package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.Du3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4126Du3 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final e.c b(JG1 jg1) {
        int iA = AbstractC9572aB4.a(4);
        int iA2 = AbstractC9572aB4.a(2);
        e.c cVarS1 = jg1.h().S1();
        if (cVarS1 == null || (cVarS1.R1() & iA) == 0) {
            return null;
        }
        while (cVarS1 != null && (cVarS1.W1() & iA2) == 0) {
            if ((cVarS1.W1() & iA) != 0) {
                return cVarS1;
            }
            cVarS1 = cVarS1.S1();
        }
        return null;
    }
}
