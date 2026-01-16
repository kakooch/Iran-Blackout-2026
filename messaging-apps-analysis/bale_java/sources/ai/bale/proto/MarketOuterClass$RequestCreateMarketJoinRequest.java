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
public final class MarketOuterClass$RequestCreateMarketJoinRequest extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 3;
    private static final MarketOuterClass$RequestCreateMarketJoinRequest DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int MARKET_PEER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TAG_IDS_FIELD_NUMBER = 4;
    private int categoryId_;
    private int marketPeerId_;
    private int tagIdsMemoizedSerializedSize = -1;
    private String displayName_ = "";
    private B.i tagIds_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestCreateMarketJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestCreateMarketJoinRequest marketOuterClass$RequestCreateMarketJoinRequest = new MarketOuterClass$RequestCreateMarketJoinRequest();
        DEFAULT_INSTANCE = marketOuterClass$RequestCreateMarketJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestCreateMarketJoinRequest.class, marketOuterClass$RequestCreateMarketJoinRequest);
    }

    private MarketOuterClass$RequestCreateMarketJoinRequest() {
    }

    private void addAllTagIds(Iterable<? extends Long> iterable) {
        ensureTagIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tagIds_);
    }

    private void addTagIds(long j) {
        ensureTagIdsIsMutable();
        this.tagIds_.l1(j);
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    private void clearMarketPeerId() {
        this.marketPeerId_ = 0;
    }

    private void clearTagIds() {
        this.tagIds_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureTagIdsIsMutable() {
        B.i iVar = this.tagIds_;
        if (iVar.u()) {
            return;
        }
        this.tagIds_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    private void setDisplayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayName_ = abstractC2383g.f0();
    }

    private void setMarketPeerId(int i) {
        this.marketPeerId_ = i;
    }

    private void setTagIds(int i, long j) {
        ensureTagIdsIsMutable();
        this.tagIds_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestCreateMarketJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004%", new Object[]{"marketPeerId_", "displayName_", "categoryId_", "tagIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestCreateMarketJoinRequest.class) {
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

    public int getCategoryId() {
        return this.categoryId_;
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public AbstractC2383g getDisplayNameBytes() {
        return AbstractC2383g.N(this.displayName_);
    }

    public int getMarketPeerId() {
        return this.marketPeerId_;
    }

    public long getTagIds(int i) {
        return this.tagIds_.getLong(i);
    }

    public int getTagIdsCount() {
        return this.tagIds_.size();
    }

    public List<Long> getTagIdsList() {
        return this.tagIds_;
    }

    public static a newBuilder(MarketOuterClass$RequestCreateMarketJoinRequest marketOuterClass$RequestCreateMarketJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestCreateMarketJoinRequest);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestCreateMarketJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestCreateMarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
