package ai.bale.proto;

import ai.bale.proto.MessagingStruct$CustomAction;
import ai.bale.proto.MessagingStruct$KeyboardButtonPollType;
import ai.bale.proto.MessagingStruct$KeyboardButtonRequestChat;
import ai.bale.proto.MessagingStruct$KeyboardButtonRequestUser;
import ai.bale.proto.MessagingStruct$WebAppInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7287Rb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$KeyboardButton extends GeneratedMessageLite implements InterfaceC7287Rb4 {
    public static final int CUSTOM_ACTION_FIELD_NUMBER = 8;
    private static final MessagingStruct$KeyboardButton DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_CHAT_FIELD_NUMBER = 5;
    public static final int REQUEST_CONTACT_FIELD_NUMBER = 2;
    public static final int REQUEST_LOCATION_FIELD_NUMBER = 3;
    public static final int REQUEST_POLL_FIELD_NUMBER = 6;
    public static final int REQUEST_USER_FIELD_NUMBER = 4;
    public static final int SEND_MESSAGE_FIELD_NUMBER = 9;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int WEB_APP_FIELD_NUMBER = 7;
    private int bitField0_;
    private MessagingStruct$CustomAction customAction_;
    private MessagingStruct$KeyboardButtonRequestChat requestChat_;
    private BoolValue requestContact_;
    private BoolValue requestLocation_;
    private MessagingStruct$KeyboardButtonPollType requestPoll_;
    private MessagingStruct$KeyboardButtonRequestUser requestUser_;
    private BoolValue sendMessage_;
    private String text_ = "";
    private MessagingStruct$WebAppInfo webApp_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7287Rb4 {
        private a() {
            super(MessagingStruct$KeyboardButton.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$KeyboardButton messagingStruct$KeyboardButton = new MessagingStruct$KeyboardButton();
        DEFAULT_INSTANCE = messagingStruct$KeyboardButton;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$KeyboardButton.class, messagingStruct$KeyboardButton);
    }

    private MessagingStruct$KeyboardButton() {
    }

    private void clearCustomAction() {
        this.customAction_ = null;
        this.bitField0_ &= -129;
    }

    private void clearRequestChat() {
        this.requestChat_ = null;
        this.bitField0_ &= -17;
    }

    private void clearRequestContact() {
        this.requestContact_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRequestLocation() {
        this.requestLocation_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRequestPoll() {
        this.requestPoll_ = null;
        this.bitField0_ &= -33;
    }

    private void clearRequestUser() {
        this.requestUser_ = null;
        this.bitField0_ &= -9;
    }

    private void clearSendMessage() {
        this.sendMessage_ = null;
        this.bitField0_ &= -5;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void clearWebApp() {
        this.webApp_ = null;
        this.bitField0_ &= -65;
    }

    public static MessagingStruct$KeyboardButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCustomAction(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        messagingStruct$CustomAction.getClass();
        MessagingStruct$CustomAction messagingStruct$CustomAction2 = this.customAction_;
        if (messagingStruct$CustomAction2 == null || messagingStruct$CustomAction2 == MessagingStruct$CustomAction.getDefaultInstance()) {
            this.customAction_ = messagingStruct$CustomAction;
        } else {
            this.customAction_ = (MessagingStruct$CustomAction) ((MessagingStruct$CustomAction.a) MessagingStruct$CustomAction.newBuilder(this.customAction_).v(messagingStruct$CustomAction)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeRequestChat(MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat) {
        messagingStruct$KeyboardButtonRequestChat.getClass();
        MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat2 = this.requestChat_;
        if (messagingStruct$KeyboardButtonRequestChat2 == null || messagingStruct$KeyboardButtonRequestChat2 == MessagingStruct$KeyboardButtonRequestChat.getDefaultInstance()) {
            this.requestChat_ = messagingStruct$KeyboardButtonRequestChat;
        } else {
            this.requestChat_ = (MessagingStruct$KeyboardButtonRequestChat) ((MessagingStruct$KeyboardButtonRequestChat.a) MessagingStruct$KeyboardButtonRequestChat.newBuilder(this.requestChat_).v(messagingStruct$KeyboardButtonRequestChat)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeRequestContact(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.requestContact_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.requestContact_ = boolValue;
        } else {
            this.requestContact_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.requestContact_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRequestLocation(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.requestLocation_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.requestLocation_ = boolValue;
        } else {
            this.requestLocation_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.requestLocation_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeRequestPoll(MessagingStruct$KeyboardButtonPollType messagingStruct$KeyboardButtonPollType) {
        messagingStruct$KeyboardButtonPollType.getClass();
        MessagingStruct$KeyboardButtonPollType messagingStruct$KeyboardButtonPollType2 = this.requestPoll_;
        if (messagingStruct$KeyboardButtonPollType2 == null || messagingStruct$KeyboardButtonPollType2 == MessagingStruct$KeyboardButtonPollType.getDefaultInstance()) {
            this.requestPoll_ = messagingStruct$KeyboardButtonPollType;
        } else {
            this.requestPoll_ = (MessagingStruct$KeyboardButtonPollType) ((MessagingStruct$KeyboardButtonPollType.a) MessagingStruct$KeyboardButtonPollType.newBuilder(this.requestPoll_).v(messagingStruct$KeyboardButtonPollType)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeRequestUser(MessagingStruct$KeyboardButtonRequestUser messagingStruct$KeyboardButtonRequestUser) {
        messagingStruct$KeyboardButtonRequestUser.getClass();
        MessagingStruct$KeyboardButtonRequestUser messagingStruct$KeyboardButtonRequestUser2 = this.requestUser_;
        if (messagingStruct$KeyboardButtonRequestUser2 == null || messagingStruct$KeyboardButtonRequestUser2 == MessagingStruct$KeyboardButtonRequestUser.getDefaultInstance()) {
            this.requestUser_ = messagingStruct$KeyboardButtonRequestUser;
        } else {
            this.requestUser_ = (MessagingStruct$KeyboardButtonRequestUser) ((MessagingStruct$KeyboardButtonRequestUser.a) MessagingStruct$KeyboardButtonRequestUser.newBuilder(this.requestUser_).v(messagingStruct$KeyboardButtonRequestUser)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeSendMessage(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendMessage_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendMessage_ = boolValue;
        } else {
            this.sendMessage_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendMessage_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeWebApp(MessagingStruct$WebAppInfo messagingStruct$WebAppInfo) {
        messagingStruct$WebAppInfo.getClass();
        MessagingStruct$WebAppInfo messagingStruct$WebAppInfo2 = this.webApp_;
        if (messagingStruct$WebAppInfo2 == null || messagingStruct$WebAppInfo2 == MessagingStruct$WebAppInfo.getDefaultInstance()) {
            this.webApp_ = messagingStruct$WebAppInfo;
        } else {
            this.webApp_ = (MessagingStruct$WebAppInfo) ((MessagingStruct$WebAppInfo.a) MessagingStruct$WebAppInfo.newBuilder(this.webApp_).v(messagingStruct$WebAppInfo)).j();
        }
        this.bitField0_ |= 64;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$KeyboardButton parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$KeyboardButton parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCustomAction(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        messagingStruct$CustomAction.getClass();
        this.customAction_ = messagingStruct$CustomAction;
        this.bitField0_ |= 128;
    }

    private void setRequestChat(MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat) {
        messagingStruct$KeyboardButtonRequestChat.getClass();
        this.requestChat_ = messagingStruct$KeyboardButtonRequestChat;
        this.bitField0_ |= 16;
    }

    private void setRequestContact(BoolValue boolValue) {
        boolValue.getClass();
        this.requestContact_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setRequestLocation(BoolValue boolValue) {
        boolValue.getClass();
        this.requestLocation_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setRequestPoll(MessagingStruct$KeyboardButtonPollType messagingStruct$KeyboardButtonPollType) {
        messagingStruct$KeyboardButtonPollType.getClass();
        this.requestPoll_ = messagingStruct$KeyboardButtonPollType;
        this.bitField0_ |= 32;
    }

    private void setRequestUser(MessagingStruct$KeyboardButtonRequestUser messagingStruct$KeyboardButtonRequestUser) {
        messagingStruct$KeyboardButtonRequestUser.getClass();
        this.requestUser_ = messagingStruct$KeyboardButtonRequestUser;
        this.bitField0_ |= 8;
    }

    private void setSendMessage(BoolValue boolValue) {
        boolValue.getClass();
        this.sendMessage_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    private void setWebApp(MessagingStruct$WebAppInfo messagingStruct$WebAppInfo) {
        messagingStruct$WebAppInfo.getClass();
        this.webApp_ = messagingStruct$WebAppInfo;
        this.bitField0_ |= 64;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$KeyboardButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\u0002", new Object[]{"bitField0_", "text_", "requestContact_", "requestLocation_", "requestUser_", "requestChat_", "requestPoll_", "webApp_", "customAction_", "sendMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$KeyboardButton.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MessagingStruct$CustomAction getCustomAction() {
        MessagingStruct$CustomAction messagingStruct$CustomAction = this.customAction_;
        return messagingStruct$CustomAction == null ? MessagingStruct$CustomAction.getDefaultInstance() : messagingStruct$CustomAction;
    }

    public MessagingStruct$KeyboardButtonRequestChat getRequestChat() {
        MessagingStruct$KeyboardButtonRequestChat messagingStruct$KeyboardButtonRequestChat = this.requestChat_;
        return messagingStruct$KeyboardButtonRequestChat == null ? MessagingStruct$KeyboardButtonRequestChat.getDefaultInstance() : messagingStruct$KeyboardButtonRequestChat;
    }

    public BoolValue getRequestContact() {
        BoolValue boolValue = this.requestContact_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getRequestLocation() {
        BoolValue boolValue = this.requestLocation_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public MessagingStruct$KeyboardButtonPollType getRequestPoll() {
        MessagingStruct$KeyboardButtonPollType messagingStruct$KeyboardButtonPollType = this.requestPoll_;
        return messagingStruct$KeyboardButtonPollType == null ? MessagingStruct$KeyboardButtonPollType.getDefaultInstance() : messagingStruct$KeyboardButtonPollType;
    }

    public MessagingStruct$KeyboardButtonRequestUser getRequestUser() {
        MessagingStruct$KeyboardButtonRequestUser messagingStruct$KeyboardButtonRequestUser = this.requestUser_;
        return messagingStruct$KeyboardButtonRequestUser == null ? MessagingStruct$KeyboardButtonRequestUser.getDefaultInstance() : messagingStruct$KeyboardButtonRequestUser;
    }

    public BoolValue getSendMessage() {
        BoolValue boolValue = this.sendMessage_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public MessagingStruct$WebAppInfo getWebApp() {
        MessagingStruct$WebAppInfo messagingStruct$WebAppInfo = this.webApp_;
        return messagingStruct$WebAppInfo == null ? MessagingStruct$WebAppInfo.getDefaultInstance() : messagingStruct$WebAppInfo;
    }

    public boolean hasCustomAction() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasRequestChat() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasRequestContact() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRequestLocation() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRequestPoll() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasRequestUser() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSendMessage() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasWebApp() {
        return (this.bitField0_ & 64) != 0;
    }

    public static a newBuilder(MessagingStruct$KeyboardButton messagingStruct$KeyboardButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$KeyboardButton);
    }

    public static MessagingStruct$KeyboardButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$KeyboardButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$KeyboardButton parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$KeyboardButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$KeyboardButton parseFrom(byte[] bArr) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$KeyboardButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$KeyboardButton parseFrom(InputStream inputStream) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$KeyboardButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$KeyboardButton parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$KeyboardButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$KeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
