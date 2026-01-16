package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SentenceOuterClass$ResponseGetMySentence extends GeneratedMessageLite implements U64 {
    private static final SentenceOuterClass$ResponseGetMySentence DEFAULT_INSTANCE;
    public static final int IS_VALIDATED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHRASES_FIELD_NUMBER = 1;
    public static final int SENTENCE_FIELD_NUMBER = 3;
    private boolean isValidated_;
    private B.j phrases_ = GeneratedMessageLite.emptyProtobufList();
    private String sentence_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$ResponseGetMySentence.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$ResponseGetMySentence sentenceOuterClass$ResponseGetMySentence = new SentenceOuterClass$ResponseGetMySentence();
        DEFAULT_INSTANCE = sentenceOuterClass$ResponseGetMySentence;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$ResponseGetMySentence.class, sentenceOuterClass$ResponseGetMySentence);
    }

    private SentenceOuterClass$ResponseGetMySentence() {
    }

    private void addAllPhrases(Iterable<String> iterable) {
        ensurePhrasesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.phrases_);
    }

    private void addPhrases(String str) {
        str.getClass();
        ensurePhrasesIsMutable();
        this.phrases_.add(str);
    }

    private void addPhrasesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensurePhrasesIsMutable();
        this.phrases_.add(abstractC2383g.f0());
    }

    private void clearIsValidated() {
        this.isValidated_ = false;
    }

    private void clearPhrases() {
        this.phrases_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSentence() {
        this.sentence_ = getDefaultInstance().getSentence();
    }

    private void ensurePhrasesIsMutable() {
        B.j jVar = this.phrases_;
        if (jVar.u()) {
            return;
        }
        this.phrases_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SentenceOuterClass$ResponseGetMySentence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$ResponseGetMySentence parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsValidated(boolean z) {
        this.isValidated_ = z;
    }

    private void setPhrases(int i, String str) {
        str.getClass();
        ensurePhrasesIsMutable();
        this.phrases_.set(i, str);
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
                return new SentenceOuterClass$ResponseGetMySentence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ț\u0002\u0007\u0003Ȉ", new Object[]{"phrases_", "isValidated_", "sentence_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$ResponseGetMySentence.class) {
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

    public boolean getIsValidated() {
        return this.isValidated_;
    }

    public String getPhrases(int i) {
        return (String) this.phrases_.get(i);
    }

    public AbstractC2383g getPhrasesBytes(int i) {
        return AbstractC2383g.N((String) this.phrases_.get(i));
    }

    public int getPhrasesCount() {
        return this.phrases_.size();
    }

    public List<String> getPhrasesList() {
        return this.phrases_;
    }

    public String getSentence() {
        return this.sentence_;
    }

    public AbstractC2383g getSentenceBytes() {
        return AbstractC2383g.N(this.sentence_);
    }

    public static a newBuilder(SentenceOuterClass$ResponseGetMySentence sentenceOuterClass$ResponseGetMySentence) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$ResponseGetMySentence);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(byte[] bArr) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$ResponseGetMySentence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMySentence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
