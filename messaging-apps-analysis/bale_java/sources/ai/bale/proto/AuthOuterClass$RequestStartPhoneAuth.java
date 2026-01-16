package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$RawValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC10921cR;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.WQ;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class AuthOuterClass$RequestStartPhoneAuth extends GeneratedMessageLite implements U64 {
    public static final int API_KEY_FIELD_NUMBER = 3;
    public static final int APP_ID_FIELD_NUMBER = 2;
    private static final AuthOuterClass$RequestStartPhoneAuth DEFAULT_INSTANCE;
    public static final int DEVICE_HASH_FIELD_NUMBER = 4;
    public static final int DEVICE_TITLE_FIELD_NUMBER = 5;
    public static final int IMEI_LIST_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 10;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 1;
    public static final int PREFERRED_LANGUAGES_FIELD_NUMBER = 7;
    public static final int SEND_CODE_TYPE_FIELD_NUMBER = 9;
    public static final int TIME_ZONE_FIELD_NUMBER = 6;
    private static final B.h.a options_converter_ = new a();
    private int appId_;
    private int bitField0_;
    private CollectionsStruct$RawValue imeiList_;
    private int optionsMemoizedSerializedSize;
    private long phoneNumber_;
    private int sendCodeType_;
    private StringValue timeZone_;
    private String apiKey_ = "";
    private AbstractC2383g deviceHash_ = AbstractC2383g.b;
    private String deviceTitle_ = "";
    private B.j preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    private B.g options_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10921cR a(Integer num) {
            EnumC10921cR enumC10921cRJ = EnumC10921cR.j(num.intValue());
            return enumC10921cRJ == null ? EnumC10921cR.UNRECOGNIZED : enumC10921cRJ;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        public b A(Iterable iterable) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).addAllOptions(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).addAllPreferredLanguages(iterable);
            return this;
        }

        public b C(String str) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setApiKey(str);
            return this;
        }

        public b D(int i) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setAppId(i);
            return this;
        }

        public b E(AbstractC2383g abstractC2383g) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setDeviceHash(abstractC2383g);
            return this;
        }

        public b F(String str) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setDeviceTitle(str);
            return this;
        }

        public b G(CollectionsStruct$RawValue collectionsStruct$RawValue) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setImeiList(collectionsStruct$RawValue);
            return this;
        }

        public b H(long j) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setPhoneNumber(j);
            return this;
        }

        public b I(WQ wq) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setSendCodeType(wq);
            return this;
        }

        public b J(StringValue stringValue) {
            q();
            ((AuthOuterClass$RequestStartPhoneAuth) this.b).setTimeZone(stringValue);
            return this;
        }

        private b() {
            super(AuthOuterClass$RequestStartPhoneAuth.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthOuterClass$RequestStartPhoneAuth authOuterClass$RequestStartPhoneAuth = new AuthOuterClass$RequestStartPhoneAuth();
        DEFAULT_INSTANCE = authOuterClass$RequestStartPhoneAuth;
        GeneratedMessageLite.registerDefaultInstance(AuthOuterClass$RequestStartPhoneAuth.class, authOuterClass$RequestStartPhoneAuth);
    }

    private AuthOuterClass$RequestStartPhoneAuth() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends EnumC10921cR> iterable) {
        ensureOptionsIsMutable();
        Iterator<? extends EnumC10921cR> it = iterable.iterator();
        while (it.hasNext()) {
            this.options_.b1(it.next().getNumber());
        }
    }

    private void addAllOptionsValue(Iterable<Integer> iterable) {
        ensureOptionsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.options_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPreferredLanguages(Iterable<String> iterable) {
        ensurePreferredLanguagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.preferredLanguages_);
    }

    private void addOptions(EnumC10921cR enumC10921cR) {
        enumC10921cR.getClass();
        ensureOptionsIsMutable();
        this.options_.b1(enumC10921cR.getNumber());
    }

    private void addOptionsValue(int i) {
        ensureOptionsIsMutable();
        this.options_.b1(i);
    }

    private void addPreferredLanguages(String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(str);
    }

    private void addPreferredLanguagesBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.add(abstractC2383g.f0());
    }

    private void clearApiKey() {
        this.apiKey_ = getDefaultInstance().getApiKey();
    }

    private void clearAppId() {
        this.appId_ = 0;
    }

    private void clearDeviceHash() {
        this.deviceHash_ = getDefaultInstance().getDeviceHash();
    }

    private void clearDeviceTitle() {
        this.deviceTitle_ = getDefaultInstance().getDeviceTitle();
    }

    private void clearImeiList() {
        this.imeiList_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = 0L;
    }

    private void clearPreferredLanguages() {
        this.preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSendCodeType() {
        this.sendCodeType_ = 0;
    }

    private void clearTimeZone() {
        this.timeZone_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureOptionsIsMutable() {
        B.g gVar = this.options_;
        if (gVar.u()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensurePreferredLanguagesIsMutable() {
        B.j jVar = this.preferredLanguages_;
        if (jVar.u()) {
            return;
        }
        this.preferredLanguages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AuthOuterClass$RequestStartPhoneAuth getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeImeiList(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        CollectionsStruct$RawValue collectionsStruct$RawValue2 = this.imeiList_;
        if (collectionsStruct$RawValue2 == null || collectionsStruct$RawValue2 == CollectionsStruct$RawValue.getDefaultInstance()) {
            this.imeiList_ = collectionsStruct$RawValue;
        } else {
            this.imeiList_ = (CollectionsStruct$RawValue) ((CollectionsStruct$RawValue.a) CollectionsStruct$RawValue.newBuilder(this.imeiList_).v(collectionsStruct$RawValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTimeZone(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.timeZone_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.timeZone_ = stringValue;
        } else {
            this.timeZone_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.timeZone_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseDelimitedFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(ByteBuffer byteBuffer) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApiKey(String str) {
        str.getClass();
        this.apiKey_ = str;
    }

    private void setApiKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.apiKey_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppId(int i) {
        this.appId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceHash(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.deviceHash_ = abstractC2383g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceTitle(String str) {
        str.getClass();
        this.deviceTitle_ = str;
    }

    private void setDeviceTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.deviceTitle_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImeiList(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        this.imeiList_ = collectionsStruct$RawValue;
        this.bitField0_ |= 2;
    }

    private void setOptions(int i, EnumC10921cR enumC10921cR) {
        enumC10921cR.getClass();
        ensureOptionsIsMutable();
        this.options_.U(i, enumC10921cR.getNumber());
    }

    private void setOptionsValue(int i, int i2) {
        ensureOptionsIsMutable();
        this.options_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneNumber(long j) {
        this.phoneNumber_ = j;
    }

    private void setPreferredLanguages(int i, String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSendCodeType(WQ wq) {
        this.sendCodeType_ = wq.getNumber();
    }

    private void setSendCodeTypeValue(int i) {
        this.sendCodeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeZone(StringValue stringValue) {
        stringValue.getClass();
        this.timeZone_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1867k.a[gVar.ordinal()]) {
            case 1:
                return new AuthOuterClass$RequestStartPhoneAuth();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001\u0002\u0002\u0004\u0003Ȉ\u0004\n\u0005Ȉ\u0006ဉ\u0000\u0007Ț\bဉ\u0001\t\f\n,", new Object[]{"bitField0_", "phoneNumber_", "appId_", "apiKey_", "deviceHash_", "deviceTitle_", "timeZone_", "preferredLanguages_", "imeiList_", "sendCodeType_", "options_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthOuterClass$RequestStartPhoneAuth.class) {
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

    public String getApiKey() {
        return this.apiKey_;
    }

    public AbstractC2383g getApiKeyBytes() {
        return AbstractC2383g.N(this.apiKey_);
    }

    public int getAppId() {
        return this.appId_;
    }

    public AbstractC2383g getDeviceHash() {
        return this.deviceHash_;
    }

    public String getDeviceTitle() {
        return this.deviceTitle_;
    }

    public AbstractC2383g getDeviceTitleBytes() {
        return AbstractC2383g.N(this.deviceTitle_);
    }

    public CollectionsStruct$RawValue getImeiList() {
        CollectionsStruct$RawValue collectionsStruct$RawValue = this.imeiList_;
        return collectionsStruct$RawValue == null ? CollectionsStruct$RawValue.getDefaultInstance() : collectionsStruct$RawValue;
    }

    public EnumC10921cR getOptions(int i) {
        EnumC10921cR enumC10921cRJ = EnumC10921cR.j(this.options_.getInt(i));
        return enumC10921cRJ == null ? EnumC10921cR.UNRECOGNIZED : enumC10921cRJ;
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List<EnumC10921cR> getOptionsList() {
        return new B.h(this.options_, options_converter_);
    }

    public int getOptionsValue(int i) {
        return this.options_.getInt(i);
    }

    public List<Integer> getOptionsValueList() {
        return this.options_;
    }

    public long getPhoneNumber() {
        return this.phoneNumber_;
    }

    public String getPreferredLanguages(int i) {
        return (String) this.preferredLanguages_.get(i);
    }

    public AbstractC2383g getPreferredLanguagesBytes(int i) {
        return AbstractC2383g.N((String) this.preferredLanguages_.get(i));
    }

    public int getPreferredLanguagesCount() {
        return this.preferredLanguages_.size();
    }

    public List<String> getPreferredLanguagesList() {
        return this.preferredLanguages_;
    }

    public WQ getSendCodeType() {
        WQ wqJ = WQ.j(this.sendCodeType_);
        return wqJ == null ? WQ.UNRECOGNIZED : wqJ;
    }

    public int getSendCodeTypeValue() {
        return this.sendCodeType_;
    }

    public StringValue getTimeZone() {
        StringValue stringValue = this.timeZone_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasImeiList() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTimeZone() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(AuthOuterClass$RequestStartPhoneAuth authOuterClass$RequestStartPhoneAuth) {
        return (b) DEFAULT_INSTANCE.createBuilder(authOuterClass$RequestStartPhoneAuth);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(byte[] bArr) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(InputStream inputStream) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthOuterClass$RequestStartPhoneAuth parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthOuterClass$RequestStartPhoneAuth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
