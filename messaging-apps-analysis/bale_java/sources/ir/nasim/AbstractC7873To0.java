package ir.nasim;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: ir.nasim.To0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7873To0 {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        AbstractC13042fc3.i(inputStream, "<this>");
        AbstractC13042fc3.i(outputStream, "out");
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(inputStream, outputStream, i);
    }

    public static final byte[] c(InputStream inputStream) {
        AbstractC13042fc3.i(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AbstractC13042fc3.h(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
