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
public final class SentenceOuterClass$RequestValidateMySentence extends GeneratedMessageLite implements U64 {
    private static final SentenceOuterClass$RequestValidateMySentence DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SENTENCE_FIELD_NUMBER = 1;
    private String sentence_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$RequestValidateMySentence.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$RequestValidateMySentence sentenceOuterClass$RequestValidateMySentence = new SentenceOuterClass$RequestValidateMySentence();
        DEFAULT_INSTANCE = sentenceOuterClass$RequestValidateMySentence;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$RequestValidateMySentence.class, sentenceOuterClass$RequestValidateMySentence);
    }

    private SentenceOuterClass$RequestValidateMySentence() {
    }

    private void clearSentence() {
        this.sentence_ = getDefaultInstance().getSentence();
    }

    public static SentenceOuterClass$RequestValidateMySentence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$RequestValidateMySentence parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSentence(String str) {
        str.getClass();
        this.sentence_ = str;
    }

    private void setSentenceBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sentence_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$RequestValidateMySentence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"sentence_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$RequestValidateMySentence.class) {
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

    public String getSentence() {
        return this.sentence_;
    }

    public AbstractC2383g getSentenceBytes() {
        return AbstractC2383g.N(this.sentence_);
    }

    public static a newBuilder(SentenceOuterClass$RequestValidateMySentence sentenceOuterClass$RequestValidateMySentence) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$RequestValidateMySentence);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(byte[] bArr) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$RequestValidateMySentence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$RequestValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
