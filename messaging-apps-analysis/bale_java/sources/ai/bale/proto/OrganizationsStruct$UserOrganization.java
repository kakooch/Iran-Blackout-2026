package ai.bale.proto;

import ai.bale.proto.OrganizationsStruct$Organization;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OrganizationsStruct$UserOrganization extends GeneratedMessageLite implements U64 {
    private static final OrganizationsStruct$UserOrganization DEFAULT_INSTANCE;
    public static final int IS_ADMIN_FIELD_NUMBER = 2;
    public static final int ORGANIZATIONAL_NAME_FIELD_NUMBER = 4;
    public static final int ORGANIZATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private boolean isAdmin_;
    private OrganizationsStruct$Organization organization_;
    private String organizationalName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OrganizationsStruct$UserOrganization.DEFAULT_INSTANCE);
        }
    }

    static {
        OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization = new OrganizationsStruct$UserOrganization();
        DEFAULT_INSTANCE = organizationsStruct$UserOrganization;
        GeneratedMessageLite.registerDefaultInstance(OrganizationsStruct$UserOrganization.class, organizationsStruct$UserOrganization);
    }

    private OrganizationsStruct$UserOrganization() {
    }

    private void clearIsAdmin() {
        this.isAdmin_ = false;
    }

    private void clearOrganization() {
        this.organization_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOrganizationalName() {
        this.organizationalName_ = getDefaultInstance().getOrganizationalName();
    }

    public static OrganizationsStruct$UserOrganization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrganization(OrganizationsStruct$Organization organizationsStruct$Organization) {
        organizationsStruct$Organization.getClass();
        OrganizationsStruct$Organization organizationsStruct$Organization2 = this.organization_;
        if (organizationsStruct$Organization2 == null || organizationsStruct$Organization2 == OrganizationsStruct$Organization.getDefaultInstance()) {
            this.organization_ = organizationsStruct$Organization;
        } else {
            this.organization_ = (OrganizationsStruct$Organization) ((OrganizationsStruct$Organization.b) OrganizationsStruct$Organization.newBuilder(this.organization_).v(organizationsStruct$Organization)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OrganizationsStruct$UserOrganization parseDelimitedFrom(InputStream inputStream) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(ByteBuffer byteBuffer) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsAdmin(boolean z) {
        this.isAdmin_ = z;
    }

    private void setOrganization(OrganizationsStruct$Organization organizationsStruct$Organization) {
        organizationsStruct$Organization.getClass();
        this.organization_ = organizationsStruct$Organization;
        this.bitField0_ |= 1;
    }

    private void setOrganizationalName(String str) {
        str.getClass();
        this.organizationalName_ = str;
    }

    private void setOrganizationalNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.organizationalName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (X0.a[gVar.ordinal()]) {
            case 1:
                return new OrganizationsStruct$UserOrganization();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007\u0004Ȉ", new Object[]{"bitField0_", "organization_", "isAdmin_", "organizationalName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OrganizationsStruct$UserOrganization.class) {
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

    public boolean getIsAdmin() {
        return this.isAdmin_;
    }

    public OrganizationsStruct$Organization getOrganization() {
        OrganizationsStruct$Organization organizationsStruct$Organization = this.organization_;
        return organizationsStruct$Organization == null ? OrganizationsStruct$Organization.getDefaultInstance() : organizationsStruct$Organization;
    }

    public String getOrganizationalName() {
        return this.organizationalName_;
    }

    public AbstractC2383g getOrganizationalNameBytes() {
        return AbstractC2383g.N(this.organizationalName_);
    }

    public boolean hasOrganization() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(OrganizationsStruct$UserOrganization organizationsStruct$UserOrganization) {
        return (a) DEFAULT_INSTANCE.createBuilder(organizationsStruct$UserOrganization);
    }

    public static OrganizationsStruct$UserOrganization parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(AbstractC2383g abstractC2383g) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(byte[] bArr) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(byte[] bArr, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(InputStream inputStream) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(AbstractC2384h abstractC2384h) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OrganizationsStruct$UserOrganization parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OrganizationsStruct$UserOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
