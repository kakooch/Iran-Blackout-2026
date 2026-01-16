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
public final class KifpoolOuterClass$ResponseUpgradeKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseUpgradeKifpool DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int level_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseUpgradeKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseUpgradeKifpool kifpoolOuterClass$ResponseUpgradeKifpool = new KifpoolOuterClass$ResponseUpgradeKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseUpgradeKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseUpgradeKifpool.class, kifpoolOuterClass$ResponseUpgradeKifpool);
    }

    private KifpoolOuterClass$ResponseUpgradeKifpool() {
    }

    private void clearLevel() {
        this.level_ = 0;
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLevel(int i) {
        this.level_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseUpgradeKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"level_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseUpgradeKifpool.class) {
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

    public int getLevel() {
        return this.level_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseUpgradeKifpool kifpoolOuterClass$ResponseUpgradeKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseUpgradeKifpool);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseUpgradeKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseUpgradeKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
