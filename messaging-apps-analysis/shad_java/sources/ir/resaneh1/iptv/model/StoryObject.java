package ir.resaneh1.iptv.model;

import android.graphics.Bitmap;
import android.text.SpannableString;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.GLSceneState;
import ir.appp.rghapp.RGHFilter;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.resaneh1.iptv.fragment.AddStoryFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.StoryEntityView;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes3.dex */
public class StoryObject extends PresenterItem {
    public String backgroundImagePath;
    public long create_date;
    private transient int currentAccount;
    public int darkColor;
    public long duration;
    public transient WidgetStoryObject emojiSliderWidget;
    public transient ArrayList<StoryEntityView> entityArray;
    public transient StoryEntityView.EntityViewAttr entityViewAttr;
    public String fileId;
    public transient Bitmap filteredBitmap;
    public String full_file_url;
    public String full_snapshot_url;
    public String full_thumbnail_url;
    public transient GLSceneState glSceneState;
    public String hashFileReceive;
    public String id;
    public transient boolean isFailed;
    public transient boolean isLocal;
    public transient boolean isPreLoadVideoOrImageCalled;
    public transient boolean isProgressStoppedToLoad;
    public Bitmap lastOverlay;
    public int lightColor;
    public String localFilePathAfterSave;
    public String localFilePathBeforeSave;
    public String localProfileId;
    public transient Bitmap overlay;
    public transient ArrayList<AddStoryFragment.FrameLayoutPaint.MyPath> paintPaths;
    public transient PhotoViewerObject playerInfoObject;
    public transient WidgetStoryObject pollWidget;
    public String profile_id;
    public transient RGHFilter rghFilter;
    public transient RGHFilter rghFilterToSave;
    public transient int rnd;
    public double saveProgress;
    public double sendProgressMain;
    public double sendProgressSnapshot;
    public double sendProgressThumbnail;
    public transient SendingStateEnum sendingState;
    public String snapshotFileId;
    public String snapshotHashFileReceive;
    public StoryTypeEnum story_type;
    public String thuFileId;
    public String thuHashFileReceive;
    public transient VideoEditedInfo videoEditedInfo;
    public int viewer_count;
    public float w_h_ratio;
    public ArrayList<WidgetStoryObject> widget_story_list;

    public enum SendingStateEnum {
        init,
        saving,
        uploadingMainFile,
        uploadThumbnail,
        uploadSnapShot,
        addStoryInProgress
    }

    public enum StoryTypeEnum {
        Picture,
        Video
    }

    public boolean hasClickableWidget() {
        ArrayList<WidgetStoryObject> arrayList = this.widget_story_list;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean hasNeedToUpdateWidget() {
        if (hasClickableWidget()) {
            return (this.emojiSliderWidget == null && this.pollWidget == null) ? false : true;
        }
        return false;
    }

    public String getSeenCountString() {
        Integer num = StoryController.getInstance(this.currentAccount).storySeenCountMap.get(this.id);
        if (num == null) {
            num = num;
        }
        return NumberUtils.toCuteStringWithKOrMEnglish((num.intValue() >= 0 ? num : 0).intValue());
    }

    public SpannableString getCreatedTimeSpannable() {
        if (this.create_date > 0) {
            return new SpannableString(LocaleController.formatStoryTimeDuration(this.create_date));
        }
        return new SpannableString(BuildConfig.FLAVOR);
    }

    public double getProgress() {
        double d;
        double d2;
        MyLog.e("StoryObject", "getProgress " + this.saveProgress + " " + this.sendProgressThumbnail + " " + this.sendProgressMain + BuildConfig.FLAVOR);
        SendingStateEnum sendingStateEnum = this.sendingState;
        if (sendingStateEnum == null || sendingStateEnum == SendingStateEnum.init) {
            return 0.0d;
        }
        if (sendingStateEnum == SendingStateEnum.saving) {
            return this.saveProgress / 2.0d;
        }
        if (sendingStateEnum == SendingStateEnum.uploadingMainFile) {
            d = 0.5d;
            d2 = this.sendProgressMain * 0.4000000059604645d;
        } else {
            if (this.story_type == StoryTypeEnum.Video) {
                if (sendingStateEnum == SendingStateEnum.uploadThumbnail) {
                    return (this.sendProgressThumbnail / 20.0d) + 0.9d;
                }
                if (sendingStateEnum == SendingStateEnum.uploadSnapShot) {
                    d = 0.95d;
                    d2 = this.sendProgressSnapshot / 20.0d;
                }
            } else if (sendingStateEnum == SendingStateEnum.uploadThumbnail) {
                return (this.sendProgressThumbnail / 10.0d) + 0.9d;
            }
            return sendingStateEnum == SendingStateEnum.addStoryInProgress ? 1.0d : 0.0d;
        }
        return d2 + d;
    }

    public StoryObject(GLSceneState gLSceneState, String str, Bitmap bitmap) {
        this.backgroundImagePath = BuildConfig.FLAVOR;
        this.currentAccount = UserConfig.selectedAccount;
        commonInit(gLSceneState, str, bitmap);
    }

    public StoryObject(GLSceneState gLSceneState, String str, Bitmap bitmap, VideoEditedInfo videoEditedInfo) {
        this.backgroundImagePath = BuildConfig.FLAVOR;
        this.currentAccount = UserConfig.selectedAccount;
        this.videoEditedInfo = videoEditedInfo;
        this.story_type = StoryTypeEnum.Video;
        this.duration = videoEditedInfo.originalDuration / 1000;
        commonInit(gLSceneState, str, bitmap);
    }

    public StoryObject(GLSceneState gLSceneState, String str, Bitmap bitmap, Bitmap bitmap2) {
        this.backgroundImagePath = BuildConfig.FLAVOR;
        this.currentAccount = UserConfig.selectedAccount;
        this.filteredBitmap = bitmap2;
        this.story_type = StoryTypeEnum.Picture;
        commonInit(gLSceneState, str, bitmap);
    }

    public StoryObject(GLSceneState gLSceneState, String str, RGHFilter rGHFilter, RGHFilter rGHFilter2, boolean z, long j, Bitmap bitmap, String str2, int i, int i2) {
        this.backgroundImagePath = BuildConfig.FLAVOR;
        this.currentAccount = UserConfig.selectedAccount;
        this.darkColor = i;
        this.lightColor = i2;
        this.rghFilter = rGHFilter;
        this.rghFilterToSave = rGHFilter2;
        this.story_type = z ? StoryTypeEnum.Video : StoryTypeEnum.Picture;
        this.duration = j;
        commonInit(gLSceneState, str, bitmap);
    }

    private void commonInit(GLSceneState gLSceneState, String str, Bitmap bitmap) {
        this.glSceneState = gLSceneState;
        this.localFilePathBeforeSave = str;
        this.overlay = bitmap;
        this.rnd = AndroidUtilities.getNextRnd();
        this.sendingState = SendingStateEnum.init;
        this.isLocal = true;
    }

    public boolean hasVideo() {
        return this.story_type == StoryTypeEnum.Video && this.full_file_url != null;
    }

    public StoryPollObject getPollIfExist() {
        WidgetStoryObject widgetStoryObject = this.pollWidget;
        if (widgetStoryObject != null) {
            return widgetStoryObject.poll;
        }
        return null;
    }

    public EmojiSliderObject getEmojiSliderIfExist() {
        WidgetStoryObject widgetStoryObject = this.emojiSliderWidget;
        if (widgetStoryObject != null) {
            return widgetStoryObject.emoji_slider;
        }
        return null;
    }

    public long getDuration() {
        long j = this.duration;
        if (j > 0) {
            return j;
        }
        return 5000L;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.storyObject;
    }

    public void makeData(int i) {
        this.currentAccount = i;
        ArrayList<WidgetStoryObject> arrayList = this.widget_story_list;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<WidgetStoryObject> it = this.widget_story_list.iterator();
            while (it.hasNext()) {
                WidgetStoryObject next = it.next();
                WidgetStoryObject.WidgetTypeEnum widgetTypeEnum = next.type;
                if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Poll) {
                    this.pollWidget = next;
                } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.EmojiSlider) {
                    this.emojiSliderWidget = next;
                }
            }
        }
        if (ApplicationLoader.applicationActivity == null || this.story_type != StoryTypeEnum.Video) {
            return;
        }
        PhotoViewerObject photoViewerObject = new PhotoViewerObject();
        photoViewerObject.size = 400000000;
        photoViewerObject.setForStoryVideo(this.id, this.full_file_url, (int) DimensionHelper.getStoryViewWidthPx(ApplicationLoader.applicationActivity), (int) DimensionHelper.getStoryViewHeightPx(ApplicationLoader.applicationActivity), (int) this.duration);
        this.playerInfoObject = photoViewerObject;
    }
}
