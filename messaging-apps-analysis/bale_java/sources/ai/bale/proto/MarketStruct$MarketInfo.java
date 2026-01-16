package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.ET3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketInfo extends GeneratedMessageLite implements ET3 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final MarketStruct$MarketInfo DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int IS_ACTIVE_FIELD_NUMBER = 7;
    public static final int IS_BANNED_FIELD_NUMBER = 10;
    public static final int IS_BASALAM_FIELD_NUMBER = 8;
    public static final int IS_TAZENAFAS_FIELD_NUMBER = 9;
    public static final int NICK_NAME_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    public static final int PRIMARY_CATEGORY_ID_FIELD_NUMBER = 4;
    private int categoryId_;
    private long createdAt_;
    private boolean isActive_;
    private boolean isBanned_;
    private boolean isBasalam_;
    private boolean isTazenafas_;
    private int peerId_;
    private int primaryCategoryId_;
    private String displayName_ = "";
    private String nickName_ = "";

    public static final class a extends GeneratedMessageLite.b implements ET3 {
        private a() {
            super(MarketStruct$MarketInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketInfo marketStruct$MarketInfo = new MarketStruct$MarketInfo();
        DEFAULT_INSTANCE = marketStruct$MarketInfo;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketInfo.class, marketStruct$MarketInfo);
    }

    private MarketStruct$MarketInfo() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    private void clearIsActive() {
        this.isActive_ = false;
    }

    private void clearIsBanned() {
        this.isBanned_ = false;
    }

    private void clearIsBasalam() {
        this.isBasalam_ = false;
    }

    private void clearIsTazenafas() {
        this.isTazenafas_ = false;
    }

    private void clearNickName() {
        this.nickName_ = getDefaultInstance().getNickName();
    }

    private void clearPeerId() {
        this.peerId_ = 0;
    }

    private void clearPrimaryCategoryId() {
        this.primaryCategoryId_ = 0;
    }

    public static MarketStruct$MarketInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketInfo parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketInfo parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    private void setDisplayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayName_ = abstractC2383g.f0();
    }

    private void setIsActive(boolean z) {
        this.isActive_ = z;
    }

    private void setIsBanned(boolean z) {
        this.isBanned_ = z;
    }

    private void setIsBasalam(boolean z) {
        this.isBasalam_ = z;
    }

    private void setIsTazenafas(boolean z) {
        this.isTazenafas_ = z;
    }

    private void setNickName(String str) {
        str.getClass();
        this.nickName_ = str;
    }

    private void setNickNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickName_ = abstractC2383g.f0();
    }

    private void setPeerId(int i) {
        this.peerId_ = i;
    }

    private void setPrimaryCategoryId(int i) {
        this.primaryCategoryId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004\u0004\u0005\u0002\u0006Ȉ\u0007\u0007\b\u0007\t\u0007\n\u0007", new Object[]{"peerId_", "displayName_", "categoryId_", "primaryCategoryId_", "createdAt_", "nickName_", "isActive_", "isBasalam_", "isTazenafas_", "isBanned_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketInfo.class) {
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

    public String getDisplayName() {
        return this.displayName_;
    }

    public AbstractC2383g getDisplayNameBytes() {
        return AbstractC2383g.N(this.displayName_);
    }

    public boolean getIsActive() {
        return this.isActive_;
    }

    public boolean getIsBanned() {
        return this.isBanned_;
    }

    public boolean getIsBasalam() {
        return this.isBasalam_;
    }

    public boolean getIsTazenafas() {
        return this.isTazenafas_;
    }

    public String getNickName() {
        return this.nickName_;
    }

    public AbstractC2383g getNickNameBytes() {
        return AbstractC2383g.N(this.nickName_);
    }

    public int getPeerId() {
        return this.peerId_;
    }

    public int getPrimaryCategoryId() {
        return this.primaryCategoryId_;
    }

    public static a newBuilder(MarketStruct$MarketInfo marketStruct$MarketInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketInfo);
    }

    public static MarketStruct$MarketInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketInfo parseFrom(byte[] bArr) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketInfo parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
