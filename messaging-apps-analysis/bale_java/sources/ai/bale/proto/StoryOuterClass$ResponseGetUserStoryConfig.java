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
public final class StoryOuterClass$ResponseGetUserStoryConfig extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final StoryOuterClass$ResponseGetUserStoryConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j config_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetUserStoryConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetUserStoryConfig storyOuterClass$ResponseGetUserStoryConfig = new StoryOuterClass$ResponseGetUserStoryConfig();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetUserStoryConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetUserStoryConfig.class, storyOuterClass$ResponseGetUserStoryConfig);
    }

    private StoryOuterClass$ResponseGetUserStoryConfig() {
    }

    private void addAllConfig(Iterable<? extends StoryStruct$UserStoryConfig> iterable) {
        ensureConfigIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.config_);
    }

    private void addConfig(StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        storyStruct$UserStoryConfig.getClass();
        ensureConfigIsMutable();
        this.config_.add(storyStruct$UserStoryConfig);
    }

    private void clearConfig() {
        this.config_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureConfigIsMutable() {
        B.j jVar = this.config_;
        if (jVar.u()) {
            return;
        }
        this.config_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeConfig(int i) {
        ensureConfigIsMutable();
        this.config_.remove(i);
    }

    private void setConfig(int i, StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        storyStruct$UserStoryConfig.getClass();
        ensureConfigIsMutable();
        this.config_.set(i, storyStruct$UserStoryConfig);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetUserStoryConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"config_", StoryStruct$UserStoryConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetUserStoryConfig.class) {
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

    public StoryStruct$UserStoryConfig getConfig(int i) {
        return (StoryStruct$UserStoryConfig) this.config_.get(i);
    }

    public int getConfigCount() {
        return this.config_.size();
    }

    public List<StoryStruct$UserStoryConfig> getConfigList() {
        return this.config_;
    }

    public e2 getConfigOrBuilder(int i) {
        return (e2) this.config_.get(i);
    }

    public List<? extends e2> getConfigOrBuilderList() {
        return this.config_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetUserStoryConfig storyOuterClass$ResponseGetUserStoryConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetUserStoryConfig);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addConfig(int i, StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        storyStruct$UserStoryConfig.getClass();
        ensureConfigIsMutable();
        this.config_.add(i, storyStruct$UserStoryConfig);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetUserStoryConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
