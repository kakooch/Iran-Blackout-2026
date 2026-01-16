package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public final class Ne implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Bundle bundle = parcel.readBundle(ResultReceiverC2988y6.class.getClassLoader());
        return new Oe((ContentValues) bundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT"), (ResultReceiver) bundle.getParcelable("CFG_KEY_PROCESS_ENVIRONMENT_RECEIVER"));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Oe[i];
    }
}
