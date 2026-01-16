package com.google.android.gms.common;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import ir.nasim.Uk8;

/* loaded from: classes3.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new Uk8();
    private final String a;
    private final int b;
    private final long c;

    public Feature(String str, int i, long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public String P() {
        return this.a;
    }

    public long S() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((P() != null && P().equals(feature.P())) || (P() == null && feature.P() == null)) && S() == feature.S()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(P(), Long.valueOf(S()));
    }

    public final String toString() {
        DG4.a aVarC = DG4.c(this);
        aVarC.a("name", P());
        aVarC.a(ParameterNames.VERSION, Long.valueOf(S()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 1, P(), false);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.q(parcel, 3, S());
        AbstractC21804u96.b(parcel, iA);
    }

    public Feature(String str, long j) {
        this.a = str;
        this.c = j;
        this.b = -1;
    }
}
