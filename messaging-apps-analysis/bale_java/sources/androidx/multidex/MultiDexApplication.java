package androidx.multidex;

import android.app.Application;
import android.content.Context;
import ir.nasim.AbstractC18497ol4;

/* loaded from: classes2.dex */
public class MultiDexApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        AbstractC18497ol4.l(this);
    }
}
