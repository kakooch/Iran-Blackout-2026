package ai.bale.proto;

import ai.bale.proto.OrganizationsStruct$UserOrganization;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OrganizationsOuterClass$ResponseGetUserOrganizationInfo extends GeneratedMessageLite implements U64 {
    private static final OrganizationsOuterClass$ResponseGetUserOrganizationInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ORGANIZATION_FIELD_NUMBER = 1;
    private int bitField0_;
    private OrganizationsStruct$UserOrganization userOrganization_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OrganizationsOuterClass$ResponseGetUserOrganizationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OrganizationsOuterClass$ResponseGetUserOrganizationInfo organizationsOuterClass$ResponseGetUserOrganizationInfo = new OrganizationsOuterClass$ResponseGetUserOrganizationInfo();
        DEFAULT_INSTANCE = organizationsOuterClass$ResponseGetUserOrganizationInfo;
        GeneratedMessageLite.registerDefaultInstance(OrganizationsOuterClass$ResponseGetUserOrganizationInfo.class, organizationsOuterClass$ResponseGetUserOrganizationInfo);
    }

    private OrganizationsOuterClass$ResponseGetUserOrganizationInfo() {
    }

    private void clearUserOrganization() {
        this.userOrganization_ = null;
        this.bitField0_ &= -2;
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserOrganization(OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization) {
        organizationsStruct$UserOrganization.getClass();
        OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization2 = this.userOrganization_;
        if (organizationsStruct$UserOrganization2 == null || organizationsStruct$UserOrganization2 == OrganizationsStruct$UserOrganization.getDefaultInstance()) {
            this.userOrganization_ = organizationsStruct$UserOrganization;
        } else {
            this.userOrganization_ = (OrganizationsStruct$UserOrganization) ((OrganizationsStruct$UserOrganization.a) OrganizationsStruct$UserOrganization.newBuilder(this.userOrganization_).v(organizationsStruct$UserOrganization)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseDelimitedFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(ByteBuffer byteBuffer) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserOrganization(OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization) {
        organizationsStruct$UserOrganization.getClass();
        this.userOrganization_ = organizationsStruct$UserOrganization;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (W0.a[gVar.ordinal()]) {
            case 1:
                return new OrganizationsOuterClass$ResponseGetUserOrganizationInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "userOrganization_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OrganizationsOuterClass$ResponseGetUserOrganizationInfo.class) {
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

    public OrganizationsStruct$UserOrganization getUserOrganization() {
        OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization = this.userOrganization_;
        return organizationsStruct$UserOrganization == null ? OrganizationsStruct$UserOrganization.getDefaultInstance() : organizationsStruct$UserOrganization;
    }

    public boolean hasUserOrganization() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(OrganizationsOuterClass$ResponseGetUserOrganizationInfo organizationsOuterClass$ResponseGetUserOrganizationInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(organizationsOuterClass$ResponseGetUserOrganizationInfo);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(byte[] bArr) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OrganizationsOuterClass$ResponseGetUserOrganizationInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OrganizationsOuterClass$ResponseGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
