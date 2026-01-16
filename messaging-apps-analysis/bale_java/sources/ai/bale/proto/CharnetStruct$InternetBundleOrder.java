package ai.bale.proto;

import ai.bale.proto.CharnetStruct$InternetBundle;
import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.TK0;
import ir.nasim.WK0;
import ir.nasim.XK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CharnetStruct$InternetBundleOrder extends GeneratedMessageLite implements WK0 {
    public static final int BUNDLE_INFO_FIELD_NUMBER = 6;
    public static final int BUNDLE_TYPE_FIELD_NUMBER = 4;
    private static final CharnetStruct$InternetBundleOrder DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_STILL_VALID_FIELD_NUMBER = 5;
    public static final int OPERATOR_TYPE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 3;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 7;
    private int bitField0_;
    private CharnetStruct$InternetBundle bundleInfo_;
    private int bundleType_;
    private long id_;
    private CollectionsStruct$BooleanValue isStillValid_;
    private int operatorType_;
    private String phoneNumber_ = "";
    private CollectionsStruct$Int32Value targetUserId_;

    public static final class a extends GeneratedMessageLite.b implements WK0 {
        private a() {
            super(CharnetStruct$InternetBundleOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        CharnetStruct$InternetBundleOrder charnetStruct$InternetBundleOrder = new CharnetStruct$InternetBundleOrder();
        DEFAULT_INSTANCE = charnetStruct$InternetBundleOrder;
        GeneratedMessageLite.registerDefaultInstance(CharnetStruct$InternetBundleOrder.class, charnetStruct$InternetBundleOrder);
    }

    private CharnetStruct$InternetBundleOrder() {
    }

    private void clearBundleInfo() {
        this.bundleInfo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearBundleType() {
        this.bundleType_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearIsStillValid() {
        this.isStillValid_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOperatorType() {
        this.operatorType_ = 0;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -5;
    }

    public static CharnetStruct$InternetBundleOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBundleInfo(CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        charnetStruct$InternetBundle.getClass();
        CharnetStruct$InternetBundle charnetStruct$InternetBundle2 = this.bundleInfo_;
        if (charnetStruct$InternetBundle2 == null || charnetStruct$InternetBundle2 == CharnetStruct$InternetBundle.getDefaultInstance()) {
            this.bundleInfo_ = charnetStruct$InternetBundle;
        } else {
            this.bundleInfo_ = (CharnetStruct$InternetBundle) ((CharnetStruct$InternetBundle.a) CharnetStruct$InternetBundle.newBuilder(this.bundleInfo_).v(charnetStruct$InternetBundle)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIsStillValid(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isStillValid_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isStillValid_ = collectionsStruct$BooleanValue;
        } else {
            this.isStillValid_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isStillValid_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.targetUserId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.targetUserId_ = collectionsStruct$Int32Value;
        } else {
            this.targetUserId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.targetUserId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CharnetStruct$InternetBundleOrder parseDelimitedFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(ByteBuffer byteBuffer) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBundleInfo(CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        charnetStruct$InternetBundle.getClass();
        this.bundleInfo_ = charnetStruct$InternetBundle;
        this.bitField0_ |= 2;
    }

    private void setBundleType(TK0 tk0) {
        this.bundleType_ = tk0.getNumber();
    }

    private void setBundleTypeValue(int i) {
        this.bundleType_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setIsStillValid(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isStillValid_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    private void setOperatorType(XK0 xk0) {
        this.operatorType_ = xk0.getNumber();
    }

    private void setOperatorTypeValue(int i) {
        this.operatorType_ = i;
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
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A.a[gVar.ordinal()]) {
            case 1:
                return new CharnetStruct$InternetBundleOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003Ȉ\u0004\f\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002", new Object[]{"bitField0_", "id_", "operatorType_", "phoneNumber_", "bundleType_", "isStillValid_", "bundleInfo_", "targetUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CharnetStruct$InternetBundleOrder.class) {
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

    public CharnetStruct$InternetBundle getBundleInfo() {
        CharnetStruct$InternetBundle charnetStruct$InternetBundle = this.bundleInfo_;
        return charnetStruct$InternetBundle == null ? CharnetStruct$InternetBundle.getDefaultInstance() : charnetStruct$InternetBundle;
    }

    public TK0 getBundleType() {
        TK0 tk0J = TK0.j(this.bundleType_);
        return tk0J == null ? TK0.UNRECOGNIZED : tk0J;
    }

    public int getBundleTypeValue() {
        return this.bundleType_;
    }

    public long getId() {
        return this.id_;
    }

    public CollectionsStruct$BooleanValue getIsStillValid() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isStillValid_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public XK0 getOperatorType() {
        XK0 xk0J = XK0.j(this.operatorType_);
        return xk0J == null ? XK0.UNRECOGNIZED : xk0J;
    }

    public int getOperatorTypeValue() {
        return this.operatorType_;
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

    public boolean hasBundleInfo() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsStillValid() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(CharnetStruct$InternetBundleOrder charnetStruct$InternetBundleOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnetStruct$InternetBundleOrder);
    }

    public static CharnetStruct$InternetBundleOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(byte[] bArr) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CharnetStruct$InternetBundleOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CharnetStruct$InternetBundleOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
