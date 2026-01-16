package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.S96;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SafirPanelMessageOuterClass$ResponseVerifySendMessage extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final SafirPanelMessageOuterClass$ResponseVerifySendMessage DEFAULT_INSTANCE;
    public static final int HAS_BALE_COUNT_FIELD_NUMBER = 1;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 5;
    public static final int ORDER_ID_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int TOTAL_PHONE_COUNT_FIELD_NUMBER = 3;
    public static final int WRONG_FORMATTED_ROWS_FIELD_NUMBER = 4;
    private long amount_;
    private int hasBaleCount_;
    private int messageType_;
    private int totalPhoneCount_;
    private int wrongFormattedRowsMemoizedSerializedSize = -1;
    private B.g wrongFormattedRows_ = GeneratedMessageLite.emptyIntList();
    private String orderId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$ResponseVerifySendMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$ResponseVerifySendMessage safirPanelMessageOuterClass$ResponseVerifySendMessage = new SafirPanelMessageOuterClass$ResponseVerifySendMessage();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$ResponseVerifySendMessage;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$ResponseVerifySendMessage.class, safirPanelMessageOuterClass$ResponseVerifySendMessage);
    }

    private SafirPanelMessageOuterClass$ResponseVerifySendMessage() {
    }

    private void addAllWrongFormattedRows(Iterable<? extends Integer> iterable) {
        ensureWrongFormattedRowsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.wrongFormattedRows_);
    }

    private void addWrongFormattedRows(int i) {
        ensureWrongFormattedRowsIsMutable();
        this.wrongFormattedRows_.b1(i);
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearHasBaleCount() {
        this.hasBaleCount_ = 0;
    }

    private void clearMessageType() {
        this.messageType_ = 0;
    }

    private void clearOrderId() {
        this.orderId_ = getDefaultInstance().getOrderId();
    }

    private void clearTotalPhoneCount() {
        this.totalPhoneCount_ = 0;
    }

    private void clearWrongFormattedRows() {
        this.wrongFormattedRows_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureWrongFormattedRowsIsMutable() {
        B.g gVar = this.wrongFormattedRows_;
        if (gVar.u()) {
            return;
        }
        this.wrongFormattedRows_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setHasBaleCount(int i) {
        this.hasBaleCount_ = i;
    }

    private void setMessageType(S96 s96) {
        this.messageType_ = s96.getNumber();
    }

    private void setMessageTypeValue(int i) {
        this.messageType_ = i;
    }

    private void setOrderId(String str) {
        str.getClass();
        this.orderId_ = str;
    }

    private void setOrderIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.orderId_ = abstractC2383g.f0();
    }

    private void setTotalPhoneCount(int i) {
        this.totalPhoneCount_ = i;
    }

    private void setWrongFormattedRows(int i, int i2) {
        ensureWrongFormattedRowsIsMutable();
        this.wrongFormattedRows_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$ResponseVerifySendMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0002\u0002\u0003\u0004\u0004'\u0005\f\u0006Ȉ", new Object[]{"hasBaleCount_", "amount_", "totalPhoneCount_", "wrongFormattedRows_", "messageType_", "orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$ResponseVerifySendMessage.class) {
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

    public int getHasBaleCount() {
        return this.hasBaleCount_;
    }

    public S96 getMessageType() {
        S96 s96J = S96.j(this.messageType_);
        return s96J == null ? S96.UNRECOGNIZED : s96J;
    }

    public int getMessageTypeValue() {
        return this.messageType_;
    }

    public String getOrderId() {
        return this.orderId_;
    }

    public AbstractC2383g getOrderIdBytes() {
        return AbstractC2383g.N(this.orderId_);
    }

    public int getTotalPhoneCount() {
        return this.totalPhoneCount_;
    }

    public int getWrongFormattedRows(int i) {
        return this.wrongFormattedRows_.getInt(i);
    }

    public int getWrongFormattedRowsCount() {
        return this.wrongFormattedRows_.size();
    }

    public List<Integer> getWrongFormattedRowsList() {
        return this.wrongFormattedRows_;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$ResponseVerifySendMessage safirPanelMessageOuterClass$ResponseVerifySendMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$ResponseVerifySendMessage);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$ResponseVerifySendMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseVerifySendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
