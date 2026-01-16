package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjk {
    private static final Class<?> zza;
    private static final zzjw<?, ?> zzb;
    private static final zzjw<?, ?> zzc;
    private static final zzjw<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzjy();
    }

    public static zzjw<?, ?> zzA() {
        return zzb;
    }

    public static zzjw<?, ?> zzB() {
        return zzc;
    }

    public static zzjw<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T, FT extends zzhi<FT>> void zzE(zzhf<FT> zzhfVar, T t, T t2) {
        zzhfVar.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzjw<UT, UB> zzjwVar, T t, T t2) {
        zzjwVar.zzc(t, zzjwVar.zzf(zzjwVar.zzd(t), zzjwVar.zzd(t2)));
    }

    static <UT, UB> UB zzG(int i, List<Integer> list, zzhw zzhwVar, UB ub, zzjw<UT, UB> zzjwVar) {
        if (zzhwVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzhwVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zzH(i, iIntValue, ub, zzjwVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzhwVar.zza(iIntValue2)) {
                    ub = (UB) zzH(i, iIntValue2, ub, zzjwVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zzH(int i, int i2, UB ub, zzjw<UT, UB> zzjwVar) {
        if (ub == null) {
            ub = zzjwVar.zzb();
        }
        zzjwVar.zza(ub, i, i2);
        return ub;
    }

    static <T> void zzI(zzis zzisVar, T t, T t2, long j) {
        zzkh.zzo(t, j, zzis.zzb(zzkh.zzn(t, j), zzkh.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzB(i, list, z);
    }

    public static void zzK(int i, List<Float> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzA(i, list, z);
    }

    public static void zzL(int i, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzx(i, list, z);
    }

    public static void zzM(int i, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzy(i, list, z);
    }

    public static void zzN(int i, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzK(i, list, z);
    }

    public static void zzO(int i, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzz(i, list, z);
    }

    public static void zzP(int i, List<Long> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzI(i, list, z);
    }

    public static void zzQ(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzv(i, list, z);
    }

    public static void zzR(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzG(i, list, z);
    }

    public static void zzS(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzJ(i, list, z);
    }

    public static void zzT(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzw(i, list, z);
    }

    public static void zzU(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzH(i, list, z);
    }

    public static void zzV(int i, List<Integer> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzC(i, list, z);
    }

    public static void zzW(int i, List<Boolean> list, zzha zzhaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzD(i, list, z);
    }

    public static void zzX(int i, List<String> list, zzha zzhaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzE(i, list);
    }

    public static void zzY(int i, List<zzgs> list, zzha zzhaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhaVar.zzF(i, list);
    }

    public static void zzZ(int i, List<?> list, zzha zzhaVar, zzji zzjiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzhaVar.zzr(i, list.get(i2), zzjiVar);
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhs.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzha zzhaVar, zzji zzjiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzhaVar.zzs(i, list.get(i2), zzjiVar);
        }
    }

    private static zzjw<?, ?> zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzjw) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List<Long> list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzgz.zzx(zzimVar.zzc(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzgz.zzx(list.get(i).longValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzgz.zzu(i));
    }

    static int zzd(List<Long> list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzgz.zzx(zzimVar.zzc(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzgz.zzx(list.get(i).longValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzgz.zzu(i));
    }

    static int zzf(List<Long> list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzim) {
            zzim zzimVar = (zzim) list;
            iZzx = 0;
            while (i < size) {
                long jZzc = zzimVar.zzc(i);
                iZzx += zzgz.zzx((jZzc >> 63) ^ (jZzc + jZzc));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                long jLongValue = list.get(i).longValue();
                iZzx += zzgz.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzx;
    }

    static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzgz.zzu(i));
    }

    static int zzh(List<Integer> list) {
        int iZzv;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            iZzv = 0;
            while (i < size) {
                iZzv += zzgz.zzv(zzhtVar.zzg(i));
                i++;
            }
        } else {
            iZzv = 0;
            while (i < size) {
                iZzv += zzgz.zzv(list.get(i).intValue());
                i++;
            }
        }
        return iZzv;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzgz.zzu(i));
    }

    static int zzj(List<Integer> list) {
        int iZzv;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            iZzv = 0;
            while (i < size) {
                iZzv += zzgz.zzv(zzhtVar.zzg(i));
                i++;
            }
        } else {
            iZzv = 0;
            while (i < size) {
                iZzv += zzgz.zzv(list.get(i).intValue());
                i++;
            }
        }
        return iZzv;
    }

    static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzgz.zzu(i));
    }

    static int zzl(List<Integer> list) {
        int iZzw;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            iZzw = 0;
            while (i < size) {
                iZzw += zzgz.zzw(zzhtVar.zzg(i));
                i++;
            }
        } else {
            iZzw = 0;
            while (i < size) {
                iZzw += zzgz.zzw(list.get(i).intValue());
                i++;
            }
        }
        return iZzw;
    }

    static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzgz.zzu(i));
    }

    static int zzn(List<Integer> list) {
        int iZzw;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzht) {
            zzht zzhtVar = (zzht) list;
            iZzw = 0;
            while (i < size) {
                int iZzg = zzhtVar.zzg(i);
                iZzw += zzgz.zzw((iZzg >> 31) ^ (iZzg + iZzg));
                i++;
            }
        } else {
            iZzw = 0;
            while (i < size) {
                int iIntValue = list.get(i).intValue();
                iZzw += zzgz.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzw;
    }

    static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzgz.zzu(i));
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 4);
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 8);
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgz.zzw(i << 3) + 1);
    }

    static int zzv(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzu = zzgz.zzu(i) * size;
        if (list instanceof zzih) {
            zzih zzihVar = (zzih) list;
            while (i2 < size) {
                Object objZzg = zzihVar.zzg(i2);
                iZzu += objZzg instanceof zzgs ? zzgz.zzA((zzgs) objZzg) : zzgz.zzy((String) objZzg);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iZzu += obj instanceof zzgs ? zzgz.zzA((zzgs) obj) : zzgz.zzy((String) obj);
                i2++;
            }
        }
        return iZzu;
    }

    static int zzw(int i, Object obj, zzji zzjiVar) {
        if (!(obj instanceof zzif)) {
            return zzgz.zzw(i << 3) + zzgz.zzB((zzix) obj, zzjiVar);
        }
        int iZzw = zzgz.zzw(i << 3);
        int iZza = ((zzif) obj).zza();
        return iZzw + zzgz.zzw(iZza) + iZza;
    }

    static int zzx(int i, List<?> list, zzji zzjiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzu = zzgz.zzu(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iZzu += obj instanceof zzif ? zzgz.zzz((zzif) obj) : zzgz.zzB((zzix) obj, zzjiVar);
        }
        return iZzu;
    }

    static int zzy(int i, List<zzgs> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzu = size * zzgz.zzu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzu += zzgz.zzA(list.get(i2));
        }
        return iZzu;
    }

    static int zzz(int i, List<zzix> list, zzji zzjiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzE = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzE += zzgz.zzE(i, list.get(i2), zzjiVar);
        }
        return iZzE;
    }
}
