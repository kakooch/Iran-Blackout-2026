package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import com.github.faucamp.simplertmp.io.ChunkStreamInfo;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class WindowAckSize extends RtmpPacket {
    private int acknowledgementWindowSize;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public String toString() {
        return "RTMP Window Acknowledgment Size";
    }

    public WindowAckSize(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WindowAckSize(int i, ChunkStreamInfo chunkStreamInfo) {
        RtmpHeader.ChunkType chunkType;
        RtmpHeader.MessageType messageType = RtmpHeader.MessageType.WINDOW_ACKNOWLEDGEMENT_SIZE;
        if (chunkStreamInfo.canReusePrevHeaderTx(messageType)) {
            chunkType = RtmpHeader.ChunkType.TYPE_2_RELATIVE_TIMESTAMP_ONLY;
        } else {
            chunkType = RtmpHeader.ChunkType.TYPE_0_FULL;
        }
        super(new RtmpHeader(chunkType, 2, messageType));
        this.acknowledgementWindowSize = i;
    }

    public int getAcknowledgementWindowSize() {
        return this.acknowledgementWindowSize;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        this.acknowledgementWindowSize = Util.readUnsignedInt32(inputStream);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        Util.writeUnsignedInt32(outputStream, this.acknowledgementWindowSize);
    }
}
