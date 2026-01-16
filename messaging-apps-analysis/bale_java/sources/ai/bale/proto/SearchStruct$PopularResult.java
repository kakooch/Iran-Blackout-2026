package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.SearchStruct$PopularSearchResult;
import ai.bale.proto.SearchStruct$SearchAds;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$PopularResult extends GeneratedMessageLite implements N1 {
    private static final SearchStruct$PopularResult DEFAULT_INSTANCE;
    public static final int DEMONSTRATIVE_NAME_FIELD_NUMBER = 1;
    public static final int GROUP_OUT_PEER_FIELD_NUMBER = 4;
    public static final int LINK_FIELD_NUMBER = 2;
    public static final int MAXAPPVERSION_FIELD_NUMBER = 7;
    public static final int MINAPPVERSION_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int POPULAR_SEARCH_RESULT_FIELD_NUMBER = 3;
    public static final int SEARCH_ADS_FIELD_NUMBER = 5;
    private int bitField0_;
    private StringValue link_;
    private int maxAppVersion_;
    private int minAppVersion_;
    private Object trait_;
    private int traitCase_ = 0;
    private String demonstrativeName_ = "";

    public static final class a extends GeneratedMessageLite.b implements N1 {
        private a() {
            super(SearchStruct$PopularResult.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        POPULAR_SEARCH_RESULT(3),
        GROUP_OUT_PEER(4),
        SEARCH_ADS(5),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 3) {
                return POPULAR_SEARCH_RESULT;
            }
            if (i == 4) {
                return GROUP_OUT_PEER;
            }
            if (i != 5) {
                return null;
            }
            return SEARCH_ADS;
        }
    }

    static {
        SearchStruct$PopularResult searchStruct$PopularResult = new SearchStruct$PopularResult();
        DEFAULT_INSTANCE = searchStruct$PopularResult;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$PopularResult.class, searchStruct$PopularResult);
    }

    private SearchStruct$PopularResult() {
    }

    private void clearDemonstrativeName() {
        this.demonstrativeName_ = getDefaultInstance().getDemonstrativeName();
    }

    private void clearGroupOutPeer() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLink() {
        this.link_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMaxAppVersion() {
        this.maxAppVersion_ = 0;
    }

    private void clearMinAppVersion() {
        this.minAppVersion_ = 0;
    }

    private void clearPopularSearchResult() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchAds() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static SearchStruct$PopularResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        if (this.traitCase_ != 4 || this.trait_ == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.trait_ = peersStruct$GroupOutPeer;
        } else {
            this.trait_ = ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder((PeersStruct$GroupOutPeer) this.trait_).v(peersStruct$GroupOutPeer)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeLink(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.link_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.link_ = stringValue;
        } else {
            this.link_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.link_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePopularSearchResult(SearchStruct$PopularSearchResult searchStruct$PopularSearchResult) {
        searchStruct$PopularSearchResult.getClass();
        if (this.traitCase_ != 3 || this.trait_ == SearchStruct$PopularSearchResult.getDefaultInstance()) {
            this.trait_ = searchStruct$PopularSearchResult;
        } else {
            this.trait_ = ((SearchStruct$PopularSearchResult.a) SearchStruct$PopularSearchResult.newBuilder((SearchStruct$PopularSearchResult) this.trait_).v(searchStruct$PopularSearchResult)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeSearchAds(SearchStruct$SearchAds searchStruct$SearchAds) {
        searchStruct$SearchAds.getClass();
        if (this.traitCase_ != 5 || this.trait_ == SearchStruct$SearchAds.getDefaultInstance()) {
            this.trait_ = searchStruct$SearchAds;
        } else {
            this.trait_ = ((SearchStruct$SearchAds.a) SearchStruct$SearchAds.newBuilder((SearchStruct$SearchAds) this.trait_).v(searchStruct$SearchAds)).j();
        }
        this.traitCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$PopularResult parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$PopularResult parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDemonstrativeName(String str) {
        str.getClass();
        this.demonstrativeName_ = str;
    }

    private void setDemonstrativeNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.demonstrativeName_ = abstractC2383g.f0();
    }

    private void setGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.trait_ = peersStruct$GroupOutPeer;
        this.traitCase_ = 4;
    }

    private void setLink(StringValue stringValue) {
        stringValue.getClass();
        this.link_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setMaxAppVersion(int i) {
        this.maxAppVersion_ = i;
    }

    private void setMinAppVersion(int i) {
        this.minAppVersion_ = i;
    }

    private void setPopularSearchResult(SearchStruct$PopularSearchResult searchStruct$PopularSearchResult) {
        searchStruct$PopularSearchResult.getClass();
        this.trait_ = searchStruct$PopularSearchResult;
        this.traitCase_ = 3;
    }

    private void setSearchAds(SearchStruct$SearchAds searchStruct$SearchAds) {
        searchStruct$SearchAds.getClass();
        this.trait_ = searchStruct$SearchAds;
        this.traitCase_ = 5;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$PopularResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006\u0004\u0007\u0004", new Object[]{"trait_", "traitCase_", "bitField0_", "demonstrativeName_", "link_", SearchStruct$PopularSearchResult.class, PeersStruct$GroupOutPeer.class, SearchStruct$SearchAds.class, "minAppVersion_", "maxAppVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$PopularResult.class) {
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

    public String getDemonstrativeName() {
        return this.demonstrativeName_;
    }

    public AbstractC2383g getDemonstrativeNameBytes() {
        return AbstractC2383g.N(this.demonstrativeName_);
    }

    public PeersStruct$GroupOutPeer getGroupOutPeer() {
        return this.traitCase_ == 4 ? (PeersStruct$GroupOutPeer) this.trait_ : PeersStruct$GroupOutPeer.getDefaultInstance();
    }

    public StringValue getLink() {
        StringValue stringValue = this.link_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getMaxAppVersion() {
        return this.maxAppVersion_;
    }

    public int getMinAppVersion() {
        return this.minAppVersion_;
    }

    public SearchStruct$PopularSearchResult getPopularSearchResult() {
        return this.traitCase_ == 3 ? (SearchStruct$PopularSearchResult) this.trait_ : SearchStruct$PopularSearchResult.getDefaultInstance();
    }

    public SearchStruct$SearchAds getSearchAds() {
        return this.traitCase_ == 5 ? (SearchStruct$SearchAds) this.trait_ : SearchStruct$SearchAds.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasGroupOutPeer() {
        return this.traitCase_ == 4;
    }

    public boolean hasLink() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPopularSearchResult() {
        return this.traitCase_ == 3;
    }

    public boolean hasSearchAds() {
        return this.traitCase_ == 5;
    }

    public static a newBuilder(SearchStruct$PopularResult searchStruct$PopularResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$PopularResult);
    }

    public static SearchStruct$PopularResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$PopularResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$PopularResult parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$PopularResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$PopularResult parseFrom(byte[] bArr) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$PopularResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$PopularResult parseFrom(InputStream inputStream) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$PopularResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$PopularResult parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$PopularResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$PopularResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
