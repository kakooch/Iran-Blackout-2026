package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class agm extends agj {
    private final aic<String, agj> a = new aic<>();

    public final void a(String str, agj agjVar) {
        this.a.put(str, agjVar);
    }

    public final Set<Map.Entry<String, agj>> b() {
        return this.a.entrySet();
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof agm) && ((agm) obj).a.equals(this.a));
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
