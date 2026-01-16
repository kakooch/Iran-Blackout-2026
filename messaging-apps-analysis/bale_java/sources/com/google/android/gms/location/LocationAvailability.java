package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    private final int a;
    private final int b;
    private final long c;
    int d;
    private final zzac[] e;
    public static final LocationAvailability f = new LocationAvailability(0, 1, 1, 0, null, true);
    public static final LocationAvailability g = new LocationAvailability(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 1, 1, 0, null, false);
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new c();

    LocationAvailability(int i, int i2, int i3, long j, zzac[] zzacVarArr, boolean z) {
        this.d = i < 1000 ? 0 : AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.a = i2;
        this.b = i3;
        this.c = j;
        this.e = zzacVarArr;
    }

    public boolean P() {
        return this.d < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.a == locationAvailability.a && this.b == locationAvailability.b && this.c == locationAvailability.c && this.d == locationAvailability.d && Arrays.equals(this.e, locationAvailability.e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return DG4.b(Integer.valueOf(this.d));
    }

    public String toString() {
        return "LocationAvailability[" + P() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.q(parcel, 3, this.c);
        AbstractC21804u96.n(parcel, 4, this.d);
        AbstractC21804u96.w(parcel, 5, this.e, i, false);
        AbstractC21804u96.c(parcel, 6, P());
        AbstractC21804u96.b(parcel, iA);
    }
}
