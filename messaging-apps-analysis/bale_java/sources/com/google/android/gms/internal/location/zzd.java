package com.google.android.gms.internal.location;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC17920nm8;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC25130zm8;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new m();
    private final int a;
    private final int b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;
    private final zzd g;
    private final List h;

    static {
        Process.myUid();
        Process.myPid();
    }

    zzd(int i, int i2, String str, String str2, String str3, int i3, List list, zzd zzdVar) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.f = str3;
        this.e = i3;
        this.h = AbstractC25130zm8.L(list);
        this.g = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzd) {
            zzd zzdVar = (zzd) obj;
            if (this.a == zzdVar.a && this.b == zzdVar.b && this.e == zzdVar.e && this.c.equals(zzdVar.c) && AbstractC17920nm8.a(this.d, zzdVar.d) && AbstractC17920nm8.a(this.f, zzdVar.f) && AbstractC17920nm8.a(this.g, zzdVar.g) && this.h.equals(zzdVar.h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.c, this.d, this.f});
    }

    public final String toString() {
        int length = this.c.length() + 18;
        String str = this.d;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.a);
        sb.append(Separators.SLASH);
        sb.append(this.c);
        if (this.d != null) {
            sb.append("[");
            if (this.d.startsWith(this.c)) {
                sb.append((CharSequence) this.d, this.c.length(), this.d.length());
            } else {
                sb.append(this.d);
            }
            sb.append("]");
        }
        if (this.f != null) {
            sb.append(Separators.SLASH);
            sb.append(Integer.toHexString(this.f.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.t(parcel, 3, this.c, false);
        AbstractC21804u96.t(parcel, 4, this.d, false);
        AbstractC21804u96.n(parcel, 5, this.e);
        AbstractC21804u96.t(parcel, 6, this.f, false);
        AbstractC21804u96.s(parcel, 7, this.g, i, false);
        AbstractC21804u96.x(parcel, 8, this.h, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
