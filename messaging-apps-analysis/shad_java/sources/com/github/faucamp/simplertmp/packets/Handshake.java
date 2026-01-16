package com.github.faucamp.simplertmp.packets;

import android.util.Log;
import com.facebook.stetho.dumpapp.Framer;
import com.github.faucamp.simplertmp.Crypto;
import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.util.Random;

/* loaded from: classes.dex */
public final class Handshake {
    private static final byte[] GENUINE_FP_KEY = {71, 101, 110, 117, 105, 110, 101, 32, 65, 100, 111, 98, 101, 32, 70, 108, 97, 115, 104, 32, 80, 108, 97, 121, 101, 114, 32, 48, 48, Framer.STDOUT_FRAME_PREFIX, -16, -18, -62, 74, -128, 104, -66, -24, 46, 0, -48, -47, 2, -98, 126, 87, 110, -20, 93, Framer.STDIN_FRAME_PREFIX, 41, -128, 111, -85, -109, -72, -26, 54, -49, -21, Framer.STDOUT_FRAME_PREFIX, -82};
    private byte[] s1;

    public final void writeC0(OutputStream outputStream) throws IOException {
        Log.d("Handshake", "writeC0");
        outputStream.write(3);
    }

    public final void readS0(InputStream inputStream) throws IOException {
        Log.d("Handshake", "readS0");
        byte b = (byte) inputStream.read();
        if (b == 3 || b == 72) {
            return;
        }
        if (b == -1) {
            throw new IOException("InputStream closed");
        }
        throw new IOException("Invalid RTMP protocol version; expected 3, got " + ((int) b));
    }

    public final void writeC1(OutputStream outputStream) throws InvalidKeyException, IOException {
        Log.d("Handshake", "writeC1");
        Log.d("Handshake", "writeC1(): Calculating digest offset");
        Random random = new Random();
        int iNextInt = random.nextInt(720);
        int i = (iNextInt % 728) + 772 + 4;
        Log.d("Handshake", "writeC1(): (real value of) digestOffset: " + iNextInt);
        Log.d("Handshake", "writeC1(): recalculated digestOffset: " + i);
        byte[] bArr = new byte[4];
        for (int i2 = 3; i2 >= 0; i2--) {
            if (iNextInt > 255) {
                bArr[i2] = -1;
                iNextInt -= 255;
            } else {
                bArr[i2] = (byte) iNextInt;
                iNextInt -= iNextInt;
            }
        }
        Log.d("Handshake", "writeC1(): digestOffsetBytes: " + Util.toHexString(bArr));
        byte[] bArr2 = new byte[i];
        Log.d("Handshake", "partBeforeDigest(): size: " + i);
        random.nextBytes(bArr2);
        Log.d("Handshake", "writeC1(): Writing timestamp and Flash Player version");
        System.arraycopy(Util.unsignedInt32ToByteArray((int) (System.currentTimeMillis() / 1000)), 0, bArr2, 0, 4);
        System.arraycopy(new byte[]{-128, 0, 7, 2}, 0, bArr2, 4, 4);
        int i3 = (1536 - i) - 32;
        byte[] bArr3 = new byte[i3];
        Log.d("Handshake", "partAfterDigest(): size: " + i3);
        random.nextBytes(bArr3);
        Log.d("Handshake", "copying digest offset bytes in partBeforeDigest");
        System.arraycopy(bArr, 0, bArr2, 772, 4);
        Log.d("Handshake", "writeC1(): Calculating digest");
        byte[] bArr4 = new byte[1504];
        System.arraycopy(bArr2, 0, bArr4, 0, i);
        System.arraycopy(bArr3, 0, bArr4, i, i3);
        byte[] bArrCalculateHmacSHA256 = new Crypto().calculateHmacSHA256(bArr4, GENUINE_FP_KEY, 30);
        Log.d("Handshake", "writeC1(): writing C1 packet");
        outputStream.write(bArr2);
        outputStream.write(bArrCalculateHmacSHA256);
        outputStream.write(bArr3);
    }

    public final void readS1(InputStream inputStream) throws IOException {
        Log.d("Handshake", "readS1");
        this.s1 = new byte[1536];
        int i = 0;
        do {
            int i2 = inputStream.read(this.s1, i, 1536 - i);
            if (i2 != -1) {
                i += i2;
            }
        } while (i < 1536);
        if (i != 1536) {
            throw new IOException("Unexpected EOF while reading S1, expected 1536 bytes, but only read " + i + " bytes");
        }
        Log.d("Handshake", "readS1(): S1 total bytes read OK");
    }

    public final void writeC2(OutputStream outputStream) throws IOException {
        Log.d("Handshake", "writeC2");
        byte[] bArr = this.s1;
        if (bArr == null) {
            throw new IllegalStateException("C2 cannot be written without S1 being read first");
        }
        outputStream.write(bArr);
    }

    public final void readS2(InputStream inputStream) throws IOException {
        int i;
        Log.d("Handshake", "readS2");
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[1528];
        int i2 = 0;
        int i3 = 0;
        do {
            int i4 = inputStream.read(bArr, i3, 4 - i3);
            if (i4 == -1) {
                throw new IOException("Unexpected EOF while reading S2 bytes 0-3");
            }
            i3 += i4;
        } while (i3 < 4);
        int i5 = 0;
        do {
            int i6 = inputStream.read(bArr2, i5, 4 - i5);
            if (i6 == -1) {
                throw new IOException("Unexpected EOF while reading S2 bytes 4-7");
            }
            i5 += i6;
        } while (i5 < 4);
        do {
            i = inputStream.read(bArr3, i2, 1528 - i2);
            if (i != -1) {
                i2 += i;
            }
            if (i2 >= 1528) {
                break;
            }
        } while (i != -1);
        if (i2 != 1528) {
            throw new IOException("Unexpected EOF while reading remainder of S2, expected 1528 bytes, but only read " + i2 + " bytes");
        }
        Log.d("Handshake", "readS2(): S2 total bytes read OK");
    }
}
