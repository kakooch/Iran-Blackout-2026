package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6371Nh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SearchStruct$SearchPeerContentType extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
    private static final SearchStruct$SearchPeerContentType DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int contentType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchStruct$SearchPeerContentType.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchPeerContentType searchStruct$SearchPeerContentType = new SearchStruct$SearchPeerContentType();
        DEFAULT_INSTANCE = searchStruct$SearchPeerContentType;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchPeerContentType.class, searchStruct$SearchPeerContentType);
    }

    private SearchStruct$SearchPeerContentType() {
    }

    private void clearContentType() {
        this.contentType_ = 0;
    }

    public static SearchStruct$SearchPeerContentType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchPeerContentType parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContentType(EnumC6371Nh6 enumC6371Nh6) {
        this.contentType_ = enumC6371Nh6.getNumber();
    }

    private void setContentTypeValue(int i) {
        this.contentType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchPeerContentType();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"contentType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchPeerContentType.class) {
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

    public static a newBuilder(SearchStruct$SearchPeerContentType searchStruct$SearchPeerContentType) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchPeerContentType);
    }

    public static SearchStruct$SearchPeerContentType parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(byte[] bArr) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchPeerContentType parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchPeerContentType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
