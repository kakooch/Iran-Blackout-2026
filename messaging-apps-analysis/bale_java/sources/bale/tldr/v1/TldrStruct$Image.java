package bale.tldr.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16196kr7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class TldrStruct$Image extends GeneratedMessageLite implements InterfaceC16196kr7 {
    public static final int ALT_FIELD_NUMBER = 4;
    private static final TldrStruct$Image DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int height_;
    private int width_;
    private String url_ = "";
    private String alt_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16196kr7 {
        private a() {
            super(TldrStruct$Image.DEFAULT_INSTANCE);
        }
    }

    static {
        TldrStruct$Image tldrStruct$Image = new TldrStruct$Image();
        DEFAULT_INSTANCE = tldrStruct$Image;
        GeneratedMessageLite.registerDefaultInstance(TldrStruct$Image.class, tldrStruct$Image);
    }

    private TldrStruct$Image() {
    }

    private void clearAlt() {
        this.alt_ = getDefaultInstance().getAlt();
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static TldrStruct$Image getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TldrStruct$Image parseDelimitedFrom(InputStream inputStream) {
        return (TldrStruct$Image) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TldrStruct$Image parseFrom(ByteBuffer byteBuffer) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAlt(String str) {
        str.getClass();
        this.alt_ = str;
    }

    private void setAltBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.alt_ = abstractC2383g.f0();
    }

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.tldr.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new TldrStruct$Image();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004Ȉ", new Object[]{"url_", "width_", "height_", "alt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TldrStruct$Image.class) {
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

    public String getAlt() {
        return this.alt_;
    }

    public AbstractC2383g getAltBytes() {
        return AbstractC2383g.N(this.alt_);
    }

    public int getHeight() {
        return this.height_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(TldrStruct$Image tldrStruct$Image) {
        return (a) DEFAULT_INSTANCE.createBuilder(tldrStruct$Image);
    }

    public static TldrStruct$Image parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TldrStruct$Image parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TldrStruct$Image parseFrom(AbstractC2383g abstractC2383g) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TldrStruct$Image parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TldrStruct$Image parseFrom(byte[] bArr) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TldrStruct$Image parseFrom(byte[] bArr, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TldrStruct$Image parseFrom(InputStream inputStream) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TldrStruct$Image parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TldrStruct$Image parseFrom(AbstractC2384h abstractC2384h) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TldrStruct$Image parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TldrStruct$Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
