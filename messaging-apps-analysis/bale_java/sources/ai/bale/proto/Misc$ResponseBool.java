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
public final class Misc$ResponseBool extends GeneratedMessageLite implements U64 {
    private static final Misc$ResponseBool DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private boolean value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Misc$ResponseBool.DEFAULT_INSTANCE);
        }
    }

    static {
        Misc$ResponseBool misc$ResponseBool = new Misc$ResponseBool();
        DEFAULT_INSTANCE = misc$ResponseBool;
        GeneratedMessageLite.registerDefaultInstance(Misc$ResponseBool.class, misc$ResponseBool);
    }

    private Misc$ResponseBool() {
    }

    private void clearValue() {
        this.value_ = false;
    }

    public static Misc$ResponseBool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Misc$ResponseBool parseDelimitedFrom(InputStream inputStream) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseBool parseFrom(ByteBuffer byteBuffer) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(boolean z) {
        this.value_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N0.a[gVar.ordinal()]) {
            case 1:
                return new Misc$ResponseBool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Misc$ResponseBool.class) {
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

    public boolean getValue() {
        return this.value_;
    }

    public static a newBuilder(Misc$ResponseBool misc$ResponseBool) {
        return (a) DEFAULT_INSTANCE.createBuilder(misc$ResponseBool);
    }

    public static Misc$ResponseBool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseBool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Misc$ResponseBool parseFrom(AbstractC2383g abstractC2383g) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Misc$ResponseBool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Misc$ResponseBool parseFrom(byte[] bArr) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Misc$ResponseBool parseFrom(byte[] bArr, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Misc$ResponseBool parseFrom(InputStream inputStream) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$ResponseBool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$ResponseBool parseFrom(AbstractC2384h abstractC2384h) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Misc$ResponseBool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Misc$ResponseBool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
