package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17851ng;
import ir.nasim.EnumC4938Hf;
import ir.nasim.InterfaceC17260mg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$BusinessAdData extends GeneratedMessageLite implements InterfaceC17260mg {
    public static final int BUSINESS_NAME_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 8;
    private static final AdvertisementStruct$BusinessAdData DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 7;
    public static final int OWNER_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NO_FIELD_NUMBER = 6;
    public static final int SPOT_FIELD_NUMBER = 4;
    public static final int STATE_FIELD_NUMBER = 5;
    private long createdAt_;
    private int ownerId_;
    private int spot_;
    private int state_;
    private String id_ = "";
    private String businessName_ = "";
    private String phoneNo_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17260mg {
        private a() {
            super(AdvertisementStruct$BusinessAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData = new AdvertisementStruct$BusinessAdData();
        DEFAULT_INSTANCE = advertisementStruct$BusinessAdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BusinessAdData.class, advertisementStruct$BusinessAdData);
    }

    private AdvertisementStruct$BusinessAdData() {
    }

    private void clearBusinessName() {
        this.businessName_ = getDefaultInstance().getBusinessName();
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearPhoneNo() {
        this.phoneNo_ = getDefaultInstance().getPhoneNo();
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementStruct$BusinessAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BusinessAdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBusinessName(String str) {
        str.getClass();
        this.businessName_ = str;
    }

    private void setBusinessNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.businessName_ = abstractC2383g.f0();
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setPhoneNo(String str) {
        str.getClass();
        this.phoneNo_ = str;
    }

    private void setPhoneNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNo_ = abstractC2383g.f0();
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setState(EnumC17851ng enumC17851ng) {
        this.state_ = enumC17851ng.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BusinessAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004\f\u0005\f\u0006Ȉ\u0007Ȉ\b\u0002", new Object[]{"id_", "businessName_", "ownerId_", "spot_", "state_", "phoneNo_", "link_", "createdAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BusinessAdData.class) {
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

    public String getBusinessName() {
        return this.businessName_;
    }

    public AbstractC2383g getBusinessNameBytes() {
        return AbstractC2383g.N(this.businessName_);
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public int getOwnerId() {
        return this.ownerId_;
    }

    public String getPhoneNo() {
        return this.phoneNo_;
    }

    public AbstractC2383g getPhoneNoBytes() {
        return AbstractC2383g.N(this.phoneNo_);
    }

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public EnumC17851ng getState() {
        EnumC17851ng enumC17851ngJ = EnumC17851ng.j(this.state_);
        return enumC17851ngJ == null ? EnumC17851ng.UNRECOGNIZED : enumC17851ngJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BusinessAdData);
    }

    public static AdvertisementStruct$BusinessAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BusinessAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BusinessAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
