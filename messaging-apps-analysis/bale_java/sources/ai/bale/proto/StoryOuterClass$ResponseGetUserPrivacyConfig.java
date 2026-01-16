package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.ZU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$ResponseGetUserPrivacyConfig extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$ResponseGetUserPrivacyConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 1;
    private B.j result_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$ResponseGetUserPrivacyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$ResponseGetUserPrivacyConfig storyOuterClass$ResponseGetUserPrivacyConfig = new StoryOuterClass$ResponseGetUserPrivacyConfig();
        DEFAULT_INSTANCE = storyOuterClass$ResponseGetUserPrivacyConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$ResponseGetUserPrivacyConfig.class, storyOuterClass$ResponseGetUserPrivacyConfig);
    }

    private StoryOuterClass$ResponseGetUserPrivacyConfig() {
    }

    private void addAllResult(Iterable<? extends StoryStruct$UserPrivacyConfig> iterable) {
        ensureResultIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.result_);
    }

    private void addResult(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        ensureResultIsMutable();
        this.result_.add(storyStruct$UserPrivacyConfig);
    }

    private void clearResult() {
        this.result_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureResultIsMutable() {
        B.j jVar = this.result_;
        if (jVar.u()) {
            return;
        }
        this.result_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeResult(int i) {
        ensureResultIsMutable();
        this.result_.remove(i);
    }

    private void setResult(int i, StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        ensureResultIsMutable();
        this.result_.set(i, storyStruct$UserPrivacyConfig);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$ResponseGetUserPrivacyConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"result_", StoryStruct$UserPrivacyConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$ResponseGetUserPrivacyConfig.class) {
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

    public StoryStruct$UserPrivacyConfig getResult(int i) {
        return (StoryStruct$UserPrivacyConfig) this.result_.get(i);
    }

    public int getResultCount() {
        return this.result_.size();
    }

    public List<StoryStruct$UserPrivacyConfig> getResultList() {
        return this.result_;
    }

    public ZU6 getResultOrBuilder(int i) {
        return (ZU6) this.result_.get(i);
    }

    public List<? extends ZU6> getResultOrBuilderList() {
        return this.result_;
    }

    public static a newBuilder(StoryOuterClass$ResponseGetUserPrivacyConfig storyOuterClass$ResponseGetUserPrivacyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$ResponseGetUserPrivacyConfig);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addResult(int i, StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        ensureResultIsMutable();
        this.result_.add(i, storyStruct$UserPrivacyConfig);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$ResponseGetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$ResponseGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
