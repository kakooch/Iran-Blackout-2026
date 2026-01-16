package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TT3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketTag extends GeneratedMessageLite implements TT3 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 3;
    private static final MarketStruct$MarketTag DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_DEFAULT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int categoryId_;
    private long id_;
    private boolean isDefault_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements TT3 {
        private a() {
            super(MarketStruct$MarketTag.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketTag marketStruct$MarketTag = new MarketStruct$MarketTag();
        DEFAULT_INSTANCE = marketStruct$MarketTag;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketTag.class, marketStruct$MarketTag);
    }

    private MarketStruct$MarketTag() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearIsDefault() {
        this.isDefault_ = false;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static MarketStruct$MarketTag getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketTag parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketTag parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setIsDefault(boolean z) {
        this.isDefault_ = z;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketTag();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0004\u0004\u0007", new Object[]{"id_", "title_", "categoryId_", "isDefault_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketTag.class) {
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

    public long getId() {
        return this.id_;
    }

    public boolean getIsDefault() {
        return this.isDefault_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MarketStruct$MarketTag marketStruct$MarketTag) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketTag);
    }

    public static MarketStruct$MarketTag parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketTag parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketTag parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketTag parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketTag parseFrom(byte[] bArr) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketTag parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketTag parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketTag parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketTag parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketTag parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketTag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
