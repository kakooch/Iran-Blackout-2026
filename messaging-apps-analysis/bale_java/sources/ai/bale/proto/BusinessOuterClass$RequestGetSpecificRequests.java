package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3592Bn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestGetSpecificRequests extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$RequestGetSpecificRequests DEFAULT_INSTANCE;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_TYPE_FIELD_NUMBER = 2;
    private int organizationId_;
    private int requestType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestGetSpecificRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestGetSpecificRequests businessOuterClass$RequestGetSpecificRequests = new BusinessOuterClass$RequestGetSpecificRequests();
        DEFAULT_INSTANCE = businessOuterClass$RequestGetSpecificRequests;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestGetSpecificRequests.class, businessOuterClass$RequestGetSpecificRequests);
    }

    private BusinessOuterClass$RequestGetSpecificRequests() {
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    private void clearRequestType() {
        this.requestType_ = 0;
    }

    public static BusinessOuterClass$RequestGetSpecificRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    private void setRequestType(EnumC3592Bn0 enumC3592Bn0) {
        this.requestType_ = enumC3592Bn0.getNumber();
    }

    private void setRequestTypeValue(int i) {
        this.requestType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestGetSpecificRequests();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\f", new Object[]{"organizationId_", "requestType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestGetSpecificRequests.class) {
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

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public EnumC3592Bn0 getRequestType() {
        EnumC3592Bn0 enumC3592Bn0J = EnumC3592Bn0.j(this.requestType_);
        return enumC3592Bn0J == null ? EnumC3592Bn0.UNRECOGNIZED : enumC3592Bn0J;
    }

    public int getRequestTypeValue() {
        return this.requestType_;
    }

    public static a newBuilder(BusinessOuterClass$RequestGetSpecificRequests businessOuterClass$RequestGetSpecificRequests) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestGetSpecificRequests);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestGetSpecificRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetSpecificRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
