package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import org.xbill.DNS.TTL;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.cn2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11308cn2 extends AbstractC10545bn2 {
    public static final ByteBuffer d(int i, CharsetEncoder charsetEncoder) {
        AbstractC13042fc3.i(charsetEncoder, "encoder");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i * ((int) Math.ceil(charsetEncoder.maxBytesPerChar())));
        AbstractC13042fc3.h(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }

    public static final CharsetEncoder e(Charset charset) {
        AbstractC13042fc3.i(charset, "<this>");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    public static byte[] f(File file) throws IOException {
        AbstractC13042fc3.i(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > TTL.MAX_VALUE) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArrG = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream.read(bArrG, i3, i2);
                if (i4 < 0) {
                    break;
                }
                i2 -= i4;
                i3 += i4;
            }
            if (i2 > 0) {
                bArrG = Arrays.copyOf(bArrG, i3);
                AbstractC13042fc3.h(bArrG, "copyOf(...)");
            } else {
                int i5 = fileInputStream.read();
                if (i5 != -1) {
                    C24450ye2 c24450ye2 = new C24450ye2(8193);
                    c24450ye2.write(i5);
                    AbstractC7873To0.b(fileInputStream, c24450ye2, 0, 2, null);
                    int size = c24450ye2.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = c24450ye2.a();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrG, size);
                    AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
                    bArrG = AbstractC9648aK.g(bArrA, bArrCopyOf, i, 0, c24450ye2.size());
                }
            }
            YV0.a(fileInputStream, null);
            return bArrG;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final String g(File file, Charset charset) throws IOException {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = AbstractC8839Xn7.e(inputStreamReader);
            YV0.a(inputStreamReader, null);
            return strE;
        } finally {
        }
    }

    public static /* synthetic */ String h(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = C12275eL0.b;
        }
        return g(file, charset);
    }

    public static final void i(File file, String str, Charset charset) throws IOException {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            k(fileOutputStream, str, charset);
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ void j(File file, String str, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = C12275eL0.b;
        }
        i(file, str, charset);
    }

    public static final void k(OutputStream outputStream, String str, Charset charset) throws IOException {
        AbstractC13042fc3.i(outputStream, "<this>");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(charset, "charset");
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderE = e(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        AbstractC13042fc3.f(charsetEncoderE);
        ByteBuffer byteBufferD = d(8192, charsetEncoderE);
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iMin = Math.min(8192 - i2, str.length() - i);
            int i3 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            AbstractC13042fc3.h(cArrArray, "array(...)");
            str.getChars(i, i3, cArrArray, i2);
            charBufferAllocate.limit(iMin + i2);
            i2 = 1;
            if (!charsetEncoderE.encode(charBufferAllocate, byteBufferD, i3 == str.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            outputStream.write(byteBufferD.array(), 0, byteBufferD.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i2 = 0;
            }
            charBufferAllocate.clear();
            byteBufferD.clear();
            i = i3;
        }
    }
}
