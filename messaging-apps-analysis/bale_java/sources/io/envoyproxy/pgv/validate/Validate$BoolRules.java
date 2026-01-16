package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class Validate$BoolRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    private static final Validate$BoolRules DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private boolean const_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$BoolRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$BoolRules validate$BoolRules = new Validate$BoolRules();
        DEFAULT_INSTANCE = validate$BoolRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$BoolRules.class, validate$BoolRules);
    }

    private Validate$BoolRules() {
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = false;
    }

    public static Validate$BoolRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$BoolRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$BoolRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$BoolRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(boolean z) {
        this.bitField0_ |= 1;
        this.const_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$BoolRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"bitField0_", "const_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$BoolRules.class) {
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

    public boolean getConst() {
        return this.const_;
    }

    public boolean hasConst() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Validate$BoolRules validate$BoolRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$BoolRules);
    }

    public static Validate$BoolRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$BoolRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$BoolRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$BoolRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$BoolRules parseFrom(byte[] bArr) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$BoolRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$BoolRules parseFrom(InputStream inputStream) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$BoolRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$BoolRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$BoolRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$BoolRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
