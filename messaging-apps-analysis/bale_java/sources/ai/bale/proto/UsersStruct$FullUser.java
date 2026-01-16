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
import ir.nasim.EnumC7089Qf4;
import ir.nasim.FM7;
import ir.nasim.InterfaceC14720iM7;
import ir.nasim.InterfaceC16491lM7;
import ir.nasim.KM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class UsersStruct$FullUser extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 7;
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    public static final int AVATAR_FIELD_NUMBER = 6;
    public static final int BOT_COMMANDS_FIELD_NUMBER = 12;
    public static final int BOT_EX_INFO_FIELD_NUMBER = 25;
    public static final int CONTACT_INFO_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 22;
    public static final int DEFAULT_BANK_ACCOUNT_FIELD_NUMBER = 19;
    public static final int DEFAULT_CARD_NUMBER_FIELD_NUMBER = 20;
    private static final UsersStruct$FullUser DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 16;
    public static final int EX_INFO_FIELD_NUMBER = 11;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_BLOCKED_FIELD_NUMBER = 13;
    public static final int IS_BOT_FIELD_NUMBER = 9;
    public static final int IS_CONTACT_FIELD_NUMBER = 15;
    public static final int IS_DELETED_FIELD_NUMBER = 14;
    public static final int LOCAL_NAME_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NICK_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PREFERRED_LANGUAGES_FIELD_NUMBER = 17;
    public static final int PRIVACY_ALLOWED_TO_INVITE_FIELD_NUMBER = 24;
    public static final int PRIVACY_BAR_MODE_FIELD_NUMBER = 23;
    public static final int PUPPETEER_FIELD_NUMBER = 21;
    public static final int SEX_FIELD_NUMBER = 10;
    public static final int TIME_ZONE_FIELD_NUMBER = 18;
    private StringValue about_;
    private long accessHash_;
    private FilesStruct$Avatar avatar_;
    private int bitField0_;
    private UsersStruct$BotExInfo botExInfo_;
    private CollectionsStruct$Int64Value createdAt_;
    private StringValue defaultBankAccount_;
    private StringValue defaultCardNumber_;
    private PeersStruct$ExInfo exInfo_;
    private int id_;
    private BoolValue isBlocked_;
    private BoolValue isBot_;
    private BoolValue isContact_;
    private BoolValue isDeleted_;
    private StringValue localName_;
    private StringValue nick_;
    private BoolValue privacyAllowedToInvite_;
    private int privacyBarMode_;
    private int puppeteer_;
    private int sex_;
    private StringValue timeZone_;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private String name_ = "";
    private B.j contactInfo_ = GeneratedMessageLite.emptyProtobufList();
    private B.j botCommands_ = GeneratedMessageLite.emptyProtobufList();
    private B.j preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$FullUser.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        UsersStruct$FullUser usersStruct$FullUser = new UsersStruct$FullUser();
        DEFAULT_INSTANCE = usersStruct$FullUser;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$FullUser.class, usersStruct$FullUser);
    }

    private UsersStruct$FullUser() {
    }

    private void addAllBotCommands(Iterable<? extends UsersStruct$BotCommand> iterable) {
        ensureBotCommandsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.botCommands_);
    }

    private void addAllContactInfo(Iterable<? extends UsersStruct$ContactRecord> iterable) {
        ensureContactInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.contactInfo_);
    }

    private void addAllPreferredLanguages(Iterable<String> iterable) {
        ensurePreferredLanguagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.preferredLanguages_);
    }

    private void addBotCommands(UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureBotCommandsIsMutable();
        this.botCommands_.add(usersStruct$BotCommand);
    }

    private void addContactInfo(UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.add(usersStruct$ContactRecord);
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

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -9;
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -5;
    }

    private void clearBotCommands() {
        this.botCommands_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearBotExInfo() {
        this.botExInfo_ = null;
        this.bitField0_ &= -16385;
    }

    private void clearContactInfo() {
        this.contactInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCreatedAt() {
        this.createdAt_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearDefaultBankAccount() {
        this.defaultBankAccount_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearDefaultCardNumber() {
        this.defaultCardNumber_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -33;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsBlocked() {
        this.isBlocked_ = null;
        this.bitField0_ &= -65;
    }

    private void clearIsBot() {
        this.isBot_ = null;
        this.bitField0_ &= -17;
    }

    private void clearIsContact() {
        this.isContact_ = null;
        this.bitField0_ &= -257;
    }

    private void clearIsDeleted() {
        this.isDeleted_ = null;
        this.bitField0_ &= -129;
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
        this.bitField0_ &= -3;
    }

    private void clearPreferredLanguages() {
        this.preferredLanguages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPrivacyAllowedToInvite() {
        this.privacyAllowedToInvite_ = null;
        this.bitField0_ &= -8193;
    }

    private void clearPrivacyBarMode() {
        this.privacyBarMode_ = 0;
    }

    private void clearPuppeteer() {
        this.puppeteer_ = 0;
    }

    private void clearSex() {
        this.sex_ = 0;
    }

    private void clearTimeZone() {
        this.timeZone_ = null;
        this.bitField0_ &= -513;
    }

    private void ensureBotCommandsIsMutable() {
        B.j jVar = this.botCommands_;
        if (jVar.u()) {
            return;
        }
        this.botCommands_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureContactInfoIsMutable() {
        B.j jVar = this.contactInfo_;
        if (jVar.u()) {
            return;
        }
        this.contactInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePreferredLanguagesIsMutable() {
        B.j jVar = this.preferredLanguages_;
        if (jVar.u()) {
            return;
        }
        this.preferredLanguages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersStruct$FullUser getDefaultInstance() {
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

    private void mergeAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.about_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.about_ = stringValue;
        } else {
            this.about_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.about_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        FilesStruct$Avatar filesStruct$Avatar2 = this.avatar_;
        if (filesStruct$Avatar2 == null || filesStruct$Avatar2 == FilesStruct$Avatar.getDefaultInstance()) {
            this.avatar_ = filesStruct$Avatar;
        } else {
            this.avatar_ = (FilesStruct$Avatar) ((FilesStruct$Avatar.a) FilesStruct$Avatar.newBuilder(this.avatar_).v(filesStruct$Avatar)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeBotExInfo(UsersStruct$BotExInfo usersStruct$BotExInfo) {
        usersStruct$BotExInfo.getClass();
        UsersStruct$BotExInfo usersStruct$BotExInfo2 = this.botExInfo_;
        if (usersStruct$BotExInfo2 == null || usersStruct$BotExInfo2 == UsersStruct$BotExInfo.getDefaultInstance()) {
            this.botExInfo_ = usersStruct$BotExInfo;
        } else {
            this.botExInfo_ = (UsersStruct$BotExInfo) ((UsersStruct$BotExInfo.a) UsersStruct$BotExInfo.newBuilder(this.botExInfo_).v(usersStruct$BotExInfo)).j();
        }
        this.bitField0_ |= 16384;
    }

    private void mergeCreatedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.createdAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.createdAt_ = collectionsStruct$Int64Value;
        } else {
            this.createdAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.createdAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeDefaultBankAccount(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.defaultBankAccount_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.defaultBankAccount_ = stringValue;
        } else {
            this.defaultBankAccount_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.defaultBankAccount_).v(stringValue)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeDefaultCardNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.defaultCardNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.defaultCardNumber_ = stringValue;
        } else {
            this.defaultCardNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.defaultCardNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeIsBlocked(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isBlocked_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isBlocked_ = boolValue;
        } else {
            this.isBlocked_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isBlocked_).v(boolValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeIsBot(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isBot_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isBot_ = boolValue;
        } else {
            this.isBot_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isBot_).v(boolValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeIsContact(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isContact_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isContact_ = boolValue;
        } else {
            this.isContact_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isContact_).v(boolValue)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeIsDeleted(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isDeleted_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isDeleted_ = boolValue;
        } else {
            this.isDeleted_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isDeleted_).v(boolValue)).j();
        }
        this.bitField0_ |= 128;
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
        this.bitField0_ |= 2;
    }

    private void mergePrivacyAllowedToInvite(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.privacyAllowedToInvite_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.privacyAllowedToInvite_ = boolValue;
        } else {
            this.privacyAllowedToInvite_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.privacyAllowedToInvite_).v(boolValue)).j();
        }
        this.bitField0_ |= 8192;
    }

    private void mergeTimeZone(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.timeZone_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.timeZone_ = stringValue;
        } else {
            this.timeZone_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.timeZone_).v(stringValue)).j();
        }
        this.bitField0_ |= 512;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$FullUser parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$FullUser parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBotCommands(int i) {
        ensureBotCommandsIsMutable();
        this.botCommands_.remove(i);
    }

    private void removeContactInfo(int i) {
        ensureContactInfoIsMutable();
        this.contactInfo_.remove(i);
    }

    private void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setAvatar(FilesStruct$Avatar filesStruct$Avatar) {
        filesStruct$Avatar.getClass();
        this.avatar_ = filesStruct$Avatar;
        this.bitField0_ |= 4;
    }

    private void setBotCommands(int i, UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureBotCommandsIsMutable();
        this.botCommands_.set(i, usersStruct$BotCommand);
    }

    private void setBotExInfo(UsersStruct$BotExInfo usersStruct$BotExInfo) {
        usersStruct$BotExInfo.getClass();
        this.botExInfo_ = usersStruct$BotExInfo;
        this.bitField0_ |= 16384;
    }

    private void setContactInfo(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.set(i, usersStruct$ContactRecord);
    }

    private void setCreatedAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.createdAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4096;
    }

    private void setDefaultBankAccount(StringValue stringValue) {
        stringValue.getClass();
        this.defaultBankAccount_ = stringValue;
        this.bitField0_ |= 1024;
    }

    private void setDefaultCardNumber(StringValue stringValue) {
        stringValue.getClass();
        this.defaultCardNumber_ = stringValue;
        this.bitField0_ |= 2048;
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 32;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsBlocked(BoolValue boolValue) {
        boolValue.getClass();
        this.isBlocked_ = boolValue;
        this.bitField0_ |= 64;
    }

    private void setIsBot(BoolValue boolValue) {
        boolValue.getClass();
        this.isBot_ = boolValue;
        this.bitField0_ |= 16;
    }

    private void setIsContact(BoolValue boolValue) {
        boolValue.getClass();
        this.isContact_ = boolValue;
        this.bitField0_ |= 256;
    }

    private void setIsDeleted(BoolValue boolValue) {
        boolValue.getClass();
        this.isDeleted_ = boolValue;
        this.bitField0_ |= 128;
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
        this.bitField0_ |= 2;
    }

    private void setPreferredLanguages(int i, String str) {
        str.getClass();
        ensurePreferredLanguagesIsMutable();
        this.preferredLanguages_.set(i, str);
    }

    private void setPrivacyAllowedToInvite(BoolValue boolValue) {
        boolValue.getClass();
        this.privacyAllowedToInvite_ = boolValue;
        this.bitField0_ |= 8192;
    }

    private void setPrivacyBarMode(EnumC7089Qf4 enumC7089Qf4) {
        this.privacyBarMode_ = enumC7089Qf4.getNumber();
    }

    private void setPrivacyBarModeValue(int i) {
        this.privacyBarMode_ = i;
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

    private void setTimeZone(StringValue stringValue) {
        stringValue.getClass();
        this.timeZone_ = stringValue;
        this.bitField0_ |= 512;
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$FullUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0000\u0001\u0001\u0019\u0019\u0001\u0003\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003\b\u001b\tဉ\u0004\n\f\u000bဉ\u0005\f\u001b\rဉ\u0006\u000eဉ\u0007\u000fဉ\b\u00102\u0011Ț\u0012ဉ\t\u0013ဉ\n\u0014ဉ\u000b\u0015\f\u0016ဉ\f\u0017\f\u0018ဉ\r\u0019ဉ\u000e", new Object[]{"bitField0_", "id_", "accessHash_", "name_", "localName_", "nick_", "avatar_", "about_", "contactInfo_", UsersStruct$ContactRecord.class, "isBot_", "sex_", "exInfo_", "botCommands_", UsersStruct$BotCommand.class, "isBlocked_", "isDeleted_", "isContact_", "ext_", b.a, "preferredLanguages_", "timeZone_", "defaultBankAccount_", "defaultCardNumber_", "puppeteer_", "createdAt_", "privacyBarMode_", "privacyAllowedToInvite_", "botExInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$FullUser.class) {
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

    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getAccessHash() {
        return this.accessHash_;
    }

    public FilesStruct$Avatar getAvatar() {
        FilesStruct$Avatar filesStruct$Avatar = this.avatar_;
        return filesStruct$Avatar == null ? FilesStruct$Avatar.getDefaultInstance() : filesStruct$Avatar;
    }

    public UsersStruct$BotCommand getBotCommands(int i) {
        return (UsersStruct$BotCommand) this.botCommands_.get(i);
    }

    public int getBotCommandsCount() {
        return this.botCommands_.size();
    }

    public List<UsersStruct$BotCommand> getBotCommandsList() {
        return this.botCommands_;
    }

    public InterfaceC14720iM7 getBotCommandsOrBuilder(int i) {
        return (InterfaceC14720iM7) this.botCommands_.get(i);
    }

    public List<? extends InterfaceC14720iM7> getBotCommandsOrBuilderList() {
        return this.botCommands_;
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

    public StringValue getDefaultBankAccount() {
        StringValue stringValue = this.defaultBankAccount_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getDefaultCardNumber() {
        StringValue stringValue = this.defaultCardNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public BoolValue getIsBlocked() {
        BoolValue boolValue = this.isBlocked_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsBot() {
        BoolValue boolValue = this.isBot_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsContact() {
        BoolValue boolValue = this.isContact_;
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

    public BoolValue getPrivacyAllowedToInvite() {
        BoolValue boolValue = this.privacyAllowedToInvite_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public EnumC7089Qf4 getPrivacyBarMode() {
        EnumC7089Qf4 enumC7089Qf4J = EnumC7089Qf4.j(this.privacyBarMode_);
        return enumC7089Qf4J == null ? EnumC7089Qf4.UNRECOGNIZED : enumC7089Qf4J;
    }

    public int getPrivacyBarModeValue() {
        return this.privacyBarMode_;
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

    public StringValue getTimeZone() {
        StringValue stringValue = this.timeZone_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAbout() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasBotExInfo() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasDefaultBankAccount() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasDefaultCardNumber() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasIsBlocked() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasIsBot() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasIsContact() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasIsDeleted() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasLocalName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNick() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPrivacyAllowedToInvite() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasTimeZone() {
        return (this.bitField0_ & 512) != 0;
    }

    public static a newBuilder(UsersStruct$FullUser usersStruct$FullUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$FullUser);
    }

    public static UsersStruct$FullUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$FullUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$FullUser parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBotCommands(int i, UsersStruct$BotCommand usersStruct$BotCommand) {
        usersStruct$BotCommand.getClass();
        ensureBotCommandsIsMutable();
        this.botCommands_.add(i, usersStruct$BotCommand);
    }

    private void addContactInfo(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactInfoIsMutable();
        this.contactInfo_.add(i, usersStruct$ContactRecord);
    }

    public static UsersStruct$FullUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$FullUser parseFrom(byte[] bArr) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$FullUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$FullUser parseFrom(InputStream inputStream) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$FullUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$FullUser parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$FullUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$FullUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
