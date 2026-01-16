package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.model.OnlineTimeObject;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class UserInfo {
    public String bio;
    public boolean can_receive_call;
    public boolean can_video_call;
    public long count_common_groups;
    public long insertedToDbTime;
    public OnlineTimeObject online_time;
    public String phone;
    public long timeStamp;
    public String user_guid;
    public String username;
    public WarningObject warning_info;

    public static UserInfo createFromServerObject(UserInfoFromServer userInfoFromServer, long j, long j2, boolean z, boolean z2) {
        UserInfo userInfo = new UserInfo();
        userInfo.user_guid = userInfoFromServer.user_guid;
        userInfo.phone = userInfoFromServer.phone;
        userInfo.username = userInfoFromServer.username;
        userInfo.bio = userInfoFromServer.bio;
        userInfo.count_common_groups = j2;
        userInfo.warning_info = userInfoFromServer.warning_info;
        userInfo.can_receive_call = z;
        userInfo.can_video_call = z2;
        userInfo.online_time = userInfoFromServer.online_time;
        userInfo.timeStamp = j;
        return userInfo;
    }

    public static UserInfo updateFromMemberObject(UserInfo userInfo, InChatMemberFromServer inChatMemberFromServer, long j) {
        if (userInfo != null && inChatMemberFromServer != null && userInfo.user_guid.equals(inChatMemberFromServer.member_guid) && j > userInfo.timeStamp) {
            OnlineTimeObject onlineTimeObject = inChatMemberFromServer.online_time;
            if (onlineTimeObject != null) {
                userInfo.online_time = onlineTimeObject;
            }
            userInfo.username = inChatMemberFromServer.username;
            userInfo.count_common_groups = inChatMemberFromServer.count_common_groups;
        }
        return userInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return this.count_common_groups == userInfo.count_common_groups && this.can_receive_call == userInfo.can_receive_call && this.can_video_call == userInfo.can_video_call && this.timeStamp == userInfo.timeStamp && Objects.equals(this.user_guid, userInfo.user_guid) && Objects.equals(this.phone, userInfo.phone) && Objects.equals(this.username, userInfo.username) && Objects.equals(this.bio, userInfo.bio) && Objects.equals(this.warning_info, userInfo.warning_info) && Objects.equals(this.online_time, userInfo.online_time) && getClass().getDeclaredFields().length == 11;
    }

    public int hashCode() {
        return Objects.hash(this.user_guid, this.phone, this.username, this.bio, Long.valueOf(this.count_common_groups), this.warning_info, Boolean.valueOf(this.can_receive_call), Boolean.valueOf(this.can_video_call), this.online_time, Long.valueOf(this.timeStamp));
    }

    public static String getNameForSort(ChatAbsObject chatAbsObject) {
        return getNameForSort(chatAbsObject, true);
    }

    public static long getLastOnlineForSort(UserInfo userInfo, long j) {
        OnlineTimeObject onlineTimeObject = userInfo.online_time;
        if (onlineTimeObject != null) {
            OnlineTimeObject.Type type = onlineTimeObject.type;
            if (type == OnlineTimeObject.Type.Exact) {
                long j2 = onlineTimeObject.exact_time;
                if (j2 < j) {
                    return 0L;
                }
                return j2;
            }
            if (type == OnlineTimeObject.Type.Approximate) {
                OnlineTimeObject.ApproximatePeriodEnum approximatePeriodEnum = onlineTimeObject.approximate_period;
                if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.LongAgo) {
                    return 1L;
                }
                if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.MonthAgo) {
                    return 2L;
                }
                if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.WeekAgo) {
                    return 3L;
                }
                if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.Recently) {
                    return 4L;
                }
            }
        }
        return 0L;
    }

    public static String getNameForSort(ChatAbsObject chatAbsObject, boolean z) {
        if (chatAbsObject == null) {
            return BuildConfig.FLAVOR;
        }
        String str = chatAbsObject.first_name;
        if (!CoreUtilities.isNotEmpty(str)) {
            str = chatAbsObject.last_name;
        } else if (!z && str.length() <= 2) {
            return formatName(chatAbsObject.first_name, chatAbsObject.last_name);
        }
        return CoreUtilities.isNotEmpty(str) ? str : BuildConfig.FLAVOR;
    }

    public static String formatName(String str, String str2) {
        return formatName(str, str2, 0);
    }

    public static String formatName(String str, String str2, int i) {
        if (str != null) {
            str = str.trim();
        }
        if (str2 != null) {
            str2 = str2.trim();
        }
        StringBuilder sb = new StringBuilder((str != null ? str.length() : 0) + (str2 != null ? str2.length() : 0) + 1);
        if (str != null && str.length() > 0) {
            if (i > 0 && str.length() > i + 2) {
                return str.substring(0, i);
            }
            sb.append(str);
            if (str2 != null && str2.length() > 0) {
                sb.append(" ");
                if (i > 0 && sb.length() + str2.length() > i) {
                    sb.append(str2.charAt(0));
                } else {
                    sb.append(str2);
                }
            }
        } else if (str2 != null && str2.length() > 0) {
            if (i > 0 && str2.length() > i + 2) {
                return str2.substring(0, i);
            }
            sb.append(str2);
        }
        return sb.toString();
    }
}
