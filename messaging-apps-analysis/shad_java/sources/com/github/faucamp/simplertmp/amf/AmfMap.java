package com.github.faucamp.simplertmp.amf;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: classes.dex */
public class AmfMap extends AmfObject {
    @Override // com.github.faucamp.simplertmp.amf.AmfObject, com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(AmfType.ECMA_MAP.getValue());
        Util.writeUnsignedInt32(outputStream, this.properties.size());
        for (Map.Entry<String, AmfData> entry : this.properties.entrySet()) {
            AmfString.writeStringTo(outputStream, entry.getKey(), true);
            entry.getValue().writeTo(outputStream);
        }
        outputStream.write(AmfObject.OBJECT_END_MARKER);
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfObject, com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        Util.readUnsignedInt32(inputStream);
        super.readFrom(inputStream);
        this.size += 4;
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfObject, com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        if (this.size == -1) {
            int size = super.getSize();
            this.size = size;
            this.size = size + 4;
        }
        return this.size;
    }
}
