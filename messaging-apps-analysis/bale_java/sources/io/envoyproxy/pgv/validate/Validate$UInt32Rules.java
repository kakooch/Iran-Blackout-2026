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
public final class Validate$UInt32Rules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    private static final Validate$UInt32Rules DEFAULT_INSTANCE;
    public static final int GTE_FIELD_NUMBER = 5;
    public static final int GT_FIELD_NUMBER = 4;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 8;
    public static final int IN_FIELD_NUMBER = 6;
    public static final int LTE_FIELD_NUMBER = 3;
    public static final int LT_FIELD_NUMBER = 2;
    public static final int NOT_IN_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int const_;
    private int gt_;
    private int gte_;
    private boolean ignoreEmpty_;
    private int lt_;
    private int lte_;
    private B.g in_ = GeneratedMessageLite.emptyIntList();
    private B.g notIn_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$UInt32Rules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$UInt32Rules validate$UInt32Rules = new Validate$UInt32Rules();
        DEFAULT_INSTANCE = validate$UInt32Rules;
        GeneratedMessageLite.registerDefaultInstance(Validate$UInt32Rules.class, validate$UInt32Rules);
    }

    private Validate$UInt32Rules() {
    }

    private void addAllIn(Iterable<? extends Integer> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<? extends Integer> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(int i) {
        ensureInIsMutable();
        this.in_.b1(i);
    }

    private void addNotIn(int i) {
        ensureNotInIsMutable();
        this.notIn_.b1(i);
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = 0;
    }

    private void clearGt() {
        this.bitField0_ &= -9;
        this.gt_ = 0;
    }

    private void clearGte() {
        this.bitField0_ &= -17;
        this.gte_ = 0;
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -33;
        this.ignoreEmpty_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearLt() {
        this.bitField0_ &= -3;
        this.lt_ = 0;
    }

    private void clearLte() {
        this.bitField0_ &= -5;
        this.lte_ = 0;
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureInIsMutable() {
        B.g gVar = this.in_;
        if (gVar.u()) {
            return;
        }
        this.in_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureNotInIsMutable() {
        B.g gVar = this.notIn_;
        if (gVar.u()) {
            return;
        }
        this.notIn_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static Validate$UInt32Rules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$UInt32Rules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$UInt32Rules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(int i) {
        this.bitField0_ |= 1;
        this.const_ = i;
    }

    private void setGt(int i) {
        this.bitField0_ |= 8;
        this.gt_ = i;
    }

    private void setGte(int i) {
        this.bitField0_ |= 16;
        this.gte_ = i;
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 32;
        this.ignoreEmpty_ = z;
    }

    private void setIn(int i, int i2) {
        ensureInIsMutable();
        this.in_.U(i, i2);
    }

    private void setLt(int i) {
        this.bitField0_ |= 2;
        this.lt_ = i;
    }

    private void setLte(int i) {
        this.bitField0_ |= 4;
        this.lte_ = i;
    }

    private void setNotIn(int i, int i2) {
        ensureNotInIsMutable();
        this.notIn_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$UInt32Rules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006\u001d\u0007\u001d\bဇ\u0005", new Object[]{"bitField0_", "const_", "lt_", "lte_", "gt_", "gte_", "in_", "notIn_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$UInt32Rules.class) {
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

    public int getConst() {
        return this.const_;
    }

    public int getGt() {
        return this.gt_;
    }

    public int getGte() {
        return this.gte_;
    }

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
    }

    public int getIn(int i) {
        return this.in_.getInt(i);
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<Integer> getInList() {
        return this.in_;
    }

    public int getLt() {
        return this.lt_;
    }

    public int getLte() {
        return this.lte_;
    }

    public int getNotIn(int i) {
        return this.notIn_.getInt(i);
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<Integer> getNotInList() {
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

    public static a newBuilder(Validate$UInt32Rules validate$UInt32Rules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$UInt32Rules);
    }

    public static Validate$UInt32Rules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$UInt32Rules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$UInt32Rules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$UInt32Rules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$UInt32Rules parseFrom(byte[] bArr) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$UInt32Rules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$UInt32Rules parseFrom(InputStream inputStream) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$UInt32Rules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$UInt32Rules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$UInt32Rules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$UInt32Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
