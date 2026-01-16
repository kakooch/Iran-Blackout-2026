package com.github.faucamp.simplertmp.amf;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class AmfNumber implements AmfData {
    private double value;

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        return 9;
    }

    public AmfNumber(double d) {
        this.value = d;
    }

    public AmfNumber() {
    }

    public double getValue() {
        return this.value;
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(AmfType.NUMBER.getValue());
        Util.writeDouble(outputStream, this.value);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        this.value = Util.readDouble(inputStream);
    }

    public static double readNumberFrom(InputStream inputStream) throws IOException {
        inputStream.read();
        return Util.readDouble(inputStream);
    }

    public static void writeNumberTo(OutputStream outputStream, double d) throws IOException {
        outputStream.write(AmfType.NUMBER.getValue());
        Util.writeDouble(outputStream, d);
    }
}
