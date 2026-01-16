package com.github.faucamp.simplertmp;

import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class Util {
    public static byte[] unsignedInt32ToByteArray(int i) throws IOException {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static void writeUnsignedInt32(OutputStream outputStream, int i) throws IOException {
        outputStream.write((byte) (i >>> 24));
        outputStream.write((byte) (i >>> 16));
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) i);
    }

    public static int readUnsignedInt32(InputStream inputStream) throws IOException {
        return (inputStream.read() & 255) | ((inputStream.read() & 255) << 24) | ((inputStream.read() & 255) << 16) | ((inputStream.read() & 255) << 8);
    }

    public static int readUnsignedInt24(InputStream inputStream) throws IOException {
        return (inputStream.read() & 255) | ((inputStream.read() & 255) << 16) | ((inputStream.read() & 255) << 8);
    }

    public static int readUnsignedInt16(InputStream inputStream) throws IOException {
        return (inputStream.read() & 255) | ((inputStream.read() & 255) << 8);
    }

    public static void writeUnsignedInt24(OutputStream outputStream, int i) throws IOException {
        outputStream.write((byte) (i >>> 16));
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) i);
    }

    public static void writeUnsignedInt16(OutputStream outputStream, int i) throws IOException {
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) i);
    }

    public static int toUnsignedInt32LittleEndian(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
    }

    public static void writeUnsignedInt32LittleEndian(OutputStream outputStream, int i) throws IOException {
        outputStream.write((byte) i);
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) (i >>> 16));
        outputStream.write((byte) (i >>> 24));
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789ABCDEF".charAt((b & 240) >> 4));
            sb.append("0123456789ABCDEF".charAt(b & 15));
        }
        return sb.toString();
    }

    public static String toHexString(byte b) {
        StringBuilder sb = new StringBuilder();
        sb.append("0123456789ABCDEF".charAt((b & 240) >> 4));
        sb.append("0123456789ABCDEF".charAt(b & 15));
        return sb.toString();
    }

    public static void readBytesUntilFull(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        do {
            int i2 = inputStream.read(bArr, i, length - i);
            if (i2 == -1) {
                throw new IOException("Unexpected EOF reached before read buffer was filled");
            }
            i += i2;
        } while (i < length);
    }

    public static double readDouble(InputStream inputStream) throws IOException {
        return Double.longBitsToDouble(((inputStream.read() & 255) << 56) | ((inputStream.read() & 255) << 48) | ((inputStream.read() & 255) << 40) | ((inputStream.read() & 255) << 32) | ((inputStream.read() & 255) << 24) | ((inputStream.read() & 255) << 16) | ((inputStream.read() & 255) << 8) | (inputStream.read() & 255));
    }

    public static void writeDouble(OutputStream outputStream, double d) throws IOException {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        outputStream.write(new byte[]{(byte) ((jDoubleToRawLongBits >> 56) & 255), (byte) ((jDoubleToRawLongBits >> 48) & 255), (byte) ((jDoubleToRawLongBits >> 40) & 255), (byte) ((jDoubleToRawLongBits >> 32) & 255), (byte) ((jDoubleToRawLongBits >> 24) & 255), (byte) ((jDoubleToRawLongBits >> 16) & 255), (byte) ((jDoubleToRawLongBits >> 8) & 255), (byte) (jDoubleToRawLongBits & 255)});
    }

    public static String getSalt(String str) {
        for (String str2 : str.split("&")) {
            if (str2.contains("salt=")) {
                return str2.substring(5);
            }
        }
        return null;
    }

    public static String getChallenge(String str) {
        for (String str2 : str.split("&")) {
            if (str2.contains("challenge=")) {
                return str2.substring(10);
            }
        }
        return null;
    }

    public static String getOpaque(String str) {
        for (String str2 : str.split("&")) {
            if (str2.contains("opaque=")) {
                return str2.substring(7);
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static String stringToMD5BASE64(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(Utf8Charset.NAME), 0, str.length());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
