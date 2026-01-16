package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
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
public final class KifpoolOuterClass$RequestPurchaseMessageWithCharge extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CHARGEAMOUNT_FIELD_NUMBER = 5;
    private static final KifpoolOuterClass$RequestPurchaseMessageWithCharge DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int HISTORYID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private CollectionsStruct$Int64Value amount_;
    private int bitField0_;
    private long chargeAmount_;
    private StringValue description_;
    private MessagingStruct$HistoryMessageIdentifier historyId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestPurchaseMessageWithCharge.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestPurchaseMessageWithCharge kifpoolOuterClass$RequestPurchaseMessageWithCharge = new KifpoolOuterClass$RequestPurchaseMessageWithCharge();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestPurchaseMessageWithCharge;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestPurchaseMessageWithCharge.class, kifpoolOuterClass$RequestPurchaseMessageWithCharge);
    }

    private KifpoolOuterClass$RequestPurchaseMessageWithCharge() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -3;
    }

    private void clearChargeAmount() {
        this.chargeAmount_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -5;
    }

    private void clearHistoryId() {
        this.historyId_ = null;
        this.bitField0_ &= -2;
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.amount_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.amount_ = collectionsStruct$Int64Value;
        } else {
            this.amount_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.amount_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeHistoryId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.historyId_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.historyId_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.historyId_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.historyId_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.amount_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setChargeAmount(long j) {
        this.chargeAmount_ = j;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setHistoryId(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.historyId_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestPurchaseMessageWithCharge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u0002", new Object[]{"bitField0_", "historyId_", "amount_", "description_", "chargeAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestPurchaseMessageWithCharge.class) {
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

    public CollectionsStruct$Int64Value getAmount() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.amount_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public long getChargeAmount() {
        return this.chargeAmount_;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$HistoryMessageIdentifier getHistoryId() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.historyId_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasHistoryId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestPurchaseMessageWithCharge kifpoolOuterClass$RequestPurchaseMessageWithCharge) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestPurchaseMessageWithCharge);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestPurchaseMessageWithCharge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestPurchaseMessageWithCharge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
