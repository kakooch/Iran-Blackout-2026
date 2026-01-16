package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kh {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    public final kg k;
    private final qz l;

    private kh(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, kg kgVar, qz qzVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = h(i5);
        this.g = i6;
        this.h = i7;
        this.i = i(i7);
        this.j = j;
        this.k = kgVar;
        this.l = qzVar;
    }

    public kh(byte[] bArr, int i) {
        aed aedVar = new aed(bArr);
        aedVar.e(i * 8);
        this.a = aedVar.i(16);
        this.b = aedVar.i(16);
        this.c = aedVar.i(24);
        this.d = aedVar.i(24);
        int i2 = aedVar.i(20);
        this.e = i2;
        this.f = h(i2);
        this.g = aedVar.i(3) + 1;
        int i3 = aedVar.i(5) + 1;
        this.h = i3;
        this.i = i(i3);
        this.j = aeu.R(aedVar.i(4), aedVar.i(32));
        this.k = null;
        this.l = null;
    }

    private static int h(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static int i(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static qz j(List<String> list, List<rg> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrA = aeu.A(str, "=");
            if (strArrA.length != 2) {
                String strValueOf = String.valueOf(str);
                Log.w("FlacStreamMetadata", strValueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(strValueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new ri(strArrA[0], strArrA[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new qz(arrayList);
    }

    public final long a() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.e;
    }

    public final long b(long j) {
        return aeu.I((j * this.e) / 1000000, 0L, this.j - 1);
    }

    public final cy c(byte[] bArr, qz qzVar) {
        bArr[4] = -128;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        qz qzVarD = d(qzVar);
        cx cxVar = new cx();
        cxVar.ae("audio/flac");
        cxVar.W(i);
        cxVar.H(this.g);
        cxVar.af(this.e);
        cxVar.T(Collections.singletonList(bArr));
        cxVar.X(qzVarD);
        return cxVar.a();
    }

    public final qz d(qz qzVar) {
        qz qzVar2 = this.l;
        return qzVar2 == null ? qzVar : qzVar2.c(qzVar);
    }

    public final kh e(kg kgVar) {
        return new kh(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, kgVar, this.l);
    }

    public final kh f(List<String> list) {
        return new kh(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, d(j(list, Collections.emptyList())));
    }

    public final kh g(List<rg> list) {
        return new kh(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, d(j(Collections.emptyList(), list)));
    }
}
