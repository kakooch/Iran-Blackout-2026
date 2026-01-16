package ir.nasim;

import android.content.Context;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.Map;

/* renamed from: ir.nasim.vc8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22660vc8 implements InterfaceC19567qa2 {
    private static final a a = new a(null);

    /* renamed from: ir.nasim.vc8$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22660vc8(Context context) {
        AbstractC13042fc3.i(context, "context");
        AppMetricaConfig appMetricaConfigBuild = AppMetricaConfig.newConfigBuilder("8517f14f-5730-4f64-a8ed-7140c6793455").withAnrMonitoring(true).build();
        AbstractC13042fc3.h(appMetricaConfigBuild, "build(...)");
        AppMetrica.activate(context, appMetricaConfigBuild);
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void a(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        AppMetrica.reportEvent(str, (Map<String, Object>) map);
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void b(String str) {
        AbstractC13042fc3.i(str, "eventName");
        AppMetrica.reportEvent(str);
    }
}
