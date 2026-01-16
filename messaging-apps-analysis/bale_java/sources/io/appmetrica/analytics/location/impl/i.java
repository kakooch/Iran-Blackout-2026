package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.CacheArguments;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public final class i {
    public final LocationFilter a;
    public final CacheArguments b;

    public i(LocationFilter locationFilter, CacheArguments cacheArguments) {
        this.a = locationFilter;
        this.b = cacheArguments;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(i.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.location.impl.LocationConfig");
        }
        i iVar = (i) obj;
        return AbstractC13042fc3.d(this.a, iVar.a) && AbstractC13042fc3.d(this.b, iVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "LocationConfig(locationFilter=" + this.a + ", cacheArguments=" + this.b + ')';
    }

    public /* synthetic */ i() {
        this(new LocationFilter(0L, 0.0f, 3, null), new CacheArguments(0L, 0L, 3, null));
    }
}
