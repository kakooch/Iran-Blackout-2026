package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC12479eh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestChangeStatusDialogAdOrder extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final AdvertisementOuterClass$RequestChangeStatusDialogAdOrder DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REJECTION_REASON_FIELD_NUMBER = 4;
    public static final int TARGET_STATUS_FIELD_NUMBER = 2;
    private int bitField0_;
    private long date_;
    private String id_ = "";
    private StringValue rejectionReason_;
    private int targetStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestChangeStatusDialogAdOrder advertisementOuterClass$RequestChangeStatusDialogAdOrder = new AdvertisementOuterClass$RequestChangeStatusDialogAdOrder();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestChangeStatusDialogAdOrder;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.class, advertisementOuterClass$RequestChangeStatusDialogAdOrder);
    }

    private AdvertisementOuterClass$RequestChangeStatusDialogAdOrder() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTargetStatus() {
        this.targetStatus_ = 0;
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRejectionReason(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.rejectionReason_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.rejectionReason_ = stringValue;
        } else {
            this.rejectionReason_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.rejectionReason_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setRejectionReason(StringValue stringValue) {
        stringValue.getClass();
        this.rejectionReason_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setTargetStatus(EnumC12479eh enumC12479eh) {
        this.targetStatus_ = enumC12479eh.getNumber();
    }

    private void setTargetStatusValue(int i) {
        this.targetStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestChangeStatusDialogAdOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0002\u0004ဉ\u0000", new Object[]{"bitField0_", "id_", "targetStatus_", "date_", "rejectionReason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public StringValue getRejectionReason() {
        StringValue stringValue = this.rejectionReason_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC12479eh getTargetStatus() {
        EnumC12479eh enumC12479ehJ = EnumC12479eh.j(this.targetStatus_);
        return enumC12479ehJ == null ? EnumC12479eh.UNRECOGNIZED : enumC12479ehJ;
    }

    public int getTargetStatusValue() {
        return this.targetStatus_;
    }

    public boolean hasRejectionReason() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestChangeStatusDialogAdOrder advertisementOuterClass$RequestChangeStatusDialogAdOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestChangeStatusDialogAdOrder);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestChangeStatusDialogAdOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
