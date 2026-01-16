package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzff implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfi zza;
    private final String zzb;

    public zzff(zzfi zzfiVar, String str) {
        this.zza = zzfiVar;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzx.zzat().zzb().zzb(this.zzb, th);
    }
}
