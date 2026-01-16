package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$Action extends GeneratedMessageLite<MessagesProto$Action, Builder> implements MessageLiteOrBuilder {
    public static final int ACTION_URL_FIELD_NUMBER = 1;
    private static final MessagesProto$Action DEFAULT_INSTANCE;
    private static volatile Parser<MessagesProto$Action> PARSER;
    private String actionUrl_ = BuildConfig.FLAVOR;

    private MessagesProto$Action() {
    }

    public String getActionUrl() {
        return this.actionUrl_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$Action, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$Action.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$Action();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"actionUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$Action> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$Action.class) {
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
        MessagesProto$Action messagesProto$Action = new MessagesProto$Action();
        DEFAULT_INSTANCE = messagesProto$Action;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$Action.class, messagesProto$Action);
    }

    public static MessagesProto$Action getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
