package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import com.github.faucamp.simplertmp.io.ChunkStreamInfo;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class UserControl extends RtmpPacket {
    private int[] eventData;
    private Type type;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public enum Type {
        STREAM_BEGIN(0),
        STREAM_EOF(1),
        STREAM_DRY(2),
        SET_BUFFER_LENGTH(3),
        STREAM_IS_RECORDED(4),
        PING_REQUEST(6),
        PONG_REPLY(7),
        BUFFER_EMPTY(31),
        BUFFER_READY(32);

        private static final Map<Integer, Type> quickLookupMap = new HashMap();
        private int intValue;

        static {
            for (Type type : values()) {
                quickLookupMap.put(Integer.valueOf(type.getIntValue()), type);
            }
        }

        Type(int i) {
            this.intValue = i;
        }

        public int getIntValue() {
            return this.intValue;
        }

        public static Type valueOf(int i) {
            return quickLookupMap.get(Integer.valueOf(i));
        }
    }

    public UserControl(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UserControl(ChunkStreamInfo chunkStreamInfo) {
        RtmpHeader.ChunkType chunkType;
        RtmpHeader.MessageType messageType = RtmpHeader.MessageType.USER_CONTROL_MESSAGE;
        if (chunkStreamInfo.canReusePrevHeaderTx(messageType)) {
            chunkType = RtmpHeader.ChunkType.TYPE_2_RELATIVE_TIMESTAMP_ONLY;
        } else {
            chunkType = RtmpHeader.ChunkType.TYPE_0_FULL;
        }
        super(new RtmpHeader(chunkType, 2, messageType));
    }

    public UserControl(UserControl userControl, ChunkStreamInfo chunkStreamInfo) {
        this(Type.PONG_REPLY, chunkStreamInfo);
        this.eventData = userControl.eventData;
    }

    public UserControl(Type type, ChunkStreamInfo chunkStreamInfo) {
        this(chunkStreamInfo);
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public void setEventData(int i) {
        if (this.type == Type.SET_BUFFER_LENGTH) {
            throw new IllegalStateException("SET_BUFFER_LENGTH requires two event data values; use setEventData(int, int) instead");
        }
        this.eventData = new int[]{i};
    }

    public void setEventData(int i, int i2) {
        if (this.type != Type.SET_BUFFER_LENGTH) {
            throw new IllegalStateException("User control type " + this.type + " requires only one event data value; use setEventData(int) instead");
        }
        this.eventData = new int[]{i, i2};
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        Type typeValueOf = Type.valueOf(Util.readUnsignedInt16(inputStream));
        this.type = typeValueOf;
        if (typeValueOf == Type.SET_BUFFER_LENGTH) {
            setEventData(Util.readUnsignedInt32(inputStream), Util.readUnsignedInt32(inputStream));
        } else {
            setEventData(Util.readUnsignedInt32(inputStream));
        }
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        Util.writeUnsignedInt16(outputStream, this.type.getIntValue());
        Util.writeUnsignedInt32(outputStream, this.eventData[0]);
        if (this.type == Type.SET_BUFFER_LENGTH) {
            Util.writeUnsignedInt32(outputStream, this.eventData[1]);
        }
    }

    public String toString() {
        return "RTMP User Control (type: " + this.type + ", event data: " + this.eventData + ")";
    }
}
