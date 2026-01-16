package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzja<T> implements zzji<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkh.zzr();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzix zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzil zzm;
    private final zzjw<?, ?> zzn;
    private final zzhf<?> zzo;
    private final zzis zzq;

    /* JADX WARN: Multi-variable type inference failed */
    private zzja(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzix zzixVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzjc zzjcVar, zzil zzilVar, zzjw<?, ?> zzjwVar, zzhf<?> zzhfVar, zzis zzisVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i;
        this.zzi = zzixVar;
        boolean z3 = false;
        if (zzjwVar != 0 && zzjwVar.zza(i2)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = z2;
        this.zzk = iArr3;
        this.zzl = i3;
        this.zzm = zzjcVar;
        this.zzn = zzilVar;
        this.zzo = zzjwVar;
        this.zzg = i2;
        this.zzq = zzhfVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static <T> double zzD(T t, long j) {
        return ((Double) zzkh.zzn(t, j)).doubleValue();
    }

    private static <T> float zzE(T t, long j) {
        return ((Float) zzkh.zzn(t, j)).floatValue();
    }

    private static <T> int zzF(T t, long j) {
        return ((Integer) zzkh.zzn(t, j)).intValue();
    }

    private static <T> long zzG(T t, long j) {
        return ((Long) zzkh.zzn(t, j)).longValue();
    }

    private static <T> boolean zzH(T t, long j) {
        return ((Boolean) zzkh.zzn(t, j)).booleanValue();
    }

    private final boolean zzI(T t, T t2, int i) {
        return zzK(t, i) == zzK(t2, i);
    }

    private final boolean zzJ(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzK(t, i) : (i3 & i4) != 0;
    }

    private final boolean zzK(T t, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return (zzkh.zzd(t, j) & (1 << (iZzB >>> 20))) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return zzkh.zzl(t, j2) != 0.0d;
            case 1:
                return zzkh.zzj(t, j2) != 0.0f;
            case 2:
                return zzkh.zzf(t, j2) != 0;
            case 3:
                return zzkh.zzf(t, j2) != 0;
            case 4:
                return zzkh.zzd(t, j2) != 0;
            case 5:
                return zzkh.zzf(t, j2) != 0;
            case 6:
                return zzkh.zzd(t, j2) != 0;
            case 7:
                return zzkh.zzh(t, j2);
            case 8:
                Object objZzn = zzkh.zzn(t, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzgs) {
                    return !zzgs.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzkh.zzn(t, j2) != null;
            case 10:
                return !zzgs.zzb.equals(zzkh.zzn(t, j2));
            case 11:
                return zzkh.zzd(t, j2) != 0;
            case 12:
                return zzkh.zzd(t, j2) != 0;
            case 13:
                return zzkh.zzd(t, j2) != 0;
            case 14:
                return zzkh.zzf(t, j2) != 0;
            case 15:
                return zzkh.zzd(t, j2) != 0;
            case 16:
                return zzkh.zzf(t, j2) != 0;
            case 17:
                return zzkh.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzL(T t, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzkh.zze(t, j, (1 << (iZzB >>> 20)) | zzkh.zzd(t, j));
    }

    private final boolean zzM(T t, int i, int i2) {
        return zzkh.zzd(t, (long) (zzB(i2) & 1048575)) == i;
    }

    private final void zzN(T t, int i, int i2) {
        zzkh.zze(t, zzB(i2) & 1048575, i);
    }

    private final int zzO(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzP(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, i2);
    }

    private final int zzQ(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final void zzR(T t, zzha zzhaVar) throws IOException {
        int i;
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < length) {
            int iZzA = zzA(i3);
            int i6 = this.zzc[i3];
            int iZzC = zzC(iZzA);
            if (iZzC <= 17) {
                int i7 = this.zzc[i3 + 2];
                int i8 = i7 & i2;
                if (i8 != i5) {
                    i4 = unsafe.getInt(t, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzA & i2;
            switch (iZzC) {
                case 0:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzf(i6, zzkh.zzl(t, j));
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 1:
                    if ((i4 & i) != 0) {
                        zzhaVar.zze(i6, zzkh.zzj(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 2:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzc(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 3:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzh(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 4:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzi(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 5:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzj(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 6:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzk(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 7:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzl(i6, zzkh.zzh(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 8:
                    if ((i4 & i) != 0) {
                        zzT(i6, unsafe.getObject(t, j), zzhaVar);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 9:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzr(i6, unsafe.getObject(t, j), zzv(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 10:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzn(i6, (zzgs) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 11:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzo(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 12:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzg(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 13:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzb(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 14:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzd(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 15:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzp(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 16:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzq(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 17:
                    if ((i4 & i) != 0) {
                        zzhaVar.zzs(i6, unsafe.getObject(t, j), zzv(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 18:
                    zzjk.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 19:
                    zzjk.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 20:
                    zzjk.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 21:
                    zzjk.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 22:
                    zzjk.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 23:
                    zzjk.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 24:
                    zzjk.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 25:
                    zzjk.zzW(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 26:
                    zzjk.zzX(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar);
                    break;
                case 27:
                    zzjk.zzZ(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, zzv(i3));
                    break;
                case 28:
                    zzjk.zzY(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar);
                    break;
                case 29:
                    zzjk.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 30:
                    zzjk.zzV(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 31:
                    zzjk.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 32:
                    zzjk.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 33:
                    zzjk.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 34:
                    zzjk.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, false);
                    break;
                case 35:
                    zzjk.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 36:
                    zzjk.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 37:
                    zzjk.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 38:
                    zzjk.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 39:
                    zzjk.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 40:
                    zzjk.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 41:
                    zzjk.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 42:
                    zzjk.zzW(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 43:
                    zzjk.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 44:
                    zzjk.zzV(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 45:
                    zzjk.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 46:
                    zzjk.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 47:
                    zzjk.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 48:
                    zzjk.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, true);
                    break;
                case 49:
                    zzjk.zzaa(this.zzc[i3], (List) unsafe.getObject(t, j), zzhaVar, zzv(i3));
                    break;
                case 50:
                    zzS(zzhaVar, i6, unsafe.getObject(t, j), i3);
                    break;
                case 51:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzf(i6, zzD(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zze(i6, zzE(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzc(i6, zzG(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzh(i6, zzG(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzi(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzj(i6, zzG(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzk(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzl(i6, zzH(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zzM(t, i6, i3)) {
                        zzT(i6, unsafe.getObject(t, j), zzhaVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzr(i6, unsafe.getObject(t, j), zzv(i3));
                        break;
                    }
                    break;
                case 61:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzn(i6, (zzgs) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzo(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzg(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzb(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzd(i6, zzG(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzp(i6, zzF(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzq(i6, zzG(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zzM(t, i6, i3)) {
                        zzhaVar.zzs(i6, unsafe.getObject(t, j), zzv(i3));
                        break;
                    }
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        zzjwVar.zzi(zzjwVar.zzd(t), zzhaVar);
    }

    private final <K, V> void zzS(zzha zzhaVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzT(int i, Object obj, zzha zzhaVar) throws IOException {
        if (obj instanceof String) {
            zzhaVar.zzm(i, (String) obj);
        } else {
            zzhaVar.zzn(i, (zzgs) obj);
        }
    }

    static zzjx zzf(Object obj) {
        zzhs zzhsVar = (zzhs) obj;
        zzjx zzjxVar = zzhsVar.zzc;
        if (zzjxVar != zzjx.zza()) {
            return zzjxVar;
        }
        zzjx zzjxVarZzb = zzjx.zzb();
        zzhsVar.zzc = zzjxVarZzb;
        return zzjxVarZzb;
    }

    static <T> zzja<T> zzk(Class<T> cls, zziu zziuVar, zzjc zzjcVar, zzil zzilVar, zzjw<?, ?> zzjwVar, zzhf<?> zzhfVar, zzis zzisVar) {
        if (zziuVar instanceof zzjh) {
            return zzl((zzjh) zziuVar, zzjcVar, zzilVar, zzjwVar, zzhfVar, zzisVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0378  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.measurement.zzja<T> zzl(com.google.android.gms.internal.measurement.zzjh r34, com.google.android.gms.internal.measurement.zzjc r35, com.google.android.gms.internal.measurement.zzil r36, com.google.android.gms.internal.measurement.zzjw<?, ?> r37, com.google.android.gms.internal.measurement.zzhf<?> r38, com.google.android.gms.internal.measurement.zzis r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzl(com.google.android.gms.internal.measurement.zzjh, com.google.android.gms.internal.measurement.zzjc, com.google.android.gms.internal.measurement.zzil, com.google.android.gms.internal.measurement.zzjw, com.google.android.gms.internal.measurement.zzhf, com.google.android.gms.internal.measurement.zzis):com.google.android.gms.internal.measurement.zzja");
    }

    private static Field zzn(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzo(T t, T t2, int i) {
        long jZzA = zzA(i) & 1048575;
        if (zzK(t2, i)) {
            Object objZzn = zzkh.zzn(t, jZzA);
            Object objZzn2 = zzkh.zzn(t2, jZzA);
            if (objZzn != null && objZzn2 != null) {
                zzkh.zzo(t, jZzA, zzia.zzi(objZzn, objZzn2));
                zzL(t, i);
            } else if (objZzn2 != null) {
                zzkh.zzo(t, jZzA, objZzn2);
                zzL(t, i);
            }
        }
    }

    private final void zzp(T t, T t2, int i) {
        int iZzA = zzA(i);
        int i2 = this.zzc[i];
        long j = iZzA & 1048575;
        if (zzM(t2, i2, i)) {
            Object objZzn = zzM(t, i2, i) ? zzkh.zzn(t, j) : null;
            Object objZzn2 = zzkh.zzn(t2, j);
            if (objZzn != null && objZzn2 != null) {
                zzkh.zzo(t, j, zzia.zzi(objZzn, objZzn2));
                zzN(t, i2, i);
            } else if (objZzn2 != null) {
                zzkh.zzo(t, j, objZzn2);
                zzN(t, i2, i);
            }
        }
    }

    private final int zzq(T t) {
        int i;
        int iZzw;
        int iZzw2;
        int iZzw3;
        int iZzx;
        int iZzw4;
        int iZzv;
        int iZzw5;
        int iZzw6;
        int iZzc;
        int iZzw7;
        int iZzw8;
        int iZzu;
        int iZzw9;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int iZzA = zzA(i6);
            int i7 = this.zzc[i6];
            int iZzC = zzC(iZzA);
            if (iZzC <= 17) {
                int i8 = this.zzc[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i5) {
                    i4 = unsafe.getInt(t, i9);
                    i5 = i9;
                }
            } else {
                i = 0;
            }
            long j = iZzA & 1048575;
            switch (iZzC) {
                case 0:
                    if ((i4 & i) != 0) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i4 & i) != 0) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i4 & i) != 0) {
                        long j2 = unsafe.getLong(t, j);
                        iZzw3 = zzgz.zzw(i7 << 3);
                        iZzx = zzgz.zzx(j2);
                        iZzw8 = iZzw3 + iZzx;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i4 & i) != 0) {
                        long j3 = unsafe.getLong(t, j);
                        iZzw3 = zzgz.zzw(i7 << 3);
                        iZzx = zzgz.zzx(j3);
                        iZzw8 = iZzw3 + iZzx;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i4 & i) != 0) {
                        int i10 = unsafe.getInt(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzv(i10);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i4 & i) != 0) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i4 & i) != 0) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i4 & i) != 0) {
                        iZzw5 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw5 + 1;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i4 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzgs) {
                            iZzw6 = zzgz.zzw(i7 << 3);
                            iZzc = ((zzgs) object).zzc();
                            iZzw7 = zzgz.zzw(iZzc);
                            i2 = iZzw6 + iZzw7 + iZzc;
                            i3 += i2;
                            break;
                        } else {
                            iZzw4 = zzgz.zzw(i7 << 3);
                            iZzv = zzgz.zzy((String) object);
                            i2 = iZzw4 + iZzv;
                            i3 += i2;
                        }
                    }
                case 9:
                    if ((i4 & i) != 0) {
                        iZzw8 = zzjk.zzw(i7, unsafe.getObject(t, j), zzv(i6));
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i4 & i) != 0) {
                        zzgs zzgsVar = (zzgs) unsafe.getObject(t, j);
                        iZzw6 = zzgz.zzw(i7 << 3);
                        iZzc = zzgsVar.zzc();
                        iZzw7 = zzgz.zzw(iZzc);
                        i2 = iZzw6 + iZzw7 + iZzc;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i4 & i) != 0) {
                        int i11 = unsafe.getInt(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzw(i11);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i4 & i) != 0) {
                        int i12 = unsafe.getInt(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzv(i12);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i4 & i) != 0) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i4 & i) != 0) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i4 & i) != 0) {
                        int i13 = unsafe.getInt(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzw((i13 >> 31) ^ (i13 + i13));
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i4 & i) != 0) {
                        long j4 = unsafe.getLong(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzx((j4 >> 63) ^ (j4 + j4));
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i4 & i) != 0) {
                        iZzw8 = zzgz.zzE(i7, (zzix) unsafe.getObject(t, j), zzv(i6));
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzw8 = zzjk.zzs(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 19:
                    iZzw8 = zzjk.zzq(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 20:
                    iZzw8 = zzjk.zzc(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 21:
                    iZzw8 = zzjk.zze(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 22:
                    iZzw8 = zzjk.zzk(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 23:
                    iZzw8 = zzjk.zzs(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 24:
                    iZzw8 = zzjk.zzq(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 25:
                    iZzw8 = zzjk.zzu(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 26:
                    iZzw8 = zzjk.zzv(i7, (List) unsafe.getObject(t, j));
                    i3 += iZzw8;
                    break;
                case 27:
                    iZzw8 = zzjk.zzx(i7, (List) unsafe.getObject(t, j), zzv(i6));
                    i3 += iZzw8;
                    break;
                case 28:
                    iZzw8 = zzjk.zzy(i7, (List) unsafe.getObject(t, j));
                    i3 += iZzw8;
                    break;
                case 29:
                    iZzw8 = zzjk.zzm(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 30:
                    iZzw8 = zzjk.zzi(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 31:
                    iZzw8 = zzjk.zzq(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 32:
                    iZzw8 = zzjk.zzs(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 33:
                    iZzw8 = zzjk.zzo(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 34:
                    iZzw8 = zzjk.zzg(i7, (List) unsafe.getObject(t, j), false);
                    i3 += iZzw8;
                    break;
                case 35:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZzv = zzjk.zzb((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZzv = zzjk.zzd((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZzv = zzjk.zzj((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzv = zzjk.zzt((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZzv = zzjk.zzl((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZzv = zzjk.zzh((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZzv = zzjk.zzn((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZzv = zzjk.zzf((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i7);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iZzw8 = zzjk.zzz(i7, (List) unsafe.getObject(t, j), zzv(i6));
                    i3 += iZzw8;
                    break;
                case 50:
                    zzis.zza(i7, unsafe.getObject(t, j), zzw(i6));
                    break;
                case 51:
                    if (zzM(t, i7, i6)) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i7, i6)) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i7, i6)) {
                        long jZzG = zzG(t, j);
                        iZzw3 = zzgz.zzw(i7 << 3);
                        iZzx = zzgz.zzx(jZzG);
                        iZzw8 = iZzw3 + iZzx;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i7, i6)) {
                        long jZzG2 = zzG(t, j);
                        iZzw3 = zzgz.zzw(i7 << 3);
                        iZzx = zzgz.zzx(jZzG2);
                        iZzw8 = iZzw3 + iZzx;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i7, i6)) {
                        int iZzF = zzF(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzv(iZzF);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i7, i6)) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i7, i6)) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i7, i6)) {
                        iZzw5 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw5 + 1;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzM(t, i7, i6)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzgs) {
                            iZzw6 = zzgz.zzw(i7 << 3);
                            iZzc = ((zzgs) object2).zzc();
                            iZzw7 = zzgz.zzw(iZzc);
                            i2 = iZzw6 + iZzw7 + iZzc;
                            i3 += i2;
                            break;
                        } else {
                            iZzw4 = zzgz.zzw(i7 << 3);
                            iZzv = zzgz.zzy((String) object2);
                            i2 = iZzw4 + iZzv;
                            i3 += i2;
                        }
                    }
                case 60:
                    if (zzM(t, i7, i6)) {
                        iZzw8 = zzjk.zzw(i7, unsafe.getObject(t, j), zzv(i6));
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i7, i6)) {
                        zzgs zzgsVar2 = (zzgs) unsafe.getObject(t, j);
                        iZzw6 = zzgz.zzw(i7 << 3);
                        iZzc = zzgsVar2.zzc();
                        iZzw7 = zzgz.zzw(iZzc);
                        i2 = iZzw6 + iZzw7 + iZzc;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i7, i6)) {
                        int iZzF2 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzw(iZzF2);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i7, i6)) {
                        int iZzF3 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzv(iZzF3);
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i7, i6)) {
                        iZzw2 = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw2 + 4;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i7, i6)) {
                        iZzw = zzgz.zzw(i7 << 3);
                        iZzw8 = iZzw + 8;
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i7, i6)) {
                        int iZzF4 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzw((iZzF4 >> 31) ^ (iZzF4 + iZzF4));
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i7, i6)) {
                        long jZzG3 = zzG(t, j);
                        iZzw4 = zzgz.zzw(i7 << 3);
                        iZzv = zzgz.zzx((jZzG3 >> 63) ^ (jZzG3 + jZzG3));
                        i2 = iZzw4 + iZzv;
                        i3 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i7, i6)) {
                        iZzw8 = zzgz.zzE(i7, (zzix) unsafe.getObject(t, j), zzv(i6));
                        i3 += iZzw8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        int iZzh = i3 + zzjwVar.zzh(zzjwVar.zzd(t));
        if (!this.zzh) {
            return iZzh;
        }
        this.zzo.zzb(t);
        throw null;
    }

    private final int zzr(T t) {
        int iZzw;
        int iZzw2;
        int iZzw3;
        int iZzx;
        int iZzw4;
        int iZzv;
        int iZzw5;
        int iZzw6;
        int iZzc;
        int iZzw7;
        int iZzw8;
        int iZzu;
        int iZzw9;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzA = zzA(i3);
            int iZzC = zzC(iZzA);
            int i4 = this.zzc[i3];
            long j = iZzA & 1048575;
            if (iZzC >= zzhk.zzJ.zza() && iZzC <= zzhk.zzW.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzC) {
                case 0:
                    if (zzK(t, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzK(t, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzK(t, i3)) {
                        long jZzf = zzkh.zzf(t, j);
                        iZzw3 = zzgz.zzw(i4 << 3);
                        iZzx = zzgz.zzx(jZzf);
                        i2 += iZzw3 + iZzx;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzK(t, i3)) {
                        long jZzf2 = zzkh.zzf(t, j);
                        iZzw3 = zzgz.zzw(i4 << 3);
                        iZzx = zzgz.zzx(jZzf2);
                        i2 += iZzw3 + iZzx;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzK(t, i3)) {
                        int iZzd = zzkh.zzd(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzv(iZzd);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzK(t, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzK(t, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzK(t, i3)) {
                        iZzw5 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw5 + 1;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzK(t, i3)) {
                        break;
                    } else {
                        Object objZzn = zzkh.zzn(t, j);
                        if (objZzn instanceof zzgs) {
                            iZzw6 = zzgz.zzw(i4 << 3);
                            iZzc = ((zzgs) objZzn).zzc();
                            iZzw7 = zzgz.zzw(iZzc);
                            i = iZzw6 + iZzw7 + iZzc;
                            i2 += i;
                            break;
                        } else {
                            iZzw4 = zzgz.zzw(i4 << 3);
                            iZzv = zzgz.zzy((String) objZzn);
                            i = iZzw4 + iZzv;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzK(t, i3)) {
                        iZzw8 = zzjk.zzw(i4, zzkh.zzn(t, j), zzv(i3));
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzK(t, i3)) {
                        zzgs zzgsVar = (zzgs) zzkh.zzn(t, j);
                        iZzw6 = zzgz.zzw(i4 << 3);
                        iZzc = zzgsVar.zzc();
                        iZzw7 = zzgz.zzw(iZzc);
                        i = iZzw6 + iZzw7 + iZzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzK(t, i3)) {
                        int iZzd2 = zzkh.zzd(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzw(iZzd2);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzK(t, i3)) {
                        int iZzd3 = zzkh.zzd(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzv(iZzd3);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzK(t, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzK(t, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzK(t, i3)) {
                        int iZzd4 = zzkh.zzd(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzw((iZzd4 >> 31) ^ (iZzd4 + iZzd4));
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzK(t, i3)) {
                        long jZzf3 = zzkh.zzf(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzx((jZzf3 >> 63) ^ (jZzf3 + jZzf3));
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzK(t, i3)) {
                        iZzw8 = zzgz.zzE(i4, (zzix) zzkh.zzn(t, j), zzv(i3));
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzw8 = zzjk.zzs(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 19:
                    iZzw8 = zzjk.zzq(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 20:
                    iZzw8 = zzjk.zzc(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 21:
                    iZzw8 = zzjk.zze(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 22:
                    iZzw8 = zzjk.zzk(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 23:
                    iZzw8 = zzjk.zzs(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 24:
                    iZzw8 = zzjk.zzq(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 25:
                    iZzw8 = zzjk.zzu(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 26:
                    iZzw8 = zzjk.zzv(i4, (List) zzkh.zzn(t, j));
                    i2 += iZzw8;
                    break;
                case 27:
                    iZzw8 = zzjk.zzx(i4, (List) zzkh.zzn(t, j), zzv(i3));
                    i2 += iZzw8;
                    break;
                case 28:
                    iZzw8 = zzjk.zzy(i4, (List) zzkh.zzn(t, j));
                    i2 += iZzw8;
                    break;
                case 29:
                    iZzw8 = zzjk.zzm(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 30:
                    iZzw8 = zzjk.zzi(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 31:
                    iZzw8 = zzjk.zzq(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 32:
                    iZzw8 = zzjk.zzs(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 33:
                    iZzw8 = zzjk.zzo(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 34:
                    iZzw8 = zzjk.zzg(i4, (List) zzkh.zzn(t, j), false);
                    i2 += iZzw8;
                    break;
                case 35:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZzv = zzjk.zzb((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZzv = zzjk.zzd((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZzv = zzjk.zzj((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzv = zzjk.zzt((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZzv = zzjk.zzl((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZzv = zzjk.zzh((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZzv = zzjk.zzp((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZzv = zzjk.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZzv = zzjk.zzn((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZzv = zzjk.zzf((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzu = zzgz.zzu(i4);
                        iZzw9 = zzgz.zzw(iZzv);
                        iZzw4 = iZzu + iZzw9;
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iZzw8 = zzjk.zzz(i4, (List) zzkh.zzn(t, j), zzv(i3));
                    i2 += iZzw8;
                    break;
                case 50:
                    zzis.zza(i4, zzkh.zzn(t, j), zzw(i3));
                    break;
                case 51:
                    if (zzM(t, i4, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i4, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i4, i3)) {
                        long jZzG = zzG(t, j);
                        iZzw3 = zzgz.zzw(i4 << 3);
                        iZzx = zzgz.zzx(jZzG);
                        i2 += iZzw3 + iZzx;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i4, i3)) {
                        long jZzG2 = zzG(t, j);
                        iZzw3 = zzgz.zzw(i4 << 3);
                        iZzx = zzgz.zzx(jZzG2);
                        i2 += iZzw3 + iZzx;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i4, i3)) {
                        int iZzF = zzF(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzv(iZzF);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i4, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i4, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i4, i3)) {
                        iZzw5 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw5 + 1;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzM(t, i4, i3)) {
                        break;
                    } else {
                        Object objZzn2 = zzkh.zzn(t, j);
                        if (objZzn2 instanceof zzgs) {
                            iZzw6 = zzgz.zzw(i4 << 3);
                            iZzc = ((zzgs) objZzn2).zzc();
                            iZzw7 = zzgz.zzw(iZzc);
                            i = iZzw6 + iZzw7 + iZzc;
                            i2 += i;
                            break;
                        } else {
                            iZzw4 = zzgz.zzw(i4 << 3);
                            iZzv = zzgz.zzy((String) objZzn2);
                            i = iZzw4 + iZzv;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzM(t, i4, i3)) {
                        iZzw8 = zzjk.zzw(i4, zzkh.zzn(t, j), zzv(i3));
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i4, i3)) {
                        zzgs zzgsVar2 = (zzgs) zzkh.zzn(t, j);
                        iZzw6 = zzgz.zzw(i4 << 3);
                        iZzc = zzgsVar2.zzc();
                        iZzw7 = zzgz.zzw(iZzc);
                        i = iZzw6 + iZzw7 + iZzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i4, i3)) {
                        int iZzF2 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzw(iZzF2);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i4, i3)) {
                        int iZzF3 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzv(iZzF3);
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i4, i3)) {
                        iZzw2 = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw2 + 4;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i4, i3)) {
                        iZzw = zzgz.zzw(i4 << 3);
                        iZzw8 = iZzw + 8;
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i4, i3)) {
                        int iZzF4 = zzF(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzw((iZzF4 >> 31) ^ (iZzF4 + iZzF4));
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i4, i3)) {
                        long jZzG3 = zzG(t, j);
                        iZzw4 = zzgz.zzw(i4 << 3);
                        iZzv = zzgz.zzx((jZzG3 >> 63) ^ (jZzG3 + jZzG3));
                        i = iZzw4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i4, i3)) {
                        iZzw8 = zzgz.zzE(i4, (zzix) zzkh.zzn(t, j), zzv(i3));
                        i2 += iZzw8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        return i2 + zzjwVar.zzh(zzjwVar.zzd(t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zzs(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzge zzgeVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZza;
        int iZza2 = i;
        Unsafe unsafe = zzb;
        zzhz zzhzVarZze = (zzhz) unsafe.getObject(t, j2);
        if (!zzhzVarZze.zza()) {
            int size = zzhzVarZze.size();
            zzhzVarZze = zzhzVarZze.zze(size == 0 ? 10 : size + size);
            unsafe.putObject(t, j2, zzhzVarZze);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzhb zzhbVar = (zzhb) zzhzVarZze;
                    int iZza3 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i12 = zzgeVar.zza + iZza3;
                    while (iZza3 < i12) {
                        zzhbVar.zzd(Double.longBitsToDouble(zzgf.zze(bArr, iZza3)));
                        iZza3 += 8;
                    }
                    if (iZza3 == i12) {
                        return iZza3;
                    }
                    throw zzic.zza();
                }
                if (i5 == 1) {
                    zzhb zzhbVar2 = (zzhb) zzhzVarZze;
                    zzhbVar2.zzd(Double.longBitsToDouble(zzgf.zze(bArr, i)));
                    while (true) {
                        i8 = iZza2 + 8;
                        if (i8 < i2) {
                            iZza2 = zzgf.zza(bArr, i8, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                zzhbVar2.zzd(Double.longBitsToDouble(zzgf.zze(bArr, iZza2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZza2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzhl zzhlVar = (zzhl) zzhzVarZze;
                    int iZza4 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i13 = zzgeVar.zza + iZza4;
                    while (iZza4 < i13) {
                        zzhlVar.zzd(Float.intBitsToFloat(zzgf.zzd(bArr, iZza4)));
                        iZza4 += 4;
                    }
                    if (iZza4 == i13) {
                        return iZza4;
                    }
                    throw zzic.zza();
                }
                if (i5 == 5) {
                    zzhl zzhlVar2 = (zzhl) zzhzVarZze;
                    zzhlVar2.zzd(Float.intBitsToFloat(zzgf.zzd(bArr, i)));
                    while (true) {
                        i9 = iZza2 + 4;
                        if (i9 < i2) {
                            iZza2 = zzgf.zza(bArr, i9, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                zzhlVar2.zzd(Float.intBitsToFloat(zzgf.zzd(bArr, iZza2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZza2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzim zzimVar = (zzim) zzhzVarZze;
                    int iZza5 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i14 = zzgeVar.zza + iZza5;
                    while (iZza5 < i14) {
                        iZza5 = zzgf.zzc(bArr, iZza5, zzgeVar);
                        zzimVar.zzg(zzgeVar.zzb);
                    }
                    if (iZza5 == i14) {
                        return iZza5;
                    }
                    throw zzic.zza();
                }
                if (i5 == 0) {
                    zzim zzimVar2 = (zzim) zzhzVarZze;
                    int iZzc = zzgf.zzc(bArr, iZza2, zzgeVar);
                    zzimVar2.zzg(zzgeVar.zzb);
                    while (iZzc < i2) {
                        int iZza6 = zzgf.zza(bArr, iZzc, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzgf.zzc(bArr, iZza6, zzgeVar);
                        zzimVar2.zzg(zzgeVar.zzb);
                    }
                    return iZzc;
                }
                return iZza2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzgf.zzl(bArr, iZza2, zzhzVarZze, zzgeVar);
                }
                if (i5 == 0) {
                    return zzgf.zzk(i3, bArr, i, i2, zzhzVarZze, zzgeVar);
                }
                return iZza2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzim zzimVar3 = (zzim) zzhzVarZze;
                    int iZza7 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i15 = zzgeVar.zza + iZza7;
                    while (iZza7 < i15) {
                        zzimVar3.zzg(zzgf.zze(bArr, iZza7));
                        iZza7 += 8;
                    }
                    if (iZza7 == i15) {
                        return iZza7;
                    }
                    throw zzic.zza();
                }
                if (i5 == 1) {
                    zzim zzimVar4 = (zzim) zzhzVarZze;
                    zzimVar4.zzg(zzgf.zze(bArr, i));
                    while (true) {
                        i10 = iZza2 + 8;
                        if (i10 < i2) {
                            iZza2 = zzgf.zza(bArr, i10, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                zzimVar4.zzg(zzgf.zze(bArr, iZza2));
                            }
                        }
                    }
                    return i10;
                }
                return iZza2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzht zzhtVar = (zzht) zzhzVarZze;
                    int iZza8 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i16 = zzgeVar.zza + iZza8;
                    while (iZza8 < i16) {
                        zzhtVar.zzh(zzgf.zzd(bArr, iZza8));
                        iZza8 += 4;
                    }
                    if (iZza8 == i16) {
                        return iZza8;
                    }
                    throw zzic.zza();
                }
                if (i5 == 5) {
                    zzht zzhtVar2 = (zzht) zzhzVarZze;
                    zzhtVar2.zzh(zzgf.zzd(bArr, i));
                    while (true) {
                        i11 = iZza2 + 4;
                        if (i11 < i2) {
                            iZza2 = zzgf.zza(bArr, i11, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                zzhtVar2.zzh(zzgf.zzd(bArr, iZza2));
                            }
                        }
                    }
                    return i11;
                }
                return iZza2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzgg zzggVar = (zzgg) zzhzVarZze;
                    iZza = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i17 = zzgeVar.zza + iZza;
                    while (iZza < i17) {
                        iZza = zzgf.zzc(bArr, iZza, zzgeVar);
                        zzggVar.zzd(zzgeVar.zzb != 0);
                    }
                    if (iZza != i17) {
                        throw zzic.zza();
                    }
                    return iZza;
                }
                if (i5 == 0) {
                    zzgg zzggVar2 = (zzgg) zzhzVarZze;
                    int iZzc2 = zzgf.zzc(bArr, iZza2, zzgeVar);
                    zzggVar2.zzd(zzgeVar.zzb != 0);
                    while (iZzc2 < i2) {
                        int iZza9 = zzgf.zza(bArr, iZzc2, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZzc2;
                        }
                        iZzc2 = zzgf.zzc(bArr, iZza9, zzgeVar);
                        zzggVar2.zzd(zzgeVar.zzb != 0);
                    }
                    return iZzc2;
                }
                return iZza2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        iZza2 = zzgf.zza(bArr, iZza2, zzgeVar);
                        int i18 = zzgeVar.zza;
                        if (i18 < 0) {
                            throw zzic.zzb();
                        }
                        if (i18 == 0) {
                            zzhzVarZze.add(BuildConfig.FLAVOR);
                        } else {
                            zzhzVarZze.add(new String(bArr, iZza2, i18, zzia.zza));
                            iZza2 += i18;
                        }
                        while (iZza2 < i2) {
                            int iZza10 = zzgf.zza(bArr, iZza2, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                iZza2 = zzgf.zza(bArr, iZza10, zzgeVar);
                                int i19 = zzgeVar.zza;
                                if (i19 < 0) {
                                    throw zzic.zzb();
                                }
                                if (i19 == 0) {
                                    zzhzVarZze.add(BuildConfig.FLAVOR);
                                } else {
                                    zzhzVarZze.add(new String(bArr, iZza2, i19, zzia.zza));
                                    iZza2 += i19;
                                }
                            }
                        }
                    } else {
                        iZza2 = zzgf.zza(bArr, iZza2, zzgeVar);
                        int i20 = zzgeVar.zza;
                        if (i20 < 0) {
                            throw zzic.zzb();
                        }
                        if (i20 == 0) {
                            zzhzVarZze.add(BuildConfig.FLAVOR);
                        } else {
                            int i21 = iZza2 + i20;
                            if (!zzkn.zzb(bArr, iZza2, i21)) {
                                throw zzic.zzf();
                            }
                            zzhzVarZze.add(new String(bArr, iZza2, i20, zzia.zza));
                            iZza2 = i21;
                        }
                        while (iZza2 < i2) {
                            int iZza11 = zzgf.zza(bArr, iZza2, zzgeVar);
                            if (i3 == zzgeVar.zza) {
                                iZza2 = zzgf.zza(bArr, iZza11, zzgeVar);
                                int i22 = zzgeVar.zza;
                                if (i22 < 0) {
                                    throw zzic.zzb();
                                }
                                if (i22 == 0) {
                                    zzhzVarZze.add(BuildConfig.FLAVOR);
                                } else {
                                    int i23 = iZza2 + i22;
                                    if (!zzkn.zzb(bArr, iZza2, i23)) {
                                        throw zzic.zzf();
                                    }
                                    zzhzVarZze.add(new String(bArr, iZza2, i22, zzia.zza));
                                    iZza2 = i23;
                                }
                            }
                        }
                    }
                }
                return iZza2;
            case 27:
                if (i5 == 2) {
                    return zzgf.zzm(zzv(i6), i3, bArr, i, i2, zzhzVarZze, zzgeVar);
                }
                return iZza2;
            case 28:
                if (i5 == 2) {
                    int iZza12 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i24 = zzgeVar.zza;
                    if (i24 < 0) {
                        throw zzic.zzb();
                    }
                    if (i24 > bArr.length - iZza12) {
                        throw zzic.zza();
                    }
                    if (i24 == 0) {
                        zzhzVarZze.add(zzgs.zzb);
                    } else {
                        zzhzVarZze.add(zzgs.zzj(bArr, iZza12, i24));
                        iZza12 += i24;
                    }
                    while (iZza12 < i2) {
                        int iZza13 = zzgf.zza(bArr, iZza12, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZza12;
                        }
                        iZza12 = zzgf.zza(bArr, iZza13, zzgeVar);
                        int i25 = zzgeVar.zza;
                        if (i25 < 0) {
                            throw zzic.zzb();
                        }
                        if (i25 > bArr.length - iZza12) {
                            throw zzic.zza();
                        }
                        if (i25 == 0) {
                            zzhzVarZze.add(zzgs.zzb);
                        } else {
                            zzhzVarZze.add(zzgs.zzj(bArr, iZza12, i25));
                            iZza12 += i25;
                        }
                    }
                    return iZza12;
                }
                return iZza2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzgf.zzk(i3, bArr, i, i2, zzhzVarZze, zzgeVar);
                    }
                    return iZza2;
                }
                iZza = zzgf.zzl(bArr, iZza2, zzhzVarZze, zzgeVar);
                zzhs zzhsVar = (zzhs) t;
                zzjx zzjxVar = zzhsVar.zzc;
                if (zzjxVar == zzjx.zza()) {
                    zzjxVar = null;
                }
                Object objZzG = zzjk.zzG(i4, zzhzVarZze, zzx(i6), zzjxVar, this.zzn);
                if (objZzG != null) {
                    zzhsVar.zzc = (zzjx) objZzG;
                    return iZza;
                }
                return iZza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzht zzhtVar3 = (zzht) zzhzVarZze;
                    int iZza14 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i26 = zzgeVar.zza + iZza14;
                    while (iZza14 < i26) {
                        iZza14 = zzgf.zza(bArr, iZza14, zzgeVar);
                        zzhtVar3.zzh(zzgv.zzb(zzgeVar.zza));
                    }
                    if (iZza14 == i26) {
                        return iZza14;
                    }
                    throw zzic.zza();
                }
                if (i5 == 0) {
                    zzht zzhtVar4 = (zzht) zzhzVarZze;
                    int iZza15 = zzgf.zza(bArr, iZza2, zzgeVar);
                    zzhtVar4.zzh(zzgv.zzb(zzgeVar.zza));
                    while (iZza15 < i2) {
                        int iZza16 = zzgf.zza(bArr, iZza15, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZza15;
                        }
                        iZza15 = zzgf.zza(bArr, iZza16, zzgeVar);
                        zzhtVar4.zzh(zzgv.zzb(zzgeVar.zza));
                    }
                    return iZza15;
                }
                return iZza2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzim zzimVar5 = (zzim) zzhzVarZze;
                    int iZza17 = zzgf.zza(bArr, iZza2, zzgeVar);
                    int i27 = zzgeVar.zza + iZza17;
                    while (iZza17 < i27) {
                        iZza17 = zzgf.zzc(bArr, iZza17, zzgeVar);
                        zzimVar5.zzg(zzgv.zzc(zzgeVar.zzb));
                    }
                    if (iZza17 == i27) {
                        return iZza17;
                    }
                    throw zzic.zza();
                }
                if (i5 == 0) {
                    zzim zzimVar6 = (zzim) zzhzVarZze;
                    int iZzc3 = zzgf.zzc(bArr, iZza2, zzgeVar);
                    zzimVar6.zzg(zzgv.zzc(zzgeVar.zzb));
                    while (iZzc3 < i2) {
                        int iZza18 = zzgf.zza(bArr, iZzc3, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZzc3;
                        }
                        iZzc3 = zzgf.zzc(bArr, iZza18, zzgeVar);
                        zzimVar6.zzg(zzgv.zzc(zzgeVar.zzb));
                    }
                    return iZzc3;
                }
                return iZza2;
            default:
                if (i5 == 3) {
                    zzji zzjiVarZzv = zzv(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzj = zzgf.zzj(zzjiVarZzv, bArr, i, i2, i28, zzgeVar);
                    zzhzVarZze.add(zzgeVar.zzc);
                    while (iZzj < i2) {
                        int iZza19 = zzgf.zza(bArr, iZzj, zzgeVar);
                        if (i3 != zzgeVar.zza) {
                            return iZzj;
                        }
                        iZzj = zzgf.zzj(zzjiVarZzv, bArr, iZza19, i2, i28, zzgeVar);
                        zzhzVarZze.add(zzgeVar.zzc);
                    }
                    return iZzj;
                }
                return iZza2;
        }
    }

    private final <K, V> int zzt(T t, byte[] bArr, int i, int i2, int i3, long j, zzge zzgeVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzw = zzw(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzir) object).zze()) {
            zzir<K, V> zzirVarZzc = zzir.zza().zzc();
            zzis.zzb(zzirVarZzc, object);
            unsafe.putObject(t, j, zzirVarZzc);
        }
        throw null;
    }

    private final int zzu(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzge zzgeVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(zzgf.zze(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(zzgf.zzd(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int iZzc = zzgf.zzc(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, Long.valueOf(zzgeVar.zzb));
                    unsafe.putInt(t, j2, i4);
                    return iZzc;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iZza = zzgf.zza(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzgeVar.zza));
                    unsafe.putInt(t, j2, i4);
                    return iZza;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgf.zze(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgf.zzd(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iZzc2 = zzgf.zzc(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgeVar.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return iZzc2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iZza2 = zzgf.zza(bArr, i, zzgeVar);
                    int i9 = zzgeVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, BuildConfig.FLAVOR);
                    } else {
                        if ((i6 & 536870912) != 0 && !zzkn.zzb(bArr, iZza2, iZza2 + i9)) {
                            throw zzic.zzf();
                        }
                        unsafe.putObject(t, j, new String(bArr, iZza2, i9, zzia.zza));
                        iZza2 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZza2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int iZzi = zzgf.zzi(zzv(i8), bArr, i, i2, zzgeVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgeVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zzi(object, zzgeVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzi;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iZzh = zzgf.zzh(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, zzgeVar.zzc);
                    unsafe.putInt(t, j2, i4);
                    return iZzh;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iZza3 = zzgf.zza(bArr, i, zzgeVar);
                    int i10 = zzgeVar.zza;
                    zzhw zzhwVarZzx = zzx(i8);
                    if (zzhwVarZzx == null || zzhwVarZzx.zza(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        zzf(t).zzh(i3, Long.valueOf(i10));
                    }
                    return iZza3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int iZza4 = zzgf.zza(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzgv.zzb(zzgeVar.zza)));
                    unsafe.putInt(t, j2, i4);
                    return iZza4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iZzc3 = zzgf.zzc(bArr, i, zzgeVar);
                    unsafe.putObject(t, j, Long.valueOf(zzgv.zzc(zzgeVar.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return iZzc3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int iZzj = zzgf.zzj(zzv(i8), bArr, i, i2, (i3 & (-8)) | 4, zzgeVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgeVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zzi(object2, zzgeVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzj;
                }
                break;
        }
        return i;
    }

    private final zzji zzv(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzji zzjiVar = (zzji) this.zzd[i3];
        if (zzjiVar != null) {
            return zzjiVar;
        }
        zzji<T> zzjiVarZzb = zzjf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzjiVarZzb;
        return zzjiVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzhw zzx(int i) {
        int i2 = i / 3;
        return (zzhw) this.zzd[i2 + i2 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a8, code lost:
    
        if (r0 != r15) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02aa, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r19;
        r1 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02be, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02f1, code lost:
    
        if (r0 != r15) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0314, code lost:
    
        if (r0 != r15) goto L105;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0097. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzy(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzge r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzy(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzge):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzz(Object obj, int i, zzji zzjiVar) {
        return zzjiVar.zzj(zzkh.zzn(obj, i & 1048575));
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final T zza() {
        return (T) ((zzhs) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final boolean zzb(T t, T t2) {
        boolean zZzD;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzA = zzA(i);
            long j = iZzA & 1048575;
            switch (zzC(iZzA)) {
                case 0:
                    if (!zzI(t, t2, i) || Double.doubleToLongBits(zzkh.zzl(t, j)) != Double.doubleToLongBits(zzkh.zzl(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzI(t, t2, i) || Float.floatToIntBits(zzkh.zzj(t, j)) != Float.floatToIntBits(zzkh.zzj(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzI(t, t2, i) || zzkh.zzf(t, j) != zzkh.zzf(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzI(t, t2, i) || zzkh.zzf(t, j) != zzkh.zzf(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzI(t, t2, i) || zzkh.zzf(t, j) != zzkh.zzf(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzI(t, t2, i) || zzkh.zzh(t, j) != zzkh.zzh(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzI(t, t2, i) || !zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzI(t, t2, i) || !zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzI(t, t2, i) || !zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzI(t, t2, i) || zzkh.zzf(t, j) != zzkh.zzf(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzI(t, t2, i) || zzkh.zzd(t, j) != zzkh.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzI(t, t2, i) || zzkh.zzf(t, j) != zzkh.zzf(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzI(t, t2, i) || !zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzD = zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j));
                    break;
                case 50:
                    zZzD = zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzB = zzB(i) & 1048575;
                    if (zzkh.zzd(t, jZzB) != zzkh.zzd(t2, jZzB) || !zzjk.zzD(zzkh.zzn(t, j), zzkh.zzn(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzD) {
                return false;
            }
        }
        if (!this.zzn.zzd(t).equals(this.zzn.zzd(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zzb(t);
        this.zzo.zzb(t2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final int zzc(T t) {
        int i;
        int iZze;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzA = zzA(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzA;
            int iHashCode = 37;
            switch (zzC(iZzA)) {
                case 0:
                    i = i2 * 53;
                    iZze = zzia.zze(Double.doubleToLongBits(zzkh.zzl(t, j)));
                    i2 = i + iZze;
                    break;
                case 1:
                    i = i2 * 53;
                    iZze = Float.floatToIntBits(zzkh.zzj(t, j));
                    i2 = i + iZze;
                    break;
                case 2:
                    i = i2 * 53;
                    iZze = zzia.zze(zzkh.zzf(t, j));
                    i2 = i + iZze;
                    break;
                case 3:
                    i = i2 * 53;
                    iZze = zzia.zze(zzkh.zzf(t, j));
                    i2 = i + iZze;
                    break;
                case 4:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 5:
                    i = i2 * 53;
                    iZze = zzia.zze(zzkh.zzf(t, j));
                    i2 = i + iZze;
                    break;
                case 6:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 7:
                    i = i2 * 53;
                    iZze = zzia.zzf(zzkh.zzh(t, j));
                    i2 = i + iZze;
                    break;
                case 8:
                    i = i2 * 53;
                    iZze = ((String) zzkh.zzn(t, j)).hashCode();
                    i2 = i + iZze;
                    break;
                case 9:
                    Object objZzn = zzkh.zzn(t, j);
                    if (objZzn != null) {
                        iHashCode = objZzn.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZze = zzkh.zzn(t, j).hashCode();
                    i2 = i + iZze;
                    break;
                case 11:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 12:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 13:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 14:
                    i = i2 * 53;
                    iZze = zzia.zze(zzkh.zzf(t, j));
                    i2 = i + iZze;
                    break;
                case 15:
                    i = i2 * 53;
                    iZze = zzkh.zzd(t, j);
                    i2 = i + iZze;
                    break;
                case 16:
                    i = i2 * 53;
                    iZze = zzia.zze(zzkh.zzf(t, j));
                    i2 = i + iZze;
                    break;
                case 17:
                    Object objZzn2 = zzkh.zzn(t, j);
                    if (objZzn2 != null) {
                        iHashCode = objZzn2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZze = zzkh.zzn(t, j).hashCode();
                    i2 = i + iZze;
                    break;
                case 50:
                    i = i2 * 53;
                    iZze = zzkh.zzn(t, j).hashCode();
                    i2 = i + iZze;
                    break;
                case 51:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(Double.doubleToLongBits(zzD(t, j)));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = Float.floatToIntBits(zzE(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(zzG(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(zzG(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(zzG(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zzf(zzH(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = ((String) zzkh.zzn(t, j)).hashCode();
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzkh.zzn(t, j).hashCode();
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzkh.zzn(t, j).hashCode();
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(zzG(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzF(t, j);
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzia.zze(zzG(t, j));
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i4, i3)) {
                        i = i2 * 53;
                        iZze = zzkh.zzn(t, j).hashCode();
                        i2 = i + iZze;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzd(t).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zzb(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final int zze(T t) {
        return this.zzi ? zzr(t) : zzq(t);
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0417, code lost:
    
        if (r6 == 1048575) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0419, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x041f, code lost:
    
        r3 = r9.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0423, code lost:
    
        if (r3 >= r9.zzl) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0425, code lost:
    
        r4 = r9.zzj[r3];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.measurement.zzkh.zzn(r12, r9.zzA(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0437, code lost:
    
        if (r5 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x043e, code lost:
    
        if (r9.zzx(r4) != null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0440, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0443, code lost:
    
        r5 = (com.google.android.gms.internal.measurement.zzir) r5;
        r0 = (com.google.android.gms.internal.measurement.zziq) r9.zzw(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x044b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x044c, code lost:
    
        if (r7 != 0) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0450, code lost:
    
        if (r0 != r32) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0457, code lost:
    
        throw com.google.android.gms.internal.measurement.zzic.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x045a, code lost:
    
        if (r0 > r32) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x045c, code lost:
    
        if (r1 != r7) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x045e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0464, code lost:
    
        throw com.google.android.gms.internal.measurement.zzic.zze();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzg(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzge r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzg(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzge):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzh(T t, byte[] bArr, int i, int i2, zzge zzgeVar) throws IOException {
        if (this.zzi) {
            zzy(t, bArr, i, i2, zzgeVar);
        } else {
            zzg(t, bArr, i, i2, 0, zzgeVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzi(T t) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long jZzA = zzA(this.zzj[i2]) & 1048575;
            Object objZzn = zzkh.zzn(t, jZzA);
            if (objZzn != null) {
                ((zzir) objZzn).zzd();
                zzkh.zzo(t, jZzA, objZzn);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(t, this.zzj[i]);
            i++;
        }
        this.zzn.zze(t);
        if (this.zzh) {
            this.zzo.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
    @Override // com.google.android.gms.internal.measurement.zzji
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzj(T r19) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzja.zzj(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzm(T t, zzha zzhaVar) throws IOException {
        if (!this.zzi) {
            zzR(t, zzhaVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zzb(t);
            throw null;
        }
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzA = zzA(i);
            int i2 = this.zzc[i];
            switch (zzC(iZzA)) {
                case 0:
                    if (zzK(t, i)) {
                        zzhaVar.zzf(i2, zzkh.zzl(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzK(t, i)) {
                        zzhaVar.zze(i2, zzkh.zzj(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzK(t, i)) {
                        zzhaVar.zzc(i2, zzkh.zzf(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzK(t, i)) {
                        zzhaVar.zzh(i2, zzkh.zzf(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzK(t, i)) {
                        zzhaVar.zzi(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzK(t, i)) {
                        zzhaVar.zzj(i2, zzkh.zzf(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzK(t, i)) {
                        zzhaVar.zzk(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzK(t, i)) {
                        zzhaVar.zzl(i2, zzkh.zzh(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzK(t, i)) {
                        zzT(i2, zzkh.zzn(t, iZzA & 1048575), zzhaVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzK(t, i)) {
                        zzhaVar.zzr(i2, zzkh.zzn(t, iZzA & 1048575), zzv(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzK(t, i)) {
                        zzhaVar.zzn(i2, (zzgs) zzkh.zzn(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzK(t, i)) {
                        zzhaVar.zzo(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzK(t, i)) {
                        zzhaVar.zzg(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzK(t, i)) {
                        zzhaVar.zzb(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzK(t, i)) {
                        zzhaVar.zzd(i2, zzkh.zzf(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzK(t, i)) {
                        zzhaVar.zzp(i2, zzkh.zzd(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzK(t, i)) {
                        zzhaVar.zzq(i2, zzkh.zzf(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzK(t, i)) {
                        zzhaVar.zzs(i2, zzkh.zzn(t, iZzA & 1048575), zzv(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzjk.zzJ(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 19:
                    zzjk.zzK(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 20:
                    zzjk.zzL(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 21:
                    zzjk.zzM(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 22:
                    zzjk.zzQ(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 23:
                    zzjk.zzO(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 24:
                    zzjk.zzT(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 25:
                    zzjk.zzW(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 26:
                    zzjk.zzX(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar);
                    break;
                case 27:
                    zzjk.zzZ(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, zzv(i));
                    break;
                case 28:
                    zzjk.zzY(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar);
                    break;
                case 29:
                    zzjk.zzR(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 30:
                    zzjk.zzV(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 31:
                    zzjk.zzU(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 32:
                    zzjk.zzP(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 33:
                    zzjk.zzS(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 34:
                    zzjk.zzN(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, false);
                    break;
                case 35:
                    zzjk.zzJ(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 36:
                    zzjk.zzK(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 37:
                    zzjk.zzL(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 38:
                    zzjk.zzM(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 39:
                    zzjk.zzQ(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 40:
                    zzjk.zzO(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 41:
                    zzjk.zzT(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 42:
                    zzjk.zzW(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 43:
                    zzjk.zzR(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 44:
                    zzjk.zzV(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 45:
                    zzjk.zzU(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 46:
                    zzjk.zzP(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 47:
                    zzjk.zzS(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 48:
                    zzjk.zzN(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, true);
                    break;
                case 49:
                    zzjk.zzaa(this.zzc[i], (List) zzkh.zzn(t, iZzA & 1048575), zzhaVar, zzv(i));
                    break;
                case 50:
                    zzS(zzhaVar, i2, zzkh.zzn(t, iZzA & 1048575), i);
                    break;
                case 51:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzf(i2, zzD(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zze(i2, zzE(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzc(i2, zzG(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzh(i2, zzG(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzi(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzj(i2, zzG(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzk(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzl(i2, zzH(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(t, i2, i)) {
                        zzT(i2, zzkh.zzn(t, iZzA & 1048575), zzhaVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzr(i2, zzkh.zzn(t, iZzA & 1048575), zzv(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzn(i2, (zzgs) zzkh.zzn(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzo(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzg(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzb(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzd(i2, zzG(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzp(i2, zzF(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzq(i2, zzG(t, iZzA & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(t, i2, i)) {
                        zzhaVar.zzs(i2, zzkh.zzn(t, iZzA & 1048575), zzv(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzjw<?, ?> zzjwVar = this.zzn;
        zzjwVar.zzi(zzjwVar.zzd(t), zzhaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final void zzd(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            long j = 1048575 & iZzA;
            int i2 = this.zzc[i];
            switch (zzC(iZzA)) {
                case 0:
                    if (zzK(t2, i)) {
                        zzkh.zzm(t, j, zzkh.zzl(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzK(t2, i)) {
                        zzkh.zzk(t, j, zzkh.zzj(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzK(t2, i)) {
                        zzkh.zzg(t, j, zzkh.zzf(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzK(t2, i)) {
                        zzkh.zzg(t, j, zzkh.zzf(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzK(t2, i)) {
                        zzkh.zzg(t, j, zzkh.zzf(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzK(t2, i)) {
                        zzkh.zzi(t, j, zzkh.zzh(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzK(t2, i)) {
                        zzkh.zzo(t, j, zzkh.zzn(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzo(t, t2, i);
                    break;
                case 10:
                    if (zzK(t2, i)) {
                        zzkh.zzo(t, j, zzkh.zzn(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzK(t2, i)) {
                        zzkh.zzg(t, j, zzkh.zzf(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzK(t2, i)) {
                        zzkh.zze(t, j, zzkh.zzd(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzK(t2, i)) {
                        zzkh.zzg(t, j, zzkh.zzf(t2, j));
                        zzL(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzo(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(t, t2, j);
                    break;
                case 50:
                    zzjk.zzI(this.zzq, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(t2, i2, i)) {
                        zzkh.zzo(t, j, zzkh.zzn(t2, j));
                        zzN(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzp(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(t2, i2, i)) {
                        zzkh.zzo(t, j, zzkh.zzn(t2, j));
                        zzN(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzp(t, t2, i);
                    break;
            }
        }
        zzjk.zzF(this.zzn, t, t2);
        if (this.zzh) {
            zzjk.zzE(this.zzo, t, t2);
        }
    }
}
