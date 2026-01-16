package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.amf.AmfNumber;
import com.github.faucamp.simplertmp.amf.AmfString;
import com.github.faucamp.simplertmp.io.ChunkStreamInfo;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Command extends VariableBodyRtmpPacket {
    private String commandName;
    private int transactionId;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public Command(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Command(String str, int i, ChunkStreamInfo chunkStreamInfo) {
        RtmpHeader.MessageType messageType = RtmpHeader.MessageType.COMMAND_AMF0;
        super(new RtmpHeader(chunkStreamInfo.canReusePrevHeaderTx(messageType) ? RtmpHeader.ChunkType.TYPE_1_RELATIVE_LARGE : RtmpHeader.ChunkType.TYPE_0_FULL, 3, messageType));
        this.commandName = str;
        this.transactionId = i;
    }

    public Command(String str, int i) {
        super(new RtmpHeader(RtmpHeader.ChunkType.TYPE_0_FULL, 3, RtmpHeader.MessageType.COMMAND_AMF0));
        this.commandName = str;
        this.transactionId = i;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        this.commandName = AmfString.readStringFrom(inputStream, false);
        this.transactionId = (int) AmfNumber.readNumberFrom(inputStream);
        readVariableData(inputStream, AmfString.sizeOf(this.commandName, false) + 9);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        AmfString.writeStringTo(outputStream, this.commandName, false);
        AmfNumber.writeNumberTo(outputStream, this.transactionId);
        writeVariableData(outputStream);
    }

    public String toString() {
        return "RTMP Command (command: " + this.commandName + ", transaction ID: " + this.transactionId + ")";
    }
}
