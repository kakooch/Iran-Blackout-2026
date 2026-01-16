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
public final class Tldr$RequestGetLinkSummary extends GeneratedMessageLite implements U64 {
    private static final Tldr$RequestGetLinkSummary DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tldr$RequestGetLinkSummary.DEFAULT_INSTANCE);
        }
    }

    static {
        Tldr$RequestGetLinkSummary tldr$RequestGetLinkSummary = new Tldr$RequestGetLinkSummary();
        DEFAULT_INSTANCE = tldr$RequestGetLinkSummary;
        GeneratedMessageLite.registerDefaultInstance(Tldr$RequestGetLinkSummary.class, tldr$RequestGetLinkSummary);
    }

    private Tldr$RequestGetLinkSummary() {
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static Tldr$RequestGetLinkSummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tldr$RequestGetLinkSummary parseDelimitedFrom(InputStream inputStream) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(ByteBuffer byteBuffer) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (k2.a[gVar.ordinal()]) {
            case 1:
                return new Tldr$RequestGetLinkSummary();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tldr$RequestGetLinkSummary.class) {
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

    public static a newBuilder(Tldr$RequestGetLinkSummary tldr$RequestGetLinkSummary) {
        return (a) DEFAULT_INSTANCE.createBuilder(tldr$RequestGetLinkSummary);
    }

    public static Tldr$RequestGetLinkSummary parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(AbstractC2383g abstractC2383g) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(byte[] bArr) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(InputStream inputStream) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(AbstractC2384h abstractC2384h) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tldr$RequestGetLinkSummary parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tldr$RequestGetLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
