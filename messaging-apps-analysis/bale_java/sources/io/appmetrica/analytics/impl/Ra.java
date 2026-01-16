package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Ra implements Parcelable {
    public static final Parcelable.Creator<Ra> CREATOR = new Qa();
    public final ResultReceiver a;
    public final List b;
    public final HashMap c;

    public Ra(ResultReceiverC2988y6 resultReceiverC2988y6, List list, Map map) {
        this.b = list;
        this.a = resultReceiverC2988y6;
        this.c = map == null ? new HashMap() : new HashMap(map);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver", this.a);
        if (this.b != null) {
            bundle.putStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        HashMap map = this.c;
        if (map != null) {
            bundle.putString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification", Gl.a((Map) map));
        }
        parcel.writeBundle(bundle);
    }

    public Ra(Parcel parcel) {
        Bundle bundle = parcel.readBundle(ResultReceiverC2988y6.class.getClassLoader());
        if (bundle != null) {
            this.a = (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver");
            this.b = bundle.getStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList");
            this.c = Gl.a(bundle.getString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification"));
            return;
        }
        this.c = new HashMap();
    }
}
