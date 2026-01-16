package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import io.envoyproxy.pgv.validate.Validate$FieldRules;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class Validate$RepeatedRules extends GeneratedMessageLite implements U64 {
    private static final Validate$RepeatedRules DEFAULT_INSTANCE;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 5;
    public static final int ITEMS_FIELD_NUMBER = 4;
    public static final int MAX_ITEMS_FIELD_NUMBER = 2;
    public static final int MIN_ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int UNIQUE_FIELD_NUMBER = 3;
    private int bitField0_;
    private boolean ignoreEmpty_;
    private Validate$FieldRules items_;
    private long maxItems_;
    private long minItems_;
    private boolean unique_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$RepeatedRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$RepeatedRules validate$RepeatedRules = new Validate$RepeatedRules();
        DEFAULT_INSTANCE = validate$RepeatedRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$RepeatedRules.class, validate$RepeatedRules);
    }

    private Validate$RepeatedRules() {
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -17;
        this.ignoreEmpty_ = false;
    }

    private void clearItems() {
        this.items_ = null;
        this.bitField0_ &= -9;
    }

    private void clearMaxItems() {
        this.bitField0_ &= -3;
        this.maxItems_ = 0L;
    }

    private void clearMinItems() {
        this.bitField0_ &= -2;
        this.minItems_ = 0L;
    }

    private void clearUnique() {
        this.bitField0_ &= -5;
        this.unique_ = false;
    }

    public static Validate$RepeatedRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeItems(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        Validate$FieldRules validate$FieldRules2 = this.items_;
        if (validate$FieldRules2 == null || validate$FieldRules2 == Validate$FieldRules.getDefaultInstance()) {
            this.items_ = validate$FieldRules;
        } else {
            this.items_ = (Validate$FieldRules) ((Validate$FieldRules.a) Validate$FieldRules.newBuilder(this.items_).v(validate$FieldRules)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$RepeatedRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$RepeatedRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 16;
        this.ignoreEmpty_ = z;
    }

    private void setItems(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        this.items_ = validate$FieldRules;
        this.bitField0_ |= 8;
    }

    private void setMaxItems(long j) {
        this.bitField0_ |= 2;
        this.maxItems_ = j;
    }

    private void setMinItems(long j) {
        this.bitField0_ |= 1;
        this.minItems_ = j;
    }

    private void setUnique(boolean z) {
        this.bitField0_ |= 4;
        this.unique_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$RepeatedRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဇ\u0004", new Object[]{"bitField0_", "minItems_", "maxItems_", "unique_", "items_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$RepeatedRules.class) {
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

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
    }

    public Validate$FieldRules getItems() {
        Validate$FieldRules validate$FieldRules = this.items_;
        return validate$FieldRules == null ? Validate$FieldRules.getDefaultInstance() : validate$FieldRules;
    }

    public long getMaxItems() {
        return this.maxItems_;
    }

    public long getMinItems() {
        return this.minItems_;
    }

    public boolean getUnique() {
        return this.unique_;
    }

    public boolean hasIgnoreEmpty() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasItems() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMaxItems() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMinItems() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUnique() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(Validate$RepeatedRules validate$RepeatedRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$RepeatedRules);
    }

    public static Validate$RepeatedRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$RepeatedRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$RepeatedRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$RepeatedRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$RepeatedRules parseFrom(byte[] bArr) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$RepeatedRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$RepeatedRules parseFrom(InputStream inputStream) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$RepeatedRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$RepeatedRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$RepeatedRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$RepeatedRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
