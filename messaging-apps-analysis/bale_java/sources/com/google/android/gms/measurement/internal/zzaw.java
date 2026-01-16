package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new C2304t();
    public final String a;
    public final zzau b;
    public final String c;
    public final long d;

    zzaw(zzaw zzawVar, long j) {
        AbstractC3795Cj5.j(zzawVar);
        this.a = zzawVar.a;
        this.b = zzawVar.b;
        this.c = zzawVar.c;
        this.d = j;
    }

    public final String toString() {
        return "origin=" + this.c + ",name=" + this.a + ",params=" + String.valueOf(this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C2304t.a(this, parcel, i);
    }

    public zzaw(String str, zzau zzauVar, String str2, long j) {
        this.a = str;
        this.b = zzauVar;
        this.c = str2;
        this.d = j;
    }
}
