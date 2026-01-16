package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzy extends zzjv {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzt> zzd;
    private Long zze;
    private Long zzf;

    zzy(zzkd zzkdVar) {
        super(zzkdVar);
    }

    private final zzt zzc(Integer num) {
        if (this.zzd.containsKey(num)) {
            return this.zzd.get(num);
        }
        zzt zztVar = new zzt(this, this.zzb, null);
        this.zzd.put(num, zztVar);
        return zztVar;
    }

    private final boolean zzd(int i, int i2) {
        zzt zztVar = this.zzd.get(Integer.valueOf(i));
        if (zztVar == null) {
            return false;
        }
        return zztVar.zze.get(i2);
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:374:0x09dc, code lost:
    
        r7 = r64.zzx.zzat().zze();
        r9 = com.google.android.gms.measurement.internal.zzei.zzl(r64.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x09f0, code lost:
    
        if (r8.zza() == false) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x09f2, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x09fb, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x09fc, code lost:
    
        r7.zzc("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x070f A[PHI: r0 r4 r13 r26 r28 r66
      0x070f: PHI (r0v98 java.util.Map) = (r0v100 java.util.Map), (r0v109 java.util.Map) binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]
      0x070f: PHI (r4v28 android.database.Cursor) = (r4v29 android.database.Cursor), (r4v31 android.database.Cursor) binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]
      0x070f: PHI (r13v12 java.lang.String) = (r13v13 java.lang.String), (r13v16 java.lang.String) binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]
      0x070f: PHI (r26v5 java.lang.String) = (r26v6 java.lang.String), (r26v8 java.lang.String) binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]
      0x070f: PHI (r28v7 java.lang.String) = (r28v8 java.lang.String), (r28v14 java.lang.String) binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]
      0x070f: PHI (r66v5 java.util.Iterator<com.google.android.gms.internal.measurement.zzdb>) = 
      (r66v6 java.util.Iterator<com.google.android.gms.internal.measurement.zzdb>)
      (r66v8 java.util.Iterator<com.google.android.gms.internal.measurement.zzdb>)
     binds: [B:276:0x0743, B:259:0x070b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0a2e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b9 A[Catch: SQLiteException -> 0x0220, all -> 0x0ac2, TRY_LEAVE, TryCatch #5 {SQLiteException -> 0x0220, blocks: (B:58:0x01b3, B:60:0x01b9, B:62:0x01c5, B:63:0x01ca, B:64:0x01d4, B:65:0x01e4, B:67:0x01f1), top: B:413:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c5 A[Catch: SQLiteException -> 0x0220, all -> 0x0ac2, TRY_ENTER, TryCatch #5 {SQLiteException -> 0x0220, blocks: (B:58:0x01b3, B:60:0x01b9, B:62:0x01c5, B:63:0x01ca, B:64:0x01d4, B:65:0x01e4, B:67:0x01f1), top: B:413:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0257  */
    /* JADX WARN: Type inference failed for: r4v41, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<com.google.android.gms.internal.measurement.zzcx> zzb(java.lang.String r65, java.util.List<com.google.android.gms.internal.measurement.zzdb> r66, java.util.List<com.google.android.gms.internal.measurement.zzdu> r67, java.lang.Long r68, java.lang.Long r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
