package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TT3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetTags extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetTags DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAGS_FIELD_NUMBER = 1;
    private B.j tags_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetTags.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetTags marketOuterClass$ResponseGetTags = new MarketOuterClass$ResponseGetTags();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetTags;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetTags.class, marketOuterClass$ResponseGetTags);
    }

    private MarketOuterClass$ResponseGetTags() {
    }

    private void addAllTags(Iterable<? extends MarketStruct$MarketTag> iterable) {
        ensureTagsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tags_);
    }

    private void addTags(MarketStruct$MarketTag marketStruct$MarketTag) {
        marketStruct$MarketTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(marketStruct$MarketTag);
    }

    private void clearTags() {
        this.tags_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTagsIsMutable() {
        B.j jVar = this.tags_;
        if (jVar.u()) {
            return;
        }
        this.tags_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetTags parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTags(int i) {
        ensureTagsIsMutable();
        this.tags_.remove(i);
    }

    private void setTags(int i, MarketStruct$MarketTag marketStruct$MarketTag) {
        marketStruct$MarketTag.getClass();
        ensureTagsIsMutable();
        this.tags_.set(i, marketStruct$MarketTag);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"tags_", MarketStruct$MarketTag.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetTags.class) {
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

    public MarketStruct$MarketTag getTags(int i) {
        return (MarketStruct$MarketTag) this.tags_.get(i);
    }

    public int getTagsCount() {
        return this.tags_.size();
    }

    public List<MarketStruct$MarketTag> getTagsList() {
        return this.tags_;
    }

    public TT3 getTagsOrBuilder(int i) {
        return (TT3) this.tags_.get(i);
    }

    public List<? extends TT3> getTagsOrBuilderList() {
        return this.tags_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetTags marketOuterClass$ResponseGetTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetTags);
    }

    public static MarketOuterClass$ResponseGetTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTags(int i, MarketStruct$MarketTag marketStruct$MarketTag) {
        marketStruct$MarketTag.getClass();
        ensureTagsIsMutable();
        this.tags_.add(i, marketStruct$MarketTag);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
