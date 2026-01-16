package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4065Dn5;
import ir.nasim.InterfaceC24543yn5;
import ir.nasim.InterfaceC25137zn5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PremiumStruct$BadgeCategory extends GeneratedMessageLite implements InterfaceC24543yn5 {
    public static final int BADGES_FIELD_NUMBER = 6;
    private static final PremiumStruct$BadgeCategory DEFAULT_INSTANCE;
    public static final int EN_NAME_FIELD_NUMBER = 3;
    public static final int FA_NAME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MEDIA_FORMAT_FIELD_NUMBER = 5;
    public static final int MEDIA_URL_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private long id_;
    private int mediaFormat_;
    private String faName_ = "";
    private String enName_ = "";
    private String mediaUrl_ = "";
    private B.j badges_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24543yn5 {
        private a() {
            super(PremiumStruct$BadgeCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$BadgeCategory premiumStruct$BadgeCategory = new PremiumStruct$BadgeCategory();
        DEFAULT_INSTANCE = premiumStruct$BadgeCategory;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$BadgeCategory.class, premiumStruct$BadgeCategory);
    }

    private PremiumStruct$BadgeCategory() {
    }

    private void addAllBadges(Iterable<? extends PremiumStruct$Badge> iterable) {
        ensureBadgesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.badges_);
    }

    private void addBadges(PremiumStruct$Badge premiumStruct$Badge) {
        premiumStruct$Badge.getClass();
        ensureBadgesIsMutable();
        this.badges_.add(premiumStruct$Badge);
    }

    private void clearBadges() {
        this.badges_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearEnName() {
        this.enName_ = getDefaultInstance().getEnName();
    }

    private void clearFaName() {
        this.faName_ = getDefaultInstance().getFaName();
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearMediaFormat() {
        this.mediaFormat_ = 0;
    }

    private void clearMediaUrl() {
        this.mediaUrl_ = getDefaultInstance().getMediaUrl();
    }

    private void ensureBadgesIsMutable() {
        B.j jVar = this.badges_;
        if (jVar.u()) {
            return;
        }
        this.badges_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PremiumStruct$BadgeCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$BadgeCategory parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$BadgeCategory parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBadges(int i) {
        ensureBadgesIsMutable();
        this.badges_.remove(i);
    }

    private void setBadges(int i, PremiumStruct$Badge premiumStruct$Badge) {
        premiumStruct$Badge.getClass();
        ensureBadgesIsMutable();
        this.badges_.set(i, premiumStruct$Badge);
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

    private void setId(long j) {
        this.id_ = j;
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
                return new PremiumStruct$BadgeCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006\u001b", new Object[]{"id_", "faName_", "enName_", "mediaUrl_", "mediaFormat_", "badges_", PremiumStruct$Badge.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$BadgeCategory.class) {
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

    public PremiumStruct$Badge getBadges(int i) {
        return (PremiumStruct$Badge) this.badges_.get(i);
    }

    public int getBadgesCount() {
        return this.badges_.size();
    }

    public List<PremiumStruct$Badge> getBadgesList() {
        return this.badges_;
    }

    public InterfaceC25137zn5 getBadgesOrBuilder(int i) {
        return (InterfaceC25137zn5) this.badges_.get(i);
    }

    public List<? extends InterfaceC25137zn5> getBadgesOrBuilderList() {
        return this.badges_;
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

    public long getId() {
        return this.id_;
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

    public static a newBuilder(PremiumStruct$BadgeCategory premiumStruct$BadgeCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$BadgeCategory);
    }

    public static PremiumStruct$BadgeCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$BadgeCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$BadgeCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBadges(int i, PremiumStruct$Badge premiumStruct$Badge) {
        premiumStruct$Badge.getClass();
        ensureBadgesIsMutable();
        this.badges_.add(i, premiumStruct$Badge);
    }

    public static PremiumStruct$BadgeCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$BadgeCategory parseFrom(byte[] bArr) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$BadgeCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$BadgeCategory parseFrom(InputStream inputStream) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$BadgeCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$BadgeCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$BadgeCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$BadgeCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
