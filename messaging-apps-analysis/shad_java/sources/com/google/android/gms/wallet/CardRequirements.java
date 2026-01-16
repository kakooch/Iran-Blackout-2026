package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class CardRequirements extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CardRequirements> CREATOR = new zze();
    ArrayList<Integer> zzao;
    boolean zzap;
    boolean zzaq;
    int zzar;

    CardRequirements(ArrayList<Integer> arrayList, boolean z, boolean z2, int i) {
        this.zzao = arrayList;
        this.zzap = z;
        this.zzaq = z2;
        this.zzar = i;
    }

    private CardRequirements() {
        this.zzap = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzao, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzap);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzar);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
