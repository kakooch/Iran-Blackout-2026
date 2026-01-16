package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.Vf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8260Vf0 implements KW5 {
    public static final C23097wL4 b = C23097wL4.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final C23097wL4 c = C23097wL4.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final LJ a;

    public C8260Vf0(LJ lj) {
        this.a = lj;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, HL4 hl4) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hl4.c(c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // ir.nasim.KW5
    public T72 a(HL4 hl4) {
        return T72.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0076 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #4 {all -> 0x0056, blocks: (B:3:0x0021, B:16:0x0052, B:32:0x0070, B:34:0x0076, B:38:0x00c2, B:39:0x00c5, B:29:0x006b), top: B:49:0x0021 }] */
    @Override // ir.nasim.Z72
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(ir.nasim.DW5 r8, java.io.File r9, ir.nasim.HL4 r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            ir.nasim.XI2.d(r4, r2, r3, r1)
            long r2 = ir.nasim.EI3.b()     // Catch: java.lang.Throwable -> L56
            ir.nasim.wL4 r4 = ir.nasim.C8260Vf0.b     // Catch: java.lang.Throwable -> L56
            java.lang.Object r4 = r10.c(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L56
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L56
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            ir.nasim.LJ r9 = r7.a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4b
            ir.nasim.Pl0 r9 = new ir.nasim.Pl0     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            ir.nasim.LJ r5 = r7.a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4c
        L44:
            r8 = move-exception
            r5 = r6
            goto Lc0
        L48:
            r9 = move-exception
            r5 = r6
            goto L5d
        L4b:
            r5 = r6
        L4c:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            goto L58
        L56:
            r8 = move-exception
            goto Lc6
        L58:
            r9 = 1
            goto L6f
        L5a:
            r8 = move-exception
            goto Lc0
        L5c:
            r9 = move-exception
        L5d:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L69
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r9)     // Catch: java.lang.Throwable -> L5a
        L69:
            if (r5 == 0) goto L6e
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L6e
        L6e:
            r9 = 0
        L6f:
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto Lbc
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r4.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = "Compressed with type: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L56
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " of size "
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            int r1 = ir.nasim.YM7.i(r8)     // Catch: java.lang.Throwable -> L56
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " in "
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            double r1 = ir.nasim.EI3.a(r2)     // Catch: java.lang.Throwable -> L56
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = ", options format: "
            r4.append(r1)     // Catch: java.lang.Throwable -> L56
            ir.nasim.wL4 r1 = ir.nasim.C8260Vf0.c     // Catch: java.lang.Throwable -> L56
            java.lang.Object r10 = r10.c(r1)     // Catch: java.lang.Throwable -> L56
            r4.append(r10)     // Catch: java.lang.Throwable -> L56
            java.lang.String r10 = ", hasAlpha: "
            r4.append(r10)     // Catch: java.lang.Throwable -> L56
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> L56
            r4.append(r8)     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L56
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> L56
        Lbc:
            ir.nasim.XI2.e()
            return r9
        Lc0:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> Lc5
        Lc5:
            throw r8     // Catch: java.lang.Throwable -> L56
        Lc6:
            ir.nasim.XI2.e()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8260Vf0.b(ir.nasim.DW5, java.io.File, ir.nasim.HL4):boolean");
    }
}
