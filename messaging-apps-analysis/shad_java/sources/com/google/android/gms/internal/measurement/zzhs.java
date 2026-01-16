package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzhs<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzgb<MessageType, BuilderType> {
    private static final Map<Object, zzhs<?, ?>> zza = new ConcurrentHashMap();
    protected zzjx zzc = zzjx.zza();
    protected int zzd = -1;

    static Object zzbA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static zzhx zzbB() {
        return zzht.zzd();
    }

    protected static zzhy zzbC() {
        return zzim.zzf();
    }

    protected static zzhy zzbD(zzhy zzhyVar) {
        int size = zzhyVar.size();
        return zzhyVar.zze(size == 0 ? 10 : size + size);
    }

    protected static <E> zzhz<E> zzbE() {
        return zzjg.zzd();
    }

    protected static <E> zzhz<E> zzbF(zzhz<E> zzhzVar) {
        int size = zzhzVar.size();
        return zzhzVar.zze(size == 0 ? 10 : size + size);
    }

    static <T extends zzhs> T zzbx(Class<T> cls) throws ClassNotFoundException {
        Map<Object, zzhs<?, ?>> map = zza;
        zzhs<?, ?> zzhsVar = map.get(cls);
        if (zzhsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhsVar = map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzhsVar == null) {
            zzhsVar = (zzhs) ((zzhs) zzkh.zzc(cls)).zzl(6, null, null);
            if (zzhsVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzhsVar);
        }
        return zzhsVar;
    }

    protected static <T extends zzhs> void zzby(Class<T> cls, T t) {
        zza.put(cls, t);
    }

    protected static Object zzbz(zzix zzixVar, String str, Object[] objArr) {
        return new zzjh(zzixVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjf.zza().zzb(getClass()).zzb(this, (zzhs) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iZzc = zzjf.zza().zzb(getClass()).zzc(this);
        this.zzb = iZzc;
        return iZzc;
    }

    public final String toString() {
        return zziz.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final /* bridge */ /* synthetic */ zziw zzbG() {
        zzho zzhoVar = (zzho) zzl(5, null, null);
        zzhoVar.zzaB(this);
        return zzhoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final /* bridge */ /* synthetic */ zziw zzbH() {
        return (zzho) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return (zzhs) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgb
    final int zzbq() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzgb
    final void zzbr(int i) {
        this.zzd = i;
    }

    protected final <MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> BuilderType zzbt() {
        return (BuilderType) zzl(5, null, null);
    }

    public final BuilderType zzbu() {
        BuilderType buildertype = (BuilderType) zzl(5, null, null);
        buildertype.zzaB(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final void zzbv(zzgz zzgzVar) throws IOException {
        zzjf.zza().zzb(getClass()).zzm(this, zzha.zza(zzgzVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final int zzbw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int iZze = zzjf.zza().zzb(getClass()).zze(this);
        this.zzd = iZze;
        return iZze;
    }

    protected abstract Object zzl(int i, Object obj, Object obj2);
}
