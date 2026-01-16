package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CJ5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class RecommenderOuterClass$ResponseGetRelatedChannels extends GeneratedMessageLite implements U64 {
    private static final RecommenderOuterClass$ResponseGetRelatedChannels DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RELATED_CHANNELS_FIELD_NUMBER = 1;
    private B.j relatedChannels_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RecommenderOuterClass$ResponseGetRelatedChannels.DEFAULT_INSTANCE);
        }
    }

    static {
        RecommenderOuterClass$ResponseGetRelatedChannels recommenderOuterClass$ResponseGetRelatedChannels = new RecommenderOuterClass$ResponseGetRelatedChannels();
        DEFAULT_INSTANCE = recommenderOuterClass$ResponseGetRelatedChannels;
        GeneratedMessageLite.registerDefaultInstance(RecommenderOuterClass$ResponseGetRelatedChannels.class, recommenderOuterClass$ResponseGetRelatedChannels);
    }

    private RecommenderOuterClass$ResponseGetRelatedChannels() {
    }

    private void addAllRelatedChannels(Iterable<? extends RecommenderOuterClass$RelatedChannel> iterable) {
        ensureRelatedChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.relatedChannels_);
    }

    private void addRelatedChannels(RecommenderOuterClass$RelatedChannel recommenderOuterClass$RelatedChannel) {
        recommenderOuterClass$RelatedChannel.getClass();
        ensureRelatedChannelsIsMutable();
        this.relatedChannels_.add(recommenderOuterClass$RelatedChannel);
    }

    private void clearRelatedChannels() {
        this.relatedChannels_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRelatedChannelsIsMutable() {
        B.j jVar = this.relatedChannels_;
        if (jVar.u()) {
            return;
        }
        this.relatedChannels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseDelimitedFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(ByteBuffer byteBuffer) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRelatedChannels(int i) {
        ensureRelatedChannelsIsMutable();
        this.relatedChannels_.remove(i);
    }

    private void setRelatedChannels(int i, RecommenderOuterClass$RelatedChannel recommenderOuterClass$RelatedChannel) {
        recommenderOuterClass$RelatedChannel.getClass();
        ensureRelatedChannelsIsMutable();
        this.relatedChannels_.set(i, recommenderOuterClass$RelatedChannel);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1895t1.a[gVar.ordinal()]) {
            case 1:
                return new RecommenderOuterClass$ResponseGetRelatedChannels();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"relatedChannels_", RecommenderOuterClass$RelatedChannel.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RecommenderOuterClass$ResponseGetRelatedChannels.class) {
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

    public RecommenderOuterClass$RelatedChannel getRelatedChannels(int i) {
        return (RecommenderOuterClass$RelatedChannel) this.relatedChannels_.get(i);
    }

    public int getRelatedChannelsCount() {
        return this.relatedChannels_.size();
    }

    public List<RecommenderOuterClass$RelatedChannel> getRelatedChannelsList() {
        return this.relatedChannels_;
    }

    public CJ5 getRelatedChannelsOrBuilder(int i) {
        return (CJ5) this.relatedChannels_.get(i);
    }

    public List<? extends CJ5> getRelatedChannelsOrBuilderList() {
        return this.relatedChannels_;
    }

    public static a newBuilder(RecommenderOuterClass$ResponseGetRelatedChannels recommenderOuterClass$ResponseGetRelatedChannels) {
        return (a) DEFAULT_INSTANCE.createBuilder(recommenderOuterClass$ResponseGetRelatedChannels);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(AbstractC2383g abstractC2383g) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRelatedChannels(int i, RecommenderOuterClass$RelatedChannel recommenderOuterClass$RelatedChannel) {
        recommenderOuterClass$RelatedChannel.getClass();
        ensureRelatedChannelsIsMutable();
        this.relatedChannels_.add(i, recommenderOuterClass$RelatedChannel);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(byte[] bArr) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(byte[] bArr, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(AbstractC2384h abstractC2384h) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RecommenderOuterClass$ResponseGetRelatedChannels parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
