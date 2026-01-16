package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzgs implements Iterable<Byte>, Serializable {
    private static final zzgn zza;
    public static final zzgs zzb = new zzgq(zzia.zzc);
    private int zzc = 0;

    static {
        zzgi zzgiVar = null;
        zza = zzgd.zza() ? new zzgr(zzgiVar) : new zzgl(zzgiVar);
        new zzgj();
    }

    zzgs() {
    }

    public static zzgs zzj(byte[] bArr, int i, int i2) {
        zzn(i, i + i2, bArr.length);
        return new zzgq(zza.zza(bArr, i, i2));
    }

    public static zzgs zzk(String str) {
        return new zzgq(str.getBytes(zzia.zza));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zzc;
        if (iZzi == 0) {
            int iZzc = zzc();
            iZzi = zzi(iZzc, 0, iZzc);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zzc = iZzi;
        }
        return iZzi;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return new zzgi(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        objArr[2] = zzc() <= 50 ? zzju.zza(this) : String.valueOf(zzju.zza(zze(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzc();

    public abstract zzgs zze(int i, int i2);

    abstract void zzf(zzgh zzghVar) throws IOException;

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    protected abstract int zzi(int i, int i2, int i3);

    public final String zzl(Charset charset) {
        return zzc() == 0 ? BuildConfig.FLAVOR : zzg(charset);
    }

    protected final int zzm() {
        return this.zzc;
    }

    static int zzn(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
