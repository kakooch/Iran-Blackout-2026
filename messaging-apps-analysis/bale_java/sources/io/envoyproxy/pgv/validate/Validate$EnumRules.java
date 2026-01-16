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
public final class Validate$EnumRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    private static final Validate$EnumRules DEFAULT_INSTANCE;
    public static final int DEFINED_ONLY_FIELD_NUMBER = 2;
    public static final int IN_FIELD_NUMBER = 3;
    public static final int NOT_IN_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int const_;
    private boolean definedOnly_;
    private B.g in_ = GeneratedMessageLite.emptyIntList();
    private B.g notIn_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$EnumRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$EnumRules validate$EnumRules = new Validate$EnumRules();
        DEFAULT_INSTANCE = validate$EnumRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$EnumRules.class, validate$EnumRules);
    }

    private Validate$EnumRules() {
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

    private void clearDefinedOnly() {
        this.bitField0_ &= -3;
        this.definedOnly_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyIntList();
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

    public static Validate$EnumRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$EnumRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$EnumRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$EnumRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(int i) {
        this.bitField0_ |= 1;
        this.const_ = i;
    }

    private void setDefinedOnly(boolean z) {
        this.bitField0_ |= 2;
        this.definedOnly_ = z;
    }

    private void setIn(int i, int i2) {
        ensureInIsMutable();
        this.in_.U(i, i2);
    }

    private void setNotIn(int i, int i2) {
        ensureNotInIsMutable();
        this.notIn_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$EnumRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001င\u0000\u0002ဇ\u0001\u0003\u0016\u0004\u0016", new Object[]{"bitField0_", "const_", "definedOnly_", "in_", "notIn_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$EnumRules.class) {
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

    public boolean getDefinedOnly() {
        return this.definedOnly_;
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

    public boolean hasDefinedOnly() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Validate$EnumRules validate$EnumRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$EnumRules);
    }

    public static Validate$EnumRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$EnumRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$EnumRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$EnumRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$EnumRules parseFrom(byte[] bArr) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$EnumRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$EnumRules parseFrom(InputStream inputStream) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$EnumRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$EnumRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$EnumRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$EnumRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
