package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$BillOrderMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int BILL_ID_FIELD_NUMBER = 1;
    public static final int BILL_TYPE_FIELD_NUMBER = 6;
    public static final int CARD_ACQ_ID_FIELD_NUMBER = 5;
    private static final MessagingStruct$BillOrderMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAY_ID_FIELD_NUMBER = 2;
    public static final int TERMINAL_ID_FIELD_NUMBER = 4;
    private int amount_;
    private int billType_;
    private String billId_ = "";
    private String payId_ = "";
    private String terminalId_ = "";
    private String cardAcqId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$BillOrderMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$BillOrderMessage messagingStruct$BillOrderMessage = new MessagingStruct$BillOrderMessage();
        DEFAULT_INSTANCE = messagingStruct$BillOrderMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$BillOrderMessage.class, messagingStruct$BillOrderMessage);
    }

    private MessagingStruct$BillOrderMessage() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearBillId() {
        this.billId_ = getDefaultInstance().getBillId();
    }

    private void clearBillType() {
        this.billType_ = 0;
    }

    private void clearCardAcqId() {
        this.cardAcqId_ = getDefaultInstance().getCardAcqId();
    }

    private void clearPayId() {
        this.payId_ = getDefaultInstance().getPayId();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    public static MessagingStruct$BillOrderMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$BillOrderMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    private void setBillId(String str) {
        str.getClass();
        this.billId_ = str;
    }

    private void setBillIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.billId_ = abstractC2383g.f0();
    }

    private void setBillType(int i) {
        this.billType_ = i;
    }

    private void setCardAcqId(String str) {
        str.getClass();
        this.cardAcqId_ = str;
    }

    private void setCardAcqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardAcqId_ = abstractC2383g.f0();
    }

    private void setPayId(String str) {
        str.getClass();
        this.payId_ = str;
    }

    private void setPayIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.payId_ = abstractC2383g.f0();
    }

    private void setTerminalId(String str) {
        str.getClass();
        this.terminalId_ = str;
    }

    private void setTerminalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.terminalId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$BillOrderMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006\u0004", new Object[]{"billId_", "payId_", "amount_", "terminalId_", "cardAcqId_", "billType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$BillOrderMessage.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public String getBillId() {
        return this.billId_;
    }

    public AbstractC2383g getBillIdBytes() {
        return AbstractC2383g.N(this.billId_);
    }

    public int getBillType() {
        return this.billType_;
    }

    public String getCardAcqId() {
        return this.cardAcqId_;
    }

    public AbstractC2383g getCardAcqIdBytes() {
        return AbstractC2383g.N(this.cardAcqId_);
    }

    public String getPayId() {
        return this.payId_;
    }

    public AbstractC2383g getPayIdBytes() {
        return AbstractC2383g.N(this.payId_);
    }

    public String getTerminalId() {
        return this.terminalId_;
    }

    public AbstractC2383g getTerminalIdBytes() {
        return AbstractC2383g.N(this.terminalId_);
    }

    public static a newBuilder(MessagingStruct$BillOrderMessage messagingStruct$BillOrderMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$BillOrderMessage);
    }

    public static MessagingStruct$BillOrderMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$BillOrderMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$BillOrderMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
