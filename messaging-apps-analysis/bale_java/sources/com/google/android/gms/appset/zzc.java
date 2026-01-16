package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C10541bm8;

/* loaded from: classes3.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new C10541bm8();
    private final String a;
    private final int b;

    public zzc(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final int P() {
        return this.b;
    }

    public final String S() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 1, this.a, false);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.b(parcel, iA);
    }
}
