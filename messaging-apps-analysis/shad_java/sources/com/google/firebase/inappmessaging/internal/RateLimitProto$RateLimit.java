package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class RateLimitProto$RateLimit extends GeneratedMessageLite<RateLimitProto$RateLimit, Builder> implements MessageLiteOrBuilder {
    private static final RateLimitProto$RateLimit DEFAULT_INSTANCE;
    public static final int LIMITS_FIELD_NUMBER = 1;
    private static volatile Parser<RateLimitProto$RateLimit> PARSER;
    private MapFieldLite<String, RateLimitProto$Counter> limits_ = MapFieldLite.emptyMapField();

    private static final class LimitsDefaultEntryHolder {
        static final MapEntryLite<String, RateLimitProto$Counter> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, BuildConfig.FLAVOR, WireFormat.FieldType.MESSAGE, RateLimitProto$Counter.getDefaultInstance());
    }

    private RateLimitProto$RateLimit() {
    }

    private MapFieldLite<String, RateLimitProto$Counter> internalGetLimits() {
        return this.limits_;
    }

    public RateLimitProto$Counter getLimitsOrDefault(String str, RateLimitProto$Counter rateLimitProto$Counter) {
        str.getClass();
        MapFieldLite<String, RateLimitProto$Counter> mapFieldLiteInternalGetLimits = internalGetLimits();
        return mapFieldLiteInternalGetLimits.containsKey(str) ? mapFieldLiteInternalGetLimits.get(str) : rateLimitProto$Counter;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RateLimitProto$RateLimit, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(RateLimitProto$1 rateLimitProto$1) {
            this();
        }

        private Builder() {
            super(RateLimitProto$RateLimit.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        RateLimitProto$1 rateLimitProto$1 = null;
        switch (RateLimitProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RateLimitProto$RateLimit();
            case 2:
                return new Builder(rateLimitProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"limits_", LimitsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RateLimitProto$RateLimit> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (RateLimitProto$RateLimit.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RateLimitProto$RateLimit rateLimitProto$RateLimit = new RateLimitProto$RateLimit();
        DEFAULT_INSTANCE = rateLimitProto$RateLimit;
        GeneratedMessageLite.registerDefaultInstance(RateLimitProto$RateLimit.class, rateLimitProto$RateLimit);
    }

    public static RateLimitProto$RateLimit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RateLimitProto$RateLimit> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
