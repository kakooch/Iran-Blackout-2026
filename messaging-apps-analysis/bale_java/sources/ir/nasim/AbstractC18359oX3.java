package ir.nasim;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: ir.nasim.oX3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18359oX3 {
    public static byte[] a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static BX0 b(MediaFormat mediaFormat) {
        if (AbstractC9683aN7.a < 29) {
            return null;
        }
        int integer = mediaFormat.getInteger("color-standard", -1);
        int integer2 = mediaFormat.getInteger("color-range", -1);
        int integer3 = mediaFormat.getInteger("color-transfer", -1);
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] bArrA = byteBuffer != null ? a(byteBuffer) : null;
        if (!d(integer)) {
            integer = -1;
        }
        if (!c(integer2)) {
            integer2 = -1;
        }
        if (!e(integer3)) {
            integer3 = -1;
        }
        if (integer == -1 && integer2 == -1 && integer3 == -1 && bArrA == null) {
            return null;
        }
        return new BX0(integer, integer2, integer3, bArrA);
    }

    private static boolean c(int i) {
        return i == 2 || i == 1 || i == -1;
    }

    private static boolean d(int i) {
        return i == 2 || i == 1 || i == 6 || i == -1;
    }

    private static boolean e(int i) {
        return i == 3 || i == 6 || i == 7 || i == -1;
    }

    public static void f(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void g(MediaFormat mediaFormat, BX0 bx0) {
        if (bx0 != null) {
            i(mediaFormat, "color-transfer", bx0.c);
            i(mediaFormat, "color-standard", bx0.a);
            i(mediaFormat, "color-range", bx0.b);
            f(mediaFormat, "hdr-static-info", bx0.d);
        }
    }

    public static void h(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void i(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void j(MediaFormat mediaFormat, List list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) list.get(i)));
        }
    }
}
