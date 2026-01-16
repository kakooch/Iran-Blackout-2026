package ir.eitaa.messenger.audioinfo.mp3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ID3v2DataInput {
    private final InputStream input;

    public ID3v2DataInput(InputStream in) {
        this.input = in;
    }

    public final void readFully(byte[] b, int off, int len) throws IOException {
        int i = 0;
        while (i < len) {
            int i2 = this.input.read(b, off + i, len - i);
            if (i2 <= 0) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    public byte[] readFully(int len) throws IOException {
        byte[] bArr = new byte[len];
        readFully(bArr, 0, len);
        return bArr;
    }

    public void skipFully(long len) throws IOException {
        long j = 0;
        while (j < len) {
            long jSkip = this.input.skip(len - j);
            if (jSkip <= 0) {
                throw new EOFException();
            }
            j += jSkip;
        }
    }

    public byte readByte() throws IOException {
        int i = this.input.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public int readInt() throws IOException {
        return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
    }

    public int readSyncsafeInt() throws IOException {
        return ((readByte() & 127) << 21) | ((readByte() & 127) << 14) | ((readByte() & 127) << 7) | (readByte() & 127);
    }
}
