package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.Duration;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U12;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class Validate$DurationRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 2;
    private static final Validate$DurationRules DEFAULT_INSTANCE;
    public static final int GTE_FIELD_NUMBER = 6;
    public static final int GT_FIELD_NUMBER = 5;
    public static final int IN_FIELD_NUMBER = 7;
    public static final int LTE_FIELD_NUMBER = 4;
    public static final int LT_FIELD_NUMBER = 3;
    public static final int NOT_IN_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int REQUIRED_FIELD_NUMBER = 1;
    private int bitField0_;
    private Duration const_;
    private Duration gt_;
    private Duration gte_;
    private Duration lt_;
    private Duration lte_;
    private boolean required_;
    private B.j in_ = GeneratedMessageLite.emptyProtobufList();
    private B.j notIn_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$DurationRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$DurationRules validate$DurationRules = new Validate$DurationRules();
        DEFAULT_INSTANCE = validate$DurationRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$DurationRules.class, validate$DurationRules);
    }

    private Validate$DurationRules() {
    }

    private void addAllIn(Iterable<? extends Duration> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<? extends Duration> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(Duration duration) {
        duration.getClass();
        ensureInIsMutable();
        this.in_.add(duration);
    }

    private void addNotIn(Duration duration) {
        duration.getClass();
        ensureNotInIsMutable();
        this.notIn_.add(duration);
    }

    private void clearConst() {
        this.const_ = null;
        this.bitField0_ &= -3;
    }

    private void clearGt() {
        this.gt_ = null;
        this.bitField0_ &= -17;
    }

    private void clearGte() {
        this.gte_ = null;
        this.bitField0_ &= -33;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLt() {
        this.lt_ = null;
        this.bitField0_ &= -5;
    }

    private void clearLte() {
        this.lte_ = null;
        this.bitField0_ &= -9;
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRequired() {
        this.bitField0_ &= -2;
        this.required_ = false;
    }

    private void ensureInIsMutable() {
        B.j jVar = this.in_;
        if (jVar.u()) {
            return;
        }
        this.in_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureNotInIsMutable() {
        B.j jVar = this.notIn_;
        if (jVar.u()) {
            return;
        }
        this.notIn_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Validate$DurationRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConst(Duration duration) {
        duration.getClass();
        Duration duration2 = this.const_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.const_ = duration;
        } else {
            this.const_ = (Duration) ((Duration.b) Duration.newBuilder(this.const_).v(duration)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeGt(Duration duration) {
        duration.getClass();
        Duration duration2 = this.gt_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.gt_ = duration;
        } else {
            this.gt_ = (Duration) ((Duration.b) Duration.newBuilder(this.gt_).v(duration)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeGte(Duration duration) {
        duration.getClass();
        Duration duration2 = this.gte_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.gte_ = duration;
        } else {
            this.gte_ = (Duration) ((Duration.b) Duration.newBuilder(this.gte_).v(duration)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeLt(Duration duration) {
        duration.getClass();
        Duration duration2 = this.lt_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.lt_ = duration;
        } else {
            this.lt_ = (Duration) ((Duration.b) Duration.newBuilder(this.lt_).v(duration)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeLte(Duration duration) {
        duration.getClass();
        Duration duration2 = this.lte_;
        if (duration2 == null || duration2 == Duration.getDefaultInstance()) {
            this.lte_ = duration;
        } else {
            this.lte_ = (Duration) ((Duration.b) Duration.newBuilder(this.lte_).v(duration)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$DurationRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$DurationRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$DurationRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeIn(int i) {
        ensureInIsMutable();
        this.in_.remove(i);
    }

    private void removeNotIn(int i) {
        ensureNotInIsMutable();
        this.notIn_.remove(i);
    }

    private void setConst(Duration duration) {
        duration.getClass();
        this.const_ = duration;
        this.bitField0_ |= 2;
    }

    private void setGt(Duration duration) {
        duration.getClass();
        this.gt_ = duration;
        this.bitField0_ |= 16;
    }

    private void setGte(Duration duration) {
        duration.getClass();
        this.gte_ = duration;
        this.bitField0_ |= 32;
    }

    private void setIn(int i, Duration duration) {
        duration.getClass();
        ensureInIsMutable();
        this.in_.set(i, duration);
    }

    private void setLt(Duration duration) {
        duration.getClass();
        this.lt_ = duration;
        this.bitField0_ |= 4;
    }

    private void setLte(Duration duration) {
        duration.getClass();
        this.lte_ = duration;
        this.bitField0_ |= 8;
    }

    private void setNotIn(int i, Duration duration) {
        duration.getClass();
        ensureNotInIsMutable();
        this.notIn_.set(i, duration);
    }

    private void setRequired(boolean z) {
        this.bitField0_ |= 1;
        this.required_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$DurationRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဇ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007\u001b\b\u001b", new Object[]{"bitField0_", "required_", "const_", "lt_", "lte_", "gt_", "gte_", "in_", Duration.class, "notIn_", Duration.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$DurationRules.class) {
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

    public Duration getConst() {
        Duration duration = this.const_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public Duration getGt() {
        Duration duration = this.gt_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public Duration getGte() {
        Duration duration = this.gte_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public Duration getIn(int i) {
        return (Duration) this.in_.get(i);
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<Duration> getInList() {
        return this.in_;
    }

    public U12 getInOrBuilder(int i) {
        return (U12) this.in_.get(i);
    }

    public List<? extends U12> getInOrBuilderList() {
        return this.in_;
    }

    public Duration getLt() {
        Duration duration = this.lt_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public Duration getLte() {
        Duration duration = this.lte_;
        return duration == null ? Duration.getDefaultInstance() : duration;
    }

    public Duration getNotIn(int i) {
        return (Duration) this.notIn_.get(i);
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<Duration> getNotInList() {
        return this.notIn_;
    }

    public U12 getNotInOrBuilder(int i) {
        return (U12) this.notIn_.get(i);
    }

    public List<? extends U12> getNotInOrBuilderList() {
        return this.notIn_;
    }

    public boolean getRequired() {
        return this.required_;
    }

    public boolean hasConst() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasGt() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasGte() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasLt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLte() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasRequired() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Validate$DurationRules validate$DurationRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$DurationRules);
    }

    public static Validate$DurationRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$DurationRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$DurationRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addIn(int i, Duration duration) {
        duration.getClass();
        ensureInIsMutable();
        this.in_.add(i, duration);
    }

    private void addNotIn(int i, Duration duration) {
        duration.getClass();
        ensureNotInIsMutable();
        this.notIn_.add(i, duration);
    }

    public static Validate$DurationRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$DurationRules parseFrom(byte[] bArr) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$DurationRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$DurationRules parseFrom(InputStream inputStream) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$DurationRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$DurationRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$DurationRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$DurationRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
