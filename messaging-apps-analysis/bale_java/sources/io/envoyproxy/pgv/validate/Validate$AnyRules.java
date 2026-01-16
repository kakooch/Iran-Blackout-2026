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
public final class Validate$AnyRules extends GeneratedMessageLite implements U64 {
    private static final Validate$AnyRules DEFAULT_INSTANCE;
    public static final int IN_FIELD_NUMBER = 2;
    public static final int NOT_IN_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REQUIRED_FIELD_NUMBER = 1;
    private int bitField0_;
    private B.j in_ = GeneratedMessageLite.emptyProtobufList();
    private B.j notIn_ = GeneratedMessageLite.emptyProtobufList();
    private boolean required_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$AnyRules.DEFAULT_INSTANCE);
        }
    }

    static {
        Validate$AnyRules validate$AnyRules = new Validate$AnyRules();
        DEFAULT_INSTANCE = validate$AnyRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$AnyRules.class, validate$AnyRules);
    }

    private Validate$AnyRules() {
    }

    private void addAllIn(Iterable<String> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<String> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(String str) {
        str.getClass();
        ensureInIsMutable();
        this.in_.add(str);
    }

    private void addInBytes(AbstractC2383g abstractC2383g) {
        ensureInIsMutable();
        this.in_.add(abstractC2383g.f0());
    }

    private void addNotIn(String str) {
        str.getClass();
        ensureNotInIsMutable();
        this.notIn_.add(str);
    }

    private void addNotInBytes(AbstractC2383g abstractC2383g) {
        ensureNotInIsMutable();
        this.notIn_.add(abstractC2383g.f0());
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyProtobufList();
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

    public static Validate$AnyRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$AnyRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$AnyRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$AnyRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIn(int i, String str) {
        str.getClass();
        ensureInIsMutable();
        this.in_.set(i, str);
    }

    private void setNotIn(int i, String str) {
        str.getClass();
        ensureNotInIsMutable();
        this.notIn_.set(i, str);
    }

    private void setRequired(boolean z) {
        this.bitField0_ |= 1;
        this.required_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$AnyRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဇ\u0000\u0002\u001a\u0003\u001a", new Object[]{"bitField0_", "required_", "in_", "notIn_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$AnyRules.class) {
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

    public String getIn(int i) {
        return (String) this.in_.get(i);
    }

    public AbstractC2383g getInBytes(int i) {
        return AbstractC2383g.N((String) this.in_.get(i));
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<String> getInList() {
        return this.in_;
    }

    public String getNotIn(int i) {
        return (String) this.notIn_.get(i);
    }

    public AbstractC2383g getNotInBytes(int i) {
        return AbstractC2383g.N((String) this.notIn_.get(i));
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<String> getNotInList() {
        return this.notIn_;
    }

    public boolean getRequired() {
        return this.required_;
    }

    public boolean hasRequired() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Validate$AnyRules validate$AnyRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$AnyRules);
    }

    public static Validate$AnyRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$AnyRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$AnyRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$AnyRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$AnyRules parseFrom(byte[] bArr) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$AnyRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$AnyRules parseFrom(InputStream inputStream) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$AnyRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$AnyRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$AnyRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$AnyRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
