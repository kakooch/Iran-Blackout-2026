package ai.bale.proto;

import ai.bale.proto.BusinessStruct$SafirRequestSupportInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestSetRequestSupport extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestSetRequestSupport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SAFIR_REQUEST_INFO_FIELD_NUMBER = 1;
    private int requestCase_ = 0;
    private Object request_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestSetRequestSupport.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SAFIR_REQUEST_INFO(1),
        REQUEST_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return REQUEST_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return SAFIR_REQUEST_INFO;
        }
    }

    static {
        BusinessOuterClass$RequestSetRequestSupport businessOuterClass$RequestSetRequestSupport = new BusinessOuterClass$RequestSetRequestSupport();
        DEFAULT_INSTANCE = businessOuterClass$RequestSetRequestSupport;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestSetRequestSupport.class, businessOuterClass$RequestSetRequestSupport);
    }

    private BusinessOuterClass$RequestSetRequestSupport() {
    }

    private void clearRequest() {
        this.requestCase_ = 0;
        this.request_ = null;
    }

    private void clearSafirRequestInfo() {
        if (this.requestCase_ == 1) {
            this.requestCase_ = 0;
            this.request_ = null;
        }
    }

    public static BusinessOuterClass$RequestSetRequestSupport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSafirRequestInfo(BusinessStruct$SafirRequestSupportInfo businessStruct$SafirRequestSupportInfo) {
        businessStruct$SafirRequestSupportInfo.getClass();
        if (this.requestCase_ != 1 || this.request_ == BusinessStruct$SafirRequestSupportInfo.getDefaultInstance()) {
            this.request_ = businessStruct$SafirRequestSupportInfo;
        } else {
            this.request_ = ((BusinessStruct$SafirRequestSupportInfo.a) BusinessStruct$SafirRequestSupportInfo.newBuilder((BusinessStruct$SafirRequestSupportInfo) this.request_).v(businessStruct$SafirRequestSupportInfo)).j();
        }
        this.requestCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSafirRequestInfo(BusinessStruct$SafirRequestSupportInfo businessStruct$SafirRequestSupportInfo) {
        businessStruct$SafirRequestSupportInfo.getClass();
        this.request_ = businessStruct$SafirRequestSupportInfo;
        this.requestCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestSetRequestSupport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"request_", "requestCase_", BusinessStruct$SafirRequestSupportInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestSetRequestSupport.class) {
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

    public b getRequestCase() {
        return b.j(this.requestCase_);
    }

    public BusinessStruct$SafirRequestSupportInfo getSafirRequestInfo() {
        return this.requestCase_ == 1 ? (BusinessStruct$SafirRequestSupportInfo) this.request_ : BusinessStruct$SafirRequestSupportInfo.getDefaultInstance();
    }

    public boolean hasSafirRequestInfo() {
        return this.requestCase_ == 1;
    }

    public static a newBuilder(BusinessOuterClass$RequestSetRequestSupport businessOuterClass$RequestSetRequestSupport) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestSetRequestSupport);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestSetRequestSupport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestSetRequestSupport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
