package ir.aaap.messengercore.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class GroupCallModels {

    public static class CreateGroupVoiceChatInput {
        public String chat_guid;
        public int rnd;
        public int version = 1;
    }

    public static class CreateGroupVoiceChatOutput {
        public ChatUpdateObject chat_update;
        public GroupVoiceChat exist_group_voice_chat;
        public GroupVoiceChatUpdate group_voice_chat_update;
        public MessageUpdateObject message_update;
        public StatusCreateGroupVoice status;
    }

    public static class DiscardGroupVoiceChatInput {
        public String chat_guid;
        public String voice_chat_id;
    }

    public static class DiscardGroupVoiceChatOutput {
        public ChatUpdateObject chat_update;
        public GroupVoiceChatUpdate group_voice_chat_update;
        public MessageUpdateObject message_update;
    }

    public static class DisplayAsGroupVoiceChat {
        public AvatarFileInline avatar_thumbnail;
        public int count_members;
        public boolean is_verified;
        public String object_guid;
        public String title;
        public ChatType type;
    }

    public static class GetDisplayAsInGroupVoiceChatInput {
        public String chat_guid;
        public String start_id;
        public String voice_chat_id;
    }

    public static class GetDisplayAsInGroupVoiceChatOutput {
        public ArrayList<DisplayAsGroupVoiceChat> display_as_object_guids;
        public boolean has_continue;
        public String next_start_id;
    }

    public static class GetGroupVoiceChatInput {
        public String chat_guid;
        public String voice_chat_id;
    }

    public static class GetGroupVoiceChatOutput {
        public GroupVoiceChat group_voice_chat;
        public boolean is_exist;
    }

    public static class GetGroupVoiceChatParticipantsByObjectGuidsInput {
        public String chat_guid;
        public Set<String> object_guids;
        public String voice_chat_id;
    }

    public static class GetGroupVoiceChatParticipantsByObjectGuidsOutput {
        public ArrayList<GroupVoiceChatParticipant> group_voice_chat_participants;
        public Status status;
        public long timestamp;
    }

    public static class GetGroupVoiceChatParticipantsInput {
        public String chat_guid;
        public String start_id;
        public String voice_chat_id;
    }

    public static class GetGroupVoiceChatParticipantsOutput {
        public boolean has_continue;
        public String next_start_id;
        public ArrayList<GroupVoiceChatParticipant> participants;
        public String state;
        public Status status;
        public long timestamp;
    }

    public static class GetGroupVoiceChatUpdatesInput {
        public String chat_guid;
        public String state;
        public String voice_chat_id;
    }

    public static class GetGroupVoiceChatUpdatesOutput {
        public GroupVoiceChat group_voice_chat;
        public ArrayList<GroupVoiceChatParticipantUpdate> group_voice_chat_participant_updates;
        public boolean is_joined;
        public String new_state;
        public GetGroupVoiceChatUpdatesStatus status;
        public long timestamp;
    }

    public static class GetGroupVoiceChatUpdatesResult {
        public boolean is_joined;
        public String new_state;
        public GetGroupVoiceChatUpdatesStatus status;
    }

    public enum GetGroupVoiceChatUpdatesStatus {
        OK,
        VoiceChatNotExist,
        OldState
    }

    public static class GroupVoiceChat {
        public boolean join_muted;
        public int participant_count;
        public StateGroupVoiceChat state;
        public String title;
        public String voice_chat_id;
    }

    public static class GroupVoiceChatParticipantUpdate {
        public GroupVoiceChatParticipantUpdateAction action;
        public ObjectGuidType chat_guid_type;
        public GroupVoiceChatParticipant group_voice_chat_participant;
        public ObjectGuidType participant_object_guid_type;
        public int timestamp;
        public Set<String> updated_parameters;
        public String voice_chat_id;
    }

    public enum GroupVoiceChatParticipantUpdateAction {
        New,
        Edit,
        Delete
    }

    public enum GroupVoiceChatParticipantUpdateParameter {
        voice_chat_id,
        is_mute,
        can_self_unmute,
        join_date,
        can_manage_voice_chat,
        active_date,
        request_speak
    }

    public static class GroupVoiceChatUpdate {
        public GroupVoiceChatUpdateAction action;
        public ObjectGuidType chat_guid_type;
        public GroupVoiceChat group_voice_chat;
        public long timestamp;
        public Set<String> updated_parameters;
        public String voice_chat_id;
    }

    public enum GroupVoiceChatUpdateAction {
        New,
        Edit,
        Delete
    }

    public enum GroupVoiceChatUpdateParameter {
        state,
        join_muted,
        participant_count,
        title
    }

    public static class JoinGroupVoiceChatInput {
        public String chat_guid;
        public String sdp_offer_data;
        public String self_object_guid;
        public String voice_chat_id;
    }

    public static class JoinGroupVoiceChatOutput {
        public ArrayList<ObjectGuidType> deleted_participant_object_guid_types;
        public GroupVoiceChatParticipantUpdate group_voice_chat_participate_update;
        public GroupVoiceChatUpdate group_voice_chat_update;
        public String sdp_answer_data;
        public Status status;
    }

    public static class LeaveGroupVoiceChatInput {
        public String chat_guid;
        public String voice_chat_id;
    }

    public static class LeaveGroupVoiceChatOutput {
        public GroupVoiceChatUpdate group_voice_chat_update;
    }

    public enum SendGroupVoiceChatActivityEnum {
        Speaking
    }

    public static class SendGroupVoiceChatActivityInput {
        public SendGroupVoiceChatActivityEnum activity;
        public String chat_guid;
        public String voice_chat_id;
    }

    public static class SendGroupVoiceChatActivityOutput {
        public Status status;
    }

    public static class SetGroupVoiceChatSettingInput {
        public String chat_guid;
        public boolean join_muted;
        public String title;
        public Set<SettingsEnumParams> updated_parameters = new HashSet();
        public String voice_chat_id;
    }

    public static class SetGroupVoiceChatSettingOutput {
        public GroupVoiceChatUpdate group_voice_chat_update;
        public Status status;
    }

    public enum SetGroupVoiceChatStateActionEnum {
        Mute,
        RequestSpeak,
        CancelRequestSpeak,
        Unmute
    }

    public static class SetGroupVoiceChatStateInput {
        public SetGroupVoiceChatStateActionEnum action;
        public String chat_guid;
        public String participant_object_guid;
        public String voice_chat_id;
    }

    public static class SetGroupVoiceChatStateOutput {
        public GroupVoiceChatParticipantUpdate group_voice_chat_participate_update;
        public SetGroupVoiceChatStateStatusEnum status;
    }

    public enum SetGroupVoiceChatStateStatusEnum {
        OK,
        VoiceChatNotExist,
        NotJoined
    }

    public enum SettingsEnumParams {
        join_muted,
        title
    }

    public enum StateGroupVoiceChat {
        Running,
        Discarded
    }

    public enum Status {
        OK,
        VoiceChatNotExist
    }

    public enum StatusCreateGroupVoice {
        Done,
        VoiceChatExist,
        Repeated
    }

    public static class GroupVoiceChatParticipant {
        public String about;
        public int active_date;
        public float amplitude;
        public boolean can_manage_voice_chat;
        public boolean can_self_unmute;
        public boolean hasVoice;
        public boolean hasVoiceDelayed;
        public boolean is_mute;
        public int join_date;
        public long lastActiveDate;
        public long lastRaiseHandDate;
        public long lastSpeakTime;
        public int lastTypingDate;
        public long lastVisibleDate;
        public long lastVoiceUpdateTime;
        public ObjectGuidType participant_object_guid_type;
        public long request_speak;
        public String voice_chat_id;
        public long allTimeStamp = 0;
        public EnumMap<GroupVoiceChatParticipantUpdateParameter, Long> updatedParamsTimeMap = new EnumMap<>(GroupVoiceChatParticipantUpdateParameter.class);

        public long getUpdateParamTimeStamp(GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter) {
            Long l = this.updatedParamsTimeMap.get(groupVoiceChatParticipantUpdateParameter);
            if (l == null) {
                return this.allTimeStamp;
            }
            if (this.allTimeStamp > l.longValue()) {
                return this.allTimeStamp;
            }
            return l.longValue();
        }

        public void setUpdateParamTimeStamp(GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter, long j) {
            if (groupVoiceChatParticipantUpdateParameter == null) {
                return;
            }
            this.updatedParamsTimeMap.put((EnumMap<GroupVoiceChatParticipantUpdateParameter, Long>) groupVoiceChatParticipantUpdateParameter, (GroupVoiceChatParticipantUpdateParameter) Long.valueOf(j));
        }
    }

    public class InviteToGroupVoiceChatInput {
        public String chat_guid;
        public String invite_object_guid;
        public String voice_chat_id;

        public InviteToGroupVoiceChatInput() {
        }
    }

    public class InviteToGroupVoiceChatOutput {
        public ChatUpdateObject chatUpdateObject;
        public MessageUpdateObject message_update;
        public Status status;

        public InviteToGroupVoiceChatOutput() {
        }
    }
}
