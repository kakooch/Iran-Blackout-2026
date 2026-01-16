package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC22510vM4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class OrganizationsStruct$Organization extends GeneratedMessageLite implements U64 {
    private static final OrganizationsStruct$Organization DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int ORG_PACKAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private static final B.h.a orgPackage_converter_ = new a();
    private int id_;
    private int orgPackageMemoizedSerializedSize;
    private String name_ = "";
    private B.g orgPackage_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC22510vM4 a(Integer num) {
            EnumC22510vM4 enumC22510vM4J = EnumC22510vM4.j(num.intValue());
            return enumC22510vM4J == null ? EnumC22510vM4.UNRECOGNIZED : enumC22510vM4J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(OrganizationsStruct$Organization.DEFAULT_INSTANCE);
        }
    }

    static {
        OrganizationsStruct$Organization organizationsStruct$Organization = new OrganizationsStruct$Organization();
        DEFAULT_INSTANCE = organizationsStruct$Organization;
        GeneratedMessageLite.registerDefaultInstance(OrganizationsStruct$Organization.class, organizationsStruct$Organization);
    }

    private OrganizationsStruct$Organization() {
    }

    private void addAllOrgPackage(Iterable<? extends EnumC22510vM4> iterable) {
        ensureOrgPackageIsMutable();
        Iterator<? extends EnumC22510vM4> it = iterable.iterator();
        while (it.hasNext()) {
            this.orgPackage_.b1(it.next().getNumber());
        }
    }

    private void addAllOrgPackageValue(Iterable<Integer> iterable) {
        ensureOrgPackageIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.orgPackage_.b1(it.next().intValue());
        }
    }

    private void addOrgPackage(EnumC22510vM4 enumC22510vM4) {
        enumC22510vM4.getClass();
        ensureOrgPackageIsMutable();
        this.orgPackage_.b1(enumC22510vM4.getNumber());
    }

    private void addOrgPackageValue(int i) {
        ensureOrgPackageIsMutable();
        this.orgPackage_.b1(i);
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearOrgPackage() {
        this.orgPackage_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureOrgPackageIsMutable() {
        B.g gVar = this.orgPackage_;
        if (gVar.u()) {
            return;
        }
        this.orgPackage_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static OrganizationsStruct$Organization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static OrganizationsStruct$Organization parseDelimitedFrom(InputStream inputStream) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsStruct$Organization parseFrom(ByteBuffer byteBuffer) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setOrgPackage(int i, EnumC22510vM4 enumC22510vM4) {
        enumC22510vM4.getClass();
        ensureOrgPackageIsMutable();
        this.orgPackage_.U(i, enumC22510vM4.getNumber());
    }

    private void setOrgPackageValue(int i, int i2) {
        ensureOrgPackageIsMutable();
        this.orgPackage_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (X0.a[gVar.ordinal()]) {
            case 1:
                return new OrganizationsStruct$Organization();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003,", new Object[]{"id_", "name_", "orgPackage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OrganizationsStruct$Organization.class) {
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

    public int getId() {
        return this.id_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public EnumC22510vM4 getOrgPackage(int i) {
        EnumC22510vM4 enumC22510vM4J = EnumC22510vM4.j(this.orgPackage_.getInt(i));
        return enumC22510vM4J == null ? EnumC22510vM4.UNRECOGNIZED : enumC22510vM4J;
    }

    public int getOrgPackageCount() {
        return this.orgPackage_.size();
    }

    public List<EnumC22510vM4> getOrgPackageList() {
        return new B.h(this.orgPackage_, orgPackage_converter_);
    }

    public int getOrgPackageValue(int i) {
        return this.orgPackage_.getInt(i);
    }

    public List<Integer> getOrgPackageValueList() {
        return this.orgPackage_;
    }

    public static b newBuilder(OrganizationsStruct$Organization organizationsStruct$Organization) {
        return (b) DEFAULT_INSTANCE.createBuilder(organizationsStruct$Organization);
    }

    public static OrganizationsStruct$Organization parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsStruct$Organization parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OrganizationsStruct$Organization parseFrom(AbstractC2383g abstractC2383g) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OrganizationsStruct$Organization parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OrganizationsStruct$Organization parseFrom(byte[] bArr) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OrganizationsStruct$Organization parseFrom(byte[] bArr, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OrganizationsStruct$Organization parseFrom(InputStream inputStream) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsStruct$Organization parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsStruct$Organization parseFrom(AbstractC2384h abstractC2384h) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OrganizationsStruct$Organization parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OrganizationsStruct$Organization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
