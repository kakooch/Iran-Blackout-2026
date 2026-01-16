package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.PeersStruct$ExInfo;
import ai.bale.proto.UsersStruct$BotExInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import com.google.protobuf.r0;
import ir.nasim.FM7;
import ir.nasim.InterfaceC16491lM7;
import ir.nasim.KM7;
import ir.nasim.KW4;
import ir.nasim.OM7;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class UsersStruct$User extends GeneratedMessageLite implements OM7 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int AVATAR_FIELD_NUMBER = 6;
    public static final int BOT_EX_INFO_FIELD_NUMBER = 21;
    public static final int CONTACT_INFO_FIELD_NUMBER = 17;
    public static final int CREATED_AT_FIELD_NUMBER = 19;
    private static final UsersStruct$User DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 14;
    public static final int EX_INFO_FIELD_NUMBER = 20;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_BOT_FIELD_NUMBER = 7;
    public static final int IS_DELETED_FIELD_NUMBER = 16;
    public static final int LOCAL_NAME_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NICK_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PUPPETEER_FIELD_NUMBER = 18;
    public static final int SEX_FIELD_NUMBER = 5;
    public static final int STATE_VERSION_FIELD_NUMBER = 15;
    private long accessHash_;
    private FilesStruct$Avatar avatar_;
    private int bitField0_;
    private UsersStruct$BotExInfo botExInfo_;
    private CollectionsStruct$Int64Value createdAt_;
    private PeersStruct$ExInfo exInfo_;
    private int id_;
    private BoolValue isBot_;
    private BoolValue isDeleted_;
    private StringValue localName_;
    private StringValue nick_;
    private int puppeteer_;
    private int sex_;
    private CollectionsStruct$Int64Value stateVersion_;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private String name_ = "";
    private B.j contactInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements OM7 {
        private a() {
            super(UsersStruct$User.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        UsersStruct$User usersStruct$User = new UsersStruct$User();
        DEFAULT_INSTANCE = usersStruct$User;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$User.class, usersStruct$User);
    }

    private UsersStruct$User() {
    }

    private void addAllContactInfo(Iterable<? extends UsersStruct$ContactRecord> iterable) {
        ensureContactInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.contactInfo_);
    }

    private void addContactInfo(UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.add(usersStruct$ContactRecord);
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -3;
    }

    private void clearBotExInfo() {
        this.botExInfo_ = null;
        this.bitField0_ &= -257;
    }

    private void clearContactInfo() {
        this.contactInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCreatedAt() {
        this.createdAt_ = null;
        this.bitField0_ &= -65;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -129;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsBot() {
        this.isBot_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsDeleted() {
        this.isDeleted_ = null;
        this.bitField0_ &= -33;
    }

    private void clearLocalName() {
        this.localName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNick() {
        this.nick_ = null;
        this.bitField0_ &= -9;
    }

    private void clearPuppeteer() {
        this.puppeteer_ = 0;
    }

    private void clearSex() {
        this.sex_ = 0;
    }

    private void clearStateVersion() {
        this.stateVersion_ = null;
        this.bitField0_ &= -17;
    }

    private void ensureContactInfoIsMutable() {
        B.j jVar = this.contactInfo_;
        if (jVar.u()) {
            return;
        }
        this.contactInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersStruct$User getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    private void mergeAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.avatar_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.avatar_ = filesStruct$Avatar;
        } else {
            this.avatar_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.avatar_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeBotExInfo(UsersStruct$BotExInfo usersStruct$BotExInfo) {
        usersStruct$BotExInfo.getClass();
        UsersStruct$BotExInfo usersStruct$BotExInfo2 = this.botExInfo_;
        if (usersStruct$BotExInfo2 == null || usersStruct$BotExInfo2 == UsersStruct$BotExInfo.getDefaultInstance()) {
            this.botExInfo_ = usersStruct$BotExInfo;
        } else {
            this.botExInfo_ = (UsersStruct$BotExInfo) ((UsersStruct$BotExInfo.a) UsersStruct$BotExInfo.newBuilder(this.botExInfo_).v(usersStruct$BotExInfo)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeCreatedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.createdAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.createdAt_ = collectionsStruct$Int64Value;
        } else {
            this.createdAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.createdAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeIsBot(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isBot_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isBot_ = boolValue;
        } else {
            this.isBot_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isBot_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeIsDeleted(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isDeleted_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isDeleted_ = boolValue;
        } else {
            this.isDeleted_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isDeleted_).v(boolValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeLocalName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.localName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.localName_ = stringValue;
        } else {
            this.localName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.localName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeNick(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nick_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nick_ = stringValue;
        } else {
            this.nick_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nick_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeStateVersion(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.stateVersion_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.stateVersion_ = collectionsStruct$Int64Value;
        } else {
            this.stateVersion_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.stateVersion_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$User parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$User) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$User parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContactInfo(int i) {
        ensureContactInfoIsMutable();
        this.contactInfo_.remove(i);
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 2;
    }

    private void setBotExInfo(UsersStruct$BotExInfo usersStruct$BotExInfo) {
        usersStruct$BotExInfo.getClass();
        this.botExInfo_ = usersStruct$BotExInfo;
        this.bitField0_ |= 256;
    }

    private void setContactInfo(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.set(i, usersStruct$ContactRecord);
    }

    private void setCreatedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.createdAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 64;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 128;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsBot(BoolValue boolValue) {
        boolValue.getClass();
        this.isBot_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setIsDeleted(BoolValue boolValue) {
        boolValue.getClass();
        this.isDeleted_ = boolValue;
        this.bitField0_ |= 32;
    }

    private void setLocalName(StringValue stringValue) {
        stringValue.getClass();
        this.localName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNick(StringValue stringValue) {
        stringValue.getClass();
        this.nick_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setPuppeteer(FM7 fm7) {
        this.puppeteer_ = fm7.getNumber();
    }

    private void setPuppeteerValue(int i) {
        this.puppeteer_ = i;
    }

    private void setSex(KM7 km7) {
        this.sex_ = km7.getNumber();
    }

    private void setSexValue(int i) {
        this.sex_ = i;
    }

    private void setStateVersion(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.stateVersion_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 16;
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$User();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0001\u0001\u0015\u0010\u0001\u0001\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004ဉ\u0000\u0005\f\u0006ဉ\u0001\u0007ဉ\u0002\tဉ\u0003\u000e2\u000fဉ\u0004\u0010ဉ\u0005\u0011\u001b\u0012\f\u0013ဉ\u0006\u0014ဉ\u0007\u0015ဉ\b", new Object[]{"bitField0_", "id_", "accessHash_", "name_", "localName_", "sex_", "avatar_", "isBot_", "nick_", "ext_", b.a, "stateVersion_", "isDeleted_", "contactInfo_", UsersStruct$ContactRecord.class, "puppeteer_", "createdAt_", "exInfo_", "botExInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$User.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public UsersStruct$BotExInfo getBotExInfo() {
        UsersStruct$BotExInfo usersStruct$BotExInfo = this.botExInfo_;
        return usersStruct$BotExInfo == null ? UsersStruct$BotExInfo.getDefaultInstance() : usersStruct$BotExInfo;
    }

    public UsersStruct$ContactRecord getContactInfo(int i) {
        return (UsersStruct$ContactRecord) this.contactInfo_.get(i);
    }

    public int getContactInfoCount() {
        return this.contactInfo_.size();
    }

    public List<UsersStruct$ContactRecord> getContactInfoList() {
        return this.contactInfo_;
    }

    public InterfaceC16491lM7 getContactInfoOrBuilder(int i) {
        return (InterfaceC16491lM7) this.contactInfo_.get(i);
    }

    public List<? extends InterfaceC16491lM7> getContactInfoOrBuilderList() {
        return this.contactInfo_;
    }

    public CollectionsStruct$Int64Value getCreatedAt() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.createdAt_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int getId() {
        return this.id_;
    }

    public BoolValue getIsBot() {
        BoolValue boolValue = this.isBot_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsDeleted() {
        BoolValue boolValue = this.isDeleted_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getLocalName() {
        StringValue stringValue = this.localName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public StringValue getNick() {
        StringValue stringValue = this.nick_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public FM7 getPuppeteer() {
        FM7 fm7J = FM7.j(this.puppeteer_);
        return fm7J == null ? FM7.UNRECOGNIZED : fm7J;
    }

    public int getPuppeteerValue() {
        return this.puppeteer_;
    }

    public KM7 getSex() {
        KM7 km7J = KM7.j(this.sex_);
        return km7J == null ? KM7.UNRECOGNIZED : km7J;
    }

    public int getSexValue() {
        return this.sex_;
    }

    public CollectionsStruct$Int64Value getStateVersion() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.stateVersion_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasBotExInfo() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasCreatedAt() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasIsBot() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIsDeleted() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasLocalName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNick() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasStateVersion() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(UsersStruct$User usersStruct$User) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$User);
    }

    public static UsersStruct$User parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$User parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$User parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContactInfo(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.add(i, usersStruct$ContactRecord);
    }

    public static UsersStruct$User parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$User parseFrom(byte[] bArr) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$User parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$User parseFrom(InputStream inputStream) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$User parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$User parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$User parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
