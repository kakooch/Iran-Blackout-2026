package bale.anonymous_contact.v1;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int64Value;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC5307Iu;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class AnonymousContactOuterClass$ResponseGetUserAnonymousContact extends GeneratedMessageLite implements U64 {
    public static final int COMMON_GROUPS_FIELD_NUMBER = 5;
    public static final int COUNTRY_NUMBER_FIELD_NUMBER = 1;
    private static final AnonymousContactOuterClass$ResponseGetUserAnonymousContact DEFAULT_INSTANCE;
    public static final int EXTRA_INFO_FIELD_NUMBER = 6;
    public static final int LAST_TIME_AVATAR_CHANGED_FIELD_NUMBER = 4;
    public static final int LAST_TIME_NAME_CHANGED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REGISTER_ACCOUNT_TIME_FIELD_NUMBER = 2;
    private int bitField0_;
    private Int64Value lastTimeAvatarChanged_;
    private Int64Value lastTimeNameChanged_;
    private Int64Value registerAccountTime_;
    private String countryNumber_ = "";
    private B.j commonGroups_ = GeneratedMessageLite.emptyProtobufList();
    private B.j extraInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AnonymousContactOuterClass$ResponseGetUserAnonymousContact.DEFAULT_INSTANCE);
        }
    }

    static {
        AnonymousContactOuterClass$ResponseGetUserAnonymousContact anonymousContactOuterClass$ResponseGetUserAnonymousContact = new AnonymousContactOuterClass$ResponseGetUserAnonymousContact();
        DEFAULT_INSTANCE = anonymousContactOuterClass$ResponseGetUserAnonymousContact;
        GeneratedMessageLite.registerDefaultInstance(AnonymousContactOuterClass$ResponseGetUserAnonymousContact.class, anonymousContactOuterClass$ResponseGetUserAnonymousContact);
    }

    private AnonymousContactOuterClass$ResponseGetUserAnonymousContact() {
    }

    private void addAllCommonGroups(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureCommonGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.commonGroups_);
    }

    private void addAllExtraInfo(Iterable<? extends AnonymousContactOuterClass$KeyValue> iterable) {
        ensureExtraInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.extraInfo_);
    }

    private void addCommonGroups(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureCommonGroupsIsMutable();
        this.commonGroups_.add(peersStruct$GroupOutPeer);
    }

    private void addExtraInfo(AnonymousContactOuterClass$KeyValue anonymousContactOuterClass$KeyValue) {
        anonymousContactOuterClass$KeyValue.getClass();
        ensureExtraInfoIsMutable();
        this.extraInfo_.add(anonymousContactOuterClass$KeyValue);
    }

    private void clearCommonGroups() {
        this.commonGroups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCountryNumber() {
        this.countryNumber_ = getDefaultInstance().getCountryNumber();
    }

    private void clearExtraInfo() {
        this.extraInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLastTimeAvatarChanged() {
        this.lastTimeAvatarChanged_ = null;
        this.bitField0_ &= -5;
    }

    private void clearLastTimeNameChanged() {
        this.lastTimeNameChanged_ = null;
        this.bitField0_ &= -3;
    }

    private void clearRegisterAccountTime() {
        this.registerAccountTime_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCommonGroupsIsMutable() {
        B.j jVar = this.commonGroups_;
        if (jVar.u()) {
            return;
        }
        this.commonGroups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureExtraInfoIsMutable() {
        B.j jVar = this.extraInfo_;
        if (jVar.u()) {
            return;
        }
        this.extraInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastTimeAvatarChanged(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.lastTimeAvatarChanged_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.lastTimeAvatarChanged_ = int64Value;
        } else {
            this.lastTimeAvatarChanged_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.lastTimeAvatarChanged_).v(int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeLastTimeNameChanged(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.lastTimeNameChanged_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.lastTimeNameChanged_ = int64Value;
        } else {
            this.lastTimeNameChanged_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.lastTimeNameChanged_).v(int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeRegisterAccountTime(Int64Value int64Value) {
        int64Value.getClass();
        Int64Value int64Value2 = this.registerAccountTime_;
        if (int64Value2 == null || int64Value2 == Int64Value.getDefaultInstance()) {
            this.registerAccountTime_ = int64Value;
        } else {
            this.registerAccountTime_ = (Int64Value) ((Int64Value.b) Int64Value.newBuilder(this.registerAccountTime_).v(int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseDelimitedFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(ByteBuffer byteBuffer) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCommonGroups(int i) {
        ensureCommonGroupsIsMutable();
        this.commonGroups_.remove(i);
    }

    private void removeExtraInfo(int i) {
        ensureExtraInfoIsMutable();
        this.extraInfo_.remove(i);
    }

    private void setCommonGroups(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureCommonGroupsIsMutable();
        this.commonGroups_.set(i, peersStruct$GroupOutPeer);
    }

    private void setCountryNumber(String str) {
        str.getClass();
        this.countryNumber_ = str;
    }

    private void setCountryNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.countryNumber_ = abstractC2383g.f0();
    }

    private void setExtraInfo(int i, AnonymousContactOuterClass$KeyValue anonymousContactOuterClass$KeyValue) {
        anonymousContactOuterClass$KeyValue.getClass();
        ensureExtraInfoIsMutable();
        this.extraInfo_.set(i, anonymousContactOuterClass$KeyValue);
    }

    private void setLastTimeAvatarChanged(Int64Value int64Value) {
        int64Value.getClass();
        this.lastTimeAvatarChanged_ = int64Value;
        this.bitField0_ |= 4;
    }

    private void setLastTimeNameChanged(Int64Value int64Value) {
        int64Value.getClass();
        this.lastTimeNameChanged_ = int64Value;
        this.bitField0_ |= 2;
    }

    private void setRegisterAccountTime(Int64Value int64Value) {
        int64Value.getClass();
        this.registerAccountTime_ = int64Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.anonymous_contact.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new AnonymousContactOuterClass$ResponseGetUserAnonymousContact();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u001b\u0006\u001b", new Object[]{"bitField0_", "countryNumber_", "registerAccountTime_", "lastTimeNameChanged_", "lastTimeAvatarChanged_", "commonGroups_", PeersStruct$GroupOutPeer.class, "extraInfo_", AnonymousContactOuterClass$KeyValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AnonymousContactOuterClass$ResponseGetUserAnonymousContact.class) {
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

    public PeersStruct$GroupOutPeer getCommonGroups(int i) {
        return (PeersStruct$GroupOutPeer) this.commonGroups_.get(i);
    }

    public int getCommonGroupsCount() {
        return this.commonGroups_.size();
    }

    public List<PeersStruct$GroupOutPeer> getCommonGroupsList() {
        return this.commonGroups_;
    }

    public InterfaceC11468d35 getCommonGroupsOrBuilder(int i) {
        return (InterfaceC11468d35) this.commonGroups_.get(i);
    }

    public List<? extends InterfaceC11468d35> getCommonGroupsOrBuilderList() {
        return this.commonGroups_;
    }

    public String getCountryNumber() {
        return this.countryNumber_;
    }

    public AbstractC2383g getCountryNumberBytes() {
        return AbstractC2383g.N(this.countryNumber_);
    }

    public AnonymousContactOuterClass$KeyValue getExtraInfo(int i) {
        return (AnonymousContactOuterClass$KeyValue) this.extraInfo_.get(i);
    }

    public int getExtraInfoCount() {
        return this.extraInfo_.size();
    }

    public List<AnonymousContactOuterClass$KeyValue> getExtraInfoList() {
        return this.extraInfo_;
    }

    public InterfaceC5307Iu getExtraInfoOrBuilder(int i) {
        return (InterfaceC5307Iu) this.extraInfo_.get(i);
    }

    public List<? extends InterfaceC5307Iu> getExtraInfoOrBuilderList() {
        return this.extraInfo_;
    }

    public Int64Value getLastTimeAvatarChanged() {
        Int64Value int64Value = this.lastTimeAvatarChanged_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getLastTimeNameChanged() {
        Int64Value int64Value = this.lastTimeNameChanged_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public Int64Value getRegisterAccountTime() {
        Int64Value int64Value = this.registerAccountTime_;
        return int64Value == null ? Int64Value.getDefaultInstance() : int64Value;
    }

    public boolean hasLastTimeAvatarChanged() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLastTimeNameChanged() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRegisterAccountTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AnonymousContactOuterClass$ResponseGetUserAnonymousContact anonymousContactOuterClass$ResponseGetUserAnonymousContact) {
        return (a) DEFAULT_INSTANCE.createBuilder(anonymousContactOuterClass$ResponseGetUserAnonymousContact);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(AbstractC2383g abstractC2383g) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCommonGroups(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureCommonGroupsIsMutable();
        this.commonGroups_.add(i, peersStruct$GroupOutPeer);
    }

    private void addExtraInfo(int i, AnonymousContactOuterClass$KeyValue anonymousContactOuterClass$KeyValue) {
        anonymousContactOuterClass$KeyValue.getClass();
        ensureExtraInfoIsMutable();
        this.extraInfo_.add(i, anonymousContactOuterClass$KeyValue);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(byte[] bArr) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(byte[] bArr, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(AbstractC2384h abstractC2384h) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AnonymousContactOuterClass$ResponseGetUserAnonymousContact parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AnonymousContactOuterClass$ResponseGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
