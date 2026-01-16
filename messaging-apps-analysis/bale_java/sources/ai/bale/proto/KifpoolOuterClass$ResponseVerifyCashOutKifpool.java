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
public final class KifpoolOuterClass$ResponseVerifyCashOutKifpool extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NO_FIELD_NUMBER = 1;
    private static final KifpoolOuterClass$ResponseVerifyCashOutKifpool DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 2;
    public static final int LAST_NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private String accountNo_ = "";
    private int bitField0_;
    private StringValue firstName_;
    private StringValue lastName_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseVerifyCashOutKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseVerifyCashOutKifpool kifpoolOuterClass$ResponseVerifyCashOutKifpool = new KifpoolOuterClass$ResponseVerifyCashOutKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseVerifyCashOutKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseVerifyCashOutKifpool.class, kifpoolOuterClass$ResponseVerifyCashOutKifpool);
    }

    private KifpoolOuterClass$ResponseVerifyCashOutKifpool() {
    }

    private void clearAccountNo() {
        this.accountNo_ = getDefaultInstance().getAccountNo();
    }

    private void clearFirstName() {
        this.firstName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLastName() {
        this.lastName_ = null;
        this.bitField0_ &= -3;
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFirstName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.firstName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.firstName_ = stringValue;
        } else {
            this.firstName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.firstName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLastName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.lastName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.lastName_ = stringValue;
        } else {
            this.lastName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.lastName_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNo(String str) {
        str.getClass();
        this.accountNo_ = str;
    }

    private void setAccountNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountNo_ = abstractC2383g.f0();
    }

    private void setFirstName(StringValue stringValue) {
        stringValue.getClass();
        this.firstName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setLastName(StringValue stringValue) {
        stringValue.getClass();
        this.lastName_ = stringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseVerifyCashOutKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "accountNo_", "firstName_", "lastName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseVerifyCashOutKifpool.class) {
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

    public String getAccountNo() {
        return this.accountNo_;
    }

    public AbstractC2383g getAccountNoBytes() {
        return AbstractC2383g.N(this.accountNo_);
    }

    public StringValue getFirstName() {
        StringValue stringValue = this.firstName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLastName() {
        StringValue stringValue = this.lastName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasFirstName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLastName() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseVerifyCashOutKifpool kifpoolOuterClass$ResponseVerifyCashOutKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseVerifyCashOutKifpool);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseVerifyCashOutKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
