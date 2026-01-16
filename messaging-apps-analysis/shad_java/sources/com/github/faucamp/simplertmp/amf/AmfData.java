package com.github.faucamp.simplertmp.amf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface AmfData {
    int getSize();

    void readFrom(InputStream inputStream) throws IOException;

    void writeTo(OutputStream outputStream) throws IOException;
}
