package com.google.android.gms.internal.measurement;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzia {
    static final Charset zza = Charset.forName(Utf8Charset.NAME);
    public static final byte[] zzc;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzc = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new zzgu(bArr, 0, 0, false, null).zza(0);
        } catch (zzic e) {
            throw new IllegalArgumentException(e);
        }
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zzb(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzc(byte[] bArr) {
        return zzkn.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzf(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int iZzh = zzh(length, bArr, 0, length);
        if (iZzh == 0) {
            return 1;
        }
        return iZzh;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzi(Object obj, Object obj2) {
        return ((zzix) obj).zzbG().zzau((zzix) obj2).zzaD();
    }
}
