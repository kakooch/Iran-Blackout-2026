package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3458Ay6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SharedMediaOuterClass$ResponseLoadMedia extends GeneratedMessageLite implements U64 {
    private static final SharedMediaOuterClass$ResponseLoadMedia DEFAULT_INSTANCE;
    public static final int MEDIA_RESULTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j mediaResults_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SharedMediaOuterClass$ResponseLoadMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SharedMediaOuterClass$ResponseLoadMedia sharedMediaOuterClass$ResponseLoadMedia = new SharedMediaOuterClass$ResponseLoadMedia();
        DEFAULT_INSTANCE = sharedMediaOuterClass$ResponseLoadMedia;
        GeneratedMessageLite.registerDefaultInstance(SharedMediaOuterClass$ResponseLoadMedia.class, sharedMediaOuterClass$ResponseLoadMedia);
    }

    private SharedMediaOuterClass$ResponseLoadMedia() {
    }

    private void addAllMediaResults(Iterable<? extends SharedMediaStruct$MessageMediaResult> iterable) {
        ensureMediaResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.mediaResults_);
    }

    private void addMediaResults(SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult) {
        sharedMediaStruct$MessageMediaResult.getClass();
        ensureMediaResultsIsMutable();
        this.mediaResults_.add(sharedMediaStruct$MessageMediaResult);
    }

    private void clearMediaResults() {
        this.mediaResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMediaResultsIsMutable() {
        B.j jVar = this.mediaResults_;
        if (jVar.u()) {
            return;
        }
        this.mediaResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseDelimitedFrom(InputStream inputStream) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(ByteBuffer byteBuffer) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMediaResults(int i) {
        ensureMediaResultsIsMutable();
        this.mediaResults_.remove(i);
    }

    private void setMediaResults(int i, SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult) {
        sharedMediaStruct$MessageMediaResult.getClass();
        ensureMediaResultsIsMutable();
        this.mediaResults_.set(i, sharedMediaStruct$MessageMediaResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (a2.a[gVar.ordinal()]) {
            case 1:
                return new SharedMediaOuterClass$ResponseLoadMedia();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"mediaResults_", SharedMediaStruct$MessageMediaResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SharedMediaOuterClass$ResponseLoadMedia.class) {
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

    public SharedMediaStruct$MessageMediaResult getMediaResults(int i) {
        return (SharedMediaStruct$MessageMediaResult) this.mediaResults_.get(i);
    }

    public int getMediaResultsCount() {
        return this.mediaResults_.size();
    }

    public List<SharedMediaStruct$MessageMediaResult> getMediaResultsList() {
        return this.mediaResults_;
    }

    public InterfaceC3458Ay6 getMediaResultsOrBuilder(int i) {
        return (InterfaceC3458Ay6) this.mediaResults_.get(i);
    }

    public List<? extends InterfaceC3458Ay6> getMediaResultsOrBuilderList() {
        return this.mediaResults_;
    }

    public static a newBuilder(SharedMediaOuterClass$ResponseLoadMedia sharedMediaOuterClass$ResponseLoadMedia) {
        return (a) DEFAULT_INSTANCE.createBuilder(sharedMediaOuterClass$ResponseLoadMedia);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMediaResults(int i, SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult) {
        sharedMediaStruct$MessageMediaResult.getClass();
        ensureMediaResultsIsMutable();
        this.mediaResults_.add(i, sharedMediaStruct$MessageMediaResult);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(byte[] bArr) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(InputStream inputStream) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SharedMediaOuterClass$ResponseLoadMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SharedMediaOuterClass$ResponseLoadMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
