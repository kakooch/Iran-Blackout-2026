package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
public final class zzq {
    private static zzq zzcq;
    private Storage zzcr;

    private zzq(Context context) {
        Storage storage = Storage.getInstance(context);
        this.zzcr = storage;
        storage.getSavedDefaultGoogleSignInAccount();
        this.zzcr.getSavedDefaultGoogleSignInOptions();
    }

    public static synchronized zzq zzd(Context context) {
        return zze(context.getApplicationContext());
    }

    private static synchronized zzq zze(Context context) {
        zzq zzqVar = zzcq;
        if (zzqVar != null) {
            return zzqVar;
        }
        zzq zzqVar2 = new zzq(context);
        zzcq = zzqVar2;
        return zzqVar2;
    }

    public final synchronized void clear() {
        this.zzcr.clear();
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzcr.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
    }
}
