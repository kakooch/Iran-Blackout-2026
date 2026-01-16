package com.neovisionaries.ws.client;

import com.facebook.stetho.common.Utf8Charset;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
class WebSocketInputStream extends FilterInputStream {
    public WebSocketInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public String readLine() throws IOException {
        return Misc.readLine(this, Utf8Charset.NAME);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.neovisionaries.ws.client.WebSocketFrame readFrame() throws com.neovisionaries.ws.client.WebSocketException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.WebSocketInputStream.readFrame():com.neovisionaries.ws.client.WebSocketFrame");
    }

    void readBytes(byte[] bArr, int i) throws WebSocketException, IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = read(bArr, i2, i - i2);
            if (i3 <= 0) {
                throw new InsufficientDataException(i, i2);
            }
            i2 += i3;
        }
    }

    private void skipQuietly(long j) throws IOException {
        try {
            skip(j);
        } catch (IOException unused) {
        }
    }

    private byte[] readPayload(long j, boolean z, byte[] bArr) throws WebSocketException, IOException {
        if (j == 0) {
            return null;
        }
        int i = (int) j;
        try {
            byte[] bArr2 = new byte[i];
            readBytes(bArr2, i);
            if (z) {
                WebSocketFrame.mask(bArr, bArr2);
            }
            return bArr2;
        } catch (OutOfMemoryError e) {
            skipQuietly(j);
            throw new WebSocketException(WebSocketError.INSUFFICIENT_MEMORY_FOR_PAYLOAD, "OutOfMemoryError occurred during a trial to allocate a memory area for a frame's payload: " + e.getMessage(), e);
        }
    }
}
