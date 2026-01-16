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
public final class MessagingStruct$ProtectedMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ProtectedMessage DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MessagingStruct$Message message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ProtectedMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ProtectedMessage messagingStruct$ProtectedMessage = new MessagingStruct$ProtectedMessage();
        DEFAULT_INSTANCE = messagingStruct$ProtectedMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ProtectedMessage.class, messagingStruct$ProtectedMessage);
    }

    private MessagingStruct$ProtectedMessage() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$ProtectedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 != null && messagingStruct$Message2 != MessagingStruct$Message.getDefaultInstance()) {
            messagingStruct$Message = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ProtectedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ProtectedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ProtectedMessage.class) {
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

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$ProtectedMessage messagingStruct$ProtectedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ProtectedMessage);
    }

    public static MessagingStruct$ProtectedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ProtectedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ProtectedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
