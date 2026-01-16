package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class zzau extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzau> CREATOR = new C2299s();
    private final Bundle a;

    zzau(Bundle bundle) {
        this.a = bundle;
    }

    final Object A0(String str) {
        return this.a.get(str);
    }

    final String C0(String str) {
        return this.a.getString(str);
    }

    public final int P() {
        return this.a.size();
    }

    public final Bundle d0() {
        return new Bundle(this.a);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new r(this);
    }

    final Double s0(String str) {
        return Double.valueOf(this.a.getDouble("value"));
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.e(parcel, 2, d0(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    final Long x0(String str) {
        return Long.valueOf(this.a.getLong("value"));
    }
}
