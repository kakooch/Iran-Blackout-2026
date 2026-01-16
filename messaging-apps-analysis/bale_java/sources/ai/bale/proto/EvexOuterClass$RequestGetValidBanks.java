package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$RequestGetValidBanks extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NATIONAL_CODE_FIELD_NUMBER = 2;
    private static final EvexOuterClass$RequestGetValidBanks DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private StringValue accountNationalCode_;
    private int bitField0_;
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$RequestGetValidBanks.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$RequestGetValidBanks evexOuterClass$RequestGetValidBanks = new EvexOuterClass$RequestGetValidBanks();
        DEFAULT_INSTANCE = evexOuterClass$RequestGetValidBanks;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$RequestGetValidBanks.class, evexOuterClass$RequestGetValidBanks);
    }

    private EvexOuterClass$RequestGetValidBanks() {
    }

    private void clearAccountNationalCode() {
        this.accountNationalCode_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static EvexOuterClass$RequestGetValidBanks getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccountNationalCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.accountNationalCode_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.accountNationalCode_ = stringValue;
        } else {
            this.accountNationalCode_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.accountNationalCode_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$RequestGetValidBanks parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNationalCode(StringValue stringValue) {
        stringValue.getClass();
        this.accountNationalCode_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$RequestGetValidBanks();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "nationalCode_", "accountNationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$RequestGetValidBanks.class) {
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

    public StringValue getAccountNationalCode() {
        StringValue stringValue = this.accountNationalCode_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public boolean hasAccountNationalCode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EvexOuterClass$RequestGetValidBanks evexOuterClass$RequestGetValidBanks) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$RequestGetValidBanks);
    }

    public static EvexOuterClass$RequestGetValidBanks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(byte[] bArr) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$RequestGetValidBanks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$RequestGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
