package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes3.dex */
public final class CommonTypesProto$TriggeringCondition extends GeneratedMessageLite<CommonTypesProto$TriggeringCondition, Builder> implements MessageLiteOrBuilder {
    private static final CommonTypesProto$TriggeringCondition DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 2;
    public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
    private static volatile Parser<CommonTypesProto$TriggeringCondition> PARSER;
    private int conditionCase_ = 0;
    private Object condition_;

    private CommonTypesProto$TriggeringCondition() {
    }

    public CommonTypesProto$Trigger getFiamTrigger() {
        if (this.conditionCase_ == 1) {
            CommonTypesProto$Trigger commonTypesProto$TriggerForNumber = CommonTypesProto$Trigger.forNumber(((Integer) this.condition_).intValue());
            return commonTypesProto$TriggerForNumber == null ? CommonTypesProto$Trigger.UNRECOGNIZED : commonTypesProto$TriggerForNumber;
        }
        return CommonTypesProto$Trigger.UNKNOWN_TRIGGER;
    }

    public CommonTypesProto$Event getEvent() {
        if (this.conditionCase_ == 2) {
            return (CommonTypesProto$Event) this.condition_;
        }
        return CommonTypesProto$Event.getDefaultInstance();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CommonTypesProto$TriggeringCondition, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CommonTypesProto$1 commonTypesProto$1) {
            this();
        }

        private Builder() {
            super(CommonTypesProto$TriggeringCondition.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CommonTypesProto$1 commonTypesProto$1 = null;
        switch (CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CommonTypesProto$TriggeringCondition();
            case 2:
                return new Builder(commonTypesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001?\u0000\u0002<\u0000", new Object[]{"condition_", "conditionCase_", CommonTypesProto$Event.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommonTypesProto$TriggeringCondition> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CommonTypesProto$TriggeringCondition.class) {
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
        CommonTypesProto$TriggeringCondition commonTypesProto$TriggeringCondition = new CommonTypesProto$TriggeringCondition();
        DEFAULT_INSTANCE = commonTypesProto$TriggeringCondition;
        GeneratedMessageLite.registerDefaultInstance(CommonTypesProto$TriggeringCondition.class, commonTypesProto$TriggeringCondition);
    }
}
