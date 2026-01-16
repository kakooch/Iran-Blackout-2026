package ir.nasim;

import java.io.Closeable;

/* renamed from: ir.nasim.Je3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5401Je3 extends AbstractC20202rd0 implements Closeable {
    private static MI3 h = MI3.a(AbstractC5401Je3.class);

    public static byte[] l(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }
}
