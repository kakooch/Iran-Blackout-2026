package ir.resaneh1.iptv.model;

import android.app.Dialog;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.components.RubinoUsernameSpan;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.InstaPostObject;
import ir.resaneh1.iptv.model.InstaReportInput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.URLSpanNoUnderlineRubino;

/* loaded from: classes3.dex */
public class Rubino {
    public static Pattern urlPattern;

    public enum ActionOnRequestTypeEnum {
        Accept,
        Decline
    }

    public static class AddCommentOutput {
        public CommentFromServer comment;
    }

    public static class AddHighlightOutput {
        public StoryHighlight highlight;
    }

    public static class AddPostOutput {
        public PostObjectFromServer post;
    }

    public enum BlockActionEnum {
        Block,
        Unblock
    }

    public enum BookMarkActionEnum {
        Bookmark,
        Unbookmark
    }

    public static class CommentFromServer {
        public String content;
        public Long create_date;
        public RubinoCommentObject first_child_comment;
        public String full_profile_thumbnail_url;
        public String id;
        public int likes_count;
        public String parent_id;
        public String post_id;
        public String profile_id;
        public String profile_username;
        public int reply_count;
    }

    public static class CommentListObject {
        public ArrayList<RubinoCommentObject> commentObjects;
    }

    public static class CommentOutput {
        public RubinoCommentObject comment;
    }

    public static class CreateProfileInput {
        public String bio;
        public String email;
        public String name;
        public String phone;
        public RubinoProfileObject.ProfileStatusEnum profile_status;
        public String username;
        public String website;
    }

    public static class EditHighlightOutput {
        public StoryHighlight highlight;
    }

    public static class EditPostOutput {
        public PostObjectFromServer post;
    }

    public static class ExploreTopicObject {
        public String full_thumbnail_url;
        public boolean hasUserImage = false;
        public String id;
        public boolean is_main;
        public int order;
        public String topic;
    }

    public static class ExploreTopicsObject {
        public long lastUpdatedTime;
        public ArrayList<ExploreTopicObject> topics;
    }

    public enum FileTypeEnum {
        Picture,
        Video
    }

    public enum FollowActionTypeEnum {
        Follow,
        Unfollow
    }

    public enum FollowingTypeEnum {
        Follower,
        Following
    }

    public static class GetCommentsOutput {
        public ArrayList<CommentFromServer> comments;
        public Set<String> liked_comments;
    }

    public static class GetExploreTopicsOutput {
        public ArrayList<ExploreTopicObject> topics;
    }

    public static class GetFollowRequestsOutput {
        public ArrayList<NewEventFromServerObject> requests;
    }

    public static class GetHashtagListOutput {
        public ArrayList<HashtagObject> hash_tags;
    }

    public static class GetHighlightStoriesOutput {
        public ArrayList<StoryObject> stories;
    }

    public static class GetMyArchiveStoriesOutput {
        public boolean has_continue;
        public String next_start_id;
        public ArrayList<StoryObject> stories;
    }

    public static class GetNewEventsOutput {
        public ArrayList<NewEventFromServerObject> records;
    }

    public static class GetPostByShareLinkOutput {
        public boolean has_access;
        public PostObjectFromServer post;
        public RubinoProfileObject profile;
    }

    public static class GetPostShareLinkOutput {
        public String share_url;
    }

    public static class GetPostsOutput {
        public Set<String> bookmarked_posts;
        public boolean has_continue;
        public ArrayList<SplitPost> items;
        public Set<String> liked_posts;
        public String next_start_id;
        public ArrayList<PostObjectFromServer> posts;
        public Map<String, StoryController.ProfileStoryStatusEnum> profile_story_status;
    }

    public static class GetProfileForTagListOutput extends GetProfileListOutput {
        public ArrayList<String> enable_profile_ids;
    }

    public static class GetProfileHighlightsOutput {
        public ArrayList<StoryHighlight> highlights;
    }

    public static class GetProfileInfoOutput {
        public boolean has_live;
        public boolean has_profile_link_item;
        public boolean i_request;
        public boolean in_blocked_list;
        public boolean in_following_list;
        public RubinoProfileObject profile;
        public StoryController.ProfileStoryStatusEnum story_status;
    }

    public static class GetProfileLinkItemsOutput {
        public ArrayList<RubinoProfileLinkObject> link_items;
    }

    public static class GetProfileListOutput {
        public Set<String> following_list;
        public Set<String> i_blocked;
        public Set<String> i_request;
        public String next_start_id;
        public HashMap<String, Set<ProfilePermissionsEnum>> profile_permissions;
        public ArrayList<RubinoProfileObject> profiles;
    }

    public static class GetRelatedExplorePostsOutput {
        public boolean auto_scroll_enable;
        public Set<String> following_list;
        public String next_start_id;
        public Map<String, StoryController.ProfileStoryStatusEnum> profile_story_status;
        public ArrayList<PostObjectFromServer> related_posts;
        public PostObjectFromServer selected_post;
    }

    public static class HashtagListObject {
        public ArrayList<HashtagObject> hashtags;
    }

    public enum InputHighlightCoverType {
        Story,
        File
    }

    public static class IsExistUsernameOutput {
        public boolean exist = false;
        public RubinoProfileObject profile;
    }

    public enum LikeActionTypeEnum {
        Like,
        Unlike
    }

    public enum ModelEnum {
        Post,
        Comment,
        Profile
    }

    public static class NewEventFromServerObject {
        public String comment_id;
        public int count_owners;
        public Long create_date;
        public Set<String> following_list;
        public String full_post_thumbnail_url;
        public Set<String> i_request;
        public String id;
        public boolean is_new;
        public NotifEnum model;
        public ArrayList<RubinoProfileObject> owners;
        public Map<String, StoryController.ProfileStoryStatusEnum> owners_story_status;
        public String post_id;
        public String post_profile_id;
        public FileTypeEnum post_type;
        public int product_count;
        public String product_type;
        public String profile_id;
        public String request_id;
        public int sale_price;
    }

    public static class NewEventsListObject {
        public ArrayList<NewEventObject> events;
    }

    public enum NotifEnum {
        LikePost,
        LikeComment,
        CommentPost,
        CommentReply,
        Request,
        FollowingYou,
        YouFollowing,
        Sale,
        Purchase,
        TagPost
    }

    public static class PostObjectFromServer {
        public boolean allow_show_comment;
        public String caption;
        public long comment_count;
        public String count_sale_unread;
        public Long create_date;
        public long duration;
        public ArrayList<PostFileObject> file_list;
        public FileTypeEnum file_type;
        public String full_file_url;
        public String full_post_profile_thumbnail_url;
        public String full_snapshot_url;
        public String full_thumbnail_url;
        public int height;
        public String id;
        public boolean is_for_sale;
        public boolean is_multi_file;
        public long likes_count;
        public CommentFromServer most_liked_comment;
        public String post_profile_username;
        public String[] product_types;
        public String profile_id;
        public String profile_store_id;
        public int sale_price;
        public String share_url;
        public ShowType show_type;
        public int size;
        public String sponsored_text;
        public ArrayList<String> store_product_ids;
        public ArrayList<TagProfileObject> tagged_profiles;
        public int video_view_count;
        public int width;
    }

    public static class PostObjectList {
        public boolean hasContinue;
        public boolean isAutoScrollEnable;
        public String nextStartId;
        public ArrayList<RubinoPostObject> posts;
        public RubinoPostObject selectedPost;
        public ArrayList<SplitPost> sortedItems;
    }

    public static class ProfileListObject {
        public String nextStartId;
        public ArrayList<RubinoProfileObject> profiles;
    }

    public enum ProfilePermissionsEnum {
        AddPost,
        AddComment,
        AddStory,
        AddProfile,
        AddLive
    }

    public static class ProfilesStoriesListObject {
        public int liveProfileCount;
        public String next_start_id;
        public ArrayList<StoryListOfAProfileObject> profiles;
        public ArrayList<String> seen_profile_ids;
    }

    public static class RemoveRecordOutput {
        public int removed_count;
    }

    public static class SetPostProductsOutput {
        public PostObjectFromServer post;
    }

    public enum ShowType {
        IGTV
    }

    public enum SortEnum {
        FromMin,
        FromMax
    }

    public static class SplitPost {
        public int index;
        public ArrayList<RubinoProfileObject> suggested_profiles;
        public SplitPostTypeEnum type;
    }

    public enum SplitPostTypeEnum {
        SuggestedProfile
    }

    public static class StoryHighlight {
        public String avatar_url;
        public int current = 0;
        public String highlight_id;
        public String name;
    }

    public static class TagProfileObject {
        public int file_index;
        public GeneralPosition position;
        public String profile_id;
    }

    public static class BaseInput {
        public String profile_id;

        public BaseInput(String str) {
            this.profile_id = str;
        }
    }

    public static void addMentionAndHashtags(SpannableString spannableString) {
        try {
            if (urlPattern == null) {
                urlPattern = Pattern.compile("(^|\\s)/[a-zA-Z@\\d_]{1,255}|(^|\\s|[^a-zA-Z@\\d_])@[a-zA-Z\\d_]{1,32}|(^|\\s)#[\\w.]+|(^|\\s)\\$[A-Z]{3,8}([ ,.]|$)");
            }
            Matcher matcher = urlPattern.matcher(spannableString);
            while (matcher.find()) {
                int iStart = matcher.start();
                int iEnd = matcher.end();
                char cCharAt = spannableString.charAt(iStart);
                if (cCharAt != '@' && cCharAt != '#' && cCharAt != '/' && cCharAt != '$') {
                    iStart++;
                }
                URLSpanNoUnderlineRubino uRLSpanNoUnderlineRubino = null;
                if (spannableString.charAt(iStart) != '/') {
                    uRLSpanNoUnderlineRubino = new URLSpanNoUnderlineRubino(spannableString.subSequence(iStart, iEnd).toString());
                }
                if (uRLSpanNoUnderlineRubino != null) {
                    spannableString.setSpan(uRLSpanNoUnderlineRubino, iStart, iEnd, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean checkUserNameOrHashtagClick(TextView textView, float f, float f2) {
        boolean z;
        URLSpan[] uRLSpanArr;
        try {
            SpannableString spannableStringValueOf = textView.getText() instanceof SpannableStringBuilder ? SpannableString.valueOf(textView.getText()) : (SpannableString) textView.getText();
            if (spannableStringValueOf == null) {
                return false;
            }
            RubinoUsernameSpan[] rubinoUsernameSpanArr = (RubinoUsernameSpan[]) spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), RubinoUsernameSpan.class);
            if (rubinoUsernameSpanArr != null) {
                for (RubinoUsernameSpan rubinoUsernameSpan : rubinoUsernameSpanArr) {
                    int spanStart = spannableStringValueOf.getSpanStart(rubinoUsernameSpan);
                    int spanEnd = spannableStringValueOf.getSpanEnd(rubinoUsernameSpan);
                    Path path = new Path();
                    textView.getLayout().getSelectionPath(spanStart, spanEnd, path);
                    RectF rectF = new RectF();
                    path.computeBounds(rectF, false);
                    if (rectF.contains(f, f2)) {
                        new MainClickHandler().onInstaUsernameClicked(rubinoUsernameSpan.username);
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            if (!z && (uRLSpanArr = (URLSpan[]) spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), URLSpan.class)) != null) {
                for (URLSpan uRLSpan : uRLSpanArr) {
                    int spanStart2 = spannableStringValueOf.getSpanStart(uRLSpan);
                    int spanEnd2 = spannableStringValueOf.getSpanEnd(uRLSpan);
                    Path path2 = new Path();
                    textView.getLayout().getSelectionPath(spanStart2 + 1, spanEnd2, path2);
                    RectF rectF2 = new RectF();
                    path2.computeBounds(rectF2, false);
                    if (rectF2.contains(f, f2)) {
                        String url = uRLSpan.getURL();
                        if (url.startsWith("@")) {
                            new MainClickHandler().onInstaUsernameClicked(url);
                            return true;
                        }
                        if (!url.startsWith("#")) {
                            return true;
                        }
                        new MainClickHandler().onInstaHashTagClicked(url);
                        return true;
                    }
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static class GetProfileInfoInput extends BaseInput {
        public String target_profile_id;

        public GetProfileInfoInput(String str, String str2) {
            super(str);
            this.target_profile_id = str2;
        }

        public GetProfileInfoInput(String str) {
            super(str);
        }
    }

    public static class LikeActionInput extends BaseInput {
        public LikeActionTypeEnum action_type;
        public String comment_id;
        public String post_id;
        public String post_profile_id;

        public LikeActionInput(String str) {
            super(str);
        }
    }

    public static class ReportInput extends BaseInput {
        private String live_profile_id;
        public InstaReportInput.RecordModel model;
        public String post_id;
        public String post_profile_id;
        public int reason;
        public String record_id;
        public String story_profile_id;

        public enum RecordModel {
            Post,
            Comment,
            Profile,
            Story
        }

        public ReportInput(String str) {
            super(str);
            this.reason = 0;
        }

        public static InstaReportInput setForStory(String str, String str2) {
            InstaReportInput instaReportInput = new InstaReportInput();
            instaReportInput.model = InstaReportInput.RecordModel.Story;
            instaReportInput.record_id = str;
            instaReportInput.story_profile_id = str2;
            return instaReportInput;
        }

        public void setForProfile(String str, int i) {
            this.record_id = str;
            this.reason = i;
            this.model = InstaReportInput.RecordModel.Profile;
        }

        public void setForLive(String str, String str2, int i) {
            this.record_id = str;
            this.live_profile_id = str2;
            this.reason = i;
            this.model = InstaReportInput.RecordModel.Live;
        }

        public void setForPost(String str, String str2, int i) {
            this.record_id = str;
            this.post_profile_id = str2;
            this.reason = i;
            this.model = InstaReportInput.RecordModel.Post;
        }

        public void setForComment(String str, String str2, int i) {
            this.record_id = str;
            this.post_id = str2;
            this.reason = i;
            this.model = InstaReportInput.RecordModel.Comment;
        }
    }

    public static class BookmarkActionInput extends BaseInput {
        public BookMarkActionEnum action_type;
        public String post_id;
        public String post_profile_id;

        public BookmarkActionInput(String str) {
            super(str);
        }
    }

    public static class GetListInput extends BaseInput {
        public String comment_id;
        public String content;
        public boolean equal;
        public FollowingTypeEnum f_type;
        public String hashtag;
        public int limit;
        public String max_id;
        public String min_id;
        public String post_id;
        public RubinoPostPosition post_position;
        public String post_profile_id;
        public FollowingTypeEnum search_type;
        public SortEnum sort;
        public String start_id;
        public String target_profile_id;
        public String topic_id;
        public String user_id;
        public String username;

        public GetListInput(String str) {
            super(str);
            this.limit = 10;
            this.sort = SortEnum.FromMax;
        }
    }

    public static class PostFileObject {
        public int duration;
        public FileTypeEnum file_type;
        public String full_file_url;
        public String full_snapshot_url;

        public static PostFileObject createFromOld(InstaPostObject.InstaPostFileObject instaPostFileObject) {
            if (instaPostFileObject == null) {
                return null;
            }
            PostFileObject postFileObject = new PostFileObject();
            postFileObject.full_file_url = instaPostFileObject.full_file_url;
            postFileObject.full_snapshot_url = instaPostFileObject.full_snapshot_url;
            postFileObject.duration = instaPostFileObject.duration;
            postFileObject.file_type = instaPostFileObject.file_type == InstaPostObject.FileTypeEnum.Video ? FileTypeEnum.Video : FileTypeEnum.Picture;
            return postFileObject;
        }
    }

    public static class RequestFollowInput extends BaseInput {
        public FollowActionTypeEnum f_type;
        public String followee_id;

        public RequestFollowInput(String str) {
            super(str);
        }
    }

    public static class GetPostShareLinkInput extends BaseInput {
        public String post_id;
        public String post_profile_id;

        public GetPostShareLinkInput(String str) {
            super(str);
        }
    }

    public static class AlertItem {
        private int iconId;
        public View.OnClickListener onClickListener;
        public Dialog parentDialog;
        public String text;

        public AlertItem() {
        }

        public AlertItem(String str, int i, View.OnClickListener onClickListener) {
            this.text = str;
            this.iconId = i;
            this.onClickListener = onClickListener;
        }

        public int getIconId() {
            return this.iconId;
        }

        public String getText() {
            return this.text;
        }

        public View.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }
    }

    public static class AlertTextValueItem extends AlertItem {
        public String value;

        public AlertTextValueItem(String str, String str2) {
            this.text = str;
            this.value = str2;
        }
    }

    public static class AlertBlockItem extends AlertItem {
        public RubinoProfileObject profile;

        public AlertBlockItem(RubinoProfileObject rubinoProfileObject) {
            this.profile = rubinoProfileObject;
        }

        public AlertBlockItem(RubinoProfileObject rubinoProfileObject, Dialog dialog) {
            this.profile = rubinoProfileObject;
            this.parentDialog = dialog;
        }

        @Override // ir.resaneh1.iptv.model.Rubino.AlertItem
        public String getText() {
            return LocaleController.getString(RubinoController.getInstance(this.profile.currentAccount).isProfileBlocked(this.profile) ? R.string.rubinoUnBlock : R.string.rubinoBlock);
        }

        @Override // ir.resaneh1.iptv.model.Rubino.AlertItem
        public View.OnClickListener getOnClickListener() {
            if (this.onClickListener == null) {
                this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.Rubino.AlertBlockItem.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoController rubinoController = RubinoController.getInstance(AlertBlockItem.this.profile.currentAccount);
                        AlertBlockItem alertBlockItem = AlertBlockItem.this;
                        rubinoController.onBlockClick(alertBlockItem.profile, alertBlockItem.parentDialog);
                    }
                };
            }
            return this.onClickListener;
        }
    }

    public static class AlertUnFollowItem extends AlertItem {
        public RubinoProfileObject profile;

        public AlertUnFollowItem(RubinoProfileObject rubinoProfileObject) {
            this.profile = rubinoProfileObject;
        }

        public AlertUnFollowItem(RubinoProfileObject rubinoProfileObject, Dialog dialog) {
            this.profile = rubinoProfileObject;
            this.parentDialog = dialog;
        }

        @Override // ir.resaneh1.iptv.model.Rubino.AlertItem
        public String getText() {
            RubinoProfileObject rubinoProfileObject = this.profile;
            return LocaleController.getString((rubinoProfileObject == null || !RubinoController.getInstance(rubinoProfileObject.currentAccount).isProfileFollowRequested(this.profile)) ? R.string.rubinoUnfollow : R.string.rubinoCancelRequest);
        }

        @Override // ir.resaneh1.iptv.model.Rubino.AlertItem
        public View.OnClickListener getOnClickListener() {
            if (this.onClickListener == null) {
                this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.Rubino.AlertUnFollowItem.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoController rubinoController = RubinoController.getInstance(AlertUnFollowItem.this.profile.currentAccount);
                        AlertUnFollowItem alertUnFollowItem = AlertUnFollowItem.this;
                        rubinoController.unFollowClickWithDialogIfNeeded(alertUnFollowItem.profile, alertUnFollowItem.parentDialog);
                    }
                };
            }
            return this.onClickListener;
        }
    }

    public static class AlertBoldItem extends AlertItem {
        public AlertBoldItem(String str) {
            this.text = str;
        }
    }

    public static class BlockInput extends BaseInput {
        public BlockActionEnum action;
        public String blocked_id;

        public BlockInput(String str) {
            super(str);
        }
    }

    public static class RemoveRecordInput extends BaseInput {
        public ModelEnum model;
        public String post_id;
        public String record_id;

        public RemoveRecordInput(String str) {
            super(str);
        }

        public static RemoveRecordInput setInputForComment(String str, String str2, String str3) {
            RemoveRecordInput removeRecordInput = new RemoveRecordInput(str);
            removeRecordInput.record_id = str2;
            removeRecordInput.post_id = str3;
            removeRecordInput.model = ModelEnum.Comment;
            return removeRecordInput;
        }

        public static RemoveRecordInput setInputForProfile(String str, String str2) {
            RemoveRecordInput removeRecordInput = new RemoveRecordInput(str);
            removeRecordInput.record_id = str2;
            removeRecordInput.model = ModelEnum.Profile;
            return removeRecordInput;
        }

        public static RemoveRecordInput setInputForPost(String str, String str2) {
            RemoveRecordInput removeRecordInput = new RemoveRecordInput(str);
            removeRecordInput.record_id = str2;
            removeRecordInput.model = ModelEnum.Post;
            return removeRecordInput;
        }
    }

    public static class GetProfileByIdsInput extends BaseInput {
        public ArrayList<String> profile_ids;

        public GetProfileByIdsInput(String str) {
            super(str);
        }
    }

    public static class GetProfileForTagListInput extends BaseInput {
        public String search_text;

        public GetProfileForTagListInput(String str) {
            super(str);
        }
    }

    public static class EditPostInput extends BaseInput {
        public Boolean allow_show_comment;
        public String caption;
        public Boolean is_for_sale;
        public String post_id;
        public String[] product_types;
        public String sale_price;

        public EditPostInput(String str) {
            super(str);
        }
    }

    public static class NewEventObject {
        public NewEventFromServerObject event;
        public transient SpannableString spannableEvent;
        public transient SpannableString spannableTime;

        public void setAsEvent(NewEventFromServerObject newEventFromServerObject) {
            this.event = newEventFromServerObject;
            createSpannableEvent();
        }

        public void setAsRequest(NewEventFromServerObject newEventFromServerObject) {
            this.event = newEventFromServerObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void createSpannableEvent() {
            /*
                Method dump skipped, instructions count: 940
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.model.Rubino.NewEventObject.createSpannableEvent():void");
        }

        private String createSaleSentences(String str, NewEventFromServerObject newEventFromServerObject, String str2) {
            if (str2 == null || newEventFromServerObject == null || str == null) {
                return BuildConfig.FLAVOR;
            }
            if (isFarsi().booleanValue()) {
                String str3 = BuildConfig.FLAVOR + " " + str2 + " " + LocaleController.getString("event_your_sale", R.string.event_your_sale);
                if (newEventFromServerObject.product_type != null) {
                    str3 = str3 + LocaleController.getString("event_with_feature", R.string.event_with_feature) + " " + newEventFromServerObject.product_type + " ";
                }
                if (newEventFromServerObject.product_count > 0) {
                    str3 = str3 + LocaleController.getString("event_with_count", R.string.event_with_count) + NumberUtils.toPersian(newEventFromServerObject.product_count) + " ";
                }
                if (newEventFromServerObject.product_count > 1) {
                    str3 = str3 + LocaleController.getString("event_total_amount_of", R.string.event_total_amount_of);
                }
                return str3 + LocaleController.getString("event_amount", R.string.event_amount) + NumberUtils.toPersian(newEventFromServerObject.sale_price) + " " + LocaleController.getString("event_toman_payed", R.string.event_toman_payed) + " " + str;
            }
            String str4 = BuildConfig.FLAVOR + str2 + " " + str + " ";
            if (newEventFromServerObject.product_count > 1) {
                str4 = str4 + LocaleController.getString("event_total_amount_of", R.string.event_total_amount_of);
            }
            String str5 = str4 + " " + NumberUtils.toPersian(newEventFromServerObject.sale_price) + " " + LocaleController.getString("event_toman_payed", R.string.event_toman_payed) + " ";
            if (newEventFromServerObject.product_count > 0) {
                str5 = str5 + LocaleController.getString("event_with_count", R.string.event_with_count) + " " + NumberUtils.toPersian(newEventFromServerObject.product_count) + " ";
            }
            if (newEventFromServerObject.product_type != null) {
                str5 = str5 + LocaleController.getString("event_with_feature", R.string.event_with_feature) + " " + newEventFromServerObject.product_type;
            }
            return str5 + " " + LocaleController.getString("event_your_sale", R.string.event_your_sale);
        }

        private Boolean isFarsi() {
            return Boolean.valueOf(LocaleController.getInstance().getCurrentLocale().getLanguage().equals("fa"));
        }

        private String createSentences(String str, String str2, String str3) {
            if (str3 == null || str2 == null) {
                return BuildConfig.FLAVOR;
            }
            if (str == null) {
                return createSemiSentences(str2, str3);
            }
            if (isFarsi().booleanValue()) {
                return BuildConfig.FLAVOR + " " + str3 + " " + str2 + " " + str + ".";
            }
            return BuildConfig.FLAVOR + " " + str3 + " " + str + " " + str2 + ".";
        }

        private String createSemiSentences(String str, String str2) {
            if (isFarsi().booleanValue()) {
                return BuildConfig.FLAVOR + " " + str2 + " " + str + " .";
            }
            return BuildConfig.FLAVOR + " " + str + " " + str2 + ".";
        }

        public SpannableString getSpannableTime() {
            if (ApplicationLoader.applicationActivity == null) {
                return null;
            }
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.event.create_date.longValue() * 1000);
                SpannableString spannableStringMakeWithColorAndRelativeSize = SpanHelper.makeWithColorAndRelativeSize(" " + DateFormatUtils.getAgoTimeRubino(calendar.getTime()), Theme.getColor(Theme.key_rubinoGrayColor), 1.0f);
                this.spannableTime = spannableStringMakeWithColorAndRelativeSize;
                return spannableStringMakeWithColorAndRelativeSize;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class RemoveNotificationInput {
        public String notification_id;
        public String notification_profile_id;

        public RemoveNotificationInput(String str, String str2) {
            this.notification_id = str;
            this.notification_profile_id = str2;
        }
    }

    public static class ActionOnRequestInput extends BaseInput {
        public ActionOnRequestTypeEnum action;
        public String request_id;

        public ActionOnRequestInput(String str) {
            super(str);
        }
    }

    public static class GetPostByShareLinkInput extends BaseInput {
        public String share_string;

        public GetPostByShareLinkInput(String str, String str2) {
            super(str);
            this.share_string = str2;
        }
    }

    public static class AddCommentInput extends BaseInput {
        public String comment_id;
        public String content;
        public String post_id;
        public String post_profile_id;
        public int rnd;

        public AddCommentInput(String str) {
            super(str);
        }

        public void setForComment(String str, String str2, String str3, int i) {
            this.content = str;
            this.post_id = str2;
            this.post_profile_id = str3;
            this.rnd = i;
        }

        public void setForReply(String str, String str2, String str3, int i) {
            this.content = str;
            this.post_id = str2;
            this.comment_id = str3;
            this.rnd = i;
        }
    }

    public static class HashtagObject {
        public String content;
        public String full_post_thumbnail_url;
        public String id;
        public transient String postCountString;
        public int public_post_count;

        public void createPostCountString() {
            String str;
            if (this.public_post_count > 0) {
                str = NumberUtils.toCuteStringWithKOrMEnglish(this.public_post_count) + " " + LocaleController.getString(R.string.rubinoPostEn);
            } else {
                str = BuildConfig.FLAVOR;
            }
            this.postCountString = str;
        }
    }

    public static class IsExistUsernameInput {
        public String username;

        public IsExistUsernameInput(String str) {
            this.username = str;
        }
    }

    public static class AddPostViewCountInput {
        public String post_id;
        public String post_profile_id;

        public AddPostViewCountInput(String str, String str2) {
            this.post_id = str;
            this.post_profile_id = str2;
        }
    }

    public class GetEmojiResultsOutput {
        public ArrayList<EmojiSliderResultObject> emoji_slider_results;
        public String next_start_id;

        public GetEmojiResultsOutput() {
        }
    }

    public static class GeneralPosition {
        public float x;
        public float y;

        public GeneralPosition(float f, float f2) {
            this.x = f;
            this.y = f2;
        }
    }

    public static class AddPostInput extends BaseInput {
        public String caption;
        public String duration;
        public String file_id;
        public String hash_file_receive;
        public String height;
        public boolean is_multi_file;
        public List<PostTagObject> postTagObjects;
        public String post_type;
        public int rnd;
        public ShowType show_type;
        public String snapshot_file_id;
        public String snapshot_hash_file_receive;
        public ArrayList<TagProfileObject> tagged_profiles;
        public String thumbnail_file_id;
        public String thumbnail_hash_file_receive;
        public String width;

        public AddPostInput(String str) {
            super(str);
        }
    }

    public static class PublishPostInput extends BaseInput {
        public String post_id;

        public PublishPostInput(String str) {
            super(str);
        }
    }

    public static class AddFilePostInput extends BaseInput {
        public String duration;
        public String file_id;
        public FileTypeEnum file_type;
        public String hash_file_receive;
        public String post_id;
        public String snapshot_file_id;
        public String snapshot_hash_file_receive;

        public AddFilePostInput(String str) {
            super(str);
        }
    }

    public static class RubinoProfilePostId {
        public Set<String> post_ids = new HashSet();
        public String profile_id;

        public RubinoProfilePostId(String str) {
            this.profile_id = str;
        }
    }

    public static class GetProfilesPostListInput extends BaseInput {
        public Collection<RubinoProfilePostId> profile_post_ids;

        public GetProfilesPostListInput(String str) {
            super(str);
        }
    }

    public static class GetProfileLinkItemsInput extends BaseInput {
        public String target_profile_id;

        public GetProfileLinkItemsInput(String str, String str2) {
            super(str);
            this.target_profile_id = str2;
        }
    }

    public static class AddPostViewTimeInput extends BaseInput {
        public int duration;
        public String post_id;
        public String post_profile_id;

        public AddPostViewTimeInput(String str, String str2, String str3, int i) {
            super(str);
            this.post_id = str2;
            this.post_profile_id = str3;
            this.duration = i;
        }
    }

    public static class InputHighlightCover {
        public String highlight_file_id;
        public String highlight_hash_file_receive;
        public String story_id;
        public InputHighlightCoverType type;

        public InputHighlightCover(InputHighlightCoverType inputHighlightCoverType) {
            this.type = inputHighlightCoverType;
        }
    }

    public static class AddHighlightInput extends BaseInput {
        public InputHighlightCover highlight_cover;
        public String highlight_name;
        public ArrayList<String> story_ids;

        public AddHighlightInput(String str) {
            super(str);
        }
    }

    public static class EditHighlightInput extends BaseInput {
        public ArrayList<String> add_story_ids;
        public InputHighlightCover highlight_cover;
        public String highlight_id;
        public String highlight_name;
        public ArrayList<String> remove_story_ids;
        public ArrayList<String> updated_parameters;

        public EditHighlightInput(String str) {
            super(str);
        }
    }

    public static class HighlightStoryInput extends BaseInput {
        public String highlight_id;
        public String story_id;

        public HighlightStoryInput(String str) {
            super(str);
        }
    }

    public static class GetHighlightStoryIdsInput extends GetStoryIdsInput {
        public String highlight_id;

        public GetHighlightStoryIdsInput(String str, String str2, String str3) {
            super(str2, str);
            this.highlight_id = str3;
        }
    }

    public static class GetHighlightStoriesInput extends BaseInput {
        public String highlight_id;
        public ArrayList<String> story_ids;
        public String target_profile_id;

        public GetHighlightStoriesInput(String str) {
            super(str);
        }
    }

    public static class RemoveHighlightCollectionInput extends BaseInput {
        public String highlight_id;

        public RemoveHighlightCollectionInput(String str) {
            super(str);
        }
    }

    public static class SetPostProductsInput extends BaseInput {
        public String post_id;
        public ArrayList<String> product_ids;

        public SetPostProductsInput(String str) {
            super(str);
        }
    }
}
