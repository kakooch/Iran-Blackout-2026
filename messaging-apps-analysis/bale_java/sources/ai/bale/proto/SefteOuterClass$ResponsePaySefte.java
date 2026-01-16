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

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponsePaySefte extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponsePaySefte DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponsePaySefte.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponsePaySefte sefteOuterClass$ResponsePaySefte = new SefteOuterClass$ResponsePaySefte();
        DEFAULT_INSTANCE = sefteOuterClass$ResponsePaySefte;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponsePaySefte.class, sefteOuterClass$ResponsePaySefte);
    }

    private SefteOuterClass$ResponsePaySefte() {
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static SefteOuterClass$ResponsePaySefte getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponsePaySefte parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponsePaySefte();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponsePaySefte.class) {
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

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(SefteOuterClass$ResponsePaySefte sefteOuterClass$ResponsePaySefte) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponsePaySefte);
    }

    public static SefteOuterClass$ResponsePaySefte parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponsePaySefte parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponsePaySefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
