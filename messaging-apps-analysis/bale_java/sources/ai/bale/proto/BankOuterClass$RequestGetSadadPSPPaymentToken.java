package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
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
public final class BankOuterClass$RequestGetSadadPSPPaymentToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$RequestGetSadadPSPPaymentToken DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int MSG_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_AMOUNT_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue description_;
    private MessagingStruct$HistoryMessageIdentifier msg_;
    private long paymentAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((BankOuterClass$RequestGetSadadPSPPaymentToken) this.b).setDescription(stringValue);
            return this;
        }

        public a B(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((BankOuterClass$RequestGetSadadPSPPaymentToken) this.b).setMsg(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        public a C(long j) {
            q();
            ((BankOuterClass$RequestGetSadadPSPPaymentToken) this.b).setPaymentAmount(j);
            return this;
        }

        private a() {
            super(BankOuterClass$RequestGetSadadPSPPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetSadadPSPPaymentToken bankOuterClass$RequestGetSadadPSPPaymentToken = new BankOuterClass$RequestGetSadadPSPPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetSadadPSPPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetSadadPSPPaymentToken.class, bankOuterClass$RequestGetSadadPSPPaymentToken);
    }

    private BankOuterClass$RequestGetSadadPSPPaymentToken() {
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMsg() {
        this.msg_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPaymentAmount() {
        this.paymentAmount_ = 0L;
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.msg_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.msg_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.msg_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.msg_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.msg_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaymentAmount(long j) {
        this.paymentAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetSadadPSPPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001", new Object[]{"bitField0_", "msg_", "paymentAmount_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetSadadPSPPaymentToken.class) {
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

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$HistoryMessageIdentifier getMsg() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.msg_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public long getPaymentAmount() {
        return this.paymentAmount_;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMsg() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGetSadadPSPPaymentToken bankOuterClass$RequestGetSadadPSPPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetSadadPSPPaymentToken);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetSadadPSPPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
