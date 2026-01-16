package ir.resaneh1.iptv.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.ExoPlayerFactory;
import com.google.android.exoplayer2t.SimpleExoPlayer;
import com.google.android.exoplayer2t.source.ExtractorMediaSource;
import com.google.android.exoplayer2t.source.LoopingMediaSource;
import com.google.android.exoplayer2t.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2t.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2t.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2t.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2t.util.Util;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.BackgroundGenerationListener;
import ir.appp.rghapp.ColorPickerListener;
import ir.appp.rghapp.FilterBuilder;
import ir.appp.rghapp.GLMediaRenderer;
import ir.appp.rghapp.GLSceneState;
import ir.appp.rghapp.RGHFilter;
import ir.appp.rghapp.Utils;
import ir.appp.rghapp.rubinoPostSlider.FilterGLThread;
import ir.appp.rghapp.rubinoPostSlider.PhotoSlideObject;
import ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UI_rubinoColorButton;
import ir.resaneh1.iptv.UIView.UI_rubinoColorPickerRow;
import ir.resaneh1.iptv.UIView.UI_rubinoDropperSelectorCell;
import ir.resaneh1.iptv.UIView.UI_rubinoEmojiPickerRow;
import ir.resaneh1.iptv.UIView.UI_rubinoFilterView;
import ir.resaneh1.iptv.UIView.UI_rubinoSeekBar;
import ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow;
import ir.resaneh1.iptv.fragment.rubino.AddStoryBottomView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.CreateLinkFrameLayout;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.SendStoryHelper;
import ir.resaneh1.iptv.helper.StoryEntityView;
import ir.resaneh1.iptv.helper.StoryStickerPickerLayout;
import ir.resaneh1.iptv.helper.StoryUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.EmojiSliderObject;
import ir.resaneh1.iptv.model.HashtagStoryObject;
import ir.resaneh1.iptv.model.InstaGetHashTagsOutput;
import ir.resaneh1.iptv.model.InstaGetListInput;
import ir.resaneh1.iptv.model.InstaGetProfilesOutput;
import ir.resaneh1.iptv.model.MentionStoryObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoClockObject;
import ir.resaneh1.iptv.model.RubinoDateObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.StoryEntityItem;
import ir.resaneh1.iptv.model.StoryLinkObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryPollObject;
import ir.resaneh1.iptv.model.StoryPositionObject;
import ir.resaneh1.iptv.model.StoryQuestionObject;
import ir.resaneh1.iptv.model.StoryQuizObject;
import ir.resaneh1.iptv.model.StoryShareQuestionObject;
import ir.resaneh1.iptv.model.StoryTextAttributeObject;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import ir.resaneh1.iptv.presenters.RubinoEntityArrayEmojiPresenter;
import ir.resaneh1.iptv.story.ClockSticker;
import ir.resaneh1.iptv.story.DateSticker;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.QuestionSticker;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSticker;
import ir.resaneh1.iptv.story.poll.PollSticker;
import ir.resaneh1.iptv.story.poll.PollView;
import ir.resaneh1.iptv.story.quiz.QuizSticker;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.relex.circleindicator.CircleIndicator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class AddStoryFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate, ColorPickerListener {
    private static Pattern urlPattern;
    private String backgroundPath;
    public RGHFilter currentFilter;
    int currentIndicator;
    int darkColor;
    private boolean didLoadVideoSize;
    private boolean didSetDefaultValues;
    private FilterGLThread eglThread;
    public CharSequence[] emojiCharSequences;
    private FilterBuilder filterBuilder;
    private UI_rubinoFilterView filterView;
    private FrameLayoutTouchable frameLayoutTouchController;
    private GLMediaRenderer glRenderer;
    private GLSurfaceView glSurfaceView;
    private Bitmap imageBitmap;
    private int imageOriginalRotation;
    private WidgetStoryObject initWidget;
    private boolean isMultiFile;
    int lightColor;
    private DisposableObserver<Long> loadDisposable;
    private FrameLayout mainFrameLayout;
    private float mediaHeight;
    private TextureView mediaTextureView;
    private AddStoryMediaType mediaType;
    private float mediaWidth;
    private boolean needToInitGl;
    private DisposableObserver pageSelectedDisposable;
    String path;
    private StoryEntityView postView;
    int screenHeight;
    int screenWidth;
    float targetHeight;
    float targetWidth;
    private VideoEditedInfo videoInfo;
    private VideoPlayer videoPlayer;
    private float widgetStoryWHRatio;

    /* JADX INFO: Access modifiers changed from: private */
    interface StoryDelegate {
        void onCreateLocalStory(StoryObject storyObject);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.add_story_fragment;
    }

    public AddStoryFragment(String str, boolean z) {
        this.emojiCharSequences = new CharSequence[]{"😍", "😂", "😀", "🔥", "😡", "😱\t", "😢", "🙌", "❤️", "🎉", "👍\t", "🙏\t", "😮", "💯\t", "😴\t", "😭\t", "👏"};
        this.currentIndicator = -1;
        this.imageBitmap = null;
        this.imageOriginalRotation = 0;
        this.path = str;
        this.mediaType = z ? AddStoryMediaType.Video : AddStoryMediaType.Picture;
        initFlags();
    }

    public AddStoryFragment(String str, boolean z, WidgetStoryObject widgetStoryObject, float f) {
        this.emojiCharSequences = new CharSequence[]{"😍", "😂", "😀", "🔥", "😡", "😱\t", "😢", "🙌", "❤️", "🎉", "👍\t", "🙏\t", "😮", "💯\t", "😴\t", "😭\t", "👏"};
        this.currentIndicator = -1;
        this.imageBitmap = null;
        this.imageOriginalRotation = 0;
        this.path = str;
        this.mediaType = z ? AddStoryMediaType.Video : AddStoryMediaType.Picture;
        this.initWidget = widgetStoryObject;
        this.widgetStoryWHRatio = f;
        initFlags();
    }

    public AddStoryFragment(WidgetStoryObject widgetStoryObject, float f) {
        this.emojiCharSequences = new CharSequence[]{"😍", "😂", "😀", "🔥", "😡", "😱\t", "😢", "🙌", "❤️", "🎉", "👍\t", "🙏\t", "😮", "💯\t", "😴\t", "😭\t", "👏"};
        this.currentIndicator = -1;
        this.imageBitmap = null;
        this.imageOriginalRotation = 0;
        this.mediaType = AddStoryMediaType.None;
        this.path = getWidgetFilePath();
        this.initWidget = widgetStoryObject;
        this.widgetStoryWHRatio = f;
        initFlags();
    }

    public AddStoryFragment() {
        this.emojiCharSequences = new CharSequence[]{"😍", "😂", "😀", "🔥", "😡", "😱\t", "😢", "🙌", "❤️", "🎉", "👍\t", "🙏\t", "😮", "💯\t", "😴\t", "😭\t", "👏"};
        this.currentIndicator = -1;
        this.imageBitmap = null;
        this.imageOriginalRotation = 0;
        initFlags();
    }

    private void initFlags() {
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.isForceBlackTheme = true;
        this.needLockOrientation = true;
        this.fragmentName = "AddStoryFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Activity activity = (Activity) context;
        this.targetWidth = DimensionHelper.getStoryViewWidthPx(activity);
        this.targetHeight = DimensionHelper.getStoryViewHeightPx(activity);
        int i = ApplicationLoader.applicationActivity.topCutoutHeight;
        activity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i2) {
                CompositeDisposable compositeDisposable;
                if ((i2 & 4) == 0) {
                    if (!(ApplicationLoader.applicationActivity.getLastFragment() instanceof AddStoryFragment) || (compositeDisposable = ((PresenterFragment) AddStoryFragment.this).compositeDisposable) == null) {
                        return;
                    }
                    compositeDisposable.add((Disposable) Observable.timer(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.1.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (DimensionHelper.isShowstoryNeedFullScreen()) {
                                AddStoryFragment.this.toggleFullscreenSwitch(true);
                            }
                            AddStoryFragment.this.lockOrientationPortrait();
                        }
                    }));
                    return;
                }
                MyLog.e("AddStoryFragment", "onSystemUiVisibilityChange 2");
            }
        });
        return super.createView(context);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.storyBackgroundCreated);
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.mainFrameLayout = (FrameLayout) findViewById(R.id.frameLayoutMain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRendererAvailable() {
        FilterGLThread filterGLThread;
        return Utils.useNewStoryCreationSystem() ? (this.mediaTextureView == null || (filterGLThread = this.eglThread) == null || filterGLThread.getFilterShader() == null) ? false : true : this.glRenderer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFilterProgressChange(int i, float f) {
        MyLog.e("AddStoryFragment", "onFilterProgressChange " + f);
        int i2 = (i % 11) + 1;
        if (i2 != 0) {
            boolean z = i2 < 0;
            if (i2 == 1 || i2 == -11) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.None, z);
            } else if (i2 == 2 || i2 == -10) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.BlackAndWhite, z);
            } else if (i2 == 3 || i2 == -9) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Greish, z);
            } else if (i2 == 4 || i2 == -8) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Happy, z);
            } else if (i2 == 5 || i2 == -7) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Dark, z);
            } else if (i2 == 6 || i2 == -6) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.BuenosAires, z);
            } else if (i2 == 7 || i2 == -5) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Tokyo, z);
            } else if (i2 == 8 || i2 == -4) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Menegol, z);
            } else if (i2 == 9 || i2 == -3) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Cold, z);
            } else if (i2 == 10 || i2 == -2) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Pinky, z);
            } else if (i2 == 11 || i2 == -1) {
                this.currentFilter.setFilterType(RGHFilter.FilterType.Sepia, z);
            }
            MyLog.e("AddStoryFragment onPageScrolled", "indicator " + i2 + " offset " + f);
            if (this.currentIndicator != i2) {
                this.currentIndicator = i2;
                applyFilterChangeToGL();
            }
            MyLog.e("AddStoryFragment", BuildConfig.FLAVOR + this.currentFilter.getFilterType());
            if (isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    this.eglThread.getFilterShader().updateFilterInfo(i2, f);
                    this.eglThread.requestRender();
                } else {
                    this.glRenderer.updateFilterInfo(i2, f);
                }
            }
        }
    }

    private void applyFilterChangeToGL() {
        if (isRendererAvailable()) {
            if (Utils.useNewStoryCreationSystem()) {
                this.eglThread.getFilterShader().setFilterType(this.currentFilter.getFilterType());
                this.eglThread.getFilterShader().setSaturation(this.currentFilter.getSaturation());
                this.eglThread.getFilterShader().setContrast(this.currentFilter.getContrast());
                this.eglThread.getFilterShader().setBrightness(this.currentFilter.getBrightness());
                this.eglThread.getFilterShader().setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
                this.eglThread.requestRender();
                return;
            }
            this.glRenderer.setFilterType(this.currentFilter.getFilterType());
            this.glRenderer.setSaturation(this.currentFilter.getSaturation());
            this.glRenderer.setContrast(this.currentFilter.getContrast());
            this.glRenderer.setBrightness(this.currentFilter.getBrightness());
            this.glRenderer.setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
        }
    }

    void createCurrentFilter(boolean z, String str) {
        if (str != null) {
            this.filterBuilder.withOverlayImage(new FilterBuilder.OverlayImage(str, DimensionHelper.getStoryWidth(), DimensionHelper.getStoryHeight(), 0, 0));
        } else {
            this.filterBuilder.withOverlayImage(null);
        }
        this.filterBuilder.trim(0, StoryCameraFragment.maxVideoPartDurationtInSecond * CloseCodes.NORMAL_CLOSURE);
        int xAfterScale = (int) this.frameLayoutTouchController.storyContainer.getXAfterScale();
        int yAfterScale = (int) this.frameLayoutTouchController.storyContainer.getYAfterScale();
        int widthAfterScale = (int) this.frameLayoutTouchController.storyContainer.getWidthAfterScale();
        int heightAfterScale = (int) this.frameLayoutTouchController.storyContainer.getHeightAfterScale();
        if (widthAfterScale == 0) {
            widthAfterScale = (int) this.mediaWidth;
            heightAfterScale = (int) this.mediaHeight;
        }
        if (!z) {
            this.filterBuilder.outputScaleSize(widthAfterScale, heightAfterScale).videoPosition(xAfterScale, yAfterScale);
        } else {
            int storyWidth = (xAfterScale * DimensionHelper.getStoryWidth()) / GLMediaRenderer.screenWidth;
            int storyHeight = (yAfterScale * DimensionHelper.getStoryHeight()) / GLMediaRenderer.screenHeight;
            this.filterBuilder.videoPosition(storyWidth, storyHeight);
            int storyWidth2 = (widthAfterScale * DimensionHelper.getStoryWidth()) / GLMediaRenderer.screenWidth;
            int storyHeight2 = (heightAfterScale * DimensionHelper.getStoryHeight()) / GLMediaRenderer.screenHeight;
            MyLog.e("Filter", "createCurrentFilter: adjustedScaleWidth = " + storyWidth2 + " -- adjustedScaleWidth = " + storyWidth2);
            MyLog.e("Filter", "adjusted xPos = " + storyWidth + " -- adjusted yPos = " + storyHeight);
            this.filterBuilder.outputScaleSize((float) storyWidth2, (float) storyHeight2);
        }
        this.filterBuilder.rotationAngle(this.frameLayoutTouchController.storyContainer.getRotation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareToSaveAndSend() throws IOException, SecurityException, IllegalArgumentException {
        String absolutePath;
        ArrayList<StoryEntityView> arrayList;
        if (this.mediaWidth <= 0.0f || this.path.isEmpty()) {
            return;
        }
        Bitmap overlayBitmap = this.frameLayoutTouchController.getOverlayBitmap();
        if (overlayBitmap == null || (((arrayList = this.frameLayoutTouchController.entityViewArray) == null || arrayList.size() <= 0) && !this.frameLayoutTouchController.hasPaint)) {
            absolutePath = null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                overlayBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                File file = new File(Utils.getImageTempFilePathPNG());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                absolutePath = file.getAbsolutePath();
                try {
                    MyLog.e("AddStoryFragment", "file overlay save ");
                } catch (FileNotFoundException e) {
                    e = e;
                    MyLog.e("AddStoryFragment", "File not found: " + e.getMessage());
                    createCurrentFilter(true, absolutePath);
                    RGHFilter rGHFilterBuildFilter = this.filterBuilder.buildFilter();
                    rGHFilterBuildFilter.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
                    createCurrentFilter(false, null);
                    RGHFilter rGHFilterBuildFilter2 = this.filterBuilder.buildFilter();
                    rGHFilterBuildFilter2.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
                    saveAndSend(this.path, rGHFilterBuildFilter2, rGHFilterBuildFilter, overlayBitmap, null);
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    createCurrentFilter(true, absolutePath);
                    RGHFilter rGHFilterBuildFilter3 = this.filterBuilder.buildFilter();
                    rGHFilterBuildFilter3.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
                    createCurrentFilter(false, null);
                    RGHFilter rGHFilterBuildFilter22 = this.filterBuilder.buildFilter();
                    rGHFilterBuildFilter22.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
                    saveAndSend(this.path, rGHFilterBuildFilter22, rGHFilterBuildFilter3, overlayBitmap, null);
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                absolutePath = null;
            } catch (IOException e4) {
                e = e4;
                absolutePath = null;
            }
        }
        createCurrentFilter(true, absolutePath);
        RGHFilter rGHFilterBuildFilter32 = this.filterBuilder.buildFilter();
        rGHFilterBuildFilter32.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
        createCurrentFilter(false, null);
        RGHFilter rGHFilterBuildFilter222 = this.filterBuilder.buildFilter();
        rGHFilterBuildFilter222.setFilterType(this.currentFilter.getFilterType(), this.currentFilter.reverseOrder);
        saveAndSend(this.path, rGHFilterBuildFilter222, rGHFilterBuildFilter32, overlayBitmap, null);
    }

    private void saveAndSend(String str, RGHFilter rGHFilter, RGHFilter rGHFilter2, Bitmap bitmap, String str2) throws SecurityException, IOException, IllegalArgumentException {
        MyLog.e("AddStoryFragment", "old method for save and send");
        if (isRendererAvailable()) {
            AddStoryMediaType addStoryMediaType = this.mediaType;
            AddStoryMediaType addStoryMediaType2 = AddStoryMediaType.Video;
            if (addStoryMediaType == addStoryMediaType2) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(ApplicationLoader.applicationActivity, Uri.fromFile(new File(str)));
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                j = strExtractMetadata != null ? Long.parseLong(strExtractMetadata) : 0L;
                int i = StoryCameraFragment.maxVideoPartDurationtInSecond;
                if (j > i * CloseCodes.NORMAL_CLOSURE) {
                    j = i * CloseCodes.NORMAL_CLOSURE;
                }
                mediaMetadataRetriever.release();
            }
            StoryObject storyObject = new StoryObject(this.glRenderer.getCurrentSceneState(), str, rGHFilter, rGHFilter2, this.mediaType == addStoryMediaType2, j, bitmap, this.backgroundPath, this.darkColor, this.lightColor);
            storyObject.localProfileId = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            storyObject.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            storyObject.entityArray = this.frameLayoutTouchController.entityViewArray;
            lambda$saveAndSend$0(storyObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAndSend() {
        createLocalStory(new StoryDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.AddStoryFragment.StoryDelegate
            public final void onCreateLocalStory(StoryObject storyObject) {
                this.f$0.lambda$saveAndSend$0(storyObject);
            }
        });
    }

    private void createLocalStory(final StoryDelegate storyDelegate) {
        if ((this.mediaWidth == 0.0f && this.path.isEmpty() && !isRendererAvailable()) || storyDelegate == null) {
            return;
        }
        Utilities.rubinoQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IOException, IllegalArgumentException {
                this.f$0.lambda$createLocalStory$2(storyDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createLocalStory$2(final StoryDelegate storyDelegate) throws SecurityException, IOException, IllegalArgumentException {
        final StoryObject storyObject;
        Bitmap overlayBitmap = this.frameLayoutTouchController.getOverlayBitmap();
        GLSceneState currentSceneState = this.eglThread.getFilterShader().getCurrentSceneState();
        if (this.mediaType == AddStoryMediaType.Video) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(ApplicationLoader.applicationActivity, Uri.fromFile(new File(this.path)));
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            long j = strExtractMetadata != null ? Long.parseLong(strExtractMetadata) : 0L;
            int i = StoryCameraFragment.maxVideoPartDurationtInSecond;
            if (j > i * CloseCodes.NORMAL_CLOSURE) {
                j = i * CloseCodes.NORMAL_CLOSURE;
            }
            mediaMetadataRetriever.release();
            this.videoInfo.startTime = currentSceneState.getVideoPlaybackStartTime();
            this.videoInfo.endTime = currentSceneState.getVideoPlaybackEndTime();
            VideoEditedInfo videoEditedInfo = this.videoInfo;
            videoEditedInfo.originalDuration = j * 1000;
            storyObject = new StoryObject(currentSceneState, this.path, overlayBitmap, videoEditedInfo);
        } else {
            storyObject = new StoryObject(currentSceneState, this.path, overlayBitmap, this.eglThread.getTexture());
        }
        storyObject.localProfileId = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        storyObject.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        storyObject.entityArray = this.frameLayoutTouchController.entityViewArray;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                storyDelegate.onCreateLocalStory(storyObject);
            }
        });
    }

    private StoryObject createLocalStoryFromVideoPart() {
        if (this.mediaType != AddStoryMediaType.Video || this.mediaWidth == 0.0f || this.path.isEmpty()) {
            return null;
        }
        StoryObject storyObject = new StoryObject(null, this.path, null);
        storyObject.story_type = StoryObject.StoryTypeEnum.Video;
        storyObject.localProfileId = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        storyObject.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        return storyObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scheduleSavingStoryObject, reason: merged with bridge method [inline-methods] */
    public void lambda$saveAndSend$0(final StoryObject storyObject) {
        addEntityItemIfNeeded(storyObject);
        SendStoryHelper.getInstance(this.currentAccount).doOrPutInQueueSendStory(storyObject);
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                AddStoryFragment.this.nextStep(storyObject.rnd);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEntityItemIfNeeded(StoryObject storyObject) {
        StoryObject storyObject2;
        String str;
        StoryObject storyObject3 = storyObject;
        ArrayList<StoryEntityView> arrayList = storyObject3.entityArray;
        if (arrayList != null) {
            Iterator<StoryEntityView> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryEntityView next = it.next();
                if (!next.isLock) {
                    StoryEntityView.TypeEnum typeEnum = next.type;
                    if (typeEnum == StoryEntityView.TypeEnum.poll) {
                        if (storyObject3.widget_story_list == null) {
                            storyObject3.widget_story_list = new ArrayList<>();
                        }
                        RectF rectF = new RectF();
                        rectF.left = next.pollSticker.getPollViewOffsetX();
                        rectF.top = next.pollSticker.getPollViewOffsetY();
                        float f = rectF.left;
                        PollSticker.PollStickerMode pollStickerMode = PollSticker.PollStickerMode.ADD_STORY;
                        rectF.right = f + PollSticker.getPollWidth(pollStickerMode);
                        rectF.bottom = rectF.top + PollSticker.getPollHeight(pollStickerMode);
                        float centerX = next.getCenterX();
                        float centerY = next.getCenterY();
                        float x = ((rectF.left + rectF.right) / 2.0f) + next.getX();
                        float y = ((rectF.bottom + rectF.top) / 2.0f) + next.getY();
                        double rotation = next.getRotation();
                        double d = x - centerX;
                        double dCos = Math.cos(Math.toRadians(rotation));
                        Double.isNaN(d);
                        double d2 = y - centerY;
                        double dSin = Math.sin(Math.toRadians(rotation));
                        Double.isNaN(d2);
                        double d3 = (dCos * d) - (dSin * d2);
                        double dSin2 = Math.sin(Math.toRadians(rotation));
                        Double.isNaN(d);
                        double d4 = d * dSin2;
                        double dCos2 = Math.cos(Math.toRadians(rotation));
                        Double.isNaN(d2);
                        double d5 = d4 + (d2 * dCos2);
                        double d6 = centerX;
                        Double.isNaN(d6);
                        double d7 = (float) (d3 + d6);
                        double d8 = centerY;
                        Double.isNaN(d8);
                        double d9 = (float) (d5 + d8);
                        double scaleX = next.getScaleX();
                        Double.isNaN(d6);
                        Double.isNaN(d7);
                        Double.isNaN(scaleX);
                        Double.isNaN(d6);
                        double d10 = d6 - (scaleX * (d6 - d7));
                        double scaleY = next.getScaleY();
                        Double.isNaN(d8);
                        Double.isNaN(d9);
                        Double.isNaN(scaleY);
                        Double.isNaN(d8);
                        float scaleX2 = (rectF.right - rectF.left) * next.getScaleX();
                        float scaleY2 = (rectF.bottom - rectF.top) * next.getScaleY();
                        storyObject3.widget_story_list.add(new WidgetStoryObject(next.entityItem.pollObject, new StoryPositionObject(this.mContext, (float) d10, (float) (d8 - (scaleY * (d8 - d9))), scaleX2, scaleY2, rotation)));
                    } else if (typeEnum == StoryEntityView.TypeEnum.emojiSlider) {
                        if (storyObject3.widget_story_list == null) {
                            storyObject3.widget_story_list = new ArrayList<>();
                        }
                        storyObject3.widget_story_list.add(new WidgetStoryObject(next.entityItem.emojiSliderObject, getPosition(next)));
                    } else if (typeEnum == StoryEntityView.TypeEnum.link) {
                        if (storyObject3.widget_story_list == null) {
                            storyObject3.widget_story_list = new ArrayList<>();
                        }
                        storyObject3.widget_story_list.add(new WidgetStoryObject(next.entityItem.storyLinkObject, getPosition(next)));
                    } else if (typeEnum == StoryEntityView.TypeEnum.post) {
                        if (storyObject3.widget_story_list == null) {
                            storyObject3.widget_story_list = new ArrayList<>();
                        }
                        storyObject3.widget_story_list.add(new WidgetStoryObject(next.entityItem.postObject, new StoryPositionObject(this.mContext, next.getCenterX(), next.getCenterY(), next.getWidthAfterScale(), next.getHeightAfterScale(), next.getRotation())));
                    } else {
                        String str2 = "#";
                        if (typeEnum == StoryEntityView.TypeEnum.hashtag) {
                            if (storyObject3.widget_story_list == null) {
                                storyObject3.widget_story_list = new ArrayList<>();
                            }
                            StoryPositionObject storyPositionObject = new StoryPositionObject(this.mContext, next.getCenterX(), next.getCenterY(), next.getWidthAfterScale(), next.getHeightAfterScale(), next.getRotation());
                            HashtagStoryObject hashtagStoryObject = new HashtagStoryObject(next.getText().trim().replace("#", BuildConfig.FLAVOR));
                            if (storyObject3.widget_story_list.size() < 20) {
                                storyObject3.widget_story_list.add(new WidgetStoryObject(hashtagStoryObject, storyPositionObject));
                            }
                        } else {
                            String str3 = "@";
                            if (typeEnum == StoryEntityView.TypeEnum.mention) {
                                if (storyObject3.widget_story_list == null) {
                                    storyObject3.widget_story_list = new ArrayList<>();
                                }
                                StoryPositionObject storyPositionObject2 = new StoryPositionObject(this.mContext, next.getCenterX(), next.getCenterY(), next.getWidthAfterScale(), next.getHeightAfterScale(), next.getRotation());
                                MentionStoryObject mentionStoryObject = new MentionStoryObject(next.getText().trim().replace("@", BuildConfig.FLAVOR));
                                if (storyObject3.widget_story_list.size() < 20) {
                                    storyObject3.widget_story_list.add(new WidgetStoryObject(mentionStoryObject, storyPositionObject2));
                                }
                            } else if (typeEnum == StoryEntityView.TypeEnum.text) {
                                Spannable spannable = next.textAttributeObject.spannableString;
                                boolean z = false;
                                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
                                int length = uRLSpanArr.length;
                                int i = 0;
                                while (i < length) {
                                    URLSpan uRLSpan = uRLSpanArr[i];
                                    int spanStart = spannable.getSpanStart(uRLSpan);
                                    int spanEnd = spannable.getSpanEnd(uRLSpan);
                                    Path path = new Path();
                                    next.textAttributeObject.layout.getSelectionPath(spanStart, spanEnd, path);
                                    RectF rectF2 = new RectF();
                                    path.computeBounds(rectF2, z);
                                    float centerX2 = next.getCenterX();
                                    float centerY2 = next.getCenterY();
                                    float x2 = ((rectF2.left + rectF2.right) / 2.0f) + next.getX();
                                    Iterator<StoryEntityView> it2 = it;
                                    float y2 = ((rectF2.bottom + rectF2.top) / 2.0f) + next.getY();
                                    Spannable spannable2 = spannable;
                                    URLSpan[] uRLSpanArr2 = uRLSpanArr;
                                    double rotation2 = next.getRotation();
                                    double d11 = x2 - centerX2;
                                    double dCos3 = Math.cos(Math.toRadians(rotation2));
                                    Double.isNaN(d11);
                                    int i2 = i;
                                    double d12 = y2 - centerY2;
                                    double dSin3 = Math.sin(Math.toRadians(rotation2));
                                    Double.isNaN(d12);
                                    double d13 = (dCos3 * d11) - (dSin3 * d12);
                                    double dSin4 = Math.sin(Math.toRadians(rotation2));
                                    Double.isNaN(d11);
                                    double d14 = d11 * dSin4;
                                    double dCos4 = Math.cos(Math.toRadians(rotation2));
                                    Double.isNaN(d12);
                                    double d15 = d14 + (d12 * dCos4);
                                    double d16 = centerX2;
                                    Double.isNaN(d16);
                                    String str4 = str3;
                                    double d17 = (float) (d13 + d16);
                                    double d18 = centerY2;
                                    Double.isNaN(d18);
                                    double d19 = (float) (d15 + d18);
                                    int i3 = length;
                                    String str5 = str2;
                                    double scaleX3 = next.getScaleX();
                                    Double.isNaN(d16);
                                    Double.isNaN(d17);
                                    Double.isNaN(scaleX3);
                                    Double.isNaN(d16);
                                    double d20 = d16 - (scaleX3 * (d16 - d17));
                                    double scaleY3 = next.getScaleY();
                                    Double.isNaN(d18);
                                    Double.isNaN(d19);
                                    Double.isNaN(scaleY3);
                                    Double.isNaN(d18);
                                    float scaleX4 = (rectF2.right - rectF2.left) * next.getScaleX();
                                    float scaleY4 = (rectF2.bottom - rectF2.top) * next.getScaleY();
                                    StoryPositionObject storyPositionObject3 = new StoryPositionObject(this.mContext, (float) d20, (float) (d18 - (scaleY3 * (d18 - d19))), scaleX4, scaleY4, rotation2);
                                    String url = uRLSpan.getURL();
                                    if (url.startsWith(str5)) {
                                        HashtagStoryObject hashtagStoryObject2 = new HashtagStoryObject(url.substring(1));
                                        storyObject2 = storyObject;
                                        if (storyObject2.widget_story_list == null) {
                                            storyObject2.widget_story_list = new ArrayList<>();
                                        }
                                        if (storyObject2.widget_story_list.size() < 20) {
                                            storyObject2.widget_story_list.add(new WidgetStoryObject(hashtagStoryObject2, storyPositionObject3));
                                            str = str4;
                                        } else {
                                            str = str4;
                                        }
                                    } else {
                                        storyObject2 = storyObject;
                                        str = str4;
                                        if (url.startsWith(str)) {
                                            MentionStoryObject mentionStoryObject2 = new MentionStoryObject(url.substring(1));
                                            if (storyObject2.widget_story_list == null) {
                                                storyObject2.widget_story_list = new ArrayList<>();
                                            }
                                            if (storyObject2.widget_story_list.size() < 20) {
                                                storyObject2.widget_story_list.add(new WidgetStoryObject(mentionStoryObject2, storyPositionObject3));
                                            }
                                        }
                                    }
                                    i = i2 + 1;
                                    str2 = str5;
                                    str3 = str;
                                    storyObject3 = storyObject2;
                                    it = it2;
                                    spannable = spannable2;
                                    uRLSpanArr = uRLSpanArr2;
                                    length = i3;
                                    z = false;
                                }
                            }
                        }
                    }
                    storyObject3 = storyObject3;
                    it = it;
                }
            }
        }
    }

    private StoryPositionObject getPosition(StoryEntityView storyEntityView) {
        return new StoryPositionObject(this.mContext, storyEntityView.getCenterX(), storyEntityView.getCenterY(), storyEntityView.getWidthAfterScale(), storyEntityView.getHeightAfterScale(), storyEntityView.getRotation());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:21:0x0032
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0010, B:9:0x0016, B:11:0x001c, B:12:0x0022, B:14:0x0026, B:15:0x002d), top: B:25:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void nextStep(int r4) {
        /*
            r3 = this;
            r3.onPauseGl()
            r0 = 0
            boolean r1 = r3.isRendererAvailable()     // Catch: java.lang.Exception -> L32
            if (r1 == 0) goto L32
            boolean r1 = ir.appp.rghapp.Utils.useNewStoryCreationSystem()     // Catch: java.lang.Exception -> L32
            if (r1 == 0) goto L2d
            ir.resaneh1.iptv.fragment.AddStoryMediaType r1 = r3.mediaType     // Catch: java.lang.Exception -> L32
            ir.resaneh1.iptv.fragment.AddStoryMediaType r2 = ir.resaneh1.iptv.fragment.AddStoryMediaType.Video     // Catch: java.lang.Exception -> L32
            if (r1 != r2) goto L22
            android.view.TextureView r1 = r3.mediaTextureView     // Catch: java.lang.Exception -> L32
            boolean r2 = r1 instanceof ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView     // Catch: java.lang.Exception -> L32
            if (r2 == 0) goto L22
            ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView r1 = (ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView) r1     // Catch: java.lang.Exception -> L32
            r1.release()     // Catch: java.lang.Exception -> L32
            goto L32
        L22:
            ir.appp.rghapp.rubinoPostSlider.FilterGLThread r1 = r3.eglThread     // Catch: java.lang.Exception -> L32
            if (r1 == 0) goto L32
            r1.shutdown()     // Catch: java.lang.Exception -> L32
            r1 = 0
            r3.eglThread = r1     // Catch: java.lang.Exception -> L32
            goto L32
        L2d:
            ir.appp.rghapp.GLMediaRenderer r1 = r3.glRenderer     // Catch: java.lang.Exception -> L32
            r1.destroyGLComponents(r0)     // Catch: java.lang.Exception -> L32
        L32:
            org.rbmain.ui.LaunchActivity r1 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> L45
            org.rbmain.ui.ActionBar.BaseFragment r1 = r1.getSecondLastFragment()     // Catch: java.lang.Exception -> L45
            boolean r1 = r1 instanceof ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L45
            org.rbmain.ui.LaunchActivity r1 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> L45
            org.rbmain.ui.ActionBar.BaseFragment r1 = r1.getSecondLastFragment()     // Catch: java.lang.Exception -> L45
            r1.removeSelfFromStack()     // Catch: java.lang.Exception -> L45
        L45:
            ir.resaneh1.iptv.fragment.StorySeenFragment r1 = new ir.resaneh1.iptv.fragment.StorySeenFragment
            ir.resaneh1.iptv.helper.StoryController$StoryIdObject r2 = new ir.resaneh1.iptv.helper.StoryController$StoryIdObject
            r2.<init>(r4)
            r1.<init>(r2, r0)
            r4 = 1
            r3.presentFragment(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.AddStoryFragment.nextStep(int):void");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() throws Throwable {
        super.init();
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            toggleFullscreenSwitch(true);
        }
        lockOrientationPortrait();
        this.isNeedLifecycleObservable = true;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.screenWidth = DimensionHelper.getScreenMinDimension(ApplicationLoader.applicationActivity);
        this.screenHeight = DimensionHelper.getScreenMaxDimension(ApplicationLoader.applicationActivity);
        this.swipeBackEnabled = false;
        this.progressBar.setVisibility(4);
        if (ApplicationLoader.applicationActivity != null) {
            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
            UI_rubinoFilterView uI_rubinoFilterView = new UI_rubinoFilterView();
            this.filterView = uI_rubinoFilterView;
            uI_rubinoFilterView.createView((Activity) this.mContext, 11, new UI_rubinoFilterView.ScrollListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.3
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoFilterView.ScrollListener
                public void onScrollX(int i, float f) {
                    try {
                        AddStoryFragment.this.onFilterProgressChange(i, f);
                    } catch (Exception unused) {
                    }
                }

                @Override // ir.resaneh1.iptv.UIView.UI_rubinoFilterView.ScrollListener
                public void onPageSelected(int i, boolean z) {
                    int i2 = (i % 11) + 1;
                    if (i2 < 0) {
                        i2 += 11;
                    }
                    String str = BuildConfig.FLAVOR;
                    if (i2 == 1) {
                        str = RGHFilter.FilterType.None + BuildConfig.FLAVOR;
                    } else if (i2 == 2) {
                        str = RGHFilter.FilterType.BlackAndWhite + BuildConfig.FLAVOR;
                    } else if (i2 == 3) {
                        str = RGHFilter.FilterType.Greish + BuildConfig.FLAVOR;
                    } else if (i2 == 4) {
                        str = RGHFilter.FilterType.Happy + BuildConfig.FLAVOR;
                    } else if (i2 == 5) {
                        str = RGHFilter.FilterType.Dark + BuildConfig.FLAVOR;
                    } else if (i2 == 6) {
                        str = RGHFilter.FilterType.BuenosAires + BuildConfig.FLAVOR;
                    } else if (i2 == 7) {
                        str = RGHFilter.FilterType.Tokyo + BuildConfig.FLAVOR;
                    } else if (i2 == 8) {
                        str = RGHFilter.FilterType.Menegol + BuildConfig.FLAVOR;
                    } else if (i2 == 9) {
                        str = RGHFilter.FilterType.Cold + BuildConfig.FLAVOR;
                    } else if (i2 == 10) {
                        str = RGHFilter.FilterType.Pinky + BuildConfig.FLAVOR;
                    } else if (i2 == 11) {
                        str = RGHFilter.FilterType.Sepia + BuildConfig.FLAVOR;
                    }
                    if (AddStoryFragment.this.frameLayoutTouchController == null || AddStoryFragment.this.frameLayoutTouchController.textViewFilter == null) {
                        return;
                    }
                    AddStoryFragment.this.frameLayoutTouchController.textViewFilter.setText(str);
                    if (z) {
                        AddStoryFragment.this.frameLayoutTouchController.startFilterTextViewAnimation(true);
                        if (AddStoryFragment.this.pageSelectedDisposable != null) {
                            AddStoryFragment.this.pageSelectedDisposable.dispose();
                        }
                        AddStoryFragment.this.pageSelectedDisposable = (DisposableObserver) Observable.timer(1000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.3.1
                            @Override // io.reactivex.Observer
                            public void onComplete() {
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                            }

                            @Override // io.reactivex.Observer
                            public void onNext(Long l) {
                                AddStoryFragment.this.frameLayoutTouchController.startFilterTextViewAnimation(false);
                            }
                        });
                        AddStoryFragment addStoryFragment = AddStoryFragment.this;
                        ((PresenterFragment) addStoryFragment).compositeDisposable.add(addStoryFragment.pageSelectedDisposable);
                        return;
                    }
                    AddStoryFragment.this.filterView.showText = true;
                }
            });
            this.mainFrameLayout.addView(this.filterView.view, LayoutHelper.createFrame(-1, -1, 17));
            FrameLayoutTouchable frameLayoutTouchable = new FrameLayoutTouchable(launchActivity, this.screenWidth, this.screenHeight);
            this.frameLayoutTouchController = frameLayoutTouchable;
            frameLayoutTouchable.setBackgroundColor(0);
            this.mainFrameLayout.addView(this.frameLayoutTouchController, LayoutHelper.createFrame(-1, -1, 17));
            this.frameLayoutTouchController.init();
            if (this.mediaType == AddStoryMediaType.None && isVideoPostWidget()) {
                this.path = getWidgetFilePath();
                this.mediaType = AddStoryMediaType.Video;
            }
            initMedia();
        }
    }

    private void initMedia() throws Throwable {
        String str = this.path;
        if (str != null) {
            if (this.mediaType == AddStoryMediaType.Video) {
                createVideoSizeFrame(str);
                if (Utils.useNewStoryCreationSystem()) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(ApplicationLoader.applicationActivity, Uri.fromFile(new File(this.path)));
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    long j = strExtractMetadata != null ? Long.parseLong(strExtractMetadata) : 0L;
                    int i = StoryCameraFragment.maxVideoPartDurationtInSecond;
                    if (j > i * CloseCodes.NORMAL_CLOSURE) {
                        int iMin = (int) Math.min(4.0d, Math.ceil((j * 1.0f) / (i * 1000.0f)));
                        if ((j / 1000) - ((iMin - 1) * StoryCameraFragment.maxVideoPartDurationtInSecond) <= StoryCameraFragment.minVideoDurationInSecond) {
                            iMin--;
                        }
                        if (iMin > 1 && !isVideoPostWidget()) {
                            createMultiFileView(iMin, j);
                        }
                    }
                    mediaMetadataRetriever.release();
                    return;
                }
                return;
            }
            createImageSizeFrame(str);
            return;
        }
        if (this.mediaType != AddStoryMediaType.None || this.initWidget == null) {
            return;
        }
        this.frameLayoutTouchController.imageViewStory.setImageResource(R.color.transparent);
    }

    private void createMultiFileView(int i, long j) {
        this.isMultiFile = true;
        ((FrameLayout.LayoutParams) this.frameLayoutTouchController.bottomContainer.getLayoutParams()).bottomMargin = 0;
        this.frameLayoutTouchController.linearLayoutMultiFileView.removeAllViews();
        this.frameLayoutTouchController.multiFileCellArray = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            AddStoryBottomView.LocalStoryFileCell localStoryFileCell = new AddStoryBottomView.LocalStoryFileCell(this.mContext);
            if (i2 == 0) {
                localStoryFileCell.setSelected(true);
            }
            long j2 = i2 * StoryCameraFragment.maxVideoPartDurationtInSecond * CloseCodes.NORMAL_CLOSURE;
            localStoryFileCell.setStory(createLocalStoryFromVideoPart(), i2, j2, Math.min((r4 * CloseCodes.NORMAL_CLOSURE) + j2, j));
            saveLocalStoryAttr(localStoryFileCell, false);
            this.frameLayoutTouchController.linearLayoutMultiFileView.addView(localStoryFileCell, LayoutHelper.createFrame(-2, -2.0f, 3, 4.0f, 8.0f, 4.0f, 8.0f));
            this.frameLayoutTouchController.multiFileCellArray.add(localStoryFileCell);
            localStoryFileCell.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final AddStoryBottomView.LocalStoryFileCell localStoryFileCell2 = (AddStoryBottomView.LocalStoryFileCell) view;
                    if (localStoryFileCell2.isSelected) {
                        if (AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.size() > 1) {
                            AddStoryFragment.this.frameLayoutTouchController.multiFileView.setOptionMode(!AddStoryFragment.this.frameLayoutTouchController.multiFileView.isInOptionMode);
                            return;
                        } else {
                            AddStoryFragment.this.frameLayoutTouchController.multiFileView.setOptionMode(false);
                            return;
                        }
                    }
                    AddStoryFragment.this.frameLayoutTouchController.multiFileView.setOptionMode(false);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.size()) {
                            break;
                        }
                        AddStoryBottomView.LocalStoryFileCell localStoryFileCell3 = AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.get(i3);
                        if (localStoryFileCell3.isSelected) {
                            if (localStoryFileCell3.isNeededToSave) {
                                AddStoryFragment.this.saveLocalStoryAttr(localStoryFileCell3, false);
                                localStoryFileCell3.isNeededToSave = false;
                            }
                            localStoryFileCell3.setSelected(false);
                        } else {
                            i3++;
                        }
                    }
                    localStoryFileCell2.setSelected(true);
                    if (AddStoryFragment.this.loadDisposable != null) {
                        AddStoryFragment.this.loadDisposable.dispose();
                    }
                    AddStoryFragment.this.loadDisposable = (DisposableObserver) Observable.timer(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.4.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Long l) throws Resources.NotFoundException {
                            AddStoryFragment.this.onSelectStory(localStoryFileCell2);
                        }
                    });
                    AddStoryFragment addStoryFragment = AddStoryFragment.this;
                    ((PresenterFragment) addStoryFragment).compositeDisposable.add(addStoryFragment.loadDisposable);
                }
            });
        }
        this.frameLayoutTouchController.multiFileView.deleteView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws Resources.NotFoundException {
                int iIndexOf;
                AddStoryFragment.this.frameLayoutTouchController.multiFileView.setOptionMode(false);
                if (AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.size() <= 1) {
                    return;
                }
                Iterator<AddStoryBottomView.LocalStoryFileCell> it = AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        iIndexOf = 0;
                        break;
                    }
                    AddStoryBottomView.LocalStoryFileCell next = it.next();
                    if (next.isSelected) {
                        iIndexOf = AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.indexOf(next);
                        AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.remove(next);
                        AddStoryFragment.this.frameLayoutTouchController.linearLayoutMultiFileView.removeView(next);
                        break;
                    }
                }
                int i3 = iIndexOf - 1;
                AddStoryBottomView.LocalStoryFileCell localStoryFileCell2 = AddStoryFragment.this.frameLayoutTouchController.multiFileCellArray.get(i3 >= 0 ? i3 : 0);
                localStoryFileCell2.setSelected(true);
                AddStoryFragment.this.onSelectStory(localStoryFileCell2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectStory(AddStoryBottomView.LocalStoryFileCell localStoryFileCell) throws Resources.NotFoundException {
        this.currentFilter = null;
        loadLocalStory(localStoryFileCell.localStory, localStoryFileCell.index, localStoryFileCell.startTime);
        localStoryFileCell.isNeededToSave = true;
    }

    private void loadLocalStory(StoryObject storyObject, int i, long j) throws Resources.NotFoundException {
        if (storyObject == null) {
            return;
        }
        RGHFilter rGHFilter = storyObject.rghFilter;
        this.currentFilter = rGHFilter;
        if (rGHFilter != null) {
            this.currentIndicator = rGHFilter.filterUiIndicator;
        } else {
            this.currentIndicator = -1;
        }
        int currentItem = this.filterView.viewPager.getCurrentItem();
        int i2 = currentItem % 11;
        int i3 = this.currentIndicator;
        int i4 = i3 - 1;
        if (i3 == -1) {
            i4 = 0;
        }
        int i5 = currentItem + (i4 - i2);
        this.filterView.showText = false;
        DisposableObserver disposableObserver = this.pageSelectedDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        this.frameLayoutTouchController.textViewFilter.setVisibility(4);
        this.filterView.viewPager.setCurrentItem(i5, false);
        this.frameLayoutTouchController.storyContainer.setByAttr(storyObject.entityViewAttr);
        this.frameLayoutTouchController.frameLayoutEntityContainer.removeAllViews();
        this.frameLayoutTouchController.entityViewArray.clear();
        ArrayList<StoryEntityView> arrayList = storyObject.entityArray;
        if (arrayList != null) {
            Iterator<StoryEntityView> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryEntityView next = it.next();
                this.frameLayoutTouchController.addEntityView(next, next.lastLayoutParams);
            }
        }
        this.frameLayoutTouchController.clearAndDrawPaintPath(storyObject.paintPaths);
        if (Utils.useNewStoryCreationSystem() && isRendererAvailable()) {
            TextureView textureView = this.mediaTextureView;
            if (textureView != null) {
                this.frameLayoutTouchController.removeView(textureView);
                TextureView textureView2 = this.mediaTextureView;
                if (textureView2 instanceof VideoEditTextureView) {
                    ((VideoEditTextureView) textureView2).release();
                }
                this.mediaTextureView = null;
                this.eglThread.shutdown();
                this.eglThread = null;
                this.videoPlayer.releasePlayer();
            }
            initGl(i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLocalStoryAttr(AddStoryBottomView.LocalStoryFileCell localStoryFileCell, boolean z) {
        StoryObject storyObject;
        FilterGLThread filterGLThread;
        if (localStoryFileCell == null || (storyObject = localStoryFileCell.localStory) == null) {
            return;
        }
        storyObject.entityArray = new ArrayList<>();
        ArrayList<StoryEntityView> arrayList = this.frameLayoutTouchController.entityViewArray;
        if (arrayList != null) {
            Iterator<StoryEntityView> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryEntityView next = it.next();
                next.lastLayoutParams = (FrameLayout.LayoutParams) next.getLayoutParams();
                storyObject.entityArray.add(next);
            }
        }
        if (localStoryFileCell.inited) {
            storyObject.entityViewAttr = this.frameLayoutTouchController.storyContainer.getAttr();
        }
        storyObject.paintPaths = new ArrayList<>();
        if (this.frameLayoutTouchController.paintView.paths != null) {
            storyObject.paintPaths.addAll(this.frameLayoutTouchController.paintView.paths);
        }
        storyObject.overlay = this.frameLayoutTouchController.getOverlayBitmap();
        if (Utils.useNewStoryCreationSystem() && (filterGLThread = this.eglThread) != null && localStoryFileCell.glSceneInitiated) {
            storyObject.glSceneState = filterGLThread.getFilterShader().getCurrentSceneState();
            RGHFilter rGHFilter = this.currentFilter;
            if (rGHFilter != null) {
                storyObject.rghFilter = rGHFilter;
                rGHFilter.filterUiIndicator = this.currentIndicator;
            }
            if (z) {
                this.currentFilter = null;
            }
        }
    }

    public void setMediaAndInit(String str, boolean z) throws Throwable {
        this.path = str;
        this.mediaType = z ? AddStoryMediaType.Video : AddStoryMediaType.Picture;
        initMedia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void glSceneOnStartPreparation(int i, long j) {
        ArrayList<AddStoryBottomView.LocalStoryFileCell> arrayList;
        ArrayList<AddStoryBottomView.LocalStoryFileCell> arrayList2;
        try {
            if (isRendererAvailable()) {
                this.eglThread.getFilterShader().setMediaCoordinationInfo(this.currentFilter.getOutputScaleWidth(), this.currentFilter.getOutputScaleHeight(), this.currentFilter.getxPosInContainer(), this.currentFilter.getyPosInContainer(), this.currentFilter.getRotationAngle());
                this.eglThread.getFilterShader().setFilterType(this.currentFilter.getFilterType());
                this.eglThread.getFilterShader().setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
                this.eglThread.getFilterShader().setVideoTimeLimit(j, Math.min((StoryCameraFragment.maxVideoPartDurationtInSecond * CloseCodes.NORMAL_CLOSURE) + j, this.videoPlayer.getDuration()));
                this.eglThread.getFilterShader().setSaturation(this.currentFilter.getSaturation());
                this.eglThread.getFilterShader().setContrast(this.currentFilter.getContrast());
                this.eglThread.getFilterShader().setBrightness(this.currentFilter.getBrightness());
                this.eglThread.getFilterShader().setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
            }
            this.frameLayoutTouchController.textViewFilter.setText(this.currentFilter.getFilterType() + BuildConfig.FLAVOR);
            StoryEntityView storyEntityView = this.frameLayoutTouchController.storyContainer;
            storyEntityView.saveCurrentPosition((int) storyEntityView.getX(), (int) this.frameLayoutTouchController.storyContainer.getY());
            this.frameLayoutTouchController.storyContainer.saveCurrentScaleAndRotation();
            StoryEntityView storyEntityView2 = this.postView;
            if (storyEntityView2 != null) {
                storyEntityView2.saveCurrentPosition((int) storyEntityView2.getX(), (int) this.postView.getY());
                this.postView.saveCurrentScaleAndRotation();
            }
            if (i == 0 && Utils.useNewStoryCreationSystem() && this.isMultiFile && (arrayList2 = this.frameLayoutTouchController.multiFileCellArray) != null) {
                try {
                    Iterator<AddStoryBottomView.LocalStoryFileCell> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        AddStoryBottomView.LocalStoryFileCell next = it.next();
                        if (!next.inited) {
                            next.inited = true;
                            next.localStory.entityViewAttr = this.frameLayoutTouchController.storyContainer.getAttr();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (isRendererAvailable()) {
                if (this.postView != null) {
                    this.eglThread.getFilterShader().setScale(this.postView.getVideoWidthAfterScale(), this.postView.getVideoHeightAfterScale());
                    this.eglThread.getFilterShader().setMediaPosition(this.postView.getVideoXAfterScale(), this.postView.getVideoYAfterScale());
                    this.eglThread.getFilterShader().setMediaRotation(this.postView.getRotation());
                } else {
                    this.eglThread.getFilterShader().setScale(this.frameLayoutTouchController.storyContainer.getWidthAfterScale(), this.frameLayoutTouchController.storyContainer.getHeightAfterScale());
                    this.eglThread.getFilterShader().setMediaPosition(this.frameLayoutTouchController.storyContainer.getXAfterScale(), this.frameLayoutTouchController.storyContainer.getYAfterScale());
                    this.eglThread.getFilterShader().setMediaRotation(this.frameLayoutTouchController.storyContainer.getRotation());
                }
                this.eglThread.requestRender();
            }
            fillLocalStoriesWithDefaultValues();
            if (!this.isMultiFile || (arrayList = this.frameLayoutTouchController.multiFileCellArray) == null) {
                return;
            }
            Iterator<AddStoryBottomView.LocalStoryFileCell> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                VideoEditedInfo videoEditedInfo = it2.next().localStory.videoEditedInfo;
                if (videoEditedInfo != null) {
                    VideoEditedInfo videoEditedInfo2 = this.videoInfo;
                    videoEditedInfo.originalHeight = videoEditedInfo2.originalHeight;
                    videoEditedInfo.originalWidth = videoEditedInfo2.originalWidth;
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void preparePlayer(long j) {
        this.videoPlayer.preparePlayer(Uri.fromFile(new File(this.path)), "other");
        this.videoPlayer.setPlayWhenReady(true);
        this.videoPlayer.seekTo(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGl(int i, long j) {
        boolean z = this.mediaType == AddStoryMediaType.Video;
        if (this.postView != null) {
            this.frameLayoutTouchController.storyContainer.getLayoutParams().width = (int) this.postView.getVideoWidthAfterScale();
            this.frameLayoutTouchController.storyContainer.getLayoutParams().height = (int) this.postView.getVideoHeightAfterScale();
            ((FrameLayout.LayoutParams) this.frameLayoutTouchController.storyContainer.getLayoutParams()).gravity = 17;
            this.frameLayoutTouchController.storyContainer.setY(this.frameLayoutTouchController.storyContainer.getY() - ((((View) this.frameLayoutTouchController.storyContainer.getParent()).getHeight() - ((View) this.postView.getParent()).getHeight()) / 2));
        }
        if (this.currentFilter == null) {
            FilterBuilder filterBuilder = new FilterBuilder();
            this.filterBuilder = filterBuilder;
            filterBuilder.imageMedia(!z);
            if (!z) {
                this.filterBuilder.originalRotationAngle(Utils.getImageRotation(this.path));
            }
            createCurrentFilter(false, null);
            RGHFilter rGHFilterBuildFilter = this.filterBuilder.buildFilter();
            this.currentFilter = rGHFilterBuildFilter;
            rGHFilterBuildFilter.setFilterType(RGHFilter.FilterType.None, false);
        }
        if (z) {
            VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
            this.videoInfo = videoEditedInfo;
            videoEditedInfo.originalPath = this.path;
            videoEditedInfo.resultWidth = RGHFilter.OUTPUT_WIDTH;
            videoEditedInfo.resultHeight = RGHFilter.OUTPUT_HEIGHT;
            videoEditedInfo.framerate = 25;
            videoEditedInfo.bitrate = 2500000;
            videoEditedInfo.videoConvertFirstWrite = true;
            videoEditedInfo.isPhoto = false;
            videoEditedInfo.start = 0.0f;
            if (MyLog.isDebugAble) {
                videoEditedInfo.endTime = 2000L;
            }
            videoEditedInfo.paintPath = null;
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            videoPlayer.setDelegate(new AnonymousClass6(i, j));
            VideoEditTextureView videoEditTextureView = new VideoEditTextureView(getContext(), this.videoPlayer);
            this.mediaTextureView = videoEditTextureView;
            videoEditTextureView.setDelegate(new VideoEditTextureView.VideoEditTextureViewDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$$ExternalSyntheticLambda0
                @Override // ir.appp.rghapp.rubinoPostSlider.VideoEditTextureView.VideoEditTextureViewDelegate
                public final void onEGLThreadAvailable(FilterGLThread filterGLThread) {
                    this.f$0.lambda$initGl$3(filterGLThread);
                }
            });
            this.mediaTextureView.setPivotX(0.0f);
            this.mediaTextureView.setPivotY(0.0f);
            this.mediaTextureView.setOpaque(false);
        } else {
            AddStoryMediaType addStoryMediaType = this.mediaType;
            AddStoryMediaType addStoryMediaType2 = AddStoryMediaType.Picture;
            if (addStoryMediaType == addStoryMediaType2 || addStoryMediaType == AddStoryMediaType.None) {
                String widgetFilePath = addStoryMediaType == addStoryMediaType2 ? this.path : getWidgetFilePath();
                if (widgetFilePath.isEmpty()) {
                    return;
                }
                this.imageOriginalRotation = this.mediaType == addStoryMediaType2 ? Utils.getImageRotation(widgetFilePath) : 0;
                this.mediaTextureView = new TextureView(getContext());
            }
        }
        this.frameLayoutTouchController.addView(this.mediaTextureView, 0, new ViewGroup.LayoutParams((int) DimensionHelper.getStoryViewWidthPx((Activity) this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) this.mContext)));
        if (z) {
            preparePlayer(j);
            return;
        }
        AddStoryMediaType addStoryMediaType3 = this.mediaType;
        AddStoryMediaType addStoryMediaType4 = AddStoryMediaType.Picture;
        if (addStoryMediaType3 == addStoryMediaType4 || addStoryMediaType3 == AddStoryMediaType.None) {
            String widgetFilePath2 = addStoryMediaType3 == addStoryMediaType4 ? this.path : getWidgetFilePath();
            if (this.mediaType == addStoryMediaType4) {
                this.imageBitmap = Utils.loadBitmapForOpenGL(getContext(), this.path, false, AndroidUtilities.getScreenWidth(), true);
            } else {
                this.imageBitmap = null;
            }
            this.mediaTextureView.setSurfaceTextureListener(new AnonymousClass7(widgetFilePath2));
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.AddStoryFragment$6, reason: invalid class name */
    class AnonymousClass6 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ int val$index;
        final /* synthetic */ long val$startTime;

        @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, int i, boolean z2) {
        }

        AnonymousClass6(int i, long j) {
            this.val$index = i;
            this.val$startTime = j;
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) throws IOException {
            if (AddStoryFragment.this.mediaTextureView != null && (AddStoryFragment.this.mediaTextureView instanceof VideoEditTextureView)) {
                ((VideoEditTextureView) AddStoryFragment.this.mediaTextureView).setVideoSize((int) (i * f), i2);
            }
            AddStoryFragment.this.videoInfo.originalHeight = i2;
            AddStoryFragment.this.videoInfo.originalWidth = i;
            AddStoryFragment.this.didLoadVideoSize = true;
            AddStoryFragment.this.glSceneOnStartPreparation(this.val$index, this.val$startTime);
            if (Utils.useNewStoryCreationSystem()) {
                return;
            }
            Utils.createGradientBackground(ApplicationLoader.applicationContext, AddStoryFragment.this.path, false, new BackgroundGenerationListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$6$$ExternalSyntheticLambda0
                @Override // ir.appp.rghapp.BackgroundGenerationListener
                public final void onGradientBackgroundGenerated(String str) {
                    this.f$0.lambda$onVideoSizeChanged$0(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onVideoSizeChanged$0(String str) {
            if (AddStoryFragment.this.isRendererAvailable()) {
                AddStoryFragment.this.eglThread.getFilterShader().setBackgroundImagePath(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGl$3(FilterGLThread filterGLThread) {
        this.eglThread = filterGLThread;
        fillLocalStoriesWithDefaultValues();
    }

    /* renamed from: ir.resaneh1.iptv.fragment.AddStoryFragment$7, reason: invalid class name */
    class AnonymousClass7 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ String val$internalMediaPath;

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass7(String str) {
            this.val$internalMediaPath = str;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (AddStoryFragment.this.eglThread != null || surfaceTexture == null) {
                return;
            }
            if (AddStoryFragment.this.mediaType == AddStoryMediaType.Picture) {
                AddStoryFragment.this.eglThread = new FilterGLThread(surfaceTexture, AddStoryFragment.this.imageBitmap, this.val$internalMediaPath, AddStoryFragment.this.imageOriginalRotation, false, RGHFilter.OUTPUT_WIDTH, RGHFilter.OUTPUT_HEIGHT);
            } else {
                AddStoryFragment.this.eglThread = new FilterGLThread(surfaceTexture, this.val$internalMediaPath, RGHFilter.OUTPUT_WIDTH, RGHFilter.OUTPUT_HEIGHT);
            }
            AddStoryFragment.this.eglThread.setSurfaceTextureSize(i, i2);
            AddStoryFragment.this.eglThread.requestRender(true, false);
            AddStoryFragment.this.glSceneOnStartPreparation(0, 0L);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (AddStoryFragment.this.eglThread != null) {
                AddStoryFragment.this.eglThread.setSurfaceTextureSize(i, i2);
                AddStoryFragment.this.eglThread.requestRender(true, false);
                AddStoryFragment.this.eglThread.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSurfaceTextureSizeChanged$0();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$0() {
            if (AddStoryFragment.this.eglThread != null) {
                AddStoryFragment.this.eglThread.requestRender(true, false);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (AddStoryFragment.this.eglThread == null) {
                return true;
            }
            AddStoryFragment.this.eglThread.shutdown();
            AddStoryFragment.this.eglThread = null;
            return true;
        }
    }

    private String getWidgetFilePath() {
        RubinoPostObject rubinoPostObject;
        PhotoSlideObject photoSlideObject;
        WidgetStoryObject widgetStoryObject = this.initWidget;
        if (widgetStoryObject == null || (rubinoPostObject = widgetStoryObject.rubinoPostObject) == null || (photoSlideObject = rubinoPostObject.photoSlideObject) == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            String path = this.initWidget.rubinoPostObject.photoSlideObject.getPhotos().get(photoSlideObject.getCurrentIndex()).getDownloadFile().getPath();
            return new File(path).exists() ? path : BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVideoPostWidget() {
        WidgetStoryObject widgetStoryObject;
        RubinoPostObject rubinoPostObject;
        PhotoSlideObject photoSlideObject;
        if (!Utils.useNewStoryCreationSystem() || (widgetStoryObject = this.initWidget) == null || (rubinoPostObject = widgetStoryObject.rubinoPostObject) == null || (photoSlideObject = rubinoPostObject.photoSlideObject) == null) {
            return false;
        }
        try {
            if (!this.initWidget.rubinoPostObject.photoSlideObject.getPhotos().get(photoSlideObject.getCurrentIndex()).isVideo || getWidgetFilePath() == null) {
                return false;
            }
            return !getWidgetFilePath().isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    private void fillLocalStoriesWithDefaultValues() {
        if (isRendererAvailable() && this.isMultiFile && this.didLoadVideoSize && !this.didSetDefaultValues) {
            this.didSetDefaultValues = true;
            ArrayList<AddStoryBottomView.LocalStoryFileCell> arrayList = this.frameLayoutTouchController.multiFileCellArray;
            if (arrayList != null) {
                Iterator<AddStoryBottomView.LocalStoryFileCell> it = arrayList.iterator();
                while (it.hasNext()) {
                    AddStoryBottomView.LocalStoryFileCell next = it.next();
                    if (!next.glSceneInitiated) {
                        next.glSceneInitiated = true;
                        next.localStory.glSceneState = this.eglThread.getFilterShader().getCurrentSceneState();
                        StoryObject storyObject = next.localStory;
                        GLSceneState gLSceneState = storyObject.glSceneState;
                        gLSceneState.videoPlaybackStartTime = next.startTime;
                        gLSceneState.videoPlaybackEndTime = next.endTime;
                        storyObject.rghFilter = this.currentFilter.m288clone();
                        StoryObject storyObject2 = next.localStory;
                        storyObject2.rghFilter.filterUiIndicator = 1;
                        storyObject2.videoEditedInfo = new VideoEditedInfo();
                        StoryObject storyObject3 = next.localStory;
                        VideoEditedInfo videoEditedInfo = storyObject3.videoEditedInfo;
                        videoEditedInfo.originalPath = this.path;
                        videoEditedInfo.resultWidth = RGHFilter.OUTPUT_WIDTH;
                        videoEditedInfo.resultHeight = RGHFilter.OUTPUT_HEIGHT;
                        videoEditedInfo.framerate = 30;
                        videoEditedInfo.bitrate = 2500000;
                        videoEditedInfo.videoConvertFirstWrite = true;
                        videoEditedInfo.isPhoto = false;
                        videoEditedInfo.start = 0.0f;
                        videoEditedInfo.paintPath = null;
                        VideoEditedInfo videoEditedInfo2 = this.videoInfo;
                        videoEditedInfo.originalHeight = videoEditedInfo2.originalHeight;
                        videoEditedInfo.originalWidth = videoEditedInfo2.originalWidth;
                        videoEditedInfo.startTime = storyObject3.glSceneState.getVideoPlaybackStartTime();
                        StoryObject storyObject4 = next.localStory;
                        storyObject4.videoEditedInfo.endTime = storyObject4.glSceneState.getVideoPlaybackEndTime();
                        StoryObject storyObject5 = next.localStory;
                        VideoEditedInfo videoEditedInfo3 = storyObject5.videoEditedInfo;
                        long j = videoEditedInfo3.endTime - videoEditedInfo3.startTime;
                        videoEditedInfo3.originalDuration = 1000 * j;
                        storyObject5.duration = j;
                        MyLog.e("AddStoryFragmet", "cell glSceneInitiated " + next.toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGlOld() {
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this.mContext);
        this.glSurfaceView = gLSurfaceView;
        this.frameLayoutTouchController.addView(gLSurfaceView, 0, new ViewGroup.LayoutParams((int) DimensionHelper.getStoryViewWidthPx((Activity) this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) this.mContext)));
        FilterBuilder filterBuilder = new FilterBuilder();
        this.filterBuilder = filterBuilder;
        boolean z = this.mediaType == AddStoryMediaType.Video;
        filterBuilder.imageMedia(!z);
        if (!z) {
            this.filterBuilder.originalRotationAngle(Utils.getImageRotation(this.path));
        }
        createCurrentFilter(false, null);
        this.currentFilter = this.filterBuilder.buildFilter();
        this.glSurfaceView.setEGLContextClientVersion(2);
        this.glSurfaceView.setPreserveEGLContextOnPause(true);
        GLMediaRenderer gLMediaRenderer = new GLMediaRenderer(this.mContext, this.path, this.currentFilter.isImageMedia());
        this.glRenderer = gLMediaRenderer;
        gLMediaRenderer.setMaxScreenWidth((int) DimensionHelper.getStoryViewWidthPx((Activity) this.mContext));
        this.glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.glSurfaceView.setRenderer(this.glRenderer);
        this.glRenderer.setGlSurfaceView(this.glSurfaceView);
        this.glSurfaceView.setRenderMode(1);
        this.glRenderer.setMediaCoordinationInfo(this.currentFilter.getOutputScaleWidth(), this.currentFilter.getOutputScaleHeight(), this.currentFilter.getxPosInContainer(), this.currentFilter.getyPosInContainer(), this.currentFilter.getRotationAngle());
        RGHFilter rGHFilter = this.currentFilter;
        RGHFilter.FilterType filterType = RGHFilter.FilterType.None;
        rGHFilter.setFilterType(filterType, false);
        this.glRenderer.setFilterType(filterType);
        this.glRenderer.setNextFilterValues(this.currentFilter.getSaturationNext(), this.currentFilter.getContrastNext(), this.currentFilter.getBrightnessNext());
        if (this.currentFilter.isTrimEnabled()) {
            this.glRenderer.setVideoTimeLimit(this.currentFilter.getTrimStart(), this.currentFilter.getTrimEnd());
        }
        Context context = this.mContext;
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getString(R.string.app_name)));
        new DefaultBandwidthMeter();
        SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(this.mContext, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        simpleExoPlayerNewSimpleInstance.setPlayWhenReady(true);
        simpleExoPlayerNewSimpleInstance.prepare(new LoopingMediaSource(new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(this.path))));
        simpleExoPlayerNewSimpleInstance.setPlayWhenReady(true);
        this.glRenderer.setExoMediaPlayer(simpleExoPlayerNewSimpleInstance);
        this.needToInitGl = true;
        this.glSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (AddStoryFragment.this.needToInitGl) {
                    AddStoryFragment.this.needToInitGl = false;
                    try {
                        if (AddStoryFragment.this.postView != null) {
                            AddStoryFragment.this.postView.saveCurrentPosition((int) AddStoryFragment.this.postView.getX(), (int) AddStoryFragment.this.postView.getY());
                            AddStoryFragment.this.postView.saveCurrentScaleAndRotation();
                            AddStoryFragment.this.frameLayoutTouchController.storyContainer.getLayoutParams().width = (int) AddStoryFragment.this.postView.getVideoWidthAfterScale();
                            AddStoryFragment.this.frameLayoutTouchController.storyContainer.getLayoutParams().height = (int) AddStoryFragment.this.postView.getVideoHeightAfterScale();
                        }
                        AddStoryFragment.this.glRenderer.setFilterType(AddStoryFragment.this.currentFilter.getFilterType());
                        AddStoryFragment.this.glRenderer.setSaturation(AddStoryFragment.this.currentFilter.getSaturation());
                        AddStoryFragment.this.glRenderer.setContrast(AddStoryFragment.this.currentFilter.getContrast());
                        AddStoryFragment.this.glRenderer.setMaxScreenWidth(AddStoryFragment.this.glSurfaceView.getLayoutParams().width);
                        AddStoryFragment.this.glRenderer.setBrightness(AddStoryFragment.this.currentFilter.getBrightness());
                        AddStoryFragment.this.glRenderer.setNextFilterValues(AddStoryFragment.this.currentFilter.getSaturationNext(), AddStoryFragment.this.currentFilter.getContrastNext(), AddStoryFragment.this.currentFilter.getBrightnessNext());
                        AddStoryFragment.this.frameLayoutTouchController.textViewFilter.setText(AddStoryFragment.this.currentFilter.getFilterType() + BuildConfig.FLAVOR);
                        AddStoryFragment.this.frameLayoutTouchController.storyContainer.saveCurrentPosition((int) AddStoryFragment.this.frameLayoutTouchController.storyContainer.getX(), (int) AddStoryFragment.this.frameLayoutTouchController.storyContainer.getY());
                        AddStoryFragment.this.frameLayoutTouchController.storyContainer.saveCurrentScaleAndRotation();
                        AddStoryFragment.this.glRenderer.setScale(AddStoryFragment.this.frameLayoutTouchController.storyContainer.getWidthAfterScale(), AddStoryFragment.this.frameLayoutTouchController.storyContainer.getHeightAfterScale());
                        AddStoryFragment.this.glRenderer.setMediaPosition(AddStoryFragment.this.frameLayoutTouchController.storyContainer.getXAfterScale(), AddStoryFragment.this.frameLayoutTouchController.storyContainer.getYAfterScale());
                        AddStoryFragment.this.glRenderer.setMediaRotation(AddStoryFragment.this.frameLayoutTouchController.storyContainer.getRotation());
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    private void createStoryTransparentFrame(float f, float f2) {
        float f3 = this.targetWidth;
        float f4 = this.targetHeight;
        float f5 = f / f2;
        if (f5 > f3 / f4) {
            f3 = f4 * f5;
        } else {
            f4 = f3 / f5;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        int i = (int) f3;
        this.frameLayoutTouchController.storyContainer.getLayoutParams().width = i;
        int i2 = (int) f4;
        this.frameLayoutTouchController.storyContainer.getLayoutParams().height = i2;
        this.frameLayoutTouchController.storyContainer.addView(frameLayout, new FrameLayout.LayoutParams(i, i2));
        this.mediaWidth = f3;
        this.mediaHeight = f4;
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                if (Utils.useNewStoryCreationSystem()) {
                    AddStoryFragment.this.initGl(0, 0L);
                } else {
                    AddStoryFragment.this.initGlOld();
                }
            }
        }));
    }

    private void createImageSizeFrame(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(str).getAbsolutePath(), options);
        float f = options.outWidth;
        float f2 = options.outHeight;
        MyLog.e("AddStoryFragment", "imageHeight " + f2 + " " + f);
        char c = 0;
        try {
            int attributeInt = new ExifInterface(new File(str).getAbsolutePath()).getAttributeInt("Orientation", 1);
            MyLog.e("AddStoryFragment", "orientation " + attributeInt);
            if (attributeInt == 3) {
                c = 180;
            } else if (attributeInt == 6) {
                c = 'Z';
            } else if (attributeInt == 8) {
                c = 270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (c == 0) {
            createStoryTransparentFrame(f, f2);
        } else if (c == 'Z' || c == 270) {
            createStoryTransparentFrame(Math.min(f2, f), Math.max(f2, f));
        } else {
            createStoryTransparentFrame(Math.max(f2, f), Math.min(f2, f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0050 A[Catch: Exception -> 0x005b, TRY_LEAVE, TryCatch #4 {Exception -> 0x005b, blocks: (B:27:0x003f, B:29:0x0050), top: B:43:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createVideoSizeFrame(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            android.media.MediaMetadataRetriever r2 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            r2.<init>()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L38
            r2.setDataSource(r6)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            r1 = 18
            java.lang.String r1 = r2.extractMetadata(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r1 == 0) goto L17
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            goto L18
        L17:
            r1 = 0
        L18:
            r3 = 19
            java.lang.String r3 = r2.extractMetadata(r3)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2c
            if (r3 == 0) goto L24
            int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2c
        L24:
            r2.release()     // Catch: java.lang.Exception -> L3f
            goto L3f
        L28:
            r4 = r2
            r2 = r1
            r1 = r4
            goto L39
        L2c:
            r6 = move-exception
            r1 = r2
            goto L32
        L2f:
            r1 = r2
            goto L38
        L31:
            r6 = move-exception
        L32:
            if (r1 == 0) goto L37
            r1.release()     // Catch: java.lang.Exception -> L37
        L37:
            throw r6
        L38:
            r2 = 0
        L39:
            if (r1 == 0) goto L3e
            r1.release()     // Catch: java.lang.Exception -> L3e
        L3e:
            r1 = r2
        L3f:
            android.content.Context r2 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> L5b
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L5b
            r3.<init>(r6)     // Catch: java.lang.Exception -> L5b
            android.net.Uri r6 = android.net.Uri.fromFile(r3)     // Catch: java.lang.Exception -> L5b
            android.media.MediaPlayer r6 = android.media.MediaPlayer.create(r2, r6)     // Catch: java.lang.Exception -> L5b
            if (r6 == 0) goto L5b
            int r1 = r6.getVideoWidth()     // Catch: java.lang.Exception -> L5b
            int r0 = r6.getVideoHeight()     // Catch: java.lang.Exception -> L5b
            r6.release()     // Catch: java.lang.Exception -> L5b
        L5b:
            float r6 = (float) r1
            float r2 = (float) r0
            r5.createStoryTransparentFrame(r6, r2)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "video "
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = " "
            r6.append(r1)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r0 = "AddStoryFragment"
            ir.resaneh1.iptv.logger.MyLog.e(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.AddStoryFragment.createVideoSizeFrame(java.lang.String):void");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        StoryStickerPickerLayout storyStickerPickerLayout;
        ArrayList<RubinoStickerAndWidgetListFragment> arrayList;
        super.onPause();
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        FrameLayoutTouchable frameLayoutTouchable = this.frameLayoutTouchController;
        if (frameLayoutTouchable != null && (storyStickerPickerLayout = frameLayoutTouchable.stickerPickerLayout) != null && !storyStickerPickerLayout.isMinimized() && (arrayList = this.frameLayoutTouchController.stickerFragments) != null) {
            Iterator<RubinoStickerAndWidgetListFragment> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
        }
        onPauseGl();
    }

    public void onPauseGl() {
        try {
            if (isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    this.eglThread.getFilterShader().pauseMediaPlayback();
                } else {
                    this.glRenderer.pauseMediaPlayback();
                    GLSurfaceView gLSurfaceView = this.glSurfaceView;
                    if (gLSurfaceView != null) {
                        gLSurfaceView.onPause();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        ArrayList<RubinoStickerAndWidgetListFragment> arrayList;
        FrameLayoutTouchable frameLayoutTouchable = this.frameLayoutTouchController;
        if (frameLayoutTouchable != null && (arrayList = frameLayoutTouchable.stickerFragments) != null) {
            Iterator<RubinoStickerAndWidgetListFragment> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onFragmentDestroy();
            }
        }
        try {
            if (isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    TextureView textureView = this.mediaTextureView;
                    if (textureView != null) {
                        if (this.mediaType == AddStoryMediaType.Video && (textureView instanceof VideoEditTextureView)) {
                            ((VideoEditTextureView) textureView).release();
                        } else {
                            this.eglThread.shutdown();
                            this.eglThread = null;
                        }
                    }
                } else {
                    this.glRenderer.destroyGLComponents(true);
                }
            }
        } catch (Exception unused) {
        }
        getNotificationCenter().removeObserver(this, NotificationCenter.storyBackgroundCreated);
        super.onFragmentDestroy();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        StoryStickerPickerLayout storyStickerPickerLayout;
        ArrayList<RubinoStickerAndWidgetListFragment> arrayList;
        super.onResume();
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            toggleFullscreenSwitch(true);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        lockOrientationPortrait();
        FrameLayoutTouchable frameLayoutTouchable = this.frameLayoutTouchController;
        if (frameLayoutTouchable != null && (storyStickerPickerLayout = frameLayoutTouchable.stickerPickerLayout) != null && !storyStickerPickerLayout.isMinimized() && (arrayList = this.frameLayoutTouchController.stickerFragments) != null) {
            Iterator<RubinoStickerAndWidgetListFragment> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
        try {
            if (isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    this.eglThread.getFilterShader().resumeMediaPlayback();
                } else {
                    this.glSurfaceView.onResume();
                    this.glRenderer.resumeMediaPlayback();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        StoryStickerPickerLayout storyStickerPickerLayout;
        FrameLayoutTouchable frameLayoutTouchable = this.frameLayoutTouchController;
        if (frameLayoutTouchable != null && (storyStickerPickerLayout = frameLayoutTouchable.stickerPickerLayout) != null && !storyStickerPickerLayout.isMinimized()) {
            this.frameLayoutTouchController.stickerPickerLayout.minimize();
            ArrayList<RubinoStickerAndWidgetListFragment> arrayList = this.frameLayoutTouchController.stickerFragments;
            if (arrayList == null) {
                return false;
            }
            Iterator<RubinoStickerAndWidgetListFragment> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
            return false;
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.storyBackgroundCreated) {
            new BitmapFactory.Options().inScaled = false;
        }
    }

    @Override // ir.appp.rghapp.ColorPickerListener
    public void onColorPickerResult(int i, int i2, int i3) {
        MyLog.e("AddStoryFragment", "onColorPickerResult " + i + " " + i2 + " " + i3);
        FrameLayoutTouchable frameLayoutTouchable = this.frameLayoutTouchController;
        if (frameLayoutTouchable != null) {
            frameLayoutTouchable.setPickerColor(i, i2, i3);
        }
    }

    public class FrameLayoutTouchable extends FrameLayout {
        int CLICK_ACTION_THRESHOLD;
        private float angleStart;
        public FrameLayout bottomContainer;
        private AnimatorSet clickAnimation;
        float clickStartX;
        float clickStartY;
        private CreateLinkFrameLayout createLinkStoryFrameLayout;
        int currentKeyboardHeight;
        public StoryTextAttributeObject currentTextAttribute;
        int defaultHashtagTextSizeInDp;
        int defaultTextSizeInDp;
        UI_rubinoDropperSelectorCell dropperCell;
        private boolean dropperVisible;
        private EditText editText;
        int editTextTopMargin;
        int edittextPadding;
        private UI_rubinoEmojiPickerRow emojiPickerRow;
        private int emojiSliderCounter;
        private StoryEntityView emojiSliderStickerEntityView;
        SizeNotifierFrameLayout emojisliderToolsFrameLayout;
        ArrayList<StoryEntityView> entityViewArray;
        private AnimatorSet filterAnimation;
        public FrameLayout frameLayoutEntityContainer;
        private boolean hasPaint;
        private DisposableObserver hashtagDisposable;
        private EditText hashtagEditText;
        Pattern hashtagPattern;
        SizeNotifierFrameLayout hashtagToolsFrameLayout;
        private TextWatcher hashtagWatcher;
        private final int height;
        private ImageView imageViewChisel;
        private ImageView imageViewErase;
        private ImageView imageViewMagic;
        private ImageView imageViewPaint;
        private ImageView imageViewQuizDone;
        private ImageView imageViewSpecial;
        private ImageView imageViewStory;
        ImageView imageViewTextAlign;
        ImageView imageViewTextBackGround;
        private ImageView imageViewTrash;
        private AnimatorSet inTrashAnimation;
        private boolean isCreateLinkVisible;
        private boolean isFilterAnimatingToShow;
        private boolean isHashtag;
        boolean isPaintMode;
        private boolean isSmallingInTrashAnimationOccuredAndFinished;
        private boolean isTrashAnimationInProgress;
        private boolean isTrashVisible;
        private boolean isWidgetToolsViewVisible;
        public LinearLayout linearLayoutMultiFileView;
        private StoryEntityView linkEntityView;
        private AnimatorSet mainToolHideAndShowAnimation;
        public FrameLayout mainToolsView;
        public ArrayList<AddStoryBottomView.LocalStoryFileCell> multiFileCellArray;
        public AddStoryBottomView multiFileView;
        private boolean needToAnimateTrashBack;
        private boolean needToRefreshEditText;
        private boolean needToRefreshHashtagEditText;
        private boolean needToResizeText;
        private boolean needToTextToolsBack;
        int newEditTextHeight;
        public Bitmap overlay;
        private UI_rubinoColorPickerRow paintColorPickerRow;
        private UI_rubinoSeekBar paintSeekBar;
        public FrameLayout paintToolsView;
        FrameLayoutPaint paintView;
        private StoryEntityView pollStickerEntityView;
        SizeNotifierFrameLayout pollToolsFrameLayout;
        private StoryEntityView questionStickerEntityView;
        SizeNotifierFrameLayout questionToolsFrameLayout;
        private int quizCounter;
        private StoryEntityView quizStickerEntityView;
        SizeNotifierFrameLayout quizToolsFrameLayout;
        private DisposableObserver searchDisposable;
        RubinoEntityArrayEmojiPresenter.SelectItemListner selectItemListener;
        StoryEntityView selected;
        public Map<Integer, StoryUtils.MyPoint> startPositionMap;
        private float startTouchDistance;
        public ArrayList<RubinoStickerAndWidgetListFragment> stickerFragments;
        public CircleIndicator stickerPickerIndicator;
        public StoryStickerPickerLayout stickerPickerLayout;
        public ViewPager stickerPickerViewPager;
        StoryEntityView storyContainer;
        private UI_rubinoColorPickerRow textColorPickerRow;
        private UI_rubinoSeekBar textSeekBar;
        SizeNotifierFrameLayout textToolsFrameLayout;
        private TextView textType;
        private TextView textViewFilter;
        private StoryEntityView toEditTextEntity;
        private AnimatorSet trashVisibilityAnimation;
        private UI_rubinoSuggestionRow ui_rubinoHashtagSuggestionRow;
        private UI_rubinoSuggestionRow ui_rubinoHashtagSuggestionRow2;
        private UI_rubinoSuggestionRow ui_rubinoProfileSuggestionRow;
        private UI_rubinoSuggestionRow ui_rubinoProfileSuggestionRow2;
        private final int width;
        private Animation zoomIn;
        private Animation zoomOut;

        static /* synthetic */ int access$6608(FrameLayoutTouchable frameLayoutTouchable) {
            int i = frameLayoutTouchable.emojiSliderCounter;
            frameLayoutTouchable.emojiSliderCounter = i + 1;
            return i;
        }

        static /* synthetic */ int access$6644(FrameLayoutTouchable frameLayoutTouchable, int i) {
            int i2 = frameLayoutTouchable.emojiSliderCounter % i;
            frameLayoutTouchable.emojiSliderCounter = i2;
            return i2;
        }

        static /* synthetic */ int access$7108(FrameLayoutTouchable frameLayoutTouchable) {
            int i = frameLayoutTouchable.quizCounter;
            frameLayoutTouchable.quizCounter = i + 1;
            return i;
        }

        static /* synthetic */ int access$7144(FrameLayoutTouchable frameLayoutTouchable, int i) {
            int i2 = frameLayoutTouchable.quizCounter % i;
            frameLayoutTouchable.quizCounter = i2;
            return i2;
        }

        public FrameLayoutTouchable(Context context, int i, int i2) {
            super(context);
            this.hashtagPattern = Pattern.compile("#([A-Za-z0-9_\\u0621-\\u06cc\\u06f0-\\u06f9]{1,39})");
            this.CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(2.0f);
            this.startTouchDistance = 0.0f;
            this.editTextTopMargin = 40;
            this.edittextPadding = 8;
            this.defaultTextSizeInDp = 25;
            this.defaultHashtagTextSizeInDp = 40;
            this.isCreateLinkVisible = false;
            this.selectItemListener = new RubinoEntityArrayEmojiPresenter.SelectItemListner() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.60
                @Override // ir.resaneh1.iptv.presenters.RubinoEntityArrayEmojiPresenter.SelectItemListner
                public void onSelectItem(StoryEntityItem storyEntityItem) {
                    if (storyEntityItem == null || ApplicationLoader.applicationActivity == null) {
                        return;
                    }
                    if (storyEntityItem.storyEntityType != StoryEntityItem.StoryEntityTypeEnum.linkPreview) {
                        FrameLayoutTouchable.this.stickerPickerLayout.minimize();
                    }
                    ArrayList<RubinoStickerAndWidgetListFragment> arrayList = FrameLayoutTouchable.this.stickerFragments;
                    if (arrayList != null) {
                        Iterator<RubinoStickerAndWidgetListFragment> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().onPause();
                        }
                    }
                    StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum = storyEntityItem.storyEntityType;
                    StoryEntityView storyEntityView = null;
                    if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.hashtagPreview) {
                        Iterator<StoryEntityView> it2 = FrameLayoutTouchable.this.entityViewArray.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            StoryEntityView next = it2.next();
                            if (next.type == StoryEntityView.TypeEnum.hashtag) {
                                storyEntityView = next;
                                break;
                            }
                        }
                        FrameLayoutTouchable.this.isHashtag = true;
                        FrameLayoutTouchable.this.openHashtagOrMentionTextEdit(storyEntityView);
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.pollPreview) {
                        FrameLayoutTouchable.this.openPollEditView();
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.emojiSliderPreview) {
                        FrameLayoutTouchable.this.openEmojiSliderEditView();
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.questionPreview) {
                        FrameLayoutTouchable.this.openQuestionEditView();
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.quizPreview) {
                        FrameLayoutTouchable.this.openQuizEditView();
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.mentionPreview) {
                        FrameLayoutTouchable.this.isHashtag = false;
                        FrameLayoutTouchable.this.openHashtagOrMentionTextEdit(null);
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.sticker || storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.emoji || storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.clockPreview || storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.datePreview) {
                        StoryEntityView storyEntityView2 = new StoryEntityView(ApplicationLoader.applicationActivity);
                        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum2 = storyEntityItem.storyEntityType;
                        if (storyEntityTypeEnum2 == StoryEntityItem.StoryEntityTypeEnum.clockPreview) {
                            StoryEntityItem storyEntityItem2 = new StoryEntityItem();
                            storyEntityItem2.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.clock;
                            RubinoClockObject rubinoClockObject = storyEntityItem.clockObject;
                            storyEntityItem2.clockObject = new RubinoClockObject(rubinoClockObject.mode, rubinoClockObject.date, 200);
                            storyEntityView2.setOrEditEntityItem(storyEntityItem2);
                            FrameLayoutTouchable.this.addEntityView(storyEntityView2, LayoutHelper.createFrame(storyEntityItem2.getSizeDp(), storyEntityItem2.getSizeDp(), 17));
                        } else if (storyEntityTypeEnum2 == StoryEntityItem.StoryEntityTypeEnum.datePreview) {
                            StoryEntityItem storyEntityItem3 = new StoryEntityItem();
                            storyEntityItem3.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.date;
                            RubinoDateObject rubinoDateObject = storyEntityItem.dateObject;
                            storyEntityItem3.dateObject = new RubinoDateObject(rubinoDateObject.theme, rubinoDateObject.date, 200);
                            storyEntityView2.setOrEditEntityItem(storyEntityItem3);
                            FrameLayoutTouchable.this.addEntityView(storyEntityView2, LayoutHelper.createFrame(storyEntityItem3.getSizeDp(), storyEntityItem3.getSizeDp(), 17));
                        } else {
                            storyEntityView2.setOrEditEntityItem(storyEntityItem);
                            FrameLayoutTouchable.this.addEntityView(storyEntityView2, LayoutHelper.createFrame(storyEntityItem.getSizeDp(), storyEntityItem.getSizeDp(), 17));
                        }
                    } else if (storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.linkPreview) {
                        FrameLayoutTouchable.this.showLinkCreateView(true);
                    }
                    MyLog.e("addStoryFragment select", storyEntityItem.storyEntityType + BuildConfig.FLAVOR);
                }
            };
            setWillNotDraw(false);
            this.entityViewArray = new ArrayList<>();
            StoryEntityView storyEntityView = new StoryEntityView(context);
            this.storyContainer = storyEntityView;
            storyEntityView.type = StoryEntityView.TypeEnum.storyContainer;
            this.startPositionMap = new HashMap();
            this.width = i;
            this.height = i2;
            setOnTouchListener(new View.OnTouchListener(AddStoryFragment.this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.1
                /* JADX WARN: Removed duplicated region for block: B:64:0x0144  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x016f  */
                @Override // android.view.View.OnTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                    /*
                        Method dump skipped, instructions count: 410
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void changePaintMode(boolean z) {
            this.isPaintMode = z;
            if (z) {
                this.hasPaint = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deselectAllBrushes() {
            UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
            this.imageViewPaint.setActivated(false);
            this.imageViewErase.setActivated(false);
            this.imageViewSpecial.setActivated(false);
            this.imageViewMagic.setActivated(false);
            this.imageViewChisel.setActivated(false);
            UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = this.dropperCell;
            if (uI_rubinoDropperSelectorCell == null || (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) == null) {
                return;
            }
            dropperSelectorFrameLayout.setVisibility(8);
            this.dropperVisible = false;
            if (AddStoryFragment.this.isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    AddStoryFragment.this.eglThread.setColorPickingMode(false);
                } else {
                    AddStoryFragment.this.glRenderer.setColorPickingMode(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createPaintToolsView() {
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
            FrameLayout frameLayout = new FrameLayout(launchActivity);
            this.paintToolsView = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1, 17));
            this.paintToolsView.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
            ImageView imageView = new ImageView(launchActivity);
            imageView.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_overlay_check));
            this.paintToolsView.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
                    FrameLayoutTouchable.this.changePaintMode(false);
                    FrameLayoutTouchable.this.paintToolsView.setVisibility(8);
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                    if (uI_rubinoDropperSelectorCell != null && (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) != null) {
                        dropperSelectorFrameLayout.setVisibility(8);
                    }
                    FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                }
            });
            ImageView imageView2 = new ImageView(launchActivity);
            this.imageViewPaint = imageView2;
            imageView2.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_marker_paint_selector));
            this.imageViewPaint.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.paintToolsView.addView(this.imageViewPaint, LayoutHelper.createFrame(48, 48.0f, 49, 0.0f, 0.0f, 100.0f, 0.0f));
            this.imageViewPaint.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.setPaintBrush();
                }
            });
            ImageView imageView3 = new ImageView(launchActivity);
            this.imageViewErase = imageView3;
            imageView3.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_eraser_selector));
            this.paintToolsView.addView(this.imageViewErase, LayoutHelper.createFrame(48, 48.0f, 49, 48.0f, 0.0f, 0.0f, 0.0f));
            this.imageViewErase.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.paintView.setErase();
                    FrameLayoutTouchable.this.deselectAllBrushes();
                    FrameLayoutTouchable.this.imageViewErase.setActivated(true);
                }
            });
            ImageView imageView4 = new ImageView(launchActivity);
            this.imageViewMagic = imageView4;
            imageView4.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_magic_selector));
            this.paintToolsView.addView(this.imageViewMagic, LayoutHelper.createFrame(48, 48.0f, 49, 0.0f, 0.0f, 0.0f, 0.0f));
            this.imageViewMagic.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.paintView.setPaintAndShadowBrush();
                    FrameLayoutTouchable.this.deselectAllBrushes();
                    FrameLayoutTouchable.this.imageViewMagic.setActivated(true);
                }
            });
            ImageView imageView5 = new ImageView(launchActivity);
            this.imageViewSpecial = imageView5;
            imageView5.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_special_selector));
            this.paintToolsView.addView(this.imageViewSpecial, LayoutHelper.createFrame(48, 48.0f, 49, 100.0f, 0.0f, 0.0f, 0.0f));
            this.imageViewSpecial.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.paintView.setBitmapBrush(R.drawable.story_smoke, true);
                    FrameLayoutTouchable.this.deselectAllBrushes();
                    FrameLayoutTouchable.this.imageViewSpecial.setActivated(true);
                }
            });
            ImageView imageView6 = new ImageView(launchActivity);
            this.imageViewChisel = imageView6;
            imageView6.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_chisel_selector));
            this.paintToolsView.addView(this.imageViewChisel, LayoutHelper.createFrame(48, 48.0f, 49, 0.0f, 0.0f, 48.0f, 0.0f));
            this.imageViewChisel.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.paintView.setBitmapBrush(R.drawable.story_marker, false);
                    FrameLayoutTouchable.this.deselectAllBrushes();
                    FrameLayoutTouchable.this.imageViewChisel.setActivated(true);
                }
            });
            ImageView imageView7 = new ImageView(launchActivity);
            imageView7.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_overlay_undo));
            this.paintToolsView.addView(imageView7, LayoutHelper.createFrame(48, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView7.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                    if (uI_rubinoDropperSelectorCell != null && (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) != null) {
                        dropperSelectorFrameLayout.setVisibility(8);
                        FrameLayoutTouchable.this.dropperVisible = false;
                        if (AddStoryFragment.this.isRendererAvailable()) {
                            if (Utils.useNewStoryCreationSystem()) {
                                AddStoryFragment.this.eglThread.setColorPickingMode(false);
                            } else {
                                AddStoryFragment.this.glRenderer.setColorPickingMode(false);
                            }
                        }
                    }
                    FrameLayoutTouchable.this.paintView.undo();
                }
            });
            UI_rubinoColorPickerRow uI_rubinoColorPickerRowCreateAndGetColorPickerRow = createAndGetColorPickerRow(false);
            this.paintColorPickerRow = uI_rubinoColorPickerRowCreateAndGetColorPickerRow;
            this.paintToolsView.addView(uI_rubinoColorPickerRowCreateAndGetColorPickerRow.view, LayoutHelper.createFrame(-1, -2, 80));
            UI_rubinoSeekBar uI_rubinoSeekBar = new UI_rubinoSeekBar();
            this.paintSeekBar = uI_rubinoSeekBar;
            uI_rubinoSeekBar.createView(launchActivity, new UI_rubinoSeekBar.ChangeSizeListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.9
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSeekBar.ChangeSizeListener
                public void onSelectSize(float f) {
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
                    FrameLayoutTouchable.this.paintView.changeSize(f);
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                    if (uI_rubinoDropperSelectorCell == null || (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) == null) {
                        return;
                    }
                    dropperSelectorFrameLayout.setVisibility(8);
                    FrameLayoutTouchable.this.dropperVisible = false;
                    if (AddStoryFragment.this.isRendererAvailable()) {
                        if (Utils.useNewStoryCreationSystem()) {
                            AddStoryFragment.this.eglThread.setColorPickingMode(false);
                        } else {
                            AddStoryFragment.this.glRenderer.setColorPickingMode(false);
                        }
                    }
                }
            }, 260, true);
            this.paintSeekBar.setProgress(this.paintView.currentSizePercent);
            this.paintToolsView.addView(this.paintSeekBar.view, LayoutHelper.createFrame(-2, -1, 19));
        }

        private UI_rubinoColorPickerRow createAndGetColorPickerRow(final boolean z) {
            if (ApplicationLoader.applicationActivity == null) {
                return null;
            }
            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
            UI_rubinoColorPickerRow uI_rubinoColorPickerRow = new UI_rubinoColorPickerRow();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-1);
            arrayList.add(-16777216);
            arrayList.add(-16776961);
            arrayList.add(-16711936);
            arrayList.add(-256);
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.orange_700)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.purple_200)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.purple_700)));
            arrayList.add(-65281);
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.red_600)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.red_100)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.yellow_300)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.yellow_600)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.green_700)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_200)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_400)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_500)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_700)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_800)));
            arrayList.add(Integer.valueOf(launchActivity.getResources().getColor(R.color.grey_900)));
            uI_rubinoColorPickerRow.createView(launchActivity, arrayList, 10, this.width, new UI_rubinoColorPickerRow.SelectColorListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.10
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoColorPickerRow.SelectColorListener
                public void onSelectColor(int i) {
                    try {
                        FrameLayoutTouchable.this.changeColor(i);
                    } catch (Exception unused) {
                    }
                }

                @Override // ir.resaneh1.iptv.UIView.UI_rubinoColorPickerRow.SelectColorListener
                public void onSelectDropper() {
                    try {
                        if (ApplicationLoader.applicationActivity == null) {
                            return;
                        }
                        FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                        if (frameLayoutTouchable.dropperCell == null) {
                            frameLayoutTouchable.dropperCell = new UI_rubinoDropperSelectorCell();
                            FrameLayoutTouchable.this.dropperCell.createView(ApplicationLoader.applicationActivity);
                        }
                        FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                        frameLayoutTouchable2.addView(frameLayoutTouchable2.dropperCell.view, LayoutHelper.createFrame(90, 120, 17));
                        if (AddStoryFragment.this.isRendererAvailable() && Utils.useNewStoryCreationSystem()) {
                            AddStoryFragment.this.eglThread.setColorPickingMode(false);
                            AddStoryFragment.this.eglThread.setColorPickerListener(AddStoryFragment.this);
                        }
                        FrameLayoutTouchable frameLayoutTouchable3 = FrameLayoutTouchable.this;
                        float x = frameLayoutTouchable3.dropperCell.view.getX();
                        UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                        frameLayoutTouchable3.getColorOfPoint((int) (x + uI_rubinoDropperSelectorCell.circleCenterX), (int) (uI_rubinoDropperSelectorCell.view.getY() + FrameLayoutTouchable.this.dropperCell.circleCenterY));
                        FrameLayoutTouchable.this.dropperCell.view.setVisibility(0);
                        FrameLayoutTouchable.this.dropperCell.view.requestLayout();
                        FrameLayoutTouchable.this.dropperVisible = true;
                        if (z) {
                            FrameLayoutTouchable.this.textToolsFrameLayout.setVisibility(4);
                            AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.textToolsFrameLayout);
                            FrameLayoutTouchable.this.needToTextToolsBack = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
            return uI_rubinoColorPickerRow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPaintBrush() {
            this.paintView.setPaintBrush();
            deselectAllBrushes();
            this.imageViewPaint.setActivated(true);
        }

        private void createMainToolsView() {
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
            FrameLayout frameLayout = new FrameLayout(launchActivity);
            this.mainToolsView = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1, 17));
            this.mainToolsView.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
            ImageView imageView = new ImageView(launchActivity);
            imageView.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_text_filled));
            this.mainToolsView.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StoryStickerPickerLayout storyStickerPickerLayout = FrameLayoutTouchable.this.stickerPickerLayout;
                    if (storyStickerPickerLayout != null) {
                        storyStickerPickerLayout.minimize();
                        Iterator<RubinoStickerAndWidgetListFragment> it = FrameLayoutTouchable.this.stickerFragments.iterator();
                        while (it.hasNext()) {
                            it.next().onPause();
                        }
                    }
                    FrameLayoutTouchable.this.openTextEdit(null);
                }
            });
            ImageView imageView2 = new ImageView(launchActivity);
            imageView2.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_drawing_tools_filled));
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mainToolsView.addView(imageView2, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 50.0f, 0.0f));
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StoryStickerPickerLayout storyStickerPickerLayout = FrameLayoutTouchable.this.stickerPickerLayout;
                    if (storyStickerPickerLayout != null) {
                        storyStickerPickerLayout.minimize();
                        Iterator<RubinoStickerAndWidgetListFragment> it = FrameLayoutTouchable.this.stickerFragments.iterator();
                        while (it.hasNext()) {
                            it.next().onPause();
                        }
                    }
                    FrameLayoutTouchable.this.changePaintMode(true);
                    FrameLayoutTouchable.this.startMainToolViewAnimation(false, false);
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    if (frameLayoutTouchable.paintToolsView == null) {
                        frameLayoutTouchable.createPaintToolsView();
                    }
                    FrameLayoutTouchable.this.paintToolsView.setVisibility(0);
                    FrameLayoutTouchable.this.setPaintBrush();
                }
            });
            ImageView imageView3 = new ImageView(launchActivity);
            imageView3.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.story_sticker_outline));
            this.mainToolsView.addView(imageView3, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 100.0f, 0.0f));
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws Resources.NotFoundException {
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    if (frameLayoutTouchable.stickerPickerLayout == null) {
                        frameLayoutTouchable.createStickerView();
                    }
                    Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.13.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            FrameLayoutTouchable.this.startMainToolViewAnimation(false, false);
                            FrameLayoutTouchable.this.showLinkCreateView(false);
                            FrameLayoutTouchable.this.stickerPickerLayout.smoothSlideToPosition();
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            th.printStackTrace();
                        }
                    });
                }
            });
            ImageView imageView4 = new ImageView(launchActivity);
            imageView4.setImageDrawable(launchActivity.getResources().getDrawable(R.drawable.rubino_canvas_close));
            this.mainToolsView.addView(imageView4, LayoutHelper.createFrame(48, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView4.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    } catch (Exception unused) {
                    }
                }
            });
            ImageView imageView5 = new ImageView(ApplicationLoader.applicationActivity);
            this.imageViewTrash = imageView5;
            imageView5.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_overlay_trash_can));
            this.imageViewTrash.setScaleX(1.0f);
            this.imageViewTrash.setScaleY(1.0f);
            this.imageViewTrash.setVisibility(4);
            addView(this.imageViewTrash, LayoutHelper.createFrame(52, 52, 81));
            int iDp = AndroidUtilities.dp(16.0f);
            int screenHeight = (int) (DimensionHelper.getScreenHeight((Activity) AddStoryFragment.this.mContext) - DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext));
            if (screenHeight > 0) {
                iDp += screenHeight;
            }
            ((FrameLayout.LayoutParams) this.imageViewTrash.getLayoutParams()).setMargins(0, 0, 0, iDp);
            this.bottomContainer = new FrameLayout(launchActivity);
            AddStoryBottomView addStoryBottomView = new AddStoryBottomView(AddStoryFragment.this.mContext);
            this.multiFileView = addStoryBottomView;
            FrameLayout frameLayout2 = addStoryBottomView.frameLayoutSave;
            this.mainToolsView.addView(this.bottomContainer, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, ((int) (DimensionHelper.getScreenHeight((Activity) AddStoryFragment.this.mContext) - DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext))) > AndroidUtilities.dp(68.0f) ? AndroidUtilities.px(r1 - AndroidUtilities.dp(68.0f)) : 0));
            this.bottomContainer.addView(this.multiFileView, 0, LayoutHelper.createFrame(-1, -2, 80));
            this.linearLayoutMultiFileView = this.multiFileView.linearLayout;
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (Utils.useNewStoryCreationSystem()) {
                            if (!AddStoryFragment.this.isMultiFile || FrameLayoutTouchable.this.multiFileCellArray.size() <= 1) {
                                AddStoryFragment.this.saveAndSend();
                                return;
                            }
                            Iterator<AddStoryBottomView.LocalStoryFileCell> it = FrameLayoutTouchable.this.multiFileCellArray.iterator();
                            while (it.hasNext()) {
                                AddStoryBottomView.LocalStoryFileCell next = it.next();
                                if (next.isSelected) {
                                    AddStoryFragment.this.saveLocalStoryAttr(next, true);
                                }
                                AddStoryFragment.this.addEntityItemIfNeeded(next.localStory);
                                SendStoryHelper.getInstance(((BaseFragment) AddStoryFragment.this).currentAccount).doOrPutInQueueSendStory(next.localStory);
                            }
                            ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add((Disposable) Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.15.1
                                @Override // io.reactivex.Observer
                                public void onComplete() {
                                }

                                @Override // io.reactivex.Observer
                                public void onError(Throwable th) {
                                }

                                @Override // io.reactivex.Observer
                                public void onNext(Integer num) {
                                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                                    AddStoryFragment.this.nextStep(frameLayoutTouchable.multiFileCellArray.get(0).localStory.rnd);
                                }
                            }));
                            return;
                        }
                        MyLog.e("AddStoryFragment", "select old method to generate video");
                        AddStoryFragment.this.prepareToSaveAndSend();
                    } catch (Exception unused) {
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openTextEdit(StoryEntityView storyEntityView) {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            if (this.textToolsFrameLayout == null) {
                createTextToolsView();
            }
            if (storyEntityView == null || storyEntityView.textAttributeObject == null) {
                this.editText.setText(BuildConfig.FLAVOR);
                this.editText.setScaleY(1.0f);
                this.editText.setScaleX(1.0f);
                this.currentTextAttribute = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.none, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, this.defaultTextSizeInDp, -1, StoryTextAttributeObject.TextColorTypeEnum.simple);
            } else {
                this.toEditTextEntity = storyEntityView;
                storyEntityView.setVisibility(4);
                this.editText.setText(storyEntityView.textAttributeObject.spannableString);
                this.currentTextAttribute = storyEntityView.textAttributeObject;
            }
            changeColor(this.currentTextAttribute.color);
            this.editText.setTextSize(1, this.currentTextAttribute.textSizeInDp);
            this.textSeekBar.setProgress((this.currentTextAttribute.textSizeInDp - 10.0f) / 30.0f);
            EditText editText = this.editText;
            StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
            editText.setBackground(storyTextAttributeObject.getBackground(storyTextAttributeObject.layout));
            this.editText.setTypeface(this.currentTextAttribute.getTypeFace());
            this.editText.setGravity(StoryTextAttributeObject.getGravity(this.currentTextAttribute));
            this.textType.setText(StoryTextAttributeObject.getFontStringByType(this.currentTextAttribute));
            setAlignmentAndBackgroundByType();
            this.textToolsFrameLayout.setVisibility(0);
            this.editText.requestLayout();
            this.editText.requestFocus();
            AndroidUtilities.showKeyboard(this.editText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openHashtagOrMentionTextEdit(StoryEntityView storyEntityView) {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            this.isWidgetToolsViewVisible = true;
            if (this.hashtagToolsFrameLayout == null) {
                createHashtagOrMentionToolsView();
            }
            this.ui_rubinoHashtagSuggestionRow.updateHashtagList(new ArrayList<>(), BuildConfig.FLAVOR, 0);
            this.ui_rubinoProfileSuggestionRow.updateProfileList(new ArrayList<>(), BuildConfig.FLAVOR, 0);
            if (this.isHashtag) {
                this.ui_rubinoProfileSuggestionRow.view.setVisibility(8);
                this.ui_rubinoHashtagSuggestionRow.view.setVisibility(0);
            } else {
                this.ui_rubinoProfileSuggestionRow.view.setVisibility(0);
                this.ui_rubinoHashtagSuggestionRow.view.setVisibility(8);
            }
            if (storyEntityView == null || storyEntityView.textAttributeObject == null) {
                this.hashtagEditText.setText(BuildConfig.FLAVOR);
                this.hashtagEditText.setScaleY(1.0f);
                this.hashtagEditText.setScaleX(1.0f);
                this.currentTextAttribute = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.rounded, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, this.defaultHashtagTextSizeInDp, -1, this.isHashtag ? StoryTextAttributeObject.TextColorTypeEnum.twoColorPink : StoryTextAttributeObject.TextColorTypeEnum.twoColorOrange);
            } else {
                this.toEditTextEntity = storyEntityView;
                storyEntityView.setVisibility(4);
                this.hashtagEditText.setText(storyEntityView.textAttributeObject.spannableString);
                this.currentTextAttribute = storyEntityView.textAttributeObject;
            }
            this.hashtagEditText.setTextSize(1, this.currentTextAttribute.textSizeInDp);
            this.hashtagEditText.setTextColor(-1);
            this.hashtagEditText.setBackground(this.currentTextAttribute.getHashtagBackground());
            this.hashtagEditText.setTypeface(this.currentTextAttribute.getTypeFace());
            this.hashtagEditText.setGravity(StoryTextAttributeObject.getGravity(this.currentTextAttribute));
            this.hashtagToolsFrameLayout.setVisibility(0);
            this.needToRefreshHashtagEditText = true;
            this.hashtagEditText.requestLayout();
            this.hashtagEditText.requestFocus();
            AndroidUtilities.showKeyboard(this.hashtagEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openPollEditView() {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            this.isWidgetToolsViewVisible = true;
            if (this.pollToolsFrameLayout == null) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
                this.pollToolsFrameLayout = sizeNotifierFrameLayout;
                sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
                this.pollToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                addView(this.pollToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
                this.pollToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
                this.pollToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.17
                    @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                    public void onSizeChanged(int i, boolean z) {
                        int availableHeight;
                        int i2;
                        if (FrameLayoutTouchable.this.pollStickerEntityView != null) {
                            PollSticker pollSticker = FrameLayoutTouchable.this.pollStickerEntityView.pollSticker;
                            int height = pollSticker.getHeight();
                            if (i > 0) {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            } else {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, 0, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            }
                            int i3 = availableHeight - i2;
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pollSticker.getLayoutParams();
                            if (i3 != layoutParams.topMargin) {
                                layoutParams.topMargin = i3;
                                pollSticker.requestLayout();
                            }
                        }
                    }
                });
                ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
                imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
                this.pollToolsFrameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FrameLayoutTouchable.this.isWidgetToolsViewVisible = false;
                        if (FrameLayoutTouchable.this.pollStickerEntityView != null) {
                            FrameLayoutTouchable.this.pollStickerEntityView.pollSticker.setPollAddStoryMode(PollView.PollAddStoryMode.LOCK);
                            FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                            frameLayoutTouchable.pollToolsFrameLayout.removeView(frameLayoutTouchable.pollStickerEntityView.pollSticker);
                            AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.pollStickerEntityView.pollSticker.getDefaultFocusEditText());
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            FrameLayoutTouchable.this.pollStickerEntityView.addPollStickerViewAndSetParameters(FrameLayoutTouchable.this.pollStickerEntityView.pollSticker);
                            layoutParams.gravity = 17;
                            FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                            frameLayoutTouchable2.addEntityView(frameLayoutTouchable2.pollStickerEntityView, layoutParams);
                        }
                        FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                        FrameLayoutTouchable.this.pollToolsFrameLayout.setVisibility(8);
                    }
                });
            }
            StoryEntityView storyEntityView = this.pollStickerEntityView;
            if (storyEntityView == null) {
                this.pollStickerEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.poll;
                storyEntityItem.pollObject = new StoryPollObject();
                this.pollStickerEntityView.setOrEditEntityItem(storyEntityItem);
            } else {
                storyEntityView.pollSticker.setPollAddStoryMode(PollView.PollAddStoryMode.EDIT);
                try {
                    this.entityViewArray.remove(this.pollStickerEntityView);
                    this.frameLayoutEntityContainer.removeView(this.pollStickerEntityView);
                } catch (Exception unused) {
                }
            }
            this.pollToolsFrameLayout.addView(this.pollStickerEntityView.getPollStickerViewAndRemoveFromParent(), new FrameLayout.LayoutParams(-2, -2, 49));
            this.pollToolsFrameLayout.setVisibility(0);
            this.pollStickerEntityView.pollSticker.getDefaultFocusEditText().requestFocus();
            AndroidUtilities.showKeyboard(this.pollStickerEntityView.pollSticker.getDefaultFocusEditText());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openEmojiSliderEditView() {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            this.isWidgetToolsViewVisible = true;
            if (this.emojisliderToolsFrameLayout == null) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
                this.emojisliderToolsFrameLayout = sizeNotifierFrameLayout;
                sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
                this.emojisliderToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                addView(this.emojisliderToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
                this.emojisliderToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
                this.emojisliderToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.20
                    @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                    public void onSizeChanged(int i, boolean z) {
                        int availableHeight;
                        int i2;
                        if (FrameLayoutTouchable.this.emojiSliderStickerEntityView != null) {
                            EmojiSticker emojiSticker = FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker;
                            int height = emojiSticker.getHeight();
                            if (i > 0) {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            } else {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, 0, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            }
                            int i3 = availableHeight - i2;
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) emojiSticker.getLayoutParams();
                            if (i3 != layoutParams.topMargin) {
                                layoutParams.topMargin = i3;
                                ((FrameLayout.LayoutParams) FrameLayoutTouchable.this.emojiPickerRow.view.getLayoutParams()).setMargins(0, (AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) - FrameLayoutTouchable.this.emojiPickerRow.view.getHeight()) - AndroidUtilities.dp(16.0f), 0, 0);
                                emojiSticker.requestLayout();
                            }
                        }
                    }
                });
                ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
                imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
                this.emojisliderToolsFrameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FrameLayoutTouchable.this.isWidgetToolsViewVisible = false;
                        FrameLayoutTouchable.this.emojisliderToolsFrameLayout.setVisibility(8);
                        FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                        if (FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker != null) {
                            FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker.lockAddStoryMode(true);
                            FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                            frameLayoutTouchable.emojisliderToolsFrameLayout.removeView(frameLayoutTouchable.emojiSliderStickerEntityView.emojiSticker);
                            AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker.getFocusEditText());
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            FrameLayoutTouchable.this.emojiSliderStickerEntityView.addEmojiSliderStickerViewAndSetParameters(FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker);
                            layoutParams.gravity = 17;
                            FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                            frameLayoutTouchable2.addEntityView(frameLayoutTouchable2.emojiSliderStickerEntityView, layoutParams);
                        }
                    }
                });
                UI_rubinoEmojiPickerRow uI_rubinoEmojiPickerRow = new UI_rubinoEmojiPickerRow();
                this.emojiPickerRow = uI_rubinoEmojiPickerRow;
                uI_rubinoEmojiPickerRow.createView(ApplicationLoader.applicationActivity, AddStoryFragment.this.emojiCharSequences, 8, this.width, new UI_rubinoEmojiPickerRow.SelectEmojiListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.22
                    @Override // ir.resaneh1.iptv.UIView.UI_rubinoEmojiPickerRow.SelectEmojiListener
                    public void onSelectColor(CharSequence charSequence) {
                        if (FrameLayoutTouchable.this.emojiSliderStickerEntityView == null || FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker == null) {
                            return;
                        }
                        FrameLayoutTouchable.this.emojiSliderStickerEntityView.emojiSticker.setEmoji(charSequence.toString());
                    }
                });
                this.emojisliderToolsFrameLayout.addView(this.emojiPickerRow.view, LayoutHelper.createFrame(-1, -2.0f, 49, 0.0f, 0.0f, 0.0f, 0.0f));
            }
            StoryEntityView storyEntityView = this.emojiSliderStickerEntityView;
            if (storyEntityView == null) {
                this.emojiSliderStickerEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.emojiSlider;
                storyEntityItem.emojiSliderObject = new EmojiSliderObject();
                this.emojiSliderStickerEntityView.setOrEditEntityItem(storyEntityItem);
            } else {
                try {
                    this.entityViewArray.remove(storyEntityView);
                    this.frameLayoutEntityContainer.removeView(this.emojiSliderStickerEntityView);
                } catch (Exception unused) {
                }
            }
            final EmojiSticker emojiStickerViewAndRemoveFromParent = this.emojiSliderStickerEntityView.getEmojiStickerViewAndRemoveFromParent();
            emojiStickerViewAndRemoveFromParent.lockAddStoryMode(false);
            setChangeThemeAnimation(emojiStickerViewAndRemoveFromParent);
            UI_rubinoColorButton uI_rubinoColorButton = new UI_rubinoColorButton(ApplicationLoader.applicationActivity);
            this.emojisliderToolsFrameLayout.addView(uI_rubinoColorButton, LayoutHelper.createFrame(32, 32.0f, 49, 0.0f, 8.0f, 0.0f, 0.0f));
            final List listAsList = Arrays.asList(EmojiSticker.SliderTheme.values());
            this.emojiSliderCounter = listAsList.indexOf(emojiStickerViewAndRemoveFromParent.getTheme());
            uI_rubinoColorButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.access$6608(FrameLayoutTouchable.this);
                    FrameLayoutTouchable.access$6644(FrameLayoutTouchable.this, listAsList.size());
                    emojiStickerViewAndRemoveFromParent.startAnimation(FrameLayoutTouchable.this.zoomOut);
                    emojiStickerViewAndRemoveFromParent.setSliderTheme((EmojiSticker.SliderTheme) listAsList.get(FrameLayoutTouchable.this.emojiSliderCounter));
                }
            });
            this.emojisliderToolsFrameLayout.addView(emojiStickerViewAndRemoveFromParent, 0, new FrameLayout.LayoutParams(-2, -2, 49));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 51);
            ExtraView extraView = this.emojiSliderStickerEntityView.emojiExtraView;
            if (extraView != null && extraView.getParent() == null) {
                this.emojisliderToolsFrameLayout.addView(this.emojiSliderStickerEntityView.emojiExtraView, layoutParams);
            }
            this.emojisliderToolsFrameLayout.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.24
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return emojiStickerViewAndRemoveFromParent.onTouch(motionEvent.getX() - emojiStickerViewAndRemoveFromParent.getX(), motionEvent.getY() - emojiStickerViewAndRemoveFromParent.getY(), motionEvent.getAction());
                }
            });
            this.emojisliderToolsFrameLayout.setVisibility(0);
            EmojiSticker emojiSticker = this.emojiSliderStickerEntityView.emojiSticker;
            if (emojiSticker != null) {
                emojiSticker.getFocusEditText().requestFocus();
                AndroidUtilities.showKeyboard(this.emojiSliderStickerEntityView.emojiSticker.getFocusEditText());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openQuestionEditView() {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            this.isWidgetToolsViewVisible = true;
            if (this.questionToolsFrameLayout == null) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
                this.questionToolsFrameLayout = sizeNotifierFrameLayout;
                sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
                this.questionToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.25
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                addView(this.questionToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
                this.questionToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
                this.questionToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.26
                    @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                    public void onSizeChanged(int i, boolean z) {
                        int availableHeight;
                        int i2;
                        if (FrameLayoutTouchable.this.questionStickerEntityView != null) {
                            QuestionSticker questionSticker = FrameLayoutTouchable.this.questionStickerEntityView.questionSticker;
                            int height = questionSticker.getHeight();
                            if (i > 0) {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            } else {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, 0, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            }
                            int i3 = availableHeight - i2;
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) questionSticker.getLayoutParams();
                            if (i3 != layoutParams.topMargin) {
                                layoutParams.topMargin = i3;
                                questionSticker.requestLayout();
                            }
                        }
                    }
                });
                ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
                imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
                this.questionToolsFrameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FrameLayoutTouchable.this.isWidgetToolsViewVisible = false;
                        FrameLayoutTouchable.this.questionStickerEntityView.questionSticker.setLockView(true);
                        FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                        frameLayoutTouchable.questionToolsFrameLayout.removeView(frameLayoutTouchable.questionStickerEntityView.questionSticker);
                        FrameLayoutTouchable.this.questionToolsFrameLayout.setVisibility(8);
                        FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                        AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.questionStickerEntityView.questionSticker.getFocusEditText());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        FrameLayoutTouchable.this.questionStickerEntityView.addQuestionStickerViewAndSetParameters(FrameLayoutTouchable.this.questionStickerEntityView.questionSticker);
                        layoutParams.gravity = 17;
                        FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                        frameLayoutTouchable2.addEntityView(frameLayoutTouchable2.questionStickerEntityView, layoutParams);
                    }
                });
            }
            StoryEntityView storyEntityView = this.questionStickerEntityView;
            if (storyEntityView == null) {
                this.questionStickerEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.question;
                storyEntityItem.questionObject = new StoryQuestionObject();
                this.questionStickerEntityView.setOrEditEntityItem(storyEntityItem);
            } else {
                try {
                    this.entityViewArray.remove(storyEntityView);
                    this.frameLayoutEntityContainer.removeView(this.questionStickerEntityView);
                } catch (Exception unused) {
                }
            }
            final QuestionSticker questionStickerViewAndRemoveFromParent = this.questionStickerEntityView.getQuestionStickerViewAndRemoveFromParent();
            questionStickerViewAndRemoveFromParent.setLockView(false);
            UI_rubinoColorButton uI_rubinoColorButton = new UI_rubinoColorButton(ApplicationLoader.applicationActivity);
            this.questionToolsFrameLayout.addView(uI_rubinoColorButton, LayoutHelper.createFrame(32, 32.0f, 49, 0.0f, 8.0f, 0.0f, 0.0f));
            uI_rubinoColorButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.28
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            this.questionToolsFrameLayout.addView(questionStickerViewAndRemoveFromParent, 0, new FrameLayout.LayoutParams(-2, -2, 49));
            this.questionToolsFrameLayout.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.29
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    motionEvent.getX();
                    questionStickerViewAndRemoveFromParent.getX();
                    motionEvent.getY();
                    questionStickerViewAndRemoveFromParent.getY();
                    return false;
                }
            });
            this.questionToolsFrameLayout.setVisibility(0);
            this.questionStickerEntityView.questionSticker.getFocusEditText().requestFocus();
            AndroidUtilities.showKeyboard(this.questionStickerEntityView.questionSticker.getFocusEditText());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void openQuizEditView() {
            changePaintMode(false);
            startMainToolViewAnimation(false, false);
            this.isWidgetToolsViewVisible = true;
            if (this.quizToolsFrameLayout == null) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
                this.quizToolsFrameLayout = sizeNotifierFrameLayout;
                sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
                this.quizToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.30
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                addView(this.quizToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
                this.quizToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
                this.quizToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.31
                    @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                    public void onSizeChanged(int i, boolean z) {
                        int availableHeight;
                        int i2;
                        if (FrameLayoutTouchable.this.quizStickerEntityView != null) {
                            QuizSticker quizSticker = FrameLayoutTouchable.this.quizStickerEntityView.quizSticker;
                            int height = quizSticker.getHeight();
                            if (i > 0) {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            } else {
                                availableHeight = AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, 0, DimensionHelper.isShowstoryNeedFullScreen()) / 2;
                                i2 = height / 2;
                            }
                            int i3 = availableHeight - i2;
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) quizSticker.getLayoutParams();
                            if (i3 != layoutParams.topMargin) {
                                layoutParams.topMargin = i3;
                                quizSticker.requestLayout();
                            }
                        }
                    }
                });
                ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
                this.imageViewQuizDone = imageView;
                imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
                this.quizToolsFrameLayout.addView(this.imageViewQuizDone, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
            }
            StoryEntityView storyEntityView = this.quizStickerEntityView;
            if (storyEntityView == null) {
                this.quizStickerEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.quiz;
                storyEntityItem.quizObject = new StoryQuizObject();
                this.quizStickerEntityView.setOrEditEntityItem(storyEntityItem);
            } else {
                try {
                    this.entityViewArray.remove(storyEntityView);
                    this.frameLayoutEntityContainer.removeView(this.quizStickerEntityView);
                } catch (Exception unused) {
                }
            }
            final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.isWidgetToolsViewVisible = false;
                    FrameLayoutTouchable.this.quizStickerEntityView.quizSticker.setLock(true);
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    frameLayoutTouchable.quizToolsFrameLayout.removeView(frameLayoutTouchable.quizStickerEntityView.quizSticker);
                    FrameLayoutTouchable.this.quizToolsFrameLayout.setVisibility(8);
                    FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                    AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.quizStickerEntityView.quizSticker.getDefaultFocusEditText());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    FrameLayoutTouchable.this.quizStickerEntityView.addQuizStickerViewAndSetParameters(FrameLayoutTouchable.this.quizStickerEntityView.quizSticker);
                    layoutParams.gravity = 17;
                    FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                    frameLayoutTouchable2.addEntityView(frameLayoutTouchable2.quizStickerEntityView, layoutParams);
                }
            };
            QuizSticker quizStickerViewAndRemoveFromParent = this.quizStickerEntityView.getQuizStickerViewAndRemoveFromParent();
            quizStickerViewAndRemoveFromParent.setLock(false);
            setChangeThemeAnimation(quizStickerViewAndRemoveFromParent);
            quizStickerViewAndRemoveFromParent.setDelegate(new QuizSticker.Delegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.33
                @Override // ir.resaneh1.iptv.story.quiz.QuizSticker.Delegate
                public void onSelectOption(int i) {
                }

                @Override // ir.resaneh1.iptv.story.quiz.QuizSticker.Delegate
                public void onEnableLockMode() {
                    System.out.println("*** enable lock");
                    if (FrameLayoutTouchable.this.imageViewQuizDone != null) {
                        FrameLayoutTouchable.this.imageViewQuizDone.setAlpha(1.0f);
                        FrameLayoutTouchable.this.imageViewQuizDone.setOnClickListener(onClickListener);
                    }
                }

                @Override // ir.resaneh1.iptv.story.quiz.QuizSticker.Delegate
                public void onDisableLockMode(QuizSticker.LockError lockError) {
                    if (FrameLayoutTouchable.this.imageViewQuizDone != null) {
                        FrameLayoutTouchable.this.imageViewQuizDone.setAlpha(0.5f);
                        FrameLayoutTouchable.this.imageViewQuizDone.setOnClickListener(null);
                    }
                    if (lockError != null) {
                        ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, lockError + BuildConfig.FLAVOR);
                    }
                }

                @Override // ir.resaneh1.iptv.story.quiz.QuizSticker.Delegate
                public Point realValueOfEventPosition(int i, int i2) {
                    Point point = new Point();
                    point.x = i;
                    point.y = i2;
                    return point;
                }
            });
            UI_rubinoColorButton uI_rubinoColorButton = new UI_rubinoColorButton(ApplicationLoader.applicationActivity);
            this.quizToolsFrameLayout.addView(uI_rubinoColorButton, LayoutHelper.createFrame(32, 32.0f, 49, 0.0f, 8.0f, 0.0f, 0.0f));
            final List listAsList = Arrays.asList(QuizSticker.QuizTheme.values());
            this.emojiSliderCounter = listAsList.indexOf(this.quizStickerEntityView.quizSticker.getTheme());
            uI_rubinoColorButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.34
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.access$7108(FrameLayoutTouchable.this);
                    FrameLayoutTouchable.access$7144(FrameLayoutTouchable.this, listAsList.size());
                    FrameLayoutTouchable.this.quizStickerEntityView.quizSticker.startAnimation(FrameLayoutTouchable.this.zoomOut);
                    FrameLayoutTouchable.this.quizStickerEntityView.quizSticker.setTheme(((QuizSticker.QuizTheme) listAsList.get(FrameLayoutTouchable.this.quizCounter)).getThemeModel());
                }
            });
            this.quizToolsFrameLayout.addView(quizStickerViewAndRemoveFromParent, 0, new FrameLayout.LayoutParams(-2, -2, 49));
            this.quizToolsFrameLayout.setVisibility(0);
            this.quizStickerEntityView.quizSticker.getDefaultFocusEditText().requestFocus();
            AndroidUtilities.showKeyboard(this.quizStickerEntityView.quizSticker.getDefaultFocusEditText());
        }

        private void setChangeThemeAnimation(final View view) {
            if (view == null) {
                return;
            }
            if (this.zoomOut == null) {
                this.zoomOut = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_out);
            }
            if (this.zoomIn == null) {
                this.zoomIn = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_in);
            }
            this.zoomOut.setAnimationListener(new Animation.AnimationListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.35
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    view.startAnimation(FrameLayoutTouchable.this.zoomIn);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getColorOfPoint(int i, int i2) {
            if (i2 > this.paintView.getHeight() || i > this.paintView.getWidth()) {
                return;
            }
            Bitmap overlayBitmap = getOverlayBitmap();
            int pixel = overlayBitmap != null ? overlayBitmap.getPixel(i, i2) : 0;
            MyLog.e("AddStoryFragment", "getColorOfPoint " + i + " " + i2 + " " + pixel);
            if (pixel == 0) {
                if (AddStoryFragment.this.isRendererAvailable() && !Utils.useNewStoryCreationSystem()) {
                    AddStoryFragment.this.glRenderer.setColorPickerListener(AddStoryFragment.this);
                    AddStoryFragment.this.glRenderer.setColorPickingMode(true);
                }
                if (AddStoryFragment.this.isRendererAvailable()) {
                    if (!Utils.useNewStoryCreationSystem()) {
                        AddStoryFragment.this.glRenderer.getPixelColor(i, i2);
                        return;
                    } else {
                        internalGetPixelColor(i, i2);
                        return;
                    }
                }
                return;
            }
            setPickerColor(i, i2, pixel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPickerColor(int i, int i2, final int i3) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.36
                @Override // java.lang.Runnable
                public void run() {
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                    if (uI_rubinoDropperSelectorCell != null) {
                        uI_rubinoDropperSelectorCell.setColor(i3);
                    }
                }
            });
        }

        private void internalGetPixelColor(int i, int i2) {
            if (AddStoryFragment.this.isRendererAvailable()) {
                AddStoryFragment.this.eglThread.setColorPickingMode(true);
                AddStoryFragment.this.eglThread.setColorPickerListener(AddStoryFragment.this);
                int storyViewWidthPx = (int) DimensionHelper.getStoryViewWidthPx((Activity) AddStoryFragment.this.mContext);
                if (storyViewWidthPx == AddStoryFragment.this.eglThread.getRenderBufferWidth()) {
                    AddStoryFragment.this.eglThread.getPixelColor(i, i2);
                    return;
                }
                AddStoryFragment.this.eglThread.getPixelColor((int) (i / (storyViewWidthPx / AddStoryFragment.this.eglThread.getRenderBufferWidth())), (int) (i2 / (((int) DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext)) / AddStoryFragment.this.eglThread.getRenderBufferHeight())));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap getOverlayBitmap() {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) DimensionHelper.getStoryViewWidthPx((Activity) AddStoryFragment.this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            layout(getLeft(), getTop(), getRight(), getBottom());
            this.paintView.draw(canvas);
            this.frameLayoutEntityContainer.draw(canvas);
            Bitmap bitmap = new BitmapDrawable(bitmapCreateBitmap).getBitmap();
            this.overlay = bitmap;
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndDrawPaintPath(ArrayList<FrameLayoutPaint.MyPath> arrayList) {
            this.paintView.paths.clear();
            if (arrayList != null) {
                this.paintView.paths.addAll(arrayList);
            }
            this.paintView.redrawCanvac();
            this.paintView.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateTextSelected(EditText editText, String str, String str2, int i) {
            if (editText == null || str2 == null) {
                return;
            }
            int selectionStart = editText.getSelectionStart();
            Editable text = editText.getText();
            if (text.toString().substring(i).indexOf(str2) >= 0) {
                editText.setText(text.toString().substring(0, i) + text.toString().substring(i).replace(str2, str));
                try {
                    editText.setSelection(selectionStart + (str.length() - str2.length()));
                } catch (Exception unused) {
                }
            }
        }

        private void createTextToolsView() {
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
            this.textToolsFrameLayout = sizeNotifierFrameLayout;
            sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
            this.textToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            addView(this.textToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
            this.textToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
            UI_rubinoColorPickerRow uI_rubinoColorPickerRowCreateAndGetColorPickerRow = createAndGetColorPickerRow(true);
            this.textColorPickerRow = uI_rubinoColorPickerRowCreateAndGetColorPickerRow;
            this.textToolsFrameLayout.addView(uI_rubinoColorPickerRowCreateAndGetColorPickerRow.view, LayoutHelper.createFrame(-1, -2, 80));
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow = new UI_rubinoSuggestionRow();
            this.ui_rubinoHashtagSuggestionRow2 = uI_rubinoSuggestionRow;
            uI_rubinoSuggestionRow.createView(ApplicationLoader.applicationActivity, new UI_rubinoSuggestionRow.SelectItemListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.38
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow.SelectItemListener
                public void onSelectItem(String str, String str2, int i) {
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    frameLayoutTouchable.updateTextSelected(frameLayoutTouchable.editText, str.replace("#", BuildConfig.FLAVOR), str2, i);
                }
            }, UI_rubinoSuggestionRow.SuggestionTypeEnum.hashtag);
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.textToolsFrameLayout;
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow2 = this.ui_rubinoHashtagSuggestionRow2;
            sizeNotifierFrameLayout2.addView(uI_rubinoSuggestionRow2.view, LayoutHelper.createFrame(-1, uI_rubinoSuggestionRow2.itemHeightDp, 80));
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow3 = new UI_rubinoSuggestionRow();
            this.ui_rubinoProfileSuggestionRow2 = uI_rubinoSuggestionRow3;
            uI_rubinoSuggestionRow3.createView(ApplicationLoader.applicationActivity, new UI_rubinoSuggestionRow.SelectItemListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.39
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow.SelectItemListener
                public void onSelectItem(String str, String str2, int i) {
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    frameLayoutTouchable.updateTextSelected(frameLayoutTouchable.editText, str, str2, i);
                }
            }, UI_rubinoSuggestionRow.SuggestionTypeEnum.mention);
            SizeNotifierFrameLayout sizeNotifierFrameLayout3 = this.textToolsFrameLayout;
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow4 = this.ui_rubinoProfileSuggestionRow2;
            sizeNotifierFrameLayout3.addView(uI_rubinoSuggestionRow4.view, LayoutHelper.createFrame(-1, uI_rubinoSuggestionRow4.itemHeightDp, 80));
            this.ui_rubinoHashtagSuggestionRow2.view.setVisibility(8);
            this.ui_rubinoProfileSuggestionRow2.view.setVisibility(8);
            int iPxToDp = DimensionHelper.pxToDp(ApplicationLoader.applicationActivity, this.width) - 56;
            final int iDp = this.textColorPickerRow.itemWidth + AndroidUtilities.dp(8.0f);
            this.newEditTextHeight = AndroidUtilities.dp(200.0f);
            this.currentTextAttribute = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.none, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, this.defaultTextSizeInDp, -1, StoryTextAttributeObject.TextColorTypeEnum.simple);
            EditText editText = new EditText(ApplicationLoader.applicationActivity);
            this.editText = editText;
            editText.setPadding(AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f));
            this.editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.40
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (FrameLayoutTouchable.this.needToRefreshEditText) {
                        FrameLayoutTouchable.this.needToRefreshEditText = false;
                        FrameLayoutTouchable.this.updateEditText();
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 23) {
                this.editText.setHyphenationFrequency(0);
                this.editText.setBreakStrategy(0);
            }
            this.editText.setMaxWidth(AndroidUtilities.dp(iPxToDp) - (AndroidUtilities.dp(this.edittextPadding) * 2));
            this.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.41
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    FrameLayoutTouchable.this.editText.removeTextChangedListener(this);
                    FrameLayoutTouchable.this.updateEditText();
                    FrameLayoutTouchable.this.editText.addTextChangedListener(this);
                }
            });
            this.textToolsFrameLayout.addView(this.editText, LayoutHelper.createFrame(iPxToDp, -2, 49));
            this.textToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.42
                @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                public void onSizeChanged(int i, boolean z) {
                    int availableHeight = ((AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) - FrameLayoutTouchable.this.textToolsFrameLayout.getPaddingTop()) - iDp) - AndroidUtilities.dp(FrameLayoutTouchable.this.editTextTopMargin);
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    if (availableHeight != frameLayoutTouchable.newEditTextHeight) {
                        frameLayoutTouchable.newEditTextHeight = availableHeight;
                        AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen());
                        AndroidUtilities.dp(16.0f);
                        FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                        frameLayoutTouchable2.currentKeyboardHeight = i;
                        ((FrameLayout.LayoutParams) frameLayoutTouchable2.textSeekBar.view.getLayoutParams()).setMargins(0, (FrameLayoutTouchable.this.newEditTextHeight - AndroidUtilities.dp(r4.textSeekBar.heightInDp)) / 2, 0, 0);
                        FrameLayoutTouchable.this.textSeekBar.view.requestLayout();
                        FrameLayoutTouchable.this.updateEditTextMargin();
                    }
                }
            });
            ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
            imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
            this.textToolsFrameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.43
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayout.LayoutParams layoutParams;
                    FrameLayoutTouchable.this.textToolsFrameLayout.setVisibility(8);
                    AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.editText);
                    FrameLayoutTouchable.this.mainToolsView.setVisibility(0);
                    if (FrameLayoutTouchable.this.toEditTextEntity == null) {
                        if (FrameLayoutTouchable.this.editText.getText().length() > 0) {
                            if (FrameLayoutTouchable.this.editText.getLayout() != null && FrameLayoutTouchable.this.editText.getLayout().getHeight() > 0) {
                                layoutParams = new FrameLayout.LayoutParams(-2, FrameLayoutTouchable.this.editText.getLayout().getHeight());
                            } else {
                                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            }
                            StoryEntityView storyEntityView = new StoryEntityView(ApplicationLoader.applicationContext);
                            StoryTextAttributeObject storyTextAttributeObjectM531clone = FrameLayoutTouchable.this.currentTextAttribute.m531clone();
                            storyTextAttributeObjectM531clone.spannableString = FrameLayoutTouchable.this.editText.getText();
                            storyTextAttributeObjectM531clone.layout = FrameLayoutTouchable.this.editText.getLayout();
                            Spannable spannable = storyTextAttributeObjectM531clone.spannableString;
                            for (UnderlineSpan underlineSpan : (UnderlineSpan[]) spannable.getSpans(0, spannable.length(), UnderlineSpan.class)) {
                                storyTextAttributeObjectM531clone.spannableString.removeSpan(underlineSpan);
                            }
                            storyEntityView.addOrEditText(storyTextAttributeObjectM531clone, FrameLayoutTouchable.this.editText.getLayout().getWidth() + (AndroidUtilities.dp(FrameLayoutTouchable.this.edittextPadding) * 2), FrameLayoutTouchable.this.editText.getLayout().getHeight());
                            layoutParams.gravity = 17;
                            FrameLayoutTouchable.this.addEntityView(storyEntityView, layoutParams);
                            return;
                        }
                        return;
                    }
                    if (FrameLayoutTouchable.this.editText.getText().length() > 0) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) FrameLayoutTouchable.this.toEditTextEntity.getLayoutParams();
                        if (FrameLayoutTouchable.this.editText.getLayout() != null && FrameLayoutTouchable.this.editText.getLayout().getHeight() > 0) {
                            layoutParams2.height = FrameLayoutTouchable.this.editText.getLayout().getHeight();
                        }
                        FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString = FrameLayoutTouchable.this.editText.getText();
                        FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.layout = FrameLayoutTouchable.this.editText.getLayout();
                        for (UnderlineSpan underlineSpan2 : (UnderlineSpan[]) FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.getSpans(0, FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.length(), UnderlineSpan.class)) {
                            FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.removeSpan(underlineSpan2);
                        }
                        FrameLayoutTouchable.this.toEditTextEntity.addOrEditText(FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject, FrameLayoutTouchable.this.editText.getLayout().getWidth() + (AndroidUtilities.dp(FrameLayoutTouchable.this.edittextPadding) * 2), FrameLayoutTouchable.this.editText.getLayout().getHeight());
                        FrameLayoutTouchable.this.toEditTextEntity.setLayoutParams(layoutParams2);
                        FrameLayoutTouchable.this.toEditTextEntity.requestLayout();
                        FrameLayoutTouchable.this.toEditTextEntity.setVisibility(0);
                    } else {
                        FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                        frameLayoutTouchable.entityViewArray.remove(frameLayoutTouchable.toEditTextEntity);
                        FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                        frameLayoutTouchable2.frameLayoutEntityContainer.removeView(frameLayoutTouchable2.toEditTextEntity);
                    }
                    FrameLayoutTouchable.this.toEditTextEntity = null;
                }
            });
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textType = textView;
            textView.setBackground(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.shape_rectangle_border_white));
            this.textType.setTextColor(-1);
            this.textType.setText(StoryTextAttributeObject.getFontStringByType(this.currentTextAttribute));
            this.textType.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
            this.textType.setGravity(17);
            this.textType.setTextSize(1, 15.0f);
            this.textType.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
            this.textToolsFrameLayout.addView(this.textType, LayoutHelper.createFrame(-2, 28.0f, 49, 0.0f, 8.0f, 0.0f, 0.0f));
            this.textType.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StoryTextAttributeObject storyTextAttributeObject = FrameLayoutTouchable.this.currentTextAttribute;
                    storyTextAttributeObject.textFont = StoryTextAttributeObject.getNextTextFont(storyTextAttributeObject);
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    StoryTextAttributeObject storyTextAttributeObject2 = frameLayoutTouchable.currentTextAttribute;
                    storyTextAttributeObject2.backGroundType = StoryTextAttributeObject.BackGroundType.none;
                    storyTextAttributeObject2.textAlignmentType = StoryTextAttributeObject.TextAlignmentEnum.center;
                    frameLayoutTouchable.setAlignmentAndBackgroundByType();
                    FrameLayoutTouchable.this.editText.setTypeface(FrameLayoutTouchable.this.currentTextAttribute.getTypeFace());
                    FrameLayoutTouchable.this.updateEditText();
                    FrameLayoutTouchable.this.textType.setText(StoryTextAttributeObject.getFontStringByType(FrameLayoutTouchable.this.currentTextAttribute));
                }
            });
            ImageView imageView2 = new ImageView(ApplicationLoader.applicationActivity);
            this.imageViewTextAlign = imageView2;
            imageView2.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_text_align_center));
            this.textToolsFrameLayout.addView(this.imageViewTextAlign, LayoutHelper.createFrame(48, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
            this.imageViewTextAlign.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.45
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StoryTextAttributeObject storyTextAttributeObject = FrameLayoutTouchable.this.currentTextAttribute;
                    storyTextAttributeObject.textAlignmentType = StoryTextAttributeObject.getNextAlignment(storyTextAttributeObject);
                    FrameLayoutTouchable.this.editText.setGravity(StoryTextAttributeObject.getGravity(FrameLayoutTouchable.this.currentTextAttribute));
                    FrameLayoutTouchable.this.updateTextColorAndBackground();
                    FrameLayoutTouchable.this.editText.invalidate();
                    FrameLayoutTouchable.this.imageViewTextAlign.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getAlignmentIconIdByType(FrameLayoutTouchable.this.currentTextAttribute)));
                }
            });
            ImageView imageView3 = new ImageView(ApplicationLoader.applicationActivity);
            this.imageViewTextBackGround = imageView3;
            imageView3.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getBackgroundIconIdByType(this.currentTextAttribute)));
            this.textToolsFrameLayout.addView(this.imageViewTextBackGround, LayoutHelper.createFrame(48, 48.0f, 51, 48.0f, 0.0f, 0.0f, 0.0f));
            this.imageViewTextBackGround.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.46
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StoryTextAttributeObject storyTextAttributeObject = FrameLayoutTouchable.this.currentTextAttribute;
                    storyTextAttributeObject.backGroundType = StoryTextAttributeObject.getNextBackGround(storyTextAttributeObject);
                    FrameLayoutTouchable.this.updateTextColorAndBackground();
                    FrameLayoutTouchable.this.editText.invalidate();
                    FrameLayoutTouchable.this.imageViewTextBackGround.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getBackgroundIconIdByType(FrameLayoutTouchable.this.currentTextAttribute)));
                }
            });
            UI_rubinoSeekBar uI_rubinoSeekBar = new UI_rubinoSeekBar();
            this.textSeekBar = uI_rubinoSeekBar;
            uI_rubinoSeekBar.createView(ApplicationLoader.applicationActivity, new UI_rubinoSeekBar.ChangeSizeListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.47
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSeekBar.ChangeSizeListener
                public void onSelectSize(float f) {
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
                    FrameLayoutTouchable.this.changeTextSize(f);
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = FrameLayoutTouchable.this.dropperCell;
                    if (uI_rubinoDropperSelectorCell == null || (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) == null) {
                        return;
                    }
                    dropperSelectorFrameLayout.setVisibility(8);
                    FrameLayoutTouchable.this.dropperVisible = false;
                }
            }, 240, false);
            this.textToolsFrameLayout.addView(this.textSeekBar.view, LayoutHelper.createFrame(-2, 300.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
        }

        private void createHashtagOrMentionToolsView() {
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(ApplicationLoader.applicationActivity);
            this.hashtagToolsFrameLayout = sizeNotifierFrameLayout;
            sizeNotifierFrameLayout.setBackgroundColor(-1979711488);
            this.hashtagToolsFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.48
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            addView(this.hashtagToolsFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
            this.hashtagToolsFrameLayout.setPadding(0, AndroidUtilities.statusBarHeight / 2, 0, 0);
            int iPxToDp = DimensionHelper.pxToDp(ApplicationLoader.applicationActivity, this.width) - 56;
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow = new UI_rubinoSuggestionRow();
            this.ui_rubinoHashtagSuggestionRow = uI_rubinoSuggestionRow;
            uI_rubinoSuggestionRow.createView(ApplicationLoader.applicationActivity, new UI_rubinoSuggestionRow.SelectItemListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.49
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow.SelectItemListener
                public void onSelectItem(String str, String str2, int i) {
                    FrameLayoutTouchable.this.hashtagEditText.setText(str);
                    try {
                        FrameLayoutTouchable.this.hashtagEditText.setSelection(FrameLayoutTouchable.this.hashtagEditText.getText().toString().length());
                    } catch (Exception unused) {
                    }
                }
            }, UI_rubinoSuggestionRow.SuggestionTypeEnum.hashtag);
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.hashtagToolsFrameLayout;
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow2 = this.ui_rubinoHashtagSuggestionRow;
            sizeNotifierFrameLayout2.addView(uI_rubinoSuggestionRow2.view, LayoutHelper.createFrame(-1, uI_rubinoSuggestionRow2.itemHeightDp, 80));
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow3 = new UI_rubinoSuggestionRow();
            this.ui_rubinoProfileSuggestionRow = uI_rubinoSuggestionRow3;
            uI_rubinoSuggestionRow3.createView(ApplicationLoader.applicationActivity, new UI_rubinoSuggestionRow.SelectItemListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.50
                @Override // ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow.SelectItemListener
                public void onSelectItem(String str, String str2, int i) {
                    FrameLayoutTouchable.this.hashtagEditText.setText(str);
                    try {
                        FrameLayoutTouchable.this.hashtagEditText.setSelection(FrameLayoutTouchable.this.hashtagEditText.getText().toString().length());
                    } catch (Exception unused) {
                    }
                }
            }, UI_rubinoSuggestionRow.SuggestionTypeEnum.mention);
            SizeNotifierFrameLayout sizeNotifierFrameLayout3 = this.hashtagToolsFrameLayout;
            UI_rubinoSuggestionRow uI_rubinoSuggestionRow4 = this.ui_rubinoProfileSuggestionRow;
            sizeNotifierFrameLayout3.addView(uI_rubinoSuggestionRow4.view, LayoutHelper.createFrame(-1, uI_rubinoSuggestionRow4.itemHeightDp, 80));
            this.newEditTextHeight = AndroidUtilities.dp(200.0f);
            this.currentTextAttribute = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.rounded, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, this.defaultHashtagTextSizeInDp, -1, StoryTextAttributeObject.TextColorTypeEnum.twoColorPink);
            EditText editText = new EditText(ApplicationLoader.applicationActivity);
            this.hashtagEditText = editText;
            editText.setPadding(AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f));
            InputFilter inputFilter = InputFilterHelper.getFilter(40, 1, this.hashtagEditText)[0];
            new InputFilter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.51
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    if (charSequence == null) {
                        return BuildConfig.FLAVOR;
                    }
                    if (!FrameLayoutTouchable.this.hashtagPattern.toString().matches(charSequence.toString().toLowerCase())) {
                        charSequence = charSequence.toString().replaceAll("[^A-Za-z0-9_\\u0621-\\u06cc\\u06f0-\\u06f9]", BuildConfig.FLAVOR);
                    }
                    String str = FrameLayoutTouchable.this.isHashtag ? "#" : "@";
                    if (spanned.length() <= 0 && charSequence.length() > 0 && !charSequence.toString().startsWith(str)) {
                        charSequence = str + charSequence.toString();
                    }
                    return charSequence.toString().toUpperCase();
                }
            };
            this.hashtagEditText.setSingleLine(true);
            this.hashtagEditText.setMaxWidth(AndroidUtilities.dp(iPxToDp) - (AndroidUtilities.dp(this.edittextPadding) * 2));
            this.hashtagEditText.setGravity(StoryTextAttributeObject.getGravity(this.currentTextAttribute));
            this.hashtagEditText.setTextSize(1, this.currentTextAttribute.textSizeInDp);
            this.hashtagEditText.setBackground(this.currentTextAttribute.getHashtagBackground());
            this.hashtagWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.52
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    FrameLayoutTouchable.this.hashtagEditText.removeTextChangedListener(FrameLayoutTouchable.this.hashtagWatcher);
                    Editable text = FrameLayoutTouchable.this.hashtagEditText.getText();
                    MyLog.e("AddStoryFragment", "hashtagEditText " + ((Object) FrameLayoutTouchable.this.hashtagEditText.getText()));
                    String str = FrameLayoutTouchable.this.isHashtag ? "#" : "@";
                    if (!text.toString().startsWith(str) && text.length() > 0) {
                        int selectionStart = FrameLayoutTouchable.this.hashtagEditText.getSelectionStart();
                        FrameLayoutTouchable.this.hashtagEditText.setText(str + text.toString());
                        try {
                            FrameLayoutTouchable.this.hashtagEditText.setSelection(selectionStart + 1);
                        } catch (Exception unused) {
                        }
                    }
                    MyLog.e("AddStoryFragment", "hashtagEditText2 " + ((Object) FrameLayoutTouchable.this.hashtagEditText.getText()));
                    if (text.toString().equals(str)) {
                        FrameLayoutTouchable.this.hashtagEditText.setText(BuildConfig.FLAVOR);
                    }
                    if (text.length() > 1) {
                        FrameLayoutTouchable.this.hashtagEditText.setHint(BuildConfig.FLAVOR);
                    } else {
                        if (FrameLayoutTouchable.this.isHashtag) {
                            FrameLayoutTouchable.this.hashtagEditText.setHint("#HASHTAG");
                        } else {
                            FrameLayoutTouchable.this.hashtagEditText.setHint("@MENTION");
                        }
                        FrameLayoutTouchable.this.hashtagEditText.requestLayout();
                    }
                    FrameLayoutTouchable.this.needToRefreshHashtagEditText = true;
                    FrameLayoutTouchable.this.updateHashTagEditTextSize();
                    MyLog.e("AddStoryFragment", "hashtagEditText3 " + ((Object) FrameLayoutTouchable.this.hashtagEditText.getText()));
                    FrameLayoutTouchable.this.hashtagEditText.addTextChangedListener(FrameLayoutTouchable.this.hashtagWatcher);
                }
            };
            this.hashtagEditText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.53
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (FrameLayoutTouchable.this.hashtagEditText == null || FrameLayoutTouchable.this.hashtagEditText.getLayout() == null || !FrameLayoutTouchable.this.needToRefreshHashtagEditText) {
                        return;
                    }
                    float maxWidth = FrameLayoutTouchable.this.hashtagEditText.getMaxWidth() - (AndroidUtilities.dp(FrameLayoutTouchable.this.edittextPadding) * 2);
                    if (FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineCount() > 0) {
                        float lineWidth = FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineWidth(0) + (AndroidUtilities.dp(FrameLayoutTouchable.this.edittextPadding) * 2);
                        if (lineWidth > 0.0f) {
                            float f = maxWidth / lineWidth;
                            if (f < 1.0f) {
                                FrameLayoutTouchable.this.updateHashTagEditTextSize();
                                return;
                            }
                            if (f > 1.3d) {
                                FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                                if (frameLayoutTouchable.currentTextAttribute.textSizeInDp < frameLayoutTouchable.defaultHashtagTextSizeInDp) {
                                    frameLayoutTouchable.updateHashTagEditTextSize();
                                    return;
                                }
                            }
                            if (FrameLayoutTouchable.this.needToRefreshHashtagEditText) {
                                FrameLayoutTouchable.this.needToRefreshHashtagEditText = false;
                                if (FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineCount() <= 0) {
                                    FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(null);
                                    FrameLayoutTouchable.this.hashtagEditText.setTextColor(-1);
                                } else {
                                    FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                                    StoryTextAttributeObject storyTextAttributeObject = frameLayoutTouchable2.currentTextAttribute;
                                    Shader textPaintShader = storyTextAttributeObject.getTextPaintShader(storyTextAttributeObject.textColorType, AndroidUtilities.dp(8.0f) + frameLayoutTouchable2.hashtagEditText.getLayout().getLineLeft(0), FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineTop(0) + AndroidUtilities.dp(2.0f), FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineRight(0) - AndroidUtilities.dp(8.0f), FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineBottom(0) - AndroidUtilities.dp(2.0f));
                                    if (textPaintShader == null) {
                                        FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(null);
                                        FrameLayoutTouchable.this.hashtagEditText.setTextColor(-1);
                                    } else {
                                        FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(textPaintShader);
                                    }
                                }
                                FrameLayoutTouchable.this.updateHashtagEditTextMargin();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (FrameLayoutTouchable.this.needToRefreshHashtagEditText) {
                        FrameLayoutTouchable.this.needToRefreshHashtagEditText = false;
                        if (FrameLayoutTouchable.this.hashtagEditText.getLayout().getLineCount() <= 0) {
                            FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(null);
                            FrameLayoutTouchable.this.hashtagEditText.setTextColor(-1);
                        } else {
                            StoryTextAttributeObject storyTextAttributeObject2 = FrameLayoutTouchable.this.currentTextAttribute;
                            Shader textPaintShader2 = storyTextAttributeObject2.getTextPaintShader(storyTextAttributeObject2.textColorType, r0.hashtagEditText.getLeft(), FrameLayoutTouchable.this.hashtagEditText.getTop(), FrameLayoutTouchable.this.hashtagEditText.getRight(), FrameLayoutTouchable.this.hashtagEditText.getBottom());
                            if (textPaintShader2 == null) {
                                FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(null);
                                FrameLayoutTouchable.this.hashtagEditText.setTextColor(-1);
                            } else {
                                FrameLayoutTouchable.this.hashtagEditText.getPaint().setShader(textPaintShader2);
                            }
                        }
                        FrameLayoutTouchable.this.updateHashtagEditTextMargin();
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 23) {
                this.hashtagEditText.setHyphenationFrequency(0);
                this.hashtagEditText.setBreakStrategy(0);
            }
            this.hashtagEditText.addTextChangedListener(this.hashtagWatcher);
            setupHashtagRxListener(this.hashtagEditText, 250);
            this.hashtagToolsFrameLayout.addView(this.hashtagEditText, LayoutHelper.createFrame(-2, -2, 49));
            this.hashtagToolsFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.54
                @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
                public void onSizeChanged(int i, boolean z) {
                    int availableHeight = ((AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen()) - FrameLayoutTouchable.this.hashtagEditText.getPaddingTop()) - (FrameLayoutTouchable.this.isHashtag ? AndroidUtilities.dp(FrameLayoutTouchable.this.ui_rubinoHashtagSuggestionRow.itemHeightDp) + AndroidUtilities.dp(4.0f) : AndroidUtilities.dp(FrameLayoutTouchable.this.ui_rubinoProfileSuggestionRow.itemHeightDp))) - AndroidUtilities.dp(FrameLayoutTouchable.this.editTextTopMargin);
                    FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                    if (availableHeight != frameLayoutTouchable.newEditTextHeight) {
                        frameLayoutTouchable.newEditTextHeight = availableHeight;
                        AndroidUtilities.getAvailableHeight((Activity) AddStoryFragment.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen());
                        AndroidUtilities.dp(16.0f);
                        FrameLayoutTouchable.this.updateHashtagEditTextMargin();
                    }
                }
            });
            ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
            imageView.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.story_overlay_check));
            this.hashtagToolsFrameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FrameLayoutTouchable.this.isWidgetToolsViewVisible = false;
                    FrameLayoutTouchable.this.hashtagToolsFrameLayout.setVisibility(8);
                    AndroidUtilities.hideKeyboard(FrameLayoutTouchable.this.hashtagEditText);
                    FrameLayoutTouchable.this.mainToolsView.setVisibility(0);
                    if (FrameLayoutTouchable.this.toEditTextEntity == null) {
                        if (FrameLayoutTouchable.this.hashtagEditText.getText().length() > 0) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            StoryEntityView storyEntityView = new StoryEntityView(ApplicationLoader.applicationContext);
                            StoryTextAttributeObject storyTextAttributeObjectM531clone = FrameLayoutTouchable.this.currentTextAttribute.m531clone();
                            Editable text = FrameLayoutTouchable.this.hashtagEditText.getText();
                            storyTextAttributeObjectM531clone.spannableString = text;
                            for (UnderlineSpan underlineSpan : (UnderlineSpan[]) text.getSpans(0, text.length(), UnderlineSpan.class)) {
                                storyTextAttributeObjectM531clone.spannableString.removeSpan(underlineSpan);
                            }
                            storyEntityView.addOrEditHashtagOrMention(storyTextAttributeObjectM531clone, FrameLayoutTouchable.this.isHashtag);
                            layoutParams.gravity = 17;
                            FrameLayoutTouchable.this.addEntityView(storyEntityView, layoutParams);
                            return;
                        }
                        return;
                    }
                    if (FrameLayoutTouchable.this.hashtagEditText.getText().length() > 0) {
                        FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString = FrameLayoutTouchable.this.hashtagEditText.getText();
                        FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.layout = FrameLayoutTouchable.this.hashtagEditText.getLayout();
                        for (UnderlineSpan underlineSpan2 : (UnderlineSpan[]) FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.getSpans(0, FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.length(), UnderlineSpan.class)) {
                            FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject.spannableString.removeSpan(underlineSpan2);
                        }
                        FrameLayoutTouchable.this.toEditTextEntity.addOrEditHashtagOrMention(FrameLayoutTouchable.this.toEditTextEntity.textAttributeObject, FrameLayoutTouchable.this.isHashtag);
                        FrameLayoutTouchable.this.toEditTextEntity.requestLayout();
                        FrameLayoutTouchable.this.toEditTextEntity.setVisibility(0);
                    } else {
                        FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                        frameLayoutTouchable.entityViewArray.remove(frameLayoutTouchable.toEditTextEntity);
                        FrameLayoutTouchable frameLayoutTouchable2 = FrameLayoutTouchable.this;
                        frameLayoutTouchable2.frameLayoutEntityContainer.removeView(frameLayoutTouchable2.toEditTextEntity);
                    }
                    FrameLayoutTouchable.this.toEditTextEntity = null;
                }
            });
        }

        private void setupHashtagRxListener(EditText editText, int i) {
            ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add(RxTextView.textChanges(editText).skip(1L).map(new Function<CharSequence, Object>(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.56
                @Override // io.reactivex.functions.Function
                public Object apply(CharSequence charSequence) throws Exception {
                    return charSequence.toString().toLowerCase();
                }
            }).debounce(i, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment$FrameLayoutTouchable$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$setupHashtagRxListener$0(obj);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setupHashtagRxListener$0(Object obj) throws Exception {
            if (obj.toString().startsWith("#")) {
                callSearchHashTag(obj.toString().trim().replace("#", BuildConfig.FLAVOR), 0);
            } else if (obj.toString().startsWith("@")) {
                callSearchRubinoProfile(obj.toString().trim().replace("@", BuildConfig.FLAVOR), 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callSearchHashTag(String str, final int i) {
            DisposableObserver disposableObserver = this.hashtagDisposable;
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
            final InstaGetListInput instaGetListInput = new InstaGetListInput();
            instaGetListInput.content = str;
            instaGetListInput.limit = 50;
            DisposableObserver disposableObserver2 = (DisposableObserver) AddStoryFragment.this.getApiRequestMessangerRx().rubinoSearchHashTag(instaGetListInput).subscribeWith(new DisposableObserver<MessangerOutput<InstaGetHashTagsOutput>>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.57
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<InstaGetHashTagsOutput> messangerOutput) {
                    if (FrameLayoutTouchable.this.ui_rubinoHashtagSuggestionRow != null) {
                        FrameLayoutTouchable.this.ui_rubinoHashtagSuggestionRow.updateHashtagList(messangerOutput.data.hash_tags, instaGetListInput.content, i);
                    }
                    if (FrameLayoutTouchable.this.ui_rubinoHashtagSuggestionRow2 != null) {
                        FrameLayoutTouchable.this.ui_rubinoHashtagSuggestionRow2.updateHashtagList(messangerOutput.data.hash_tags, instaGetListInput.content, i);
                    }
                }
            });
            this.hashtagDisposable = disposableObserver2;
            ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add(disposableObserver2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callSearchRubinoProfile(String str, final int i) {
            DisposableObserver disposableObserver = this.hashtagDisposable;
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
            final InstaGetListInput instaGetListInput = new InstaGetListInput();
            instaGetListInput.username = str;
            instaGetListInput.limit = 50;
            DisposableObserver disposableObserver2 = (DisposableObserver) AddStoryFragment.this.getApiRequestMessangerRx().rubinoSearchProfiles(instaGetListInput).subscribeWith(new DisposableObserver<MessangerOutput<InstaGetProfilesOutput>>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.58
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<InstaGetProfilesOutput> messangerOutput) {
                    if (FrameLayoutTouchable.this.ui_rubinoProfileSuggestionRow != null) {
                        FrameLayoutTouchable.this.ui_rubinoProfileSuggestionRow.updateProfileList(messangerOutput.data.profiles, instaGetListInput.username, i);
                    }
                    if (FrameLayoutTouchable.this.ui_rubinoProfileSuggestionRow2 != null) {
                        FrameLayoutTouchable.this.ui_rubinoProfileSuggestionRow2.updateProfileList(messangerOutput.data.profiles, instaGetListInput.username, i);
                    }
                }
            });
            this.hashtagDisposable = disposableObserver2;
            ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add(disposableObserver2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateHashtagEditTextMargin() {
            try {
                if ((this.newEditTextHeight - this.hashtagEditText.getLayout().getHeight()) / 2 > AndroidUtilities.dp(this.editTextTopMargin)) {
                    ((FrameLayout.LayoutParams) this.hashtagEditText.getLayoutParams()).setMargins(0, (this.newEditTextHeight - this.hashtagEditText.getLayout().getHeight()) / 2, 0, 0);
                } else {
                    ((FrameLayout.LayoutParams) this.hashtagEditText.getLayoutParams()).setMargins(0, AndroidUtilities.dp(this.editTextTopMargin), 0, 0);
                }
                this.hashtagEditText.setPadding(AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(this.edittextPadding), AndroidUtilities.dp(2.0f));
                this.hashtagEditText.requestLayout();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateEditTextMargin() {
            try {
                if ((this.newEditTextHeight - this.editText.getLayout().getHeight()) / 2 > AndroidUtilities.dp(this.editTextTopMargin)) {
                    ((FrameLayout.LayoutParams) this.editText.getLayoutParams()).setMargins(0, (this.newEditTextHeight - this.editText.getLayout().getHeight()) / 2, 0, 0);
                } else {
                    ((FrameLayout.LayoutParams) this.editText.getLayoutParams()).setMargins(0, AndroidUtilities.dp(this.editTextTopMargin), 0, 0);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createStickerView() throws Resources.NotFoundException {
            long jLastModified;
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            StoryStickerPickerLayout storyStickerPickerLayout = (StoryStickerPickerLayout) ApplicationLoader.applicationActivity.getLayoutInflater().inflate(R.layout.story_sticker_picker_layout, (ViewGroup) null);
            this.stickerPickerLayout = storyStickerPickerLayout;
            addView(storyStickerPickerLayout, LayoutHelper.createFrame(-1, -1.0f));
            this.stickerPickerLayout.setScrollListener(new StoryStickerPickerLayout.ScrollListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.59
                @Override // ir.resaneh1.iptv.helper.StoryStickerPickerLayout.ScrollListener
                public void onScrollIdle(boolean z) {
                    if (z) {
                        if (FrameLayoutTouchable.this.isWidgetToolsViewVisible) {
                            return;
                        }
                        FrameLayoutTouchable.this.startMainToolViewAnimation(true, false);
                        return;
                    }
                    FrameLayoutTouchable.this.startMainToolViewAnimation(false, false);
                }
            });
            this.stickerPickerLayout.mDescView.setBackground(ApplicationLoader.applicationActivity.getResources().getDrawable(R.color.grey_800_alpha_70));
            this.stickerFragments = new ArrayList<>();
            RubinoStickerAndWidgetListFragment rubinoStickerAndWidgetListFragment = new RubinoStickerAndWidgetListFragment(this.selectItemListener);
            try {
                jLastModified = new File(AddStoryFragment.this.path).lastModified();
            } catch (Exception unused) {
                jLastModified = 0;
            }
            rubinoStickerAndWidgetListFragment.createTestEntity(Long.valueOf(jLastModified));
            this.stickerFragments.add(rubinoStickerAndWidgetListFragment);
            FrameLayout frameLayout = (FrameLayout) this.stickerPickerLayout.findViewById(R.id.containerFrameLayout);
            ViewPager viewPager = new ViewPager(ApplicationLoader.applicationContext);
            this.stickerPickerViewPager = viewPager;
            frameLayout.addView(viewPager, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 4.0f, 0.0f, 0.0f));
            this.stickerPickerViewPager.setAdapter(new StickerPagerAdapter(ApplicationLoader.applicationActivity, this.stickerFragments));
            CircleIndicator circleIndicator = new CircleIndicator(ApplicationLoader.applicationActivity);
            this.stickerPickerIndicator = circleIndicator;
            circleIndicator.setViewPager(this.stickerPickerViewPager);
            this.stickerPickerIndicator.setGravity(17);
            if (Build.VERSION.SDK_INT >= 17) {
                this.stickerPickerIndicator.setLayoutDirection(0);
            }
            frameLayout.addView(this.stickerPickerIndicator, LayoutHelper.createFrame(-1, 32.0f, 49, 0.0f, 0.0f, 0.0f, 0.0f));
            this.stickerPickerIndicator.setVisibility(4);
            this.stickerPickerViewPager.setCurrentItem(this.stickerFragments.size() - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showLinkCreateView(boolean z) {
            if (z == this.isCreateLinkVisible) {
                return;
            }
            this.isCreateLinkVisible = z;
            if (this.createLinkStoryFrameLayout == null) {
                FrameLayout frameLayout = (FrameLayout) this.stickerPickerLayout.findViewById(R.id.containerFrameLayout);
                CreateLinkFrameLayout createLinkFrameLayout = new CreateLinkFrameLayout(AddStoryFragment.this.mContext);
                this.createLinkStoryFrameLayout = createLinkFrameLayout;
                createLinkFrameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.61
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                this.createLinkStoryFrameLayout.setOnDoneListener(new CreateLinkFrameLayout.OnDoneListener() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.62
                    @Override // ir.resaneh1.iptv.helper.CreateLinkFrameLayout.OnDoneListener
                    public void onDoneClick(String str, String str2) {
                        StoryEntityItem storyEntityItem;
                        if (FrameLayoutTouchable.this.linkEntityView == null) {
                            FrameLayoutTouchable.this.linkEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
                            storyEntityItem = new StoryEntityItem();
                            storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.link;
                            storyEntityItem.storyLinkObject = new StoryLinkObject();
                            storyEntityItem.linkTextAttribute = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.rounded, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, 24, -1, StoryTextAttributeObject.TextColorTypeEnum.twoColorBlue);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 17;
                            FrameLayoutTouchable frameLayoutTouchable = FrameLayoutTouchable.this;
                            frameLayoutTouchable.addEntityView(frameLayoutTouchable.linkEntityView, layoutParams);
                        } else {
                            storyEntityItem = FrameLayoutTouchable.this.linkEntityView.entityItem;
                        }
                        storyEntityItem.storyLinkObject.link = str2;
                        String host = null;
                        try {
                            host = new URL(str2.toLowerCase(Locale.ROOT)).getHost();
                        } catch (MalformedURLException e) {
                            MyLog.handleException(e);
                        }
                        StoryLinkObject storyLinkObject = storyEntityItem.storyLinkObject;
                        if (TextUtils.isEmpty(str)) {
                            str = host != null ? host : BuildConfig.FLAVOR;
                        }
                        storyLinkObject.text = str;
                        FrameLayoutTouchable.this.linkEntityView.setOrEditEntityItem(storyEntityItem);
                        ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add((Disposable) Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.62.1
                            @Override // io.reactivex.Observer
                            public void onComplete() {
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                            }

                            @Override // io.reactivex.Observer
                            public void onNext(Long l) {
                                FrameLayoutTouchable.this.stickerPickerLayout.minimize();
                            }
                        }));
                    }

                    @Override // ir.resaneh1.iptv.helper.CreateLinkFrameLayout.OnDoneListener
                    public void onBackClick() {
                        FrameLayoutTouchable.this.showLinkCreateView(false);
                    }
                });
                frameLayout.addView(this.createLinkStoryFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
            }
            this.stickerPickerViewPager.setVisibility(!z ? 0 : 8);
            this.stickerPickerIndicator.setVisibility((z || this.stickerFragments.size() <= 1) ? 8 : 0);
            this.createLinkStoryFrameLayout.setVisibility(z ? 0 : 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlignmentAndBackgroundByType() {
            StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
            StoryTextAttributeObject.TextFontEnum textFontEnum = storyTextAttributeObject.textFont;
            StoryTextAttributeObject.TextFontEnum textFontEnum2 = StoryTextAttributeObject.TextFontEnum.neon;
            this.needToResizeText = textFontEnum == textFontEnum2 || textFontEnum == StoryTextAttributeObject.TextFontEnum.strong || textFontEnum == StoryTextAttributeObject.TextFontEnum.modern;
            if (textFontEnum == textFontEnum2 || textFontEnum == StoryTextAttributeObject.TextFontEnum.modern) {
                this.imageViewTextAlign.setVisibility(8);
                this.imageViewTextBackGround.setVisibility(8);
                changeTextSize(0.5f);
            } else {
                StoryTextAttributeObject.TextFontEnum textFontEnum3 = StoryTextAttributeObject.TextFontEnum.classic;
                if (textFontEnum == textFontEnum3 || textFontEnum == StoryTextAttributeObject.TextFontEnum.typewriter) {
                    if (textFontEnum == textFontEnum3) {
                        this.textSeekBar.view.setVisibility(0);
                        if (this.textSeekBar.seekbar.getProgress() > 0.0f) {
                            changeTextSize(this.textSeekBar.seekbar.getProgress());
                        } else {
                            changeTextSize(0.5f);
                            this.textSeekBar.setProgress(0.5f);
                        }
                    } else if (textFontEnum == StoryTextAttributeObject.TextFontEnum.typewriter) {
                        storyTextAttributeObject.textAlignmentType = StoryTextAttributeObject.TextAlignmentEnum.right;
                        changeTextSize(0.5f);
                    }
                    this.imageViewTextAlign.setVisibility(0);
                    this.imageViewTextAlign.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getAlignmentIconIdByType(this.currentTextAttribute)));
                    this.imageViewTextBackGround.setVisibility(0);
                    this.imageViewTextBackGround.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getBackgroundIconIdByType(this.currentTextAttribute)));
                    ((FrameLayout.LayoutParams) this.imageViewTextBackGround.getLayoutParams()).setMargins(AndroidUtilities.dp(48.0f), 0, 0, 0);
                } else if (textFontEnum == StoryTextAttributeObject.TextFontEnum.strong) {
                    this.imageViewTextBackGround.setVisibility(0);
                    this.imageViewTextBackGround.setImageDrawable(ApplicationLoader.applicationActivity.getResources().getDrawable(StoryTextAttributeObject.getBackgroundIconIdByType(this.currentTextAttribute)));
                    changeTextSize(0.5f);
                    ((FrameLayout.LayoutParams) this.imageViewTextBackGround.getLayoutParams()).setMargins(AndroidUtilities.dp(0.0f), 0, 0, 0);
                    this.imageViewTextAlign.setVisibility(8);
                }
            }
            this.editText.setGravity(StoryTextAttributeObject.getGravity(this.currentTextAttribute));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateEditText() {
            Editable text = this.editText.getText();
            this.textColorPickerRow.view.setVisibility(0);
            this.ui_rubinoProfileSuggestionRow2.updateProfileList(new ArrayList<>(), BuildConfig.FLAVOR, 0);
            this.ui_rubinoHashtagSuggestionRow2.updateHashtagList(new ArrayList<>(), BuildConfig.FLAVOR, 0);
            this.ui_rubinoProfileSuggestionRow2.view.setVisibility(8);
            this.ui_rubinoHashtagSuggestionRow2.view.setVisibility(8);
            if (text.length() > 0) {
                for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) text.getSpans(0, text.length(), RelativeSizeSpan.class)) {
                    text.removeSpan(relativeSizeSpan);
                }
                for (URLSpan uRLSpan : (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class)) {
                    text.removeSpan(uRLSpan);
                }
            }
            try {
                if (AddStoryFragment.urlPattern == null) {
                    Pattern unused = AddStoryFragment.urlPattern = Pattern.compile("(^|\\s)/[a-zA-Z@\\d_]{1,255}|(^|\\s|[^a-zA-Z@\\d_])@[a-zA-Z\\d_]{1,32}|(^|\\s)#[\\w.]+|(^|\\s)\\$[A-Z]{3,8}([ ,.]|$)");
                }
                Matcher matcher = AddStoryFragment.urlPattern.matcher(text);
                while (matcher.find()) {
                    final int iStart = matcher.start();
                    int iEnd = matcher.end();
                    char cCharAt = text.charAt(iStart);
                    if (cCharAt != '@' && cCharAt != '#' && cCharAt != '/' && cCharAt != '$') {
                        iStart++;
                    }
                    URLSpan uRLSpan2 = null;
                    if (text.charAt(iStart) != '/') {
                        uRLSpan2 = new URLSpan(text.subSequence(iStart, iEnd).toString());
                    }
                    if (uRLSpan2 != null) {
                        text.setSpan(uRLSpan2, iStart, iEnd, 0);
                        int selectionStart = this.editText.getSelectionStart();
                        if (selectionStart >= iStart && selectionStart <= iEnd) {
                            final String url = uRLSpan2.getURL();
                            if (url.startsWith("#")) {
                                this.textColorPickerRow.view.setVisibility(8);
                                this.ui_rubinoProfileSuggestionRow2.view.setVisibility(8);
                                this.ui_rubinoHashtagSuggestionRow2.view.setVisibility(0);
                                DisposableObserver disposableObserver = this.searchDisposable;
                                if (disposableObserver != null) {
                                    disposableObserver.dispose();
                                }
                                DisposableObserver disposableObserver2 = (DisposableObserver) Observable.timer(250L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.63
                                    @Override // io.reactivex.Observer
                                    public void onComplete() {
                                    }

                                    @Override // io.reactivex.Observer
                                    public void onError(Throwable th) {
                                    }

                                    @Override // io.reactivex.Observer
                                    public void onNext(Long l) {
                                        FrameLayoutTouchable.this.callSearchHashTag(url.trim().replace("#", BuildConfig.FLAVOR), iStart);
                                    }
                                });
                                this.searchDisposable = disposableObserver2;
                                ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add(disposableObserver2);
                            } else if (url.startsWith("@")) {
                                this.textColorPickerRow.view.setVisibility(8);
                                this.ui_rubinoHashtagSuggestionRow2.view.setVisibility(8);
                                this.ui_rubinoProfileSuggestionRow2.view.setVisibility(0);
                                DisposableObserver disposableObserver3 = this.searchDisposable;
                                if (disposableObserver3 != null) {
                                    disposableObserver3.dispose();
                                }
                                DisposableObserver disposableObserver4 = (DisposableObserver) Observable.timer(250L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.64
                                    @Override // io.reactivex.Observer
                                    public void onComplete() {
                                    }

                                    @Override // io.reactivex.Observer
                                    public void onError(Throwable th) {
                                    }

                                    @Override // io.reactivex.Observer
                                    public void onNext(Long l) {
                                        FrameLayoutTouchable.this.callSearchRubinoProfile(url.trim().replace("@", BuildConfig.FLAVOR), iStart);
                                    }
                                });
                                this.searchDisposable = disposableObserver4;
                                ((PresenterFragment) AddStoryFragment.this).compositeDisposable.add(disposableObserver4);
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            this.editText.getLayout();
            Layout layout = this.editText.getLayout();
            if (layout == null) {
                return;
            }
            try {
                int lineCount = layout.getLineCount();
                for (int i = 0; i < lineCount; i++) {
                    int lineStart = layout.getLineStart(i);
                    int lineEnd = layout.getLineEnd(i);
                    if (lineStart != lineEnd) {
                        float lineWidth = layout.getLineWidth(i);
                        if (lineWidth > 0.0f) {
                            float width = (layout.getWidth() * 1.0f) / lineWidth;
                            if (width > 3.0f) {
                                width = 3.0f;
                            }
                            if (width < 1.0f || this.needToResizeText) {
                                text.setSpan(new RelativeSizeSpan(width), lineStart, lineEnd, 33);
                            }
                        }
                    }
                }
                if (layout.getHeight() > this.newEditTextHeight) {
                    float height = layout.getHeight();
                    float f = this.newEditTextHeight / height;
                    this.editText.setPivotY(0.0f);
                    this.textToolsFrameLayout.getLayoutParams().height = (int) (height * 2.0f);
                    this.editText.setScaleX(f);
                    this.editText.setScaleY(f);
                    this.editText.requestLayout();
                }
                updateTextColorAndBackground();
                updateEditTextMargin();
                this.editText.requestLayout();
            } catch (Exception unused3) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateHashTagEditTextSize() {
            Editable text = this.hashtagEditText.getText();
            if (text.length() > 0) {
                for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) text.getSpans(0, text.length(), RelativeSizeSpan.class)) {
                    text.removeSpan(relativeSizeSpan);
                }
            }
            Layout layout = this.hashtagEditText.getLayout();
            if (layout == null) {
                return;
            }
            float maxWidth = this.hashtagEditText.getMaxWidth() - (AndroidUtilities.dp(this.edittextPadding) * 2);
            try {
                int lineCount = layout.getLineCount();
                for (int i = 0; i < lineCount; i++) {
                    if (layout.getLineStart(i) != layout.getLineEnd(i)) {
                        float lineWidth = layout.getLineWidth(i) + (AndroidUtilities.dp(this.edittextPadding) * 2);
                        if (lineWidth > 0.0f) {
                            float f = maxWidth / lineWidth;
                            if (f < 1.0f) {
                                StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
                                storyTextAttributeObject.textSizeInDp -= 2;
                            } else {
                                StoryTextAttributeObject storyTextAttributeObject2 = this.currentTextAttribute;
                                int i2 = storyTextAttributeObject2.textSizeInDp;
                                if (i2 < this.defaultHashtagTextSizeInDp && f > 1.3d) {
                                    storyTextAttributeObject2.textSizeInDp = i2 + 2;
                                }
                            }
                            this.hashtagEditText.setTextSize(0, AndroidUtilities.dp(this.currentTextAttribute.textSizeInDp));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateTextColorAndBackground() {
            this.editText.setTextColor(this.currentTextAttribute.getTextColor());
            this.editText.setLinkTextColor(this.currentTextAttribute.getTextColor());
            this.editText.setShadowLayer(this.currentTextAttribute.getShadowRadius(), this.currentTextAttribute.getShadowDx(), this.currentTextAttribute.getShadowDy(), this.currentTextAttribute.getShadowColor());
            StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
            if (storyTextAttributeObject.backGroundType != StoryTextAttributeObject.BackGroundType.none) {
                storyTextAttributeObject.layout = this.editText.getLayout();
                Drawable background = this.currentTextAttribute.getBackground(this.editText.getLayout());
                if (background != null) {
                    this.editText.setBackground(background);
                }
            } else {
                this.editText.setBackgroundColor(0);
            }
            this.editText.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void changeTextSize(float f) {
            StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
            if (storyTextAttributeObject != null) {
                int i = (int) ((f * 30.0f) + 10.0f);
                storyTextAttributeObject.textSizeInDp = i;
                EditText editText = this.editText;
                if (editText != null) {
                    editText.setTextSize(1, i);
                    this.needToRefreshEditText = true;
                }
            }
        }

        private void changeTextColor(int i) {
            StoryTextAttributeObject storyTextAttributeObject = this.currentTextAttribute;
            if (storyTextAttributeObject != null) {
                storyTextAttributeObject.color = i;
                if (this.editText != null) {
                    updateTextColorAndBackground();
                    this.editText.invalidate();
                }
            }
        }

        public void addEntityView(StoryEntityView storyEntityView, FrameLayout.LayoutParams layoutParams) {
            this.frameLayoutEntityContainer.addView(storyEntityView, layoutParams);
            int i = layoutParams.height;
            int i2 = this.height;
            if (i > i2) {
                storyEntityView.setScale(i2 / i);
            }
            this.entityViewArray.add(storyEntityView);
        }

        private void addPostView(RubinoPostObject rubinoPostObject, int i) {
            if (rubinoPostObject == null) {
                return;
            }
            StoryEntityView storyEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
            StoryEntityItem storyEntityItem = new StoryEntityItem();
            storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.post;
            storyEntityItem.postObject = rubinoPostObject;
            storyEntityItem.isSupportVideo = AddStoryFragment.this.isVideoPostWidget();
            storyEntityView.setOrEditEntityItem(storyEntityItem);
            int height = storyEntityView.getHeight();
            if (height > i) {
                storyEntityView.setScale((i * 1.0f) / (height * 1.0f));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            storyEntityView.isLock = false;
            this.frameLayoutEntityContainer.setClipToPadding(false);
            this.frameLayoutEntityContainer.setClipChildren(false);
            this.frameLayoutEntityContainer.addView(storyEntityView, layoutParams);
            if (AddStoryFragment.this.isVideoPostWidget()) {
                AddStoryFragment.this.postView = storyEntityView;
            }
            this.entityViewArray.add(storyEntityView);
        }

        private void addLockPollShareView(float f, StoryPollObject storyPollObject, StoryPositionObject storyPositionObject) {
            if (storyPollObject == null || storyPositionObject == null) {
                return;
            }
            StoryEntityView storyEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
            StoryEntityItem storyEntityItem = new StoryEntityItem();
            storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.pollShare;
            storyEntityItem.pollObject = storyPollObject;
            storyEntityView.setOrEditEntityItem(storyEntityItem);
            storyEntityView.isLock = true;
            RectF rectPx = storyPositionObject.getRectPx(AddStoryFragment.this.mContext, f);
            float widthPx = (int) storyPositionObject.getWidthPx(AddStoryFragment.this.mContext, f);
            float heightPx = (int) storyPositionObject.getHeightPx(AddStoryFragment.this.mContext, f);
            PollSticker.PollStickerMode pollStickerMode = PollSticker.PollStickerMode.ADD_STORY;
            float pollWidth = PollSticker.getPollWidth(pollStickerMode);
            float pollHeight = PollSticker.getPollHeight(pollStickerMode);
            int iDp = AndroidUtilities.dp(1.0f);
            int i = iDp * 2;
            float f2 = i;
            storyEntityView.setScaleX((widthPx + f2) / pollWidth);
            storyEntityView.setScaleY((f2 + heightPx) / pollHeight);
            storyEntityView.setRotationAngle((float) storyPositionObject.rotation);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(((int) widthPx) + i, ((int) heightPx) + i, 51);
            layoutParams.topMargin = ((int) rectPx.top) - iDp;
            layoutParams.leftMargin = ((int) rectPx.left) - iDp;
            this.frameLayoutEntityContainer.addView(storyEntityView, layoutParams);
            this.entityViewArray.add(storyEntityView);
        }

        private void addShareQuestionView(float f, StoryShareQuestionObject storyShareQuestionObject, StoryPositionObject storyPositionObject) {
            if (storyShareQuestionObject == null || storyPositionObject == null) {
                return;
            }
            StoryEntityView storyEntityView = new StoryEntityView(AddStoryFragment.this.mContext);
            StoryEntityItem storyEntityItem = new StoryEntityItem();
            storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.questionShare;
            storyEntityItem.shareQuestionObject = storyShareQuestionObject;
            storyEntityView.setOrEditEntityItem(storyEntityItem);
            RectF rectPx = storyPositionObject.getRectPx(AddStoryFragment.this.mContext, f);
            float widthPx = (int) storyPositionObject.getWidthPx(AddStoryFragment.this.mContext, f);
            float heightPx = (int) storyPositionObject.getHeightPx(AddStoryFragment.this.mContext, f);
            storyEntityView.setScale(widthPx / QuestionSticker.getViewWidth());
            storyEntityView.setRotationAngle((float) storyPositionObject.rotation);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) widthPx, (int) heightPx, 51);
            layoutParams.topMargin = (int) rectPx.top;
            layoutParams.leftMargin = (int) rectPx.left;
            this.frameLayoutEntityContainer.addView(storyEntityView, layoutParams);
            this.entityViewArray.add(storyEntityView);
        }

        public void updateSelectedIfFoundAndCheckClick(MotionEvent motionEvent) {
            StoryEntityView storyEntityView;
            int action = motionEvent.getAction() & 255;
            int size = this.entityViewArray.size();
            if (size == 0) {
                return;
            }
            if (action != 0) {
                if (action != 1 && action != 3) {
                    if (action != 5) {
                        if (action != 6) {
                            return;
                        }
                    }
                }
                if (motionEvent.getPointerCount() == 1 && motionEvent.getActionIndex() == 0) {
                    if (!this.dropperVisible) {
                        startMainToolViewAnimation(true, true);
                    }
                    if (isAClick(this.clickStartX, motionEvent.getX(), this.clickStartY, motionEvent.getY()) && (storyEntityView = this.selected) != null) {
                        StoryEntityView.TypeEnum typeEnum = storyEntityView.type;
                        if (typeEnum == StoryEntityView.TypeEnum.text) {
                            openTextEdit(storyEntityView);
                        } else if (typeEnum == StoryEntityView.TypeEnum.poll) {
                            openPollEditView();
                        } else if (typeEnum == StoryEntityView.TypeEnum.emojiSlider) {
                            openEmojiSliderEditView();
                        } else if (typeEnum == StoryEntityView.TypeEnum.question) {
                            openQuestionEditView();
                        } else if (typeEnum == StoryEntityView.TypeEnum.quiz) {
                            openQuizEditView();
                        } else if (typeEnum == StoryEntityView.TypeEnum.hashtag || typeEnum == StoryEntityView.TypeEnum.mention || typeEnum == StoryEntityView.TypeEnum.clock || typeEnum == StoryEntityView.TypeEnum.date || typeEnum == StoryEntityView.TypeEnum.post || typeEnum == StoryEntityView.TypeEnum.link) {
                            if (storyEntityView.downAnimationEndAndSmallest) {
                                performClick(storyEntityView);
                            } else {
                                storyEntityView.isClicked = true;
                            }
                        }
                    }
                    StoryEntityView storyEntityView2 = this.selected;
                    if (storyEntityView2 != null && isEntityInTrashArea(storyEntityView2, motionEvent.getX(), motionEvent.getY())) {
                        StoryEntityView storyEntityView3 = this.selected;
                        StoryEntityView.TypeEnum typeEnum2 = storyEntityView3.type;
                        if (typeEnum2 == StoryEntityView.TypeEnum.poll) {
                            this.pollStickerEntityView = null;
                        } else if (typeEnum2 == StoryEntityView.TypeEnum.emojiSlider) {
                            this.emojiSliderStickerEntityView = null;
                        } else if (typeEnum2 == StoryEntityView.TypeEnum.question) {
                            this.questionStickerEntityView = null;
                        } else if (typeEnum2 == StoryEntityView.TypeEnum.quiz) {
                            this.quizStickerEntityView = null;
                        } else if (typeEnum2 == StoryEntityView.TypeEnum.link) {
                            this.linkEntityView = null;
                        }
                        this.entityViewArray.remove(storyEntityView3);
                        this.frameLayoutEntityContainer.removeView(this.selected);
                        this.isSmallingInTrashAnimationOccuredAndFinished = false;
                        this.isTrashAnimationInProgress = false;
                        this.needToAnimateTrashBack = false;
                        AnimatorSet animatorSet = this.inTrashAnimation;
                        if (animatorSet != null) {
                            animatorSet.cancel();
                            this.inTrashAnimation = null;
                        }
                        this.imageViewTrash.setScaleX(1.0f);
                        this.imageViewTrash.setScaleY(1.0f);
                    }
                    if (this.isTrashVisible) {
                        this.isTrashVisible = false;
                        startTrashVisibilityAnimation(false);
                    }
                    StoryEntityView storyEntityView4 = this.selected;
                    if (storyEntityView4 != null && storyEntityView4.needToAnimateBack) {
                        startClickAnimation(false, storyEntityView4);
                    }
                    this.selected = null;
                    return;
                }
                return;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.selected == null) {
                int i = size - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    StoryEntityView storyEntityView5 = this.entityViewArray.get(i);
                    if (!storyEntityView5.isLock && isPointInEntityArea(x, y, storyEntityView5)) {
                        this.selected = storyEntityView5;
                        onUpdateSelected();
                        MyLog.e("AddStoryFragment", " a touch " + i);
                        break;
                    }
                    i--;
                }
            }
            if (this.selected == null && motionEvent.getPointerCount() == 2) {
                int i2 = size - 1;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    StoryEntityView storyEntityView6 = this.entityViewArray.get(i2);
                    if (!storyEntityView6.isLock && isLineIntersectsEntity(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1), storyEntityView6)) {
                        this.selected = storyEntityView6;
                        onUpdateSelected();
                        MyLog.e("AddStoryFragment", " 2 touch " + i2);
                        break;
                    }
                    i2--;
                }
            }
            if (this.selected != null && motionEvent.getPointerCount() == 1 && motionEvent.getActionIndex() == 0) {
                this.clickStartX = motionEvent.getX();
                this.clickStartY = motionEvent.getY();
                startClickAnimation(true, this.selected);
            }
            if (this.selected != null) {
                startMainToolViewAnimation(false, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void performClick(StoryEntityView storyEntityView) {
            DateSticker.DateTheme dateTheme;
            ClockSticker.ClockMode clockMode;
            storyEntityView.isClicked = false;
            StoryEntityView.TypeEnum typeEnum = storyEntityView.type;
            if (typeEnum == StoryEntityView.TypeEnum.hashtag) {
                StoryTextAttributeObject storyTextAttributeObject = storyEntityView.textAttributeObject;
                storyTextAttributeObject.textColorType = StoryTextAttributeObject.getNextHashtagTextColorType(storyTextAttributeObject);
                StoryTextAttributeObject storyTextAttributeObject2 = storyEntityView.textAttributeObject;
                storyTextAttributeObject2.backGroundType = StoryTextAttributeObject.getHashtagOrMentionBackGroundByColorType(storyTextAttributeObject2);
                storyEntityView.addOrEditHashtagOrMention(storyEntityView.textAttributeObject, true);
                return;
            }
            if (typeEnum == StoryEntityView.TypeEnum.mention) {
                StoryTextAttributeObject storyTextAttributeObject3 = storyEntityView.textAttributeObject;
                storyTextAttributeObject3.textColorType = StoryTextAttributeObject.getNextMentionTextColorType(storyTextAttributeObject3);
                StoryTextAttributeObject storyTextAttributeObject4 = storyEntityView.textAttributeObject;
                storyTextAttributeObject4.backGroundType = StoryTextAttributeObject.getHashtagOrMentionBackGroundByColorType(storyTextAttributeObject4);
                storyEntityView.addOrEditHashtagOrMention(storyEntityView.textAttributeObject, false);
                return;
            }
            if (typeEnum == StoryEntityView.TypeEnum.clock) {
                int i = AnonymousClass10.$SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[storyEntityView.clockSticker.getMode().ordinal()];
                if (i == 1) {
                    clockMode = ClockSticker.ClockMode.TEXTUAL_SIMPLE;
                } else if (i == 2) {
                    clockMode = ClockSticker.ClockMode.TEXTUAL_GRAY;
                } else {
                    clockMode = ClockSticker.ClockMode.CIRCULAR;
                }
                storyEntityView.clockSticker.setMode(clockMode);
                return;
            }
            if (typeEnum == StoryEntityView.TypeEnum.date) {
                int i2 = AnonymousClass10.$SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[storyEntityView.dateSticker.getDateTheme().ordinal()];
                if (i2 == 1) {
                    dateTheme = DateSticker.DateTheme.BLACK;
                } else if (i2 == 2) {
                    dateTheme = DateSticker.DateTheme.RED;
                } else {
                    dateTheme = DateSticker.DateTheme.WHITE;
                }
                storyEntityView.dateSticker.setDateTheme(dateTheme);
                return;
            }
            if (typeEnum == StoryEntityView.TypeEnum.post) {
                storyEntityView.postCell.setNextMode();
                return;
            }
            if (typeEnum == StoryEntityView.TypeEnum.link) {
                StoryTextAttributeObject storyTextAttributeObject5 = storyEntityView.textAttributeObject;
                storyTextAttributeObject5.textColorType = StoryTextAttributeObject.getNextLinkTextColorType(storyTextAttributeObject5);
                StoryTextAttributeObject storyTextAttributeObject6 = storyEntityView.textAttributeObject;
                storyTextAttributeObject6.backGroundType = StoryTextAttributeObject.getLinkBackGroundByColorType(storyTextAttributeObject6);
                storyEntityView.addOrEditLink(storyEntityView.textAttributeObject);
            }
        }

        private void onUpdateSelected() {
            this.isSmallingInTrashAnimationOccuredAndFinished = false;
            this.isTrashAnimationInProgress = false;
            this.inTrashAnimation = null;
            this.frameLayoutEntityContainer.removeView(this.selected);
            this.frameLayoutEntityContainer.addView(this.selected);
            this.entityViewArray.remove(this.selected);
            this.entityViewArray.add(this.selected);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isEntityInTrashArea(StoryEntityView storyEntityView, float f, float f2) {
            if (!storyEntityView.isDeletable || !this.isTrashVisible) {
                return false;
            }
            float scaleX = storyEntityView.getScaleX();
            float f3 = storyEntityView.scaleBeforeAnimation;
            if (f3 > 0.0f) {
                scaleX = f3;
            }
            float width = storyEntityView.getWidth() * scaleX;
            float height = storyEntityView.getHeight() * scaleX;
            float x = (storyEntityView.getX() + (storyEntityView.getWidth() / 2.0f)) - (width / 2.0f);
            float y = (storyEntityView.getY() + (storyEntityView.getHeight() / 2.0f)) - (height / 2.0f);
            RectF rectF = new RectF(x, y, width + x, height + y);
            RectF rectF2 = new RectF(this.imageViewTrash.getX(), this.imageViewTrash.getY(), this.imageViewTrash.getX() + this.imageViewTrash.getWidth(), this.imageViewTrash.getY() + this.imageViewTrash.getHeight());
            return rectF2.intersect(rectF) && rectF2.contains(f, f2);
        }

        private boolean isLineIntersectsEntity(float f, float f2, float f3, float f4, StoryEntityView storyEntityView) {
            RectF entityClickableRect = storyEntityView.getEntityClickableRect();
            StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(f, f2);
            applyRotationIfNeeded(myPoint, storyEntityView);
            StoryUtils.MyPoint myPoint2 = new StoryUtils.MyPoint(f3, f4);
            applyRotationIfNeeded(myPoint2, storyEntityView);
            if (!StoryUtils.isLineAndRectIntersects(entityClickableRect, myPoint, myPoint2)) {
                return false;
            }
            MyLog.e("AddStoryFragment", " INTERSECT ");
            return true;
        }

        private StoryUtils.MyPoint applyRotationIfNeeded(StoryUtils.MyPoint myPoint, StoryEntityView storyEntityView) {
            float reverseRotationAngle = storyEntityView.getReverseRotationAngle();
            if (reverseRotationAngle == 0.0f) {
                return myPoint;
            }
            double d = reverseRotationAngle;
            Double.isNaN(d);
            float widthAfterScale = storyEntityView.getWidthAfterScale();
            float heightAfterScale = storyEntityView.getHeightAfterScale();
            float xAfterScale = storyEntityView.getXAfterScale() + (widthAfterScale / 2.0f);
            float yAfterScale = storyEntityView.getYAfterScale() + (heightAfterScale / 2.0f);
            double d2 = myPoint.x - xAfterScale;
            double d3 = myPoint.y - yAfterScale;
            double d4 = (float) ((d * 3.141592653589793d) / 180.0d);
            double dCos = Math.cos(d4);
            Double.isNaN(d2);
            double dSin = Math.sin(d4);
            Double.isNaN(d3);
            double d5 = (dCos * d2) - (dSin * d3);
            double dSin2 = Math.sin(d4);
            Double.isNaN(d2);
            double dCos2 = Math.cos(d4);
            Double.isNaN(d3);
            double d6 = xAfterScale;
            Double.isNaN(d6);
            myPoint.x = (float) (d5 + d6);
            double d7 = yAfterScale;
            Double.isNaN(d7);
            myPoint.y = (float) ((d2 * dSin2) + (d3 * dCos2) + d7);
            return myPoint;
        }

        private boolean isPointInEntityArea(float f, float f2, StoryEntityView storyEntityView) {
            RectF entityClickableRect = storyEntityView.getEntityClickableRect();
            StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(f, f2);
            applyRotationIfNeeded(myPoint, storyEntityView);
            return entityClickableRect.contains(myPoint.x, myPoint.y);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkToMoveEntityViews(MotionEvent motionEvent) {
            StoryUtils.MyPoint myPoint;
            StoryUtils.MyPoint myPoint2;
            int actionIndex = motionEvent.getActionIndex();
            int pointerCount = motionEvent.getPointerCount();
            if ((actionIndex == 0 || actionIndex == 1) && (myPoint = this.startPositionMap.get(Integer.valueOf(motionEvent.getPointerId(0)))) != null) {
                float x = motionEvent.getX(0) - myPoint.x;
                float y = motionEvent.getY(0) - myPoint.y;
                if (pointerCount == 1) {
                    if (this.dropperVisible) {
                        this.dropperCell.view.setOffset((int) x, (int) y);
                        invalidate();
                        float x2 = this.dropperCell.view.getX();
                        UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = this.dropperCell;
                        getColorOfPoint((int) (x2 + uI_rubinoDropperSelectorCell.circleCenterX), (int) (uI_rubinoDropperSelectorCell.view.getY() + this.dropperCell.circleCenterY));
                    } else {
                        StoryEntityView storyEntityView = this.selected;
                        if (storyEntityView != null) {
                            int i = (int) x;
                            int i2 = (int) y;
                            storyEntityView.setOffset(i, i2);
                            invalidate();
                            if (this.selected == AddStoryFragment.this.postView) {
                                this.storyContainer.setOffset(i, i2);
                                if (Utils.useNewStoryCreationSystem()) {
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(AddStoryFragment.this.postView.getVideoXAfterScale(), AddStoryFragment.this.postView.getVideoYAfterScale());
                                    AddStoryFragment.this.eglThread.requestRender();
                                } else {
                                    AddStoryFragment.this.glRenderer.setMediaPosition(AddStoryFragment.this.postView.getVideoXAfterScale(), AddStoryFragment.this.postView.getVideoYAfterScale());
                                }
                            }
                        }
                    }
                }
                if (pointerCount != 2 || this.dropperVisible || (myPoint2 = this.startPositionMap.get(Integer.valueOf(motionEvent.getPointerId(1)))) == null) {
                    return;
                }
                float x3 = motionEvent.getX(1) - myPoint2.x;
                float y2 = motionEvent.getY(1) - myPoint2.y;
                StoryEntityView storyEntityView2 = this.selected;
                if (storyEntityView2 != null && storyEntityView2 != AddStoryFragment.this.postView) {
                    this.selected.setOffset((int) ((x + x3) / 2.0f), (int) ((y + y2) / 2.0f));
                } else {
                    StoryEntityView storyEntityView3 = this.storyContainer;
                    int i3 = (int) ((x + x3) / 2.0f);
                    int i4 = (int) ((y + y2) / 2.0f);
                    storyEntityView3.setOffset(i3, i4);
                    if (AddStoryFragment.this.postView != null) {
                        AddStoryFragment.this.postView.setOffset(i3, i4);
                    }
                    try {
                        if (AddStoryFragment.this.isRendererAvailable()) {
                            if (Utils.useNewStoryCreationSystem()) {
                                if (AddStoryFragment.this.postView != null) {
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(AddStoryFragment.this.postView.getVideoXAfterScale(), AddStoryFragment.this.postView.getVideoYAfterScale());
                                } else {
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(storyEntityView3.getXAfterScale(), storyEntityView3.getYAfterScale());
                                }
                                AddStoryFragment.this.eglThread.requestRender();
                            } else {
                                AddStoryFragment.this.glRenderer.setMediaPosition(storyEntityView3.getXAfterScale(), storyEntityView3.getYAfterScale());
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                invalidate();
            }
        }

        public float distance(MotionEvent motionEvent, int i, int i2) {
            if (motionEvent.getPointerCount() < 2) {
                return 0.0f;
            }
            float x = motionEvent.getX(i) - motionEvent.getX(i2);
            float y = motionEvent.getY(i) - motionEvent.getY(i2);
            return (float) Math.sqrt((x * x) + (y * y));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean checkIsPinchGesture(MotionEvent motionEvent) {
            if (motionEvent.getPointerCount() == 2) {
                float fDistance = distance(motionEvent, 0, 1);
                if (this.startTouchDistance != 0.0f) {
                    StoryEntityView storyEntityView = this.selected;
                    if (storyEntityView != null && storyEntityView != AddStoryFragment.this.postView) {
                        this.selected.setScale(fDistance / this.startTouchDistance);
                    } else {
                        StoryEntityView storyEntityView2 = this.storyContainer;
                        storyEntityView2.setScale(fDistance / this.startTouchDistance);
                        if (AddStoryFragment.this.postView != null) {
                            AddStoryFragment.this.postView.setScale(fDistance / this.startTouchDistance);
                        }
                        try {
                            if (AddStoryFragment.this.isRendererAvailable()) {
                                if (Utils.useNewStoryCreationSystem()) {
                                    if (AddStoryFragment.this.postView != null) {
                                        AddStoryFragment.this.eglThread.getFilterShader().setScale(AddStoryFragment.this.postView.getVideoWidthAfterScale(), AddStoryFragment.this.postView.getVideoHeightAfterScale());
                                    } else {
                                        AddStoryFragment.this.eglThread.getFilterShader().setScale(storyEntityView2.getWidthAfterScale(), storyEntityView2.getHeightAfterScale());
                                    }
                                    AddStoryFragment.this.eglThread.requestRender();
                                } else {
                                    AddStoryFragment.this.glRenderer.setScale(storyEntityView2.getWidthAfterScale(), storyEntityView2.getHeightAfterScale());
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    invalidate();
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean checkIsRotate(MotionEvent motionEvent) {
            if (motionEvent.getPointerCount() == 2) {
                double degrees = Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
                double d = this.angleStart;
                Double.isNaN(d);
                if (Math.abs(degrees - d) > 0.0d) {
                    StoryEntityView storyEntityView = this.selected;
                    if (storyEntityView != null && storyEntityView != AddStoryFragment.this.postView) {
                        StoryEntityView storyEntityView2 = this.selected;
                        double d2 = this.angleStart;
                        Double.isNaN(d2);
                        storyEntityView2.setRotationAngle((float) (degrees - d2));
                    } else {
                        StoryEntityView storyEntityView3 = this.storyContainer;
                        double d3 = this.angleStart;
                        Double.isNaN(d3);
                        float f = (float) (degrees - d3);
                        storyEntityView3.setRotationAngle(f);
                        if (AddStoryFragment.this.postView != null) {
                            AddStoryFragment.this.postView.setRotationAngle(f);
                        }
                        try {
                            if (AddStoryFragment.this.isRendererAvailable()) {
                                if (Utils.useNewStoryCreationSystem()) {
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaRotation(storyEntityView3.getRotation());
                                    AddStoryFragment.this.eglThread.requestRender();
                                } else {
                                    AddStoryFragment.this.glRenderer.setMediaRotation(storyEntityView3.getRotation());
                                }
                            }
                            MyLog.e("AddStoryFragment", "glRenderer rotation " + storyEntityView3.getRotation());
                        } catch (Exception unused) {
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("storyContainer rotation ");
                    sb.append(this.storyContainer.getRotation());
                    sb.append(" to degree ");
                    double d4 = this.angleStart;
                    Double.isNaN(d4);
                    sb.append(Math.toDegrees(degrees - d4));
                    MyLog.e("AddStoryFragment", sb.toString());
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleUpAndDownEvents(MotionEvent motionEvent, boolean z) {
            int pointerCount = motionEvent.getPointerCount();
            int actionIndex = motionEvent.getActionIndex();
            if (actionIndex == 0 || actionIndex == 1) {
                if (this.dropperVisible) {
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout = this.dropperCell.view;
                    dropperSelectorFrameLayout.saveCurrentPosition((int) dropperSelectorFrameLayout.getX(), (int) dropperSelectorFrameLayout.getY());
                    dropperSelectorFrameLayout.saveCurrentScaleAndRotation();
                } else {
                    StoryEntityView storyEntityView = this.selected;
                    if (storyEntityView != null && storyEntityView != AddStoryFragment.this.postView) {
                        StoryEntityView storyEntityView2 = this.selected;
                        storyEntityView2.saveCurrentPosition((int) storyEntityView2.getX(), (int) storyEntityView2.getY());
                        storyEntityView2.saveCurrentScaleAndRotation();
                    } else {
                        StoryEntityView storyEntityView3 = this.storyContainer;
                        storyEntityView3.saveCurrentPosition((int) storyEntityView3.getX(), (int) storyEntityView3.getY());
                        storyEntityView3.saveCurrentScaleAndRotation();
                        if (AddStoryFragment.this.postView != null) {
                            AddStoryFragment.this.postView.saveCurrentPosition((int) storyEntityView3.getX(), (int) storyEntityView3.getY());
                            AddStoryFragment.this.postView.saveCurrentScaleAndRotation();
                        }
                        try {
                            if (AddStoryFragment.this.isRendererAvailable()) {
                                if (Utils.useNewStoryCreationSystem()) {
                                    if (AddStoryFragment.this.postView != null) {
                                        AddStoryFragment.this.eglThread.getFilterShader().setScale(AddStoryFragment.this.postView.getVideoWidthAfterScale(), AddStoryFragment.this.postView.getVideoHeightAfterScale());
                                        AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(AddStoryFragment.this.postView.getVideoXAfterScale(), AddStoryFragment.this.postView.getVideoYAfterScale());
                                    } else {
                                        AddStoryFragment.this.eglThread.getFilterShader().setScale(this.storyContainer.getWidthAfterScale(), this.storyContainer.getHeightAfterScale());
                                        AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(this.storyContainer.getXAfterScale(), this.storyContainer.getYAfterScale());
                                    }
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaRotation(storyEntityView3.getRotation());
                                    AddStoryFragment.this.eglThread.requestRender();
                                } else {
                                    AddStoryFragment.this.glRenderer.setScale(this.storyContainer.getWidthAfterScale(), this.storyContainer.getHeightAfterScale());
                                    AddStoryFragment.this.glRenderer.setMediaPosition(this.storyContainer.getXAfterScale(), this.storyContainer.getYAfterScale());
                                    AddStoryFragment.this.glRenderer.setMediaRotation(storyEntityView3.getRotation());
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                for (int i = 0; i < pointerCount; i++) {
                    this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(i)), new StoryUtils.MyPoint(motionEvent.getPointerId(i), motionEvent.getX(i), motionEvent.getY(i)));
                }
            }
            if (pointerCount == 2 && !this.dropperVisible) {
                this.startTouchDistance = distance(motionEvent, 0, 1);
                this.angleStart = (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
            } else {
                this.startTouchDistance = 0.0f;
                this.angleStart = 0.0f;
            }
            if (z) {
                this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(actionIndex)), new StoryUtils.MyPoint(motionEvent.getPointerId(actionIndex), motionEvent.getX(actionIndex), motionEvent.getY(actionIndex)));
                if (this.dropperVisible && actionIndex == 0) {
                    int x = (int) (motionEvent.getX(0) - this.dropperCell.circleCenterX);
                    float y = motionEvent.getY(0);
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = this.dropperCell;
                    uI_rubinoDropperSelectorCell.view.saveCurrentPosition(x, (int) (y - uI_rubinoDropperSelectorCell.circleCenterY));
                    this.dropperCell.view.setOffset(0, 0);
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell2 = this.dropperCell;
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout2 = uI_rubinoDropperSelectorCell2.view;
                    getColorOfPoint((int) (dropperSelectorFrameLayout2.positionX + uI_rubinoDropperSelectorCell2.circleCenterX), (int) (dropperSelectorFrameLayout2.positionY + uI_rubinoDropperSelectorCell2.circleCenterY));
                    invalidate();
                }
            } else {
                if (this.dropperVisible && actionIndex == 0) {
                    UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell3 = this.dropperCell;
                    if (uI_rubinoDropperSelectorCell3 != null) {
                        changeColor(uI_rubinoDropperSelectorCell3.getColor());
                    }
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout3 = this.dropperCell.view;
                    dropperSelectorFrameLayout3.positionX = (this.width / 2) - (dropperSelectorFrameLayout3.getWidth() / 2);
                    UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout4 = this.dropperCell.view;
                    dropperSelectorFrameLayout4.positionY = (this.height / 2) - (dropperSelectorFrameLayout4.getHeight() / 2);
                    this.dropperCell.view.setOffset(0, 0);
                    removeView(this.dropperCell.view);
                    this.dropperVisible = false;
                    if (AddStoryFragment.this.isRendererAvailable()) {
                        if (Utils.useNewStoryCreationSystem()) {
                            AddStoryFragment.this.eglThread.setColorPickingMode(false);
                        } else {
                            AddStoryFragment.this.glRenderer.setColorPickingMode(false);
                        }
                    }
                    if (this.needToTextToolsBack) {
                        this.needToTextToolsBack = false;
                        this.textToolsFrameLayout.setVisibility(0);
                        this.editText.requestFocus();
                        AndroidUtilities.showKeyboard(this.editText);
                    }
                }
                this.startPositionMap.remove(Integer.valueOf(motionEvent.getPointerId(actionIndex)));
                if (actionIndex == 0) {
                    for (int i2 = 1; i2 < pointerCount; i2++) {
                        this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(i2)), new StoryUtils.MyPoint(motionEvent.getPointerId(i2), motionEvent.getX(i2), motionEvent.getY(i2)));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "down" : "up");
            sb.append(" ");
            sb.append(motionEvent.getPointerId(motionEvent.getActionIndex()));
            sb.append(" index ");
            sb.append(motionEvent.getActionIndex());
            MyLog.e("AddStoryFragment", sb.toString());
        }

        private boolean isAClick(float f, float f2, float f3, float f4) {
            float fAbs = Math.abs(f - f2);
            float fAbs2 = Math.abs(f3 - f4);
            int i = this.CLICK_ACTION_THRESHOLD;
            return fAbs <= ((float) i) && fAbs2 <= ((float) i);
        }

        public void changeColor(int i) {
            UI_rubinoDropperSelectorCell.DropperSelectorFrameLayout dropperSelectorFrameLayout;
            if (this.isPaintMode) {
                this.paintView.changeColor(i);
                this.paintSeekBar.setColor(i);
                this.paintColorPickerRow.setSelectedColor(i);
            } else {
                changeTextColor(i);
                this.textSeekBar.setColor(i);
                this.textColorPickerRow.setSelectedColor(i);
            }
            UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = this.dropperCell;
            if (uI_rubinoDropperSelectorCell == null || (dropperSelectorFrameLayout = uI_rubinoDropperSelectorCell.view) == null) {
                return;
            }
            dropperSelectorFrameLayout.setVisibility(8);
            this.dropperVisible = false;
            if (AddStoryFragment.this.isRendererAvailable()) {
                if (Utils.useNewStoryCreationSystem()) {
                    AddStoryFragment.this.eglThread.setColorPickingMode(false);
                } else {
                    AddStoryFragment.this.glRenderer.setColorPickingMode(false);
                }
            }
        }

        public void startTrashAnimation(final boolean z, final StoryEntityView storyEntityView) {
            MyLog.e("AddStoryFragment", "startTrashAnimation  isInTrash" + z);
            if (this.inTrashAnimation != null) {
                return;
            }
            MyLog.e("AddStoryFragment", "startTrashAnimation isTrashAnimationInProgress" + this.isTrashAnimationInProgress);
            if (z) {
                if (this.isTrashAnimationInProgress) {
                    return;
                }
                this.isSmallingInTrashAnimationOccuredAndFinished = false;
                this.isTrashAnimationInProgress = true;
                this.inTrashAnimation = new AnimatorSet();
                storyEntityView.scaleBeforeAnimation = storyEntityView.getScaleX();
                storyEntityView.pivotXBeforeAnimation = storyEntityView.getPivotX();
                storyEntityView.pivotYBeforeAnimation = storyEntityView.getPivotY();
                storyEntityView.scaleAfterAnimation = (this.imageViewTrash.getWidth() / 1.5f) / Math.max(storyEntityView.getWidth(), storyEntityView.getHeight());
                float x = (this.imageViewTrash.getX() + (this.imageViewTrash.getWidth() / 2.0f)) - storyEntityView.getX();
                float y = (this.imageViewTrash.getY() + (this.imageViewTrash.getHeight() / 2.0f)) - storyEntityView.getY();
                storyEntityView.setPivotX(x);
                storyEntityView.setPivotY(y);
                this.inTrashAnimation.playTogether(ObjectAnimator.ofFloat(this.imageViewTrash, "scaleX", 1.2f), ObjectAnimator.ofFloat(this.imageViewTrash, "scaleY", 1.2f), ObjectAnimator.ofFloat(storyEntityView, "scaleX", storyEntityView.scaleAfterAnimation), ObjectAnimator.ofFloat(storyEntityView, "scaleY", storyEntityView.scaleAfterAnimation));
            } else {
                this.isSmallingInTrashAnimationOccuredAndFinished = false;
                AnimatorSet animatorSet = new AnimatorSet();
                this.inTrashAnimation = animatorSet;
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.imageViewTrash, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.imageViewTrash, "scaleY", 1.0f), ObjectAnimator.ofFloat(storyEntityView, "scaleX", storyEntityView.scaleBeforeAnimation), ObjectAnimator.ofFloat(storyEntityView, "scaleY", storyEntityView.scaleBeforeAnimation));
            }
            this.inTrashAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.65
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (FrameLayoutTouchable.this.inTrashAnimation == null || !FrameLayoutTouchable.this.inTrashAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.inTrashAnimation = null;
                    if (z) {
                        FrameLayoutTouchable.this.imageViewTrash.setScaleX(1.2f);
                        FrameLayoutTouchable.this.imageViewTrash.setScaleY(1.2f);
                        StoryEntityView storyEntityView2 = storyEntityView;
                        storyEntityView2.setScaleX(storyEntityView2.scaleAfterAnimation);
                        StoryEntityView storyEntityView3 = storyEntityView;
                        storyEntityView3.setScaleY(storyEntityView3.scaleAfterAnimation);
                        if (FrameLayoutTouchable.this.needToAnimateTrashBack) {
                            FrameLayoutTouchable.this.needToAnimateTrashBack = false;
                            MyLog.e("AddStoryFragment trash ", "needToAnimateTrashBack");
                            FrameLayoutTouchable.this.startTrashAnimation(false, storyEntityView);
                        }
                        FrameLayoutTouchable.this.isSmallingInTrashAnimationOccuredAndFinished = true;
                        return;
                    }
                    FrameLayoutTouchable.this.imageViewTrash.setScaleX(1.0f);
                    FrameLayoutTouchable.this.imageViewTrash.setScaleY(1.0f);
                    StoryEntityView storyEntityView4 = storyEntityView;
                    storyEntityView4.setPivotX(storyEntityView4.pivotXBeforeAnimation);
                    StoryEntityView storyEntityView5 = storyEntityView;
                    storyEntityView5.setPivotY(storyEntityView5.pivotYBeforeAnimation);
                    StoryEntityView storyEntityView6 = storyEntityView;
                    storyEntityView6.setScaleX(storyEntityView6.scaleBeforeAnimation);
                    StoryEntityView storyEntityView7 = storyEntityView;
                    storyEntityView7.setScaleY(storyEntityView7.scaleBeforeAnimation);
                    FrameLayoutTouchable.this.isTrashAnimationInProgress = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (FrameLayoutTouchable.this.inTrashAnimation == null || !FrameLayoutTouchable.this.inTrashAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.inTrashAnimation = null;
                }
            });
            if (z) {
                this.inTrashAnimation.setDuration(300L);
                Vibrator vibrator = (Vibrator) AddStoryFragment.this.getParentActivity().getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(50L);
                }
            } else {
                this.inTrashAnimation.setDuration(200L);
            }
            this.inTrashAnimation.start();
        }

        public void startClickAnimation(final boolean z, final StoryEntityView storyEntityView) {
            if (storyEntityView == null) {
                return;
            }
            StoryEntityView.TypeEnum typeEnum = storyEntityView.type;
            if (typeEnum == StoryEntityView.TypeEnum.hashtag || typeEnum == StoryEntityView.TypeEnum.mention || typeEnum == StoryEntityView.TypeEnum.clock || typeEnum == StoryEntityView.TypeEnum.date || typeEnum == StoryEntityView.TypeEnum.post || typeEnum == StoryEntityView.TypeEnum.link) {
                if (z || storyEntityView.needToAnimateBack) {
                    if (this.clickAnimation != null) {
                        if (!z && storyEntityView.isLastAnimationDown) {
                            storyEntityView.needToAnimateBackAtEnd = true;
                            return;
                        }
                        return;
                    }
                    storyEntityView.isLastAnimationDown = z;
                    if (z) {
                        storyEntityView.scaleBeforeAnimation = storyEntityView.getScaleX();
                    }
                    storyEntityView.downAnimationEndAndSmallest = false;
                    float f = storyEntityView.scaleBeforeAnimation;
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.clickAnimation = animatorSet;
                    if (z) {
                        float f2 = f - (0.05f * f);
                        animatorSet.playTogether(ObjectAnimator.ofFloat(storyEntityView, "scaleX", f, f2), ObjectAnimator.ofFloat(storyEntityView, "scaleY", f, f2));
                    } else {
                        float f3 = f - (0.05f * f);
                        animatorSet.playTogether(ObjectAnimator.ofFloat(storyEntityView, "scaleX", f3, f), ObjectAnimator.ofFloat(storyEntityView, "scaleY", f3, f));
                    }
                    this.clickAnimation.setInterpolator(new AccelerateInterpolator());
                    this.clickAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.66
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (FrameLayoutTouchable.this.clickAnimation == null || !FrameLayoutTouchable.this.clickAnimation.equals(animator)) {
                                return;
                            }
                            FrameLayoutTouchable.this.clickAnimation = null;
                            if (z) {
                                StoryEntityView storyEntityView2 = storyEntityView;
                                float f4 = storyEntityView2.scaleBeforeAnimation;
                                storyEntityView2.setScaleX(f4 - (f4 * 0.05f));
                                StoryEntityView storyEntityView3 = storyEntityView;
                                float f5 = storyEntityView3.scaleBeforeAnimation;
                                storyEntityView3.setScaleY(f5 - (0.05f * f5));
                                StoryEntityView storyEntityView4 = storyEntityView;
                                storyEntityView4.downAnimationEndAndSmallest = true;
                                if (storyEntityView4.isClicked) {
                                    FrameLayoutTouchable.this.performClick(storyEntityView4);
                                }
                                StoryEntityView storyEntityView5 = storyEntityView;
                                if (storyEntityView5.needToAnimateBackAtEnd) {
                                    FrameLayoutTouchable.this.startClickAnimation(false, storyEntityView5);
                                    return;
                                }
                                return;
                            }
                            StoryEntityView storyEntityView6 = storyEntityView;
                            storyEntityView6.setScaleX(storyEntityView6.scaleBeforeAnimation);
                            StoryEntityView storyEntityView7 = storyEntityView;
                            storyEntityView7.setScaleY(storyEntityView7.scaleBeforeAnimation);
                            StoryEntityView storyEntityView8 = storyEntityView;
                            storyEntityView8.needToAnimateBack = false;
                            storyEntityView8.needToAnimateBackAtEnd = false;
                            if (AddStoryFragment.this.postView != null) {
                                AddStoryFragment.this.frameLayoutTouchController.storyContainer.saveCurrentPosition((int) AddStoryFragment.this.frameLayoutTouchController.storyContainer.getX(), (int) AddStoryFragment.this.frameLayoutTouchController.storyContainer.getY());
                                AddStoryFragment.this.frameLayoutTouchController.storyContainer.saveCurrentScaleAndRotation();
                                AddStoryFragment.this.postView.saveCurrentPosition((int) AddStoryFragment.this.postView.getX(), (int) AddStoryFragment.this.postView.getY());
                                AddStoryFragment.this.postView.saveCurrentScaleAndRotation();
                                if (AddStoryFragment.this.isRendererAvailable()) {
                                    AddStoryFragment.this.eglThread.getFilterShader().setScale(AddStoryFragment.this.postView.getVideoWidthAfterScale(), AddStoryFragment.this.postView.getVideoHeightAfterScale());
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaPosition(AddStoryFragment.this.postView.getVideoXAfterScale(), AddStoryFragment.this.postView.getVideoYAfterScale());
                                    AddStoryFragment.this.eglThread.getFilterShader().setMediaRotation(AddStoryFragment.this.postView.getRotation());
                                    AddStoryFragment.this.eglThread.requestRender();
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            if (FrameLayoutTouchable.this.clickAnimation == null || !FrameLayoutTouchable.this.clickAnimation.equals(animator)) {
                                return;
                            }
                            FrameLayoutTouchable.this.clickAnimation = null;
                        }
                    });
                    if (z) {
                        this.clickAnimation.setDuration(75L);
                        this.selected.needToAnimateBack = true;
                    } else {
                        this.clickAnimation.setDuration(75L);
                    }
                    this.clickAnimation.start();
                }
            }
        }

        public void startFilterTextViewAnimation(final boolean z) {
            AnimatorSet animatorSet = this.filterAnimation;
            if (animatorSet != null) {
                if (z == this.isFilterAnimatingToShow) {
                    return;
                }
                animatorSet.cancel();
                this.filterAnimation = null;
            } else {
                if (z && this.textViewFilter.getVisibility() == 0) {
                    return;
                }
                if (!z && this.textViewFilter.getVisibility() != 0) {
                    return;
                }
            }
            this.filterAnimation = new AnimatorSet();
            this.textViewFilter.setVisibility(0);
            this.isFilterAnimatingToShow = z;
            if (z) {
                this.filterAnimation.playTogether(ObjectAnimator.ofFloat(this.textViewFilter, "alpha", 0.0f, 1.0f));
            } else {
                this.filterAnimation.playTogether(ObjectAnimator.ofFloat(this.textViewFilter, "alpha", 0.0f));
            }
            this.filterAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.67
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (FrameLayoutTouchable.this.filterAnimation == null || !FrameLayoutTouchable.this.filterAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.filterAnimation = null;
                    if (z) {
                        FrameLayoutTouchable.this.textViewFilter.setVisibility(0);
                    } else {
                        FrameLayoutTouchable.this.textViewFilter.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (FrameLayoutTouchable.this.filterAnimation == null || !FrameLayoutTouchable.this.filterAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.filterAnimation = null;
                }
            });
            if (z) {
                this.filterAnimation.setDuration(150L);
            } else {
                this.filterAnimation.setDuration(150L);
            }
            this.filterAnimation.start();
        }

        public void startPaintToolViewAnimation(final boolean z) {
            AnimatorSet animatorSet = this.mainToolHideAndShowAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mainToolHideAndShowAnimation = animatorSet2;
            if (z) {
                this.paintToolsView.setVisibility(0);
                this.mainToolHideAndShowAnimation.playTogether(ObjectAnimator.ofFloat(this.paintToolsView, "alpha", 1.0f));
            } else {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.paintToolsView, "alpha", 0.0f));
            }
            this.mainToolHideAndShowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.68
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (FrameLayoutTouchable.this.mainToolHideAndShowAnimation == null || !FrameLayoutTouchable.this.mainToolHideAndShowAnimation.equals(animator)) {
                        return;
                    }
                    if (z) {
                        FrameLayoutTouchable.this.paintToolsView.setVisibility(0);
                    } else {
                        FrameLayoutTouchable.this.paintToolsView.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (FrameLayoutTouchable.this.mainToolHideAndShowAnimation == null || !FrameLayoutTouchable.this.mainToolHideAndShowAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.mainToolHideAndShowAnimation = null;
                }
            });
            if (z) {
                this.mainToolHideAndShowAnimation.setDuration(200L);
            } else {
                this.mainToolHideAndShowAnimation.setDuration(300L);
            }
            this.mainToolHideAndShowAnimation.start();
        }

        public void startTrashVisibilityAnimation(final boolean z) {
            AnimatorSet animatorSet = this.trashVisibilityAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.trashVisibilityAnimation = new AnimatorSet();
            this.imageViewTrash.setVisibility(0);
            if (z) {
                this.trashVisibilityAnimation.playTogether(ObjectAnimator.ofFloat(this.imageViewTrash, "alpha", 0.0f, 1.0f));
            } else {
                this.trashVisibilityAnimation.playTogether(ObjectAnimator.ofFloat(this.imageViewTrash, "alpha", 1.0f, 0.0f));
            }
            this.trashVisibilityAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.69
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (FrameLayoutTouchable.this.trashVisibilityAnimation == null || !FrameLayoutTouchable.this.trashVisibilityAnimation.equals(animator)) {
                        return;
                    }
                    if (z) {
                        FrameLayoutTouchable.this.imageViewTrash.setVisibility(0);
                    } else {
                        FrameLayoutTouchable.this.imageViewTrash.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (FrameLayoutTouchable.this.trashVisibilityAnimation == null || !FrameLayoutTouchable.this.trashVisibilityAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.trashVisibilityAnimation = null;
                }
            });
            if (z) {
                this.trashVisibilityAnimation.setDuration(300L);
            } else {
                this.trashVisibilityAnimation.setDuration(200L);
            }
            this.trashVisibilityAnimation.start();
        }

        public void startMainToolViewAnimation(final boolean z, boolean z2) {
            AnimatorSet animatorSet = this.mainToolHideAndShowAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (!z2) {
                if (z) {
                    this.mainToolsView.setVisibility(0);
                    this.mainToolsView.setAlpha(1.0f);
                    return;
                } else {
                    this.mainToolsView.setVisibility(4);
                    return;
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mainToolHideAndShowAnimation = animatorSet2;
            if (z) {
                this.mainToolsView.setVisibility(0);
                this.mainToolHideAndShowAnimation.playTogether(ObjectAnimator.ofFloat(this.mainToolsView, "alpha", 1.0f));
            } else {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mainToolsView, "alpha", 0.0f));
            }
            this.mainToolHideAndShowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.AddStoryFragment.FrameLayoutTouchable.70
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (FrameLayoutTouchable.this.mainToolHideAndShowAnimation == null || !FrameLayoutTouchable.this.mainToolHideAndShowAnimation.equals(animator)) {
                        return;
                    }
                    if (z) {
                        FrameLayoutTouchable.this.mainToolsView.setVisibility(0);
                        FrameLayoutTouchable.this.mainToolsView.setAlpha(1.0f);
                    } else {
                        FrameLayoutTouchable.this.mainToolsView.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (FrameLayoutTouchable.this.mainToolHideAndShowAnimation == null || !FrameLayoutTouchable.this.mainToolHideAndShowAnimation.equals(animator)) {
                        return;
                    }
                    FrameLayoutTouchable.this.mainToolHideAndShowAnimation = null;
                }
            });
            if (z) {
                this.mainToolHideAndShowAnimation.setDuration(200L);
            } else {
                this.mainToolHideAndShowAnimation.setDuration(200L);
            }
            this.mainToolHideAndShowAnimation.start();
        }

        public void init() {
            int i;
            removeAllViews();
            this.storyContainer.setBackgroundColor(0);
            addView(this.storyContainer, LayoutHelper.createFrame(-2, -2, 1));
            ImageView imageView = new ImageView(ApplicationLoader.applicationActivity);
            this.imageViewStory = imageView;
            imageView.setBackgroundColor(0);
            FrameLayoutPaint frameLayoutPaint = new FrameLayoutPaint(ApplicationLoader.applicationActivity, (int) DimensionHelper.getStoryViewWidthPx((Activity) AddStoryFragment.this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext));
            this.paintView = frameLayoutPaint;
            addView(frameLayoutPaint, new ViewGroup.LayoutParams((int) DimensionHelper.getStoryViewWidthPx((Activity) AddStoryFragment.this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext)));
            FrameLayout frameLayout = new FrameLayout(ApplicationLoader.applicationActivity);
            this.frameLayoutEntityContainer = frameLayout;
            addView(frameLayout, new ViewGroup.LayoutParams((int) DimensionHelper.getStoryViewWidthPx((Activity) AddStoryFragment.this.mContext), (int) DimensionHelper.getStoryViewHeightPx((Activity) AddStoryFragment.this.mContext)));
            createMainToolsView();
            TextView textView = new TextView(AddStoryFragment.this.mContext);
            this.textViewFilter = textView;
            textView.setTextSize(1, 23.0f);
            this.textViewFilter.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.textViewFilter.setTextColor(-1);
            this.textViewFilter.setText(BuildConfig.FLAVOR);
            this.textViewFilter.setVisibility(4);
            this.textViewFilter.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            this.textViewFilter.setShadowLayer(AndroidUtilities.dp(3.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), -1442840576);
            addView(this.textViewFilter, LayoutHelper.createFrame(-2, -2, 17));
            if (AddStoryFragment.this.initWidget != null) {
                if (AddStoryFragment.this.initWidget.type == WidgetStoryObject.WidgetTypeEnum.Poll) {
                    addLockPollShareView(AddStoryFragment.this.widgetStoryWHRatio, AddStoryFragment.this.initWidget.poll, AddStoryFragment.this.initWidget.position);
                    return;
                }
                if (AddStoryFragment.this.initWidget.type == WidgetStoryObject.WidgetTypeEnum.Post) {
                    if (AddStoryFragment.this.isVideoPostWidget()) {
                        i = this.height;
                    } else {
                        i = (this.height * 2) / 3;
                    }
                    addPostView(AddStoryFragment.this.initWidget.rubinoPostObject, i);
                    return;
                }
                if (AddStoryFragment.this.initWidget.type == WidgetStoryObject.WidgetTypeEnum.QuestionTest) {
                    addShareQuestionView(AddStoryFragment.this.widgetStoryWHRatio, AddStoryFragment.this.initWidget.shareQuestionObject, AddStoryFragment.this.initWidget.position);
                }
            }
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.AddStoryFragment$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode;
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme;

        static {
            int[] iArr = new int[DateSticker.DateTheme.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme = iArr;
            try {
                iArr[DateSticker.DateTheme.WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[DateSticker.DateTheme.BLACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[DateSticker.DateTheme.RED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ClockSticker.ClockMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode = iArr2;
            try {
                iArr2[ClockSticker.ClockMode.CIRCULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[ClockSticker.ClockMode.TEXTUAL_SIMPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$ClockSticker$ClockMode[ClockSticker.ClockMode.TEXTUAL_GRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class StickerPagerAdapter extends PagerAdapter {
        ArrayList<RubinoStickerAndWidgetListFragment> fragments;
        private final Activity mContext;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public StickerPagerAdapter(Activity activity, ArrayList<RubinoStickerAndWidgetListFragment> arrayList) {
            this.mContext = activity;
            this.fragments = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            ArrayList<RubinoStickerAndWidgetListFragment> arrayList = this.fragments;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            RubinoStickerAndWidgetListFragment rubinoStickerAndWidgetListFragment = this.fragments.get(i);
            rubinoStickerAndWidgetListFragment.onFragmentCreate();
            rubinoStickerAndWidgetListFragment.createView(this.mContext);
            View fragmentView = rubinoStickerAndWidgetListFragment.getFragmentView();
            fragmentView.setBackgroundColor(0);
            fragmentView.setTag(rubinoStickerAndWidgetListFragment);
            viewGroup.addView(fragmentView, LayoutHelper.createFrame(-1, -1.0f));
            return fragmentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view = (View) obj;
            PresenterFragment presenterFragment = (PresenterFragment) view.getTag();
            presenterFragment.onPause();
            presenterFragment.onFragmentDestroy();
            viewGroup.removeView(view);
        }
    }

    public static class FrameLayoutPaint extends FrameLayout {
        private final Brush brush;
        Bitmap canvasBitmap;
        Paint canvasPaint;
        int currentColor;
        private Path currentPath;
        private final ArrayList<StoryUtils.MyPoint> currentPointArray;
        float currentSizePercent;
        private float currentX;
        private float currentY;
        Canvas myCanvas;
        private final ArrayList<MyPath> paths;
        float startX;
        float startY;

        public void changeColor(int i) {
            this.currentColor = i;
            Brush brush = this.brush;
            if (brush != null) {
                brush.changeColor(i);
            }
        }

        public void changeSize(float f) {
            this.currentSizePercent = f;
            Brush brush = this.brush;
            if (brush != null) {
                brush.changeSize(f);
            }
        }

        public FrameLayoutPaint(Context context, int i, int i2) {
            super(context);
            this.paths = new ArrayList<>();
            setWillNotDraw(false);
            setBackgroundColor(0);
            setBackground(ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.transparent));
            this.canvasBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.myCanvas = new Canvas(this.canvasBitmap);
            this.currentPath = new Path();
            this.currentPointArray = new ArrayList<>();
            this.canvasPaint = new Paint(1);
            this.brush = new Brush(Brush.BrushType.Paint, -1, 0.5f, 0, false);
            this.currentColor = -1;
            this.currentSizePercent = 0.5f;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(this.canvasBitmap, 0.0f, 0.0f, this.canvasPaint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void paintDown(float f, float f2) {
            Brush brush = this.brush;
            if (brush == null) {
                return;
            }
            Brush.BrushType brushType = brush.type;
            if (brushType == Brush.BrushType.Paint || brushType == Brush.BrushType.PaintAndShadow || brushType == Brush.BrushType.Erase) {
                Path path = new Path();
                this.currentPath = path;
                path.moveTo(f, f2);
            } else if (brushType == Brush.BrushType.Bitmap) {
                this.currentPointArray.clear();
                drawRotatedAndScaledBitmap(this.brush, f, f2);
                this.currentPointArray.add(new StoryUtils.MyPoint(f, f2));
            }
            this.startX = f;
            this.startY = f2;
            this.currentX = f;
            this.currentY = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void paintMove(float f, float f2) {
            Brush brush = this.brush;
            if (brush == null) {
                return;
            }
            Brush.BrushType brushType = brush.type;
            if (brushType == Brush.BrushType.Paint || brushType == Brush.BrushType.PaintAndShadow || brushType == Brush.BrushType.Erase) {
                Path path = this.currentPath;
                float f3 = this.currentX;
                float f4 = this.currentY;
                path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
                Brush brush2 = this.brush;
                if (brush2.type == Brush.BrushType.PaintAndShadow) {
                    redrawCanvac();
                    this.myCanvas.drawPath(this.currentPath, this.brush.getShadowPaint());
                    this.myCanvas.drawPath(this.currentPath, this.brush.getPaint());
                } else {
                    this.myCanvas.drawPath(this.currentPath, brush2.getPaint());
                }
            } else if (brushType == Brush.BrushType.Bitmap) {
                float maxDistance = brush.getMaxDistance();
                float f5 = f - this.startX;
                float f6 = f2 - this.startY;
                if (Math.abs(f5) > maxDistance || Math.abs(f6) > maxDistance) {
                    int iMax = Math.max((int) (Math.abs(f5) / maxDistance), (int) (Math.abs(f6) / maxDistance));
                    for (int i = 1; i < iMax; i++) {
                        float f7 = i;
                        float f8 = iMax;
                        StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(this.startX + ((f7 * f5) / f8), this.startY + ((f7 * f6) / f8));
                        this.currentPointArray.add(myPoint);
                        drawRotatedAndScaledBitmap(this.brush, myPoint.x, myPoint.y);
                    }
                }
                drawRotatedAndScaledBitmap(this.brush, f, f2);
                this.currentPointArray.add(new StoryUtils.MyPoint(f, f2));
            }
            this.startX = f;
            this.startY = f2;
            this.currentX = f;
            this.currentY = f2;
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void paintUp(float f, float f2) {
            Brush brush = this.brush;
            if (brush == null) {
                return;
            }
            Brush.BrushType brushType = brush.type;
            if (brushType == Brush.BrushType.Paint || brushType == Brush.BrushType.PaintAndShadow || brushType == Brush.BrushType.Erase) {
                this.currentPath.lineTo(this.currentX, this.currentY);
                this.myCanvas.drawPath(this.currentPath, this.brush.getPaint());
                this.paths.add(new MyPath(this.currentPath, this.brush));
            } else if (brushType == Brush.BrushType.Bitmap) {
                drawRotatedAndScaledBitmap(brush, f, f2);
                this.currentPointArray.add(new StoryUtils.MyPoint(f, f2));
                this.paths.add(new MyPath(this.currentPointArray, this.brush));
            }
            redrawCanvac();
            invalidate();
        }

        public void drawRotatedAndScaledBitmap(Brush brush, float f, float f2) {
            if (brush.isArrayOfBitmap) {
                Bitmap bitmap = brush.getBitmap((int) (f + f2));
                this.myCanvas.save();
                this.myCanvas.translate(f, f2);
                this.myCanvas.rotate((int) (r0 % 360.0f), bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                this.myCanvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                this.myCanvas.restore();
                return;
            }
            this.myCanvas.drawBitmap(brush.getBitmap(), f - (brush.getBitmap().getWidth() / 2.0f), f2 - (brush.getBitmap().getHeight() / 2.0f), (Paint) null);
        }

        public void setErase() {
            Brush brush = this.brush;
            brush.type = Brush.BrushType.Erase;
            brush.setErase();
            this.brush.changeSize(this.currentSizePercent);
        }

        public void setPaintBrush() {
            Brush brush = this.brush;
            brush.type = Brush.BrushType.Paint;
            brush.setPaint();
            this.brush.changeSize(this.currentSizePercent);
            this.brush.changeColor(this.currentColor);
        }

        public void setPaintAndShadowBrush() {
            Brush brush = this.brush;
            brush.type = Brush.BrushType.PaintAndShadow;
            brush.setPaintAndShadow();
            this.brush.changeSize(this.currentSizePercent);
            this.brush.changeColor(this.currentColor);
        }

        public void setBitmapBrush(int i, boolean z) {
            Brush brush = this.brush;
            brush.type = Brush.BrushType.Bitmap;
            brush.setBitmapDrawable(i, z);
            this.brush.changeSize(this.currentSizePercent);
            this.brush.changeColor(this.currentColor);
        }

        public void undo() {
            ArrayList<MyPath> arrayList = this.paths;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.paths.remove(r0.size() - 1);
            redrawCanvac();
            invalidate();
        }

        public void redrawCanvac() {
            this.myCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Iterator<MyPath> it = this.paths.iterator();
            while (it.hasNext()) {
                MyPath next = it.next();
                MyPath.TypeEnum typeEnum = next.type;
                if (typeEnum == MyPath.TypeEnum.Path) {
                    Brush brush = next.brush;
                    if (brush.type == Brush.BrushType.PaintAndShadow) {
                        this.myCanvas.drawPath(next.path, brush.getShadowPaint());
                    }
                    this.myCanvas.drawPath(next.path, next.brush.getPaint());
                } else if (typeEnum == MyPath.TypeEnum.PointArray) {
                    Iterator<StoryUtils.MyPoint> it2 = next.points.iterator();
                    while (it2.hasNext()) {
                        StoryUtils.MyPoint next2 = it2.next();
                        drawRotatedAndScaledBitmap(next.brush, next2.x, next2.y);
                    }
                }
            }
        }

        public static class Brush {
            private Bitmap bitmap;
            private BitmapDrawable bitmapDrawable;
            int bitmapDrawableId;
            private final Bitmap[] bitmaps = new Bitmap[5];
            int color;
            boolean isArrayOfBitmap;
            private Paint paint;
            private Paint paintShadow;
            int sizeInDp;
            float sizePercent;
            public BrushType type;

            public enum BrushType {
                Bitmap,
                Paint,
                PaintAndShadow,
                Erase
            }

            /* renamed from: clone, reason: merged with bridge method [inline-methods] */
            public Brush m439clone() {
                return new Brush(this.type, this.color, this.sizePercent, this.bitmapDrawableId, this.isArrayOfBitmap);
            }

            public Brush(BrushType brushType, int i, float f, int i2, boolean z) {
                this.color = i;
                this.sizePercent = f;
                if (brushType == BrushType.Bitmap) {
                    this.sizeInDp = getSizeInDpForBitmap();
                } else {
                    this.sizeInDp = getSizeInDpForPaint();
                }
                this.bitmapDrawableId = i2;
                this.isArrayOfBitmap = z;
                this.type = brushType;
            }

            public float getMaxDistance() {
                int iDp;
                if (this.type != BrushType.Bitmap) {
                    return 0.0f;
                }
                if (this.bitmapDrawableId == R.drawable.story_smoke) {
                    iDp = AndroidUtilities.dp(this.sizeInDp) / 4;
                } else {
                    iDp = AndroidUtilities.dp(this.sizeInDp) / 20;
                }
                return iDp;
            }

            public void init() {
                BrushType brushType = this.type;
                if (brushType == BrushType.Bitmap) {
                    setBitmapDrawable(this.bitmapDrawableId, this.isArrayOfBitmap);
                    changeSize(this.sizePercent);
                    changeColor(this.color);
                } else if (brushType == BrushType.Paint) {
                    setPaint();
                    changeSize(this.sizePercent);
                    changeColor(this.color);
                } else if (brushType == BrushType.PaintAndShadow) {
                    setPaint();
                    changeSize(this.sizePercent);
                    changeColor(this.color);
                } else if (brushType == BrushType.Erase) {
                    changeSize(this.sizePercent);
                    setErase();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBitmapDrawable(int i, boolean z) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                this.bitmapDrawableId = i;
                this.isArrayOfBitmap = z;
                this.bitmapDrawable = (BitmapDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPaint() {
                if (this.paint == null) {
                    Paint paint = new Paint(1);
                    this.paint = paint;
                    paint.setStyle(Paint.Style.STROKE);
                    this.paint.setStrokeJoin(Paint.Join.ROUND);
                    this.paint.setStrokeCap(Paint.Cap.ROUND);
                    this.paint.setXfermode(null);
                }
                this.paint.setXfermode(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPaintAndShadow() {
                if (this.paint == null) {
                    Paint paint = new Paint(1);
                    this.paint = paint;
                    paint.setStyle(Paint.Style.STROKE);
                    this.paint.setStrokeJoin(Paint.Join.ROUND);
                    this.paint.setStrokeCap(Paint.Cap.ROUND);
                    this.paint.setXfermode(null);
                }
                if (this.paintShadow == null) {
                    Paint paint2 = new Paint(1);
                    this.paintShadow = paint2;
                    paint2.setStyle(Paint.Style.STROKE);
                    this.paintShadow.setStrokeJoin(Paint.Join.ROUND);
                    this.paintShadow.setStrokeCap(Paint.Cap.ROUND);
                    this.paintShadow.setXfermode(null);
                }
                this.paint.setXfermode(null);
            }

            public void changeColor(int i) {
                this.color = i;
                BrushType brushType = this.type;
                if (brushType == BrushType.Bitmap) {
                    if (this.bitmapDrawable == null) {
                        setBitmapDrawable(this.bitmapDrawableId, this.isArrayOfBitmap);
                    }
                    this.bitmapDrawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
                    int sizeInDpForBitmap = getSizeInDpForBitmap();
                    if (this.isArrayOfBitmap) {
                        int length = this.bitmaps.length;
                        for (int i2 = 1; i2 < length; i2++) {
                            int iDp = AndroidUtilities.dp(((i2 + 5) * sizeInDpForBitmap) / (length + 5));
                            this.bitmaps[i2] = Bitmap.createBitmap(iDp, iDp, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(this.bitmaps[i2]);
                            this.bitmapDrawable.setBounds(0, 0, iDp, iDp);
                            this.bitmapDrawable.draw(canvas);
                        }
                    }
                    float f = sizeInDpForBitmap;
                    this.bitmap = Bitmap.createBitmap(AndroidUtilities.dp(f), AndroidUtilities.dp(f), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(this.bitmap);
                    this.bitmapDrawable.setBounds(0, 0, AndroidUtilities.dp(f), AndroidUtilities.dp(f));
                    this.bitmapDrawable.draw(canvas2);
                    this.bitmaps[0] = this.bitmap;
                    return;
                }
                if (brushType == BrushType.PaintAndShadow) {
                    setPaintAndShadow();
                    this.paint.setColor(-1);
                    this.paintShadow.setColor(-1);
                    this.paintShadow.setShadowLayer(AndroidUtilities.dp(8.0f), 0.0f, 0.0f, i);
                    return;
                }
                if (brushType == BrushType.Erase) {
                    setErase();
                } else {
                    setPaint();
                    this.paint.setColor(i);
                }
            }

            public void changeSize(float f) {
                if (f < 0.0f) {
                    f = 0.0f;
                }
                if (f > 1.0f) {
                    f = 1.0f;
                }
                this.sizePercent = f;
                BrushType brushType = this.type;
                BrushType brushType2 = BrushType.Bitmap;
                if (brushType == brushType2) {
                    this.sizeInDp = getSizeInDpForBitmap();
                } else {
                    this.sizeInDp = getSizeInDpForPaint();
                }
                if (this.type == brushType2) {
                    if (this.bitmapDrawable == null) {
                        setBitmapDrawable(this.bitmapDrawableId, this.isArrayOfBitmap);
                    }
                    int sizeInDpForBitmap = getSizeInDpForBitmap();
                    if (this.isArrayOfBitmap) {
                        int length = this.bitmaps.length;
                        for (int i = 1; i < length; i++) {
                            int iDp = AndroidUtilities.dp(((i + 5) * sizeInDpForBitmap) / (length + 5));
                            this.bitmaps[i] = Bitmap.createBitmap(iDp, iDp, Bitmap.Config.ARGB_8888);
                            this.bitmapDrawable.setBounds(0, 0, iDp, iDp);
                            this.bitmapDrawable.draw(new Canvas(this.bitmaps[i]));
                        }
                    }
                    float f2 = sizeInDpForBitmap;
                    this.bitmap = Bitmap.createBitmap(AndroidUtilities.dp(f2), AndroidUtilities.dp(f2), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.bitmap);
                    this.bitmapDrawable.setBounds(0, 0, AndroidUtilities.dp(f2), AndroidUtilities.dp(f2));
                    this.bitmapDrawable.draw(canvas);
                    this.bitmaps[0] = this.bitmap;
                    return;
                }
                int sizeInDpForPaint = getSizeInDpForPaint();
                if (this.paint == null) {
                    setPaint();
                }
                float f3 = sizeInDpForPaint;
                this.paint.setStrokeWidth(AndroidUtilities.dp(f3));
                if (this.type == BrushType.PaintAndShadow) {
                    if (this.paintShadow == null) {
                        setPaintAndShadow();
                    }
                    this.paintShadow.setStrokeWidth(AndroidUtilities.dp(f3));
                }
            }

            public void setErase() {
                if (this.paint == null) {
                    setPaint();
                }
                this.type = BrushType.Erase;
                this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }

            public Paint getPaint() {
                BrushType brushType = this.type;
                if (brushType != BrushType.Paint && brushType != BrushType.PaintAndShadow && brushType != BrushType.Erase) {
                    return null;
                }
                if (this.paint == null) {
                    init();
                }
                return this.paint;
            }

            public Paint getShadowPaint() {
                if (this.type != BrushType.PaintAndShadow) {
                    return null;
                }
                if (this.paintShadow == null) {
                    init();
                }
                return this.paintShadow;
            }

            public Bitmap getBitmap() {
                return getBitmap(0);
            }

            public Bitmap getBitmap(int i) {
                if (this.type != BrushType.Bitmap) {
                    return null;
                }
                if (this.bitmap == null) {
                    init();
                }
                if (this.isArrayOfBitmap) {
                    Bitmap[] bitmapArr = this.bitmaps;
                    return bitmapArr[i % bitmapArr.length];
                }
                return this.bitmap;
            }

            private int getSizeInDpForBitmap() {
                return (int) ((this.sizePercent * 50.0f) + 20.0f);
            }

            private int getSizeInDpForPaint() {
                return (int) ((this.sizePercent * 20.0f) + 8.0f);
            }
        }

        public static class MyPath {
            public Brush brush;
            public Path path;
            public ArrayList<StoryUtils.MyPoint> points;
            public TypeEnum type;

            public enum TypeEnum {
                Path,
                PointArray
            }

            public MyPath(Path path, Brush brush) {
                this.type = TypeEnum.Path;
                this.path = path;
                this.brush = brush.m439clone();
            }

            public MyPath(ArrayList<StoryUtils.MyPoint> arrayList, Brush brush) {
                this.type = TypeEnum.PointArray;
                ArrayList<StoryUtils.MyPoint> arrayList2 = new ArrayList<>();
                this.points = arrayList2;
                arrayList2.addAll(arrayList);
                this.brush = brush.m439clone();
            }
        }
    }
}
