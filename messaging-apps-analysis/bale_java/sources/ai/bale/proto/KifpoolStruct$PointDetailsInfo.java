package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC10586br3;
import ir.nasim.InterfaceC11970dr3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$PointDetailsInfo extends GeneratedMessageLite implements InterfaceC11970dr3 {
    public static final int CAMPAIGN_NAME_FIELD_NUMBER = 3;
    private static final KifpoolStruct$PointDetailsInfo DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 7;
    public static final int OP_TYPE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int POINT_FIELD_NUMBER = 4;
    public static final int PROCESS_NAME_FIELD_NUMBER = 6;
    public static final int TRANSACTION_DATE_TIME_FIELD_NUMBER = 1;
    public static final int TRANSACTION_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String campaignName_ = "";
    private StringValue description_;
    private int opType_;
    private long point_;
    private StringValue processName_;
    private long transactionDateTime_;
    private int transactionType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11970dr3 {
        private a() {
            super(KifpoolStruct$PointDetailsInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$PointDetailsInfo kifpoolStruct$PointDetailsInfo = new KifpoolStruct$PointDetailsInfo();
        DEFAULT_INSTANCE = kifpoolStruct$PointDetailsInfo;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$PointDetailsInfo.class, kifpoolStruct$PointDetailsInfo);
    }

    private KifpoolStruct$PointDetailsInfo() {
    }

    private void clearCampaignName() {
        this.campaignName_ = getDefaultInstance().getCampaignName();
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOpType() {
        this.opType_ = 0;
    }

    private void clearPoint() {
        this.point_ = 0L;
    }

    private void clearProcessName() {
        this.processName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionDateTime() {
        this.transactionDateTime_ = 0L;
    }

    private void clearTransactionType() {
        this.transactionType_ = 0;
    }

    public static KifpoolStruct$PointDetailsInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeProcessName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.processName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.processName_ = stringValue;
        } else {
            this.processName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.processName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$PointDetailsInfo parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCampaignName(String str) {
        str.getClass();
        this.campaignName_ = str;
    }

    private void setCampaignNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.campaignName_ = abstractC2383g.f0();
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setOpType(EnumC10586br3 enumC10586br3) {
        this.opType_ = enumC10586br3.getNumber();
    }

    private void setOpTypeValue(int i) {
        this.opType_ = i;
    }

    private void setPoint(long j) {
        this.point_ = j;
    }

    private void setProcessName(StringValue stringValue) {
        stringValue.getClass();
        this.processName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setTransactionDateTime(long j) {
        this.transactionDateTime_ = j;
    }

    private void setTransactionType(int i) {
        this.transactionType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1900v0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolStruct$PointDetailsInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003Ȉ\u0004\u0002\u0005\f\u0006ဉ\u0000\u0007ဉ\u0001", new Object[]{"bitField0_", "transactionDateTime_", "transactionType_", "campaignName_", "point_", "opType_", "processName_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$PointDetailsInfo.class) {
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

    public String getCampaignName() {
        return this.campaignName_;
    }

    public AbstractC2383g getCampaignNameBytes() {
        return AbstractC2383g.N(this.campaignName_);
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC10586br3 getOpType() {
        EnumC10586br3 enumC10586br3J = EnumC10586br3.j(this.opType_);
        return enumC10586br3J == null ? EnumC10586br3.UNRECOGNIZED : enumC10586br3J;
    }

    public int getOpTypeValue() {
        return this.opType_;
    }

    public long getPoint() {
        return this.point_;
    }

    public StringValue getProcessName() {
        StringValue stringValue = this.processName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getTransactionDateTime() {
        return this.transactionDateTime_;
    }

    public int getTransactionType() {
        return this.transactionType_;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasProcessName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolStruct$PointDetailsInfo kifpoolStruct$PointDetailsInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$PointDetailsInfo);
    }

    public static KifpoolStruct$PointDetailsInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(byte[] bArr) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(InputStream inputStream) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$PointDetailsInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$PointDetailsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
