package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6371Nh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchContent extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 2;
    private static final SearchOuterClass$RequestSearchContent DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private int bitField0_;
    private int contentType_;
    private BytesValue loadMoreState_;
    private SearchStruct$SearchPieceText query_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC6371Nh6 enumC6371Nh6) {
            q();
            ((SearchOuterClass$RequestSearchContent) this.b).setContentType(enumC6371Nh6);
            return this;
        }

        public a B(BytesValue bytesValue) {
            q();
            ((SearchOuterClass$RequestSearchContent) this.b).setLoadMoreState(bytesValue);
            return this;
        }

        public a C(SearchStruct$SearchPieceText.a aVar) {
            q();
            ((SearchOuterClass$RequestSearchContent) this.b).setQuery((SearchStruct$SearchPieceText) aVar.a());
            return this;
        }

        private a() {
            super(SearchOuterClass$RequestSearchContent.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchContent searchOuterClass$RequestSearchContent = new SearchOuterClass$RequestSearchContent();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchContent;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchContent.class, searchOuterClass$RequestSearchContent);
    }

    private SearchOuterClass$RequestSearchContent() {
    }

    private void clearContentType() {
        this.contentType_ = 0;
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -3;
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchOuterClass$RequestSearchContent getDefaultInstance() {
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

    public static SearchOuterClass$RequestSearchContent parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentType(EnumC6371Nh6 enumC6371Nh6) {
        this.contentType_ = enumC6371Nh6.getNumber();
    }

    private void setContentTypeValue(int i) {
        this.contentType_ = i;
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
                return new SearchOuterClass$RequestSearchContent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001", new Object[]{"bitField0_", "query_", "contentType_", "loadMoreState_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchContent.class) {
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

    public EnumC6371Nh6 getContentType() {
        EnumC6371Nh6 enumC6371Nh6J = EnumC6371Nh6.j(this.contentType_);
        return enumC6371Nh6J == null ? EnumC6371Nh6.UNRECOGNIZED : enumC6371Nh6J;
    }

    public int getContentTypeValue() {
        return this.contentType_;
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

    public static a newBuilder(SearchOuterClass$RequestSearchContent searchOuterClass$RequestSearchContent) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchContent);
    }

    public static SearchOuterClass$RequestSearchContent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchContent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
