package ir.aaap.messengercore.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LiveModels {

    public static class AddLiveCommentInput {
        public String access_token;
        public String live_id;
        public String text;
    }

    public static class AddLiveCommentOutput {
        public LiveCommentObjectFromServer live_comment;
    }

    public enum DeviceTypeEnum {
        Mobile,
        Software
    }

    public enum EnumParams {
        allow_comment
    }

    public static class GetLiveCommentsInput {
        public String access_token;
        public String live_id;
        public String start_id;
    }

    public static class GetLiveCommentsOutput {
        public boolean has_continue;
        public ArrayList<LiveCommentObjectFromServer> live_comments;
        public String next_start_id;
    }

    public static class GetLivePlayUrlInput {
        public String access_token;
        public String live_id;
    }

    public static class GetLivePlayUrlOutput {
        public boolean is_owner;
        public LiveStatus live_status;
        public PlayTypeEnum play_type;
        public String play_url;
    }

    public static class GetLivePlayUrlResult {
        public boolean can_play;
        public boolean is_owner;
        public PlayTypeEnum play_type;
        public String play_url;
    }

    public static class GetLiveStatusInput {
        public String access_token;
        public String live_id;
        public GetLiveStatusType type;
    }

    public static class GetLiveStatusOutput {
        public boolean is_blocked;
        public LiveStatus live_status;
    }

    public enum GetLiveStatusType {
        LiveViewer,
        MessageStat
    }

    public static class GetLiveViewersInput {
        public String live_id;
        public String start_id;
        public GetLiveViewersType type;
    }

    public static class GetLiveViewersOutput {
        public ArrayList<ChatAbsObject> abs_objects;
        public boolean has_continue;
        public String next_start_id;
    }

    public enum GetLiveViewersType {
        VOD,
        Live
    }

    public static class LastLiveState {
        public boolean isExternalPublish;
        public String live_id;
        public String publishText;
        public String streamURl;
        public long timestamp;
    }

    public static class LiveCommentObjectFromServer {
        public String comment_id;
        public ChatAbsObject comment_user_info;
        public String full_profile_thumbnail_url;
        public String profile_id;
        public String profile_username;
        public String text;
    }

    public static class LiveMessage {
        public String access_token;
        public String live_id;
        public LiveStatus live_status;
        public String thumb_inline;
        public String title;
    }

    public static class LiveStatus {
        public boolean allow_comment;
        public boolean can_play;
        public int duration;
        public boolean isBlocked;
        public int play_count;
        public LiveStatusEnum status;
    }

    public enum LiveStatusEnum {
        InProgress,
        Finish,
        Ready,
        Unsuccessful
    }

    public static class LiveUpdate {
        public String live_id;
        public LiveStatus live_status;
    }

    public enum PlayTypeEnum {
        Live,
        VOD
    }

    public static class RubinoAddLiveCommentInput {
        public String live_id;
        public String live_profile_id;
        public String profile_id;
        public String text;
    }

    public static class RubinoGetLiveCommentsInput {
        public String live_id;
        public String live_profile_id;
        public String profile_id;
        public String start_id;
    }

    public static class RubinoGetLiveInfoOutput {
        public boolean is_live_exist;
        public boolean is_owner;
        public String live_id;
        public LiveStatus live_status;
        public PlayTypeEnum play_type = PlayTypeEnum.Live;
        public String play_url;
    }

    public static class RubinoGetLiveInfolInput {
        public String live_profile_id;
        public String profile_id;
    }

    public static class RubinoGetLiveStatusInput {
        public String access_token;
        public String live_id;
        public String live_profile_id;
        public String profile_id;
    }

    public static class RubinoGetLiveStatusOutput {
        public boolean is_blocked;
        public LiveStatus live_status;
    }

    public static class RubinoLastLiveState {
        public boolean isExternalPublish;
        public String live_id;
        public String profile_id;
        public String publishText;
        public String streamURl;
        public long timestamp;
    }

    public static class RubinoSendLiveInput {
        public DeviceTypeEnum device_type;
        public String profile_id;
        public int rnd;
        public String title;
    }

    public static class RubinoSendLiveOutput {
        public String live_id;
        public String publish_text;
        public String publish_url;
    }

    public static class RubinoSetLiveSettingInput {
        public boolean allow_comment;
        public String live_id;
        public String profile_id;
        public ArrayList<EnumParams> updated_parameters;
    }

    public static class RubinoSetLiveSettingOutput {
        public LiveStatus live_status;
    }

    public static class RubinoStopLiveInput {
        public String live_id;
        public String profile_id;
    }

    public static class RubinoStopLiveOutput {
        public LiveStatus live_status;
    }

    public static class SendLiveInput {
        public DeviceTypeEnum device_type;
        public String object_guid;
        public long rnd;
        public String thumb_inline;
        public String title;
    }

    public static class SendLiveOutput {
        public ChatUpdateObject chat_update;
        public MessageUpdateObject message_update;
        public String publish_text;
        public String publish_url;
        public Status status;
    }

    public static class SendLiveResult {
        public Message liveMessage;
        public String publish_text;
        public String publish_url;
        public Status status;
    }

    public static class SetLiveSettingInput {
        public boolean allow_comment;
        public String live_id;
        public ArrayList<EnumParams> updated_parameters;
    }

    public static class SetLiveSettingOutput {
        public LiveStatus live_status;
    }

    public enum Status {
        OK,
        Repeated
    }

    public static class StopLiveInput {
        public String live_id;
    }

    public static class StopLiveOutput {
        public LiveStatus live_status;
    }

    public static class CommentLiveHintObject {
        public String text;

        public CommentLiveHintObject(String str) {
            this.text = str;
        }
    }
}
