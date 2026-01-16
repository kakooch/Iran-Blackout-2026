package ir.resaneh1.iptv.presenters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.utilites.ChatConverter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import ir.aaap.messengercore.model.ChatType;
import ir.appp.rghapp.Utils;
import ir.appp.rghapp.components.ContextProgressViewWithDelay;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.CustomProgressView;
import ir.resaneh1.iptv.UIView.UI_MP4PlayerView;
import ir.resaneh1.iptv.UIView.UI_StoryGLSurfaceView;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.fragment.StoryFragment;
import ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.CubeLayoutManager;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.ImageHelper;
import ir.resaneh1.iptv.helper.SendStoryHelper;
import ir.resaneh1.iptv.helper.StoriesProgressView;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.StoryUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.EmojiSliderObject;
import ir.resaneh1.iptv.model.InstaReportInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoStoryData;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryPollObject;
import ir.resaneh1.iptv.model.StoryPositionObject;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSticker;
import ir.resaneh1.iptv.story.poll.PollSticker;
import ir.resaneh1.iptv.story.poll.PollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class StoryPresenter extends AbstractPresenter<StoryListOfAProfileObject, MyViewHolder> {
    private final int CLICK_ACTION_THRESHOLD;
    View.OnClickListener OnSeenCountViewClick;
    View.OnClickListener OnSendMessageClick;
    int currentAccount;
    private boolean isCommentShowing;
    public boolean isLocal;
    private boolean isPausedForDialog;
    private boolean isRecyclerIdle;
    private boolean isScrollLock;
    private int lastSize;
    private final LockScrollListener lockScrollListener;
    Context mContext;
    private final GestureDetector mDetector;
    View.OnClickListener onCloseClickListener;
    View.OnClickListener onOptionClick;
    View.OnClickListener onReactionClick;
    View.OnClickListener onRetryOptionClick;
    View.OnClickListener onRetrySendClick;
    View.OnTouchListener onTouchListener;
    View.OnClickListener onUserClick;
    private ScrollListener scrollListener;
    private SeenClickListener seenClickListener;
    public StoryFragment storyFragment;
    public int topMarginPx;

    public interface LockScrollListener {
        void change(boolean z);
    }

    public interface ScrollListener {
        void onFlingUp(float f);

        void onScrollHorizontally(int i);

        void onScrollUp(float f);
    }

    public interface SeenClickListener {
        void onClick();
    }

    public double getReverseRotationAngle(double d) {
        double d2;
        double d3 = d % 360.0d;
        if (d3 >= 0.0d && d3 <= 90.0d) {
            return -d3;
        }
        if (d3 > 90.0d && d3 < 180.0d) {
            return -d3;
        }
        if (d3 >= 180.0d && d3 < 270.0d) {
            d2 = d3 - 180.0d;
        } else {
            if (d3 >= 270.0d && d3 <= 360.0d) {
                return 360.0d - d3;
            }
            if (d3 < 0.0d && d3 >= -90.0d) {
                return -d3;
            }
            if (d3 < -90.0d && d3 >= -180.0d) {
                return -d3;
            }
            if (d3 < -180.0d && d3 >= -270.0d) {
                return -d3;
            }
            if (d3 >= -270.0d || d3 < -360.0d) {
                return d3;
            }
            d2 = d3 + 360.0d;
        }
        return -d2;
    }

    public StoryPresenter(Context context, boolean z, LockScrollListener lockScrollListener) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(5.0f);
        this.isRecyclerIdle = true;
        this.topMarginPx = 0;
        this.isCommentShowing = false;
        this.onRetrySendClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    StoryPresenter.this.retry((MyViewHolder) view.getTag());
                }
            }
        };
        this.onRetryOptionClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                    ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    String string = LocaleController.getString(R.string.delete);
                    if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId() != null && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().isLocal) {
                        string = LocaleController.getString(R.string.cancelSending);
                    }
                    arrayList.add(string);
                    arrayList2.add(1);
                    arrayList.add(LocaleController.getString(R.string.retry));
                    arrayList2.add(2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(StoryPresenter.this.mContext);
                    StoryPresenter.this.isPausedForDialog = false;
                    builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (((Integer) arrayList2.get(i)).intValue() == 1) {
                                StoryController.getInstance(StoryPresenter.this.currentAccount).deleteStory(((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject(), ((StoryListOfAProfileObject) myViewHolder.item).highlightId);
                            } else if (((Integer) arrayList2.get(i)).intValue() == 2) {
                                StoryPresenter.this.retry(myViewHolder);
                            }
                        }
                    });
                    StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.2.2
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                        }
                    });
                    alertDialogCreate.show();
                }
            }
        };
        this.onCloseClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.getLastFragment().finishFragment();
                }
            }
        };
        this.OnSeenCountViewClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StoryPresenter.this.seenClickListener != null) {
                    StoryPresenter.this.seenClickListener.onClick();
                }
            }
        };
        this.OnSendMessageClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                if (myViewHolder != null) {
                    String strTrim = myViewHolder.editTextSendComment.getText().toString().trim();
                    if (strTrim.isEmpty()) {
                        return;
                    }
                    myViewHolder.textViewAlert.setText(LocaleController.getString("rubinoMessageSent", R.string.rubinoMessageSent));
                    StoryPresenter.this.sendComment(myViewHolder, strTrim);
                }
            }
        };
        this.onReactionClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                String string = ((TextView) view).getText().toString();
                if (System.currentTimeMillis() - myViewHolder.sendCommentLastTime > 1000) {
                    myViewHolder.sendCommentLastTime = System.currentTimeMillis();
                    myViewHolder.textViewAlert.setText(LocaleController.getString("rubinoMessageSent", R.string.rubinoMessageSent));
                    StoryPresenter.this.sendComment(myViewHolder, string);
                }
            }
        };
        this.onUserClick = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder;
                try {
                    myViewHolder = (MyViewHolder) view.getTag(R.id.viewTag2);
                } catch (Exception unused) {
                    myViewHolder = null;
                }
                if (myViewHolder == null) {
                    myViewHolder = (MyViewHolder) view.getTag();
                }
                if (myViewHolder != null) {
                    new MainClickHandler().onRubinoProfileClick(((StoryListOfAProfileObject) myViewHolder.item).profileObject);
                }
            }
        };
        this.onOptionClick = new AnonymousClass8();
        this.onTouchListener = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.14
            private int childCount;
            private float startX;
            private float startY;
            long pressTime = 0;
            boolean isEmojiSliderDown = false;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                StoryUtils.MyPoint xYInEmojiArea;
                StoryObject currentStoryObject;
                ArrayList<WidgetStoryObject> arrayList;
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                boolean zOnClick = false;
                if (!StoryPresenter.this.isRecyclerIdle) {
                    StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                    return false;
                }
                StoryPresenter.this.mDetector.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.isEmojiSliderDown = false;
                    StoryPresenter.this.isScrollLock = false;
                    ApplicationLoader.applicationActivity.getLastFragment().swipeDownEnabled = !StoryPresenter.this.isScrollLock;
                    this.startX = motionEvent.getX();
                    this.startY = motionEvent.getY();
                    this.pressTime = System.currentTimeMillis();
                    if (StoryPresenter.this.isRecyclerIdle) {
                        StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                        StoryPresenter.this.hideAndShowViewsOnTouch(myViewHolder, false);
                        if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() != null && myViewHolder.isWidgetAdded && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().hasClickableWidget()) {
                            StoryObject currentStoryObject2 = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
                            if (currentStoryObject2.emojiSliderWidget != null && myViewHolder.emojiSticker != null && (xYInEmojiArea = StoryPresenter.this.getXYInEmojiArea(this.startX, this.startY, currentStoryObject2.emojiSliderWidget.position, currentStoryObject2.w_h_ratio, true)) != null) {
                                boolean zOnTouch = myViewHolder.emojiSticker.onTouch(xYInEmojiArea.x, xYInEmojiArea.y, 0);
                                this.isEmojiSliderDown = zOnTouch;
                                StoryPresenter.this.isScrollLock = zOnTouch;
                                ApplicationLoader.applicationActivity.getLastFragment().swipeDownEnabled = !StoryPresenter.this.isScrollLock;
                            }
                        }
                    }
                    this.childCount = myViewHolder.clickView.getChildCount();
                    myViewHolder.clickView.removeAllViews();
                    StoryPresenter.this.lockScrollListener.change(true);
                    return true;
                }
                if (action != 1) {
                    if (action == 2) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        float fAbs = Math.abs(this.startX - x);
                        float fAbs2 = Math.abs(this.startY - y);
                        if (this.isEmojiSliderDown) {
                            StoryObject currentStoryObject3 = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
                            StoryUtils.MyPoint xYInEmojiArea2 = StoryPresenter.this.getXYInEmojiArea(motionEvent.getX(), motionEvent.getY(), currentStoryObject3.emojiSliderWidget.position, currentStoryObject3.w_h_ratio, false);
                            if (xYInEmojiArea2 != null) {
                                myViewHolder.emojiSticker.onTouch(xYInEmojiArea2.x, xYInEmojiArea2.y, 2);
                            }
                            return true;
                        }
                        if (fAbs > StoryPresenter.this.CLICK_ACTION_THRESHOLD && fAbs > fAbs2 && jCurrentTimeMillis - this.pressTime < 400) {
                            StoryPresenter.this.hideAndShowViewsOnTouch(myViewHolder, true);
                            StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                            StoryPresenter.this.lockScrollListener.change(false);
                        }
                        return false;
                    }
                    if (action != 3) {
                        if (StoryPresenter.this.isRecyclerIdle) {
                            StoryPresenter.this.hideAndShowViewsOnTouch(myViewHolder, true);
                            StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                        }
                        return false;
                    }
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                StoryPresenter.this.hideAndShowViewsOnTouch(myViewHolder, true);
                if (this.isEmojiSliderDown) {
                    StoryObject currentStoryObject4 = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
                    StoryUtils.MyPoint xYInEmojiArea3 = StoryPresenter.this.getXYInEmojiArea(x2, y2, currentStoryObject4.emojiSliderWidget.position, currentStoryObject4.w_h_ratio, false);
                    boolean zOnTouch2 = xYInEmojiArea3 != null ? myViewHolder.emojiSticker.onTouch(xYInEmojiArea3.x, xYInEmojiArea3.y, 1) : false;
                    StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                    this.isEmojiSliderDown = false;
                    StoryPresenter.this.isScrollLock = false;
                    ApplicationLoader.applicationActivity.getLastFragment().swipeDownEnabled = !StoryPresenter.this.isScrollLock;
                    zOnClick = zOnTouch2;
                }
                if (!zOnClick) {
                    if (StoryPresenter.this.isLessThanThreshold(this.startX, x2, this.startY, y2)) {
                        long j = this.pressTime;
                        if (jCurrentTimeMillis2 - j < 400 && jCurrentTimeMillis2 - j > 20) {
                            if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() != null && myViewHolder.isWidgetAdded && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().hasClickableWidget() && (arrayList = (currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject()).widget_story_list) != null) {
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    WidgetStoryObject widgetStoryObject = currentStoryObject.widget_story_list.get(size);
                                    StoryPositionObject storyPositionObject = widgetStoryObject.position;
                                    if (storyPositionObject != null && StoryPresenter.this.isPointInEntityArea(x2, y2, storyPositionObject, ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().w_h_ratio)) {
                                        WidgetStoryObject.WidgetTypeEnum widgetTypeEnum = widgetStoryObject.type;
                                        if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Hashtag && widgetStoryObject.hashtag != null) {
                                            StoryPresenter.this.addHashtagOrMentionOrPostClickView(myViewHolder, widgetStoryObject);
                                        } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Mention && widgetStoryObject.mention != null) {
                                            StoryPresenter.this.addHashtagOrMentionOrPostClickView(myViewHolder, widgetStoryObject);
                                        } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Post && widgetStoryObject.story_post != null) {
                                            StoryPresenter.this.addHashtagOrMentionOrPostClickView(myViewHolder, widgetStoryObject);
                                        } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Link && widgetStoryObject.story_link != null) {
                                            StoryPresenter.this.addHashtagOrMentionOrPostClickView(myViewHolder, widgetStoryObject);
                                        } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Poll && widgetStoryObject.poll != null) {
                                            StoryUtils.MyPoint xYInPollArea = StoryPresenter.this.getXYInPollArea(x2, y2, widgetStoryObject.position, currentStoryObject.w_h_ratio);
                                            if (xYInPollArea != null && myViewHolder.pollSticker != null) {
                                                zOnClick = myViewHolder.pollSticker.onClick(xYInPollArea.x, xYInPollArea.y);
                                            }
                                        } else if (widgetTypeEnum != WidgetStoryObject.WidgetTypeEnum.EmojiSlider || widgetStoryObject.emoji_slider == null) {
                                            ToastiLikeSnack.showL(((AbstractPresenter) StoryPresenter.this).context, LocaleController.getString(R.string.rubinoNotSupportedWidgetStory));
                                            StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                                            zOnClick = true;
                                        }
                                        zOnClick = true;
                                        break;
                                    }
                                }
                            }
                            if (this.childCount > 0) {
                                if (!zOnClick) {
                                    StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                                }
                                zOnClick = true;
                            }
                            if (!zOnClick) {
                                int width = myViewHolder.itemView.getWidth() / 2;
                                StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                                if (motionEvent.getX() > width) {
                                    StoryPresenter.this.updateProgress(myViewHolder, 1);
                                } else {
                                    StoryPresenter.this.updateProgress(myViewHolder, -1);
                                }
                            }
                            return true;
                        }
                    }
                    StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                }
                return zOnClick;
            }
        };
        this.mContext = context;
        this.mDetector = new GestureDetector(ApplicationLoader.applicationActivity, new MyGestureListener());
        int i = ApplicationLoader.applicationActivity.topCutoutHeight;
        this.lockScrollListener = lockScrollListener;
        this.isLocal = z;
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    public void setSeenClickListener(SeenClickListener seenClickListener) {
        this.seenClickListener = seenClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retry(MyViewHolder myViewHolder) {
        StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
        if (currentStoryObject == null || !currentStoryObject.isFailed) {
            return;
        }
        myViewHolder.retryFrameLayout.setVisibility(8);
        SendStoryHelper.getInstance(this.currentAccount).retrySendStory(currentStoryObject.rnd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendComment(MyViewHolder myViewHolder, String str) {
        StoryObject currentStoryObject;
        myViewHolder.editTextSendComment.setText(BuildConfig.FLAVOR);
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).info == null || (currentStoryObject = ((StoryListOfAProfileObject) titem).getCurrentStoryObject()) == null) {
            return;
        }
        Titem titem2 = myViewHolder.item;
        String str2 = ((StoryListOfAProfileObject) titem2).info.chat_object_guid;
        ChatType chatType = ((StoryListOfAProfileObject) titem2).info.chat_object_type;
        long dialogId = ChatConverter.getDialogId(str2, chatType);
        RubinoStoryData rubinoStoryData = new RubinoStoryData();
        rubinoStoryData.story_id = currentStoryObject.id;
        rubinoStoryData.story_profile_id = currentStoryObject.profile_id;
        rubinoStoryData.storyObject = currentStoryObject;
        rubinoStoryData.type = RubinoStoryData.Type.Reply;
        rubinoStoryData.reply_text = str;
        rubinoStoryData.profileObject = StoryController.getInstance(this.currentAccount).getInstantProfile(currentStoryObject.profile_id);
        rubinoStoryData.toType = chatType;
        TLRPC$TL_messageMediaRubinoStory tLRPC$TL_messageMediaRubinoStory = new TLRPC$TL_messageMediaRubinoStory();
        tLRPC$TL_messageMediaRubinoStory.rubinoStoryData = rubinoStoryData;
        SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$TL_messageMediaRubinoStory, dialogId, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        hideKeyboard(myViewHolder);
        startSendCommentAlertAnimation(myViewHolder);
    }

    /* renamed from: ir.resaneh1.iptv.presenters.StoryPresenter$8, reason: invalid class name */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ApplicationLoader.applicationActivity != null) {
                final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId() != null && !((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().isLocal) {
                    arrayList.add(LocaleController.getString(R.string.ShareSendTo));
                    arrayList2.add(4);
                }
                if (((StoryListOfAProfileObject) myViewHolder.item).isMyStory()) {
                    arrayList.add(LocaleController.getString(R.string.setting));
                    arrayList2.add(3);
                    String string = LocaleController.getString(R.string.delete);
                    if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId() != null && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().isLocal) {
                        string = LocaleController.getString(R.string.cancelSending);
                    }
                    arrayList.add(string);
                    arrayList2.add(1);
                } else {
                    arrayList.add(LocaleController.getString(R.string.report));
                    arrayList2.add(2);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(StoryPresenter.this.mContext);
                StoryPresenter.this.isPausedForDialog = false;
                builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new AnonymousClass1(arrayList2, myViewHolder));
                StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.8.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (StoryPresenter.this.isPausedForDialog) {
                            return;
                        }
                        StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                    }
                });
                alertDialogCreate.show();
            }
        }

        /* renamed from: ir.resaneh1.iptv.presenters.StoryPresenter$8$1, reason: invalid class name */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            final /* synthetic */ MyViewHolder val$holder;
            final /* synthetic */ ArrayList val$options;

            AnonymousClass1(ArrayList arrayList, MyViewHolder myViewHolder) {
                this.val$options = arrayList;
                this.val$holder = myViewHolder;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (((Integer) this.val$options.get(i)).intValue() == 3) {
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new StorySettingsActivity(AppRubinoPreferences.getInstance(StoryPresenter.this.currentAccount).getInstaCurrentProfileObject()));
                        return;
                    }
                    return;
                }
                if (((Integer) this.val$options.get(i)).intValue() == 1) {
                    StoryController.getInstance(StoryPresenter.this.currentAccount).deleteStory(((StoryListOfAProfileObject) this.val$holder.item).getCurrentStoryObject(), ((StoryListOfAProfileObject) this.val$holder.item).highlightId);
                    return;
                }
                if (((Integer) this.val$options.get(i)).intValue() == 4) {
                    StoryPresenter.this.onDirectClicked((StoryListOfAProfileObject) this.val$holder.item);
                    StoryPresenter.this.pauseProgressAndVideo(this.val$holder);
                } else if (((Integer) this.val$options.get(i)).intValue() == 2) {
                    StoryPresenter.this.isPausedForDialog = true;
                    final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(((AbstractPresenter) StoryPresenter.this).context, "در صورتی که این استوری دارای محتوای نامناسب،غیراخلاقی و یا تبلیغاتی هست گزارش کنید");
                    threeButtonDialog.button1.setText("گزارش");
                    threeButtonDialog.button2.setText("انصراف");
                    threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.8.1.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            threeButtonDialog.dismiss();
                            StoryObject currentStoryObject = ((StoryListOfAProfileObject) AnonymousClass1.this.val$holder.item).getCurrentStoryObject();
                            if (currentStoryObject == null) {
                                return;
                            }
                            ApiRequestMessanger.getInstance(StoryPresenter.this.currentAccount).instaReportRecord(InstaReportInput.setForStory(currentStoryObject.id, currentStoryObject.profile_id), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.8.1.1.1
                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onError(MessangerOutput messangerOutput) {
                                }

                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onFailure(Call call, Throwable th) {
                                }

                                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                                public void onResponse(Call call, Object obj) {
                                    ToastiLikeSnack.showL(((AbstractPresenter) StoryPresenter.this).context, LocaleController.getString("ReportSent", R.string.ReportSent));
                                }
                            });
                        }
                    });
                    threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.8.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            threeButtonDialog.dismiss();
                        }
                    });
                    threeButtonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.8.1.3
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface2) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            StoryPresenter.this.resumeProgressAndVideo(anonymousClass1.val$holder);
                            StoryPresenter.this.isPausedForDialog = false;
                        }
                    });
                    threeButtonDialog.show();
                }
            }
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.story_layout, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(this, viewInflate);
        viewInflate.setTag(myViewHolder);
        ((TextView) viewInflate.findViewById(R.id.textViewSending)).setText(LocaleController.getString(R.string.sendingRequest));
        ((TextView) viewInflate.findViewById(R.id.textView)).setText(LocaleController.getString(R.string.WriteAMessage));
        if (Build.VERSION.SDK_INT >= 17) {
            myViewHolder.storiesProgressView.setLayoutDirection(0);
        }
        if (this.isLocal && Utils.useNewStoryCreationSystem()) {
            setGlView(myViewHolder);
        }
        myViewHolder.compositeDisposable = new CompositeDisposable();
        myViewHolder.textView1.setText(Emoji.replaceEmoji("😂", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView2.setText(Emoji.replaceEmoji("😮", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView3.setText(Emoji.replaceEmoji("😍", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView4.setText(Emoji.replaceEmoji("😢", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView5.setText(Emoji.replaceEmoji("👏", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView6.setText(Emoji.replaceEmoji("🔥", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView7.setText(Emoji.replaceEmoji("🎉", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView8.setText(Emoji.replaceEmoji("💯", Theme.chat_replyTextPaint.getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        myViewHolder.textView1.setTag(myViewHolder);
        myViewHolder.textView1.setOnClickListener(this.onReactionClick);
        myViewHolder.textView2.setTag(myViewHolder);
        myViewHolder.textView2.setOnClickListener(this.onReactionClick);
        myViewHolder.textView3.setTag(myViewHolder);
        myViewHolder.textView3.setOnClickListener(this.onReactionClick);
        myViewHolder.textView4.setTag(myViewHolder);
        myViewHolder.textView4.setOnClickListener(this.onReactionClick);
        myViewHolder.textView5.setTag(myViewHolder);
        myViewHolder.textView5.setOnClickListener(this.onReactionClick);
        myViewHolder.textView6.setTag(myViewHolder);
        myViewHolder.textView6.setOnClickListener(this.onReactionClick);
        myViewHolder.textView7.setTag(myViewHolder);
        myViewHolder.textView7.setOnClickListener(this.onReactionClick);
        myViewHolder.textView8.setTag(myViewHolder);
        myViewHolder.textView8.setOnClickListener(this.onReactionClick);
        myViewHolder.imageViewOption2.setTag(myViewHolder);
        myViewHolder.imageViewOption2.setOnClickListener(this.onOptionClick);
        myViewHolder.imageViewUser.setOnClickListener(this.onUserClick);
        myViewHolder.textViewName.setOnClickListener(this.onUserClick);
        myViewHolder.textViewName.setTag(myViewHolder);
        myViewHolder.imageViewUser.setTag(R.id.viewTag2, myViewHolder);
        myViewHolder.retryOptionImageView.setTag(myViewHolder);
        myViewHolder.retryOptionImageView.setOnClickListener(this.onRetryOptionClick);
        myViewHolder.retryFrameLayout.setTag(myViewHolder);
        myViewHolder.retryFrameLayout.setOnClickListener(this.onRetrySendClick);
        myViewHolder.imageViewClose.setOnClickListener(this.onCloseClickListener);
        myViewHolder.editTextSendComment.setImeOptions(6);
        myViewHolder.textViewSendComment.setTag(myViewHolder);
        myViewHolder.textViewSendComment.setOnClickListener(this.OnSendMessageClick);
        myViewHolder.frameLayoutSeen.setTag(myViewHolder);
        myViewHolder.frameLayoutSeen.setOnClickListener(this.OnSeenCountViewClick);
        myViewHolder.sizeNotifierFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.9
            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
            public void onSizeChanged(int i, boolean z) {
                Titem titem = myViewHolder.item;
                if ((titem == 0 || !((StoryListOfAProfileObject) titem).isMyStory()) && i != StoryPresenter.this.lastSize) {
                    StoryPresenter.this.lastSize = i;
                    if (i <= AndroidUtilities.getNavigationBarSize(((AbstractPresenter) StoryPresenter.this).context).y) {
                        StoryPresenter.this.hideAndShowSendCommentView(myViewHolder, false, false);
                        return;
                    }
                    AndroidUtilities.getAvailableHeight((Activity) StoryPresenter.this.mContext, i, DimensionHelper.isShowstoryNeedFullScreen());
                    AndroidUtilities.dp(200.0f);
                    int i2 = ((FrameLayout.LayoutParams) myViewHolder.frameLayoutSendComment.getLayoutParams()).topMargin;
                    StoryPresenter.this.hideAndShowSendCommentView(myViewHolder, true, false);
                }
            }
        });
        myViewHolder.frameLayoutCommentBottom.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryPresenter.this.hideAndShowSendCommentView(myViewHolder, true, true);
            }
        });
        myViewHolder.editTextSendComment.setHint(LocaleController.getString(R.string.WriteAMessage));
        myViewHolder.editTextSendComment.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    myViewHolder.frameLayoutReaction.setVisibility(0);
                } else {
                    myViewHolder.frameLayoutReaction.setVisibility(4);
                }
            }
        });
        myViewHolder.frameLayoutSendComment.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        myViewHolder.directButton.setTag(myViewHolder);
        myViewHolder.directButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateViewHolder$0(view);
            }
        });
        myViewHolder.highLightButton.setTag(myViewHolder);
        myViewHolder.highLightButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateViewHolder$1(view);
            }
        });
        myViewHolder.clickView.setTag(myViewHolder);
        myViewHolder.clickView.setOnTouchListener(this.onTouchListener);
        myViewHolder.storyContainer.getLayoutParams().width = DimensionHelper.getScreenMinDimension((Activity) this.context);
        myViewHolder.storyContainer.getLayoutParams().height = (int) (myViewHolder.storyContainer.getLayoutParams().width * DimensionHelper.getStoryHWRatio());
        int screenMaxDimension = DimensionHelper.getScreenMaxDimension((Activity) this.context) - myViewHolder.storyContainer.getLayoutParams().height;
        if (screenMaxDimension > AndroidUtilities.dp(64.0f)) {
            if (screenMaxDimension > AndroidUtilities.dp(100.0f)) {
                this.topMarginPx = AndroidUtilities.dp(24.0f);
                AndroidUtilities.dp(64.0f);
                ((FrameLayout.LayoutParams) myViewHolder.frameLayoutBottomContainer.getLayoutParams()).bottomMargin = (screenMaxDimension - AndroidUtilities.dp(64.0f)) - this.topMarginPx;
                ((FrameLayout.LayoutParams) myViewHolder.storyContainer.getLayoutParams()).topMargin = this.topMarginPx;
            } else {
                ((FrameLayout.LayoutParams) myViewHolder.frameLayoutBottomContainer.getLayoutParams()).bottomMargin = screenMaxDimension - AndroidUtilities.dp(64.0f);
            }
        }
        MainAdapter mainAdapter = (MainAdapter) ((RecyclerView) viewGroup).getAdapter();
        if (myViewHolder.parentLifecycle == null) {
            myViewHolder.setParentLifeCycleObservable(mainAdapter.getLifecycle());
        }
        setLifeCycleObserver2(myViewHolder);
        return myViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
        onDirectClicked((StoryListOfAProfileObject) ((MyViewHolder) view.getTag()).item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
        MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
        pauseProgressAndVideo(myViewHolder);
        onHighlightClicked(myViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDirectClicked(StoryListOfAProfileObject storyListOfAProfileObject) {
        RubinoController.getInstance(this.currentAccount).shareOrCopyStory(ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, storyListOfAProfileObject.getCurrentStoryObject());
    }

    private void onHighlightClicked(final MyViewHolder myViewHolder) {
        final StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
        if (currentStoryObject == null) {
            return;
        }
        HighlightBottomSheet highlightBottomSheet = new HighlightBottomSheet(this.currentAccount, this.context, currentStoryObject);
        highlightBottomSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$onHighlightClicked$2(myViewHolder, dialogInterface);
            }
        });
        highlightBottomSheet.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$onHighlightClicked$3(myViewHolder, dialogInterface);
            }
        });
        highlightBottomSheet.show();
        highlightBottomSheet.setDelegate(new HighlightBottomSheet.HighlightsDelegate() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.13
            @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet.HighlightsDelegate
            public void onHighlightSelected(Rubino.StoryHighlight storyHighlight) {
                if (storyHighlight != null) {
                    myViewHolder.compositeDisposable.add((Disposable) RubinoController.getInstance(StoryPresenter.this.currentAccount).highlightStoryObservable(storyHighlight, currentStoryObject.id).subscribeWith(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.13.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Integer num) {
                        }
                    }));
                }
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet.HighlightsDelegate
            public void onCreateNewHighlight(StoryObject storyObject, String str) {
                if (storyObject == null || TextUtils.isEmpty(str)) {
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(storyObject.id);
                Rubino.InputHighlightCover inputHighlightCover = new Rubino.InputHighlightCover(Rubino.InputHighlightCoverType.Story);
                inputHighlightCover.story_id = storyObject.id;
                myViewHolder.compositeDisposable.add((Disposable) RubinoController.getInstance(StoryPresenter.this.currentAccount).addHighlight(arrayList, str, inputHighlightCover).subscribeWith(new DisposableObserver<Rubino.AddHighlightOutput>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.13.2
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Rubino.AddHighlightOutput addHighlightOutput) {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        ToastiLikeSnack.showS(((AbstractPresenter) StoryPresenter.this).context, LocaleController.getString(R.string.conneciton_server_failed_message));
                    }
                }));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHighlightClicked$2(MyViewHolder myViewHolder, DialogInterface dialogInterface) {
        resumeProgressAndVideo(myViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHighlightClicked$3(MyViewHolder myViewHolder, DialogInterface dialogInterface) {
        resumeProgressAndVideo(myViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPointInEntityArea(float f, float f2, StoryPositionObject storyPositionObject, float f3) {
        RectF rectPx = storyPositionObject.getRectPx(this.mContext, f3);
        StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(f, f2);
        applyRotationIfNeeded(myPoint, storyPositionObject.rotation, storyPositionObject.getCenterXPx(this.mContext, f3), storyPositionObject.getCenterYPx(this.mContext, f3));
        return rectPx.contains(myPoint.x, myPoint.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StoryUtils.MyPoint getXYInPollArea(float f, float f2, StoryPositionObject storyPositionObject, float f3) {
        RectF rectPx = storyPositionObject.getRectPx(this.mContext, f3);
        StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(f, f2);
        applyRotationIfNeeded(myPoint, storyPositionObject.rotation, storyPositionObject.getCenterXPx(this.mContext, f3), storyPositionObject.getCenterYPx(this.mContext, f3));
        if (!rectPx.contains(myPoint.x, myPoint.y)) {
            return null;
        }
        myPoint.x -= rectPx.left;
        myPoint.y -= rectPx.top;
        PollSticker.PollStickerMode pollStickerMode = PollSticker.PollStickerMode.STORY;
        return new StoryUtils.MyPoint(myPoint.x * (PollSticker.getPollWidth(pollStickerMode) / storyPositionObject.getWidthPx(this.mContext, f3)), myPoint.y * (PollSticker.getPollHeight(pollStickerMode) / storyPositionObject.getHeightPx(this.mContext, f3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StoryUtils.MyPoint getXYInEmojiArea(float f, float f2, StoryPositionObject storyPositionObject, float f3, boolean z) {
        RectF rectPx = storyPositionObject.getRectPx(this.mContext, f3);
        StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint(f, f2);
        applyRotationIfNeeded(myPoint, storyPositionObject.rotation, storyPositionObject.getCenterXPx(this.mContext, f3), storyPositionObject.getCenterYPx(this.mContext, f3));
        if (!rectPx.contains(myPoint.x, myPoint.y) && z) {
            return null;
        }
        myPoint.x -= rectPx.left;
        myPoint.y -= rectPx.top;
        float viewWidth = EmojiSticker.getViewWidth() / storyPositionObject.getWidthPx(this.mContext, f3);
        return new StoryUtils.MyPoint(myPoint.x * viewWidth, myPoint.y * viewWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StoryUtils.MyPoint getRealXYOfEmoji(float f, float f2, StoryPositionObject storyPositionObject, float f3) {
        float widthPx = storyPositionObject.getWidthPx(this.mContext, f3) / EmojiSticker.getViewWidth();
        RectF rectPx = storyPositionObject.getRectPx(this.mContext, f3);
        StoryUtils.MyPoint myPoint = new StoryUtils.MyPoint((f * widthPx) + rectPx.left, (f2 * widthPx) + rectPx.top);
        float centerXPx = storyPositionObject.getCenterXPx(this.mContext, f3);
        float centerYPx = storyPositionObject.getCenterYPx(this.mContext, f3);
        double d = (float) ((storyPositionObject.rotation * 3.141592653589793d) / 180.0d);
        double d2 = myPoint.x - centerXPx;
        double d3 = myPoint.y - centerYPx;
        double dCos = Math.cos(d);
        Double.isNaN(d2);
        double dSin = Math.sin(d);
        Double.isNaN(d3);
        double d4 = (dCos * d2) - (dSin * d3);
        double dSin2 = Math.sin(d);
        Double.isNaN(d2);
        double dCos2 = Math.cos(d);
        Double.isNaN(d3);
        double d5 = (d2 * dSin2) + (d3 * dCos2);
        double d6 = centerXPx;
        Double.isNaN(d6);
        myPoint.x = (float) (d4 + d6);
        double d7 = centerYPx;
        Double.isNaN(d7);
        myPoint.y = (float) (d5 + d7);
        return myPoint;
    }

    private StoryUtils.MyPoint applyRotationIfNeeded(StoryUtils.MyPoint myPoint, double d, float f, float f2) {
        if (d == 0.0d) {
            return myPoint;
        }
        double reverseRotationAngle = (float) ((getReverseRotationAngle(d) * 3.141592653589793d) / 180.0d);
        double d2 = myPoint.x - f;
        double d3 = myPoint.y - f2;
        double dCos = Math.cos(reverseRotationAngle);
        Double.isNaN(d2);
        double dSin = Math.sin(reverseRotationAngle);
        Double.isNaN(d3);
        double d4 = (dCos * d2) - (dSin * d3);
        double dSin2 = Math.sin(reverseRotationAngle);
        Double.isNaN(d2);
        double dCos2 = Math.cos(reverseRotationAngle);
        Double.isNaN(d3);
        double d5 = (d2 * dSin2) + (d3 * dCos2);
        double d6 = f;
        Double.isNaN(d6);
        myPoint.x = (float) (d4 + d6);
        double d7 = f2;
        Double.isNaN(d7);
        myPoint.y = (float) (d5 + d7);
        return myPoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLink(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        new MainClickHandler().openUrl(str);
    }

    private void addPollView(final MyViewHolder myViewHolder, final StoryObject storyObject, final StoryPollObject storyPollObject, StoryPositionObject storyPositionObject) {
        if (storyObject == null || storyPollObject == null || storyPositionObject == null) {
            return;
        }
        final PollSticker pollSticker = null;
        WidgetStoryObject.StateEnum stateEnum = storyPollObject.state;
        if (stateEnum == WidgetStoryObject.StateEnum.Closed) {
            pollSticker = new PollSticker(this.mContext, PollSticker.PollStickerMode.SHARE);
            pollSticker.setPollLeftPercentage(storyPollObject.getLeftPercentage(), false, PollView.PollOption.NONE);
        } else if (storyPollObject.selection_index > 0) {
            pollSticker = new PollSticker(this.mContext, PollSticker.PollStickerMode.VOTED);
            PollView.PollOption pollOption = PollView.PollOption.NONE;
            int i = storyPollObject.selection_index;
            if (i == 1) {
                pollOption = PollView.PollOption.LEFT;
            } else if (i == 2) {
                pollOption = PollView.PollOption.RIGHT;
            }
            pollSticker.setPollLeftPercentage(storyPollObject.getLeftPercentage(), false, pollOption);
        } else if (stateEnum == WidgetStoryObject.StateEnum.Open) {
            pollSticker = new PollSticker(this.mContext, PollSticker.PollStickerMode.STORY);
            pollSticker.setPollClickListener(new PollView.PollClickListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.15
                @Override // ir.resaneh1.iptv.story.poll.PollView.PollClickListener
                public void onLeftClicked() {
                    storyPollObject.answerPoll(1);
                    pollSticker.setPollLeftPercentage(storyPollObject.getLeftPercentage(), true, PollView.PollOption.LEFT);
                    StoryController storyController = StoryController.getInstance(StoryPresenter.this.currentAccount);
                    StoryObject storyObject2 = storyObject;
                    storyController.addPollAnswer(storyObject2.id, storyObject2.profile_id, 1);
                }

                @Override // ir.resaneh1.iptv.story.poll.PollView.PollClickListener
                public void onRightClicked() {
                    storyPollObject.answerPoll(2);
                    pollSticker.setPollLeftPercentage(storyPollObject.getLeftPercentage(), true, PollView.PollOption.RIGHT);
                    StoryController storyController = StoryController.getInstance(StoryPresenter.this.currentAccount);
                    StoryObject storyObject2 = storyObject;
                    storyController.addPollAnswer(storyObject2.id, storyObject2.profile_id, 2);
                }

                @Override // ir.resaneh1.iptv.story.poll.PollView.PollClickListener
                public void onAnimationStart() {
                    StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
                }

                @Override // ir.resaneh1.iptv.story.poll.PollView.PollClickListener
                public void onAnimationFinished() {
                    StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                }
            });
        }
        if (pollSticker != null) {
            String str = storyPollObject.content;
            String str2 = BuildConfig.FLAVOR;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            ArrayList<String> arrayList = storyPollObject.choices_list;
            String str3 = (arrayList == null || arrayList.size() <= 0) ? BuildConfig.FLAVOR : storyPollObject.choices_list.get(0);
            ArrayList<String> arrayList2 = storyPollObject.choices_list;
            if (arrayList2 != null && arrayList2.size() > 1) {
                str2 = storyPollObject.choices_list.get(1);
            }
            pollSticker.setValues(str, str3, str2);
            int iDp = AndroidUtilities.dp(1.0f);
            RectF rectPx = storyPositionObject.getRectPx(this.mContext, storyObject.w_h_ratio);
            float widthPx = (int) storyPositionObject.getWidthPx(this.mContext, storyObject.w_h_ratio);
            float heightPx = (int) storyPositionObject.getHeightPx(this.mContext, storyObject.w_h_ratio);
            PollSticker.PollStickerMode pollStickerMode = PollSticker.PollStickerMode.STORY;
            float pollWidth = PollSticker.getPollWidth(pollStickerMode);
            float pollHeight = PollSticker.getPollHeight(pollStickerMode);
            int i2 = iDp * 2;
            float f = i2;
            pollSticker.setScaleX((widthPx + f) / pollWidth);
            pollSticker.setScaleY((f + heightPx) / pollHeight);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setClipToPadding(false);
            frameLayout.setClipChildren(false);
            frameLayout.addView(pollSticker, new FrameLayout.LayoutParams((int) pollWidth, (int) pollHeight, 17));
            frameLayout.setRotation((float) storyPositionObject.rotation);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(((int) widthPx) + i2, ((int) heightPx) + i2);
            layoutParams.topMargin = ((int) rectPx.top) - iDp;
            layoutParams.leftMargin = ((int) rectPx.left) - iDp;
            myViewHolder.pollSticker = pollSticker;
            myViewHolder.widgetContainer.addView(frameLayout, layoutParams);
        }
    }

    private float addEmojiSliderViewAndGetScale(final MyViewHolder myViewHolder, final StoryObject storyObject, EmojiSliderObject emojiSliderObject, final StoryPositionObject storyPositionObject) throws Resources.NotFoundException {
        if (storyObject != null && emojiSliderObject != null && storyPositionObject != null) {
            EmojiSeekbar.Delegate delegate = new EmojiSeekbar.Delegate() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.16
                @Override // ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar.Delegate
                public void onChangedProgress(float f) {
                    if (myViewHolder.emojiSticker == null || myViewHolder.emojiSticker.getEmojiMode() != EmojiSticker.EmojiMode.STORY) {
                        return;
                    }
                    myViewHolder.emojiSticker.setEmojiMode(EmojiSticker.EmojiMode.STORY_LOCK);
                    StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
                    EmojiSliderObject emojiSliderIfExist = currentStoryObject.getEmojiSliderIfExist();
                    if (emojiSliderIfExist != null) {
                        emojiSliderIfExist.answerEmojiSlider(f);
                        myViewHolder.emojiSticker.setValues(emojiSliderIfExist.emoji_char, emojiSliderIfExist.my_float_answer * 100.0f, emojiSliderIfExist.average_float_answer * 100.0f, emojiSliderIfExist.content);
                    }
                    StoryController.getInstance(StoryPresenter.this.currentAccount).addEmojiSliderAnswer(currentStoryObject.id, currentStoryObject.profile_id, f / 100.0f);
                }

                @Override // ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar.Delegate
                public Point realValueOfEventPosition(float f, float f2) {
                    StoryUtils.MyPoint realXYOfEmoji = StoryPresenter.this.getRealXYOfEmoji(f, f2, storyPositionObject, storyObject.w_h_ratio);
                    Point point = new Point();
                    point.x = (int) realXYOfEmoji.x;
                    point.y = (int) realXYOfEmoji.y;
                    return point;
                }
            };
            WidgetStoryObject.StateEnum stateEnum = emojiSliderObject.state;
            if (stateEnum != WidgetStoryObject.StateEnum.Closed && emojiSliderObject.my_float_answer <= 0.0f) {
                if (stateEnum == WidgetStoryObject.StateEnum.Open) {
                    myViewHolder.emojiSticker = new EmojiSticker(this.mContext, EmojiSticker.EmojiMode.STORY, delegate);
                    myViewHolder.emojiSticker.lockAddStoryMode(false);
                    myViewHolder.emojiSticker.setEmoji(emojiSliderObject.emoji_char);
                    myViewHolder.emojiSticker.setTitle(emojiSliderObject.content);
                }
            } else {
                myViewHolder.emojiSticker = new EmojiSticker(this.mContext, EmojiSticker.EmojiMode.STORY_LOCK, delegate);
                myViewHolder.emojiSticker.setValues(emojiSliderObject.emoji_char, emojiSliderObject.my_float_answer * 100.0f, emojiSliderObject.average_float_answer * 100.0f, emojiSliderObject.content);
            }
            EmojiSliderObject.ThemeEmojiSlider themeEmojiSlider = emojiSliderObject.theme;
            if (themeEmojiSlider != null) {
                if (themeEmojiSlider.text_color != null) {
                    myViewHolder.emojiSticker.setTextColor(emojiSliderObject.theme.text_color.getColor());
                }
                if (emojiSliderObject.theme.background_color != null) {
                    myViewHolder.emojiSticker.setBackGroundColor(emojiSliderObject.theme.background_color.getColor());
                }
                if (emojiSliderObject.theme.seekbar_background_color != null) {
                    myViewHolder.emojiSticker.setSeekBarBackgroundColor(emojiSliderObject.theme.seekbar_background_color.getColor());
                }
                EmojiSliderObject.ThemeEmojiSlider themeEmojiSlider2 = emojiSliderObject.theme;
                if (themeEmojiSlider2.seekbar_type != EmojiSliderObject.ThemeEmojiSlider.SeekbarTypeEnum.Gradient) {
                    if (themeEmojiSlider2.seekbar_progress_color != null) {
                        myViewHolder.emojiSticker.setSeekBarForegroundColor(false, emojiSliderObject.theme.seekbar_progress_color.getColor());
                    }
                } else {
                    myViewHolder.emojiSticker.setSeekBarForegroundColor(true, 0);
                }
            }
            if (myViewHolder.emojiSticker != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.circleCrop();
                requestOptions.placeholder(R.drawable.placeholder_avatar_man);
                String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().full_photo_url;
                if (str == null || str.isEmpty()) {
                    Bitmap bitmapDrawableToBitmap = ImageHelper.drawableToBitmap(this.mContext, R.drawable.placeholder_avatar_man);
                    if (!bitmapDrawableToBitmap.isRecycled()) {
                        myViewHolder.emojiSticker.setUserProfileImage(bitmapDrawableToBitmap);
                    }
                } else {
                    Glide.with(ApplicationLoader.applicationContext).asBitmap().apply((BaseRequestOptions<?>) requestOptions).load(str).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.17
                        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                        public void onLoadFailed(Drawable drawable) {
                        }

                        @Override // com.bumptech.glide.request.target.Target
                        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            if (myViewHolder.emojiSticker == null || bitmap.isRecycled()) {
                                return;
                            }
                            myViewHolder.emojiSticker.setUserProfileImage(bitmap);
                        }
                    });
                }
                RectF rectPx = storyPositionObject.getRectPx(this.mContext, storyObject.w_h_ratio);
                float widthPx = (int) storyPositionObject.getWidthPx(this.mContext, storyObject.w_h_ratio);
                float heightPx = (int) storyPositionObject.getHeightPx(this.mContext, storyObject.w_h_ratio);
                float viewWidth = EmojiSticker.getViewWidth();
                int iDp = AndroidUtilities.dp(1.0f);
                int i = iDp * 2;
                float f = (i + widthPx) / viewWidth;
                myViewHolder.emojiSticker.setScaleX(f);
                myViewHolder.emojiSticker.setScaleY(f);
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                frameLayout.setClipToPadding(false);
                frameLayout.setClipChildren(false);
                frameLayout.addView(myViewHolder.emojiSticker, new FrameLayout.LayoutParams(-2, -2, 17));
                frameLayout.setRotation((float) storyPositionObject.rotation);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(((int) widthPx) + i, ((int) heightPx) + iDp);
                layoutParams.topMargin = ((int) rectPx.top) - iDp;
                layoutParams.leftMargin = ((int) rectPx.left) - iDp;
                myViewHolder.widgetContainer.addView(frameLayout, layoutParams);
                return f;
            }
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x022c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addHashtagOrMentionOrPostClickView(final ir.resaneh1.iptv.presenters.StoryPresenter.MyViewHolder r25, final ir.resaneh1.iptv.model.WidgetStoryObject r26) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.presenters.StoryPresenter.addHashtagOrMentionOrPostClickView(ir.resaneh1.iptv.presenters.StoryPresenter$MyViewHolder, ir.resaneh1.iptv.model.WidgetStoryObject):void");
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final MyViewHolder myViewHolder, StoryListOfAProfileObject storyListOfAProfileObject) {
        boolean z;
        StoryListOfAProfileObject storyListOfAProfileObject2 = (StoryListOfAProfileObject) myViewHolder.item;
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null) {
            storyFragment.getCurrentStoryAndPreload(myViewHolder.getAdapterPosition());
            this.storyFragment.preLoadMedia(myViewHolder.getAdapterPosition());
        }
        super.onBindViewHolder((StoryPresenter) myViewHolder, (MyViewHolder) storyListOfAProfileObject);
        if (myViewHolder.uiStoryGLSurfaceView != null) {
            myViewHolder.uiStoryGLSurfaceView.onDestroy();
        }
        if (storyListOfAProfileObject2 != myViewHolder.item && myViewHolder.mp4PlayerView != null) {
            myViewHolder.mp4PlayerView.stopAndReleasePlayer();
            myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.init;
        }
        try {
            if (myViewHolder.targetView != null) {
                Glide.with(ApplicationLoader.applicationContext).clear(myViewHolder.targetView);
                myViewHolder.targetView = null;
                setImage(myViewHolder, null, R.color.black);
                myViewHolder.imageView.setVisibility(4);
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().setCustomKey("StoryPresenter4", "targetView Exception");
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        myViewHolder.isWidgetAdded = false;
        myViewHolder.isLastWidgetRemoved = false;
        myViewHolder.emojiSticker = null;
        myViewHolder.pollSticker = null;
        myViewHolder.textViewTime.setText(BuildConfig.FLAVOR);
        myViewHolder.sendCommentAlertView.setVisibility(8);
        myViewHolder.frameLayoutSeen.setVisibility(8);
        myViewHolder.highLightButton.setVisibility(8);
        myViewHolder.textViewSeenCount.setText("0");
        if (myViewHolder.frameLayoutGlContainer != null) {
            myViewHolder.frameLayoutGlContainer.setVisibility(4);
        }
        if (myViewHolder.disposableImage == null || myViewHolder.disposableImage.isDisposed()) {
            z = false;
        } else {
            myViewHolder.disposableImage.dispose();
            myViewHolder.disposableImage = null;
            z = true;
        }
        myViewHolder.clickView.removeAllViews();
        myViewHolder.imageViewOption2.setVisibility(4);
        myViewHolder.directButton.setVisibility(4);
        myViewHolder.sendLocalFrameLayout.setVisibility(4);
        myViewHolder.retryFrameLayout.setVisibility(4);
        myViewHolder.progressView.setVisibility(8);
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        if (myViewHolder.hideAnimation != null) {
            myViewHolder.hideAnimation.cancel();
        }
        if (myViewHolder.disposableHideViewsOnTouch != null) {
            myViewHolder.disposableHideViewsOnTouch.dispose();
        }
        if (storyListOfAProfileObject.profileObject != null) {
            myViewHolder.imageViewUser.setVisibility(0);
            myViewHolder.textViewName.setVisibility(0);
            myViewHolder.imageViewClose.setVisibility(0);
            GlideHelper.loadCircle(ApplicationLoader.applicationContext, myViewHolder.imageViewUser, storyListOfAProfileObject.profileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
            myViewHolder.textViewName.setText(storyListOfAProfileObject.profileObject.getUsername());
        } else {
            myViewHolder.imageViewUser.setVisibility(4);
            myViewHolder.textViewName.setVisibility(4);
            myViewHolder.textViewTime.setVisibility(4);
            myViewHolder.imageViewClose.setVisibility(4);
        }
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocalAndLoadIfNeeded = StoryController.getInstance(this.currentAccount).getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(storyListOfAProfileObject.profileObject, storyListOfAProfileObject.highlightId);
        storyListOfAProfileObject.info = instantProfileStoryIdsWithLocalAndLoadIfNeeded;
        if (instantProfileStoryIdsWithLocalAndLoadIfNeeded != null && instantProfileStoryIdsWithLocalAndLoadIfNeeded.storyIdsObject != null) {
            storyListOfAProfileObject.setCurrentBasedOnSeenForFirstTime();
            hideAndShowViewsOnTouch(myViewHolder, true);
            initProgress(myViewHolder);
            if (!((StoryListOfAProfileObject) myViewHolder.item).canReply() || myViewHolder.isForceToStopAsPreview) {
                myViewHolder.frameLayoutCommentBottom.setVisibility(8);
            } else {
                myViewHolder.frameLayoutCommentBottom.setVisibility(0);
            }
            final StoryObject currentStoryObject = storyListOfAProfileObject.getCurrentStoryObject();
            if (currentStoryObject != null) {
                if (((StoryListOfAProfileObject) myViewHolder.item).profileObject != null) {
                    myViewHolder.textViewTime.setVisibility(0);
                    myViewHolder.textViewTime.setText(storyListOfAProfileObject.getCurrentStoryObject().getCreatedTimeSpannable());
                } else {
                    myViewHolder.textViewTime.setText(BuildConfig.FLAVOR);
                    myViewHolder.textViewTime.setVisibility(4);
                }
                if (currentStoryObject.w_h_ratio > 0.0f) {
                    int screenMinDimension = (int) (DimensionHelper.getScreenMinDimension((Activity) this.mContext) / currentStoryObject.w_h_ratio);
                    if (myViewHolder.storyContainer.getLayoutParams().height != screenMinDimension) {
                        myViewHolder.storyContainer.getLayoutParams().height = screenMinDimension;
                    }
                }
                myViewHolder.imageViewOption2.setVisibility(0);
                if (currentStoryObject.isLocal) {
                    removeLastWidgetIfNeeded(myViewHolder);
                    stopProgressAndVideo(myViewHolder);
                    onBindGl(myViewHolder);
                    updateSendingState(myViewHolder);
                    myViewHolder.imageView.setVisibility(4);
                    if (myViewHolder.mp4PlayerView != null && myViewHolder.mp4PlayerView.exoPlayerView != null) {
                        myViewHolder.mp4PlayerView.exoPlayerView.setVisibility(4);
                    }
                } else {
                    myViewHolder.directButton.setVisibility(0);
                    if (myViewHolder.uiStoryGLSurfaceView != null) {
                        myViewHolder.uiStoryGLSurfaceView.onPause();
                        myViewHolder.frameLayoutGlContainer.setVisibility(4);
                    }
                    myViewHolder.imageView.setVisibility(0);
                    myViewHolder.disposableImage = (Disposable) Observable.timer((storyListOfAProfileObject2 != myViewHolder.item || z) ? 0 : ImageReceiver.DEFAULT_CROSSFADE_DURATION, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.19
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            StoryPresenter.this.setImage(myViewHolder, null, R.color.black);
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            dispose();
                        }

                        @Override // io.reactivex.Observer
                        public void onComplete() {
                            dispose();
                        }
                    });
                    myViewHolder.compositeDisposable.add(myViewHolder.disposableImage);
                    if (currentStoryObject.story_type == StoryObject.StoryTypeEnum.Picture) {
                        currentStoryObject.isProgressStoppedToLoad = true;
                        stopProgressAndVideo(myViewHolder);
                        try {
                            myViewHolder.targetView = (SimpleTarget) Glide.with(ApplicationLoader.applicationContext).asBitmap().apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.black)).load(currentStoryObject.full_file_url).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.20
                                @Override // com.bumptech.glide.request.target.Target
                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) throws Resources.NotFoundException {
                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                }

                                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) throws Resources.NotFoundException {
                                    if (myViewHolder.disposableImage != null) {
                                        myViewHolder.disposableImage.dispose();
                                    }
                                    StoryPresenter.this.setImage(myViewHolder, bitmap, R.color.black);
                                    StoryObject storyObject = currentStoryObject;
                                    storyObject.isProgressStoppedToLoad = false;
                                    if (storyObject.hasClickableWidget()) {
                                        StoryPresenter.this.addWidgets(myViewHolder, currentStoryObject);
                                    }
                                    int adapterPosition = myViewHolder.getAdapterPosition();
                                    StoryPresenter storyPresenter = StoryPresenter.this;
                                    if (adapterPosition == storyPresenter.storyFragment.currentSnapPosition && storyPresenter.isRecyclerIdle && !myViewHolder.isProgressStopedOnTouch) {
                                        StoryPresenter.this.setSeenStoryIfNeeded(myViewHolder, currentStoryObject);
                                        MyViewHolder myViewHolder2 = myViewHolder;
                                        myViewHolder2.storiesProgressView.startStories(((StoryListOfAProfileObject) myViewHolder2.item).current);
                                    }
                                }

                                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                                public void onLoadFailed(Drawable drawable) {
                                    if (myViewHolder.disposableImage != null) {
                                        myViewHolder.disposableImage.dispose();
                                    }
                                    StoryPresenter.this.setImage(myViewHolder, null, R.color.black);
                                    currentStoryObject.isProgressStoppedToLoad = false;
                                }
                            });
                        } catch (Exception e2) {
                            MyLog.e("messsage GlideException", "Glide" + e2.getMessage());
                            FirebaseCrashlytics.getInstance().recordException(e2);
                        }
                        if (myViewHolder.mp4PlayerView != null && myViewHolder.mp4PlayerView.exoPlayerView != null) {
                            myViewHolder.mp4PlayerView.exoPlayerView.setVisibility(4);
                        }
                    } else {
                        try {
                            myViewHolder.targetView = (SimpleTarget) Glide.with(ApplicationLoader.applicationContext).asBitmap().apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.black)).load(currentStoryObject.full_snapshot_url).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.21
                                @Override // com.bumptech.glide.request.target.Target
                                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) throws Resources.NotFoundException {
                                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                                }

                                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) throws Resources.NotFoundException {
                                    if (myViewHolder.disposableImage != null) {
                                        myViewHolder.disposableImage.dispose();
                                    }
                                    StoryPresenter.this.setImage(myViewHolder, bitmap, R.color.black);
                                    if (currentStoryObject.hasClickableWidget()) {
                                        StoryPresenter.this.addWidgets(myViewHolder, currentStoryObject);
                                    }
                                }

                                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                                public void onLoadFailed(Drawable drawable) {
                                    StoryPresenter.this.setImage(myViewHolder, null, R.color.black);
                                }
                            });
                        } catch (Exception unused) {
                        }
                        if (currentStoryObject.hasVideo()) {
                            currentStoryObject.isProgressStoppedToLoad = true;
                            subscribeToPlay(myViewHolder);
                        }
                    }
                }
                if (storyListOfAProfileObject.presenterPosition == this.storyFragment.currentSnapPosition) {
                    if (currentStoryObject.isLocal || !currentStoryObject.hasVideo()) {
                        if (!myViewHolder.isProgressStopedOnTouch && !currentStoryObject.isProgressStoppedToLoad) {
                            myViewHolder.storiesProgressView.startStories(storyListOfAProfileObject.current);
                        }
                    } else if (myViewHolder.mp4PlayerView != null && myViewHolder.mp4PlayerView.exoPlayer != null && myViewHolder.mp4PlayerView.exoPlayer.getPlayWhenReady() && myViewHolder.mp4PlayerView.exoPlayer.getPlaybackState() == 3 && !myViewHolder.isProgressStopedOnTouch) {
                        myViewHolder.storiesProgressView.startStories(storyListOfAProfileObject.current);
                    }
                }
            } else {
                removeLastWidgetIfNeeded(myViewHolder);
                setImage(myViewHolder, null, R.color.black);
                stopProgressAndVideo(myViewHolder);
                if (myViewHolder.mp4PlayerView != null && myViewHolder.mp4PlayerView.exoPlayerView != null) {
                    myViewHolder.mp4PlayerView.exoPlayerView.setVisibility(4);
                }
            }
        } else {
            removeLastWidgetIfNeeded(myViewHolder);
            myViewHolder.storiesProgressView.setVisibility(4);
            myViewHolder.frameLayoutCommentBottom.setVisibility(4);
            GlideHelper.load(ApplicationLoader.applicationContext, myViewHolder.imageView, null, R.color.black);
            if (myViewHolder.mp4PlayerView != null) {
                stopProgressAndVideo(myViewHolder);
                if (myViewHolder.mp4PlayerView.exoPlayerView != null) {
                    myViewHolder.mp4PlayerView.exoPlayerView.setVisibility(4);
                }
            }
        }
        if (myViewHolder.isForceToStopAsPreview) {
            setPreview(myViewHolder);
        }
        if (((StoryListOfAProfileObject) myViewHolder.item).isMyStory()) {
            myViewHolder.frameLayoutCommentBottom.setVisibility(8);
            if (((StoryListOfAProfileObject) myViewHolder.item).isSeenViewVisible()) {
                myViewHolder.frameLayoutSeen.setVisibility(0);
                myViewHolder.textViewSeenCount.setText(((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().getSeenCountString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImage(MyViewHolder myViewHolder, Bitmap bitmap, int i) {
        removeLastWidgetIfNeeded(myViewHolder);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("setImage ");
        sb.append(bitmap);
        sb.append(" ");
        sb.append(bitmap != null ? Boolean.valueOf(bitmap.isRecycled()) : BuildConfig.FLAVOR);
        firebaseCrashlytics.setCustomKey("StoryPresenter3", sb.toString());
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                myViewHolder.imageView.setImageBitmap(bitmap);
                return;
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
                return;
            }
        }
        myViewHolder.imageView.setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLastWidgetIfNeeded(MyViewHolder myViewHolder) {
        if (myViewHolder.isLastWidgetRemoved) {
            return;
        }
        myViewHolder.isLastWidgetRemoved = true;
        myViewHolder.widgetContainer.removeAllViews();
        myViewHolder.widgetContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWidgets(MyViewHolder myViewHolder, StoryObject storyObject) throws Resources.NotFoundException {
        EmojiSliderObject emojiSliderObject;
        StoryPollObject storyPollObject;
        if (myViewHolder == null || storyObject == null || myViewHolder.isWidgetAdded) {
            return;
        }
        myViewHolder.isLastWidgetRemoved = false;
        removeLastWidgetIfNeeded(myViewHolder);
        myViewHolder.isWidgetAdded = true;
        float fAddEmojiSliderViewAndGetScale = 0.0f;
        Iterator<WidgetStoryObject> it = storyObject.widget_story_list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            WidgetStoryObject next = it.next();
            WidgetStoryObject.WidgetTypeEnum widgetTypeEnum = next.type;
            if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.Poll && (storyPollObject = next.poll) != null) {
                addPollView(myViewHolder, storyObject, storyPollObject, next.position);
            } else if (widgetTypeEnum == WidgetStoryObject.WidgetTypeEnum.EmojiSlider && (emojiSliderObject = next.emoji_slider) != null) {
                fAddEmojiSliderViewAndGetScale = addEmojiSliderViewAndGetScale(myViewHolder, storyObject, emojiSliderObject, next.position);
                z = true;
            }
            z2 = true;
        }
        if (z) {
            addEmojiSliderExtraView(myViewHolder, fAddEmojiSliderViewAndGetScale);
        }
        if (z2) {
            myViewHolder.widgetContainer.setVisibility(0);
        }
    }

    private void addEmojiSliderExtraView(MyViewHolder myViewHolder, float f) {
        myViewHolder.emojiExtraView = new ExtraView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 51);
        myViewHolder.emojiSticker.setExtraView(myViewHolder.emojiExtraView);
        if (f > 0.0f) {
            myViewHolder.emojiExtraView.setEmojiParentScale(f);
        }
        myViewHolder.widgetContainer.addView(myViewHolder.emojiExtraView, layoutParams);
    }

    public void updateSendingState(MyViewHolder myViewHolder) {
        StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
        if (currentStoryObject != null && currentStoryObject.isLocal) {
            if (!currentStoryObject.isFailed) {
                StoryObject.SendingStateEnum sendingStateEnum = currentStoryObject.sendingState;
                if (sendingStateEnum == StoryObject.SendingStateEnum.init || sendingStateEnum == StoryObject.SendingStateEnum.saving || sendingStateEnum == StoryObject.SendingStateEnum.uploadThumbnail || sendingStateEnum == StoryObject.SendingStateEnum.uploadSnapShot || sendingStateEnum == StoryObject.SendingStateEnum.uploadingMainFile || sendingStateEnum == StoryObject.SendingStateEnum.addStoryInProgress) {
                    myViewHolder.sendLocalFrameLayout.setVisibility(0);
                    double progress = currentStoryObject.getProgress();
                    if (progress >= 0.0d) {
                        if (progress == 0.0d) {
                            myViewHolder.sendingProgress.setProgress(0);
                            return;
                        } else {
                            myViewHolder.sendingProgress.setProgressWithAnimation((int) (progress * 100.0d), 50);
                            return;
                        }
                    }
                    return;
                }
                myViewHolder.sendLocalFrameLayout.setVisibility(4);
                return;
            }
            myViewHolder.sendLocalFrameLayout.setVisibility(4);
            myViewHolder.imageViewOption2.setVisibility(4);
            myViewHolder.directButton.setVisibility(4);
            myViewHolder.retryFrameLayout.setVisibility(0);
            return;
        }
        myViewHolder.sendLocalFrameLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideKeyboard(MyViewHolder myViewHolder) {
        AndroidUtilities.hideKeyboard(myViewHolder.editTextSendComment);
    }

    public void setPreview(MyViewHolder myViewHolder) {
        if (myViewHolder.hideAnimation != null) {
            myViewHolder.hideAnimation.cancel();
        }
        myViewHolder.storiesProgressView.pause();
        myViewHolder.storiesProgressView.setVisibility(8);
        myViewHolder.imageViewUser.setVisibility(8);
        myViewHolder.textViewName.setVisibility(4);
        myViewHolder.textViewTime.setVisibility(4);
        myViewHolder.imageViewClose.setVisibility(4);
        myViewHolder.frameLayoutCommentBottom.setVisibility(8);
        myViewHolder.progressView.setVisibility(8);
        MyLog.e("StoryPresenter", " progressview 2 gone");
    }

    public void unSetPreview(MyViewHolder myViewHolder) {
        myViewHolder.storiesProgressView.resume();
        myViewHolder.storiesProgressView.setVisibility(0);
        myViewHolder.imageViewUser.setVisibility(0);
        myViewHolder.textViewName.setVisibility(0);
        myViewHolder.textViewTime.setVisibility(0);
        myViewHolder.imageViewClose.setVisibility(0);
        if (((StoryListOfAProfileObject) myViewHolder.item).canReply()) {
            myViewHolder.frameLayoutCommentBottom.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseProgressAndVideo(MyViewHolder myViewHolder) {
        StoriesProgressView storiesProgressView = myViewHolder.storiesProgressView;
        if (storiesProgressView != null) {
            storiesProgressView.pause();
        }
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        if (myViewHolder.uiStoryGLSurfaceView != null) {
            myViewHolder.uiStoryGLSurfaceView.onPause();
        }
        if (myViewHolder.mp4PlayerView != null) {
            myViewHolder.mp4PlayerView.pausePlayer();
        }
        myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.subscribedAndPause;
    }

    private void stopProgressAndVideo(MyViewHolder myViewHolder) {
        StoriesProgressView storiesProgressView = myViewHolder.storiesProgressView;
        if (storiesProgressView != null) {
            storiesProgressView.pause();
        }
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        if (myViewHolder.uiStoryGLSurfaceView != null) {
            myViewHolder.uiStoryGLSurfaceView.onPause();
        }
        if (myViewHolder.mp4PlayerView != null) {
            myViewHolder.mp4PlayerView.stopPlayer();
        }
        myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.subscribedAndPause;
    }

    public void resumeProgressAndVideo(MyViewHolder myViewHolder) {
        StoriesProgressView storiesProgressView;
        if (!myViewHolder.isProgressStopedOnTouch && !myViewHolder.isForceToStopAsPreview && myViewHolder.getAdapterPosition() == this.storyFragment.currentSnapPosition && this.isRecyclerIdle) {
            boolean z = false;
            if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() == null || !((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().isLocal) {
                if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() != null && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().hasVideo()) {
                    if (myViewHolder.mp4PlayerView == null || myViewHolder.mp4PlayerView.playingItemId != ((StoryListOfAProfileObject) myViewHolder.item).current || myViewHolder.mp4PlayerView.exoPlayer == null) {
                        play(myViewHolder);
                    } else {
                        myViewHolder.mp4PlayerView.resumePlayer();
                    }
                    z = true;
                }
            } else if (myViewHolder.uiStoryGLSurfaceView != null) {
                myViewHolder.uiStoryGLSurfaceView.onResume();
            }
            if (z || ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() == null || ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().isProgressStoppedToLoad || (storiesProgressView = myViewHolder.storiesProgressView) == null) {
                return;
            }
            storiesProgressView.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAndShowSendCommentView(MyViewHolder myViewHolder, boolean z, boolean z2) {
        RecyclerView recyclerView;
        this.isCommentShowing = z;
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null && (recyclerView = storyFragment.mainRecyclerView) != null) {
            CubeLayoutManager cubeLayoutManager = null;
            try {
                cubeLayoutManager = (CubeLayoutManager) recyclerView.getLayoutManager();
            } catch (Exception unused) {
            }
            if (cubeLayoutManager != null) {
                cubeLayoutManager.setScrollEnabled(!z);
            }
        }
        if (z) {
            pauseProgressAndVideo(myViewHolder);
            myViewHolder.editTextSendComment.setText(BuildConfig.FLAVOR);
            myViewHolder.frameLayoutSendCommentContainer.setVisibility(0);
            myViewHolder.frameLayoutCommentBottom.setVisibility(4);
            myViewHolder.imageViewOption2.setVisibility(4);
            myViewHolder.directButton.setVisibility(4);
            myViewHolder.editTextSendComment.setFocusable(true);
            myViewHolder.editTextSendComment.requestFocus();
            if (myViewHolder.clickView != null) {
                myViewHolder.clickView.removeAllViews();
            }
            if (z2) {
                openKeyboard(myViewHolder);
                return;
            }
            return;
        }
        resumeProgressAndVideo(myViewHolder);
        if (((StoryListOfAProfileObject) myViewHolder.item).canReply()) {
            myViewHolder.frameLayoutCommentBottom.setVisibility(0);
        }
        myViewHolder.imageViewOption2.setVisibility(0);
        myViewHolder.directButton.setVisibility(0);
        myViewHolder.frameLayoutSendCommentContainer.setVisibility(4);
        MyLog.e("frameLayoutSendCommentContainer", "frameLayoutSendCommentContainer Invisible");
        if (z2) {
            hideKeyboard(myViewHolder);
        }
    }

    private void openKeyboard(MyViewHolder myViewHolder) {
        AndroidUtilities.showKeyboard(myViewHolder.editTextSendComment);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<StoryListOfAProfileObject> {
        private final FrameLayout clickView;
        CompositeDisposable compositeDisposable;
        private final View directButton;
        private Disposable disposableHideViewsOnTouch;
        private Disposable disposableImage;
        private Disposable disposableLifeCycle2;
        private Disposable disposablePlay;
        private final EditText editTextSendComment;
        private ExtraView emojiExtraView;
        private EmojiSticker emojiSticker;
        private final FrameLayout frameLayoutBottomContainer;
        private final FrameLayout frameLayoutCommentBottom;
        private final FrameLayout frameLayoutGlContainer;
        private final FrameLayout frameLayoutLoadingContainer;
        private final FrameLayout frameLayoutReaction;
        private final FrameLayout frameLayoutSeen;
        private final FrameLayout frameLayoutSendComment;
        private final FrameLayout frameLayoutSendCommentContainer;
        private final FrameLayout frameLayoutVideoContainer;
        private AnimatorSet hashtagAnimation;
        public View headerShadowView;
        private AnimatorSet hideAnimation;
        private final ImageView highLightButton;
        public ImageView imageView;
        public ImageView imageViewClose;
        public ImageView imageViewOption2;
        public ImageView imageViewUser;
        public boolean isForceToStopAsPreview;
        public boolean isLastWidgetRemoved;
        private boolean isProgressStopedOnTouch;
        public boolean isWidgetAdded;
        private UI_MP4PlayerView mp4PlayerView;
        private BehaviorSubject<PresenterFragment.LifeCycleState> parentLifecycle;
        public ViewGroupCellPresenter.PlayStateEnum playState;
        private PollSticker pollSticker;
        private final ContextProgressViewWithDelay progressView;
        private final FrameLayout retryFrameLayout;
        private final ImageView retryOptionImageView;
        private AnimatorSet sendCommentAlertAnimation;
        private final View sendCommentAlertView;
        private long sendCommentLastTime;
        private final FrameLayout sendLocalFrameLayout;
        private final FrameLayout sendLocalLoadingContainer;
        private final CustomProgressView sendingProgress;
        private final SizeNotifierFrameLayout sizeNotifierFrameLayout;
        public StoriesProgressView storiesProgressView;
        private final FrameLayout storyContainer;
        private SimpleTarget<Bitmap> targetView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        public TextView textView5;
        public TextView textView6;
        public TextView textView7;
        public TextView textView8;
        private final TextView textViewAlert;
        public TextView textViewName;
        private final TextView textViewSeenCount;
        private final TextView textViewSendComment;
        public TextView textViewTime;
        private UI_StoryGLSurfaceView uiStoryGLSurfaceView;
        private final FrameLayout widgetContainer;

        public MyViewHolder(StoryPresenter storyPresenter, View view) {
            super(view);
            this.playState = ViewGroupCellPresenter.PlayStateEnum.init;
            this.sizeNotifierFrameLayout = (SizeNotifierFrameLayout) view;
            this.textViewAlert = (TextView) view.findViewById(R.id.textViewAlert);
            this.sendCommentAlertView = view.findViewById(R.id.sendCommentAlertView);
            this.textViewSendComment = (TextView) view.findViewById(R.id.textViewSendComment);
            this.textViewSeenCount = (TextView) view.findViewById(R.id.textViewSeenCount);
            this.frameLayoutSeen = (FrameLayout) view.findViewById(R.id.frameLayoutSeen);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.imageViewUser = (ImageView) view.findViewById(R.id.imageViewUser);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
            this.textViewTime = (TextView) view.findViewById(R.id.textViewTime);
            this.headerShadowView = view.findViewById(R.id.headerShadow);
            this.imageView.setBackgroundColor(((AbstractPresenter) storyPresenter).context.getResources().getColor(R.color.black));
            this.imageViewClose = (ImageView) view.findViewById(R.id.imageViewClose);
            this.clickView = (FrameLayout) view.findViewById(R.id.clickView);
            this.frameLayoutCommentBottom = (FrameLayout) view.findViewById(R.id.frameLayoutCommentBottom);
            this.frameLayoutSendCommentContainer = (FrameLayout) view.findViewById(R.id.frameLayoutSendCommentContainer);
            this.frameLayoutSendComment = (FrameLayout) view.findViewById(R.id.frameLayoutSendComment);
            this.directButton = view.findViewById(R.id.directButton);
            this.highLightButton = (ImageView) view.findViewById(R.id.highlightButton);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frameLayoutLoadingContainer);
            this.frameLayoutLoadingContainer = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.sendLocalLoadingContainer);
            this.sendLocalLoadingContainer = frameLayout2;
            this.retryFrameLayout = (FrameLayout) view.findViewById(R.id.retryFrameLayout);
            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.sendLocalFrameLayout);
            this.sendLocalFrameLayout = frameLayout3;
            this.editTextSendComment = (EditText) view.findViewById(R.id.editText);
            this.storiesProgressView = (StoriesProgressView) view.findViewById(R.id.progressView);
            this.frameLayoutReaction = (FrameLayout) view.findViewById(R.id.frameLayoutReaction);
            this.frameLayoutVideoContainer = (FrameLayout) view.findViewById(R.id.frameLayoutVideoContainer);
            FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.frameLayoutGlContainer);
            this.frameLayoutGlContainer = frameLayout4;
            this.retryOptionImageView = (ImageView) view.findViewById(R.id.retryOptionImageView);
            this.frameLayoutBottomContainer = (FrameLayout) view.findViewById(R.id.frameLayoutBottomContainer);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.textView4 = (TextView) view.findViewById(R.id.textView4);
            this.textView5 = (TextView) view.findViewById(R.id.textView5);
            this.textView6 = (TextView) view.findViewById(R.id.textView6);
            this.textView7 = (TextView) view.findViewById(R.id.textView7);
            this.textView8 = (TextView) view.findViewById(R.id.textView8);
            this.imageViewOption2 = (ImageView) view.findViewById(R.id.imageViewOption2);
            this.storyContainer = (FrameLayout) view.findViewById(R.id.storyContainer);
            this.widgetContainer = (FrameLayout) view.findViewById(R.id.widgetContainer);
            frameLayout4.getLayoutParams().width = (int) DimensionHelper.getStoryViewWidthPx((Activity) storyPresenter.mContext);
            frameLayout4.getLayoutParams().height = (int) DimensionHelper.getStoryViewHeightPx((Activity) storyPresenter.mContext);
            ContextProgressViewWithDelay contextProgressViewWithDelay = new ContextProgressViewWithDelay(((AbstractPresenter) storyPresenter).context, 3);
            this.progressView = contextProgressViewWithDelay;
            frameLayout.addView(contextProgressViewWithDelay, LayoutHelper.createFrame(-1, -1.0f));
            frameLayout3.setVisibility(4);
            this.sendingProgress = UIProgressBarNewStyle.addStoryProgressBar((Activity) storyPresenter.mContext, frameLayout2, 24, R.color.white, R.color.white);
        }

        public void setParentLifeCycleObservable(BehaviorSubject<PresenterFragment.LifeCycleState> behaviorSubject) {
            this.parentLifecycle = behaviorSubject;
        }
    }

    public void hideAndShowViewsOnTouch(final MyViewHolder myViewHolder, final boolean z) {
        if (myViewHolder.disposableHideViewsOnTouch != null) {
            myViewHolder.disposableHideViewsOnTouch.dispose();
        }
        myViewHolder.isProgressStopedOnTouch = !z;
        if (!z) {
            myViewHolder.disposableHideViewsOnTouch = (Disposable) Observable.timer(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.22
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (StoryPresenter.this.isRecyclerIdle) {
                        StoryPresenter.this.startHideAnimation(myViewHolder, z);
                    }
                }
            });
            myViewHolder.compositeDisposable.add(myViewHolder.disposableHideViewsOnTouch);
        } else {
            startHideAnimation(myViewHolder, z);
        }
    }

    public void startHideAnimation(final MyViewHolder myViewHolder, final boolean z) {
        if (myViewHolder.hideAnimation != null) {
            myViewHolder.hideAnimation.cancel();
        }
        myViewHolder.hideAnimation = new AnimatorSet();
        if (z) {
            if (!myViewHolder.isForceToStopAsPreview) {
                myViewHolder.textViewName.setVisibility(0);
                myViewHolder.textViewTime.setVisibility(0);
                myViewHolder.imageViewClose.setVisibility(0);
                myViewHolder.imageViewUser.setVisibility(0);
            }
            if (((StoryListOfAProfileObject) myViewHolder.item).isSeenViewVisible()) {
                myViewHolder.highLightButton.setVisibility(0);
                myViewHolder.frameLayoutSeen.setVisibility(0);
            }
            Titem titem = myViewHolder.item;
            if (titem != 0 && ((StoryListOfAProfileObject) titem).canReply() && !myViewHolder.isForceToStopAsPreview) {
                if (myViewHolder.frameLayoutSendCommentContainer.getVisibility() != 0) {
                    myViewHolder.frameLayoutCommentBottom.setVisibility(0);
                    myViewHolder.imageViewOption2.setVisibility(0);
                }
                myViewHolder.hideAnimation.playTogether(ObjectAnimator.ofFloat(myViewHolder.frameLayoutCommentBottom, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewOption2, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.directButton, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.textViewName, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.textViewTime, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewClose, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewUser, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.storiesProgressView, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.headerShadowView, "alpha", 1.0f));
            } else {
                myViewHolder.imageViewOption2.setVisibility(0);
                if (((StoryListOfAProfileObject) myViewHolder.item).isSeenViewVisible()) {
                    myViewHolder.frameLayoutSeen.setVisibility(0);
                    myViewHolder.highLightButton.setVisibility(0);
                    myViewHolder.hideAnimation.playTogether(ObjectAnimator.ofFloat(myViewHolder.frameLayoutSeen, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.highLightButton, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.textViewName, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.textViewTime, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewOption2, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.directButton, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewClose, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewUser, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.headerShadowView, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.storiesProgressView, "alpha", 1.0f));
                } else {
                    myViewHolder.frameLayoutSeen.setVisibility(4);
                    myViewHolder.highLightButton.setVisibility(8);
                    myViewHolder.hideAnimation.playTogether(ObjectAnimator.ofFloat(myViewHolder.textViewName, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.textViewTime, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewOption2, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.directButton, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewClose, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewUser, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.headerShadowView, "alpha", 1.0f), ObjectAnimator.ofFloat(myViewHolder.storiesProgressView, "alpha", 1.0f));
                }
            }
        } else {
            myViewHolder.hideAnimation.playTogether(ObjectAnimator.ofFloat(myViewHolder.frameLayoutSeen, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.highLightButton, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.frameLayoutCommentBottom, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewOption2, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.directButton, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.textViewName, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.textViewTime, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewClose, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.imageViewUser, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.storiesProgressView, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.headerShadowView, "alpha", 0.0f), ObjectAnimator.ofFloat(myViewHolder.progressView, "alpha", 0.0f));
        }
        myViewHolder.hideAnimation.addListener(new AnimatorListenerAdapter(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.23
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (myViewHolder.hideAnimation == null || !myViewHolder.hideAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    myViewHolder.frameLayoutSeen.setVisibility(4);
                    myViewHolder.highLightButton.setVisibility(8);
                    myViewHolder.frameLayoutCommentBottom.setVisibility(4);
                    myViewHolder.textViewName.setVisibility(4);
                    myViewHolder.textViewTime.setVisibility(4);
                    myViewHolder.imageViewClose.setVisibility(4);
                    myViewHolder.imageViewUser.setVisibility(4);
                    myViewHolder.storiesProgressView.setAlpha(0.0f);
                    myViewHolder.progressView.setVisibility(4);
                    MyLog.e("StoryPresenter", " progressview 3 INVISIBLE");
                    return;
                }
                MyViewHolder myViewHolder2 = myViewHolder;
                if (myViewHolder2.isForceToStopAsPreview) {
                    return;
                }
                Titem titem2 = myViewHolder2.item;
                if (titem2 != 0 && ((StoryListOfAProfileObject) titem2).canReply() && myViewHolder.frameLayoutSendCommentContainer.getVisibility() != 0) {
                    myViewHolder.frameLayoutCommentBottom.setVisibility(0);
                    myViewHolder.imageViewOption2.setVisibility(0);
                }
                if (((StoryListOfAProfileObject) myViewHolder.item).isSeenViewVisible()) {
                    myViewHolder.frameLayoutSeen.setVisibility(0);
                    myViewHolder.highLightButton.setVisibility(0);
                }
                myViewHolder.imageViewOption2.setVisibility(0);
                myViewHolder.imageViewOption2.setAlpha(1.0f);
                myViewHolder.textViewName.setVisibility(0);
                myViewHolder.textViewName.setAlpha(1.0f);
                myViewHolder.textViewTime.setVisibility(0);
                myViewHolder.textViewTime.setAlpha(1.0f);
                myViewHolder.imageViewClose.setVisibility(0);
                myViewHolder.imageViewClose.setAlpha(1.0f);
                myViewHolder.imageViewUser.setVisibility(0);
                myViewHolder.imageViewUser.setAlpha(1.0f);
                myViewHolder.storiesProgressView.setAlpha(1.0f);
                myViewHolder.progressView.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (myViewHolder.hideAnimation == null || !myViewHolder.hideAnimation.equals(animator)) {
                    return;
                }
                myViewHolder.hideAnimation = null;
            }
        });
        if (z) {
            myViewHolder.hideAnimation.setDuration(200L);
        } else {
            myViewHolder.hideAnimation.setDuration(300L);
        }
        myViewHolder.hideAnimation.start();
    }

    private void startHashtagAnimation(final MyViewHolder myViewHolder, View view, int i, int i2) {
        if (myViewHolder.hashtagAnimation != null) {
            myViewHolder.hashtagAnimation.cancel();
        }
        if (myViewHolder.isForceToStopAsPreview) {
            return;
        }
        myViewHolder.hashtagAnimation = new AnimatorSet();
        myViewHolder.hashtagAnimation.setInterpolator(new AccelerateInterpolator());
        view.setVisibility(0);
        view.setPivotX(i);
        view.setPivotY(i2);
        myViewHolder.hashtagAnimation.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "scaleX", 0.4f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 0.4f, 1.0f));
        myViewHolder.hashtagAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.24
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (myViewHolder.hashtagAnimation == null || !myViewHolder.hashtagAnimation.equals(animator)) {
                    return;
                }
                StoryPresenter.this.pauseProgressAndVideo(myViewHolder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (myViewHolder.hashtagAnimation != null) {
                    myViewHolder.hashtagAnimation.equals(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (myViewHolder.hashtagAnimation == null || !myViewHolder.hashtagAnimation.equals(animator)) {
                    return;
                }
                myViewHolder.hashtagAnimation = null;
                StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
            }
        });
        myViewHolder.hashtagAnimation.setDuration(100L);
        myViewHolder.hashtagAnimation.start();
    }

    private void startSendCommentAlertAnimation(final MyViewHolder myViewHolder) {
        if (myViewHolder.sendCommentAlertAnimation != null) {
            myViewHolder.sendCommentAlertAnimation.cancel();
        }
        if (myViewHolder.isForceToStopAsPreview) {
            return;
        }
        myViewHolder.sendCommentAlertAnimation = new AnimatorSet();
        myViewHolder.sendCommentAlertAnimation.setInterpolator(new AccelerateInterpolator());
        myViewHolder.sendCommentAlertView.setVisibility(0);
        myViewHolder.sendCommentAlertAnimation.playTogether(ObjectAnimator.ofFloat(myViewHolder.sendCommentAlertView, "alpha", 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f));
        myViewHolder.sendCommentAlertAnimation.addListener(new AnimatorListenerAdapter(this) { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.25
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (myViewHolder.sendCommentAlertAnimation != null) {
                    myViewHolder.sendCommentAlertAnimation.equals(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (myViewHolder.sendCommentAlertAnimation == null || !myViewHolder.sendCommentAlertAnimation.equals(animator)) {
                    return;
                }
                myViewHolder.sendCommentAlertView.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (myViewHolder.sendCommentAlertAnimation == null || !myViewHolder.sendCommentAlertAnimation.equals(animator)) {
                    return;
                }
                myViewHolder.sendCommentAlertAnimation = null;
            }
        });
        myViewHolder.sendCommentAlertAnimation.setDuration(1800L);
        myViewHolder.sendCommentAlertAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextIfPossible(MyViewHolder myViewHolder, int i) {
        if (i != 0) {
            if (myViewHolder.mp4PlayerView != null) {
                myViewHolder.mp4PlayerView.cancelDownloadFile();
            }
            if (this.storyFragment != null && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId() != null) {
                this.storyFragment.clearStoryPreloadPicture(((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().getIdOrRnd());
            }
        }
        hideAndShowSendCommentView(myViewHolder, false, true);
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).info != null && ((StoryListOfAProfileObject) titem).info.storyIdsObject != null && ((StoryListOfAProfileObject) titem).current + i < ((StoryListOfAProfileObject) titem).info.storyIdsObject.size() && ((StoryListOfAProfileObject) myViewHolder.item).current + i >= 0) {
            if (myViewHolder.mp4PlayerView != null) {
                myViewHolder.mp4PlayerView.stopPlayer();
                myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.subscribedAndPause;
            }
            if (myViewHolder.disposablePlay != null) {
                myViewHolder.disposablePlay.dispose();
            }
            Titem titem2 = myViewHolder.item;
            ((StoryListOfAProfileObject) titem2).current += i;
            onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) titem2);
            return;
        }
        if (myViewHolder.item != 0) {
            StoryController.getInstance(this.currentAccount).sendSeenStoryIdsIfNeeded(((StoryListOfAProfileObject) myViewHolder.item).getProfileId());
        }
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null) {
            storyFragment.nextPersonIfPossible(myViewHolder.getAdapterPosition(), i);
        }
    }

    public void updateProgress(MyViewHolder myViewHolder, int i) {
        if (i < 0) {
            myViewHolder.storiesProgressView.reverse();
        } else {
            myViewHolder.storiesProgressView.skip();
        }
    }

    private void initProgress(final MyViewHolder myViewHolder) {
        myViewHolder.storiesProgressView.setVisibility(0);
        myViewHolder.storiesProgressView.setStoriesCountWithDurations((StoryListOfAProfileObject) myViewHolder.item);
        myViewHolder.storiesProgressView.setStoriesListener(new StoriesProgressView.StoriesListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.26
            @Override // ir.resaneh1.iptv.helper.StoriesProgressView.StoriesListener
            public void onNext(boolean z) {
                if (((StoryListOfAProfileObject) myViewHolder.item).canReply() && StoryPresenter.this.isCommentShowing) {
                    StoryPresenter.this.hideAndShowSendCommentView(myViewHolder, false, true);
                } else if (z || !((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().isLocal) {
                    StoryPresenter.this.nextIfPossible(myViewHolder, 1);
                } else {
                    StoryPresenter.this.nextIfPossible(myViewHolder, 0);
                }
            }

            @Override // ir.resaneh1.iptv.helper.StoriesProgressView.StoriesListener
            public void onPrev() {
                if (!((StoryListOfAProfileObject) myViewHolder.item).canReply() || !StoryPresenter.this.isCommentShowing) {
                    StoryPresenter.this.nextIfPossible(myViewHolder, -1);
                } else {
                    StoryPresenter.this.hideAndShowSendCommentView(myViewHolder, false, true);
                }
            }

            @Override // ir.resaneh1.iptv.helper.StoriesProgressView.StoriesListener
            public void onComplete(boolean z) {
                if (z || ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId() == null || !((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().isLocal) {
                    StoryPresenter.this.nextIfPossible(myViewHolder, 1);
                } else {
                    StoryPresenter.this.nextIfPossible(myViewHolder, 0);
                }
            }
        });
        myViewHolder.storiesProgressView.initProgress(((StoryListOfAProfileObject) myViewHolder.item).current);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLessThanThreshold(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(f - f2);
        float fAbs2 = Math.abs(f3 - f4);
        int i = this.CLICK_ACTION_THRESHOLD;
        return fAbs <= ((float) i) && fAbs2 <= ((float) i);
    }

    public void subscribeToPlay(final MyViewHolder myViewHolder) {
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.subscribedAndPause;
        myViewHolder.disposablePlay = (Disposable) Observable.timer(1L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.27
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                if (myViewHolder.playState == ViewGroupCellPresenter.PlayStateEnum.play || !StoryPresenter.this.isRecyclerIdle) {
                    return;
                }
                StoryPresenter.this.play(myViewHolder);
            }
        });
        myViewHolder.compositeDisposable.add(myViewHolder.disposablePlay);
    }

    public void play(MyViewHolder myViewHolder) {
        StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
        if (currentStoryObject == null || this.storyFragment == null || !this.isRecyclerIdle) {
            return;
        }
        if (!currentStoryObject.hasVideo()) {
            myViewHolder.mp4PlayerView.stopPlayer();
            myViewHolder.playState = ViewGroupCellPresenter.PlayStateEnum.subscribedAndPause;
            return;
        }
        ViewGroupCellPresenter.PlayStateEnum playStateEnum = myViewHolder.playState;
        ViewGroupCellPresenter.PlayStateEnum playStateEnum2 = ViewGroupCellPresenter.PlayStateEnum.play;
        if (playStateEnum == playStateEnum2) {
            return;
        }
        setPlayerIfNeeded(myViewHolder);
        if (((StoryListOfAProfileObject) myViewHolder.item).presenterPosition != this.storyFragment.currentSnapPosition) {
            return;
        }
        myViewHolder.playState = playStateEnum2;
        if (currentStoryObject.playerInfoObject != null) {
            myViewHolder.mp4PlayerView.playNew(((StoryListOfAProfileObject) myViewHolder.item).current, currentStoryObject.playerInfoObject);
        }
    }

    private void setGlView(MyViewHolder myViewHolder) {
        if (myViewHolder.uiStoryGLSurfaceView != null) {
            myViewHolder.uiStoryGLSurfaceView.onPause();
            myViewHolder.uiStoryGLSurfaceView.onDestroy();
        }
        myViewHolder.uiStoryGLSurfaceView = new UI_StoryGLSurfaceView();
        myViewHolder.uiStoryGLSurfaceView.createView(this.context);
        myViewHolder.frameLayoutGlContainer.removeAllViews();
        myViewHolder.frameLayoutGlContainer.addView(myViewHolder.uiStoryGLSurfaceView.view);
    }

    private void onBindGl(MyViewHolder myViewHolder) {
        StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject();
        if (currentStoryObject != null && currentStoryObject.isLocal && Utils.useNewStoryCreationSystem()) {
            if (myViewHolder.uiStoryGLSurfaceView != null) {
                myViewHolder.uiStoryGLSurfaceView.onResume();
            } else {
                setGlView(myViewHolder);
            }
            myViewHolder.frameLayoutGlContainer.setVisibility(0);
            myViewHolder.uiStoryGLSurfaceView.onBindGl(currentStoryObject);
        }
    }

    private void setPlayerIfNeeded(final MyViewHolder myViewHolder) {
        if (myViewHolder.mp4PlayerView == null) {
            myViewHolder.mp4PlayerView = new UI_MP4PlayerView();
            myViewHolder.mp4PlayerView.createView((Activity) this.context);
            myViewHolder.frameLayoutVideoContainer.addView(myViewHolder.mp4PlayerView.exoPlayerView);
            myViewHolder.mp4PlayerView.setExoPlayerEventListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.28
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
                public void onLoadingChanged(boolean z) {
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
                public void onPlayerError(ExoPlaybackException exoPlaybackException) {
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
                public void onPlayerStateChanged(boolean z, final int i) throws Resources.NotFoundException {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (i == 2) {
                                myViewHolder.progressView.setVisibility(0);
                            } else {
                                myViewHolder.progressView.setVisibility(4);
                            }
                        }
                    });
                    MyViewHolder myViewHolder2 = myViewHolder;
                    if (myViewHolder2.storiesProgressView != null) {
                        StoryObject currentStoryObject = ((StoryListOfAProfileObject) myViewHolder2.item).getCurrentStoryObject();
                        if (!z) {
                            myViewHolder.storiesProgressView.pause();
                            return;
                        }
                        if (i == 3) {
                            MyViewHolder myViewHolder3 = myViewHolder;
                            if (!myViewHolder3.isWidgetAdded) {
                                StoryPresenter.this.removeLastWidgetIfNeeded(myViewHolder3);
                                if (((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() != null && ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().hasClickableWidget()) {
                                    StoryPresenter storyPresenter = StoryPresenter.this;
                                    MyViewHolder myViewHolder4 = myViewHolder;
                                    storyPresenter.addWidgets(myViewHolder4, ((StoryListOfAProfileObject) myViewHolder4.item).getCurrentStoryObject());
                                }
                            }
                            int adapterPosition = myViewHolder.getAdapterPosition();
                            StoryPresenter storyPresenter2 = StoryPresenter.this;
                            if (adapterPosition == storyPresenter2.storyFragment.currentSnapPosition && storyPresenter2.isRecyclerIdle) {
                                float currentPosition = 0.0f;
                                try {
                                    currentPosition = myViewHolder.mp4PlayerView.exoPlayer.getCurrentPosition() / ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().getDuration();
                                } catch (Exception unused) {
                                }
                                if (currentStoryObject != null) {
                                    currentStoryObject.isProgressStoppedToLoad = false;
                                    StoryPresenter.this.setSeenStoryIfNeeded(myViewHolder, currentStoryObject);
                                }
                                if (myViewHolder.isProgressStopedOnTouch || !StoryPresenter.this.isRecyclerIdle) {
                                    return;
                                }
                                MyViewHolder myViewHolder5 = myViewHolder;
                                if (myViewHolder5.isForceToStopAsPreview) {
                                    return;
                                }
                                myViewHolder5.storiesProgressView.startStories(((StoryListOfAProfileObject) myViewHolder5.item).current, currentPosition);
                                return;
                            }
                            return;
                        }
                        if (currentStoryObject != null) {
                            currentStoryObject.isProgressStoppedToLoad = true;
                        }
                        myViewHolder.storiesProgressView.pause();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeenStoryIfNeeded(MyViewHolder myViewHolder, StoryObject storyObject) {
        Titem titem = myViewHolder.item;
        if ((((StoryListOfAProfileObject) titem).highlightId == null || ((StoryListOfAProfileObject) titem).highlightId.isEmpty()) && storyObject != null) {
            String str = storyObject.profile_id;
            if (str == null || !str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id)) {
                StoryController.getInstance(this.currentAccount).addStorySeen(storyObject.id, storyObject.profile_id);
            }
        }
    }

    private void setLifeCycleObserver2(final MyViewHolder myViewHolder) {
        if (myViewHolder.parentLifecycle == null || myViewHolder.disposableLifeCycle2 != null) {
            return;
        }
        myViewHolder.disposableLifeCycle2 = (Disposable) myViewHolder.parentLifecycle.subscribeWith(new DisposableObserver<PresenterFragment.LifeCycleState>() { // from class: ir.resaneh1.iptv.presenters.StoryPresenter.29
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(PresenterFragment.LifeCycleState lifeCycleState) {
                Titem titem;
                if (lifeCycleState == PresenterFragment.LifeCycleState.resume) {
                    StoryPresenter.this.isRecyclerIdle = true;
                    return;
                }
                if (lifeCycleState == PresenterFragment.LifeCycleState.dialogDismissed) {
                    StoryPresenter.this.isRecyclerIdle = true;
                    StoryPresenter.this.resumeProgressAndVideo(myViewHolder);
                    StoryPresenter.this.hideKeyboard(myViewHolder);
                    return;
                }
                if (lifeCycleState == PresenterFragment.LifeCycleState.pause || lifeCycleState == PresenterFragment.LifeCycleState.dialogShow) {
                    MyViewHolder myViewHolder2 = myViewHolder;
                    myViewHolder2.playState = ViewGroupCellPresenter.PlayStateEnum.init;
                    StoryPresenter.this.pauseProgressAndVideo(myViewHolder2);
                    StoryPresenter.this.isRecyclerIdle = false;
                    if (myViewHolder.item != 0) {
                        StoryController.getInstance(StoryPresenter.this.currentAccount).sendSeenStoryIdsIfNeeded(((StoryListOfAProfileObject) myViewHolder.item).getProfileId());
                        return;
                    }
                    return;
                }
                if (lifeCycleState == PresenterFragment.LifeCycleState.destroy || lifeCycleState == PresenterFragment.LifeCycleState.lowMemory) {
                    try {
                        if (myViewHolder.targetView != null) {
                            FirebaseCrashlytics.getInstance().setCustomKey("StoryPresenter2", "targetView2");
                            Glide.with(ApplicationLoader.applicationContext).clear(myViewHolder.targetView);
                            myViewHolder.targetView = null;
                        }
                        StoryPresenter.this.setImage(myViewHolder, null, R.color.black);
                    } catch (Exception e) {
                        FirebaseCrashlytics.getInstance().setCustomKey("StoryPresenter5", "Exception " + e.getMessage());
                        FirebaseCrashlytics.getInstance().recordException(e);
                    }
                    if (StoryPresenter.this.storyFragment != null && (titem = myViewHolder.item) != 0 && ((StoryListOfAProfileObject) titem).getCurrentStoryId() != null) {
                        StoryPresenter.this.storyFragment.clearStoryPreloadPicture(((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().getIdOrRnd());
                    }
                    if (myViewHolder.mp4PlayerView != null) {
                        myViewHolder.mp4PlayerView.stopAndReleasePlayer();
                        myViewHolder.frameLayoutVideoContainer.removeAllViews();
                        myViewHolder.mp4PlayerView.cancelDownloadFile();
                        myViewHolder.mp4PlayerView = null;
                    }
                    if (myViewHolder.uiStoryGLSurfaceView != null) {
                        myViewHolder.uiStoryGLSurfaceView.onPause();
                        myViewHolder.uiStoryGLSurfaceView.onDestroy();
                        myViewHolder.frameLayoutGlContainer.removeAllViews();
                        myViewHolder.uiStoryGLSurfaceView = null;
                    }
                    if (myViewHolder.disposableLifeCycle2 != null) {
                        myViewHolder.disposableLifeCycle2.dispose();
                    }
                    if (myViewHolder.disposablePlay != null) {
                        myViewHolder.disposablePlay.dispose();
                    }
                    CompositeDisposable compositeDisposable = myViewHolder.compositeDisposable;
                    if (compositeDisposable != null) {
                        compositeDisposable.dispose();
                        myViewHolder.compositeDisposable = new CompositeDisposable();
                    }
                    StoriesProgressView storiesProgressView = myViewHolder.storiesProgressView;
                    if (storiesProgressView != null) {
                        storiesProgressView.destroy();
                    }
                    StoryPresenter.this.isRecyclerIdle = false;
                    if (myViewHolder.item != 0) {
                        StoryController.getInstance(StoryPresenter.this.currentAccount).sendSeenStoryIdsIfNeeded(((StoryListOfAProfileObject) myViewHolder.item).getProfileId());
                    }
                }
            }
        });
        myViewHolder.compositeDisposable.add(myViewHolder.disposableLifeCycle2);
    }

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public MyGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 > 0.0f && !StoryPresenter.this.isScrollLock && StoryPresenter.this.scrollListener != null) {
                StoryPresenter.this.scrollListener.onScrollUp(f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 < 0.0f && StoryPresenter.this.scrollListener != null) {
                StoryPresenter.this.scrollListener.onFlingUp(f2);
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }
}
