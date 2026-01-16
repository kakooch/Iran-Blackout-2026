package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3692By1;
import ir.nasim.InterfaceC4160Dy1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeStruct$NewsInfo extends GeneratedMessageLite implements InterfaceC4160Dy1 {
    public static final int CATEGORY_FIELD_NUMBER = 8;
    private static final DakeStruct$NewsInfo DEFAULT_INSTANCE;
    public static final int HAS_LIKED_FIELD_NUMBER = 10;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE_URL_FIELD_NUMBER = 5;
    public static final int LINK_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PUBLISHED_TIME_FIELD_NUMBER = 6;
    public static final int RSS_NAME_FIELD_NUMBER = 9;
    public static final int SUMMARY_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int VECTOR_FIELD_NUMBER = 7;
    private int category_;
    private boolean hasLiked_;
    private long publishedTime_;
    private String id_ = "";
    private String title_ = "";
    private String summary_ = "";
    private String link_ = "";
    private String imageUrl_ = "";
    private String vector_ = "";
    private String rssName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4160Dy1 {
        private a() {
            super(DakeStruct$NewsInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeStruct$NewsInfo dakeStruct$NewsInfo = new DakeStruct$NewsInfo();
        DEFAULT_INSTANCE = dakeStruct$NewsInfo;
        GeneratedMessageLite.registerDefaultInstance(DakeStruct$NewsInfo.class, dakeStruct$NewsInfo);
    }

    private DakeStruct$NewsInfo() {
    }

    private void clearCategory() {
        this.category_ = 0;
    }

    private void clearHasLiked() {
        this.hasLiked_ = false;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearImageUrl() {
        this.imageUrl_ = getDefaultInstance().getImageUrl();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearPublishedTime() {
        this.publishedTime_ = 0L;
    }

    private void clearRssName() {
        this.rssName_ = getDefaultInstance().getRssName();
    }

    private void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearVector() {
        this.vector_ = getDefaultInstance().getVector();
    }

    public static DakeStruct$NewsInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeStruct$NewsInfo parseDelimitedFrom(InputStream inputStream) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$NewsInfo parseFrom(ByteBuffer byteBuffer) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategory(EnumC3692By1 enumC3692By1) {
        this.category_ = enumC3692By1.getNumber();
    }

    private void setCategoryValue(int i) {
        this.category_ = i;
    }

    private void setHasLiked(boolean z) {
        this.hasLiked_ = z;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setImageUrl(String str) {
        str.getClass();
        this.imageUrl_ = str;
    }

    private void setImageUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.imageUrl_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setPublishedTime(long j) {
        this.publishedTime_ = j;
    }

    private void setRssName(String str) {
        str.getClass();
        this.rssName_ = str;
    }

    private void setRssNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rssName_ = abstractC2383g.f0();
    }

    private void setSummary(String str) {
        str.getClass();
        this.summary_ = str;
    }

    private void setSummaryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.summary_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setVector(String str) {
        str.getClass();
        this.vector_ = str;
    }

    private void setVectorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.vector_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N.a[gVar.ordinal()]) {
            case 1:
                return new DakeStruct$NewsInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0002\u0007Ȉ\b\f\tȈ\n\u0007", new Object[]{"id_", "title_", "summary_", "link_", "imageUrl_", "publishedTime_", "vector_", "category_", "rssName_", "hasLiked_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeStruct$NewsInfo.class) {
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

    public EnumC3692By1 getCategory() {
        EnumC3692By1 enumC3692By1J = EnumC3692By1.j(this.category_);
        return enumC3692By1J == null ? EnumC3692By1.UNRECOGNIZED : enumC3692By1J;
    }

    public int getCategoryValue() {
        return this.category_;
    }

    public boolean getHasLiked() {
        return this.hasLiked_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public AbstractC2383g getImageUrlBytes() {
        return AbstractC2383g.N(this.imageUrl_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public long getPublishedTime() {
        return this.publishedTime_;
    }

    public String getRssName() {
        return this.rssName_;
    }

    public AbstractC2383g getRssNameBytes() {
        return AbstractC2383g.N(this.rssName_);
    }

    public String getSummary() {
        return this.summary_;
    }

    public AbstractC2383g getSummaryBytes() {
        return AbstractC2383g.N(this.summary_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getVector() {
        return this.vector_;
    }

    public AbstractC2383g getVectorBytes() {
        return AbstractC2383g.N(this.vector_);
    }

    public static a newBuilder(DakeStruct$NewsInfo dakeStruct$NewsInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeStruct$NewsInfo);
    }

    public static DakeStruct$NewsInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$NewsInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeStruct$NewsInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeStruct$NewsInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeStruct$NewsInfo parseFrom(byte[] bArr) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeStruct$NewsInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeStruct$NewsInfo parseFrom(InputStream inputStream) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$NewsInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$NewsInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeStruct$NewsInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeStruct$NewsInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
