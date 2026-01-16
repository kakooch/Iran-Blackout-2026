package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchAndCondition;
import ai.bale.proto.SearchStruct$SearchDateCondition;
import ai.bale.proto.SearchStruct$SearchDocumentName;
import ai.bale.proto.SearchStruct$SearchHasLinkCondition;
import ai.bale.proto.SearchStruct$SearchOrCondition;
import ai.bale.proto.SearchStruct$SearchPeerCondition;
import ai.bale.proto.SearchStruct$SearchPeerContentType;
import ai.bale.proto.SearchStruct$SearchPeerTypeCondition;
import ai.bale.proto.SearchStruct$SearchPieceText;
import ai.bale.proto.SearchStruct$SearchSenderCondition;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$SearchCondition extends GeneratedMessageLite implements O1 {
    private static final SearchStruct$SearchCondition DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEARCH_AND_CONDITION_FIELD_NUMBER = 1;
    public static final int SEARCH_DATE_FIELD_NUMBER = 7;
    public static final int SEARCH_DOCUMENT_NAME_FIELD_NUMBER = 10;
    public static final int SEARCH_HAS_LINK_FIELD_NUMBER = 9;
    public static final int SEARCH_OR_CONDITION_FIELD_NUMBER = 2;
    public static final int SEARCH_PEER_CONDITION_FIELD_NUMBER = 3;
    public static final int SEARCH_PEER_CONTENT_TYPE_FIELD_NUMBER = 4;
    public static final int SEARCH_PEER_TYPE_CONDITION_FIELD_NUMBER = 5;
    public static final int SEARCH_PIECE_TEXT_FIELD_NUMBER = 6;
    public static final int SEARCH_SENDER_FIELD_NUMBER = 8;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements O1 {
        public a A(SearchStruct$SearchAndCondition searchStruct$SearchAndCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchAndCondition(searchStruct$SearchAndCondition);
            return this;
        }

        public a B(SearchStruct$SearchDateCondition searchStruct$SearchDateCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchDate(searchStruct$SearchDateCondition);
            return this;
        }

        public a C(SearchStruct$SearchDocumentName searchStruct$SearchDocumentName) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchDocumentName(searchStruct$SearchDocumentName);
            return this;
        }

        public a D(SearchStruct$SearchHasLinkCondition searchStruct$SearchHasLinkCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchHasLink(searchStruct$SearchHasLinkCondition);
            return this;
        }

        public a E(SearchStruct$SearchPeerCondition searchStruct$SearchPeerCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchPeerCondition(searchStruct$SearchPeerCondition);
            return this;
        }

        public a F(SearchStruct$SearchPeerTypeCondition searchStruct$SearchPeerTypeCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchPeerTypeCondition(searchStruct$SearchPeerTypeCondition);
            return this;
        }

        public a G(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchPieceText(searchStruct$SearchPieceText);
            return this;
        }

        public a H(SearchStruct$SearchSenderCondition searchStruct$SearchSenderCondition) {
            q();
            ((SearchStruct$SearchCondition) this.b).setSearchSender(searchStruct$SearchSenderCondition);
            return this;
        }

        private a() {
            super(SearchStruct$SearchCondition.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SEARCH_AND_CONDITION(1),
        SEARCH_OR_CONDITION(2),
        SEARCH_PEER_CONDITION(3),
        SEARCH_PEER_CONTENT_TYPE(4),
        SEARCH_PEER_TYPE_CONDITION(5),
        SEARCH_PIECE_TEXT(6),
        SEARCH_DATE(7),
        SEARCH_SENDER(8),
        SEARCH_HAS_LINK(9),
        SEARCH_DOCUMENT_NAME(10),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return TRAIT_NOT_SET;
                case 1:
                    return SEARCH_AND_CONDITION;
                case 2:
                    return SEARCH_OR_CONDITION;
                case 3:
                    return SEARCH_PEER_CONDITION;
                case 4:
                    return SEARCH_PEER_CONTENT_TYPE;
                case 5:
                    return SEARCH_PEER_TYPE_CONDITION;
                case 6:
                    return SEARCH_PIECE_TEXT;
                case 7:
                    return SEARCH_DATE;
                case 8:
                    return SEARCH_SENDER;
                case 9:
                    return SEARCH_HAS_LINK;
                case 10:
                    return SEARCH_DOCUMENT_NAME;
                default:
                    return null;
            }
        }
    }

    static {
        SearchStruct$SearchCondition searchStruct$SearchCondition = new SearchStruct$SearchCondition();
        DEFAULT_INSTANCE = searchStruct$SearchCondition;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchCondition.class, searchStruct$SearchCondition);
    }

    private SearchStruct$SearchCondition() {
    }

    private void clearSearchAndCondition() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchDate() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchDocumentName() {
        if (this.traitCase_ == 10) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchHasLink() {
        if (this.traitCase_ == 9) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchOrCondition() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchPeerCondition() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchPeerContentType() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchPeerTypeCondition() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchPieceText() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchSender() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static SearchStruct$SearchCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSearchAndCondition(SearchStruct$SearchAndCondition searchStruct$SearchAndCondition) {
        searchStruct$SearchAndCondition.getClass();
        if (this.traitCase_ != 1 || this.trait_ == SearchStruct$SearchAndCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchAndCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchAndCondition.a) SearchStruct$SearchAndCondition.newBuilder((SearchStruct$SearchAndCondition) this.trait_).v(searchStruct$SearchAndCondition)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeSearchDate(SearchStruct$SearchDateCondition searchStruct$SearchDateCondition) {
        searchStruct$SearchDateCondition.getClass();
        if (this.traitCase_ != 7 || this.trait_ == SearchStruct$SearchDateCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchDateCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchDateCondition.a) SearchStruct$SearchDateCondition.newBuilder((SearchStruct$SearchDateCondition) this.trait_).v(searchStruct$SearchDateCondition)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeSearchDocumentName(SearchStruct$SearchDocumentName searchStruct$SearchDocumentName) {
        searchStruct$SearchDocumentName.getClass();
        if (this.traitCase_ != 10 || this.trait_ == SearchStruct$SearchDocumentName.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchDocumentName;
        } else {
            this.trait_ = ((SearchStruct$SearchDocumentName.a) SearchStruct$SearchDocumentName.newBuilder((SearchStruct$SearchDocumentName) this.trait_).v(searchStruct$SearchDocumentName)).j();
        }
        this.traitCase_ = 10;
    }

    private void mergeSearchHasLink(SearchStruct$SearchHasLinkCondition searchStruct$SearchHasLinkCondition) {
        searchStruct$SearchHasLinkCondition.getClass();
        if (this.traitCase_ != 9 || this.trait_ == SearchStruct$SearchHasLinkCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchHasLinkCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchHasLinkCondition.a) SearchStruct$SearchHasLinkCondition.newBuilder((SearchStruct$SearchHasLinkCondition) this.trait_).v(searchStruct$SearchHasLinkCondition)).j();
        }
        this.traitCase_ = 9;
    }

    private void mergeSearchOrCondition(SearchStruct$SearchOrCondition searchStruct$SearchOrCondition) {
        searchStruct$SearchOrCondition.getClass();
        if (this.traitCase_ != 2 || this.trait_ == SearchStruct$SearchOrCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchOrCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchOrCondition.a) SearchStruct$SearchOrCondition.newBuilder((SearchStruct$SearchOrCondition) this.trait_).v(searchStruct$SearchOrCondition)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeSearchPeerCondition(SearchStruct$SearchPeerCondition searchStruct$SearchPeerCondition) {
        searchStruct$SearchPeerCondition.getClass();
        if (this.traitCase_ != 3 || this.trait_ == SearchStruct$SearchPeerCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchPeerCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchPeerCondition.a) SearchStruct$SearchPeerCondition.newBuilder((SearchStruct$SearchPeerCondition) this.trait_).v(searchStruct$SearchPeerCondition)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeSearchPeerContentType(SearchStruct$SearchPeerContentType searchStruct$SearchPeerContentType) {
        searchStruct$SearchPeerContentType.getClass();
        if (this.traitCase_ != 4 || this.trait_ == SearchStruct$SearchPeerContentType.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchPeerContentType;
        } else {
            this.trait_ = ((SearchStruct$SearchPeerContentType.a) SearchStruct$SearchPeerContentType.newBuilder((SearchStruct$SearchPeerContentType) this.trait_).v(searchStruct$SearchPeerContentType)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeSearchPeerTypeCondition(SearchStruct$SearchPeerTypeCondition searchStruct$SearchPeerTypeCondition) {
        searchStruct$SearchPeerTypeCondition.getClass();
        if (this.traitCase_ != 5 || this.trait_ == SearchStruct$SearchPeerTypeCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchPeerTypeCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchPeerTypeCondition.a) SearchStruct$SearchPeerTypeCondition.newBuilder((SearchStruct$SearchPeerTypeCondition) this.trait_).v(searchStruct$SearchPeerTypeCondition)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeSearchPieceText(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        if (this.traitCase_ != 6 || this.trait_ == SearchStruct$SearchPieceText.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchPieceText;
        } else {
            this.trait_ = ((SearchStruct$SearchPieceText.a) SearchStruct$SearchPieceText.newBuilder((SearchStruct$SearchPieceText) this.trait_).v(searchStruct$SearchPieceText)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergeSearchSender(SearchStruct$SearchSenderCondition searchStruct$SearchSenderCondition) {
        searchStruct$SearchSenderCondition.getClass();
        if (this.traitCase_ != 8 || this.trait_ == SearchStruct$SearchSenderCondition.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchSenderCondition;
        } else {
            this.trait_ = ((SearchStruct$SearchSenderCondition.a) SearchStruct$SearchSenderCondition.newBuilder((SearchStruct$SearchSenderCondition) this.trait_).v(searchStruct$SearchSenderCondition)).j();
        }
        this.traitCase_ = 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchCondition parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchCondition parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchAndCondition(SearchStruct$SearchAndCondition searchStruct$SearchAndCondition) {
        searchStruct$SearchAndCondition.getClass();
        this.trait_ = searchStruct$SearchAndCondition;
        this.traitCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchDate(SearchStruct$SearchDateCondition searchStruct$SearchDateCondition) {
        searchStruct$SearchDateCondition.getClass();
        this.trait_ = searchStruct$SearchDateCondition;
        this.traitCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchDocumentName(SearchStruct$SearchDocumentName searchStruct$SearchDocumentName) {
        searchStruct$SearchDocumentName.getClass();
        this.trait_ = searchStruct$SearchDocumentName;
        this.traitCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchHasLink(SearchStruct$SearchHasLinkCondition searchStruct$SearchHasLinkCondition) {
        searchStruct$SearchHasLinkCondition.getClass();
        this.trait_ = searchStruct$SearchHasLinkCondition;
        this.traitCase_ = 9;
    }

    private void setSearchOrCondition(SearchStruct$SearchOrCondition searchStruct$SearchOrCondition) {
        searchStruct$SearchOrCondition.getClass();
        this.trait_ = searchStruct$SearchOrCondition;
        this.traitCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchPeerCondition(SearchStruct$SearchPeerCondition searchStruct$SearchPeerCondition) {
        searchStruct$SearchPeerCondition.getClass();
        this.trait_ = searchStruct$SearchPeerCondition;
        this.traitCase_ = 3;
    }

    private void setSearchPeerContentType(SearchStruct$SearchPeerContentType searchStruct$SearchPeerContentType) {
        searchStruct$SearchPeerContentType.getClass();
        this.trait_ = searchStruct$SearchPeerContentType;
        this.traitCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchPeerTypeCondition(SearchStruct$SearchPeerTypeCondition searchStruct$SearchPeerTypeCondition) {
        searchStruct$SearchPeerTypeCondition.getClass();
        this.trait_ = searchStruct$SearchPeerTypeCondition;
        this.traitCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchPieceText(SearchStruct$SearchPieceText searchStruct$SearchPieceText) {
        searchStruct$SearchPieceText.getClass();
        this.trait_ = searchStruct$SearchPieceText;
        this.traitCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchSender(SearchStruct$SearchSenderCondition searchStruct$SearchSenderCondition) {
        searchStruct$SearchSenderCondition.getClass();
        this.trait_ = searchStruct$SearchSenderCondition;
        this.traitCase_ = 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0001\u0000\u0001\n\n\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000", new Object[]{"trait_", "traitCase_", SearchStruct$SearchAndCondition.class, SearchStruct$SearchOrCondition.class, SearchStruct$SearchPeerCondition.class, SearchStruct$SearchPeerContentType.class, SearchStruct$SearchPeerTypeCondition.class, SearchStruct$SearchPieceText.class, SearchStruct$SearchDateCondition.class, SearchStruct$SearchSenderCondition.class, SearchStruct$SearchHasLinkCondition.class, SearchStruct$SearchDocumentName.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchCondition.class) {
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

    public SearchStruct$SearchAndCondition getSearchAndCondition() {
        return this.traitCase_ == 1 ? (SearchStruct$SearchAndCondition) this.trait_ : SearchStruct$SearchAndCondition.getDefaultInstance();
    }

    public SearchStruct$SearchDateCondition getSearchDate() {
        return this.traitCase_ == 7 ? (SearchStruct$SearchDateCondition) this.trait_ : SearchStruct$SearchDateCondition.getDefaultInstance();
    }

    public SearchStruct$SearchDocumentName getSearchDocumentName() {
        return this.traitCase_ == 10 ? (SearchStruct$SearchDocumentName) this.trait_ : SearchStruct$SearchDocumentName.getDefaultInstance();
    }

    public SearchStruct$SearchHasLinkCondition getSearchHasLink() {
        return this.traitCase_ == 9 ? (SearchStruct$SearchHasLinkCondition) this.trait_ : SearchStruct$SearchHasLinkCondition.getDefaultInstance();
    }

    public SearchStruct$SearchOrCondition getSearchOrCondition() {
        return this.traitCase_ == 2 ? (SearchStruct$SearchOrCondition) this.trait_ : SearchStruct$SearchOrCondition.getDefaultInstance();
    }

    public SearchStruct$SearchPeerCondition getSearchPeerCondition() {
        return this.traitCase_ == 3 ? (SearchStruct$SearchPeerCondition) this.trait_ : SearchStruct$SearchPeerCondition.getDefaultInstance();
    }

    public SearchStruct$SearchPeerContentType getSearchPeerContentType() {
        return this.traitCase_ == 4 ? (SearchStruct$SearchPeerContentType) this.trait_ : SearchStruct$SearchPeerContentType.getDefaultInstance();
    }

    public SearchStruct$SearchPeerTypeCondition getSearchPeerTypeCondition() {
        return this.traitCase_ == 5 ? (SearchStruct$SearchPeerTypeCondition) this.trait_ : SearchStruct$SearchPeerTypeCondition.getDefaultInstance();
    }

    public SearchStruct$SearchPieceText getSearchPieceText() {
        return this.traitCase_ == 6 ? (SearchStruct$SearchPieceText) this.trait_ : SearchStruct$SearchPieceText.getDefaultInstance();
    }

    public SearchStruct$SearchSenderCondition getSearchSender() {
        return this.traitCase_ == 8 ? (SearchStruct$SearchSenderCondition) this.trait_ : SearchStruct$SearchSenderCondition.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasSearchAndCondition() {
        return this.traitCase_ == 1;
    }

    public boolean hasSearchDate() {
        return this.traitCase_ == 7;
    }

    public boolean hasSearchDocumentName() {
        return this.traitCase_ == 10;
    }

    public boolean hasSearchHasLink() {
        return this.traitCase_ == 9;
    }

    public boolean hasSearchOrCondition() {
        return this.traitCase_ == 2;
    }

    public boolean hasSearchPeerCondition() {
        return this.traitCase_ == 3;
    }

    public boolean hasSearchPeerContentType() {
        return this.traitCase_ == 4;
    }

    public boolean hasSearchPeerTypeCondition() {
        return this.traitCase_ == 5;
    }

    public boolean hasSearchPieceText() {
        return this.traitCase_ == 6;
    }

    public boolean hasSearchSender() {
        return this.traitCase_ == 8;
    }

    public static a newBuilder(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchCondition);
    }

    public static SearchStruct$SearchCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchCondition parseFrom(byte[] bArr) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchCondition parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
