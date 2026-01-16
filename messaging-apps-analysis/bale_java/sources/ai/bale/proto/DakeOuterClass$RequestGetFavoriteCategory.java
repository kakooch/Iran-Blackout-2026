package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeOuterClass$RequestGetFavoriteCategory extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$RequestGetFavoriteCategory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$RequestGetFavoriteCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$RequestGetFavoriteCategory dakeOuterClass$RequestGetFavoriteCategory = new DakeOuterClass$RequestGetFavoriteCategory();
        DEFAULT_INSTANCE = dakeOuterClass$RequestGetFavoriteCategory;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$RequestGetFavoriteCategory.class, dakeOuterClass$RequestGetFavoriteCategory);
    }

    private DakeOuterClass$RequestGetFavoriteCategory() {
    }

    public static DakeOuterClass$RequestGetFavoriteCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$RequestGetFavoriteCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$RequestGetFavoriteCategory.class) {
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

    public static a newBuilder(DakeOuterClass$RequestGetFavoriteCategory dakeOuterClass$RequestGetFavoriteCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$RequestGetFavoriteCategory);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(byte[] bArr) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$RequestGetFavoriteCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$RequestGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
