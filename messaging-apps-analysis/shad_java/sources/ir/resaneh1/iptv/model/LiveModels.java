package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import android.util.Base64;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.model.FileInlineObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.rbmain.messenger.FileLog;

/* loaded from: classes3.dex */
public class LiveModels {

    public static class AddLiveCommentInput {
        public String access_token;
        public String live_id;
        public String text;
    }

    public static class AddLiveCommentOutput {
        public LiveCommentObject live_comment;
    }

    public enum DeviceTypeEnum {
        Mobile,
        Software
    }

    public enum EnumParams {
        allow_comment
    }

    public static class GetLiveCommnetsInput {
        public String access_token;
        public String live_id;
        public String start_id;
    }

    public static class GetLiveCommnetsOutput {
        public boolean has_continue;
        public ArrayList<LiveCommentObject> live_comments;
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
        public Type type;

        public enum Type {
            VOD,
            Live
        }
    }

    public static class GetLiveViewersOutput {
        public ArrayList<ChatAbsObject> abs_objects;
        public boolean has_continue;
        public String next_start_id;
    }

    public static class LastLiveState {
        public boolean isExternalPublish;
        public String live_id;
        public String publishText;
        public String streamURl;
        public long timestamp;
    }

    public static class LiveStatus {
        public boolean allow_comment;
        public boolean can_play;
        public int duration;
        public boolean isBlocked;
        public int play_count;
        public LiveStatusEnum status;

        public enum LiveStatusEnum {
            InProgress,
            Finish,
            Ready,
            Unsuccessful
        }
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

    public static class RubinoGetLiveCommnetsInput {
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

    public static class RubinoGetLiveViewersInput {
        public String live_id;
        public String profile_id;
        public String start_id;
    }

    public static class RubinoGetLiveViewersOutput {
        public boolean has_continue;
        public String next_start_id;
        public ArrayList<RubinoProfileObject> profiles;
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
        public int rnd;
        public String thumb_inline;
        public String title;
    }

    public static class SendLiveOutput {
        public MessageUpdateObject chat_update;
        public MessageUpdateObject message_update;
        public String publish_text;
        public String publish_url;
        public Status status;

        public enum Status {
            OK,
            Repeated
        }
    }

    public static class SetLiveSettingInput {
        public boolean allow_comment;
        public String live_id;
        public ArrayList<EnumParams> updated_parameters;
    }

    public static class SetLiveSettingOutput {
        public LiveStatus live_status;
    }

    public static class StopLiveInput {
        public String live_id;
    }

    public static class StopLiveOutput {
        public LiveStatus live_status;
    }

    public static class LiveMessage {
        public String access_token;
        public String live_id;
        public LiveStatus live_status;
        public String thumb_inline;
        public String title;

        public File getThumbnailFile() {
            return new File(StorageHelper.getThumbDirectory(), "live_" + this.live_id + ".jpg");
        }

        public FileInlineObject getThumbnailFileInline() {
            FileInlineObject fileInlineObject = new FileInlineObject();
            fileInlineObject.type = FileInlineObject.FileInlineType.Image;
            fileInlineObject.local_attach_path = getThumbnailFile().getPath();
            fileInlineObject.customid = "thumb_live" + this.live_id;
            return fileInlineObject;
        }

        public void saveThumbnail() throws IOException {
            String str = this.thumb_inline;
            if (str == null || str.isEmpty()) {
                return;
            }
            File thumbnailFile = getThumbnailFile();
            if (thumbnailFile.exists()) {
                return;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(thumbnailFile, "rws");
                randomAccessFile.write(Base64.decode(this.thumb_inline, 0));
                randomAccessFile.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static class LiveCommentObject extends PresenterItem {
        public String comment_id;
        public ChatAbsObject comment_user_info;
        public String full_profile_thumbnail_url;
        public String profile_id;
        public String profile_username;
        public String text;

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public String getId() {
            return this.comment_id;
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public PresenterItemType getPresenterType() {
            return PresenterItemType.liveComment;
        }

        public SpannableString getSpannableString() {
            String str = this.profile_username;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            return SpanHelper.makeBoldAndRelativeSize(new SpannableString(str + " \n" + this.text), 0, str.length(), 1.1f);
        }
    }

    public static class CommentLiveHintObject extends PresenterItem {
        public String text;

        public CommentLiveHintObject(String str) {
            this.text = str;
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public PresenterItemType getPresenterType() {
            return PresenterItemType.liveCommentHint;
        }
    }
}
