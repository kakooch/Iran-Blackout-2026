package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjh implements zziu {
    private final zzix zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzjh(zzix zzixVar, String str, Object[] objArr) {
        char cCharAt;
        this.zza = zzixVar;
        this.zzb = str;
        this.zzc = objArr;
        int i = 1;
        try {
            cCharAt = str.charAt(0);
        } catch (ArrayIndexOutOfBoundsException unused) {
            char[] charArray = str.toCharArray();
            String str2 = new String(charArray);
            try {
                try {
                    cCharAt = str2.charAt(0);
                    str = str2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    e = e;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            } catch (ArrayIndexOutOfBoundsException unused2) {
                char[] cArr = new char[str2.length()];
                str2.getChars(0, str2.length(), cArr, 0);
                String str3 = new String(cArr);
                try {
                    cCharAt = str3.charAt(0);
                    str = str3;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    e = e2;
                    str2 = str3;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            }
        }
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        while (true) {
            int i4 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 55296) {
                this.zzd = (cCharAt2 << i3) | i2;
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final zzix zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzc() {
        return (this.zzd & 1) == 1 ? 1 : 2;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
