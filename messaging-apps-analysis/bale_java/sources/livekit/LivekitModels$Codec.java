package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$Codec extends GeneratedMessageLite implements PE3 {
    private static final LivekitModels$Codec DEFAULT_INSTANCE;
    public static final int FMTP_LINE_FIELD_NUMBER = 2;
    public static final int MIME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String mime_ = "";
    private String fmtpLine_ = "";

    public static final class a extends GeneratedMessageLite.b implements PE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$Codec.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$Codec livekitModels$Codec = new LivekitModels$Codec();
        DEFAULT_INSTANCE = livekitModels$Codec;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$Codec.class, livekitModels$Codec);
    }

    private LivekitModels$Codec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFmtpLine() {
        this.fmtpLine_ = getDefaultInstance().getFmtpLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMime() {
        this.mime_ = getDefaultInstance().getMime();
    }

    public static LivekitModels$Codec getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$Codec parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Codec parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFmtpLine(String str) {
        str.getClass();
        this.fmtpLine_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFmtpLineBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fmtpLine_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMime(String str) {
        str.getClass();
        this.mime_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mime_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$Codec();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"mime_", "fmtpLine_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$Codec.class) {
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

    public String getFmtpLine() {
        return this.fmtpLine_;
    }

    public AbstractC2383g getFmtpLineBytes() {
        return AbstractC2383g.N(this.fmtpLine_);
    }

    public String getMime() {
        return this.mime_;
    }

    public AbstractC2383g getMimeBytes() {
        return AbstractC2383g.N(this.mime_);
    }

    public static a newBuilder(LivekitModels$Codec livekitModels$Codec) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$Codec);
    }

    public static LivekitModels$Codec parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Codec parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$Codec parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$Codec parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$Codec parseFrom(byte[] bArr) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$Codec parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$Codec parseFrom(InputStream inputStream) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Codec parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Codec parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$Codec parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$Codec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
