package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC23192wW0;
import ir.nasim.InterfaceC22596vW0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ClubStruct$WheelPrize extends GeneratedMessageLite implements InterfaceC22596vW0 {
    public static final int AMOUNT_FIELD_NUMBER = 5;
    public static final int CODE_FIELD_NUMBER = 4;
    public static final int COMPANY_FIELD_NUMBER = 3;
    private static final ClubStruct$WheelPrize DEFAULT_INSTANCE;
    public static final int DESC_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PRIZE_TYPE_FIELD_NUMBER = 1;
    private CollectionsStruct$Int64Value amount_;
    private int bitField0_;
    private StringValue code_;
    private StringValue company_;
    private String desc_ = "";
    private int prizeType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22596vW0 {
        private a() {
            super(ClubStruct$WheelPrize.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubStruct$WheelPrize clubStruct$WheelPrize = new ClubStruct$WheelPrize();
        DEFAULT_INSTANCE = clubStruct$WheelPrize;
        GeneratedMessageLite.registerDefaultInstance(ClubStruct$WheelPrize.class, clubStruct$WheelPrize);
    }

    private ClubStruct$WheelPrize() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -5;
    }

    private void clearCode() {
        this.code_ = null;
        this.bitField0_ &= -3;
    }

    private void clearCompany() {
        this.company_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDesc() {
        this.desc_ = getDefaultInstance().getDesc();
    }

    private void clearPrizeType() {
        this.prizeType_ = 0;
    }

    public static ClubStruct$WheelPrize getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.amount_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.amount_ = collectionsStruct$Int64Value;
        } else {
            this.amount_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.amount_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.code_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.code_ = stringValue;
        } else {
            this.code_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.code_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeCompany(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.company_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.company_ = stringValue;
        } else {
            this.company_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.company_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubStruct$WheelPrize parseDelimitedFrom(InputStream inputStream) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubStruct$WheelPrize parseFrom(ByteBuffer byteBuffer) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.amount_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setCode(StringValue stringValue) {
        stringValue.getClass();
        this.code_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setCompany(StringValue stringValue) {
        stringValue.getClass();
        this.company_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDesc(String str) {
        str.getClass();
        this.desc_ = str;
    }

    private void setDescBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.desc_ = abstractC2383g.f0();
    }

    private void setPrizeType(EnumC23192wW0 enumC23192wW0) {
        this.prizeType_ = enumC23192wW0.getNumber();
    }

    private void setPrizeTypeValue(int i) {
        this.prizeType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C.a[gVar.ordinal()]) {
            case 1:
                return new ClubStruct$WheelPrize();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005ဉ\u0002", new Object[]{"bitField0_", "prizeType_", "desc_", "company_", "code_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubStruct$WheelPrize.class) {
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

    public CollectionsStruct$Int64Value getAmount() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.amount_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public StringValue getCode() {
        StringValue stringValue = this.code_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getCompany() {
        StringValue stringValue = this.company_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getDesc() {
        return this.desc_;
    }

    public AbstractC2383g getDescBytes() {
        return AbstractC2383g.N(this.desc_);
    }

    public EnumC23192wW0 getPrizeType() {
        EnumC23192wW0 enumC23192wW0J = EnumC23192wW0.j(this.prizeType_);
        return enumC23192wW0J == null ? EnumC23192wW0.UNRECOGNIZED : enumC23192wW0J;
    }

    public int getPrizeTypeValue() {
        return this.prizeType_;
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCode() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasCompany() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ClubStruct$WheelPrize clubStruct$WheelPrize) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubStruct$WheelPrize);
    }

    public static ClubStruct$WheelPrize parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubStruct$WheelPrize parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubStruct$WheelPrize parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubStruct$WheelPrize parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubStruct$WheelPrize parseFrom(byte[] bArr) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubStruct$WheelPrize parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubStruct$WheelPrize parseFrom(InputStream inputStream) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubStruct$WheelPrize parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubStruct$WheelPrize parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubStruct$WheelPrize parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubStruct$WheelPrize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
