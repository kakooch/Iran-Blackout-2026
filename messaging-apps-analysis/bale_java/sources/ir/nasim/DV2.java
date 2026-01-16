package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.G;

/* loaded from: classes2.dex */
public abstract class DV2 {
    public static final G.c a(Context context, androidx.navigation.d dVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(dVar, "navBackStackEntry");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                G.c cVarE = CV2.e((Activity) context, dVar, dVar.c(), dVar.n3());
                AbstractC13042fc3.h(cVarE, "HiltViewModelFactory.cre…delProviderFactory,\n    )");
                return cVarE;
            }
            context = ((ContextWrapper) context).getBaseContext();
            AbstractC13042fc3.h(context, "ctx.baseContext");
        }
        throw new IllegalStateException("Expected an activity context for creating a HiltViewModelFactory for a NavBackStackEntry but instead found: " + context);
    }
}
