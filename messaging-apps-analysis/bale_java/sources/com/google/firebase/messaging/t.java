package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public class t implements Parcelable.Creator {
    static void c(RemoteMessage remoteMessage, Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.e(parcel, 2, remoteMessage.a, false);
        AbstractC21804u96.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Bundle bundleA = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            if (SafeParcelReader.l(iT) != 2) {
                SafeParcelReader.A(parcel, iT);
            } else {
                bundleA = SafeParcelReader.a(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new RemoteMessage(bundleA);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
