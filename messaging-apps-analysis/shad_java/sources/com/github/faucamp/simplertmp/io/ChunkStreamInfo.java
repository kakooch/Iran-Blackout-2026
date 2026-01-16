package com.github.faucamp.simplertmp.io;

import com.github.faucamp.simplertmp.Util;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes.dex */
public class ChunkStreamInfo {
    private static long sessionBeginTimestamp;
    private RtmpHeader prevHeaderRx;
    private RtmpHeader prevHeaderTx;
    private long realLastTimestamp = System.nanoTime() / 1000000;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream(MessagesController.UPDATE_MASK_REORDER);

    public RtmpHeader prevHeaderRx() {
        return this.prevHeaderRx;
    }

    public void setPrevHeaderRx(RtmpHeader rtmpHeader) {
        this.prevHeaderRx = rtmpHeader;
    }

    public RtmpHeader getPrevHeaderTx() {
        return this.prevHeaderTx;
    }

    public boolean canReusePrevHeaderTx(RtmpHeader.MessageType messageType) {
        RtmpHeader rtmpHeader = this.prevHeaderTx;
        return rtmpHeader != null && rtmpHeader.getMessageType() == messageType;
    }

    public void setPrevHeaderTx(RtmpHeader rtmpHeader) {
        this.prevHeaderTx = rtmpHeader;
    }

    public static void markSessionTimestampTx() {
        sessionBeginTimestamp = System.nanoTime() / 1000000;
    }

    public long markAbsoluteTimestampTx() {
        return (System.nanoTime() / 1000000) - sessionBeginTimestamp;
    }

    public long markDeltaTimestampTx() {
        long jNanoTime = System.nanoTime() / 1000000;
        long j = jNanoTime - this.realLastTimestamp;
        this.realLastTimestamp = jNanoTime;
        return j;
    }

    public boolean storePacketChunk(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[Math.min(this.prevHeaderRx.getPacketLength() - this.baos.size(), i)];
        Util.readBytesUntilFull(inputStream, bArr);
        this.baos.write(bArr);
        return this.baos.size() == this.prevHeaderRx.getPacketLength();
    }

    public ByteArrayInputStream getStoredPacketInputStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.baos.toByteArray());
        this.baos.reset();
        return byteArrayInputStream;
    }

    public void clearStoredChunks() {
        this.baos.reset();
    }
}
