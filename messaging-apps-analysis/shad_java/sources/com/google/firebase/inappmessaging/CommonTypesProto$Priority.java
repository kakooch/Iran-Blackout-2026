package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes3.dex */
public final class CommonTypesProto$Priority extends GeneratedMessageLite<CommonTypesProto$Priority, Builder> implements MessageLiteOrBuilder {
    private static final CommonTypesProto$Priority DEFAULT_INSTANCE;
    private static volatile Parser<CommonTypesProto$Priority> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    private CommonTypesProto$Priority() {
    }

    public int getValue() {
        return this.value_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CommonTypesProto$Priority, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(CommonTypesProto$1 commonTypesProto$1) {
            this();
        }

        private Builder() {
            super(CommonTypesProto$Priority.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        CommonTypesProto$1 commonTypesProto$1 = null;
        switch (CommonTypesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CommonTypesProto$Priority();
            case 2:
                return new Builder(commonTypesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommonTypesProto$Priority> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (CommonTypesProto$Priority.class) {
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
        CommonTypesProto$Priority commonTypesProto$Priority = new CommonTypesProto$Priority();
        DEFAULT_INSTANCE = commonTypesProto$Priority;
        GeneratedMessageLite.registerDefaultInstance(CommonTypesProto$Priority.class, commonTypesProto$Priority);
    }

    public static CommonTypesProto$Priority getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
