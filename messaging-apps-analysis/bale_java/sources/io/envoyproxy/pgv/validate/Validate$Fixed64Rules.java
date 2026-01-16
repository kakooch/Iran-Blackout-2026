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
public final class Validate$Fixed64Rules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    private static final Validate$Fixed64Rules DEFAULT_INSTANCE;
    public static final int GTE_FIELD_NUMBER = 5;
    public static final int GT_FIELD_NUMBER = 4;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 8;
    public static final int IN_FIELD_NUMBER = 6;
    public static final int LTE_FIELD_NUMBER = 3;
    public static final int LT_FIELD_NUMBER = 2;
    public static final int NOT_IN_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long const_;
    private long gt_;
    private long gte_;
    private boolean ignoreEmpty_;
    private long lt_;
    private long lte_;
    private B.i in_ = GeneratedMessageLite.emptyLongList();
    private B.i notIn_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$Fixed64Rules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$Fixed64Rules validate$Fixed64Rules = new Validate$Fixed64Rules();
        DEFAULT_INSTANCE = validate$Fixed64Rules;
        GeneratedMessageLite.registerDefaultInstance(Validate$Fixed64Rules.class, validate$Fixed64Rules);
    }

    private Validate$Fixed64Rules() {
    }

    private void addAllIn(Iterable<? extends Long> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<? extends Long> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(long j) {
        ensureInIsMutable();
        this.in_.l1(j);
    }

    private void addNotIn(long j) {
        ensureNotInIsMutable();
        this.notIn_.l1(j);
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = 0L;
    }

    private void clearGt() {
        this.bitField0_ &= -9;
        this.gt_ = 0L;
    }

    private void clearGte() {
        this.bitField0_ &= -17;
        this.gte_ = 0L;
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -33;
        this.ignoreEmpty_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearLt() {
        this.bitField0_ &= -3;
        this.lt_ = 0L;
    }

    private void clearLte() {
        this.bitField0_ &= -5;
        this.lte_ = 0L;
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureInIsMutable() {
        B.i iVar = this.in_;
        if (iVar.u()) {
            return;
        }
        this.in_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    private void ensureNotInIsMutable() {
        B.i iVar = this.notIn_;
        if (iVar.u()) {
            return;
        }
        this.notIn_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static Validate$Fixed64Rules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$Fixed64Rules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$Fixed64Rules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(long j) {
        this.bitField0_ |= 1;
        this.const_ = j;
    }

    private void setGt(long j) {
        this.bitField0_ |= 8;
        this.gt_ = j;
    }

    private void setGte(long j) {
        this.bitField0_ |= 16;
        this.gte_ = j;
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 32;
        this.ignoreEmpty_ = z;
    }

    private void setIn(int i, long j) {
        ensureInIsMutable();
        this.in_.z1(i, j);
    }

    private void setLt(long j) {
        this.bitField0_ |= 2;
        this.lt_ = j;
    }

    private void setLte(long j) {
        this.bitField0_ |= 4;
        this.lte_ = j;
    }

    private void setNotIn(int i, long j) {
        ensureNotInIsMutable();
        this.notIn_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$Fixed64Rules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001စ\u0000\u0002စ\u0001\u0003စ\u0002\u0004စ\u0003\u0005စ\u0004\u0006\u0017\u0007\u0017\bဇ\u0005", new Object[]{"bitField0_", "const_", "lt_", "lte_", "gt_", "gte_", "in_", "notIn_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$Fixed64Rules.class) {
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

    public long getConst() {
        return this.const_;
    }

    public long getGt() {
        return this.gt_;
    }

    public long getGte() {
        return this.gte_;
    }

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
    }

    public long getIn(int i) {
        return this.in_.getLong(i);
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<Long> getInList() {
        return this.in_;
    }

    public long getLt() {
        return this.lt_;
    }

    public long getLte() {
        return this.lte_;
    }

    public long getNotIn(int i) {
        return this.notIn_.getLong(i);
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<Long> getNotInList() {
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

    public static a newBuilder(Validate$Fixed64Rules validate$Fixed64Rules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$Fixed64Rules);
    }

    public static Validate$Fixed64Rules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$Fixed64Rules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$Fixed64Rules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$Fixed64Rules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$Fixed64Rules parseFrom(byte[] bArr) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$Fixed64Rules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$Fixed64Rules parseFrom(InputStream inputStream) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$Fixed64Rules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$Fixed64Rules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$Fixed64Rules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$Fixed64Rules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
