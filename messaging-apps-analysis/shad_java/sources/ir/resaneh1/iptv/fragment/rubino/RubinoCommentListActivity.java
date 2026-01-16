package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.AddCommentView;
import ir.resaneh1.iptv.fragment.rubino.CommentCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.RndHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;

/* loaded from: classes3.dex */
public class RubinoCommentListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int commentWithCaptionType;
    private AnimatorSet addCommentAnimation;
    private boolean addCommentInit;
    private AddCommentView addCommentView;
    private AddCommentView addCommentView2;
    private int arrayEndRow;
    private int arrayStartRow;
    private int captionPostRow;
    private Context context;
    private int emptyViewRow;
    public DisposableObserver fakeObserver;
    private boolean hasContinue;
    private boolean isFocusNeeded;
    private boolean lastKeyboardIsOpen;
    private long lastManualRefreshTime;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private int loadMorePosition;
    public DisposableObserver loadObserver;
    private int loadingRow;
    private String maxId;
    private boolean needToRetry;
    private boolean needToUpdateMargin;
    private View.OnClickListener onCommentClick;
    private View.OnLongClickListener onCommentLongClick;
    private View.OnClickListener onHideReplyClick;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    private CommentCell.OnReplyClickListener onReplyClick;
    private View.OnClickListener onReplyLoadingClick;
    private RubinoPostObject postObject;
    public DisposableObserver refreshObserver;
    private int retryRow;
    private int rowCount;
    private SizeNotifierFrameLayout sizeNotifierFrameLayout;
    private PullToRefreshLayout swipeRefreshLayout;
    private int type;
    private ArrayList<RubinoCommentObject> commentArray = new ArrayList<>();
    private int lastKeyboardSize = -1;

    public RubinoCommentListActivity(int i, RubinoPostObject rubinoPostObject, boolean z) {
        new ArrayList();
        this.lastKeyboardIsOpen = false;
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.13
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoCommentListActivity.this.getComments(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z2) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoCommentListActivity.this.listView, z2);
            }
        };
        this.onReplyClick = new CommentCell.OnReplyClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.16
            @Override // ir.resaneh1.iptv.fragment.rubino.CommentCell.OnReplyClickListener
            public void onReplyClick(RubinoCommentObject rubinoCommentObject, RubinoCommentObject rubinoCommentObject2, int i2) {
                if (RubinoCommentListActivity.this.postObject.post.allow_show_comment) {
                    try {
                        ((LinearLayoutManager) RubinoCommentListActivity.this.listView.getLayoutManager()).scrollToPositionWithOffset(rubinoCommentObject != null ? RubinoCommentListActivity.this.listAdapter.getPositionForPositionInSection(RubinoCommentListActivity.this.commentArray.indexOf(rubinoCommentObject) + RubinoCommentListActivity.this.arrayStartRow, rubinoCommentObject.getReplyIndex(rubinoCommentObject2)) : RubinoCommentListActivity.this.listAdapter.getPositionForPositionInSection(RubinoCommentListActivity.this.commentArray.indexOf(rubinoCommentObject2) + RubinoCommentListActivity.this.arrayStartRow, 0), (RubinoCommentListActivity.this.addCommentView2.getVisibility() == 0 ? RubinoCommentListActivity.this.addCommentView2.getTop() : RubinoCommentListActivity.this.addCommentView.getTop()) - i2);
                    } catch (Exception e) {
                        MyLog.handleException(e);
                    }
                    if (RubinoCommentListActivity.this.addCommentView != null) {
                        RubinoCommentListActivity.this.addCommentView.setReplyMode(rubinoCommentObject, rubinoCommentObject2);
                    }
                    if (RubinoCommentListActivity.this.addCommentView2 != null && RubinoCommentListActivity.this.addCommentView2.getVisibility() == 0) {
                        RubinoCommentListActivity.this.addCommentView2.editText.setEnabled(false);
                        RubinoCommentListActivity.this.addCommentView2.setReplyMode(rubinoCommentObject, rubinoCommentObject2);
                        RubinoCommentListActivity.this.addCommentView2.editText.setEnabled(true);
                        AndroidUtilities.showKeyboard(RubinoCommentListActivity.this.addCommentView2.editText);
                    }
                    RubinoCommentListActivity.this.updatePadding();
                }
            }
        };
        this.onHideReplyClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof CommentReplyLoadingCell) {
                    RubinoCommentObject rubinoCommentObject = ((CommentReplyLoadingCell) view).commentObject;
                    rubinoCommentObject.isRepliesHidden = true;
                    rubinoCommentObject.updateRows();
                    RubinoCommentListActivity.this.updateRows();
                }
            }
        };
        this.onCommentLongClick = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.18
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (view.getTag() instanceof CommentCell) {
                    CommentCell commentCell = (CommentCell) view.getTag();
                    RubinoCommentListActivity.this.onCommentClick(commentCell.currentComment, ((Integer) commentCell.getTag()).intValue());
                }
                return true;
            }
        };
        this.onCommentClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof CommentCell) {
                    CommentCell commentCell = (CommentCell) view.getTag();
                    RubinoCommentListActivity.this.onCommentClick(commentCell.currentComment, RubinoCommentListActivity.this.listAdapter.getSectionForPosition(((Integer) commentCell.getTag()).intValue()));
                }
            }
        };
        this.onReplyLoadingClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof CommentReplyLoadingCell) {
                    final CommentReplyLoadingCell commentReplyLoadingCell = (CommentReplyLoadingCell) view;
                    final RubinoCommentObject rubinoCommentObject = commentReplyLoadingCell.commentObject;
                    if (!rubinoCommentObject.hasContinueReply) {
                        if (rubinoCommentObject.isRepliesHidden) {
                            rubinoCommentObject.isRepliesHidden = false;
                            rubinoCommentObject.updateRows();
                            RubinoCommentListActivity.this.updateRows();
                            return;
                        }
                        return;
                    }
                    Disposable disposable = rubinoCommentObject.getReplyDisposable;
                    if (disposable == null || disposable.isDisposed()) {
                        commentReplyLoadingCell.updateLoadingState(true);
                        Disposable disposable2 = (Disposable) RubinoCommentListActivity.this.getRubinoController().getCommentReplyListObservable(RubinoCommentListActivity.this.postObject.post.id, rubinoCommentObject.comment.id, rubinoCommentObject.maxIdReply, 3).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.CommentListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.23.1
                            @Override // io.reactivex.Observer
                            public void onNext(Rubino.CommentListObject commentListObject) {
                                ArrayList<RubinoCommentObject> arrayList;
                                commentReplyLoadingCell.updateLoadingState(false);
                                if (commentListObject != null && (arrayList = commentListObject.commentObjects) != null && arrayList.size() > 0) {
                                    rubinoCommentObject.onReplyLoaded(commentListObject.commentObjects);
                                } else {
                                    RubinoCommentObject rubinoCommentObject2 = rubinoCommentObject;
                                    rubinoCommentObject2.hasContinueReply = false;
                                    rubinoCommentObject2.updateRows();
                                }
                                RubinoCommentListActivity.this.updateRows();
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                                commentReplyLoadingCell.updateLoadingState(false);
                                Disposable disposable3 = rubinoCommentObject.getReplyDisposable;
                                if (disposable3 != null) {
                                    disposable3.dispose();
                                }
                            }

                            @Override // io.reactivex.Observer
                            public void onComplete() {
                                Disposable disposable3 = rubinoCommentObject.getReplyDisposable;
                                if (disposable3 != null) {
                                    disposable3.dispose();
                                }
                            }
                        });
                        rubinoCommentObject.getReplyDisposable = disposable2;
                        RubinoCommentListActivity.this.compositeDisposable.add(disposable2);
                    }
                }
            }
        };
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoCommentListActivity";
        this.swipeBackEnabled = true;
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
        this.postObject = rubinoPostObject;
        this.isFocusNeeded = z;
        this.type = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoLikeCommentChanged);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoLikeCommentChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.context = context;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        if (this.type == commentWithCaptionType) {
            this.actionBar.setTitle(LocaleController.getString(R.string.rubinoComments));
        }
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceRegular());
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    RubinoCommentListActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, i2);
                RubinoCommentListActivity.this.updatePadding();
            }
        };
        this.sizeNotifierFrameLayout = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setDelegate(new SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.3
            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
            public void onSizeChanged(int i, boolean z) {
                if (RubinoCommentListActivity.this.addCommentInit && RubinoCommentListActivity.this.postObject.post.allow_show_comment && i != RubinoCommentListActivity.this.lastKeyboardSize) {
                    RubinoCommentListActivity.this.lastKeyboardSize = i;
                    if (i > AndroidUtilities.getNavigationBarSize(context).y) {
                        RubinoCommentListActivity.this.toggleAddViewComment(true);
                        RubinoCommentListActivity.this.updateMargin();
                    } else {
                        RubinoCommentListActivity.this.toggleAddViewComment(false);
                    }
                }
            }
        });
        SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.sizeNotifierFrameLayout;
        this.fragmentView = sizeNotifierFrameLayout2;
        SizeNotifierFrameLayout sizeNotifierFrameLayout3 = sizeNotifierFrameLayout2;
        int i = Theme.key_windowBackgroundWhite;
        sizeNotifierFrameLayout3.setBackgroundColor(Theme.getColor(i));
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context);
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setClipToPadding(false);
        this.listView.setClipChildren(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setEmptyView(new RubinoEmptyView(context, 17));
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context);
        this.swipeRefreshLayout = pullToRefreshLayout;
        sizeNotifierFrameLayout3.addView(pullToRefreshLayout, LayoutHelper.createFrame(-1, -1, 51));
        this.swipeRefreshLayout.bindListViewToLayout(this.listView);
        sizeNotifierFrameLayout3.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setBackgroundColor(Theme.getColor(i));
        this.listView.setAdapter(this.listAdapter);
        AddCommentView addCommentView = new AddCommentView(context, true);
        this.addCommentView = addCommentView;
        sizeNotifierFrameLayout3.addView(addCommentView, LayoutHelper.createFrame(-1, -2, 80));
        this.addCommentView.setVisibility(8);
        this.addCommentView.editText.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                RubinoCommentListActivity.this.toggleAddViewComment(true);
                AndroidUtilities.showKeyboard(RubinoCommentListActivity.this.addCommentView2.editText);
                return true;
            }
        });
        this.addCommentView.setPost(this.postObject);
        this.addCommentView.setOnSendClickListener(new AddCommentView.OnSendClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.6
            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddCommentClick(RubinoPostObject rubinoPostObject, String str) {
                RubinoCommentListActivity.this.addComment(rubinoPostObject, str);
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddReplyClick(RubinoPostObject rubinoPostObject, String str, RubinoCommentObject rubinoCommentObject) {
                RubinoCommentListActivity.this.addReply(rubinoPostObject, str, rubinoCommentObject);
            }
        });
        this.addCommentView.setVisibility(8);
        AddCommentView addCommentView2 = new AddCommentView(context, true);
        this.addCommentView2 = addCommentView2;
        sizeNotifierFrameLayout3.addView(addCommentView2, LayoutHelper.createFrame(-1, -2, 80));
        this.addCommentView2.setPost(this.postObject);
        this.addCommentView2.setOnSendClickListener(new AddCommentView.OnSendClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.7
            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddCommentClick(RubinoPostObject rubinoPostObject, String str) {
                RubinoCommentListActivity.this.addComment(rubinoPostObject, str);
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnSendClickListener
            public void onAddReplyClick(RubinoPostObject rubinoPostObject, String str, RubinoCommentObject rubinoCommentObject) {
                RubinoCommentListActivity.this.addReply(rubinoPostObject, str, rubinoCommentObject);
            }
        });
        this.addCommentView2.setOnReplyModeChangeListener(new AddCommentView.OnReplyModeChangeListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.8
            @Override // ir.resaneh1.iptv.fragment.rubino.AddCommentView.OnReplyModeChangeListener
            public void onReplyModeChange(boolean z) {
            }
        });
        this.addCommentView2.setVisibility(8);
        this.addCommentView2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (RubinoCommentListActivity.this.needToUpdateMargin) {
                    RubinoCommentListActivity.this.needToUpdateMargin = false;
                    RubinoCommentListActivity.this.updateMargin();
                }
            }
        });
        PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
        if (pullToRefreshLayout2 != null) {
            pullToRefreshLayout2.setEnabled(true);
            this.swipeRefreshLayout.setRefreshListener(this.onRefreshListener);
        }
        this.hasContinue = true;
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMargin() {
        int availableHeight = (AndroidUtilities.getAvailableHeight((Activity) this.context, this.lastKeyboardSize, false) - this.actionBar.getHeight()) - this.addCommentView2.getHeight();
        if (!this.addCommentView2.isInReplyMode) {
            getAppPreferences().setLong(AppPreferences.Key.RubinoAddCommentMargin, availableHeight);
        }
        this.addCommentView2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleAddViewComment(boolean z) {
        if (!RubinoController.getInstance(this.currentAccount).hasPermissionAddComment()) {
            this.addCommentView2.setVisibility(8);
            this.addCommentView.setVisibility(8);
            return;
        }
        if (z) {
            showAddCommentView2();
            AddCommentView addCommentView = this.addCommentView;
            if (addCommentView.isInReplyMode) {
                AddCommentView addCommentView2 = this.addCommentView2;
                RubinoCommentObject rubinoCommentObject = addCommentView.toReplyCommentObject;
                addCommentView2.setReplyMode(rubinoCommentObject, rubinoCommentObject);
            } else if (!this.lastKeyboardIsOpen) {
                this.addCommentView2.resetFromReplyMode();
                this.addCommentView2.editText.setText(this.addCommentView.editText.getText());
            }
            this.addCommentView.setVisibility(8);
            this.addCommentView2.editText.requestFocus();
        } else {
            AddCommentView addCommentView3 = this.addCommentView2;
            if (addCommentView3.isInReplyMode) {
                AddCommentView addCommentView4 = this.addCommentView;
                RubinoCommentObject rubinoCommentObject2 = addCommentView3.toReplyCommentObject;
                addCommentView4.setReplyMode(rubinoCommentObject2, rubinoCommentObject2);
            } else {
                this.addCommentView.resetFromReplyMode();
            }
            this.addCommentView.editText.setText(this.addCommentView2.editText.getText());
            AnimatorSet animatorSet = this.addCommentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.addCommentView2.setVisibility(8);
            this.addCommentView.setVisibility(0);
        }
        this.lastKeyboardIsOpen = z;
    }

    public void hideKeyboard(View view) {
        AndroidUtilities.hideKeyboard(view);
    }

    public void addComment(RubinoPostObject rubinoPostObject, String str) {
        if (rubinoPostObject == null || !rubinoPostObject.post.id.equals(this.postObject.post.id)) {
            return;
        }
        RubinoCommentObject rubinoCommentObject = new RubinoCommentObject();
        final int rndForString = RndHelper.getRndForString(this.postObject.post.id + str + this.postObject.post.profile_id);
        rubinoCommentObject.setLocalComment(getCurrentAccount(), str, rndForString);
        RubinoPostObject fromPostMapIfExist = getRubinoController().getFromPostMapIfExist(this.postObject.post.id);
        if (fromPostMapIfExist != null) {
            fromPostMapIfExist.myComments.add(rubinoCommentObject);
        }
        boolean z = false;
        if (this.hasContinue) {
            this.commentArray.add(0, rubinoCommentObject);
            z = true;
        } else {
            this.commentArray.add(rubinoCommentObject);
        }
        updateRows();
        final int itemCount = z ? this.arrayStartRow : this.listAdapter.getItemCount() - 1;
        try {
            hideKeyboard(this.addCommentView2.editText);
            ((LinearLayoutManager) this.listView.getLayoutManager()).scrollToPositionWithOffset(itemCount, AndroidUtilities.dp(50.0f));
        } catch (Exception unused) {
        }
        RubinoController rubinoController = getRubinoController();
        Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
    }

    protected void forceRippleAnimation(View view) {
        Drawable background = view.getBackground();
        if (view.getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
            view.setBackgroundResource(typedValue.resourceId);
            background = view.getBackground();
        }
        if (Build.VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return;
        }
        final RippleDrawable rippleDrawable = (RippleDrawable) background;
        rippleDrawable.setState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled});
        this.compositeDisposable.add((Disposable) Observable.timer(1500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                rippleDrawable.setState(new int[0]);
            }
        }));
    }

    public void addReply(RubinoPostObject rubinoPostObject, String str, final RubinoCommentObject rubinoCommentObject) {
        if (rubinoPostObject == null || !rubinoPostObject.post.id.equals(this.postObject.post.id)) {
            return;
        }
        final RubinoCommentObject rubinoCommentObject2 = new RubinoCommentObject();
        int rndForString = RndHelper.getRndForString(rubinoCommentObject.comment.id + this.postObject.post.id + str);
        rubinoCommentObject2.setLocalComment(getCurrentAccount(), str, rndForString);
        rubinoCommentObject.addTopReplyArray(rubinoCommentObject2);
        final int positionForPositionInSection = this.listAdapter.getPositionForPositionInSection(this.commentArray.indexOf(rubinoCommentObject) + this.arrayStartRow, rubinoCommentObject.getReplyIndex(rubinoCommentObject2));
        updateRows();
        try {
            hideKeyboard(this.addCommentView2.editText);
        } catch (Exception unused) {
        }
    }

    void updateRows() {
        updateRows(true);
    }

    void updateRows(boolean z) {
        ListAdapter listAdapter;
        RubinoPostObject rubinoPostObject;
        String str;
        this.captionPostRow = -1;
        this.arrayStartRow = -1;
        this.arrayEndRow = -1;
        this.loadingRow = -1;
        this.emptyViewRow = -1;
        this.retryRow = -1;
        this.loadMorePosition = Math.max(0, this.commentArray.size() - 15);
        this.rowCount = 0;
        if (this.type == commentWithCaptionType && (rubinoPostObject = this.postObject) != null && (str = rubinoPostObject.post.caption) != null && !str.isEmpty()) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.captionPostRow = i;
        }
        if (this.needToRetry) {
            int i2 = this.rowCount;
            this.rowCount = i2 + 1;
            this.retryRow = i2;
        } else {
            if (this.commentArray.size() > 0) {
                int i3 = this.rowCount;
                this.arrayStartRow = i3;
                int size = i3 + this.commentArray.size();
                this.rowCount = size;
                this.arrayEndRow = size;
            }
            if (this.hasContinue) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.loadingRow = i4;
            } else if (this.commentArray.size() == 0 && this.captionPostRow < 0) {
                int i5 = this.rowCount;
                this.rowCount = i5 + 1;
                this.emptyViewRow = i5;
            }
        }
        if (!z || (listAdapter = this.listAdapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePadding() {
        int measuredHeight;
        AddCommentView addCommentView = this.addCommentView;
        if (addCommentView != null && addCommentView.getVisibility() == 0) {
            measuredHeight = this.addCommentView.getMeasuredHeight();
        } else {
            AddCommentView addCommentView2 = this.addCommentView2;
            measuredHeight = (addCommentView2 == null || addCommentView2.getVisibility() != 0) ? 0 : this.addCommentView2.getMeasuredHeight();
        }
        this.listView.setPadding(0, 0, 0, measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getComments(final boolean z, final boolean z2) {
        if (this.postObject == null) {
            return;
        }
        if (z || this.hasContinue) {
            if (z) {
                DisposableObserver disposableObserver = this.refreshObserver;
                if (disposableObserver != null && !disposableObserver.isDisposed()) {
                    PullToRefreshLayout pullToRefreshLayout = this.swipeRefreshLayout;
                    if (pullToRefreshLayout != null) {
                        pullToRefreshLayout.setRefreshing(false, true);
                        return;
                    }
                    return;
                }
                if (z2 && System.currentTimeMillis() - this.lastManualRefreshTime < 10000) {
                    DisposableObserver disposableObserver2 = this.fakeObserver;
                    if (disposableObserver2 != null && !disposableObserver2.isDisposed()) {
                        this.fakeObserver.dispose();
                    }
                    DisposableObserver disposableObserver3 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.14
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (RubinoCommentListActivity.this.swipeRefreshLayout != null) {
                                RubinoCommentListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                            }
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
                    this.fakeObserver = disposableObserver3;
                    this.compositeDisposable.add(disposableObserver3);
                    return;
                }
                DisposableObserver disposableObserver4 = this.loadObserver;
                if (disposableObserver4 != null && !disposableObserver4.isDisposed()) {
                    this.loadObserver.dispose();
                }
            } else {
                DisposableObserver disposableObserver5 = this.loadObserver;
                if (disposableObserver5 != null && !disposableObserver5.isDisposed()) {
                    return;
                }
                DisposableObserver disposableObserver6 = this.refreshObserver;
                if (disposableObserver6 != null && !disposableObserver6.isDisposed()) {
                    this.refreshObserver.dispose();
                    PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
                    if (pullToRefreshLayout2 != null) {
                        pullToRefreshLayout2.setRefreshing(false, true);
                    }
                }
            }
            DisposableObserver disposableObserver7 = this.fakeObserver;
            if (disposableObserver7 != null && !disposableObserver7.isDisposed()) {
                this.fakeObserver.dispose();
            }
            Observable<Rubino.CommentListObject> commentsObservable = null;
            if (this.type == commentWithCaptionType) {
                RubinoController rubinoController = getRubinoController();
                Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
                commentsObservable = rubinoController.getCommentsObservable(postObjectFromServer.id, postObjectFromServer.profile_id, z ? null : this.maxId, 50);
            }
            DisposableObserver disposableObserver8 = (DisposableObserver) commentsObservable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.CommentListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.15
                @Override // io.reactivex.Observer
                public void onNext(Rubino.CommentListObject commentListObject) {
                    ArrayList<RubinoCommentObject> arrayList;
                    RubinoCommentListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    if (z && z2) {
                        RubinoCommentListActivity.this.lastManualRefreshTime = System.currentTimeMillis();
                    }
                    if (commentListObject == null || (arrayList = commentListObject.commentObjects) == null || arrayList.size() <= 0) {
                        RubinoCommentListActivity.this.hasContinue = false;
                    } else {
                        if (z) {
                            RubinoCommentListActivity.this.commentArray.clear();
                        }
                        RubinoCommentListActivity.this.commentArray.addAll(commentListObject.commentObjects);
                        RubinoCommentListActivity rubinoCommentListActivity = RubinoCommentListActivity.this;
                        ArrayList<RubinoCommentObject> arrayList2 = commentListObject.commentObjects;
                        rubinoCommentListActivity.maxId = arrayList2.get(arrayList2.size() - 1).comment.id;
                    }
                    if (RubinoCommentListActivity.this.postObject.post.allow_show_comment && !RubinoCommentListActivity.this.addCommentInit) {
                        RubinoCommentListActivity.this.addCommentInit = true;
                        if (RubinoCommentListActivity.this.isFocusNeeded) {
                            RubinoCommentListActivity.this.toggleAddViewComment(true);
                            AndroidUtilities.showKeyboard(RubinoCommentListActivity.this.addCommentView2.editText);
                        } else {
                            RubinoCommentListActivity.this.toggleAddViewComment(false);
                        }
                    }
                    RubinoCommentListActivity.this.updateRows();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoCommentListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    dispose();
                    if (RubinoCommentListActivity.this.commentArray.size() == 0) {
                        RubinoCommentListActivity.this.needToRetry = true;
                    }
                    RubinoCommentListActivity.this.updateRows();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            if (z) {
                this.refreshObserver = disposableObserver8;
            } else {
                this.loadObserver = disposableObserver8;
            }
            this.compositeDisposable.add(disposableObserver8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCommentClick(final RubinoCommentObject rubinoCommentObject, final int i) {
        RubinoPostObject rubinoPostObject;
        Rubino.AlertItem alertItem;
        String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        if ((str != null && str.equals(rubinoCommentObject.comment.profile_id)) || ((rubinoPostObject = this.postObject) != null && str.equals(rubinoPostObject.post.profile_id))) {
            alertItem = new Rubino.AlertItem(LocaleController.getString(R.string.rubinoDeleteComment), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RubinoCommentListActivity rubinoCommentListActivity = RubinoCommentListActivity.this;
                    rubinoCommentListActivity.compositeDisposable.add((Disposable) rubinoCommentListActivity.getRubinoController().getDeleteCommentObservable(rubinoCommentObject).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.RemoveRecordOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.20.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(MessangerOutput<Rubino.RemoveRecordOutput> messangerOutput) {
                            AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                            if (rubinoCommentObject.isReply) {
                                ArrayList arrayList = RubinoCommentListActivity.this.commentArray;
                                AnonymousClass20 anonymousClass202 = AnonymousClass20.this;
                                ((RubinoCommentObject) arrayList.get(i - RubinoCommentListActivity.this.arrayStartRow)).deleteReply(rubinoCommentObject);
                            } else {
                                Iterator it = RubinoCommentListActivity.this.commentArray.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    RubinoCommentObject rubinoCommentObject2 = (RubinoCommentObject) it.next();
                                    if (rubinoCommentObject2.comment.id.equals(rubinoCommentObject.comment.id)) {
                                        RubinoCommentListActivity.this.commentArray.remove(rubinoCommentObject2);
                                        break;
                                    }
                                }
                            }
                            RubinoCommentListActivity.this.updateRows();
                        }
                    }));
                }
            });
        } else {
            alertItem = new Rubino.AlertItem(LocaleController.getString(R.string.rubinoReport), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ArrayList arrayList = new ArrayList();
                    final RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoReport), arrayList);
                    arrayList.add(new Rubino.AlertBoldItem(LocaleController.getString(R.string.rubinoReportCommentQuestion)));
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSpam), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.21.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                            RubinoCommentListActivity.this.reportComment(rubinoCommentObject, 1, i);
                            rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                        }
                    }));
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoInAppropriate), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.21.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                            RubinoCommentListActivity.this.reportComment(rubinoCommentObject, 2, i);
                            rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                        }
                    }));
                    rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
                    ApplicationLoader.applicationActivity.getLastFragment().showDialog(rubinoBottomUpAlertCreateRubinoDialogItems);
                }
            });
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(alertItem);
        RubinoController.showRubinoCenterDialog(null, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportComment(RubinoCommentObject rubinoCommentObject, int i, int i2) {
        getRubinoController().reportComment(rubinoCommentObject, this.postObject.post.id, i);
    }

    public void showAddCommentView2() {
        if (this.addCommentView2.getVisibility() == 0 || !this.postObject.post.allow_show_comment) {
            return;
        }
        try {
            AnimatorSet animatorSet = this.addCommentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.addCommentAnimation = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.addCommentView2, "alpha", 0.0f, 1.0f));
            this.addCommentAnimation.setInterpolator(new DecelerateInterpolator());
            this.addCommentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.22
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (RubinoCommentListActivity.this.addCommentAnimation == null || !RubinoCommentListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoCommentListActivity.this.addCommentView2.setVisibility(0);
                    RubinoCommentListActivity.this.addCommentView2.setAlpha(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RubinoCommentListActivity.this.addCommentAnimation == null || !RubinoCommentListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoCommentListActivity.this.addCommentView2.setAlpha(1.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (RubinoCommentListActivity.this.addCommentAnimation == null || !RubinoCommentListActivity.this.addCommentAnimation.equals(animator)) {
                        return;
                    }
                    RubinoCommentListActivity.this.addCommentView2.setVisibility(4);
                }
            });
            this.addCommentAnimation.setDuration(180L);
            this.addCommentAnimation.start();
        } catch (Exception unused) {
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.emojiDidLoad) {
            this.addCommentView.setEmoji();
            this.addCommentView2.setEmoji();
            return;
        }
        if (i == NotificationCenter.rubinoLikeCommentChanged) {
            String str = (String) objArr[0];
            boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
            int iIntValue = ((Integer) objArr[2]).intValue();
            CommentCell commentCellFindVisibleViewForCommentId = findVisibleViewForCommentId(str);
            if (commentCellFindVisibleViewForCommentId != null) {
                RubinoCommentObject rubinoCommentObject = commentCellFindVisibleViewForCommentId.currentComment;
                rubinoCommentObject.isLiked = zBooleanValue;
                rubinoCommentObject.comment.likes_count = iIntValue;
                rubinoCommentObject.createLikeCountString();
                commentCellFindVisibleViewForCommentId.setLikeCountView();
                commentCellFindVisibleViewForCommentId.setLikeIcon(true ^ this.isPaused);
            }
        }
    }

    private CommentCell findVisibleViewForCommentId(String str) {
        CommentCell commentCell;
        RubinoCommentObject rubinoCommentObject;
        Rubino.CommentFromServer commentFromServer;
        String str2;
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if ((childAt instanceof CommentCell) && (rubinoCommentObject = (commentCell = (CommentCell) childAt).currentComment) != null && (commentFromServer = rubinoCommentObject.comment) != null && (str2 = commentFromServer.id) != null && str2.equals(str)) {
                return commentCell;
            }
        }
        return null;
    }

    class ListAdapter extends RecyclerListViewEdited.SectionsAdapter {
        Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            return null;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            View rubinoLoadingCell;
            if (i == 0) {
                CommentCell commentCell = new CommentCell(this.mContext);
                commentCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                commentCell.setOnReplyClick(RubinoCommentListActivity.this.onReplyClick);
                commentCell.view.setOnLongClickListener(RubinoCommentListActivity.this.onCommentLongClick);
                commentCell.view.setOnClickListener(RubinoCommentListActivity.this.onCommentClick);
                commentCell.setonLongClick(RubinoCommentListActivity.this.onCommentLongClick);
                view = commentCell;
            } else if (i == 2) {
                View commentReplyLoadingCell = new CommentReplyLoadingCell(this.mContext);
                commentReplyLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                view = commentReplyLoadingCell;
            } else {
                if (i == 4) {
                    View rubinoEmptyView = new RubinoEmptyView(this.mContext, 17);
                    rubinoEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    rubinoLoadingCell = rubinoEmptyView;
                } else if (i == 5) {
                    RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                    rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                    rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity.ListAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            RubinoCommentListActivity.this.needToRetry = false;
                            RubinoCommentListActivity.this.updateRows();
                        }
                    });
                    rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                    ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                    rubinoLoadingCell = rubinoRetryView;
                } else if (i == 6) {
                    View commentCell2 = new CommentCell(this.mContext);
                    commentCell2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    view = commentCell2;
                } else {
                    rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                }
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = view;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                CommentCell commentCell = (CommentCell) viewHolder.itemView;
                commentCell.setTag(Integer.valueOf(i));
                if (i >= RubinoCommentListActivity.this.arrayStartRow && i < RubinoCommentListActivity.this.arrayEndRow) {
                    RubinoCommentObject rubinoCommentObject = (RubinoCommentObject) RubinoCommentListActivity.this.commentArray.get(i - RubinoCommentListActivity.this.arrayStartRow);
                    if (i2 == 0) {
                        commentCell.setComment(RubinoCommentListActivity.this.postObject.post.id, null, rubinoCommentObject, false);
                    } else if (i2 >= rubinoCommentObject.replyArrayStartRow && i2 < rubinoCommentObject.replyArrayEndRow) {
                        commentCell.setComment(RubinoCommentListActivity.this.postObject.post.id, rubinoCommentObject, rubinoCommentObject.getReply(i2 - rubinoCommentObject.replyArrayStartRow), false);
                    }
                }
            } else if (itemViewType == 2) {
                CommentReplyLoadingCell commentReplyLoadingCell = (CommentReplyLoadingCell) viewHolder.itemView;
                if (i >= RubinoCommentListActivity.this.arrayStartRow && i < RubinoCommentListActivity.this.arrayEndRow) {
                    RubinoCommentObject rubinoCommentObject2 = (RubinoCommentObject) RubinoCommentListActivity.this.commentArray.get(i - RubinoCommentListActivity.this.arrayStartRow);
                    if (i2 == rubinoCommentObject2.replyLoadingRow) {
                        commentReplyLoadingCell.setOnClickListener(RubinoCommentListActivity.this.onReplyLoadingClick);
                        commentReplyLoadingCell.setLoadingCommentReplies(rubinoCommentObject2);
                    } else if (i2 == rubinoCommentObject2.replyHideRow) {
                        commentReplyLoadingCell.setHideCommentReplies(rubinoCommentObject2);
                        commentReplyLoadingCell.setOnClickListener(RubinoCommentListActivity.this.onHideReplyClick);
                    }
                }
            } else if (itemViewType == 4) {
                ((RubinoEmptyView) viewHolder.itemView).setData(0, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            } else if (itemViewType == 6) {
                CommentCell commentCell2 = (CommentCell) viewHolder.itemView;
                if (i == RubinoCommentListActivity.this.captionPostRow) {
                    commentCell2.setPost(RubinoCommentListActivity.this.postObject, true);
                }
            }
            if (RubinoCommentListActivity.this.hasContinue) {
                if ((i == RubinoCommentListActivity.this.loadMorePosition || i == RubinoCommentListActivity.this.loadingRow) && RubinoCommentListActivity.this.retryRow < 0) {
                    RubinoCommentListActivity.this.getComments(false, false);
                }
            }
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public int getSectionCount() {
            return RubinoCommentListActivity.this.rowCount;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public int getCountForSection(int i) {
            if (i < RubinoCommentListActivity.this.arrayStartRow || i >= RubinoCommentListActivity.this.arrayEndRow) {
                return 1;
            }
            return ((RubinoCommentObject) RubinoCommentListActivity.this.commentArray.get(i - RubinoCommentListActivity.this.arrayStartRow)).itemCount + 0;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public boolean isEnabled(int i, int i2) {
            if (i < RubinoCommentListActivity.this.arrayStartRow || i >= RubinoCommentListActivity.this.arrayEndRow) {
                return false;
            }
            RubinoCommentObject rubinoCommentObject = (RubinoCommentObject) RubinoCommentListActivity.this.commentArray.get(i - RubinoCommentListActivity.this.arrayStartRow);
            return i2 == 0 || i2 == rubinoCommentObject.replyLoadingRow || i2 == rubinoCommentObject.replyHideRow || (i2 >= rubinoCommentObject.replyArrayStartRow && i2 < rubinoCommentObject.replyArrayEndRow);
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (i < RubinoCommentListActivity.this.arrayStartRow || i >= RubinoCommentListActivity.this.arrayEndRow) {
                if (i == RubinoCommentListActivity.this.loadingRow) {
                    return 1;
                }
                if (i == RubinoCommentListActivity.this.emptyViewRow) {
                    return 4;
                }
                if (i == RubinoCommentListActivity.this.retryRow) {
                    return 5;
                }
                return i == RubinoCommentListActivity.this.captionPostRow ? 6 : 1;
            }
            RubinoCommentObject rubinoCommentObject = (RubinoCommentObject) RubinoCommentListActivity.this.commentArray.get(i - RubinoCommentListActivity.this.arrayStartRow);
            return (i2 == rubinoCommentObject.replyLoadingRow || i2 == rubinoCommentObject.replyHideRow) ? 2 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            MyLog.e("List Status", "detached: " + viewHolder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            MyLog.e("List Status", "attached: " + viewHolder.getAdapterPosition());
        }
    }
}
