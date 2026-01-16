package ai.bale.proto;

import ai.bale.proto.StoryStruct$UserPrivacyConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestSetUserPrivacyConfig extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final StoryOuterClass$RequestSetUserPrivacyConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StoryStruct$UserPrivacyConfig config_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
            q();
            ((StoryOuterClass$RequestSetUserPrivacyConfig) this.b).setConfig(storyStruct$UserPrivacyConfig);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestSetUserPrivacyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestSetUserPrivacyConfig storyOuterClass$RequestSetUserPrivacyConfig = new StoryOuterClass$RequestSetUserPrivacyConfig();
        DEFAULT_INSTANCE = storyOuterClass$RequestSetUserPrivacyConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestSetUserPrivacyConfig.class, storyOuterClass$RequestSetUserPrivacyConfig);
    }

    private StoryOuterClass$RequestSetUserPrivacyConfig() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig2 = this.config_;
        if (storyStruct$UserPrivacyConfig2 == null || storyStruct$UserPrivacyConfig2 == StoryStruct$UserPrivacyConfig.getDefaultInstance()) {
            this.config_ = storyStruct$UserPrivacyConfig;
        } else {
            this.config_ = (StoryStruct$UserPrivacyConfig) ((StoryStruct$UserPrivacyConfig.a) StoryStruct$UserPrivacyConfig.newBuilder(this.config_).v(storyStruct$UserPrivacyConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfig(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        this.config_ = storyStruct$UserPrivacyConfig;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestSetUserPrivacyConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestSetUserPrivacyConfig.class) {
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

    public StoryStruct$UserPrivacyConfig getConfig() {
        StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig = this.config_;
        return storyStruct$UserPrivacyConfig == null ? StoryStruct$UserPrivacyConfig.getDefaultInstance() : storyStruct$UserPrivacyConfig;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryOuterClass$RequestSetUserPrivacyConfig storyOuterClass$RequestSetUserPrivacyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestSetUserPrivacyConfig);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestSetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestSetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
