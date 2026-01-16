package ai.bale.proto;

import ai.bale.proto.MessagingStruct$AuthenticationButton;
import ai.bale.proto.MessagingStruct$CopyTextButton;
import ai.bale.proto.MessagingStruct$CustomAction;
import ai.bale.proto.MessagingStruct$LoginUrl;
import ai.bale.proto.MessagingStruct$SwitchInlineQueryChosenChat;
import ai.bale.proto.MessagingStruct$WebAppInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC6570Ob4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$InlineKeyboardButton extends GeneratedMessageLite implements InterfaceC6570Ob4 {
    public static final int AUTHENTICATION_FIELD_NUMBER = 10;
    public static final int CALLBACK_DATA_FIELD_NUMBER = 3;
    public static final int COPY_TEXT_FIELD_NUMBER = 9;
    public static final int CUSTOM_ACTION_FIELD_NUMBER = 11;
    private static final MessagingStruct$InlineKeyboardButton DEFAULT_INSTANCE;
    public static final int LOGIN_URL_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SEND_DATA_FIELD_NUMBER = 12;
    public static final int SWITCH_INLINE_QUERY_CHOSEN_CHAT_FIELD_NUMBER = 8;
    public static final int SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD_NUMBER = 7;
    public static final int SWITCH_INLINE_QUERY_FIELD_NUMBER = 6;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    public static final int WEB_APP_FIELD_NUMBER = 4;
    private MessagingStruct$AuthenticationButton authentication_;
    private int bitField0_;
    private StringValue callbackData_;
    private MessagingStruct$CopyTextButton copyText_;
    private MessagingStruct$CustomAction customAction_;
    private MessagingStruct$LoginUrl loginUrl_;
    private BoolValue sendData_;
    private MessagingStruct$SwitchInlineQueryChosenChat switchInlineQueryChosenChat_;
    private StringValue switchInlineQueryCurrentChat_;
    private StringValue switchInlineQuery_;
    private String text_ = "";
    private StringValue url_;
    private MessagingStruct$WebAppInfo webApp_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6570Ob4 {
        private a() {
            super(MessagingStruct$InlineKeyboardButton.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton = new MessagingStruct$InlineKeyboardButton();
        DEFAULT_INSTANCE = messagingStruct$InlineKeyboardButton;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$InlineKeyboardButton.class, messagingStruct$InlineKeyboardButton);
    }

    private MessagingStruct$InlineKeyboardButton() {
    }

    private void clearAuthentication() {
        this.authentication_ = null;
        this.bitField0_ &= -257;
    }

    private void clearCallbackData() {
        this.callbackData_ = null;
        this.bitField0_ &= -3;
    }

    private void clearCopyText() {
        this.copyText_ = null;
        this.bitField0_ &= -129;
    }

    private void clearCustomAction() {
        this.customAction_ = null;
        this.bitField0_ &= -513;
    }

    private void clearLoginUrl() {
        this.loginUrl_ = null;
        this.bitField0_ &= -9;
    }

    private void clearSendData() {
        this.sendData_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearSwitchInlineQuery() {
        this.switchInlineQuery_ = null;
        this.bitField0_ &= -17;
    }

    private void clearSwitchInlineQueryChosenChat() {
        this.switchInlineQueryChosenChat_ = null;
        this.bitField0_ &= -65;
    }

    private void clearSwitchInlineQueryCurrentChat() {
        this.switchInlineQueryCurrentChat_ = null;
        this.bitField0_ &= -33;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void clearUrl() {
        this.url_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWebApp() {
        this.webApp_ = null;
        this.bitField0_ &= -5;
    }

    public static MessagingStruct$InlineKeyboardButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAuthentication(MessagingStruct$AuthenticationButton messagingStruct$AuthenticationButton) {
        messagingStruct$AuthenticationButton.getClass();
        MessagingStruct$AuthenticationButton messagingStruct$AuthenticationButton2 = this.authentication_;
        if (messagingStruct$AuthenticationButton2 == null || messagingStruct$AuthenticationButton2 == MessagingStruct$AuthenticationButton.getDefaultInstance()) {
            this.authentication_ = messagingStruct$AuthenticationButton;
        } else {
            this.authentication_ = (MessagingStruct$AuthenticationButton) ((MessagingStruct$AuthenticationButton.a) MessagingStruct$AuthenticationButton.newBuilder(this.authentication_).v(messagingStruct$AuthenticationButton)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeCallbackData(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.callbackData_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.callbackData_ = stringValue;
        } else {
            this.callbackData_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.callbackData_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeCopyText(MessagingStruct$CopyTextButton messagingStruct$CopyTextButton) {
        messagingStruct$CopyTextButton.getClass();
        MessagingStruct$CopyTextButton messagingStruct$CopyTextButton2 = this.copyText_;
        if (messagingStruct$CopyTextButton2 == null || messagingStruct$CopyTextButton2 == MessagingStruct$CopyTextButton.getDefaultInstance()) {
            this.copyText_ = messagingStruct$CopyTextButton;
        } else {
            this.copyText_ = (MessagingStruct$CopyTextButton) ((MessagingStruct$CopyTextButton.a) MessagingStruct$CopyTextButton.newBuilder(this.copyText_).v(messagingStruct$CopyTextButton)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeCustomAction(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        messagingStruct$CustomAction.getClass();
        MessagingStruct$CustomAction messagingStruct$CustomAction2 = this.customAction_;
        if (messagingStruct$CustomAction2 == null || messagingStruct$CustomAction2 == MessagingStruct$CustomAction.getDefaultInstance()) {
            this.customAction_ = messagingStruct$CustomAction;
        } else {
            this.customAction_ = (MessagingStruct$CustomAction) ((MessagingStruct$CustomAction.a) MessagingStruct$CustomAction.newBuilder(this.customAction_).v(messagingStruct$CustomAction)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeLoginUrl(MessagingStruct$LoginUrl messagingStruct$LoginUrl) {
        messagingStruct$LoginUrl.getClass();
        MessagingStruct$LoginUrl messagingStruct$LoginUrl2 = this.loginUrl_;
        if (messagingStruct$LoginUrl2 == null || messagingStruct$LoginUrl2 == MessagingStruct$LoginUrl.getDefaultInstance()) {
            this.loginUrl_ = messagingStruct$LoginUrl;
        } else {
            this.loginUrl_ = (MessagingStruct$LoginUrl) ((MessagingStruct$LoginUrl.a) MessagingStruct$LoginUrl.newBuilder(this.loginUrl_).v(messagingStruct$LoginUrl)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeSendData(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.sendData_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.sendData_ = boolValue;
        } else {
            this.sendData_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.sendData_).v(boolValue)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeSwitchInlineQuery(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.switchInlineQuery_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.switchInlineQuery_ = stringValue;
        } else {
            this.switchInlineQuery_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.switchInlineQuery_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeSwitchInlineQueryChosenChat(MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat) {
        messagingStruct$SwitchInlineQueryChosenChat.getClass();
        MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat2 = this.switchInlineQueryChosenChat_;
        if (messagingStruct$SwitchInlineQueryChosenChat2 == null || messagingStruct$SwitchInlineQueryChosenChat2 == MessagingStruct$SwitchInlineQueryChosenChat.getDefaultInstance()) {
            this.switchInlineQueryChosenChat_ = messagingStruct$SwitchInlineQueryChosenChat;
        } else {
            this.switchInlineQueryChosenChat_ = (MessagingStruct$SwitchInlineQueryChosenChat) ((MessagingStruct$SwitchInlineQueryChosenChat.a) MessagingStruct$SwitchInlineQueryChosenChat.newBuilder(this.switchInlineQueryChosenChat_).v(messagingStruct$SwitchInlineQueryChosenChat)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeSwitchInlineQueryCurrentChat(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.switchInlineQueryCurrentChat_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.switchInlineQueryCurrentChat_ = stringValue;
        } else {
            this.switchInlineQueryCurrentChat_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.switchInlineQueryCurrentChat_).v(stringValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeUrl(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.url_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.url_ = stringValue;
        } else {
            this.url_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.url_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeWebApp(MessagingStruct$WebAppInfo messagingStruct$WebAppInfo) {
        messagingStruct$WebAppInfo.getClass();
        MessagingStruct$WebAppInfo messagingStruct$WebAppInfo2 = this.webApp_;
        if (messagingStruct$WebAppInfo2 == null || messagingStruct$WebAppInfo2 == MessagingStruct$WebAppInfo.getDefaultInstance()) {
            this.webApp_ = messagingStruct$WebAppInfo;
        } else {
            this.webApp_ = (MessagingStruct$WebAppInfo) ((MessagingStruct$WebAppInfo.a) MessagingStruct$WebAppInfo.newBuilder(this.webApp_).v(messagingStruct$WebAppInfo)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$InlineKeyboardButton parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAuthentication(MessagingStruct$AuthenticationButton messagingStruct$AuthenticationButton) {
        messagingStruct$AuthenticationButton.getClass();
        this.authentication_ = messagingStruct$AuthenticationButton;
        this.bitField0_ |= 256;
    }

    private void setCallbackData(StringValue stringValue) {
        stringValue.getClass();
        this.callbackData_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setCopyText(MessagingStruct$CopyTextButton messagingStruct$CopyTextButton) {
        messagingStruct$CopyTextButton.getClass();
        this.copyText_ = messagingStruct$CopyTextButton;
        this.bitField0_ |= 128;
    }

    private void setCustomAction(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        messagingStruct$CustomAction.getClass();
        this.customAction_ = messagingStruct$CustomAction;
        this.bitField0_ |= 512;
    }

    private void setLoginUrl(MessagingStruct$LoginUrl messagingStruct$LoginUrl) {
        messagingStruct$LoginUrl.getClass();
        this.loginUrl_ = messagingStruct$LoginUrl;
        this.bitField0_ |= 8;
    }

    private void setSendData(BoolValue boolValue) {
        boolValue.getClass();
        this.sendData_ = boolValue;
        this.bitField0_ |= 1024;
    }

    private void setSwitchInlineQuery(StringValue stringValue) {
        stringValue.getClass();
        this.switchInlineQuery_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setSwitchInlineQueryChosenChat(MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat) {
        messagingStruct$SwitchInlineQueryChosenChat.getClass();
        this.switchInlineQueryChosenChat_ = messagingStruct$SwitchInlineQueryChosenChat;
        this.bitField0_ |= 64;
    }

    private void setSwitchInlineQueryCurrentChat(StringValue stringValue) {
        stringValue.getClass();
        this.switchInlineQueryCurrentChat_ = stringValue;
        this.bitField0_ |= 32;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    private void setUrl(StringValue stringValue) {
        stringValue.getClass();
        this.url_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setWebApp(MessagingStruct$WebAppInfo messagingStruct$WebAppInfo) {
        messagingStruct$WebAppInfo.getClass();
        this.webApp_ = messagingStruct$WebAppInfo;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$InlineKeyboardButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004\u0007ဉ\u0005\bဉ\u0006\tဉ\u0007\nဉ\b\u000bဉ\t\fဉ\n", new Object[]{"bitField0_", "text_", "url_", "callbackData_", "webApp_", "loginUrl_", "switchInlineQuery_", "switchInlineQueryCurrentChat_", "switchInlineQueryChosenChat_", "copyText_", "authentication_", "customAction_", "sendData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$InlineKeyboardButton.class) {
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

    public MessagingStruct$AuthenticationButton getAuthentication() {
        MessagingStruct$AuthenticationButton messagingStruct$AuthenticationButton = this.authentication_;
        return messagingStruct$AuthenticationButton == null ? MessagingStruct$AuthenticationButton.getDefaultInstance() : messagingStruct$AuthenticationButton;
    }

    public StringValue getCallbackData() {
        StringValue stringValue = this.callbackData_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$CopyTextButton getCopyText() {
        MessagingStruct$CopyTextButton messagingStruct$CopyTextButton = this.copyText_;
        return messagingStruct$CopyTextButton == null ? MessagingStruct$CopyTextButton.getDefaultInstance() : messagingStruct$CopyTextButton;
    }

    public MessagingStruct$CustomAction getCustomAction() {
        MessagingStruct$CustomAction messagingStruct$CustomAction = this.customAction_;
        return messagingStruct$CustomAction == null ? MessagingStruct$CustomAction.getDefaultInstance() : messagingStruct$CustomAction;
    }

    public MessagingStruct$LoginUrl getLoginUrl() {
        MessagingStruct$LoginUrl messagingStruct$LoginUrl = this.loginUrl_;
        return messagingStruct$LoginUrl == null ? MessagingStruct$LoginUrl.getDefaultInstance() : messagingStruct$LoginUrl;
    }

    public BoolValue getSendData() {
        BoolValue boolValue = this.sendData_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getSwitchInlineQuery() {
        StringValue stringValue = this.switchInlineQuery_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$SwitchInlineQueryChosenChat getSwitchInlineQueryChosenChat() {
        MessagingStruct$SwitchInlineQueryChosenChat messagingStruct$SwitchInlineQueryChosenChat = this.switchInlineQueryChosenChat_;
        return messagingStruct$SwitchInlineQueryChosenChat == null ? MessagingStruct$SwitchInlineQueryChosenChat.getDefaultInstance() : messagingStruct$SwitchInlineQueryChosenChat;
    }

    public StringValue getSwitchInlineQueryCurrentChat() {
        StringValue stringValue = this.switchInlineQueryCurrentChat_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public StringValue getUrl() {
        StringValue stringValue = this.url_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$WebAppInfo getWebApp() {
        MessagingStruct$WebAppInfo messagingStruct$WebAppInfo = this.webApp_;
        return messagingStruct$WebAppInfo == null ? MessagingStruct$WebAppInfo.getDefaultInstance() : messagingStruct$WebAppInfo;
    }

    public boolean hasAuthentication() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasCallbackData() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasCopyText() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCustomAction() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasLoginUrl() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSendData() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasSwitchInlineQuery() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasSwitchInlineQueryChosenChat() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSwitchInlineQueryCurrentChat() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWebApp() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$InlineKeyboardButton);
    }

    public static MessagingStruct$InlineKeyboardButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(byte[] bArr) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(InputStream inputStream) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$InlineKeyboardButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$InlineKeyboardButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
