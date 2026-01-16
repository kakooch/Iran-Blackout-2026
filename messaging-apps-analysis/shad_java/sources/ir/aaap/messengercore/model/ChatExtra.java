package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public class ChatExtra {
    public int local_count_unseen = ConnectionsManager.DEFAULT_DATACENTER_ID;
    public ChatMessage local_last_message;
    public long local_last_message_prev_message_id;
    public int local_last_message_send_state;
    public long local_last_seen_my_mid;
    public long local_time;
    public String object_guid;

    public ChatExtra(String str) {
        this.object_guid = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatExtra)) {
            return false;
        }
        ChatExtra chatExtra = (ChatExtra) obj;
        return this.local_last_seen_my_mid == chatExtra.local_last_seen_my_mid && this.local_count_unseen == chatExtra.local_count_unseen && Objects.equals(this.object_guid, chatExtra.object_guid) && Objects.equals(this.local_last_message, chatExtra.local_last_message) && Objects.equals(Long.valueOf(this.local_last_message_prev_message_id), Long.valueOf(chatExtra.local_last_message_prev_message_id)) && Objects.equals(Long.valueOf(this.local_time), Long.valueOf(chatExtra.local_time)) && Objects.equals(Integer.valueOf(this.local_last_message_send_state), Integer.valueOf(chatExtra.local_last_message_send_state)) && getClass().getDeclaredFields().length == 7;
    }

    public int hashCode() {
        return Objects.hash(this.object_guid, Long.valueOf(this.local_last_seen_my_mid), Integer.valueOf(this.local_count_unseen), this.local_last_message, Long.valueOf(this.local_last_message_prev_message_id), Long.valueOf(this.local_time));
    }
}
