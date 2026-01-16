package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum XU6 implements B.c {
    UserConfigKey_Unknown(0),
    UserConfigKey_ExcludePrivacy(1),
    UserConfigKey_IncludePrivacy(2),
    UserConfigKey_HasReply(3),
    UserConfigKey_TextStoryBackgrounds(5),
    UserConfigKey_IgnoredUnmutualContacts(6),
    UserConfigKey_ContactsStoryNotification(7),
    UserConfigKey_ChannelStoryNotification(8),
    UserConfigKey_LikeStoryNotification(9),
    UserConfigKey_Tags(10),
    UserConfigKey_PopularStoryChannelBlackList(11),
    UserConfigKey_PopularStoryAttendance(12),
    UserConfigKey_HiddenPeers(14),
    UNRECOGNIZED(-1);

    private static final B.d p = new B.d() { // from class: ir.nasim.XU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public XU6 a(int i) {
            return XU6.j(i);
        }
    };
    private final int a;

    XU6(int i) {
        this.a = i;
    }

    public static XU6 j(int i) {
        switch (i) {
            case 0:
                return UserConfigKey_Unknown;
            case 1:
                return UserConfigKey_ExcludePrivacy;
            case 2:
                return UserConfigKey_IncludePrivacy;
            case 3:
                return UserConfigKey_HasReply;
            case 4:
            case 13:
            default:
                return null;
            case 5:
                return UserConfigKey_TextStoryBackgrounds;
            case 6:
                return UserConfigKey_IgnoredUnmutualContacts;
            case 7:
                return UserConfigKey_ContactsStoryNotification;
            case 8:
                return UserConfigKey_ChannelStoryNotification;
            case 9:
                return UserConfigKey_LikeStoryNotification;
            case 10:
                return UserConfigKey_Tags;
            case 11:
                return UserConfigKey_PopularStoryChannelBlackList;
            case 12:
                return UserConfigKey_PopularStoryAttendance;
            case 14:
                return UserConfigKey_HiddenPeers;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
