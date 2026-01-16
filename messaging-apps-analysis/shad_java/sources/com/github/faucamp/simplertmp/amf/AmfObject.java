package com.github.faucamp.simplertmp.amf;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AmfObject implements AmfData {
    protected static final byte[] OBJECT_END_MARKER = {0, 0, 9};
    Map<String, AmfData> properties = new LinkedHashMap();
    protected int size = -1;

    public AmfData getProperty(String str) {
        return this.properties.get(str);
    }

    public void setProperty(String str, boolean z) {
        this.properties.put(str, new AmfBoolean(z));
    }

    public void setProperty(String str, String str2) {
        this.properties.put(str, new AmfString(str2, false));
    }

    public void setProperty(String str, int i) {
        this.properties.put(str, new AmfNumber(i));
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(AmfType.OBJECT.getValue());
        for (Map.Entry<String, AmfData> entry : this.properties.entrySet()) {
            AmfString.writeStringTo(outputStream, entry.getKey(), true);
            entry.getValue().writeTo(outputStream);
        }
        outputStream.write(OBJECT_END_MARKER);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        this.size = 1;
        InputStream bufferedInputStream = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
        while (true) {
            bufferedInputStream.mark(3);
            byte[] bArr = new byte[3];
            bufferedInputStream.read(bArr);
            byte b = bArr[0];
            byte[] bArr2 = OBJECT_END_MARKER;
            if (b == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2]) {
                this.size += 3;
                return;
            }
            bufferedInputStream.reset();
            String stringFrom = AmfString.readStringFrom(inputStream, true);
            this.size += AmfString.sizeOf(stringFrom, true);
            AmfData from = AmfDecoder.readFrom(bufferedInputStream);
            this.size += from.getSize();
            this.properties.put(stringFrom, from);
        }
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        if (this.size == -1) {
            this.size = 1;
            for (Map.Entry<String, AmfData> entry : this.properties.entrySet()) {
                int iSizeOf = this.size + AmfString.sizeOf(entry.getKey(), true);
                this.size = iSizeOf;
                this.size = iSizeOf + entry.getValue().getSize();
            }
            this.size += 3;
        }
        return this.size;
    }
}
