package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzey extends zzas implements IInterface {
    zzey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zzf(Map map, long j, String str, List<zzcp> list) {
        Parcel parcelZza = zza();
        parcelZza.writeMap(map);
        parcelZza.writeLong(j);
        parcelZza.writeString(str);
        parcelZza.writeTypedList(list);
        zzl(1, parcelZza);
    }
}
