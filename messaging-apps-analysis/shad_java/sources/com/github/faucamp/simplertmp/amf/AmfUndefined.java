package com.github.faucamp.simplertmp.amf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class AmfUndefined implements AmfData {
    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        return 1;
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) {
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(AmfType.UNDEFINED.getValue());
    }
}
