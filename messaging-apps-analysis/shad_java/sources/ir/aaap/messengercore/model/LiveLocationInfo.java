package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class LiveLocationInfo {
    public String chatGuid;
    public ChatType chatType;
    public long messageId;
    public Message messageObject;
    public int periodSecond;
    public int stopTimeSecond;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LiveLocationInfo liveLocationInfo = (LiveLocationInfo) obj;
        return this.messageId == liveLocationInfo.messageId && this.chatGuid.equals(liveLocationInfo.chatGuid) && this.chatType == liveLocationInfo.chatType;
    }
}
