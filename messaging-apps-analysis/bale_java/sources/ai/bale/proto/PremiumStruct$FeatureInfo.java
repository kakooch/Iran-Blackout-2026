package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4065Dn5;
import ir.nasim.InterfaceC3831Cn5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$FeatureInfo extends GeneratedMessageLite implements InterfaceC3831Cn5 {
    private static final PremiumStruct$FeatureInfo DEFAULT_INSTANCE;
    public static final int EN_LONG_DESCRIPTION_FIELD_NUMBER = 7;
    public static final int EN_SHORT_DESCRIPTION_FIELD_NUMBER = 5;
    public static final int EN_TITLE_FIELD_NUMBER = 3;
    public static final int EN_UNIT_FIELD_NUMBER = 9;
    public static final int FA_LONG_DESCRIPTION_FIELD_NUMBER = 6;
    public static final int FA_SHORT_DESCRIPTION_FIELD_NUMBER = 4;
    public static final int FA_TITLE_FIELD_NUMBER = 2;
    public static final int FA_UNIT_FIELD_NUMBER = 8;
    public static final int FEATURE_ID_FIELD_NUMBER = 1;
    public static final int ICON_SVG_FIELD_NUMBER = 11;
    public static final int MEDIA_FORMAT_FIELD_NUMBER = 13;
    public static final int MEDIA_URL_FIELD_NUMBER = 12;
    public static final int MIN_APP_VERSION_FIELD_NUMBER = 10;
    private static volatile KW4 PARSER = null;
    public static final int QUOTA_FIELD_NUMBER = 14;
    public static final int RESET_PERIOD_FIELD_NUMBER = 15;
    private long featureId_;
    private int mediaFormat_;
    private int minAppVersion_;
    private long quota_;
    private long resetPeriod_;
    private String faTitle_ = "";
    private String enTitle_ = "";
    private String faShortDescription_ = "";
    private String enShortDescription_ = "";
    private String faLongDescription_ = "";
    private String enLongDescription_ = "";
    private String faUnit_ = "";
    private String enUnit_ = "";
    private String iconSvg_ = "";
    private String mediaUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3831Cn5 {
        private a() {
            super(PremiumStruct$FeatureInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$FeatureInfo premiumStruct$FeatureInfo = new PremiumStruct$FeatureInfo();
        DEFAULT_INSTANCE = premiumStruct$FeatureInfo;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$FeatureInfo.class, premiumStruct$FeatureInfo);
    }

    private PremiumStruct$FeatureInfo() {
    }

    private void clearEnLongDescription() {
        this.enLongDescription_ = getDefaultInstance().getEnLongDescription();
    }

    private void clearEnShortDescription() {
        this.enShortDescription_ = getDefaultInstance().getEnShortDescription();
    }

    private void clearEnTitle() {
        this.enTitle_ = getDefaultInstance().getEnTitle();
    }

    private void clearEnUnit() {
        this.enUnit_ = getDefaultInstance().getEnUnit();
    }

    private void clearFaLongDescription() {
        this.faLongDescription_ = getDefaultInstance().getFaLongDescription();
    }

    private void clearFaShortDescription() {
        this.faShortDescription_ = getDefaultInstance().getFaShortDescription();
    }

    private void clearFaTitle() {
        this.faTitle_ = getDefaultInstance().getFaTitle();
    }

    private void clearFaUnit() {
        this.faUnit_ = getDefaultInstance().getFaUnit();
    }

    private void clearFeatureId() {
        this.featureId_ = 0L;
    }

    private void clearIconSvg() {
        this.iconSvg_ = getDefaultInstance().getIconSvg();
    }

    private void clearMediaFormat() {
        this.mediaFormat_ = 0;
    }

    private void clearMediaUrl() {
        this.mediaUrl_ = getDefaultInstance().getMediaUrl();
    }

    private void clearMinAppVersion() {
        this.minAppVersion_ = 0;
    }

    private void clearQuota() {
        this.quota_ = 0L;
    }

    private void clearResetPeriod() {
        this.resetPeriod_ = 0L;
    }

    public static PremiumStruct$FeatureInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$FeatureInfo parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$FeatureInfo parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnLongDescription(String str) {
        str.getClass();
        this.enLongDescription_ = str;
    }

    private void setEnLongDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enLongDescription_ = abstractC2383g.f0();
    }

    private void setEnShortDescription(String str) {
        str.getClass();
        this.enShortDescription_ = str;
    }

    private void setEnShortDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enShortDescription_ = abstractC2383g.f0();
    }

    private void setEnTitle(String str) {
        str.getClass();
        this.enTitle_ = str;
    }

    private void setEnTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enTitle_ = abstractC2383g.f0();
    }

    private void setEnUnit(String str) {
        str.getClass();
        this.enUnit_ = str;
    }

    private void setEnUnitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enUnit_ = abstractC2383g.f0();
    }

    private void setFaLongDescription(String str) {
        str.getClass();
        this.faLongDescription_ = str;
    }

    private void setFaLongDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faLongDescription_ = abstractC2383g.f0();
    }

    private void setFaShortDescription(String str) {
        str.getClass();
        this.faShortDescription_ = str;
    }

    private void setFaShortDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faShortDescription_ = abstractC2383g.f0();
    }

    private void setFaTitle(String str) {
        str.getClass();
        this.faTitle_ = str;
    }

    private void setFaTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faTitle_ = abstractC2383g.f0();
    }

    private void setFaUnit(String str) {
        str.getClass();
        this.faUnit_ = str;
    }

    private void setFaUnitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faUnit_ = abstractC2383g.f0();
    }

    private void setFeatureId(long j) {
        this.featureId_ = j;
    }

    private void setIconSvg(String str) {
        str.getClass();
        this.iconSvg_ = str;
    }

    private void setIconSvgBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.iconSvg_ = abstractC2383g.f0();
    }

    private void setMediaFormat(EnumC4065Dn5 enumC4065Dn5) {
        this.mediaFormat_ = enumC4065Dn5.getNumber();
    }

    private void setMediaFormatValue(int i) {
        this.mediaFormat_ = i;
    }

    private void setMediaUrl(String str) {
        str.getClass();
        this.mediaUrl_ = str;
    }

    private void setMediaUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mediaUrl_ = abstractC2383g.f0();
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setQuota(long j) {
        this.quota_ = j;
    }

    private void setResetPeriod(long j) {
        this.resetPeriod_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$FeatureInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n\u0004\u000bȈ\fȈ\r\f\u000e\u0002\u000f\u0002", new Object[]{"featureId_", "faTitle_", "enTitle_", "faShortDescription_", "enShortDescription_", "faLongDescription_", "enLongDescription_", "faUnit_", "enUnit_", "minAppVersion_", "iconSvg_", "mediaUrl_", "mediaFormat_", "quota_", "resetPeriod_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$FeatureInfo.class) {
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

    public String getEnLongDescription() {
        return this.enLongDescription_;
    }

    public AbstractC2383g getEnLongDescriptionBytes() {
        return AbstractC2383g.N(this.enLongDescription_);
    }

    public String getEnShortDescription() {
        return this.enShortDescription_;
    }

    public AbstractC2383g getEnShortDescriptionBytes() {
        return AbstractC2383g.N(this.enShortDescription_);
    }

    public String getEnTitle() {
        return this.enTitle_;
    }

    public AbstractC2383g getEnTitleBytes() {
        return AbstractC2383g.N(this.enTitle_);
    }

    public String getEnUnit() {
        return this.enUnit_;
    }

    public AbstractC2383g getEnUnitBytes() {
        return AbstractC2383g.N(this.enUnit_);
    }

    public String getFaLongDescription() {
        return this.faLongDescription_;
    }

    public AbstractC2383g getFaLongDescriptionBytes() {
        return AbstractC2383g.N(this.faLongDescription_);
    }

    public String getFaShortDescription() {
        return this.faShortDescription_;
    }

    public AbstractC2383g getFaShortDescriptionBytes() {
        return AbstractC2383g.N(this.faShortDescription_);
    }

    public String getFaTitle() {
        return this.faTitle_;
    }

    public AbstractC2383g getFaTitleBytes() {
        return AbstractC2383g.N(this.faTitle_);
    }

    public String getFaUnit() {
        return this.faUnit_;
    }

    public AbstractC2383g getFaUnitBytes() {
        return AbstractC2383g.N(this.faUnit_);
    }

    public long getFeatureId() {
        return this.featureId_;
    }

    public String getIconSvg() {
        return this.iconSvg_;
    }

    public AbstractC2383g getIconSvgBytes() {
        return AbstractC2383g.N(this.iconSvg_);
    }

    public EnumC4065Dn5 getMediaFormat() {
        EnumC4065Dn5 enumC4065Dn5J = EnumC4065Dn5.j(this.mediaFormat_);
        return enumC4065Dn5J == null ? EnumC4065Dn5.UNRECOGNIZED : enumC4065Dn5J;
    }

    public int getMediaFormatValue() {
        return this.mediaFormat_;
    }

    public String getMediaUrl() {
        return this.mediaUrl_;
    }

    public AbstractC2383g getMediaUrlBytes() {
        return AbstractC2383g.N(this.mediaUrl_);
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public long getQuota() {
        return this.quota_;
    }

    public long getResetPeriod() {
        return this.resetPeriod_;
    }

    public static a newBuilder(PremiumStruct$FeatureInfo premiumStruct$FeatureInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$FeatureInfo);
    }

    public static PremiumStruct$FeatureInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$FeatureInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$FeatureInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$FeatureInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$FeatureInfo parseFrom(byte[] bArr) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$FeatureInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$FeatureInfo parseFrom(InputStream inputStream) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$FeatureInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$FeatureInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$FeatureInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$FeatureInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
