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
public final class Arbainexchange$ResponseGetRate extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$ResponseGetRate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RATE_FIELD_NUMBER = 1;
    private float rate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetRate.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetRate arbainexchange$ResponseGetRate = new Arbainexchange$ResponseGetRate();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetRate;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetRate.class, arbainexchange$ResponseGetRate);
    }

    private Arbainexchange$ResponseGetRate() {
    }

    private void clearRate() {
        this.rate_ = 0.0f;
    }

    public static Arbainexchange$ResponseGetRate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetRate parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRate(float f) {
        this.rate_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetRate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001", new Object[]{"rate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetRate.class) {
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

    public float getRate() {
        return this.rate_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetRate arbainexchange$ResponseGetRate) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetRate);
    }

    public static Arbainexchange$ResponseGetRate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetRate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
