package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.R60;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Microbanki$ResponseGetMoneyRequestDetails extends GeneratedMessageLite implements U64 {
    private static final Microbanki$ResponseGetMoneyRequestDetails DEFAULT_INSTANCE;
    public static final int LAST_PAY_DATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PAY_COUNT_FIELD_NUMBER = 2;
    public static final int RESPONSE_TYPE_FIELD_NUMBER = 4;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 1;
    private long lastPayDate_;
    private int payCount_;
    private int responseType_;
    private long totalAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Microbanki$ResponseGetMoneyRequestDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        Microbanki$ResponseGetMoneyRequestDetails microbanki$ResponseGetMoneyRequestDetails = new Microbanki$ResponseGetMoneyRequestDetails();
        DEFAULT_INSTANCE = microbanki$ResponseGetMoneyRequestDetails;
        GeneratedMessageLite.registerDefaultInstance(Microbanki$ResponseGetMoneyRequestDetails.class, microbanki$ResponseGetMoneyRequestDetails);
    }

    private Microbanki$ResponseGetMoneyRequestDetails() {
    }

    private void clearLastPayDate() {
        this.lastPayDate_ = 0L;
    }

    private void clearPayCount() {
        this.payCount_ = 0;
    }

    private void clearResponseType() {
        this.responseType_ = 0;
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    public static Microbanki$ResponseGetMoneyRequestDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseDelimitedFrom(InputStream inputStream) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(ByteBuffer byteBuffer) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastPayDate(long j) {
        this.lastPayDate_ = j;
    }

    private void setPayCount(int i) {
        this.payCount_ = i;
    }

    private void setResponseType(R60 r60) {
        this.responseType_ = r60.getNumber();
    }

    private void setResponseTypeValue(int i) {
        this.responseType_ = i;
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M0.a[gVar.ordinal()]) {
            case 1:
                return new Microbanki$ResponseGetMoneyRequestDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0002\u0004\f", new Object[]{"totalAmount_", "payCount_", "lastPayDate_", "responseType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Microbanki$ResponseGetMoneyRequestDetails.class) {
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

    public long getLastPayDate() {
        return this.lastPayDate_;
    }

    public int getPayCount() {
        return this.payCount_;
    }

    public R60 getResponseType() {
        R60 r60J = R60.j(this.responseType_);
        return r60J == null ? R60.UNRECOGNIZED : r60J;
    }

    public int getResponseTypeValue() {
        return this.responseType_;
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public static a newBuilder(Microbanki$ResponseGetMoneyRequestDetails microbanki$ResponseGetMoneyRequestDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(microbanki$ResponseGetMoneyRequestDetails);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(byte[] bArr) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(InputStream inputStream) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Microbanki$ResponseGetMoneyRequestDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Microbanki$ResponseGetMoneyRequestDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
