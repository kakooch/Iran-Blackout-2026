package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$NasimEncryptedMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$NasimEncryptedMessage DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int MESSAGE_LENGTH_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SIGNATURE_FIELD_NUMBER = 4;
    private AbstractC2383g key_;
    private int messageLength_;
    private AbstractC2383g message_;
    private AbstractC2383g signature_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$NasimEncryptedMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$NasimEncryptedMessage messagingStruct$NasimEncryptedMessage = new MessagingStruct$NasimEncryptedMessage();
        DEFAULT_INSTANCE = messagingStruct$NasimEncryptedMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$NasimEncryptedMessage.class, messagingStruct$NasimEncryptedMessage);
    }

    private MessagingStruct$NasimEncryptedMessage() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.key_ = abstractC2383g;
        this.message_ = abstractC2383g;
        this.signature_ = abstractC2383g;
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    private void clearMessageLength() {
        this.messageLength_ = 0;
    }

    private void clearSignature() {
        this.signature_ = getDefaultInstance().getSignature();
    }

    public static MessagingStruct$NasimEncryptedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$NasimEncryptedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.key_ = abstractC2383g;
    }

    private void setMessage(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.message_ = abstractC2383g;
    }

    private void setMessageLength(int i) {
        this.messageLength_ = i;
    }

    private void setSignature(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.signature_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$NasimEncryptedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0002\n\u0003\u0004\u0004\n", new Object[]{"key_", "message_", "messageLength_", "signature_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$NasimEncryptedMessage.class) {
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

    public AbstractC2383g getKey() {
        return this.key_;
    }

    public AbstractC2383g getMessage() {
        return this.message_;
    }

    public int getMessageLength() {
        return this.messageLength_;
    }

    public AbstractC2383g getSignature() {
        return this.signature_;
    }

    public static a newBuilder(MessagingStruct$NasimEncryptedMessage messagingStruct$NasimEncryptedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$NasimEncryptedMessage);
    }

    public static MessagingStruct$NasimEncryptedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$NasimEncryptedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$NasimEncryptedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
