package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC9852ag;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestCreateAndStartChannelAd extends GeneratedMessageLite implements U64 {
    public static final int CLICK_COUNT_FIELD_NUMBER = 6;
    private static final AdvertisementOuterClass$RequestCreateAndStartChannelAd DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int LINK_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PLATFORM_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int VIEW_COUNT_FIELD_NUMBER = 5;
    private int clickCount_;
    private int platform_;
    private long startTime_;
    private int viewCount_;
    private String title_ = "";
    private String description_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestCreateAndStartChannelAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestCreateAndStartChannelAd advertisementOuterClass$RequestCreateAndStartChannelAd = new AdvertisementOuterClass$RequestCreateAndStartChannelAd();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestCreateAndStartChannelAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestCreateAndStartChannelAd.class, advertisementOuterClass$RequestCreateAndStartChannelAd);
    }

    private AdvertisementOuterClass$RequestCreateAndStartChannelAd() {
    }

    private void clearClickCount() {
        this.clickCount_ = 0;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearPlatform() {
        this.platform_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearViewCount() {
        this.viewCount_ = 0;
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClickCount(int i) {
        this.clickCount_ = i;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setPlatform(EnumC9852ag enumC9852ag) {
        this.platform_ = enumC9852ag.getNumber();
    }

    private void setPlatformValue(int i) {
        this.platform_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setViewCount(int i) {
        this.viewCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestCreateAndStartChannelAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005\u0004\u0006\u0004\u0007\u0002", new Object[]{"title_", "description_", "link_", "platform_", "viewCount_", "clickCount_", "startTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestCreateAndStartChannelAd.class) {
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

    public int getClickCount() {
        return this.clickCount_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public EnumC9852ag getPlatform() {
        EnumC9852ag enumC9852agJ = EnumC9852ag.j(this.platform_);
        return enumC9852agJ == null ? EnumC9852ag.UNRECOGNIZED : enumC9852agJ;
    }

    public int getPlatformValue() {
        return this.platform_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getViewCount() {
        return this.viewCount_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestCreateAndStartChannelAd advertisementOuterClass$RequestCreateAndStartChannelAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestCreateAndStartChannelAd);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestCreateAndStartChannelAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateAndStartChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
