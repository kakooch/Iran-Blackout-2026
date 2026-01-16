package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzam extends zzgf {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    zzam(zzfl zzflVar) {
        super(zzflVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final boolean zza() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.zzb = sb.toString();
        return false;
    }

    public final long zzb() {
        zzv();
        return this.zza;
    }

    public final String zzc() {
        zzv();
        return this.zzb;
    }

    final long zzd() {
        zzg();
        return this.zze;
    }

    final void zze() {
        zzg();
        this.zzd = null;
        this.zze = 0L;
    }

    final boolean zzf() throws OperationCanceledException, IOException, AuthenticatorException {
        Account[] result;
        zzg();
        long jCurrentTimeMillis = this.zzx.zzax().currentTimeMillis();
        if (jCurrentTimeMillis - this.zze > 86400000) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(this.zzx.zzaw(), "android.permission.GET_ACCOUNTS") != 0) {
            this.zzx.zzat().zzf().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = jCurrentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(this.zzx.zzaw());
        }
        try {
            result = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            this.zzx.zzat().zzc().zzb("Exception checking account types", e);
        }
        if (result != null && result.length > 0) {
            this.zzd = Boolean.TRUE;
            this.zze = jCurrentTimeMillis;
            return true;
        }
        Account[] result2 = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.zzd = Boolean.TRUE;
            this.zze = jCurrentTimeMillis;
            return true;
        }
        this.zze = jCurrentTimeMillis;
        this.zzd = Boolean.FALSE;
        return false;
    }
}
