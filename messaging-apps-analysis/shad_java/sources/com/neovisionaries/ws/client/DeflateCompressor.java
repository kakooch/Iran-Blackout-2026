package com.neovisionaries.ws.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes3.dex */
class DeflateCompressor {
    public static byte[] compress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflaterCreateDeflater = createDeflater();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflaterCreateDeflater);
        deflaterOutputStream.write(bArr, 0, bArr.length);
        deflaterOutputStream.close();
        deflaterCreateDeflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static Deflater createDeflater() {
        return new Deflater(-1, true);
    }
}
