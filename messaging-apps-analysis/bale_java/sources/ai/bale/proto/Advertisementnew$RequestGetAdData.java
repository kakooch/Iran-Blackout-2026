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
public final class Advertisementnew$RequestGetAdData extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    private static final Advertisementnew$RequestGetAdData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String adId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestGetAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestGetAdData advertisementnew$RequestGetAdData = new Advertisementnew$RequestGetAdData();
        DEFAULT_INSTANCE = advertisementnew$RequestGetAdData;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestGetAdData.class, advertisementnew$RequestGetAdData);
    }

    private Advertisementnew$RequestGetAdData() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    public static Advertisementnew$RequestGetAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestGetAdData parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new Advertisementnew$RequestGetAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"adId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestGetAdData.class) {
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

    public static a newBuilder(Advertisementnew$RequestGetAdData advertisementnew$RequestGetAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestGetAdData);
    }

    public static Advertisementnew$RequestGetAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestGetAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
