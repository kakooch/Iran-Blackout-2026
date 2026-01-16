package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$ReplyConfig extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$ReplyConfig DEFAULT_INSTANCE;
    public static final int HAS_REPLY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean hasReply_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$ReplyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$ReplyConfig storyStruct$ReplyConfig = new StoryStruct$ReplyConfig();
        DEFAULT_INSTANCE = storyStruct$ReplyConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$ReplyConfig.class, storyStruct$ReplyConfig);
    }

    private StoryStruct$ReplyConfig() {
    }

    private void clearHasReply() {
        this.hasReply_ = false;
    }

    public static StoryStruct$ReplyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$ReplyConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ReplyConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHasReply(boolean z) {
        this.hasReply_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$ReplyConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"hasReply_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$ReplyConfig.class) {
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

    public boolean getHasReply() {
        return this.hasReply_;
    }

    public static a newBuilder(StoryStruct$ReplyConfig storyStruct$ReplyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$ReplyConfig);
    }

    public static StoryStruct$ReplyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ReplyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$ReplyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$ReplyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$ReplyConfig parseFrom(byte[] bArr) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$ReplyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$ReplyConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$ReplyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$ReplyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$ReplyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$ReplyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
