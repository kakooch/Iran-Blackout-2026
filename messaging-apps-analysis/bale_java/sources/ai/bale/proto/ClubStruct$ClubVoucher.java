package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC21349tW0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ClubStruct$ClubVoucher extends GeneratedMessageLite implements InterfaceC21349tW0 {
    public static final int CODE_FIELD_NUMBER = 6;
    public static final int COMPANY_FIELD_NUMBER = 3;
    public static final int COST_FIELD_NUMBER = 2;
    private static final ClubStruct$ClubVoucher DEFAULT_INSTANCE;
    public static final int DESC_FIELD_NUMBER = 4;
    public static final int EXPIRE_DATE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int VOUCHER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue code_;
    private long cost_;
    private long expireDate_;
    private String voucherId_ = "";
    private String company_ = "";
    private String desc_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21349tW0 {
        private a() {
            super(ClubStruct$ClubVoucher.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubStruct$ClubVoucher clubStruct$ClubVoucher = new ClubStruct$ClubVoucher();
        DEFAULT_INSTANCE = clubStruct$ClubVoucher;
        GeneratedMessageLite.registerDefaultInstance(ClubStruct$ClubVoucher.class, clubStruct$ClubVoucher);
    }

    private ClubStruct$ClubVoucher() {
    }

    private void clearCode() {
        this.code_ = null;
        this.bitField0_ &= -2;
    }

    private void clearCompany() {
        this.company_ = getDefaultInstance().getCompany();
    }

    private void clearCost() {
        this.cost_ = 0L;
    }

    private void clearDesc() {
        this.desc_ = getDefaultInstance().getDesc();
    }

    private void clearExpireDate() {
        this.expireDate_ = 0L;
    }

    private void clearVoucherId() {
        this.voucherId_ = getDefaultInstance().getVoucherId();
    }

    public static ClubStruct$ClubVoucher getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.code_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.code_ = stringValue;
        } else {
            this.code_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.code_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubStruct$ClubVoucher parseDelimitedFrom(InputStream inputStream) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubStruct$ClubVoucher parseFrom(ByteBuffer byteBuffer) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(StringValue stringValue) {
        stringValue.getClass();
        this.code_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setCompany(String str) {
        str.getClass();
        this.company_ = str;
    }

    private void setCompanyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.company_ = abstractC2383g.f0();
    }

    private void setCost(long j) {
        this.cost_ = j;
    }

    private void setDesc(String str) {
        str.getClass();
        this.desc_ = str;
    }

    private void setDescBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.desc_ = abstractC2383g.f0();
    }

    private void setExpireDate(long j) {
        this.expireDate_ = j;
    }

    private void setVoucherId(String str) {
        str.getClass();
        this.voucherId_ = str;
    }

    private void setVoucherIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.voucherId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C.a[gVar.ordinal()]) {
            case 1:
                return new ClubStruct$ClubVoucher();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005\u0002\u0006ဉ\u0000", new Object[]{"bitField0_", "voucherId_", "cost_", "company_", "desc_", "expireDate_", "code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubStruct$ClubVoucher.class) {
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

    public StringValue getCode() {
        StringValue stringValue = this.code_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getCompany() {
        return this.company_;
    }

    public AbstractC2383g getCompanyBytes() {
        return AbstractC2383g.N(this.company_);
    }

    public long getCost() {
        return this.cost_;
    }

    public String getDesc() {
        return this.desc_;
    }

    public AbstractC2383g getDescBytes() {
        return AbstractC2383g.N(this.desc_);
    }

    public long getExpireDate() {
        return this.expireDate_;
    }

    public String getVoucherId() {
        return this.voucherId_;
    }

    public AbstractC2383g getVoucherIdBytes() {
        return AbstractC2383g.N(this.voucherId_);
    }

    public boolean hasCode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ClubStruct$ClubVoucher clubStruct$ClubVoucher) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubStruct$ClubVoucher);
    }

    public static ClubStruct$ClubVoucher parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubStruct$ClubVoucher parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubStruct$ClubVoucher parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubStruct$ClubVoucher parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubStruct$ClubVoucher parseFrom(byte[] bArr) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubStruct$ClubVoucher parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubStruct$ClubVoucher parseFrom(InputStream inputStream) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubStruct$ClubVoucher parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubStruct$ClubVoucher parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubStruct$ClubVoucher parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubStruct$ClubVoucher) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
