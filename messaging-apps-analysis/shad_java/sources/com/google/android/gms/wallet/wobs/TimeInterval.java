package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class TimeInterval extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TimeInterval> CREATOR = new zzk();
    private long zzge;
    private long zzgf;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zzge);
        SafeParcelWriter.writeLong(parcel, 3, this.zzgf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public TimeInterval(long j, long j2) {
        this.zzge = j;
        this.zzgf = j2;
    }

    TimeInterval() {
    }
}
