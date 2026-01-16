package com.google.android.gms.tagmanager;

import android.gov.nist.core.Separators;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzea {
    private static zzea zza;
    private volatile int zze = 1;
    private volatile String zzc = null;
    private volatile String zzb = null;
    private volatile String zzd = null;

    zzea() {
    }

    static zzea zza() {
        zzea zzeaVar;
        synchronized (zzea.class) {
            try {
                if (zza == null) {
                    zza = new zzea();
                }
                zzeaVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeaVar;
    }

    private static final String zzf(String str) {
        return str.split(Separators.AND)[0].split(Separators.EQUALS)[1];
    }

    final String zzb() {
        return this.zzc;
    }

    final String zzc() {
        return this.zzb;
    }

    final synchronized boolean zzd(Uri uri) {
        try {
            try {
                String strDecode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (!strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    if (!strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        zzdh.zzc(strDecode.length() != 0 ? "Invalid preview uri: ".concat(strDecode) : new String("Invalid preview uri: "));
                        return false;
                    }
                    if (!zzf(uri.getQuery()).equals(this.zzb)) {
                        return false;
                    }
                    String strValueOf = String.valueOf(this.zzb);
                    zzdh.zzb.zzd(strValueOf.length() != 0 ? "Exit preview mode for container: ".concat(strValueOf) : new String("Exit preview mode for container: "));
                    this.zze = 1;
                    this.zzc = null;
                    return true;
                }
                zzdh.zzb.zzd(strDecode.length() != 0 ? "Container preview url: ".concat(strDecode) : new String("Container preview url: "));
                if (strDecode.matches(".*?&gtm_debug=x$")) {
                    this.zze = 3;
                } else {
                    this.zze = 2;
                }
                this.zzd = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zze == 2 || this.zze == 3) {
                    String strValueOf2 = String.valueOf(this.zzd);
                    this.zzc = strValueOf2.length() != 0 ? "/r?".concat(strValueOf2) : new String("/r?");
                }
                this.zzb = zzf(this.zzd);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    final int zze() {
        return this.zze;
    }
}
