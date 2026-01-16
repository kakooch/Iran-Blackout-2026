package ir.eitaa.messenger.audioinfo.mp3;

import ir.eitaa.messenger.audioinfo.util.PositionInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MP3Input extends PositionInputStream {
    public MP3Input(InputStream delegate) throws IOException {
        super(delegate);
    }

    public final void readFully(byte[] b, int off, int len) throws IOException {
        int i = 0;
        while (i < len) {
            int i2 = read(b, off + i, len - i);
            if (i2 <= 0) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    public void skipFully(long len) throws IOException {
        long j = 0;
        while (j < len) {
            long jSkip = skip(len - j);
            if (jSkip <= 0) {
                throw new EOFException();
            }
            j += jSkip;
        }
    }

    public String toString() {
        return "mp3[pos=" + getPosition() + "]";
    }
}
