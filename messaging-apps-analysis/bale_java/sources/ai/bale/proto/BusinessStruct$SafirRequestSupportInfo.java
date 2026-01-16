package ai.bale.proto;

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
public final class BusinessStruct$SafirRequestSupportInfo extends GeneratedMessageLite implements U64 {
    public static final int CONTACT_POINT_FIELD_NUMBER = 1;
    private static final BusinessStruct$SafirRequestSupportInfo DEFAULT_INSTANCE;
    public static final int FULL_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String contactPoint_ = "";
    private String fullName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessStruct$SafirRequestSupportInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$SafirRequestSupportInfo businessStruct$SafirRequestSupportInfo = new BusinessStruct$SafirRequestSupportInfo();
        DEFAULT_INSTANCE = businessStruct$SafirRequestSupportInfo;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$SafirRequestSupportInfo.class, businessStruct$SafirRequestSupportInfo);
    }

    private BusinessStruct$SafirRequestSupportInfo() {
    }

    private void clearContactPoint() {
        this.contactPoint_ = getDefaultInstance().getContactPoint();
    }

    private void clearFullName() {
        this.fullName_ = getDefaultInstance().getFullName();
    }

    public static BusinessStruct$SafirRequestSupportInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$SafirRequestSupportInfo parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContactPoint(String str) {
        str.getClass();
        this.contactPoint_ = str;
    }

    private void setContactPointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contactPoint_ = abstractC2383g.f0();
    }

    private void setFullName(String str) {
        str.getClass();
        this.fullName_ = str;
    }

    private void setFullNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fullName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$SafirRequestSupportInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"contactPoint_", "fullName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$SafirRequestSupportInfo.class) {
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

    public String getContactPoint() {
        return this.contactPoint_;
    }

    public AbstractC2383g getContactPointBytes() {
        return AbstractC2383g.N(this.contactPoint_);
    }

    public String getFullName() {
        return this.fullName_;
    }

    public AbstractC2383g getFullNameBytes() {
        return AbstractC2383g.N(this.fullName_);
    }

    public static a newBuilder(BusinessStruct$SafirRequestSupportInfo businessStruct$SafirRequestSupportInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$SafirRequestSupportInfo);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(byte[] bArr) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(InputStream inputStream) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$SafirRequestSupportInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$SafirRequestSupportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
