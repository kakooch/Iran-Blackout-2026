package ir.nasim;

import androidx.fragment.app.FragmentManager;

/* renamed from: ir.nasim.lN1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC16494lN1 {
    public static final void a(androidx.fragment.app.l lVar) {
        AbstractC13042fc3.i(lVar, "<this>");
        try {
            if (lVar.u6()) {
                lVar.u8();
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public static final void b(androidx.fragment.app.l lVar, FragmentManager fragmentManager) {
        AbstractC13042fc3.i(lVar, "<this>");
        AbstractC13042fc3.i(fragmentManager, "fragmentManager");
        try {
            if (lVar.u6()) {
                return;
            }
            lVar.K8(fragmentManager, null);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }
}
