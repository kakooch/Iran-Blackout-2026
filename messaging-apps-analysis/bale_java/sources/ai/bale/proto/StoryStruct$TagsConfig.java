package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.SU6;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$TagsConfig extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$TagsConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAGS_FIELD_NUMBER = 1;
    private B.j tags_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryStruct$TagsConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$TagsConfig storyStruct$TagsConfig = new StoryStruct$TagsConfig();
        DEFAULT_INSTANCE = storyStruct$TagsConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$TagsConfig.class, storyStruct$TagsConfig);
    }

    private StoryStruct$TagsConfig() {
    }

    private void addAllTags(Iterable<? extends StoryStruct$Tag> iterable) {
        ensureTagsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tags_);
    }

    private void addTags(StoryStruct$Tag storyStruct$Tag) {
        storyStruct$Tag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(storyStruct$Tag);
    }

    private void clearTags() {
        this.tags_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTagsIsMutable() {
        B.j jVar = this.tags_;
        if (jVar.u()) {
            return;
        }
        this.tags_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryStruct$TagsConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$TagsConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TagsConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTags(int i) {
        ensureTagsIsMutable();
        this.tags_.remove(i);
    }

    private void setTags(int i, StoryStruct$Tag storyStruct$Tag) {
        storyStruct$Tag.getClass();
        ensureTagsIsMutable();
        this.tags_.set(i, storyStruct$Tag);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$TagsConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"tags_", StoryStruct$Tag.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$TagsConfig.class) {
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

    public StoryStruct$Tag getTags(int i) {
        return (StoryStruct$Tag) this.tags_.get(i);
    }

    public int getTagsCount() {
        return this.tags_.size();
    }

    public List<StoryStruct$Tag> getTagsList() {
        return this.tags_;
    }

    public SU6 getTagsOrBuilder(int i) {
        return (SU6) this.tags_.get(i);
    }

    public List<? extends SU6> getTagsOrBuilderList() {
        return this.tags_;
    }

    public static a newBuilder(StoryStruct$TagsConfig storyStruct$TagsConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$TagsConfig);
    }

    public static StoryStruct$TagsConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TagsConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$TagsConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTags(int i, StoryStruct$Tag storyStruct$Tag) {
        storyStruct$Tag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(i, storyStruct$Tag);
    }

    public static StoryStruct$TagsConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$TagsConfig parseFrom(byte[] bArr) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$TagsConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$TagsConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$TagsConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$TagsConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$TagsConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$TagsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
