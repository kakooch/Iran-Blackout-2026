package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public final class MessagesProto$CardMessage extends GeneratedMessageLite<MessagesProto$CardMessage, Builder> implements MessageLiteOrBuilder {
    public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
    public static final int BODY_FIELD_NUMBER = 2;
    private static final MessagesProto$CardMessage DEFAULT_INSTANCE;
    public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
    private static volatile Parser<MessagesProto$CardMessage> PARSER = null;
    public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
    public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
    public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
    public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
    public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
    public static final int TITLE_FIELD_NUMBER = 1;
    private MessagesProto$Text body_;
    private MessagesProto$Button primaryActionButton_;
    private MessagesProto$Action primaryAction_;
    private MessagesProto$Button secondaryActionButton_;
    private MessagesProto$Action secondaryAction_;
    private MessagesProto$Text title_;
    private String portraitImageUrl_ = BuildConfig.FLAVOR;
    private String landscapeImageUrl_ = BuildConfig.FLAVOR;
    private String backgroundHexColor_ = BuildConfig.FLAVOR;

    private MessagesProto$CardMessage() {
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

    public String getPortraitImageUrl() {
        return this.portraitImageUrl_;
    }

    public String getLandscapeImageUrl() {
        return this.landscapeImageUrl_;
    }

    public String getBackgroundHexColor() {
        return this.backgroundHexColor_;
    }

    public boolean hasPrimaryActionButton() {
        return this.primaryActionButton_ != null;
    }

    public MessagesProto$Button getPrimaryActionButton() {
        MessagesProto$Button messagesProto$Button = this.primaryActionButton_;
        return messagesProto$Button == null ? MessagesProto$Button.getDefaultInstance() : messagesProto$Button;
    }

    public boolean hasPrimaryAction() {
        return this.primaryAction_ != null;
    }

    public MessagesProto$Action getPrimaryAction() {
        MessagesProto$Action messagesProto$Action = this.primaryAction_;
        return messagesProto$Action == null ? MessagesProto$Action.getDefaultInstance() : messagesProto$Action;
    }

    public boolean hasSecondaryActionButton() {
        return this.secondaryActionButton_ != null;
    }

    public MessagesProto$Button getSecondaryActionButton() {
        MessagesProto$Button messagesProto$Button = this.secondaryActionButton_;
        return messagesProto$Button == null ? MessagesProto$Button.getDefaultInstance() : messagesProto$Button;
    }

    public boolean hasSecondaryAction() {
        return this.secondaryAction_ != null;
    }

    public MessagesProto$Action getSecondaryAction() {
        MessagesProto$Action messagesProto$Action = this.secondaryAction_;
        return messagesProto$Action == null ? MessagesProto$Action.getDefaultInstance() : messagesProto$Action;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$CardMessage, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$CardMessage.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$CardMessage();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\t\u0007\t\b\t\t\t", new Object[]{"title_", "body_", "portraitImageUrl_", "landscapeImageUrl_", "backgroundHexColor_", "primaryActionButton_", "primaryAction_", "secondaryActionButton_", "secondaryAction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$CardMessage> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$CardMessage.class) {
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
        MessagesProto$CardMessage messagesProto$CardMessage = new MessagesProto$CardMessage();
        DEFAULT_INSTANCE = messagesProto$CardMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$CardMessage.class, messagesProto$CardMessage);
    }

    public static MessagesProto$CardMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
