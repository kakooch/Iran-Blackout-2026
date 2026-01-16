package ir.eitaa.messenger.audioinfo.mp3;

import ir.eitaa.messenger.audioinfo.AudioInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ID3v1Info extends AudioInfo {
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isID3v1StartPosition(java.io.InputStream r2) throws java.io.IOException {
        /*
            r0 = 3
            r2.mark(r0)
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 84
            if (r0 != r1) goto L1e
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 65
            if (r0 != r1) goto L1e
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L23
            r1 = 71
            if (r0 != r1) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.reset()
            return r0
        L23:
            r0 = move-exception
            r2.reset()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.audioinfo.mp3.ID3v1Info.isID3v1StartPosition(java.io.InputStream):boolean");
    }

    public ID3v1Info(InputStream input) throws IOException {
        if (isID3v1StartPosition(input)) {
            this.brand = "ID3";
            this.version = "1.0";
            byte[] bytes = readBytes(input, 128);
            this.title = extractString(bytes, 3, 30);
            this.artist = extractString(bytes, 33, 30);
            this.album = extractString(bytes, 63, 30);
            try {
                this.year = Short.parseShort(extractString(bytes, 93, 4));
            } catch (NumberFormatException unused) {
                this.year = (short) 0;
            }
            this.comment = extractString(bytes, 97, 30);
            ID3v1Genre genre = ID3v1Genre.getGenre(bytes[127]);
            if (genre != null) {
                this.genre = genre.getDescription();
            }
            if (bytes[125] != 0 || bytes[126] == 0) {
                return;
            }
            this.version = "1.1";
            this.track = (short) (bytes[126] & 255);
        }
    }

    byte[] readBytes(InputStream input, int len) throws IOException {
        byte[] bArr = new byte[len];
        int i = 0;
        while (i < len) {
            int i2 = input.read(bArr, i, len - i);
            if (i2 <= 0) {
                throw new EOFException();
            }
            i += i2;
        }
        return bArr;
    }

    String extractString(byte[] bytes, int offset, int length) {
        try {
            String str = new String(bytes, offset, length, "ISO-8859-1");
            int iIndexOf = str.indexOf(0);
            return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
        } catch (Exception unused) {
            return "";
        }
    }
}
