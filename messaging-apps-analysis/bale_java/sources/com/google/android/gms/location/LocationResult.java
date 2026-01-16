package com.google.android.gms.location;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    private final List a;
    static final List b = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new e();

    LocationResult(List list) {
        this.a = list;
    }

    public Location P() {
        int size = this.a.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.a.get(size - 1);
    }

    public List S() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (Build.VERSION.SDK_INT >= 31) {
            return this.a.equals(locationResult.a);
        }
        if (this.a.size() != locationResult.a.size()) {
            return false;
        }
        Iterator it = locationResult.a.iterator();
        for (Location location : this.a) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !DG4.a(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return DG4.b(this.a);
    }

    public String toString() {
        return "LocationResult".concat(String.valueOf(this.a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.x(parcel, 1, S(), false);
        AbstractC21804u96.b(parcel, iA);
    }
}
