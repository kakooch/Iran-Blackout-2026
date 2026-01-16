package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
class zzgq extends zzgp {
    protected final byte[] zza;

    zzgq(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgs) || zzc() != ((zzgs) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzgq)) {
            return obj.equals(this);
        }
        zzgq zzgqVar = (zzgq) obj;
        int iZzm = zzm();
        int iZzm2 = zzgqVar.zzm();
        if (iZzm != 0 && iZzm2 != 0 && iZzm != iZzm2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzgqVar.zzc()) {
            int iZzc2 = zzc();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(iZzc);
            sb.append(iZzc2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iZzc > zzgqVar.zzc()) {
            int iZzc3 = zzgqVar.zzc();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(iZzc);
            sb2.append(", ");
            sb2.append(iZzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgqVar.zza;
        zzgqVar.zzd();
        int i = 0;
        int i2 = 0;
        while (i < iZzc) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final zzgs zze(int i, int i2) {
        int iZzn = zzgs.zzn(0, i2, zzc());
        return iZzn == 0 ? zzgs.zzb : new zzgm(this.zza, 0, iZzn);
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    final void zzf(zzgh zzghVar) throws IOException {
        ((zzgx) zzghVar).zzp(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final boolean zzh() {
        return zzkn.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    protected final int zzi(int i, int i2, int i3) {
        return zzia.zzh(i, this.zza, 0, i3);
    }
}
