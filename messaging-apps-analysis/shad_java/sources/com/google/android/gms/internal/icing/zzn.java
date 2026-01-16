package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzn implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        zzt zztVar = null;
        byte[] bArrCreateByteArray = null;
        int i = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                zztVar = (zzt) SafeParcelReader.createParcelable(parcel, header, zzt.CREATOR);
            } else if (fieldId == 4) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 5) {
                bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzk(strCreateString, zztVar, i, bArrCreateByteArray);
    }
}
