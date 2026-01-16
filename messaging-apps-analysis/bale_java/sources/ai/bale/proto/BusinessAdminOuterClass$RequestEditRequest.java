package ai.bale.proto;

import ai.bale.proto.BusinessStruct$BusinessRequest;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestEditRequest extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestEditRequest DEFAULT_INSTANCE;
    public static final int NOTIFY_OWNER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean notifyOwner_;
    private BusinessStruct$BusinessRequest request_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestEditRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestEditRequest businessAdminOuterClass$RequestEditRequest = new BusinessAdminOuterClass$RequestEditRequest();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestEditRequest;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestEditRequest.class, businessAdminOuterClass$RequestEditRequest);
    }

    private BusinessAdminOuterClass$RequestEditRequest() {
    }

    private void clearNotifyOwner() {
        this.notifyOwner_ = false;
    }

    private void clearRequest() {
        this.request_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessAdminOuterClass$RequestEditRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRequest(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        BusinessStruct$BusinessRequest businessStruct$BusinessRequest2 = this.request_;
        if (businessStruct$BusinessRequest2 == null || businessStruct$BusinessRequest2 == BusinessStruct$BusinessRequest.getDefaultInstance()) {
            this.request_ = businessStruct$BusinessRequest;
        } else {
            this.request_ = (BusinessStruct$BusinessRequest) ((BusinessStruct$BusinessRequest.a) BusinessStruct$BusinessRequest.newBuilder(this.request_).v(businessStruct$BusinessRequest)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNotifyOwner(boolean z) {
        this.notifyOwner_ = z;
    }

    private void setRequest(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        this.request_ = businessStruct$BusinessRequest;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestEditRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000", new Object[]{"bitField0_", "notifyOwner_", "request_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestEditRequest.class) {
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

    public boolean getNotifyOwner() {
        return this.notifyOwner_;
    }

    public BusinessStruct$BusinessRequest getRequest() {
        BusinessStruct$BusinessRequest businessStruct$BusinessRequest = this.request_;
        return businessStruct$BusinessRequest == null ? BusinessStruct$BusinessRequest.getDefaultInstance() : businessStruct$BusinessRequest;
    }

    public boolean hasRequest() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestEditRequest businessAdminOuterClass$RequestEditRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestEditRequest);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestEditRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
