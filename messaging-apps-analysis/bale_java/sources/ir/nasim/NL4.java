package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* loaded from: classes2.dex */
public abstract class NL4 {
    public static List a(byte[] bArr) {
        long jH = h(f(bArr));
        long jH2 = h(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(jH));
        arrayList.add(b(jH2));
        return arrayList;
    }

    private static byte[] b(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long d(byte b, byte b2) {
        int i;
        int i2 = b & 255;
        int i3 = b & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = b2 & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        return i * (i4 >= 16 ? 2500 << r6 : i4 >= 12 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND << (i4 & 1) : (i4 & 3) == 3 ? 60000 : AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND << r6);
    }

    public static long e(byte[] bArr) {
        return d(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    private static int f(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int g(ByteBuffer byteBuffer) {
        return (int) ((d(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    private static long h(long j) {
        return (j * 1000000000) / 48000;
    }
}
