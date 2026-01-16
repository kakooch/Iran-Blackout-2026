package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6306Na4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BannedMessage extends GeneratedMessageLite implements U64 {
    public static final int BAN_REASON_FIELD_NUMBER = 1;
    private static final MessagingStruct$BannedMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int banReason_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BannedMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BannedMessage messagingStruct$BannedMessage = new MessagingStruct$BannedMessage();
        DEFAULT_INSTANCE = messagingStruct$BannedMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BannedMessage.class, messagingStruct$BannedMessage);
    }

    private MessagingStruct$BannedMessage() {
    }

    private void clearBanReason() {
        this.banReason_ = 0;
    }

    public static MessagingStruct$BannedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BannedMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BannedMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBanReason(EnumC6306Na4 enumC6306Na4) {
        this.banReason_ = enumC6306Na4.getNumber();
    }

    private void setBanReasonValue(int i) {
        this.banReason_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BannedMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"banReason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BannedMessage.class) {
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

    public EnumC6306Na4 getBanReason() {
        EnumC6306Na4 enumC6306Na4J = EnumC6306Na4.j(this.banReason_);
        return enumC6306Na4J == null ? EnumC6306Na4.UNRECOGNIZED : enumC6306Na4J;
    }

    public int getBanReasonValue() {
        return this.banReason_;
    }

    public static a newBuilder(MessagingStruct$BannedMessage messagingStruct$BannedMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BannedMessage);
    }

    public static MessagingStruct$BannedMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BannedMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BannedMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BannedMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BannedMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BannedMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BannedMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BannedMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BannedMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BannedMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BannedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
