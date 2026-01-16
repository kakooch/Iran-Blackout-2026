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
public final class Validate$MapRules extends GeneratedMessageLite implements U64 {
    private static final Validate$MapRules DEFAULT_INSTANCE;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 6;
    public static final int KEYS_FIELD_NUMBER = 4;
    public static final int MAX_PAIRS_FIELD_NUMBER = 2;
    public static final int MIN_PAIRS_FIELD_NUMBER = 1;
    public static final int NO_SPARSE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 5;
    private int bitField0_;
    private boolean ignoreEmpty_;
    private Validate$FieldRules keys_;
    private long maxPairs_;
    private long minPairs_;
    private boolean noSparse_;
    private Validate$FieldRules values_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$MapRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$MapRules validate$MapRules = new Validate$MapRules();
        DEFAULT_INSTANCE = validate$MapRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$MapRules.class, validate$MapRules);
    }

    private Validate$MapRules() {
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -33;
        this.ignoreEmpty_ = false;
    }

    private void clearKeys() {
        this.keys_ = null;
        this.bitField0_ &= -9;
    }

    private void clearMaxPairs() {
        this.bitField0_ &= -3;
        this.maxPairs_ = 0L;
    }

    private void clearMinPairs() {
        this.bitField0_ &= -2;
        this.minPairs_ = 0L;
    }

    private void clearNoSparse() {
        this.bitField0_ &= -5;
        this.noSparse_ = false;
    }

    private void clearValues() {
        this.values_ = null;
        this.bitField0_ &= -17;
    }

    public static Validate$MapRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeKeys(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        Validate$FieldRules validate$FieldRules2 = this.keys_;
        if (validate$FieldRules2 == null || validate$FieldRules2 == Validate$FieldRules.getDefaultInstance()) {
            this.keys_ = validate$FieldRules;
        } else {
            this.keys_ = (Validate$FieldRules) ((Validate$FieldRules.a) Validate$FieldRules.newBuilder(this.keys_).v(validate$FieldRules)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeValues(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        Validate$FieldRules validate$FieldRules2 = this.values_;
        if (validate$FieldRules2 == null || validate$FieldRules2 == Validate$FieldRules.getDefaultInstance()) {
            this.values_ = validate$FieldRules;
        } else {
            this.values_ = (Validate$FieldRules) ((Validate$FieldRules.a) Validate$FieldRules.newBuilder(this.values_).v(validate$FieldRules)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$MapRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$MapRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$MapRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 32;
        this.ignoreEmpty_ = z;
    }

    private void setKeys(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        this.keys_ = validate$FieldRules;
        this.bitField0_ |= 8;
    }

    private void setMaxPairs(long j) {
        this.bitField0_ |= 2;
        this.maxPairs_ = j;
    }

    private void setMinPairs(long j) {
        this.bitField0_ |= 1;
        this.minPairs_ = j;
    }

    private void setNoSparse(boolean z) {
        this.bitField0_ |= 4;
        this.noSparse_ = z;
    }

    private void setValues(Validate$FieldRules validate$FieldRules) {
        validate$FieldRules.getClass();
        this.values_ = validate$FieldRules;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$MapRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "minPairs_", "maxPairs_", "noSparse_", "keys_", "values_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$MapRules.class) {
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

    public Validate$FieldRules getKeys() {
        Validate$FieldRules validate$FieldRules = this.keys_;
        return validate$FieldRules == null ? Validate$FieldRules.getDefaultInstance() : validate$FieldRules;
    }

    public long getMaxPairs() {
        return this.maxPairs_;
    }

    public long getMinPairs() {
        return this.minPairs_;
    }

    public boolean getNoSparse() {
        return this.noSparse_;
    }

    public Validate$FieldRules getValues() {
        Validate$FieldRules validate$FieldRules = this.values_;
        return validate$FieldRules == null ? Validate$FieldRules.getDefaultInstance() : validate$FieldRules;
    }

    public boolean hasIgnoreEmpty() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasKeys() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMaxPairs() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMinPairs() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNoSparse() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasValues() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(Validate$MapRules validate$MapRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$MapRules);
    }

    public static Validate$MapRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$MapRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$MapRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$MapRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$MapRules parseFrom(byte[] bArr) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$MapRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$MapRules parseFrom(InputStream inputStream) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$MapRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$MapRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$MapRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$MapRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
