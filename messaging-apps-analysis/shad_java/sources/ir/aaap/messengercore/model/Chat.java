package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class Chat {
    public HashSet<ChatAccessEnum> access;
    public ChatExtra chatExtra;
    public ChatParamUpdateTimeObject chatParamUpdateTimeObject;
    public KeyPadObject chat_keypad;
    public int count_unseen;
    public int group_my_last_send_time;
    public String group_voice_chat_id;
    public boolean isLastMessageLocal;
    public boolean is_blocked;
    public boolean is_in_contact;
    public boolean is_mute;
    public boolean is_pinned;
    public ChatMessage lastMessage;
    public long lastMessageId;
    public long lastMessageTime;
    public long lastSeenMyMid;
    public long last_deleted_mid;
    public ChatMessage last_message;
    public long last_message_id;
    public long last_seen_my_mid;
    public long last_seen_peer_mid;
    public String object_guid;
    public long pinned_message_id;
    public ArrayList<Long> pinned_message_ids;
    public boolean show_ask_spam;
    public int slow_mode_duration;
    public ChatStatusEnum status;
    public long time;
    public String timeString;
    public String time_string;

    public enum ChatAccessEnum {
        ChangeInfo,
        ViewInfo,
        ViewMembers,
        ViewAdmins,
        PinMessages,
        SendMessages,
        EditAllMessages,
        DeleteGlobalAllMessages,
        AddMember,
        BanMember,
        SetAdmin,
        SetJoinLink,
        RemoveObject,
        SetMemberAccess,
        ViewMessages,
        DeleteLocalMessages,
        EditMyMessages,
        DeleteGlobalMyMessages,
        SuperAdmin,
        AcceptOwner
    }

    public enum ChatStatusEnum {
        Active,
        ObjRemoved,
        NoAccess,
        Stopped,
        NotExist
    }

    public enum EnumSetChannelAdminAccess {
        ChangeInfo,
        ViewMembers,
        ViewAdmins,
        PinMessages,
        SendMessages,
        EditAllMessages,
        DeleteGlobalAllMessages,
        AddMember,
        SetJoinLink,
        SetAdmin
    }

    public enum EnumSetGroupAdminAccess {
        ChangeInfo,
        PinMessages,
        DeleteGlobalAllMessages,
        BanMember,
        SetAdmin,
        SetJoinLink,
        SetMemberAccess
    }

    public enum EnumSetGroupMemberAccess {
        ViewMembers,
        ViewAdmins,
        SendMessages,
        AddMember
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        return this.count_unseen == chat.count_unseen && this.is_mute == chat.is_mute && this.is_pinned == chat.is_pinned && this.last_seen_my_mid == chat.last_seen_my_mid && this.last_seen_peer_mid == chat.last_seen_peer_mid && this.last_deleted_mid == chat.last_deleted_mid && this.time == chat.time && this.pinned_message_id == chat.pinned_message_id && this.is_blocked == chat.is_blocked && this.last_message_id == chat.last_message_id && this.is_in_contact == chat.is_in_contact && this.slow_mode_duration == chat.slow_mode_duration && this.group_my_last_send_time == chat.group_my_last_send_time && this.lastSeenMyMid == chat.lastSeenMyMid && this.isLastMessageLocal == chat.isLastMessageLocal && Objects.equals(this.object_guid, chat.object_guid) && Objects.equals(this.access, chat.access) && Objects.equals(this.time_string, chat.time_string) && Objects.equals(this.last_message, chat.last_message) && this.status == chat.status && Objects.equals(this.chat_keypad, chat.chat_keypad) && Objects.equals(this.chatExtra, chat.chatExtra) && Objects.equals(this.chatParamUpdateTimeObject, chat.chatParamUpdateTimeObject) && getClass().getDeclaredFields().length == 22;
    }

    public long getUpdateTimestamp() {
        ChatParamUpdateTimeObject chatParamUpdateTimeObject = this.chatParamUpdateTimeObject;
        if (chatParamUpdateTimeObject != null) {
            return chatParamUpdateTimeObject.update_timestamp;
        }
        return 0L;
    }

    public long getUpdateTimestamp(ChatParamUpdateTimeObject.Params params) {
        ChatParamUpdateTimeObject chatParamUpdateTimeObject = this.chatParamUpdateTimeObject;
        if (chatParamUpdateTimeObject != null) {
            return chatParamUpdateTimeObject.getLastUpdateTimestamp(params);
        }
        return 0L;
    }

    public void setParamUpdateTime(ChatParamUpdateTimeObject.Params params, long j) {
        if (this.chatParamUpdateTimeObject == null) {
            this.chatParamUpdateTimeObject = new ChatParamUpdateTimeObject();
        }
        this.chatParamUpdateTimeObject.setParamUpdateTimestamp(params, j);
    }

    public void setUpdateTimestamp(long j) {
        if (this.chatParamUpdateTimeObject == null) {
            this.chatParamUpdateTimeObject = new ChatParamUpdateTimeObject();
        }
        this.chatParamUpdateTimeObject.update_timestamp = j;
    }

    public void fillAttributes() {
        ChatExtra chatExtra = this.chatExtra;
        if (chatExtra != null) {
            this.lastSeenMyMid = Math.max(this.last_seen_my_mid, chatExtra.local_last_seen_my_mid);
        } else {
            this.lastSeenMyMid = this.last_seen_my_mid;
        }
        long j = this.last_message_id;
        if (j == this.last_seen_my_mid) {
            this.count_unseen = 0;
            ChatExtra chatExtra2 = this.chatExtra;
            if (chatExtra2 != null) {
                chatExtra2.local_count_unseen = 0;
            }
        }
        this.isLastMessageLocal = false;
        ChatExtra chatExtra3 = this.chatExtra;
        if (chatExtra3 != null && chatExtra3.local_last_message != null && chatExtra3.local_last_message_prev_message_id >= j) {
            this.isLastMessageLocal = true;
        }
        if (this.isLastMessageLocal) {
            long j2 = chatExtra3.local_time;
            this.lastMessageTime = j2;
            ChatMessage chatMessage = chatExtra3.local_last_message;
            this.lastMessage = chatMessage;
            long j3 = chatMessage.message_id;
            this.lastMessageId = j3;
            this.timeString = createTimeString(j2, j3);
            return;
        }
        this.lastMessageTime = this.time;
        this.lastMessage = this.last_message;
        this.lastMessageId = j;
        this.timeString = this.time_string;
    }

    public static String createTimeString(long j, long j2) {
        StringBuilder sb = new StringBuilder("000000000000000000000000000000");
        String str = j + BuildConfig.FLAVOR;
        sb.replace(0, str.length(), str);
        String str2 = Math.abs(j2) + BuildConfig.FLAVOR;
        sb.replace(30 - str2.length(), 30, str2);
        return sb.toString();
    }

    public boolean isLastSeenNotSent() {
        ChatExtra chatExtra = this.chatExtra;
        return chatExtra != null && chatExtra.local_last_seen_my_mid > this.last_seen_my_mid;
    }

    public static Chat createFromServerObject(ChatFromServer chatFromServer, long j) {
        Chat chat = new Chat();
        chat.object_guid = chatFromServer.object_guid;
        chat.access = chatFromServer.access;
        chat.count_unseen = chatFromServer.count_unseen;
        chat.is_mute = chatFromServer.is_mute;
        chat.is_pinned = chatFromServer.is_pinned;
        chat.last_seen_my_mid = chatFromServer.last_seen_my_mid;
        chat.last_seen_peer_mid = chatFromServer.last_seen_peer_mid;
        chat.last_deleted_mid = chatFromServer.last_deleted_mid;
        chat.time = chatFromServer.time;
        chat.pinned_message_id = chatFromServer.pinned_message_id;
        chat.pinned_message_ids = chatFromServer.pinned_message_ids;
        chat.is_blocked = chatFromServer.is_blocked;
        chat.last_message_id = chatFromServer.last_message_id;
        chat.slow_mode_duration = chatFromServer.slow_mode_duration;
        chat.group_my_last_send_time = chatFromServer.group_my_last_send_time;
        chat.is_in_contact = chatFromServer.is_in_contact;
        chat.time_string = chatFromServer.time_string;
        chat.last_message = chatFromServer.last_message;
        chat.status = chatFromServer.status;
        chat.chat_keypad = chatFromServer.chat_keypad;
        chat.group_voice_chat_id = chatFromServer.group_voice_chat_id;
        chat.show_ask_spam = chatFromServer.show_ask_spam;
        chat.setUpdateTimestamp(j);
        chat.fillAttributes();
        return chat;
    }
}
