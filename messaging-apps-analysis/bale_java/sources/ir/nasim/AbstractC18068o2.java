package ir.nasim;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: ir.nasim.o2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18068o2 {
    private static final int[] a = {2002, 2000, 1920, 1601, 1600, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 960, 800, 800, 480, 400, 400, 2048};

    /* renamed from: ir.nasim.o2$b */
    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    public static void a(int i, EW4 ew4) {
        ew4.O(7);
        byte[] bArrE = ew4.e();
        bArrE[0] = -84;
        bArrE[1] = 64;
        bArrE[2] = -1;
        bArrE[3] = -1;
        bArrE[4] = (byte) ((i >> 16) & 255);
        bArrE[5] = (byte) ((i >> 8) & 255);
        bArrE[6] = (byte) (i & 255);
    }

    public static com.google.android.exoplayer2.X b(EW4 ew4, String str, String str2, DrmInitData drmInitData) {
        ew4.T(1);
        return new X.b().U(str).g0("audio/ac4").J(2).h0(((ew4.F() & 32) >> 5) == 1 ? 48000 : 44100).O(drmInitData).X(str2).G();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new DW4(bArr)).e;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC18068o2.b d(ir.nasim.DW4 r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L53
            r9 = r7
            goto L54
        L53:
            r9 = r6
        L54:
            int r11 = r11.h(r3)
            if (r9 != r6) goto L63
            r4 = 13
            if (r11 != r4) goto L63
            int[] r0 = ir.nasim.AbstractC18068o2.a
            r11 = r0[r11]
            goto L91
        L63:
            if (r9 != r7) goto L90
            int[] r4 = ir.nasim.AbstractC18068o2.a
            int r6 = r4.length
            if (r11 >= r6) goto L90
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8b
            r7 = 11
            if (r1 == r0) goto L86
            if (r1 == r2) goto L8b
            if (r1 == r3) goto L7c
            goto L84
        L7c:
            if (r11 == r2) goto L82
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
        L82:
            int r4 = r4 + 1
        L84:
            r11 = r4
            goto L91
        L86:
            if (r11 == r6) goto L82
            if (r11 != r7) goto L84
            goto L82
        L8b:
            if (r11 == r2) goto L82
            if (r11 != r6) goto L84
            goto L82
        L90:
            r11 = 0
        L91:
            ir.nasim.o2$b r0 = new ir.nasim.o2$b
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18068o2.d(ir.nasim.DW4):ir.nasim.o2$b");
    }

    public static int e(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    private static int f(DW4 dw4, int i) {
        int i2 = 0;
        while (true) {
            int iH = i2 + dw4.h(i);
            if (!dw4.g()) {
                return iH;
            }
            i2 = (iH + 1) << i;
        }
    }
}
