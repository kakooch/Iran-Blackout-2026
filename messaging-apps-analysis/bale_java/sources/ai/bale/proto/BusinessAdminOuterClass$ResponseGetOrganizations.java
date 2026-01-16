package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23948xn0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$ResponseGetOrganizations extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$ResponseGetOrganizations DEFAULT_INSTANCE;
    public static final int ORGANIZATION_INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j organizationInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$ResponseGetOrganizations.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$ResponseGetOrganizations businessAdminOuterClass$ResponseGetOrganizations = new BusinessAdminOuterClass$ResponseGetOrganizations();
        DEFAULT_INSTANCE = businessAdminOuterClass$ResponseGetOrganizations;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$ResponseGetOrganizations.class, businessAdminOuterClass$ResponseGetOrganizations);
    }

    private BusinessAdminOuterClass$ResponseGetOrganizations() {
    }

    private void addAllOrganizationInfo(Iterable<? extends BusinessStruct$OrganizationInfo> iterable) {
        ensureOrganizationInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.organizationInfo_);
    }

    private void addOrganizationInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        ensureOrganizationInfoIsMutable();
        this.organizationInfo_.add(businessStruct$OrganizationInfo);
    }

    private void clearOrganizationInfo() {
        this.organizationInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOrganizationInfoIsMutable() {
        B.j jVar = this.organizationInfo_;
        if (jVar.u()) {
            return;
        }
        this.organizationInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrganizationInfo(int i) {
        ensureOrganizationInfoIsMutable();
        this.organizationInfo_.remove(i);
    }

    private void setOrganizationInfo(int i, BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        ensureOrganizationInfoIsMutable();
        this.organizationInfo_.set(i, businessStruct$OrganizationInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$ResponseGetOrganizations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"organizationInfo_", BusinessStruct$OrganizationInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$ResponseGetOrganizations.class) {
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

    public BusinessStruct$OrganizationInfo getOrganizationInfo(int i) {
        return (BusinessStruct$OrganizationInfo) this.organizationInfo_.get(i);
    }

    public int getOrganizationInfoCount() {
        return this.organizationInfo_.size();
    }

    public List<BusinessStruct$OrganizationInfo> getOrganizationInfoList() {
        return this.organizationInfo_;
    }

    public InterfaceC23948xn0 getOrganizationInfoOrBuilder(int i) {
        return (InterfaceC23948xn0) this.organizationInfo_.get(i);
    }

    public List<? extends InterfaceC23948xn0> getOrganizationInfoOrBuilderList() {
        return this.organizationInfo_;
    }

    public static a newBuilder(BusinessAdminOuterClass$ResponseGetOrganizations businessAdminOuterClass$ResponseGetOrganizations) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$ResponseGetOrganizations);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrganizationInfo(int i, BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        ensureOrganizationInfoIsMutable();
        this.organizationInfo_.add(i, businessStruct$OrganizationInfo);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$ResponseGetOrganizations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseGetOrganizations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
