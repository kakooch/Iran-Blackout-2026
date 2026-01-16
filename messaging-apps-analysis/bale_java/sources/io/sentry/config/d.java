package io.sentry.config;

import android.gov.nist.core.Separators;
import io.sentry.util.B;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class d implements f {
    d() {
    }

    private String i(String str) {
        return "SENTRY_" + str.replace(Separators.DOT, "_").replace("-", "_").toUpperCase(Locale.ROOT);
    }

    @Override // io.sentry.config.f
    public Map a(String str) {
        String strF;
        String str2 = i(str) + "_";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str2) && (strF = B.f(entry.getValue(), Separators.DOUBLE_QUOTE)) != null) {
                concurrentHashMap.put(key.substring(str2.length()).toLowerCase(Locale.ROOT), strF);
            }
        }
        return concurrentHashMap;
    }

    @Override // io.sentry.config.f
    public String f(String str) {
        return B.f(System.getenv(i(str)), Separators.DOUBLE_QUOTE);
    }
}
