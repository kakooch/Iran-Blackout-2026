package com.github.faucamp.simplertmp.amf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class AmfBoolean implements AmfData {
    private boolean value;

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        return 2;
    }

    public AmfBoolean(boolean z) {
        this.value = z;
    }

    public AmfBoolean() {
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(AmfType.BOOLEAN.getValue());
        outputStream.write(this.value ? 1 : 0);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        this.value = inputStream.read() == 1;
    }
}
