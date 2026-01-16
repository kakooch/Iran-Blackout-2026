package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.f;
import ir.nasim.InterfaceC5592Jz5;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class IncorrectJpegMetadataQuirk implements InterfaceC5592Jz5 {
    private static final Set a = new HashSet(Arrays.asList("A24"));

    private boolean c(byte[] bArr) {
        byte b;
        int i = 2;
        while (i + 4 <= bArr.length && (b = bArr[i]) == -1) {
            if (b == -1 && bArr[i + 1] == -38) {
                return true;
            }
            i += (((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255)) + 2;
        }
        return false;
    }

    private int d(byte[] bArr) {
        int i = 2;
        while (true) {
            int i2 = i + 1;
            if (i2 > bArr.length) {
                return -1;
            }
            if (bArr[i] == -1 && bArr[i2] == -40) {
                return i;
            }
            i = i2;
        }
    }

    private static boolean e() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && a.contains(Build.DEVICE.toUpperCase(Locale.US));
    }

    static boolean g() {
        return e();
    }

    public byte[] f(f fVar) {
        int iD = 0;
        ByteBuffer buffer = fVar.P0()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return (c(bArr) || (iD = d(bArr)) != -1) ? Arrays.copyOfRange(bArr, iD, buffer.limit()) : bArr;
    }
}
