package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestGetMarket extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestGetMarket DEFAULT_INSTANCE;
    public static final int NICK_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    private int identifierCase_ = 0;
    private Object identifier_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetMarket.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PEER_ID(1),
        NICK_NAME(2),
        IDENTIFIER_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return IDENTIFIER_NOT_SET;
            }
            if (i == 1) {
                return PEER_ID;
            }
            if (i != 2) {
                return null;
            }
            return NICK_NAME;
        }
    }

    static {
        MarketOuterClass$RequestGetMarket marketOuterClass$RequestGetMarket = new MarketOuterClass$RequestGetMarket();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetMarket;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetMarket.class, marketOuterClass$RequestGetMarket);
    }

    private MarketOuterClass$RequestGetMarket() {
    }

    private void clearIdentifier() {
        this.identifierCase_ = 0;
        this.identifier_ = null;
    }

    private void clearNickName() {
        if (this.identifierCase_ == 2) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    private void clearPeerId() {
        if (this.identifierCase_ == 1) {
            this.identifierCase_ = 0;
            this.identifier_ = null;
        }
    }

    public static MarketOuterClass$RequestGetMarket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetMarket parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNickName(String str) {
        str.getClass();
        this.identifierCase_ = 2;
        this.identifier_ = str;
    }

    private void setNickNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.identifier_ = abstractC2383g.f0();
        this.identifierCase_ = 2;
    }

    private void setPeerId(int i) {
        this.identifierCase_ = 1;
        this.identifier_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetMarket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u00017\u0000\u0002Ȼ\u0000", new Object[]{"identifier_", "identifierCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetMarket.class) {
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

    public b getIdentifierCase() {
        return b.j(this.identifierCase_);
    }

    public String getNickName() {
        return this.identifierCase_ == 2 ? (String) this.identifier_ : "";
    }

    public AbstractC2383g getNickNameBytes() {
        return AbstractC2383g.N(this.identifierCase_ == 2 ? (String) this.identifier_ : "");
    }

    public int getPeerId() {
        if (this.identifierCase_ == 1) {
            return ((Integer) this.identifier_).intValue();
        }
        return 0;
    }

    public boolean hasNickName() {
        return this.identifierCase_ == 2;
    }

    public boolean hasPeerId() {
        return this.identifierCase_ == 1;
    }

    public static a newBuilder(MarketOuterClass$RequestGetMarket marketOuterClass$RequestGetMarket) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetMarket);
    }

    public static MarketOuterClass$RequestGetMarket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetMarket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
