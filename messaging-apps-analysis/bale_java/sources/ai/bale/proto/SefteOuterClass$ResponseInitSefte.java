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
public final class SefteOuterClass$ResponseInitSefte extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseInitSefte DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PDF_FIELD_NUMBER = 1;
    public static final int REQ_ID_FIELD_NUMBER = 2;
    private String pdf_ = "";
    private String reqId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseInitSefte.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseInitSefte sefteOuterClass$ResponseInitSefte = new SefteOuterClass$ResponseInitSefte();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseInitSefte;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseInitSefte.class, sefteOuterClass$ResponseInitSefte);
    }

    private SefteOuterClass$ResponseInitSefte() {
    }

    private void clearPdf() {
        this.pdf_ = getDefaultInstance().getPdf();
    }

    private void clearReqId() {
        this.reqId_ = getDefaultInstance().getReqId();
    }

    public static SefteOuterClass$ResponseInitSefte getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseInitSefte parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPdf(String str) {
        str.getClass();
        this.pdf_ = str;
    }

    private void setPdfBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pdf_ = abstractC2383g.f0();
    }

    private void setReqId(String str) {
        str.getClass();
        this.reqId_ = str;
    }

    private void setReqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reqId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseInitSefte();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"pdf_", "reqId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseInitSefte.class) {
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

    public String getPdf() {
        return this.pdf_;
    }

    public AbstractC2383g getPdfBytes() {
        return AbstractC2383g.N(this.pdf_);
    }

    public String getReqId() {
        return this.reqId_;
    }

    public AbstractC2383g getReqIdBytes() {
        return AbstractC2383g.N(this.reqId_);
    }

    public static a newBuilder(SefteOuterClass$ResponseInitSefte sefteOuterClass$ResponseInitSefte) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseInitSefte);
    }

    public static SefteOuterClass$ResponseInitSefte parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseInitSefte parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseInitSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
