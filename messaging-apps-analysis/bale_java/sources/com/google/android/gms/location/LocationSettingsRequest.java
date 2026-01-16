package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new f();
    private final List a;
    private final boolean b;
    private final boolean c;

    public static final class a {
        private final ArrayList a = new ArrayList();
        private boolean b = false;
        private boolean c = false;

        public a a(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                LocationRequest locationRequest = (LocationRequest) it.next();
                if (locationRequest != null) {
                    this.a.add(locationRequest);
                }
            }
            return this;
        }

        public LocationSettingsRequest b() {
            return new LocationSettingsRequest(this.a, this.b, this.c);
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }
    }

    LocationSettingsRequest(List list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.x(parcel, 1, Collections.unmodifiableList(this.a), false);
        AbstractC21804u96.c(parcel, 2, this.b);
        AbstractC21804u96.c(parcel, 3, this.c);
        AbstractC21804u96.b(parcel, iA);
    }
}
