package ir.nasim;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.xbill.DNS.Flags;
import org.xbill.DNS.dnssec.ValidatingResolver;

/* renamed from: ir.nasim.Ke3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5635Ke3 {
    public static int a(byte b) {
        return b < 0 ? b + Flags.QR : b;
    }

    public static String b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static double c(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return (((((r0[0] << 24) & (-16777216)) | ((r0[1] << 16) & 16711680)) | ((r0[2] << 8) & ValidatingResolver.VALIDATION_REASON_QCLASS)) | (r0[3] & 255)) / 1.073741824E9d;
    }

    public static double d(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[4]);
        return (((((r0[0] << 24) & (-16777216)) | ((r0[1] << 16) & 16711680)) | ((r0[2] << 8) & ValidatingResolver.VALIDATION_REASON_QCLASS)) | (r0[3] & 255)) / 65536.0d;
    }

    public static float e(ByteBuffer byteBuffer) {
        byteBuffer.get(new byte[2]);
        return ((short) (((short) ((r0[0] << 8) & ValidatingResolver.VALIDATION_REASON_QCLASS)) | (r0[1] & 255))) / 256.0f;
    }

    public static String f(ByteBuffer byteBuffer) {
        int iH = h(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((iH >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    public static String g(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return PM7.a(bArr);
    }

    public static int h(ByteBuffer byteBuffer) {
        return (a(byteBuffer.get()) << 8) + a(byteBuffer.get());
    }

    public static int i(ByteBuffer byteBuffer) {
        return (h(byteBuffer) << 8) + a(byteBuffer.get());
    }

    public static long j(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static long k(ByteBuffer byteBuffer) {
        long jH = h(byteBuffer) << 32;
        if (jH >= 0) {
            return jH + j(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static long l(ByteBuffer byteBuffer) {
        long j = j(byteBuffer) << 32;
        if (j >= 0) {
            return j + j(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static int m(ByteBuffer byteBuffer) {
        return a(byteBuffer.get());
    }
}
