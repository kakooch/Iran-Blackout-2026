package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchDialog extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchDialog DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private int bitField0_;
    private SearchStruct$SearchPieceText query_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$RequestSearchDialog.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchDialog searchOuterClass$RequestSearchDialog = new SearchOuterClass$RequestSearchDialog();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchDialog;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchDialog.class, searchOuterClass$RequestSearchDialog);
    }

    private SearchOuterClass$RequestSearchDialog() {
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchOuterClass$RequestSearchDialog getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static SearchOuterClass$RequestSearchDialog parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setQuery(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        this.query_ = searchStruct$SearchPieceText;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchDialog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "query_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchDialog.class) {
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

    public SearchStruct$SearchPieceText getQuery() {
        SearchStruct$SearchPieceText searchStruct$SearchPieceText = this.query_;
        return searchStruct$SearchPieceText == null ? SearchStruct$SearchPieceText.getDefaultInstance() : searchStruct$SearchPieceText;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$RequestSearchDialog searchOuterClass$RequestSearchDialog) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchDialog);
    }

    public static SearchOuterClass$RequestSearchDialog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchDialog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchDialog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
