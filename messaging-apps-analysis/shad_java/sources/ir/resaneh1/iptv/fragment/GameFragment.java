package ir.resaneh1.iptv.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.transition.ChangeBounds;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.jakewharton.rxbinding2.view.RxView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.CustomProgressView;
import ir.resaneh1.iptv.UIView.UI_GameOption;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GameTestHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.DynamicEndpointDataObject;
import ir.resaneh1.iptv.model.GameAddCommentInput;
import ir.resaneh1.iptv.model.GameAddCommentOutput;
import ir.resaneh1.iptv.model.GameAnswerObject;
import ir.resaneh1.iptv.model.GameCommentObject;
import ir.resaneh1.iptv.model.GameGetCommentsInput;
import ir.resaneh1.iptv.model.GameGetCommentsOutput;
import ir.resaneh1.iptv.model.GameInput;
import ir.resaneh1.iptv.model.GameOptionObject;
import ir.resaneh1.iptv.model.GameQuestionInfo;
import ir.resaneh1.iptv.model.GameQuestionObject;
import ir.resaneh1.iptv.model.GameSendAnswerInput;
import ir.resaneh1.iptv.model.GameSendAnswerOutput;
import ir.resaneh1.iptv.model.GameStateObject;
import ir.resaneh1.iptv.model.GameUseReliveChanceInput;
import ir.resaneh1.iptv.model.GameUseReliveChanceOutput;
import ir.resaneh1.iptv.model.GetGameStatusInput;
import ir.resaneh1.iptv.model.GetGameStatusOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.GameCommentPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class GameFragment extends PresenterFragment {
    private DisposableObserver addCommentTimer;
    private final String backgroundUrl;
    private FrameLayout circleProgressContainer;
    private CompositeDisposable compositeDisposable;
    private Drawable countOnlineDrawableGrey;
    private Drawable countOnlineDrawableWhite;
    private int currentLevel;
    private GameQuestionObject currentQuestion;
    private EditText editTextComment;
    private SimpleExoPlayer exoPlayer;
    private PlayerView exoPlayerView;
    private FrameLayout frameLayoutComment;
    private FrameLayout frameLayoutMain;
    private FrameLayout frameLayoutNoGame;
    private FrameLayout frameLayoutVideo;
    private GameCommentPresenter gameCommentPresenter;
    private final String gameId;
    private DisposableObserver getCommentRequestTimer;
    private int greenProgressColor;
    private final boolean hideComments;
    private String hostStreamUrl;
    private ImageView imageViewBackground;
    private ImageView imageViewSendComment;
    private boolean isCommentTimerStarted;
    private boolean isPlaying;
    private final boolean isTest;
    private LinearLayout linearLayoutOptions;
    private DisposableObserver loadingObserver;
    private HashMap<String, GameCommentObject> myComments;
    Scene newScene;
    private DisposableObserver nextStateTimer;
    private DynamicFragment noGameFragment;
    private View progressVideo;
    private HashMap<String, GameQuestionInfo> questionInfoMap;
    private ViewGroup questionLayout;
    private DisposableObserver questionTimer;
    private int redProgressColor;
    private int reliveChance;
    private Drawable reliveDrawableGrey;
    private Drawable reliveDrawableWhite;
    private CustomProgressView ringProgressBar;
    private DisposableObserver scrollTimer;
    private FrameLayout sendProgressBarContainer;
    private int smallHeight;
    private int smallWidth;
    private TextView textViewCountOnline;
    private TextView textViewQuestion;
    private TextView textViewReliveCount;
    private TextView textViewTimer;
    private ArrayList<UI_GameOption> uiGameOptions;
    private boolean isFirstBack = true;
    private long delayToRetryMiliSecond = 1000;
    private GameStateObject currentState = null;
    private String nextStartIdComment = BuildConfig.FLAVOR;
    private long lastTimeCommentApiCalled = 0;
    private boolean isKnowLost = false;
    private boolean isMaybeRecentlyLostAndCanUseRelive = false;
    boolean isFirstTimeGetHostOrQuestionOrAnswerState = true;
    private boolean isVideoLayoutSmall = true;
    View.OnClickListener onReliveClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameFragment.this.canUseChance()) {
                GameFragment.this.showChanceView();
            }
        }
    };
    View.OnTouchListener onRecyclerViewTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            }
            GameFragment.this.startTimerToScroll();
            return false;
        }
    };
    UI_GameOption.OnSelectOptionListener onSelectOptionListener = new UI_GameOption.OnSelectOptionListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.18
        @Override // ir.resaneh1.iptv.UIView.UI_GameOption.OnSelectOptionListener
        public void onSelect(UI_GameOption uI_GameOption) {
            if (GameFragment.this.canAnswer()) {
                if (GameFragment.this.currentQuestion != null) {
                    GameFragment.this.callSendAnswer(uI_GameOption.optionObject.option_id);
                    return;
                }
                return;
            }
            GameFragment gameFragment = GameFragment.this;
            GameQuestionInfo questionInfo = gameFragment.getQuestionInfo(gameFragment.currentQuestion.question_id);
            if (!GameFragment.this.isKnowLost) {
                if (GameFragment.this.currentState != null && GameFragment.this.currentState.status != GameStateObject.GameStatusEnum.ShowQuestion) {
                    ToastiLikeSnack.showMessageLikeToastLong("زمان پاسخگویی به پایان رسیده!");
                    return;
                } else {
                    if (questionInfo.isSendAnswerRequesting || questionInfo.selectedId != null) {
                        ToastiLikeSnack.showMessageLikeToastLong("قبلا پاسخ داده اید!");
                        return;
                    }
                    return;
                }
            }
            ToastiLikeSnack.showMessageLikeToastLong("نمی تونی جواب بدی چون حذف شدی");
        }
    };

    private void showLoseView() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.game_fragment;
    }

    public GameFragment(boolean z, String str, String str2, int i, int i2, String str3, boolean z2) {
        this.isTest = z;
        this.gameId = str;
        this.currentLevel = i2;
        this.reliveChance = i;
        this.backgroundUrl = str3;
        this.hideComments = z2;
        this.isFullScreen = true;
        this.needLockOrientation = true;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.exoPlayerView = (PlayerView) findViewById(R.id.simpleExoPlayerView);
        this.progressVideo = findViewById(R.id.progressBarContainerVideo);
        UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, (FrameLayout) this.progressVideo, 32);
        this.frameLayoutMain = (FrameLayout) findViewById(R.id.frameLayoutMain);
        this.frameLayoutNoGame = (FrameLayout) findViewById(R.id.frameLayoutNoGameContainer);
        this.frameLayoutVideo = (FrameLayout) findViewById(R.id.frameLayoutVideo);
        this.linearLayoutOptions = (LinearLayout) findViewById(R.id.linearLayoutOptions);
        this.textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        this.textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        this.questionLayout = (ViewGroup) findViewById(R.id.questionLayout);
        findViewById(R.id.emoji1ImageView).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameFragment.this.editTextComment.setText("😍");
                GameFragment.this.addMyCommentComment();
            }
        });
        findViewById(R.id.emoji2ImageView).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameFragment.this.editTextComment.setText("❤️");
                GameFragment.this.addMyCommentComment();
            }
        });
        findViewById(R.id.emoji3ImageView).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameFragment.this.editTextComment.setText("😫");
                GameFragment.this.addMyCommentComment();
            }
        });
        findViewById(R.id.emoji4ImageView).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameFragment.this.editTextComment.setText("👍🏻");
                GameFragment.this.addMyCommentComment();
            }
        });
        findViewById(R.id.emoji5ImageView).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameFragment.this.editTextComment.setText("😎");
                GameFragment.this.addMyCommentComment();
            }
        });
        EditText editText = (EditText) findViewById(R.id.editText);
        this.editTextComment = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.fragment.GameFragment.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
            }
        });
        this.imageViewSendComment = (ImageView) findViewById(R.id.imageViewSend);
        this.sendProgressBarContainer = (FrameLayout) findViewById(R.id.sendProgressBarContainer);
        this.imageViewBackground = (ImageView) findViewById(R.id.imageViewBackground);
        UIProgressBarNewStyle.addToFrameWhiteWithTransparentBackground(ApplicationLoader.applicationActivity, this.sendProgressBarContainer, 30);
        this.circleProgressContainer = (FrameLayout) findViewById(R.id.circleProgressContainer);
        this.textViewCountOnline = (TextView) findViewById(R.id.textViewCountOnline);
        this.textViewReliveCount = (TextView) findViewById(R.id.textViewReliveCount);
        this.frameLayoutComment = (FrameLayout) findViewById(R.id.frameLayoutComment);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() throws Resources.NotFoundException {
        super.init();
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.game_user_white);
        this.countOnlineDrawableWhite = drawable;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.countOnlineDrawableWhite.setBounds(0, 0, this.countOnlineDrawableWhite.getIntrinsicWidth(), intrinsicHeight);
        Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.game_user_grey);
        this.countOnlineDrawableGrey = drawable2;
        int intrinsicHeight2 = drawable2.getIntrinsicHeight();
        this.countOnlineDrawableGrey.setBounds(0, 0, this.countOnlineDrawableGrey.getIntrinsicWidth(), intrinsicHeight2);
        Drawable drawable3 = this.mContext.getResources().getDrawable(R.drawable.game_relive_white);
        this.reliveDrawableWhite = drawable3;
        int intrinsicHeight3 = drawable3.getIntrinsicHeight();
        this.reliveDrawableWhite.setBounds(0, 0, this.reliveDrawableWhite.getIntrinsicWidth(), intrinsicHeight3);
        Drawable drawable4 = this.mContext.getResources().getDrawable(R.drawable.game_relive_grey);
        this.reliveDrawableGrey = drawable4;
        int intrinsicHeight4 = drawable4.getIntrinsicHeight();
        this.reliveDrawableGrey.setBounds(0, 0, this.reliveDrawableGrey.getIntrinsicWidth(), intrinsicHeight4);
        this.textViewReliveCount.setText(NumberUtils.toPersian(this.reliveChance));
        this.textViewReliveCount.setOnClickListener(this.onReliveClick);
        this.questionInfoMap = new HashMap<>();
        this.redProgressColor = R.color.red_500;
        this.greenProgressColor = R.color.green_400;
        this.smallWidth = AndroidUtilities.dp(100.0f);
        this.smallHeight = (DimensionHelper.getScreenHeight((Activity) this.mContext) * this.smallWidth) / DimensionHelper.getScreenWidth((Activity) this.mContext);
        this.compositeDisposable = new CompositeDisposable();
        lockOrientationPortrait();
        this.swipeBackEnabled = false;
        String str = this.backgroundUrl;
        if (str != null && !str.isEmpty()) {
            GlideHelper.load(this.mContext, this.imageViewBackground, this.backgroundUrl, R.color.purple_700);
        } else {
            this.imageViewBackground.setBackgroundColor(this.mContext.getResources().getColor(R.color.purple_700));
        }
        this.progressBar.setVisibility(4);
        this.uiGameOptions = new ArrayList<>();
        this.gameCommentPresenter = new GameCommentPresenter(this.mContext);
        initVertical();
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.GameFragment.7
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.gameComment) {
                    return GameFragment.this.gameCommentPresenter;
                }
                return MainPresenterSelector.getInstance(GameFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, null, null);
        this.mainAdapter = mainAdapter;
        mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
        makeLayout();
        this.isPlaying = false;
        if (this.isTest) {
            GameTestHelper.getStatusArray();
        } else {
            callGetGameStatus();
        }
    }

    private void initVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 1, true);
        this.linearLayoutManager = linearLayoutManager;
        this.mainRecyclerView.setLayoutManager(linearLayoutManager);
    }

    void makeLayout() {
        this.ringProgressBar = UIProgressBarNewStyle.addGameProgressBar((Activity) this.mContext, this.circleProgressContainer, 108, this.greenProgressColor, this.redProgressColor);
        hideGameView();
        setCountOnlineAndReliveViewWhite();
        if (this.hideComments) {
            hideCommentView();
        } else {
            setComments();
        }
    }

    private void hideCommentView() {
        this.frameLayoutComment.setVisibility(8);
        this.mainRecyclerView.setVisibility(4);
    }

    private void hideGameView() {
        initOrClearQuestionLayout();
        this.questionLayout.setVisibility(8);
        this.isVideoLayoutSmall = true;
        setVideoSizeIfNeeded(false);
        this.frameLayoutMain.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetGameStatus() {
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getGameStatus(this.delayToRetryMiliSecond, new GetGameStatusInput(this.gameId)).subscribeWith(new DisposableObserver<MessangerOutput<GetGameStatusOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetGameStatusOutput> messangerOutput) {
                GetGameStatusOutput getGameStatusOutput;
                if (messangerOutput == null || (getGameStatusOutput = messangerOutput.data) == null) {
                    return;
                }
                GameFragment.this.onGetState(getGameStatusOutput);
                GameFragment.this.prepareToGetNextState(getGameStatusOutput.api_call_time);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                GameFragment.this.compositeDisposable.add((Disposable) Observable.just(1).delay(GameFragment.this.delayToRetryMiliSecond, TimeUnit.MILLISECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.9.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th2) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        GameFragment.this.callGetGameStatus();
                    }
                }));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetState(GetGameStatusOutput getGameStatusOutput) {
        DisposableObserver disposableObserver = this.nextStateTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        String str = getGameStatusOutput.count_online;
        if (str != null) {
            setCountOnline(str);
        }
        String str2 = getGameStatusOutput.stream_url;
        if (str2 != null && !str2.isEmpty() && getGameStatusOutput.stream_url.startsWith("http")) {
            this.hostStreamUrl = getGameStatusOutput.stream_url;
        }
        GameStateObject gameStateObject = getGameStatusOutput.state;
        if (gameStateObject != null) {
            doNext(gameStateObject, getGameStatusOutput.state_remaining);
            GameStateObject gameStateObject2 = getGameStatusOutput.state;
            GameStateObject.GameStatusEnum gameStatusEnum = gameStateObject2.status;
            if ((gameStatusEnum == GameStateObject.GameStatusEnum.Host || gameStatusEnum == GameStateObject.GameStatusEnum.ShowAnswer || gameStatusEnum == GameStateObject.GameStatusEnum.ShowQuestion) && this.isFirstTimeGetHostOrQuestionOrAnswerState) {
                this.isFirstTimeGetHostOrQuestionOrAnswerState = false;
                if (this.currentLevel < gameStateObject2.allowed_level) {
                    ToastiLikeSnack.showMessageLikeToastLong("دیر رسیدی به بازی!");
                }
            }
        }
        long j = getGameStatusOutput.retry_time;
        if (j > 0) {
            this.delayToRetryMiliSecond = j;
        }
        GameStateObject gameStateObject3 = getGameStatusOutput.next_state;
        if (gameStateObject3 != null) {
            gameStateObject3.isFromNextState = true;
            startTimerForNextState(gameStateObject3, getGameStatusOutput.state_remaining);
            return;
        }
        GameStateObject gameStateObject4 = getGameStatusOutput.state;
        if (gameStateObject4 != null) {
            GameStateObject.GameStatusEnum gameStatusEnum2 = gameStateObject4.status;
            if (gameStatusEnum2 == GameStateObject.GameStatusEnum.ShowQuestion || gameStatusEnum2 == GameStateObject.GameStatusEnum.ShowAnswer) {
                GameStateObject gameStateObject5 = new GameStateObject();
                gameStateObject5.status = GameStateObject.GameStatusEnum.Host;
                startTimerForNextState(gameStateObject5, getGameStatusOutput.state_remaining);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerToScroll() {
        DisposableObserver disposableObserver = this.scrollTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) Observable.timer(20L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                try {
                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, GameFragment.this.mContext) { // from class: ir.resaneh1.iptv.fragment.GameFragment.11.1
                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                        protected int getVerticalSnapPreference() {
                            return -1;
                        }
                    };
                    linearSmoothScroller.setTargetPosition(0);
                    GameFragment.this.mainRecyclerView.getLayoutManager().startSmoothScroll(linearSmoothScroller);
                } catch (Exception unused) {
                }
            }
        });
        this.scrollTimer = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    public void setCountOnline(String str) {
        this.textViewCountOnline.setText(NumberUtils.toCuteStringWithKOrM(str));
    }

    public void setCountOnlineAndReliveViewWhite() {
        this.textViewCountOnline.setTextColor(this.mContext.getResources().getColor(R.color.white));
        this.textViewCountOnline.setCompoundDrawables(this.countOnlineDrawableWhite, null, null, null);
        this.textViewReliveCount.setTextColor(this.mContext.getResources().getColor(R.color.white));
        this.textViewReliveCount.setCompoundDrawables(this.reliveDrawableWhite, null, null, null);
    }

    public void setCountOnlineAndReliveViewGrey() {
        this.textViewCountOnline.setTextColor(this.mContext.getResources().getColor(R.color.grey_700));
        this.textViewCountOnline.setCompoundDrawables(this.countOnlineDrawableGrey, null, null, null);
        this.textViewReliveCount.setTextColor(this.mContext.getResources().getColor(R.color.grey_700));
        this.textViewReliveCount.setCompoundDrawables(this.reliveDrawableGrey, null, null, null);
    }

    private void startQuestionTimer(int i, int i2) {
        DisposableObserver disposableObserver;
        final Long lValueOf = Long.valueOf(System.currentTimeMillis());
        final long j = i2;
        long jLongValue = lValueOf.longValue() + j;
        if (Math.abs(jLongValue - getQuestionInfo(this.currentQuestion.question_id).showEndTime) > 1000 || (disposableObserver = this.questionTimer) == null || disposableObserver.isDisposed()) {
            getQuestionInfo(this.currentQuestion.question_id).showEndTime = jLongValue;
            DisposableObserver disposableObserver2 = this.questionTimer;
            if (disposableObserver2 != null) {
                disposableObserver2.dispose();
            }
            this.ringProgressBar.setVisibility(0);
            if (i < 0) {
                i = 1;
            }
            this.ringProgressBar.setProgress(((i - i2) * 100) / i);
            this.ringProgressBar.setProgressWithAnimation(100, i2);
            DisposableObserver disposableObserver3 = (DisposableObserver) Observable.interval(0L, 270, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.12
                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
                    long jLongValue2 = lValueOf2.longValue() - lValueOf.longValue();
                    long j2 = j;
                    if (jLongValue2 >= j2) {
                        GameFragment.this.ringProgressBar.setProgress(100);
                        GameFragment.this.textViewTimer.setText(NumberUtils.toPersian(0));
                        dispose();
                    } else {
                        int iLongValue = (int) ((j2 - (lValueOf2.longValue() - lValueOf.longValue())) / 1000);
                        if (GameFragment.this.textViewTimer.getVisibility() == 0) {
                            GameFragment.this.textViewTimer.setText(NumberUtils.toPersian(iLongValue));
                        }
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            this.questionTimer = disposableObserver3;
            this.compositeDisposable.add(disposableObserver3);
        }
    }

    private void startTimerForNextState(final GameStateObject gameStateObject, long j) {
        if (j == 0) {
            return;
        }
        DisposableObserver disposableObserver = (DisposableObserver) Observable.timer(j, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.13
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                GameFragment.this.doNext(gameStateObject);
            }
        });
        this.nextStateTimer = disposableObserver;
        this.compositeDisposable.add(disposableObserver);
    }

    public void doNext(GameStateObject gameStateObject) {
        doNext(gameStateObject, -1L);
    }

    public void doNext(GameStateObject gameStateObject, long j) {
        GameStateObject gameStateObject2 = this.currentState;
        this.currentState = gameStateObject;
        GameStateObject.GameStatusEnum gameStatusEnum = gameStateObject.status;
        if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowQuestion) {
            if (gameStateObject.question == null) {
                gameStateObject.question = new GameQuestionObject();
            }
            updateCurrentQuestionIfNeeded(gameStateObject.question);
            getQuestionInfo(this.currentQuestion.question_id).isOneTimeShowedQuestion = true;
            this.isMaybeRecentlyLostAndCanUseRelive = false;
            setAndShowQuestionView();
            if (j > 0) {
                startQuestionTimer(this.currentQuestion.show_time, (int) j);
            } else {
                int i = this.currentQuestion.show_time;
                startQuestionTimer(i, i);
            }
        } else if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowAnswer && gameStateObject.answer != null) {
            GameQuestionObject gameQuestionObject = gameStateObject.question;
            if (gameQuestionObject != null) {
                updateCurrentQuestionIfNeeded(gameQuestionObject);
                setAndShowQuestionView();
            }
            DisposableObserver disposableObserver = this.questionTimer;
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
            if (gameStateObject.answer.correct_option_key != null) {
                getQuestionInfo(this.currentQuestion.question_id).correctOptionId = gameStateObject.answer.correct_option_key;
                if (getQuestionInfo(this.currentQuestion.question_id).isSendAnswerRequesting && getQuestionInfo(this.currentQuestion.question_id).selectedId == null) {
                    startWaitingTimerIfNeeded();
                } else {
                    checkAnswerAndSetLevel(this.currentQuestion.question_id);
                }
            }
            updateViewByState();
        } else {
            GameStateObject.GameStatusEnum gameStatusEnum2 = GameStateObject.GameStatusEnum.NoGame;
            if (gameStatusEnum == gameStatusEnum2) {
                this.isCommentTimerStarted = false;
                DisposableObserver disposableObserver2 = this.getCommentRequestTimer;
                if (disposableObserver2 != null) {
                    disposableObserver2.dispose();
                }
                DisposableObserver disposableObserver3 = this.addCommentTimer;
                if (disposableObserver3 != null) {
                    disposableObserver3.dispose();
                }
                if (gameStateObject2 == null || gameStateObject2.status != gameStatusEnum2 || !gameStateObject.state_id.equals(gameStateObject2.state_id)) {
                    setNoGameView(gameStateObject.no_game_endpoint);
                }
                stopPlayer();
            } else if (gameStatusEnum == GameStateObject.GameStatusEnum.Host) {
                DisposableObserver disposableObserver4 = this.questionTimer;
                if (disposableObserver4 != null) {
                    disposableObserver4.dispose();
                }
                setHostLayout();
            }
        }
        if (gameStateObject.status != GameStateObject.GameStatusEnum.NoGame) {
            setGameLayoutHideNoGameIfNeeded();
            if (!this.isPlaying) {
                playStream();
            }
            if (this.isCommentTimerStarted) {
                return;
            }
            DisposableObserver disposableObserver5 = this.addCommentTimer;
            if (disposableObserver5 != null) {
                disposableObserver5.dispose();
            }
            if (this.hideComments) {
                return;
            }
            callGetComments();
        }
    }

    private void startWaitingTimerIfNeeded() {
        final GameQuestionInfo questionInfo = getQuestionInfo(this.currentQuestion.question_id);
        if (questionInfo.waitingForAnswerDisposable == null) {
            questionInfo.waitingForAnswerDisposable = (Disposable) Observable.timer(3L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.14
                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    Disposable disposable = questionInfo.requestSendAnswerDisposable;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    if (GameFragment.this.currentState.answer != null) {
                        GameFragment gameFragment = GameFragment.this;
                        gameFragment.checkAnswerAndSetLevel(gameFragment.currentQuestion.question_id);
                        GameFragment.this.updateViewByState();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    onComplete();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
        }
        this.compositeDisposable.add(questionInfo.waitingForAnswerDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareToGetNextState(long j) {
        if (j < 0) {
            return;
        }
        if (this.delayToRetryMiliSecond <= 0) {
            this.delayToRetryMiliSecond = 1L;
        }
        this.compositeDisposable.add((Disposable) Observable.timer(j, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.15
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                GameFragment.this.callGetGameStatus();
            }
        }));
    }

    private void setHostLayout() {
        hideQuestionLayout();
        setVideoSizeIfNeeded(false);
    }

    private void setNoGameView(DynamicEndpointDataObject dynamicEndpointDataObject) {
        String str;
        String str2;
        if (dynamicEndpointDataObject != null) {
            str = dynamicEndpointDataObject.endpoint_type_id;
            str2 = dynamicEndpointDataObject.object_id;
        } else {
            str = BuildConfig.FLAVOR;
            str2 = str;
        }
        stopAndReleasePlayer();
        hideGameView();
        removeLastNoGameIfExist();
        if (dynamicEndpointDataObject != null) {
            DynamicFragment dynamicFragment = new DynamicFragment(BuildConfig.FLAVOR, str, str2);
            dynamicFragment.isPreview = true;
            dynamicFragment.createView(this.mContext);
            dynamicFragment.getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.transparent));
            this.noGameFragment = dynamicFragment;
            this.frameLayoutNoGame.addView(dynamicFragment.getFragmentView());
        }
    }

    private void setGameLayoutHideNoGameIfNeeded() {
        if (this.frameLayoutMain.getVisibility() != 0) {
            this.frameLayoutMain.setVisibility(0);
            removeLastNoGameIfExist();
        }
    }

    private void removeLastNoGameIfExist() {
        try {
            this.frameLayoutNoGame.removeAllViews();
            DynamicFragment dynamicFragment = this.noGameFragment;
            if (dynamicFragment != null) {
                dynamicFragment.onPause();
                this.noGameFragment.onFragmentDestroy();
                this.noGameFragment = null;
            }
        } catch (Exception unused) {
        }
    }

    private void hideQuestionLayout() {
        if (this.questionLayout.getVisibility() == 0 || this.questionLayout.getVisibility() == 4) {
            setCountOnlineAndReliveViewWhite();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.questionLayout, "alpha", 0.0f));
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(300L);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.GameFragment.16
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GameFragment.this.questionLayout.setAlpha(1.0f);
                    GameFragment.this.questionLayout.setVisibility(8);
                }
            });
            animatorSet.start();
        }
    }

    private void initOrClearQuestionLayout() {
        this.textViewQuestion.setText(BuildConfig.FLAVOR);
        initOptionLayout();
    }

    public void showQuestionViewSmallVideo() {
        if (this.questionLayout.getVisibility() != 0) {
            setCountOnlineAndReliveViewGrey();
            this.questionLayout.setAlpha(0.0f);
            this.questionLayout.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.questionLayout, "alpha", 1.0f));
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(300L);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.GameFragment.17
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GameFragment.this.questionLayout.setAlpha(1.0f);
                }
            });
            animatorSet.start();
        }
        setVideoSizeIfNeeded(true);
    }

    private void setAndShowQuestionView() {
        if (this.currentState.status == GameStateObject.GameStatusEnum.ShowQuestion) {
            initOrClearQuestionLayout();
        }
        showQuestionViewSmallVideo();
        updateViewByState();
    }

    private void setQuestionTextIfNeeded() {
        if (this.currentQuestion.text != null) {
            if (this.textViewQuestion.getText().toString().equals(this.currentQuestion.text)) {
                return;
            }
            this.textViewQuestion.setText(this.currentQuestion.text);
            return;
        }
        this.textViewQuestion.setText(BuildConfig.FLAVOR);
    }

    private void initOptionLayout() {
        int i;
        this.linearLayoutOptions.setVisibility(4);
        int size = this.uiGameOptions.size();
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            if (i2 < size) {
                this.uiGameOptions.get(i2).clearViewAndInvisible();
            } else {
                UI_GameOption uI_GameOption = new UI_GameOption();
                uI_GameOption.createView((Activity) this.mContext, this.onSelectOptionListener);
                this.uiGameOptions.add(uI_GameOption);
                this.linearLayoutOptions.addView(uI_GameOption.view);
            }
            i2++;
        }
        for (i = 3; i < size; i++) {
            UI_GameOption uI_GameOption2 = this.uiGameOptions.get(i);
            uI_GameOption2.clearViewAndInvisible();
            uI_GameOption2.view.setVisibility(8);
        }
    }

    private void updateQuestionView() {
        setQuestionTextIfNeeded();
        ArrayList<GameOptionObject> arrayList = this.currentQuestion.options;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        setOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewByState() {
        GameStateObject.GameStatusEnum gameStatusEnum;
        GameStateObject gameStateObject = this.currentState;
        if (gameStateObject == null || (gameStatusEnum = gameStateObject.status) == null) {
            return;
        }
        if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowQuestion) {
            updateQuestionView();
        } else if (gameStatusEnum == GameStateObject.GameStatusEnum.ShowAnswer) {
            updateQuestionView();
            setAndShowAnswerView(this.currentState.answer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canAnswer() {
        GameStateObject gameStateObject;
        GameQuestionObject gameQuestionObject = this.currentQuestion;
        if (gameQuestionObject == null) {
            return false;
        }
        GameQuestionInfo questionInfo = getQuestionInfo(gameQuestionObject.question_id);
        return (questionInfo.isSendAnswerRequesting || questionInfo.selectedId != null || (gameStateObject = this.currentState) == null || gameStateObject.status != GameStateObject.GameStatusEnum.ShowQuestion || this.isKnowLost) ? false : true;
    }

    private void updateCurrentQuestionIfNeeded(GameQuestionObject gameQuestionObject) {
        if (gameQuestionObject == null) {
            return;
        }
        GameQuestionObject gameQuestionObject2 = this.currentQuestion;
        if (gameQuestionObject2 == null) {
            this.currentQuestion = gameQuestionObject;
            return;
        }
        if (!DataGenerator.isTwoStringEquals(gameQuestionObject2.question_id, gameQuestionObject.question_id)) {
            this.currentQuestion = gameQuestionObject;
            return;
        }
        if (DataGenerator.isTwoStringEquals(this.currentQuestion.question_id, gameQuestionObject.question_id)) {
            String str = gameQuestionObject.text;
            if (str != null && !str.isEmpty()) {
                this.currentQuestion.text = gameQuestionObject.text;
            }
            ArrayList<GameOptionObject> arrayList = gameQuestionObject.options;
            if (arrayList != null && arrayList.size() > 0) {
                GameQuestionObject gameQuestionObject3 = this.currentQuestion;
                if (gameQuestionObject3.options == null) {
                    gameQuestionObject3.options = new ArrayList<>();
                }
                this.currentQuestion.options.clear();
                this.currentQuestion.options.addAll(gameQuestionObject.options);
            }
            GameQuestionObject gameQuestionObject4 = this.currentQuestion;
            gameQuestionObject4.allow_use_relive = gameQuestionObject.allow_use_relive;
            int i = gameQuestionObject.show_time;
            if (i != gameQuestionObject4.show_time) {
                gameQuestionObject4.show_time = i;
            }
        }
    }

    private void setOptions() {
        ArrayList<GameOptionObject> arrayList = this.currentQuestion.options;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int size2 = this.uiGameOptions.size();
        String str = getQuestionInfo(this.currentQuestion.question_id).requestingSelectingId;
        String str2 = getQuestionInfo(this.currentQuestion.question_id).selectedId;
        boolean z = getQuestionInfo(this.currentQuestion.question_id).isSendAnswerRequesting;
        for (int i = 0; i < size; i++) {
            if (i >= size2) {
                UI_GameOption uI_GameOption = new UI_GameOption();
                uI_GameOption.createView((Activity) this.mContext, this.onSelectOptionListener);
                this.uiGameOptions.add(uI_GameOption);
                this.linearLayoutOptions.addView(uI_GameOption.view);
            }
            this.uiGameOptions.get(i).setOption(this.currentQuestion.options.get(i));
            if (z) {
                if (DataGenerator.isTwoStringEquals(this.currentQuestion.options.get(i).option_id, str)) {
                    this.uiGameOptions.get(i).showLoadingProgress();
                }
            } else if (str2 != null && DataGenerator.isTwoStringEquals(this.currentQuestion.options.get(i).option_id, str2)) {
                this.uiGameOptions.get(i).setSelectedView();
            }
        }
        int size3 = this.uiGameOptions.size();
        while (size < size3) {
            this.uiGameOptions.get(size).view.setVisibility(8);
            size++;
        }
        this.linearLayoutOptions.setVisibility(0);
    }

    private void setAndShowAnswerView(GameAnswerObject gameAnswerObject) {
        ArrayList<GameOptionObject> arrayList;
        int iIntValue;
        GameQuestionObject gameQuestionObject = this.currentQuestion;
        if (gameQuestionObject == null || (arrayList = gameQuestionObject.options) == null || gameAnswerObject == null || gameAnswerObject.options == null) {
            return;
        }
        int size = arrayList.size();
        int size2 = this.uiGameOptions.size();
        Iterator<String> it = gameAnswerObject.options.keySet().iterator();
        int iIntValue2 = 0;
        while (it.hasNext()) {
            iIntValue2 += gameAnswerObject.options.get(it.next()).intValue();
        }
        String str = getQuestionInfo(this.currentQuestion.question_id) != null ? getQuestionInfo(this.currentQuestion.question_id).selectedId : null;
        for (int i = 0; i < size; i++) {
            UI_GameOption.OptionStateEnum optionStateEnum = UI_GameOption.OptionStateEnum.notSelected;
            GameOptionObject gameOptionObject = this.currentQuestion.options.get(i);
            if (DataGenerator.isTwoStringEquals(gameOptionObject.option_id, str)) {
                if (DataGenerator.isTwoStringEquals(gameOptionObject.option_id, gameAnswerObject.correct_option_key)) {
                    optionStateEnum = UI_GameOption.OptionStateEnum.greenSelected;
                } else {
                    optionStateEnum = UI_GameOption.OptionStateEnum.red;
                }
            } else if (DataGenerator.isTwoStringEquals(gameOptionObject.option_id, gameAnswerObject.correct_option_key)) {
                optionStateEnum = UI_GameOption.OptionStateEnum.green;
            }
            if (i < size2) {
                try {
                    iIntValue = gameAnswerObject.options.get(gameOptionObject.option_id).intValue();
                } catch (Exception unused) {
                    iIntValue = 0;
                }
                this.uiGameOptions.get(i).setResult(iIntValue, iIntValue2, optionStateEnum, gameAnswerObject.hide_answer_count);
            }
        }
        if (this.questionLayout.getVisibility() != 0) {
            showQuestionViewSmallVideo();
        }
        if (this.linearLayoutOptions.getVisibility() != 0) {
            this.linearLayoutOptions.setVisibility(0);
        }
        this.ringProgressBar.setVisibility(8);
        this.textViewTimer.setText(BuildConfig.FLAVOR);
    }

    private void setComments() {
        this.isCommentTimerStarted = false;
        EditText editText = this.editTextComment;
        editText.setFilters(InputFilterHelper.getFilter(300, 3, editText));
        this.sendProgressBarContainer.setVisibility(4);
        this.compositeDisposable.add((Disposable) RxView.clicks(this.imageViewSendComment).subscribeWith(new DisposableObserver<Object>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.19
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                GameFragment.this.addMyCommentComment();
            }
        }));
        this.mainRecyclerView.setOnTouchListener(this.onRecyclerViewTouch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetComments() {
        DisposableObserver disposableObserver = this.getCommentRequestTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        this.isCommentTimerStarted = true;
        DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().gameGetComments(5, new GameGetCommentsInput(this.gameId, this.nextStartIdComment)).doOnNext(new Consumer<MessangerOutput<GameGetCommentsOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.21
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<GameGetCommentsOutput> messangerOutput) throws Exception {
                GameGetCommentsOutput gameGetCommentsOutput;
                if (messangerOutput == null || (gameGetCommentsOutput = messangerOutput.data) == null || gameGetCommentsOutput.comments == null) {
                    return;
                }
                ArrayList<GameCommentObject> arrayList = gameGetCommentsOutput.comments;
                if (gameGetCommentsOutput.next_start_id != null) {
                    GameFragment.this.nextStartIdComment = gameGetCommentsOutput.next_start_id;
                }
                if (arrayList.size() > 0) {
                    GameFragment.this.startAddCommentTimer(arrayList);
                }
            }
        }).delay(5L, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<MessangerOutput<GameGetCommentsOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.20
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GameGetCommentsOutput> messangerOutput) {
                GameFragment.this.callGetComments();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                GameFragment.this.compositeDisposable.add((Disposable) Observable.just(1).delay(5L, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.20.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th2) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        GameFragment.this.callGetComments();
                    }
                }));
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                dispose();
            }
        });
        this.getCommentRequestTimer = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddCommentTimer(final ArrayList<GameCommentObject> arrayList) {
        DisposableObserver disposableObserver = this.addCommentTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) Observable.interval(20L, 1000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.22
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                int iLongValue = (int) l.longValue();
                if (iLongValue < arrayList.size()) {
                    GameCommentObject gameCommentObject = (GameCommentObject) arrayList.get(iLongValue);
                    if (GameFragment.this.myComments != null) {
                        if (GameFragment.this.myComments.get(gameCommentObject.comment_id) == null) {
                            GameFragment.this.addComment(gameCommentObject);
                            return;
                        }
                        return;
                    }
                    GameFragment.this.addComment(gameCommentObject);
                    return;
                }
                dispose();
            }
        });
        this.addCommentTimer = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addComment(GameCommentObject gameCommentObject) {
        GameCommentObject gameCommentObject2;
        GameCommentPresenter.MyViewHolder myViewHolder;
        boolean z = true;
        if (this.mainArrayList.size() > 1000) {
            ArrayList<PresenterItem> arrayList = this.mainArrayList;
            arrayList.remove(arrayList.size() - 1);
            this.mainAdapter.notifyItemRemoved(this.mainArrayList.size());
        }
        try {
            gameCommentObject2 = (GameCommentObject) this.mainArrayList.get(0);
        } catch (Exception unused) {
            gameCommentObject2 = null;
        }
        if (gameCommentObject2 != null) {
            for (int i = 0; i < this.mainRecyclerView.getChildCount(); i++) {
                try {
                    myViewHolder = (GameCommentPresenter.MyViewHolder) this.mainRecyclerView.getChildAt(i).getTag();
                } catch (Exception unused2) {
                    myViewHolder = null;
                }
                if (myViewHolder != null && myViewHolder.item == gameCommentObject2) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (gameCommentObject != null) {
            this.mainArrayList.add(0, gameCommentObject);
            this.mainAdapter.notifyItemInserted(0);
        } else if (MyLog.isDebugAble) {
            MyLog.handleException(new Exception("ExceptionComment"));
        }
        if (z) {
            try {
                this.mainRecyclerView.scrollToPosition(0);
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GameQuestionInfo getQuestionInfo(String str) {
        if (str == null || str.isEmpty()) {
            return new GameQuestionInfo();
        }
        GameQuestionInfo gameQuestionInfo = this.questionInfoMap.get(str);
        if (gameQuestionInfo != null) {
            return gameQuestionInfo;
        }
        GameQuestionInfo gameQuestionInfo2 = new GameQuestionInfo();
        this.questionInfoMap.put(this.currentQuestion.question_id, gameQuestionInfo2);
        return gameQuestionInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSendAnswer(final String str) {
        final String str2 = this.currentQuestion.question_id;
        GameQuestionInfo questionInfo = getQuestionInfo(str2);
        questionInfo.isSendAnswerRequesting = true;
        questionInfo.requestingSelectingId = str;
        updateViewByState();
        Disposable disposable = (Disposable) getApiRequestMessangerRx().gameSendAnswer(new GameSendAnswerInput(this.currentQuestion.question_id, str, this.gameId)).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GameSendAnswerOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.23
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GameSendAnswerOutput> messangerOutput) {
                MyLog.e("GameFragment", "send answer on next");
                if (messangerOutput.data != null) {
                    GameQuestionInfo questionInfo2 = GameFragment.this.getQuestionInfo(str2);
                    GameSendAnswerOutput gameSendAnswerOutput = messangerOutput.data;
                    if (gameSendAnswerOutput.state == GameSendAnswerOutput.StateEnum.IsAllowed || gameSendAnswerOutput.state == GameSendAnswerOutput.StateEnum.AnsweredBefore) {
                        MyLog.e("GameFragment", "send answer on next Allowed");
                        questionInfo2.nextLevel = messangerOutput.data.next_level;
                        questionInfo2.selectedId = str;
                    } else if (gameSendAnswerOutput.state == GameSendAnswerOutput.StateEnum.NotAllowed) {
                        ToastiLikeSnack.showMessageLikeToastLong("اجازه پاسخ دادن به سوال ندارید");
                        GameFragment.this.isKnowLost = true;
                        MyLog.e("GameFragment", "send answer on next notAllowed");
                    } else if (gameSendAnswerOutput.state == GameSendAnswerOutput.StateEnum.NotInTime) {
                        ToastiLikeSnack.showMessageLikeToastLong("زمان پاسخگویی به سوال به پایان رسیده");
                        GameFragment.this.getQuestionInfo(str2).isShowLostToast = true;
                        MyLog.e("GameFragment", "send answer on next NotInTime");
                    }
                }
                GameFragment.this.getQuestionInfo(str2).isSendAnswerRequesting = false;
                if (GameFragment.this.getQuestionInfo(str2).waitingForAnswerDisposable != null) {
                    GameFragment.this.getQuestionInfo(str2).waitingForAnswerDisposable.dispose();
                }
                GameFragment.this.checkAnswerAndSetLevel(str2);
                GameFragment.this.updateViewByState();
                dispose();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                GameFragment.this.getQuestionInfo(str2).isSendAnswerRequesting = false;
                if (GameFragment.this.getQuestionInfo(str2).waitingForAnswerDisposable != null) {
                    GameFragment.this.getQuestionInfo(str2).waitingForAnswerDisposable.dispose();
                    GameFragment.this.checkAnswerAndSetLevel(str2);
                }
                GameFragment.this.updateViewByState();
            }
        });
        questionInfo.requestSendAnswerDisposable = disposable;
        this.compositeDisposable.add(disposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAnswerAndSetLevel(String str) {
        GameQuestionInfo questionInfo = getQuestionInfo(str);
        String str2 = questionInfo.correctOptionId;
        if (str2 != null) {
            String str3 = questionInfo.selectedId;
            if (str3 != null && str3.equals(str2)) {
                if (this.currentLevel < getQuestionInfo(this.currentQuestion.question_id).nextLevel) {
                    this.currentLevel = getQuestionInfo(this.currentQuestion.question_id).nextLevel;
                }
                if (getQuestionInfo(this.currentQuestion.question_id).isShowCorrectToast) {
                    return;
                }
                getQuestionInfo(this.currentQuestion.question_id).isShowCorrectToast = true;
                ToastiLikeSnack.showMessageLikeToastLong("آفرین درسته!");
                return;
            }
            if (!this.isKnowLost && !getQuestionInfo(this.currentQuestion.question_id).isUsedChanceForThisQuestion) {
                this.isMaybeRecentlyLostAndCanUseRelive = true;
            }
            if (questionInfo.selectedId == null) {
                if (questionInfo.isOneTimeShowedQuestion) {
                    if (!questionInfo.isShowLostToast && !this.isKnowLost) {
                        if (questionInfo.requestingSelectingId != null) {
                            ToastiLikeSnack.showMessageLikeToastLong("پاسخ شما ارسال نشده است");
                        } else {
                            ToastiLikeSnack.showMessageLikeToastLong("هیچ پاسخی ندادی");
                        }
                        questionInfo.isShowLostToast = true;
                    }
                    if (!this.isKnowLost && !questionInfo.isDialogChanceShowed) {
                        getQuestionInfo(this.currentQuestion.question_id).isDialogChanceShowed = true;
                        showChanceDialogAfterLost();
                    }
                    if (questionInfo.requestingSelectingId != null || getQuestionInfo(this.currentQuestion.question_id).isUsedChanceForThisQuestion) {
                        return;
                    }
                    this.isKnowLost = true;
                    return;
                }
                return;
            }
            if (!this.isKnowLost && !questionInfo.isDialogChanceShowed) {
                getQuestionInfo(this.currentQuestion.question_id).isDialogChanceShowed = true;
                showChanceDialogAfterLost();
            }
            if (!getQuestionInfo(this.currentQuestion.question_id).isUsedChanceForThisQuestion) {
                this.isKnowLost = true;
            }
            if (getQuestionInfo(this.currentQuestion.question_id).isShowLostToast) {
                return;
            }
            ToastiLikeSnack.showMessageLikeToastLong("آخ آخ! غلطه!");
            getQuestionInfo(this.currentQuestion.question_id).isShowLostToast = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canUseChance() {
        return (this.currentQuestion == null || this.currentState.status == GameStateObject.GameStatusEnum.ShowQuestion || !this.isMaybeRecentlyLostAndCanUseRelive) ? false : true;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        DynamicFragment dynamicFragment = this.noGameFragment;
        if (dynamicFragment != null) {
            dynamicFragment.onPause();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        lockOrientationPortrait();
        DynamicFragment dynamicFragment = this.noGameFragment;
        if (dynamicFragment != null) {
            dynamicFragment.onResume();
        }
    }

    private void showChanceDialogAfterLost() {
        if (canUseChance()) {
            this.compositeDisposable.add((Disposable) Observable.timer(2L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.24
                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    GameFragment.this.showChanceView();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            }));
        } else {
            showLoseView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showChanceView() {
        if (!this.currentQuestion.allow_use_relive) {
            if (this.reliveChance > 0) {
                ToastiLikeSnack.showMessageLikeToastLong("توی این سوال نمیشه از جون استفاده کرد");
            }
        } else {
            if (this.reliveChance <= 0) {
                Link link = new Link();
                link.type = Link.LinkTypeEnum.alert;
                Link.AlertData alertData = new Link.AlertData();
                link.alert_data = alertData;
                alertData.has_link = false;
                alertData.message = "حیف!اگه جون داشتی میتونستی ادامه بدی!";
                return;
            }
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, "یه جون بده! مسابقه رو ادامه بده!");
            threeButtonDialog.button1.setText("بله");
            threeButtonDialog.button2.setText("خیر");
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final String str = GameFragment.this.currentQuestion.question_id;
                    GameFragment.this.compositeDisposable.add((Disposable) GameFragment.this.getApiRequestMessangerRx().gameUseReliveChance(new GameUseReliveChanceInput(GameFragment.this.gameId, GameFragment.this.currentQuestion.question_id)).subscribeWith(new DisposableObserver<MessangerOutput<GameUseReliveChanceOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.25.1
                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(MessangerOutput<GameUseReliveChanceOutput> messangerOutput) {
                            GameUseReliveChanceOutput gameUseReliveChanceOutput;
                            if (messangerOutput == null || (gameUseReliveChanceOutput = messangerOutput.data) == null) {
                                return;
                            }
                            GameUseReliveChanceOutput gameUseReliveChanceOutput2 = gameUseReliveChanceOutput;
                            if (gameUseReliveChanceOutput2.state == GameUseReliveChanceOutput.StateEnum.IsAllowed) {
                                GameFragment.this.currentLevel = gameUseReliveChanceOutput2.new_level;
                                GameFragment.this.reliveChance = gameUseReliveChanceOutput2.new_relive_chance;
                                GameFragment.this.getQuestionInfo(str).isUsedChanceForThisQuestion = true;
                                GameFragment.this.isKnowLost = false;
                                GameFragment.this.isMaybeRecentlyLostAndCanUseRelive = false;
                                GameFragment.this.textViewReliveCount.setText(NumberUtils.toPersian(GameFragment.this.reliveChance));
                                ToastiLikeSnack.showMessageLikeToastLong("ایول میتونی ادامه بدی");
                                return;
                            }
                            ToastiLikeSnack.showMessageLikeToastLong("شما اجازه استفاده از جون برای این مرحله را ندارید");
                        }

                        @Override // io.reactivex.Observer
                        public void onComplete() {
                            dispose();
                        }
                    }));
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.GameFragment.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMyCommentComment() {
        this.imageViewSendComment.setVisibility(8);
        this.sendProgressBarContainer.setVisibility(0);
        String string = this.editTextComment.getText().toString();
        String myUsername = getAppPreferences().getMyUsername();
        if (myUsername == null || myUsername.isEmpty()) {
            myUsername = "شما";
        }
        if (!string.isEmpty()) {
            this.mainArrayList.add(0, new GameCommentObject(myUsername, string, BuildConfig.FLAVOR));
            this.mainAdapter.notifyItemInserted(0);
            try {
                this.mainRecyclerView.scrollToPosition(0);
                AndroidUtilities.hideKeyboard(this.editTextComment);
            } catch (Exception unused) {
            }
            callAddComment(string);
        }
        this.editTextComment.setText(BuildConfig.FLAVOR);
        this.sendProgressBarContainer.setVisibility(4);
        this.imageViewSendComment.setVisibility(0);
    }

    private void callAddComment(String str) {
        if (System.currentTimeMillis() - this.lastTimeCommentApiCalled < 10000) {
            return;
        }
        this.lastTimeCommentApiCalled = System.currentTimeMillis();
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().gameAddComment(new GameAddCommentInput(str, this.gameId)).subscribeWith(new DisposableObserver<MessangerOutput<GameAddCommentOutput>>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.27
            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GameAddCommentOutput> messangerOutput) {
                GameAddCommentOutput gameAddCommentOutput;
                if (messangerOutput == null || (gameAddCommentOutput = messangerOutput.data) == null || gameAddCommentOutput.comment == null) {
                    return;
                }
                if (GameFragment.this.myComments == null) {
                    GameFragment.this.myComments = new HashMap();
                }
                HashMap map = GameFragment.this.myComments;
                GameAddCommentOutput gameAddCommentOutput2 = messangerOutput.data;
                map.put(gameAddCommentOutput2.comment.comment_id, gameAddCommentOutput2.comment);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                dispose();
            }
        }));
    }

    public void playStream() {
        String str = this.hostStreamUrl;
        if (str != null && !str.isEmpty()) {
            playStream(this.hostStreamUrl);
        } else {
            this.frameLayoutVideo.setVisibility(4);
            this.textViewTimer.setVisibility(0);
        }
    }

    public void playStream(String str) {
        if (this.isPlaying) {
            return;
        }
        if (str == null || str.isEmpty()) {
            stopPlayer();
            return;
        }
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        Context context = this.mContext;
        HlsMediaSource hlsMediaSourceCreateMediaSource = new HlsMediaSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context, "exoplayer2example"), defaultBandwidthMeter)).createMediaSource(Uri.parse(str));
        if (this.exoPlayer == null) {
            initExoPlayer();
        }
        stopPlayer();
        this.isPlaying = true;
        this.exoPlayer.setPlayWhenReady(true);
        this.exoPlayer.prepare(hlsMediaSourceCreateMediaSource);
    }

    public void stopPlayer() {
        this.isPlaying = false;
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
            this.exoPlayer.stop();
            this.exoPlayerView.setVisibility(4);
        }
    }

    public void stopAndReleasePlayer() {
        if (this.exoPlayer != null) {
            stopPlayer();
            this.exoPlayer.release();
            this.exoPlayer = null;
        }
    }

    private void initExoPlayer() {
        if (this.exoPlayer == null) {
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance(this.mContext, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        }
        this.exoPlayer.setPlayWhenReady(true);
        this.exoPlayerView.setVisibility(4);
        this.exoPlayerView.setPlayer(this.exoPlayer);
        this.exoPlayerView.setUseController(false);
        this.exoPlayerView.setResizeMode(4);
        this.exoPlayerView.setBackgroundColor(0);
        this.exoPlayer.addListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.28
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
                Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                onLoadingChanged(z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackStateChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPositionDiscontinuity(int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onRepeatModeChanged(int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onSeekProcessed() {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onShuffleModeEnabledChanged(boolean z) {
            }

            /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onLoadingChanged(boolean z) {
                if (z) {
                    MyLog.e("GameFragment", "loading");
                    GameFragment.this.loadingObserver = (DisposableObserver) Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>(this) { // from class: ir.resaneh1.iptv.fragment.GameFragment.28.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                        }
                    });
                } else {
                    MyLog.e("GameFragment", "loading false");
                    if (GameFragment.this.loadingObserver != null) {
                        GameFragment.this.loadingObserver.dispose();
                    }
                    GameFragment.this.progressVideo.setVisibility(4);
                }
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean z, int i) {
                if (i == 3) {
                    GameFragment.this.textViewTimer.setVisibility(8);
                    GameFragment.this.progressVideo.setVisibility(4);
                    GameFragment.this.exoPlayerView.setVisibility(0);
                } else if (i == 4) {
                    GameFragment.this.isPlaying = false;
                }
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                GameFragment.this.isPlaying = false;
                GameFragment.this.compositeDisposable.add((Disposable) Observable.timer(700L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.GameFragment.28.2
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Long l) {
                        GameFragment.this.playStream();
                    }
                }));
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        stopAndReleasePlayer();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        DynamicFragment dynamicFragment = this.noGameFragment;
        if (dynamicFragment != null) {
            dynamicFragment.onFragmentDestroy();
        }
        GameStateObject gameStateObject = this.currentState;
        if (gameStateObject == null || gameStateObject.status != GameStateObject.GameStatusEnum.NoGame) {
            getApiRequestMessangerRx().exitGame(new GameInput(this.gameId)).subscribe(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.fragment.GameFragment.29
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput messangerOutput) {
                }
            });
        }
    }

    public void setVideoSizeIfNeeded(boolean z) {
        if (z) {
            if (this.isVideoLayoutSmall) {
                return;
            }
            changeSize(this.frameLayoutVideo, true, this.frameLayoutMain);
        } else if (this.isVideoLayoutSmall) {
            changeSize(this.frameLayoutVideo, false, this.frameLayoutMain);
        }
    }

    private void changeSize(final View view, final boolean z, ViewGroup viewGroup) {
        if (this.newScene != null) {
            TransitionManager.endTransitions(viewGroup);
        }
        Scene scene = new Scene(viewGroup);
        this.newScene = scene;
        scene.setEnterAction(new Runnable() { // from class: ir.resaneh1.iptv.fragment.GameFragment.30
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (z) {
                    layoutParams.width = GameFragment.this.smallWidth;
                    layoutParams.height = GameFragment.this.smallHeight;
                    layoutParams.gravity = 1;
                    layoutParams.setMargins(0, AndroidUtilities.dp(32.0f), 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                view.setLayoutParams(layoutParams);
            }
        });
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.setInterpolator((TimeInterpolator) new LinearInterpolator());
        transitionSet.setDuration(300L);
        transitionSet.addListener(new Transition.TransitionListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.31
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                GameFragment.this.isVideoLayoutSmall = z;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                GameFragment.this.isVideoLayoutSmall = z;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                GameFragment.this.isVideoLayoutSmall = !z;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                GameFragment.this.isVideoLayoutSmall = !z;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                GameFragment.this.isVideoLayoutSmall = z;
            }
        });
        TransitionManager.go(this.newScene, transitionSet);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        GameStateObject gameStateObject;
        if (this.isFirstBack && (gameStateObject = this.currentState) != null && gameStateObject.status != GameStateObject.GameStatusEnum.NoGame) {
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, "آیا می خواهید از بازی خارج شوید؟");
            threeButtonDialog.button1.setText("تایید");
            threeButtonDialog.button2.setText("خیر");
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.GameFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                    if (ApplicationLoader.applicationActivity != null) {
                        GameFragment.this.isFirstBack = false;
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.GameFragment.33
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return false;
        }
        return super.onBackPressed();
    }
}
