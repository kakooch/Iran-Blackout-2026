package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public final class P9 implements Parcelable {
    public static final O9 CREATOR = new O9();
    public final Boolean a;
    public final IdentifierStatus b;
    public final String c;

    public P9(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.a = bool;
        this.b = identifierStatus;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P9)) {
            return false;
        }
        P9 p9 = (P9) obj;
        return AbstractC13042fc3.d(this.a, p9.a) && this.b == p9.b && AbstractC13042fc3.d(this.c, p9.c);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public P9() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
