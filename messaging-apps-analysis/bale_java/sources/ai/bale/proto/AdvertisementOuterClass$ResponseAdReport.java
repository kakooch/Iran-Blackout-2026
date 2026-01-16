package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseAdReport extends GeneratedMessageLite implements U64 {
    public static final int CLICKS_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$ResponseAdReport DEFAULT_INSTANCE;
    public static final int LINK_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int VIEWS_FIELD_NUMBER = 1;
    private long clicks_;
    private long views_;
    private String title_ = "";
    private String link_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseAdReport.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseAdReport advertisementOuterClass$ResponseAdReport = new AdvertisementOuterClass$ResponseAdReport();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseAdReport;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseAdReport.class, advertisementOuterClass$ResponseAdReport);
    }

    private AdvertisementOuterClass$ResponseAdReport() {
    }

    private void clearClicks() {
        this.clicks_ = 0L;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearViews() {
        this.views_ = 0L;
    }

    public static AdvertisementOuterClass$ResponseAdReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseAdReport parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClicks(long j) {
        this.clicks_ = j;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setViews(long j) {
        this.views_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseAdReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004Ȉ", new Object[]{"views_", "clicks_", "title_", "link_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseAdReport.class) {
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

    public long getClicks() {
        return this.clicks_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public long getViews() {
        return this.views_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseAdReport advertisementOuterClass$ResponseAdReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseAdReport);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseAdReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseAdReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
