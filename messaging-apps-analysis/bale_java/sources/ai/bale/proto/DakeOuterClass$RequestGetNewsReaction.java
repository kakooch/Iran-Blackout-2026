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

/* loaded from: classes9.dex */
public final class DakeOuterClass$RequestGetNewsReaction extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$RequestGetNewsReaction DEFAULT_INSTANCE;
    public static final int FEED_IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j feedIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$RequestGetNewsReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$RequestGetNewsReaction dakeOuterClass$RequestGetNewsReaction = new DakeOuterClass$RequestGetNewsReaction();
        DEFAULT_INSTANCE = dakeOuterClass$RequestGetNewsReaction;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$RequestGetNewsReaction.class, dakeOuterClass$RequestGetNewsReaction);
    }

    private DakeOuterClass$RequestGetNewsReaction() {
    }

    private void addAllFeedIds(Iterable<String> iterable) {
        ensureFeedIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.feedIds_);
    }

    private void addFeedIds(String str) {
        str.getClass();
        ensureFeedIdsIsMutable();
        this.feedIds_.add(str);
    }

    private void addFeedIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureFeedIdsIsMutable();
        this.feedIds_.add(abstractC2383g.f0());
    }

    private void clearFeedIds() {
        this.feedIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFeedIdsIsMutable() {
        B.j jVar = this.feedIds_;
        if (jVar.u()) {
            return;
        }
        this.feedIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DakeOuterClass$RequestGetNewsReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$RequestGetNewsReaction parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFeedIds(int i, String str) {
        str.getClass();
        ensureFeedIdsIsMutable();
        this.feedIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$RequestGetNewsReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"feedIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$RequestGetNewsReaction.class) {
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

    public String getFeedIds(int i) {
        return (String) this.feedIds_.get(i);
    }

    public AbstractC2383g getFeedIdsBytes(int i) {
        return AbstractC2383g.N((String) this.feedIds_.get(i));
    }

    public int getFeedIdsCount() {
        return this.feedIds_.size();
    }

    public List<String> getFeedIdsList() {
        return this.feedIds_;
    }

    public static a newBuilder(DakeOuterClass$RequestGetNewsReaction dakeOuterClass$RequestGetNewsReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$RequestGetNewsReaction);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(byte[] bArr) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$RequestGetNewsReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
