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

/* loaded from: classes.dex */
public final class StoryStruct$ReStoryWidget extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$ReStoryWidget DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private String storyId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$ReStoryWidget.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$ReStoryWidget storyStruct$ReStoryWidget = new StoryStruct$ReStoryWidget();
        DEFAULT_INSTANCE = storyStruct$ReStoryWidget;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$ReStoryWidget.class, storyStruct$ReStoryWidget);
    }

    private StoryStruct$ReStoryWidget() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStoryId() {
        this.storyId_ = getDefaultInstance().getStoryId();
    }

    public static StoryStruct$ReStoryWidget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$ReStoryWidget parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ReStoryWidget parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setStoryId(String str) {
        str.getClass();
        this.storyId_ = str;
    }

    private void setStoryIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.storyId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$ReStoryWidget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "storyId_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$ReStoryWidget.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public String getStoryId() {
        return this.storyId_;
    }

    public AbstractC2383g getStoryIdBytes() {
        return AbstractC2383g.N(this.storyId_);
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryStruct$ReStoryWidget storyStruct$ReStoryWidget) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$ReStoryWidget);
    }

    public static StoryStruct$ReStoryWidget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ReStoryWidget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$ReStoryWidget parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$ReStoryWidget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$ReStoryWidget parseFrom(byte[] bArr) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$ReStoryWidget parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$ReStoryWidget parseFrom(InputStream inputStream) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ReStoryWidget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ReStoryWidget parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$ReStoryWidget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$ReStoryWidget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
