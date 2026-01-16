package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24360yU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$TextStoryBackgroundsConfig extends GeneratedMessageLite implements U64 {
    public static final int BACKGROUNDS_FIELD_NUMBER = 1;
    private static final StoryStruct$TextStoryBackgroundsConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j backgrounds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$TextStoryBackgroundsConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$TextStoryBackgroundsConfig storyStruct$TextStoryBackgroundsConfig = new StoryStruct$TextStoryBackgroundsConfig();
        DEFAULT_INSTANCE = storyStruct$TextStoryBackgroundsConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$TextStoryBackgroundsConfig.class, storyStruct$TextStoryBackgroundsConfig);
    }

    private StoryStruct$TextStoryBackgroundsConfig() {
    }

    private void addAllBackgrounds(Iterable<? extends StoryStruct$MediaStory> iterable) {
        ensureBackgroundsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.backgrounds_);
    }

    private void addBackgrounds(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureBackgroundsIsMutable();
        this.backgrounds_.add(storyStruct$MediaStory);
    }

    private void clearBackgrounds() {
        this.backgrounds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBackgroundsIsMutable() {
        B.j jVar = this.backgrounds_;
        if (jVar.u()) {
            return;
        }
        this.backgrounds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryStruct$TextStoryBackgroundsConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBackgrounds(int i) {
        ensureBackgroundsIsMutable();
        this.backgrounds_.remove(i);
    }

    private void setBackgrounds(int i, StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureBackgroundsIsMutable();
        this.backgrounds_.set(i, storyStruct$MediaStory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$TextStoryBackgroundsConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"backgrounds_", StoryStruct$MediaStory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$TextStoryBackgroundsConfig.class) {
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

    public StoryStruct$MediaStory getBackgrounds(int i) {
        return (StoryStruct$MediaStory) this.backgrounds_.get(i);
    }

    public int getBackgroundsCount() {
        return this.backgrounds_.size();
    }

    public List<StoryStruct$MediaStory> getBackgroundsList() {
        return this.backgrounds_;
    }

    public InterfaceC24360yU6 getBackgroundsOrBuilder(int i) {
        return (InterfaceC24360yU6) this.backgrounds_.get(i);
    }

    public List<? extends InterfaceC24360yU6> getBackgroundsOrBuilderList() {
        return this.backgrounds_;
    }

    public static a newBuilder(StoryStruct$TextStoryBackgroundsConfig storyStruct$TextStoryBackgroundsConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$TextStoryBackgroundsConfig);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBackgrounds(int i, StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureBackgroundsIsMutable();
        this.backgrounds_.add(i, storyStruct$MediaStory);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(byte[] bArr) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$TextStoryBackgroundsConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$TextStoryBackgroundsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
