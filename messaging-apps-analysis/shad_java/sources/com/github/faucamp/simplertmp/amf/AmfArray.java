package com.github.faucamp.simplertmp.amf;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AmfArray implements AmfData {
    private List<AmfData> items;
    private int size = -1;

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void writeTo(OutputStream outputStream) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public void readFrom(InputStream inputStream) throws IOException {
        int unsignedInt32 = Util.readUnsignedInt32(inputStream);
        this.size = 5;
        this.items = new ArrayList(unsignedInt32);
        for (int i = 0; i < unsignedInt32; i++) {
            AmfData from = AmfDecoder.readFrom(inputStream);
            this.size += from.getSize();
            this.items.add(from);
        }
    }

    @Override // com.github.faucamp.simplertmp.amf.AmfData
    public int getSize() {
        if (this.size == -1) {
            this.size = 5;
            List<AmfData> list = this.items;
            if (list != null) {
                Iterator<AmfData> it = list.iterator();
                while (it.hasNext()) {
                    this.size += it.next().getSize();
                }
            }
        }
        return this.size;
    }
}
