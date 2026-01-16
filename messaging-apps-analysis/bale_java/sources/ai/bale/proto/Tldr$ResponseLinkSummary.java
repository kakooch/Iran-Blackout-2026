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
public final class Tldr$ResponseLinkSummary extends GeneratedMessageLite implements U64 {
    private static final Tldr$ResponseLinkSummary DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private String summary_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tldr$ResponseLinkSummary.DEFAULT_INSTANCE);
        }
    }

    static {
        Tldr$ResponseLinkSummary tldr$ResponseLinkSummary = new Tldr$ResponseLinkSummary();
        DEFAULT_INSTANCE = tldr$ResponseLinkSummary;
        GeneratedMessageLite.registerDefaultInstance(Tldr$ResponseLinkSummary.class, tldr$ResponseLinkSummary);
    }

    private Tldr$ResponseLinkSummary() {
    }

    private void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    public static Tldr$ResponseLinkSummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tldr$ResponseLinkSummary parseDelimitedFrom(InputStream inputStream) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$ResponseLinkSummary parseFrom(ByteBuffer byteBuffer) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSummary(String str) {
        str.getClass();
        this.summary_ = str;
    }

    private void setSummaryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.summary_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (k2.a[gVar.ordinal()]) {
            case 1:
                return new Tldr$ResponseLinkSummary();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"summary_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tldr$ResponseLinkSummary.class) {
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

    public String getSummary() {
        return this.summary_;
    }

    public AbstractC2383g getSummaryBytes() {
        return AbstractC2383g.N(this.summary_);
    }

    public static a newBuilder(Tldr$ResponseLinkSummary tldr$ResponseLinkSummary) {
        return (a) DEFAULT_INSTANCE.createBuilder(tldr$ResponseLinkSummary);
    }

    public static Tldr$ResponseLinkSummary parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$ResponseLinkSummary parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tldr$ResponseLinkSummary parseFrom(AbstractC2383g abstractC2383g) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tldr$ResponseLinkSummary parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tldr$ResponseLinkSummary parseFrom(byte[] bArr) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tldr$ResponseLinkSummary parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tldr$ResponseLinkSummary parseFrom(InputStream inputStream) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tldr$ResponseLinkSummary parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tldr$ResponseLinkSummary parseFrom(AbstractC2384h abstractC2384h) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tldr$ResponseLinkSummary parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tldr$ResponseLinkSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
