package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10305bR;
import ir.nasim.InterfaceC9711aR;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.WQ;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class AuthOuterClass$ResponseStartPhoneAuth extends GeneratedMessageLite implements U64 {
    public static final int ACTIVATION_TYPE_FIELD_NUMBER = 3;
    public static final int AVAILABLE_SEND_CODE_TYPES_FIELD_NUMBER = 11;
    public static final int CODE_EXPIRATION_DATE_FIELD_NUMBER = 6;
    public static final int CODE_TIMEOUT_FIELD_NUMBER = 9;
    private static final AuthOuterClass$ResponseStartPhoneAuth DEFAULT_INSTANCE;
    public static final int EX_INFO_ADDRESS_FIELD_NUMBER = 10;
    public static final int IS_IMEI_OK_FIELD_NUMBER = 4;
    public static final int IS_REGISTERED_FIELD_NUMBER = 2;
    public static final int NEXT_SEND_CODE_TYPE_FIELD_NUMBER = 7;
    public static final int NEXT_SEND_CODE_WAIT_TIME_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int SENT_CODE_TYPE_FIELD_NUMBER = 5;
    public static final int TRANSACTION_HASH_FIELD_NUMBER = 1;
    private static final B.h.a availableSendCodeTypes_converter_ = new a();
    private int activationType_;
    private int availableSendCodeTypesMemoizedSerializedSize;
    private int bitField0_;
    private CollectionsStruct$Int64Value codeExpirationDate_;
    private CollectionsStruct$Int32Value codeTimeout_;
    private boolean isImeiOk_;
    private boolean isRegistered_;
    private int nextSendCodeType_;
    private CollectionsStruct$Int64Value nextSendCodeWaitTime_;
    private int sentCodeType_;
    private String transactionHash_ = "";
    private B.j exInfoAddress_ = GeneratedMessageLite.emptyProtobufList();
    private B.g availableSendCodeTypes_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WQ a(Integer num) {
            WQ wqJ = WQ.j(num.intValue());
            return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(AuthOuterClass$ResponseStartPhoneAuth.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$ResponseStartPhoneAuth authOuterClass$ResponseStartPhoneAuth = new AuthOuterClass$ResponseStartPhoneAuth();
        DEFAULT_INSTANCE = authOuterClass$ResponseStartPhoneAuth;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$ResponseStartPhoneAuth.class, authOuterClass$ResponseStartPhoneAuth);
    }

    private AuthOuterClass$ResponseStartPhoneAuth() {
    }

    private void addAllAvailableSendCodeTypes(Iterable<? extends WQ> iterable) {
        ensureAvailableSendCodeTypesIsMutable();
        Iterator<? extends WQ> it = iterable.iterator();
        while (it.hasNext()) {
            this.availableSendCodeTypes_.b1(it.next().getNumber());
        }
    }

    private void addAllAvailableSendCodeTypesValue(Iterable<Integer> iterable) {
        ensureAvailableSendCodeTypesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.availableSendCodeTypes_.b1(it.next().intValue());
        }
    }

    private void addAllExInfoAddress(Iterable<? extends AuthStruct$ExInfoAddress> iterable) {
        ensureExInfoAddressIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exInfoAddress_);
    }

    private void addAvailableSendCodeTypes(WQ wq) {
        wq.getClass();
        ensureAvailableSendCodeTypesIsMutable();
        this.availableSendCodeTypes_.b1(wq.getNumber());
    }

    private void addAvailableSendCodeTypesValue(int i) {
        ensureAvailableSendCodeTypesIsMutable();
        this.availableSendCodeTypes_.b1(i);
    }

    private void addExInfoAddress(AuthStruct$ExInfoAddress authStruct$ExInfoAddress) {
        authStruct$ExInfoAddress.getClass();
        ensureExInfoAddressIsMutable();
        this.exInfoAddress_.add(authStruct$ExInfoAddress);
    }

    private void clearActivationType() {
        this.activationType_ = 0;
    }

    private void clearAvailableSendCodeTypes() {
        this.availableSendCodeTypes_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearCodeExpirationDate() {
        this.codeExpirationDate_ = null;
        this.bitField0_ &= -2;
    }

    private void clearCodeTimeout() {
        this.codeTimeout_ = null;
        this.bitField0_ &= -5;
    }

    private void clearExInfoAddress() {
        this.exInfoAddress_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIsImeiOk() {
        this.isImeiOk_ = false;
    }

    private void clearIsRegistered() {
        this.isRegistered_ = false;
    }

    private void clearNextSendCodeType() {
        this.nextSendCodeType_ = 0;
    }

    private void clearNextSendCodeWaitTime() {
        this.nextSendCodeWaitTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSentCodeType() {
        this.sentCodeType_ = 0;
    }

    private void clearTransactionHash() {
        this.transactionHash_ = getDefaultInstance().getTransactionHash();
    }

    private void ensureAvailableSendCodeTypesIsMutable() {
        B.g gVar = this.availableSendCodeTypes_;
        if (gVar.u()) {
            return;
        }
        this.availableSendCodeTypes_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureExInfoAddressIsMutable() {
        B.j jVar = this.exInfoAddress_;
        if (jVar.u()) {
            return;
        }
        this.exInfoAddress_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCodeExpirationDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.codeExpirationDate_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.codeExpirationDate_ = collectionsStruct$Int64Value;
        } else {
            this.codeExpirationDate_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.codeExpirationDate_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeCodeTimeout(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.codeTimeout_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.codeTimeout_ = collectionsStruct$Int32Value;
        } else {
            this.codeTimeout_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.codeTimeout_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeNextSendCodeWaitTime(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.nextSendCodeWaitTime_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.nextSendCodeWaitTime_ = collectionsStruct$Int64Value;
        } else {
            this.nextSendCodeWaitTime_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.nextSendCodeWaitTime_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeExInfoAddress(int i) {
        ensureExInfoAddressIsMutable();
        this.exInfoAddress_.remove(i);
    }

    private void setActivationType(EnumC10305bR enumC10305bR) {
        this.activationType_ = enumC10305bR.getNumber();
    }

    private void setActivationTypeValue(int i) {
        this.activationType_ = i;
    }

    private void setAvailableSendCodeTypes(int i, WQ wq) {
        wq.getClass();
        ensureAvailableSendCodeTypesIsMutable();
        this.availableSendCodeTypes_.U(i, wq.getNumber());
    }

    private void setAvailableSendCodeTypesValue(int i, int i2) {
        ensureAvailableSendCodeTypesIsMutable();
        this.availableSendCodeTypes_.U(i, i2);
    }

    private void setCodeExpirationDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.codeExpirationDate_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setCodeTimeout(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.codeTimeout_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 4;
    }

    private void setExInfoAddress(int i, AuthStruct$ExInfoAddress authStruct$ExInfoAddress) {
        authStruct$ExInfoAddress.getClass();
        ensureExInfoAddressIsMutable();
        this.exInfoAddress_.set(i, authStruct$ExInfoAddress);
    }

    private void setIsImeiOk(boolean z) {
        this.isImeiOk_ = z;
    }

    private void setIsRegistered(boolean z) {
        this.isRegistered_ = z;
    }

    private void setNextSendCodeType(WQ wq) {
        this.nextSendCodeType_ = wq.getNumber();
    }

    private void setNextSendCodeTypeValue(int i) {
        this.nextSendCodeType_ = i;
    }

    private void setNextSendCodeWaitTime(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.nextSendCodeWaitTime_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setSentCodeType(WQ wq) {
        this.sentCodeType_ = wq.getNumber();
    }

    private void setSentCodeTypeValue(int i) {
        this.sentCodeType_ = i;
    }

    private void setTransactionHash(String str) {
        str.getClass();
        this.transactionHash_ = str;
    }

    private void setTransactionHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionHash_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$ResponseStartPhoneAuth();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0000\u0001Ȉ\u0002\u0007\u0003\f\u0004\u0007\u0005\f\u0006ဉ\u0000\u0007\f\bဉ\u0001\tဉ\u0002\n\u001b\u000b,", new Object[]{"bitField0_", "transactionHash_", "isRegistered_", "activationType_", "isImeiOk_", "sentCodeType_", "codeExpirationDate_", "nextSendCodeType_", "nextSendCodeWaitTime_", "codeTimeout_", "exInfoAddress_", AuthStruct$ExInfoAddress.class, "availableSendCodeTypes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$ResponseStartPhoneAuth.class) {
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

    public EnumC10305bR getActivationType() {
        EnumC10305bR enumC10305bRJ = EnumC10305bR.j(this.activationType_);
        return enumC10305bRJ == null ? EnumC10305bR.UNRECOGNIZED : enumC10305bRJ;
    }

    public int getActivationTypeValue() {
        return this.activationType_;
    }

    public WQ getAvailableSendCodeTypes(int i) {
        WQ wqJ = WQ.j(this.availableSendCodeTypes_.getInt(i));
        return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
    }

    public int getAvailableSendCodeTypesCount() {
        return this.availableSendCodeTypes_.size();
    }

    public List<WQ> getAvailableSendCodeTypesList() {
        return new B.h(this.availableSendCodeTypes_, availableSendCodeTypes_converter_);
    }

    public int getAvailableSendCodeTypesValue(int i) {
        return this.availableSendCodeTypes_.getInt(i);
    }

    public List<Integer> getAvailableSendCodeTypesValueList() {
        return this.availableSendCodeTypes_;
    }

    public CollectionsStruct$Int64Value getCodeExpirationDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.codeExpirationDate_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$Int32Value getCodeTimeout() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.codeTimeout_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public AuthStruct$ExInfoAddress getExInfoAddress(int i) {
        return (AuthStruct$ExInfoAddress) this.exInfoAddress_.get(i);
    }

    public int getExInfoAddressCount() {
        return this.exInfoAddress_.size();
    }

    public List<AuthStruct$ExInfoAddress> getExInfoAddressList() {
        return this.exInfoAddress_;
    }

    public InterfaceC9711aR getExInfoAddressOrBuilder(int i) {
        return (InterfaceC9711aR) this.exInfoAddress_.get(i);
    }

    public List<? extends InterfaceC9711aR> getExInfoAddressOrBuilderList() {
        return this.exInfoAddress_;
    }

    public boolean getIsImeiOk() {
        return this.isImeiOk_;
    }

    public boolean getIsRegistered() {
        return this.isRegistered_;
    }

    public WQ getNextSendCodeType() {
        WQ wqJ = WQ.j(this.nextSendCodeType_);
        return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
    }

    public int getNextSendCodeTypeValue() {
        return this.nextSendCodeType_;
    }

    public CollectionsStruct$Int64Value getNextSendCodeWaitTime() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.nextSendCodeWaitTime_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public WQ getSentCodeType() {
        WQ wqJ = WQ.j(this.sentCodeType_);
        return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
    }

    public int getSentCodeTypeValue() {
        return this.sentCodeType_;
    }

    public String getTransactionHash() {
        return this.transactionHash_;
    }

    public AbstractC2383g getTransactionHashBytes() {
        return AbstractC2383g.N(this.transactionHash_);
    }

    public boolean hasCodeExpirationDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasCodeTimeout() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasNextSendCodeWaitTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public static b newBuilder(AuthOuterClass$ResponseStartPhoneAuth authOuterClass$ResponseStartPhoneAuth) {
        return (b) DEFAULT_INSTANCE.createBuilder(authOuterClass$ResponseStartPhoneAuth);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addExInfoAddress(int i, AuthStruct$ExInfoAddress authStruct$ExInfoAddress) {
        authStruct$ExInfoAddress.getClass();
        ensureExInfoAddressIsMutable();
        this.exInfoAddress_.add(i, authStruct$ExInfoAddress);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(byte[] bArr) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(InputStream inputStream) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$ResponseStartPhoneAuth parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$ResponseStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
