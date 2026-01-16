package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.IT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetMarketsJoinRequest extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetMarketsJoinRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTS_FIELD_NUMBER = 1;
    private B.j requests_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetMarketsJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetMarketsJoinRequest marketOuterClass$ResponseGetMarketsJoinRequest = new MarketOuterClass$ResponseGetMarketsJoinRequest();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetMarketsJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetMarketsJoinRequest.class, marketOuterClass$ResponseGetMarketsJoinRequest);
    }

    private MarketOuterClass$ResponseGetMarketsJoinRequest() {
    }

    private void addAllRequests(Iterable<? extends MarketStruct$MarketJoinRequest> iterable) {
        ensureRequestsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.requests_);
    }

    private void addRequests(MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.add(marketStruct$MarketJoinRequest);
    }

    private void clearRequests() {
        this.requests_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRequestsIsMutable() {
        B.j jVar = this.requests_;
        if (jVar.u()) {
            return;
        }
        this.requests_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRequests(int i) {
        ensureRequestsIsMutable();
        this.requests_.remove(i);
    }

    private void setRequests(int i, MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.set(i, marketStruct$MarketJoinRequest);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetMarketsJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"requests_", MarketStruct$MarketJoinRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetMarketsJoinRequest.class) {
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

    public MarketStruct$MarketJoinRequest getRequests(int i) {
        return (MarketStruct$MarketJoinRequest) this.requests_.get(i);
    }

    public int getRequestsCount() {
        return this.requests_.size();
    }

    public List<MarketStruct$MarketJoinRequest> getRequestsList() {
        return this.requests_;
    }

    public IT3 getRequestsOrBuilder(int i) {
        return (IT3) this.requests_.get(i);
    }

    public List<? extends IT3> getRequestsOrBuilderList() {
        return this.requests_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetMarketsJoinRequest marketOuterClass$ResponseGetMarketsJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetMarketsJoinRequest);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRequests(int i, MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureRequestsIsMutable();
        this.requests_.add(i, marketStruct$MarketJoinRequest);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetMarketsJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketsJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
