package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7048Qb;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$AdDetail extends GeneratedMessageLite implements InterfaceC7048Qb {
    public static final int ASKED_CLICK_CNT_FIELD_NUMBER = 10;
    public static final int ASKED_VIEW_CNT_FIELD_NUMBER = 7;
    public static final int CLICK_CNT_FIELD_NUMBER = 12;
    private static final AdvertisementOuterClass$AdDetail DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE_FIELD_NUMBER = 6;
    public static final int LINK_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 9;
    public static final int STATUS_FIELD_NUMBER = 8;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    public static final int VIEW_CNT_FIELD_NUMBER = 11;
    private long askedClickCnt_;
    private long askedViewCnt_;
    private long clickCnt_;
    private long startTime_;
    private int status_;
    private int userId_;
    private long viewCnt_;
    private String id_ = "";
    private String title_ = "";
    private String description_ = "";
    private String link_ = "";
    private String image_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7048Qb {
        private a() {
            super(AdvertisementOuterClass$AdDetail.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$AdDetail advertisementOuterClass$AdDetail = new AdvertisementOuterClass$AdDetail();
        DEFAULT_INSTANCE = advertisementOuterClass$AdDetail;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$AdDetail.class, advertisementOuterClass$AdDetail);
    }

    private AdvertisementOuterClass$AdDetail() {
    }

    private void clearAskedClickCnt() {
        this.askedClickCnt_ = 0L;
    }

    private void clearAskedViewCnt() {
        this.askedViewCnt_ = 0L;
    }

    private void clearClickCnt() {
        this.clickCnt_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearImage() {
        this.image_ = getDefaultInstance().getImage();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void clearViewCnt() {
        this.viewCnt_ = 0L;
    }

    public static AdvertisementOuterClass$AdDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$AdDetail parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAskedClickCnt(long j) {
        this.askedClickCnt_ = j;
    }

    private void setAskedViewCnt(long j) {
        this.askedViewCnt_ = j;
    }

    private void setClickCnt(long j) {
        this.clickCnt_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setImage(String str) {
        str.getClass();
        this.image_ = str;
    }

    private void setImageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.image_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setStatus(int i) {
        this.status_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    private void setViewCnt(long j) {
        this.viewCnt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$AdDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0004\t\u0002\n\u0002\u000b\u0002\f\u0002", new Object[]{"id_", "userId_", "title_", "description_", "link_", "image_", "askedViewCnt_", "status_", "startTime_", "askedClickCnt_", "viewCnt_", "clickCnt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$AdDetail.class) {
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

    public long getAskedClickCnt() {
        return this.askedClickCnt_;
    }

    public long getAskedViewCnt() {
        return this.askedViewCnt_;
    }

    public long getClickCnt() {
        return this.clickCnt_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getImage() {
        return this.image_;
    }

    public AbstractC2383g getImageBytes() {
        return AbstractC2383g.N(this.image_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public int getStatus() {
        return this.status_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public long getViewCnt() {
        return this.viewCnt_;
    }

    public static a newBuilder(AdvertisementOuterClass$AdDetail advertisementOuterClass$AdDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$AdDetail);
    }

    public static AdvertisementOuterClass$AdDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$AdDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$AdDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
