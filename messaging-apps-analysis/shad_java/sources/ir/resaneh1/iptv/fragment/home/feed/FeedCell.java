package ir.resaneh1.iptv.fragment.home.feed;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2t.analytics.AnalyticsListener;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.fragment.home.HomeSliderCell$$ExternalSyntheticBackport0;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.HomePageModels;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.VideoPlayer;

/* loaded from: classes3.dex */
public class FeedCell extends HomeCell implements VideoPlayer.VideoPlayerDelegate {
    private static final String TAG = FeedCell.class.getName();
    private HomePageModels.FeedSectionObject cachedFeedSection;
    private Context context;
    private FeedTimerCell feedTimerCell;
    private ImageView imageView;
    private boolean isVisibleToUser;
    private View.OnClickListener onLinkClick;
    private TextureView videoCell;
    private VideoPlayer videoPlayer;
    private int widthImage;

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
    }

    public FeedCell(Context context) {
        super(context);
        this.isVisibleToUser = false;
        this.onLinkClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.feed.FeedCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FeedCell.this.cachedFeedSection == null || FeedCell.this.cachedFeedSection.action_link == null) {
                    return;
                }
                HomePageActivityNew.onLinkClick(FeedCell.this.cachedFeedSection.action_link);
            }
        };
        getFrameLayout().setOnClickListener(this.onLinkClick);
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        this.feedTimerCell = new FeedTimerCell(context, Boolean.TRUE);
        this.videoPlayer = new VideoPlayer();
        this.widthImage = AndroidUtilities.px(AndroidUtilities.getScreenWidth()) - 12;
        this.context = context;
        initImageView(context);
        initVideoView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        View view = new View(context);
        view.setBackgroundResource(R.drawable.bg_feed_view_gradient);
        frameLayout.addView(this.videoCell, LayoutHelper.createFrame(-1, -1, 0));
        frameLayout.addView(this.imageView, LayoutHelper.createFrame(-1, -1, 17));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1, 17));
        frameLayout.addView(this.feedTimerCell, LayoutHelper.createFrame(-1, 60, 48, 40.0f, 20.0f, 40.0f, 0.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.addView(frameLayout, LayoutHelper.createFrame(-1, (int) ((this.widthImage * 3.0f) / 4.0f), 48));
        return frameLayout2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageView.animate().alpha(1.0f);
        this.isVisibleToUser = true;
        if (this.videoCell == null || this.cachedFeedSection == null) {
            return;
        }
        if (expireTimeIsValid() && !this.videoPlayer.isPlaying()) {
            if (isPreparedAndValidUri()) {
                playVideo(this.cachedFeedSection);
            } else {
                restartPlayer();
            }
        } else if (isPlayingAndInvalidUri()) {
            restartPlayer();
        }
        HomePageModels.TimerInfoObject timerInfoObject = this.cachedFeedSection.timer_info;
        if (timerInfoObject == null || HomeSliderCell$$ExternalSyntheticBackport0.m(Integer.valueOf(timerInfoObject.expiration_time))) {
            VisibilityHelper.hideViews(this.feedTimerCell);
            return;
        }
        if (this.cachedFeedSection.timer_info.expiration_time <= 0) {
            VisibilityHelper.hideViews(this.feedTimerCell);
            return;
        }
        VisibilityHelper.showViews(this.feedTimerCell);
        this.feedTimerCell.refreshCounter(this.cachedFeedSection.timer_info.expiration_time);
        this.feedTimerCell.setColonsColor(this.cachedFeedSection.timer_info.color_code);
        this.feedTimerCell.updateTextColor(this.cachedFeedSection.timer_info.color_code);
        this.feedTimerCell.updateFonts(this.cachedFeedSection.timer_info.font_size);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isVisibleToUser = false;
        this.imageView.animate().alpha(1.0f);
        if (this.videoCell != null) {
            new Handler().post(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.feed.FeedCell$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDetachedFromWindow$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDetachedFromWindow$0() {
        this.videoPlayer.pause();
        this.videoPlayer.releasePlayer(true);
        this.feedTimerCell.stopCounter();
    }

    private void initVideoView(Context context) {
        this.videoCell = new TextureView(context);
        initVideoPlayer();
    }

    private void initImageView(Context context) {
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_shape_rectangle_grey));
        this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        resetData();
        if (isValidData(homePageSectionObject)) {
            VisibilityHelper.showViews(this);
            this.feedTimerCell.setData(homePageSectionObject.feed_section);
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            HomePageModels.FeedSectionObject feedSectionObject = homePageSectionObject.feed_section;
            this.cachedFeedSection = feedSectionObject;
            String str = feedSectionObject.image_url;
            if (str != null) {
                GlideHelper.load(this.context, this.imageView, str, R.drawable.rubino_shape_rectangle_grey);
                return;
            }
            return;
        }
        this.cachedFeedSection = null;
        VisibilityHelper.hideViews(this);
    }

    private void resetData() {
        this.imageView.setImageDrawable(null);
        this.cachedFeedSection = null;
    }

    private boolean isPreparedAndValidUri() {
        HomePageModels.FeedSectionObject feedSectionObject;
        return this.videoPlayer.isPlayerPrepared() && (feedSectionObject = this.cachedFeedSection) != null && feedSectionObject.video != null && this.videoPlayer.getCurrentUri() == Uri.parse(this.cachedFeedSection.video.url);
    }

    private boolean isPlayingAndInvalidUri() {
        HomePageModels.FeedSectionObject feedSectionObject;
        HomePageModels.FeedSectionVideo feedSectionVideo;
        return this.videoPlayer.isPlaying() && ((feedSectionObject = this.cachedFeedSection) == null || (feedSectionVideo = feedSectionObject.video) == null || feedSectionVideo.url == null || !this.videoPlayer.getCurrentUri().equals(Uri.parse(this.cachedFeedSection.video.url)));
    }

    private boolean isValidData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        return (homePageSectionObject == null || homePageSectionObject.feed_section == null) ? false : true;
    }

    private boolean expireTimeIsValid() {
        int i;
        return MyLog.isDebugAble || HomeSliderCell$$ExternalSyntheticBackport0.m(Integer.valueOf(this.cachedFeedSection.timer_info.expiration_time)) || (i = this.cachedFeedSection.timer_info.expiration_time) == 0 || ((long) i) > System.currentTimeMillis() / 1000;
    }

    private void initVideoPlayer() {
        this.videoPlayer.setLooping(true);
        this.videoPlayer.setDelegate(this);
        this.videoPlayer.setTextureView(this.videoCell);
    }

    public void playVideo(HomePageModels.FeedSectionObject feedSectionObject) {
        if (feedSectionObject.video == null) {
            return;
        }
        try {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.feed.FeedCell$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$playVideo$1();
                }
            });
            this.videoPlayer.setMute(true);
            this.videoPlayer.setVolume(0.0f);
            this.videoPlayer.play();
        } catch (Exception e) {
            MyLog.e(TAG, " play video : crash " + e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playVideo$1() {
        VisibilityHelper.showViews(this.videoCell);
    }

    private void restartPlayer() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.feed.FeedCell$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$restartPlayer$2();
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartPlayer$2() {
        HomePageModels.FeedSectionVideo feedSectionVideo;
        String str;
        if (this.isVisibleToUser) {
            this.videoPlayer.releasePlayer(false);
            HomePageModels.FeedSectionObject feedSectionObject = this.cachedFeedSection;
            if (feedSectionObject == null || (feedSectionVideo = feedSectionObject.video) == null || (str = feedSectionVideo.url) == null) {
                return;
            }
            this.videoPlayer.preparePlayer(Uri.parse(str), "other");
            playVideo(this.cachedFeedSection);
        }
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onStateChanged(boolean z, int i) {
        if (i == 3) {
            if (!this.videoPlayer.isPlaying()) {
                this.imageView.animate().alpha(1.0f);
            } else {
                this.imageView.animate().alpha(0.0f);
            }
        }
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onError(VideoPlayer videoPlayer, Exception exc) {
        MyLog.e(TAG, exc.getLocalizedMessage());
        this.videoPlayer.preparePlayer(Uri.parse(this.cachedFeedSection.video.url), "other");
        playVideo(this.cachedFeedSection);
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onRenderedFirstFrame() {
        if (this.videoPlayer.isPlaying()) {
            this.imageView.animate().alpha(0.0f);
        }
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        if (this.videoPlayer.isPlaying()) {
            this.imageView.animate().alpha(0.0f);
        }
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
    }

    @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onSeekFinished(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
    }
}
