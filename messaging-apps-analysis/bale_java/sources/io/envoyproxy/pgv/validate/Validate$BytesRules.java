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
public final class Validate$BytesRules extends GeneratedMessageLite implements U64 {
    public static final int CONST_FIELD_NUMBER = 1;
    public static final int CONTAINS_FIELD_NUMBER = 7;
    private static final Validate$BytesRules DEFAULT_INSTANCE;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 14;
    public static final int IN_FIELD_NUMBER = 8;
    public static final int IPV4_FIELD_NUMBER = 11;
    public static final int IPV6_FIELD_NUMBER = 12;
    public static final int IP_FIELD_NUMBER = 10;
    public static final int LEN_FIELD_NUMBER = 13;
    public static final int MAX_LEN_FIELD_NUMBER = 3;
    public static final int MIN_LEN_FIELD_NUMBER = 2;
    public static final int NOT_IN_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PATTERN_FIELD_NUMBER = 4;
    public static final int PREFIX_FIELD_NUMBER = 5;
    public static final int SUFFIX_FIELD_NUMBER = 6;
    private int bitField0_;
    private AbstractC2383g const_;
    private AbstractC2383g contains_;
    private boolean ignoreEmpty_;
    private B.j in_;
    private long len_;
    private long maxLen_;
    private long minLen_;
    private B.j notIn_;
    private String pattern_;
    private AbstractC2383g prefix_;
    private AbstractC2383g suffix_;
    private int wellKnownCase_ = 0;
    private Object wellKnown_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$BytesRules.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        IP(10),
        IPV4(11),
        IPV6(12),
        WELLKNOWN_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return WELLKNOWN_NOT_SET;
            }
            switch (i) {
                case 10:
                    return IP;
                case 11:
                    return IPV4;
                case 12:
                    return IPV6;
                default:
                    return null;
            }
        }
    }

    static {
        Validate$BytesRules validate$BytesRules = new Validate$BytesRules();
        DEFAULT_INSTANCE = validate$BytesRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$BytesRules.class, validate$BytesRules);
    }

    private Validate$BytesRules() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.const_ = abstractC2383g;
        this.pattern_ = "";
        this.prefix_ = abstractC2383g;
        this.suffix_ = abstractC2383g;
        this.contains_ = abstractC2383g;
        this.in_ = GeneratedMessageLite.emptyProtobufList();
        this.notIn_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void addAllIn(Iterable<? extends AbstractC2383g> iterable) {
        ensureInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.in_);
    }

    private void addAllNotIn(Iterable<? extends AbstractC2383g> iterable) {
        ensureNotInIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notIn_);
    }

    private void addIn(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureInIsMutable();
        this.in_.add(abstractC2383g);
    }

    private void addNotIn(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureNotInIsMutable();
        this.notIn_.add(abstractC2383g);
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = getDefaultInstance().getConst();
    }

    private void clearContains() {
        this.bitField0_ &= -129;
        this.contains_ = getDefaultInstance().getContains();
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -257;
        this.ignoreEmpty_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIp() {
        if (this.wellKnownCase_ == 10) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearIpv4() {
        if (this.wellKnownCase_ == 11) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearIpv6() {
        if (this.wellKnownCase_ == 12) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearLen() {
        this.bitField0_ &= -3;
        this.len_ = 0L;
    }

    private void clearMaxLen() {
        this.bitField0_ &= -9;
        this.maxLen_ = 0L;
    }

    private void clearMinLen() {
        this.bitField0_ &= -5;
        this.minLen_ = 0L;
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPattern() {
        this.bitField0_ &= -17;
        this.pattern_ = getDefaultInstance().getPattern();
    }

    private void clearPrefix() {
        this.bitField0_ &= -33;
        this.prefix_ = getDefaultInstance().getPrefix();
    }

    private void clearSuffix() {
        this.bitField0_ &= -65;
        this.suffix_ = getDefaultInstance().getSuffix();
    }

    private void clearWellKnown() {
        this.wellKnownCase_ = 0;
        this.wellKnown_ = null;
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

    public static Validate$BytesRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$BytesRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$BytesRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$BytesRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConst(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.bitField0_ |= 1;
        this.const_ = abstractC2383g;
    }

    private void setContains(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.bitField0_ |= 128;
        this.contains_ = abstractC2383g;
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 256;
        this.ignoreEmpty_ = z;
    }

    private void setIn(int i, AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureInIsMutable();
        this.in_.set(i, abstractC2383g);
    }

    private void setIp(boolean z) {
        this.wellKnownCase_ = 10;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setIpv4(boolean z) {
        this.wellKnownCase_ = 11;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setIpv6(boolean z) {
        this.wellKnownCase_ = 12;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setLen(long j) {
        this.bitField0_ |= 2;
        this.len_ = j;
    }

    private void setMaxLen(long j) {
        this.bitField0_ |= 8;
        this.maxLen_ = j;
    }

    private void setMinLen(long j) {
        this.bitField0_ |= 4;
        this.minLen_ = j;
    }

    private void setNotIn(int i, AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        ensureNotInIsMutable();
        this.notIn_.set(i, abstractC2383g);
    }

    private void setPattern(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.pattern_ = str;
    }

    private void setPatternBytes(AbstractC2383g abstractC2383g) {
        this.pattern_ = abstractC2383g.f0();
        this.bitField0_ |= 16;
    }

    private void setPrefix(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.bitField0_ |= 32;
        this.prefix_ = abstractC2383g;
    }

    private void setSuffix(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.bitField0_ |= 64;
        this.suffix_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$BytesRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000e\u0001\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ည\u0000\u0002ဃ\u0002\u0003ဃ\u0003\u0004ဈ\u0004\u0005ည\u0005\u0006ည\u0006\u0007ည\u0007\b\u001c\t\u001c\n:\u0000\u000b:\u0000\f:\u0000\rဃ\u0001\u000eဇ\b", new Object[]{"wellKnown_", "wellKnownCase_", "bitField0_", "const_", "minLen_", "maxLen_", "pattern_", "prefix_", "suffix_", "contains_", "in_", "notIn_", "len_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$BytesRules.class) {
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

    public AbstractC2383g getConst() {
        return this.const_;
    }

    public AbstractC2383g getContains() {
        return this.contains_;
    }

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
    }

    public AbstractC2383g getIn(int i) {
        return (AbstractC2383g) this.in_.get(i);
    }

    public int getInCount() {
        return this.in_.size();
    }

    public List<AbstractC2383g> getInList() {
        return this.in_;
    }

    public boolean getIp() {
        if (this.wellKnownCase_ == 10) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getIpv4() {
        if (this.wellKnownCase_ == 11) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getIpv6() {
        if (this.wellKnownCase_ == 12) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public long getLen() {
        return this.len_;
    }

    public long getMaxLen() {
        return this.maxLen_;
    }

    public long getMinLen() {
        return this.minLen_;
    }

    public AbstractC2383g getNotIn(int i) {
        return (AbstractC2383g) this.notIn_.get(i);
    }

    public int getNotInCount() {
        return this.notIn_.size();
    }

    public List<AbstractC2383g> getNotInList() {
        return this.notIn_;
    }

    public String getPattern() {
        return this.pattern_;
    }

    public AbstractC2383g getPatternBytes() {
        return AbstractC2383g.N(this.pattern_);
    }

    public AbstractC2383g getPrefix() {
        return this.prefix_;
    }

    public AbstractC2383g getSuffix() {
        return this.suffix_;
    }

    public b getWellKnownCase() {
        return b.j(this.wellKnownCase_);
    }

    public boolean hasConst() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasContains() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasIgnoreEmpty() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasIp() {
        return this.wellKnownCase_ == 10;
    }

    public boolean hasIpv4() {
        return this.wellKnownCase_ == 11;
    }

    public boolean hasIpv6() {
        return this.wellKnownCase_ == 12;
    }

    public boolean hasLen() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMaxLen() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMinLen() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPattern() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPrefix() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasSuffix() {
        return (this.bitField0_ & 64) != 0;
    }

    public static a newBuilder(Validate$BytesRules validate$BytesRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$BytesRules);
    }

    public static Validate$BytesRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$BytesRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$BytesRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$BytesRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$BytesRules parseFrom(byte[] bArr) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$BytesRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$BytesRules parseFrom(InputStream inputStream) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$BytesRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$BytesRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$BytesRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$BytesRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
