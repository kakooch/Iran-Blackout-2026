package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class ChatFromServer {
    public ChatAbsObject abs_object;
    public HashSet<Chat.ChatAccessEnum> access;
    public KeyPadObject chat_keypad;
    public int count_unseen;
    public long create_time;
    public int group_my_last_send_time;
    public String group_voice_chat_id;
    public boolean is_blocked;
    public boolean is_in_contact;
    public boolean is_mute;
    public boolean is_pinned;
    public long last_deleted_mid;
    public ChatMessage last_message;
    public long last_message_id;
    public long last_seen_my_mid;
    public long last_seen_peer_mid;
    public String object_guid;
    public int offset_count_seen;
    public long pinned_message_id;
    public ArrayList<Long> pinned_message_ids;
    public boolean show_ask_spam;
    public int slow_mode_duration;
    public Chat.ChatStatusEnum status;
    public long time;
    public String time_string;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatFromServer)) {
            return false;
        }
        ChatFromServer chatFromServer = (ChatFromServer) obj;
        return this.count_unseen == chatFromServer.count_unseen && this.is_mute == chatFromServer.is_mute && this.is_pinned == chatFromServer.is_pinned && this.last_seen_my_mid == chatFromServer.last_seen_my_mid && this.last_seen_peer_mid == chatFromServer.last_seen_peer_mid && this.last_deleted_mid == chatFromServer.last_deleted_mid && this.time == chatFromServer.time && this.pinned_message_id == chatFromServer.pinned_message_id && this.create_time == chatFromServer.create_time && this.is_blocked == chatFromServer.is_blocked && this.last_message_id == chatFromServer.last_message_id && this.offset_count_seen == chatFromServer.offset_count_seen && this.slow_mode_duration == chatFromServer.slow_mode_duration && this.group_my_last_send_time == chatFromServer.group_my_last_send_time && this.is_in_contact == chatFromServer.is_in_contact && Objects.equals(this.object_guid, chatFromServer.object_guid) && Objects.equals(this.access, chatFromServer.access) && Objects.equals(this.time_string, chatFromServer.time_string) && Objects.equals(this.last_message, chatFromServer.last_message) && this.status == chatFromServer.status && Objects.equals(this.abs_object, chatFromServer.abs_object) && Objects.equals(this.chat_keypad, chatFromServer.chat_keypad) && Objects.equals(this.group_voice_chat_id, chatFromServer.group_voice_chat_id) && Objects.equals(Boolean.valueOf(this.show_ask_spam), Boolean.valueOf(chatFromServer.show_ask_spam)) && getClass().getDeclaredFields().length == 24;
    }
}
