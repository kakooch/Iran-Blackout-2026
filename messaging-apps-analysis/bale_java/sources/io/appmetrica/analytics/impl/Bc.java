package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerFactory;
import ir.nasim.AbstractC19460qO3;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Bc {
    public final LinkedHashMap a = new LinkedHashMap();

    public final LinkedHashMap a(String str) {
        LinkedHashMap linkedHashMap = this.a;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(AbstractC19460qO3.f(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((ModuleEventServiceHandlerFactory) entry.getValue()).createEventHandler(str));
        }
        return linkedHashMap2;
    }
}
