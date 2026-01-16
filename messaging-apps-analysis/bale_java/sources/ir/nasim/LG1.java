package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
public abstract class LG1 {
    public static final View a(JG1 jg1) {
        if (!jg1.h().b2()) {
            M73.b("Cannot get View because the Modifier node is not currently attached.");
        }
        Object objB = AbstractC4360Eu3.b(KG1.o(jg1));
        AbstractC13042fc3.g(objB, "null cannot be cast to non-null type android.view.View");
        return (View) objB;
    }
}
