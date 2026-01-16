package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.EnumC23376wo8;
import ir.nasim.Qu8;

/* loaded from: classes3.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new Qu8();
    private final String a;
    private final int b;
    public final int c;
    private final String d;
    private final String e;
    private final boolean f;
    public final String g;
    private final boolean h;
    private final int i;

    public zzr(String str, int i, int i2, String str2, String str3, String str4, boolean z, EnumC23376wo8 enumC23376wo8) {
        this.a = (String) AbstractC3795Cj5.j(str);
        this.b = i;
        this.c = i2;
        this.g = str2;
        this.d = str3;
        this.e = str4;
        this.f = !z;
        this.h = z;
        this.i = enumC23376wo8.j();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzr) {
            zzr zzrVar = (zzr) obj;
            if (DG4.a(this.a, zzrVar.a) && this.b == zzrVar.b && this.c == zzrVar.c && DG4.a(this.g, zzrVar.g) && DG4.a(this.d, zzrVar.d) && DG4.a(this.e, zzrVar.e) && this.f == zzrVar.f && this.h == zzrVar.h && this.i == zzrVar.i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), this.g, this.d, this.e, Boolean.valueOf(this.f), Boolean.valueOf(this.h), Integer.valueOf(this.i));
    }

    public final String toString() {
        return "PlayLoggerContext[package=" + this.a + ",packageVersionCode=" + this.b + ",logSource=" + this.c + ",logSourceName=" + this.g + ",uploadAccount=" + this.d + ",loggingId=" + this.e + ",logAndroidId=" + this.f + ",isAnonymous=" + this.h + ",qosTier=" + this.i + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, this.a, false);
        AbstractC21804u96.n(parcel, 3, this.b);
        AbstractC21804u96.n(parcel, 4, this.c);
        AbstractC21804u96.t(parcel, 5, this.d, false);
        AbstractC21804u96.t(parcel, 6, this.e, false);
        AbstractC21804u96.c(parcel, 7, this.f);
        AbstractC21804u96.t(parcel, 8, this.g, false);
        AbstractC21804u96.c(parcel, 9, this.h);
        AbstractC21804u96.n(parcel, 10, this.i);
        AbstractC21804u96.b(parcel, iA);
    }

    public zzr(String str, int i, int i2, String str2, String str3, boolean z, String str4, boolean z2, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = str3;
        this.f = z;
        this.g = str4;
        this.h = z2;
        this.i = i3;
    }
}
