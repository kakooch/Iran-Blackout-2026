package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestCreateKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestCreateKifpool DEFAULT_INSTANCE;
    public static final int NATIONAL_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue nationalId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestCreateKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestCreateKifpool kifpoolOuterClass$RequestCreateKifpool = new KifpoolOuterClass$RequestCreateKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestCreateKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestCreateKifpool.class, kifpoolOuterClass$RequestCreateKifpool);
    }

    private KifpoolOuterClass$RequestCreateKifpool() {
    }

    private void clearNationalId() {
        this.nationalId_ = null;
        this.bitField0_ &= -2;
    }

    public static KifpoolOuterClass$RequestCreateKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNationalId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nationalId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nationalId_ = stringValue;
        } else {
            this.nationalId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nationalId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalId(StringValue stringValue) {
        stringValue.getClass();
        this.nationalId_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestCreateKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "nationalId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestCreateKifpool.class) {
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

    public StringValue getNationalId() {
        StringValue stringValue = this.nationalId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasNationalId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestCreateKifpool kifpoolOuterClass$RequestCreateKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestCreateKifpool);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestCreateKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestCreateKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
