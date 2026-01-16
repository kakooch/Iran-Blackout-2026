package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8202Uy5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$GlobalConfig extends GeneratedMessageLite implements U64 {
    private static final PushStruct$GlobalConfig DEFAULT_INSTANCE;
    public static final int ENABLE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean enable_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$GlobalConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$GlobalConfig pushStruct$GlobalConfig = new PushStruct$GlobalConfig();
        DEFAULT_INSTANCE = pushStruct$GlobalConfig;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$GlobalConfig.class, pushStruct$GlobalConfig);
    }

    private PushStruct$GlobalConfig() {
    }

    private void clearEnable() {
        this.enable_ = false;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PushStruct$GlobalConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$GlobalConfig parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$GlobalConfig parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnable(boolean z) {
        this.enable_ = z;
    }

    private void setType(EnumC8202Uy5 enumC8202Uy5) {
        this.type_ = enumC8202Uy5.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$GlobalConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0007", new Object[]{"type_", "enable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$GlobalConfig.class) {
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

    public boolean getEnable() {
        return this.enable_;
    }

    public EnumC8202Uy5 getType() {
        EnumC8202Uy5 enumC8202Uy5J = EnumC8202Uy5.j(this.type_);
        return enumC8202Uy5J == null ? EnumC8202Uy5.UNRECOGNIZED : enumC8202Uy5J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(PushStruct$GlobalConfig pushStruct$GlobalConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$GlobalConfig);
    }

    public static PushStruct$GlobalConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$GlobalConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$GlobalConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$GlobalConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$GlobalConfig parseFrom(byte[] bArr) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$GlobalConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$GlobalConfig parseFrom(InputStream inputStream) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$GlobalConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$GlobalConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$GlobalConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$GlobalConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
