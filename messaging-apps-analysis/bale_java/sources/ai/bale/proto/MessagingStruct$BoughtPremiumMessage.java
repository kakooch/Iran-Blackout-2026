package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BoughtPremiumMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$BoughtPremiumMessage DEFAULT_INSTANCE;
    public static final int ORIGINAL_MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$Message originalMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BoughtPremiumMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BoughtPremiumMessage messagingStruct$BoughtPremiumMessage = new MessagingStruct$BoughtPremiumMessage();
        DEFAULT_INSTANCE = messagingStruct$BoughtPremiumMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BoughtPremiumMessage.class, messagingStruct$BoughtPremiumMessage);
    }

    private MessagingStruct$BoughtPremiumMessage() {
    }

    private void clearOriginalMessage() {
        this.originalMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$BoughtPremiumMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BoughtPremiumMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOriginalMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.originalMessage_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BoughtPremiumMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "originalMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BoughtPremiumMessage.class) {
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

    public MessagingStruct$Message getOriginalMessage() {
        MessagingStruct$Message messagingStruct$Message = this.originalMessage_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public boolean hasOriginalMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$BoughtPremiumMessage messagingStruct$BoughtPremiumMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BoughtPremiumMessage);
    }

    public static MessagingStruct$BoughtPremiumMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BoughtPremiumMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BoughtPremiumMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
