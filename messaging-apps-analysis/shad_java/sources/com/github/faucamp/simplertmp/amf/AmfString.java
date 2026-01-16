package com.github.faucamp.simplertmp.amf;

import android.util.Log;
import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class AmfString implements AmfData {
    private boolean key;
    private int size;
    private String value;

    public AmfString() {
        this.size = -1;
    }

    public AmfString(String str, boolean z) {
        this.size = -1;
        this.value = str;
        this.key = z;
    }

    public AmfString(String str) {
        this(str, false);
    }

    public String getValue() {
        return this.value;
    }

    public boolean isKey() {
        return this.key;
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bytes = this.value.getBytes("ASCII");
        if (!this.key) {
            outputStream.write(AmfType.STRING.getValue());
        }
        Util.writeUnsignedInt16(outputStream, bytes.length);
        outputStream.write(bytes);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        int unsignedInt16 = Util.readUnsignedInt16(inputStream);
        this.size = unsignedInt16 + 3;
        byte[] bArr = new byte[unsignedInt16];
        Util.readBytesUntilFull(inputStream, bArr);
        this.value = new String(bArr, "ASCII");
    }

    public static String readStringFrom(InputStream inputStream, boolean z) throws IOException {
        if (!z) {
            inputStream.read();
        }
        byte[] bArr = new byte[Util.readUnsignedInt16(inputStream)];
        Util.readBytesUntilFull(inputStream, bArr);
        return new String(bArr, "ASCII");
    }

    public static void writeStringTo(OutputStream outputStream, String str, boolean z) throws IOException {
        byte[] bytes = str.getBytes("ASCII");
        if (!z) {
            outputStream.write(AmfType.STRING.getValue());
        }
        Util.writeUnsignedInt16(outputStream, bytes.length);
        outputStream.write(bytes);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        if (this.size == -1) {
            try {
                this.size = (isKey() ? 0 : 1) + 2 + this.value.getBytes("ASCII").length;
            } catch (UnsupportedEncodingException e) {
                Log.e("AmfString", "AmfString.getSize(): caught exception", e);
                throw new RuntimeException(e);
            }
        }
        return this.size;
    }

    public static int sizeOf(String str, boolean z) {
        try {
            return (z ? 0 : 1) + 2 + str.getBytes("ASCII").length;
        } catch (UnsupportedEncodingException e) {
            Log.e("AmfString", "AmfString.SizeOf(): caught exception", e);
            throw new RuntimeException(e);
        }
    }
}
