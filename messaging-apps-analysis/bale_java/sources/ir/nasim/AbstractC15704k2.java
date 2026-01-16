package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.nio.ByteBuffer;
import okio.Utf8;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.k2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15704k2 {
    private static final int[] a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, 32000};
    private static final int[] c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, WKSRecord.Service.ERPC, WKSRecord.Service.NETBIOS_SSN, 174, 208, WKSRecord.Service.SUR_MEAS, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: ir.nasim.k2$b */
    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        private b(String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
        }
    }

    private static int a(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((AbstractC9683aN7.G(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - iPosition;
            }
        }
        return -1;
    }

    private static int c(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static com.google.android.exoplayer2.X d(EW4 ew4, String str, String str2, DrmInitData drmInitData) {
        DW4 dw4 = new DW4();
        dw4.m(ew4);
        int i = b[dw4.h(2)];
        dw4.r(8);
        int i2 = d[dw4.h(3)];
        if (dw4.h(1) != 0) {
            i2++;
        }
        int i3 = e[dw4.h(5)] * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        dw4.c();
        ew4.S(dw4.d());
        return new X.b().U(str).g0("audio/ac3").J(i2).h0(i).O(drmInitData).X(str2).I(i3).b0(i3).G();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static b f(DW4 dw4) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int iE = dw4.e();
        dw4.r(40);
        boolean z = dw4.h(5) > 10;
        dw4.p(iE);
        int i13 = -1;
        if (z) {
            dw4.r(16);
            int iH = dw4.h(2);
            if (iH == 0) {
                i13 = 0;
            } else if (iH == 1) {
                i13 = 1;
            } else if (iH == 2) {
                i13 = 2;
            }
            dw4.r(3);
            int iH2 = (dw4.h(11) + 1) * 2;
            int iH3 = dw4.h(2);
            if (iH3 == 3) {
                i8 = c[dw4.h(2)];
                i7 = 3;
                i9 = 6;
            } else {
                int iH4 = dw4.h(2);
                int i14 = a[iH4];
                i7 = iH4;
                i8 = b[iH3];
                i9 = i14;
            }
            int i15 = i9 * 256;
            int iA = a(iH2, i8, i9);
            int iH5 = dw4.h(3);
            boolean zG = dw4.g();
            i = d[iH5] + (zG ? 1 : 0);
            dw4.r(10);
            if (dw4.g()) {
                dw4.r(8);
            }
            if (iH5 == 0) {
                dw4.r(5);
                if (dw4.g()) {
                    dw4.r(8);
                }
            }
            if (i13 == 1 && dw4.g()) {
                dw4.r(16);
            }
            if (dw4.g()) {
                if (iH5 > 2) {
                    dw4.r(2);
                }
                if ((iH5 & 1) == 0 || iH5 <= 2) {
                    i11 = 6;
                } else {
                    i11 = 6;
                    dw4.r(6);
                }
                if ((iH5 & 4) != 0) {
                    dw4.r(i11);
                }
                if (zG && dw4.g()) {
                    dw4.r(5);
                }
                if (i13 == 0) {
                    if (dw4.g()) {
                        i12 = 6;
                        dw4.r(6);
                    } else {
                        i12 = 6;
                    }
                    if (iH5 == 0 && dw4.g()) {
                        dw4.r(i12);
                    }
                    if (dw4.g()) {
                        dw4.r(i12);
                    }
                    int iH6 = dw4.h(2);
                    if (iH6 == 1) {
                        dw4.r(5);
                    } else if (iH6 == 2) {
                        dw4.r(12);
                    } else if (iH6 == 3) {
                        int iH7 = dw4.h(5);
                        if (dw4.g()) {
                            dw4.r(5);
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                dw4.r(4);
                            }
                            if (dw4.g()) {
                                if (dw4.g()) {
                                    dw4.r(4);
                                }
                                if (dw4.g()) {
                                    dw4.r(4);
                                }
                            }
                        }
                        if (dw4.g()) {
                            dw4.r(5);
                            if (dw4.g()) {
                                dw4.r(7);
                                if (dw4.g()) {
                                    dw4.r(8);
                                }
                            }
                        }
                        dw4.r((iH7 + 2) * 8);
                        dw4.c();
                    }
                    if (iH5 < 2) {
                        if (dw4.g()) {
                            dw4.r(14);
                        }
                        if (iH5 == 0 && dw4.g()) {
                            dw4.r(14);
                        }
                    }
                    if (dw4.g()) {
                        if (i7 == 0) {
                            dw4.r(5);
                        } else {
                            for (int i16 = 0; i16 < i9; i16++) {
                                if (dw4.g()) {
                                    dw4.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (dw4.g()) {
                dw4.r(5);
                if (iH5 == 2) {
                    dw4.r(4);
                }
                if (iH5 >= 6) {
                    dw4.r(2);
                }
                if (dw4.g()) {
                    dw4.r(8);
                }
                if (iH5 == 0 && dw4.g()) {
                    dw4.r(8);
                }
                if (iH3 < 3) {
                    dw4.q();
                }
            }
            if (i13 == 0 && i7 != 3) {
                dw4.q();
            }
            if (i13 == 2 && (i7 == 3 || dw4.g())) {
                i10 = 6;
                dw4.r(6);
            } else {
                i10 = 6;
            }
            str = (dw4.g() && dw4.h(i10) == 1 && dw4.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i2 = i13;
            i3 = i15;
            i5 = iH2;
            i6 = i8;
            i4 = iA;
        } else {
            dw4.r(32);
            int iH8 = dw4.h(2);
            String str2 = iH8 == 3 ? null : "audio/ac3";
            int iH9 = dw4.h(6);
            int i17 = e[iH9 / 2] * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            int iC = c(iH8, iH9);
            dw4.r(8);
            int iH10 = dw4.h(3);
            if ((iH10 & 1) != 0 && iH10 != 1) {
                dw4.r(2);
            }
            if ((iH10 & 4) != 0) {
                dw4.r(2);
            }
            if (iH10 == 2) {
                dw4.r(2);
            }
            int[] iArr = b;
            int i18 = iH8 < iArr.length ? iArr[iH8] : -1;
            i = d[iH10] + (dw4.g() ? 1 : 0);
            i2 = -1;
            str = str2;
            i3 = 1536;
            i4 = i17;
            i5 = iC;
            i6 = i18;
        }
        return new b(str, i2, i, i6, i5, i3, i4);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & Utf8.REPLACEMENT_BYTE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.X h(ir.nasim.EW4 r7, java.lang.String r8, java.lang.String r9, com.google.android.exoplayer2.drm.DrmInitData r10) {
        /*
            ir.nasim.DW4 r0 = new ir.nasim.DW4
            r0.<init>()
            r0.m(r7)
            r1 = 13
            int r1 = r0.h(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.r(r2)
            r3 = 2
            int r3 = r0.h(r3)
            int[] r4 = ir.nasim.AbstractC15704k2.b
            r3 = r4[r3]
            r4 = 10
            r0.r(r4)
            int[] r4 = ir.nasim.AbstractC15704k2.d
            int r5 = r0.h(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.h(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.r(r2)
            r2 = 4
            int r2 = r0.h(r2)
            r0.r(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.s(r2)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.r(r5)
        L4f:
            int r2 = r0.b()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.r(r6)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.c()
            int r0 = r0.d()
            r7.S(r0)
            com.google.android.exoplayer2.X$b r7 = new com.google.android.exoplayer2.X$b
            r7.<init>()
            com.google.android.exoplayer2.X$b r7 = r7.U(r8)
            com.google.android.exoplayer2.X$b r7 = r7.g0(r2)
            com.google.android.exoplayer2.X$b r7 = r7.J(r4)
            com.google.android.exoplayer2.X$b r7 = r7.h0(r3)
            com.google.android.exoplayer2.X$b r7 = r7.O(r10)
            com.google.android.exoplayer2.X$b r7 = r7.X(r9)
            com.google.android.exoplayer2.X$b r7 = r7.b0(r1)
            com.google.android.exoplayer2.X r7 = r7.G()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15704k2.h(ir.nasim.EW4, java.lang.String, java.lang.String, com.google.android.exoplayer2.drm.DrmInitData):com.google.android.exoplayer2.X");
    }

    public static int i(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                return 40 << ((bArr[(b2 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
