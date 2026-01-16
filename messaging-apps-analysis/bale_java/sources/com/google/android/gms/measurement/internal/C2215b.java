package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2215b extends O3 {
    private String d;
    private Set e;
    private Map f;
    private Long g;
    private Long h;

    C2215b(Y3 y3) {
        super(y3);
    }

    private final m4 n(Integer num) {
        if (this.f.containsKey(num)) {
            return (m4) this.f.get(num);
        }
        m4 m4Var = new m4(this, this.d, null);
        this.f.put(num, m4Var);
        return m4Var;
    }

    private final boolean o(int i, int i2) {
        m4 m4Var = (m4) this.f.get(Integer.valueOf(i));
        if (m4Var == null) {
            return false;
        }
        return m4Var.d.get(i2);
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:409:0x0a44, code lost:
    
        r0 = r62.a.b().w();
        r6 = com.google.android.gms.measurement.internal.C2227d1.z(r62.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0a58, code lost:
    
        if (r8.J() == false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0a5a, code lost:
    
        r7 = java.lang.Integer.valueOf(r8.A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0a63, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0a64, code lost:
    
        r0.c("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x077d A[PHI: r0 r5 r22 r26 r27
      0x077d: PHI (r0v99 java.util.Map) = (r0v101 java.util.Map), (r0v107 java.util.Map) binds: [B:305:0x07ab, B:292:0x0779] A[DONT_GENERATE, DONT_INLINE]
      0x077d: PHI (r5v29 android.database.Cursor) = (r5v30 android.database.Cursor), (r5v31 android.database.Cursor) binds: [B:305:0x07ab, B:292:0x0779] A[DONT_GENERATE, DONT_INLINE]
      0x077d: PHI (r22v11 com.google.android.gms.measurement.internal.q) = (r22v12 com.google.android.gms.measurement.internal.q), (r22v16 com.google.android.gms.measurement.internal.q) binds: [B:305:0x07ab, B:292:0x0779] A[DONT_GENERATE, DONT_INLINE]
      0x077d: PHI (r26v7 java.lang.String) = (r26v8 java.lang.String), (r26v11 java.lang.String) binds: [B:305:0x07ab, B:292:0x0779] A[DONT_GENERATE, DONT_INLINE]
      0x077d: PHI (r27v8 java.lang.String) = (r27v9 java.lang.String), (r27v11 java.lang.String) binds: [B:305:0x07ab, B:292:0x0779] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0971  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0a95  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ac A[Catch: all -> 0x01ba, SQLiteException -> 0x01bd, TRY_LEAVE, TryCatch #14 {all -> 0x01ba, blocks: (B:60:0x01a6, B:62:0x01ac, B:69:0x01c4, B:70:0x01c9, B:71:0x01d3, B:72:0x01e3, B:79:0x020f, B:74:0x01f2, B:76:0x0202, B:78:0x0208, B:94:0x0235), top: B:454:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c4 A[Catch: all -> 0x01ba, SQLiteException -> 0x01bd, TRY_ENTER, TryCatch #14 {all -> 0x01ba, blocks: (B:60:0x01a6, B:62:0x01ac, B:69:0x01c4, B:70:0x01c9, B:71:0x01d3, B:72:0x01e3, B:79:0x020f, B:74:0x01f2, B:76:0x0202, B:78:0x0208, B:94:0x0235), top: B:454:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024e  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r4v25, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v52, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List m(java.lang.String r63, java.util.List r64, java.util.List r65, java.lang.Long r66, java.lang.Long r67) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2215b.m(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
