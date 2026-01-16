package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import ir.nasim.AbstractC12739f72;
import ir.nasim.AbstractC13042fc3;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class m {
    public static final m a = new m();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static final class a extends AbstractC12739f72 {
        @Override // ir.nasim.AbstractC12739f72, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            AbstractC13042fc3.i(activity, "activity");
            x.INSTANCE.c(activity);
        }
    }

    private m() {
    }

    public static final void a(Context context) {
        AbstractC13042fc3.i(context, "context");
        if (b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        AbstractC13042fc3.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
