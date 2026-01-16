package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class LabelValueRow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LabelValueRow> CREATOR = new zze();

    @Deprecated
    String zzfq;

    @Deprecated
    String zzfr;
    ArrayList<LabelValue> zzfs;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzfq, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzfr, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzfs, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    LabelValueRow(String str, String str2, ArrayList<LabelValue> arrayList) {
        this.zzfq = str;
        this.zzfr = str2;
        this.zzfs = arrayList;
    }
}
