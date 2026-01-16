package com.github.faucamp.simplertmp.packets;

import com.github.faucamp.simplertmp.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SetPeerBandwidth extends RtmpPacket {
    private int acknowledgementWindowSize;
    private LimitType limitType;

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected byte[] array() {
        return null;
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected int size() {
        return 0;
    }

    public String toString() {
        return "RTMP Set Peer Bandwidth";
    }

    public enum LimitType {
        HARD(0),
        SOFT(1),
        DYNAMIC(2);

        private static final Map<Integer, LimitType> quickLookupMap = new HashMap();
        private int intValue;

        static {
            for (LimitType limitType : values()) {
                quickLookupMap.put(Integer.valueOf(limitType.getIntValue()), limitType);
            }
        }

        LimitType(int i) {
            this.intValue = i;
        }

        public int getIntValue() {
            return this.intValue;
        }

        public static LimitType valueOf(int i) {
            return quickLookupMap.get(Integer.valueOf(i));
        }
    }

    public SetPeerBandwidth(RtmpHeader rtmpHeader) {
        super(rtmpHeader);
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    public void readBody(InputStream inputStream) throws IOException {
        this.acknowledgementWindowSize = Util.readUnsignedInt32(inputStream);
        this.limitType = LimitType.valueOf(inputStream.read());
    }

    @Override // com.github.faucamp.simplertmp.packets.RtmpPacket
    protected void writeBody(OutputStream outputStream) throws IOException {
        Util.writeUnsignedInt32(outputStream, this.acknowledgementWindowSize);
        outputStream.write(this.limitType.getIntValue());
    }
}
