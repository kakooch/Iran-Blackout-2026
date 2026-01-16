package ai.bale.proto;

import ai.bale.proto.PassportStruct$PassportDate;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportFieldDate extends GeneratedMessageLite implements U64 {
    private static final PassportStruct$PassportFieldDate DEFAULT_INSTANCE;
    public static final int IS_GREGORIAN_FIELD_NUMBER = 2;
    public static final int MAX_DATE_FIELD_NUMBER = 4;
    public static final int MIN_DATE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isGregorian_;
    private PassportStruct$PassportDate maxDate_;
    private PassportStruct$PassportDate minDate_;
    private PassportStruct$PassportDate value_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportStruct$PassportFieldDate.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportFieldDate passportStruct$PassportFieldDate = new PassportStruct$PassportFieldDate();
        DEFAULT_INSTANCE = passportStruct$PassportFieldDate;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportFieldDate.class, passportStruct$PassportFieldDate);
    }

    private PassportStruct$PassportFieldDate() {
    }

    private void clearIsGregorian() {
        this.isGregorian_ = false;
    }

    private void clearMaxDate() {
        this.maxDate_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMinDate() {
        this.minDate_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static PassportStruct$PassportFieldDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMaxDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        PassportStruct$PassportDate passportStruct$PassportDate2 = this.maxDate_;
        if (passportStruct$PassportDate2 == null || passportStruct$PassportDate2 == PassportStruct$PassportDate.getDefaultInstance()) {
            this.maxDate_ = passportStruct$PassportDate;
        } else {
            this.maxDate_ = (PassportStruct$PassportDate) ((PassportStruct$PassportDate.a) PassportStruct$PassportDate.newBuilder(this.maxDate_).v(passportStruct$PassportDate)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMinDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        PassportStruct$PassportDate passportStruct$PassportDate2 = this.minDate_;
        if (passportStruct$PassportDate2 == null || passportStruct$PassportDate2 == PassportStruct$PassportDate.getDefaultInstance()) {
            this.minDate_ = passportStruct$PassportDate;
        } else {
            this.minDate_ = (PassportStruct$PassportDate) ((PassportStruct$PassportDate.a) PassportStruct$PassportDate.newBuilder(this.minDate_).v(passportStruct$PassportDate)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeValue(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        PassportStruct$PassportDate passportStruct$PassportDate2 = this.value_;
        if (passportStruct$PassportDate2 == null || passportStruct$PassportDate2 == PassportStruct$PassportDate.getDefaultInstance()) {
            this.value_ = passportStruct$PassportDate;
        } else {
            this.value_ = (PassportStruct$PassportDate) ((PassportStruct$PassportDate.a) PassportStruct$PassportDate.newBuilder(this.value_).v(passportStruct$PassportDate)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportFieldDate parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldDate parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsGregorian(boolean z) {
        this.isGregorian_ = z;
    }

    private void setMaxDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        this.maxDate_ = passportStruct$PassportDate;
        this.bitField0_ |= 4;
    }

    private void setMinDate(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        this.minDate_ = passportStruct$PassportDate;
        this.bitField0_ |= 2;
    }

    private void setValue(PassportStruct$PassportDate passportStruct$PassportDate) {
        passportStruct$PassportDate.getClass();
        this.value_ = passportStruct$PassportDate;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportFieldDate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "value_", "isGregorian_", "minDate_", "maxDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportFieldDate.class) {
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

    public boolean getIsGregorian() {
        return this.isGregorian_;
    }

    public PassportStruct$PassportDate getMaxDate() {
        PassportStruct$PassportDate passportStruct$PassportDate = this.maxDate_;
        return passportStruct$PassportDate == null ? PassportStruct$PassportDate.getDefaultInstance() : passportStruct$PassportDate;
    }

    public PassportStruct$PassportDate getMinDate() {
        PassportStruct$PassportDate passportStruct$PassportDate = this.minDate_;
        return passportStruct$PassportDate == null ? PassportStruct$PassportDate.getDefaultInstance() : passportStruct$PassportDate;
    }

    public PassportStruct$PassportDate getValue() {
        PassportStruct$PassportDate passportStruct$PassportDate = this.value_;
        return passportStruct$PassportDate == null ? PassportStruct$PassportDate.getDefaultInstance() : passportStruct$PassportDate;
    }

    public boolean hasMaxDate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMinDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PassportStruct$PassportFieldDate passportStruct$PassportFieldDate) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportFieldDate);
    }

    public static PassportStruct$PassportFieldDate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldDate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportFieldDate parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PassportStruct$PassportFieldDate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportFieldDate parseFrom(byte[] bArr) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportFieldDate parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportFieldDate parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportFieldDate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportFieldDate parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportFieldDate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportFieldDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
