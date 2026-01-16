package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12759f92;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class EnrichmentStruct$OpenGraphObject extends GeneratedMessageLite implements U64 {
    private static final EnrichmentStruct$OpenGraphObject DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int IMAGES_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private String type_ = "";
    private String url_ = "";
    private String title_ = "";
    private String description_ = "";
    private B.j images_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EnrichmentStruct$OpenGraphObject.DEFAULT_INSTANCE);
        }
    }

    static {
        EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject = new EnrichmentStruct$OpenGraphObject();
        DEFAULT_INSTANCE = enrichmentStruct$OpenGraphObject;
        GeneratedMessageLite.registerDefaultInstance(EnrichmentStruct$OpenGraphObject.class, enrichmentStruct$OpenGraphObject);
    }

    private EnrichmentStruct$OpenGraphObject() {
    }

    private void addAllImages(Iterable<? extends EnrichmentStruct$OpenGraphImage> iterable) {
        ensureImagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.images_);
    }

    private void addImages(EnrichmentStruct$OpenGraphImage enrichmentStruct$OpenGraphImage) {
        enrichmentStruct$OpenGraphImage.getClass();
        ensureImagesIsMutable();
        this.images_.add(enrichmentStruct$OpenGraphImage);
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearImages() {
        this.images_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensureImagesIsMutable() {
        B.j jVar = this.images_;
        if (jVar.u()) {
            return;
        }
        this.images_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static EnrichmentStruct$OpenGraphObject getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EnrichmentStruct$OpenGraphObject parseDelimitedFrom(InputStream inputStream) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(ByteBuffer byteBuffer) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeImages(int i) {
        ensureImagesIsMutable();
        this.images_.remove(i);
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setImages(int i, EnrichmentStruct$OpenGraphImage enrichmentStruct$OpenGraphImage) {
        enrichmentStruct$OpenGraphImage.getClass();
        ensureImagesIsMutable();
        this.images_.set(i, enrichmentStruct$OpenGraphImage);
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    private void setTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.type_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P.a[gVar.ordinal()]) {
            case 1:
                return new EnrichmentStruct$OpenGraphObject();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u001b", new Object[]{"type_", "url_", "title_", "description_", "images_", EnrichmentStruct$OpenGraphImage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EnrichmentStruct$OpenGraphObject.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public EnrichmentStruct$OpenGraphImage getImages(int i) {
        return (EnrichmentStruct$OpenGraphImage) this.images_.get(i);
    }

    public int getImagesCount() {
        return this.images_.size();
    }

    public List<EnrichmentStruct$OpenGraphImage> getImagesList() {
        return this.images_;
    }

    public InterfaceC12759f92 getImagesOrBuilder(int i) {
        return (InterfaceC12759f92) this.images_.get(i);
    }

    public List<? extends InterfaceC12759f92> getImagesOrBuilderList() {
        return this.images_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getType() {
        return this.type_;
    }

    public AbstractC2383g getTypeBytes() {
        return AbstractC2383g.N(this.type_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(EnrichmentStruct$OpenGraphObject enrichmentStruct$OpenGraphObject) {
        return (a) DEFAULT_INSTANCE.createBuilder(enrichmentStruct$OpenGraphObject);
    }

    public static EnrichmentStruct$OpenGraphObject parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(AbstractC2383g abstractC2383g) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addImages(int i, EnrichmentStruct$OpenGraphImage enrichmentStruct$OpenGraphImage) {
        enrichmentStruct$OpenGraphImage.getClass();
        ensureImagesIsMutable();
        this.images_.add(i, enrichmentStruct$OpenGraphImage);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(byte[] bArr) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(byte[] bArr, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(InputStream inputStream) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(AbstractC2384h abstractC2384h) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EnrichmentStruct$OpenGraphObject parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphObject) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
