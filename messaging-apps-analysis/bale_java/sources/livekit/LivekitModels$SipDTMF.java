package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$SipDTMF extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 3;
    private static final LivekitModels$SipDTMF DEFAULT_INSTANCE;
    public static final int DIGIT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int code_;
    private String digit_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$SipDTMF.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$SipDTMF livekitModels$SipDTMF = new LivekitModels$SipDTMF();
        DEFAULT_INSTANCE = livekitModels$SipDTMF;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$SipDTMF.class, livekitModels$SipDTMF);
    }

    private LivekitModels$SipDTMF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDigit() {
        this.digit_ = getDefaultInstance().getDigit();
    }

    public static LivekitModels$SipDTMF getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$SipDTMF parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SipDTMF parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDigit(String str) {
        str.getClass();
        this.digit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDigitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.digit_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$SipDTMF();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0003\u0004\u0002\u0000\u0000\u0000\u0003\u000b\u0004Ȉ", new Object[]{"code_", "digit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$SipDTMF.class) {
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

    public int getCode() {
        return this.code_;
    }

    public String getDigit() {
        return this.digit_;
    }

    public AbstractC2383g getDigitBytes() {
        return AbstractC2383g.N(this.digit_);
    }

    public static a newBuilder(LivekitModels$SipDTMF livekitModels$SipDTMF) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$SipDTMF);
    }

    public static LivekitModels$SipDTMF parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SipDTMF parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$SipDTMF parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$SipDTMF parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$SipDTMF parseFrom(byte[] bArr) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$SipDTMF parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$SipDTMF parseFrom(InputStream inputStream) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$SipDTMF parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$SipDTMF parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$SipDTMF parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$SipDTMF) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
