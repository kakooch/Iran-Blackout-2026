package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19998rI4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreStruct$OmreStation extends GeneratedMessageLite implements InterfaceC19998rI4 {
    public static final int ADDRESS_FIELD_NUMBER = 3;
    private static final OmreStruct$OmreStation DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PROVINCE_FIELD_NUMBER = 4;
    private String name_ = "";
    private String id_ = "";
    private String address_ = "";
    private String province_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19998rI4 {
        private a() {
            super(OmreStruct$OmreStation.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreStruct$OmreStation omreStruct$OmreStation = new OmreStruct$OmreStation();
        DEFAULT_INSTANCE = omreStruct$OmreStation;
        GeneratedMessageLite.registerDefaultInstance(OmreStruct$OmreStation.class, omreStruct$OmreStation);
    }

    private OmreStruct$OmreStation() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearProvince() {
        this.province_ = getDefaultInstance().getProvince();
    }

    public static OmreStruct$OmreStation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreStruct$OmreStation parseDelimitedFrom(InputStream inputStream) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreStruct$OmreStation parseFrom(ByteBuffer byteBuffer) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setProvince(String str) {
        str.getClass();
        this.province_ = str;
    }

    private void setProvinceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.province_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (V0.a[gVar.ordinal()]) {
            case 1:
                return new OmreStruct$OmreStation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"name_", "id_", "address_", "province_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreStruct$OmreStation.class) {
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

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getProvince() {
        return this.province_;
    }

    public AbstractC2383g getProvinceBytes() {
        return AbstractC2383g.N(this.province_);
    }

    public static a newBuilder(OmreStruct$OmreStation omreStruct$OmreStation) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreStruct$OmreStation);
    }

    public static OmreStruct$OmreStation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreStruct$OmreStation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreStruct$OmreStation parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreStruct$OmreStation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreStruct$OmreStation parseFrom(byte[] bArr) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreStruct$OmreStation parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreStruct$OmreStation parseFrom(InputStream inputStream) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreStruct$OmreStation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreStruct$OmreStation parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreStruct$OmreStation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreStruct$OmreStation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
