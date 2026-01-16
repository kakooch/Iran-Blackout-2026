package ir.nasim;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class DZ2 extends QN {
    public DZ2(InputStream inputStream) throws IOException {
        byte b;
        if (w(inputStream)) {
            this.a = "ID3";
            this.b = "1.0";
            byte[] bArrX = x(inputStream, 128);
            this.d = v(bArrX, 3, 30);
            this.e = v(bArrX, 33, 30);
            this.g = v(bArrX, 63, 30);
            try {
                this.h = Short.parseShort(v(bArrX, 93, 4));
            } catch (NumberFormatException unused) {
                this.h = (short) 0;
            }
            this.j = v(bArrX, 97, 30);
            CZ2 cz2P = CZ2.p(bArrX[127]);
            if (cz2P != null) {
                this.i = cz2P.j();
            }
            if (bArrX[125] != 0 || (b = bArrX[126]) == 0) {
                return;
            }
            this.b = "1.1";
            this.k = (short) (b & 255);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean w(java.io.InputStream r2) throws java.io.IOException {
        /*
            r0 = 3
            r2.mark(r0)
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 84
            if (r0 != r1) goto L20
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 65
            if (r0 != r1) goto L20
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 71
            if (r0 != r1) goto L20
            r0 = 1
            goto L21
        L1e:
            r0 = move-exception
            goto L25
        L20:
            r0 = 0
        L21:
            r2.reset()
            return r0
        L25:
            r2.reset()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DZ2.w(java.io.InputStream):boolean");
    }

    String v(byte[] bArr, int i, int i2) {
        try {
            String str = new String(bArr, i, i2, "ISO-8859-1");
            int iIndexOf = str.indexOf(0);
            return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
        } catch (Exception unused) {
            return "";
        }
    }

    byte[] x(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 <= 0) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return bArr;
    }
}
