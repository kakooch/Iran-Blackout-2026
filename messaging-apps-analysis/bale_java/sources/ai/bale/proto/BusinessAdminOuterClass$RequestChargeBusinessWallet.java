package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19695qn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestChargeBusinessWallet extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestChargeBusinessWallet DEFAULT_INSTANCE;
    public static final int DIFF_CREDIT_FIELD_NUMBER = 2;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TX_ACTION_FIELD_NUMBER = 3;
    private long diffCredit_;
    private int organizationId_;
    private int txAction_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestChargeBusinessWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestChargeBusinessWallet businessAdminOuterClass$RequestChargeBusinessWallet = new BusinessAdminOuterClass$RequestChargeBusinessWallet();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestChargeBusinessWallet;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestChargeBusinessWallet.class, businessAdminOuterClass$RequestChargeBusinessWallet);
    }

    private BusinessAdminOuterClass$RequestChargeBusinessWallet() {
    }

    private void clearDiffCredit() {
        this.diffCredit_ = 0L;
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    private void clearTxAction() {
        this.txAction_ = 0;
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiffCredit(long j) {
        this.diffCredit_ = j;
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    private void setTxAction(EnumC19695qn0 enumC19695qn0) {
        this.txAction_ = enumC19695qn0.getNumber();
    }

    private void setTxActionValue(int i) {
        this.txAction_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestChargeBusinessWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\f", new Object[]{"organizationId_", "diffCredit_", "txAction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestChargeBusinessWallet.class) {
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

    public long getDiffCredit() {
        return this.diffCredit_;
    }

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public EnumC19695qn0 getTxAction() {
        EnumC19695qn0 enumC19695qn0J = EnumC19695qn0.j(this.txAction_);
        return enumC19695qn0J == null ? EnumC19695qn0.UNRECOGNIZED : enumC19695qn0J;
    }

    public int getTxActionValue() {
        return this.txAction_;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestChargeBusinessWallet businessAdminOuterClass$RequestChargeBusinessWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestChargeBusinessWallet);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestChargeBusinessWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestChargeBusinessWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
