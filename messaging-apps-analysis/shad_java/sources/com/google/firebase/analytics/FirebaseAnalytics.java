package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes3.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzbr zzb;

    public FirebaseAnalytics(zzbr zzbrVar) {
        Preconditions.checkNotNull(zzbrVar);
        this.zzb = zzbrVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(@RecentlyNonNull Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    zza = new FirebaseAnalytics(zzbr.zza(context, null, null, null, null));
                }
            }
        }
        return zza;
    }

    @Keep
    public static zzho getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzbr zzbrVarZza = zzbr.zza(context, null, null, null, bundle);
        if (zzbrVarZza == null) {
            return null;
        }
        return new zzc(zzbrVarZza);
    }

    @RecentlyNonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.getInstance().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public void logEvent(@RecentlyNonNull String str, Bundle bundle) {
        this.zzb.zzg(str, bundle);
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(@RecentlyNonNull Activity activity, String str, String str2) {
        this.zzb.zzo(activity, str, str2);
    }
}
