package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestStartStream extends GeneratedMessageLite implements U64 {
    private static final MeetOuterClass$RequestStartStream DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RTMPSERVER_FIELD_NUMBER = 3;
    public static final int STREAM_USER_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer streamUser_;
    private String url_ = "";
    private String rtmpServer_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$RequestStartStream.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestStartStream meetOuterClass$RequestStartStream = new MeetOuterClass$RequestStartStream();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartStream;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartStream.class, meetOuterClass$RequestStartStream);
    }

    private MeetOuterClass$RequestStartStream() {
    }

    private void clearRtmpServer() {
        this.rtmpServer_ = getDefaultInstance().getRtmpServer();
    }

    private void clearStreamUser() {
        this.streamUser_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static MeetOuterClass$RequestStartStream getDefaultInstance() {
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

    public static MeetOuterClass$RequestStartStream parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRtmpServer(String str) {
        str.getClass();
        this.rtmpServer_ = str;
    }

    private void setRtmpServerBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rtmpServer_ = abstractC2383g.f0();
    }

    private void setStreamUser(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.streamUser_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartStream();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ", new Object[]{"bitField0_", "streamUser_", "url_", "rtmpServer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartStream.class) {
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

    public String getRtmpServer() {
        return this.rtmpServer_;
    }

    public AbstractC2383g getRtmpServerBytes() {
        return AbstractC2383g.N(this.rtmpServer_);
    }

    public PeersStruct$ExPeer getStreamUser() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.streamUser_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasStreamUser() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestStartStream meetOuterClass$RequestStartStream) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartStream);
    }

    public static MeetOuterClass$RequestStartStream parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartStream parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
