package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$ModalMessage extends GeneratedMessageLite<MessagesProto$ModalMessage, Builder> implements MessageLiteOrBuilder {
    public static final int ACTION_BUTTON_FIELD_NUMBER = 4;
    public static final int ACTION_FIELD_NUMBER = 5;
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 6;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final MessagesProto$ModalMessage DEFAULT_INSTANCE;
    public static final int IMAGE_URL_FIELD_NUMBER = 3;
    private static volatile Parser<MessagesProto$ModalMessage> PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private MessagesProto$Button actionButton_;
    private MessagesProto$Action action_;
    private MessagesProto$Text body_;
    private MessagesProto$Text title_;
    private String imageUrl_ = BuildConfig.FLAVOR;
    private String backgroundHexColor_ = BuildConfig.FLAVOR;

    private MessagesProto$ModalMessage() {
    }

    public boolean hasTitle() {
        return this.title_ != null;
    }

    public MessagesProto$Text getTitle() {
        MessagesProto$Text messagesProto$Text = this.title_;
        return messagesProto$Text == null ? MessagesProto$Text.getDefaultInstance() : messagesProto$Text;
    }

    public boolean hasBody() {
        return this.body_ != null;
    }

    public MessagesProto$Text getBody() {
        MessagesProto$Text messagesProto$Text = this.body_;
        return messagesProto$Text == null ? MessagesProto$Text.getDefaultInstance() : messagesProto$Text;
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public MessagesProto$Button getActionButton() {
        MessagesProto$Button messagesProto$Button = this.actionButton_;
        return messagesProto$Button == null ? MessagesProto$Button.getDefaultInstance() : messagesProto$Button;
    }

    public boolean hasAction() {
        return this.action_ != null;
    }

    public MessagesProto$Action getAction() {
        MessagesProto$Action messagesProto$Action = this.action_;
        return messagesProto$Action == null ? MessagesProto$Action.getDefaultInstance() : messagesProto$Action;
    }

    public String getBackgroundHexColor() {
        return this.backgroundHexColor_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$ModalMessage, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$ModalMessage.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$ModalMessage();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ\u0004\t\u0005\t\u0006Ȉ", new Object[]{"title_", "body_", "imageUrl_", "actionButton_", "action_", "backgroundHexColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$ModalMessage> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$ModalMessage.class) {
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
        MessagesProto$ModalMessage messagesProto$ModalMessage = new MessagesProto$ModalMessage();
        DEFAULT_INSTANCE = messagesProto$ModalMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$ModalMessage.class, messagesProto$ModalMessage);
    }

    public static MessagesProto$ModalMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
