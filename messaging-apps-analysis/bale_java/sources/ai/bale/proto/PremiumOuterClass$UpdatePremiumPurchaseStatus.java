package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$UpdatePremiumPurchaseStatus extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$UpdatePremiumPurchaseStatus DEFAULT_INSTANCE;
    public static final int FAILED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SUCCESSFUL_FIELD_NUMBER = 1;
    public static final int UNKNOWN_FIELD_NUMBER = 3;
    private int bitField0_;
    private BoolValue failed_;
    private BoolValue successful_;
    private BoolValue unknown_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$UpdatePremiumPurchaseStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$UpdatePremiumPurchaseStatus premiumOuterClass$UpdatePremiumPurchaseStatus = new PremiumOuterClass$UpdatePremiumPurchaseStatus();
        DEFAULT_INSTANCE = premiumOuterClass$UpdatePremiumPurchaseStatus;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$UpdatePremiumPurchaseStatus.class, premiumOuterClass$UpdatePremiumPurchaseStatus);
    }

    private PremiumOuterClass$UpdatePremiumPurchaseStatus() {
    }

    private void clearFailed() {
        this.failed_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSuccessful() {
        this.successful_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUnknown() {
        this.unknown_ = null;
        this.bitField0_ &= -5;
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFailed(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.failed_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.failed_ = boolValue;
        } else {
            this.failed_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.failed_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSuccessful(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.successful_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.successful_ = boolValue;
        } else {
            this.successful_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.successful_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeUnknown(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.unknown_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.unknown_ = boolValue;
        } else {
            this.unknown_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.unknown_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFailed(BoolValue boolValue) {
        boolValue.getClass();
        this.failed_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setSuccessful(BoolValue boolValue) {
        boolValue.getClass();
        this.successful_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setUnknown(BoolValue boolValue) {
        boolValue.getClass();
        this.unknown_ = boolValue;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$UpdatePremiumPurchaseStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "successful_", "failed_", "unknown_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$UpdatePremiumPurchaseStatus.class) {
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

    public BoolValue getFailed() {
        BoolValue boolValue = this.failed_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getSuccessful() {
        BoolValue boolValue = this.successful_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getUnknown() {
        BoolValue boolValue = this.unknown_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasFailed() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSuccessful() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUnknown() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(PremiumOuterClass$UpdatePremiumPurchaseStatus premiumOuterClass$UpdatePremiumPurchaseStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$UpdatePremiumPurchaseStatus);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(byte[] bArr) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$UpdatePremiumPurchaseStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$UpdatePremiumPurchaseStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
