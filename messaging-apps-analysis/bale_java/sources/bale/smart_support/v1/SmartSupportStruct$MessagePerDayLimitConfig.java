package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$MessagePerDayLimitConfig extends GeneratedMessageLite implements U64 {
    private static final SmartSupportStruct$MessagePerDayLimitConfig DEFAULT_INSTANCE;
    public static final int ENABLED_FIELD_NUMBER = 1;
    public static final int LIMIT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private boolean enabled_;
    private int limit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportStruct$MessagePerDayLimitConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig = new SmartSupportStruct$MessagePerDayLimitConfig();
        DEFAULT_INSTANCE = smartSupportStruct$MessagePerDayLimitConfig;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$MessagePerDayLimitConfig.class, smartSupportStruct$MessagePerDayLimitConfig);
    }

    private SmartSupportStruct$MessagePerDayLimitConfig() {
    }

    private void clearEnabled() {
        this.enabled_ = false;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnabled(boolean z) {
        this.enabled_ = z;
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$MessagePerDayLimitConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u0004", new Object[]{"enabled_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$MessagePerDayLimitConfig.class) {
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

    public boolean getEnabled() {
        return this.enabled_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public static a newBuilder(SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$MessagePerDayLimitConfig);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(byte[] bArr) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$MessagePerDayLimitConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$MessagePerDayLimitConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
