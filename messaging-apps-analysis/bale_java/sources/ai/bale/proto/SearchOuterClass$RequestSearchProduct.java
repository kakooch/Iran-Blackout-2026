package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchProduct extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchProduct DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private SearchStruct$SearchPieceText query_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(BytesValue bytesValue) {
            q();
            ((SearchOuterClass$RequestSearchProduct) this.b).setLoadMoreState(bytesValue);
            return this;
        }

        public a B(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
            q();
            ((SearchOuterClass$RequestSearchProduct) this.b).setQuery(searchStruct$SearchPieceText);
            return this;
        }

        private a() {
            super(SearchOuterClass$RequestSearchProduct.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchProduct searchOuterClass$RequestSearchProduct = new SearchOuterClass$RequestSearchProduct();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchProduct;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchProduct.class, searchOuterClass$RequestSearchProduct);
    }

    private SearchOuterClass$RequestSearchProduct() {
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -3;
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchOuterClass$RequestSearchProduct getDefaultInstance() {
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
        this.bitField0_ |= 2;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchProduct parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        this.query_ = searchStruct$SearchPieceText;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchProduct();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "query_", "loadMoreState_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchProduct.class) {
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

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$RequestSearchProduct searchOuterClass$RequestSearchProduct) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchProduct);
    }

    public static SearchOuterClass$RequestSearchProduct parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchProduct parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
