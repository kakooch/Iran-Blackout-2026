package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$ImageOnlyMessage extends GeneratedMessageLite<MessagesProto$ImageOnlyMessage, Builder> implements MessageLiteOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final MessagesProto$ImageOnlyMessage DEFAULT_INSTANCE;
    public static final int IMAGE_URL_FIELD_NUMBER = 1;
    private static volatile Parser<MessagesProto$ImageOnlyMessage> PARSER;
    private MessagesProto$Action action_;
    private String imageUrl_ = BuildConfig.FLAVOR;

    private MessagesProto$ImageOnlyMessage() {
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public boolean hasAction() {
        return this.action_ != null;
    }

    public MessagesProto$Action getAction() {
        MessagesProto$Action messagesProto$Action = this.action_;
        return messagesProto$Action == null ? MessagesProto$Action.getDefaultInstance() : messagesProto$Action;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$ImageOnlyMessage, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$ImageOnlyMessage.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$ImageOnlyMessage();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"imageUrl_", "action_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$ImageOnlyMessage> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$ImageOnlyMessage.class) {
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
        MessagesProto$ImageOnlyMessage messagesProto$ImageOnlyMessage = new MessagesProto$ImageOnlyMessage();
        DEFAULT_INSTANCE = messagesProto$ImageOnlyMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$ImageOnlyMessage.class, messagesProto$ImageOnlyMessage);
    }

    public static MessagesProto$ImageOnlyMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
