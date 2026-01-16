package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zziz implements Runnable {
    final /* synthetic */ zzja zza;

    zziz(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjb.zzK(this.zza.zza, null);
        this.zza.zza.zzR();
    }
}
