package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzha {
    private final zzgz zza;

    private zzha(zzgz zzgzVar) {
        zzia.zzb(zzgzVar, "output");
        this.zza = zzgzVar;
        zzgzVar.zza = this;
    }

    public static zzha zza(zzgz zzgzVar) {
        zzha zzhaVar = zzgzVar.zza;
        return zzhaVar != null ? zzhaVar : new zzha(zzgzVar);
    }

    public final void zzE(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzih)) {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzih zzihVar = (zzih) list;
        while (i2 < list.size()) {
            Object objZzg = zzihVar.zzg(i2);
            if (objZzg instanceof String) {
                this.zza.zzh(i, (String) objZzg);
            } else {
                this.zza.zzi(i, (zzgs) objZzg);
            }
            i2++;
        }
    }

    public final void zzF(int i, List<zzgs> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzi(i, list.get(i2));
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zzd(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzg(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzh(i, str);
    }

    public final void zzn(int i, zzgs zzgsVar) throws IOException {
        this.zza.zzi(i, zzgsVar);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzc(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzq(int i, long j) throws IOException {
        this.zza.zze(i, (j >> 63) ^ (j + j));
    }

    public final void zzr(int i, Object obj, zzji zzjiVar) throws IOException {
        zzix zzixVar = (zzix) obj;
        zzgx zzgxVar = (zzgx) this.zza;
        zzgxVar.zzl((i << 3) | 2);
        zzgb zzgbVar = (zzgb) zzixVar;
        int iZzbq = zzgbVar.zzbq();
        if (iZzbq == -1) {
            iZzbq = zzjiVar.zze(zzgbVar);
            zzgbVar.zzbr(iZzbq);
        }
        zzgxVar.zzl(iZzbq);
        zzjiVar.zzm(zzixVar, zzgxVar.zza);
    }

    public final void zzs(int i, Object obj, zzji zzjiVar) throws IOException {
        zzgz zzgzVar = this.zza;
        zzgzVar.zza(i, 3);
        zzjiVar.zzm((zzix) obj, zzgzVar.zza);
        zzgzVar.zza(i, 4);
    }

    public final void zzt(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    public final void zzu(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    public final void zzC(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzv += zzgz.zzv(list.get(i3).intValue());
        }
        this.zza.zzl(iZzv);
        while (i2 < list.size()) {
            this.zza.zzk(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzD(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).booleanValue();
            i3++;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzj(list.get(i2).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzG(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzc(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzw += zzgz.zzw(list.get(i3).intValue());
        }
        this.zza.zzl(iZzw);
        while (i2 < list.size()) {
            this.zza.zzl(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzH(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzm(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzI(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzo(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzJ(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzgz zzgzVar = this.zza;
                int iIntValue = list.get(i2).intValue();
                zzgzVar.zzc(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = list.get(i3).intValue();
            iZzw += zzgz.zzw((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzl(iZzw);
        while (i2 < list.size()) {
            zzgz zzgzVar2 = this.zza;
            int iIntValue3 = list.get(i2).intValue();
            zzgzVar2.zzl((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public final void zzK(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzgz zzgzVar = this.zza;
                long jLongValue = list.get(i2).longValue();
                zzgzVar.zze(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = list.get(i3).longValue();
            iZzx += zzgz.zzx((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzl(iZzx);
        while (i2 < list.size()) {
            zzgz zzgzVar2 = this.zza;
            long jLongValue3 = list.get(i2).longValue();
            zzgzVar2.zzn((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public final void zzv(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzv += zzgz.zzv(list.get(i3).intValue());
        }
        this.zza.zzl(iZzv);
        while (i2 < list.size()) {
            this.zza.zzk(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzw(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzm(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzx(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zze(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzgz.zzx(list.get(i3).longValue());
        }
        this.zza.zzl(iZzx);
        while (i2 < list.size()) {
            this.zza.zzn(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzy(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zze(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzgz.zzx(list.get(i3).longValue());
        }
        this.zza.zzl(iZzx);
        while (i2 < list.size()) {
            this.zza.zzn(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzz(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzo(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzA(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(list.get(i2).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).floatValue();
            i3 += 4;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzm(Float.floatToRawIntBits(list.get(i2).floatValue()));
            i2++;
        }
    }

    public final void zzB(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zza(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).doubleValue();
            i3 += 8;
        }
        this.zza.zzl(i3);
        while (i2 < list.size()) {
            this.zza.zzo(Double.doubleToRawLongBits(list.get(i2).doubleValue()));
            i2++;
        }
    }
}
