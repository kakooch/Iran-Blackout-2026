package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzad();
    private String zzdy;
    private String zzdz;
    private int zzea;
    private int zzeb;

    public zzae(String str, String str2, int i, int i2) {
        this.zzdy = str;
        this.zzdz = str2;
        this.zzea = i;
        this.zzeb = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdy, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdz, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzea);
        SafeParcelWriter.writeInt(parcel, 5, this.zzeb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
