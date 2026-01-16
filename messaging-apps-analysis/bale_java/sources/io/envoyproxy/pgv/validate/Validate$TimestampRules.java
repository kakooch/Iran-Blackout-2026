package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class Validate$TimestampRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 2;
    private static final Validate$TimestampRules DEFAULT_INSTANCE;
    public static final int GTE_FIELD_NUMBER = 6;
    public static final int GT_FIELD_NUMBER = 5;
    public static final int GT_NOW_FIELD_NUMBER = 8;
    public static final int LTE_FIELD_NUMBER = 4;
    public static final int LT_FIELD_NUMBER = 3;
    public static final int LT_NOW_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int REQUIRED_FIELD_NUMBER = 1;
    public static final int WITHIN_FIELD_NUMBER = 9;
    private int bitField0_;
    private Timestamp const_;
    private boolean gtNow_;
    private Timestamp gt_;
    private Timestamp gte_;
    private boolean ltNow_;
    private Timestamp lt_;
    private Timestamp lte_;
    private boolean required_;
    private Duration within_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$TimestampRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$TimestampRules validate$TimestampRules = new Validate$TimestampRules();
        DEFAULT_INSTANCE = validate$TimestampRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$TimestampRules.class, validate$TimestampRules);
    }

    private Validate$TimestampRules() {
    }

    private void clearConst() {
        this.const_ = null;
        this.bitField0_ &= -3;
    }

    private void clearGt() {
        this.gt_ = null;
        this.bitField0_ &= -17;
    }

    private void clearGtNow() {
        this.bitField0_ &= -129;
        this.gtNow_ = false;
    }

    private void clearGte() {
        this.gte_ = null;
        this.bitField0_ &= -33;
    }

    private void clearLt() {
        this.lt_ = null;
        this.bitField0_ &= -5;
    }

    private void clearLtNow() {
        this.bitField0_ &= -65;
        this.ltNow_ = false;
    }

    private void clearLte() {
        this.lte_ = null;
        this.bitField0_ &= -9;
    }

    private void clearRequired() {
        this.bitField0_ &= -2;
        this.required_ = false;
    }

    private void clearWithin() {
        this.within_ = null;
        this.bitField0_ &= -257;
    }

    public static Validate$TimestampRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConst(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.const_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.const_ = timestamp;
        } else {
            this.const_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.const_).v(timestamp)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeGt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.gt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.gt_ = timestamp;
        } else {
            this.gt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.gt_).v(timestamp)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeGte(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.gte_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.gte_ = timestamp;
        } else {
            this.gte_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.gte_).v(timestamp)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeLt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lt_ = timestamp;
        } else {
            this.lt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lt_).v(timestamp)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeLte(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lte_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lte_ = timestamp;
        } else {
            this.lte_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lte_).v(timestamp)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeWithin(Duration duration) {
        duration.getClass();
        Duration duration2 = this.within_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.within_ = duration;
        } else {
            this.within_ = (Duration) ((Duration.b) Duration.newBuilder(this.within_).v(duration)).j();
        }
        this.bitField0_ |= 256;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$TimestampRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$TimestampRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(Timestamp timestamp) {
        timestamp.getClass();
        this.const_ = timestamp;
        this.bitField0_ |= 2;
    }

    private void setGt(Timestamp timestamp) {
        timestamp.getClass();
        this.gt_ = timestamp;
        this.bitField0_ |= 16;
    }

    private void setGtNow(boolean z) {
        this.bitField0_ |= 128;
        this.gtNow_ = z;
    }

    private void setGte(Timestamp timestamp) {
        timestamp.getClass();
        this.gte_ = timestamp;
        this.bitField0_ |= 32;
    }

    private void setLt(Timestamp timestamp) {
        timestamp.getClass();
        this.lt_ = timestamp;
        this.bitField0_ |= 4;
    }

    private void setLtNow(boolean z) {
        this.bitField0_ |= 64;
        this.ltNow_ = z;
    }

    private void setLte(Timestamp timestamp) {
        timestamp.getClass();
        this.lte_ = timestamp;
        this.bitField0_ |= 8;
    }

    private void setRequired(boolean z) {
        this.bitField0_ |= 1;
        this.required_ = z;
    }

    private void setWithin(Duration duration) {
        duration.getClass();
        this.within_ = duration;
        this.bitField0_ |= 256;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$TimestampRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဇ\u0006\bဇ\u0007\tဉ\b", new Object[]{"bitField0_", "required_", "const_", "lt_", "lte_", "gt_", "gte_", "ltNow_", "gtNow_", "within_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$TimestampRules.class) {
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

    public Timestamp getConst() {
        Timestamp timestamp = this.const_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getGt() {
        Timestamp timestamp = this.gt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean getGtNow() {
        return this.gtNow_;
    }

    public Timestamp getGte() {
        Timestamp timestamp = this.gte_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getLt() {
        Timestamp timestamp = this.lt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean getLtNow() {
        return this.ltNow_;
    }

    public Timestamp getLte() {
        Timestamp timestamp = this.lte_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean getRequired() {
        return this.required_;
    }

    public Duration getWithin() {
        Duration duration = this.within_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public boolean hasConst() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasGt() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasGtNow() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasGte() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasLt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLtNow() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasLte() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasRequired() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWithin() {
        return (this.bitField0_ & 256) != 0;
    }

    public static a newBuilder(Validate$TimestampRules validate$TimestampRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$TimestampRules);
    }

    public static Validate$TimestampRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$TimestampRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$TimestampRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$TimestampRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$TimestampRules parseFrom(byte[] bArr) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$TimestampRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$TimestampRules parseFrom(InputStream inputStream) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$TimestampRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$TimestampRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$TimestampRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$TimestampRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
