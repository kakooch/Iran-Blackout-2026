package io.sentry.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class c implements f {
    private final List a;

    public c(List list) {
        this.a = list;
    }

    @Override // io.sentry.config.f
    public Map a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            concurrentHashMap.putAll(((f) it.next()).a(str));
        }
        return concurrentHashMap;
    }

    @Override // io.sentry.config.f
    public String f(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            String strF = ((f) it.next()).f(str);
            if (strF != null) {
                return strF;
            }
        }
        return null;
    }
}
