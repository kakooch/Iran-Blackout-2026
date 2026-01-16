package ai.bale.proto;

import bale.tldr.v1.TldrStruct$Image;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16196kr7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Tldr$ResponseLinkPreview extends GeneratedMessageLite implements U64 {
    private static final Tldr$ResponseLinkPreview DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int IMAGES_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";
    private String description_ = "";
    private B.j images_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tldr$ResponseLinkPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        Tldr$ResponseLinkPreview tldr$ResponseLinkPreview = new Tldr$ResponseLinkPreview();
        DEFAULT_INSTANCE = tldr$ResponseLinkPreview;
        GeneratedMessageLite.registerDefaultInstance(Tldr$ResponseLinkPreview.class, tldr$ResponseLinkPreview);
    }

    private Tldr$ResponseLinkPreview() {
    }

    private void addAllImages(Iterable<? extends TldrStruct$Image> iterable) {
        ensureImagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.images_);
    }

    private void addImages(TldrStruct$Image tldrStruct$Image) {
        tldrStruct$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(tldrStruct$Image);
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

    private void ensureImagesIsMutable() {
        B.j jVar = this.images_;
        if (jVar.u()) {
            return;
        }
        this.images_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Tldr$ResponseLinkPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tldr$ResponseLinkPreview parseDelimitedFrom(InputStream inputStream) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$ResponseLinkPreview parseFrom(ByteBuffer byteBuffer) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setImages(int i, TldrStruct$Image tldrStruct$Image) {
        tldrStruct$Image.getClass();
        ensureImagesIsMutable();
        this.images_.set(i, tldrStruct$Image);
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (k2.a[gVar.ordinal()]) {
            case 1:
                return new Tldr$ResponseLinkPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"title_", "description_", "images_", TldrStruct$Image.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tldr$ResponseLinkPreview.class) {
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

    public TldrStruct$Image getImages(int i) {
        return (TldrStruct$Image) this.images_.get(i);
    }

    public int getImagesCount() {
        return this.images_.size();
    }

    public List<TldrStruct$Image> getImagesList() {
        return this.images_;
    }

    public InterfaceC16196kr7 getImagesOrBuilder(int i) {
        return (InterfaceC16196kr7) this.images_.get(i);
    }

    public List<? extends InterfaceC16196kr7> getImagesOrBuilderList() {
        return this.images_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(Tldr$ResponseLinkPreview tldr$ResponseLinkPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(tldr$ResponseLinkPreview);
    }

    public static Tldr$ResponseLinkPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$ResponseLinkPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tldr$ResponseLinkPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addImages(int i, TldrStruct$Image tldrStruct$Image) {
        tldrStruct$Image.getClass();
        ensureImagesIsMutable();
        this.images_.add(i, tldrStruct$Image);
    }

    public static Tldr$ResponseLinkPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tldr$ResponseLinkPreview parseFrom(byte[] bArr) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tldr$ResponseLinkPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tldr$ResponseLinkPreview parseFrom(InputStream inputStream) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$ResponseLinkPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$ResponseLinkPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tldr$ResponseLinkPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tldr$ResponseLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
