package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class RecommenderOuterClass$ResponseGetChannelRecommendations extends GeneratedMessageLite implements U64 {
    public static final int CHANNELS_FIELD_NUMBER = 1;
    private static final RecommenderOuterClass$ResponseGetChannelRecommendations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j channels_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RecommenderOuterClass$ResponseGetChannelRecommendations.DEFAULT_INSTANCE);
        }
    }

    static {
        RecommenderOuterClass$ResponseGetChannelRecommendations recommenderOuterClass$ResponseGetChannelRecommendations = new RecommenderOuterClass$ResponseGetChannelRecommendations();
        DEFAULT_INSTANCE = recommenderOuterClass$ResponseGetChannelRecommendations;
        GeneratedMessageLite.registerDefaultInstance(RecommenderOuterClass$ResponseGetChannelRecommendations.class, recommenderOuterClass$ResponseGetChannelRecommendations);
    }

    private RecommenderOuterClass$ResponseGetChannelRecommendations() {
    }

    private void addAllChannels(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channels_);
    }

    private void addChannels(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(peersStruct$GroupOutPeer);
    }

    private void clearChannels() {
        this.channels_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureChannelsIsMutable() {
        B.j jVar = this.channels_;
        if (jVar.u()) {
            return;
        }
        this.channels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseDelimitedFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(ByteBuffer byteBuffer) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeChannels(int i) {
        ensureChannelsIsMutable();
        this.channels_.remove(i);
    }

    private void setChannels(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureChannelsIsMutable();
        this.channels_.set(i, peersStruct$GroupOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1895t1.a[gVar.ordinal()]) {
            case 1:
                return new RecommenderOuterClass$ResponseGetChannelRecommendations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"channels_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RecommenderOuterClass$ResponseGetChannelRecommendations.class) {
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

    public PeersStruct$GroupOutPeer getChannels(int i) {
        return (PeersStruct$GroupOutPeer) this.channels_.get(i);
    }

    public int getChannelsCount() {
        return this.channels_.size();
    }

    public List<PeersStruct$GroupOutPeer> getChannelsList() {
        return this.channels_;
    }

    public InterfaceC11468d35 getChannelsOrBuilder(int i) {
        return (InterfaceC11468d35) this.channels_.get(i);
    }

    public List<? extends InterfaceC11468d35> getChannelsOrBuilderList() {
        return this.channels_;
    }

    public static a newBuilder(RecommenderOuterClass$ResponseGetChannelRecommendations recommenderOuterClass$ResponseGetChannelRecommendations) {
        return (a) DEFAULT_INSTANCE.createBuilder(recommenderOuterClass$ResponseGetChannelRecommendations);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(AbstractC2383g abstractC2383g) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addChannels(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(i, peersStruct$GroupOutPeer);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(byte[] bArr) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(byte[] bArr, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(AbstractC2384h abstractC2384h) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RecommenderOuterClass$ResponseGetChannelRecommendations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetChannelRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
