package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.messaging.AbstractC2365b;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new t();
    Bundle a;
    private Map b;

    public RemoteMessage(Bundle bundle) {
        this.a = bundle;
    }

    public Map P() {
        if (this.b == null) {
            this.b = AbstractC2365b.a.a(this.a);
        }
        return this.b;
    }

    public Intent S() {
        Intent intent = new Intent();
        intent.putExtras(this.a);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        t.c(this, parcel, i);
    }
}
