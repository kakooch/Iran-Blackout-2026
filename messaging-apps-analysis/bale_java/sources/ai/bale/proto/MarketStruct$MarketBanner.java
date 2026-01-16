package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketAction;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AT3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketBanner extends GeneratedMessageLite implements AT3 {
    public static final int ACTION_FIELD_NUMBER = 1;
    private static final MarketStruct$MarketBanner DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 3;
    public static final int IMAGEURL_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private MarketStruct$MarketAction action_;
    private int bitField0_;
    private long fileId_;
    private String imageUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements AT3 {
        private a() {
            super(MarketStruct$MarketBanner.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketBanner marketStruct$MarketBanner = new MarketStruct$MarketBanner();
        DEFAULT_INSTANCE = marketStruct$MarketBanner;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketBanner.class, marketStruct$MarketBanner);
    }

    private MarketStruct$MarketBanner() {
    }

    private void clearAction() {
        this.action_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearImageUrl() {
        this.imageUrl_ = getDefaultInstance().getImageUrl();
    }

    public static MarketStruct$MarketBanner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAction(MarketStruct$MarketAction marketStruct$MarketAction) {
        marketStruct$MarketAction.getClass();
        MarketStruct$MarketAction marketStruct$MarketAction2 = this.action_;
        if (marketStruct$MarketAction2 == null || marketStruct$MarketAction2 == MarketStruct$MarketAction.getDefaultInstance()) {
            this.action_ = marketStruct$MarketAction;
        } else {
            this.action_ = (MarketStruct$MarketAction) ((MarketStruct$MarketAction.a) MarketStruct$MarketAction.newBuilder(this.action_).v(marketStruct$MarketAction)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketBanner parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketBanner parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(MarketStruct$MarketAction marketStruct$MarketAction) {
        marketStruct$MarketAction.getClass();
        this.action_ = marketStruct$MarketAction;
        this.bitField0_ |= 1;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setImageUrl(String str) {
        str.getClass();
        this.imageUrl_ = str;
    }

    private void setImageUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.imageUrl_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketBanner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u0002", new Object[]{"bitField0_", "action_", "imageUrl_", "fileId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketBanner.class) {
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

    public MarketStruct$MarketAction getAction() {
        MarketStruct$MarketAction marketStruct$MarketAction = this.action_;
        return marketStruct$MarketAction == null ? MarketStruct$MarketAction.getDefaultInstance() : marketStruct$MarketAction;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public AbstractC2383g getImageUrlBytes() {
        return AbstractC2383g.N(this.imageUrl_);
    }

    public boolean hasAction() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketStruct$MarketBanner marketStruct$MarketBanner) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketBanner);
    }

    public static MarketStruct$MarketBanner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketBanner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketBanner parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketBanner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketBanner parseFrom(byte[] bArr) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketBanner parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketBanner parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketBanner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketBanner parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketBanner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketBanner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
