package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhq implements Runnable {
    final /* synthetic */ zzhr zza;
    private final URL zzb;
    private final String zzc;
    private final zzfj zzd;

    public zzhq(zzhr zzhrVar, String str, URL url, byte[] bArr, Map map, zzfj zzfjVar, byte[] bArr2) {
        this.zza = zzhrVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfjVar);
        this.zzb = url;
        this.zzd = zzfjVar;
        this.zzc = str;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) throws IllegalStateException {
        this.zza.zzx.zzau().zzh(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzhp
            private final zzhq zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            {
                this.zza = this;
                this.zzb = i;
                this.zzc = exc;
                this.zzd = bArr;
                this.zze = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzhr r0 = r9.zza
            r0.zzav()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzhr r2 = r9.zza     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L68
            java.net.URL r3 = r9.zzb     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L68
            java.net.HttpURLConnection r2 = r2.zzd(r3)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L68
            int r3 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L55
            java.util.Map r4 = r2.getHeaderFields()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4d
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3e
            r5.<init>()     // Catch: java.lang.Throwable -> L3e
            java.io.InputStream r6 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3e
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L3c
        L24:
            int r8 = r6.read(r7)     // Catch: java.lang.Throwable -> L3c
            if (r8 <= 0) goto L2e
            r5.write(r7, r0, r8)     // Catch: java.lang.Throwable -> L3c
            goto L24
        L2e:
            byte[] r0 = r5.toByteArray()     // Catch: java.lang.Throwable -> L3c
            r6.close()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r2.disconnect()
            r9.zzb(r3, r1, r0, r4)
            return
        L3c:
            r0 = move-exception
            goto L40
        L3e:
            r0 = move-exception
            r6 = r1
        L40:
            if (r6 == 0) goto L45
            r6.close()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
        L45:
            throw r0     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
        L46:
            r0 = move-exception
            goto L5f
        L48:
            r0 = move-exception
            goto L6d
        L4a:
            r0 = move-exception
            r4 = r1
            goto L5f
        L4d:
            r0 = move-exception
            r4 = r1
            goto L6d
        L50:
            r3 = move-exception
            r4 = r1
            r0 = r3
            r3 = 0
            goto L5f
        L55:
            r3 = move-exception
            r4 = r1
            r0 = r3
            r3 = 0
            goto L6d
        L5a:
            r2 = move-exception
            r4 = r1
            r0 = r2
            r3 = 0
            r2 = r4
        L5f:
            if (r2 == 0) goto L64
            r2.disconnect()
        L64:
            r9.zzb(r3, r1, r1, r4)
            throw r0
        L68:
            r2 = move-exception
            r4 = r1
            r0 = r2
            r3 = 0
            r2 = r4
        L6d:
            if (r2 == 0) goto L72
            r2.disconnect()
        L72:
            r9.zzb(r3, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhq.run():void");
    }

    final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzd.zza(this.zzc, i, exc, bArr, map);
    }
}
