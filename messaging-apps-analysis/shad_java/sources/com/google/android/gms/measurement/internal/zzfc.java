package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfc extends zzjv implements zzad {
    private final Map<String, Map<String, String>> zzb;
    private final Map<String, Map<String, Boolean>> zzc;
    private final Map<String, Map<String, Boolean>> zzd;
    private final Map<String, com.google.android.gms.internal.measurement.zzcp> zze;
    private final Map<String, Map<String, Integer>> zzf;
    private final Map<String, String> zzg;

    zzfc(zzkd zzkdVar) {
        super(zzkdVar);
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzf = new ArrayMap();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00d3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00d3 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzn(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            r11.zzX()
            r11.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.zze
            java.lang.Object r0 = r0.get(r12)
            if (r0 != 0) goto Lda
            com.google.android.gms.measurement.internal.zzkd r0 = r11.zza
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r0.zzg()
            r0.zzX()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zze()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            java.lang.String r5 = "remote_config"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            r6[r10] = r12     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            if (r3 != 0) goto L43
            goto L80
        L43:
            byte[] r3 = r2.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            boolean r4 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            if (r4 == 0) goto L60
            com.google.android.gms.measurement.internal.zzfl r4 = r0.zzx     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            java.lang.String r5 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzei.zzl(r12)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
            r4.zzb(r5, r6)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> Ld2
        L60:
            r2.close()
            goto L84
        L64:
            r3 = move-exception
            goto L6b
        L66:
            r12 = move-exception
            goto Ld4
        L68:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L6b:
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzx     // Catch: java.lang.Throwable -> Ld2
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()     // Catch: java.lang.Throwable -> Ld2
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzei.zzl(r12)     // Catch: java.lang.Throwable -> Ld2
            r0.zzc(r4, r5, r3)     // Catch: java.lang.Throwable -> Ld2
            if (r2 == 0) goto L83
        L80:
            r2.close()
        L83:
            r3 = r1
        L84:
            if (r3 != 0) goto La5
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r11.zzb
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.zzc
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r11.zzd
            r0.put(r12, r1)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r0 = r11.zze
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.zzg
            r0.put(r12, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> r0 = r11.zzf
            r0.put(r12, r1)
            return
        La5:
            com.google.android.gms.internal.measurement.zzcp r0 = r11.zzq(r12, r3)
            com.google.android.gms.internal.measurement.zzho r0 = r0.zzbu()
            com.google.android.gms.internal.measurement.zzco r0 = (com.google.android.gms.internal.measurement.zzco) r0
            r11.zzo(r12, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r11.zzb
            com.google.android.gms.internal.measurement.zzhs r3 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r3 = (com.google.android.gms.internal.measurement.zzcp) r3
            java.util.Map r3 = zzr(r3)
            r2.put(r12, r3)
            java.util.Map<java.lang.String, com.google.android.gms.internal.measurement.zzcp> r2 = r11.zze
            com.google.android.gms.internal.measurement.zzhs r0 = r0.zzaA()
            com.google.android.gms.internal.measurement.zzcp r0 = (com.google.android.gms.internal.measurement.zzcp) r0
            r2.put(r12, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r11.zzg
            r0.put(r12, r1)
            return
        Ld2:
            r12 = move-exception
            r1 = r2
        Ld4:
            if (r1 == 0) goto Ld9
            r1.close()
        Ld9:
            throw r12
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfc.zzn(java.lang.String):void");
    }

    private final void zzo(String str, com.google.android.gms.internal.measurement.zzco zzcoVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzcoVar != null) {
            for (int i = 0; i < zzcoVar.zza(); i++) {
                com.google.android.gms.internal.measurement.zzcm zzcmVarZzbu = zzcoVar.zzb(i).zzbu();
                if (TextUtils.isEmpty(zzcmVarZzbu.zza())) {
                    this.zzx.zzat().zze().zza("EventConfig contained null event name");
                } else {
                    String strZza = zzcmVarZzbu.zza();
                    String strZzb = zzgi.zzb(zzcmVarZzbu.zza());
                    if (!TextUtils.isEmpty(strZzb)) {
                        zzcmVarZzbu.zzb(strZzb);
                        zzcoVar.zzc(i, zzcmVarZzbu);
                    }
                    arrayMap.put(strZza, Boolean.valueOf(zzcmVarZzbu.zzc()));
                    arrayMap2.put(zzcmVarZzbu.zza(), Boolean.valueOf(zzcmVarZzbu.zzd()));
                    if (zzcmVarZzbu.zze()) {
                        if (zzcmVarZzbu.zzf() < 2 || zzcmVarZzbu.zzf() > 65535) {
                            this.zzx.zzat().zze().zzc("Invalid sampling rate. Event name, sample rate", zzcmVarZzbu.zza(), Integer.valueOf(zzcmVarZzbu.zzf()));
                        } else {
                            arrayMap3.put(zzcmVarZzbu.zza(), Integer.valueOf(zzcmVarZzbu.zzf()));
                        }
                    }
                }
            }
        }
        this.zzc.put(str, arrayMap);
        this.zzd.put(str, arrayMap2);
        this.zzf.put(str, arrayMap3);
    }

    private final com.google.android.gms.internal.measurement.zzcp zzq(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzcp.zzk();
        }
        try {
            com.google.android.gms.internal.measurement.zzcp zzcpVarZzaA = ((com.google.android.gms.internal.measurement.zzco) zzkf.zzt(com.google.android.gms.internal.measurement.zzcp.zzj(), bArr)).zzaA();
            this.zzx.zzat().zzk().zzc("Parsed config. version, gmp_app_id", zzcpVarZzaA.zza() ? Long.valueOf(zzcpVarZzaA.zzb()) : null, zzcpVarZzaA.zzc() ? zzcpVarZzaA.zzd() : null);
            return zzcpVarZzaA;
        } catch (com.google.android.gms.internal.measurement.zzic e) {
            this.zzx.zzat().zze().zzc("Unable to merge remote config. appId", zzei.zzl(str), e);
            return com.google.android.gms.internal.measurement.zzcp.zzk();
        } catch (RuntimeException e2) {
            this.zzx.zzat().zze().zzc("Unable to merge remote config. appId", zzei.zzl(str), e2);
            return com.google.android.gms.internal.measurement.zzcp.zzk();
        }
    }

    private static final Map<String, String> zzr(com.google.android.gms.internal.measurement.zzcp zzcpVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzcpVar != null) {
            for (com.google.android.gms.internal.measurement.zzcr zzcrVar : zzcpVar.zze()) {
                arrayMap.put(zzcrVar.zza(), zzcrVar.zzb());
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzad
    public final String zza(String str, String str2) throws Throwable {
        zzg();
        zzn(str);
        Map<String, String> map = this.zzb.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        return false;
    }

    protected final com.google.android.gms.internal.measurement.zzcp zzb(String str) {
        zzX();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzn(str);
        return this.zze.get(str);
    }

    protected final String zzc(String str) {
        zzg();
        return this.zzg.get(str);
    }

    protected final void zzd(String str) {
        zzg();
        this.zzg.put(str, null);
    }

    final void zze(String str) {
        zzg();
        this.zze.remove(str);
    }

    final boolean zzf(String str) {
        zzg();
        com.google.android.gms.internal.measurement.zzcp zzcpVarZzb = zzb(str);
        if (zzcpVarZzb == null) {
            return false;
        }
        return zzcpVarZzb.zzi();
    }

    protected final boolean zzh(String str, byte[] bArr, String str2) throws Throwable {
        zzX();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzco zzcoVarZzbu = zzq(str, bArr).zzbu();
        if (zzcoVarZzbu == null) {
            return false;
        }
        zzo(str, zzcoVarZzbu);
        this.zze.put(str, zzcoVarZzbu.zzaA());
        this.zzg.put(str, str2);
        this.zzb.put(str, zzr(zzcoVarZzbu.zzaA()));
        this.zza.zzi().zzJ(str, new ArrayList(zzcoVarZzbu.zzd()));
        try {
            zzcoVarZzbu.zze();
            bArr = zzcoVarZzbu.zzaA().zzbp();
        } catch (RuntimeException e) {
            this.zzx.zzat().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzei.zzl(str), e);
        }
        zzai zzaiVarZzi = this.zza.zzi();
        Preconditions.checkNotEmpty(str);
        zzaiVarZzi.zzg();
        zzaiVarZzi.zzX();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzaiVarZzi.zze().update("apps", r2, "app_id = ?", new String[]{str}) == 0) {
                zzaiVarZzi.zzx.zzat().zzb().zzb("Failed to update remote config (got 0). appId", zzei.zzl(str));
            }
        } catch (SQLiteException e2) {
            zzaiVarZzi.zzx.zzat().zzb().zzc("Error storing remote config. appId", zzei.zzl(str), e2);
        }
        this.zze.put(str, zzcoVarZzbu.zzaA());
        return true;
    }

    final boolean zzi(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzn(str);
        if (zzl(str) && zzkk.zzR(str2)) {
            return true;
        }
        if (zzm(str) && zzkk.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzc.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzj(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzn(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzd.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int zzk(String str, String str2) throws Throwable {
        Integer num;
        zzg();
        zzn(str);
        Map<String, Integer> map = this.zzf.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    final boolean zzl(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }
}
