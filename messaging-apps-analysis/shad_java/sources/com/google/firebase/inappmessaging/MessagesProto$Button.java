package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$Button extends GeneratedMessageLite<MessagesProto$Button, Builder> implements MessageLiteOrBuilder {
    public static final int BUTTON_HEX_COLOR_FIELD_NUMBER = 2;
    private static final MessagesProto$Button DEFAULT_INSTANCE;
    private static volatile Parser<MessagesProto$Button> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String buttonHexColor_ = BuildConfig.FLAVOR;
    private MessagesProto$Text text_;

    private MessagesProto$Button() {
    }

    public boolean hasText() {
        return this.text_ != null;
    }

    public MessagesProto$Text getText() {
        MessagesProto$Text messagesProto$Text = this.text_;
        return messagesProto$Text == null ? MessagesProto$Text.getDefaultInstance() : messagesProto$Text;
    }

    public String getButtonHexColor() {
        return this.buttonHexColor_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$Button, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$Button.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$Button();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002Ȉ", new Object[]{"text_", "buttonHexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$Button> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$Button.class) {
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
        MessagesProto$Button messagesProto$Button = new MessagesProto$Button();
        DEFAULT_INSTANCE = messagesProto$Button;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$Button.class, messagesProto$Button);
    }

    public static MessagesProto$Button getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
