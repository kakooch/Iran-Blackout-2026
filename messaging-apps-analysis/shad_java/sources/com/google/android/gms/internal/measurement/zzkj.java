package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
abstract class zzkj {
    zzkj() {
    }

    final boolean zza(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract String zzc(byte[] bArr, int i, int i2) throws zzic;

    abstract int zzd(CharSequence charSequence, byte[] bArr, int i, int i2);
}
