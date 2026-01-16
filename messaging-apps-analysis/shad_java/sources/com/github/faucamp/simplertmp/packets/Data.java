package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.amf.AmfString;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Data extends VariableBodyRtmpPacket {
    private String type;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public Data(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public Data(String str) {
        super(new RtmpHeader(RtmpHeader.ChunkType.TYPE_0_FULL, 3, RtmpHeader.MessageType.DATA_AMF0));
        this.type = str;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        String stringFrom = AmfString.readStringFrom(inputStream, false);
        this.type = stringFrom;
        readVariableData(inputStream, AmfString.sizeOf(stringFrom, false));
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        AmfString.writeStringTo(outputStream, this.type, false);
        writeVariableData(outputStream);
    }
}
