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
public final class StoryOuterClass$ResponseCanAddBotStory extends GeneratedMessageLite implements U64 {
    public static final int CAN_ADD_BOT_STORY_FIELD_NUMBER = 1;
    private static final StoryOuterClass$ResponseCanAddBotStory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private boolean canAddBotStory_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseCanAddBotStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseCanAddBotStory storyOuterClass$ResponseCanAddBotStory = new StoryOuterClass$ResponseCanAddBotStory();
        DEFAULT_INSTANCE = storyOuterClass$ResponseCanAddBotStory;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseCanAddBotStory.class, storyOuterClass$ResponseCanAddBotStory);
    }

    private StoryOuterClass$ResponseCanAddBotStory() {
    }

    private void clearCanAddBotStory() {
        this.canAddBotStory_ = false;
    }

    public static StoryOuterClass$ResponseCanAddBotStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCanAddBotStory(boolean z) {
        this.canAddBotStory_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseCanAddBotStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"canAddBotStory_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseCanAddBotStory.class) {
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

    public boolean getCanAddBotStory() {
        return this.canAddBotStory_;
    }

    public static a newBuilder(StoryOuterClass$ResponseCanAddBotStory storyOuterClass$ResponseCanAddBotStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseCanAddBotStory);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseCanAddBotStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseCanAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
