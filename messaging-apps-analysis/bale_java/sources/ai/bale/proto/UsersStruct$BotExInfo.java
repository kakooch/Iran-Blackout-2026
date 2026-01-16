package ai.bale.proto;

import ai.bale.proto.UsersStruct$Intro;
import ai.bale.proto.UsersStruct$IntroMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$BotExInfo extends GeneratedMessageLite implements U64 {
    public static final int BOT_ACTIVE_USERS_FIELD_NUMBER = 1;
    private static final UsersStruct$BotExInfo DEFAULT_INSTANCE;
    public static final int HAS_MAIN_MINI_APP_FIELD_NUMBER = 2;
    public static final int HAS_TIMCHE_PROFILE_FIELD_NUMBER = 5;
    public static final int INTRO_FIELD_NUMBER = 3;
    public static final int INTRO_MESSAGE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue botActiveUsers_;
    private BoolValue hasMainMiniApp_;
    private BoolValue hasTimcheProfile_;
    private UsersStruct$IntroMessage introMessage_;
    private UsersStruct$Intro intro_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$BotExInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$BotExInfo usersStruct$BotExInfo = new UsersStruct$BotExInfo();
        DEFAULT_INSTANCE = usersStruct$BotExInfo;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$BotExInfo.class, usersStruct$BotExInfo);
    }

    private UsersStruct$BotExInfo() {
    }

    private void clearBotActiveUsers() {
        this.botActiveUsers_ = null;
        this.bitField0_ &= -2;
    }

    private void clearHasMainMiniApp() {
        this.hasMainMiniApp_ = null;
        this.bitField0_ &= -3;
    }

    private void clearHasTimcheProfile() {
        this.hasTimcheProfile_ = null;
        this.bitField0_ &= -17;
    }

    private void clearIntro() {
        this.intro_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIntroMessage() {
        this.introMessage_ = null;
        this.bitField0_ &= -9;
    }

    public static UsersStruct$BotExInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotActiveUsers(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.botActiveUsers_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.botActiveUsers_ = stringValue;
        } else {
            this.botActiveUsers_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.botActiveUsers_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeHasMainMiniApp(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.hasMainMiniApp_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.hasMainMiniApp_ = boolValue;
        } else {
            this.hasMainMiniApp_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.hasMainMiniApp_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeHasTimcheProfile(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.hasTimcheProfile_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.hasTimcheProfile_ = boolValue;
        } else {
            this.hasTimcheProfile_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.hasTimcheProfile_).v(boolValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeIntro(UsersStruct$Intro usersStruct$Intro) {
        usersStruct$Intro.getClass();
        UsersStruct$Intro usersStruct$Intro2 = this.intro_;
        if (usersStruct$Intro2 == null || usersStruct$Intro2 == UsersStruct$Intro.getDefaultInstance()) {
            this.intro_ = usersStruct$Intro;
        } else {
            this.intro_ = (UsersStruct$Intro) ((UsersStruct$Intro.a) UsersStruct$Intro.newBuilder(this.intro_).v(usersStruct$Intro)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeIntroMessage(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        usersStruct$IntroMessage.getClass();
        UsersStruct$IntroMessage usersStruct$IntroMessage2 = this.introMessage_;
        if (usersStruct$IntroMessage2 == null || usersStruct$IntroMessage2 == UsersStruct$IntroMessage.getDefaultInstance()) {
            this.introMessage_ = usersStruct$IntroMessage;
        } else {
            this.introMessage_ = (UsersStruct$IntroMessage) ((UsersStruct$IntroMessage.a) UsersStruct$IntroMessage.newBuilder(this.introMessage_).v(usersStruct$IntroMessage)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$BotExInfo parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$BotExInfo parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotActiveUsers(StringValue stringValue) {
        stringValue.getClass();
        this.botActiveUsers_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setHasMainMiniApp(BoolValue boolValue) {
        boolValue.getClass();
        this.hasMainMiniApp_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setHasTimcheProfile(BoolValue boolValue) {
        boolValue.getClass();
        this.hasTimcheProfile_ = boolValue;
        this.bitField0_ |= 16;
    }

    private void setIntro(UsersStruct$Intro usersStruct$Intro) {
        usersStruct$Intro.getClass();
        this.intro_ = usersStruct$Intro;
        this.bitField0_ |= 4;
    }

    private void setIntroMessage(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        usersStruct$IntroMessage.getClass();
        this.introMessage_ = usersStruct$IntroMessage;
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$BotExInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "botActiveUsers_", "hasMainMiniApp_", "intro_", "introMessage_", "hasTimcheProfile_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$BotExInfo.class) {
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

    public StringValue getBotActiveUsers() {
        StringValue stringValue = this.botActiveUsers_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public BoolValue getHasMainMiniApp() {
        BoolValue boolValue = this.hasMainMiniApp_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getHasTimcheProfile() {
        BoolValue boolValue = this.hasTimcheProfile_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    @Deprecated
    public UsersStruct$Intro getIntro() {
        UsersStruct$Intro usersStruct$Intro = this.intro_;
        return usersStruct$Intro == null ? UsersStruct$Intro.getDefaultInstance() : usersStruct$Intro;
    }

    public UsersStruct$IntroMessage getIntroMessage() {
        UsersStruct$IntroMessage usersStruct$IntroMessage = this.introMessage_;
        return usersStruct$IntroMessage == null ? UsersStruct$IntroMessage.getDefaultInstance() : usersStruct$IntroMessage;
    }

    public boolean hasBotActiveUsers() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasHasMainMiniApp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasHasTimcheProfile() {
        return (this.bitField0_ & 16) != 0;
    }

    @Deprecated
    public boolean hasIntro() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIntroMessage() {
        return (this.bitField0_ & 8) != 0;
    }

    public static a newBuilder(UsersStruct$BotExInfo usersStruct$BotExInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$BotExInfo);
    }

    public static UsersStruct$BotExInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$BotExInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$BotExInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$BotExInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$BotExInfo parseFrom(byte[] bArr) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$BotExInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$BotExInfo parseFrom(InputStream inputStream) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$BotExInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$BotExInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$BotExInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$BotExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
