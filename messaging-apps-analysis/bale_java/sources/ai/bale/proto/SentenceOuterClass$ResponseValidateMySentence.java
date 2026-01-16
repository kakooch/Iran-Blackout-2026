package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SentenceOuterClass$ResponseValidateMySentence extends GeneratedMessageLite implements U64 {
    private static final SentenceOuterClass$ResponseValidateMySentence DEFAULT_INSTANCE;
    public static final int IS_VALID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isValid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$ResponseValidateMySentence.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$ResponseValidateMySentence sentenceOuterClass$ResponseValidateMySentence = new SentenceOuterClass$ResponseValidateMySentence();
        DEFAULT_INSTANCE = sentenceOuterClass$ResponseValidateMySentence;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$ResponseValidateMySentence.class, sentenceOuterClass$ResponseValidateMySentence);
    }

    private SentenceOuterClass$ResponseValidateMySentence() {
    }

    private void clearIsValid() {
        this.isValid_ = false;
    }

    public static SentenceOuterClass$ResponseValidateMySentence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsValid(boolean z) {
        this.isValid_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$ResponseValidateMySentence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"isValid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$ResponseValidateMySentence.class) {
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

    public boolean getIsValid() {
        return this.isValid_;
    }

    public static a newBuilder(SentenceOuterClass$ResponseValidateMySentence sentenceOuterClass$ResponseValidateMySentence) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$ResponseValidateMySentence);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(byte[] bArr) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$ResponseValidateMySentence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$ResponseValidateMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
