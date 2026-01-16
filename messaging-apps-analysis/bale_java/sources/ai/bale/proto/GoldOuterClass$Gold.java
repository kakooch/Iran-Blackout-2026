package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PJ2;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$Gold extends GeneratedMessageLite implements U64 {
    private static final GoldOuterClass$Gold DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UNIT_FIELD_NUMBER = 2;
    public static final int WEIGHT_FIELD_NUMBER = 1;
    private int unit_;
    private long weight_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$Gold.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$Gold goldOuterClass$Gold = new GoldOuterClass$Gold();
        DEFAULT_INSTANCE = goldOuterClass$Gold;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$Gold.class, goldOuterClass$Gold);
    }

    private GoldOuterClass$Gold() {
    }

    private void clearUnit() {
        this.unit_ = 0;
    }

    private void clearWeight() {
        this.weight_ = 0L;
    }

    public static GoldOuterClass$Gold getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$Gold parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$Gold parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUnit(PJ2 pj2) {
        this.unit_ = pj2.getNumber();
    }

    private void setUnitValue(int i) {
        this.unit_ = i;
    }

    private void setWeight(long j) {
        this.weight_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$Gold();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\f", new Object[]{"weight_", "unit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$Gold.class) {
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

    public PJ2 getUnit() {
        PJ2 pj2J = PJ2.j(this.unit_);
        return pj2J == null ? PJ2.UNRECOGNIZED : pj2J;
    }

    public int getUnitValue() {
        return this.unit_;
    }

    public long getWeight() {
        return this.weight_;
    }

    public static a newBuilder(GoldOuterClass$Gold goldOuterClass$Gold) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$Gold);
    }

    public static GoldOuterClass$Gold parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$Gold parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$Gold parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$Gold parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$Gold parseFrom(byte[] bArr) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$Gold parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$Gold parseFrom(InputStream inputStream) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$Gold parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$Gold parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$Gold parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$Gold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
