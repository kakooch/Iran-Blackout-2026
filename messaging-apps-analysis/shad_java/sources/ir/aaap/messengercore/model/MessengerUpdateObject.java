package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.VoiceCallModels;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MessengerUpdateObject {
    public ArrayList<VoiceCallModels.CallSignalDataObject> call_signal_data;
    public ArrayList<VoiceCallModels.CallUpdateObject> call_updates;
    public ArrayList<ChatUpdateObject> chat_updates;
    public ArrayList<NotificationModels.EditNotificationObject> edit_notifications;
    public ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> group_voice_chat_participant_updates;
    public ArrayList<GroupCallModels.GroupVoiceChatUpdate> group_voice_chat_updates;
    public ArrayList<LiveModels.LiveUpdate> live_updates;
    public ArrayList<MessageUpdateObject> message_updates;
    public Mode mode;
    public ArrayList<NotificationModels.RemoveNotificationObject> remove_notifications;
    public ArrayList<ShowActivityObject> show_activities;
    public ArrayList<NotificationModels.ShowNotificationObject> show_notifications;
    public String user_guid;

    public enum Mode {
        Normal,
        Silent
    }
}
