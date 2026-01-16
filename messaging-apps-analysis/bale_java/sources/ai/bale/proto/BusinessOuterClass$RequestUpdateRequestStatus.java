package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC3353An0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestUpdateRequestStatus extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestUpdateRequestStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REJECTION_REASON_FIELD_NUMBER = 3;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int REQUEST_STATUS_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue rejectionReason_;
    private int requestId_;
    private int requestStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestUpdateRequestStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestUpdateRequestStatus businessOuterClass$RequestUpdateRequestStatus = new BusinessOuterClass$RequestUpdateRequestStatus();
        DEFAULT_INSTANCE = businessOuterClass$RequestUpdateRequestStatus;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestUpdateRequestStatus.class, businessOuterClass$RequestUpdateRequestStatus);
    }

    private BusinessOuterClass$RequestUpdateRequestStatus() {
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    private void clearRequestStatus() {
        this.requestStatus_ = 0;
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus getDefaultInstance() {
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

    public static BusinessOuterClass$RequestUpdateRequestStatus parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRejectionReason(StringValue stringValue) {
        stringValue.getClass();
        this.rejectionReason_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    private void setRequestStatus(EnumC3353An0 enumC3353An0) {
        this.requestStatus_ = enumC3353An0.getNumber();
    }

    private void setRequestStatusValue(int i) {
        this.requestStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestUpdateRequestStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "requestId_", "requestStatus_", "rejectionReason_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestUpdateRequestStatus.class) {
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

    public StringValue getRejectionReason() {
        StringValue stringValue = this.rejectionReason_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public EnumC3353An0 getRequestStatus() {
        EnumC3353An0 enumC3353An0J = EnumC3353An0.j(this.requestStatus_);
        return enumC3353An0J == null ? EnumC3353An0.UNRECOGNIZED : enumC3353An0J;
    }

    public int getRequestStatusValue() {
        return this.requestStatus_;
    }

    public boolean hasRejectionReason() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$RequestUpdateRequestStatus businessOuterClass$RequestUpdateRequestStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestUpdateRequestStatus);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestUpdateRequestStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestUpdateRequestStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
