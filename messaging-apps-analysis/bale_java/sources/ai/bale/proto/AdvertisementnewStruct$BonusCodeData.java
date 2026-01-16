package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC22711vi;
import ir.nasim.EnumC23307wi;
import ir.nasim.InterfaceC22121ui;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementnewStruct$BonusCodeData extends GeneratedMessageLite implements InterfaceC22121ui {
    public static final int AD_ID_FIELD_NUMBER = 6;
    public static final int CODE_FIELD_NUMBER = 3;
    public static final int CREATE_TIME_FIELD_NUMBER = 7;
    private static final AdvertisementnewStruct$BonusCodeData DEFAULT_INSTANCE;
    public static final int EXP_DATE_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int OWNER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 5;
    private long createTime_;
    private long expDate_;
    private int ownerId_;
    private int state_;
    private int type_;
    private int value_;
    private String id_ = "";
    private String code_ = "";
    private String adId_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22121ui {
        private a() {
            super(AdvertisementnewStruct$BonusCodeData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData = new AdvertisementnewStruct$BonusCodeData();
        DEFAULT_INSTANCE = advertisementnewStruct$BonusCodeData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementnewStruct$BonusCodeData.class, advertisementnewStruct$BonusCodeData);
    }

    private AdvertisementnewStruct$BonusCodeData() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearCreateTime() {
        this.createTime_ = 0L;
    }

    private void clearExpDate() {
        this.expDate_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearValue() {
        this.value_ = 0;
    }

    public static AdvertisementnewStruct$BonusCodeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementnewStruct$BonusCodeData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setCreateTime(long j) {
        this.createTime_ = j;
    }

    private void setExpDate(long j) {
        this.expDate_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setState(EnumC22711vi enumC22711vi) {
        this.state_ = enumC22711vi.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setType(EnumC23307wi enumC23307wi) {
        this.type_ = enumC23307wi.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1852f.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementnewStruct$BonusCodeData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\f\u0005\u0004\u0006Ȉ\u0007\u0002\b\f\t\u0002", new Object[]{"id_", "ownerId_", "code_", "type_", "value_", "adId_", "createTime_", "state_", "expDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementnewStruct$BonusCodeData.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public long getCreateTime() {
        return this.createTime_;
    }

    public long getExpDate() {
        return this.expDate_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public int getOwnerId() {
        return this.ownerId_;
    }

    public EnumC22711vi getState() {
        EnumC22711vi enumC22711viJ = EnumC22711vi.j(this.state_);
        return enumC22711viJ == null ? EnumC22711vi.UNRECOGNIZED : enumC22711viJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public EnumC23307wi getType() {
        EnumC23307wi enumC23307wiJ = EnumC23307wi.j(this.type_);
        return enumC23307wiJ == null ? EnumC23307wi.UNRECOGNIZED : enumC23307wiJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getValue() {
        return this.value_;
    }

    public static a newBuilder(AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnewStruct$BonusCodeData);
    }

    public static AdvertisementnewStruct$BonusCodeData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(byte[] bArr) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementnewStruct$BonusCodeData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementnewStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
