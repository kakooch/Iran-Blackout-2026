package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestUpdateClickV2 extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 2;
    private static final Advertisementnew$RequestUpdateClickV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String adId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestUpdateClickV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestUpdateClickV2 advertisementnew$RequestUpdateClickV2 = new Advertisementnew$RequestUpdateClickV2();
        DEFAULT_INSTANCE = advertisementnew$RequestUpdateClickV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestUpdateClickV2.class, advertisementnew$RequestUpdateClickV2);
    }

    private Advertisementnew$RequestUpdateClickV2() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    public static Advertisementnew$RequestUpdateClickV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestUpdateClickV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestUpdateClickV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"adId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestUpdateClickV2.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public static a newBuilder(Advertisementnew$RequestUpdateClickV2 advertisementnew$RequestUpdateClickV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestUpdateClickV2);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestUpdateClickV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestUpdateClickV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
