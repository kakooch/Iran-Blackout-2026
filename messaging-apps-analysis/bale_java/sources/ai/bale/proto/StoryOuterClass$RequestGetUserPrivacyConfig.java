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
public final class StoryOuterClass$RequestGetUserPrivacyConfig extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestGetUserPrivacyConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(StoryOuterClass$RequestGetUserPrivacyConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryOuterClass$RequestGetUserPrivacyConfig storyOuterClass$RequestGetUserPrivacyConfig = new StoryOuterClass$RequestGetUserPrivacyConfig();
        DEFAULT_INSTANCE = storyOuterClass$RequestGetUserPrivacyConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestGetUserPrivacyConfig.class, storyOuterClass$RequestGetUserPrivacyConfig);
    }

    private StoryOuterClass$RequestGetUserPrivacyConfig() {
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestGetUserPrivacyConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestGetUserPrivacyConfig.class) {
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

    public static a newBuilder(StoryOuterClass$RequestGetUserPrivacyConfig storyOuterClass$RequestGetUserPrivacyConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestGetUserPrivacyConfig);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestGetUserPrivacyConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestGetUserPrivacyConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
