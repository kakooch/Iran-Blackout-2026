package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Abort extends RtmpPacket {
    private int chunkStreamId;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public Abort(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public int getChunkStreamId() {
        return this.chunkStreamId;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        this.chunkStreamId = Util.readUnsignedInt32(inputStream);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        Util.writeUnsignedInt32(outputStream, this.chunkStreamId);
    }
}
