package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.util.StateSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScrollerCustom;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.XiaomiUtilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_dialogFolder;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_checkHistoryImportPeer;
import ir.eitaa.tgnet.TLRPC$TL_messages_checkedHistoryImportPeer;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFilter;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.DrawerLayoutContainer;
import ir.eitaa.ui.ActionBar.MenuDrawable;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.DialogsAdapter;
import ir.eitaa.ui.Adapters.DialogsSearchAdapter;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Cells.AccountSelectCell;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.SearchToolsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.ChatActivityEnterView;
import ir.eitaa.ui.Components.ChatAvatarContainer;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.DialogsItemAnimator;
import ir.eitaa.ui.Components.FilterTabsView;
import ir.eitaa.ui.Components.FiltersListBottomSheet;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.FragmentContextView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.PacmanAnimation;
import ir.eitaa.ui.Components.ProxyDrawable;
import ir.eitaa.ui.Components.PullForegroundDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RecyclerAnimationScrollHelper;
import ir.eitaa.ui.Components.RecyclerItemsEnterAnimator;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SearchViewPager;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.Components.ViewPagerFixed;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.FilteredSearchView;
import ir.eitaa.ui.GroupCreateFinalActivity;
import ir.eitaa.ui.explore.activity.ExploreActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DialogsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static String lastSearchString_ = "";
    public static int position_;
    private static SearchToolsCell searchToolsCell;
    public static View view_;
    private final String ACTION_MODE_SEARCH_DIALOGS_TAG;
    public final Property<DialogsActivity, Float> SCROLL_Y;
    private ValueAnimator actionBarColorAnimator;
    private Paint actionBarDefaultPaint;
    private ArrayList<View> actionModeViews;
    private ActionBarMenuSubItem addToFavoriteItem;
    private ActionBarMenuSubItem addToFolderItem;
    private String addToGroupAlertString;
    private float additionalFloatingTranslation;
    private float additionalFloatingTranslation2;
    private float additionalOffset;
    private boolean afterSignup;
    private boolean allowMoving;
    private boolean allowSwipeDuringCurrentTouch;
    private boolean allowSwitchAccount;
    private boolean animatingForward;
    private int animationIndex;
    private ActionBarMenuItem archive2Item;
    private ActionBarMenuSubItem archiveItem;
    private boolean askAboutContacts;
    private boolean askingForPermissions;
    private ChatAvatarContainer avatarContainer;
    private boolean backAnimation;
    private BackDrawable backDrawable;
    private ActionBarMenuSubItem blockItem;
    private View blurredView;
    private int canClearCacheCount;
    private boolean canDeletePsaSelected;
    private int canMuteCount;
    private int canPinCount;
    private int canReadCount;
    private int canReportSpamCount;
    private boolean canShowFilterTabsView;
    private boolean canShowHiddenArchive;
    private int canUnarchiveCount;
    private int canUnmuteCount;
    private boolean cantSendToChannels;
    private boolean checkCanWrite;
    private boolean checkPermission;
    private boolean checkingImportDialog;
    private ActionBarMenuSubItem clearItem;
    private boolean closeSearchFieldOnHide;
    private ChatActivityEnterView commentView;
    private int currentConnectionState;
    View databaseMigrationHint;
    private int debugLastUpdateAction;
    private DialogsActivityDelegate delegate;
    private ActionBarMenuItem deleteItem;
    private int dialogChangeFinished;
    private int dialogInsertFinished;
    private int dialogRemoveFinished;
    private boolean dialogsListFrozen;
    private boolean disableActionBarScrolling;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimator;
    private AnimatorSet expandModeHintAnimation;
    private Runnable expandModeHintHideRunnable;
    private TextView expandModeHintTextView;
    private boolean expandedMode;
    private ActionBarMenuItem exploreItem;
    private float filterTabsMoveFrom;
    private float filterTabsProgress;
    private FilterTabsView filterTabsView;
    private boolean filterTabsViewIsVisible;
    private ValueAnimator filtersTabAnimator;
    private FiltersView filtersView;
    private RLottieImageView floatingButton;
    private FrameLayout floatingButtonContainer;
    private float floatingButtonHideProgress;
    private float floatingButtonTranslation;
    private boolean floatingForceVisible;
    private boolean floatingHidden;
    private final AccelerateDecelerateInterpolator floatingInterpolator;
    private int folderId;
    private FragmentContextView fragmentContextView;
    private FragmentContextView fragmentLocationContextView;
    private ArrayList<TLRPC$Dialog> frozenDialogsList;
    private boolean getDialogFilters;
    private boolean hasInvoice;
    private int hasPoll;
    private int initialDialogsType;
    private String initialSearchString;
    private int initialSearchType;
    boolean isDrawerTransition;
    public boolean isForward;
    boolean isSlideBackTransition;
    private int lastMeasuredTopPadding;
    private SearchToolsCell.ActionItem listModeActionItem;
    private ActionBarMenuSubItem lockChatItem;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    private MenuDrawable menuDrawable;
    private int messagesCount;
    private ArrayList<MessagesController.DialogFilter> movingDialogFilters;
    private DialogCell movingView;
    private boolean movingWas;
    private ActionBarMenuItem muteItem;
    private boolean onlySelect;
    private long openedDialogId;
    private PacmanAnimation pacmanAnimation;
    private RLottieDrawable passcodeDrawable;
    private ActionBarMenuItem passcodeItem;
    private boolean passcodeItemVisible;
    private AlertDialog permissionDialog;
    private ActionBarMenuSubItem pin2Item;
    private ActionBarMenuItem pinItem;
    private int prevPosition;
    private int prevTop;
    private float progressToActionMode;
    private ProxyDrawable proxyDrawable;
    private ActionBarMenuItem proxyItem;
    private boolean proxyItemVisible;
    private ActionBarMenuSubItem readItem;
    private ActionBarMenuItem recommendItem;
    private ActionBarMenuSubItem removeFromFavoriteItem;
    private ActionBarMenuSubItem removeFromFolderItem;
    private boolean resetDelegate;
    private AnimatorSet scrimAnimatorSet;
    private Paint scrimPaint;
    private ActionBarPopupWindow scrimPopupWindow;
    private ActionBarMenuSubItem[] scrimPopupWindowItems;
    private View scrimView;
    private int[] scrimViewLocation;
    private boolean scrimViewSelected;
    private float scrollAdditionalOffset;
    private boolean scrollBarVisible;
    private boolean scrollUpdated;
    private boolean scrollingManually;
    private float searchAnimationProgress;
    private boolean searchAnimationTabsDelayedCrossfade;
    private AnimatorSet searchAnimator;
    private long searchDialogId;
    private boolean searchFiltersWasShowed;
    private boolean searchIsShowed;
    private ActionBarMenuItem searchItem;
    private TLObject searchObject;
    private String searchString;
    private ViewPagerFixed.TabsView searchTabsView;
    private SearchViewPager searchViewPager;
    private boolean searchWas;
    private boolean searchWasFullyShowed;
    private boolean searching;
    private String selectAlertString;
    private String selectAlertStringGroup;
    private ArrayList<Long> selectedDialogs;
    private NumberTextView selectedDialogsCountTextView;
    private String showingSuggestion;
    private RecyclerView sideMenu;
    ValueAnimator slideBackTransitionAnimator;
    float slideFragmentProgress;
    private DialogCell slidingView;
    private long startArchivePullingTime;
    private boolean startedTracking;
    private ActionBarMenuItem switchItem;
    private Animator tabsAlphaAnimator;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private float tabsYOffset;
    private int topPadding;
    private UndoView[] undoView;
    private FrameLayout updateLayout;
    private AnimatorSet updateLayoutAnimator;
    private RadialProgress2 updateLayoutIcon;
    private boolean updatePullAfterScroll;
    private TextView updateTextView;
    private ViewPage[] viewPages;
    private boolean waitingForScrollFinished;
    private ActionBarMenuItem whatshotItem;
    private boolean whiteActionBar;
    public static boolean[] dialogsLoaded = new boolean[3];
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$PVPmZ6JTJ3NP1b1NhbMyppDtuPU
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return DialogsActivity.lambda$static$0(f);
        }
    };
    public static float viewOffset = 0.0f;

    public interface DialogsActivityDelegate {
        void didSelectDialogs(DialogsActivity fragment, ArrayList<Long> dids, CharSequence message, boolean param);
    }

    static /* synthetic */ boolean lambda$createActionMode$10(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    static /* synthetic */ int access$13608(DialogsActivity dialogsActivity) {
        int i = dialogsActivity.canReadCount;
        dialogsActivity.canReadCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ViewPage extends FrameLayout {
        private int archivePullViewState;
        private DialogsAdapter dialogsAdapter;
        private DialogsItemAnimator dialogsItemAnimator;
        private int dialogsType;
        private ItemTouchHelper itemTouchhelper;
        private int lastItemsCount;
        private LinearLayoutManager layoutManager;
        private DialogsRecyclerView listView;
        private FlickerLoadingView progressView;
        private PullForegroundDrawable pullForegroundDrawable;
        private RecyclerItemsEnterAnimator recyclerItemsEnterAnimator;
        private RecyclerAnimationScrollHelper scrollHelper;
        private int selectedType;
        private SwipeController swipeController;

        static /* synthetic */ int access$11108(ViewPage viewPage) {
            int i = viewPage.lastItemsCount;
            viewPage.lastItemsCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$11110(ViewPage viewPage) {
            int i = viewPage.lastItemsCount;
            viewPage.lastItemsCount = i - 1;
            return i;
        }

        public ViewPage(Context context) {
            super(context);
        }

        public boolean isDefaultDialogType() {
            int i = this.dialogsType;
            return i == 0 || i == 7 || i == 8;
        }
    }

    private class ContentView extends SizeNotifierFrameLayout {
        private Paint actionBarSearchPaint;
        private int inputFieldHeight;
        private int[] pos;
        private int startedTrackingPointerId;
        private int startedTrackingX;
        private int startedTrackingY;
        private VelocityTracker velocityTracker;
        private Paint windowBackgroundPaint;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public ContentView(Context context) {
            super(context);
            this.actionBarSearchPaint = new Paint(1);
            this.windowBackgroundPaint = new Paint();
            this.pos = new int[2];
        }

        private boolean prepareForMoving(MotionEvent ev, boolean forward) {
            int nextPageId = DialogsActivity.this.filterTabsView.getNextPageId(forward);
            if (nextPageId < 0) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            DialogsActivity.this.maybeStartTracking = false;
            DialogsActivity.this.startedTracking = true;
            this.startedTrackingX = (int) (ev.getX() + DialogsActivity.this.additionalOffset);
            ((BaseFragment) DialogsActivity.this).actionBar.setEnabled(false);
            DialogsActivity.this.filterTabsView.setEnabled(false);
            DialogsActivity.this.viewPages[1].selectedType = nextPageId;
            DialogsActivity.this.viewPages[1].setVisibility(0);
            DialogsActivity.this.animatingForward = forward;
            DialogsActivity.this.showScrollbars(false);
            DialogsActivity.this.switchToCurrentSelectedMode(true);
            if (forward) {
                DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
            } else {
                DialogsActivity.this.viewPages[1].setTranslationX(-DialogsActivity.this.viewPages[0].getMeasuredWidth());
            }
            return true;
        }

        @Override // android.view.View
        public void setPadding(int left, int top, int right, int bottom) {
            DialogsActivity.this.topPadding = top;
            DialogsActivity.this.updateContextViewPosition();
            if (DialogsActivity.this.whiteActionBar && DialogsActivity.this.searchViewPager != null) {
                DialogsActivity.this.searchViewPager.setTranslationY(DialogsActivity.this.topPadding - DialogsActivity.this.lastMeasuredTopPadding);
            } else {
                requestLayout();
            }
        }

        public boolean checkTabsAnimationInProgress() {
            boolean z;
            if (!DialogsActivity.this.tabsAnimationInProgress) {
                return false;
            }
            if (DialogsActivity.this.backAnimation) {
                if (Math.abs(DialogsActivity.this.viewPages[0].getTranslationX()) < 1.0f) {
                    DialogsActivity.this.viewPages[0].setTranslationX(0.0f);
                    DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() * (DialogsActivity.this.animatingForward ? 1 : -1));
                    z = true;
                }
                z = false;
            } else {
                if (Math.abs(DialogsActivity.this.viewPages[1].getTranslationX()) < 1.0f) {
                    DialogsActivity.this.viewPages[0].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() * (DialogsActivity.this.animatingForward ? -1 : 1));
                    DialogsActivity.this.viewPages[1].setTranslationX(0.0f);
                    z = true;
                }
                z = false;
            }
            if (z) {
                DialogsActivity.this.showScrollbars(true);
                if (DialogsActivity.this.tabsAnimation != null) {
                    DialogsActivity.this.tabsAnimation.cancel();
                    DialogsActivity.this.tabsAnimation = null;
                }
                DialogsActivity.this.tabsAnimationInProgress = false;
            }
            return DialogsActivity.this.tabsAnimationInProgress;
        }

        public int getActionBarFullHeight() {
            float height = ((BaseFragment) DialogsActivity.this).actionBar.getHeight();
            float measuredHeight = 0.0f;
            float measuredHeight2 = (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() == 8) ? 0.0f : DialogsActivity.this.filterTabsView.getMeasuredHeight() - ((1.0f - DialogsActivity.this.filterTabsProgress) * DialogsActivity.this.filterTabsView.getMeasuredHeight());
            if (DialogsActivity.this.searchTabsView != null && DialogsActivity.this.searchTabsView.getVisibility() != 8) {
                measuredHeight = DialogsActivity.this.searchTabsView.getMeasuredHeight();
            }
            return (int) (height + (measuredHeight2 * (1.0f - DialogsActivity.this.searchAnimationProgress)) + (measuredHeight * DialogsActivity.this.searchAnimationProgress));
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            boolean zDrawChild;
            if ((child == DialogsActivity.this.fragmentContextView && DialogsActivity.this.fragmentContextView.isCallStyle()) || child == DialogsActivity.this.blurredView) {
                return true;
            }
            if (child != DialogsActivity.this.viewPages[0] && ((DialogsActivity.this.viewPages.length <= 1 || child != DialogsActivity.this.viewPages[1]) && child != DialogsActivity.this.fragmentContextView && child != DialogsActivity.this.fragmentLocationContextView && child != DialogsActivity.this.searchViewPager)) {
                if (child == ((BaseFragment) DialogsActivity.this).actionBar && DialogsActivity.this.slideFragmentProgress != 1.0f) {
                    canvas.save();
                    DialogsActivity dialogsActivity = DialogsActivity.this;
                    float f = 1.0f - ((1.0f - dialogsActivity.slideFragmentProgress) * 0.05f);
                    canvas.translate((dialogsActivity.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - DialogsActivity.this.slideFragmentProgress), 0.0f);
                    canvas.scale(f, f, DialogsActivity.this.isDrawerTransition ? getMeasuredWidth() : 0.0f, (((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + (ActionBar.getCurrentActionBarHeight() / 2.0f));
                    zDrawChild = super.drawChild(canvas, child, drawingTime);
                    canvas.restore();
                } else {
                    zDrawChild = super.drawChild(canvas, child, drawingTime);
                }
            } else {
                canvas.save();
                canvas.clipRect(0.0f, (-getY()) + ((BaseFragment) DialogsActivity.this).actionBar.getY() + getActionBarFullHeight(), getMeasuredWidth(), getMeasuredHeight());
                DialogsActivity dialogsActivity2 = DialogsActivity.this;
                float f2 = dialogsActivity2.slideFragmentProgress;
                if (f2 != 1.0f) {
                    float f3 = 1.0f - ((1.0f - f2) * 0.05f);
                    canvas.translate((dialogsActivity2.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - DialogsActivity.this.slideFragmentProgress), 0.0f);
                    canvas.scale(f3, f3, DialogsActivity.this.isDrawerTransition ? getMeasuredWidth() : 0.0f, (-getY()) + ((BaseFragment) DialogsActivity.this).actionBar.getY() + getActionBarFullHeight());
                }
                zDrawChild = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
            }
            if (child == ((BaseFragment) DialogsActivity.this).actionBar && ((BaseFragment) DialogsActivity.this).parentLayout != null) {
                int y = (int) (((BaseFragment) DialogsActivity.this).actionBar.getY() + getActionBarFullHeight());
                ((BaseFragment) DialogsActivity.this).parentLayout.drawHeaderShadow(canvas, (int) ((1.0f - DialogsActivity.this.searchAnimationProgress) * 255.0f), y);
                if (DialogsActivity.this.searchAnimationProgress > 0.0f && DialogsActivity.this.searchAnimationProgress < 1.0f) {
                    int alpha = Theme.dividerPaint.getAlpha();
                    Theme.dividerPaint.setAlpha((int) (alpha * DialogsActivity.this.searchAnimationProgress));
                    float f4 = y;
                    canvas.drawLine(0.0f, f4, getMeasuredWidth(), f4, Theme.dividerPaint);
                    Theme.dividerPaint.setAlpha(alpha);
                }
            }
            return zDrawChild;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int y;
            int actionBarFullHeight = getActionBarFullHeight();
            if (!((BaseFragment) DialogsActivity.this).inPreviewMode) {
                y = (int) ((-getY()) + ((BaseFragment) DialogsActivity.this).actionBar.getY());
            } else {
                y = AndroidUtilities.statusBarHeight;
            }
            int i = y;
            if (DialogsActivity.this.whiteActionBar) {
                if (DialogsActivity.this.searchAnimationProgress != 1.0f) {
                    if (DialogsActivity.this.searchAnimationProgress == 0.0f && DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                        DialogsActivity.this.filterTabsView.setTranslationY(((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
                    }
                } else {
                    this.actionBarSearchPaint.setColor(Theme.getColor("windowBackgroundWhite"));
                    if (DialogsActivity.this.searchTabsView != null) {
                        DialogsActivity.this.searchTabsView.setTranslationY(0.0f);
                        DialogsActivity.this.searchTabsView.setAlpha(1.0f);
                        if (DialogsActivity.this.filtersView != null) {
                            DialogsActivity.this.filtersView.setTranslationY(0.0f);
                            DialogsActivity.this.filtersView.setAlpha(1.0f);
                        }
                    }
                }
                float f = i;
                int i2 = i + actionBarFullHeight;
                float f2 = i2;
                canvas.drawRect(0.0f, f, getMeasuredWidth(), f2, DialogsActivity.this.searchAnimationProgress == 1.0f ? this.actionBarSearchPaint : DialogsActivity.this.actionBarDefaultPaint);
                if (DialogsActivity.this.searchAnimationProgress > 0.0f && DialogsActivity.this.searchAnimationProgress < 1.0f) {
                    this.actionBarSearchPaint.setColor(ColorUtils.blendARGB(Theme.getColor(DialogsActivity.this.folderId != 0 ? "actionBarDefaultArchived" : "actionBarDefault"), Theme.getColor("windowBackgroundWhite"), DialogsActivity.this.searchAnimationProgress));
                    if (DialogsActivity.this.searchIsShowed || !DialogsActivity.this.searchWasFullyShowed) {
                        canvas.save();
                        canvas.clipRect(0, i, getMeasuredWidth(), i2);
                        canvas.drawCircle(getMeasuredWidth() - AndroidUtilities.dp(24.0f), (((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ((((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight() - r2) / 2.0f), getMeasuredWidth() * 1.3f * DialogsActivity.this.searchAnimationProgress, this.actionBarSearchPaint);
                        canvas.restore();
                    } else {
                        canvas.drawRect(0.0f, f, getMeasuredWidth(), f2, this.actionBarSearchPaint);
                    }
                    if (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                        DialogsActivity.this.filterTabsView.setTranslationY(actionBarFullHeight - (((BaseFragment) DialogsActivity.this).actionBar.getHeight() + DialogsActivity.this.filterTabsView.getMeasuredHeight()));
                    }
                    if (DialogsActivity.this.searchTabsView != null) {
                        float height = actionBarFullHeight - (((BaseFragment) DialogsActivity.this).actionBar.getHeight() + DialogsActivity.this.searchTabsView.getMeasuredHeight());
                        float f3 = DialogsActivity.this.searchAnimationTabsDelayedCrossfade ? DialogsActivity.this.searchAnimationProgress < 0.5f ? 0.0f : (DialogsActivity.this.searchAnimationProgress - 0.5f) / 0.5f : DialogsActivity.this.searchAnimationProgress;
                        DialogsActivity.this.searchTabsView.setTranslationY(height);
                        DialogsActivity.this.searchTabsView.setAlpha(f3);
                        if (DialogsActivity.this.filtersView != null) {
                            DialogsActivity.this.filtersView.setTranslationY(height);
                            DialogsActivity.this.filtersView.setAlpha(f3);
                        }
                    }
                }
            } else if (!((BaseFragment) DialogsActivity.this).inPreviewMode) {
                if (DialogsActivity.this.progressToActionMode > 0.0f) {
                    this.actionBarSearchPaint.setColor(ColorUtils.blendARGB(Theme.getColor(DialogsActivity.this.folderId != 0 ? "actionBarDefaultArchived" : "actionBarDefault"), Theme.getColor("windowBackgroundWhite"), DialogsActivity.this.progressToActionMode));
                    canvas.drawRect(0.0f, i, getMeasuredWidth(), i + actionBarFullHeight, this.actionBarSearchPaint);
                } else {
                    canvas.drawRect(0.0f, i, getMeasuredWidth(), i + actionBarFullHeight, DialogsActivity.this.actionBarDefaultPaint);
                }
            }
            DialogsActivity.this.tabsYOffset = 0.0f;
            if (DialogsActivity.this.filtersTabAnimator == null || DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0) {
                if (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                    DialogsActivity.this.filterTabsView.setTranslationY(((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
                    DialogsActivity.this.filterTabsView.setAlpha(1.0f);
                }
            } else {
                DialogsActivity dialogsActivity = DialogsActivity.this;
                dialogsActivity.tabsYOffset = (-(1.0f - dialogsActivity.filterTabsProgress)) * DialogsActivity.this.filterTabsView.getMeasuredHeight();
                DialogsActivity.this.filterTabsView.setTranslationY(((BaseFragment) DialogsActivity.this).actionBar.getTranslationY() + DialogsActivity.this.tabsYOffset);
                DialogsActivity.this.filterTabsView.setAlpha(DialogsActivity.this.filterTabsProgress);
                DialogsActivity.this.viewPages[0].setTranslationY((-(1.0f - DialogsActivity.this.filterTabsProgress)) * DialogsActivity.this.filterTabsMoveFrom);
            }
            DialogsActivity.this.updateContextViewPosition();
            super.dispatchDraw(canvas);
            if (DialogsActivity.this.whiteActionBar && DialogsActivity.this.searchAnimationProgress > 0.0f && DialogsActivity.this.searchAnimationProgress < 1.0f && DialogsActivity.this.searchTabsView != null) {
                this.windowBackgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
                this.windowBackgroundPaint.setAlpha((int) (r1.getAlpha() * DialogsActivity.this.searchAnimationProgress));
                canvas.drawRect(0.0f, actionBarFullHeight + i, getMeasuredWidth(), i + ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight() + DialogsActivity.this.searchTabsView.getMeasuredHeight(), this.windowBackgroundPaint);
            }
            if (DialogsActivity.this.fragmentContextView != null && DialogsActivity.this.fragmentContextView.isCallStyle()) {
                canvas.save();
                canvas.translate(DialogsActivity.this.fragmentContextView.getX(), DialogsActivity.this.fragmentContextView.getY());
                DialogsActivity dialogsActivity2 = DialogsActivity.this;
                float f4 = dialogsActivity2.slideFragmentProgress;
                if (f4 != 1.0f) {
                    float f5 = 1.0f - ((1.0f - f4) * 0.05f);
                    canvas.translate((dialogsActivity2.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - DialogsActivity.this.slideFragmentProgress), 0.0f);
                    canvas.scale(f5, 1.0f, DialogsActivity.this.isDrawerTransition ? getMeasuredWidth() : 0.0f, DialogsActivity.this.fragmentContextView.getY());
                }
                DialogsActivity.this.fragmentContextView.setDrawOverlay(true);
                DialogsActivity.this.fragmentContextView.draw(canvas);
                DialogsActivity.this.fragmentContextView.setDrawOverlay(false);
                canvas.restore();
            }
            if (DialogsActivity.this.blurredView != null && DialogsActivity.this.blurredView.getVisibility() == 0) {
                if (DialogsActivity.this.blurredView.getAlpha() == 1.0f) {
                    DialogsActivity.this.blurredView.draw(canvas);
                } else if (DialogsActivity.this.blurredView.getAlpha() != 0.0f) {
                    canvas.saveLayerAlpha(DialogsActivity.this.blurredView.getLeft(), DialogsActivity.this.blurredView.getTop(), DialogsActivity.this.blurredView.getRight(), DialogsActivity.this.blurredView.getBottom(), (int) (DialogsActivity.this.blurredView.getAlpha() * 255.0f), 31);
                    canvas.translate(DialogsActivity.this.blurredView.getLeft(), DialogsActivity.this.blurredView.getTop());
                    DialogsActivity.this.blurredView.draw(canvas);
                    canvas.restore();
                }
            }
            if (DialogsActivity.this.scrimView != null) {
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), DialogsActivity.this.scrimPaint);
                canvas.save();
                getLocationInWindow(this.pos);
                canvas.translate(DialogsActivity.this.scrimViewLocation[0] - this.pos[0], DialogsActivity.this.scrimViewLocation[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0));
                DialogsActivity.this.scrimView.draw(canvas);
                if (DialogsActivity.this.scrimViewSelected) {
                    Drawable selectorDrawable = DialogsActivity.this.filterTabsView.getSelectorDrawable();
                    canvas.translate(-DialogsActivity.this.scrimViewLocation[0], (-selectorDrawable.getIntrinsicHeight()) - 1);
                    selectorDrawable.draw(canvas);
                }
                canvas.restore();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int i;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            setMeasuredDimension(size, size2);
            int paddingTop = size2 - getPaddingTop();
            if (DialogsActivity.this.doneItem != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) DialogsActivity.this.doneItem.getLayoutParams();
                layoutParams.topMargin = ((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0;
                layoutParams.height = ActionBar.getCurrentActionBarHeight();
            }
            measureChildWithMargins(((BaseFragment) DialogsActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
            int iMeasureKeyboardHeight = measureKeyboardHeight();
            int childCount = getChildCount();
            float f = 0.0f;
            if (DialogsActivity.this.commentView != null) {
                measureChildWithMargins(DialogsActivity.this.commentView, widthMeasureSpec, 0, heightMeasureSpec, 0);
                Object tag = DialogsActivity.this.commentView.getTag();
                if (tag != null && tag.equals(2)) {
                    if (iMeasureKeyboardHeight <= AndroidUtilities.dp(20.0f) && !AndroidUtilities.isInMultiwindow) {
                        paddingTop -= DialogsActivity.this.commentView.getEmojiPadding();
                    }
                    this.inputFieldHeight = DialogsActivity.this.commentView.getMeasuredHeight();
                } else {
                    this.inputFieldHeight = 0;
                }
                if (SharedConfig.smoothKeyboard && DialogsActivity.this.commentView.isPopupShowing()) {
                    ((BaseFragment) DialogsActivity.this).fragmentView.setTranslationY(0.0f);
                    for (int i2 = 0; i2 < DialogsActivity.this.viewPages.length; i2++) {
                        if (DialogsActivity.this.viewPages[i2] != null) {
                            DialogsActivity.this.viewPages[i2].setTranslationY(0.0f);
                        }
                    }
                    if (!DialogsActivity.this.onlySelect) {
                        ((BaseFragment) DialogsActivity.this).actionBar.setTranslationY(0.0f);
                    }
                    DialogsActivity.this.searchViewPager.setTranslationY(0.0f);
                }
            }
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && childAt != DialogsActivity.this.commentView && childAt != ((BaseFragment) DialogsActivity.this).actionBar) {
                    if (childAt instanceof DatabaseMigrationHint) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), (((View.MeasureSpec.getSize(heightMeasureSpec) + iMeasureKeyboardHeight) - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight()), 1073741824));
                    } else if (!(childAt instanceof ViewPage)) {
                        if (childAt == DialogsActivity.this.searchViewPager) {
                            DialogsActivity.this.searchViewPager.setTranslationY(0.0f);
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((Math.max(AndroidUtilities.dp(10.0f), ((((View.MeasureSpec.getSize(heightMeasureSpec) + iMeasureKeyboardHeight) - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - (DialogsActivity.this.onlySelect ? 0 : ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight())) - DialogsActivity.this.topPadding) - (DialogsActivity.this.searchTabsView == null ? 0 : AndroidUtilities.dp(50.0f))) - ((DialogsActivity.searchToolsCell == null || DialogsActivity.searchToolsCell.getVisibility() == 8) ? 0 : AndroidUtilities.dp(50.0f)), 1073741824));
                            childAt.setPivotX(childAt.getMeasuredWidth() / 2);
                        } else if (DialogsActivity.this.commentView != null && DialogsActivity.this.commentView.isPopupView(childAt)) {
                            if (AndroidUtilities.isInMultiwindow) {
                                if (AndroidUtilities.isTablet()) {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(320.0f), ((paddingTop - this.inputFieldHeight) - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(((paddingTop - this.inputFieldHeight) - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                }
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                            }
                        } else {
                            measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                        }
                    } else {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        if (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0) {
                            iDp = ((paddingTop - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - (DialogsActivity.this.onlySelect ? 0 : ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight());
                            i = DialogsActivity.this.topPadding;
                        } else {
                            iDp = ((paddingTop - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - AndroidUtilities.dp(44.0f);
                            i = DialogsActivity.this.topPadding;
                        }
                        int i4 = iDp - i;
                        if (DialogsActivity.this.filtersTabAnimator != null && DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                            i4 = (int) (i4 + DialogsActivity.this.filterTabsMoveFrom);
                        } else {
                            childAt.setTranslationY(f);
                        }
                        DialogsActivity dialogsActivity = DialogsActivity.this;
                        int i5 = (dialogsActivity.isSlideBackTransition || dialogsActivity.isDrawerTransition) ? (int) (i4 * 0.05f) : 0;
                        childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), i5);
                        childAt.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), i4 + i5), 1073741824));
                        childAt.setPivotX(childAt.getMeasuredWidth() / 2);
                    }
                }
                i3++;
                f = 0.0f;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x021b  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 603
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.ContentView.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            int actionMasked = ev.getActionMasked();
            if ((actionMasked == 1 || actionMasked == 3) && ((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                DialogsActivity.this.allowMoving = true;
            }
            if (checkTabsAnimationInProgress()) {
                return true;
            }
            return (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.isAnimatingIndicator()) || onTouchEvent(ev);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            if (DialogsActivity.this.maybeStartTracking && !DialogsActivity.this.startedTracking) {
                onTouchEvent(null);
            }
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent ev) {
            float xVelocity;
            float yVelocity;
            float measuredWidth;
            int measuredWidth2;
            if (((BaseFragment) DialogsActivity.this).parentLayout == null || DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.isEditing() || DialogsActivity.this.searching || ((BaseFragment) DialogsActivity.this).parentLayout.checkTransitionAnimation() || ((BaseFragment) DialogsActivity.this).parentLayout.isInPreviewMode() || ((BaseFragment) DialogsActivity.this).parentLayout.isPreviewOpenAnimationInProgress() || ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().isDrawerOpened() || !((ev == null || DialogsActivity.this.startedTracking || ev.getY() > ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) DialogsActivity.this).actionBar.getTranslationY()) && SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 5)) {
                return false;
            }
            if (ev != null) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.addMovement(ev);
            }
            if (ev != null && ev.getAction() == 0 && checkTabsAnimationInProgress()) {
                DialogsActivity.this.startedTracking = true;
                this.startedTrackingPointerId = ev.getPointerId(0);
                this.startedTrackingX = (int) ev.getX();
                ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(false);
                if (DialogsActivity.this.animatingForward) {
                    if (this.startedTrackingX >= DialogsActivity.this.viewPages[0].getMeasuredWidth() + DialogsActivity.this.viewPages[0].getTranslationX()) {
                        ViewPage viewPage = DialogsActivity.this.viewPages[0];
                        DialogsActivity.this.viewPages[0] = DialogsActivity.this.viewPages[1];
                        DialogsActivity.this.viewPages[1] = viewPage;
                        DialogsActivity.this.animatingForward = false;
                        DialogsActivity dialogsActivity = DialogsActivity.this;
                        dialogsActivity.additionalOffset = dialogsActivity.viewPages[0].getTranslationX();
                        DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[0].selectedType, 1.0f);
                        DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[1].selectedType, DialogsActivity.this.additionalOffset / DialogsActivity.this.viewPages[0].getMeasuredWidth());
                        DialogsActivity.this.switchToCurrentSelectedMode(true);
                        DialogsActivity.this.viewPages[0].dialogsAdapter.resume();
                        DialogsActivity.this.viewPages[1].dialogsAdapter.pause();
                    } else {
                        DialogsActivity dialogsActivity2 = DialogsActivity.this;
                        dialogsActivity2.additionalOffset = dialogsActivity2.viewPages[0].getTranslationX();
                    }
                } else if (this.startedTrackingX < DialogsActivity.this.viewPages[1].getMeasuredWidth() + DialogsActivity.this.viewPages[1].getTranslationX()) {
                    ViewPage viewPage2 = DialogsActivity.this.viewPages[0];
                    DialogsActivity.this.viewPages[0] = DialogsActivity.this.viewPages[1];
                    DialogsActivity.this.viewPages[1] = viewPage2;
                    DialogsActivity.this.animatingForward = true;
                    DialogsActivity dialogsActivity3 = DialogsActivity.this;
                    dialogsActivity3.additionalOffset = dialogsActivity3.viewPages[0].getTranslationX();
                    DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[0].selectedType, 1.0f);
                    DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[1].selectedType, (-DialogsActivity.this.additionalOffset) / DialogsActivity.this.viewPages[0].getMeasuredWidth());
                    DialogsActivity.this.switchToCurrentSelectedMode(true);
                    DialogsActivity.this.viewPages[0].dialogsAdapter.resume();
                    DialogsActivity.this.viewPages[1].dialogsAdapter.pause();
                } else {
                    DialogsActivity dialogsActivity4 = DialogsActivity.this;
                    dialogsActivity4.additionalOffset = dialogsActivity4.viewPages[0].getTranslationX();
                }
                DialogsActivity.this.tabsAnimation.removeAllListeners();
                DialogsActivity.this.tabsAnimation.cancel();
                DialogsActivity.this.tabsAnimationInProgress = false;
            } else if (ev != null && ev.getAction() == 0) {
                DialogsActivity.this.additionalOffset = 0.0f;
            }
            if (ev != null && ev.getAction() == 0 && !DialogsActivity.this.startedTracking && !DialogsActivity.this.maybeStartTracking && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                this.startedTrackingPointerId = ev.getPointerId(0);
                DialogsActivity.this.maybeStartTracking = true;
                this.startedTrackingX = (int) ev.getX();
                this.startedTrackingY = (int) ev.getY();
                this.velocityTracker.clear();
            } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                int x = (int) ((ev.getX() - this.startedTrackingX) + DialogsActivity.this.additionalOffset);
                int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                if (DialogsActivity.this.startedTracking && ((DialogsActivity.this.animatingForward && x > 0) || (!DialogsActivity.this.animatingForward && x < 0))) {
                    if (!prepareForMoving(ev, x < 0)) {
                        DialogsActivity.this.maybeStartTracking = true;
                        DialogsActivity.this.startedTracking = false;
                        DialogsActivity.this.viewPages[0].setTranslationX(0.0f);
                        DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.animatingForward ? DialogsActivity.this.viewPages[0].getMeasuredWidth() : -DialogsActivity.this.viewPages[0].getMeasuredWidth());
                        DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[1].selectedType, 0.0f);
                    }
                }
                if (!DialogsActivity.this.maybeStartTracking || DialogsActivity.this.startedTracking) {
                    if (DialogsActivity.this.startedTracking) {
                        DialogsActivity.this.viewPages[0].setTranslationX(x);
                        if (DialogsActivity.this.animatingForward) {
                            DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() + x);
                        } else {
                            DialogsActivity.this.viewPages[1].setTranslationX(x - DialogsActivity.this.viewPages[0].getMeasuredWidth());
                        }
                        DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[1].selectedType, Math.abs(x) / DialogsActivity.this.viewPages[0].getMeasuredWidth());
                    }
                } else {
                    float pixelsInCM = AndroidUtilities.getPixelsInCM(0.3f, true);
                    int x2 = (int) (ev.getX() - this.startedTrackingX);
                    if (Math.abs(x2) >= pixelsInCM && Math.abs(x2) > iAbs) {
                        prepareForMoving(ev, x < 0);
                    }
                }
            } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                this.velocityTracker.computeCurrentVelocity(1000, DialogsActivity.this.maximumVelocity);
                if (ev == null || ev.getAction() == 3) {
                    xVelocity = 0.0f;
                    yVelocity = 0.0f;
                } else {
                    xVelocity = this.velocityTracker.getXVelocity();
                    yVelocity = this.velocityTracker.getYVelocity();
                    if (!DialogsActivity.this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                        prepareForMoving(ev, xVelocity < 0.0f);
                    }
                }
                if (DialogsActivity.this.startedTracking) {
                    float x3 = DialogsActivity.this.viewPages[0].getX();
                    DialogsActivity.this.tabsAnimation = new AnimatorSet();
                    if (DialogsActivity.this.additionalOffset == 0.0f) {
                        DialogsActivity.this.backAnimation = Math.abs(x3) < ((float) DialogsActivity.this.viewPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                    } else if (Math.abs(xVelocity) <= 1500.0f) {
                        if (DialogsActivity.this.animatingForward) {
                            DialogsActivity dialogsActivity5 = DialogsActivity.this;
                            dialogsActivity5.backAnimation = dialogsActivity5.viewPages[1].getX() > ((float) (DialogsActivity.this.viewPages[0].getMeasuredWidth() >> 1));
                        } else {
                            DialogsActivity dialogsActivity6 = DialogsActivity.this;
                            dialogsActivity6.backAnimation = dialogsActivity6.viewPages[0].getX() < ((float) (DialogsActivity.this.viewPages[0].getMeasuredWidth() >> 1));
                        }
                    } else {
                        DialogsActivity dialogsActivity7 = DialogsActivity.this;
                        dialogsActivity7.backAnimation = !dialogsActivity7.animatingForward ? xVelocity >= 0.0f : xVelocity <= 0.0f;
                    }
                    if (!DialogsActivity.this.backAnimation) {
                        measuredWidth = DialogsActivity.this.viewPages[0].getMeasuredWidth() - Math.abs(x3);
                        if (DialogsActivity.this.animatingForward) {
                            DialogsActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, -DialogsActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                        } else {
                            DialogsActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, DialogsActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                        }
                    } else {
                        measuredWidth = Math.abs(x3);
                        if (DialogsActivity.this.animatingForward) {
                            DialogsActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, DialogsActivity.this.viewPages[1].getMeasuredWidth()));
                        } else {
                            DialogsActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DialogsActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, -DialogsActivity.this.viewPages[1].getMeasuredWidth()));
                        }
                    }
                    DialogsActivity.this.tabsAnimation.setInterpolator(DialogsActivity.interpolator);
                    int measuredWidth3 = getMeasuredWidth();
                    float f = measuredWidth3 / 2;
                    float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                    float fAbs = Math.abs(xVelocity);
                    if (fAbs > 0.0f) {
                        measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                    } else {
                        measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                    }
                    DialogsActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                    DialogsActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.ContentView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            DialogsActivity.this.tabsAnimation = null;
                            if (!DialogsActivity.this.backAnimation) {
                                ViewPage viewPage3 = DialogsActivity.this.viewPages[0];
                                DialogsActivity.this.viewPages[0] = DialogsActivity.this.viewPages[1];
                                DialogsActivity.this.viewPages[1] = viewPage3;
                                DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[0].selectedType, 1.0f);
                                DialogsActivity.this.updateCounters(false);
                                DialogsActivity.this.viewPages[0].dialogsAdapter.resume();
                                DialogsActivity.this.viewPages[1].dialogsAdapter.pause();
                            }
                            if (((BaseFragment) DialogsActivity.this).parentLayout != null) {
                                ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(DialogsActivity.this.viewPages[0].selectedType == DialogsActivity.this.filterTabsView.getFirstTabId() || DialogsActivity.this.searchIsShowed || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 5);
                            }
                            DialogsActivity.this.viewPages[1].setVisibility(8);
                            DialogsActivity.this.showScrollbars(true);
                            DialogsActivity.this.tabsAnimationInProgress = false;
                            DialogsActivity.this.maybeStartTracking = false;
                            ((BaseFragment) DialogsActivity.this).actionBar.setEnabled(true);
                            DialogsActivity.this.filterTabsView.setEnabled(true);
                            DialogsActivity dialogsActivity8 = DialogsActivity.this;
                            dialogsActivity8.checkListLoad(dialogsActivity8.viewPages[0]);
                        }
                    });
                    DialogsActivity.this.tabsAnimation.start();
                    DialogsActivity.this.tabsAnimationInProgress = true;
                    DialogsActivity.this.startedTracking = false;
                } else {
                    ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(DialogsActivity.this.viewPages[0].selectedType == DialogsActivity.this.filterTabsView.getFirstTabId() || DialogsActivity.this.searchIsShowed || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 5);
                    DialogsActivity.this.maybeStartTracking = false;
                    ((BaseFragment) DialogsActivity.this).actionBar.setEnabled(true);
                    DialogsActivity.this.filterTabsView.setEnabled(true);
                }
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
            }
            return DialogsActivity.this.startedTracking;
        }
    }

    public class DialogsRecyclerView extends RecyclerListView {
        private int appliedPaddingTop;
        private boolean firstLayout;
        private boolean ignoreLayout;
        private int lastListPadding;
        private int lastTop;
        Paint paint;
        private final ViewPage parentPage;
        RectF rectF;

        @Override // ir.eitaa.ui.Components.RecyclerListView
        protected boolean updateEmptyViewAnimated() {
            return true;
        }

        public DialogsRecyclerView(Context context, ViewPage page) {
            super(context);
            this.firstLayout = true;
            this.paint = new Paint();
            this.rectF = new RectF();
            this.parentPage = page;
        }

        public void setViewsOffset(float viewOffset) {
            View viewFindViewByPosition;
            DialogsActivity.viewOffset = viewOffset;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setTranslationY(viewOffset);
            }
            if (this.selectorPosition != -1 && (viewFindViewByPosition = getLayoutManager().findViewByPosition(this.selectorPosition)) != null) {
                this.selectorRect.set(viewFindViewByPosition.getLeft(), (int) (viewFindViewByPosition.getTop() + viewOffset), viewFindViewByPosition.getRight(), (int) (viewFindViewByPosition.getBottom() + viewOffset));
                this.selectorDrawable.setBounds(this.selectorRect);
            }
            invalidate();
        }

        public float getViewOffset() {
            return DialogsActivity.viewOffset;
        }

        @Override // android.view.ViewGroup
        public void addView(View child, int index, ViewGroup.LayoutParams params) {
            super.addView(child, index, params);
            child.setTranslationY(DialogsActivity.viewOffset);
            child.setTranslationX(0.0f);
            child.setAlpha(1.0f);
        }

        @Override // android.view.ViewGroup, android.view.ViewManager
        public void removeView(View view) {
            super.removeView(view);
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onDraw(Canvas canvas) {
            if (this.parentPage.pullForegroundDrawable != null && DialogsActivity.viewOffset != 0.0f) {
                int paddingTop = getPaddingTop();
                if (paddingTop != 0) {
                    canvas.save();
                    canvas.translate(0.0f, paddingTop);
                }
                this.parentPage.pullForegroundDrawable.drawOverScroll(canvas);
                if (paddingTop != 0) {
                    canvas.restore();
                }
            }
            super.onDraw(canvas);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.parentPage.recyclerItemsEnterAnimator.dispatchDraw();
            super.dispatchDraw(canvas);
            if (drawMovingViewsOverlayed()) {
                this.paint.setColor(Theme.getColor("windowBackgroundWhite"));
                for (int i = 0; i < getChildCount(); i++) {
                    View childAt = getChildAt(i);
                    if (((childAt instanceof DialogCell) && ((DialogCell) childAt).isMoving()) || ((childAt instanceof DialogsAdapter.LastEmptyView) && ((DialogsAdapter.LastEmptyView) childAt).moving)) {
                        if (childAt.getAlpha() != 1.0f) {
                            this.rectF.set(childAt.getX(), childAt.getY(), childAt.getX() + childAt.getMeasuredWidth(), childAt.getY() + childAt.getMeasuredHeight());
                            canvas.saveLayerAlpha(this.rectF, (int) (childAt.getAlpha() * 255.0f), 31);
                        } else {
                            canvas.save();
                        }
                        canvas.translate(childAt.getX(), childAt.getY());
                        canvas.drawRect(0.0f, 0.0f, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.paint);
                        childAt.draw(canvas);
                        canvas.restore();
                    }
                }
                invalidate();
            }
            if (DialogsActivity.this.slidingView == null || DialogsActivity.this.pacmanAnimation == null) {
                return;
            }
            DialogsActivity.this.pacmanAnimation.draw(canvas, DialogsActivity.this.slidingView.getTop() + (DialogsActivity.this.slidingView.getMeasuredHeight() / 2));
        }

        private boolean drawMovingViewsOverlayed() {
            return (getItemAnimator() == null || !getItemAnimator().isRunning() || (DialogsActivity.this.dialogRemoveFinished == 0 && DialogsActivity.this.dialogInsertFinished == 0 && DialogsActivity.this.dialogChangeFinished == 0)) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (drawMovingViewsOverlayed() && (child instanceof DialogCell) && ((DialogCell) child).isMoving()) {
                return true;
            }
            return super.drawChild(canvas, child, drawingTime);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            ViewPage viewPage = this.parentPage;
            if (viewPage == null || viewPage.recyclerItemsEnterAnimator == null) {
                return;
            }
            this.parentPage.recyclerItemsEnterAnimator.onDetached();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView
        public void setAdapter(RecyclerView.Adapter adapter) {
            super.setAdapter(adapter);
            this.firstLayout = true;
        }

        private void checkIfAdapterValid() {
            RecyclerView.Adapter adapter = getAdapter();
            if (this.parentPage.lastItemsCount == adapter.getItemCount() || DialogsActivity.this.dialogsListFrozen) {
                return;
            }
            this.ignoreLayout = true;
            adapter.notifyDataSetChanged();
            this.ignoreLayout = false;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
        protected void onMeasure(int widthSpec, int heightSpec) {
            int currentActionBarHeight;
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
            if (DialogsActivity.this.onlySelect) {
                currentActionBarHeight = 0;
            } else if (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0) {
                currentActionBarHeight = ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight();
            } else {
                currentActionBarHeight = AndroidUtilities.dp(44.0f);
            }
            int iFindFirstVisibleItemPosition = this.parentPage.layoutManager.findFirstVisibleItemPosition();
            if (iFindFirstVisibleItemPosition != -1 && !DialogsActivity.this.dialogsListFrozen && this.parentPage.itemTouchhelper.isIdle() && (viewHolderFindViewHolderForAdapterPosition = this.parentPage.listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) != null) {
                int top = viewHolderFindViewHolderForAdapterPosition.itemView.getTop();
                this.ignoreLayout = true;
                this.parentPage.layoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, (int) ((top - this.lastListPadding) + DialogsActivity.this.scrollAdditionalOffset));
                this.ignoreLayout = false;
            }
            if (!DialogsActivity.this.onlySelect) {
                this.ignoreLayout = true;
                if (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0) {
                    currentActionBarHeight = (!((BaseFragment) DialogsActivity.this).inPreviewMode || Build.VERSION.SDK_INT < 21) ? 0 : AndroidUtilities.statusBarHeight;
                } else {
                    currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
                }
                setTopGlowOffset(currentActionBarHeight);
                setPadding(0, currentActionBarHeight, 0, 0);
                this.parentPage.progressView.setPaddingTop(currentActionBarHeight);
                this.ignoreLayout = false;
            }
            if (this.firstLayout && DialogsActivity.this.getMessagesController().dialogsLoaded) {
                if (this.parentPage.dialogsType == 0 && DialogsActivity.this.hasHiddenArchive()) {
                    this.ignoreLayout = true;
                    ((LinearLayoutManager) getLayoutManager()).scrollToPositionWithOffset(1, (int) ((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
                    this.ignoreLayout = false;
                }
                this.firstLayout = false;
            }
            checkIfAdapterValid();
            super.onMeasure(widthSpec, heightSpec);
            if (DialogsActivity.this.onlySelect || this.appliedPaddingTop == currentActionBarHeight || DialogsActivity.this.viewPages == null || DialogsActivity.this.viewPages.length <= 1) {
                return;
            }
            DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            this.lastListPadding = getPaddingTop();
            this.lastTop = t;
            DialogsActivity.this.scrollAdditionalOffset = 0.0f;
            if ((DialogsActivity.this.dialogRemoveFinished == 0 && DialogsActivity.this.dialogInsertFinished == 0 && DialogsActivity.this.dialogChangeFinished == 0) || this.parentPage.dialogsItemAnimator.isRunning()) {
                return;
            }
            DialogsActivity.this.onDialogAnimationFinished();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toggleArchiveHidden(boolean action, DialogCell dialogCell) {
            SharedConfig.toggleArchiveHidden();
            if (SharedConfig.archiveHidden) {
                if (dialogCell != null) {
                    DialogsActivity.this.disableActionBarScrolling = true;
                    DialogsActivity.this.waitingForScrollFinished = true;
                    smoothScrollBy(0, dialogCell.getMeasuredHeight() + (dialogCell.getTop() - getPaddingTop()), CubicBezierInterpolator.EASE_OUT);
                    if (action) {
                        DialogsActivity.this.updatePullAfterScroll = true;
                    } else {
                        updatePullState();
                    }
                }
                DialogsActivity.this.getUndoView().showWithAction(0L, 6, null, null);
                return;
            }
            DialogsActivity.this.getUndoView().showWithAction(0L, 7, null, null);
            updatePullState();
            if (!action || dialogCell == null) {
                return;
            }
            dialogCell.resetPinnedArchiveState();
            dialogCell.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePullState() {
            this.parentPage.archivePullViewState = SharedConfig.archiveHidden ? 2 : 0;
            if (this.parentPage.pullForegroundDrawable != null) {
                this.parentPage.pullForegroundDrawable.setWillDraw(this.parentPage.archivePullViewState != 0);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            LinearLayoutManager linearLayoutManager;
            int iFindFirstVisibleItemPosition;
            if (this.fastScrollAnimationRunning || DialogsActivity.this.waitingForScrollFinished || DialogsActivity.this.dialogRemoveFinished != 0 || DialogsActivity.this.dialogInsertFinished != 0 || DialogsActivity.this.dialogChangeFinished != 0) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                setOverScrollMode(0);
            }
            if ((action == 1 || action == 3) && !this.parentPage.itemTouchhelper.isIdle() && this.parentPage.swipeController.swipingFolder) {
                this.parentPage.swipeController.swipeFolderBack = true;
                if (this.parentPage.itemTouchhelper.checkHorizontalSwipe(null, 4) != 0 && this.parentPage.swipeController.currentItemViewHolder != null) {
                    View view = this.parentPage.swipeController.currentItemViewHolder.itemView;
                    if (view instanceof DialogCell) {
                        DialogCell dialogCell = (DialogCell) view;
                        long dialogId = dialogCell.getDialogId();
                        if (DialogObject.isFolderDialogId(dialogId)) {
                            toggleArchiveHidden(false, dialogCell);
                        } else {
                            DialogsActivity dialogsActivity = DialogsActivity.this;
                            TLRPC$Dialog tLRPC$Dialog = dialogsActivity.getDialogsArray(((BaseFragment) dialogsActivity).currentAccount, this.parentPage.dialogsType, DialogsActivity.this.folderId, false).get(dialogCell.getDialogIndex());
                            if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 1) {
                                if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 3) {
                                    if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 0) {
                                        if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 4) {
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(Long.valueOf(dialogId));
                                            DialogsActivity.this.performSelectedDialogsAction(arrayList, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, true);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(Long.valueOf(dialogId));
                                        DialogsActivity.this.canPinCount = !DialogsActivity.this.isDialogPinned(tLRPC$Dialog) ? 1 : 0;
                                        DialogsActivity.this.performSelectedDialogsAction(arrayList2, 100, true);
                                    }
                                } else if (!DialogsActivity.this.getMessagesController().isDialogMuted(dialogId)) {
                                    NotificationsController.getInstance(UserConfig.selectedAccount).setDialogNotificationsSettings(dialogId, 3);
                                    if (BulletinFactory.canShowBulletin(DialogsActivity.this)) {
                                        BulletinFactory.createMuteBulletin(DialogsActivity.this, 3).show();
                                    }
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    arrayList3.add(Long.valueOf(dialogId));
                                    DialogsActivity dialogsActivity2 = DialogsActivity.this;
                                    dialogsActivity2.canMuteCount = !MessagesController.getInstance(((BaseFragment) dialogsActivity2).currentAccount).isDialogMuted(dialogId) ? 1 : 0;
                                    DialogsActivity dialogsActivity3 = DialogsActivity.this;
                                    dialogsActivity3.canUnmuteCount = dialogsActivity3.canMuteCount > 0 ? 0 : 1;
                                    DialogsActivity.this.performSelectedDialogsAction(arrayList3, R.styleable.AppCompatTheme_textColorAlertDialogListItem, true);
                                }
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(Long.valueOf(dialogId));
                                DialogsActivity.this.canReadCount = (tLRPC$Dialog.unread_count > 0 || tLRPC$Dialog.unread_mark) ? 1 : 0;
                                DialogsActivity.this.performSelectedDialogsAction(arrayList4, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, true);
                            }
                        }
                    }
                }
            }
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (this.parentPage.dialogsType == 0 && ((action == 1 || action == 3) && this.parentPage.archivePullViewState == 2 && DialogsActivity.this.hasHiddenArchive() && (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition()) == 0)) {
                int paddingTop = getPaddingTop();
                View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
                int iDp = (int) (AndroidUtilities.dp(SharedConfig.useThreeLinesLayout ? 78.0f : 72.0f) * 0.85f);
                int top = (viewFindViewByPosition.getTop() - paddingTop) + viewFindViewByPosition.getMeasuredHeight();
                long jCurrentTimeMillis = System.currentTimeMillis() - DialogsActivity.this.startArchivePullingTime;
                if (top < iDp || jCurrentTimeMillis < 200) {
                    DialogsActivity.this.disableActionBarScrolling = true;
                    smoothScrollBy(0, top, CubicBezierInterpolator.EASE_OUT_QUINT);
                    this.parentPage.archivePullViewState = 2;
                } else if (this.parentPage.archivePullViewState != 1) {
                    if (getViewOffset() == 0.0f) {
                        DialogsActivity.this.disableActionBarScrolling = true;
                        smoothScrollBy(0, viewFindViewByPosition.getTop() - paddingTop, CubicBezierInterpolator.EASE_OUT_QUINT);
                    }
                    if (!DialogsActivity.this.canShowHiddenArchive) {
                        DialogsActivity.this.canShowHiddenArchive = true;
                        performHapticFeedback(3, 2);
                        if (this.parentPage.pullForegroundDrawable != null) {
                            this.parentPage.pullForegroundDrawable.colorize(true);
                        }
                    }
                    ((DialogCell) viewFindViewByPosition).startOutAnimation();
                    this.parentPage.archivePullViewState = 1;
                }
                if (getViewOffset() != 0.0f) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getViewOffset(), 0.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$DialogsRecyclerView$ajU4zh8Ux4PmzwW36MQ2TY3Cl6o
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$onTouchEvent$0$DialogsActivity$DialogsRecyclerView(valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.setDuration(Math.max(100L, (long) (350.0f - ((getViewOffset() / PullForegroundDrawable.getMaxOverscroll()) * 120.0f))));
                    valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    setScrollEnabled(false);
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.DialogsRecyclerView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            DialogsRecyclerView.this.setScrollEnabled(true);
                        }
                    });
                    valueAnimatorOfFloat.start();
                }
            }
            return zOnTouchEvent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTouchEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$0$DialogsActivity$DialogsRecyclerView(ValueAnimator valueAnimator) {
            setViewsOffset(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent e) {
            if (this.fastScrollAnimationRunning || DialogsActivity.this.waitingForScrollFinished || DialogsActivity.this.dialogRemoveFinished != 0 || DialogsActivity.this.dialogInsertFinished != 0 || DialogsActivity.this.dialogChangeFinished != 0) {
                return false;
            }
            if (e.getAction() == 0) {
                DialogsActivity.this.allowSwipeDuringCurrentTouch = !((BaseFragment) r0).actionBar.isActionModeShowed();
                checkIfAdapterValid();
            }
            return super.onInterceptTouchEvent(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SwipeController extends ItemTouchHelper.Callback {
        private RecyclerView.ViewHolder currentItemViewHolder;
        private ViewPage parentPage;
        private boolean swipeFolderBack;
        private boolean swipingFolder;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeEscapeVelocity(float defaultValue) {
            return 3500.0f;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.45f;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeVelocityThreshold(float defaultValue) {
            return Float.MAX_VALUE;
        }

        public SwipeController(ViewPage page) {
            this.parentPage = page;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            TLRPC$Dialog tLRPC$Dialog;
            if (!DialogsActivity.this.waitingForDialogsAnimationEnd(this.parentPage) && (((BaseFragment) DialogsActivity.this).parentLayout == null || !((BaseFragment) DialogsActivity.this).parentLayout.isInPreviewMode())) {
                if (!this.swipingFolder || !this.swipeFolderBack) {
                    if (!DialogsActivity.this.onlySelect && this.parentPage.isDefaultDialogType() && DialogsActivity.this.slidingView == null) {
                        View view = viewHolder.itemView;
                        if (view instanceof DialogCell) {
                            DialogCell dialogCell = (DialogCell) view;
                            if (dialogCell.customDialog != null) {
                                return 0;
                            }
                            long dialogId = dialogCell.getDialogId();
                            MessagesController.DialogFilter dialogFilter = null;
                            if (!((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed(null)) {
                                if ((DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 5) && DialogsActivity.this.allowSwipeDuringCurrentTouch && (((dialogId != DialogsActivity.this.getUserConfig().clientUserId && dialogId != 777000) || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 2) && (!DialogsActivity.this.getMessagesController().isPromoDialog(dialogId, false) || DialogsActivity.this.getMessagesController().promoDialogType == MessagesController.PROMO_TYPE_PSA))) {
                                    boolean z = DialogsActivity.this.folderId == 0 && (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 3 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 1 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 0 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 4);
                                    if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 1) {
                                        if (DialogsActivity.this.viewPages[0].dialogsType == 7 || DialogsActivity.this.viewPages[0].dialogsType == 8) {
                                            dialogFilter = DialogsActivity.this.getMessagesController().selectedDialogFilter[DialogsActivity.this.viewPages[0].dialogsType == 8 ? (char) 1 : (char) 0];
                                        }
                                        if (dialogFilter != null && (dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0 && (tLRPC$Dialog = DialogsActivity.this.getMessagesController().dialogs_dict.get(dialogId)) != null && !dialogFilter.alwaysShow(((BaseFragment) DialogsActivity.this).currentAccount, tLRPC$Dialog) && (tLRPC$Dialog.unread_count > 0 || tLRPC$Dialog.unread_mark)) {
                                            z = false;
                                        }
                                    }
                                    this.swipeFolderBack = false;
                                    this.swipingFolder = (z && !DialogObject.isFolderDialogId(dialogCell.getDialogId())) || (SharedConfig.archiveHidden && DialogObject.isFolderDialogId(dialogCell.getDialogId()));
                                    dialogCell.setSliding(true);
                                    return ItemTouchHelper.Callback.makeMovementFlags(0, 4);
                                }
                            } else {
                                TLRPC$Dialog tLRPC$Dialog2 = DialogsActivity.this.getMessagesController().dialogs_dict.get(dialogId);
                                if (!DialogsActivity.this.allowMoving || tLRPC$Dialog2 == null || !DialogsActivity.this.isDialogPinned(tLRPC$Dialog2) || DialogObject.isFolderDialogId(dialogId)) {
                                    return 0;
                                }
                                DialogsActivity.this.movingView = (DialogCell) viewHolder.itemView;
                                DialogsActivity.this.movingView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                                this.swipeFolderBack = false;
                                return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
                            }
                        }
                    }
                } else {
                    View view2 = viewHolder.itemView;
                    if (view2 instanceof DialogCell) {
                        ((DialogCell) view2).swipeCanceled = true;
                    }
                    this.swipingFolder = false;
                    return 0;
                }
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            long dialogId;
            TLRPC$Dialog tLRPC$Dialog;
            View view = target.itemView;
            if (!(view instanceof DialogCell) || (tLRPC$Dialog = DialogsActivity.this.getMessagesController().dialogs_dict.get((dialogId = ((DialogCell) view).getDialogId()))) == null || !DialogsActivity.this.isDialogPinned(tLRPC$Dialog) || DialogObject.isFolderDialogId(dialogId)) {
                return false;
            }
            this.parentPage.dialogsAdapter.notifyItemMoved(source.getAdapterPosition(), target.getAdapterPosition());
            DialogsActivity.this.updateDialogIndices();
            if (DialogsActivity.this.viewPages[0].dialogsType != 7 && DialogsActivity.this.viewPages[0].dialogsType != 8) {
                DialogsActivity.this.movingWas = true;
            } else {
                MessagesController.DialogFilter dialogFilter = DialogsActivity.this.getMessagesController().selectedDialogFilter[DialogsActivity.this.viewPages[0].dialogsType == 8 ? (char) 1 : (char) 0];
                if (!DialogsActivity.this.movingDialogFilters.contains(dialogFilter)) {
                    DialogsActivity.this.movingDialogFilters.add(dialogFilter);
                }
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int convertToAbsoluteDirection(int flags, int layoutDirection) {
            if (this.swipeFolderBack) {
                return 0;
            }
            return super.convertToAbsoluteDirection(flags, layoutDirection);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            if (viewHolder == null) {
                DialogsActivity.this.slidingView = null;
                return;
            }
            DialogCell dialogCell = (DialogCell) viewHolder.itemView;
            long dialogId = dialogCell.getDialogId();
            if (DialogObject.isFolderDialogId(dialogId)) {
                this.parentPage.listView.toggleArchiveHidden(false, dialogCell);
                return;
            }
            final TLRPC$Dialog tLRPC$Dialog = DialogsActivity.this.getMessagesController().dialogs_dict.get(dialogId);
            if (tLRPC$Dialog == null) {
                return;
            }
            if (DialogsActivity.this.getMessagesController().isPromoDialog(dialogId, false) || DialogsActivity.this.folderId != 0 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 1) {
                DialogsActivity.this.slidingView = dialogCell;
                final int adapterPosition = viewHolder.getAdapterPosition();
                final int itemCount = this.parentPage.dialogsAdapter.getItemCount();
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$SwipeController$2XO_521YM6XfyT3Yyv76Z4y1-I4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSwiped$1$DialogsActivity$SwipeController(tLRPC$Dialog, itemCount, adapterPosition);
                    }
                };
                DialogsActivity.this.setDialogsListFrozen(true);
                if (Utilities.random.nextInt(1000) == 1) {
                    if (DialogsActivity.this.pacmanAnimation == null) {
                        DialogsActivity.this.pacmanAnimation = new PacmanAnimation(this.parentPage.listView);
                    }
                    DialogsActivity.this.pacmanAnimation.setFinishRunnable(runnable);
                    DialogsActivity.this.pacmanAnimation.start();
                    return;
                }
                runnable.run();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(dialogId));
            DialogsActivity.this.canReadCount = (tLRPC$Dialog.unread_count > 0 || tLRPC$Dialog.unread_mark) ? 1 : 0;
            DialogsActivity.this.performSelectedDialogsAction(arrayList, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSwiped$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSwiped$1$DialogsActivity$SwipeController(final TLRPC$Dialog tLRPC$Dialog, int i, int i2) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
            if (DialogsActivity.this.frozenDialogsList == null) {
                return;
            }
            DialogsActivity.this.frozenDialogsList.remove(tLRPC$Dialog);
            final int i3 = tLRPC$Dialog.pinnedNum;
            DialogsActivity.this.slidingView = null;
            this.parentPage.listView.invalidate();
            int iFindLastVisibleItemPosition = this.parentPage.layoutManager.findLastVisibleItemPosition();
            if (iFindLastVisibleItemPosition == i - 1) {
                this.parentPage.layoutManager.findViewByPosition(iFindLastVisibleItemPosition).requestLayout();
            }
            if (!DialogsActivity.this.getMessagesController().isPromoDialog(tLRPC$Dialog.id, false)) {
                int iAddDialogToFolder = DialogsActivity.this.getMessagesController().addDialogToFolder(tLRPC$Dialog.id, DialogsActivity.this.folderId == 0 ? 1 : 0, -1, 0L);
                if (iAddDialogToFolder != 2 || i2 != 0) {
                    this.parentPage.dialogsItemAnimator.prepareForRemove();
                    ViewPage.access$11110(this.parentPage);
                    this.parentPage.dialogsAdapter.notifyItemRemoved(i2);
                    DialogsActivity.this.dialogRemoveFinished = 2;
                }
                if (DialogsActivity.this.folderId == 0) {
                    if (iAddDialogToFolder == 2) {
                        this.parentPage.dialogsItemAnimator.prepareForRemove();
                        if (i2 == 0) {
                            DialogsActivity.this.dialogChangeFinished = 2;
                            DialogsActivity.this.setDialogsListFrozen(true);
                            this.parentPage.dialogsAdapter.notifyItemChanged(0);
                        } else {
                            ViewPage.access$11108(this.parentPage);
                            this.parentPage.dialogsAdapter.notifyItemInserted(0);
                            if (!SharedConfig.archiveHidden && this.parentPage.layoutManager.findFirstVisibleItemPosition() == 0) {
                                DialogsActivity.this.disableActionBarScrolling = true;
                                this.parentPage.listView.smoothScrollBy(0, -AndroidUtilities.dp(SharedConfig.useThreeLinesLayout ? 78.0f : 72.0f));
                            }
                        }
                        DialogsActivity dialogsActivity = DialogsActivity.this;
                        DialogsActivity.this.frozenDialogsList.add(0, dialogsActivity.getDialogsArray(((BaseFragment) dialogsActivity).currentAccount, this.parentPage.dialogsType, DialogsActivity.this.folderId, false).get(0));
                    } else if (iAddDialogToFolder == 1 && (viewHolderFindViewHolderForAdapterPosition = this.parentPage.listView.findViewHolderForAdapterPosition(0)) != null) {
                        View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                        if (view instanceof DialogCell) {
                            DialogCell dialogCell = (DialogCell) view;
                            dialogCell.checkCurrentDialogIndex(true);
                            dialogCell.animateArchiveAvatar();
                        }
                    }
                    SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                    boolean z = globalMainSettings.getBoolean("archivehint_l", false) || SharedConfig.archiveHidden;
                    if (!z) {
                        globalMainSettings.edit().putBoolean("archivehint_l", true).commit();
                    }
                    DialogsActivity.this.getUndoView().showWithAction(tLRPC$Dialog.id, z ? 2 : 3, null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$SwipeController$fDIjlqRzkrzugki4io__PXVQXRk
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onSwiped$0$DialogsActivity$SwipeController(tLRPC$Dialog, i3);
                        }
                    });
                }
                if (DialogsActivity.this.folderId == 0 || !DialogsActivity.this.frozenDialogsList.isEmpty()) {
                    return;
                }
                this.parentPage.listView.setEmptyView(null);
                this.parentPage.progressView.setVisibility(4);
                return;
            }
            DialogsActivity.this.getMessagesController().hidePromoDialog();
            this.parentPage.dialogsItemAnimator.prepareForRemove();
            ViewPage.access$11110(this.parentPage);
            this.parentPage.dialogsAdapter.notifyItemRemoved(i2);
            DialogsActivity.this.dialogRemoveFinished = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSwiped$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSwiped$0$DialogsActivity$SwipeController(TLRPC$Dialog tLRPC$Dialog, int i) {
            DialogsActivity.this.dialogsListFrozen = true;
            DialogsActivity.this.getMessagesController().addDialogToFolder(tLRPC$Dialog.id, 0, i, 0L);
            DialogsActivity.this.dialogsListFrozen = false;
            ArrayList<TLRPC$Dialog> dialogs = DialogsActivity.this.getMessagesController().getDialogs(0);
            int iIndexOf = dialogs.indexOf(tLRPC$Dialog);
            if (iIndexOf < 0) {
                this.parentPage.dialogsAdapter.notifyDataSetChanged();
                return;
            }
            ArrayList<TLRPC$Dialog> dialogs2 = DialogsActivity.this.getMessagesController().getDialogs(1);
            if (!dialogs2.isEmpty() || iIndexOf != 1) {
                DialogsActivity.this.dialogInsertFinished = 2;
                DialogsActivity.this.setDialogsListFrozen(true);
                this.parentPage.dialogsItemAnimator.prepareForRemove();
                ViewPage.access$11108(this.parentPage);
                this.parentPage.dialogsAdapter.notifyItemInserted(iIndexOf);
            }
            if (dialogs2.isEmpty()) {
                dialogs.remove(0);
                if (iIndexOf == 1) {
                    DialogsActivity.this.dialogChangeFinished = 2;
                    DialogsActivity.this.setDialogsListFrozen(true);
                    this.parentPage.dialogsAdapter.notifyItemChanged(0);
                } else {
                    DialogsActivity.this.frozenDialogsList.remove(0);
                    this.parentPage.dialogsItemAnimator.prepareForRemove();
                    ViewPage.access$11110(this.parentPage);
                    this.parentPage.dialogsAdapter.notifyItemRemoved(0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (viewHolder != null) {
                this.parentPage.listView.hideSelector(false);
            }
            this.currentItemViewHolder = viewHolder;
            if (viewHolder != null) {
                View view = viewHolder.itemView;
                if (view instanceof DialogCell) {
                    ((DialogCell) view).swipeCanceled = false;
                }
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
            if (animationType == 4) {
                return 200L;
            }
            if (animationType == 8 && DialogsActivity.this.movingView != null) {
                final DialogCell dialogCell = DialogsActivity.this.movingView;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$SwipeController$sEfL3Fb3Urf55YZ74ea0IQ5itRE
                    @Override // java.lang.Runnable
                    public final void run() {
                        dialogCell.setBackgroundDrawable(null);
                    }
                }, this.parentPage.dialogsItemAnimator.getMoveDuration());
                DialogsActivity.this.movingView = null;
            }
            return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
        }
    }

    public DialogsActivity(Bundle args) {
        super(args);
        this.initialSearchType = -1;
        this.expandedMode = SharedConfig.expandedViewMode;
        this.getDialogFilters = false;
        this.ACTION_MODE_SEARCH_DIALOGS_TAG = "search_dialogs_action_mode";
        this.undoView = new UndoView[2];
        this.scrimViewLocation = new int[2];
        this.movingDialogFilters = new ArrayList<>();
        this.actionBarDefaultPaint = new Paint();
        this.actionModeViews = new ArrayList<>();
        this.askAboutContacts = true;
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.checkPermission = true;
        this.resetDelegate = true;
        this.selectedDialogs = new ArrayList<>();
        this.animationIndex = -1;
        this.debugLastUpdateAction = -1;
        this.SCROLL_Y = new AnimationProperties.FloatProperty<DialogsActivity>("animationValue") { // from class: ir.eitaa.ui.DialogsActivity.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(DialogsActivity object, float value) {
                object.setScrollY(value);
            }

            @Override // android.util.Property
            public Float get(DialogsActivity object) {
                return Float.valueOf(((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
            }
        };
        this.scrollBarVisible = true;
        this.slideFragmentProgress = 1.0f;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        if (getArguments() != null) {
            this.onlySelect = this.arguments.getBoolean("onlySelect", false);
            this.isForward = this.arguments.getBoolean("isForward", false);
            this.cantSendToChannels = this.arguments.getBoolean("cantSendToChannels", false);
            this.initialDialogsType = this.arguments.getInt("dialogsType", 0);
            this.selectAlertString = this.arguments.getString("selectAlertString");
            this.selectAlertStringGroup = this.arguments.getString("selectAlertStringGroup");
            this.addToGroupAlertString = this.arguments.getString("addToGroupAlertString");
            this.allowSwitchAccount = this.arguments.getBoolean("allowSwitchAccount");
            this.checkCanWrite = this.arguments.getBoolean("checkCanWrite", true);
            this.afterSignup = this.arguments.getBoolean("afterSignup", false);
            this.folderId = this.arguments.getInt("folderId", 0);
            this.resetDelegate = this.arguments.getBoolean("resetDelegate", true);
            this.messagesCount = this.arguments.getInt("messagesCount", 0);
            this.hasPoll = this.arguments.getInt("hasPoll", 0);
            this.hasInvoice = this.arguments.getBoolean("hasInvoice", false);
        }
        if (this.initialDialogsType == 0) {
            this.askAboutContacts = MessagesController.getGlobalNotificationsSettings().getBoolean("askAboutContacts", true);
            SharedConfig.loadProxyList();
        }
        if (this.searchString == null) {
            this.currentConnectionState = getConnectionsManager().getConnectionState();
            getNotificationCenter().addObserver(this, NotificationCenter.dialogsNeedReload);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
            if (!this.onlySelect) {
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.closeSearchByActiveAction);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.proxySettingsChanged);
                getNotificationCenter().addObserver(this, NotificationCenter.filterSettingsUpdated);
                getNotificationCenter().addObserver(this, NotificationCenter.dialogFiltersUpdated);
                getNotificationCenter().addObserver(this, NotificationCenter.dialogsUnreadCounterChanged);
            }
            getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
            getNotificationCenter().addObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().addObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.appDidLogout);
            getNotificationCenter().addObserver(this, NotificationCenter.openedChatChanged);
            getNotificationCenter().addObserver(this, NotificationCenter.notificationsSettingsUpdated);
            getNotificationCenter().addObserver(this, NotificationCenter.messageReceivedByAck);
            getNotificationCenter().addObserver(this, NotificationCenter.messageReceivedByServer);
            getNotificationCenter().addObserver(this, NotificationCenter.messageSendError);
            getNotificationCenter().addObserver(this, NotificationCenter.needReloadRecentDialogsSearch);
            getNotificationCenter().addObserver(this, NotificationCenter.replyMessagesDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.reloadHints);
            getNotificationCenter().addObserver(this, NotificationCenter.didUpdateConnectionState);
            getNotificationCenter().addObserver(this, NotificationCenter.needDeleteDialog);
            getNotificationCenter().addObserver(this, NotificationCenter.folderBecomeEmpty);
            getNotificationCenter().addObserver(this, NotificationCenter.newSuggestionsAvailable);
            getNotificationCenter().addObserver(this, NotificationCenter.fileLoaded);
            getNotificationCenter().addObserver(this, NotificationCenter.fileLoadFailed);
            getNotificationCenter().addObserver(this, NotificationCenter.fileLoadProgressChanged);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetPasscode);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.appUpdateAvailable);
        }
        getNotificationCenter().addObserver(this, NotificationCenter.messagesDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.onDatabaseMigration);
        getNotificationCenter().addObserver(this, NotificationCenter.didClearDatabase);
        getNotificationCenter().addObserver(this, NotificationCenter.liveChatsNeedReload);
        getNotificationCenter().addObserver(this, NotificationCenter.exploreStatusNeedReload);
        getNotificationCenter().addObserver(this, NotificationCenter.mxbStatusNeedReload);
        getNotificationCenter().addObserver(this, NotificationCenter.contactsImported);
        loadDialogs(getAccountInstance());
        getMessagesController().loadPinnedDialogs(this.folderId, 0L, null);
        if (this.databaseMigrationHint != null && !getMessagesStorage().isDatabaseMigrationInProgress()) {
            View view = this.databaseMigrationHint;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.databaseMigrationHint = null;
        }
        return true;
    }

    public static void loadDialogs(AccountInstance accountInstance) {
        int currentAccount = accountInstance.getCurrentAccount();
        if (dialogsLoaded[currentAccount]) {
            return;
        }
        MessagesController messagesController = accountInstance.getMessagesController();
        messagesController.loadGlobalNotificationsSettings();
        messagesController.loadDialogs(0, 0, 100, true);
        messagesController.loadHintDialogs();
        messagesController.loadUserInfo(accountInstance.getUserConfig().getCurrentUser(), false, 0);
        accountInstance.getContactsController().checkInviteText();
        accountInstance.getMediaDataController().loadRecents(2, false, true, false);
        accountInstance.getMediaDataController().loadRecents(3, false, true, false);
        accountInstance.getMediaDataController().checkFeaturedStickers();
        Iterator<String> it = messagesController.diceEmojies.iterator();
        while (it.hasNext()) {
            accountInstance.getMediaDataController().loadStickersByEmojiOrName(it.next(), true, true);
        }
        dialogsLoaded[currentAccount] = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        if (this.searchString == null) {
            getNotificationCenter().removeObserver(this, NotificationCenter.dialogsNeedReload);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
            if (!this.onlySelect) {
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.closeSearchByActiveAction);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxySettingsChanged);
                getNotificationCenter().removeObserver(this, NotificationCenter.filterSettingsUpdated);
                getNotificationCenter().removeObserver(this, NotificationCenter.dialogFiltersUpdated);
                getNotificationCenter().removeObserver(this, NotificationCenter.dialogsUnreadCounterChanged);
            }
            getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
            getNotificationCenter().removeObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().removeObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.appDidLogout);
            getNotificationCenter().removeObserver(this, NotificationCenter.openedChatChanged);
            getNotificationCenter().removeObserver(this, NotificationCenter.notificationsSettingsUpdated);
            getNotificationCenter().removeObserver(this, NotificationCenter.messageReceivedByAck);
            getNotificationCenter().removeObserver(this, NotificationCenter.messageReceivedByServer);
            getNotificationCenter().removeObserver(this, NotificationCenter.messageSendError);
            getNotificationCenter().removeObserver(this, NotificationCenter.needReloadRecentDialogsSearch);
            getNotificationCenter().removeObserver(this, NotificationCenter.replyMessagesDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.reloadHints);
            getNotificationCenter().removeObserver(this, NotificationCenter.didUpdateConnectionState);
            getNotificationCenter().removeObserver(this, NotificationCenter.needDeleteDialog);
            getNotificationCenter().removeObserver(this, NotificationCenter.folderBecomeEmpty);
            getNotificationCenter().removeObserver(this, NotificationCenter.newSuggestionsAvailable);
            getNotificationCenter().removeObserver(this, NotificationCenter.messagesDeleted);
            getNotificationCenter().removeObserver(this, NotificationCenter.fileLoaded);
            getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadFailed);
            getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadProgressChanged);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetPasscode);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.appUpdateAvailable);
        }
        getNotificationCenter().removeObserver(this, NotificationCenter.onDatabaseMigration);
        getNotificationCenter().removeObserver(this, NotificationCenter.didClearDatabase);
        getNotificationCenter().removeObserver(this, NotificationCenter.liveChatsNeedReload);
        getNotificationCenter().removeObserver(this, NotificationCenter.exploreStatusNeedReload);
        getNotificationCenter().removeObserver(this, NotificationCenter.mxbStatusNeedReload);
        getNotificationCenter().removeObserver(this, NotificationCenter.contactsImported);
        ChatActivityEnterView chatActivityEnterView = this.commentView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.onDestroy();
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        getNotificationCenter().onAnimationFinish(this.animationIndex);
        this.delegate = null;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context) { // from class: ir.eitaa.ui.DialogsActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar, android.view.View
            public void setTranslationY(float translationY) {
                if (translationY != getTranslationY() && ((BaseFragment) DialogsActivity.this).fragmentView != null) {
                    ((BaseFragment) DialogsActivity.this).fragmentView.invalidate();
                }
                super.setTranslationY(translationY);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBar
            protected boolean shouldClipChild(View child) {
                return super.shouldClipChild(child) || child == DialogsActivity.this.doneItem;
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBar, android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (!((BaseFragment) DialogsActivity.this).inPreviewMode || DialogsActivity.this.avatarContainer == null || child == DialogsActivity.this.avatarContainer) {
                    return super.drawChild(canvas, child, drawingTime);
                }
                return false;
            }
        };
        actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultSelector"), false);
        actionBar.setItemsBackgroundColor(Theme.getColor("actionBarActionModeDefaultSelector"), true);
        actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), false);
        actionBar.setItemsColor(Theme.getColor("actionBarActionModeDefaultIcon"), true);
        if (this.inPreviewMode || (AndroidUtilities.isTablet() && this.folderId != 0)) {
            actionBar.setOccupyStatusBar(false);
        }
        return actionBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v3, types: [boolean, int] */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i;
        ?? r13;
        int i2;
        int i3;
        int i4;
        final Context context2 = context;
        this.searching = false;
        this.searchWas = false;
        this.pacmanAnimation = null;
        this.selectedDialogs.clear();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$smgxI39Sc_RSyBLtsu4u9ZDJPnk
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                Theme.createChatResources(context2, false);
            }
        });
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        String str = "Done";
        float f = 0.0f;
        int i5 = 8;
        if (!this.onlySelect && this.searchString == null && this.folderId == 0) {
            r13 = 1;
            ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, (ActionBarMenu) null, Theme.getColor("actionBarDefaultSelector"), Theme.getColor("actionBarDefaultIcon"), true);
            this.doneItem = actionBarMenuItem;
            actionBarMenuItem.setText(LocaleController.getString("Done", R.string.Done).toUpperCase());
            this.actionBar.addView(this.doneItem, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 0.0f, 10.0f, 0.0f));
            this.doneItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$US-sWedNMordYT5FnR4Sy0cVeUo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$2$DialogsActivity(view);
                }
            });
            this.doneItem.setAlpha(0.0f);
            this.doneItem.setVisibility(8);
            ProxyDrawable proxyDrawable = new ProxyDrawable(context2);
            this.proxyDrawable = proxyDrawable;
            ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(2, proxyDrawable);
            this.proxyItem = actionBarMenuItemAddItem;
            actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("ProxySettings", R.string.ProxySettings));
            RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.passcode_lock_close, "passcode_lock_close", AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), true, (int[]) null);
            this.passcodeDrawable = rLottieDrawable;
            ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(1, rLottieDrawable);
            this.passcodeItem = actionBarMenuItemAddItem2;
            actionBarMenuItemAddItem2.setContentDescription(LocaleController.getString("AccDescrPasscodeLock", R.string.AccDescrPasscodeLock));
            ActionBarMenuItem actionBarMenuItemAddItem3 = actionBarMenuCreateMenu.addItem(1372, R.drawable.ic_whatshot);
            this.whatshotItem = actionBarMenuItemAddItem3;
            actionBarMenuItemAddItem3.setContentDescription(LocaleController.getString("TrendsContentDescription", R.string.TrendsContentDescription));
            ActionBarMenuItem actionBarMenuItemAddItem4 = actionBarMenuCreateMenu.addItem(1401, R.drawable.recommend);
            this.recommendItem = actionBarMenuItemAddItem4;
            actionBarMenuItemAddItem4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.DialogsActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DialogsActivity.this.presentFragment(new MessageExploreActivity(0, null, null, 0));
                }
            });
            ActionBarMenuItem actionBarMenuItemAddItem5 = actionBarMenuCreateMenu.addItem(1380, R.drawable.ic_explore);
            this.exploreItem = actionBarMenuItemAddItem5;
            actionBarMenuItemAddItem5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.DialogsActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DialogsActivity.this.presentFragment(new ExploreActivity());
                }
            });
            this.exploreItem.setContentDescription(LocaleController.getString("Explore", R.string.Explore));
            updatePasscodeButton();
            i = 0;
            updateProxyButton(false);
            updateWhatshotButton();
        } else {
            i = 0;
            r13 = 1;
        }
        ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(i, R.drawable.ic_ab_search).setIsSearchField(r13, r13).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.DialogsActivity.5
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                DialogsActivity.this.searching = true;
                DialogsActivity.this.updateWhatshotButton();
                if (DialogsActivity.this.switchItem != null) {
                    DialogsActivity.this.switchItem.setVisibility(8);
                }
                if (DialogsActivity.this.proxyItem != null && DialogsActivity.this.proxyItemVisible) {
                    DialogsActivity.this.proxyItem.setVisibility(8);
                }
                if (DialogsActivity.this.viewPages[0] != null) {
                    if (DialogsActivity.this.searchString != null) {
                        DialogsActivity.this.viewPages[0].listView.hide();
                        if (DialogsActivity.this.searchViewPager != null) {
                            DialogsActivity.this.searchViewPager.searchListView.show();
                        }
                    }
                    if (!DialogsActivity.this.onlySelect) {
                        DialogsActivity.this.floatingButtonContainer.setVisibility(8);
                    }
                }
                DialogsActivity.this.setScrollY(0.0f);
                DialogsActivity.this.updatePasscodeButton();
                DialogsActivity.this.updateWhatshotButton();
                ((BaseFragment) DialogsActivity.this).actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
                if (DialogsActivity.searchToolsCell != null) {
                    DialogsActivity.searchToolsCell.setTabSelected(0);
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public boolean canCollapseSearch() {
                if (DialogsActivity.this.switchItem != null) {
                    DialogsActivity.this.switchItem.setVisibility(0);
                }
                if (DialogsActivity.this.proxyItem != null && DialogsActivity.this.proxyItemVisible) {
                    DialogsActivity.this.proxyItem.setVisibility(0);
                }
                if (DialogsActivity.this.searchString == null) {
                    return true;
                }
                DialogsActivity.this.finishFragment();
                return false;
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                DialogsActivity.this.searching = false;
                DialogsActivity.this.searchWas = false;
                if (DialogsActivity.this.viewPages[0] != null) {
                    DialogsActivity.this.viewPages[0].listView.setEmptyView(DialogsActivity.this.folderId == 0 ? DialogsActivity.this.viewPages[0].progressView : null);
                    if (!DialogsActivity.this.onlySelect) {
                        DialogsActivity.this.floatingButtonContainer.setVisibility(0);
                        DialogsActivity.this.floatingHidden = true;
                        DialogsActivity.this.floatingButtonTranslation = AndroidUtilities.dp(100.0f);
                        DialogsActivity.this.floatingButtonHideProgress = 1.0f;
                        DialogsActivity.this.updateFloatingButtonOffset();
                    }
                    DialogsActivity.this.showSearch(false, true, context2);
                }
                DialogsActivity.this.updatePasscodeButton();
                DialogsActivity.this.updateWhatshotButton();
                if (DialogsActivity.this.menuDrawable != null) {
                    if (((BaseFragment) DialogsActivity.this).actionBar.getBackButton().getDrawable() != DialogsActivity.this.menuDrawable) {
                        ((BaseFragment) DialogsActivity.this).actionBar.setBackButtonDrawable(DialogsActivity.this.menuDrawable);
                        DialogsActivity.this.menuDrawable.setRotation(0.0f, true);
                    }
                    ((BaseFragment) DialogsActivity.this).actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrOpenMenu", R.string.AccDescrOpenMenu));
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                String string = editText.getText().toString();
                if (string.length() != 0 || DialogsActivity.this.searchViewPager.dialogsSearchAdapter != null) {
                    DialogsActivity.this.searchWas = true;
                    if (!DialogsActivity.this.searchIsShowed) {
                        DialogsActivity.this.showSearch(true, true, context2);
                    }
                }
                DialogsActivity.this.searchViewPager.onTextChanged(string);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchFilterCleared(FiltersView.MediaFilterData filterData) {
                if (DialogsActivity.this.searchIsShowed) {
                    DialogsActivity.this.searchViewPager.removeSearchFilter(filterData);
                    DialogsActivity.this.searchViewPager.onTextChanged(DialogsActivity.this.searchItem.getSearchField().getText().toString());
                    DialogsActivity.this.updateFiltersView(true, null, null, false, true);
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public boolean canToggleSearch() {
                return !((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed() && DialogsActivity.this.databaseMigrationHint == null;
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        String str2 = "actionBarDefault";
        if (this.onlySelect || this.isForward) {
            this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
            int i6 = this.initialDialogsType;
            if (((i6 == 3 && this.selectAlertString == null) || this.isForward) && !LaunchActivity.isShare) {
                this.actionBar.setTitle(LocaleController.getString("ForwardTo", R.string.ForwardTo));
            } else if (i6 == 10) {
                this.actionBar.setTitle(LocaleController.getString("SelectChats", R.string.SelectChats));
            } else {
                this.actionBar.setTitle(LocaleController.getString("SelectChat", R.string.SelectChat));
            }
            this.actionBar.setBackgroundColor(Theme.getColor("actionBarDefault"));
        } else {
            if (this.searchString != null || this.folderId != 0) {
                ActionBar actionBar = this.actionBar;
                BackDrawable backDrawable = new BackDrawable(false);
                this.backDrawable = backDrawable;
                actionBar.setBackButtonDrawable(backDrawable);
            } else {
                ActionBar actionBar2 = this.actionBar;
                MenuDrawable menuDrawable = new MenuDrawable();
                this.menuDrawable = menuDrawable;
                actionBar2.setBackButtonDrawable(menuDrawable);
                this.actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrOpenMenu", R.string.AccDescrOpenMenu));
            }
            if (this.folderId != 0) {
                this.actionBar.setTitle(LocaleController.getString("ArchivedChats", R.string.ArchivedChats));
            } else if (BuildVars.DEBUG_VERSION) {
                this.actionBar.setTitle("Eitaa Beta");
            } else {
                this.actionBar.setTitle(LocaleController.getString("AppName", R.string.AppName));
            }
            if (this.folderId == 0) {
                this.actionBar.setSupportsHolidayImage(false);
            }
        }
        if (!this.onlySelect) {
            this.actionBar.setAddToContainer(false);
            this.actionBar.setCastShadows(false);
            this.actionBar.setClipContent(r13);
        }
        this.actionBar.setTitleActionRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$-qVmPm_Q8X6DFqZEXv70GfdKw4o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$3$DialogsActivity();
            }
        });
        if (this.initialDialogsType == 0 && this.folderId == 0 && !this.onlySelect && TextUtils.isEmpty(this.searchString)) {
            this.scrimPaint = new Paint() { // from class: ir.eitaa.ui.DialogsActivity.6
                @Override // android.graphics.Paint
                public void setAlpha(int a) {
                    super.setAlpha(a);
                    if (((BaseFragment) DialogsActivity.this).fragmentView != null) {
                        ((BaseFragment) DialogsActivity.this).fragmentView.invalidate();
                    }
                }
            };
            FilterTabsView filterTabsView = new FilterTabsView(context2) { // from class: ir.eitaa.ui.DialogsActivity.7
                @Override // android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    DialogsActivity.this.maybeStartTracking = false;
                    return super.onInterceptTouchEvent(ev);
                }

                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    if (getTranslationY() != translationY) {
                        super.setTranslationY(translationY);
                        DialogsActivity.this.updateContextViewPosition();
                        if (((BaseFragment) DialogsActivity.this).fragmentView != null) {
                            ((BaseFragment) DialogsActivity.this).fragmentView.invalidate();
                        }
                    }
                }

                @Override // ir.eitaa.ui.Components.FilterTabsView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int l, int t, int r, int b) {
                    super.onLayout(changed, l, t, r, b);
                    if (DialogsActivity.this.scrimView != null) {
                        DialogsActivity.this.scrimView.getLocationInWindow(DialogsActivity.this.scrimViewLocation);
                        ((BaseFragment) DialogsActivity.this).fragmentView.invalidate();
                    }
                }
            };
            this.filterTabsView = filterTabsView;
            filterTabsView.setVisibility(8);
            this.canShowFilterTabsView = false;
            this.filterTabsView.setDelegate(new AnonymousClass8());
        }
        if (this.allowSwitchAccount && UserConfig.getActivatedAccountsCount() > r13) {
            this.switchItem = actionBarMenuCreateMenu.addItemWithWidth(r13 == true ? 1 : 0, 0, AndroidUtilities.dp(56.0f));
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
            BackupImageView backupImageView = new BackupImageView(context2);
            backupImageView.setRoundRadius(AndroidUtilities.dp(18.0f));
            this.switchItem.addView(backupImageView, LayoutHelper.createFrame(36, 36, 17));
            TLRPC$User currentUser = getUserConfig().getCurrentUser();
            avatarDrawable.setInfo(currentUser);
            backupImageView.getImageReceiver().setCurrentAccount(this.currentAccount);
            backupImageView.setImage(ImageLocation.getForUserOrChat(currentUser, r13 == true ? 1 : 0), "50_50", ImageLocation.getForUserOrChat(currentUser, 2), "50_50", avatarDrawable, currentUser);
            for (int i7 = 0; i7 < 3; i7++) {
                if (AccountInstance.getInstance(i7).getUserConfig().getCurrentUser() != null) {
                    AccountSelectCell accountSelectCell = new AccountSelectCell(context2, false);
                    accountSelectCell.setAccount(i7, r13);
                    this.switchItem.addSubItem(i7 + 10, accountSelectCell, AndroidUtilities.dp(230.0f), AndroidUtilities.dp(48.0f));
                }
            }
        }
        this.actionBar.setAllowOverlayTitle(r13);
        RecyclerView recyclerView = this.sideMenu;
        if (recyclerView != null) {
            recyclerView.setBackgroundColor(Theme.getColor("chats_menuBackground"));
            this.sideMenu.setGlowColor(Theme.getColor("chats_menuBackground"));
            this.sideMenu.getAdapter().notifyDataSetChanged();
        }
        createActionMode(null);
        ContentView contentView = new ContentView(context2);
        this.fragmentView = contentView;
        int i8 = (this.folderId == 0 && this.initialDialogsType == 0 && !this.onlySelect) ? 2 : 1;
        this.viewPages = new ViewPage[i8];
        int i9 = 0;
        ?? r132 = r13;
        while (i9 < i8) {
            final ViewPage viewPage = new ViewPage(context2) { // from class: ir.eitaa.ui.DialogsActivity.9
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (DialogsActivity.this.tabsAnimationInProgress && DialogsActivity.this.viewPages[0] == this) {
                        DialogsActivity.this.filterTabsView.selectTabWithId(DialogsActivity.this.viewPages[1].selectedType, Math.abs(DialogsActivity.this.viewPages[0].getTranslationX()) / DialogsActivity.this.viewPages[0].getMeasuredWidth());
                    }
                }
            };
            contentView.addView(viewPage, LayoutHelper.createFrame(-1, -1.0f));
            viewPage.dialogsType = this.initialDialogsType;
            this.viewPages[i9] = viewPage;
            viewPage.progressView = new FlickerLoadingView(context2);
            viewPage.progressView.setViewType(7);
            viewPage.progressView.setVisibility(i5);
            viewPage.addView(viewPage.progressView, LayoutHelper.createFrame(-2, -2, 17));
            viewPage.listView = new DialogsRecyclerView(context2, viewPage);
            viewPage.listView.setOnTouchListener(new View.OnTouchListener(context2, viewPage) { // from class: ir.eitaa.ui.DialogsActivity.10
                GestureDetector detector;
                final /* synthetic */ Context val$context;
                final /* synthetic */ ViewPage val$viewPage;

                {
                    this.val$context = context2;
                    this.val$viewPage = viewPage;
                    this.detector = new GestureDetector(context2, new GestureDetector.SimpleOnGestureListener() { // from class: ir.eitaa.ui.DialogsActivity.10.1
                        long lastGetDifferenceRefreshTime = 0;

                        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            if (AnonymousClass10.this.val$viewPage.dialogsAdapter != AnonymousClass10.this.val$viewPage.listView.getAdapter() || velocityY <= 1000.0f || AnonymousClass10.this.val$viewPage.layoutManager.findFirstVisibleItemPosition() != 0 || AnonymousClass10.this.val$viewPage.listView.getChildCount() <= 0 || AnonymousClass10.this.val$viewPage.listView.getChildAt(0).getTop() != 0) {
                                return false;
                            }
                            long currentTime = ConnectionsManager.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).getCurrentTime();
                            if (this.lastGetDifferenceRefreshTime + (MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).schedule_period_forground_ms / 1000) >= currentTime) {
                                return true;
                            }
                            this.lastGetDifferenceRefreshTime = currentTime;
                            MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).getDifference();
                            return true;
                        }
                    });
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    this.detector.onTouchEvent(event);
                    return false;
                }
            });
            viewPage.listView.setAnimateEmptyView(r132, 0);
            viewPage.listView.setClipToPadding(false);
            viewPage.listView.setPivotY(f);
            viewPage.dialogsItemAnimator = new DialogsItemAnimator(viewPage.listView) { // from class: ir.eitaa.ui.DialogsActivity.11
                @Override // androidx.recyclerview.widget.SimpleItemAnimator
                public void onRemoveStarting(RecyclerView.ViewHolder item) {
                    super.onRemoveStarting(item);
                    if (viewPage.layoutManager.findFirstVisibleItemPosition() == 0) {
                        View viewFindViewByPosition = viewPage.layoutManager.findViewByPosition(0);
                        if (viewFindViewByPosition != null) {
                            viewFindViewByPosition.invalidate();
                        }
                        if (viewPage.archivePullViewState == 2) {
                            viewPage.archivePullViewState = 1;
                        }
                        if (viewPage.pullForegroundDrawable != null) {
                            viewPage.pullForegroundDrawable.doNotShow();
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.SimpleItemAnimator
                public void onRemoveFinished(RecyclerView.ViewHolder item) {
                    if (DialogsActivity.this.dialogRemoveFinished == 2) {
                        DialogsActivity.this.dialogRemoveFinished = 1;
                    }
                }

                @Override // androidx.recyclerview.widget.SimpleItemAnimator
                public void onAddFinished(RecyclerView.ViewHolder item) {
                    if (DialogsActivity.this.dialogInsertFinished == 2) {
                        DialogsActivity.this.dialogInsertFinished = 1;
                    }
                }

                @Override // androidx.recyclerview.widget.SimpleItemAnimator
                public void onChangeFinished(RecyclerView.ViewHolder item, boolean oldItem) {
                    if (DialogsActivity.this.dialogChangeFinished == 2) {
                        DialogsActivity.this.dialogChangeFinished = 1;
                    }
                }

                @Override // ir.eitaa.ui.Components.DialogsItemAnimator
                protected void onAllAnimationsDone() {
                    if (DialogsActivity.this.dialogRemoveFinished == 1 || DialogsActivity.this.dialogInsertFinished == 1 || DialogsActivity.this.dialogChangeFinished == 1) {
                        DialogsActivity.this.onDialogAnimationFinished();
                    }
                }
            };
            viewPage.listView.setItemAnimator(viewPage.dialogsItemAnimator);
            viewPage.listView.setVerticalScrollBarEnabled(r132);
            viewPage.listView.setInstantClick(r132);
            viewPage.layoutManager = new AnonymousClass12(context2, viewPage);
            viewPage.layoutManager.setOrientation(r132);
            viewPage.listView.setLayoutManager(viewPage.layoutManager);
            viewPage.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
            viewPage.addView(viewPage.listView, LayoutHelper.createFrame(-1, -1.0f));
            viewPage.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$5xWYRVbtCQNUGzIm6cg44dl0jj4
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
                public final void onItemClick(View view, int i10, float f2, float f3) {
                    this.f$0.lambda$createView$4$DialogsActivity(viewPage, view, i10, f2, f3);
                }
            });
            viewPage.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListenerExtended() { // from class: ir.eitaa.ui.DialogsActivity.14
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
                public boolean onItemClick(View view, int position, float x, float y) {
                    if (!Theme.getCurrentTheme().isDark()) {
                        ((BaseFragment) DialogsActivity.this).actionBar.setBackgroundColor(0);
                    }
                    if (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0 && DialogsActivity.this.filterTabsView.isEditing()) {
                        return false;
                    }
                    if (viewPage.dialogsAdapter.hasDialogAd) {
                        if (position == 0 && !viewPage.dialogsAdapter.hasArchive()) {
                            return false;
                        }
                        if (position == 1 && viewPage.dialogsAdapter.hasArchive() && DialogsActivity.this.folderId != 1) {
                            return false;
                        }
                    }
                    return DialogsActivity.this.onItemLongClick(view, position, x, y, viewPage.dialogsType, viewPage.dialogsAdapter);
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
                public void onLongClickRelease() {
                    DialogsActivity.this.finishPreviewFragment();
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
                public void onMove(float dx, float dy) {
                    DialogsActivity.this.movePreviewFragment(dy);
                }
            });
            viewPage.swipeController = new SwipeController(viewPage);
            viewPage.recyclerItemsEnterAnimator = new RecyclerItemsEnterAnimator(viewPage.listView, false);
            viewPage.itemTouchhelper = new ItemTouchHelper(viewPage.swipeController);
            viewPage.itemTouchhelper.attachToRecyclerView(viewPage.listView);
            viewPage.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.DialogsActivity.15
                private boolean wasManualScroll;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                    if (newState != 1) {
                        DialogsActivity.this.scrollingManually = false;
                    } else {
                        this.wasManualScroll = true;
                        DialogsActivity.this.scrollingManually = true;
                    }
                    if (newState == 0) {
                        this.wasManualScroll = false;
                        DialogsActivity.this.disableActionBarScrolling = false;
                        if (DialogsActivity.this.waitingForScrollFinished) {
                            DialogsActivity.this.waitingForScrollFinished = false;
                            if (DialogsActivity.this.updatePullAfterScroll) {
                                viewPage.listView.updatePullState();
                                DialogsActivity.this.updatePullAfterScroll = false;
                            }
                            viewPage.dialogsAdapter.notifyDataSetChanged();
                        }
                        if (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0 && DialogsActivity.this.viewPages[0].listView == recyclerView2) {
                            int i10 = (int) (-((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
                            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                            if (i10 == 0 || i10 == currentActionBarHeight) {
                                return;
                            }
                            if (i10 >= currentActionBarHeight / 2) {
                                if (DialogsActivity.this.viewPages[0].listView.canScrollVertically(1)) {
                                    recyclerView2.smoothScrollBy(0, currentActionBarHeight - i10);
                                    return;
                                }
                                return;
                            }
                            recyclerView2.smoothScrollBy(0, -i10);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                    View childAt;
                    int iFindFirstVisibleItemPosition;
                    boolean z;
                    boolean z2;
                    viewPage.dialogsItemAnimator.onListScroll(-dy);
                    DialogsActivity.this.checkListLoad(viewPage);
                    if (DialogsActivity.this.initialDialogsType != 10 && this.wasManualScroll && DialogsActivity.this.floatingButtonContainer.getVisibility() != 8 && recyclerView2.getChildCount() > 0 && (iFindFirstVisibleItemPosition = viewPage.layoutManager.findFirstVisibleItemPosition()) != -1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        if (!DialogsActivity.this.hasHiddenArchive() || (viewHolderFindViewHolderForAdapterPosition != null && viewHolderFindViewHolderForAdapterPosition.getAdapterPosition() != 0)) {
                            int top = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView.getTop() : 0;
                            if (DialogsActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                                int i10 = DialogsActivity.this.prevTop - top;
                                z = top < DialogsActivity.this.prevTop;
                                if (Math.abs(i10) <= 1) {
                                    z2 = false;
                                }
                                if (z2 && DialogsActivity.this.scrollUpdated && (z || DialogsActivity.this.scrollingManually)) {
                                    DialogsActivity.this.hideFloatingButton(z);
                                }
                                DialogsActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                                DialogsActivity.this.prevTop = top;
                                DialogsActivity.this.scrollUpdated = true;
                            } else {
                                z = iFindFirstVisibleItemPosition > DialogsActivity.this.prevPosition;
                            }
                            z2 = true;
                            if (z2) {
                                DialogsActivity.this.hideFloatingButton(z);
                            }
                            DialogsActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                            DialogsActivity.this.prevTop = top;
                            DialogsActivity.this.scrollUpdated = true;
                        }
                    }
                    if (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0 || recyclerView2 != DialogsActivity.this.viewPages[0].listView || DialogsActivity.this.searching || ((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed() || DialogsActivity.this.disableActionBarScrolling || !DialogsActivity.this.filterTabsViewIsVisible) {
                        return;
                    }
                    if (dy > 0 && DialogsActivity.this.hasHiddenArchive() && DialogsActivity.this.viewPages[0].dialogsType == 0 && (childAt = recyclerView2.getChildAt(0)) != null && recyclerView2.getChildViewHolder(childAt).getAdapterPosition() == 0) {
                        int measuredHeight = childAt.getMeasuredHeight() + (childAt.getTop() - recyclerView2.getPaddingTop());
                        if (measuredHeight + dy > 0) {
                            if (measuredHeight >= 0) {
                                return;
                            } else {
                                dy = -measuredHeight;
                            }
                        }
                    }
                    float translationY = ((BaseFragment) DialogsActivity.this).actionBar.getTranslationY();
                    float f2 = translationY - dy;
                    if (f2 < (-ActionBar.getCurrentActionBarHeight())) {
                        f2 = -ActionBar.getCurrentActionBarHeight();
                    } else if (f2 > 0.0f) {
                        f2 = 0.0f;
                    }
                    if (f2 != translationY) {
                        DialogsActivity.this.setScrollY(f2);
                    }
                }
            });
            viewPage.archivePullViewState = SharedConfig.archiveHidden ? 2 : 0;
            if (viewPage.pullForegroundDrawable == null && this.folderId == 0) {
                viewPage.pullForegroundDrawable = new PullForegroundDrawable(LocaleController.getString("AccSwipeForArchive", R.string.AccSwipeForArchive), LocaleController.getString("AccReleaseForArchive", R.string.AccReleaseForArchive)) { // from class: ir.eitaa.ui.DialogsActivity.16
                    @Override // ir.eitaa.ui.Components.PullForegroundDrawable
                    protected float getViewOffset() {
                        return viewPage.listView.getViewOffset();
                    }
                };
                if (hasHiddenArchive()) {
                    viewPage.pullForegroundDrawable.showHidden();
                } else {
                    viewPage.pullForegroundDrawable.doNotShow();
                }
                viewPage.pullForegroundDrawable.setWillDraw(viewPage.archivePullViewState != 0);
            }
            int i10 = i9;
            String str3 = str2;
            int i11 = i8;
            ContentView contentView2 = contentView;
            String str4 = str;
            viewPage.dialogsAdapter = new DialogsAdapter(this, context, viewPage.dialogsType, this.folderId, this.onlySelect, this.selectedDialogs, this.currentAccount, this.isForward) { // from class: ir.eitaa.ui.DialogsActivity.17
                @Override // ir.eitaa.ui.Adapters.DialogsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
                public void notifyDataSetChanged() {
                    viewPage.lastItemsCount = getItemCount();
                    try {
                        super.notifyDataSetChanged();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
            };
            viewPage.dialogsAdapter.setForceShowEmptyCell(this.afterSignup);
            if (AndroidUtilities.isTablet() && this.openedDialogId != 0) {
                viewPage.dialogsAdapter.setOpenedDialogId(this.openedDialogId);
            }
            viewPage.dialogsAdapter.setArchivedPullDrawable(viewPage.pullForegroundDrawable);
            viewPage.listView.setAdapter(viewPage.dialogsAdapter);
            viewPage.listView.setEmptyView(this.folderId == 0 ? viewPage.progressView : null);
            viewPage.scrollHelper = new RecyclerAnimationScrollHelper(viewPage.listView, viewPage.layoutManager);
            if (i10 != 0) {
                this.viewPages[i10].setVisibility(8);
            }
            i9 = i10 + 1;
            context2 = context;
            str = str4;
            contentView = contentView2;
            i8 = i11;
            str2 = str3;
            i5 = 8;
            f = 0.0f;
            r132 = 1;
        }
        String str5 = str;
        String str6 = str2;
        ContentView contentView3 = contentView;
        if (this.searchString != null) {
            i2 = 2;
        } else {
            i2 = !this.onlySelect ? 1 : 0;
        }
        SearchViewPager searchViewPager = new SearchViewPager(context, this, i2, this.initialDialogsType, this.folderId, new SearchViewPager.ChatPreviewDelegate() { // from class: ir.eitaa.ui.DialogsActivity.18
            @Override // ir.eitaa.ui.Components.SearchViewPager.ChatPreviewDelegate
            public void startChatPreview(DialogCell cell) {
                DialogsActivity.this.showChatPreview(cell);
            }

            @Override // ir.eitaa.ui.Components.SearchViewPager.ChatPreviewDelegate
            public void move(float dy) {
                DialogsActivity.this.movePreviewFragment(dy);
            }

            @Override // ir.eitaa.ui.Components.SearchViewPager.ChatPreviewDelegate
            public void finish() {
                DialogsActivity.this.finishPreviewFragment();
            }
        });
        this.searchViewPager = searchViewPager;
        contentView3.addView(searchViewPager);
        this.searchViewPager.dialogsSearchAdapter.setDelegate(new AnonymousClass19());
        this.searchViewPager.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$y0q-NVrdS1g4dwJtaj0z9rgEB3Y
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i12) {
                this.f$0.lambda$createView$5$DialogsActivity(view, i12);
            }
        });
        this.searchViewPager.searchListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListenerExtended() { // from class: ir.eitaa.ui.DialogsActivity.20
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public boolean onItemClick(View view, int position, float x, float y) {
                DialogsActivity dialogsActivity = DialogsActivity.this;
                return dialogsActivity.onItemLongClick(view, position, x, y, -1, dialogsActivity.searchViewPager.dialogsSearchAdapter);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onLongClickRelease() {
                DialogsActivity.this.finishPreviewFragment();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onMove(float dx, float dy) {
                DialogsActivity.this.movePreviewFragment(dy);
            }
        });
        this.searchViewPager.setFilteredSearchViewDelegate(new FilteredSearchView.Delegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$xiVWgQZN21q-RqmXJiFdx0Q8FyA
            @Override // ir.eitaa.ui.FilteredSearchView.Delegate
            public final void updateFiltersView(boolean z, ArrayList arrayList, ArrayList arrayList2, boolean z2) {
                this.f$0.lambda$createView$6$DialogsActivity(z, arrayList, arrayList2, z2);
            }
        });
        this.searchViewPager.setVisibility(8);
        FiltersView filtersView = new FiltersView(getParentActivity(), null);
        this.filtersView = filtersView;
        filtersView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$VOTDUYF1vzAedX_n9vUY-rGqb5Q
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i12) {
                this.f$0.lambda$createView$7$DialogsActivity(view, i12);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.floatingButtonContainer = frameLayout;
        frameLayout.setVisibility(((!this.onlySelect || this.initialDialogsType == 10) && this.folderId == 0) ? 0 : 8);
        FrameLayout frameLayout2 = this.floatingButtonContainer;
        int i12 = Build.VERSION.SDK_INT;
        int i13 = (i12 >= 21 ? 56 : 60) + 20;
        float f2 = (i12 >= 21 ? 56 : 60) + 20;
        boolean z = LocaleController.isRTL;
        contentView3.addView(frameLayout2, LayoutHelper.createFrame(i13, f2, (z ? 3 : 5) | 80, z ? 4.0f : 0.0f, 0.0f, z ? 0.0f : 4.0f, 0.0f));
        this.floatingButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$VTGCNZSZ5IPFJ652weU0ZYorjlA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$8$DialogsActivity(view);
            }
        });
        if (this.onlySelect || this.isForward) {
            this.floatingButtonContainer.setVisibility(8);
        }
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.floatingButton = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor("chats_actionBackground"), Theme.getColor("chats_actionPressedBackground"));
        if (i12 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionIcon"), PorterDuff.Mode.MULTIPLY));
        if (this.initialDialogsType == 10) {
            this.floatingButton.setImageResource(R.drawable.floating_check);
            this.floatingButtonContainer.setContentDescription(LocaleController.getString(str5, R.string.Done));
        } else {
            this.floatingButton.setAnimation(R.raw.write_contacts_fab_icon, 52, 52);
            this.floatingButtonContainer.setContentDescription(LocaleController.getString("NewMessageTitle", R.string.NewMessageTitle));
        }
        if (i12 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            int[] iArr = {android.R.attr.state_pressed};
            RLottieImageView rLottieImageView2 = this.floatingButton;
            Property property = View.TRANSLATION_Z;
            i3 = 2;
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(rLottieImageView2, (Property<RLottieImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButton.setStateListAnimator(stateListAnimator);
            this.floatingButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.DialogsActivity.21
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        } else {
            i3 = 2;
        }
        this.floatingButtonContainer.addView(this.floatingButton, LayoutHelper.createFrame(i12 >= 21 ? 56 : 60, i12 >= 21 ? 56 : 60, 51, 10.0f, 6.0f, 10.0f, 0.0f));
        this.searchTabsView = null;
        if (!this.onlySelect && this.initialDialogsType == 0 && !this.isForward) {
            FragmentContextView fragmentContextView = new FragmentContextView(context, this, true);
            this.fragmentLocationContextView = fragmentContextView;
            fragmentContextView.setLayoutParams(LayoutHelper.createFrame(-1, 38.0f, 51, 0.0f, -36.0f, 0.0f, 0.0f));
            contentView3.addView(this.fragmentLocationContextView);
            FragmentContextView fragmentContextView2 = new FragmentContextView(context, this, false) { // from class: ir.eitaa.ui.DialogsActivity.22
                @Override // ir.eitaa.ui.Components.FragmentContextView
                protected void playbackSpeedChanged(float value) {
                    float f3 = value - 1.0f;
                    if (Math.abs(f3) > 0.001f || Math.abs(value - 1.8f) > 0.001f) {
                        DialogsActivity.this.getUndoView().showWithAction(0L, Math.abs(f3) > 0.001f ? 50 : 51, Float.valueOf(value), null, null);
                    }
                }
            };
            this.fragmentContextView = fragmentContextView2;
            fragmentContextView2.setLayoutParams(LayoutHelper.createFrame(-1, 38.0f, 51, 0.0f, -36.0f, 0.0f, 0.0f));
            contentView3.addView(this.fragmentContextView);
            this.fragmentContextView.setAdditionalContextView(this.fragmentLocationContextView);
            this.fragmentLocationContextView.setAdditionalContextView(this.fragmentContextView);
        } else if (this.initialDialogsType == 3 || this.isForward) {
            ChatActivityEnterView chatActivityEnterView = this.commentView;
            if (chatActivityEnterView != null) {
                chatActivityEnterView.onDestroy();
            }
            ChatActivityEnterView chatActivityEnterView2 = new ChatActivityEnterView(getParentActivity(), contentView3, null, false) { // from class: ir.eitaa.ui.DialogsActivity.23
                @Override // android.view.ViewGroup, android.view.View
                public boolean dispatchTouchEvent(MotionEvent ev) {
                    if (ev.getAction() == 0) {
                        AndroidUtilities.requestAdjustResize(DialogsActivity.this.getParentActivity(), ((BaseFragment) DialogsActivity.this).classGuid);
                    }
                    return super.dispatchTouchEvent(ev);
                }
            };
            this.commentView = chatActivityEnterView2;
            chatActivityEnterView2.setAllowStickersAndGifs(false, false);
            this.commentView.setForceShowSendButton(true, false);
            this.commentView.setVisibility(8);
            contentView3.addView(this.commentView, LayoutHelper.createFrame(-1, -2, 83));
            this.commentView.setDelegate(new ChatActivityEnterView.ChatActivityEnterViewDelegate() { // from class: ir.eitaa.ui.DialogsActivity.24
                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ void bottomPanelTranslationYChanged(float f3) {
                    ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$bottomPanelTranslationYChanged(this, f3);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void didPressAttachButton() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ boolean hasForwardingMessages() {
                    return ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$hasForwardingMessages(this);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ boolean hasScheduledMessages() {
                    return ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$hasScheduledMessages(this);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void needChangeVideoPreviewState(int state, float seekProgress) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void needSendTyping() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void needShowMediaBanHint() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void needStartRecordAudio(int state) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void needStartRecordVideo(int state, boolean notify, int scheduleDate) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onAttachButtonHidden() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onAttachButtonShow() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onAudioVideoInterfaceUpdated() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onMessageEditEnd(boolean loading) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onPreAudioVideoRecord() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onSendLongClick() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onStickersExpandedChange() {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onStickersTab(boolean opened) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onSwitchRecordMode(boolean video) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onTextChanged(final CharSequence text, boolean bigChange) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onTextSelectionChanged(int start, int end) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onTextSpansChanged(CharSequence text) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ void onTrendingStickersShowed(boolean z2) {
                    ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$onTrendingStickersShowed(this, z2);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onUpdateSlowModeButton(View button, boolean show, CharSequence time) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onWindowSizeChanged(int size) {
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ void openScheduledMessages() {
                    ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$openScheduledMessages(this);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ void prepareMessageSending() {
                    ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$prepareMessageSending(this);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public /* synthetic */ void scrollToSendingMessage() {
                    ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$scrollToSendingMessage(this);
                }

                @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
                public void onMessageSend(CharSequence message, boolean notify, int scheduleDate) {
                    if (DialogsActivity.this.delegate == null || DialogsActivity.this.selectedDialogs.isEmpty()) {
                        return;
                    }
                    DialogsActivityDelegate dialogsActivityDelegate = DialogsActivity.this.delegate;
                    DialogsActivity dialogsActivity = DialogsActivity.this;
                    dialogsActivityDelegate.didSelectDialogs(dialogsActivity, dialogsActivity.selectedDialogs, message, false);
                }
            });
        }
        if (!SharedConfig.filtersVisibility) {
            this.filterTabsView = null;
        }
        FilterTabsView filterTabsView2 = this.filterTabsView;
        if (filterTabsView2 != null) {
            i4 = -1;
            contentView3.addView(filterTabsView2, LayoutHelper.createFrame(-1, 44.0f));
        } else {
            i4 = -1;
        }
        if (!this.onlySelect) {
            FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(i4, -2.0f);
            if (this.inPreviewMode && i12 >= 21) {
                layoutParamsCreateFrame.topMargin = AndroidUtilities.statusBarHeight;
            }
            contentView3.addView(this.actionBar, layoutParamsCreateFrame);
        }
        if (this.searchString == null && this.initialDialogsType == 0) {
            FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.DialogsActivity.25
                private int lastGradientWidth;
                private LinearGradient updateGradient;
                private Paint paint = new Paint();
                private Matrix matrix = new Matrix();

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    if (this.updateGradient == null) {
                        return;
                    }
                    this.paint.setColor(-1);
                    this.paint.setShader(this.updateGradient);
                    this.updateGradient.setLocalMatrix(this.matrix);
                    canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
                    DialogsActivity.this.updateLayoutIcon.setBackgroundGradientDrawable(this.updateGradient);
                    DialogsActivity.this.updateLayoutIcon.draw(canvas);
                }

                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    int size = View.MeasureSpec.getSize(widthMeasureSpec);
                    if (this.lastGradientWidth != size) {
                        this.updateGradient = new LinearGradient(0.0f, 0.0f, size, 0.0f, new int[]{-9846926, -11291731}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                        this.lastGradientWidth = size;
                    }
                    int measuredWidth = (getMeasuredWidth() - DialogsActivity.this.updateTextView.getMeasuredWidth()) / 2;
                    DialogsActivity.this.updateLayoutIcon.setProgressRect(measuredWidth, AndroidUtilities.dp(13.0f), AndroidUtilities.dp(22.0f) + measuredWidth, AndroidUtilities.dp(35.0f));
                }

                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    super.setTranslationY(translationY);
                    DialogsActivity.this.additionalFloatingTranslation2 = AndroidUtilities.dp(48.0f) - translationY;
                    if (DialogsActivity.this.additionalFloatingTranslation2 < 0.0f) {
                        DialogsActivity.this.additionalFloatingTranslation2 = 0.0f;
                    }
                    if (DialogsActivity.this.floatingHidden) {
                        return;
                    }
                    DialogsActivity.this.updateFloatingButtonOffset();
                }
            };
            this.updateLayout = frameLayout3;
            frameLayout3.setWillNotDraw(false);
            this.updateLayout.setVisibility(4);
            this.updateLayout.setTranslationY(AndroidUtilities.dp(48.0f));
            if (i12 >= 21) {
                this.updateLayout.setBackground(Theme.getSelectorDrawable(Theme.getColor("listSelectorSDK21"), (String) null));
            }
            contentView3.addView(this.updateLayout, LayoutHelper.createFrame(-1, 48, 83));
            this.updateLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$JyH3XXzwxz8_lWAqwrqNHf5G2CM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$9$DialogsActivity(view);
                }
            });
            RadialProgress2 radialProgress2 = new RadialProgress2(this.updateLayout);
            this.updateLayoutIcon = radialProgress2;
            radialProgress2.setColors(-1, -1, -1, -1);
            this.updateLayoutIcon.setCircleRadius(AndroidUtilities.dp(11.0f));
            this.updateLayoutIcon.setAsMini();
            this.updateLayoutIcon.setIcon(15, true, false);
            TextView textView = new TextView(context);
            this.updateTextView = textView;
            textView.setTextSize(1, 15.0f);
            this.updateTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.updateTextView.setText(LocaleController.getString("AppUpdateNow", R.string.AppUpdateNow).toUpperCase());
            this.updateTextView.setTextColor(-1);
            this.updateTextView.setPadding(AndroidUtilities.dp(30.0f), 0, 0, 0);
            this.updateLayout.addView(this.updateTextView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        for (int i14 = 0; i14 < i3; i14++) {
            this.undoView[i14] = new AnonymousClass26(context);
            contentView3.addView(this.undoView[i14], LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        }
        if (this.folderId != 0) {
            this.viewPages[0].listView.setGlowColor(Theme.getColor("actionBarDefaultArchived"));
            this.actionBar.setTitleColor(Theme.getColor("actionBarDefaultArchivedTitle"));
            this.actionBar.setItemsColor(Theme.getColor("actionBarDefaultArchivedIcon"), false);
            this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultArchivedSelector"), false);
            this.actionBar.setSearchTextColor(Theme.getColor("actionBarDefaultArchivedSearch"), false);
            this.actionBar.setSearchTextColor(Theme.getColor("actionBarDefaultSearchArchivedPlaceholder"), true);
        }
        if (!this.onlySelect && this.initialDialogsType == 0) {
            View view = new View(context) { // from class: ir.eitaa.ui.DialogsActivity.27
                @Override // android.view.View
                public void setAlpha(float alpha) {
                    super.setAlpha(alpha);
                    if (((BaseFragment) DialogsActivity.this).fragmentView != null) {
                        ((BaseFragment) DialogsActivity.this).fragmentView.invalidate();
                    }
                }
            };
            this.blurredView = view;
            view.setVisibility(8);
            contentView3.addView(this.blurredView, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.actionBarDefaultPaint.setColor(Theme.getColor(this.folderId == 0 ? str6 : "actionBarDefaultArchived"));
        if (this.inPreviewMode) {
            TLRPC$User currentUser2 = getUserConfig().getCurrentUser();
            ChatAvatarContainer chatAvatarContainer = new ChatAvatarContainer(this.actionBar.getContext(), null, false);
            this.avatarContainer = chatAvatarContainer;
            chatAvatarContainer.setTitle(UserObject.getUserName(currentUser2));
            this.avatarContainer.setSubtitle(LocaleController.formatUserStatus(this.currentAccount, currentUser2));
            this.avatarContainer.setUserAvatar(currentUser2, true);
            this.avatarContainer.setOccupyStatusBar(false);
            this.avatarContainer.setLeftPadding(AndroidUtilities.dp(10.0f));
            this.actionBar.addView(this.avatarContainer, 0, LayoutHelper.createFrame(-2, -1.0f, 51, 0.0f, 0.0f, 40.0f, 0.0f));
            this.floatingButton.setVisibility(4);
            this.actionBar.setOccupyStatusBar(false);
            this.actionBar.setBackgroundColor(Theme.getColor(str6));
            FragmentContextView fragmentContextView3 = this.fragmentContextView;
            if (fragmentContextView3 != null) {
                contentView3.removeView(fragmentContextView3);
            }
            FragmentContextView fragmentContextView4 = this.fragmentLocationContextView;
            if (fragmentContextView4 != null) {
                contentView3.removeView(fragmentContextView4);
            }
        }
        this.searchIsShowed = false;
        updateFilterTabs(false, false);
        if (this.searchString != null) {
            showSearch(true, false, context);
            this.actionBar.openSearchField(this.searchString, false);
        } else if (this.initialSearchString != null) {
            showSearch(true, false, context);
            this.actionBar.openSearchField(this.initialSearchString, false);
            this.initialSearchString = null;
            FilterTabsView filterTabsView3 = this.filterTabsView;
            if (filterTabsView3 != null) {
                filterTabsView3.setTranslationY(-AndroidUtilities.dp(44.0f));
            }
        } else {
            showSearch(false, false, context);
        }
        updateMenuButton(false);
        LaunchActivity.isShare = false;
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$DialogsActivity(View view) {
        this.filterTabsView.setIsEditing(false);
        showDoneItem(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$DialogsActivity() {
        if (this.initialDialogsType != 10) {
            hideFloatingButton(false);
        }
        scrollToTop();
    }

    /* renamed from: ir.eitaa.ui.DialogsActivity$8, reason: invalid class name */
    class AnonymousClass8 implements FilterTabsView.FilterTabsViewDelegate {
        static /* synthetic */ void lambda$showDeleteAlert$0() {
        }

        AnonymousClass8() {
        }

        private void showDeleteAlert(final MessagesController.DialogFilter dialogFilter) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("FilterDelete", R.string.FilterDelete));
            builder.setMessage(LocaleController.getString("FilterDeleteAlert", R.string.FilterDeleteAlert));
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$8$_EmMFiDVoP_43OeQHQsbck2dSTM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$showDeleteAlert$2$DialogsActivity$8(dialogFilter, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showDeleteAlert$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showDeleteAlert$2$DialogsActivity$8(MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
            tLRPC$TL_messages_updateDialogFilter.id = dialogFilter.id;
            DialogsActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$8$9B7jZOlAoglTC2_NCWlHpkSDkHU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$8$4qJrEthgswi5i1jJdu6AMc8p2F8
                        @Override // java.lang.Runnable
                        public final void run() {
                            DialogsActivity.AnonymousClass8.lambda$showDeleteAlert$0();
                        }
                    });
                }
            });
            DialogsActivity.this.getMessagesController().removeFilter(dialogFilter);
            DialogsActivity.this.getMessagesStorage().deleteDialogFilter(dialogFilter);
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onSamePageSelected() {
            DialogsActivity.this.scrollToTop();
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageReorder(int fromId, int toId) {
            for (int i = 0; i < DialogsActivity.this.viewPages.length; i++) {
                if (DialogsActivity.this.viewPages[i].selectedType == fromId) {
                    DialogsActivity.this.viewPages[i].selectedType = toId;
                } else if (DialogsActivity.this.viewPages[i].selectedType == toId) {
                    DialogsActivity.this.viewPages[i].selectedType = fromId;
                }
            }
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageSelected(int id, boolean forward) {
            if (DialogsActivity.this.viewPages[0].selectedType == id) {
                return;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = DialogsActivity.this.getMessagesController().dialogFilters;
            if (id == Integer.MAX_VALUE || (id >= 0 && id < arrayList.size())) {
                if (((BaseFragment) DialogsActivity.this).parentLayout != null) {
                    ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(id == DialogsActivity.this.filterTabsView.getFirstTabId() || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 5);
                }
                DialogsActivity.this.viewPages[1].selectedType = id;
                DialogsActivity.this.viewPages[1].setVisibility(0);
                DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
                DialogsActivity.this.showScrollbars(false);
                DialogsActivity.this.switchToCurrentSelectedMode(true);
                DialogsActivity.this.animatingForward = forward;
            }
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public boolean canPerformActions() {
            return !DialogsActivity.this.searching;
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageScrolled(float progress) {
            if (progress != 1.0f || DialogsActivity.this.viewPages[1].getVisibility() == 0 || DialogsActivity.this.searching) {
                if (DialogsActivity.this.animatingForward) {
                    DialogsActivity.this.viewPages[0].setTranslationX((-progress) * DialogsActivity.this.viewPages[0].getMeasuredWidth());
                    DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() - (DialogsActivity.this.viewPages[0].getMeasuredWidth() * progress));
                } else {
                    DialogsActivity.this.viewPages[0].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() * progress);
                    DialogsActivity.this.viewPages[1].setTranslationX((DialogsActivity.this.viewPages[0].getMeasuredWidth() * progress) - DialogsActivity.this.viewPages[0].getMeasuredWidth());
                }
                if (progress == 1.0f) {
                    ViewPage viewPage = DialogsActivity.this.viewPages[0];
                    DialogsActivity.this.viewPages[0] = DialogsActivity.this.viewPages[1];
                    DialogsActivity.this.viewPages[1] = viewPage;
                    DialogsActivity.this.viewPages[1].setVisibility(8);
                    DialogsActivity.this.showScrollbars(true);
                    DialogsActivity.this.updateCounters(false);
                    DialogsActivity dialogsActivity = DialogsActivity.this;
                    dialogsActivity.checkListLoad(dialogsActivity.viewPages[0]);
                    DialogsActivity.this.viewPages[0].dialogsAdapter.resume();
                    DialogsActivity.this.viewPages[1].dialogsAdapter.pause();
                }
            }
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public int getTabCounter(int tabId) {
            if (tabId == Integer.MAX_VALUE) {
                return DialogsActivity.this.getMessagesStorage().getMainUnreadCount();
            }
            ArrayList<MessagesController.DialogFilter> arrayList = DialogsActivity.this.getMessagesController().dialogFilters;
            if (tabId < 0 || tabId >= arrayList.size()) {
                return 0;
            }
            return DialogsActivity.this.getMessagesController().dialogFilters.get(tabId).unreadCount;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean didSelectTab(ir.eitaa.ui.Components.FilterTabsView.TabView r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 850
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.AnonymousClass8.didSelectTab(ir.eitaa.ui.Components.FilterTabsView$TabView, boolean):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didSelectTab$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didSelectTab$3$DialogsActivity$8(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing()) {
                DialogsActivity.this.scrimPopupWindow.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didSelectTab$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didSelectTab$4$DialogsActivity$8(MessagesController.DialogFilter dialogFilter, int i, int i2, View view) {
            if (dialogFilter == null) {
                if (i == 0) {
                    DialogsActivity.this.resetScroll();
                    DialogsActivity.this.filterTabsView.setIsEditing(true);
                    DialogsActivity.this.showDoneItem(true);
                } else if (i != 1) {
                    showDeleteAlert(dialogFilter);
                } else if (i2 == 2) {
                    DialogsActivity.this.presentFragment(new FiltersSetupActivity());
                } else {
                    DialogsActivity.this.presentFragment(new FilterCreateActivity(dialogFilter));
                }
            } else if (i == 0) {
                DialogsActivity.this.resetScroll();
                DialogsActivity.this.filterTabsView.setIsEditing(true);
                DialogsActivity.this.showDoneItem(true);
            } else if (i == 2) {
                if (i2 == 2) {
                    DialogsActivity.this.presentFragment(new FiltersSetupActivity());
                } else {
                    DialogsActivity.this.presentFragment(new FilterCreateActivity(dialogFilter));
                }
            } else if (i == 3) {
                showDeleteAlert(dialogFilter);
            } else if (i == 1) {
                if (dialogFilter.dialogs.size() == 0) {
                    DialogsActivity.this.getMessagesController().selectDialogFilter(dialogFilter, 1);
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < dialogFilter.dialogs.size(); i3++) {
                    arrayList.add(Long.valueOf(dialogFilter.dialogs.get(i3).id));
                    if (dialogFilter.dialogs.get(i3).unread_count != 0 || dialogFilter.dialogs.get(i3).unread_mark) {
                        DialogsActivity.access$13608(DialogsActivity.this);
                    }
                }
                if (DialogsActivity.this.canReadCount != 0) {
                    DialogsActivity.this.performSelectedDialogsAction(arrayList, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, true);
                }
            }
            if (DialogsActivity.this.scrimPopupWindow != null) {
                DialogsActivity.this.scrimPopupWindow.dismiss();
            }
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public boolean isTabMenuVisible() {
            return DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing();
        }

        @Override // ir.eitaa.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onDeletePressed(int id) {
            showDeleteAlert(DialogsActivity.this.getMessagesController().dialogFilters.get(id));
        }
    }

    /* renamed from: ir.eitaa.ui.DialogsActivity$12, reason: invalid class name */
    class AnonymousClass12 extends LinearLayoutManager {
        private boolean fixOffset;
        final /* synthetic */ ViewPage val$viewPage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(Context context, final ViewPage val$viewPage) {
            super(context);
            this.val$viewPage = val$viewPage;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void scrollToPositionWithOffset(int position, int offset) {
            if (this.fixOffset) {
                offset -= this.val$viewPage.listView.getPaddingTop();
            }
            super.scrollToPositionWithOffset(position, offset);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
        public void prepareForDrop(View view, View target, int x, int y) {
            this.fixOffset = true;
            super.prepareForDrop(view, target, x, y);
            this.fixOffset = false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
            if (DialogsActivity.this.hasHiddenArchive() && position == 1) {
                super.smoothScrollToPosition(recyclerView, state, position);
                return;
            }
            LinearSmoothScrollerCustom linearSmoothScrollerCustom = new LinearSmoothScrollerCustom(recyclerView.getContext(), 0);
            linearSmoothScrollerCustom.setTargetPosition(position);
            startSmoothScroll(linearSmoothScrollerCustom);
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x010c  */
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int scrollVerticallyBy(int r18, androidx.recyclerview.widget.RecyclerView.Recycler r19, androidx.recyclerview.widget.RecyclerView.State r20) {
            /*
                Method dump skipped, instructions count: 709
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.AnonymousClass12.scrollVerticallyBy(int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):int");
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (BuildVars.DEBUG_PRIVATE_VERSION) {
                try {
                    super.onLayoutChildren(recycler, state);
                    return;
                } catch (IndexOutOfBoundsException unused) {
                    throw new RuntimeException("Inconsistency detected. dialogsListIsFrozen=" + DialogsActivity.this.dialogsListFrozen + " lastUpdateAction=" + DialogsActivity.this.debugLastUpdateAction);
                }
            }
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                FileLog.e(e);
                final ViewPage viewPage = this.val$viewPage;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$12$f51Xej3K-FPO7MUsEqQ5Ki9Ixo0
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewPage.dialogsAdapter.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$DialogsActivity(ViewPage viewPage, View view, int i, float f, float f2) {
        int i2 = this.initialDialogsType;
        if (i2 == 10) {
            onItemLongClick(view, i, 0.0f, 0.0f, viewPage.dialogsType, viewPage.dialogsAdapter);
            return;
        }
        if ((i2 != 11 && i2 != 13) || i != 1) {
            onItemClick(view, i, viewPage.dialogsAdapter, f, f2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("forImport", true);
        bundle.putLongArray("result", new long[]{getUserConfig().getClientUserId()});
        bundle.putInt("chatType", 4);
        String string = this.arguments.getString("importTitle");
        if (string != null) {
            bundle.putString("title", string);
        }
        GroupCreateFinalActivity groupCreateFinalActivity = new GroupCreateFinalActivity(bundle);
        groupCreateFinalActivity.setDelegate(new GroupCreateFinalActivity.GroupCreateFinalActivityDelegate() { // from class: ir.eitaa.ui.DialogsActivity.13
            @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didFailChatCreation() {
            }

            @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didStartChatCreation() {
            }

            @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didFinishChatCreation(GroupCreateFinalActivity fragment, long chatId) {
                ArrayList<Long> arrayList = new ArrayList<>();
                arrayList.add(Long.valueOf(-chatId));
                DialogsActivityDelegate dialogsActivityDelegate = DialogsActivity.this.delegate;
                DialogsActivity.this.removeSelfFromStack();
                dialogsActivityDelegate.didSelectDialogs(DialogsActivity.this, arrayList, null, true);
            }
        });
        presentFragment(groupCreateFinalActivity);
    }

    /* renamed from: ir.eitaa.ui.DialogsActivity$19, reason: invalid class name */
    class AnonymousClass19 implements DialogsSearchAdapter.DialogsSearchAdapterDelegate {
        AnonymousClass19() {
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void searchStateChanged(boolean search, boolean animated) {
            if (DialogsActivity.this.searchViewPager.emptyView.getVisibility() == 0) {
                animated = true;
            }
            if (DialogsActivity.this.searching && DialogsActivity.this.searchWas && DialogsActivity.this.searchViewPager.emptyView != null) {
                if (search || DialogsActivity.this.searchViewPager.dialogsSearchAdapter.getItemCount() != 0) {
                    DialogsActivity.this.searchViewPager.emptyView.showProgress(true, animated);
                } else {
                    DialogsActivity.this.searchViewPager.emptyView.showProgress(false, animated);
                }
            }
            if (search && DialogsActivity.this.searchViewPager.dialogsSearchAdapter.getItemCount() == 0) {
                DialogsActivity.this.searchViewPager.cancelEnterAnimation();
            }
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void didPressedOnSubDialog(long did) {
            if (DialogsActivity.this.onlySelect || DialogsActivity.this.isForward) {
                if (DialogsActivity.this.validateSlowModeDialog(did)) {
                    if (DialogsActivity.this.selectedDialogs.isEmpty()) {
                        DialogsActivity.this.didSelectResult(did, true, false);
                        return;
                    }
                    DialogsActivity.this.findAndUpdateCheckBox(did, DialogsActivity.this.addOrRemoveSelectedDialog(did, null));
                    DialogsActivity.this.updateSelectedCount();
                    ((BaseFragment) DialogsActivity.this).actionBar.closeSearchField();
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            if (DialogObject.isUserDialog(did)) {
                bundle.putLong("user_id", did);
            } else {
                bundle.putLong("chat_id", -did);
            }
            DialogsActivity.this.closeSearch();
            if (AndroidUtilities.isTablet() && DialogsActivity.this.viewPages != null) {
                for (int i = 0; i < DialogsActivity.this.viewPages.length; i++) {
                    DialogsActivity.this.viewPages[i].dialogsAdapter.setOpenedDialogId(DialogsActivity.this.openedDialogId = did);
                }
                DialogsActivity.this.updateVisibleRows(MessagesController.UPDATE_MASK_SELECT_DIALOG);
            }
            if (DialogsActivity.this.searchString != null) {
                if (DialogsActivity.this.getMessagesController().checkCanOpenChat(bundle, DialogsActivity.this)) {
                    DialogsActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
                    DialogsActivity.this.presentFragment(new ChatActivity(bundle));
                    return;
                }
                return;
            }
            if (DialogsActivity.this.getMessagesController().checkCanOpenChat(bundle, DialogsActivity.this)) {
                DialogsActivity.this.presentFragment(new ChatActivity(bundle));
            }
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void needRemoveHint(final long did) {
            TLRPC$User user;
            if (DialogsActivity.this.getParentActivity() == null || (user = DialogsActivity.this.getMessagesController().getUser(Long.valueOf(did))) == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("ChatHintsDeleteAlertTitle", R.string.ChatHintsDeleteAlertTitle));
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("ChatHintsDeleteAlert", R.string.ChatHintsDeleteAlert, ContactsController.formatName(user.first_name, user.last_name))));
            builder.setPositiveButton(LocaleController.getString("StickersRemove", R.string.StickersRemove), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$19$PHFBZxXZSsQurjUyii522ha5wuc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$needRemoveHint$0$DialogsActivity$19(did, dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$needRemoveHint$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$needRemoveHint$0$DialogsActivity$19(long j, DialogInterface dialogInterface, int i) {
            DialogsActivity.this.getMediaDataController().removePeer(j);
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void needClearList() {
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("ClearSearchAlertTitle", R.string.ClearSearchAlertTitle));
            builder.setMessage(LocaleController.getString("ClearSearchAlert", R.string.ClearSearchAlert));
            builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$19$EgnqajR1sptNDqmwaDfVmJqEMEQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$needClearList$1$DialogsActivity$19(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$needClearList$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$needClearList$1$DialogsActivity$19(DialogInterface dialogInterface, int i) {
            if (DialogsActivity.this.searchViewPager.dialogsSearchAdapter.isRecentSearchDisplayed()) {
                DialogsActivity.this.searchViewPager.dialogsSearchAdapter.clearRecentSearch();
            } else {
                DialogsActivity.this.searchViewPager.dialogsSearchAdapter.clearRecentHashtags();
            }
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void runResultsEnterAnimation() {
            if (DialogsActivity.this.searchViewPager != null) {
                DialogsActivity.this.searchViewPager.runResultsEnterAnimation();
            }
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public boolean isSelected(long dialogId) {
            return DialogsActivity.this.selectedDialogs.contains(Long.valueOf(dialogId));
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void mxbPressed(String phone) {
            MxbHelper.showMxbMessengersDialog(DialogsActivity.this, phone);
        }

        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public boolean isForward() {
            return DialogsActivity.this.isForward;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$DialogsActivity(View view, int i) {
        if (this.initialDialogsType == 10) {
            onItemLongClick(view, i, 0.0f, 0.0f, -1, this.searchViewPager.dialogsSearchAdapter);
        } else {
            onItemClick(view, i, this.searchViewPager.dialogsSearchAdapter, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$DialogsActivity(boolean z, ArrayList arrayList, ArrayList arrayList2, boolean z2) {
        updateFiltersView(z, arrayList, arrayList2, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$DialogsActivity(View view, int i) {
        this.filtersView.cancelClickRunnables(true);
        addSearchFilter(this.filtersView.getFilterAt(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$DialogsActivity(View view) {
        if (this.initialDialogsType == 10) {
            if (this.delegate == null || this.selectedDialogs.isEmpty()) {
                return;
            }
            this.delegate.didSelectDialogs(this, this.selectedDialogs, null, false);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("destroyAfterSelect", true);
        presentFragment(new ContactsActivity(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$DialogsActivity(View view) {
        if (SharedConfig.isAppUpdateAvailable()) {
            AndroidUtilities.openForView(SharedConfig.pendingAppUpdate.document, true, getParentActivity());
        }
    }

    /* renamed from: ir.eitaa.ui.DialogsActivity$26, reason: invalid class name */
    class AnonymousClass26 extends UndoView {
        AnonymousClass26(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setTranslationY(float translationY) {
            super.setTranslationY(translationY);
            if (this != DialogsActivity.this.undoView[0] || DialogsActivity.this.undoView[1].getVisibility() == 0) {
                return;
            }
            DialogsActivity.this.additionalFloatingTranslation = (getMeasuredHeight() + AndroidUtilities.dp(8.0f)) - translationY;
            if (DialogsActivity.this.additionalFloatingTranslation < 0.0f) {
                DialogsActivity.this.additionalFloatingTranslation = 0.0f;
            }
            if (DialogsActivity.this.floatingHidden) {
                return;
            }
            DialogsActivity.this.updateFloatingButtonOffset();
        }

        @Override // ir.eitaa.ui.Components.UndoView
        protected boolean canUndo() {
            for (int i = 0; i < DialogsActivity.this.viewPages.length; i++) {
                if (DialogsActivity.this.viewPages[i].dialogsItemAnimator.isRunning()) {
                    return false;
                }
            }
            return true;
        }

        @Override // ir.eitaa.ui.Components.UndoView
        protected void onRemoveDialogAction(long currentDialogId, int action) {
            if (action == 1 || action == 27) {
                DialogsActivity.this.debugLastUpdateAction = 1;
                DialogsActivity.this.setDialogsListFrozen(true);
                if (DialogsActivity.this.frozenDialogsList != null) {
                    final int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= DialogsActivity.this.frozenDialogsList.size()) {
                            break;
                        }
                        if (((TLRPC$Dialog) DialogsActivity.this.frozenDialogsList.get(i2)).id == currentDialogId) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                    if (i >= 0) {
                        final TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) DialogsActivity.this.frozenDialogsList.remove(i);
                        DialogsActivity.this.viewPages[0].dialogsAdapter.notifyDataSetChanged();
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$26$QRLmfxyqvwhQ5K8zPSqp_3VPRNw
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onRemoveDialogAction$0$DialogsActivity$26(i, tLRPC$Dialog);
                            }
                        });
                        return;
                    }
                    DialogsActivity.this.setDialogsListFrozen(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onRemoveDialogAction$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onRemoveDialogAction$0$DialogsActivity$26(int i, TLRPC$Dialog tLRPC$Dialog) {
            if (DialogsActivity.this.frozenDialogsList != null) {
                DialogsActivity.this.frozenDialogsList.add(i, tLRPC$Dialog);
                DialogsActivity.this.viewPages[0].dialogsAdapter.notifyItemInserted(i);
                DialogsActivity.this.dialogInsertFinished = 2;
            }
        }
    }

    private void updateAppUpdateViews(boolean animated) {
        boolean zExists;
        if (this.updateLayout == null) {
            return;
        }
        if (SharedConfig.isAppUpdateAvailable()) {
            FileLoader.getAttachFileName(SharedConfig.pendingAppUpdate.document);
            zExists = FileLoader.getPathToAttach(SharedConfig.pendingAppUpdate.document, true).exists();
        } else {
            zExists = false;
        }
        if (zExists) {
            if (this.updateLayout.getTag() != null) {
                return;
            }
            AnimatorSet animatorSet = this.updateLayoutAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.updateLayout.setVisibility(0);
            this.updateLayout.setTag(1);
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.updateLayoutAnimator = animatorSet2;
                animatorSet2.setDuration(180L);
                this.updateLayoutAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                this.updateLayoutAnimator.playTogether(ObjectAnimator.ofFloat(this.updateLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f));
                this.updateLayoutAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.28
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        DialogsActivity.this.updateLayoutAnimator = null;
                    }
                });
                this.updateLayoutAnimator.start();
                return;
            }
            this.updateLayout.setTranslationY(0.0f);
            return;
        }
        if (this.updateLayout.getTag() == null) {
            return;
        }
        this.updateLayout.setTag(null);
        if (animated) {
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.updateLayoutAnimator = animatorSet3;
            animatorSet3.setDuration(180L);
            this.updateLayoutAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.updateLayoutAnimator.playTogether(ObjectAnimator.ofFloat(this.updateLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(48.0f)));
            this.updateLayoutAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.29
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (DialogsActivity.this.updateLayout.getTag() == null) {
                        DialogsActivity.this.updateLayout.setVisibility(4);
                    }
                    DialogsActivity.this.updateLayoutAnimator = null;
                }
            });
            this.updateLayoutAnimator.start();
            return;
        }
        this.updateLayout.setTranslationY(AndroidUtilities.dp(48.0f));
        this.updateLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContextViewPosition() {
        FilterTabsView filterTabsView = this.filterTabsView;
        float fDp = 0.0f;
        float measuredHeight = (filterTabsView == null || filterTabsView.getVisibility() == 8) ? 0.0f : this.filterTabsView.getMeasuredHeight();
        ViewPagerFixed.TabsView tabsView = this.searchTabsView;
        float measuredHeight2 = (tabsView == null || tabsView.getVisibility() == 8) ? 0.0f : this.searchTabsView.getMeasuredHeight();
        if (this.fragmentContextView != null) {
            FragmentContextView fragmentContextView = this.fragmentLocationContextView;
            float fDp2 = (fragmentContextView == null || fragmentContextView.getVisibility() != 0) ? 0.0f : AndroidUtilities.dp(36.0f) + 0.0f;
            FragmentContextView fragmentContextView2 = this.fragmentContextView;
            float topPadding = fDp2 + fragmentContextView2.getTopPadding() + this.actionBar.getTranslationY();
            float f = this.searchAnimationProgress;
            fragmentContextView2.setTranslationY(topPadding + ((1.0f - f) * measuredHeight) + (f * measuredHeight2) + this.tabsYOffset);
        }
        if (this.fragmentLocationContextView != null) {
            FragmentContextView fragmentContextView3 = this.fragmentContextView;
            if (fragmentContextView3 != null && fragmentContextView3.getVisibility() == 0) {
                fDp = 0.0f + AndroidUtilities.dp(this.fragmentContextView.getStyleHeight()) + this.fragmentContextView.getTopPadding();
            }
            FragmentContextView fragmentContextView4 = this.fragmentLocationContextView;
            float topPadding2 = fDp + fragmentContextView4.getTopPadding() + this.actionBar.getTranslationY();
            float f2 = this.searchAnimationProgress;
            fragmentContextView4.setTranslationY(topPadding2 + (measuredHeight * (1.0f - f2)) + (measuredHeight2 * f2) + this.tabsYOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateFiltersView(boolean r11, java.util.ArrayList<java.lang.Object> r12, java.util.ArrayList<ir.eitaa.ui.Adapters.FiltersView.DateData> r13, boolean r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r10.searchIsShowed
            if (r0 == 0) goto Lbf
            boolean r0 = r10.onlySelect
            if (r0 == 0) goto La
            goto Lbf
        La:
            ir.eitaa.ui.Components.SearchViewPager r0 = r10.searchViewPager
            java.util.ArrayList r0 = r0.getCurrentSearchFilters()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L16:
            int r7 = r0.size()
            r8 = 1
            if (r2 >= r7) goto L54
            java.lang.Object r7 = r0.get(r2)
            ir.eitaa.ui.Adapters.FiltersView$MediaFilterData r7 = (ir.eitaa.ui.Adapters.FiltersView.MediaFilterData) r7
            boolean r7 = r7.isMedia()
            if (r7 == 0) goto L2b
            r4 = 1
            goto L51
        L2b:
            java.lang.Object r7 = r0.get(r2)
            ir.eitaa.ui.Adapters.FiltersView$MediaFilterData r7 = (ir.eitaa.ui.Adapters.FiltersView.MediaFilterData) r7
            int r7 = r7.filterType
            r9 = 4
            if (r7 != r9) goto L38
            r5 = 1
            goto L51
        L38:
            java.lang.Object r7 = r0.get(r2)
            ir.eitaa.ui.Adapters.FiltersView$MediaFilterData r7 = (ir.eitaa.ui.Adapters.FiltersView.MediaFilterData) r7
            int r7 = r7.filterType
            r9 = 6
            if (r7 != r9) goto L45
            r6 = 1
            goto L51
        L45:
            java.lang.Object r7 = r0.get(r2)
            ir.eitaa.ui.Adapters.FiltersView$MediaFilterData r7 = (ir.eitaa.ui.Adapters.FiltersView.MediaFilterData) r7
            int r7 = r7.filterType
            r9 = 7
            if (r7 != r9) goto L51
            r3 = 1
        L51:
            int r2 = r2 + 1
            goto L16
        L54:
            if (r3 == 0) goto L57
            r14 = 0
        L57:
            if (r12 == 0) goto L5f
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L69
        L5f:
            if (r13 == 0) goto L67
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L69
        L67:
            if (r14 == 0) goto L6b
        L69:
            r0 = 1
            goto L6c
        L6b:
            r0 = 0
        L6c:
            r2 = 0
            if (r4 != 0) goto L74
            if (r0 != 0) goto L74
            if (r11 == 0) goto L74
            goto L9b
        L74:
            if (r0 == 0) goto L9b
            if (r12 == 0) goto L81
            boolean r11 = r12.isEmpty()
            if (r11 != 0) goto L81
            if (r5 != 0) goto L81
            goto L82
        L81:
            r12 = r2
        L82:
            if (r13 == 0) goto L8d
            boolean r11 = r13.isEmpty()
            if (r11 != 0) goto L8d
            if (r6 != 0) goto L8d
            goto L8e
        L8d:
            r13 = r2
        L8e:
            if (r12 != 0) goto L94
            if (r13 != 0) goto L94
            if (r14 == 0) goto L9b
        L94:
            ir.eitaa.ui.Adapters.FiltersView r11 = r10.filtersView
            r11.setUsersAndDates(r12, r13, r14)
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r11 != 0) goto La3
            ir.eitaa.ui.Adapters.FiltersView r12 = r10.filtersView
            r12.setUsersAndDates(r2, r2, r1)
        La3:
            if (r15 != 0) goto Lae
            ir.eitaa.ui.Adapters.FiltersView r12 = r10.filtersView
            androidx.recyclerview.widget.RecyclerView$Adapter r12 = r12.getAdapter()
            r12.notifyDataSetChanged()
        Lae:
            ir.eitaa.ui.Components.ViewPagerFixed$TabsView r12 = r10.searchTabsView
            if (r12 == 0) goto Lb5
            r12.hide(r11, r8)
        Lb5:
            ir.eitaa.ui.Adapters.FiltersView r12 = r10.filtersView
            r12.setEnabled(r11)
            ir.eitaa.ui.Adapters.FiltersView r11 = r10.filtersView
            r11.setVisibility(r1)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.updateFiltersView(boolean, java.util.ArrayList, java.util.ArrayList, boolean, boolean):void");
    }

    private void addSearchFilter(FiltersView.MediaFilterData filter) {
        if (this.searchIsShowed) {
            ArrayList<FiltersView.MediaFilterData> currentSearchFilters = this.searchViewPager.getCurrentSearchFilters();
            if (!currentSearchFilters.isEmpty()) {
                for (int i = 0; i < currentSearchFilters.size(); i++) {
                    if (filter.isSameType(currentSearchFilters.get(i))) {
                        return;
                    }
                }
            }
            currentSearchFilters.add(filter);
            this.actionBar.setSearchFilter(filter);
            this.actionBar.setSearchFieldText("");
            updateFiltersView(true, null, null, false, true);
        }
    }

    private void createActionMode(String tag) {
        if (this.actionBar.actionModeIsExist(tag)) {
            return;
        }
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode(false, tag);
        actionBarMenuCreateActionMode.setBackground(null);
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedDialogsCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedDialogsCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.selectedDialogsCountTextView.setTextColor(Theme.getColor("actionBarActionModeDefaultIcon"));
        actionBarMenuCreateActionMode.addView(this.selectedDialogsCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedDialogsCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$n47kuRMq93JhpE9wTkf9ZVMaj48
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DialogsActivity.lambda$createActionMode$10(view, motionEvent);
            }
        });
        this.pinItem = actionBarMenuCreateActionMode.addItemWithWidth(100, R.drawable.msg_pin, AndroidUtilities.dp(54.0f));
        this.muteItem = actionBarMenuCreateActionMode.addItemWithWidth(R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.drawable.msg_mute, AndroidUtilities.dp(54.0f));
        this.archive2Item = actionBarMenuCreateActionMode.addItemWithWidth(R.styleable.AppCompatTheme_toolbarStyle, R.drawable.msg_archive, AndroidUtilities.dp(54.0f));
        this.deleteItem = actionBarMenuCreateActionMode.addItemWithWidth(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete));
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = actionBarMenuCreateActionMode.addItemWithWidth(0, R.drawable.ic_ab_other, AndroidUtilities.dp(54.0f), LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.archiveItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_textColorSearchUrl, R.drawable.msg_archive, LocaleController.getString("Archive", R.string.Archive));
        this.pin2Item = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_tooltipForegroundColor, R.drawable.msg_pin, LocaleController.getString("DialogPin", R.string.DialogPin));
        this.addToFolderItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_tooltipFrameBackground, R.drawable.msg_addfolder, LocaleController.getString("FilterAddTo", R.string.FilterAddTo));
        this.removeFromFolderItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_viewInflaterClass, R.drawable.msg_removefolder, LocaleController.getString("FilterRemoveFrom", R.string.FilterRemoveFrom));
        this.addToFavoriteItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_windowActionBar, R.drawable.stickers_favorites, LocaleController.getString("AddToFavsMenu", R.string.AddToFavsMenu));
        this.removeFromFavoriteItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_windowActionBarOverlay, R.drawable.stickers_favorites, LocaleController.getString("RemoveFromFavsMenu", R.string.RemoveFromFavsMenu));
        this.readItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, R.drawable.msg_markread, LocaleController.getString("MarkAsRead", R.string.MarkAsRead));
        this.clearItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu, R.drawable.msg_clear, LocaleController.getString("ClearHistory", R.string.ClearHistory));
        this.blockItem = actionBarMenuItemAddItemWithWidth.addSubItem(R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, R.drawable.msg_block, LocaleController.getString("BlockUser", R.string.BlockUser));
        this.lockChatItem = actionBarMenuItemAddItemWithWidth.addSubItem(1380, R.drawable.menu_secret, LocaleController.getString("LockThisChat", R.string.LockThisChat));
        this.actionModeViews.add(this.pinItem);
        this.actionModeViews.add(this.archive2Item);
        this.actionModeViews.add(this.muteItem);
        this.actionModeViews.add(this.deleteItem);
        this.actionModeViews.add(actionBarMenuItemAddItemWithWidth);
        if (tag == null) {
            this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass30());
        }
    }

    /* renamed from: ir.eitaa.ui.DialogsActivity$30, reason: invalid class name */
    class AnonymousClass30 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass30() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) throws InterruptedException, IOException {
            if (id == 201 || (id == 200 && DialogsActivity.this.searchViewPager != null)) {
                DialogsActivity.this.searchViewPager.onActionBarItemClick(id);
                return;
            }
            if (id == -1) {
                if (DialogsActivity.this.filterTabsView == null || !DialogsActivity.this.filterTabsView.isEditing()) {
                    if (((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                        if (DialogsActivity.this.searchViewPager == null || DialogsActivity.this.searchViewPager.getVisibility() != 0 || !DialogsActivity.this.searchViewPager.actionModeShowing()) {
                            DialogsActivity.this.hideActionMode(true);
                            return;
                        } else {
                            DialogsActivity.this.searchViewPager.hideActionMode();
                            return;
                        }
                    }
                    if (!DialogsActivity.this.onlySelect && DialogsActivity.this.folderId == 0) {
                        DialogsActivity dialogsActivity = DialogsActivity.this;
                        if (!dialogsActivity.isForward) {
                            if (((BaseFragment) dialogsActivity).parentLayout != null) {
                                ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().openDrawer(false);
                                return;
                            }
                            return;
                        }
                    }
                    DialogsActivity.this.finishFragment();
                    return;
                }
                DialogsActivity.this.filterTabsView.setIsEditing(false);
                DialogsActivity.this.showDoneItem(false);
                return;
            }
            if (id == 1) {
                if (DialogsActivity.this.getParentActivity() == null) {
                    return;
                }
                SharedConfig.appLocked = true;
                SharedConfig.saveConfig();
                int[] iArr = new int[2];
                DialogsActivity.this.passcodeItem.getLocationInWindow(iArr);
                ((LaunchActivity) DialogsActivity.this.getParentActivity()).showPasscodeActivity(false, true, iArr[0] + (DialogsActivity.this.passcodeItem.getMeasuredWidth() / 2), iArr[1] + (DialogsActivity.this.passcodeItem.getMeasuredHeight() / 2), new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$30$_GeC6HQDoFivVAx7mFv8XUBTGDQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$0$DialogsActivity$30();
                    }
                }, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$30$4ypN2Fu32URLaQRRcflsoPFA3Z4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$1$DialogsActivity$30();
                    }
                });
                DialogsActivity.this.updatePasscodeButton();
                return;
            }
            if (id == 2) {
                DialogsActivity.this.presentFragment(new ProxyListActivity());
                return;
            }
            if (id >= 10 && id < 13) {
                if (DialogsActivity.this.getParentActivity() == null) {
                    return;
                }
                DialogsActivityDelegate dialogsActivityDelegate = DialogsActivity.this.delegate;
                LaunchActivity launchActivity = (LaunchActivity) DialogsActivity.this.getParentActivity();
                launchActivity.switchToAccount(id - 10, true);
                DialogsActivity dialogsActivity2 = new DialogsActivity(((BaseFragment) DialogsActivity.this).arguments);
                dialogsActivity2.setDelegate(dialogsActivityDelegate);
                launchActivity.presentFragment(dialogsActivity2, false, true);
                return;
            }
            if (id == 109) {
                DialogsActivity dialogsActivity3 = DialogsActivity.this;
                FiltersListBottomSheet filtersListBottomSheet = new FiltersListBottomSheet(dialogsActivity3, dialogsActivity3.selectedDialogs);
                filtersListBottomSheet.setDelegate(new FiltersListBottomSheet.FiltersListBottomSheetDelegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$30$IXdHeHMvus8bnMNqrdz0dJY8MMY
                    @Override // ir.eitaa.ui.Components.FiltersListBottomSheet.FiltersListBottomSheetDelegate
                    public final void didSelectFilter(MessagesController.DialogFilter dialogFilter) {
                        this.f$0.lambda$onItemClick$2$DialogsActivity$30(dialogFilter);
                    }
                });
                DialogsActivity.this.showDialog(filtersListBottomSheet);
                return;
            }
            if (id == 110) {
                MessagesController.DialogFilter dialogFilter = DialogsActivity.this.getMessagesController().dialogFilters.get(DialogsActivity.this.viewPages[0].selectedType);
                DialogsActivity dialogsActivity4 = DialogsActivity.this;
                ArrayList<Long> dialogsCount = FiltersListBottomSheet.getDialogsCount(dialogsActivity4, dialogFilter, dialogsActivity4.selectedDialogs, false, false);
                if ((dialogFilter != null ? dialogFilter.neverShow.size() : 0) + dialogsCount.size() > 100) {
                    DialogsActivity dialogsActivity5 = DialogsActivity.this;
                    dialogsActivity5.showDialog(AlertsCreator.createSimpleAlert(dialogsActivity5.getParentActivity(), LocaleController.getString("FilterAddToAlertFullTitle", R.string.FilterAddToAlertFullTitle), LocaleController.getString("FilterAddToAlertFullText", R.string.FilterAddToAlertFullText)).create());
                    return;
                }
                if (!dialogsCount.isEmpty()) {
                    dialogFilter.neverShow.addAll(dialogsCount);
                    for (int i = 0; i < dialogsCount.size(); i++) {
                        Long l = dialogsCount.get(i);
                        dialogFilter.alwaysShow.remove(l);
                        dialogFilter.pinnedDialogs.delete(l.longValue());
                    }
                    FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, false, false, true, false, false, DialogsActivity.this, null);
                }
                DialogsActivity.this.getUndoView().showWithAction(dialogsCount.size() == 1 ? dialogsCount.get(0).longValue() : 0L, 21, Integer.valueOf(dialogsCount.size()), dialogFilter, (Runnable) null, (Runnable) null);
                DialogsActivity.this.hideActionMode(false);
                return;
            }
            if (id == 111) {
                MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).setDialogFavorites(DialogsActivity.this.selectedDialogs, true);
                MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).sortDialogs(null);
                DialogsActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                DialogsActivity.this.hideActionMode(true);
                return;
            }
            if (id == 112) {
                MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).setDialogFavorites(DialogsActivity.this.selectedDialogs, false);
                MessagesController.getInstance(((BaseFragment) DialogsActivity.this).currentAccount).sortDialogs(null);
                DialogsActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                DialogsActivity.this.hideActionMode(true);
                return;
            }
            if (id == 100 || id == 101 || id == 102 || id == 103 || id == 104 || id == 105 || id == 106 || id == 107 || id == 108 || id == 1380) {
                DialogsActivity dialogsActivity6 = DialogsActivity.this;
                dialogsActivity6.performSelectedDialogsAction(dialogsActivity6.selectedDialogs, id, true);
            } else if (id == 1372) {
                DialogsActivity.this.presentFragment(new TrendsActivity());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$DialogsActivity$30() {
            DialogsActivity.this.passcodeItem.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$DialogsActivity$30() {
            DialogsActivity.this.passcodeItem.setAlpha(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$DialogsActivity$30(MessagesController.DialogFilter dialogFilter) {
            ArrayList<Long> arrayList;
            ArrayList<Long> arrayList2;
            long jLongValue;
            DialogsActivity dialogsActivity = DialogsActivity.this;
            ArrayList<Long> dialogsCount = FiltersListBottomSheet.getDialogsCount(dialogsActivity, dialogFilter, dialogsActivity.selectedDialogs, true, false);
            if ((dialogFilter != null ? dialogFilter.alwaysShow.size() : 0) + dialogsCount.size() <= 100) {
                if (dialogFilter != null) {
                    if (dialogsCount.isEmpty()) {
                        arrayList = dialogsCount;
                    } else {
                        for (int i = 0; i < dialogsCount.size(); i++) {
                            dialogFilter.neverShow.remove(dialogsCount.get(i));
                        }
                        dialogFilter.alwaysShow.addAll(dialogsCount);
                        arrayList = dialogsCount;
                        FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, false, false, true, true, false, DialogsActivity.this, null);
                    }
                    if (arrayList.size() == 1) {
                        arrayList2 = arrayList;
                        jLongValue = arrayList2.get(0).longValue();
                    } else {
                        arrayList2 = arrayList;
                        jLongValue = 0;
                    }
                    DialogsActivity.this.getUndoView().showWithAction(jLongValue, 20, Integer.valueOf(arrayList2.size()), dialogFilter, (Runnable) null, (Runnable) null);
                } else {
                    DialogsActivity.this.presentFragment(new FilterCreateActivity(null, dialogsCount));
                }
                DialogsActivity.this.hideActionMode(true);
                return;
            }
            DialogsActivity dialogsActivity2 = DialogsActivity.this;
            dialogsActivity2.showDialog(AlertsCreator.createSimpleAlert(dialogsActivity2.getParentActivity(), LocaleController.getString("FilterAddToAlertFullTitle", R.string.FilterAddToAlertFullTitle), LocaleController.getString("FilterRemoveFromAlertFullText", R.string.FilterRemoveFromAlertFullText)).create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        ViewPage[] viewPageArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            viewPageArr = this.viewPages;
            if (i2 >= viewPageArr.length) {
                break;
            }
            viewPageArr[i2].listView.stopScroll();
            i2++;
        }
        viewPageArr[z ? 1 : 0].listView.getAdapter();
        if (this.viewPages[z ? 1 : 0].selectedType == Integer.MAX_VALUE) {
            this.viewPages[z ? 1 : 0].dialogsType = 0;
            this.viewPages[z ? 1 : 0].listView.updatePullState();
        } else {
            MessagesController.DialogFilter dialogFilter = getMessagesController().dialogFilters.get(this.viewPages[z ? 1 : 0].selectedType);
            if (this.viewPages[!z ? 1 : 0].dialogsType == 7) {
                this.viewPages[z ? 1 : 0].dialogsType = 8;
            } else {
                this.viewPages[z ? 1 : 0].dialogsType = 7;
            }
            this.viewPages[z ? 1 : 0].listView.setScrollEnabled(true);
            getMessagesController().selectDialogFilter(dialogFilter, this.viewPages[z ? 1 : 0].dialogsType == 8 ? 1 : 0);
        }
        this.viewPages[z ? 1 : 0].dialogsAdapter.setDialogsType(this.viewPages[z ? 1 : 0].dialogsType);
        LinearLayoutManager linearLayoutManager = this.viewPages[z ? 1 : 0].layoutManager;
        if (this.viewPages[z ? 1 : 0].dialogsType == 0 && hasHiddenArchive()) {
            i = 1;
        }
        linearLayoutManager.scrollToPositionWithOffset(i, (int) this.actionBar.getTranslationY());
        checkListLoad(this.viewPages[z ? 1 : 0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showScrollbars(boolean show) {
        if (this.viewPages == null || this.scrollBarVisible == show) {
            return;
        }
        this.scrollBarVisible = show;
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                return;
            }
            if (show) {
                viewPageArr[i].listView.setScrollbarFadingEnabled(false);
            }
            this.viewPages[i].listView.setVerticalScrollBarEnabled(show);
            if (show) {
                this.viewPages[i].listView.setScrollbarFadingEnabled(true);
            }
            i++;
        }
    }

    private void updateFilterTabs(boolean force, boolean animated) {
        int iFindFirstVisibleItemPosition;
        boolean z;
        if (this.filterTabsView == null || this.inPreviewMode || this.searchIsShowed) {
            return;
        }
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            this.scrimPopupWindow = null;
        }
        ArrayList<MessagesController.DialogFilter> arrayList = getMessagesController().dialogFilters;
        MessagesController.getMainSettings(this.currentAccount);
        boolean z2 = true;
        if (!arrayList.isEmpty()) {
            if (force || this.filterTabsView.getVisibility() != 0) {
                boolean z3 = this.filterTabsView.getVisibility() != 0 ? false : animated;
                this.canShowFilterTabsView = true;
                updateFilterTabsVisibility(animated);
                int currentTabId = this.filterTabsView.getCurrentTabId();
                if (currentTabId != Integer.MAX_VALUE && currentTabId >= arrayList.size()) {
                    this.filterTabsView.resetTabId();
                }
                this.filterTabsView.removeTabs();
                if (LocaleController.isRTL) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        this.filterTabsView.addTab(size, arrayList.get(size).localId, arrayList.get(size).name);
                    }
                    this.filterTabsView.addTab(ConnectionsManager.DEFAULT_DATACENTER_ID, 0, LocaleController.getString("FilterAllChatsShort", R.string.FilterAllChatsShort));
                    this.filterTabsView.getListView().scrollToPosition(arrayList.size());
                } else {
                    this.filterTabsView.addTab(ConnectionsManager.DEFAULT_DATACENTER_ID, 0, LocaleController.getString("FilterAllChatsShort", R.string.FilterAllChatsShort));
                    int size2 = arrayList.size();
                    for (int i = 0; i < size2; i++) {
                        this.filterTabsView.addTab(i, arrayList.get(i).localId, arrayList.get(i).name);
                    }
                }
                int currentTabId2 = this.filterTabsView.getCurrentTabId();
                if (currentTabId2 < 0 || this.viewPages[0].selectedType == currentTabId2) {
                    z = false;
                } else {
                    this.viewPages[0].selectedType = currentTabId2;
                    z = true;
                }
                int i2 = 0;
                while (true) {
                    ViewPage[] viewPageArr = this.viewPages;
                    if (i2 >= viewPageArr.length) {
                        break;
                    }
                    if (viewPageArr[i2].selectedType != Integer.MAX_VALUE && this.viewPages[i2].selectedType >= arrayList.size()) {
                        this.viewPages[i2].selectedType = arrayList.size() - 1;
                    }
                    this.viewPages[i2].listView.setScrollingTouchSlop(1);
                    i2++;
                }
                this.filterTabsView.finishAddingTabs(z3);
                if (z) {
                    switchToCurrentSelectedMode(false);
                }
                ActionBarLayout actionBarLayout = this.parentLayout;
                if (actionBarLayout != null) {
                    DrawerLayoutContainer drawerLayoutContainer = actionBarLayout.getDrawerLayoutContainer();
                    if (currentTabId2 != this.filterTabsView.getFirstTabId() && SharedConfig.getChatSwipeAction(this.currentAccount) == 5) {
                        z2 = false;
                    }
                    drawerLayoutContainer.setAllowOpenDrawerBySwipe(z2);
                }
            }
        } else {
            if (this.filterTabsView.getVisibility() != 8) {
                this.filterTabsView.setIsEditing(false);
                showDoneItem(false);
                this.maybeStartTracking = false;
                if (this.startedTracking) {
                    this.startedTracking = false;
                    this.viewPages[0].setTranslationX(0.0f);
                    this.viewPages[1].setTranslationX(r10[0].getMeasuredWidth());
                }
                if (this.viewPages[0].selectedType != Integer.MAX_VALUE) {
                    this.viewPages[0].selectedType = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    this.viewPages[0].dialogsAdapter.setDialogsType(0);
                    this.viewPages[0].dialogsType = 0;
                    this.viewPages[0].dialogsAdapter.notifyDataSetChanged();
                }
                this.viewPages[1].setVisibility(8);
                this.viewPages[1].selectedType = ConnectionsManager.DEFAULT_DATACENTER_ID;
                this.viewPages[1].dialogsAdapter.setDialogsType(0);
                this.viewPages[1].dialogsType = 0;
                this.viewPages[1].dialogsAdapter.notifyDataSetChanged();
                this.canShowFilterTabsView = false;
                updateFilterTabsVisibility(animated);
                int i3 = 0;
                while (true) {
                    ViewPage[] viewPageArr2 = this.viewPages;
                    if (i3 >= viewPageArr2.length) {
                        break;
                    }
                    if (viewPageArr2[i3].dialogsType == 0 && this.viewPages[i3].archivePullViewState == 2 && hasHiddenArchive() && ((iFindFirstVisibleItemPosition = this.viewPages[i3].layoutManager.findFirstVisibleItemPosition()) == 0 || iFindFirstVisibleItemPosition == 1)) {
                        this.viewPages[i3].layoutManager.scrollToPositionWithOffset(1, 0);
                    }
                    this.viewPages[i3].listView.setScrollingTouchSlop(0);
                    this.viewPages[i3].listView.requestLayout();
                    this.viewPages[i3].requestLayout();
                    i3++;
                }
            }
            ActionBarLayout actionBarLayout2 = this.parentLayout;
            if (actionBarLayout2 != null) {
                actionBarLayout2.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(true);
            }
        }
        updateCounters(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void finishFragment() {
        super.finishFragment();
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0183  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$11$DialogsActivity(int i) {
        this.askAboutContacts = i != 0;
        MessagesController.getGlobalNotificationsSettings().edit().putBoolean("askAboutContacts", this.askAboutContacts).commit();
        askForPermissons(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$12$DialogsActivity(DialogInterface dialogInterface, int i) {
        Intent permissionManagerIntent = XiaomiUtilities.getPermissionManagerIntent();
        if (permissionManagerIntent != null) {
            try {
                try {
                    getParentActivity().startActivity(permissionManagerIntent);
                } catch (Exception unused) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
                    getParentActivity().startActivity(intent);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean presentFragment(BaseFragment fragment) {
        boolean zPresentFragment = super.presentFragment(fragment);
        if (zPresentFragment && this.viewPages != null) {
            int i = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i].dialogsAdapter.pause();
                i++;
            }
        }
        return zPresentFragment;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        ChatActivityEnterView chatActivityEnterView = this.commentView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.onResume();
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        Bulletin.removeDelegate(this);
        if (this.viewPages != null) {
            int i = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i].dialogsAdapter.pause();
                i++;
            }
        }
        SharedConfig.archiveHidden = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).getBoolean("archiveHidden", false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            return false;
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null && filterTabsView.isEditing()) {
            this.filterTabsView.setIsEditing(false);
            showDoneItem(false);
            return false;
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null && actionBar.isActionModeShowed()) {
            if (this.searchViewPager.getVisibility() == 0) {
                this.searchViewPager.hideActionMode();
                hideActionMode(true);
            } else {
                hideActionMode(true);
            }
            return false;
        }
        FilterTabsView filterTabsView2 = this.filterTabsView;
        if (filterTabsView2 != null && filterTabsView2.getVisibility() == 0 && !this.tabsAnimationInProgress && !this.filterTabsView.isAnimatingIndicator() && this.filterTabsView.getCurrentTabId() != Integer.MAX_VALUE && !this.startedTracking) {
            this.filterTabsView.selectFirstTab();
            return false;
        }
        ChatActivityEnterView chatActivityEnterView = this.commentView;
        if (chatActivityEnterView != null && chatActivityEnterView.isPopupShowing()) {
            this.commentView.hidePopup(true);
            return false;
        }
        return super.onBackPressed();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        if (this.closeSearchFieldOnHide) {
            ActionBar actionBar = this.actionBar;
            if (actionBar != null) {
                actionBar.closeSearchField();
            }
            TLObject tLObject = this.searchObject;
            if (tLObject != null) {
                this.searchViewPager.dialogsSearchAdapter.putRecentSearch(this.searchDialogId, tLObject);
                this.searchObject = null;
            }
            this.closeSearchFieldOnHide = false;
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null && filterTabsView.getVisibility() == 0 && this.filterTabsViewIsVisible) {
            int i = (int) (-this.actionBar.getTranslationY());
            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
            if (i != 0 && i != currentActionBarHeight) {
                if (i >= currentActionBarHeight / 2) {
                    if (this.viewPages[0].listView.canScrollVertically(1)) {
                        setScrollY(-currentActionBarHeight);
                    }
                } else {
                    setScrollY(0.0f);
                }
            }
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void setInPreviewMode(boolean value) {
        super.setInPreviewMode(value);
        if (value || this.avatarContainer == null) {
            return;
        }
        this.actionBar.setBackground(null);
        ((ViewGroup.MarginLayoutParams) this.actionBar.getLayoutParams()).topMargin = 0;
        this.actionBar.removeView(this.avatarContainer);
        this.avatarContainer = null;
        updateFilterTabs(false, false);
        this.floatingButton.setVisibility(0);
        ContentView contentView = (ContentView) this.fragmentView;
        FragmentContextView fragmentContextView = this.fragmentContextView;
        if (fragmentContextView != null) {
            contentView.addView(fragmentContextView);
        }
        FragmentContextView fragmentContextView2 = this.fragmentLocationContextView;
        if (fragmentContextView2 != null) {
            contentView.addView(fragmentContextView2);
        }
    }

    public boolean addOrRemoveSelectedDialog(long did, View cell) {
        if (this.selectedDialogs.contains(Long.valueOf(did))) {
            this.selectedDialogs.remove(Long.valueOf(did));
            if (cell instanceof DialogCell) {
                ((DialogCell) cell).setChecked(false, true);
            } else if (cell instanceof ProfileSearchCell) {
                ((ProfileSearchCell) cell).setChecked(false, true);
            }
            return false;
        }
        if (this.selectedDialogs.size() > 50) {
            return false;
        }
        this.selectedDialogs.add(Long.valueOf(did));
        if (cell instanceof DialogCell) {
            ((DialogCell) cell).setChecked(true, true);
        } else if (cell instanceof ProfileSearchCell) {
            ((ProfileSearchCell) cell).setChecked(true, true);
        }
        return true;
    }

    public void search(String query, boolean animated, Context context) {
        showSearch(true, animated, context);
        this.actionBar.openSearchField(query, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showSearch(final boolean r21, boolean r22, android.content.Context r23) {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.showSearch(boolean, boolean, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showSearch$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showSearch$14$DialogsActivity(ValueAnimator valueAnimator) {
        setSearchAnimationProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public boolean onlyDialogsAdapter() {
        getMessagesController().getTotalDialogsCount();
        return this.onlySelect;
    }

    private void updateFilterTabsVisibility(boolean animated) {
        if (this.isPaused || this.databaseMigrationHint != null) {
            animated = false;
        }
        if (this.searchIsShowed) {
            ValueAnimator valueAnimator = this.filtersTabAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            boolean z = this.canShowFilterTabsView;
            this.filterTabsViewIsVisible = z;
            this.filterTabsProgress = z ? 1.0f : 0.0f;
            return;
        }
        final boolean z2 = this.canShowFilterTabsView;
        if (this.filterTabsViewIsVisible != z2) {
            ValueAnimator valueAnimator2 = this.filtersTabAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            this.filterTabsViewIsVisible = z2;
            if (animated) {
                if (z2) {
                    if (this.filterTabsView.getVisibility() != 0) {
                        this.filterTabsView.setVisibility(0);
                    }
                    this.filtersTabAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.filterTabsMoveFrom = AndroidUtilities.dp(44.0f);
                } else {
                    this.filtersTabAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
                    this.filterTabsMoveFrom = Math.max(0.0f, AndroidUtilities.dp(44.0f) + this.actionBar.getTranslationY());
                }
                final float translationY = this.actionBar.getTranslationY();
                this.filtersTabAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.35
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        DialogsActivity.this.filtersTabAnimator = null;
                        DialogsActivity.this.scrollAdditionalOffset = AndroidUtilities.dp(44.0f) - DialogsActivity.this.filterTabsMoveFrom;
                        if (!z2) {
                            DialogsActivity.this.filterTabsView.setVisibility(8);
                        }
                        if (((BaseFragment) DialogsActivity.this).fragmentView != null) {
                            ((BaseFragment) DialogsActivity.this).fragmentView.requestLayout();
                        }
                        DialogsActivity.this.getNotificationCenter().onAnimationFinish(DialogsActivity.this.animationIndex);
                    }
                });
                this.filtersTabAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$XraewZWO-KW0cIOhnANi6eesz4I
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$updateFilterTabsVisibility$15$DialogsActivity(z2, translationY, valueAnimator3);
                    }
                });
                this.filtersTabAnimator.setDuration(220L);
                this.filtersTabAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.animationIndex = getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
                this.filtersTabAnimator.start();
                this.fragmentView.requestLayout();
                return;
            }
            this.filterTabsProgress = z2 ? 1.0f : 0.0f;
            this.filterTabsView.setVisibility(z2 ? 0 : 8);
            View view = this.fragmentView;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFilterTabsVisibility$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFilterTabsVisibility$15$DialogsActivity(boolean z, float f, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.filterTabsProgress = fFloatValue;
        if (!z) {
            setScrollY(f * fFloatValue);
        }
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchAnimationProgress(float progress) {
        this.searchAnimationProgress = progress;
        if (this.whiteActionBar) {
            this.actionBar.setItemsColor(Theme.getColor(this.folderId != 0 ? "actionBarDefaultArchivedIcon" : "actionBarDefaultIcon"), false);
            this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor("actionBarActionModeDefaultIcon"), Theme.getColor("windowBackgroundWhiteGrayText2"), this.searchAnimationProgress), true);
            this.actionBar.setItemsBackgroundColor(ColorUtils.blendARGB(Theme.getColor(this.folderId != 0 ? "actionBarDefaultArchivedSelector" : "actionBarDefaultSelector"), Theme.getColor("actionBarActionModeDefaultSelector"), this.searchAnimationProgress), false);
        }
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
        updateContextViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findAndUpdateCheckBox(long dialogId, boolean checked) {
        if (this.viewPages == null) {
            return;
        }
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                return;
            }
            int childCount = viewPageArr[i].listView.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 < childCount) {
                    View childAt = this.viewPages[i].listView.getChildAt(i2);
                    if (childAt instanceof DialogCell) {
                        DialogCell dialogCell = (DialogCell) childAt;
                        if (dialogCell.getDialogId() == dialogId) {
                            dialogCell.setChecked(checked, true);
                            break;
                        }
                    }
                    i2++;
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkListLoad(ir.eitaa.ui.DialogsActivity.ViewPage r15) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.checkListLoad(ir.eitaa.ui.DialogsActivity$ViewPage):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkListLoad$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkListLoad$16$DialogsActivity(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            getMessagesController().loadDialogs(this.folderId, -1, 100, z2);
        }
        if (z3) {
            getMessagesController().loadDialogs(1, -1, 100, z4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onItemClick(android.view.View r20, int r21, androidx.recyclerview.widget.RecyclerView.Adapter r22, float r23, float r24) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.onItemClick(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Adapter, float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(View view, int position, float x, float y, int dialogsType, RecyclerView.Adapter adapter) {
        TLRPC$Dialog tLRPC$Dialog;
        int i;
        String str;
        final long jMakeEncryptedDialogId;
        if (getParentActivity() == null) {
            return false;
        }
        if (!this.actionBar.isActionModeShowed() && !AndroidUtilities.isTablet() && !this.onlySelect && (view instanceof DialogCell)) {
            DialogCell dialogCell = (DialogCell) view;
            if (dialogCell.isPointInsideAvatar(x, y)) {
                return showChatPreview(dialogCell);
            }
        }
        DialogsSearchAdapter dialogsSearchAdapter = this.searchViewPager.dialogsSearchAdapter;
        if (adapter == dialogsSearchAdapter) {
            Object item = dialogsSearchAdapter.getItem(position);
            if (this.searchViewPager.dialogsSearchAdapter.isRecentSearchDisplayed()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("ClearSearchSingleAlertTitle", R.string.ClearSearchSingleAlertTitle));
                if (item instanceof TLRPC$Chat) {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) item;
                    builder.setMessage(LocaleController.formatString("ClearSearchSingleChatAlertText", R.string.ClearSearchSingleChatAlertText, tLRPC$Chat.title));
                    jMakeEncryptedDialogId = -tLRPC$Chat.id;
                } else if (item instanceof TLRPC$User) {
                    TLRPC$User tLRPC$User = (TLRPC$User) item;
                    if (tLRPC$User.id == getUserConfig().clientUserId) {
                        builder.setMessage(LocaleController.formatString("ClearSearchSingleChatAlertText", R.string.ClearSearchSingleChatAlertText, LocaleController.getString("SavedMessages", R.string.SavedMessages)));
                    } else {
                        builder.setMessage(LocaleController.formatString("ClearSearchSingleUserAlertText", R.string.ClearSearchSingleUserAlertText, ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name)));
                    }
                    jMakeEncryptedDialogId = tLRPC$User.id;
                } else {
                    if (!(item instanceof TLRPC$EncryptedChat)) {
                        return false;
                    }
                    TLRPC$User user = getMessagesController().getUser(Long.valueOf(((TLRPC$EncryptedChat) item).user_id));
                    builder.setMessage(LocaleController.formatString("ClearSearchSingleUserAlertText", R.string.ClearSearchSingleUserAlertText, ContactsController.formatName(user.first_name, user.last_name)));
                    jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(r11.id);
                }
                builder.setPositiveButton(LocaleController.getString("ClearSearchRemove", R.string.ClearSearchRemove).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$Y80TATKk0cHJz6HioR45WqBouZI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onItemLongClick$17$DialogsActivity(jMakeEncryptedDialogId, dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
                return true;
            }
        }
        DialogsSearchAdapter dialogsSearchAdapter2 = this.searchViewPager.dialogsSearchAdapter;
        if (adapter == dialogsSearchAdapter2) {
            long dialogId = (!(view instanceof ProfileSearchCell) || dialogsSearchAdapter2.isGlobalSearch(position)) ? 0L : ((ProfileSearchCell) view).getDialogId();
            if (dialogId == 0) {
                return false;
            }
            showOrUpdateActionMode(dialogId, view);
            return true;
        }
        ArrayList<TLRPC$Dialog> dialogsArray = getDialogsArray(this.currentAccount, dialogsType, this.folderId, this.dialogsListFrozen);
        int iFixPosition = ((DialogsAdapter) adapter).fixPosition(position);
        if (iFixPosition < 0 || iFixPosition >= dialogsArray.size() || (tLRPC$Dialog = dialogsArray.get(iFixPosition)) == null) {
            return false;
        }
        if (this.onlySelect || this.isForward) {
            int i2 = this.initialDialogsType;
            if ((i2 != 3 && i2 != 10 && !this.isForward) || !validateSlowModeDialog(tLRPC$Dialog.id)) {
                return false;
            }
            addOrRemoveSelectedDialog(tLRPC$Dialog.id, view);
            updateSelectedCount();
        } else {
            if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
                view.performHapticFeedback(0, 2);
                BottomSheet.Builder builder2 = new BottomSheet.Builder(getParentActivity());
                boolean z = getMessagesStorage().getArchiveUnreadCount() != 0;
                int[] iArr = new int[2];
                iArr[0] = z ? R.drawable.menu_read : 0;
                iArr[1] = SharedConfig.archiveHidden ? R.drawable.chats_pin : R.drawable.chats_unpin;
                CharSequence[] charSequenceArr = new CharSequence[2];
                charSequenceArr[0] = z ? LocaleController.getString("MarkAllAsRead", R.string.MarkAllAsRead) : null;
                if (SharedConfig.archiveHidden) {
                    i = R.string.PinInTheList;
                    str = "PinInTheList";
                } else {
                    i = R.string.HideAboveTheList;
                    str = "HideAboveTheList";
                }
                charSequenceArr[1] = LocaleController.getString(str, i);
                builder2.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$OKDDEqsluvY4mYfawO6x3C3Vbdw
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onItemLongClick$18$DialogsActivity(dialogInterface, i3);
                    }
                });
                showDialog(builder2.create());
                return false;
            }
            if (this.actionBar.isActionModeShowed() && isDialogPinned(tLRPC$Dialog)) {
                return false;
            }
            showOrUpdateActionMode(tLRPC$Dialog.id, view);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onItemLongClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onItemLongClick$17$DialogsActivity(long j, DialogInterface dialogInterface, int i) {
        this.searchViewPager.dialogsSearchAdapter.removeRecentSearch(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onItemLongClick$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onItemLongClick$18$DialogsActivity(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            getMessagesStorage().readAllDialogs(1);
            return;
        }
        if (i != 1 || this.viewPages == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i2 >= viewPageArr.length) {
                return;
            }
            if (viewPageArr[i2].dialogsType == 0 && this.viewPages[i2].getVisibility() == 0) {
                View childAt = this.viewPages[i2].listView.getChildAt(0);
                DialogCell dialogCell = null;
                if (childAt instanceof DialogCell) {
                    DialogCell dialogCell2 = (DialogCell) childAt;
                    if (dialogCell2.isFolderCell()) {
                        dialogCell = dialogCell2;
                    }
                }
                this.viewPages[i2].listView.toggleArchiveHidden(true, dialogCell);
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showChatPreview(DialogCell cell) {
        TLRPC$Chat chat;
        long dialogId = cell.getDialogId();
        Bundle bundle = new Bundle();
        int messageId = cell.getMessageId();
        if (DialogObject.isEncryptedDialog(dialogId)) {
            return false;
        }
        if (DialogObject.isUserDialog(dialogId)) {
            bundle.putLong("user_id", dialogId);
        } else {
            if (messageId != 0 && (chat = getMessagesController().getChat(Long.valueOf(-dialogId))) != null && chat.migrated_to != null) {
                bundle.putLong("migrated_to", dialogId);
                dialogId = -chat.migrated_to.channel_id;
            }
            bundle.putLong("chat_id", -dialogId);
        }
        if (messageId != 0) {
            bundle.putInt("message_id", messageId);
        }
        if (this.searchString != null) {
            if (!getMessagesController().checkCanOpenChat(bundle, this)) {
                return true;
            }
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
            prepareBlurBitmap();
            presentFragmentAsPreview(new ChatActivity(bundle));
            return true;
        }
        if (!getMessagesController().checkCanOpenChat(bundle, this)) {
            return true;
        }
        prepareBlurBitmap();
        presentFragmentAsPreview(new ChatActivity(bundle));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatingButtonOffset() {
        this.floatingButtonContainer.setTranslationY(this.floatingButtonTranslation - (Math.max(this.additionalFloatingTranslation, this.additionalFloatingTranslation2) * (1.0f - this.floatingButtonHideProgress)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasHiddenArchive() {
        return !this.onlySelect && this.initialDialogsType == 0 && this.folderId == 0 && getMessagesController().hasHiddenArchive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean waitingForDialogsAnimationEnd(ViewPage viewPage) {
        return (!viewPage.dialogsItemAnimator.isRunning() && this.dialogRemoveFinished == 0 && this.dialogInsertFinished == 0 && this.dialogChangeFinished == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDialogAnimationFinished() {
        this.dialogRemoveFinished = 0;
        this.dialogInsertFinished = 0;
        this.dialogChangeFinished = 0;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$CNmDP2aqe_z2tnivtEYBnRotxI8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDialogAnimationFinished$19$DialogsActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDialogAnimationFinished$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDialogAnimationFinished$19$DialogsActivity() {
        ArrayList<TLRPC$Dialog> arrayList;
        if (this.viewPages != null && this.folderId != 0 && ((arrayList = this.frozenDialogsList) == null || arrayList.isEmpty())) {
            int i = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i].listView.setEmptyView(null);
                this.viewPages[i].progressView.setVisibility(4);
                i++;
            }
            finishFragment();
        }
        setDialogsListFrozen(false);
        updateDialogIndices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollY(float value) {
        View view = this.scrimView;
        if (view != null) {
            view.getLocationInWindow(this.scrimViewLocation);
        }
        this.actionBar.setTranslationY(value);
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            filterTabsView.setTranslationY(value);
        }
        updateContextViewPosition();
        if (this.viewPages != null) {
            int i = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i].listView.setTopGlowOffset(this.viewPages[i].listView.getPaddingTop() + ((int) value));
                i++;
            }
        }
        this.fragmentView.invalidate();
    }

    private void prepareBlurBitmap() {
        if (this.blurredView == null) {
            return;
        }
        int measuredWidth = (int) (this.fragmentView.getMeasuredWidth() / 6.0f);
        int measuredHeight = (int) (this.fragmentView.getMeasuredHeight() / 6.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(0.16666667f, 0.16666667f);
        this.fragmentView.draw(canvas);
        Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max(7, Math.max(measuredWidth, measuredHeight) / 180));
        this.blurredView.setBackground(new BitmapDrawable(bitmapCreateBitmap));
        this.blurredView.setAlpha(0.0f);
        this.blurredView.setVisibility(0);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationProgress(boolean isOpen, float progress) {
        View view = this.blurredView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (isOpen) {
            this.blurredView.setAlpha(1.0f - progress);
        } else {
            this.blurredView.setAlpha(progress);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        View view;
        if (isOpen && (view = this.blurredView) != null && view.getVisibility() == 0) {
            this.blurredView.setVisibility(8);
            this.blurredView.setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetScroll() {
        if (this.actionBar.getTranslationY() == 0.0f) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, this.SCROLL_Y, 0.0f));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(180L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideActionMode(boolean animateCheck) {
        this.actionBar.hideActionMode();
        if (this.menuDrawable != null) {
            this.actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrOpenMenu", R.string.AccDescrOpenMenu));
        }
        this.selectedDialogs.clear();
        MenuDrawable menuDrawable = this.menuDrawable;
        if (menuDrawable != null) {
            menuDrawable.setRotation(0.0f, true);
        } else {
            BackDrawable backDrawable = this.backDrawable;
            if (backDrawable != null) {
                backDrawable.setRotation(0.0f, true);
            }
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            filterTabsView.animateColorsTo("actionBarTabLine", "actionBarTabActiveText", "actionBarTabUnactiveText", "actionBarTabSelector", "actionBarDefault");
        }
        ValueAnimator valueAnimator = this.actionBarColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progressToActionMode, 0.0f);
        this.actionBarColorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$0CSX08zaZgrNh9Lxm8JyiTVSFEQ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$hideActionMode$20$DialogsActivity(valueAnimator2);
            }
        });
        this.actionBarColorAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.actionBarColorAnimator.setDuration(200L);
        this.actionBarColorAnimator.start();
        this.allowMoving = false;
        if (!this.movingDialogFilters.isEmpty()) {
            int i = 0;
            for (int size = this.movingDialogFilters.size(); i < size; size = size) {
                MessagesController.DialogFilter dialogFilter = this.movingDialogFilters.get(i);
                FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, false, false, true, true, false, this, null);
                i++;
            }
            this.movingDialogFilters.clear();
        }
        if (this.movingWas) {
            getMessagesController().reorderPinnedDialogs(this.folderId, null, 0L);
            this.movingWas = false;
        }
        updateCounters(true);
        if (this.viewPages != null) {
            int i2 = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i2 >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i2].dialogsAdapter.onReorderStateChanged(false);
                i2++;
            }
        }
        updateVisibleRows(MessagesController.UPDATE_MASK_REORDER | MessagesController.UPDATE_MASK_CHECK | (animateCheck ? MessagesController.UPDATE_MASK_CHAT : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hideActionMode$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hideActionMode$20$DialogsActivity(ValueAnimator valueAnimator) {
        this.progressToActionMode = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < this.actionBar.getChildCount(); i++) {
            if (this.actionBar.getChildAt(i).getVisibility() == 0 && this.actionBar.getChildAt(i) != this.actionBar.getActionMode() && this.actionBar.getChildAt(i) != this.actionBar.getBackButton()) {
                this.actionBar.getChildAt(i).setAlpha(1.0f - this.progressToActionMode);
            }
        }
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
    }

    private int getPinnedCount() {
        ArrayList<TLRPC$Dialog> dialogs;
        if ((this.viewPages[0].dialogsType == 7 || this.viewPages[0].dialogsType == 8) && (!this.actionBar.isActionModeShowed() || this.actionBar.isActionModeShowed(null))) {
            dialogs = getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, this.dialogsListFrozen);
        } else {
            dialogs = getMessagesController().getDialogs(this.folderId);
        }
        int size = dialogs.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i2);
            if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                if (!isDialogPinned(tLRPC$Dialog)) {
                    if (!getMessagesController().isPromoDialog(tLRPC$Dialog.id, false)) {
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDialogPinned(TLRPC$Dialog dialog) {
        MessagesController.DialogFilter dialogFilter = null;
        if ((this.viewPages[0].dialogsType == 7 || this.viewPages[0].dialogsType == 8) && (!this.actionBar.isActionModeShowed() || this.actionBar.isActionModeShowed(null))) {
            dialogFilter = getMessagesController().selectedDialogFilter[this.viewPages[0].dialogsType == 8 ? (char) 1 : (char) 0];
        }
        if (dialogFilter != null) {
            return dialogFilter.pinnedDialogs.indexOfKey(dialog.id) >= 0;
        }
        return dialog.pinned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0106 A[PHI: r2 r4
      0x0106: PHI (r2v21 int) = (r2v14 int), (r2v14 int), (r2v23 int) binds: [B:51:0x00df, B:53:0x00e5, B:59:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x0106: PHI (r4v13 int) = (r4v7 int), (r4v7 int), (r4v16 int) binds: [B:51:0x00df, B:53:0x00e5, B:59:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performSelectedDialogsAction(final java.util.ArrayList<java.lang.Long> r39, final int r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 2015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.performSelectedDialogsAction(java.util.ArrayList, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$21$DialogsActivity(ArrayList arrayList) {
        getMessagesController().addDialogToFolder(arrayList, this.folderId == 0 ? 0 : 1, -1, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$22$DialogsActivity(DialogInterface dialogInterface, int i) {
        presentFragment(new FiltersSetupActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$24$DialogsActivity(ArrayList arrayList, final int i, DialogInterface dialogInterface, int i2) {
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList<Long> arrayList2 = new ArrayList<>(arrayList);
        getUndoView().showWithAction(arrayList2, i == 102 ? 27 : 26, (Object) null, (Object) null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$Boukm16VVJnLu6zEhBY_KCQ8dnU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSelectedDialogsAction$23$DialogsActivity(i, arrayList2);
            }
        }, (Runnable) null);
        hideActionMode(i == 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$23$DialogsActivity(int i, ArrayList arrayList) {
        if (i == 102) {
            getMessagesController().setDialogsInTransaction(true);
            performSelectedDialogsAction(arrayList, i, false);
            getMessagesController().setDialogsInTransaction(false);
            getMessagesController().checkIfFolderEmpty(this.folderId);
            if (this.folderId == 0 || getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, false).size() != 0) {
                return;
            }
            this.viewPages[0].listView.setEmptyView(null);
            this.viewPages[0].progressView.setVisibility(4);
            finishFragment();
            return;
        }
        performSelectedDialogsAction(arrayList, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$25$DialogsActivity(ArrayList arrayList, boolean z, boolean z2) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) arrayList.get(i)).longValue();
            if (z) {
                getMessagesController().reportSpam(jLongValue, getMessagesController().getUser(Long.valueOf(jLongValue)), null, null, false);
            }
            if (z2) {
                getMessagesController().deleteDialog(jLongValue, 0, true);
            }
            getMessagesController().blockPeer(jLongValue);
        }
        hideActionMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$26$DialogsActivity(DialogInterface dialogInterface, int i) {
        getMessagesController().hidePromoDialog();
        hideActionMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* renamed from: lambda$performSelectedDialogsAction$28, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSelectedDialogsAction$28$DialogsActivity(final int r18, final ir.eitaa.tgnet.TLRPC$Chat r19, final long r20, final boolean r22, final boolean r23) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.lambda$performSelectedDialogsAction$28$DialogsActivity(int, ir.eitaa.tgnet.TLRPC$Chat, long, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSelectedDialogsAction$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSelectedDialogsAction$29$DialogsActivity(DialogInterface dialogInterface) {
        hideActionMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performDeleteOrClearDialogAction, reason: merged with bridge method [inline-methods] */
    public void lambda$performSelectedDialogsAction$27$DialogsActivity(int action, long selectedDialog, TLRPC$Chat chat, boolean isBot, boolean revoke) {
        if (action == 103) {
            getMessagesController().deleteDialog(selectedDialog, 1, revoke);
            return;
        }
        if (chat != null) {
            if (ChatObject.isNotInChat(chat)) {
                getMessagesController().deleteDialog(selectedDialog, 0, revoke);
            } else {
                getMessagesController().deleteParticipantFromChat((int) (-selectedDialog), getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId())), null, null, revoke, false);
            }
        } else {
            getMessagesController().deleteDialog(selectedDialog, 0, revoke);
            if (isBot) {
                getMessagesController().blockPeer((int) selectedDialog);
            }
        }
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, Long.valueOf(selectedDialog));
        }
        getMessagesController().checkIfFolderEmpty(this.folderId);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pinDialog(long r16, boolean r18, ir.eitaa.messenger.MessagesController.DialogFilter r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.pinDialog(long, boolean, ir.eitaa.messenger.MessagesController$DialogFilter, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$pinDialog$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$pinDialog$30$DialogsActivity() {
        setDialogsListFrozen(false);
    }

    private void lockDialog(TLRPC$Dialog dialog) {
        getMessagesController().updateDialogLockState(dialog, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToTop() {
        int iFindFirstVisibleItemPosition = this.viewPages[0].layoutManager.findFirstVisibleItemPosition() * AndroidUtilities.dp(SharedConfig.useThreeLinesLayout ? 78.0f : 72.0f);
        int i = (this.viewPages[0].dialogsType == 0 && hasHiddenArchive()) ? 1 : 0;
        this.viewPages[0].listView.getItemAnimator();
        if (iFindFirstVisibleItemPosition >= this.viewPages[0].listView.getMeasuredHeight() * 1.2f) {
            this.viewPages[0].scrollHelper.setScrollDirection(1);
            this.viewPages[0].scrollHelper.scrollToPosition(i, 0, false, true);
            resetScroll();
            return;
        }
        this.viewPages[0].listView.smoothScrollToPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bd A[PHI: r8 r10
      0x01bd: PHI (r8v3 int) = (r8v2 int), (r8v2 int), (r8v2 int), (r8v5 int) binds: [B:87:0x01b5, B:88:0x01b7, B:90:0x01bb, B:63:0x0137] A[DONT_GENERATE, DONT_INLINE]
      0x01bd: PHI (r10v4 int) = (r10v2 int), (r10v2 int), (r10v2 int), (r10v6 int) binds: [B:87:0x01b5, B:88:0x01b7, B:90:0x01bb, B:63:0x0137] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateCounters(boolean r19) {
        /*
            Method dump skipped, instructions count: 1047
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.updateCounters(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateSlowModeDialog(long dialogId) {
        TLRPC$Chat chat;
        ChatActivityEnterView chatActivityEnterView;
        if ((this.messagesCount <= 1 && ((chatActivityEnterView = this.commentView) == null || chatActivityEnterView.getVisibility() != 0 || TextUtils.isEmpty(this.commentView.getFieldText()))) || !DialogObject.isChatDialog(dialogId) || (chat = getMessagesController().getChat(Long.valueOf(-dialogId))) == null || ChatObject.hasAdminRights(chat) || !chat.slowmode_enabled) {
            return true;
        }
        AlertsCreator.showSimpleAlert(this, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError));
        return false;
    }

    private void showOrUpdateActionMode(long dialogId, View cell) {
        addOrRemoveSelectedDialog(dialogId, cell);
        boolean z = true;
        if (this.actionBar.isActionModeShowed()) {
            if (this.selectedDialogs.isEmpty()) {
                hideActionMode(true);
                return;
            }
        } else {
            if (this.searchIsShowed) {
                createActionMode("search_dialogs_action_mode");
                if (this.actionBar.getBackButton().getDrawable() instanceof MenuDrawable) {
                    this.actionBar.setBackButtonDrawable(new BackDrawable(false));
                }
            } else {
                createActionMode(null);
            }
            AndroidUtilities.hideKeyboard(this.fragmentView.findFocus());
            this.actionBar.setActionModeOverrideColor(Theme.getColor("windowBackgroundWhite"));
            this.actionBar.showActionMode();
            resetScroll();
            if (this.menuDrawable != null) {
                this.actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
            }
            if (getPinnedCount() > 1) {
                if (this.viewPages != null) {
                    int i = 0;
                    while (true) {
                        ViewPage[] viewPageArr = this.viewPages;
                        if (i >= viewPageArr.length) {
                            break;
                        }
                        viewPageArr[i].dialogsAdapter.onReorderStateChanged(true);
                        i++;
                    }
                }
                updateVisibleRows(MessagesController.UPDATE_MASK_REORDER);
            }
            if (!this.searchIsShowed) {
                AnimatorSet animatorSet = new AnimatorSet();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.actionModeViews.size(); i2++) {
                    View view = this.actionModeViews.get(i2);
                    view.setPivotY(ActionBar.getCurrentActionBarHeight() / 2);
                    AndroidUtilities.clearDrawableAnimation(view);
                    arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.1f, 1.0f));
                }
                animatorSet.playTogether(arrayList);
                animatorSet.setDuration(200L);
                animatorSet.start();
            }
            ValueAnimator valueAnimator = this.actionBarColorAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progressToActionMode, 1.0f);
            this.actionBarColorAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$eZPlZxbx-pYyALcQoZcbyYtfpOo
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$showOrUpdateActionMode$31$DialogsActivity(valueAnimator2);
                }
            });
            this.actionBarColorAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.actionBarColorAnimator.setDuration(200L);
            this.actionBarColorAnimator.start();
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView != null) {
                filterTabsView.animateColorsTo("profile_tabSelectedLine", "profile_tabSelectedText", "profile_tabText", "profile_tabSelector", "actionBarActionModeDefault");
            }
            MenuDrawable menuDrawable = this.menuDrawable;
            if (menuDrawable != null) {
                menuDrawable.setRotateToBack(false);
                this.menuDrawable.setRotation(1.0f, true);
            } else {
                BackDrawable backDrawable = this.backDrawable;
                if (backDrawable != null) {
                    backDrawable.setRotation(1.0f, true);
                }
            }
            z = false;
        }
        updateCounters(false);
        this.selectedDialogsCountTextView.setNumber(this.selectedDialogs.size(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showOrUpdateActionMode$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showOrUpdateActionMode$31$DialogsActivity(ValueAnimator valueAnimator) {
        this.progressToActionMode = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < this.actionBar.getChildCount(); i++) {
            if (this.actionBar.getChildAt(i).getVisibility() == 0 && this.actionBar.getChildAt(i) != this.actionBar.getActionMode() && this.actionBar.getChildAt(i) != this.actionBar.getBackButton()) {
                this.actionBar.getChildAt(i).setAlpha(1.0f - this.progressToActionMode);
            }
        }
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSearch() {
        if (AndroidUtilities.isTablet()) {
            ActionBar actionBar = this.actionBar;
            if (actionBar != null) {
                actionBar.closeSearchField();
            }
            TLObject tLObject = this.searchObject;
            if (tLObject != null) {
                this.searchViewPager.dialogsSearchAdapter.putRecentSearch(this.searchDialogId, tLObject);
                this.searchObject = null;
                return;
            }
            return;
        }
        this.closeSearchFieldOnHide = true;
    }

    protected RecyclerListView getListView() {
        return this.viewPages[0].listView;
    }

    protected RecyclerListView getSearchListView() {
        return this.searchViewPager.searchListView;
    }

    public UndoView getUndoView() {
        if (this.undoView[0].getVisibility() == 0) {
            UndoView[] undoViewArr = this.undoView;
            UndoView undoView = undoViewArr[0];
            undoViewArr[0] = undoViewArr[1];
            undoViewArr[1] = undoView;
            undoView.hide(true, 2);
            ContentView contentView = (ContentView) this.fragmentView;
            contentView.removeView(this.undoView[0]);
            contentView.addView(this.undoView[0]);
        }
        return this.undoView[0];
    }

    private void updateProxyButton(boolean animated) {
        if (this.proxyDrawable != null) {
            ActionBarMenuItem actionBarMenuItem = this.doneItem;
            if (actionBarMenuItem == null || actionBarMenuItem.getVisibility() != 0) {
                ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).getString("proxy_ip", "");
                this.proxyItemVisible = false;
                this.proxyItem.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneItem(final boolean show) {
        if (this.doneItem == null) {
            return;
        }
        AnimatorSet animatorSet = this.doneItemAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.doneItemAnimator = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.doneItemAnimator = animatorSet2;
        animatorSet2.setDuration(180L);
        if (show) {
            this.doneItem.setVisibility(0);
        } else {
            this.doneItem.setSelected(false);
            Drawable background = this.doneItem.getBackground();
            if (background != null) {
                background.setState(StateSet.NOTHING);
                background.jumpToCurrentState();
            }
            ActionBarMenuItem actionBarMenuItem = this.searchItem;
            if (actionBarMenuItem != null) {
                actionBarMenuItem.setVisibility(0);
            }
            ActionBarMenuItem actionBarMenuItem2 = this.proxyItem;
            if (actionBarMenuItem2 != null && this.proxyItemVisible) {
                actionBarMenuItem2.setVisibility(0);
            }
            ActionBarMenuItem actionBarMenuItem3 = this.passcodeItem;
            if (actionBarMenuItem3 != null && this.passcodeItemVisible) {
                actionBarMenuItem3.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        ActionBarMenuItem actionBarMenuItem4 = this.doneItem;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem4, (Property<ActionBarMenuItem, Float>) property, fArr));
        if (this.proxyItemVisible) {
            ActionBarMenuItem actionBarMenuItem5 = this.proxyItem;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 0.0f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem5, (Property<ActionBarMenuItem, Float>) property2, fArr2));
        }
        if (this.passcodeItemVisible) {
            ActionBarMenuItem actionBarMenuItem6 = this.passcodeItem;
            Property property3 = View.ALPHA;
            float[] fArr3 = new float[1];
            fArr3[0] = show ? 0.0f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem6, (Property<ActionBarMenuItem, Float>) property3, fArr3));
        }
        ActionBarMenuItem actionBarMenuItem7 = this.searchItem;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = show ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem7, (Property<ActionBarMenuItem, Float>) property4, fArr4));
        this.doneItemAnimator.playTogether(arrayList);
        this.doneItemAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.36
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                DialogsActivity.this.doneItemAnimator = null;
                if (show) {
                    if (DialogsActivity.this.searchItem != null) {
                        DialogsActivity.this.searchItem.setVisibility(4);
                    }
                    if (DialogsActivity.this.proxyItem != null && DialogsActivity.this.proxyItemVisible) {
                        DialogsActivity.this.proxyItem.setVisibility(4);
                    }
                    if (DialogsActivity.this.passcodeItem == null || !DialogsActivity.this.passcodeItemVisible) {
                        return;
                    }
                    DialogsActivity.this.passcodeItem.setVisibility(4);
                    return;
                }
                if (DialogsActivity.this.doneItem != null) {
                    DialogsActivity.this.doneItem.setVisibility(8);
                }
            }
        });
        this.doneItemAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedCount() {
        if (this.commentView != null) {
            if (this.selectedDialogs.isEmpty()) {
                if (this.initialDialogsType == 3 && this.selectAlertString == null) {
                    this.actionBar.setTitle(LocaleController.getString("ForwardTo", R.string.ForwardTo));
                } else {
                    this.actionBar.setTitle(LocaleController.getString("SelectChat", R.string.SelectChat));
                }
                if (this.commentView.getTag() != null) {
                    this.commentView.hidePopup(false);
                    this.commentView.closeKeyboard();
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.commentView, (Property<ChatActivityEnterView, Float>) View.TRANSLATION_Y, 0.0f, r8.getMeasuredHeight()));
                    animatorSet.setDuration(180L);
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.37
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            DialogsActivity.this.commentView.setVisibility(8);
                        }
                    });
                    animatorSet.start();
                    this.commentView.setTag(null);
                    this.fragmentView.requestLayout();
                    return;
                }
                return;
            }
            if (this.commentView.getTag() == null) {
                this.commentView.setFieldText("");
                this.commentView.setVisibility(0);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.commentView, (Property<ChatActivityEnterView, Float>) View.TRANSLATION_Y, r8.getMeasuredHeight(), 0.0f));
                animatorSet2.setDuration(180L);
                animatorSet2.setInterpolator(new DecelerateInterpolator());
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.38
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        DialogsActivity.this.commentView.setTag(2);
                        DialogsActivity.this.commentView.requestLayout();
                    }
                });
                animatorSet2.start();
                this.commentView.setTag(1);
            }
            this.actionBar.setTitle(LocaleController.formatPluralString("Recipient", this.selectedDialogs.size()));
            return;
        }
        if (this.initialDialogsType == 10) {
            hideFloatingButton(this.selectedDialogs.isEmpty());
        }
    }

    @TargetApi(23)
    private void askForPermissons(boolean alert) {
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (getUserConfig().syncContacts && this.askAboutContacts && parentActivity.checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
            if (alert) {
                AlertDialog alertDialogCreate = AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$QjBk3GtX9BtMudbR4Www4zX5zz0
                    @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                    public final void run(int i) {
                        this.f$0.lambda$askForPermissons$32$DialogsActivity(i);
                    }
                }).create();
                this.permissionDialog = alertDialogCreate;
                showDialog(alertDialogCreate);
                return;
            } else {
                arrayList.add("android.permission.READ_CONTACTS");
                arrayList.add("android.permission.WRITE_CONTACTS");
                arrayList.add("android.permission.GET_ACCOUNTS");
            }
        }
        if ((Build.VERSION.SDK_INT <= 28 || BuildVars.NO_SCOPED_STORAGE) && parentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.isEmpty()) {
            if (this.askingForPermissions) {
                this.askingForPermissions = false;
                showFiltersHint();
                return;
            }
            return;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        try {
            if (strArr.length > 0) {
                parentActivity.requestPermissions(strArr, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$askForPermissons$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$askForPermissons$32$DialogsActivity(int i) {
        this.askAboutContacts = i != 0;
        MessagesController.getGlobalNotificationsSettings().edit().putBoolean("askAboutContacts", this.askAboutContacts).commit();
        askForPermissons(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        super.onDialogDismiss(dialog);
        AlertDialog alertDialog = this.permissionDialog;
        if (alertDialog == null || dialog != alertDialog || getParentActivity() == null) {
            return;
        }
        askForPermissons(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        FrameLayout frameLayout;
        super.onConfigurationChanged(newConfig);
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        if (this.onlySelect || (frameLayout = this.floatingButtonContainer) == null) {
            return;
        }
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.eitaa.ui.DialogsActivity.39
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                DialogsActivity dialogsActivity = DialogsActivity.this;
                dialogsActivity.floatingButtonTranslation = dialogsActivity.floatingHidden ? AndroidUtilities.dp(100.0f) : 0.0f;
                DialogsActivity.this.updateFloatingButtonOffset();
                DialogsActivity.this.floatingButtonContainer.setClickable(!DialogsActivity.this.floatingHidden);
                if (DialogsActivity.this.floatingButtonContainer != null) {
                    DialogsActivity.this.floatingButtonContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults.length > i) {
                    String str = permissions[i];
                    str.hashCode();
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (grantResults[i] == 0) {
                            ImageLoader.getInstance().checkMediaPaths();
                        }
                    } else if (str.equals("android.permission.READ_CONTACTS")) {
                        if (grantResults[i] == 0) {
                            getContactsController().forceImportContacts();
                        } else {
                            SharedPreferences.Editor editorEdit = MessagesController.getGlobalNotificationsSettings().edit();
                            this.askAboutContacts = false;
                            editorEdit.putBoolean("askAboutContacts", false).commit();
                        }
                    }
                }
            }
            if (this.askingForPermissions) {
                this.askingForPermissions = false;
                showFiltersHint();
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        SearchViewPager searchViewPager;
        DialogsSearchAdapter dialogsSearchAdapter;
        DialogsSearchAdapter dialogsSearchAdapter2;
        int i;
        int i2;
        int i3 = 0;
        if (id == NotificationCenter.dialogsNeedReload) {
            if (this.viewPages == null || this.dialogsListFrozen) {
                return;
            }
            AccountInstance.getInstance(this.currentAccount).getMessagesController().getDialogs(this.folderId);
            int i4 = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i4 >= viewPageArr.length) {
                    break;
                }
                if (viewPageArr[i4].getVisibility() == 0) {
                    int currentCount = this.viewPages[i4].dialogsAdapter.getCurrentCount();
                    if (this.viewPages[i4].dialogsType == 0 && hasHiddenArchive() && this.viewPages[i4].listView.getChildCount() == 0) {
                        ((LinearLayoutManager) this.viewPages[i4].listView.getLayoutManager()).scrollToPositionWithOffset(1, 0);
                    }
                    if (this.viewPages[i4].dialogsAdapter.isDataSetChanged() || args.length > 0) {
                        this.viewPages[i4].dialogsAdapter.notifyDataSetChanged();
                        if (this.viewPages[i4].dialogsAdapter.getItemCount() > currentCount && (i = this.initialDialogsType) != 11 && i != 12 && i != 13) {
                            this.viewPages[i4].recyclerItemsEnterAnimator.showItemsAnimated(currentCount);
                        }
                    } else {
                        updateVisibleRows(MessagesController.UPDATE_MASK_NEW_MESSAGE);
                        if (this.viewPages[i4].dialogsAdapter.getItemCount() > currentCount && (i2 = this.initialDialogsType) != 11 && i2 != 12 && i2 != 13) {
                            this.viewPages[i4].recyclerItemsEnterAnimator.showItemsAnimated(currentCount);
                        }
                    }
                    try {
                        this.viewPages[i4].listView.setEmptyView(this.folderId == 0 ? this.viewPages[i4].progressView : null);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    checkListLoad(this.viewPages[i4]);
                }
                i4++;
            }
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView == null || filterTabsView.getVisibility() != 0) {
                return;
            }
            this.filterTabsView.checkTabsCounter();
            return;
        }
        if (id == NotificationCenter.dialogsUnreadCounterChanged) {
            FilterTabsView filterTabsView2 = this.filterTabsView;
            if (filterTabsView2 == null || filterTabsView2.getVisibility() != 0) {
                return;
            }
            this.filterTabsView.notifyTabCounterChanged(ConnectionsManager.DEFAULT_DATACENTER_ID);
            return;
        }
        if (id == NotificationCenter.emojiLoaded) {
            updateVisibleRows(0);
            FilterTabsView filterTabsView3 = this.filterTabsView;
            if (filterTabsView3 != null) {
                filterTabsView3.getTabsContainer().invalidateViews();
                return;
            }
            return;
        }
        if (id == NotificationCenter.closeSearchByActiveAction) {
            ActionBar actionBar = this.actionBar;
            if (actionBar != null) {
                actionBar.closeSearchField();
                return;
            }
            return;
        }
        if (id == NotificationCenter.proxySettingsChanged) {
            updateProxyButton(false);
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            Integer num = (Integer) args[0];
            updateVisibleRows(num.intValue());
            FilterTabsView filterTabsView4 = this.filterTabsView;
            if (filterTabsView4 != null && filterTabsView4.getVisibility() == 0 && (num.intValue() & MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE) != 0) {
                this.filterTabsView.checkTabsCounter();
            }
            if (this.viewPages != null) {
                while (i3 < this.viewPages.length) {
                    if ((num.intValue() & MessagesController.UPDATE_MASK_STATUS) != 0) {
                        this.viewPages[i3].dialogsAdapter.sortOnlineContacts(true);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.appDidLogout) {
            dialogsLoaded[this.currentAccount] = false;
            return;
        }
        if (id == NotificationCenter.encryptedChatUpdated) {
            updateVisibleRows(0);
            return;
        }
        if (id == NotificationCenter.contactsDidLoad) {
            if (this.viewPages == null || this.dialogsListFrozen) {
                return;
            }
            int i5 = 0;
            boolean z = false;
            while (true) {
                ViewPage[] viewPageArr2 = this.viewPages;
                if (i5 >= viewPageArr2.length) {
                    break;
                }
                if (!viewPageArr2[i5].isDefaultDialogType() || getMessagesController().getDialogs(this.folderId).size() > 10) {
                    z = true;
                } else {
                    this.viewPages[i5].dialogsAdapter.notifyDataSetChanged();
                }
                i5++;
            }
            if (z) {
                updateVisibleRows(0);
                return;
            }
            return;
        }
        if (id == NotificationCenter.openedChatChanged) {
            if (this.viewPages == null) {
                return;
            }
            int i6 = 0;
            while (true) {
                ViewPage[] viewPageArr3 = this.viewPages;
                if (i6 < viewPageArr3.length) {
                    if (viewPageArr3[i6].isDefaultDialogType() && AndroidUtilities.isTablet()) {
                        boolean zBooleanValue = ((Boolean) args[1]).booleanValue();
                        long jLongValue = ((Long) args[0]).longValue();
                        if (!zBooleanValue) {
                            this.openedDialogId = jLongValue;
                        } else if (jLongValue == this.openedDialogId) {
                            this.openedDialogId = 0L;
                        }
                        this.viewPages[i6].dialogsAdapter.setOpenedDialogId(this.openedDialogId);
                    }
                    i6++;
                } else {
                    updateVisibleRows(MessagesController.UPDATE_MASK_SELECT_DIALOG);
                    return;
                }
            }
        } else {
            if (id == NotificationCenter.notificationsSettingsUpdated) {
                updateVisibleRows(0);
                return;
            }
            if (id == NotificationCenter.messageReceivedByAck || id == NotificationCenter.messageReceivedByServer || id == NotificationCenter.messageSendError) {
                updateVisibleRows(MessagesController.UPDATE_MASK_SEND_STATE);
                return;
            }
            if (id == NotificationCenter.didSetPasscode) {
                updatePasscodeButton();
                return;
            }
            if (id == NotificationCenter.needReloadRecentDialogsSearch) {
                SearchViewPager searchViewPager2 = this.searchViewPager;
                if (searchViewPager2 == null || (dialogsSearchAdapter2 = searchViewPager2.dialogsSearchAdapter) == null) {
                    return;
                }
                dialogsSearchAdapter2.loadRecentSearch();
                return;
            }
            if (id == NotificationCenter.replyMessagesDidLoad) {
                updateVisibleRows(MessagesController.UPDATE_MASK_MESSAGE_TEXT);
                return;
            }
            if (id == NotificationCenter.reloadHints) {
                SearchViewPager searchViewPager3 = this.searchViewPager;
                if (searchViewPager3 == null || (dialogsSearchAdapter = searchViewPager3.dialogsSearchAdapter) == null) {
                    return;
                }
                dialogsSearchAdapter.notifyDataSetChanged();
                return;
            }
            if (id == NotificationCenter.liveChatsNeedReload) {
                ActionBarMenuItem actionBarMenuItem = this.whatshotItem;
                if (actionBarMenuItem != null) {
                    actionBarMenuItem.setHasLiveIndicator(MessagesController.getInstance(this.currentAccount).livechats.size() != 0);
                }
                ActionBarMenuItem actionBarMenuItem2 = this.exploreItem;
                if (actionBarMenuItem2 != null) {
                    actionBarMenuItem2.setHasLiveIndicator(MessagesController.getInstance(this.currentAccount).livechats.size() != 0);
                    return;
                }
                return;
            }
            if (id == NotificationCenter.didUpdateConnectionState) {
                int connectionState = AccountInstance.getInstance(account).getConnectionsManager().getConnectionState();
                if (this.currentConnectionState != connectionState) {
                    this.currentConnectionState = connectionState;
                    updateProxyButton(true);
                    return;
                }
                return;
            }
            if (id == NotificationCenter.needDeleteDialog) {
                if (this.fragmentView == null || this.isPaused) {
                    return;
                }
                final long jLongValue2 = ((Long) args[0]).longValue();
                final TLRPC$User tLRPC$User = (TLRPC$User) args[1];
                final TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) args[2];
                final boolean zBooleanValue2 = ((Boolean) args[3]).booleanValue();
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$WmCUr0eqCW69zAeOJBjTBmZgGNU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$33$DialogsActivity(tLRPC$Chat, jLongValue2, zBooleanValue2, tLRPC$User);
                    }
                };
                if (this.undoView[0] != null) {
                    getUndoView().showWithAction(jLongValue2, 1, runnable);
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            if (id == NotificationCenter.folderBecomeEmpty) {
                int iIntValue = ((Integer) args[0]).intValue();
                int i7 = this.folderId;
                if (i7 != iIntValue || i7 == 0) {
                    return;
                }
                finishFragment();
                return;
            }
            if (id == NotificationCenter.dialogFiltersUpdated) {
                updateFilterTabs(true, true);
                return;
            }
            if (id == NotificationCenter.filterSettingsUpdated) {
                showFiltersHint();
                return;
            }
            if (id == NotificationCenter.newSuggestionsAvailable) {
                showNextSupportedSuggestion();
                return;
            }
            if (id == NotificationCenter.messagesDeleted) {
                if (!this.searchIsShowed || this.searchViewPager == null) {
                    return;
                }
                this.searchViewPager.messagesDeleted(((Long) args[1]).longValue(), (ArrayList) args[0]);
                return;
            }
            if (id == NotificationCenter.didClearDatabase) {
                if (this.viewPages == null) {
                    return;
                }
                while (true) {
                    ViewPage[] viewPageArr4 = this.viewPages;
                    if (i3 >= viewPageArr4.length) {
                        return;
                    }
                    viewPageArr4[i3].dialogsAdapter.didDatabaseCleared();
                    i3++;
                }
            } else {
                if (id == NotificationCenter.appUpdateAvailable) {
                    updateMenuButton(true);
                    return;
                }
                if (id == NotificationCenter.fileLoaded || id == NotificationCenter.fileLoadFailed || id == NotificationCenter.fileLoadProgressChanged) {
                    String str = (String) args[0];
                    if (SharedConfig.isAppUpdateAvailable() && FileLoader.getAttachFileName(SharedConfig.pendingAppUpdate.document).equals(str)) {
                        updateMenuButton(true);
                        return;
                    }
                    return;
                }
                if (id == NotificationCenter.onDatabaseMigration) {
                    boolean zBooleanValue3 = ((Boolean) args[0]).booleanValue();
                    if (this.fragmentView != null) {
                        if (zBooleanValue3) {
                            if (this.databaseMigrationHint == null) {
                                DatabaseMigrationHint databaseMigrationHint = new DatabaseMigrationHint(this.fragmentView.getContext(), this.currentAccount);
                                this.databaseMigrationHint = databaseMigrationHint;
                                databaseMigrationHint.setAlpha(0.0f);
                                ((ContentView) this.fragmentView).addView(this.databaseMigrationHint);
                                this.databaseMigrationHint.animate().alpha(1.0f).setDuration(300L).setStartDelay(1000L).start();
                            }
                            this.databaseMigrationHint.setTag(1);
                            return;
                        }
                        View view = this.databaseMigrationHint;
                        if (view == null || view.getTag() == null) {
                            return;
                        }
                        final View view2 = this.databaseMigrationHint;
                        view2.animate().setListener(null).cancel();
                        view2.animate().setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.40
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (view2.getParent() != null) {
                                    ((ViewGroup) view2.getParent()).removeView(view2);
                                }
                                DialogsActivity.this.databaseMigrationHint = null;
                            }
                        }).alpha(0.0f).setStartDelay(0L).setDuration(150L).start();
                        this.databaseMigrationHint.setTag(null);
                        return;
                    }
                    return;
                }
                if (id == NotificationCenter.exploreStatusNeedReload) {
                    updateWhatshotButton();
                } else {
                    if (id != NotificationCenter.mxbStatusNeedReload || (searchViewPager = this.searchViewPager) == null) {
                        return;
                    }
                    searchViewPager.dialogsSearchAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$33$DialogsActivity(TLRPC$Chat tLRPC$Chat, long j, boolean z, TLRPC$User tLRPC$User) {
        if (tLRPC$Chat != null) {
            if (ChatObject.isNotInChat(tLRPC$Chat)) {
                getMessagesController().deleteDialog(j, 0, z);
            } else {
                getMessagesController().deleteParticipantFromChat(-j, getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId())), null, null, z, z);
            }
        } else {
            getMessagesController().deleteDialog(j, 0, z);
            if (tLRPC$User != null && tLRPC$User.bot) {
                getMessagesController().blockPeer(tLRPC$User.id);
            }
        }
        getMessagesController().checkIfFolderEmpty(this.folderId);
    }

    private void updateMenuButton(boolean animated) {
        int i;
        if (this.menuDrawable == null || this.updateLayout == null) {
            return;
        }
        float fFloatValue = 0.0f;
        if (SharedConfig.isAppUpdateAvailable()) {
            String attachFileName = FileLoader.getAttachFileName(SharedConfig.pendingAppUpdate.document);
            if (getFileLoader().isLoadingFile(attachFileName)) {
                i = MenuDrawable.TYPE_UDPATE_DOWNLOADING;
                Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                if (fileProgress != null) {
                    fFloatValue = fileProgress.floatValue();
                }
            } else {
                i = MenuDrawable.TYPE_UDPATE_AVAILABLE;
            }
        } else {
            i = MenuDrawable.TYPE_DEFAULT;
        }
        updateAppUpdateViews(animated);
        this.menuDrawable.setType(i, animated);
        this.menuDrawable.setUpdateDownloadProgress(fFloatValue, animated);
    }

    private void showNextSupportedSuggestion() {
        if (this.showingSuggestion != null) {
            return;
        }
        for (String str : getMessagesController().pendingSuggestions) {
            if (showSuggestion(str)) {
                this.showingSuggestion = str;
                return;
            }
        }
    }

    private void onSuggestionDismiss() {
        if (this.showingSuggestion == null) {
            return;
        }
        getMessagesController().removeSuggestion(0L, this.showingSuggestion);
        this.showingSuggestion = null;
        showNextSupportedSuggestion();
    }

    private boolean showSuggestion(String suggestion) {
        if (!"AUTOARCHIVE_POPULAR".equals(suggestion)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("HideNewChatsAlertTitle", R.string.HideNewChatsAlertTitle));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("HideNewChatsAlertText", R.string.HideNewChatsAlertText)));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("GoToSettings", R.string.GoToSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$MrxrZVWLxv1IH7N7tLiyq4IbGs8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showSuggestion$34$DialogsActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create(), new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$tqJv2hfNiyd69KDNnKn26eeIbeY
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showSuggestion$35$DialogsActivity(dialogInterface);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showSuggestion$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showSuggestion$34$DialogsActivity(DialogInterface dialogInterface, int i) {
        presentFragment(new PrivacySettingsActivity());
        AndroidUtilities.scrollToFragmentRow(this.parentLayout, "newChatsRow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showSuggestion$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showSuggestion$35$DialogsActivity(DialogInterface dialogInterface) {
        onSuggestionDismiss();
    }

    private void showFiltersHint() {
        if (this.askingForPermissions || !getMessagesController().dialogFiltersLoaded || !getMessagesController().showFiltersTooltip || this.filterTabsView == null || !getMessagesController().dialogFilters.isEmpty() || this.isPaused || !getUserConfig().filtersLoaded || this.inPreviewMode) {
            return;
        }
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (globalMainSettings.getBoolean("filterhint", false)) {
            return;
        }
        globalMainSettings.edit().putBoolean("filterhint", true).commit();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$ntvQHCAKQxhZZ1C3jnVeJ34siWI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showFiltersHint$37$DialogsActivity();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showFiltersHint$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showFiltersHint$36$DialogsActivity() {
        presentFragment(new FiltersSetupActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showFiltersHint$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showFiltersHint$37$DialogsActivity() {
        getUndoView().showWithAction(0L, 15, null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$2HsV0e54ff9bW4yAgi29LpEk278
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showFiltersHint$36$DialogsActivity();
            }
        });
    }

    private void setDialogsListFrozen(boolean frozen, boolean notify) {
        if (this.viewPages == null || this.dialogsListFrozen == frozen) {
            return;
        }
        if (frozen) {
            this.frozenDialogsList = new ArrayList<>(getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, false));
        } else {
            this.frozenDialogsList = null;
        }
        this.dialogsListFrozen = frozen;
        this.viewPages[0].dialogsAdapter.setDialogsListFrozen(frozen);
        if (frozen || !notify) {
            return;
        }
        this.viewPages[0].dialogsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialogsListFrozen(boolean frozen) {
        setDialogsListFrozen(frozen, true);
    }

    public ArrayList<TLRPC$Dialog> getDialogsArray(int currentAccount, int dialogsType, int folderId, boolean frozen) {
        ArrayList<TLRPC$Dialog> arrayList;
        if (frozen && (arrayList = this.frozenDialogsList) != null) {
            return arrayList;
        }
        MessagesController messagesController = AccountInstance.getInstance(currentAccount).getMessagesController();
        if (dialogsType == 0) {
            if (this.isForward) {
                return messagesController.getDialogsForward();
            }
            return messagesController.getDialogs(folderId);
        }
        if (dialogsType == 1 || dialogsType == 10 || dialogsType == 13) {
            return messagesController.dialogsServerOnly;
        }
        if (dialogsType == 2) {
            return messagesController.dialogsCanAddUsers;
        }
        if (dialogsType == 3) {
            return messagesController.dialogsForward;
        }
        if (dialogsType == 4 || dialogsType == 12) {
            return messagesController.dialogsUsersOnly;
        }
        if (dialogsType == 5) {
            return messagesController.dialogsChannelsOnly;
        }
        if (dialogsType == 6 || dialogsType == 11) {
            return messagesController.dialogsGroupsOnly;
        }
        if (dialogsType != 7 && dialogsType != 8) {
            if (dialogsType == 9) {
                return messagesController.dialogsForBlock;
            }
            return new ArrayList<>();
        }
        MessagesController.DialogFilter dialogFilter = messagesController.selectedDialogFilter[dialogsType == 7 ? (char) 0 : (char) 1];
        if (dialogFilter == null) {
            return messagesController.getDialogs(folderId);
        }
        return dialogFilter.dialogs;
    }

    public void setSideMenu(RecyclerView recyclerView) {
        this.sideMenu = recyclerView;
        recyclerView.setBackgroundColor(Theme.getColor("chats_menuBackground"));
        this.sideMenu.setGlowColor(Theme.getColor("chats_menuBackground"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWhatshotButton() {
        if (this.whatshotItem == null) {
            return;
        }
        if (!this.onlySelect && this.searchString == null && this.folderId == 0 && !this.isForward && !this.searching) {
            if (MessagesController.getInstance(this.currentAccount).exploreEnabled) {
                this.exploreItem.setVisibility(0);
                this.whatshotItem.setVisibility(8);
            } else {
                this.exploreItem.setVisibility(8);
                this.whatshotItem.setVisibility(0);
            }
            this.recommendItem.setVisibility(8);
            return;
        }
        this.exploreItem.setVisibility(8);
        this.whatshotItem.setVisibility(8);
        this.recommendItem.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePasscodeButton() {
        if (this.passcodeItem == null) {
            return;
        }
        if (SharedConfig.passcodeHash.length() != 0 && !this.searching) {
            ActionBarMenuItem actionBarMenuItem = this.doneItem;
            if (actionBarMenuItem == null || actionBarMenuItem.getVisibility() != 0) {
                this.passcodeItem.setVisibility(0);
            }
            this.passcodeItem.setIcon(this.passcodeDrawable);
            this.passcodeItemVisible = true;
            return;
        }
        this.passcodeItem.setVisibility(8);
        this.passcodeItemVisible = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean hide) {
        if (this.floatingHidden != hide) {
            if (hide && this.floatingForceVisible) {
                return;
            }
            this.floatingHidden = hide;
            AnimatorSet animatorSet = new AnimatorSet();
            float[] fArr = new float[2];
            fArr[0] = this.floatingButtonHideProgress;
            fArr[1] = this.floatingHidden ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$U2fUkh58b1vjG5DAsVpqYFIwsqs
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$hideFloatingButton$38$DialogsActivity(valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(this.floatingInterpolator);
            this.floatingButtonContainer.setClickable(!hide);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hideFloatingButton$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hideFloatingButton$38$DialogsActivity(ValueAnimator valueAnimator) {
        this.floatingButtonHideProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.floatingButtonTranslation = AndroidUtilities.dp(100.0f) * this.floatingButtonHideProgress;
        updateFloatingButtonOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDialogIndices() {
        int iIndexOf;
        if (this.viewPages == null) {
            return;
        }
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                return;
            }
            if (viewPageArr[i].getVisibility() == 0) {
                ArrayList<TLRPC$Dialog> dialogsArray = getDialogsArray(this.currentAccount, this.viewPages[i].dialogsType, this.folderId, false);
                int childCount = this.viewPages[i].listView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.viewPages[i].listView.getChildAt(i2);
                    if (childAt instanceof DialogCell) {
                        DialogCell dialogCell = (DialogCell) childAt;
                        TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(dialogCell.getDialogId());
                        if (tLRPC$Dialog != null && (iIndexOf = dialogsArray.indexOf(tLRPC$Dialog)) >= 0) {
                            dialogCell.setDialogIndex(iIndexOf);
                        }
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVisibleRows(int mask) {
        updateVisibleRows(mask, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateVisibleRows(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.updateVisibleRows(int, boolean):void");
    }

    public void setDelegate(DialogsActivityDelegate dialogsActivityDelegate) {
        this.delegate = dialogsActivityDelegate;
    }

    public void setSearchString(String string) {
        this.searchString = string;
    }

    public void setInitialSearchString(String initialSearchString) {
        this.initialSearchString = initialSearchString;
    }

    public boolean isMainDialogList() {
        return this.delegate == null && this.searchString == null;
    }

    public void setInitialSearchType(int type) {
        this.initialSearchType = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didSelectResult(final long dialogId, boolean useAlert, final boolean param) {
        final TLRPC$Chat tLRPC$Chat;
        String string;
        String stringSimple;
        String string2;
        final TLRPC$User tLRPC$User = null;
        if (this.addToGroupAlertString == null && this.checkCanWrite) {
            if (DialogObject.isChatDialog(dialogId)) {
                long j = -dialogId;
                TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(j));
                if (ChatObject.isChannel(chat) && !chat.megagroup && (this.cantSendToChannels || !ChatObject.isCanWriteToChannel(j, this.currentAccount) || this.hasPoll == 2)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                    builder.setTitle(LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle));
                    if (this.hasPoll == 2) {
                        builder.setMessage(LocaleController.getString("PublicPollCantForward", R.string.PublicPollCantForward));
                    } else {
                        builder.setMessage(LocaleController.getString("ChannelCantSendMessage", R.string.ChannelCantSendMessage));
                    }
                    builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                    showDialog(builder.create());
                    return;
                }
            } else if (DialogObject.isEncryptedDialog(dialogId) && (this.hasPoll != 0 || this.hasInvoice)) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                builder2.setTitle(LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle));
                if (this.hasPoll != 0) {
                    builder2.setMessage(LocaleController.getString("PollCantForwardSecretChat", R.string.PollCantForwardSecretChat));
                } else {
                    builder2.setMessage(LocaleController.getString("InvoiceCantForwardSecretChat", R.string.InvoiceCantForwardSecretChat));
                }
                builder2.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                showDialog(builder2.create());
                return;
            }
        }
        int i = this.initialDialogsType;
        if (i == 11 || i == 12 || i == 13) {
            if (this.checkingImportDialog) {
                return;
            }
            if (DialogObject.isUserDialog(dialogId)) {
                TLRPC$User user = getMessagesController().getUser(Long.valueOf(dialogId));
                if (!user.mutual_contact) {
                    getUndoView().showWithAction(dialogId, 45, (Runnable) null);
                    return;
                } else {
                    tLRPC$Chat = null;
                    tLRPC$User = user;
                }
            } else {
                TLRPC$Chat chat2 = getMessagesController().getChat(Long.valueOf(-dialogId));
                if (!ChatObject.hasAdminRights(chat2) || !ChatObject.canChangeChatInfo(chat2)) {
                    getUndoView().showWithAction(dialogId, 46, (Runnable) null);
                    return;
                }
                tLRPC$Chat = chat2;
            }
            final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            final TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer = new TLRPC$TL_messages_checkHistoryImportPeer();
            tLRPC$TL_messages_checkHistoryImportPeer.peer = getMessagesController().getInputPeer(dialogId);
            getConnectionsManager().sendRequest(tLRPC$TL_messages_checkHistoryImportPeer, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$luiXYi8XXYI50oCQkIzJ6SUr48Q
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didSelectResult$41$DialogsActivity(alertDialog, tLRPC$User, tLRPC$Chat, dialogId, param, tLRPC$TL_messages_checkHistoryImportPeer, tLObject, tLRPC$TL_error);
                }
            });
            try {
                alertDialog.showDelayed(300L);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (useAlert && ((this.selectAlertString != null && this.selectAlertStringGroup != null) || this.addToGroupAlertString != null)) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
            if (DialogObject.isEncryptedDialog(dialogId)) {
                TLRPC$User user2 = getMessagesController().getUser(Long.valueOf(getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(dialogId))).user_id));
                if (user2 == null) {
                    return;
                }
                string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(user2));
                string2 = LocaleController.getString("Send", R.string.Send);
            } else if (!DialogObject.isUserDialog(dialogId)) {
                TLRPC$Chat chat3 = getMessagesController().getChat(Long.valueOf(-dialogId));
                if (chat3 == null) {
                    return;
                }
                if (this.addToGroupAlertString != null) {
                    string = LocaleController.getString("AddToTheGroupAlertTitle", R.string.AddToTheGroupAlertTitle);
                    stringSimple = LocaleController.formatStringSimple(this.addToGroupAlertString, chat3.title);
                    string2 = LocaleController.getString("Add", R.string.Add);
                } else {
                    string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                    stringSimple = LocaleController.formatStringSimple(this.selectAlertStringGroup, chat3.title);
                    string2 = LocaleController.getString("Send", R.string.Send);
                }
            } else if (dialogId == getUserConfig().getClientUserId()) {
                string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                stringSimple = LocaleController.formatStringSimple(this.selectAlertStringGroup, LocaleController.getString("SavedMessages", R.string.SavedMessages));
                string2 = LocaleController.getString("Send", R.string.Send);
            } else {
                TLRPC$User user3 = getMessagesController().getUser(Long.valueOf(dialogId));
                if (user3 == null || this.selectAlertString == null) {
                    return;
                }
                string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(user3));
                string2 = LocaleController.getString("Send", R.string.Send);
            }
            builder3.setTitle(string);
            builder3.setMessage(AndroidUtilities.replaceTags(stringSimple));
            builder3.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$VlY8BaOiXRsXbtL3m3k2c9tAopY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$didSelectResult$42$DialogsActivity(dialogId, dialogInterface, i2);
                }
            });
            builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder3.create());
            return;
        }
        if (this.delegate != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(dialogId));
            this.delegate.didSelectDialogs(this, arrayList, null, param);
            if (this.resetDelegate) {
                this.delegate = null;
                return;
            }
            return;
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$41$DialogsActivity(final AlertDialog alertDialog, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final long j, final boolean z, final TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$6VUj75fpnT6vO9V9CH8BTaAjiro
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didSelectResult$40$DialogsActivity(alertDialog, tLObject, tLRPC$User, tLRPC$Chat, j, z, tLRPC$TL_error, tLRPC$TL_messages_checkHistoryImportPeer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$40$DialogsActivity(AlertDialog alertDialog, TLObject tLObject, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, final long j, final boolean z, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.checkingImportDialog = false;
        if (tLObject != null) {
            AlertsCreator.createImportDialogAlert(this, this.arguments.getString("importTitle"), ((TLRPC$TL_messages_checkedHistoryImportPeer) tLObject).confirm_text, tLRPC$User, tLRPC$Chat, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$nu4vzHdxJ6aXRUQ8h3fZpTTgDXM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didSelectResult$39$DialogsActivity(j, z);
                }
            });
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_messages_checkHistoryImportPeer, new Object[0]);
            getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(j), tLRPC$TL_messages_checkHistoryImportPeer, tLRPC$TL_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$39$DialogsActivity(long j, boolean z) {
        setDialogsListFrozen(true);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j));
        this.delegate.didSelectDialogs(this, arrayList, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$42$DialogsActivity(long j, DialogInterface dialogInterface, int i) {
        didSelectResult(j, false, false);
    }

    public RLottieImageView getFloatingButton() {
        return this.floatingButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x089f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03da  */
    /* JADX WARN: Type inference failed for: r4v195, types: [ir.eitaa.ui.Components.RecyclerListView] */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<ir.eitaa.ui.ActionBar.ThemeDescription> getThemeDescriptions() {
        /*
            Method dump skipped, instructions count: 6817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.getThemeDescriptions():java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x004d A[SYNTHETIC] */
    /* renamed from: lambda$getThemeDescriptions$43, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getThemeDescriptions$43$DialogsActivity() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogsActivity.lambda$getThemeDescriptions$43$DialogsActivity():void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected Animator getCustomSlideTransition(boolean topFragment, boolean backAnimation, float distanceToMove) {
        if (backAnimation) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.slideFragmentProgress, 1.0f);
            this.slideBackTransitionAnimator = valueAnimatorOfFloat;
            return valueAnimatorOfFloat;
        }
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.slideFragmentProgress, 1.0f);
        this.slideBackTransitionAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogsActivity$PZzSQc6ry2chUXDyDRwOeR1PYxI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$getCustomSlideTransition$44$DialogsActivity(valueAnimator);
            }
        });
        this.slideBackTransitionAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.slideBackTransitionAnimator.setDuration((int) (Math.max((int) ((200.0f / getLayoutContainer().getMeasuredWidth()) * distanceToMove), 80) * 1.2f));
        this.slideBackTransitionAnimator.start();
        return this.slideBackTransitionAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getCustomSlideTransition$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getCustomSlideTransition$44$DialogsActivity(ValueAnimator valueAnimator) {
        setSlideTransitionProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void prepareFragmentToSlide(boolean topFragment, boolean beginSlide) {
        if (!topFragment && beginSlide) {
            this.isSlideBackTransition = true;
            setFragmentIsSliding(true);
        } else {
            this.slideBackTransitionAnimator = null;
            this.isSlideBackTransition = false;
            setFragmentIsSliding(false);
            setSlideTransitionProgress(1.0f);
        }
    }

    private void setFragmentIsSliding(boolean sliding) {
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            return;
        }
        if (sliding) {
            ViewPage[] viewPageArr = this.viewPages;
            if (viewPageArr != null && viewPageArr[0] != null) {
                viewPageArr[0].setLayerType(2, null);
                this.viewPages[0].setClipChildren(false);
                this.viewPages[0].setClipToPadding(false);
                this.viewPages[0].listView.setClipChildren(false);
            }
            ActionBar actionBar = this.actionBar;
            if (actionBar != null) {
                actionBar.setLayerType(2, null);
            }
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView != null) {
                filterTabsView.getListView().setLayerType(2, null);
            }
            View view = this.fragmentView;
            if (view != null) {
                ((ViewGroup) view).setClipChildren(false);
                this.fragmentView.requestLayout();
                return;
            }
            return;
        }
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr2 = this.viewPages;
            if (i >= viewPageArr2.length) {
                break;
            }
            ViewPage viewPage = viewPageArr2[i];
            if (viewPage != null) {
                viewPage.setLayerType(0, null);
                viewPage.setClipChildren(true);
                viewPage.setClipToPadding(true);
                viewPage.listView.setClipChildren(true);
            }
            i++;
        }
        ActionBar actionBar2 = this.actionBar;
        if (actionBar2 != null) {
            actionBar2.setLayerType(0, null);
        }
        FilterTabsView filterTabsView2 = this.filterTabsView;
        if (filterTabsView2 != null) {
            filterTabsView2.getListView().setLayerType(0, null);
        }
        View view2 = this.fragmentView;
        if (view2 != null) {
            ((ViewGroup) view2).setClipChildren(true);
            this.fragmentView.requestLayout();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onSlideProgress(boolean isOpen, float progress) {
        if (SharedConfig.getDevicePerformanceClass() != 0 && this.isSlideBackTransition && this.slideBackTransitionAnimator == null) {
            setSlideTransitionProgress(progress);
        }
    }

    private void setSlideTransitionProgress(float progress) {
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            return;
        }
        this.slideFragmentProgress = progress;
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            float f = 1.0f - ((1.0f - this.slideFragmentProgress) * 0.05f);
            filterTabsView.getListView().setScaleX(f);
            this.filterTabsView.getListView().setScaleY(f);
            this.filterTabsView.getListView().setTranslationX((this.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - this.slideFragmentProgress));
            this.filterTabsView.getListView().setPivotX(this.isDrawerTransition ? this.filterTabsView.getMeasuredWidth() : 0.0f);
            this.filterTabsView.getListView().setPivotY(0.0f);
            this.filterTabsView.invalidate();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void setProgressToDrawerOpened(float progress) {
        if (SharedConfig.getDevicePerformanceClass() == 0 || this.isSlideBackTransition) {
            return;
        }
        boolean z = progress > 0.0f;
        if (this.searchIsShowed) {
            progress = 0.0f;
            z = false;
        }
        if (z != this.isDrawerTransition) {
            this.isDrawerTransition = z;
            if (z) {
                setFragmentIsSliding(true);
            } else {
                setFragmentIsSliding(false);
            }
            View view = this.fragmentView;
            if (view != null) {
                view.requestLayout();
            }
        }
        setSlideTransitionProgress(1.0f - progress);
    }

    public void setShowSearch(String query, int i) {
        if (!this.searching) {
            this.initialSearchType = i;
            this.actionBar.openSearchField(query, false);
            return;
        }
        if (!this.searchItem.getSearchField().getText().toString().equals(query)) {
            this.searchItem.getSearchField().setText(query);
        }
        if (this.searchViewPager.getTabsView().getCurrentTabId() != i) {
            this.searchViewPager.getTabsView().scrollToTab(i, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showExpandModeHint(boolean hide, boolean expandedMode) {
        int i;
        String str;
        if (getParentActivity() == null || this.fragmentView == null || searchToolsCell == null) {
            return;
        }
        if (hide && this.expandModeHintTextView == null) {
            return;
        }
        if (this.expandModeHintTextView == null) {
            TextView textView = new TextView(getParentActivity());
            this.expandModeHintTextView = textView;
            textView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(3.0f), Theme.getColor("chat_gifSaveHintBackground")));
            this.expandModeHintTextView.setTextColor(Theme.getColor("chat_gifSaveHintText"));
            this.expandModeHintTextView.setTextSize(1, 14.0f);
            this.expandModeHintTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.expandModeHintTextView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(7.0f));
            this.expandModeHintTextView.setGravity(16);
            this.expandModeHintTextView.setAlpha(0.0f);
            ((ContentView) this.fragmentView).addView(this.expandModeHintTextView, LayoutHelper.createFrame(-2, -2.0f, 53, 5.0f, 5.0f + (this.actionBar.getHeight() / (getParentActivity().getResources().getDisplayMetrics().densityDpi / 160.0f)) + 100.0f, 5.0f, 0.0f));
        }
        if (hide) {
            AnimatorSet animatorSet = this.expandModeHintAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.expandModeHintAnimation = null;
            }
            AndroidUtilities.cancelRunOnUIThread(this.expandModeHintHideRunnable);
            this.expandModeHintHideRunnable = null;
            hideExpandModeHint();
            return;
        }
        TextView textView2 = this.expandModeHintTextView;
        if (expandedMode) {
            i = R.string.ExpandedModeEnabledHint;
            str = "ExpandedModeEnabledHint";
        } else {
            i = R.string.ExpandedModeDisabledHint;
            str = "ExpandedModeDisabledHint";
        }
        textView2.setText(LocaleController.getString(str, i));
        Runnable runnable = this.expandModeHintHideRunnable;
        if (runnable != null) {
            AnimatorSet animatorSet2 = this.expandModeHintAnimation;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                this.expandModeHintAnimation = null;
            } else {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.DialogsActivity.41
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogsActivity.this.hideExpandModeHint();
                    }
                };
                this.expandModeHintHideRunnable = runnable2;
                AndroidUtilities.runOnUIThread(runnable2, 1000L);
                return;
            }
        } else if (this.expandModeHintAnimation != null) {
            return;
        }
        this.expandModeHintTextView.setVisibility(0);
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.expandModeHintAnimation = animatorSet3;
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.expandModeHintTextView, "alpha", 1.0f));
        this.expandModeHintAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.42
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(DialogsActivity.this.expandModeHintAnimation)) {
                    DialogsActivity.this.expandModeHintAnimation = null;
                    AndroidUtilities.runOnUIThread(DialogsActivity.this.expandModeHintHideRunnable = new Runnable() { // from class: ir.eitaa.ui.DialogsActivity.42.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DialogsActivity.this.hideExpandModeHint();
                        }
                    }, 1000L);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation.equals(DialogsActivity.this.expandModeHintAnimation)) {
                    DialogsActivity.this.expandModeHintAnimation = null;
                }
            }
        });
        this.expandModeHintAnimation.setDuration(300L);
        this.expandModeHintAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideExpandModeHint() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.expandModeHintAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.expandModeHintTextView, "alpha", 0.0f));
        this.expandModeHintAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogsActivity.43
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(DialogsActivity.this.expandModeHintAnimation)) {
                    DialogsActivity.this.expandModeHintAnimation = null;
                    DialogsActivity.this.expandModeHintHideRunnable = null;
                    if (DialogsActivity.this.expandModeHintTextView != null) {
                        DialogsActivity.this.expandModeHintTextView.setVisibility(8);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation.equals(DialogsActivity.this.expandModeHintAnimation)) {
                    DialogsActivity.this.expandModeHintHideRunnable = null;
                    DialogsActivity.this.expandModeHintAnimation = null;
                }
            }
        });
        this.expandModeHintAnimation.setDuration(300L);
        this.expandModeHintAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateExpandedViewButton() {
        int i;
        String str;
        SearchToolsCell.ActionItem actionItem = this.listModeActionItem;
        if (actionItem == null) {
            return;
        }
        if (this.expandedMode && this.searching) {
            actionItem.setImageResource(R.drawable.ic_message_cell_veiw);
        } else {
            actionItem.setImageResource(R.drawable.ic_dialog_cell_view);
        }
        SearchToolsCell.ActionItem actionItem2 = this.listModeActionItem;
        if (this.expandedMode) {
            i = R.string.ExpandedModeEnabledHint;
            str = "ExpandedModeEnabledHint";
        } else {
            i = R.string.ExpandedModeDisabledHint;
            str = "ExpandedModeDisabledHint";
        }
        actionItem2.setContentDescription(LocaleController.getString(str, i));
        ((FilteredSearchView) this.searchViewPager.getCurrentView()).getDialogsAdapter().setExpandedViewMode(this.expandedMode);
    }

    public static SearchToolsCell getSearchToolsCell() {
        return searchToolsCell;
    }
}
