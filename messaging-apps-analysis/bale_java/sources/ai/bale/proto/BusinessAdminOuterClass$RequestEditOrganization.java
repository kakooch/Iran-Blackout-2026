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
public final class BusinessAdminOuterClass$RequestEditOrganization extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestEditOrganization DEFAULT_INSTANCE;
    public static final int NOTIFY_OWNER_FIELD_NUMBER = 1;
    public static final int ORG_INFO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private boolean notifyOwner_;
    private BusinessStruct$OrganizationInfo orgInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestEditOrganization.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestEditOrganization businessAdminOuterClass$RequestEditOrganization = new BusinessAdminOuterClass$RequestEditOrganization();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestEditOrganization;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestEditOrganization.class, businessAdminOuterClass$RequestEditOrganization);
    }

    private BusinessAdminOuterClass$RequestEditOrganization() {
    }

    private void clearNotifyOwner() {
        this.notifyOwner_ = false;
    }

    private void clearOrgInfo() {
        this.orgInfo_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessAdminOuterClass$RequestEditOrganization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrgInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo2 = this.orgInfo_;
        if (businessStruct$OrganizationInfo2 == null || businessStruct$OrganizationInfo2 == BusinessStruct$OrganizationInfo.getDefaultInstance()) {
            this.orgInfo_ = businessStruct$OrganizationInfo;
        } else {
            this.orgInfo_ = (BusinessStruct$OrganizationInfo) ((BusinessStruct$OrganizationInfo.a) BusinessStruct$OrganizationInfo.newBuilder(this.orgInfo_).v(businessStruct$OrganizationInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNotifyOwner(boolean z) {
        this.notifyOwner_ = z;
    }

    private void setOrgInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        this.orgInfo_ = businessStruct$OrganizationInfo;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestEditOrganization();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000", new Object[]{"bitField0_", "notifyOwner_", "orgInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestEditOrganization.class) {
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

    public BusinessStruct$OrganizationInfo getOrgInfo() {
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo = this.orgInfo_;
        return businessStruct$OrganizationInfo == null ? BusinessStruct$OrganizationInfo.getDefaultInstance() : businessStruct$OrganizationInfo;
    }

    public boolean hasOrgInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestEditOrganization businessAdminOuterClass$RequestEditOrganization) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestEditOrganization);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestEditOrganization parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestEditOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
