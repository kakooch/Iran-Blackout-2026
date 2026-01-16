package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.measurement.zzlc;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzjc extends zzjv {
    private String zzb;
    private boolean zzc;
    private long zzd;

    zzjc(zzkd zzkdVar) {
        super(zzkdVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        return false;
    }

    final Pair<String, Boolean> zzc(String str, zzaf zzafVar) {
        zzlc.zzb();
        return (!this.zzx.zzc().zzn(null, zzdw.zzay) || zzafVar.zzf()) ? zzd(str) : new Pair<>(BuildConfig.FLAVOR, Boolean.FALSE);
    }

    @Deprecated
    final Pair<String, Boolean> zzd(String str) {
        zzg();
        long jElapsedRealtime = this.zzx.zzax().elapsedRealtime();
        String str2 = this.zzb;
        if (str2 != null && jElapsedRealtime < this.zzd) {
            return new Pair<>(str2, Boolean.valueOf(this.zzc));
        }
        this.zzd = jElapsedRealtime + this.zzx.zzc().zzj(str, zzdw.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzx.zzaw());
            if (advertisingIdInfo != null) {
                this.zzb = advertisingIdInfo.getId();
                this.zzc = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzb == null) {
                this.zzb = BuildConfig.FLAVOR;
            }
        } catch (Exception e) {
            this.zzx.zzat().zzj().zzb("Unable to get advertising id", e);
            this.zzb = BuildConfig.FLAVOR;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzb, Boolean.valueOf(this.zzc));
    }

    @Deprecated
    final String zzf(String str) throws NoSuchAlgorithmException {
        zzg();
        String str2 = (String) zzd(str).first;
        MessageDigest messageDigestZzN = zzkk.zzN();
        if (messageDigestZzN == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzN.digest(str2.getBytes())));
    }
}
