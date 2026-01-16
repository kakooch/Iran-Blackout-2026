package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$PopularStoryChannelBlackListConfig extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$PopularStoryChannelBlackListConfig DEFAULT_INSTANCE;
    public static final int EX_PEER_IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int exPeerIdsMemoizedSerializedSize = -1;
    private B.g exPeerIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$PopularStoryChannelBlackListConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$PopularStoryChannelBlackListConfig storyStruct$PopularStoryChannelBlackListConfig = new StoryStruct$PopularStoryChannelBlackListConfig();
        DEFAULT_INSTANCE = storyStruct$PopularStoryChannelBlackListConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$PopularStoryChannelBlackListConfig.class, storyStruct$PopularStoryChannelBlackListConfig);
    }

    private StoryStruct$PopularStoryChannelBlackListConfig() {
    }

    private void addAllExPeerIds(Iterable<? extends Integer> iterable) {
        ensureExPeerIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exPeerIds_);
    }

    private void addExPeerIds(int i) {
        ensureExPeerIdsIsMutable();
        this.exPeerIds_.b1(i);
    }

    private void clearExPeerIds() {
        this.exPeerIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureExPeerIdsIsMutable() {
        B.g gVar = this.exPeerIds_;
        if (gVar.u()) {
            return;
        }
        this.exPeerIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeerIds(int i, int i2) {
        ensureExPeerIdsIsMutable();
        this.exPeerIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$PopularStoryChannelBlackListConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"exPeerIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$PopularStoryChannelBlackListConfig.class) {
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

    public int getExPeerIds(int i) {
        return this.exPeerIds_.getInt(i);
    }

    public int getExPeerIdsCount() {
        return this.exPeerIds_.size();
    }

    public List<Integer> getExPeerIdsList() {
        return this.exPeerIds_;
    }

    public static a newBuilder(StoryStruct$PopularStoryChannelBlackListConfig storyStruct$PopularStoryChannelBlackListConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$PopularStoryChannelBlackListConfig);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(byte[] bArr) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$PopularStoryChannelBlackListConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$PopularStoryChannelBlackListConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
