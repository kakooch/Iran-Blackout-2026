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
public final class SefteOuterClass$ResponseSignSefte extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseSignSefte DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQ_ID_FIELD_NUMBER = 2;
    public static final int SIGNED_PDF_FIELD_NUMBER = 1;
    private String signedPdf_ = "";
    private String reqId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseSignSefte.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseSignSefte sefteOuterClass$ResponseSignSefte = new SefteOuterClass$ResponseSignSefte();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseSignSefte;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseSignSefte.class, sefteOuterClass$ResponseSignSefte);
    }

    private SefteOuterClass$ResponseSignSefte() {
    }

    private void clearReqId() {
        this.reqId_ = getDefaultInstance().getReqId();
    }

    private void clearSignedPdf() {
        this.signedPdf_ = getDefaultInstance().getSignedPdf();
    }

    public static SefteOuterClass$ResponseSignSefte getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseSignSefte parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setReqId(String str) {
        str.getClass();
        this.reqId_ = str;
    }

    private void setReqIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reqId_ = abstractC2383g.f0();
    }

    private void setSignedPdf(String str) {
        str.getClass();
        this.signedPdf_ = str;
    }

    private void setSignedPdfBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.signedPdf_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseSignSefte();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"signedPdf_", "reqId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseSignSefte.class) {
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

    public String getReqId() {
        return this.reqId_;
    }

    public AbstractC2383g getReqIdBytes() {
        return AbstractC2383g.N(this.reqId_);
    }

    public String getSignedPdf() {
        return this.signedPdf_;
    }

    public AbstractC2383g getSignedPdfBytes() {
        return AbstractC2383g.N(this.signedPdf_);
    }

    public static a newBuilder(SefteOuterClass$ResponseSignSefte sefteOuterClass$ResponseSignSefte) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseSignSefte);
    }

    public static SefteOuterClass$ResponseSignSefte parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseSignSefte parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseSignSefte) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
