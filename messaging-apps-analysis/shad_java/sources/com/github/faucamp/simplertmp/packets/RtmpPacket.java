package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.io.ChunkStreamInfo;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class RtmpPacket {
    protected RtmpHeader header;

    protected abstract byte[] array();

    public abstract void readBody(InputStream inputStream) throws IOException;

    protected abstract int size();

    protected abstract void writeBody(OutputStream outputStream) throws IOException;

    public RtmpPacket(RtmpHeader rtmpHeader) {
        this.header = rtmpHeader;
    }

    public RtmpHeader getHeader() {
        return this.header;
    }

    public void writeTo(OutputStream outputStream, int i, ChunkStreamInfo chunkStreamInfo) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeBody(byteArrayOutputStream);
        boolean z = this instanceof ContentData;
        byte[] bArrArray = z ? array() : byteArrayOutputStream.toByteArray();
        int size = z ? size() : bArrArray.length;
        this.header.setPacketLength(size);
        this.header.writeTo(outputStream, RtmpHeader.ChunkType.TYPE_0_FULL, chunkStreamInfo);
        int i2 = 0;
        while (size > i) {
            outputStream.write(bArrArray, i2, i);
            size -= i;
            i2 += i;
            this.header.writeTo(outputStream, RtmpHeader.ChunkType.TYPE_3_RELATIVE_SINGLE_BYTE, chunkStreamInfo);
        }
        outputStream.write(bArrArray, i2, size);
    }
}
