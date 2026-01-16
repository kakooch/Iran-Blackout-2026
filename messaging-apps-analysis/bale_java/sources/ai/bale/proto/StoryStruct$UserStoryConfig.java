package ai.bale.proto;

import ai.bale.proto.StoryStruct$HiddenPeersConfig;
import ai.bale.proto.StoryStruct$IgnoredUnmutualContactsConfig;
import ai.bale.proto.StoryStruct$NotificationConfig;
import ai.bale.proto.StoryStruct$PopularStoryAttendanceConfig;
import ai.bale.proto.StoryStruct$PopularStoryChannelBlackListConfig;
import ai.bale.proto.StoryStruct$ReplyConfig;
import ai.bale.proto.StoryStruct$TagsConfig;
import ai.bale.proto.StoryStruct$TextStoryBackgroundsConfig;
import ai.bale.proto.StoryStruct$UserPrivacyConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.XU6;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$UserStoryConfig extends GeneratedMessageLite implements e2 {
    public static final int ATTENDANCE_CONFIG_FIELD_NUMBER = 18;
    private static final StoryStruct$UserStoryConfig DEFAULT_INSTANCE;
    public static final int HIDDEN_PEERS_CONFIG_FIELD_NUMBER = 19;
    public static final int IGNORED_UNMUTUAL_CONTACTS_CONFIG_FIELD_NUMBER = 14;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int NOTIFICATION_CONFIG_FIELD_NUMBER = 15;
    private static volatile KW4 PARSER = null;
    public static final int POPULAR_STORY_CHANNEL_BLACKLIST_CONFIG_FIELD_NUMBER = 17;
    public static final int PRIVACY_CONFIG_FIELD_NUMBER = 10;
    public static final int REPLY_CONFIG_FIELD_NUMBER = 11;
    public static final int TAGS_CONFIG_FIELD_NUMBER = 16;
    public static final int TEXT_STORY_BACKGROUND_CONFIG_FIELD_NUMBER = 13;
    private int key_;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements e2 {
        public a A(XU6 xu6) {
            q();
            ((StoryStruct$UserStoryConfig) this.b).setKey(xu6);
            return this;
        }

        public a B(StoryStruct$NotificationConfig storyStruct$NotificationConfig) {
            q();
            ((StoryStruct$UserStoryConfig) this.b).setNotificationConfig(storyStruct$NotificationConfig);
            return this;
        }

        private a() {
            super(StoryStruct$UserStoryConfig.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PRIVACY_CONFIG(10),
        REPLY_CONFIG(11),
        TEXT_STORY_BACKGROUND_CONFIG(13),
        IGNORED_UNMUTUAL_CONTACTS_CONFIG(14),
        NOTIFICATION_CONFIG(15),
        TAGS_CONFIG(16),
        POPULAR_STORY_CHANNEL_BLACKLIST_CONFIG(17),
        ATTENDANCE_CONFIG(18),
        HIDDEN_PEERS_CONFIG(19),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 10) {
                return PRIVACY_CONFIG;
            }
            if (i == 11) {
                return REPLY_CONFIG;
            }
            switch (i) {
                case 13:
                    return TEXT_STORY_BACKGROUND_CONFIG;
                case 14:
                    return IGNORED_UNMUTUAL_CONTACTS_CONFIG;
                case 15:
                    return NOTIFICATION_CONFIG;
                case 16:
                    return TAGS_CONFIG;
                case 17:
                    return POPULAR_STORY_CHANNEL_BLACKLIST_CONFIG;
                case 18:
                    return ATTENDANCE_CONFIG;
                case 19:
                    return HIDDEN_PEERS_CONFIG;
                default:
                    return null;
            }
        }
    }

    static {
        StoryStruct$UserStoryConfig storyStruct$UserStoryConfig = new StoryStruct$UserStoryConfig();
        DEFAULT_INSTANCE = storyStruct$UserStoryConfig;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$UserStoryConfig.class, storyStruct$UserStoryConfig);
    }

    private StoryStruct$UserStoryConfig() {
    }

    private void clearAttendanceConfig() {
        if (this.traitCase_ == 18) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearHiddenPeersConfig() {
        if (this.traitCase_ == 19) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearIgnoredUnmutualContactsConfig() {
        if (this.traitCase_ == 14) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearKey() {
        this.key_ = 0;
    }

    private void clearNotificationConfig() {
        if (this.traitCase_ == 15) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPopularStoryChannelBlacklistConfig() {
        if (this.traitCase_ == 17) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPrivacyConfig() {
        if (this.traitCase_ == 10) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearReplyConfig() {
        if (this.traitCase_ == 11) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTagsConfig() {
        if (this.traitCase_ == 16) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTextStoryBackgroundConfig() {
        if (this.traitCase_ == 13) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static StoryStruct$UserStoryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAttendanceConfig(StoryStruct$PopularStoryAttendanceConfig storyStruct$PopularStoryAttendanceConfig) {
        storyStruct$PopularStoryAttendanceConfig.getClass();
        if (this.traitCase_ != 18 || this.trait_ == StoryStruct$PopularStoryAttendanceConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$PopularStoryAttendanceConfig;
        } else {
            this.trait_ = ((StoryStruct$PopularStoryAttendanceConfig.a) StoryStruct$PopularStoryAttendanceConfig.newBuilder((StoryStruct$PopularStoryAttendanceConfig) this.trait_).v(storyStruct$PopularStoryAttendanceConfig)).j();
        }
        this.traitCase_ = 18;
    }

    private void mergeHiddenPeersConfig(StoryStruct$HiddenPeersConfig storyStruct$HiddenPeersConfig) {
        storyStruct$HiddenPeersConfig.getClass();
        if (this.traitCase_ != 19 || this.trait_ == StoryStruct$HiddenPeersConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$HiddenPeersConfig;
        } else {
            this.trait_ = ((StoryStruct$HiddenPeersConfig.a) StoryStruct$HiddenPeersConfig.newBuilder((StoryStruct$HiddenPeersConfig) this.trait_).v(storyStruct$HiddenPeersConfig)).j();
        }
        this.traitCase_ = 19;
    }

    private void mergeIgnoredUnmutualContactsConfig(StoryStruct$IgnoredUnmutualContactsConfig storyStruct$IgnoredUnmutualContactsConfig) {
        storyStruct$IgnoredUnmutualContactsConfig.getClass();
        if (this.traitCase_ != 14 || this.trait_ == StoryStruct$IgnoredUnmutualContactsConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$IgnoredUnmutualContactsConfig;
        } else {
            this.trait_ = ((StoryStruct$IgnoredUnmutualContactsConfig.a) StoryStruct$IgnoredUnmutualContactsConfig.newBuilder((StoryStruct$IgnoredUnmutualContactsConfig) this.trait_).v(storyStruct$IgnoredUnmutualContactsConfig)).j();
        }
        this.traitCase_ = 14;
    }

    private void mergeNotificationConfig(StoryStruct$NotificationConfig storyStruct$NotificationConfig) {
        storyStruct$NotificationConfig.getClass();
        if (this.traitCase_ != 15 || this.trait_ == StoryStruct$NotificationConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$NotificationConfig;
        } else {
            this.trait_ = ((StoryStruct$NotificationConfig.a) StoryStruct$NotificationConfig.newBuilder((StoryStruct$NotificationConfig) this.trait_).v(storyStruct$NotificationConfig)).j();
        }
        this.traitCase_ = 15;
    }

    private void mergePopularStoryChannelBlacklistConfig(StoryStruct$PopularStoryChannelBlackListConfig storyStruct$PopularStoryChannelBlackListConfig) {
        storyStruct$PopularStoryChannelBlackListConfig.getClass();
        if (this.traitCase_ != 17 || this.trait_ == StoryStruct$PopularStoryChannelBlackListConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$PopularStoryChannelBlackListConfig;
        } else {
            this.trait_ = ((StoryStruct$PopularStoryChannelBlackListConfig.a) StoryStruct$PopularStoryChannelBlackListConfig.newBuilder((StoryStruct$PopularStoryChannelBlackListConfig) this.trait_).v(storyStruct$PopularStoryChannelBlackListConfig)).j();
        }
        this.traitCase_ = 17;
    }

    private void mergePrivacyConfig(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        if (this.traitCase_ != 10 || this.trait_ == StoryStruct$UserPrivacyConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$UserPrivacyConfig;
        } else {
            this.trait_ = ((StoryStruct$UserPrivacyConfig.a) StoryStruct$UserPrivacyConfig.newBuilder((StoryStruct$UserPrivacyConfig) this.trait_).v(storyStruct$UserPrivacyConfig)).j();
        }
        this.traitCase_ = 10;
    }

    private void mergeReplyConfig(StoryStruct$ReplyConfig storyStruct$ReplyConfig) {
        storyStruct$ReplyConfig.getClass();
        if (this.traitCase_ != 11 || this.trait_ == StoryStruct$ReplyConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$ReplyConfig;
        } else {
            this.trait_ = ((StoryStruct$ReplyConfig.a) StoryStruct$ReplyConfig.newBuilder((StoryStruct$ReplyConfig) this.trait_).v(storyStruct$ReplyConfig)).j();
        }
        this.traitCase_ = 11;
    }

    private void mergeTagsConfig(StoryStruct$TagsConfig storyStruct$TagsConfig) {
        storyStruct$TagsConfig.getClass();
        if (this.traitCase_ != 16 || this.trait_ == StoryStruct$TagsConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$TagsConfig;
        } else {
            this.trait_ = ((StoryStruct$TagsConfig.a) StoryStruct$TagsConfig.newBuilder((StoryStruct$TagsConfig) this.trait_).v(storyStruct$TagsConfig)).j();
        }
        this.traitCase_ = 16;
    }

    private void mergeTextStoryBackgroundConfig(StoryStruct$TextStoryBackgroundsConfig storyStruct$TextStoryBackgroundsConfig) {
        storyStruct$TextStoryBackgroundsConfig.getClass();
        if (this.traitCase_ != 13 || this.trait_ == StoryStruct$TextStoryBackgroundsConfig.getDefaultInstance()) {
            this.trait_ = storyStruct$TextStoryBackgroundsConfig;
        } else {
            this.trait_ = ((StoryStruct$TextStoryBackgroundsConfig.a) StoryStruct$TextStoryBackgroundsConfig.newBuilder((StoryStruct$TextStoryBackgroundsConfig) this.trait_).v(storyStruct$TextStoryBackgroundsConfig)).j();
        }
        this.traitCase_ = 13;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$UserStoryConfig parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$UserStoryConfig parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAttendanceConfig(StoryStruct$PopularStoryAttendanceConfig storyStruct$PopularStoryAttendanceConfig) {
        storyStruct$PopularStoryAttendanceConfig.getClass();
        this.trait_ = storyStruct$PopularStoryAttendanceConfig;
        this.traitCase_ = 18;
    }

    private void setHiddenPeersConfig(StoryStruct$HiddenPeersConfig storyStruct$HiddenPeersConfig) {
        storyStruct$HiddenPeersConfig.getClass();
        this.trait_ = storyStruct$HiddenPeersConfig;
        this.traitCase_ = 19;
    }

    private void setIgnoredUnmutualContactsConfig(StoryStruct$IgnoredUnmutualContactsConfig storyStruct$IgnoredUnmutualContactsConfig) {
        storyStruct$IgnoredUnmutualContactsConfig.getClass();
        this.trait_ = storyStruct$IgnoredUnmutualContactsConfig;
        this.traitCase_ = 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKey(XU6 xu6) {
        this.key_ = xu6.getNumber();
    }

    private void setKeyValue(int i) {
        this.key_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNotificationConfig(StoryStruct$NotificationConfig storyStruct$NotificationConfig) {
        storyStruct$NotificationConfig.getClass();
        this.trait_ = storyStruct$NotificationConfig;
        this.traitCase_ = 15;
    }

    private void setPopularStoryChannelBlacklistConfig(StoryStruct$PopularStoryChannelBlackListConfig storyStruct$PopularStoryChannelBlackListConfig) {
        storyStruct$PopularStoryChannelBlackListConfig.getClass();
        this.trait_ = storyStruct$PopularStoryChannelBlackListConfig;
        this.traitCase_ = 17;
    }

    private void setPrivacyConfig(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig) {
        storyStruct$UserPrivacyConfig.getClass();
        this.trait_ = storyStruct$UserPrivacyConfig;
        this.traitCase_ = 10;
    }

    private void setReplyConfig(StoryStruct$ReplyConfig storyStruct$ReplyConfig) {
        storyStruct$ReplyConfig.getClass();
        this.trait_ = storyStruct$ReplyConfig;
        this.traitCase_ = 11;
    }

    private void setTagsConfig(StoryStruct$TagsConfig storyStruct$TagsConfig) {
        storyStruct$TagsConfig.getClass();
        this.trait_ = storyStruct$TagsConfig;
        this.traitCase_ = 16;
    }

    private void setTextStoryBackgroundConfig(StoryStruct$TextStoryBackgroundsConfig storyStruct$TextStoryBackgroundsConfig) {
        storyStruct$TextStoryBackgroundsConfig.getClass();
        this.trait_ = storyStruct$TextStoryBackgroundsConfig;
        this.traitCase_ = 13;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$UserStoryConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0001\u0000\u0001\u0013\n\u0000\u0000\u0000\u0001\f\n<\u0000\u000b<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000", new Object[]{"trait_", "traitCase_", "key_", StoryStruct$UserPrivacyConfig.class, StoryStruct$ReplyConfig.class, StoryStruct$TextStoryBackgroundsConfig.class, StoryStruct$IgnoredUnmutualContactsConfig.class, StoryStruct$NotificationConfig.class, StoryStruct$TagsConfig.class, StoryStruct$PopularStoryChannelBlackListConfig.class, StoryStruct$PopularStoryAttendanceConfig.class, StoryStruct$HiddenPeersConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$UserStoryConfig.class) {
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

    public StoryStruct$PopularStoryAttendanceConfig getAttendanceConfig() {
        return this.traitCase_ == 18 ? (StoryStruct$PopularStoryAttendanceConfig) this.trait_ : StoryStruct$PopularStoryAttendanceConfig.getDefaultInstance();
    }

    public StoryStruct$HiddenPeersConfig getHiddenPeersConfig() {
        return this.traitCase_ == 19 ? (StoryStruct$HiddenPeersConfig) this.trait_ : StoryStruct$HiddenPeersConfig.getDefaultInstance();
    }

    public StoryStruct$IgnoredUnmutualContactsConfig getIgnoredUnmutualContactsConfig() {
        return this.traitCase_ == 14 ? (StoryStruct$IgnoredUnmutualContactsConfig) this.trait_ : StoryStruct$IgnoredUnmutualContactsConfig.getDefaultInstance();
    }

    public XU6 getKey() {
        XU6 xu6J = XU6.j(this.key_);
        return xu6J == null ? XU6.UNRECOGNIZED : xu6J;
    }

    public int getKeyValue() {
        return this.key_;
    }

    public StoryStruct$NotificationConfig getNotificationConfig() {
        return this.traitCase_ == 15 ? (StoryStruct$NotificationConfig) this.trait_ : StoryStruct$NotificationConfig.getDefaultInstance();
    }

    public StoryStruct$PopularStoryChannelBlackListConfig getPopularStoryChannelBlacklistConfig() {
        return this.traitCase_ == 17 ? (StoryStruct$PopularStoryChannelBlackListConfig) this.trait_ : StoryStruct$PopularStoryChannelBlackListConfig.getDefaultInstance();
    }

    public StoryStruct$UserPrivacyConfig getPrivacyConfig() {
        return this.traitCase_ == 10 ? (StoryStruct$UserPrivacyConfig) this.trait_ : StoryStruct$UserPrivacyConfig.getDefaultInstance();
    }

    public StoryStruct$ReplyConfig getReplyConfig() {
        return this.traitCase_ == 11 ? (StoryStruct$ReplyConfig) this.trait_ : StoryStruct$ReplyConfig.getDefaultInstance();
    }

    public StoryStruct$TagsConfig getTagsConfig() {
        return this.traitCase_ == 16 ? (StoryStruct$TagsConfig) this.trait_ : StoryStruct$TagsConfig.getDefaultInstance();
    }

    public StoryStruct$TextStoryBackgroundsConfig getTextStoryBackgroundConfig() {
        return this.traitCase_ == 13 ? (StoryStruct$TextStoryBackgroundsConfig) this.trait_ : StoryStruct$TextStoryBackgroundsConfig.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasAttendanceConfig() {
        return this.traitCase_ == 18;
    }

    public boolean hasHiddenPeersConfig() {
        return this.traitCase_ == 19;
    }

    public boolean hasIgnoredUnmutualContactsConfig() {
        return this.traitCase_ == 14;
    }

    public boolean hasNotificationConfig() {
        return this.traitCase_ == 15;
    }

    public boolean hasPopularStoryChannelBlacklistConfig() {
        return this.traitCase_ == 17;
    }

    public boolean hasPrivacyConfig() {
        return this.traitCase_ == 10;
    }

    public boolean hasReplyConfig() {
        return this.traitCase_ == 11;
    }

    public boolean hasTagsConfig() {
        return this.traitCase_ == 16;
    }

    public boolean hasTextStoryBackgroundConfig() {
        return this.traitCase_ == 13;
    }

    public static a newBuilder(StoryStruct$UserStoryConfig storyStruct$UserStoryConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$UserStoryConfig);
    }

    public static StoryStruct$UserStoryConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$UserStoryConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$UserStoryConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$UserStoryConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$UserStoryConfig parseFrom(byte[] bArr) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$UserStoryConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$UserStoryConfig parseFrom(InputStream inputStream) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$UserStoryConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$UserStoryConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$UserStoryConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$UserStoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
