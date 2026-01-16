package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.b;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* loaded from: classes3.dex */
public abstract class zzbt {
    public static final String zza;
    public static final String zzb;

    static {
        String strReplaceAll = String.valueOf(b.a / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zza = strReplaceAll;
        String strValueOf = String.valueOf(strReplaceAll);
        zzb = strValueOf.length() != 0 ? "ma".concat(strValueOf) : new String("ma");
    }
}
