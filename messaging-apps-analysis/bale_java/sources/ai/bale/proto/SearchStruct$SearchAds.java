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
public final class SearchStruct$SearchAds extends GeneratedMessageLite implements U64 {
    private static final SearchStruct$SearchAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchStruct$SearchAds.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchAds searchStruct$SearchAds = new SearchStruct$SearchAds();
        DEFAULT_INSTANCE = searchStruct$SearchAds;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchAds.class, searchStruct$SearchAds);
    }

    private SearchStruct$SearchAds() {
    }

    public static SearchStruct$SearchAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchAds parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchAds parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchAds.class) {
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

    public static a newBuilder(SearchStruct$SearchAds searchStruct$SearchAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchAds);
    }

    public static SearchStruct$SearchAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchAds parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchStruct$SearchAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchAds parseFrom(byte[] bArr) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchAds parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchAds parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
