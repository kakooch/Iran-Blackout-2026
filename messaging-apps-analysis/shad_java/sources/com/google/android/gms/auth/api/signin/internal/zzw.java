package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
public final class zzw extends com.google.android.gms.internal.p000authapi.zzd implements zzt {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzd(zzr zzrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZzc = zzc();
        com.google.android.gms.internal.p000authapi.zzf.zzc(parcelZzc, zzrVar);
        com.google.android.gms.internal.p000authapi.zzf.zzc(parcelZzc, googleSignInOptions);
        zzc(102, parcelZzc);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zze(zzr zzrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZzc = zzc();
        com.google.android.gms.internal.p000authapi.zzf.zzc(parcelZzc, zzrVar);
        com.google.android.gms.internal.p000authapi.zzf.zzc(parcelZzc, googleSignInOptions);
        zzc(103, parcelZzc);
    }
}
