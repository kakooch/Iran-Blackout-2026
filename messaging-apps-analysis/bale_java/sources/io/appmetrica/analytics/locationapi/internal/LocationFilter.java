package io.appmetrica.analytics.locationapi.internal;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/appmetrica/analytics/locationapi/internal/LocationFilter;", "", "", "toString", "other", "", "equals", "", "hashCode", "", "a", "J", "getUpdateTimeInterval", "()J", "updateTimeInterval", "", "b", TokenNames.F, "getUpdateDistanceInterval", "()F", "updateDistanceInterval", "<init>", "(JF)V", "location-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class LocationFilter {

    /* renamed from: a, reason: from kotlin metadata */
    private final long updateTimeInterval;

    /* renamed from: b, reason: from kotlin metadata */
    private final float updateDistanceInterval;

    public LocationFilter() {
        this(0L, 0.0f, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC13042fc3.d(LocationFilter.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.locationapi.internal.LocationFilter");
        }
        LocationFilter locationFilter = (LocationFilter) other;
        return this.updateTimeInterval == locationFilter.updateTimeInterval && this.updateDistanceInterval == locationFilter.updateDistanceInterval;
    }

    public final float getUpdateDistanceInterval() {
        return this.updateDistanceInterval;
    }

    public final long getUpdateTimeInterval() {
        return this.updateTimeInterval;
    }

    public int hashCode() {
        return Float.hashCode(this.updateDistanceInterval) + (Long.hashCode(this.updateTimeInterval) * 31);
    }

    public String toString() {
        return "LocationFilter(updateTimeInterval=" + this.updateTimeInterval + ", updateDistanceInterval=" + this.updateDistanceInterval + ')';
    }

    public LocationFilter(long j, float f) {
        this.updateTimeInterval = j;
        this.updateDistanceInterval = f;
    }

    public /* synthetic */ LocationFilter(long j, float f, int i, ED1 ed1) {
        this((i & 1) != 0 ? 5000L : j, (i & 2) != 0 ? 10.0f : f);
    }
}
