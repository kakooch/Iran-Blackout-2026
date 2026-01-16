package ir.nasim;

import java.io.IOException;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.mN7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17091mN7 {
    public static int a(long j) throws IOException {
        if (j < -2147483648L) {
            throw new IOException("Too small value");
        }
        if (j <= TTL.MAX_VALUE) {
            return (int) j;
        }
        throw new IOException("Too big value");
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, "utf-8");
    }
}
