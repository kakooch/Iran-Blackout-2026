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
public final class BusinessOuterClass$RequestCreateRequest extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestCreateRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_INFO_FIELD_NUMBER = 1;
    private int bitField0_;
    private BusinessStruct$BusinessRequest requestInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestCreateRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestCreateRequest businessOuterClass$RequestCreateRequest = new BusinessOuterClass$RequestCreateRequest();
        DEFAULT_INSTANCE = businessOuterClass$RequestCreateRequest;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestCreateRequest.class, businessOuterClass$RequestCreateRequest);
    }

    private BusinessOuterClass$RequestCreateRequest() {
    }

    private void clearRequestInfo() {
        this.requestInfo_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessOuterClass$RequestCreateRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRequestInfo(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        BusinessStruct$BusinessRequest businessStruct$BusinessRequest2 = this.requestInfo_;
        if (businessStruct$BusinessRequest2 == null || businessStruct$BusinessRequest2 == BusinessStruct$BusinessRequest.getDefaultInstance()) {
            this.requestInfo_ = businessStruct$BusinessRequest;
        } else {
            this.requestInfo_ = (BusinessStruct$BusinessRequest) ((BusinessStruct$BusinessRequest.a) BusinessStruct$BusinessRequest.newBuilder(this.requestInfo_).v(businessStruct$BusinessRequest)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestCreateRequest parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRequestInfo(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        businessStruct$BusinessRequest.getClass();
        this.requestInfo_ = businessStruct$BusinessRequest;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestCreateRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "requestInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestCreateRequest.class) {
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

    public BusinessStruct$BusinessRequest getRequestInfo() {
        BusinessStruct$BusinessRequest businessStruct$BusinessRequest = this.requestInfo_;
        return businessStruct$BusinessRequest == null ? BusinessStruct$BusinessRequest.getDefaultInstance() : businessStruct$BusinessRequest;
    }

    public boolean hasRequestInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$RequestCreateRequest businessOuterClass$RequestCreateRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestCreateRequest);
    }

    public static BusinessOuterClass$RequestCreateRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestCreateRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestCreateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
