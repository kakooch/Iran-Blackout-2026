package com.google.android.gms.internal.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzu();
    private String[] zzfi;
    private int[] zzfj;
    private RemoteViews zzfk;
    private byte[] zzfl;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zzfi, false);
        SafeParcelWriter.writeIntArray(parcel, 2, this.zzfj, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzfk, i, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzfl, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzr(String[] strArr, int[] iArr, RemoteViews remoteViews, byte[] bArr) {
        this.zzfi = strArr;
        this.zzfj = iArr;
        this.zzfk = remoteViews;
        this.zzfl = bArr;
    }

    private zzr() {
    }
}
