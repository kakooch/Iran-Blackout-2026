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
public final class Validate$MessageRules extends GeneratedMessageLite implements U64 {
    private static final Validate$MessageRules DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REQUIRED_FIELD_NUMBER = 2;
    public static final int SKIP_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean required_;
    private boolean skip_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$MessageRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$MessageRules validate$MessageRules = new Validate$MessageRules();
        DEFAULT_INSTANCE = validate$MessageRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$MessageRules.class, validate$MessageRules);
    }

    private Validate$MessageRules() {
    }

    private void clearRequired() {
        this.bitField0_ &= -3;
        this.required_ = false;
    }

    private void clearSkip() {
        this.bitField0_ &= -2;
        this.skip_ = false;
    }

    public static Validate$MessageRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$MessageRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$MessageRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$MessageRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRequired(boolean z) {
        this.bitField0_ |= 2;
        this.required_ = z;
    }

    private void setSkip(boolean z) {
        this.bitField0_ |= 1;
        this.skip_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$MessageRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"bitField0_", "skip_", "required_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$MessageRules.class) {
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

    public boolean getRequired() {
        return this.required_;
    }

    public boolean getSkip() {
        return this.skip_;
    }

    public boolean hasRequired() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSkip() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Validate$MessageRules validate$MessageRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$MessageRules);
    }

    public static Validate$MessageRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$MessageRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$MessageRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$MessageRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$MessageRules parseFrom(byte[] bArr) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$MessageRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$MessageRules parseFrom(InputStream inputStream) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$MessageRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$MessageRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$MessageRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$MessageRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
