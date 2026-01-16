package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes3.dex */
public final class RateLimitProto$Counter extends GeneratedMessageLite<RateLimitProto$Counter, Builder> implements MessageLiteOrBuilder {
    private static final RateLimitProto$Counter DEFAULT_INSTANCE;
    private static volatile Parser<RateLimitProto$Counter> PARSER = null;
    public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long startTimeEpoch_;
    private long value_;

    private RateLimitProto$Counter() {
    }

    public long getValue() {
        return this.value_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(long j) {
        this.value_ = j;
    }

    public long getStartTimeEpoch() {
        return this.startTimeEpoch_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTimeEpoch(long j) {
        this.startTimeEpoch_ = j;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RateLimitProto$Counter, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(RateLimitProto$1 rateLimitProto$1) {
            this();
        }

        private Builder() {
            super(RateLimitProto$Counter.DEFAULT_INSTANCE);
        }

        public Builder setValue(long j) {
            copyOnWrite();
            ((RateLimitProto$Counter) this.instance).setValue(j);
            return this;
        }

        public Builder setStartTimeEpoch(long j) {
            copyOnWrite();
            ((RateLimitProto$Counter) this.instance).setStartTimeEpoch(j);
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        RateLimitProto$1 rateLimitProto$1 = null;
        switch (RateLimitProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RateLimitProto$Counter();
            case 2:
                return new Builder(rateLimitProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"value_", "startTimeEpoch_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RateLimitProto$Counter> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (RateLimitProto$Counter.class) {
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
        RateLimitProto$Counter rateLimitProto$Counter = new RateLimitProto$Counter();
        DEFAULT_INSTANCE = rateLimitProto$Counter;
        GeneratedMessageLite.registerDefaultInstance(RateLimitProto$Counter.class, rateLimitProto$Counter);
    }

    public static RateLimitProto$Counter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
