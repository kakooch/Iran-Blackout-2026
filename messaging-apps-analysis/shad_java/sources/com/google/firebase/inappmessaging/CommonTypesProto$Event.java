package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class CommonTypesProto$Event extends GeneratedMessageLite<CommonTypesProto$Event, Builder> implements MessageLiteOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 5;
    private static final CommonTypesProto$Event DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile Parser<CommonTypesProto$Event> PARSER = null;
    public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
    public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
    private int count_;
    private long previousTimestampMillis_;
    private long timestampMillis_;
    private Internal.ProtobufList<CommonTypesProto$TriggerParam> triggerParams_ = GeneratedMessageLite.emptyProtobufList();
    private String name_ = BuildConfig.FLAVOR;

    private CommonTypesProto$Event() {
    }

    public String getName() {
        return this.name_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CommonTypesProto$Event, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CommonTypesProto$1 commonTypesProto$1) {
            this();
        }

        private Builder() {
            super(CommonTypesProto$Event.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CommonTypesProto$1 commonTypesProto$1 = null;
        switch (CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CommonTypesProto$Event();
            case 2:
                return new Builder(commonTypesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0004", new Object[]{"triggerParams_", CommonTypesProto$TriggerParam.class, "name_", "timestampMillis_", "previousTimestampMillis_", "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommonTypesProto$Event> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CommonTypesProto$Event.class) {
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
        CommonTypesProto$Event commonTypesProto$Event = new CommonTypesProto$Event();
        DEFAULT_INSTANCE = commonTypesProto$Event;
        GeneratedMessageLite.registerDefaultInstance(CommonTypesProto$Event.class, commonTypesProto$Event);
    }

    public static CommonTypesProto$Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
