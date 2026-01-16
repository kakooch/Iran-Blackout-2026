package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13219fr3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolStruct$PointSummeryInfo extends GeneratedMessageLite implements InterfaceC13219fr3 {
    private static final KifpoolStruct$PointSummeryInfo DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int key_;
    private long value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13219fr3 {
        private a() {
            super(KifpoolStruct$PointSummeryInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolStruct$PointSummeryInfo kifpoolStruct$PointSummeryInfo = new KifpoolStruct$PointSummeryInfo();
        DEFAULT_INSTANCE = kifpoolStruct$PointSummeryInfo;
        GeneratedMessageLite.registerDefaultInstance(KifpoolStruct$PointSummeryInfo.class, kifpoolStruct$PointSummeryInfo);
    }

    private KifpoolStruct$PointSummeryInfo() {
    }

    private void clearKey() {
        this.key_ = 0;
    }

    private void clearValue() {
        this.value_ = 0L;
    }

    public static KifpoolStruct$PointSummeryInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolStruct$PointSummeryInfo parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(int i) {
        this.key_ = i;
    }

    private void setValue(long j) {
        this.value_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1900v0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolStruct$PointSummeryInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolStruct$PointSummeryInfo.class) {
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

    public int getKey() {
        return this.key_;
    }

    public long getValue() {
        return this.value_;
    }

    public static a newBuilder(KifpoolStruct$PointSummeryInfo kifpoolStruct$PointSummeryInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolStruct$PointSummeryInfo);
    }

    public static KifpoolStruct$PointSummeryInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(byte[] bArr) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(InputStream inputStream) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolStruct$PointSummeryInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolStruct$PointSummeryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
