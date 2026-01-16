package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qa {
    public static py a(jv jvVar) throws IOException {
        byte[] bArr;
        aee aeeVar = new aee(16);
        if (pz.a(jvVar, aeeVar).a != 1380533830) {
            return null;
        }
        jvVar.g(aeeVar.i(), 0, 4);
        aeeVar.h(0);
        int iV = aeeVar.v();
        if (iV != 1463899717) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(iV);
            Log.e("WavHeaderReader", sb.toString());
            return null;
        }
        pz pzVarA = pz.a(jvVar, aeeVar);
        while (pzVarA.a != 1718449184) {
            jvVar.i((int) pzVarA.b);
            pzVarA = pz.a(jvVar, aeeVar);
        }
        ary.q(pzVarA.b >= 16);
        jvVar.g(aeeVar.i(), 0, 16);
        aeeVar.h(0);
        int iP = aeeVar.p();
        int iP2 = aeeVar.p();
        int iC = aeeVar.C();
        aeeVar.C();
        int iP3 = aeeVar.p();
        int iP4 = aeeVar.p();
        int i = ((int) pzVarA.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            jvVar.g(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = aeu.f;
        }
        return new py(iP, iP2, iC, iP3, iP4, bArr);
    }
}
