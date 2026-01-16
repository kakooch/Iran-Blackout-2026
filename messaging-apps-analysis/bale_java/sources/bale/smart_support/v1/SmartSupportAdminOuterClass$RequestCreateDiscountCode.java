package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC14231ha3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportAdminOuterClass$RequestCreateDiscountCode extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final SmartSupportAdminOuterClass$RequestCreateDiscountCode DEFAULT_INSTANCE;
    public static final int DISCOUNT_AMOUNT_FIELD_NUMBER = 3;
    public static final int DISCOUNT_PERCENTAGE_FIELD_NUMBER = 2;
    public static final int EXPIRE_TIME_FIELD_NUMBER = 5;
    public static final int MAX_DISCOUNT_AMOUNT_FIELD_NUMBER = 4;
    public static final int MIN_ORDER_AMOUNT_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int USERS_COUNT_LIMIT_FIELD_NUMBER = 7;
    public static final int USERS_LIST_FIELD_NUMBER = 8;
    private int bitField0_;
    private StringValue code_;
    private Int64Value discountAmount_;
    private Int64Value discountPercentage_;
    private long expireTime_;
    private Int64Value maxDiscountAmount_;
    private Int64Value minOrderAmount_;
    private Int64Value usersCountLimit_;
    private B.j usersList_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportAdminOuterClass$RequestCreateDiscountCode.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportAdminOuterClass$RequestCreateDiscountCode smartSupportAdminOuterClass$RequestCreateDiscountCode = new SmartSupportAdminOuterClass$RequestCreateDiscountCode();
        DEFAULT_INSTANCE = smartSupportAdminOuterClass$RequestCreateDiscountCode;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportAdminOuterClass$RequestCreateDiscountCode.class, smartSupportAdminOuterClass$RequestCreateDiscountCode);
    }

    private SmartSupportAdminOuterClass$RequestCreateDiscountCode() {
    }

    private void addAllUsersList(Iterable<? extends Int64Value> iterable) {
        ensureUsersListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersList_);
    }

    private void addUsersList(Int64Value int64Value) {
        int64Value.getClass();
        ensureUsersListIsMutable();
        this.usersList_.add(int64Value);
    }

    private void clearCode() {
        this.code_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDiscountAmount() {
        this.discountAmount_ = null;
        this.bitField0_ &= -5;
    }

    private void clearDiscountPercentage() {
        this.discountPercentage_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExpireTime() {
        this.expireTime_ = 0L;
    }

    private void clearMaxDiscountAmount() {
        this.maxDiscountAmount_ = null;
        this.bitField0_ &= -9;
    }

    private void clearMinOrderAmount() {
        this.minOrderAmount_ = null;
        this.bitField0_ &= -33;
    }

    private void clearUsersCountLimit() {
        this.usersCountLimit_ = null;
        this.bitField0_ &= -17;
    }

    private void clearUsersList() {
        this.usersList_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersListIsMutable() {
        B.j jVar = this.usersList_;
        if (jVar.u()) {
            return;
        }
        this.usersList_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode getDefaultInstance() {
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

    private void mergeDiscountAmount(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.discountAmount_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.discountAmount_ = int64Value;
        } else {
            this.discountAmount_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.discountAmount_).v(int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeDiscountPercentage(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.discountPercentage_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.discountPercentage_ = int64Value;
        } else {
            this.discountPercentage_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.discountPercentage_).v(int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMaxDiscountAmount(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.maxDiscountAmount_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.maxDiscountAmount_ = int64Value;
        } else {
            this.maxDiscountAmount_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.maxDiscountAmount_).v(int64Value)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeMinOrderAmount(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.minOrderAmount_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.minOrderAmount_ = int64Value;
        } else {
            this.minOrderAmount_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.minOrderAmount_).v(int64Value)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeUsersCountLimit(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.usersCountLimit_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.usersCountLimit_ = int64Value;
        } else {
            this.usersCountLimit_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.usersCountLimit_).v(int64Value)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsersList(int i) {
        ensureUsersListIsMutable();
        this.usersList_.remove(i);
    }

    private void setCode(StringValue stringValue) {
        stringValue.getClass();
        this.code_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDiscountAmount(Int64Value int64Value) {
        int64Value.getClass();
        this.discountAmount_ = int64Value;
        this.bitField0_ |= 4;
    }

    private void setDiscountPercentage(Int64Value int64Value) {
        int64Value.getClass();
        this.discountPercentage_ = int64Value;
        this.bitField0_ |= 2;
    }

    private void setExpireTime(long j) {
        this.expireTime_ = j;
    }

    private void setMaxDiscountAmount(Int64Value int64Value) {
        int64Value.getClass();
        this.maxDiscountAmount_ = int64Value;
        this.bitField0_ |= 8;
    }

    private void setMinOrderAmount(Int64Value int64Value) {
        int64Value.getClass();
        this.minOrderAmount_ = int64Value;
        this.bitField0_ |= 32;
    }

    private void setUsersCountLimit(Int64Value int64Value) {
        int64Value.getClass();
        this.usersCountLimit_ = int64Value;
        this.bitField0_ |= 16;
    }

    private void setUsersList(int i, Int64Value int64Value) {
        int64Value.getClass();
        ensureUsersListIsMutable();
        this.usersList_.set(i, int64Value);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.smart_support.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportAdminOuterClass$RequestCreateDiscountCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\t\b\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u0002\u0007ဉ\u0004\b\u001b\tဉ\u0005", new Object[]{"bitField0_", "code_", "discountPercentage_", "discountAmount_", "maxDiscountAmount_", "expireTime_", "usersCountLimit_", "usersList_", Int64Value.class, "minOrderAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportAdminOuterClass$RequestCreateDiscountCode.class) {
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

    public Int64Value getDiscountAmount() {
        Int64Value int64Value = this.discountAmount_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getDiscountPercentage() {
        Int64Value int64Value = this.discountPercentage_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public long getExpireTime() {
        return this.expireTime_;
    }

    public Int64Value getMaxDiscountAmount() {
        Int64Value int64Value = this.maxDiscountAmount_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getMinOrderAmount() {
        Int64Value int64Value = this.minOrderAmount_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getUsersCountLimit() {
        Int64Value int64Value = this.usersCountLimit_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getUsersList(int i) {
        return (Int64Value) this.usersList_.get(i);
    }

    public int getUsersListCount() {
        return this.usersList_.size();
    }

    public List<Int64Value> getUsersListList() {
        return this.usersList_;
    }

    public InterfaceC14231ha3 getUsersListOrBuilder(int i) {
        return (InterfaceC14231ha3) this.usersList_.get(i);
    }

    public List<? extends InterfaceC14231ha3> getUsersListOrBuilderList() {
        return this.usersList_;
    }

    public boolean hasCode() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDiscountAmount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDiscountPercentage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMaxDiscountAmount() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMinOrderAmount() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasUsersCountLimit() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(SmartSupportAdminOuterClass$RequestCreateDiscountCode smartSupportAdminOuterClass$RequestCreateDiscountCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportAdminOuterClass$RequestCreateDiscountCode);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsersList(int i, Int64Value int64Value) {
        int64Value.getClass();
        ensureUsersListIsMutable();
        this.usersList_.add(i, int64Value);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(byte[] bArr) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportAdminOuterClass$RequestCreateDiscountCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestCreateDiscountCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
