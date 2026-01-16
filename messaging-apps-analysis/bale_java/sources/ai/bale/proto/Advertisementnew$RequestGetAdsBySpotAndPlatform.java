package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4938Hf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestGetAdsBySpotAndPlatform extends GeneratedMessageLite implements U64 {
    private static final Advertisementnew$RequestGetAdsBySpotAndPlatform DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SPOT_FIELD_NUMBER = 1;
    private int spot_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestGetAdsBySpotAndPlatform.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestGetAdsBySpotAndPlatform advertisementnew$RequestGetAdsBySpotAndPlatform = new Advertisementnew$RequestGetAdsBySpotAndPlatform();
        DEFAULT_INSTANCE = advertisementnew$RequestGetAdsBySpotAndPlatform;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestGetAdsBySpotAndPlatform.class, advertisementnew$RequestGetAdsBySpotAndPlatform);
    }

    private Advertisementnew$RequestGetAdsBySpotAndPlatform() {
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestGetAdsBySpotAndPlatform();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"spot_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestGetAdsBySpotAndPlatform.class) {
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

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public static a newBuilder(Advertisementnew$RequestGetAdsBySpotAndPlatform advertisementnew$RequestGetAdsBySpotAndPlatform) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestGetAdsBySpotAndPlatform);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
