package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.IT3;
import ir.nasim.JT3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketJoinRequest extends GeneratedMessageLite implements IT3 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final MarketStruct$MarketJoinRequest DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 6;
    public static final int MARKET_PEER_ID_FIELD_NUMBER = 3;
    public static final int NICK_NAME_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 8;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    private int categoryId_;
    private long createdAt_;
    private int marketPeerId_;
    private int requestId_;
    private int status_;
    private long updatedAt_;
    private String description_ = "";
    private String displayName_ = "";
    private String nickName_ = "";

    public static final class a extends GeneratedMessageLite.b implements IT3 {
        private a() {
            super(MarketStruct$MarketJoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest = new MarketStruct$MarketJoinRequest();
        DEFAULT_INSTANCE = marketStruct$MarketJoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketJoinRequest.class, marketStruct$MarketJoinRequest);
    }

    private MarketStruct$MarketJoinRequest() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    private void clearMarketPeerId() {
        this.marketPeerId_ = 0;
    }

    private void clearNickName() {
        this.nickName_ = getDefaultInstance().getNickName();
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    public static MarketStruct$MarketJoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketJoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
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

    private void setNickName(String str) {
        str.getClass();
        this.nickName_ = str;
    }

    private void setNickNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickName_ = abstractC2383g.f0();
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    private void setStatus(JT3 jt3) {
        this.status_ = jt3.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setUpdatedAt(long j) {
        this.updatedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketJoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0004\u0004\u0002\u0005\u0002\u0006Ȉ\u0007Ȉ\b\u0004\t\u0004", new Object[]{"status_", "description_", "marketPeerId_", "createdAt_", "updatedAt_", "displayName_", "nickName_", "requestId_", "categoryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketJoinRequest.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
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

    public String getNickName() {
        return this.nickName_;
    }

    public AbstractC2383g getNickNameBytes() {
        return AbstractC2383g.N(this.nickName_);
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public JT3 getStatus() {
        JT3 jt3J = JT3.j(this.status_);
        return jt3J == null ? JT3.UNRECOGNIZED : jt3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    public static a newBuilder(MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketJoinRequest);
    }

    public static MarketStruct$MarketJoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(byte[] bArr) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketJoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketJoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
