package ai.bale.proto;

import ai.bale.proto.MessagingStruct$InlineKeyboardButtonMarkup;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ReplyKeyboardMarkup;
import ai.bale.proto.MessagingStruct$ReplyKeyboardRemove;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC3506Bd4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$TemplateMessage extends GeneratedMessageLite implements U64 {
    public static final int BTN_LIST_FIELD_NUMBER = 3;
    private static final MessagingStruct$TemplateMessage DEFAULT_INSTANCE;
    public static final int GENERAL_MESSAGE_FIELD_NUMBER = 1;
    public static final int INLINE_KEYBOARD_MARKUP_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int REPLY_KEYBOARD_MARKUP_FIELD_NUMBER = 6;
    public static final int REPLY_KEYBOARD_REMOVE_FIELD_NUMBER = 7;
    public static final int RESPONSE_TYPE_FIELD_NUMBER = 4;
    public static final int TEMPLATE_MESSAGE_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j btnList_ = GeneratedMessageLite.emptyProtobufList();
    private MessagingStruct$Message generalMessage_;
    private MessagingStruct$InlineKeyboardButtonMarkup inlineKeyboardMarkup_;
    private MessagingStruct$ReplyKeyboardMarkup replyKeyboardMarkup_;
    private MessagingStruct$ReplyKeyboardRemove replyKeyboardRemove_;
    private StringValue responseType_;
    private long templateMessageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$TemplateMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$TemplateMessage messagingStruct$TemplateMessage = new MessagingStruct$TemplateMessage();
        DEFAULT_INSTANCE = messagingStruct$TemplateMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$TemplateMessage.class, messagingStruct$TemplateMessage);
    }

    private MessagingStruct$TemplateMessage() {
    }

    private void addAllBtnList(Iterable<? extends MessagingStruct$TemplateMessageButton> iterable) {
        ensureBtnListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.btnList_);
    }

    private void addBtnList(MessagingStruct$TemplateMessageButton messagingStruct$TemplateMessageButton) {
        messagingStruct$TemplateMessageButton.getClass();
        ensureBtnListIsMutable();
        this.btnList_.add(messagingStruct$TemplateMessageButton);
    }

    private void clearBtnList() {
        this.btnList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGeneralMessage() {
        this.generalMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearInlineKeyboardMarkup() {
        this.inlineKeyboardMarkup_ = null;
        this.bitField0_ &= -5;
    }

    private void clearReplyKeyboardMarkup() {
        this.replyKeyboardMarkup_ = null;
        this.bitField0_ &= -9;
    }

    private void clearReplyKeyboardRemove() {
        this.replyKeyboardRemove_ = null;
        this.bitField0_ &= -17;
    }

    private void clearResponseType() {
        this.responseType_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTemplateMessageId() {
        this.templateMessageId_ = 0L;
    }

    private void ensureBtnListIsMutable() {
        B.j jVar = this.btnList_;
        if (jVar.u()) {
            return;
        }
        this.btnList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$TemplateMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGeneralMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.generalMessage_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.generalMessage_ = messagingStruct$Message;
        } else {
            this.generalMessage_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.generalMessage_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeInlineKeyboardMarkup(MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup) {
        messagingStruct$InlineKeyboardButtonMarkup.getClass();
        MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup2 = this.inlineKeyboardMarkup_;
        if (messagingStruct$InlineKeyboardButtonMarkup2 == null || messagingStruct$InlineKeyboardButtonMarkup2 == MessagingStruct$InlineKeyboardButtonMarkup.getDefaultInstance()) {
            this.inlineKeyboardMarkup_ = messagingStruct$InlineKeyboardButtonMarkup;
        } else {
            this.inlineKeyboardMarkup_ = (MessagingStruct$InlineKeyboardButtonMarkup) ((MessagingStruct$InlineKeyboardButtonMarkup.a) MessagingStruct$InlineKeyboardButtonMarkup.newBuilder(this.inlineKeyboardMarkup_).v(messagingStruct$InlineKeyboardButtonMarkup)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeReplyKeyboardMarkup(MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup) {
        messagingStruct$ReplyKeyboardMarkup.getClass();
        MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup2 = this.replyKeyboardMarkup_;
        if (messagingStruct$ReplyKeyboardMarkup2 == null || messagingStruct$ReplyKeyboardMarkup2 == MessagingStruct$ReplyKeyboardMarkup.getDefaultInstance()) {
            this.replyKeyboardMarkup_ = messagingStruct$ReplyKeyboardMarkup;
        } else {
            this.replyKeyboardMarkup_ = (MessagingStruct$ReplyKeyboardMarkup) ((MessagingStruct$ReplyKeyboardMarkup.a) MessagingStruct$ReplyKeyboardMarkup.newBuilder(this.replyKeyboardMarkup_).v(messagingStruct$ReplyKeyboardMarkup)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeReplyKeyboardRemove(MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove) {
        messagingStruct$ReplyKeyboardRemove.getClass();
        MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove2 = this.replyKeyboardRemove_;
        if (messagingStruct$ReplyKeyboardRemove2 == null || messagingStruct$ReplyKeyboardRemove2 == MessagingStruct$ReplyKeyboardRemove.getDefaultInstance()) {
            this.replyKeyboardRemove_ = messagingStruct$ReplyKeyboardRemove;
        } else {
            this.replyKeyboardRemove_ = (MessagingStruct$ReplyKeyboardRemove) ((MessagingStruct$ReplyKeyboardRemove.a) MessagingStruct$ReplyKeyboardRemove.newBuilder(this.replyKeyboardRemove_).v(messagingStruct$ReplyKeyboardRemove)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeResponseType(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.responseType_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.responseType_ = stringValue;
        } else {
            this.responseType_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.responseType_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$TemplateMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBtnList(int i) {
        ensureBtnListIsMutable();
        this.btnList_.remove(i);
    }

    private void setBtnList(int i, MessagingStruct$TemplateMessageButton messagingStruct$TemplateMessageButton) {
        messagingStruct$TemplateMessageButton.getClass();
        ensureBtnListIsMutable();
        this.btnList_.set(i, messagingStruct$TemplateMessageButton);
    }

    private void setGeneralMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.generalMessage_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setInlineKeyboardMarkup(MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup) {
        messagingStruct$InlineKeyboardButtonMarkup.getClass();
        this.inlineKeyboardMarkup_ = messagingStruct$InlineKeyboardButtonMarkup;
        this.bitField0_ |= 4;
    }

    private void setReplyKeyboardMarkup(MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup) {
        messagingStruct$ReplyKeyboardMarkup.getClass();
        this.replyKeyboardMarkup_ = messagingStruct$ReplyKeyboardMarkup;
        this.bitField0_ |= 8;
    }

    private void setReplyKeyboardRemove(MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove) {
        messagingStruct$ReplyKeyboardRemove.getClass();
        this.replyKeyboardRemove_ = messagingStruct$ReplyKeyboardRemove;
        this.bitField0_ |= 16;
    }

    private void setResponseType(StringValue stringValue) {
        stringValue.getClass();
        this.responseType_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setTemplateMessageId(long j) {
        this.templateMessageId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$TemplateMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u001b\u0004ဉ\u0001\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဉ\u0004", new Object[]{"bitField0_", "generalMessage_", "templateMessageId_", "btnList_", MessagingStruct$TemplateMessageButton.class, "responseType_", "inlineKeyboardMarkup_", "replyKeyboardMarkup_", "replyKeyboardRemove_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$TemplateMessage.class) {
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

    public MessagingStruct$TemplateMessageButton getBtnList(int i) {
        return (MessagingStruct$TemplateMessageButton) this.btnList_.get(i);
    }

    public int getBtnListCount() {
        return this.btnList_.size();
    }

    public List<MessagingStruct$TemplateMessageButton> getBtnListList() {
        return this.btnList_;
    }

    public InterfaceC3506Bd4 getBtnListOrBuilder(int i) {
        return (InterfaceC3506Bd4) this.btnList_.get(i);
    }

    public List<? extends InterfaceC3506Bd4> getBtnListOrBuilderList() {
        return this.btnList_;
    }

    public MessagingStruct$Message getGeneralMessage() {
        MessagingStruct$Message messagingStruct$Message = this.generalMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public MessagingStruct$InlineKeyboardButtonMarkup getInlineKeyboardMarkup() {
        MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup = this.inlineKeyboardMarkup_;
        return messagingStruct$InlineKeyboardButtonMarkup == null ? MessagingStruct$InlineKeyboardButtonMarkup.getDefaultInstance() : messagingStruct$InlineKeyboardButtonMarkup;
    }

    public MessagingStruct$ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup = this.replyKeyboardMarkup_;
        return messagingStruct$ReplyKeyboardMarkup == null ? MessagingStruct$ReplyKeyboardMarkup.getDefaultInstance() : messagingStruct$ReplyKeyboardMarkup;
    }

    public MessagingStruct$ReplyKeyboardRemove getReplyKeyboardRemove() {
        MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove = this.replyKeyboardRemove_;
        return messagingStruct$ReplyKeyboardRemove == null ? MessagingStruct$ReplyKeyboardRemove.getDefaultInstance() : messagingStruct$ReplyKeyboardRemove;
    }

    public StringValue getResponseType() {
        StringValue stringValue = this.responseType_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getTemplateMessageId() {
        return this.templateMessageId_;
    }

    public boolean hasGeneralMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasInlineKeyboardMarkup() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasReplyKeyboardMarkup() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasReplyKeyboardRemove() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasResponseType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingStruct$TemplateMessage messagingStruct$TemplateMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$TemplateMessage);
    }

    public static MessagingStruct$TemplateMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$TemplateMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBtnList(int i, MessagingStruct$TemplateMessageButton messagingStruct$TemplateMessageButton) {
        messagingStruct$TemplateMessageButton.getClass();
        ensureBtnListIsMutable();
        this.btnList_.add(i, messagingStruct$TemplateMessageButton);
    }

    public static MessagingStruct$TemplateMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$TemplateMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$TemplateMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$TemplateMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$TemplateMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$TemplateMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$TemplateMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$TemplateMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
