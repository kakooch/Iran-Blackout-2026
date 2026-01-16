package io.sentry.internal.modules;

import io.sentry.ILogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class a extends d {
    private final List e;

    public a(List list, ILogger iLogger) {
        super(iLogger);
        this.e = list;
    }

    @Override // io.sentry.internal.modules.d
    protected Map b() {
        TreeMap treeMap = new TreeMap();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Map mapA = ((b) it.next()).a();
            if (mapA != null) {
                treeMap.putAll(mapA);
            }
        }
        return treeMap;
    }
}
