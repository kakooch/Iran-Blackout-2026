package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketTag;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseCreateTag extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseCreateTag DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAG_FIELD_NUMBER = 1;
    private int bitField0_;
    private MarketStruct$MarketTag tag_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseCreateTag.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseCreateTag marketOuterClass$ResponseCreateTag = new MarketOuterClass$ResponseCreateTag();
        DEFAULT_INSTANCE = marketOuterClass$ResponseCreateTag;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseCreateTag.class, marketOuterClass$ResponseCreateTag);
    }

    private MarketOuterClass$ResponseCreateTag() {
    }

    private void clearTag() {
        this.tag_ = null;
        this.bitField0_ &= -2;
    }

    public static MarketOuterClass$ResponseCreateTag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTag(MarketStruct$MarketTag marketStruct$MarketTag) {
        marketStruct$MarketTag.getClass();
        MarketStruct$MarketTag marketStruct$MarketTag2 = this.tag_;
        if (marketStruct$MarketTag2 == null || marketStruct$MarketTag2 == MarketStruct$MarketTag.getDefaultInstance()) {
            this.tag_ = marketStruct$MarketTag;
        } else {
            this.tag_ = (MarketStruct$MarketTag) ((MarketStruct$MarketTag.a) MarketStruct$MarketTag.newBuilder(this.tag_).v(marketStruct$MarketTag)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseCreateTag parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTag(MarketStruct$MarketTag marketStruct$MarketTag) {
        marketStruct$MarketTag.getClass();
        this.tag_ = marketStruct$MarketTag;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseCreateTag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "tag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseCreateTag.class) {
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

    public MarketStruct$MarketTag getTag() {
        MarketStruct$MarketTag marketStruct$MarketTag = this.tag_;
        return marketStruct$MarketTag == null ? MarketStruct$MarketTag.getDefaultInstance() : marketStruct$MarketTag;
    }

    public boolean hasTag() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$ResponseCreateTag marketOuterClass$ResponseCreateTag) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseCreateTag);
    }

    public static MarketOuterClass$ResponseCreateTag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseCreateTag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseCreateTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
