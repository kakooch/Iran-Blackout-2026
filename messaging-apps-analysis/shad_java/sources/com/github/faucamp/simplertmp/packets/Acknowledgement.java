package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Acknowledgement extends RtmpPacket {
    private int sequenceNumber;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public Acknowledgement(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        this.sequenceNumber = Util.readUnsignedInt32(inputStream);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        Util.writeUnsignedInt32(outputStream, this.sequenceNumber);
    }

    public String toString() {
        return "RTMP Acknowledgment (sequence number: " + this.sequenceNumber + ")";
    }
}
