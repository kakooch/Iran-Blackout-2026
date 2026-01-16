package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class Validate$DoubleRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    private static final Validate$DoubleRules DEFAULT_INSTANCE;
    public static final int GTE_FIELD_NUMBER = 5;
    public static final int GT_FIELD_NUMBER = 4;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 8;
    public static final int IN_FIELD_NUMBER = 6;
    public static final int LTE_FIELD_NUMBER = 3;
    public static final int LT_FIELD_NUMBER = 2;
    public static final int NOT_IN_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private double const_;
    private double gt_;
    private double gte_;
    private boolean ignoreEmpty_;
    private double lt_;
    private double lte_;
    private B.b in_ = GeneratedMessageLite.emptyDoubleList();
    private B.b notIn_ = GeneratedMessageLite.emptyDoubleList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$DoubleRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$DoubleRules validate$DoubleRules = new Validate$DoubleRules();
        DEFAULT_INSTANCE = validate$DoubleRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$DoubleRules.class, validate$DoubleRules);
    }

    private Validate$DoubleRules() {
    }

    private void addAllIn(Iterable<? extends Double> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<? extends Double> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(double d) {
        ensureInIsMutable();
        this.in_.s1(d);
    }

    private void addNotIn(double d) {
        ensureNotInIsMutable();
        this.notIn_.s1(d);
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = 0.0d;
    }

    private void clearGt() {
        this.bitField0_ &= -9;
        this.gt_ = 0.0d;
    }

    private void clearGte() {
        this.bitField0_ &= -17;
        this.gte_ = 0.0d;
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -33;
        this.ignoreEmpty_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void clearLt() {
        this.bitField0_ &= -3;
        this.lt_ = 0.0d;
    }

    private void clearLte() {
        this.bitField0_ &= -5;
        this.lte_ = 0.0d;
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyDoubleList();
    }

    private void ensureInIsMutable() {
        B.b bVar = this.in_;
        if (bVar.u()) {
            return;
        }
        this.in_ = GeneratedMessageLite.mutableCopy(bVar);
    }

    private void ensureNotInIsMutable() {
        B.b bVar = this.notIn_;
        if (bVar.u()) {
            return;
        }
        this.notIn_ = GeneratedMessageLite.mutableCopy(bVar);
    }

    public static Validate$DoubleRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$DoubleRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$DoubleRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(double d) {
        this.bitField0_ |= 1;
        this.const_ = d;
    }

    private void setGt(double d) {
        this.bitField0_ |= 8;
        this.gt_ = d;
    }

    private void setGte(double d) {
        this.bitField0_ |= 16;
        this.gte_ = d;
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 32;
        this.ignoreEmpty_ = z;
    }

    private void setIn(int i, double d) {
        ensureInIsMutable();
        this.in_.S0(i, d);
    }

    private void setLt(double d) {
        this.bitField0_ |= 2;
        this.lt_ = d;
    }

    private void setLte(double d) {
        this.bitField0_ |= 4;
        this.lte_ = d;
    }

    private void setNotIn(int i, double d) {
        ensureNotInIsMutable();
        this.notIn_.S0(i, d);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$DoubleRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004\u0006\u0012\u0007\u0012\bဇ\u0005", new Object[]{"bitField0_", "const_", "lt_", "lte_", "gt_", "gte_", "in_", "notIn_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$DoubleRules.class) {
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

    public double getConst() {
        return this.const_;
    }

    public double getGt() {
        return this.gt_;
    }

    public double getGte() {
        return this.gte_;
    }

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
    }

    public double getIn(int i) {
        return this.in_.getDouble(i);
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<Double> getInList() {
        return this.in_;
    }

    public double getLt() {
        return this.lt_;
    }

    public double getLte() {
        return this.lte_;
    }

    public double getNotIn(int i) {
        return this.notIn_.getDouble(i);
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<Double> getNotInList() {
        return this.notIn_;
    }

    public boolean hasConst() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasGt() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasGte() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasIgnoreEmpty() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasLt() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLte() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(Validate$DoubleRules validate$DoubleRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$DoubleRules);
    }

    public static Validate$DoubleRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$DoubleRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$DoubleRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$DoubleRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$DoubleRules parseFrom(byte[] bArr) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$DoubleRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$DoubleRules parseFrom(InputStream inputStream) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$DoubleRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$DoubleRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$DoubleRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$DoubleRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
