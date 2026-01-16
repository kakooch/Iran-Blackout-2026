package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;
import java.util.EnumMap;

/* loaded from: classes3.dex */
public class ChatParamUpdateTimeObject {
    EnumMap<Params, Long> updatedParamsTimeMap = new EnumMap<>(Params.class);
    public long update_timestamp = 0;

    public enum Params {
        object_guid,
        access,
        count_unseen,
        is_mute,
        is_pinned,
        time_string,
        last_message,
        last_seen_my_mid,
        last_seen_peer_mid,
        status,
        abs_object,
        time,
        pinned_message_id,
        pinned_message_ids,
        is_blocked,
        last_message_id,
        last_deleted_mid,
        chat_keypad,
        slow_mode_duration,
        group_my_last_send_time,
        keypad_options,
        group_voice_chat_id,
        show_ask_spam
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatParamUpdateTimeObject)) {
            return false;
        }
        ChatParamUpdateTimeObject chatParamUpdateTimeObject = (ChatParamUpdateTimeObject) obj;
        if (this.update_timestamp == chatParamUpdateTimeObject.update_timestamp) {
            EnumMap<Params, Long> enumMap = this.updatedParamsTimeMap;
            if (enumMap == null && chatParamUpdateTimeObject.updatedParamsTimeMap == null) {
                return true;
            }
            if (enumMap != null && chatParamUpdateTimeObject.updatedParamsTimeMap != null && enumMap.size() == chatParamUpdateTimeObject.updatedParamsTimeMap.size()) {
                for (K k : this.updatedParamsTimeMap.keySet()) {
                    if (!Objects.equals(this.updatedParamsTimeMap.get(k), chatParamUpdateTimeObject.updatedParamsTimeMap.get(k))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void setParamUpdateTimestamp(Params params, long j) {
        if (this.updatedParamsTimeMap != null) {
            this.updatedParamsTimeMap = new EnumMap<>(Params.class);
        }
        this.updatedParamsTimeMap.put((EnumMap<Params, Long>) params, (Params) Long.valueOf(j));
    }

    public long getLastUpdateTimestamp(Params params) {
        Long l;
        EnumMap<Params, Long> enumMap = this.updatedParamsTimeMap;
        if (enumMap == null || (l = enumMap.get(params)) == null) {
            return 0L;
        }
        return l.longValue();
    }
}
