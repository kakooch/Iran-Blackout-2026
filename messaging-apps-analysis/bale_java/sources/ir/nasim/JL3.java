package ir.nasim;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* loaded from: classes5.dex */
public abstract class JL3 {
    public static final byte[] a(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "payload");
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArrC = AbstractC7873To0.c(gZIPInputStream);
                    YV0.a(gZIPInputStream, null);
                    YV0.a(byteArrayInputStream, null);
                    return bArrC;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            C19406qI3.c("MTPU", "Failed to decompress:", e);
            return bArr;
        }
    }
}
