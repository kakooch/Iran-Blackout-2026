package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import android.util.Pair;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lp {
    public byte[] M;
    public lq S;
    public boolean T;
    public kr V;
    public int W;
    private int X;
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public byte[] h;
    public kq i;
    public byte[] j;
    public jc k;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = 0;
    public int q = -1;
    public float r = 0.0f;
    public float s = 0.0f;
    public float t = 0.0f;
    public byte[] u = null;
    public int v = -1;
    public boolean w = false;
    public int x = -1;
    public int y = -1;
    public int z = -1;
    public int A = CloseCodes.NORMAL_CLOSURE;
    public int B = 200;
    public float C = -1.0f;
    public float D = -1.0f;
    public float E = -1.0f;
    public float F = -1.0f;
    public float G = -1.0f;
    public float H = -1.0f;
    public float I = -1.0f;
    public float J = -1.0f;
    public float K = -1.0f;
    public float L = -1.0f;
    public int N = 1;
    public int O = -1;
    public int P = 8000;
    public long Q = 0;
    public long R = 0;
    public boolean U = true;
    private String Y = "eng";

    private lp() {
    }

    /* synthetic */ lp(byte[] bArr) {
    }

    private static Pair<String, List<byte[]>> e(aee aeeVar) throws dt {
        try {
            aeeVar.k(16);
            long jU = aeeVar.u();
            if (jU == 1482049860) {
                return new Pair<>("video/divx", null);
            }
            if (jU == 859189832) {
                return new Pair<>("video/3gpp", null);
            }
            if (jU != 826496599) {
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            }
            int iG = aeeVar.g() + 20;
            byte[] bArrI = aeeVar.i();
            while (true) {
                int length = bArrI.length;
                if (iG >= length - 4) {
                    throw new dt("Failed to find FourCC VC1 initialization data");
                }
                if (bArrI[iG] == 0 && bArrI[iG + 1] == 0 && bArrI[iG + 2] == 1 && bArrI[iG + 3] == 15) {
                    return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrI, iG, length)));
                }
                iG++;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new dt("Error parsing FourCC private data");
        }
    }

    private static List<byte[]> f(byte[] bArr) throws dt {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw new dt("Error parsing vorbis codec private");
            }
            int i3 = 1;
            int i4 = 0;
            while (true) {
                i = bArr[i3];
                if (i != -1) {
                    break;
                }
                i4 += 255;
                i3++;
            }
            int i5 = i3 + 1;
            int i6 = i4 + i;
            int i7 = 0;
            while (true) {
                i2 = bArr[i5];
                if (i2 != -1) {
                    break;
                }
                i7 += 255;
                i5++;
            }
            int i8 = i5 + 1;
            int i9 = i7 + i2;
            if (bArr[i8] != 1) {
                throw new dt("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i8, bArr2, 0, i6);
            int i10 = i8 + i6;
            if (bArr[i10] != 3) {
                throw new dt("Error parsing vorbis codec private");
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw new dt("Error parsing vorbis codec private");
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new dt("Error parsing vorbis codec private");
        }
    }

    private static boolean g(aee aeeVar) throws dt {
        try {
            int iP = aeeVar.p();
            if (iP == 1) {
                return true;
            }
            if (iP == 65534) {
                aeeVar.h(24);
                if (aeeVar.x() == lr.e.getMostSignificantBits()) {
                    if (aeeVar.x() == lr.e.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new dt("Error parsing MS/ACM codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.ka r20, int r21) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 1590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lp.a(com.google.ads.interactivemedia.v3.internal.ka, int):void");
    }
}
