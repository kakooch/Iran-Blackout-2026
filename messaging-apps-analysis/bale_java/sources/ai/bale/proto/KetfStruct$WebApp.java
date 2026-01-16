package ai.bale.proto;

import ai.bale.proto.FilesStruct$ImageLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13189fo3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$WebApp extends GeneratedMessageLite implements InterfaceC13189fo3 {
    private static final KetfStruct$WebApp DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int IMAGE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SHORT_NAME_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private FilesStruct$ImageLocation image_;
    private String url_ = "";
    private String shortName_ = "";
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13189fo3 {
        private a() {
            super(KetfStruct$WebApp.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$WebApp ketfStruct$WebApp = new KetfStruct$WebApp();
        DEFAULT_INSTANCE = ketfStruct$WebApp;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$WebApp.class, ketfStruct$WebApp);
    }

    private KetfStruct$WebApp() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearImage() {
        this.image_ = null;
        this.bitField0_ &= -2;
    }

    private void clearShortName() {
        this.shortName_ = getDefaultInstance().getShortName();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static KetfStruct$WebApp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeImage(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        FilesStruct$ImageLocation filesStruct$ImageLocation2 = this.image_;
        if (filesStruct$ImageLocation2 == null || filesStruct$ImageLocation2 == FilesStruct$ImageLocation.getDefaultInstance()) {
            this.image_ = filesStruct$ImageLocation;
        } else {
            this.image_ = (FilesStruct$ImageLocation) ((FilesStruct$ImageLocation.a) FilesStruct$ImageLocation.newBuilder(this.image_).v(filesStruct$ImageLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$WebApp parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$WebApp parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setImage(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        filesStruct$ImageLocation.getClass();
        this.image_ = filesStruct$ImageLocation;
        this.bitField0_ |= 1;
    }

    private void setShortName(String str) {
        str.getClass();
        this.shortName_ = str;
    }

    private void setShortNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.shortName_ = abstractC2383g.f0();
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
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
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$WebApp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000", new Object[]{"bitField0_", "url_", "shortName_", "title_", "description_", "image_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$WebApp.class) {
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

    public FilesStruct$ImageLocation getImage() {
        FilesStruct$ImageLocation filesStruct$ImageLocation = this.image_;
        return filesStruct$ImageLocation == null ? FilesStruct$ImageLocation.getDefaultInstance() : filesStruct$ImageLocation;
    }

    public String getShortName() {
        return this.shortName_;
    }

    public AbstractC2383g getShortNameBytes() {
        return AbstractC2383g.N(this.shortName_);
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasImage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfStruct$WebApp ketfStruct$WebApp) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$WebApp);
    }

    public static KetfStruct$WebApp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$WebApp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$WebApp parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$WebApp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$WebApp parseFrom(byte[] bArr) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$WebApp parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$WebApp parseFrom(InputStream inputStream) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$WebApp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$WebApp parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$WebApp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$WebApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
