package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.SurfaceTexture;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import ir.appp.rghapp.components.SSHFilterGLThread;
import ir.appp.rghapp.components.SSHFilterShaders;
import ir.appp.rghapp.components.SSHFilterView;
import ir.appp.rghapp.components.SSHSeekBarView;
import ir.appp.rghapp.rubinoPostSlider.SSHHorizontalScrollView;
import ir.appp.rghapp.rubinoPostSlider.SSHPostActivity;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.model.FragmentType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieImageView;

/* loaded from: classes3.dex */
public class SSHMultiSelectMediaActivity extends LifecycleAwareBaseFragment {
    private ActionBarMenuItem actionBarNextItem;
    private ActionBarMenuItem actionBarTitleItem;
    private FrameLayout containerView;
    private RGHMediaHelper$PhotoEntry currentMedia;
    private SSHFilterView filterView;
    private ActionBarMenuItem muteActionBarItem;
    private AlertDialog progressDialog;
    private SSHSeekBarView seekBarView;
    private SSHFilterView.FilterItem selectedFilter;
    public HashMap<Object, Object> selectedPhotos;
    public ArrayList<Object> selectedPhotosOrder;
    private VideoPlayer videoPlayer;
    private boolean videoPlayerCreated;
    private final SparseArray<SSHMediaCell> mediaViews = new SparseArray<>();
    private ArrayList<RGHMediaHelper$PhotoEntry> mediaEntries = new ArrayList<>();
    private boolean muteVideos = false;
    private boolean containsVideo = false;
    private final Runnable updateProgressRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (SSHMultiSelectMediaActivity.this.videoPlayer != null) {
                if (SSHMultiSelectMediaActivity.this.videoPlayer.getCurrentPosition() >= SSHMultiSelectMediaActivity.this.currentMedia.editedInfo.endTime / 1000) {
                    SSHMultiSelectMediaActivity.this.videoPlayer.seekTo(SSHMultiSelectMediaActivity.this.currentMedia.editedInfo.startTime / 1000);
                }
                AndroidUtilities.runOnUIThread(SSHMultiSelectMediaActivity.this.updateProgressRunnable, 17L);
            }
        }
    };
    private int currentIndexMedia = 0;

    public interface OnVideoTextureCreatedListener {
        void onVideoTextureCreated(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread);
    }

    public boolean isMulti() {
        return true;
    }

    public SSHMultiSelectMediaActivity(HashMap<Object, Object> map, ArrayList<Object> arrayList) {
        this.selectedPhotos = map;
        this.selectedPhotosOrder = arrayList;
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoEditMultiMediaActivity";
        this.isSmallActionBar = true;
        this.swipeBackEnabled = false;
        this.needLockOrientation = true;
        this.isFullScreen = DimensionHelper.isShowstoryNeedFullScreen();
        ActionBarAnimationType actionBarAnimationType = ActionBarAnimationType.ALPHA;
        this.presentAnimationType = actionBarAnimationType;
        this.dismissAnimationType = actionBarAnimationType;
        this.fragmentAnimationDuration = 150.0f;
        setInPreviewMode(true);
    }

    private void needShowProgress() {
        if (this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
    }

    protected void needHideProgress() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$needHideProgress$0();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$needHideProgress$0() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(final Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        actionBarCreateActionBar.setCastShadows(false);
        actionBarCreateActionBar.setAddToContainer(true);
        actionBarCreateActionBar.isSmallActionBar = this.isSmallActionBar;
        actionBarCreateActionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        final ActionBarMenu actionBarMenuCreateMenu = actionBarCreateActionBar.createMenu();
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
        this.muteActionBarItem = actionBarMenuItem;
        actionBarMenuItem.setRtlLayout(true);
        this.muteActionBarItem.iconView.setImageResource(R.drawable.ic_rubino_unmute);
        this.muteActionBarItem.iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RLottieImageView rLottieImageView = this.muteActionBarItem.iconView;
        int i = Theme.key_rubinoBlackColor;
        rLottieImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        this.muteActionBarItem.iconView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        this.muteActionBarItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_rubino_add_post_TabSelector), 3));
        this.muteActionBarItem.setVisibility(4);
        this.muteActionBarItem.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                actionBarMenuCreateMenu.onItemClick(3);
            }
        });
        actionBarCreateActionBar.addView(this.muteActionBarItem, LayoutHelper.createFrame(48, -1, 17));
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0, true);
        this.actionBarTitleItem = actionBarMenuItem2;
        actionBarMenuItem2.setRtlLayout(true);
        this.actionBarTitleItem.textView.setTextColor(Theme.getColor(i));
        this.actionBarTitleItem.textView.setTextSize(1, 18.0f);
        this.actionBarTitleItem.textView.setSingleLine(true);
        this.actionBarTitleItem.textView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.actionBarTitleItem.setVisibility(4);
        actionBarCreateActionBar.addView(this.actionBarTitleItem, LayoutHelper.createFrame(-2, -1.0f, 21, 0.0f, 0.0f, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(2, LocaleController.getString("NEXT", R.string.rubinoActionNext));
        this.actionBarNextItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.actionBarNextItem.textView.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1 || i2 == 1) {
                    SSHMultiSelectMediaActivity.this.onBackPressed();
                    return;
                }
                if (i2 == 2) {
                    SSHMultiSelectMediaActivity.this.releasePlayer();
                    SSHMultiSelectMediaActivity.this.send();
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    SSHMultiSelectMediaActivity.this.toggleMuteVideos(context);
                }
            }
        });
        return actionBarCreateActionBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActionBarTitleText(boolean z, String str) {
        this.actionBarTitleItem.textView.setText(str);
        if (z) {
            this.muteActionBarItem.setVisibility(4);
            this.actionBarNextItem.setVisibility(4);
            this.actionBarTitleItem.setVisibility(0);
        } else {
            this.muteActionBarItem.setVisibility(this.containsVideo ? 0 : 4);
            this.actionBarNextItem.setVisibility(0);
            this.actionBarTitleItem.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMuteVideos(Context context) {
        boolean z = !this.muteVideos;
        this.muteVideos = z;
        if (z) {
            this.muteActionBarItem.iconView.setImageResource(R.drawable.ic_rubino_mute);
            Toast.makeText(context, "همه ویدیوها بی صدا هستند.", 0).show();
        } else {
            this.muteActionBarItem.iconView.setImageResource(R.drawable.ic_rubino_unmute);
            Toast.makeText(context, "همه ویدیوها با صدا هستند.", 0).show();
        }
        Iterator<RGHMediaHelper$PhotoEntry> it = this.mediaEntries.iterator();
        while (it.hasNext()) {
            RGHMediaHelper$PhotoEntry next = it.next();
            if (next.isVideo) {
                next.editedInfo.muted = this.muteVideos;
            }
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setMute(this.muteVideos);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.rtlLayout = true;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setRtlLayout(true);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.containerView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        needShowProgress();
        Iterator<Object> it = this.selectedPhotosOrder.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = (RGHMediaHelper$PhotoEntry) this.selectedPhotos.get(it.next());
            this.mediaEntries.add(rGHMediaHelper$PhotoEntry);
            if (this.containsVideo || (rGHMediaHelper$PhotoEntry != null && rGHMediaHelper$PhotoEntry.isVideo)) {
                z = true;
            }
            this.containsVideo = z;
        }
        this.muteActionBarItem.setVisibility(this.containsVideo ? 0 : 8);
        getMediasInfo();
        FrameLayout frameLayout2 = this.containerView;
        this.fragmentView = frameLayout2;
        ViewCompat.setLayoutDirection(frameLayout2, 0);
        return this.fragmentView;
    }

    public int getMaxVideoDuration() {
        return (isMulti() ? RGHAddPostActivity.maxMultiVideoDurationInSecond : RGHAddPostActivity.maxVideoDurationInSecond) * CloseCodes.NORMAL_CLOSURE;
    }

    private void getMediasInfo() {
        this.compositeDisposable.add((Disposable) Observable.just(Boolean.TRUE).observeOn(Schedulers.computation()).doOnNext(new Consumer() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$getMediasInfo$2((Boolean) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Boolean>() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Boolean bool) {
                SSHMultiSelectMediaActivity sSHMultiSelectMediaActivity = SSHMultiSelectMediaActivity.this;
                sSHMultiSelectMediaActivity.initViews(sSHMultiSelectMediaActivity.getParentActivity());
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                th.printStackTrace();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getMediasInfo$2(java.lang.Boolean r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.lambda$getMediasInfo$2(java.lang.Boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViews(Context context) {
        int i;
        int i2;
        int i3;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.mediaEntries.get(this.currentIndexMedia);
        this.currentMedia = rGHMediaHelper$PhotoEntry;
        prepareFilterView(ThumbnailUtils.extractThumbnail(rGHMediaHelper$PhotoEntry.bitmap, 250, 250));
        int i4 = 0;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.mediaEntries.get(0);
        if (rGHMediaHelper$PhotoEntry2.isVideo) {
            MediaController.CropState cropState = rGHMediaHelper$PhotoEntry2.editedInfo.cropState;
            i = cropState.transformWidth;
            i2 = cropState.transformHeight;
        } else {
            VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry2.editedInfo;
            i = videoEditedInfo.resultWidth;
            i2 = videoEditedInfo.resultHeight;
        }
        int rubinoContainerViewWidth = (int) ((MediaController.getRubinoContainerViewWidth() / 1.25f) / AndroidUtilities.density);
        if (i == i2) {
            i3 = rubinoContainerViewWidth;
        } else if (i > i2) {
            i3 = (int) (i2 * (rubinoContainerViewWidth / i));
        } else {
            rubinoContainerViewWidth = (int) (i * (rubinoContainerViewWidth / i2));
            i3 = rubinoContainerViewWidth;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        SSHHorizontalScrollView sSHHorizontalScrollView = new SSHHorizontalScrollView(getParentActivity(), this.mediaEntries.size(), (int) (rubinoContainerViewWidth * AndroidUtilities.density), AndroidUtilities.dp(16.0f));
        sSHHorizontalScrollView.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getParentActivity());
        linearLayout.setOrientation(0);
        while (i4 < this.mediaEntries.size()) {
            final RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry3 = this.mediaEntries.get(i4);
            SSHMediaCell sSHMediaCell = new SSHMediaCell(getParentActivity(), rGHMediaHelper$PhotoEntry3, (i4 == 0 && rGHMediaHelper$PhotoEntry3.isVideo && !this.videoPlayerCreated) ? new OnVideoTextureCreatedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda8
                @Override // ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.OnVideoTextureCreatedListener
                public final void onVideoTextureCreated(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
                    this.f$0.lambda$initViews$3(rGHMediaHelper$PhotoEntry3, surfaceTexture, sSHFilterGLThread);
                }
            } : null);
            if (rGHMediaHelper$PhotoEntry3.isVideo) {
                this.videoPlayerCreated = true;
            }
            sSHMediaCell.setTag(Integer.valueOf(i4));
            sSHMediaCell.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onMediaCellClicked(view);
                }
            });
            linearLayout.addView(sSHMediaCell, LayoutHelper.createLinear(rubinoContainerViewWidth, i3, 17, i4 == 0 ? 16 : 8, 0, i4 == this.mediaEntries.size() - 1 ? 16 : 8, 0));
            this.mediaViews.append(i4, sSHMediaCell);
            i4++;
        }
        sSHHorizontalScrollView.setDelegate(new SSHHorizontalScrollView.OnScrollListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.4
            @Override // ir.appp.rghapp.rubinoPostSlider.SSHHorizontalScrollView.OnScrollListener
            public void onStartScrolling() {
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.SSHHorizontalScrollView.OnScrollListener
            public void onIdleScrolling(int i5) {
                SSHMultiSelectMediaActivity.this.currentIndexMedia = i5;
                SSHMultiSelectMediaActivity sSHMultiSelectMediaActivity = SSHMultiSelectMediaActivity.this;
                sSHMultiSelectMediaActivity.currentMedia = (RGHMediaHelper$PhotoEntry) sSHMultiSelectMediaActivity.mediaEntries.get(SSHMultiSelectMediaActivity.this.currentIndexMedia);
                if (SSHMultiSelectMediaActivity.this.currentMedia.isVideo) {
                    SSHMediaCell sSHMediaCell2 = (SSHMediaCell) SSHMultiSelectMediaActivity.this.mediaViews.get(SSHMultiSelectMediaActivity.this.currentIndexMedia);
                    if (sSHMediaCell2.eglThread != null) {
                        sSHMediaCell2.eglThread.setNeedRenderFirstFrameFromBitmap(false);
                    }
                    if (sSHMediaCell2.videoTextureView != null) {
                        SSHMultiSelectMediaActivity.this.preparePlayer(Uri.fromFile(new File(SSHMultiSelectMediaActivity.this.currentMedia.path)), true);
                        SSHMultiSelectMediaActivity.this.videoPlayer.setSurface(new Surface(sSHMediaCell2.videoTextureView));
                        return;
                    }
                    return;
                }
                if (SSHMultiSelectMediaActivity.this.videoPlayer != null) {
                    SSHMultiSelectMediaActivity.this.videoPlayer.pause();
                    SSHMultiSelectMediaActivity.this.videoPlayer.setSurface(null);
                }
            }
        });
        sSHHorizontalScrollView.addView(linearLayout);
        frameLayout.addView(sSHHorizontalScrollView, LayoutHelper.createFrame(-1, -2, 17));
        this.containerView.addView(frameLayout, LayoutHelper.createFrame(-1, (int) (MediaController.getRubinoContainerViewHeight() / AndroidUtilities.density), 48));
        needHideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$3(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.setNeedRenderFirstFrameFromBitmap(false);
        }
        if (surfaceTexture != null) {
            preparePlayer(Uri.fromFile(new File(rGHMediaHelper$PhotoEntry.path)), true);
            this.videoPlayer.setSurface(new Surface(surfaceTexture));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaCellClicked(View view) {
        SSHSeekBarView sSHSeekBarView = this.seekBarView;
        if (sSHSeekBarView == null || sSHSeekBarView.getVisibility() != 0) {
            final int iIntValue = ((Integer) view.getTag()).intValue();
            if (this.currentMedia.isVideo) {
                SSHMediaCell sSHMediaCell = this.mediaViews.get(this.currentIndexMedia);
                sSHMediaCell.videoTextureView = null;
                if (sSHMediaCell.onVideoTextureCreatedListener == null) {
                    sSHMediaCell.onVideoTextureCreatedListener = new OnVideoTextureCreatedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda7
                        @Override // ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.OnVideoTextureCreatedListener
                        public final void onVideoTextureCreated(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
                            this.f$0.lambda$onMediaCellClicked$4(surfaceTexture, sSHFilterGLThread);
                        }
                    };
                }
            }
            presentFragment(new SSHPostActivity(iIntValue, this.mediaEntries.get(iIntValue), new SSHPostActivity.OnMediaEditFinished() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda9
                @Override // ir.appp.rghapp.rubinoPostSlider.SSHPostActivity.OnMediaEditFinished
                public final void onMediaEditFinished(int i, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
                    this.f$0.lambda$onMediaCellClicked$5(iIntValue, i, rGHMediaHelper$PhotoEntry);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMediaCellClicked$4(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.setNeedRenderFirstFrameFromBitmap(false);
        }
        if (surfaceTexture != null) {
            preparePlayer(Uri.fromFile(new File(this.currentMedia.path)), true);
            this.videoPlayer.setSurface(new Surface(surfaceTexture));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMediaCellClicked$5(int i, int i2, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        this.mediaEntries.set(i, rGHMediaHelper$PhotoEntry);
        boolean z = rGHMediaHelper$PhotoEntry.editedInfo.muted && this.muteVideos;
        this.muteVideos = z;
        this.muteActionBarItem.iconView.setImageResource(z ? R.drawable.ic_rubino_mute : R.drawable.ic_rubino_unmute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlayer(Uri uri, boolean z) {
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.5
                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onRenderedFirstFrame() {
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onStateChanged(boolean z2, int i, boolean z3) {
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onError(VideoPlayer videoPlayer2, Exception exc) {
                    if (SSHMultiSelectMediaActivity.this.videoPlayer != videoPlayer2) {
                        return;
                    }
                    FileLog.e(exc);
                }
            });
        }
        this.videoPlayer.preparePlayer(uri, "other");
        this.videoPlayer.setLooping(true);
        this.videoPlayer.seekTo(this.currentMedia.editedInfo.startTime / 1000);
        this.videoPlayer.setMute(this.currentMedia.editedInfo.muted);
        this.videoPlayer.setPlayWhenReady(z);
        AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePlayer() {
        try {
            this.videoPlayerCreated = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                videoPlayer.releasePlayer();
                this.videoPlayer = null;
            }
            SSHMediaCell sSHMediaCell = this.mediaViews.get(this.currentIndexMedia);
            if (sSHMediaCell != null) {
                sSHMediaCell.videoTextureView = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
        if (rGHMediaHelper$PhotoEntry != null && rGHMediaHelper$PhotoEntry.isVideo) {
            SSHMediaCell sSHMediaCell = this.mediaViews.get(this.currentIndexMedia);
            sSHMediaCell.videoTextureView = null;
            if (sSHMediaCell.onVideoTextureCreatedListener == null) {
                sSHMediaCell.onVideoTextureCreatedListener = new OnVideoTextureCreatedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda6
                    @Override // ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.OnVideoTextureCreatedListener
                    public final void onVideoTextureCreated(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
                        this.f$0.lambda$onResume$6(surfaceTexture, sSHFilterGLThread);
                    }
                };
            }
        }
        updateEglThreads();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$6(SurfaceTexture surfaceTexture, SSHFilterGLThread sSHFilterGLThread) {
        if (sSHFilterGLThread != null) {
            sSHFilterGLThread.setNeedRenderFirstFrameFromBitmap(false);
        }
        if (surfaceTexture != null) {
            preparePlayer(Uri.fromFile(new File(this.currentMedia.path)), true);
            this.videoPlayer.setSurface(new Surface(surfaceTexture));
        }
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        releasePlayer();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        this.compositeDisposable.dispose();
        Iterator<RGHMediaHelper$PhotoEntry> it = this.mediaEntries.iterator();
        while (it.hasNext()) {
            RGHMediaHelper$PhotoEntry next = it.next();
            Bitmap bitmap = next.bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                next.bitmap.recycle();
                next.bitmap = null;
            }
            next.resetForAddPost();
        }
        this.mediaEntries = null;
        for (int i = 0; i < this.mediaViews.size(); i++) {
            SSHMediaCell sSHMediaCell = this.mediaViews.get(i);
            if (sSHMediaCell.eglThread != null) {
                sSHMediaCell.eglThread.shutdown();
                sSHMediaCell.eglThread = null;
            }
            if (sSHMediaCell.videoTextureView != null) {
                sSHMediaCell.videoTextureView.release();
                sSHMediaCell.videoTextureView = null;
            }
            sSHMediaCell.textureView = null;
        }
        super.onFragmentDestroy();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        SSHSeekBarView sSHSeekBarView = this.seekBarView;
        if (sSHSeekBarView != null && sSHSeekBarView.getVisibility() == 0) {
            updateFilterSizeValue(this.selectedFilter.id, 100);
            updateActionBarTitleText(false, null);
            this.filterView.setVisibility(0);
            this.seekBarView.setVisibility(8);
        } else {
            showDiscardDialog();
        }
        return false;
    }

    private void showDiscardDialog() {
        if (ApplicationLoader.applicationActivity != null) {
            String string = LocaleController.getString("Are you sure to discard changes?", R.string.rubinoAddPostDiscardMessage);
            SpannableString spannableString = new SpannableString(string);
            int length = string.length();
            int i = Theme.key_rubinoBlackColor;
            RubinoController.showRubinoCenterDialog(false, true, null, SpanHelper.makeBoldWithColorAndRelativeSize(spannableString, 0, length, Theme.getColor(i), 1.4f), LocaleController.getString("Discard", R.string.rubinoAddPostDiscard), LocaleController.getString("Close", R.string.rubinoAddPostContinue), -769226, Theme.getColor(i), new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showDiscardDialog$7(view);
                }
            }, null);
            return;
        }
        presentFragment(new RGHAddPostActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDiscardDialog$7(View view) {
        presentFragment(new RGHAddPostActivity(), true);
    }

    private void prepareSeekBarView() {
        SSHSeekBarView sSHSeekBarView = new SSHSeekBarView(getParentActivity());
        this.seekBarView = sSHSeekBarView;
        sSHSeekBarView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.seekBarView.setSeekBarDelegate(new SSHSeekBarView.SeekBarDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda5
            @Override // ir.appp.rghapp.components.SSHSeekBarView.SeekBarDelegate
            public final void onProgressChanged(int i) {
                this.f$0.lambda$prepareSeekBarView$8(i);
            }
        });
        this.seekBarView.setOnActionClickedListener(new SSHSeekBarView.OnActionClickedListener() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity.6
            @Override // ir.appp.rghapp.components.SSHSeekBarView.OnActionClickedListener
            public void onDoneClicked() {
                SSHMultiSelectMediaActivity.this.selectedFilter.progress = SSHMultiSelectMediaActivity.this.seekBarView.getProgress();
                SSHMultiSelectMediaActivity.this.filterView.updateSelectedFilter(SSHMultiSelectMediaActivity.this.selectedFilter.id);
                SSHMultiSelectMediaActivity.this.filterView.setVisibility(0);
                SSHMultiSelectMediaActivity.this.seekBarView.setVisibility(8);
                SSHMultiSelectMediaActivity.this.updateActionBarTitleText(false, null);
            }

            @Override // ir.appp.rghapp.components.SSHSeekBarView.OnActionClickedListener
            public void onCancelClicked() {
                SSHMultiSelectMediaActivity.this.onBackPressed();
            }
        });
        this.seekBarView.setVisibility(8);
        this.containerView.addView(this.seekBarView, LayoutHelper.createFrame(-1, -1, 83));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSeekBarView$8(int i) {
        updateFilterSizeValue(this.selectedFilter.id, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send() {
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mediaEntries.size(); i++) {
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntryCopy = this.mediaEntries.get(i).copy();
            SSHMediaCell sSHMediaCell = this.mediaViews.get(i);
            rGHMediaHelper$PhotoEntryCopy.bitmap = sSHMediaCell.eglThread.getTexture();
            if (i == 0) {
                if (rGHMediaHelper$PhotoEntryCopy.isVideo) {
                    MediaController.CropState cropState = rGHMediaHelper$PhotoEntryCopy.editedInfo.cropState;
                    float fMin = 150.0f / Math.min(cropState.transformWidth, cropState.transformHeight);
                    Bitmap bitmap = rGHMediaHelper$PhotoEntryCopy.editedInfo.coverPhotoBitmap;
                    if (bitmap == null) {
                        bitmap = sSHMediaCell.textureView.getBitmap();
                    }
                    MediaController.CropState cropState2 = rGHMediaHelper$PhotoEntryCopy.editedInfo.cropState;
                    rGHMediaHelper$PhotoEntryCopy.thumbBitmap = ImageLoader.generateThumbnail(bitmap, 1.0f, cropState2.translateX, cropState2.translateY, (int) (cropState2.transformWidth * fMin), (int) (fMin * cropState2.transformHeight));
                } else {
                    VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntryCopy.editedInfo;
                    float fMin2 = 150.0f / Math.min(videoEditedInfo.resultWidth, videoEditedInfo.resultHeight);
                    Bitmap bitmap2 = sSHMediaCell.textureView.getBitmap();
                    VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntryCopy.editedInfo;
                    rGHMediaHelper$PhotoEntryCopy.thumbBitmap = ImageLoader.generateThumbnail(bitmap2, 1.0f, 0, 0, (int) (videoEditedInfo2.resultWidth * fMin2), (int) (fMin2 * videoEditedInfo2.resultHeight));
                }
            }
            arrayList.add(rGHMediaHelper$PhotoEntryCopy);
        }
        presentFragment(new RubinoCaptionPostActivity(RubinoDraftManager.getInstance(this.currentAccount).createSendingPost(arrayList, AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)));
    }

    private void prepareFilterView(Bitmap bitmap) {
        if (this.filterView == null) {
            SSHFilterView sSHFilterView = new SSHFilterView(getParentActivity(), true, true);
            this.filterView = sSHFilterView;
            sSHFilterView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            if (bitmap != null) {
                this.filterView.setBitmapPath(bitmap);
            }
            this.filterView.setDelegate(new SSHFilterView.FilterViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$$ExternalSyntheticLambda4
                @Override // ir.appp.rghapp.components.SSHFilterView.FilterViewDelegate
                public final void onFilterChanged(SSHFilterView.FilterItem filterItem) {
                    this.f$0.lambda$prepareFilterView$9(filterItem);
                }
            });
            this.containerView.addView(this.filterView, LayoutHelper.createFrame(-1, -1, 83));
            if (this.seekBarView == null) {
                prepareSeekBarView();
            }
        }
        SSHFilterView sSHFilterView2 = this.filterView;
        sSHFilterView2.scrollToPosition(sSHFilterView2.getSelectedItemPosition(), false);
        this.filterView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareFilterView$9(SSHFilterView.FilterItem filterItem) {
        SSHFilterView.FilterItem filterItem2;
        int i = filterItem.id;
        if (i != 0 && (filterItem2 = this.selectedFilter) != null && i == filterItem2.id) {
            this.seekBarView.setValue(filterItem.progress, filterItem.min, filterItem.max);
            this.filterView.setVisibility(8);
            this.seekBarView.setVisibility(0);
            updateActionBarTitleText(true, filterItem.title);
        }
        this.selectedFilter = filterItem;
        updateFilterSizeValue(filterItem.id, 100);
    }

    private void updateFilterSizeValue(int i, int i2) {
        Iterator<RGHMediaHelper$PhotoEntry> it = this.mediaEntries.iterator();
        while (it.hasNext()) {
            RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState = it.next().savedFilterState;
            rGHMediaHelper$SavedFilterState.filterId = i;
            rGHMediaHelper$SavedFilterState.filterSize = i2;
        }
        updateEglThreads();
    }

    private void updateEglThreads() {
        for (int i = 0; i < this.mediaEntries.size(); i++) {
            SSHMediaCell sSHMediaCell = this.mediaViews.get(i);
            if (sSHMediaCell != null && sSHMediaCell.eglThread != null) {
                sSHMediaCell.eglThread.setFilterGLThreadDelegate(SSHFilterShaders.getFilterShadersDelegate(sSHMediaCell.currentMedia.savedFilterState));
                sSHMediaCell.eglThread.requestRender(true, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SSHMediaCell extends FrameLayout {
        private final AspectRatioFrameLayout aspectRatioFrameLayout;
        private final RGHMediaHelper$PhotoEntry currentMedia;
        private SSHFilterGLThread eglThread;
        private OnVideoTextureCreatedListener onVideoTextureCreatedListener;
        private TextureView textureView;
        private SurfaceTexture videoTextureView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public SSHMediaCell(Context context, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, OnVideoTextureCreatedListener onVideoTextureCreatedListener) {
            super(context);
            setWillNotDraw(false);
            this.currentMedia = rGHMediaHelper$PhotoEntry;
            this.onVideoTextureCreatedListener = onVideoTextureCreatedListener;
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.drawable.bg_round_white);
            imageView.setImageResource(R.drawable.ic_media);
            imageView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setColorFilter(-14013910);
            addView(imageView, LayoutHelper.createFrame(32, 32.0f, 83, 16.0f, 0.0f, 4.0f, 20.0f));
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            TextureView textureView = new TextureView(context);
            this.textureView = textureView;
            textureView.setSurfaceTextureListener(new AnonymousClass1(rGHMediaHelper$PhotoEntry, context));
            if (rGHMediaHelper$PhotoEntry.isVideo) {
                aspectRatioFrameLayout.setAspectRatio(rGHMediaHelper$PhotoEntry.width / rGHMediaHelper$PhotoEntry.height, 0);
            }
            aspectRatioFrameLayout.addView(this.textureView, LayoutHelper.createFrame(-1, -1, 17));
            addView(aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 48));
        }

        /* renamed from: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$SSHMediaCell$1, reason: invalid class name */
        class AnonymousClass1 implements TextureView.SurfaceTextureListener {
            final /* synthetic */ Context val$context;
            final /* synthetic */ RGHMediaHelper$PhotoEntry val$currentMedia;

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            AnonymousClass1(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, Context context) {
                this.val$currentMedia = rGHMediaHelper$PhotoEntry;
                this.val$context = context;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (this.val$currentMedia == null || SSHMediaCell.this.eglThread != null || surfaceTexture == null) {
                    return;
                }
                SSHMediaCell sSHMediaCell = SSHMediaCell.this;
                RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.val$currentMedia;
                sSHMediaCell.eglThread = new SSHFilterGLThread(rGHMediaHelper$PhotoEntry.imageId, this.val$context, surfaceTexture, rGHMediaHelper$PhotoEntry.isVideo, rGHMediaHelper$PhotoEntry.bitmap, 0, false, new SSHFilterGLThread.FilterGLThreadVideoDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$SSHMediaCell$1$$ExternalSyntheticLambda0
                    @Override // ir.appp.rghapp.components.SSHFilterGLThread.FilterGLThreadVideoDelegate
                    public final void onVideoSurfaceCreated(SurfaceTexture surfaceTexture2) {
                        this.f$0.lambda$onSurfaceTextureAvailable$0(surfaceTexture2);
                    }
                }, null, true);
                SSHMediaCell.this.eglThread.setSurfaceTextureSize(i, i2);
                SSHMediaCell.this.eglThread.setFilterGLThreadDelegate(SSHFilterShaders.getFilterShadersDelegate(this.val$currentMedia.savedFilterState));
                SSHMediaCell.this.eglThread.requestRender(true, true, false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onSurfaceTextureAvailable$0(SurfaceTexture surfaceTexture) {
                SSHMediaCell.this.videoTextureView = surfaceTexture;
                if (SSHMediaCell.this.onVideoTextureCreatedListener != null) {
                    SSHMediaCell.this.onVideoTextureCreatedListener.onVideoTextureCreated(SSHMediaCell.this.videoTextureView, SSHMediaCell.this.eglThread);
                }
                SSHMediaCell.this.onVideoTextureCreatedListener = null;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (SSHMediaCell.this.eglThread != null) {
                    SSHMediaCell.this.eglThread.setSurfaceTextureSize(i, i2);
                    SSHMediaCell.this.eglThread.requestRender(true, true, false);
                    SSHMediaCell.this.eglThread.postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHMultiSelectMediaActivity$SSHMediaCell$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onSurfaceTextureSizeChanged$1();
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$1() {
                if (SSHMediaCell.this.eglThread != null) {
                    SSHMediaCell.this.eglThread.requestRender(true, true, false);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (SSHMediaCell.this.eglThread == null) {
                    return true;
                }
                SSHMediaCell.this.eglThread.shutdown();
                SSHMediaCell.this.eglThread = null;
                return true;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float height;
            int height2;
            if (this.aspectRatioFrameLayout != null) {
                canvas.save();
                RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentMedia;
                if (rGHMediaHelper$PhotoEntry != null && rGHMediaHelper$PhotoEntry.isVideo) {
                    if (this.aspectRatioFrameLayout.getHeight() > this.aspectRatioFrameLayout.getWidth()) {
                        height = getWidth();
                        height2 = this.aspectRatioFrameLayout.getWidth();
                    } else if (this.aspectRatioFrameLayout.getHeight() >= this.aspectRatioFrameLayout.getWidth() && getWidth() > getHeight()) {
                        height = getWidth();
                        height2 = this.aspectRatioFrameLayout.getWidth();
                    } else {
                        height = getHeight();
                        height2 = this.aspectRatioFrameLayout.getHeight();
                    }
                    float f = height / height2;
                    int i = (-((int) ((this.aspectRatioFrameLayout.getWidth() * f) - getWidth()))) / 2;
                    int i2 = (-((int) ((this.aspectRatioFrameLayout.getHeight() * f) - getHeight()))) / 2;
                    float width = getWidth() / MediaController.getInstance().getAddPostCropArea().width();
                    float height3 = getHeight() / MediaController.getInstance().getAddPostCropArea().height();
                    MediaController.CropState cropState = this.currentMedia.editedInfo.cropState;
                    canvas.translate(i + ((int) (cropState.translateX * width)), i2 + ((int) (cropState.translateY * height3)));
                    canvas.scale(f, f);
                    this.aspectRatioFrameLayout.draw(canvas);
                } else if (rGHMediaHelper$PhotoEntry != null) {
                    canvas.translate(0.0f, 0.0f);
                    canvas.scale(1.0f, 1.0f);
                    AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
                    VideoEditedInfo videoEditedInfo = this.currentMedia.editedInfo;
                    aspectRatioFrameLayout.setAspectRatio(videoEditedInfo.resultWidth / videoEditedInfo.resultHeight, 0);
                    this.aspectRatioFrameLayout.draw(canvas);
                }
                canvas.restore();
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                if (view != this.aspectRatioFrameLayout) {
                    if (super.drawChild(canvas, view, j)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }
    }
}
