package ai.bale.proto;

import ai.bale.proto.BusinessStruct$OrganizationInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$ResponseGetOrganizationInfo extends GeneratedMessageLite implements U64 {
    private static final BusinessOuterClass$ResponseGetOrganizationInfo DEFAULT_INSTANCE;
    public static final int ORGANIZATION_INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BusinessStruct$OrganizationInfo organizationInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$ResponseGetOrganizationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$ResponseGetOrganizationInfo businessOuterClass$ResponseGetOrganizationInfo = new BusinessOuterClass$ResponseGetOrganizationInfo();
        DEFAULT_INSTANCE = businessOuterClass$ResponseGetOrganizationInfo;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$ResponseGetOrganizationInfo.class, businessOuterClass$ResponseGetOrganizationInfo);
    }

    private BusinessOuterClass$ResponseGetOrganizationInfo() {
    }

    private void clearOrganizationInfo() {
        this.organizationInfo_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrganizationInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo2 = this.organizationInfo_;
        if (businessStruct$OrganizationInfo2 == null || businessStruct$OrganizationInfo2 == BusinessStruct$OrganizationInfo.getDefaultInstance()) {
            this.organizationInfo_ = businessStruct$OrganizationInfo;
        } else {
            this.organizationInfo_ = (BusinessStruct$OrganizationInfo) ((BusinessStruct$OrganizationInfo.a) BusinessStruct$OrganizationInfo.newBuilder(this.organizationInfo_).v(businessStruct$OrganizationInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrganizationInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        this.organizationInfo_ = businessStruct$OrganizationInfo;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$ResponseGetOrganizationInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "organizationInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$ResponseGetOrganizationInfo.class) {
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

    public BusinessStruct$OrganizationInfo getOrganizationInfo() {
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo = this.organizationInfo_;
        return businessStruct$OrganizationInfo == null ? BusinessStruct$OrganizationInfo.getDefaultInstance() : businessStruct$OrganizationInfo;
    }

    public boolean hasOrganizationInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$ResponseGetOrganizationInfo businessOuterClass$ResponseGetOrganizationInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$ResponseGetOrganizationInfo);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(byte[] bArr) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$ResponseGetOrganizationInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$ResponseGetOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
