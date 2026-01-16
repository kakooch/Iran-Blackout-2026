package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4065Dn5;
import ir.nasim.InterfaceC25137zn5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$Badge extends GeneratedMessageLite implements InterfaceC25137zn5 {
    public static final int BADGE_ID_FIELD_NUMBER = 1;
    private static final PremiumStruct$Badge DEFAULT_INSTANCE;
    public static final int EN_NAME_FIELD_NUMBER = 3;
    public static final int FA_NAME_FIELD_NUMBER = 2;
    public static final int MEDIA_FORMAT_FIELD_NUMBER = 5;
    public static final int MEDIA_URL_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private long badgeId_;
    private int mediaFormat_;
    private String faName_ = "";
    private String enName_ = "";
    private String mediaUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC25137zn5 {
        private a() {
            super(PremiumStruct$Badge.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$Badge premiumStruct$Badge = new PremiumStruct$Badge();
        DEFAULT_INSTANCE = premiumStruct$Badge;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$Badge.class, premiumStruct$Badge);
    }

    private PremiumStruct$Badge() {
    }

    private void clearBadgeId() {
        this.badgeId_ = 0L;
    }

    private void clearEnName() {
        this.enName_ = getDefaultInstance().getEnName();
    }

    private void clearFaName() {
        this.faName_ = getDefaultInstance().getFaName();
    }

    private void clearMediaFormat() {
        this.mediaFormat_ = 0;
    }

    private void clearMediaUrl() {
        this.mediaUrl_ = getDefaultInstance().getMediaUrl();
    }

    public static PremiumStruct$Badge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$Badge parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$Badge parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBadgeId(long j) {
        this.badgeId_ = j;
    }

    private void setEnName(String str) {
        str.getClass();
        this.enName_ = str;
    }

    private void setEnNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enName_ = abstractC2383g.f0();
    }

    private void setFaName(String str) {
        str.getClass();
        this.faName_ = str;
    }

    private void setFaNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.faName_ = abstractC2383g.f0();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$Badge();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f", new Object[]{"badgeId_", "faName_", "enName_", "mediaUrl_", "mediaFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$Badge.class) {
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

    public long getBadgeId() {
        return this.badgeId_;
    }

    public String getEnName() {
        return this.enName_;
    }

    public AbstractC2383g getEnNameBytes() {
        return AbstractC2383g.N(this.enName_);
    }

    public String getFaName() {
        return this.faName_;
    }

    public AbstractC2383g getFaNameBytes() {
        return AbstractC2383g.N(this.faName_);
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

    public static a newBuilder(PremiumStruct$Badge premiumStruct$Badge) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$Badge);
    }

    public static PremiumStruct$Badge parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$Badge parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$Badge parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$Badge parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$Badge parseFrom(byte[] bArr) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$Badge parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$Badge parseFrom(InputStream inputStream) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$Badge parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$Badge parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$Badge parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$Badge) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
