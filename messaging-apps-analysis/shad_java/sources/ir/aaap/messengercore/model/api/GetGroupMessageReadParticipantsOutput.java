package ir.aaap.messengercore.model.api;

import java.util.Map;

/* loaded from: classes3.dex */
public class GetGroupMessageReadParticipantsOutput {
    public Map<String, Long> read_participants;
    public StatusEnum status;

    public enum StatusEnum {
        OK,
        TooMembers,
        OldMessage
    }
}
