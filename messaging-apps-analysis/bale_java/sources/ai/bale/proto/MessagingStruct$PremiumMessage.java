package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$PremiumMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final MessagingStruct$PremiumMessage DEFAULT_INSTANCE;
    public static final int FILE_MIME_TYPE_FIELD_NUMBER = 5;
    public static final int ORIGINAL_MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PREVIEW_FIELD_NUMBER = 4;
    public static final int TARGET_WALLET_ID_FIELD_NUMBER = 2;
    private long amount_;
    private int bitField0_;
    private StringValue fileMimeType_;
    private MessagingStruct$Message originalMessage_;
    private MessagingStruct$Message preview_;
    private String targetWalletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$PremiumMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$PremiumMessage messagingStruct$PremiumMessage = new MessagingStruct$PremiumMessage();
        DEFAULT_INSTANCE = messagingStruct$PremiumMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$PremiumMessage.class, messagingStruct$PremiumMessage);
    }

    private MessagingStruct$PremiumMessage() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearFileMimeType() {
        this.fileMimeType_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOriginalMessage() {
        this.originalMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPreview() {
        this.preview_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTargetWalletId() {
        this.targetWalletId_ = getDefaultInstance().getTargetWalletId();
    }

    public static MessagingStruct$PremiumMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFileMimeType(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.fileMimeType_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.fileMimeType_ = stringValue;
        } else {
            this.fileMimeType_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.fileMimeType_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeOriginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.originalMessage_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.originalMessage_ = messagingStruct$Message;
        } else {
            this.originalMessage_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.originalMessage_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePreview(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.preview_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.preview_ = messagingStruct$Message;
        } else {
            this.preview_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.preview_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$PremiumMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PremiumMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setFileMimeType(StringValue stringValue) {
        stringValue.getClass();
        this.fileMimeType_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setOriginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.originalMessage_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setPreview(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.preview_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setTargetWalletId(String str) {
        str.getClass();
        this.targetWalletId_ = str;
    }

    private void setTargetWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.targetWalletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$PremiumMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "amount_", "targetWalletId_", "originalMessage_", "preview_", "fileMimeType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$PremiumMessage.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public StringValue getFileMimeType() {
        StringValue stringValue = this.fileMimeType_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$Message getOriginalMessage() {
        MessagingStruct$Message messagingStruct$Message = this.originalMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public MessagingStruct$Message getPreview() {
        MessagingStruct$Message messagingStruct$Message = this.preview_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public String getTargetWalletId() {
        return this.targetWalletId_;
    }

    public AbstractC2383g getTargetWalletIdBytes() {
        return AbstractC2383g.N(this.targetWalletId_);
    }

    public boolean hasFileMimeType() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOriginalMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPreview() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingStruct$PremiumMessage messagingStruct$PremiumMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$PremiumMessage);
    }

    public static MessagingStruct$PremiumMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PremiumMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$PremiumMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$PremiumMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$PremiumMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$PremiumMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$PremiumMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PremiumMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PremiumMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$PremiumMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$PremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
