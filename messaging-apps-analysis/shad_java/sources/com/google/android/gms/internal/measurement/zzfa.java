package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfa extends zzfg<Long> {
    zzfa(zzfe zzfeVar, String str, Long l, boolean z) {
        super(zzfeVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final /* bridge */ /* synthetic */ Long zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String strZzd = super.zzd();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(strZzd).length() + 25 + str.length());
            sb.append("Invalid long value for ");
            sb.append(strZzd);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
