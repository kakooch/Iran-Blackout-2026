package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21982uT3;
import ir.nasim.KW4;
import ir.nasim.WT3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$PopularSearchItem extends GeneratedMessageLite implements WT3 {
    private static final MarketStruct$PopularSearchItem DEFAULT_INSTANCE;
    public static final int DEFAULT_TAB_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 4;
    public static final int TERM_FIELD_NUMBER = 1;
    private int bitField0_;
    private int defaultTab_;
    private CollectionsStruct$Int32Value peerId_;
    private String term_ = "";
    private String displayName_ = "";

    public static final class a extends GeneratedMessageLite.b implements WT3 {
        private a() {
            super(MarketStruct$PopularSearchItem.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$PopularSearchItem marketStruct$PopularSearchItem = new MarketStruct$PopularSearchItem();
        DEFAULT_INSTANCE = marketStruct$PopularSearchItem;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$PopularSearchItem.class, marketStruct$PopularSearchItem);
    }

    private MarketStruct$PopularSearchItem() {
    }

    private void clearDefaultTab() {
        this.defaultTab_ = 0;
    }

    private void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    private void clearPeerId() {
        this.peerId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTerm() {
        this.term_ = getDefaultInstance().getTerm();
    }

    public static MarketStruct$PopularSearchItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeerId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.peerId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.peerId_ = collectionsStruct$Int32Value;
        } else {
            this.peerId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.peerId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$PopularSearchItem parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$PopularSearchItem parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultTab(EnumC21982uT3 enumC21982uT3) {
        this.defaultTab_ = enumC21982uT3.getNumber();
    }

    private void setDefaultTabValue(int i) {
        this.defaultTab_ = i;
    }

    private void setDisplayName(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    private void setDisplayNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayName_ = abstractC2383g.f0();
    }

    private void setPeerId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.peerId_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 1;
    }

    private void setTerm(String str) {
        str.getClass();
        this.term_ = str;
    }

    private void setTermBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.term_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$PopularSearchItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003Ȉ\u0004ဉ\u0000", new Object[]{"bitField0_", "term_", "defaultTab_", "displayName_", "peerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$PopularSearchItem.class) {
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

    public EnumC21982uT3 getDefaultTab() {
        EnumC21982uT3 enumC21982uT3J = EnumC21982uT3.j(this.defaultTab_);
        return enumC21982uT3J == null ? EnumC21982uT3.UNRECOGNIZED : enumC21982uT3J;
    }

    public int getDefaultTabValue() {
        return this.defaultTab_;
    }

    public String getDisplayName() {
        return this.displayName_;
    }

    public AbstractC2383g getDisplayNameBytes() {
        return AbstractC2383g.N(this.displayName_);
    }

    public CollectionsStruct$Int32Value getPeerId() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.peerId_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public String getTerm() {
        return this.term_;
    }

    public AbstractC2383g getTermBytes() {
        return AbstractC2383g.N(this.term_);
    }

    public boolean hasPeerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketStruct$PopularSearchItem marketStruct$PopularSearchItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$PopularSearchItem);
    }

    public static MarketStruct$PopularSearchItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$PopularSearchItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$PopularSearchItem parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$PopularSearchItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$PopularSearchItem parseFrom(byte[] bArr) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$PopularSearchItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$PopularSearchItem parseFrom(InputStream inputStream) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$PopularSearchItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$PopularSearchItem parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$PopularSearchItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$PopularSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
