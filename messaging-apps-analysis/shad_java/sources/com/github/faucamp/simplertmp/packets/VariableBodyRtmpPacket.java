package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.amf.AmfData;
import com.github.faucamp.simplertmp.amf.AmfDecoder;
import com.github.faucamp.simplertmp.amf.AmfNull;
import com.github.faucamp.simplertmp.amf.AmfString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class VariableBodyRtmpPacket extends RtmpPacket {
    protected List<AmfData> data;

    public VariableBodyRtmpPacket(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public List<AmfData> getData() {
        return this.data;
    }

    public void addData(String str) {
        addData(new AmfString(str));
    }

    public void addData(AmfData amfData) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (amfData == null) {
            amfData = new AmfNull();
        }
        this.data.add(amfData);
    }

    protected void readVariableData(InputStream inputStream, int i) throws IOException {
        do {
            AmfData from = AmfDecoder.readFrom(inputStream);
            addData(from);
            i += from.getSize();
        } while (i < this.header.getPacketLength());
    }

    protected void writeVariableData(OutputStream outputStream) throws IOException {
        List<AmfData> list = this.data;
        if (list != null) {
            Iterator<AmfData> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeTo(outputStream);
            }
            return;
        }
        AmfNull.writeNullTo(outputStream);
    }
}
