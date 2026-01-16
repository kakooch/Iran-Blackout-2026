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
public final class StoryOuterClass$ResponseGetDefaultStoryBackgrounds extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetDefaultStoryBackgrounds DEFAULT_INSTANCE;
    public static final int DEFAULT_STORY_BACKGROUNDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j defaultStoryBackgrounds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetDefaultStoryBackgrounds.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetDefaultStoryBackgrounds storyOuterClass$ResponseGetDefaultStoryBackgrounds = new StoryOuterClass$ResponseGetDefaultStoryBackgrounds();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetDefaultStoryBackgrounds;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetDefaultStoryBackgrounds.class, storyOuterClass$ResponseGetDefaultStoryBackgrounds);
    }

    private StoryOuterClass$ResponseGetDefaultStoryBackgrounds() {
    }

    private void addAllDefaultStoryBackgrounds(Iterable<? extends StoryStruct$MediaStory> iterable) {
        ensureDefaultStoryBackgroundsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.defaultStoryBackgrounds_);
    }

    private void addDefaultStoryBackgrounds(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureDefaultStoryBackgroundsIsMutable();
        this.defaultStoryBackgrounds_.add(storyStruct$MediaStory);
    }

    private void clearDefaultStoryBackgrounds() {
        this.defaultStoryBackgrounds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDefaultStoryBackgroundsIsMutable() {
        B.j jVar = this.defaultStoryBackgrounds_;
        if (jVar.u()) {
            return;
        }
        this.defaultStoryBackgrounds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDefaultStoryBackgrounds(int i) {
        ensureDefaultStoryBackgroundsIsMutable();
        this.defaultStoryBackgrounds_.remove(i);
    }

    private void setDefaultStoryBackgrounds(int i, StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureDefaultStoryBackgroundsIsMutable();
        this.defaultStoryBackgrounds_.set(i, storyStruct$MediaStory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetDefaultStoryBackgrounds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"defaultStoryBackgrounds_", StoryStruct$MediaStory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetDefaultStoryBackgrounds.class) {
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

    public StoryStruct$MediaStory getDefaultStoryBackgrounds(int i) {
        return (StoryStruct$MediaStory) this.defaultStoryBackgrounds_.get(i);
    }

    public int getDefaultStoryBackgroundsCount() {
        return this.defaultStoryBackgrounds_.size();
    }

    public List<StoryStruct$MediaStory> getDefaultStoryBackgroundsList() {
        return this.defaultStoryBackgrounds_;
    }

    public InterfaceC24360yU6 getDefaultStoryBackgroundsOrBuilder(int i) {
        return (InterfaceC24360yU6) this.defaultStoryBackgrounds_.get(i);
    }

    public List<? extends InterfaceC24360yU6> getDefaultStoryBackgroundsOrBuilderList() {
        return this.defaultStoryBackgrounds_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetDefaultStoryBackgrounds storyOuterClass$ResponseGetDefaultStoryBackgrounds) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetDefaultStoryBackgrounds);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDefaultStoryBackgrounds(int i, StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        ensureDefaultStoryBackgroundsIsMutable();
        this.defaultStoryBackgrounds_.add(i, storyStruct$MediaStory);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetDefaultStoryBackgrounds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetDefaultStoryBackgrounds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
