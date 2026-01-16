package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class zze implements Parcelable.Creator<CardRequirements> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CardRequirements[] newArray(int i) {
        return new CardRequirements[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CardRequirements createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        int i = 0;
        boolean z2 = true;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
            } else if (fieldId == 2) {
                z2 = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 3) {
                z = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 4) {
                i = SafeParcelReader.readInt(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new CardRequirements(arrayListCreateIntegerList, z2, z, i);
    }
}
