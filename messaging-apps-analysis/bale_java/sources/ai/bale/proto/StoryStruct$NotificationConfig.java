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
public final class StoryStruct$NotificationConfig extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$NotificationConfig DEFAULT_INSTANCE;
    public static final int ISACTIVE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isActive_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((StoryStruct$NotificationConfig) this.b).setIsActive(z);
            return this;
        }

        private a() {
            super(StoryStruct$NotificationConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$NotificationConfig storyStruct$NotificationConfig = new StoryStruct$NotificationConfig();
        DEFAULT_INSTANCE = storyStruct$NotificationConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$NotificationConfig.class, storyStruct$NotificationConfig);
    }

    private StoryStruct$NotificationConfig() {
    }

    private void clearIsActive() {
        this.isActive_ = false;
    }

    public static StoryStruct$NotificationConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$NotificationConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$NotificationConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsActive(boolean z) {
        this.isActive_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$NotificationConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"isActive_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$NotificationConfig.class) {
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

    public boolean getIsActive() {
        return this.isActive_;
    }

    public static a newBuilder(StoryStruct$NotificationConfig storyStruct$NotificationConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$NotificationConfig);
    }

    public static StoryStruct$NotificationConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$NotificationConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$NotificationConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$NotificationConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$NotificationConfig parseFrom(byte[] bArr) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$NotificationConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$NotificationConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$NotificationConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$NotificationConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$NotificationConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$NotificationConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
