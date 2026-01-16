package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonAction;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonBanner extends GeneratedMessageLite implements InterfaceC1853f0 {
    public static final int ACTION_FIELD_NUMBER = 1;
    private static final GarsonStruct$GarsonBanner DEFAULT_INSTANCE;
    public static final int FILE_ID_BANNER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 2;
    private GarsonStruct$GarsonAction action_;
    private int bitField0_;
    private int fileIdBanner_;
    private int imageCase_ = 0;
    private Object image_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1853f0 {
        private a() {
            super(GarsonStruct$GarsonBanner.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        URL(2),
        IMAGE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return IMAGE_NOT_SET;
            }
            if (i != 2) {
                return null;
            }
            return URL;
        }
    }

    static {
        GarsonStruct$GarsonBanner garsonStruct$GarsonBanner = new GarsonStruct$GarsonBanner();
        DEFAULT_INSTANCE = garsonStruct$GarsonBanner;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonBanner.class, garsonStruct$GarsonBanner);
    }

    private GarsonStruct$GarsonBanner() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileIdBanner() {
        this.fileIdBanner_ = 0;
    }

    private void clearImage() {
        this.imageCase_ = 0;
        this.image_ = null;
    }

    private void clearUrl() {
        if (this.imageCase_ == 2) {
            this.imageCase_ = 0;
            this.image_ = null;
        }
    }

    public static GarsonStruct$GarsonBanner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(GarsonStruct$GarsonAction garsonStruct$GarsonAction) {
        garsonStruct$GarsonAction.getClass();
        GarsonStruct$GarsonAction garsonStruct$GarsonAction2 = this.action_;
        if (garsonStruct$GarsonAction2 == null || garsonStruct$GarsonAction2 == GarsonStruct$GarsonAction.getDefaultInstance()) {
            this.action_ = garsonStruct$GarsonAction;
        } else {
            this.action_ = (GarsonStruct$GarsonAction) ((GarsonStruct$GarsonAction.a) GarsonStruct$GarsonAction.newBuilder(this.action_).v(garsonStruct$GarsonAction)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonBanner parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBanner parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(GarsonStruct$GarsonAction garsonStruct$GarsonAction) {
        garsonStruct$GarsonAction.getClass();
        this.action_ = garsonStruct$GarsonAction;
        this.bitField0_ |= 1;
    }

    private void setFileIdBanner(int i) {
        this.fileIdBanner_ = i;
    }

    private void setUrl(String str) {
        str.getClass();
        this.imageCase_ = 2;
        this.image_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.image_ = abstractC2383g.f0();
        this.imageCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonBanner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȼ\u0000\u0003\u0004", new Object[]{"image_", "imageCase_", "bitField0_", "action_", "fileIdBanner_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonBanner.class) {
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

    public GarsonStruct$GarsonAction getAction() {
        GarsonStruct$GarsonAction garsonStruct$GarsonAction = this.action_;
        return garsonStruct$GarsonAction == null ? GarsonStruct$GarsonAction.getDefaultInstance() : garsonStruct$GarsonAction;
    }

    public int getFileIdBanner() {
        return this.fileIdBanner_;
    }

    public b getImageCase() {
        return b.j(this.imageCase_);
    }

    public String getUrl() {
        return this.imageCase_ == 2 ? (String) this.image_ : "";
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.imageCase_ == 2 ? (String) this.image_ : "");
    }

    public boolean hasAction() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUrl() {
        return this.imageCase_ == 2;
    }

    public static a newBuilder(GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonBanner);
    }

    public static GarsonStruct$GarsonBanner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBanner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonBanner parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonBanner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonBanner parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonBanner parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonBanner parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBanner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBanner parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonBanner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
