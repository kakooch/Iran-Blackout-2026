package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.common.Utf8Charset;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sa extends ra {
    public static final ry a = rx.a;
    private final ry b;

    public sa() {
        this(null);
    }

    public sa(ry ryVar) {
        this.b = ryVar;
    }

    private static boolean d(aee aeeVar, int i, int i2, boolean z) {
        int iR;
        long jR;
        int iO;
        int i3;
        int iG = aeeVar.g();
        while (true) {
            try {
                if (aeeVar.d() < i2) {
                    return true;
                }
                if (i >= 3) {
                    iR = aeeVar.v();
                    jR = aeeVar.t();
                    iO = aeeVar.o();
                } else {
                    iR = aeeVar.r();
                    jR = aeeVar.r();
                    iO = 0;
                }
                if (iR == 0 && jR == 0 && iO == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jR) != 0) {
                        return false;
                    }
                    jR = ((jR >> 24) << 21) | ((255 & (jR >> 16)) << 14) | (jR & 255) | (((jR >> 8) & 255) << 7);
                }
                if (i == 4) {
                    i = iO & 1;
                    i3 = (iO & 64) == 0 ? 0 : 1;
                } else {
                    if (i == 3) {
                        i3 = (iO & 32) != 0 ? 1 : 0;
                        if ((iO & 128) == 0) {
                        }
                    } else {
                        i3 = 0;
                    }
                    i = 0;
                }
                if (i != 0) {
                    i3 += 4;
                }
                if (jR < i3) {
                    return false;
                }
                if (aeeVar.d() < jR) {
                    return false;
                }
                aeeVar.k((int) jR);
            } finally {
                aeeVar.h(iG);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0527: MOVE (r2 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:248:0x0525 */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0282 A[Catch: UnsupportedEncodingException -> 0x02ff, all -> 0x0516, TRY_LEAVE, TryCatch #0 {all -> 0x0516, blocks: (B:238:0x04e9, B:240:0x0512, B:132:0x0223, B:146:0x0270, B:148:0x0282, B:150:0x0289, B:152:0x029a, B:154:0x02a4, B:164:0x02db, B:153:0x029f, B:158:0x02b0, B:160:0x02c9, B:162:0x02d1, B:163:0x02d6, B:176:0x031a, B:184:0x0360, B:187:0x0393, B:190:0x03a3, B:191:0x03ab, B:193:0x03b1, B:195:0x03b7, B:196:0x03bb, B:202:0x03d7, B:206:0x0400, B:208:0x040a, B:209:0x0435, B:210:0x043d, B:212:0x0443, B:214:0x0449, B:215:0x044d, B:219:0x045f, B:228:0x0479, B:230:0x04b4, B:231:0x04c3, B:234:0x04d3), top: B:257:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b0 A[Catch: all -> 0x0516, UnsupportedEncodingException -> 0x0525, TryCatch #0 {all -> 0x0516, blocks: (B:238:0x04e9, B:240:0x0512, B:132:0x0223, B:146:0x0270, B:148:0x0282, B:150:0x0289, B:152:0x029a, B:154:0x02a4, B:164:0x02db, B:153:0x029f, B:158:0x02b0, B:160:0x02c9, B:162:0x02d1, B:163:0x02d6, B:176:0x031a, B:184:0x0360, B:187:0x0393, B:190:0x03a3, B:191:0x03ab, B:193:0x03b1, B:195:0x03b7, B:196:0x03bb, B:202:0x03d7, B:206:0x0400, B:208:0x040a, B:209:0x0435, B:210:0x043d, B:212:0x0443, B:214:0x0449, B:215:0x044d, B:219:0x045f, B:228:0x0479, B:230:0x04b4, B:231:0x04c3, B:234:0x04d3), top: B:257:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.ads.interactivemedia.v3.internal.sb e(int r23, com.google.ads.interactivemedia.v3.internal.aee r24, boolean r25, int r26, com.google.ads.interactivemedia.v3.internal.ry r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.sa.e(int, com.google.ads.interactivemedia.v3.internal.aee, boolean, int, com.google.ads.interactivemedia.v3.internal.ry):com.google.ads.interactivemedia.v3.internal.sb");
    }

    private static int f(aee aeeVar, int i) {
        byte[] bArrI = aeeVar.i();
        int iG = aeeVar.g();
        int i2 = iG;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iG + i) {
                return i;
            }
            if ((bArrI[i2] & 255) == 255 && bArrI[i3] == 0) {
                System.arraycopy(bArrI, i2 + 2, bArrI, i3, (i - (i2 - iG)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static String g(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : Utf8Charset.NAME : "UTF-16BE" : "UTF-16";
    }

    private static String h(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int i(byte[] bArr, int i, int i2) {
        int iJ = j(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iJ;
        }
        while (true) {
            int length = bArr.length;
            if (iJ >= length - 1) {
                return length;
            }
            if (iJ % 2 == 0 && bArr[iJ + 1] == 0) {
                return iJ;
            }
            iJ = j(bArr, iJ + 1);
        }
    }

    private static int j(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int k(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] l(byte[] bArr, int i, int i2) {
        return i2 <= i ? aeu.f : Arrays.copyOfRange(bArr, i, i2);
    }

    private static String m(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? BuildConfig.FLAVOR : new String(bArr, i, i2 - i, str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ra
    protected final qz b(ByteBuffer byteBuffer) {
        return c(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.qz c(byte[] r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.sa.c(byte[], int):com.google.ads.interactivemedia.v3.internal.qz");
    }
}
