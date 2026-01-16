package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class ContentData extends RtmpPacket {
    protected byte[] data;
    protected int size;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void writeBody(OutputStream outputStream) {
    }

    public ContentData(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    public void setData(byte[] bArr, int i) {
        this.data = bArr;
        this.size = i;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[this.header.getPacketLength()];
        this.data = bArr;
        Util.readBytesUntilFull(inputStream, bArr);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public byte[] array() {
        return this.data;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public int size() {
        return this.size;
    }
}
