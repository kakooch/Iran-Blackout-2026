package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15833kF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$DataChannelReceiveState extends GeneratedMessageLite implements InterfaceC15833kF3 {
    private static final LivekitRtc$DataChannelReceiveState DEFAULT_INSTANCE;
    public static final int LAST_SEQ_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PUBLISHER_SID_FIELD_NUMBER = 1;
    private int lastSeq_;
    private String publisherSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15833kF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(int i) {
            q();
            ((LivekitRtc$DataChannelReceiveState) this.b).setLastSeq(i);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitRtc$DataChannelReceiveState) this.b).setPublisherSid(str);
            return this;
        }

        private a() {
            super(LivekitRtc$DataChannelReceiveState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$DataChannelReceiveState livekitRtc$DataChannelReceiveState = new LivekitRtc$DataChannelReceiveState();
        DEFAULT_INSTANCE = livekitRtc$DataChannelReceiveState;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$DataChannelReceiveState.class, livekitRtc$DataChannelReceiveState);
    }

    private LivekitRtc$DataChannelReceiveState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastSeq() {
        this.lastSeq_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublisherSid() {
        this.publisherSid_ = getDefaultInstance().getPublisherSid();
    }

    public static LivekitRtc$DataChannelReceiveState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$DataChannelReceiveState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastSeq(int i) {
        this.lastSeq_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublisherSid(String str) {
        str.getClass();
        this.publisherSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublisherSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.publisherSid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$DataChannelReceiveState();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u000b", new Object[]{"publisherSid_", "lastSeq_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$DataChannelReceiveState.class) {
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

    public int getLastSeq() {
        return this.lastSeq_;
    }

    public String getPublisherSid() {
        return this.publisherSid_;
    }

    public AbstractC2383g getPublisherSidBytes() {
        return AbstractC2383g.N(this.publisherSid_);
    }

    public static a newBuilder(LivekitRtc$DataChannelReceiveState livekitRtc$DataChannelReceiveState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$DataChannelReceiveState);
    }

    public static LivekitRtc$DataChannelReceiveState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(byte[] bArr) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(InputStream inputStream) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$DataChannelReceiveState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$DataChannelReceiveState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
