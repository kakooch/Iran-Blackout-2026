package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgf {
    static int zza(byte[] bArr, int i, zzge zzgeVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzgeVar);
        }
        zzgeVar.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzge zzgeVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgeVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgeVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgeVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgeVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgeVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzc(byte[] bArr, int i, zzge zzgeVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzgeVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & 127) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzgeVar.zzb = j2;
        return i3;
    }

    static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zze(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static int zzf(byte[] bArr, int i, zzge zzgeVar) throws zzic {
        int iZza = zza(bArr, i, zzgeVar);
        int i2 = zzgeVar.zza;
        if (i2 < 0) {
            throw zzic.zzb();
        }
        if (i2 == 0) {
            zzgeVar.zzc = BuildConfig.FLAVOR;
            return iZza;
        }
        zzgeVar.zzc = new String(bArr, iZza, i2, zzia.zza);
        return iZza + i2;
    }

    static int zzg(byte[] bArr, int i, zzge zzgeVar) throws zzic {
        int iZza = zza(bArr, i, zzgeVar);
        int i2 = zzgeVar.zza;
        if (i2 < 0) {
            throw zzic.zzb();
        }
        if (i2 == 0) {
            zzgeVar.zzc = BuildConfig.FLAVOR;
            return iZza;
        }
        zzgeVar.zzc = zzkn.zze(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzh(byte[] bArr, int i, zzge zzgeVar) throws zzic {
        int iZza = zza(bArr, i, zzgeVar);
        int i2 = zzgeVar.zza;
        if (i2 < 0) {
            throw zzic.zzb();
        }
        if (i2 > bArr.length - iZza) {
            throw zzic.zza();
        }
        if (i2 == 0) {
            zzgeVar.zzc = zzgs.zzb;
            return iZza;
        }
        zzgeVar.zzc = zzgs.zzj(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzi(zzji zzjiVar, byte[] bArr, int i, int i2, zzge zzgeVar) throws IOException {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzgeVar);
            i3 = zzgeVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzic.zza();
        }
        Object objZza = zzjiVar.zza();
        int i5 = i3 + i4;
        zzjiVar.zzh(objZza, bArr, i4, i5, zzgeVar);
        zzjiVar.zzi(objZza);
        zzgeVar.zzc = objZza;
        return i5;
    }

    static int zzj(zzji zzjiVar, byte[] bArr, int i, int i2, int i3, zzge zzgeVar) throws IOException {
        zzja zzjaVar = (zzja) zzjiVar;
        Object objZza = zzjaVar.zza();
        int iZzg = zzjaVar.zzg(objZza, bArr, i, i2, i3, zzgeVar);
        zzjaVar.zzi(objZza);
        zzgeVar.zzc = objZza;
        return iZzg;
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzhz<?> zzhzVar, zzge zzgeVar) {
        zzht zzhtVar = (zzht) zzhzVar;
        int iZza = zza(bArr, i2, zzgeVar);
        zzhtVar.zzh(zzgeVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzgeVar);
            if (i != zzgeVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzgeVar);
            zzhtVar.zzh(zzgeVar.zza);
        }
        return iZza;
    }

    static int zzl(byte[] bArr, int i, zzhz<?> zzhzVar, zzge zzgeVar) throws IOException {
        zzht zzhtVar = (zzht) zzhzVar;
        int iZza = zza(bArr, i, zzgeVar);
        int i2 = zzgeVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzgeVar);
            zzhtVar.zzh(zzgeVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzic.zza();
    }

    static int zzm(zzji<?> zzjiVar, int i, byte[] bArr, int i2, int i3, zzhz<?> zzhzVar, zzge zzgeVar) throws IOException {
        int iZzi = zzi(zzjiVar, bArr, i2, i3, zzgeVar);
        zzhzVar.add(zzgeVar.zzc);
        while (iZzi < i3) {
            int iZza = zza(bArr, iZzi, zzgeVar);
            if (i != zzgeVar.zza) {
                break;
            }
            iZzi = zzi(zzjiVar, bArr, iZza, i3, zzgeVar);
            zzhzVar.add(zzgeVar.zzc);
        }
        return iZzi;
    }

    static int zzn(int i, byte[] bArr, int i2, int i3, zzjx zzjxVar, zzge zzgeVar) throws zzic {
        if ((i >>> 3) == 0) {
            throw zzic.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzgeVar);
            zzjxVar.zzh(i, Long.valueOf(zzgeVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzjxVar.zzh(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzgeVar);
            int i5 = zzgeVar.zza;
            if (i5 < 0) {
                throw zzic.zzb();
            }
            if (i5 > bArr.length - iZza) {
                throw zzic.zza();
            }
            if (i5 == 0) {
                zzjxVar.zzh(i, zzgs.zzb);
            } else {
                zzjxVar.zzh(i, zzgs.zzj(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzic.zzc();
            }
            zzjxVar.zzh(i, Integer.valueOf(zzd(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzjx zzjxVarZzb = zzjx.zzb();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzgeVar);
            int i8 = zzgeVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZza2;
                break;
            }
            i7 = i8;
            i2 = zzn(i8, bArr, iZza2, i3, zzjxVarZzb, zzgeVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzic.zze();
        }
        zzjxVar.zzh(i, zzjxVarZzb);
        return i2;
    }
}
