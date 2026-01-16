package ai.bale.proto;

import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$TextStory;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$StoryContent extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$StoryContent DEFAULT_INSTANCE;
    public static final int MEDIA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$StoryContent.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MEDIA(1),
        TEXT(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return MEDIA;
            }
            if (i != 2) {
                return null;
            }
            return TEXT;
        }
    }

    static {
        StoryStruct$StoryContent storyStruct$StoryContent = new StoryStruct$StoryContent();
        DEFAULT_INSTANCE = storyStruct$StoryContent;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$StoryContent.class, storyStruct$StoryContent);
    }

    private StoryStruct$StoryContent() {
    }

    private void clearMedia() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearText() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static StoryStruct$StoryContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMedia(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        if (this.traitCase_ != 1 || this.trait_ == StoryStruct$MediaStory.getDefaultInstance()) {
            this.trait_ = storyStruct$MediaStory;
        } else {
            this.trait_ = ((StoryStruct$MediaStory.a) StoryStruct$MediaStory.newBuilder((StoryStruct$MediaStory) this.trait_).v(storyStruct$MediaStory)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeText(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        if (this.traitCase_ != 2 || this.trait_ == StoryStruct$TextStory.getDefaultInstance()) {
            this.trait_ = storyStruct$TextStory;
        } else {
            this.trait_ = ((StoryStruct$TextStory.a) StoryStruct$TextStory.newBuilder((StoryStruct$TextStory) this.trait_).v(storyStruct$TextStory)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$StoryContent parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$StoryContent parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMedia(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        this.trait_ = storyStruct$MediaStory;
        this.traitCase_ = 1;
    }

    private void setText(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        this.trait_ = storyStruct$TextStory;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$StoryContent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", StoryStruct$MediaStory.class, StoryStruct$TextStory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$StoryContent.class) {
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

    public StoryStruct$MediaStory getMedia() {
        return this.traitCase_ == 1 ? (StoryStruct$MediaStory) this.trait_ : StoryStruct$MediaStory.getDefaultInstance();
    }

    public StoryStruct$TextStory getText() {
        return this.traitCase_ == 2 ? (StoryStruct$TextStory) this.trait_ : StoryStruct$TextStory.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasMedia() {
        return this.traitCase_ == 1;
    }

    public boolean hasText() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(StoryStruct$StoryContent storyStruct$StoryContent) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$StoryContent);
    }

    public static StoryStruct$StoryContent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$StoryContent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$StoryContent parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$StoryContent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$StoryContent parseFrom(byte[] bArr) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$StoryContent parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$StoryContent parseFrom(InputStream inputStream) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$StoryContent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$StoryContent parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$StoryContent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$StoryContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
