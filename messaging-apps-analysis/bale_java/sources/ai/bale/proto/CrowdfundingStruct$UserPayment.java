package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5318Iv1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CrowdfundingStruct$UserPayment extends GeneratedMessageLite implements InterfaceC5318Iv1 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final CrowdfundingStruct$UserPayment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_AMOUNT_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long date_;
    private long paymentAmount_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5318Iv1 {
        private a() {
            super(CrowdfundingStruct$UserPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        CrowdfundingStruct$UserPayment crowdfundingStruct$UserPayment = new CrowdfundingStruct$UserPayment();
        DEFAULT_INSTANCE = crowdfundingStruct$UserPayment;
        GeneratedMessageLite.registerDefaultInstance(CrowdfundingStruct$UserPayment.class, crowdfundingStruct$UserPayment);
    }

    private CrowdfundingStruct$UserPayment() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearPaymentAmount() {
        this.paymentAmount_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static CrowdfundingStruct$UserPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CrowdfundingStruct$UserPayment parseDelimitedFrom(InputStream inputStream) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(ByteBuffer byteBuffer) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setPaymentAmount(long j) {
        this.paymentAmount_ = j;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L.a[gVar.ordinal()]) {
            case 1:
                return new CrowdfundingStruct$UserPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"userId_", "paymentAmount_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CrowdfundingStruct$UserPayment.class) {
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

    public long getDate() {
        return this.date_;
    }

    public long getPaymentAmount() {
        return this.paymentAmount_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(CrowdfundingStruct$UserPayment crowdfundingStruct$UserPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(crowdfundingStruct$UserPayment);
    }

    public static CrowdfundingStruct$UserPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(byte[] bArr) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(InputStream inputStream) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CrowdfundingStruct$UserPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CrowdfundingStruct$UserPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
