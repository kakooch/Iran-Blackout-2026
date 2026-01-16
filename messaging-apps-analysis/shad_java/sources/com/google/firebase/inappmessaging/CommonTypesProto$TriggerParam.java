package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class CommonTypesProto$TriggerParam extends GeneratedMessageLite<CommonTypesProto$TriggerParam, Builder> implements MessageLiteOrBuilder {
    private static final CommonTypesProto$TriggerParam DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
    public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
    public static final int INT_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<CommonTypesProto$TriggerParam> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    private double doubleValue_;
    private float floatValue_;
    private long intValue_;
    private String name_ = BuildConfig.FLAVOR;
    private String stringValue_ = BuildConfig.FLAVOR;

    private CommonTypesProto$TriggerParam() {
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CommonTypesProto$TriggerParam, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CommonTypesProto$1 commonTypesProto$1) {
            this();
        }

        private Builder() {
            super(CommonTypesProto$TriggerParam.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CommonTypesProto$1 commonTypesProto$1 = null;
        switch (CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CommonTypesProto$TriggerParam();
            case 2:
                return new Builder(commonTypesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0001\u0005\u0000", new Object[]{"name_", "stringValue_", "intValue_", "floatValue_", "doubleValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommonTypesProto$TriggerParam> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CommonTypesProto$TriggerParam.class) {
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
        CommonTypesProto$TriggerParam commonTypesProto$TriggerParam = new CommonTypesProto$TriggerParam();
        DEFAULT_INSTANCE = commonTypesProto$TriggerParam;
        GeneratedMessageLite.registerDefaultInstance(CommonTypesProto$TriggerParam.class, commonTypesProto$TriggerParam);
    }
}
