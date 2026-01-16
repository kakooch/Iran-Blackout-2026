package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import com.github.faucamp.simplertmp.io.ChunkStreamInfo;
import com.github.faucamp.simplertmp.io.RtmpSessionInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RtmpHeader {
    private int absoluteTimestamp;
    private int chunkStreamId;
    private ChunkType chunkType;
    private int extendedTimestamp;
    private int messageStreamId;
    private MessageType messageType;
    private int packetLength;
    private int timestampDelta = -1;

    public enum MessageType {
        SET_CHUNK_SIZE(1),
        ABORT(2),
        ACKNOWLEDGEMENT(3),
        USER_CONTROL_MESSAGE(4),
        WINDOW_ACKNOWLEDGEMENT_SIZE(5),
        SET_PEER_BANDWIDTH(6),
        AUDIO(8),
        VIDEO(9),
        DATA_AMF3(15),
        SHARED_OBJECT_AMF3(16),
        COMMAND_AMF3(17),
        DATA_AMF0(18),
        COMMAND_AMF0(20),
        SHARED_OBJECT_AMF0(19),
        AGGREGATE_MESSAGE(22);

        private static final Map<Byte, MessageType> quickLookupMap = new HashMap();
        private byte value;

        static {
            for (MessageType messageType : values()) {
                quickLookupMap.put(Byte.valueOf(messageType.getValue()), messageType);
            }
        }

        MessageType(int i) {
            this.value = (byte) i;
        }

        public byte getValue() {
            return this.value;
        }

        public static MessageType valueOf(byte b) {
            Map<Byte, MessageType> map = quickLookupMap;
            if (map.containsKey(Byte.valueOf(b))) {
                return map.get(Byte.valueOf(b));
            }
            throw new IllegalArgumentException("Unknown message type byte: " + Util.toHexString(b));
        }
    }

    public enum ChunkType {
        TYPE_0_FULL(0),
        TYPE_1_RELATIVE_LARGE(1),
        TYPE_2_RELATIVE_TIMESTAMP_ONLY(2),
        TYPE_3_RELATIVE_SINGLE_BYTE(3);

        private static final Map<Byte, ChunkType> quickLookupMap = new HashMap();
        private byte value;

        static {
            for (ChunkType chunkType : values()) {
                quickLookupMap.put(Byte.valueOf(chunkType.getValue()), chunkType);
            }
        }

        ChunkType(int i) {
            this.value = (byte) i;
        }

        public byte getValue() {
            return this.value;
        }

        public static ChunkType valueOf(byte b) {
            Map<Byte, ChunkType> map = quickLookupMap;
            if (map.containsKey(Byte.valueOf(b))) {
                return map.get(Byte.valueOf(b));
            }
            throw new IllegalArgumentException("Unknown chunk header type byte: " + Util.toHexString(b));
        }
    }

    public RtmpHeader() {
    }

    public RtmpHeader(ChunkType chunkType, int i, MessageType messageType) {
        this.chunkType = chunkType;
        this.chunkStreamId = i;
        this.messageType = messageType;
    }

    public static RtmpHeader readHeader(InputStream inputStream, RtmpSessionInfo rtmpSessionInfo) throws IOException {
        RtmpHeader rtmpHeader = new RtmpHeader();
        rtmpHeader.readHeaderImpl(inputStream, rtmpSessionInfo);
        return rtmpHeader;
    }

    private void readHeaderImpl(InputStream inputStream, RtmpSessionInfo rtmpSessionInfo) throws IOException {
        int unsignedInt32;
        int i = inputStream.read();
        if (i == -1) {
            throw new EOFException("Unexpected EOF while reading RTMP packet basic header");
        }
        byte b = (byte) i;
        parseBasicHeader(b);
        int i2 = AnonymousClass1.$SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType[this.chunkType.ordinal()];
        if (i2 == 1) {
            this.absoluteTimestamp = Util.readUnsignedInt24(inputStream);
            this.timestampDelta = 0;
            this.packetLength = Util.readUnsignedInt24(inputStream);
            this.messageType = MessageType.valueOf((byte) inputStream.read());
            byte[] bArr = new byte[4];
            Util.readBytesUntilFull(inputStream, bArr);
            this.messageStreamId = Util.toUnsignedInt32LittleEndian(bArr);
            unsignedInt32 = this.absoluteTimestamp >= 16777215 ? Util.readUnsignedInt32(inputStream) : 0;
            this.extendedTimestamp = unsignedInt32;
            if (unsignedInt32 != 0) {
                this.absoluteTimestamp = unsignedInt32;
                return;
            }
            return;
        }
        if (i2 == 2) {
            this.timestampDelta = Util.readUnsignedInt24(inputStream);
            this.packetLength = Util.readUnsignedInt24(inputStream);
            this.messageType = MessageType.valueOf((byte) inputStream.read());
            this.extendedTimestamp = this.timestampDelta >= 16777215 ? Util.readUnsignedInt32(inputStream) : 0;
            RtmpHeader rtmpHeaderPrevHeaderRx = rtmpSessionInfo.getChunkStreamInfo(this.chunkStreamId).prevHeaderRx();
            if (rtmpHeaderPrevHeaderRx != null) {
                this.messageStreamId = rtmpHeaderPrevHeaderRx.messageStreamId;
                int i3 = this.extendedTimestamp;
                if (i3 == 0) {
                    i3 = this.timestampDelta + rtmpHeaderPrevHeaderRx.absoluteTimestamp;
                }
                this.absoluteTimestamp = i3;
                return;
            }
            this.messageStreamId = 0;
            int i4 = this.extendedTimestamp;
            if (i4 == 0) {
                i4 = this.timestampDelta;
            }
            this.absoluteTimestamp = i4;
            return;
        }
        if (i2 == 3) {
            int unsignedInt24 = Util.readUnsignedInt24(inputStream);
            this.timestampDelta = unsignedInt24;
            this.extendedTimestamp = unsignedInt24 >= 16777215 ? Util.readUnsignedInt32(inputStream) : 0;
            RtmpHeader rtmpHeaderPrevHeaderRx2 = rtmpSessionInfo.getChunkStreamInfo(this.chunkStreamId).prevHeaderRx();
            this.packetLength = rtmpHeaderPrevHeaderRx2.packetLength;
            this.messageType = rtmpHeaderPrevHeaderRx2.messageType;
            this.messageStreamId = rtmpHeaderPrevHeaderRx2.messageStreamId;
            int i5 = this.extendedTimestamp;
            if (i5 == 0) {
                i5 = this.timestampDelta + rtmpHeaderPrevHeaderRx2.absoluteTimestamp;
            }
            this.absoluteTimestamp = i5;
            return;
        }
        if (i2 == 4) {
            RtmpHeader rtmpHeaderPrevHeaderRx3 = rtmpSessionInfo.getChunkStreamInfo(this.chunkStreamId).prevHeaderRx();
            unsignedInt32 = rtmpHeaderPrevHeaderRx3.timestampDelta >= 16777215 ? Util.readUnsignedInt32(inputStream) : 0;
            this.extendedTimestamp = unsignedInt32;
            int i6 = unsignedInt32 == 0 ? rtmpHeaderPrevHeaderRx3.timestampDelta : 16777215;
            this.timestampDelta = i6;
            this.packetLength = rtmpHeaderPrevHeaderRx3.packetLength;
            this.messageType = rtmpHeaderPrevHeaderRx3.messageType;
            this.messageStreamId = rtmpHeaderPrevHeaderRx3.messageStreamId;
            if (unsignedInt32 == 0) {
                unsignedInt32 = rtmpHeaderPrevHeaderRx3.absoluteTimestamp + i6;
            }
            this.absoluteTimestamp = unsignedInt32;
            return;
        }
        throw new IOException("Invalid chunk type; basic header byte was: " + Util.toHexString(b));
    }

    /* renamed from: com.github.faucamp.simplertmp.packets.RtmpHeader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType;

        static {
            int[] iArr = new int[ChunkType.values().length];
            $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType = iArr;
            try {
                iArr[ChunkType.TYPE_0_FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType[ChunkType.TYPE_1_RELATIVE_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType[ChunkType.TYPE_2_RELATIVE_TIMESTAMP_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType[ChunkType.TYPE_3_RELATIVE_SINGLE_BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void writeTo(OutputStream outputStream, ChunkType chunkType, ChunkStreamInfo chunkStreamInfo) throws IOException {
        outputStream.write(((byte) (chunkType.getValue() << 6)) | this.chunkStreamId);
        int i = AnonymousClass1.$SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$ChunkType[chunkType.ordinal()];
        if (i == 1) {
            chunkStreamInfo.markDeltaTimestampTx();
            int i2 = this.absoluteTimestamp;
            if (i2 >= 16777215) {
                i2 = 16777215;
            }
            Util.writeUnsignedInt24(outputStream, i2);
            Util.writeUnsignedInt24(outputStream, this.packetLength);
            outputStream.write(this.messageType.getValue());
            Util.writeUnsignedInt32LittleEndian(outputStream, this.messageStreamId);
            int i3 = this.absoluteTimestamp;
            if (i3 >= 16777215) {
                this.extendedTimestamp = i3;
                Util.writeUnsignedInt32(outputStream, i3);
                return;
            }
            return;
        }
        if (i == 2) {
            this.timestampDelta = (int) chunkStreamInfo.markDeltaTimestampTx();
            int absoluteTimestamp = chunkStreamInfo.getPrevHeaderTx().getAbsoluteTimestamp();
            int i4 = this.timestampDelta;
            int i5 = absoluteTimestamp + i4;
            this.absoluteTimestamp = i5;
            if (i5 >= 16777215) {
                i4 = 16777215;
            }
            Util.writeUnsignedInt24(outputStream, i4);
            Util.writeUnsignedInt24(outputStream, this.packetLength);
            outputStream.write(this.messageType.getValue());
            int i6 = this.absoluteTimestamp;
            if (i6 >= 16777215) {
                this.extendedTimestamp = i6;
                Util.writeUnsignedInt32(outputStream, i6);
                return;
            }
            return;
        }
        if (i != 3) {
            if (i == 4) {
                int i7 = this.extendedTimestamp;
                if (i7 > 0) {
                    Util.writeUnsignedInt32(outputStream, i7);
                    return;
                }
                return;
            }
            throw new IOException("Invalid chunk type: " + chunkType);
        }
        this.timestampDelta = (int) chunkStreamInfo.markDeltaTimestampTx();
        int absoluteTimestamp2 = chunkStreamInfo.getPrevHeaderTx().getAbsoluteTimestamp();
        int i8 = this.timestampDelta;
        int i9 = absoluteTimestamp2 + i8;
        this.absoluteTimestamp = i9;
        if (i9 >= 16777215) {
            i8 = 16777215;
        }
        Util.writeUnsignedInt24(outputStream, i8);
        int i10 = this.absoluteTimestamp;
        if (i10 >= 16777215) {
            this.extendedTimestamp = i10;
            Util.writeUnsignedInt32(outputStream, i10);
        }
    }

    private void parseBasicHeader(byte b) {
        this.chunkType = ChunkType.valueOf((byte) ((b & 255) >>> 6));
        this.chunkStreamId = b & 63;
    }

    public int getChunkStreamId() {
        return this.chunkStreamId;
    }

    public int getPacketLength() {
        return this.packetLength;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public int getAbsoluteTimestamp() {
        return this.absoluteTimestamp;
    }

    public void setAbsoluteTimestamp(int i) {
        this.absoluteTimestamp = i;
    }

    public void setChunkStreamId(int i) {
        this.chunkStreamId = i;
    }

    public void setMessageStreamId(int i) {
        this.messageStreamId = i;
    }

    public void setPacketLength(int i) {
        this.packetLength = i;
    }
}
