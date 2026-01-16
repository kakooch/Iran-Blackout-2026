package ai.bale.proto;

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
public final class StoryOuterClass$ResponseAddStory extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseAddStory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    private String storyId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseAddStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseAddStory storyOuterClass$ResponseAddStory = new StoryOuterClass$ResponseAddStory();
        DEFAULT_INSTANCE = storyOuterClass$ResponseAddStory;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseAddStory.class, storyOuterClass$ResponseAddStory);
    }

    private StoryOuterClass$ResponseAddStory() {
    }

    private void clearStoryId() {
        this.storyId_ = getDefaultInstance().getStoryId();
    }

    public static StoryOuterClass$ResponseAddStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseAddStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseAddStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"storyId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseAddStory.class) {
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

    public String getStoryId() {
        return this.storyId_;
    }

    public AbstractC2383g getStoryIdBytes() {
        return AbstractC2383g.N(this.storyId_);
    }

    public static a newBuilder(StoryOuterClass$ResponseAddStory storyOuterClass$ResponseAddStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseAddStory);
    }

    public static StoryOuterClass$ResponseAddStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseAddStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
