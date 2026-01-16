package androidx.tracing.perfetto;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/tracing/perfetto/StartupTracingConfigStoreIsEnabledGate;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "tracing-perfetto_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
abstract class StartupTracingConfigStoreIsEnabledGate extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: androidx.tracing.perfetto.StartupTracingConfigStoreIsEnabledGate$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        private final ComponentName c(Context context) {
            return new ComponentName(context, StartupTracingConfigStoreIsEnabledGate.class.getName());
        }

        private final void e(Context context, boolean z) {
            context.getPackageManager().setComponentEnabledSetting(c(context), z ? 1 : 2, 1);
        }

        public final void a(Context context) {
            AbstractC13042fc3.i(context, "context");
            e(context, false);
        }

        public final void b(Context context) {
            AbstractC13042fc3.i(context, "context");
            e(context, true);
        }

        public final boolean d(Context context) {
            AbstractC13042fc3.i(context, "context");
            return context.getPackageManager().getComponentEnabledSetting(c(context)) == 1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }
}
