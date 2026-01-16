package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11529d96;
import ir.nasim.EnumC13399g96;
import ir.nasim.InterfaceC12763f96;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SabaStruct$Order extends GeneratedMessageLite implements InterfaceC12763f96 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 1;
    public static final int AMOUNT_FIELD_NUMBER = 5;
    public static final int BUNDLE_ID_FIELD_NUMBER = 4;
    public static final int DATE_FIELD_NUMBER = 7;
    private static final SabaStruct$Order DEFAULT_INSTANCE;
    public static final int OPERATOR_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 6;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 3;
    private long amount_;
    private int bitField0_;
    private int bundleId_;
    private long date_;
    private int operatorCode_;
    private CollectionsStruct$Int32Value targetUserId_;
    private int type_;
    private String accessHash_ = "";
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC12763f96 {
        private a() {
            super(SabaStruct$Order.DEFAULT_INSTANCE);
        }
    }

    static {
        SabaStruct$Order sabaStruct$Order = new SabaStruct$Order();
        DEFAULT_INSTANCE = sabaStruct$Order;
        GeneratedMessageLite.registerDefaultInstance(SabaStruct$Order.class, sabaStruct$Order);
    }

    private SabaStruct$Order() {
    }

    private void clearAccessHash() {
        this.accessHash_ = getDefaultInstance().getAccessHash();
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearBundleId() {
        this.bundleId_ = 0;
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

    public static SabaStruct$Order getDefaultInstance() {
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

    public static SabaStruct$Order parseDelimitedFrom(InputStream inputStream) {
        return (SabaStruct$Order) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SabaStruct$Order parseFrom(ByteBuffer byteBuffer) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setBundleId(int i) {
        this.bundleId_ = i;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setOperatorCode(EnumC11529d96 enumC11529d96) {
        this.operatorCode_ = enumC11529d96.getNumber();
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

    private void setType(EnumC13399g96 enumC13399g96) {
        this.type_ = enumC13399g96.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C1.a[gVar.ordinal()]) {
            case 1:
                return new SabaStruct$Order();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\f\u0004\u0004\u0005\u0002\u0006Ȉ\u0007\u0002\bဉ\u0000", new Object[]{"bitField0_", "accessHash_", "operatorCode_", "type_", "bundleId_", "amount_", "phoneNumber_", "date_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SabaStruct$Order.class) {
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

    public int getBundleId() {
        return this.bundleId_;
    }

    public long getDate() {
        return this.date_;
    }

    public EnumC11529d96 getOperatorCode() {
        EnumC11529d96 enumC11529d96J = EnumC11529d96.j(this.operatorCode_);
        return enumC11529d96J == null ? EnumC11529d96.UNRECOGNIZED : enumC11529d96J;
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

    public EnumC13399g96 getType() {
        EnumC13399g96 enumC13399g96J = EnumC13399g96.j(this.type_);
        return enumC13399g96J == null ? EnumC13399g96.UNRECOGNIZED : enumC13399g96J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SabaStruct$Order sabaStruct$Order) {
        return (a) DEFAULT_INSTANCE.createBuilder(sabaStruct$Order);
    }

    public static SabaStruct$Order parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SabaStruct$Order parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SabaStruct$Order parseFrom(AbstractC2383g abstractC2383g) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SabaStruct$Order parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SabaStruct$Order parseFrom(byte[] bArr) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SabaStruct$Order parseFrom(byte[] bArr, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SabaStruct$Order parseFrom(InputStream inputStream) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SabaStruct$Order parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SabaStruct$Order parseFrom(AbstractC2384h abstractC2384h) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SabaStruct$Order parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SabaStruct$Order) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
