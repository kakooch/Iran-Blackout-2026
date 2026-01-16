package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.GetGroupMessageReadParticipantsOutput;
import java.util.Map;

/* loaded from: classes3.dex */
public class GetGroupMessageReadParticipantsResult {
    public Map<String, ChatAbsObject> chatAbsObjectMap;
    public Map<String, Long> read_participants;
    public GetGroupMessageReadParticipantsOutput.StatusEnum status;
}
