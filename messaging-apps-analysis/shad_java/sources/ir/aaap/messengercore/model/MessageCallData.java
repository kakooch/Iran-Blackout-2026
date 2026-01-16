package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class MessageCallData {
    public String call_id;
    public VoiceCallModels.CallType call_type;
    public DiscardReasonEnum discard_reason;
    public int duration;

    public enum DiscardReasonEnum {
        NotDiscarded,
        Missed,
        Disconnect,
        Hangup,
        Busy
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageCallData)) {
            return false;
        }
        MessageCallData messageCallData = (MessageCallData) obj;
        return this.duration == messageCallData.duration && Objects.equals(this.call_id, messageCallData.call_id) && this.discard_reason == messageCallData.discard_reason && this.call_type == messageCallData.call_type;
    }

    public int hashCode() {
        return Objects.hash(this.call_id, this.discard_reason, Integer.valueOf(this.duration), this.call_type);
    }
}
