package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestDeleteStream extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestDeleteStream DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STREAM_USER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$ExPeer streamUser_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$RequestDeleteStream.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestDeleteStream meetOuterClass$RequestDeleteStream = new MeetOuterClass$RequestDeleteStream();
        DEFAULT_INSTANCE = meetOuterClass$RequestDeleteStream;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestDeleteStream.class, meetOuterClass$RequestDeleteStream);
    }

    private MeetOuterClass$RequestDeleteStream() {
    }

    private void clearStreamUser() {
        this.streamUser_ = null;
        this.bitField0_ &= -2;
    }

    public static MeetOuterClass$RequestDeleteStream getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStreamUser(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.streamUser_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.streamUser_ = peersStruct$ExPeer;
        } else {
            this.streamUser_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.streamUser_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestDeleteStream parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStreamUser(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.streamUser_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestDeleteStream();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "streamUser_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestDeleteStream.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public PeersStruct$ExPeer getStreamUser() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.streamUser_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasStreamUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestDeleteStream meetOuterClass$RequestDeleteStream) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestDeleteStream);
    }

    public static MeetOuterClass$RequestDeleteStream parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestDeleteStream parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
