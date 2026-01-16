package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchMarket extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchMarket DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    public static final int WITH_CATEGORY_FIELD_NUMBER = 2;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private SearchStruct$SearchPieceText query_;
    private BoolValue withCategory_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(BytesValue bytesValue) {
            q();
            ((SearchOuterClass$RequestSearchMarket) this.b).setLoadMoreState(bytesValue);
            return this;
        }

        public a B(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
            q();
            ((SearchOuterClass$RequestSearchMarket) this.b).setQuery(searchStruct$SearchPieceText);
            return this;
        }

        public a C(BoolValue boolValue) {
            q();
            ((SearchOuterClass$RequestSearchMarket) this.b).setWithCategory(boolValue);
            return this;
        }

        private a() {
            super(SearchOuterClass$RequestSearchMarket.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchMarket searchOuterClass$RequestSearchMarket = new SearchOuterClass$RequestSearchMarket();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchMarket;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchMarket.class, searchOuterClass$RequestSearchMarket);
    }

    private SearchOuterClass$RequestSearchMarket() {
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -5;
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWithCategory() {
        this.withCategory_ = null;
        this.bitField0_ &= -3;
    }

    public static SearchOuterClass$RequestSearchMarket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        SearchStruct$SearchPieceText searchStruct$SearchPieceText2 = this.query_;
        if (searchStruct$SearchPieceText2 == null || searchStruct$SearchPieceText2 == SearchStruct$SearchPieceText.getDefaultInstance()) {
            this.query_ = searchStruct$SearchPieceText;
        } else {
            this.query_ = (SearchStruct$SearchPieceText) ((SearchStruct$SearchPieceText.a) SearchStruct$SearchPieceText.newBuilder(this.query_).v(searchStruct$SearchPieceText)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeWithCategory(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.withCategory_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.withCategory_ = boolValue;
        } else {
            this.withCategory_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.withCategory_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchMarket parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        this.query_ = searchStruct$SearchPieceText;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWithCategory(BoolValue boolValue) {
        boolValue.getClass();
        this.withCategory_ = boolValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchMarket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "query_", "withCategory_", "loadMoreState_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchMarket.class) {
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

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public SearchStruct$SearchPieceText getQuery() {
        SearchStruct$SearchPieceText searchStruct$SearchPieceText = this.query_;
        return searchStruct$SearchPieceText == null ? SearchStruct$SearchPieceText.getDefaultInstance() : searchStruct$SearchPieceText;
    }

    public BoolValue getWithCategory() {
        BoolValue boolValue = this.withCategory_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWithCategory() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SearchOuterClass$RequestSearchMarket searchOuterClass$RequestSearchMarket) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchMarket);
    }

    public static SearchOuterClass$RequestSearchMarket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchMarket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
