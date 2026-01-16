package ir.aaap.messengercore.model;

import java.util.EnumMap;

/* loaded from: classes3.dex */
public class MessageParamUpdateTimeObject {
    EnumMap<UpdateParameterEnum, Long> updatedParamsTimeMap = new EnumMap<>(UpdateParameterEnum.class);
    public long update_timestamp = 0;

    public enum UpdateParameterEnum {
        text,
        type,
        inline_keypad,
        metadata,
        is_edited,
        message_call,
        is_banned
    }

    public void setParamUpdateTimestamp(UpdateParameterEnum updateParameterEnum, long j) {
        if (this.updatedParamsTimeMap != null) {
            this.updatedParamsTimeMap = new EnumMap<>(UpdateParameterEnum.class);
        }
        this.updatedParamsTimeMap.put((EnumMap<UpdateParameterEnum, Long>) updateParameterEnum, (UpdateParameterEnum) Long.valueOf(j));
    }

    public long getLastUpdateTimestamp(UpdateParameterEnum updateParameterEnum) {
        Long l;
        EnumMap<UpdateParameterEnum, Long> enumMap = this.updatedParamsTimeMap;
        if (enumMap == null || (l = enumMap.get(updateParameterEnum)) == null) {
            return 0L;
        }
        return l.longValue();
    }
}
