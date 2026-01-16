package ai.bale.proto;

import ai.bale.proto.SearchStruct$MessageSearchResult;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3544Bh6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$MessageSearchItem extends GeneratedMessageLite implements InterfaceC3544Bh6 {
    private static final SearchStruct$MessageSearchItem DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 1;
    private int bitField0_;
    private SearchStruct$MessageSearchResult result_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3544Bh6 {
        @Override // ir.nasim.InterfaceC3544Bh6
        public SearchStruct$MessageSearchResult getResult() {
            return ((SearchStruct$MessageSearchItem) this.b).getResult();
        }

        private a() {
            super(SearchStruct$MessageSearchItem.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$MessageSearchItem searchStruct$MessageSearchItem = new SearchStruct$MessageSearchItem();
        DEFAULT_INSTANCE = searchStruct$MessageSearchItem;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$MessageSearchItem.class, searchStruct$MessageSearchItem);
    }

    private SearchStruct$MessageSearchItem() {
    }

    private void clearResult() {
        this.result_ = null;
        this.bitField0_ &= -2;
    }

    public static SearchStruct$MessageSearchItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeResult(SearchStruct$MessageSearchResult searchStruct$MessageSearchResult) {
        searchStruct$MessageSearchResult.getClass();
        SearchStruct$MessageSearchResult searchStruct$MessageSearchResult2 = this.result_;
        if (searchStruct$MessageSearchResult2 == null || searchStruct$MessageSearchResult2 == SearchStruct$MessageSearchResult.getDefaultInstance()) {
            this.result_ = searchStruct$MessageSearchResult;
        } else {
            this.result_ = (SearchStruct$MessageSearchResult) ((SearchStruct$MessageSearchResult.a) SearchStruct$MessageSearchResult.newBuilder(this.result_).v(searchStruct$MessageSearchResult)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$MessageSearchItem parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MessageSearchItem parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setResult(SearchStruct$MessageSearchResult searchStruct$MessageSearchResult) {
        searchStruct$MessageSearchResult.getClass();
        this.result_ = searchStruct$MessageSearchResult;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$MessageSearchItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "result_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$MessageSearchItem.class) {
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

    @Override // ir.nasim.InterfaceC3544Bh6
    public SearchStruct$MessageSearchResult getResult() {
        SearchStruct$MessageSearchResult searchStruct$MessageSearchResult = this.result_;
        return searchStruct$MessageSearchResult == null ? SearchStruct$MessageSearchResult.getDefaultInstance() : searchStruct$MessageSearchResult;
    }

    public boolean hasResult() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchStruct$MessageSearchItem searchStruct$MessageSearchItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$MessageSearchItem);
    }

    public static SearchStruct$MessageSearchItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MessageSearchItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$MessageSearchItem parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$MessageSearchItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$MessageSearchItem parseFrom(byte[] bArr) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$MessageSearchItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$MessageSearchItem parseFrom(InputStream inputStream) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$MessageSearchItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$MessageSearchItem parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$MessageSearchItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$MessageSearchItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
