package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.QN7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class Validate$StringRules extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 21;
    public static final int CONST_FIELD_NUMBER = 1;
    public static final int CONTAINS_FIELD_NUMBER = 9;
    private static final Validate$StringRules DEFAULT_INSTANCE;
    public static final int EMAIL_FIELD_NUMBER = 12;
    public static final int HOSTNAME_FIELD_NUMBER = 13;
    public static final int IGNORE_EMPTY_FIELD_NUMBER = 26;
    public static final int IN_FIELD_NUMBER = 10;
    public static final int IPV4_FIELD_NUMBER = 15;
    public static final int IPV6_FIELD_NUMBER = 16;
    public static final int IP_FIELD_NUMBER = 14;
    public static final int LEN_BYTES_FIELD_NUMBER = 20;
    public static final int LEN_FIELD_NUMBER = 19;
    public static final int MAX_BYTES_FIELD_NUMBER = 5;
    public static final int MAX_LEN_FIELD_NUMBER = 3;
    public static final int MIN_BYTES_FIELD_NUMBER = 4;
    public static final int MIN_LEN_FIELD_NUMBER = 2;
    public static final int NOT_CONTAINS_FIELD_NUMBER = 23;
    public static final int NOT_IN_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PATTERN_FIELD_NUMBER = 6;
    public static final int PREFIX_FIELD_NUMBER = 7;
    public static final int STRICT_FIELD_NUMBER = 25;
    public static final int SUFFIX_FIELD_NUMBER = 8;
    public static final int URI_FIELD_NUMBER = 17;
    public static final int URI_REF_FIELD_NUMBER = 18;
    public static final int UUID_FIELD_NUMBER = 22;
    public static final int WELL_KNOWN_REGEX_FIELD_NUMBER = 24;
    private int bitField0_;
    private boolean ignoreEmpty_;
    private long lenBytes_;
    private long len_;
    private long maxBytes_;
    private long maxLen_;
    private long minBytes_;
    private long minLen_;
    private Object wellKnown_;
    private int wellKnownCase_ = 0;
    private String const_ = "";
    private String pattern_ = "";
    private String prefix_ = "";
    private String suffix_ = "";
    private String contains_ = "";
    private String notContains_ = "";
    private B.j in_ = GeneratedMessageLite.emptyProtobufList();
    private B.j notIn_ = GeneratedMessageLite.emptyProtobufList();
    private boolean strict_ = true;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$StringRules.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        EMAIL(12),
        HOSTNAME(13),
        IP(14),
        IPV4(15),
        IPV6(16),
        URI(17),
        URI_REF(18),
        ADDRESS(21),
        UUID(22),
        WELL_KNOWN_REGEX(24),
        WELLKNOWN_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return WELLKNOWN_NOT_SET;
            }
            if (i == 24) {
                return WELL_KNOWN_REGEX;
            }
            if (i == 21) {
                return ADDRESS;
            }
            if (i == 22) {
                return UUID;
            }
            switch (i) {
                case 12:
                    return EMAIL;
                case 13:
                    return HOSTNAME;
                case 14:
                    return IP;
                case 15:
                    return IPV4;
                case 16:
                    return IPV6;
                case 17:
                    return URI;
                case 18:
                    return URI_REF;
                default:
                    return null;
            }
        }
    }

    static {
        Validate$StringRules validate$StringRules = new Validate$StringRules();
        DEFAULT_INSTANCE = validate$StringRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$StringRules.class, validate$StringRules);
    }

    private Validate$StringRules() {
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

    private void clearAddress() {
        if (this.wellKnownCase_ == 21) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearConst() {
        this.bitField0_ &= -2;
        this.const_ = getDefaultInstance().getConst();
    }

    private void clearContains() {
        this.bitField0_ &= -1025;
        this.contains_ = getDefaultInstance().getContains();
    }

    private void clearEmail() {
        if (this.wellKnownCase_ == 12) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearHostname() {
        if (this.wellKnownCase_ == 13) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearIgnoreEmpty() {
        this.bitField0_ &= -8193;
        this.ignoreEmpty_ = false;
    }

    private void clearIn() {
        this.in_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIp() {
        if (this.wellKnownCase_ == 14) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearIpv4() {
        if (this.wellKnownCase_ == 15) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearIpv6() {
        if (this.wellKnownCase_ == 16) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearLen() {
        this.bitField0_ &= -3;
        this.len_ = 0L;
    }

    private void clearLenBytes() {
        this.bitField0_ &= -17;
        this.lenBytes_ = 0L;
    }

    private void clearMaxBytes() {
        this.bitField0_ &= -65;
        this.maxBytes_ = 0L;
    }

    private void clearMaxLen() {
        this.bitField0_ &= -9;
        this.maxLen_ = 0L;
    }

    private void clearMinBytes() {
        this.bitField0_ &= -33;
        this.minBytes_ = 0L;
    }

    private void clearMinLen() {
        this.bitField0_ &= -5;
        this.minLen_ = 0L;
    }

    private void clearNotContains() {
        this.bitField0_ &= -2049;
        this.notContains_ = getDefaultInstance().getNotContains();
    }

    private void clearNotIn() {
        this.notIn_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPattern() {
        this.bitField0_ &= -129;
        this.pattern_ = getDefaultInstance().getPattern();
    }

    private void clearPrefix() {
        this.bitField0_ &= -257;
        this.prefix_ = getDefaultInstance().getPrefix();
    }

    private void clearStrict() {
        this.bitField0_ &= -4097;
        this.strict_ = true;
    }

    private void clearSuffix() {
        this.bitField0_ &= -513;
        this.suffix_ = getDefaultInstance().getSuffix();
    }

    private void clearUri() {
        if (this.wellKnownCase_ == 17) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearUriRef() {
        if (this.wellKnownCase_ == 18) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearUuid() {
        if (this.wellKnownCase_ == 22) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
    }

    private void clearWellKnown() {
        this.wellKnownCase_ = 0;
        this.wellKnown_ = null;
    }

    private void clearWellKnownRegex() {
        if (this.wellKnownCase_ == 24) {
            this.wellKnownCase_ = 0;
            this.wellKnown_ = null;
        }
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

    public static Validate$StringRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$StringRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$StringRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$StringRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(boolean z) {
        this.wellKnownCase_ = 21;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setConst(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.const_ = str;
    }

    private void setConstBytes(AbstractC2383g abstractC2383g) {
        this.const_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    private void setContains(String str) {
        str.getClass();
        this.bitField0_ |= 1024;
        this.contains_ = str;
    }

    private void setContainsBytes(AbstractC2383g abstractC2383g) {
        this.contains_ = abstractC2383g.f0();
        this.bitField0_ |= 1024;
    }

    private void setEmail(boolean z) {
        this.wellKnownCase_ = 12;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setHostname(boolean z) {
        this.wellKnownCase_ = 13;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setIgnoreEmpty(boolean z) {
        this.bitField0_ |= 8192;
        this.ignoreEmpty_ = z;
    }

    private void setIn(int i, String str) {
        str.getClass();
        ensureInIsMutable();
        this.in_.set(i, str);
    }

    private void setIp(boolean z) {
        this.wellKnownCase_ = 14;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setIpv4(boolean z) {
        this.wellKnownCase_ = 15;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setIpv6(boolean z) {
        this.wellKnownCase_ = 16;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setLen(long j) {
        this.bitField0_ |= 2;
        this.len_ = j;
    }

    private void setLenBytes(long j) {
        this.bitField0_ |= 16;
        this.lenBytes_ = j;
    }

    private void setMaxBytes(long j) {
        this.bitField0_ |= 64;
        this.maxBytes_ = j;
    }

    private void setMaxLen(long j) {
        this.bitField0_ |= 8;
        this.maxLen_ = j;
    }

    private void setMinBytes(long j) {
        this.bitField0_ |= 32;
        this.minBytes_ = j;
    }

    private void setMinLen(long j) {
        this.bitField0_ |= 4;
        this.minLen_ = j;
    }

    private void setNotContains(String str) {
        str.getClass();
        this.bitField0_ |= 2048;
        this.notContains_ = str;
    }

    private void setNotContainsBytes(AbstractC2383g abstractC2383g) {
        this.notContains_ = abstractC2383g.f0();
        this.bitField0_ |= 2048;
    }

    private void setNotIn(int i, String str) {
        str.getClass();
        ensureNotInIsMutable();
        this.notIn_.set(i, str);
    }

    private void setPattern(String str) {
        str.getClass();
        this.bitField0_ |= 128;
        this.pattern_ = str;
    }

    private void setPatternBytes(AbstractC2383g abstractC2383g) {
        this.pattern_ = abstractC2383g.f0();
        this.bitField0_ |= 128;
    }

    private void setPrefix(String str) {
        str.getClass();
        this.bitField0_ |= 256;
        this.prefix_ = str;
    }

    private void setPrefixBytes(AbstractC2383g abstractC2383g) {
        this.prefix_ = abstractC2383g.f0();
        this.bitField0_ |= 256;
    }

    private void setStrict(boolean z) {
        this.bitField0_ |= 4096;
        this.strict_ = z;
    }

    private void setSuffix(String str) {
        str.getClass();
        this.bitField0_ |= 512;
        this.suffix_ = str;
    }

    private void setSuffixBytes(AbstractC2383g abstractC2383g) {
        this.suffix_ = abstractC2383g.f0();
        this.bitField0_ |= 512;
    }

    private void setUri(boolean z) {
        this.wellKnownCase_ = 17;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setUriRef(boolean z) {
        this.wellKnownCase_ = 18;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setUuid(boolean z) {
        this.wellKnownCase_ = 22;
        this.wellKnown_ = Boolean.valueOf(z);
    }

    private void setWellKnownRegex(QN7 qn7) {
        this.wellKnown_ = Integer.valueOf(qn7.getNumber());
        this.wellKnownCase_ = 24;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$StringRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u001a\u0001\u0001\u0001\u001a\u001a\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဃ\u0002\u0003ဃ\u0003\u0004ဃ\u0005\u0005ဃ\u0006\u0006ဈ\u0007\u0007ဈ\b\bဈ\t\tဈ\n\n\u001a\u000b\u001a\f:\u0000\r:\u0000\u000e:\u0000\u000f:\u0000\u0010:\u0000\u0011:\u0000\u0012:\u0000\u0013ဃ\u0001\u0014ဃ\u0004\u0015:\u0000\u0016:\u0000\u0017ဈ\u000b\u0018\u083f\u0000\u0019ဇ\f\u001aဇ\r", new Object[]{"wellKnown_", "wellKnownCase_", "bitField0_", "const_", "minLen_", "maxLen_", "minBytes_", "maxBytes_", "pattern_", "prefix_", "suffix_", "contains_", "in_", "notIn_", "len_", "lenBytes_", "notContains_", QN7.p(), "strict_", "ignoreEmpty_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$StringRules.class) {
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

    public boolean getAddress() {
        if (this.wellKnownCase_ == 21) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public String getConst() {
        return this.const_;
    }

    public AbstractC2383g getConstBytes() {
        return AbstractC2383g.N(this.const_);
    }

    public String getContains() {
        return this.contains_;
    }

    public AbstractC2383g getContainsBytes() {
        return AbstractC2383g.N(this.contains_);
    }

    public boolean getEmail() {
        if (this.wellKnownCase_ == 12) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getHostname() {
        if (this.wellKnownCase_ == 13) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getIgnoreEmpty() {
        return this.ignoreEmpty_;
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

    public boolean getIp() {
        if (this.wellKnownCase_ == 14) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getIpv4() {
        if (this.wellKnownCase_ == 15) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getIpv6() {
        if (this.wellKnownCase_ == 16) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public long getLen() {
        return this.len_;
    }

    public long getLenBytes() {
        return this.lenBytes_;
    }

    public long getMaxBytes() {
        return this.maxBytes_;
    }

    public long getMaxLen() {
        return this.maxLen_;
    }

    public long getMinBytes() {
        return this.minBytes_;
    }

    public long getMinLen() {
        return this.minLen_;
    }

    public String getNotContains() {
        return this.notContains_;
    }

    public AbstractC2383g getNotContainsBytes() {
        return AbstractC2383g.N(this.notContains_);
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

    public String getPattern() {
        return this.pattern_;
    }

    public AbstractC2383g getPatternBytes() {
        return AbstractC2383g.N(this.pattern_);
    }

    public String getPrefix() {
        return this.prefix_;
    }

    public AbstractC2383g getPrefixBytes() {
        return AbstractC2383g.N(this.prefix_);
    }

    public boolean getStrict() {
        return this.strict_;
    }

    public String getSuffix() {
        return this.suffix_;
    }

    public AbstractC2383g getSuffixBytes() {
        return AbstractC2383g.N(this.suffix_);
    }

    public boolean getUri() {
        if (this.wellKnownCase_ == 17) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getUriRef() {
        if (this.wellKnownCase_ == 18) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public boolean getUuid() {
        if (this.wellKnownCase_ == 22) {
            return ((Boolean) this.wellKnown_).booleanValue();
        }
        return false;
    }

    public b getWellKnownCase() {
        return b.j(this.wellKnownCase_);
    }

    public QN7 getWellKnownRegex() {
        if (this.wellKnownCase_ != 24) {
            return QN7.UNKNOWN;
        }
        QN7 qn7J = QN7.j(((Integer) this.wellKnown_).intValue());
        return qn7J == null ? QN7.UNKNOWN : qn7J;
    }

    public boolean hasAddress() {
        return this.wellKnownCase_ == 21;
    }

    public boolean hasConst() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasContains() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasEmail() {
        return this.wellKnownCase_ == 12;
    }

    public boolean hasHostname() {
        return this.wellKnownCase_ == 13;
    }

    public boolean hasIgnoreEmpty() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasIp() {
        return this.wellKnownCase_ == 14;
    }

    public boolean hasIpv4() {
        return this.wellKnownCase_ == 15;
    }

    public boolean hasIpv6() {
        return this.wellKnownCase_ == 16;
    }

    public boolean hasLen() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLenBytes() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasMaxBytes() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasMaxLen() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMinBytes() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasMinLen() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasNotContains() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasPattern() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasPrefix() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasStrict() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasSuffix() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasUri() {
        return this.wellKnownCase_ == 17;
    }

    public boolean hasUriRef() {
        return this.wellKnownCase_ == 18;
    }

    public boolean hasUuid() {
        return this.wellKnownCase_ == 22;
    }

    public boolean hasWellKnownRegex() {
        return this.wellKnownCase_ == 24;
    }

    public static a newBuilder(Validate$StringRules validate$StringRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$StringRules);
    }

    public static Validate$StringRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$StringRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$StringRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$StringRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$StringRules parseFrom(byte[] bArr) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$StringRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$StringRules parseFrom(InputStream inputStream) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$StringRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$StringRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$StringRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$StringRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
