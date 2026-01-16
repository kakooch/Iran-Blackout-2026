package io.sentry.config;

import android.gov.nist.core.Separators;
import io.sentry.util.B;
import io.sentry.util.u;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
abstract class a implements f {
    private final String a;
    private final Properties b;

    protected a(String str, Properties properties) {
        this.a = (String) u.c(str, "prefix is required");
        this.b = (Properties) u.c(properties, "properties are required");
    }

    @Override // io.sentry.config.f
    public Map a(String str) {
        String str2 = this.a + str + Separators.DOT;
        HashMap map = new HashMap();
        for (Map.Entry entry : this.b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str3 = (String) entry.getKey();
                if (str3.startsWith(str2)) {
                    map.put(str3.substring(str2.length()), B.f((String) entry.getValue(), Separators.DOUBLE_QUOTE));
                }
            }
        }
        return map;
    }

    @Override // io.sentry.config.f
    public String f(String str) {
        return B.f(this.b.getProperty(this.a + str), Separators.DOUBLE_QUOTE);
    }

    protected a(Properties properties) {
        this("", properties);
    }
}
