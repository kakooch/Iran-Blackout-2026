package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.T60;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankStruct$MoneyRequestPayment extends GeneratedMessageLite implements T60 {
    public static final int AMOUNT_FIELD_NUMBER = 6;
    public static final int DATE_FIELD_NUMBER = 7;
    private static final BankStruct$MoneyRequestPayment DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYER_USER_ID_FIELD_NUMBER = 8;
    public static final int RECEIPT_DATE_FIELD_NUMBER = 4;
    public static final int RECEIPT_PEER_FIELD_NUMBER = 2;
    public static final int RECEIPT_RANDOM_ID_FIELD_NUMBER = 3;
    public static final int TRACE_NUMBER_FIELD_NUMBER = 5;
    private long amount_;
    private int bitField0_;
    private long date_;
    private long id_;
    private int payerUserId_;
    private long receiptDate_;
    private PeersStruct$Peer receiptPeer_;
    private long receiptRandomId_;
    private long traceNumber_;

    public static final class a extends GeneratedMessageLite.b implements T60 {
        private a() {
            super(BankStruct$MoneyRequestPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment = new BankStruct$MoneyRequestPayment();
        DEFAULT_INSTANCE = bankStruct$MoneyRequestPayment;
        GeneratedMessageLite.registerDefaultInstance(BankStruct$MoneyRequestPayment.class, bankStruct$MoneyRequestPayment);
    }

    private BankStruct$MoneyRequestPayment() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearPayerUserId() {
        this.payerUserId_ = 0;
    }

    private void clearReceiptDate() {
        this.receiptDate_ = 0L;
    }

    private void clearReceiptPeer() {
        this.receiptPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReceiptRandomId() {
        this.receiptRandomId_ = 0L;
    }

    private void clearTraceNumber() {
        this.traceNumber_ = 0L;
    }

    public static BankStruct$MoneyRequestPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeReceiptPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.receiptPeer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.receiptPeer_ = peersStruct$Peer;
        } else {
            this.receiptPeer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.receiptPeer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankStruct$MoneyRequestPayment parseDelimitedFrom(InputStream inputStream) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(ByteBuffer byteBuffer) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setPayerUserId(int i) {
        this.payerUserId_ = i;
    }

    private void setReceiptDate(long j) {
        this.receiptDate_ = j;
    }

    private void setReceiptPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.receiptPeer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setReceiptRandomId(long j) {
        this.receiptRandomId_ = j;
    }

    private void setTraceNumber(long j) {
        this.traceNumber_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1879o.a[gVar.ordinal()]) {
            case 1:
                return new BankStruct$MoneyRequestPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000\u0003\u0002\u0004\u0002\u0005\u0002\u0006\u0002\u0007\u0002\b\u0004", new Object[]{"bitField0_", "id_", "receiptPeer_", "receiptRandomId_", "receiptDate_", "traceNumber_", "amount_", "date_", "payerUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankStruct$MoneyRequestPayment.class) {
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

    public long getDate() {
        return this.date_;
    }

    public long getId() {
        return this.id_;
    }

    public int getPayerUserId() {
        return this.payerUserId_;
    }

    public long getReceiptDate() {
        return this.receiptDate_;
    }

    public PeersStruct$Peer getReceiptPeer() {
        PeersStruct$Peer peersStruct$Peer = this.receiptPeer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getReceiptRandomId() {
        return this.receiptRandomId_;
    }

    public long getTraceNumber() {
        return this.traceNumber_;
    }

    public boolean hasReceiptPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankStruct$MoneyRequestPayment);
    }

    public static BankStruct$MoneyRequestPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(byte[] bArr) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(InputStream inputStream) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankStruct$MoneyRequestPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankStruct$MoneyRequestPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
