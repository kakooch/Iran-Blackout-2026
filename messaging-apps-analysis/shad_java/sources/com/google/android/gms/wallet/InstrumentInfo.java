package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class InstrumentInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzl();
    private int zzam;
    private String zzbw;
    private String zzbx;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getInstrumentType(), false);
        SafeParcelWriter.writeString(parcel, 3, getInstrumentDetails(), false);
        SafeParcelWriter.writeInt(parcel, 4, getCardClass());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public InstrumentInfo(String str, String str2, int i) {
        this.zzbw = str;
        this.zzbx = str2;
        this.zzam = i;
    }

    private InstrumentInfo() {
    }

    public final String getInstrumentType() {
        return this.zzbw;
    }

    public final String getInstrumentDetails() {
        return this.zzbx;
    }

    public final int getCardClass() {
        int i = this.zzam;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 0;
    }
}
