package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Crowdfunding$ResponseGetTotalPaidAmount extends GeneratedMessageLite implements U64 {
    public static final int CREATOR_USER_ID_FIELD_NUMBER = 2;
    private static final Crowdfunding$ResponseGetTotalPaidAmount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOTAL_PAID_AMOUNT_FIELD_NUMBER = 1;
    private int creatorUserId_;
    private long totalPaidAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Crowdfunding$ResponseGetTotalPaidAmount.DEFAULT_INSTANCE);
        }
    }

    static {
        Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount = new Crowdfunding$ResponseGetTotalPaidAmount();
        DEFAULT_INSTANCE = crowdfunding$ResponseGetTotalPaidAmount;
        GeneratedMessageLite.registerDefaultInstance(Crowdfunding$ResponseGetTotalPaidAmount.class, crowdfunding$ResponseGetTotalPaidAmount);
    }

    private Crowdfunding$ResponseGetTotalPaidAmount() {
    }

    private void clearCreatorUserId() {
        this.creatorUserId_ = 0;
    }

    private void clearTotalPaidAmount() {
        this.totalPaidAmount_ = 0L;
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseDelimitedFrom(InputStream inputStream) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(ByteBuffer byteBuffer) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreatorUserId(int i) {
        this.creatorUserId_ = i;
    }

    private void setTotalPaidAmount(long j) {
        this.totalPaidAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K.a[gVar.ordinal()]) {
            case 1:
                return new Crowdfunding$ResponseGetTotalPaidAmount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"totalPaidAmount_", "creatorUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Crowdfunding$ResponseGetTotalPaidAmount.class) {
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

    public int getCreatorUserId() {
        return this.creatorUserId_;
    }

    public long getTotalPaidAmount() {
        return this.totalPaidAmount_;
    }

    public static a newBuilder(Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount) {
        return (a) DEFAULT_INSTANCE.createBuilder(crowdfunding$ResponseGetTotalPaidAmount);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(AbstractC2383g abstractC2383g) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(byte[] bArr) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(byte[] bArr, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(InputStream inputStream) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(AbstractC2384h abstractC2384h) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Crowdfunding$ResponseGetTotalPaidAmount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Crowdfunding$ResponseGetTotalPaidAmount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
