package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC9137Yq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestGetMyKifpools extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestGetMyKifpools DEFAULT_INSTANCE;
    public static final int INVOCATIONSPOT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int POCKET_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private StringValue invocationSpot_;
    private int pocketType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestGetMyKifpools.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestGetMyKifpools kifpoolOuterClass$RequestGetMyKifpools = new KifpoolOuterClass$RequestGetMyKifpools();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestGetMyKifpools;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestGetMyKifpools.class, kifpoolOuterClass$RequestGetMyKifpools);
    }

    private KifpoolOuterClass$RequestGetMyKifpools() {
    }

    private void clearInvocationSpot() {
        this.invocationSpot_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPocketType() {
        this.pocketType_ = 0;
    }

    public static KifpoolOuterClass$RequestGetMyKifpools getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInvocationSpot(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.invocationSpot_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.invocationSpot_ = stringValue;
        } else {
            this.invocationSpot_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.invocationSpot_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvocationSpot(StringValue stringValue) {
        stringValue.getClass();
        this.invocationSpot_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setPocketType(EnumC9137Yq3 enumC9137Yq3) {
        this.pocketType_ = enumC9137Yq3.getNumber();
    }

    private void setPocketTypeValue(int i) {
        this.pocketType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestGetMyKifpools();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "invocationSpot_", "pocketType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestGetMyKifpools.class) {
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

    public StringValue getInvocationSpot() {
        StringValue stringValue = this.invocationSpot_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC9137Yq3 getPocketType() {
        EnumC9137Yq3 enumC9137Yq3J = EnumC9137Yq3.j(this.pocketType_);
        return enumC9137Yq3J == null ? EnumC9137Yq3.UNRECOGNIZED : enumC9137Yq3J;
    }

    public int getPocketTypeValue() {
        return this.pocketType_;
    }

    public boolean hasInvocationSpot() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestGetMyKifpools kifpoolOuterClass$RequestGetMyKifpools) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestGetMyKifpools);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestGetMyKifpools parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
