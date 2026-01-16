package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class yh implements yp {
    private static final int[] b = {8, 13, 11, 2, 0, 1, 7};
    private final boolean c = true;

    private static void b(int i, List<Integer> list) {
        if (i != -1) {
            Integer numValueOf = Integer.valueOf(i);
            if (list.contains(numValueOf)) {
                return;
            }
            list.add(numValueOf);
        }
    }

    private static boolean c(jy jyVar, jv jvVar) throws IOException {
        try {
            boolean zG = jyVar.g(jvVar);
            jvVar.j();
            return zG;
        } catch (EOFException unused) {
            jvVar.j();
            return false;
        } catch (Throwable th) {
            jvVar.j();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e5  */
    @Override // com.google.ads.interactivemedia.v3.internal.yp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* bridge */ /* synthetic */ com.google.ads.interactivemedia.v3.internal.yf a(android.net.Uri r17, com.google.ads.interactivemedia.v3.internal.cy r18, java.util.List r19, com.google.ads.interactivemedia.v3.internal.aes r20, java.util.Map r21, com.google.ads.interactivemedia.v3.internal.jv r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yh.a(android.net.Uri, com.google.ads.interactivemedia.v3.internal.cy, java.util.List, com.google.ads.interactivemedia.v3.internal.aes, java.util.Map, com.google.ads.interactivemedia.v3.internal.jv):com.google.ads.interactivemedia.v3.internal.yf");
    }
}
