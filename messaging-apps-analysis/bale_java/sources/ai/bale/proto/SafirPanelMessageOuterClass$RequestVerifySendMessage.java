package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirPanelMessageOuterClass$RequestVerifySendMessage extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 3;
    private static final SafirPanelMessageOuterClass$RequestVerifySendMessage DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int ORDER_ID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBERS_FILE_LOCATION_FIELD_NUMBER = 1;
    private int bitField0_;
    private int botId_;
    private MessagingStruct$Message message_;
    private String orderId_ = "";
    private FilesStruct$FileLocation phoneNumbersFileLocation_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$RequestVerifySendMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$RequestVerifySendMessage safirPanelMessageOuterClass$RequestVerifySendMessage = new SafirPanelMessageOuterClass$RequestVerifySendMessage();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$RequestVerifySendMessage;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$RequestVerifySendMessage.class, safirPanelMessageOuterClass$RequestVerifySendMessage);
    }

    private SafirPanelMessageOuterClass$RequestVerifySendMessage() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOrderId() {
        this.orderId_ = getDefaultInstance().getOrderId();
    }

    private void clearPhoneNumbersFileLocation() {
        this.phoneNumbersFileLocation_ = null;
        this.bitField0_ &= -2;
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePhoneNumbersFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.phoneNumbersFileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.phoneNumbersFileLocation_ = filesStruct$FileLocation;
        } else {
            this.phoneNumbersFileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.phoneNumbersFileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setOrderId(String str) {
        str.getClass();
        this.orderId_ = str;
    }

    private void setOrderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.orderId_ = abstractC2383g.f0();
    }

    private void setPhoneNumbersFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.phoneNumbersFileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$RequestVerifySendMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0004\u0004Ȉ", new Object[]{"bitField0_", "phoneNumbersFileLocation_", "message_", "botId_", "orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$RequestVerifySendMessage.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public String getOrderId() {
        return this.orderId_;
    }

    public AbstractC2383g getOrderIdBytes() {
        return AbstractC2383g.N(this.orderId_);
    }

    public FilesStruct$FileLocation getPhoneNumbersFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.phoneNumbersFileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPhoneNumbersFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$RequestVerifySendMessage safirPanelMessageOuterClass$RequestVerifySendMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$RequestVerifySendMessage);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$RequestVerifySendMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$RequestVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
