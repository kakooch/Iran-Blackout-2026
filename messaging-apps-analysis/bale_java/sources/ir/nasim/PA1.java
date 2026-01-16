package ir.nasim;

import android.util.Log;
import java.util.Map;

/* loaded from: classes5.dex */
public final class PA1 implements InterfaceC19567qa2 {
    public static final PA1 a = new PA1();

    private PA1() {
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void a(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        Log.i("DebugAnalytics", "sendEvent: " + str + ", map: " + map);
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void b(String str) {
        AbstractC13042fc3.i(str, "eventName");
        Log.i("DebugAnalytics", "sendEvent: " + str);
    }
}
