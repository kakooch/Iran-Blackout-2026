package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestGetOrganization extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestGetOrganization DEFAULT_INSTANCE;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 2;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int identifierCase_ = 0;
    private Object identifier_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestGetOrganization.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        OWNER_USER_ID(1),
        ORGANIZATION_ID(2),
        IDENTIFIER_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return IDENTIFIER_NOT_SET;
            }
            if (i == 1) {
                return OWNER_USER_ID;
            }
            if (i != 2) {
                return null;
            }
            return ORGANIZATION_ID;
        }
    }

    static {
        BusinessAdminOuterClass$RequestGetOrganization businessAdminOuterClass$RequestGetOrganization = new BusinessAdminOuterClass$RequestGetOrganization();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestGetOrganization;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestGetOrganization.class, businessAdminOuterClass$RequestGetOrganization);
    }

    private BusinessAdminOuterClass$RequestGetOrganization() {
    }

    private void clearIdentifier() {
        this.identifierCase_ = 0;
        this.identifier_ = null;
    }

    private void clearOrganizationId() {
        if (this.identifierCase_ == 2) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    private void clearOwnerUserId() {
        if (this.identifierCase_ == 1) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    public static BusinessAdminOuterClass$RequestGetOrganization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrganizationId(int i) {
        this.identifierCase_ = 2;
        this.identifier_ = Integer.valueOf(i);
    }

    private void setOwnerUserId(int i) {
        this.identifierCase_ = 1;
        this.identifier_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestGetOrganization();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u00017\u0000\u00027\u0000", new Object[]{"identifier_", "identifierCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestGetOrganization.class) {
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

    public b getIdentifierCase() {
        return b.j(this.identifierCase_);
    }

    public int getOrganizationId() {
        if (this.identifierCase_ == 2) {
            return ((Integer) this.identifier_).intValue();
        }
        return 0;
    }

    public int getOwnerUserId() {
        if (this.identifierCase_ == 1) {
            return ((Integer) this.identifier_).intValue();
        }
        return 0;
    }

    public boolean hasOrganizationId() {
        return this.identifierCase_ == 2;
    }

    public boolean hasOwnerUserId() {
        return this.identifierCase_ == 1;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestGetOrganization businessAdminOuterClass$RequestGetOrganization) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestGetOrganization);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestGetOrganization parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestGetOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
