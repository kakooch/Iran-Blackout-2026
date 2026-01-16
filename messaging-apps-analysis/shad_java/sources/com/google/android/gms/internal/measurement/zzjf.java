package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjf {
    private static final zzjf zza = new zzjf();
    private final ConcurrentMap<Class<?>, zzji<?>> zzc = new ConcurrentHashMap();
    private final zzjj zzb = new zzip();

    private zzjf() {
    }

    public static zzjf zza() {
        return zza;
    }

    public final <T> zzji<T> zzb(Class<T> cls) {
        zzia.zzb(cls, "messageType");
        zzji<T> zzjiVarZza = (zzji) this.zzc.get(cls);
        if (zzjiVarZza == null) {
            zzjiVarZza = this.zzb.zza(cls);
            zzia.zzb(cls, "messageType");
            zzia.zzb(zzjiVarZza, "schema");
            zzji<T> zzjiVar = (zzji) this.zzc.putIfAbsent(cls, zzjiVarZza);
            if (zzjiVar != null) {
                return zzjiVar;
            }
        }
        return zzjiVarZza;
    }
}
