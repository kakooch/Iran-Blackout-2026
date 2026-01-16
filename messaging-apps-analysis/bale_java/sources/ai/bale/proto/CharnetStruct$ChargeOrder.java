package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PK0;
import ir.nasim.XK0;
import ir.nasim.YK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CharnetStruct$ChargeOrder extends GeneratedMessageLite implements PK0 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 1;
    public static final int AMOUNT_FIELD_NUMBER = 5;
    public static final int DATE_FIELD_NUMBER = 7;
    private static final CharnetStruct$ChargeOrder DEFAULT_INSTANCE;
    public static final int OPERATOR_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 6;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 3;
    private long amount_;
    private int bitField0_;
    private long date_;
    private int operatorCode_;
    private CollectionsStruct$Int32Value targetUserId_;
    private int type_;
    private String accessHash_ = "";
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements PK0 {
        private a() {
            super(CharnetStruct$ChargeOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        CharnetStruct$ChargeOrder charnetStruct$ChargeOrder = new CharnetStruct$ChargeOrder();
        DEFAULT_INSTANCE = charnetStruct$ChargeOrder;
        GeneratedMessageLite.registerDefaultInstance(CharnetStruct$ChargeOrder.class, charnetStruct$ChargeOrder);
    }

    private CharnetStruct$ChargeOrder() {
    }

    private void clearAccessHash() {
        this.accessHash_ = getDefaultInstance().getAccessHash();
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearOperatorCode() {
        this.operatorCode_ = 0;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static CharnetStruct$ChargeOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.targetUserId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.targetUserId_ = collectionsStruct$Int32Value;
        } else {
            this.targetUserId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.targetUserId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CharnetStruct$ChargeOrder parseDelimitedFrom(InputStream inputStream) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$ChargeOrder parseFrom(ByteBuffer byteBuffer) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(String str) {
        str.getClass();
        this.accessHash_ = str;
    }

    private void setAccessHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accessHash_ = abstractC2383g.f0();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setOperatorCode(XK0 xk0) {
        this.operatorCode_ = xk0.getNumber();
    }

    private void setOperatorCodeValue(int i) {
        this.operatorCode_ = i;
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    private void setTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.targetUserId_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 1;
    }

    private void setType(YK0 yk0) {
        this.type_ = yk0.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A.a[gVar.ordinal()]) {
            case 1:
                return new CharnetStruct$ChargeOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\f\u0005\u0002\u0006Ȉ\u0007\u0002\bဉ\u0000", new Object[]{"bitField0_", "accessHash_", "operatorCode_", "type_", "amount_", "phoneNumber_", "date_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CharnetStruct$ChargeOrder.class) {
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

    public String getAccessHash() {
        return this.accessHash_;
    }

    public AbstractC2383g getAccessHashBytes() {
        return AbstractC2383g.N(this.accessHash_);
    }

    public long getAmount() {
        return this.amount_;
    }

    public long getDate() {
        return this.date_;
    }

    public XK0 getOperatorCode() {
        XK0 xk0J = XK0.j(this.operatorCode_);
        return xk0J == null ? XK0.UNRECOGNIZED : xk0J;
    }

    public int getOperatorCodeValue() {
        return this.operatorCode_;
    }

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public CollectionsStruct$Int32Value getTargetUserId() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.targetUserId_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public YK0 getType() {
        YK0 yk0J = YK0.j(this.type_);
        return yk0J == null ? YK0.UNRECOGNIZED : yk0J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(CharnetStruct$ChargeOrder charnetStruct$ChargeOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnetStruct$ChargeOrder);
    }

    public static CharnetStruct$ChargeOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$ChargeOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CharnetStruct$ChargeOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CharnetStruct$ChargeOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CharnetStruct$ChargeOrder parseFrom(byte[] bArr) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CharnetStruct$ChargeOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CharnetStruct$ChargeOrder parseFrom(InputStream inputStream) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$ChargeOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$ChargeOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CharnetStruct$ChargeOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CharnetStruct$ChargeOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
