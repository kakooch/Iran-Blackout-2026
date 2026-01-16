package ir.nasim;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;

/* renamed from: ir.nasim.sc5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC20790sc5 {
    public static final Context a(Context context, int i) {
        AbstractC13042fc3.i(context, "<this>");
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.uiMode = (configuration.uiMode & (-49)) | 32;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        if (i != 0) {
            return new ContextThemeWrapper(contextCreateConfigurationContext, i);
        }
        AbstractC13042fc3.f(contextCreateConfigurationContext);
        return contextCreateConfigurationContext;
    }

    public static /* synthetic */ Context b(Context context, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = AbstractC23035wE5.MainActivityTheme;
        }
        return a(context, i);
    }
}
