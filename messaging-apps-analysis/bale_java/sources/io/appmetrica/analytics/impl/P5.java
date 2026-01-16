package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;

/* loaded from: classes3.dex */
public final class P5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        EnumC2585h9 enumC2585h9;
        Bundle bundle = parcel.readBundle(ResultReceiverC2988y6.class.getClassLoader());
        if (bundle.containsKey("CounterReport.Source")) {
            int i = bundle.getInt("CounterReport.Source");
            EnumC2585h9[] enumC2585h9ArrValues = EnumC2585h9.values();
            int length = enumC2585h9ArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC2585h9 = EnumC2585h9.NATIVE;
                    break;
                }
                enumC2585h9 = enumC2585h9ArrValues[i2];
                if (enumC2585h9.a == i) {
                    break;
                }
                i2++;
            }
        } else {
            enumC2585h9 = null;
        }
        Q5 q5 = new Q5("", "", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = bundle.getInt("CounterReport.Type", -1);
        q5.e = bundle.getInt("CounterReport.CustomType");
        q5.b = StringUtils.ifIsNullToDef(bundle.getString("CounterReport.Value"), "");
        q5.c = bundle.getString("CounterReport.Environment");
        q5.a = bundle.getString("CounterReport.Event");
        q5.f = Q5.a(bundle);
        q5.g = bundle.getInt("CounterReport.TRUNCATED");
        q5.h = bundle.getString("CounterReport.ProfileID");
        q5.i = bundle.getLong("CounterReport.CreationElapsedRealtime");
        q5.j = bundle.getLong("CounterReport.CreationTimestamp");
        q5.k = X9.a(Integer.valueOf(bundle.getInt("CounterReport.UniquenessStatus")));
        q5.l = enumC2585h9;
        q5.m = bundle.getBundle("CounterReport.Payload");
        q5.n = bundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(bundle.getBoolean("CounterReport.AttributionIdChanged")) : null;
        q5.o = bundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(bundle.getInt("CounterReport.OpenId")) : null;
        q5.p = CollectionUtils.bundleToMap(bundle.getBundle("CounterReport.Extras"));
        return q5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Q5[i];
    }
}
