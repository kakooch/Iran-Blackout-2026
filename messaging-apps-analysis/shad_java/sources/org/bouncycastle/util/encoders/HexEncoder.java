package org.bouncycastle.util.encoders;

import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class HexEncoder {
    protected final byte[] encodingTable = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    protected final byte[] decodingTable = new byte[128];

    public HexEncoder() {
        initialiseDecodingTable();
    }

    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[72];
        while (i2 > 0) {
            int iMin = Math.min(36, i2);
            outputStream.write(bArr2, 0, encode(bArr, i, iMin, bArr2, 0));
            i += iMin;
            i2 -= iMin;
        }
        return i2 * 2;
    }

    public int encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        int i4 = i2 + i;
        int i5 = i3;
        while (i < i4) {
            int i6 = i + 1;
            int i7 = bArr[i] & 255;
            int i8 = i5 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i5] = bArr3[i7 >>> 4];
            i5 = i8 + 1;
            bArr2[i8] = bArr3[i7 & 15];
            i = i6;
        }
        return i5 - i3;
    }

    protected void initialiseDecodingTable() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i >= bArr2.length) {
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.decodingTable[bArr2[i]] = (byte) i;
            i++;
        }
    }
}
