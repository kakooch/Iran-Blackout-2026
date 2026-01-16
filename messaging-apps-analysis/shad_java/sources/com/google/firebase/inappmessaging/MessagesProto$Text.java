package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$Text extends GeneratedMessageLite<MessagesProto$Text, Builder> implements MessageLiteOrBuilder {
    private static final MessagesProto$Text DEFAULT_INSTANCE;
    public static final int HEX_COLOR_FIELD_NUMBER = 2;
    private static volatile Parser<MessagesProto$Text> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String text_ = BuildConfig.FLAVOR;
    private String hexColor_ = BuildConfig.FLAVOR;

    private MessagesProto$Text() {
    }

    public String getText() {
        return this.text_;
    }

    public String getHexColor() {
        return this.hexColor_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$Text, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$Text.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$Text();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"text_", "hexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$Text> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$Text.class) {
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
        MessagesProto$Text messagesProto$Text = new MessagesProto$Text();
        DEFAULT_INSTANCE = messagesProto$Text;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$Text.class, messagesProto$Text);
    }

    public static MessagesProto$Text getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
