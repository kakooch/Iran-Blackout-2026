package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$RequestGetPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final BankOuterClass$RequestGetPaymentToken DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int MSG_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private Int32Value amount_;
    private int bitField0_;
    private StringValue description_;
    private MessagingStruct$HistoryMessageIdentifier msg_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Int32Value.b bVar) {
            q();
            ((BankOuterClass$RequestGetPaymentToken) this.b).setAmount((Int32Value) bVar.a());
            return this;
        }

        public a B(StringValue.b bVar) {
            q();
            ((BankOuterClass$RequestGetPaymentToken) this.b).setDescription((StringValue) bVar.a());
            return this;
        }

        public a C(MessagingStruct$HistoryMessageIdentifier.a aVar) {
            q();
            ((BankOuterClass$RequestGetPaymentToken) this.b).setMsg((MessagingStruct$HistoryMessageIdentifier) aVar.a());
            return this;
        }

        private a() {
            super(BankOuterClass$RequestGetPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetPaymentToken bankOuterClass$RequestGetPaymentToken = new BankOuterClass$RequestGetPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetPaymentToken.class, bankOuterClass$RequestGetPaymentToken);
    }

    private BankOuterClass$RequestGetPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMsg() {
        this.msg_ = null;
        this.bitField0_ &= -2;
    }

    public static BankOuterClass$RequestGetPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.amount_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.amount_ = int32Value;
        } else {
            this.amount_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.amount_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
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

    public static BankOuterClass$RequestGetPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(Int32Value int32Value) {
        int32Value.getClass();
        this.amount_ = int32Value;
        this.bitField0_ |= 4;
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "msg_", "description_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetPaymentToken.class) {
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

    public Int32Value getAmount() {
        Int32Value int32Value = this.amount_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$HistoryMessageIdentifier getMsg() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.msg_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMsg() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGetPaymentToken bankOuterClass$RequestGetPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetPaymentToken);
    }

    public static BankOuterClass$RequestGetPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
