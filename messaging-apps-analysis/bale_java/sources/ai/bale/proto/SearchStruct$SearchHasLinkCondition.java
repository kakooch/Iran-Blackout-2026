package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$SearchHasLinkCondition extends GeneratedMessageLite implements U64 {
    private static final SearchStruct$SearchHasLinkCondition DEFAULT_INSTANCE;
    public static final int HAS_LINK_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean hasLink_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((SearchStruct$SearchHasLinkCondition) this.b).setHasLink(z);
            return this;
        }

        private a() {
            super(SearchStruct$SearchHasLinkCondition.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchHasLinkCondition searchStruct$SearchHasLinkCondition = new SearchStruct$SearchHasLinkCondition();
        DEFAULT_INSTANCE = searchStruct$SearchHasLinkCondition;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchHasLinkCondition.class, searchStruct$SearchHasLinkCondition);
    }

    private SearchStruct$SearchHasLinkCondition() {
    }

    private void clearHasLink() {
        this.hasLink_ = false;
    }

    public static SearchStruct$SearchHasLinkCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchHasLinkCondition parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHasLink(boolean z) {
        this.hasLink_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchHasLinkCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"hasLink_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchHasLinkCondition.class) {
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

    public boolean getHasLink() {
        return this.hasLink_;
    }

    public static a newBuilder(SearchStruct$SearchHasLinkCondition searchStruct$SearchHasLinkCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchHasLinkCondition);
    }

    public static SearchStruct$SearchHasLinkCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(byte[] bArr) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchHasLinkCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchHasLinkCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
