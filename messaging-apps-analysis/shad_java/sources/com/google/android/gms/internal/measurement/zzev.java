package com.google.android.gms.internal.measurement;

import android.net.Uri;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzev {
    private final Map<String, Map<String, String>> zza;

    zzev(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        Map<String, String> map = this.zza.get(uri.toString());
        if (map == null) {
            return null;
        }
        String strValueOf = String.valueOf(str3);
        return map.get(strValueOf.length() != 0 ? BuildConfig.FLAVOR.concat(strValueOf) : new String(BuildConfig.FLAVOR));
    }
}
