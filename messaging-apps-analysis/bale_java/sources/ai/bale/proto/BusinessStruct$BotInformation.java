package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.UsersStruct$IntroMessage;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$BotInformation extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 6;
    public static final int AVATAR_FIELD_NUMBER = 5;
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final BusinessStruct$BotInformation DEFAULT_INSTANCE;
    public static final int INTRO_MESSAGE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NICKNAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private FilesStruct$FileLocation avatar_;
    private int bitField0_;
    private int botId_;
    private UsersStruct$IntroMessage introMessage_;
    private String nickname_ = "";
    private String name_ = "";
    private String about_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessStruct$BotInformation.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$BotInformation businessStruct$BotInformation = new BusinessStruct$BotInformation();
        DEFAULT_INSTANCE = businessStruct$BotInformation;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$BotInformation.class, businessStruct$BotInformation);
    }

    private BusinessStruct$BotInformation() {
    }

    private void clearAbout() {
        this.about_ = getDefaultInstance().getAbout();
    }

    private void clearAvatar() {
        this.avatar_ = null;
        this.bitField0_ &= -3;
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearIntroMessage() {
        this.introMessage_ = null;
        this.bitField0_ &= -2;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNickname() {
        this.nickname_ = getDefaultInstance().getNickname();
    }

    public static BusinessStruct$BotInformation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.avatar_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.avatar_ = filesStruct$FileLocation;
        } else {
            this.avatar_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.avatar_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIntroMessage(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        usersStruct$IntroMessage.getClass();
        UsersStruct$IntroMessage usersStruct$IntroMessage2 = this.introMessage_;
        if (usersStruct$IntroMessage2 == null || usersStruct$IntroMessage2 == UsersStruct$IntroMessage.getDefaultInstance()) {
            this.introMessage_ = usersStruct$IntroMessage;
        } else {
            this.introMessage_ = (UsersStruct$IntroMessage) ((UsersStruct$IntroMessage.a) UsersStruct$IntroMessage.newBuilder(this.introMessage_).v(usersStruct$IntroMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$BotInformation parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BotInformation parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAbout(String str) {
        str.getClass();
        this.about_ = str;
    }

    private void setAboutBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.about_ = abstractC2383g.f0();
    }

    private void setAvatar(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.avatar_ = filesStruct$FileLocation;
        this.bitField0_ |= 2;
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setIntroMessage(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        usersStruct$IntroMessage.getClass();
        this.introMessage_ = usersStruct$IntroMessage;
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

    private void setNickname(String str) {
        str.getClass();
        this.nickname_ = str;
    }

    private void setNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nickname_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$BotInformation();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005ဉ\u0001\u0006Ȉ", new Object[]{"bitField0_", "botId_", "nickname_", "name_", "introMessage_", "avatar_", "about_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$BotInformation.class) {
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

    public String getAbout() {
        return this.about_;
    }

    public AbstractC2383g getAboutBytes() {
        return AbstractC2383g.N(this.about_);
    }

    public FilesStruct$FileLocation getAvatar() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.avatar_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public int getBotId() {
        return this.botId_;
    }

    public UsersStruct$IntroMessage getIntroMessage() {
        UsersStruct$IntroMessage usersStruct$IntroMessage = this.introMessage_;
        return usersStruct$IntroMessage == null ? UsersStruct$IntroMessage.getDefaultInstance() : usersStruct$IntroMessage;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getNickname() {
        return this.nickname_;
    }

    public AbstractC2383g getNicknameBytes() {
        return AbstractC2383g.N(this.nickname_);
    }

    public boolean hasAvatar() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIntroMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessStruct$BotInformation businessStruct$BotInformation) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$BotInformation);
    }

    public static BusinessStruct$BotInformation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BotInformation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$BotInformation parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$BotInformation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$BotInformation parseFrom(byte[] bArr) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$BotInformation parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$BotInformation parseFrom(InputStream inputStream) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BotInformation parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BotInformation parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$BotInformation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$BotInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
