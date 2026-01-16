package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import ir.nasim.AbstractC17219mb8;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new k();
    LocationRequest a;

    zzdd(LocationRequest locationRequest, List list, boolean z, boolean z2, String str, boolean z3, boolean z4, String str2, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WorkSource workSource;
        LocationRequest.a aVar = new LocationRequest.a(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    AbstractC17219mb8.a(workSource, clientIdentity.a, clientIdentity.b);
                }
            }
            aVar.j(workSource);
        }
        if (z) {
            aVar.b(1);
        }
        if (z2) {
            aVar.i(2);
        }
        if (str != null) {
            aVar.h(str);
        } else if (str2 != null) {
            aVar.h(str2);
        }
        if (z3) {
            aVar.g(true);
        }
        if (z4) {
            aVar.f(true);
        }
        if (j != Long.MAX_VALUE) {
            aVar.d(j);
        }
        this.a = aVar.a();
    }

    public static zzdd P(String str, LocationRequest locationRequest) {
        return new zzdd(locationRequest, null, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return DG4.a(this.a, ((zzdd) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 1, this.a, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
