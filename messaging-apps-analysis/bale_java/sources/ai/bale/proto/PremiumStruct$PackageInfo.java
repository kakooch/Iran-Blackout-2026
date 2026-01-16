package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4533Fn5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$PackageInfo extends GeneratedMessageLite implements InterfaceC4533Fn5 {
    public static final int BUNDLE_ID_FIELD_NUMBER = 2;
    private static final PremiumStruct$PackageInfo DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 10;
    public static final int EN_DESCRIPTION_FIELD_NUMBER = 6;
    public static final int EN_TITLE_FIELD_NUMBER = 4;
    public static final int FA_DESCRIPTION_FIELD_NUMBER = 5;
    public static final int FA_TITLE_FIELD_NUMBER = 3;
    public static final int FINAL_PRICE_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_SPECIAL_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 8;
    private long bundleId_;
    private long duration_;
    private long finalPrice_;
    private long id_;
    private boolean isSpecial_;
    private long price_;
    private String faTitle_ = "";
    private String enTitle_ = "";
    private String faDescription_ = "";
    private String enDescription_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4533Fn5 {
        private a() {
            super(PremiumStruct$PackageInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$PackageInfo premiumStruct$PackageInfo = new PremiumStruct$PackageInfo();
        DEFAULT_INSTANCE = premiumStruct$PackageInfo;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$PackageInfo.class, premiumStruct$PackageInfo);
    }

    private PremiumStruct$PackageInfo() {
    }

    private void clearBundleId() {
        this.bundleId_ = 0L;
    }

    private void clearDuration() {
        this.duration_ = 0L;
    }

    private void clearEnDescription() {
        this.enDescription_ = getDefaultInstance().getEnDescription();
    }

    private void clearEnTitle() {
        this.enTitle_ = getDefaultInstance().getEnTitle();
    }

    private void clearFaDescription() {
        this.faDescription_ = getDefaultInstance().getFaDescription();
    }

    private void clearFaTitle() {
        this.faTitle_ = getDefaultInstance().getFaTitle();
    }

    private void clearFinalPrice() {
        this.finalPrice_ = 0L;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearIsSpecial() {
        this.isSpecial_ = false;
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    public static PremiumStruct$PackageInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$PackageInfo parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$PackageInfo parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBundleId(long j) {
        this.bundleId_ = j;
    }

    private void setDuration(long j) {
        this.duration_ = j;
    }

    private void setEnDescription(String str) {
        str.getClass();
        this.enDescription_ = str;
    }

    private void setEnDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enDescription_ = abstractC2383g.f0();
    }

    private void setEnTitle(String str) {
        str.getClass();
        this.enTitle_ = str;
    }

    private void setEnTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enTitle_ = abstractC2383g.f0();
    }

    private void setFaDescription(String str) {
        str.getClass();
        this.faDescription_ = str;
    }

    private void setFaDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faDescription_ = abstractC2383g.f0();
    }

    private void setFaTitle(String str) {
        str.getClass();
        this.faTitle_ = str;
    }

    private void setFaTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faTitle_ = abstractC2383g.f0();
    }

    private void setFinalPrice(long j) {
        this.finalPrice_ = j;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setIsSpecial(boolean z) {
        this.isSpecial_ = z;
    }

    private void setPrice(long j) {
        this.price_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$PackageInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\b\u0002\t\u0002\n\u0002\u000b\u0007", new Object[]{"id_", "bundleId_", "faTitle_", "enTitle_", "faDescription_", "enDescription_", "price_", "finalPrice_", "duration_", "isSpecial_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$PackageInfo.class) {
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

    public long getBundleId() {
        return this.bundleId_;
    }

    public long getDuration() {
        return this.duration_;
    }

    public String getEnDescription() {
        return this.enDescription_;
    }

    public AbstractC2383g getEnDescriptionBytes() {
        return AbstractC2383g.N(this.enDescription_);
    }

    public String getEnTitle() {
        return this.enTitle_;
    }

    public AbstractC2383g getEnTitleBytes() {
        return AbstractC2383g.N(this.enTitle_);
    }

    public String getFaDescription() {
        return this.faDescription_;
    }

    public AbstractC2383g getFaDescriptionBytes() {
        return AbstractC2383g.N(this.faDescription_);
    }

    public String getFaTitle() {
        return this.faTitle_;
    }

    public AbstractC2383g getFaTitleBytes() {
        return AbstractC2383g.N(this.faTitle_);
    }

    public long getFinalPrice() {
        return this.finalPrice_;
    }

    public long getId() {
        return this.id_;
    }

    public boolean getIsSpecial() {
        return this.isSpecial_;
    }

    public long getPrice() {
        return this.price_;
    }

    public static a newBuilder(PremiumStruct$PackageInfo premiumStruct$PackageInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$PackageInfo);
    }

    public static PremiumStruct$PackageInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$PackageInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$PackageInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$PackageInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$PackageInfo parseFrom(byte[] bArr) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$PackageInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$PackageInfo parseFrom(InputStream inputStream) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$PackageInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$PackageInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$PackageInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
