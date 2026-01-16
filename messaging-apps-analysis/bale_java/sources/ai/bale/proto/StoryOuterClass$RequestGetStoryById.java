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
public final class StoryOuterClass$RequestGetStoryById extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetStoryById DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    private String storyId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((StoryOuterClass$RequestGetStoryById) this.b).setStoryId(str);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestGetStoryById.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetStoryById storyOuterClass$RequestGetStoryById = new StoryOuterClass$RequestGetStoryById();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetStoryById;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetStoryById.class, storyOuterClass$RequestGetStoryById);
    }

    private StoryOuterClass$RequestGetStoryById() {
    }

    private void clearStoryId() {
        this.storyId_ = getDefaultInstance().getStoryId();
    }

    public static StoryOuterClass$RequestGetStoryById getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetStoryById parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoryId(String str) {
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
                return new StoryOuterClass$RequestGetStoryById();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"storyId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetStoryById.class) {
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

    public static a newBuilder(StoryOuterClass$RequestGetStoryById storyOuterClass$RequestGetStoryById) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetStoryById);
    }

    public static StoryOuterClass$RequestGetStoryById parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetStoryById parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetStoryById) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
