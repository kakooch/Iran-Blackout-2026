package com.google.firebase.inappmessaging;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes3.dex */
public final class MessagesProto$Content extends GeneratedMessageLite<MessagesProto$Content, Builder> implements MessageLiteOrBuilder {
    public static final int BANNER_FIELD_NUMBER = 1;
    public static final int CARD_FIELD_NUMBER = 4;
    private static final MessagesProto$Content DEFAULT_INSTANCE;
    public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
    public static final int MODAL_FIELD_NUMBER = 2;
    private static volatile Parser<MessagesProto$Content> PARSER;
    private int messageDetailsCase_ = 0;
    private Object messageDetails_;

    private MessagesProto$Content() {
    }

    public enum MessageDetailsCase {
        BANNER(1),
        MODAL(2),
        IMAGE_ONLY(3),
        CARD(4),
        MESSAGEDETAILS_NOT_SET(0);

        MessageDetailsCase(int i) {
        }

        public static MessageDetailsCase forNumber(int i) {
            if (i == 0) {
                return MESSAGEDETAILS_NOT_SET;
            }
            if (i == 1) {
                return BANNER;
            }
            if (i == 2) {
                return MODAL;
            }
            if (i == 3) {
                return IMAGE_ONLY;
            }
            if (i != 4) {
                return null;
            }
            return CARD;
        }
    }

    public MessageDetailsCase getMessageDetailsCase() {
        return MessageDetailsCase.forNumber(this.messageDetailsCase_);
    }

    public MessagesProto$BannerMessage getBanner() {
        if (this.messageDetailsCase_ == 1) {
            return (MessagesProto$BannerMessage) this.messageDetails_;
        }
        return MessagesProto$BannerMessage.getDefaultInstance();
    }

    public MessagesProto$ModalMessage getModal() {
        if (this.messageDetailsCase_ == 2) {
            return (MessagesProto$ModalMessage) this.messageDetails_;
        }
        return MessagesProto$ModalMessage.getDefaultInstance();
    }

    public MessagesProto$ImageOnlyMessage getImageOnly() {
        if (this.messageDetailsCase_ == 3) {
            return (MessagesProto$ImageOnlyMessage) this.messageDetails_;
        }
        return MessagesProto$ImageOnlyMessage.getDefaultInstance();
    }

    public MessagesProto$CardMessage getCard() {
        if (this.messageDetailsCase_ == 4) {
            return (MessagesProto$CardMessage) this.messageDetails_;
        }
        return MessagesProto$CardMessage.getDefaultInstance();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<MessagesProto$Content, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(MessagesProto$1 messagesProto$1) {
            this();
        }

        private Builder() {
            super(MessagesProto$Content.DEFAULT_INSTANCE);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        MessagesProto$1 messagesProto$1 = null;
        switch (MessagesProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MessagesProto$Content();
            case 2:
                return new Builder(messagesProto$1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"messageDetails_", "messageDetailsCase_", MessagesProto$BannerMessage.class, MessagesProto$ModalMessage.class, MessagesProto$ImageOnlyMessage.class, MessagesProto$CardMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MessagesProto$Content> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (MessagesProto$Content.class) {
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
        MessagesProto$Content messagesProto$Content = new MessagesProto$Content();
        DEFAULT_INSTANCE = messagesProto$Content;
        GeneratedMessageLite.registerDefaultInstance(MessagesProto$Content.class, messagesProto$Content);
    }

    public static MessagesProto$Content getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
