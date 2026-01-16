package ai.bale.proto;

import ai.bale.proto.MessagingStruct$BankEx;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BankMessage extends GeneratedMessageLite implements U64 {
    public static final int BANK_EX_FIELD_NUMBER = 1;
    private static final MessagingStruct$BankMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private MessagingStruct$BankEx bankEx_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BankMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BankMessage messagingStruct$BankMessage = new MessagingStruct$BankMessage();
        DEFAULT_INSTANCE = messagingStruct$BankMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BankMessage.class, messagingStruct$BankMessage);
    }

    private MessagingStruct$BankMessage() {
    }

    private void clearBankEx() {
        this.bankEx_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$BankMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBankEx(MessagingStruct$BankEx messagingStruct$BankEx) {
        messagingStruct$BankEx.getClass();
        MessagingStruct$BankEx messagingStruct$BankEx2 = this.bankEx_;
        if (messagingStruct$BankEx2 == null || messagingStruct$BankEx2 == MessagingStruct$BankEx.getDefaultInstance()) {
            this.bankEx_ = messagingStruct$BankEx;
        } else {
            this.bankEx_ = (MessagingStruct$BankEx) ((MessagingStruct$BankEx.a) MessagingStruct$BankEx.newBuilder(this.bankEx_).v(messagingStruct$BankEx)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BankMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankEx(MessagingStruct$BankEx messagingStruct$BankEx) {
        messagingStruct$BankEx.getClass();
        this.bankEx_ = messagingStruct$BankEx;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BankMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "bankEx_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BankMessage.class) {
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

    public MessagingStruct$BankEx getBankEx() {
        MessagingStruct$BankEx messagingStruct$BankEx = this.bankEx_;
        return messagingStruct$BankEx == null ? MessagingStruct$BankEx.getDefaultInstance() : messagingStruct$BankEx;
    }

    public boolean hasBankEx() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$BankMessage messagingStruct$BankMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BankMessage);
    }

    public static MessagingStruct$BankMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BankMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BankMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BankMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BankMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BankMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BankMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BankMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BankMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BankMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
