package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.util.StateSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MyLog;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScrollerCustom;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.CardPageLinkData;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.XiaomiUtilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$TL_dialogFolder;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_checkHistoryImportPeer;
import org.rbmain.tgnet.TLRPC$TL_messages_checkedHistoryImportPeer;
import org.rbmain.tgnet.TLRPC$TL_messages_updateDialogFilter;
import org.rbmain.tgnet.TLRPC$TL_userEmpty;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.DrawerLayoutContainer;
import org.rbmain.ui.ActionBar.MenuDrawable;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.DialogsAdapter;
import org.rbmain.ui.Adapters.DialogsSearchAdapter;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.ChatActivityEnterView;
import org.rbmain.ui.Components.ChatAvatarContainer;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.DialogsItemAnimator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.FilterTabsView;
import org.rbmain.ui.Components.FiltersListBottomSheet;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.FragmentContextView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberTextView;
import org.rbmain.ui.Components.PacmanAnimation;
import org.rbmain.ui.Components.ProxyDrawable;
import org.rbmain.ui.Components.PullForegroundDrawable;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RecyclerAnimationScrollHelper;
import org.rbmain.ui.Components.RecyclerItemsEnterAnimator;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SearchViewPager;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.Components.ViewPagerFixed;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.GroupCreateFinalActivity;

/* loaded from: classes4.dex */
public class DialogsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static boolean[] dialogsLoaded = new boolean[3];
    private static final Interpolator interpolator = new Interpolator() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda23
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return DialogsActivity.lambda$static$0(f);
        }
    };
    public static float viewOffset = 0.0f;
    public final Property<DialogsActivity, Float> SCROLL_Y;
    private ValueAnimator actionBarColorAnimator;
    private Paint actionBarDefaultPaint;
    private ArrayList<View> actionModeViews;
    private ActionBarMenuSubItem addToFolderItem;
    private String addToGroupAlertString;
    private float additionalFloatingTranslation;
    private float additionalOffset;
    private boolean afterSignup;
    private boolean allowMoving;
    private boolean allowSwipeDuringCurrentTouch;
    private boolean allowSwitchAccount;
    private boolean animatingForward;
    private int animationIndex;
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
    private boolean hasInvoice;
    private int hasPoll;
    private int initialDialogsType;
    private String initialSearchString;
    private int initialSearchType;
    boolean isDrawerTransition;
    private boolean isLoadingChats;
    boolean isSlideBackTransition;
    private int lastMeasuredTopPadding;
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
    private RLottieDrawable passcodeDrawable2;
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
    private boolean updatePullAfterScroll;
    private ViewPage[] viewPages;
    private boolean waitingForScrollFinished;
    private boolean whiteActionBar;

    /* loaded from: classes.dex */
    public interface DialogsActivityDelegate {
        void didSelectDialogs(DialogsActivity dialogsActivity, ArrayList<Long> arrayList, CharSequence charSequence, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createActionMode$14(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    public void setShowSearch(String str, int i) {
        if (!this.searching) {
            this.initialSearchType = i;
            this.actionBar.openSearchField(str, false);
            return;
        }
        if (!this.searchItem.getSearchField().getText().toString().equals(str)) {
            this.searchItem.getSearchField().setText(str);
        }
        if (this.searchViewPager.getTabsView().getCurrentTabId() != i) {
            this.searchViewPager.getTabsView().scrollToTab(i, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ViewPage extends FrameLayout {
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

        static /* synthetic */ int access$10308(ViewPage viewPage) {
            int i = viewPage.lastItemsCount;
            viewPage.lastItemsCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$10310(ViewPage viewPage) {
            int i = viewPage.lastItemsCount;
            viewPage.lastItemsCount = i - 1;
            return i;
        }

        public ViewPage(DialogsActivity dialogsActivity, Context context) {
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

        private boolean prepareForMoving(MotionEvent motionEvent, boolean z) {
            int nextPageId = DialogsActivity.this.filterTabsView.getNextPageId(z);
            if (nextPageId < 0) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            DialogsActivity.this.maybeStartTracking = false;
            DialogsActivity.this.startedTracking = true;
            this.startedTrackingX = (int) (motionEvent.getX() + DialogsActivity.this.additionalOffset);
            ((BaseFragment) DialogsActivity.this).actionBar.setEnabled(false);
            DialogsActivity.this.filterTabsView.setEnabled(false);
            DialogsActivity.this.viewPages[1].selectedType = nextPageId;
            DialogsActivity.this.viewPages[1].setVisibility(0);
            DialogsActivity.this.animatingForward = z;
            DialogsActivity.this.showScrollbars(false);
            DialogsActivity.this.switchToCurrentSelectedMode(true);
            if (z) {
                DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
            } else {
                DialogsActivity.this.viewPages[1].setTranslationX(-DialogsActivity.this.viewPages[0].getMeasuredWidth());
            }
            return true;
        }

        @Override // android.view.View
        public void setPadding(int i, int i2, int i3, int i4) {
            DialogsActivity.this.topPadding = i2;
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
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean zDrawChild;
            if ((view == DialogsActivity.this.fragmentContextView && DialogsActivity.this.fragmentContextView.isCallStyle()) || view == DialogsActivity.this.blurredView) {
                return true;
            }
            if (view != DialogsActivity.this.viewPages[0] && ((DialogsActivity.this.viewPages.length <= 1 || view != DialogsActivity.this.viewPages[1]) && view != DialogsActivity.this.fragmentContextView && view != DialogsActivity.this.fragmentLocationContextView && view != DialogsActivity.this.searchViewPager)) {
                if (view == ((BaseFragment) DialogsActivity.this).actionBar && DialogsActivity.this.slideFragmentProgress != 1.0f) {
                    canvas.save();
                    DialogsActivity dialogsActivity = DialogsActivity.this;
                    float f = 1.0f - ((1.0f - dialogsActivity.slideFragmentProgress) * 0.05f);
                    canvas.translate((dialogsActivity.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - DialogsActivity.this.slideFragmentProgress), 0.0f);
                    canvas.scale(f, f, DialogsActivity.this.isDrawerTransition ? getMeasuredWidth() : 0.0f, (((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + (ActionBar.getCurrentActionBarHeight() / 2.0f));
                    zDrawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                } else {
                    zDrawChild = super.drawChild(canvas, view, j);
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
                zDrawChild = super.drawChild(canvas, view, j);
                canvas.restore();
            }
            if (view == ((BaseFragment) DialogsActivity.this).actionBar && ((BaseFragment) DialogsActivity.this).parentLayout != null) {
                int y = (int) (((BaseFragment) DialogsActivity.this).actionBar.getY() + getActionBarFullHeight());
                ((BaseFragment) DialogsActivity.this).parentLayout.drawHeaderShadow(canvas, (int) ((1.0f - DialogsActivity.this.searchAnimationProgress) * 255.0f), y);
                if (DialogsActivity.this.searchAnimationProgress > 0.0f) {
                    if (DialogsActivity.this.searchAnimationProgress < 1.0f) {
                        int alpha = Theme.dividerPaint.getAlpha();
                        Theme.dividerPaint.setAlpha((int) (alpha * DialogsActivity.this.searchAnimationProgress));
                        float f4 = y;
                        canvas.drawLine(0.0f, f4, getMeasuredWidth(), f4, Theme.dividerPaint);
                        Theme.dividerPaint.setAlpha(alpha);
                    } else {
                        float f5 = y;
                        canvas.drawLine(0.0f, f5, getMeasuredWidth(), f5, Theme.dividerPaint);
                    }
                }
            }
            return zDrawChild;
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
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
                    this.actionBarSearchPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
                    this.actionBarSearchPaint.setColor(ColorUtils.blendARGB(Theme.getColor(DialogsActivity.this.folderId == 0 ? Theme.key_actionBarDefault : Theme.key_actionBarDefaultArchived), Theme.getColor(Theme.key_windowBackgroundWhite), DialogsActivity.this.searchAnimationProgress));
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
                    this.actionBarSearchPaint.setColor(ColorUtils.blendARGB(Theme.getColor(DialogsActivity.this.folderId == 0 ? Theme.key_actionBarDefault : Theme.key_actionBarDefaultArchived), Theme.getColor(Theme.key_windowBackgroundWhite), DialogsActivity.this.progressToActionMode));
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
                this.windowBackgroundPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, size2);
            int paddingTop = size2 - getPaddingTop();
            if (DialogsActivity.this.doneItem != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) DialogsActivity.this.doneItem.getLayoutParams();
                layoutParams.topMargin = ((BaseFragment) DialogsActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0;
                layoutParams.height = ActionBar.getCurrentActionBarHeight();
            }
            measureChildWithMargins(((BaseFragment) DialogsActivity.this).actionBar, i, 0, i2, 0);
            int iMeasureKeyboardHeight = measureKeyboardHeight();
            int childCount = getChildCount();
            float f = 0.0f;
            if (DialogsActivity.this.commentView != null) {
                measureChildWithMargins(DialogsActivity.this.commentView, i, 0, i2, 0);
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
                    DialogsActivity.this.fragmentView.setTranslationY(0.0f);
                    for (int i3 = 0; i3 < DialogsActivity.this.viewPages.length; i3++) {
                        if (DialogsActivity.this.viewPages[i3] != null) {
                            DialogsActivity.this.viewPages[i3].setTranslationY(0.0f);
                        }
                    }
                    if (!DialogsActivity.this.onlySelect) {
                        ((BaseFragment) DialogsActivity.this).actionBar.setTranslationY(0.0f);
                    }
                    DialogsActivity.this.searchViewPager.setTranslationY(0.0f);
                }
            }
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8 && childAt != DialogsActivity.this.commentView && childAt != ((BaseFragment) DialogsActivity.this).actionBar) {
                    if (!(childAt instanceof ViewPage)) {
                        if (childAt == DialogsActivity.this.searchViewPager) {
                            DialogsActivity.this.searchViewPager.setTranslationY(0.0f);
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), ((((View.MeasureSpec.getSize(i2) + iMeasureKeyboardHeight) - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - (DialogsActivity.this.onlySelect ? 0 : ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight())) - DialogsActivity.this.topPadding) - (DialogsActivity.this.searchTabsView == null ? 0 : AndroidUtilities.dp(44.0f)), 1073741824));
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
                            measureChildWithMargins(childAt, i, 0, i2, 0);
                        }
                    } else {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        int iDp = (DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0) ? (((paddingTop - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - (DialogsActivity.this.onlySelect ? 0 : ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight())) - DialogsActivity.this.topPadding : (((paddingTop - this.inputFieldHeight) + AndroidUtilities.dp(2.0f)) - AndroidUtilities.dp(44.0f)) - DialogsActivity.this.topPadding;
                        if (DialogsActivity.this.filtersTabAnimator != null && DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                            iDp = (int) (iDp + DialogsActivity.this.filterTabsMoveFrom);
                        } else {
                            childAt.setTranslationY(f);
                        }
                        DialogsActivity dialogsActivity = DialogsActivity.this;
                        int i5 = (dialogsActivity.isSlideBackTransition || dialogsActivity.isDrawerTransition) ? (int) (iDp * 0.05f) : 0;
                        childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), i5);
                        childAt.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), iDp + i5), 1073741824));
                        childAt.setPivotX(childAt.getMeasuredWidth() / 2);
                    }
                }
                i4++;
                f = 0.0f;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0190  */
        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r15, int r16, int r17, int r18, int r19) {
            /*
                Method dump skipped, instructions count: 437
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.ContentView.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked == 1 || actionMasked == 3) && ((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                DialogsActivity.this.allowMoving = true;
            }
            if (checkTabsAnimationInProgress()) {
                return true;
            }
            return (DialogsActivity.this.filterTabsView != null && DialogsActivity.this.filterTabsView.isAnimatingIndicator()) || onTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean z) {
            if (DialogsActivity.this.maybeStartTracking && !DialogsActivity.this.startedTracking) {
                onTouchEvent(null);
            }
            super.requestDisallowInterceptTouchEvent(z);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float xVelocity;
            float yVelocity;
            float measuredWidth;
            int measuredWidth2;
            if (((BaseFragment) DialogsActivity.this).parentLayout == null || DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.isEditing() || DialogsActivity.this.searching || ((BaseFragment) DialogsActivity.this).parentLayout.checkTransitionAnimation() || ((BaseFragment) DialogsActivity.this).parentLayout.isInPreviewMode() || ((BaseFragment) DialogsActivity.this).parentLayout.isPreviewOpenAnimationInProgress() || ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().isDrawerOpened() || !((motionEvent == null || DialogsActivity.this.startedTracking || motionEvent.getY() > ((BaseFragment) DialogsActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) DialogsActivity.this).actionBar.getTranslationY()) && SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 4)) {
                return false;
            }
            if (motionEvent != null) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.addMovement(motionEvent);
            }
            if (motionEvent != null && motionEvent.getAction() == 0 && checkTabsAnimationInProgress()) {
                DialogsActivity.this.startedTracking = true;
                this.startedTrackingPointerId = motionEvent.getPointerId(0);
                this.startedTrackingX = (int) motionEvent.getX();
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
            } else if (motionEvent != null && motionEvent.getAction() == 0) {
                DialogsActivity.this.additionalOffset = 0.0f;
            }
            if (motionEvent != null && motionEvent.getAction() == 0 && !DialogsActivity.this.startedTracking && !DialogsActivity.this.maybeStartTracking && DialogsActivity.this.filterTabsView.getVisibility() == 0) {
                this.startedTrackingPointerId = motionEvent.getPointerId(0);
                DialogsActivity.this.maybeStartTracking = true;
                this.startedTrackingX = (int) motionEvent.getX();
                this.startedTrackingY = (int) motionEvent.getY();
                this.velocityTracker.clear();
            } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.startedTrackingPointerId) {
                int x = (int) ((motionEvent.getX() - this.startedTrackingX) + DialogsActivity.this.additionalOffset);
                int iAbs = Math.abs(((int) motionEvent.getY()) - this.startedTrackingY);
                if (DialogsActivity.this.startedTracking && ((DialogsActivity.this.animatingForward && x > 0) || (!DialogsActivity.this.animatingForward && x < 0))) {
                    if (!prepareForMoving(motionEvent, x < 0)) {
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
                    int x2 = (int) (motionEvent.getX() - this.startedTrackingX);
                    if (Math.abs(x2) >= pixelsInCM && Math.abs(x2) > iAbs) {
                        prepareForMoving(motionEvent, x < 0);
                    }
                }
            } else if (motionEvent == null || (motionEvent.getPointerId(0) == this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6))) {
                this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, DialogsActivity.this.maximumVelocity);
                if (motionEvent == null || motionEvent.getAction() == 3) {
                    xVelocity = 0.0f;
                    yVelocity = 0.0f;
                } else {
                    xVelocity = this.velocityTracker.getXVelocity();
                    yVelocity = this.velocityTracker.getYVelocity();
                    if (!DialogsActivity.this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                        prepareForMoving(motionEvent, xVelocity < 0.0f);
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
                    DialogsActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.ContentView.1
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
                                ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(DialogsActivity.this.viewPages[0].selectedType == DialogsActivity.this.filterTabsView.getFirstTabId() || DialogsActivity.this.searchIsShowed || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 4);
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
                    ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(DialogsActivity.this.viewPages[0].selectedType == DialogsActivity.this.filterTabsView.getFirstTabId() || DialogsActivity.this.searchIsShowed || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 4);
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
        Paint paint;
        private final ViewPage parentPage;
        RectF rectF;

        @Override // org.rbmain.ui.Components.RecyclerListView
        protected boolean updateEmptyViewAnimated() {
            return true;
        }

        public DialogsRecyclerView(Context context, ViewPage viewPage) {
            super(context);
            this.firstLayout = true;
            this.paint = new Paint();
            this.rectF = new RectF();
            this.parentPage = viewPage;
        }

        public void setViewsOffset(float f) {
            View viewFindViewByPosition;
            DialogsActivity.viewOffset = f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setTranslationY(f);
            }
            if (this.selectorPosition != -1 && (viewFindViewByPosition = getLayoutManager().findViewByPosition(this.selectorPosition)) != null) {
                this.selectorRect.set(viewFindViewByPosition.getLeft(), (int) (viewFindViewByPosition.getTop() + f), viewFindViewByPosition.getRight(), (int) (viewFindViewByPosition.getBottom() + f));
                this.selectorDrawable.setBounds(this.selectorRect);
            }
            invalidate();
        }

        public float getViewOffset() {
            return DialogsActivity.viewOffset;
        }

        @Override // android.view.ViewGroup
        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            super.addView(view, i, layoutParams);
            view.setTranslationY(DialogsActivity.viewOffset);
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
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

        @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (drawMovingViewsOverlayed()) {
                this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
        public boolean drawChild(Canvas canvas, View view, long j) {
            if (drawMovingViewsOverlayed() && (view instanceof DialogCell) && ((DialogCell) view).isMoving()) {
                return true;
            }
            return super.drawChild(canvas, view, j);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView
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

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
        protected void onMeasure(int i, int i2) {
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
            super.onMeasure(i, i2);
            if (DialogsActivity.this.onlySelect || this.appliedPaddingTop == currentActionBarHeight || DialogsActivity.this.viewPages == null || DialogsActivity.this.viewPages.length <= 1) {
                return;
            }
            DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
        }

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.lastListPadding = getPaddingTop();
            DialogsActivity.this.scrollAdditionalOffset = 0.0f;
            if ((DialogsActivity.this.dialogRemoveFinished == 0 && DialogsActivity.this.dialogInsertFinished == 0 && DialogsActivity.this.dialogChangeFinished == 0) || this.parentPage.dialogsItemAnimator.isRunning()) {
                return;
            }
            DialogsActivity.this.onDialogAnimationFinished();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void toggleArchiveHidden(boolean z, DialogCell dialogCell) {
            SharedConfig.toggleArchiveHidden();
            if (SharedConfig.archiveHidden) {
                if (dialogCell != null) {
                    DialogsActivity.this.disableActionBarScrolling = true;
                    DialogsActivity.this.waitingForScrollFinished = true;
                    smoothScrollBy(0, dialogCell.getMeasuredHeight() + (dialogCell.getTop() - getPaddingTop()), CubicBezierInterpolator.EASE_OUT);
                    if (z) {
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
            if (!z || dialogCell == null) {
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

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
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
                                if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 2) {
                                    if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 0) {
                                        if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 3) {
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(Long.valueOf(dialogId));
                                            DialogsActivity.this.perfromSelectedDialogsAction(arrayList, 102, true);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(Long.valueOf(dialogId));
                                        DialogsActivity.this.canPinCount = !DialogsActivity.this.isDialogPinned(tLRPC$Dialog) ? 1 : 0;
                                        DialogsActivity.this.perfromSelectedDialogsAction(arrayList2, 100, true);
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
                                    DialogsActivity.this.perfromSelectedDialogsAction(arrayList3, 104, true);
                                }
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(Long.valueOf(dialogId));
                                DialogsActivity.this.canReadCount = (tLRPC$Dialog.unread_count > 0 || tLRPC$Dialog.unread_mark) ? 1 : 0;
                                DialogsActivity.this.perfromSelectedDialogsAction(arrayList4, 101, true);
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
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$DialogsRecyclerView$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$onTouchEvent$0(valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.setDuration(Math.max(100L, (long) (350.0f - ((getViewOffset() / PullForegroundDrawable.getMaxOverscroll()) * 120.0f))));
                    valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                    setScrollEnabled(false);
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.DialogsRecyclerView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            DialogsRecyclerView.this.setScrollEnabled(true);
                        }
                    });
                    valueAnimatorOfFloat.start();
                }
            }
            return zOnTouchEvent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTouchEvent$0(ValueAnimator valueAnimator) {
            setViewsOffset(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.fastScrollAnimationRunning || DialogsActivity.this.waitingForScrollFinished || DialogsActivity.this.dialogRemoveFinished != 0 || DialogsActivity.this.dialogInsertFinished != 0 || DialogsActivity.this.dialogChangeFinished != 0) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                DialogsActivity.this.allowSwipeDuringCurrentTouch = !((BaseFragment) r0).actionBar.isActionModeShowed();
                checkIfAdapterValid();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SwipeController extends ItemTouchHelper.Callback {
        private RecyclerView.ViewHolder currentItemViewHolder;
        private ViewPage parentPage;
        private boolean swipeFolderBack;
        private boolean swipingFolder;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeEscapeVelocity(float f) {
            return 3500.0f;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.45f;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public float getSwipeVelocityThreshold(float f) {
            return Float.MAX_VALUE;
        }

        public SwipeController(ViewPage viewPage) {
            this.parentPage = viewPage;
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
                            long dialogId = dialogCell.getDialogId();
                            if (!((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                                if ((DialogsActivity.this.filterTabsView == null || DialogsActivity.this.filterTabsView.getVisibility() != 0 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 4) && DialogsActivity.this.allowSwipeDuringCurrentTouch) {
                                    int i = DialogsActivity.this.getUserConfig().clientUserId;
                                    if (!DialogsActivity.this.getMessagesController().isPromoDialog(dialogId, false) || DialogsActivity.this.getMessagesController().promoDialogType == 1) {
                                        boolean z = DialogsActivity.this.folderId == 0 && (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 2 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 1 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 0 || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 3);
                                        if (SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) == 1) {
                                            MessagesController.DialogFilter dialogFilter = null;
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
                                }
                            } else {
                                TLRPC$Dialog tLRPC$Dialog2 = DialogsActivity.this.getMessagesController().dialogs_dict.get(dialogId);
                                if (!DialogsActivity.this.allowMoving || tLRPC$Dialog2 == null || !DialogsActivity.this.isDialogPinned(tLRPC$Dialog2) || DialogObject.isFolderDialogId(dialogId)) {
                                    return 0;
                                }
                                DialogsActivity.this.movingView = (DialogCell) viewHolder.itemView;
                                DialogsActivity.this.movingView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            long dialogId;
            TLRPC$Dialog tLRPC$Dialog;
            View view = viewHolder2.itemView;
            if (!(view instanceof DialogCell) || (tLRPC$Dialog = DialogsActivity.this.getMessagesController().dialogs_dict.get((dialogId = ((DialogCell) view).getDialogId()))) == null || !DialogsActivity.this.isDialogPinned(tLRPC$Dialog) || DialogObject.isFolderDialogId(dialogId)) {
                return false;
            }
            this.parentPage.dialogsAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
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
        public int convertToAbsoluteDirection(int i, int i2) {
            if (this.swipeFolderBack) {
                return 0;
            }
            return super.convertToAbsoluteDirection(i, i2);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
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
                Runnable runnable = new Runnable() { // from class: org.rbmain.ui.DialogsActivity$SwipeController$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSwiped$1(tLRPC$Dialog, itemCount, adapterPosition);
                    }
                };
                DialogsActivity.this.setDialogsListFrozen(true);
                if (Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) == 1) {
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
            DialogsActivity.this.perfromSelectedDialogsAction(arrayList, 101, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSwiped$1(final TLRPC$Dialog tLRPC$Dialog, int i, int i2) {
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
                    ViewPage.access$10310(this.parentPage);
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
                            ViewPage.access$10308(this.parentPage);
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
                        globalMainSettings.edit().putBoolean("archivehint_l", true).apply();
                    }
                    DialogsActivity.this.getUndoView().showWithAction(tLRPC$Dialog.id, z ? 2 : 3, null, new Runnable() { // from class: org.rbmain.ui.DialogsActivity$SwipeController$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onSwiped$0(tLRPC$Dialog, i3);
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
            ViewPage.access$10310(this.parentPage);
            this.parentPage.dialogsAdapter.notifyItemRemoved(i2);
            DialogsActivity.this.dialogRemoveFinished = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSwiped$0(TLRPC$Dialog tLRPC$Dialog, int i) {
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
                ViewPage.access$10308(this.parentPage);
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
                    ViewPage.access$10310(this.parentPage);
                    this.parentPage.dialogsAdapter.notifyItemRemoved(0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
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
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            if (i == 4) {
                return 200L;
            }
            if (i == 8 && DialogsActivity.this.movingView != null) {
                final DialogCell dialogCell = DialogsActivity.this.movingView;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$SwipeController$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        dialogCell.setBackgroundDrawable(null);
                    }
                }, this.parentPage.dialogsItemAnimator.getMoveDuration());
                DialogsActivity.this.movingView = null;
            }
            return super.getAnimationDuration(recyclerView, i, f, f2);
        }
    }

    public DialogsActivity(Bundle bundle) {
        super(bundle);
        this.initialSearchType = -1;
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
        this.SCROLL_Y = new AnimationProperties.FloatProperty<DialogsActivity>("animationValue") { // from class: org.rbmain.ui.DialogsActivity.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(DialogsActivity dialogsActivity, float f) {
                dialogsActivity.setScrollY(f);
            }

            @Override // android.util.Property
            public Float get(DialogsActivity dialogsActivity) {
                return Float.valueOf(((BaseFragment) DialogsActivity.this).actionBar.getTranslationY());
            }
        };
        this.scrollBarVisible = true;
        this.slideFragmentProgress = 1.0f;
        this.fragmentName = "DialogsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        if (getArguments() != null) {
            this.onlySelect = this.arguments.getBoolean("onlySelect", false);
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
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
            if (!this.onlySelect) {
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.closeSearchByActiveAction);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.proxySettingsChanged);
                getNotificationCenter().addObserver(this, NotificationCenter.filterSettingsUpdated);
                getNotificationCenter().addObserver(this, NotificationCenter.dialogFiltersUpdated);
                getNotificationCenter().addObserver(this, NotificationCenter.dialogsUnreadCounterChanged);
                getNotificationCenter().addObserver(this, NotificationCenter.dialogsLoadingChange);
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
            getNotificationCenter().addObserver(this, NotificationCenter.lastOnlineUpdated);
            getNotificationCenter().addObserver(this, NotificationCenter.replyMessagesDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.reloadHints);
            getNotificationCenter().addObserver(this, NotificationCenter.didUpdateConnectionState);
            getNotificationCenter().addObserver(this, NotificationCenter.needDeleteDialog);
            getNotificationCenter().addObserver(this, NotificationCenter.folderBecomeEmpty);
            getNotificationCenter().addObserver(this, NotificationCenter.newSuggestionsAvailable);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetPasscode);
        }
        getNotificationCenter().addObserver(this, NotificationCenter.messagesDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.didClearDatabase);
        getDialogsProxy().initMessenger();
        loadDialogs(getAccountInstance());
        getMessagesController().loadPinnedDialogs(this.folderId, 0L, null);
        return true;
    }

    public static void loadDialogs(AccountInstance accountInstance) {
        int currentAccount = accountInstance.getCurrentAccount();
        if (dialogsLoaded[currentAccount]) {
            return;
        }
        MessagesController messagesController = accountInstance.getMessagesController();
        messagesController.loadGlobalNotificationsSettings();
        messagesController.loadHintDialogs();
        messagesController.loadUserInfo(accountInstance.getUserConfig().getCurrentUser(), false, 0);
        accountInstance.getContactsController().checkInviteText();
        accountInstance.getMediaDataController().checkAllMedia(false);
        accountInstance.getMediaDataController().loadRecents(2, false, true, false);
        accountInstance.getMediaDataController().loadRecents(3, false, true, false);
        accountInstance.getMediaDataController().checkFeaturedStickers();
        Iterator<String> it = messagesController.diceEmojies.iterator();
        while (it.hasNext()) {
            accountInstance.getMediaDataController().loadStickersByEmojiOrName(it.next(), true, true);
        }
        dialogsLoaded[currentAccount] = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        if (this.searchString == null) {
            getNotificationCenter().removeObserver(this, NotificationCenter.dialogsNeedReload);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
            if (!this.onlySelect) {
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.closeSearchByActiveAction);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxySettingsChanged);
                getNotificationCenter().removeObserver(this, NotificationCenter.filterSettingsUpdated);
                getNotificationCenter().removeObserver(this, NotificationCenter.dialogFiltersUpdated);
                getNotificationCenter().removeObserver(this, NotificationCenter.dialogsUnreadCounterChanged);
                getNotificationCenter().removeObserver(this, NotificationCenter.dialogsLoadingChange);
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
            getNotificationCenter().removeObserver(this, NotificationCenter.lastOnlineUpdated);
            getNotificationCenter().removeObserver(this, NotificationCenter.replyMessagesDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.reloadHints);
            getNotificationCenter().removeObserver(this, NotificationCenter.didUpdateConnectionState);
            getNotificationCenter().removeObserver(this, NotificationCenter.needDeleteDialog);
            getNotificationCenter().removeObserver(this, NotificationCenter.folderBecomeEmpty);
            getNotificationCenter().removeObserver(this, NotificationCenter.newSuggestionsAvailable);
            getNotificationCenter().removeObserver(this, NotificationCenter.messagesDeleted);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetPasscode);
        }
        getNotificationCenter().removeObserver(this, NotificationCenter.didClearDatabase);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context) { // from class: org.rbmain.ui.DialogsActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public void setTranslationY(float f) {
                View view;
                if (f != getTranslationY() && (view = DialogsActivity.this.fragmentView) != null) {
                    view.invalidate();
                }
                super.setTranslationY(f);
            }

            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (!((BaseFragment) DialogsActivity.this).inPreviewMode || DialogsActivity.this.avatarContainer == null || view == DialogsActivity.this.avatarContainer) {
                    return super.drawChild(canvas, view, j);
                }
                return false;
            }
        };
        actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSelector), false);
        actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefaultSelector), true);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), true);
        if (this.inPreviewMode || (AndroidUtilities.isTablet() && this.folderId != 0)) {
            actionBar.setOccupyStatusBar(false);
        }
        actionBar.setRtlLayout(this.rtlLayout);
        return actionBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x07f9 A[LOOP:2: B:188:0x07f7->B:189:0x07f9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0959  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(final android.content.Context r41) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
        this.filterTabsView.setIsEditing(false);
        showDoneItem(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3() {
        if (this.initialDialogsType != 10) {
            hideFloatingButton(false);
        }
        scrollToTop();
    }

    /* renamed from: org.rbmain.ui.DialogsActivity$6, reason: invalid class name */
    class AnonymousClass6 implements FilterTabsView.FilterTabsViewDelegate {
        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$showDeleteAlert$0() {
        }

        AnonymousClass6() {
        }

        private void showDeleteAlert(final MessagesController.DialogFilter dialogFilter) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("FilterDelete", R.string.FilterDelete));
            builder.setMessage(LocaleController.getString("FilterDeleteAlert", R.string.FilterDeleteAlert));
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$6$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$showDeleteAlert$2(dialogFilter, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showDeleteAlert$2(MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
            tLRPC$TL_messages_updateDialogFilter.id = dialogFilter.id;
            DialogsActivity.this.getDialogsProxy().deleteDialogFilter(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: org.rbmain.ui.DialogsActivity$6$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    DialogsActivity.AnonymousClass6.lambda$showDeleteAlert$1(tLObject, tLRPC$TL_error);
                }
            });
            DialogsActivity.this.getMessagesController().removeFilter(dialogFilter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$showDeleteAlert$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$6$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DialogsActivity.AnonymousClass6.lambda$showDeleteAlert$0();
                }
            });
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onSamePageSelected() {
            DialogsActivity.this.scrollToTop();
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageReorder(int i, int i2) {
            for (int i3 = 0; i3 < DialogsActivity.this.viewPages.length; i3++) {
                if (DialogsActivity.this.viewPages[i3].selectedType == i) {
                    DialogsActivity.this.viewPages[i3].selectedType = i2;
                } else if (DialogsActivity.this.viewPages[i3].selectedType == i2) {
                    DialogsActivity.this.viewPages[i3].selectedType = i;
                }
            }
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageSelected(int i, boolean z) {
            if (DialogsActivity.this.viewPages[0].selectedType == i) {
                return;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = DialogsActivity.this.getMessagesController().dialogFilters;
            if (i == Integer.MAX_VALUE || (i >= 0 && i < arrayList.size())) {
                if (((BaseFragment) DialogsActivity.this).parentLayout != null) {
                    ((BaseFragment) DialogsActivity.this).parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(i == DialogsActivity.this.filterTabsView.getFirstTabId() || SharedConfig.getChatSwipeAction(((BaseFragment) DialogsActivity.this).currentAccount) != 4);
                }
                DialogsActivity.this.viewPages[1].selectedType = i;
                DialogsActivity.this.viewPages[1].setVisibility(0);
                DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth());
                DialogsActivity.this.showScrollbars(false);
                DialogsActivity.this.switchToCurrentSelectedMode(true);
                DialogsActivity.this.animatingForward = z;
            }
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public boolean canPerformActions() {
            return !DialogsActivity.this.searching;
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onPageScrolled(float f) {
            if (f != 1.0f || DialogsActivity.this.viewPages[1].getVisibility() == 0 || DialogsActivity.this.searching) {
                if (DialogsActivity.this.animatingForward) {
                    DialogsActivity.this.viewPages[0].setTranslationX((-f) * DialogsActivity.this.viewPages[0].getMeasuredWidth());
                    DialogsActivity.this.viewPages[1].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() - (DialogsActivity.this.viewPages[0].getMeasuredWidth() * f));
                } else {
                    DialogsActivity.this.viewPages[0].setTranslationX(DialogsActivity.this.viewPages[0].getMeasuredWidth() * f);
                    DialogsActivity.this.viewPages[1].setTranslationX((DialogsActivity.this.viewPages[0].getMeasuredWidth() * f) - DialogsActivity.this.viewPages[0].getMeasuredWidth());
                }
                if (f == 1.0f) {
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

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public int getTabCounter(int i) {
            if (i == Integer.MAX_VALUE) {
                if (DialogsActivity.this.getAccountInstance().getCoreMainClass().isAccountLoggedIn()) {
                    return DialogsActivity.this.getAccountInstance().getCoreMainClass().getFolderUnreadCount(BuildConfig.FLAVOR);
                }
                return 0;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = DialogsActivity.this.getMessagesController().dialogFilters;
            if (i < 0 || i >= arrayList.size()) {
                return 0;
            }
            return DialogsActivity.this.getMessagesController().dialogFilters.get(i).unreadCount;
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public boolean didSelectTab(FilterTabsView.TabView tabView, boolean z) {
            ScrollView scrollView;
            if (((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                return false;
            }
            if (DialogsActivity.this.scrimPopupWindow != null) {
                DialogsActivity.this.scrimPopupWindow.dismiss();
                DialogsActivity.this.scrimPopupWindow = null;
                DialogsActivity.this.scrimPopupWindowItems = null;
                return false;
            }
            final Rect rect = new Rect();
            final MessagesController.DialogFilter dialogFilter = tabView.getId() != Integer.MAX_VALUE ? DialogsActivity.this.getMessagesController().dialogFilters.get(tabView.getId()) : null;
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(DialogsActivity.this.getParentActivity());
            actionBarPopupWindowLayout.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.DialogsActivity.6.1
                private int[] pos = new int[2];

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getActionMasked() == 0) {
                        if (DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing()) {
                            View contentView = DialogsActivity.this.scrimPopupWindow.getContentView();
                            contentView.getLocationInWindow(this.pos);
                            Rect rect2 = rect;
                            int[] iArr = this.pos;
                            rect2.set(iArr[0], iArr[1], iArr[0] + contentView.getMeasuredWidth(), this.pos[1] + contentView.getMeasuredHeight());
                            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                                DialogsActivity.this.scrimPopupWindow.dismiss();
                            }
                        }
                    } else if (motionEvent.getActionMasked() == 4 && DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing()) {
                        DialogsActivity.this.scrimPopupWindow.dismiss();
                    }
                    return false;
                }
            });
            actionBarPopupWindowLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: org.rbmain.ui.DialogsActivity$6$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.f$0.lambda$didSelectTab$3(keyEvent);
                }
            });
            Rect rect2 = new Rect();
            Drawable drawableMutate = DialogsActivity.this.getParentActivity().getResources().getDrawable(R.drawable.popup_fixed_alert).mutate();
            drawableMutate.getPadding(rect2);
            actionBarPopupWindowLayout.setBackgroundDrawable(drawableMutate);
            actionBarPopupWindowLayout.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
            final LinearLayout linearLayout = new LinearLayout(DialogsActivity.this.getParentActivity());
            if (Build.VERSION.SDK_INT >= 21) {
                scrollView = new ScrollView(this, DialogsActivity.this.getParentActivity(), null, 0, R.style.scrollbarShapeStyle) { // from class: org.rbmain.ui.DialogsActivity.6.2
                    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i, int i2) {
                        super.onMeasure(i, i2);
                        setMeasuredDimension(linearLayout.getMeasuredWidth(), getMeasuredHeight());
                    }
                };
            } else {
                scrollView = new ScrollView(DialogsActivity.this.getParentActivity());
            }
            scrollView.setClipToPadding(false);
            int i = -2;
            actionBarPopupWindowLayout.addView(scrollView, LayoutHelper.createFrame(-2, -2.0f));
            linearLayout.setMinimumWidth(AndroidUtilities.dp(200.0f));
            linearLayout.setOrientation(1);
            DialogsActivity.this.scrimPopupWindowItems = new ActionBarMenuSubItem[3];
            final int i2 = tabView.getId() == Integer.MAX_VALUE ? 2 : 3;
            final int i3 = 0;
            while (i3 < i2) {
                ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(DialogsActivity.this.getParentActivity(), i3 == 0, i3 == i2 + (-1));
                if (i3 == 0) {
                    if (DialogsActivity.this.getMessagesController().dialogFilters.size() <= 1) {
                        i3++;
                    } else {
                        actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("FilterReorder", R.string.FilterReorder), R.drawable.tabs_reorder);
                    }
                } else if (i3 != 1) {
                    actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("FilterDeleteItem", R.string.FilterDeleteItem), R.drawable.msg_delete);
                } else if (i2 == 2) {
                    actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("FilterEditAll", R.string.FilterEditAll), R.drawable.msg_edit);
                } else {
                    actionBarMenuSubItem.setTextAndIcon(LocaleController.getString("FilterEdit", R.string.FilterEdit), R.drawable.msg_edit);
                }
                DialogsActivity.this.scrimPopupWindowItems[i3] = actionBarMenuSubItem;
                linearLayout.addView(actionBarMenuSubItem);
                actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$6$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$didSelectTab$4(i3, i2, dialogFilter, view);
                    }
                });
                i3++;
            }
            scrollView.addView(linearLayout, LayoutHelper.createScroll(-2, -2, 51));
            DialogsActivity.this.scrimPopupWindow = new ActionBarPopupWindow(actionBarPopupWindowLayout, i, i) { // from class: org.rbmain.ui.DialogsActivity.6.3
                @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
                public void dismiss() {
                    super.dismiss();
                    if (DialogsActivity.this.scrimPopupWindow != this) {
                        return;
                    }
                    DialogsActivity.this.scrimPopupWindow = null;
                    DialogsActivity.this.scrimPopupWindowItems = null;
                    if (DialogsActivity.this.scrimAnimatorSet != null) {
                        DialogsActivity.this.scrimAnimatorSet.cancel();
                        DialogsActivity.this.scrimAnimatorSet = null;
                    }
                    DialogsActivity.this.scrimAnimatorSet = new AnimatorSet();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(ObjectAnimator.ofInt(DialogsActivity.this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0));
                    DialogsActivity.this.scrimAnimatorSet.playTogether(arrayList);
                    DialogsActivity.this.scrimAnimatorSet.setDuration(220L);
                    DialogsActivity.this.scrimAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.6.3.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (DialogsActivity.this.scrimView != null) {
                                DialogsActivity.this.scrimView.setBackground(null);
                                DialogsActivity.this.scrimView = null;
                            }
                            View view = DialogsActivity.this.fragmentView;
                            if (view != null) {
                                view.invalidate();
                            }
                        }
                    });
                    DialogsActivity.this.scrimAnimatorSet.start();
                    if (Build.VERSION.SDK_INT >= 19) {
                        DialogsActivity.this.getParentActivity().getWindow().getDecorView().setImportantForAccessibility(0);
                    }
                }
            };
            tabView.setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_actionBarDefault)));
            DialogsActivity.this.scrimPopupWindow.setDismissAnimationDuration(220);
            DialogsActivity.this.scrimPopupWindow.setOutsideTouchable(true);
            DialogsActivity.this.scrimPopupWindow.setClippingEnabled(true);
            DialogsActivity.this.scrimPopupWindow.setAnimationStyle(R.style.PopupContextAnimation);
            DialogsActivity.this.scrimPopupWindow.setFocusable(true);
            actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
            DialogsActivity.this.scrimPopupWindow.setInputMethodMode(2);
            DialogsActivity.this.scrimPopupWindow.setSoftInputMode(0);
            DialogsActivity.this.scrimPopupWindow.getContentView().setFocusableInTouchMode(true);
            tabView.getLocationInWindow(DialogsActivity.this.scrimViewLocation);
            int iDp = (DialogsActivity.this.scrimViewLocation[0] + rect2.left) - AndroidUtilities.dp(16.0f);
            if (iDp < AndroidUtilities.dp(6.0f)) {
                iDp = AndroidUtilities.dp(6.0f);
            } else if (iDp > (DialogsActivity.this.fragmentView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - actionBarPopupWindowLayout.getMeasuredWidth()) {
                iDp = (DialogsActivity.this.fragmentView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - actionBarPopupWindowLayout.getMeasuredWidth();
            }
            DialogsActivity.this.scrimPopupWindow.showAtLocation(DialogsActivity.this.fragmentView, 51, iDp, (DialogsActivity.this.scrimViewLocation[1] + tabView.getMeasuredHeight()) - AndroidUtilities.dp(12.0f));
            DialogsActivity.this.scrimViewSelected = z;
            DialogsActivity.this.fragmentView.invalidate();
            if (DialogsActivity.this.scrimAnimatorSet != null) {
                DialogsActivity.this.scrimAnimatorSet.cancel();
            }
            DialogsActivity.this.scrimAnimatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofInt(DialogsActivity.this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0, 50));
            DialogsActivity.this.scrimAnimatorSet.playTogether(arrayList);
            DialogsActivity.this.scrimAnimatorSet.setDuration(150L);
            DialogsActivity.this.scrimAnimatorSet.start();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didSelectTab$3(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing()) {
                DialogsActivity.this.scrimPopupWindow.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didSelectTab$4(int i, int i2, MessagesController.DialogFilter dialogFilter, View view) {
            if (i == 0) {
                DialogsActivity.this.resetScroll();
                DialogsActivity.this.filterTabsView.setIsEditing(true);
                DialogsActivity.this.showDoneItem(true);
            } else if (i == 1) {
                if (i2 == 2) {
                    DialogsActivity.this.presentFragment(new FiltersSetupActivity());
                } else {
                    DialogsActivity.this.presentFragment(new FilterCreateActivity(dialogFilter));
                }
            } else if (i == 2) {
                showDeleteAlert(dialogFilter);
            }
            if (DialogsActivity.this.scrimPopupWindow != null) {
                DialogsActivity.this.scrimPopupWindow.dismiss();
            }
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public boolean isTabMenuVisible() {
            return DialogsActivity.this.scrimPopupWindow != null && DialogsActivity.this.scrimPopupWindow.isShowing();
        }

        @Override // org.rbmain.ui.Components.FilterTabsView.FilterTabsViewDelegate
        public void onDeletePressed(int i) {
            showDeleteAlert(DialogsActivity.this.getMessagesController().dialogFilters.get(i));
        }
    }

    /* renamed from: org.rbmain.ui.DialogsActivity$9, reason: invalid class name */
    class AnonymousClass9 extends LinearLayoutManager {
        private boolean fixOffset;
        final /* synthetic */ ViewPage val$viewPage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Context context, ViewPage viewPage) {
            super(context);
            this.val$viewPage = viewPage;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void scrollToPositionWithOffset(int i, int i2) {
            if (this.fixOffset) {
                i2 -= this.val$viewPage.listView.getPaddingTop();
            }
            super.scrollToPositionWithOffset(i, i2);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
        public void prepareForDrop(View view, View view2, int i, int i2) {
            this.fixOffset = true;
            super.prepareForDrop(view, view2, i, i2);
            this.fixOffset = false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            if (DialogsActivity.this.hasHiddenArchive() && i == 1) {
                super.smoothScrollToPosition(recyclerView, state, i);
                return;
            }
            LinearSmoothScrollerCustom linearSmoothScrollerCustom = new LinearSmoothScrollerCustom(recyclerView.getContext(), 0);
            linearSmoothScrollerCustom.setTargetPosition(i);
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
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.AnonymousClass9.scrollVerticallyBy(int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):int");
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$9$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DialogsActivity.AnonymousClass9.lambda$onLayoutChildren$0(viewPage);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onLayoutChildren$0(ViewPage viewPage) {
            viewPage.dialogsAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(ViewPage viewPage, View view, int i) {
        int i2 = this.initialDialogsType;
        if (i2 == 10) {
            onItemLongClick(view, i, 0.0f, 0.0f, viewPage.dialogsType, viewPage.dialogsAdapter);
            return;
        }
        if ((i2 != 11 && i2 != 13) || i != 1) {
            onItemClick(view, i, viewPage.dialogsAdapter);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("forImport", true);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(getUserConfig().getClientUserId()));
        bundle.putIntegerArrayList("result", arrayList);
        bundle.putInt("chatType", 4);
        String string = this.arguments.getString("importTitle");
        if (string != null) {
            bundle.putString("title", string);
        }
        GroupCreateFinalActivity groupCreateFinalActivity = new GroupCreateFinalActivity(bundle);
        groupCreateFinalActivity.setDelegate(new GroupCreateFinalActivity.GroupCreateFinalActivityDelegate() { // from class: org.rbmain.ui.DialogsActivity.10
            @Override // org.rbmain.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didFailChatCreation() {
            }

            @Override // org.rbmain.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didStartChatCreation() {
            }

            @Override // org.rbmain.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
            public void didFinishChatCreation(GroupCreateFinalActivity groupCreateFinalActivity2, int i3) {
                ArrayList<Long> arrayList2 = new ArrayList<>();
                arrayList2.add(Long.valueOf(-i3));
                DialogsActivityDelegate dialogsActivityDelegate = DialogsActivity.this.delegate;
                DialogsActivity.this.removeSelfFromStack();
                dialogsActivityDelegate.didSelectDialogs(DialogsActivity.this, arrayList2, null, true);
            }
        });
        presentFragment(groupCreateFinalActivity);
    }

    /* renamed from: org.rbmain.ui.DialogsActivity$16, reason: invalid class name */
    class AnonymousClass16 implements DialogsSearchAdapter.DialogsSearchAdapterDelegate {
        AnonymousClass16() {
        }

        @Override // org.rbmain.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void searchStateChanged(boolean z, boolean z2) {
            if (DialogsActivity.this.searchViewPager.emptyView.getVisibility() == 0) {
                z2 = true;
            }
            if (DialogsActivity.this.searching && DialogsActivity.this.searchWas && DialogsActivity.this.searchViewPager.emptyView != null) {
                if (z || DialogsActivity.this.searchViewPager.dialogsSearchAdapter.getItemCount() != 0) {
                    DialogsActivity.this.searchViewPager.emptyView.showProgress(true, z2);
                } else {
                    DialogsActivity.this.searchViewPager.emptyView.showProgress(false, z2);
                }
            }
            if (z && DialogsActivity.this.searchViewPager.dialogsSearchAdapter.getItemCount() == 0) {
                DialogsActivity.this.searchViewPager.cancelEnterAnimation();
            }
        }

        @Override // org.rbmain.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void didPressedOnSubDialog(long j) {
            if (DialogsActivity.this.onlySelect) {
                if (DialogsActivity.this.validateSlowModeDialog(j)) {
                    if (DialogsActivity.this.selectedDialogs.isEmpty()) {
                        DialogsActivity.this.didSelectResult(j, true, false);
                        return;
                    }
                    DialogsActivity.this.findAndUpdateCheckBox(j, DialogsActivity.this.addOrRemoveSelectedDialog(j, null));
                    DialogsActivity.this.updateSelectedCount();
                    ((BaseFragment) DialogsActivity.this).actionBar.closeSearchField();
                    return;
                }
                return;
            }
            int i = (int) j;
            Bundle bundle = new Bundle();
            if (i > 0) {
                bundle.putInt("user_id", i);
            } else {
                bundle.putInt("chat_id", -i);
            }
            DialogsActivity.this.closeSearch();
            if (AndroidUtilities.isTablet() && DialogsActivity.this.viewPages != null) {
                for (int i2 = 0; i2 < DialogsActivity.this.viewPages.length; i2++) {
                    DialogsActivity.this.viewPages[i2].dialogsAdapter.setOpenedDialogId(DialogsActivity.this.openedDialogId = j);
                }
                DialogsActivity.this.updateVisibleRows(512);
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

        @Override // org.rbmain.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void needRemoveHint(final int i) {
            TLRPC$User user;
            if (DialogsActivity.this.getParentActivity() == null || (user = DialogsActivity.this.getMessagesController().getUser(Integer.valueOf(i))) == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("ChatHintsDeleteAlertTitle", R.string.ChatHintsDeleteAlertTitle));
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("ChatHintsDeleteAlert", R.string.ChatHintsDeleteAlert, ContactsController.formatName(user.first_name, user.last_name))));
            builder.setPositiveButton(LocaleController.getString("StickersRemove", R.string.StickersRemove), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$16$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$needRemoveHint$0(i, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$needRemoveHint$0(int i, DialogInterface dialogInterface, int i2) {
            DialogsActivity.this.getMediaDataController().removePeer(i);
        }

        @Override // org.rbmain.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void needClearList() {
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("ClearSearchAlertTitle", R.string.ClearSearchAlertTitle));
            builder.setMessage(LocaleController.getString("ClearSearchAlert", R.string.ClearSearchAlert));
            builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$16$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$needClearList$1(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            DialogsActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$needClearList$1(DialogInterface dialogInterface, int i) {
            if (DialogsActivity.this.searchViewPager.dialogsSearchAdapter.isRecentSearchDisplayed()) {
                DialogsActivity.this.searchViewPager.dialogsSearchAdapter.clearRecentSearch();
            } else {
                DialogsActivity.this.searchViewPager.dialogsSearchAdapter.clearRecentHashtags();
            }
        }

        @Override // org.rbmain.ui.Adapters.DialogsSearchAdapter.DialogsSearchAdapterDelegate
        public void runResultsEnterAnimation() {
            if (DialogsActivity.this.searchViewPager != null) {
                DialogsActivity.this.searchViewPager.runResultsEnterAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(View view, int i) {
        if (this.initialDialogsType == 10) {
            onItemLongClick(view, i, 0.0f, 0.0f, -1, this.searchViewPager.dialogsSearchAdapter);
        } else {
            onItemClick(view, i, this.searchViewPager.dialogsSearchAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(boolean z, ArrayList arrayList, ArrayList arrayList2) {
        updateFiltersView(z, arrayList, arrayList2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(View view, int i) {
        this.filtersView.cancelClickRunnables(true);
        addSearchFilter(this.filtersView.getFilterAt(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(View view) {
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

    /* renamed from: org.rbmain.ui.DialogsActivity$21, reason: invalid class name */
    class AnonymousClass21 extends UndoView {
        AnonymousClass21(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (this != DialogsActivity.this.undoView[0] || DialogsActivity.this.undoView[1].getVisibility() == 0) {
                return;
            }
            DialogsActivity.this.additionalFloatingTranslation = (getMeasuredHeight() + AndroidUtilities.dp(8.0f)) - f;
            if (DialogsActivity.this.additionalFloatingTranslation < 0.0f) {
                DialogsActivity.this.additionalFloatingTranslation = 0.0f;
            }
            if (DialogsActivity.this.floatingHidden) {
                return;
            }
            DialogsActivity.this.updateFloatingButtonOffset();
        }

        @Override // org.rbmain.ui.Components.UndoView
        protected boolean canUndo() {
            for (int i = 0; i < DialogsActivity.this.viewPages.length; i++) {
                if (DialogsActivity.this.viewPages[i].dialogsItemAnimator.isRunning()) {
                    return false;
                }
            }
            return true;
        }

        @Override // org.rbmain.ui.Components.UndoView
        protected void onRemoveDialogAction(long j, int i) {
            if (i == 1) {
                DialogsActivity.this.debugLastUpdateAction = 1;
                DialogsActivity.this.setDialogsListFrozen(true);
                if (DialogsActivity.this.frozenDialogsList != null) {
                    final int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= DialogsActivity.this.frozenDialogsList.size()) {
                            break;
                        }
                        if (((TLRPC$Dialog) DialogsActivity.this.frozenDialogsList.get(i3)).id == j) {
                            i2 = i3;
                            break;
                        }
                        i3++;
                    }
                    if (i2 >= 0) {
                        final TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) DialogsActivity.this.frozenDialogsList.remove(i2);
                        DialogsActivity.this.viewPages[0].dialogsAdapter.notifyDataSetChanged();
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$21$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onRemoveDialogAction$0(i2, tLRPC$Dialog);
                            }
                        });
                        return;
                    }
                    DialogsActivity.this.setDialogsListFrozen(false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRemoveDialogAction$0(int i, TLRPC$Dialog tLRPC$Dialog) {
            if (DialogsActivity.this.frozenDialogsList == null || i < 0 || i >= DialogsActivity.this.frozenDialogsList.size()) {
                return;
            }
            DialogsActivity.this.frozenDialogsList.add(i, tLRPC$Dialog);
            DialogsActivity.this.viewPages[0].dialogsAdapter.notifyItemInserted(i);
            DialogsActivity.this.dialogInsertFinished = 2;
        }
    }

    private View addClearDatabase(final boolean z) {
        Button button = new Button(getParentActivity());
        if (z) {
            button.setText("link");
        } else {
            button.setText("DON'T");
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$addClearDatabase$13(z, view);
            }
        });
        button.setGravity(8388613);
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addClearDatabase$13(boolean z, View view) {
        if (z) {
            Link link = new Link();
            link.type = Link.LinkTypeEnum.cardpage;
            CardPageLinkData cardPageLinkData = new CardPageLinkData();
            link.cardpage_data = cardPageLinkData;
            cardPageLinkData.tag = "tstMain";
            cardPageLinkData.title = "تست";
            new MainClickHandler().onLinkClick(link);
            return;
        }
        getAccountInstance().getCoreMainClass().clearDataBaseAndStorageForDebug();
        IdStorage.getInstance().clear();
        MessagesController.getInstance(this.currentAccount).clearQueryTime();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addClearDatabase$10();
            }
        });
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                DialogsActivity.lambda$addClearDatabase$12();
            }
        });
        ApplicationLoader.applicationActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e3 A[Catch: all -> 0x023d, Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:3:0x0004, B:4:0x001c, B:6:0x0023, B:9:0x0031, B:10:0x0039, B:11:0x004c, B:13:0x0052, B:15:0x0076, B:17:0x007c, B:47:0x01fd, B:20:0x0087, B:22:0x00a4, B:39:0x0117, B:40:0x011a, B:42:0x01e3, B:46:0x01fa, B:48:0x0205), top: B:60:0x0004, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f3  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$addClearDatabase$10() {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.lambda$addClearDatabase$10():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addClearDatabase$9() {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didClearDatabase, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$addClearDatabase$12() {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            r4 = 7
            if (r2 >= r4) goto L52
            r3 = -1
            r4 = 100
            r5 = 3
            r6 = 2
            r7 = 4
            if (r2 != 0) goto L12
            r3 = 0
        L10:
            r6 = 0
            goto L2e
        L12:
            if (r2 != r0) goto L16
            r3 = 2
            goto L10
        L16:
            if (r2 != r6) goto L1b
            r3 = 3
            r6 = 1
            goto L2e
        L1b:
            if (r2 != r5) goto L1f
            r3 = 3
            goto L2e
        L1f:
            if (r2 != r7) goto L23
            r3 = 1
            goto L10
        L23:
            r5 = 5
            if (r2 != r5) goto L29
            r3 = 100
            goto L10
        L29:
            r5 = 6
            if (r2 != r5) goto L10
            r3 = 4
            goto L10
        L2e:
            if (r3 != r4) goto L3c
            java.io.File r4 = new java.io.File
            java.io.File r5 = org.rbmain.messenger.FileLoader.checkDirectory(r7)
            java.lang.String r8 = "acache"
            r4.<init>(r5, r8)
            goto L40
        L3c:
            java.io.File r4 = org.rbmain.messenger.FileLoader.checkDirectory(r3)
        L40:
            if (r4 == 0) goto L4e
            java.lang.String r4 = r4.getAbsolutePath()
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            org.rbmain.messenger.Utilities.clearDir(r4, r6, r8, r1)
        L4e:
            int r2 = r2 + 1
            r3 = 1
            goto L4
        L52:
            org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda38 r0 = new org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda38
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.lambda$addClearDatabase$12():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addClearDatabase$11(boolean z) {
        if (z) {
            ImageLoader.getInstance().clearMemory();
        }
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
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateFiltersView(boolean r10, java.util.ArrayList<java.lang.Object> r11, java.util.ArrayList<org.rbmain.ui.Adapters.FiltersView.DateData> r12, boolean r13) {
        /*
            r9 = this;
            boolean r0 = r9.searchIsShowed
            if (r0 == 0) goto Laa
            boolean r0 = r9.onlySelect
            if (r0 == 0) goto La
            goto Laa
        La:
            org.rbmain.ui.Components.SearchViewPager r0 = r9.searchViewPager
            java.util.ArrayList r0 = r0.getCurrentSearchFilters()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L15:
            int r6 = r0.size()
            r7 = 1
            if (r2 >= r6) goto L46
            java.lang.Object r6 = r0.get(r2)
            org.rbmain.ui.Adapters.FiltersView$MediaFilterData r6 = (org.rbmain.ui.Adapters.FiltersView.MediaFilterData) r6
            boolean r6 = r6.isMedia()
            if (r6 == 0) goto L2a
            r3 = 1
            goto L43
        L2a:
            java.lang.Object r6 = r0.get(r2)
            org.rbmain.ui.Adapters.FiltersView$MediaFilterData r6 = (org.rbmain.ui.Adapters.FiltersView.MediaFilterData) r6
            int r6 = r6.filterType
            r8 = 4
            if (r6 != r8) goto L37
            r4 = 1
            goto L43
        L37:
            java.lang.Object r6 = r0.get(r2)
            org.rbmain.ui.Adapters.FiltersView$MediaFilterData r6 = (org.rbmain.ui.Adapters.FiltersView.MediaFilterData) r6
            int r6 = r6.filterType
            r8 = 6
            if (r6 != r8) goto L43
            r5 = 1
        L43:
            int r2 = r2 + 1
            goto L15
        L46:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L56
        L4e:
            if (r12 == 0) goto L58
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L58
        L56:
            r0 = 1
            goto L59
        L58:
            r0 = 0
        L59:
            r2 = 0
            if (r3 != 0) goto L61
            if (r0 != 0) goto L61
            if (r10 == 0) goto L61
            goto L86
        L61:
            if (r0 == 0) goto L86
            if (r11 == 0) goto L6e
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L6e
            if (r4 != 0) goto L6e
            goto L6f
        L6e:
            r11 = r2
        L6f:
            if (r12 == 0) goto L7a
            boolean r10 = r12.isEmpty()
            if (r10 != 0) goto L7a
            if (r5 != 0) goto L7a
            goto L7b
        L7a:
            r12 = r2
        L7b:
            if (r11 != 0) goto L7f
            if (r12 == 0) goto L86
        L7f:
            org.rbmain.ui.Adapters.FiltersView r10 = r9.filtersView
            r10.setUsersAndDates(r11, r12, r1)
            r10 = 1
            goto L87
        L86:
            r10 = 0
        L87:
            if (r10 != 0) goto L8e
            org.rbmain.ui.Adapters.FiltersView r11 = r9.filtersView
            r11.setUsersAndDates(r2, r2, r1)
        L8e:
            if (r13 != 0) goto L99
            org.rbmain.ui.Adapters.FiltersView r11 = r9.filtersView
            androidx.recyclerview.widget.RecyclerView$Adapter r11 = r11.getAdapter()
            r11.notifyDataSetChanged()
        L99:
            org.rbmain.ui.Components.ViewPagerFixed$TabsView r11 = r9.searchTabsView
            if (r11 == 0) goto La0
            r11.hide(r10, r7)
        La0:
            org.rbmain.ui.Adapters.FiltersView r11 = r9.filtersView
            r11.setEnabled(r10)
            org.rbmain.ui.Adapters.FiltersView r10 = r9.filtersView
            r10.setVisibility(r1)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.updateFiltersView(boolean, java.util.ArrayList, java.util.ArrayList, boolean):void");
    }

    private void addSearchFilter(FiltersView.MediaFilterData mediaFilterData) {
        if (this.searchIsShowed) {
            ArrayList<FiltersView.MediaFilterData> currentSearchFilters = this.searchViewPager.getCurrentSearchFilters();
            if (!currentSearchFilters.isEmpty()) {
                for (int i = 0; i < currentSearchFilters.size(); i++) {
                    if (mediaFilterData.isSameType(currentSearchFilters.get(i))) {
                        return;
                    }
                }
            }
            currentSearchFilters.add(mediaFilterData);
            this.actionBar.setSearchFilter(mediaFilterData);
            this.actionBar.setSearchFieldText(BuildConfig.FLAVOR);
            updateFiltersView(true, null, null, true);
        }
    }

    private void createActionMode() {
        if (this.actionBar.actionModeIsExist(null)) {
            return;
        }
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode();
        actionBarMenuCreateActionMode.setBackground(null);
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedDialogsCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedDialogsCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedDialogsCountTextView.setTextColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon));
        actionBarMenuCreateActionMode.addView(this.selectedDialogsCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedDialogsCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DialogsActivity.lambda$createActionMode$14(view, motionEvent);
            }
        });
        this.pinItem = actionBarMenuCreateActionMode.addItemWithWidth(100, R.drawable.msg_pin, AndroidUtilities.dp(54.0f));
        this.muteItem = actionBarMenuCreateActionMode.addItemWithWidth(104, R.drawable.msg_mute, AndroidUtilities.dp(54.0f));
        this.deleteItem = actionBarMenuCreateActionMode.addItemWithWidth(102, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete));
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = actionBarMenuCreateActionMode.addItemWithWidth(0, R.drawable.ic_ab_other, AndroidUtilities.dp(54.0f), LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.pin2Item = actionBarMenuItemAddItemWithWidth.addSubItem(108, R.drawable.msg_pin, LocaleController.getString("DialogPin", R.string.DialogPin));
        this.addToFolderItem = actionBarMenuItemAddItemWithWidth.addSubItem(109, R.drawable.msg_addfolder, LocaleController.getString("FilterAddTo", R.string.FilterAddTo));
        this.removeFromFolderItem = actionBarMenuItemAddItemWithWidth.addSubItem(110, R.drawable.msg_removefolder, LocaleController.getString("FilterRemoveFrom", R.string.FilterRemoveFrom));
        this.readItem = actionBarMenuItemAddItemWithWidth.addSubItem(101, R.drawable.msg_markread, LocaleController.getString("MarkAsRead", R.string.MarkAsRead));
        this.clearItem = actionBarMenuItemAddItemWithWidth.addSubItem(103, R.drawable.msg_clear, LocaleController.getString("ClearHistory", R.string.ClearHistory));
        this.blockItem = actionBarMenuItemAddItemWithWidth.addSubItem(106, R.drawable.msg_block, LocaleController.getString("BlockUser", R.string.BlockUser));
        this.actionModeViews.add(this.pinItem);
        this.actionModeViews.add(this.muteItem);
        this.actionModeViews.add(this.deleteItem);
        this.actionModeViews.add(actionBarMenuItemAddItemWithWidth);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass23());
    }

    /* renamed from: org.rbmain.ui.DialogsActivity$23, reason: invalid class name */
    class AnonymousClass23 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass23() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == 201 || (i == 200 && DialogsActivity.this.searchViewPager != null)) {
                DialogsActivity.this.searchViewPager.onActionBarItemClick(i);
                return;
            }
            if (i == -1) {
                if (DialogsActivity.this.filterTabsView == null || !DialogsActivity.this.filterTabsView.isEditing()) {
                    if (((BaseFragment) DialogsActivity.this).actionBar.isActionModeShowed()) {
                        if (DialogsActivity.this.searchViewPager == null || DialogsActivity.this.searchViewPager.getVisibility() != 0) {
                            DialogsActivity.this.hideActionMode(true);
                            return;
                        } else {
                            DialogsActivity.this.searchViewPager.hideActionMode();
                            return;
                        }
                    }
                    if (!DialogsActivity.this.onlySelect && DialogsActivity.this.folderId == 0) {
                        ActionBarLayout unused = ((BaseFragment) DialogsActivity.this).parentLayout;
                        return;
                    } else {
                        DialogsActivity.this.finishFragment();
                        return;
                    }
                }
                DialogsActivity.this.filterTabsView.setIsEditing(false);
                DialogsActivity.this.showDoneItem(false);
                return;
            }
            if (i == 1) {
                SharedConfig.appLocked = !SharedConfig.appLocked;
                SharedConfig.saveConfig();
                DialogsActivity.this.updatePasscodeButton(true);
                return;
            }
            if (i == 2) {
                DialogsActivity.this.presentFragment(new ProxyListActivity());
                return;
            }
            if (i >= 10 && i < 13) {
                if (DialogsActivity.this.getParentActivity() == null) {
                    return;
                }
                DialogsActivityDelegate dialogsActivityDelegate = DialogsActivity.this.delegate;
                LaunchActivity launchActivity = (LaunchActivity) DialogsActivity.this.getParentActivity();
                launchActivity.switchToAccount(i - 10, true);
                DialogsActivity dialogsActivity = new DialogsActivity(((BaseFragment) DialogsActivity.this).arguments);
                dialogsActivity.setDelegate(dialogsActivityDelegate);
                launchActivity.presentFragment(dialogsActivity, false, true);
                return;
            }
            if (i == 109) {
                DialogsActivity dialogsActivity2 = DialogsActivity.this;
                FiltersListBottomSheet filtersListBottomSheet = new FiltersListBottomSheet(dialogsActivity2, dialogsActivity2.selectedDialogs);
                filtersListBottomSheet.setDelegate(new FiltersListBottomSheet.FiltersListBottomSheetDelegate() { // from class: org.rbmain.ui.DialogsActivity$23$$ExternalSyntheticLambda0
                    @Override // org.rbmain.ui.Components.FiltersListBottomSheet.FiltersListBottomSheetDelegate
                    public final void didSelectFilter(MessagesController.DialogFilter dialogFilter) {
                        this.f$0.lambda$onItemClick$0(dialogFilter);
                    }
                });
                DialogsActivity.this.showDialog(filtersListBottomSheet);
                return;
            }
            if (i != 110) {
                if (i == 100 || i == 101 || i == 102 || i == 103 || i == 104 || i == 105 || i == 106 || i == 107 || i == 108) {
                    DialogsActivity dialogsActivity3 = DialogsActivity.this;
                    dialogsActivity3.perfromSelectedDialogsAction(dialogsActivity3.selectedDialogs, i, true);
                    return;
                }
                return;
            }
            MessagesController.DialogFilter dialogFilter = DialogsActivity.this.getMessagesController().dialogFilters.get(DialogsActivity.this.viewPages[0].selectedType);
            DialogsActivity dialogsActivity4 = DialogsActivity.this;
            ArrayList<Integer> dialogsCount = FiltersListBottomSheet.getDialogsCount(dialogsActivity4, dialogFilter, dialogsActivity4.selectedDialogs, false, false);
            if ((dialogFilter != null ? dialogFilter.neverShow.size() : 0) + dialogsCount.size() > 100) {
                DialogsActivity dialogsActivity5 = DialogsActivity.this;
                dialogsActivity5.showDialog(AlertsCreator.createSimpleAlert(dialogsActivity5.getParentActivity(), LocaleController.getString("FilterAddToAlertFullTitle", R.string.FilterAddToAlertFullTitle), LocaleController.getString("FilterAddToAlertFullText", R.string.FilterAddToAlertFullText)).create());
                return;
            }
            if (!dialogsCount.isEmpty()) {
                dialogFilter.neverShow.addAll(dialogsCount);
                for (int i2 = 0; i2 < dialogsCount.size(); i2++) {
                    dialogFilter.alwaysShow.remove(dialogsCount.get(i2));
                    dialogFilter.pinnedDialogs.remove(r6.intValue());
                }
                FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, false, false, true, false, false, DialogsActivity.this, null);
            }
            DialogsActivity.this.getUndoView().showWithAction(dialogsCount.size() == 1 ? dialogsCount.get(0).intValue() : 0L, 21, Integer.valueOf(dialogsCount.size()), dialogFilter, null, null);
            DialogsActivity.this.hideActionMode(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(MessagesController.DialogFilter dialogFilter) {
            ArrayList<Integer> arrayList;
            ArrayList<Integer> arrayList2;
            long jIntValue;
            DialogsActivity dialogsActivity = DialogsActivity.this;
            ArrayList<Integer> dialogsCount = FiltersListBottomSheet.getDialogsCount(dialogsActivity, dialogFilter, dialogsActivity.selectedDialogs, true, false);
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
                        jIntValue = arrayList2.get(0).intValue();
                    } else {
                        arrayList2 = arrayList;
                        jIntValue = 0;
                    }
                    DialogsActivity.this.getUndoView().showWithAction(jIntValue, 20, Integer.valueOf(arrayList2.size()), dialogFilter, null, null);
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
    public void showScrollbars(boolean z) {
        if (this.viewPages == null || this.scrollBarVisible == z) {
            return;
        }
        this.scrollBarVisible = z;
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                return;
            }
            if (z) {
                viewPageArr[i].listView.setScrollbarFadingEnabled(false);
            }
            this.viewPages[i].listView.setVerticalScrollBarEnabled(z);
            if (z) {
                this.viewPages[i].listView.setScrollbarFadingEnabled(true);
            }
            i++;
        }
    }

    private void updateFilterTabs(boolean z, boolean z2) {
        int iFindFirstVisibleItemPosition;
        boolean z3;
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
        boolean z4 = true;
        if (!arrayList.isEmpty()) {
            if (z || this.filterTabsView.getVisibility() != 0) {
                boolean z5 = this.filterTabsView.getVisibility() != 0 ? false : z2;
                this.canShowFilterTabsView = true;
                updateFilterTabsVisibility(z2);
                int currentTabId = this.filterTabsView.getCurrentTabId();
                if (currentTabId != Integer.MAX_VALUE && currentTabId >= arrayList.size()) {
                    this.filterTabsView.resetTabId();
                }
                this.filterTabsView.removeTabs();
                this.filterTabsView.addTab(ConnectionsManager.DEFAULT_DATACENTER_ID, 0, LocaleController.getString("FilterAllChats", R.string.FilterAllChats));
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.filterTabsView.addTab(i, arrayList.get(i).localId, arrayList.get(i).name);
                }
                int currentTabId2 = this.filterTabsView.getCurrentTabId();
                if (currentTabId2 < 0 || this.viewPages[0].selectedType == currentTabId2) {
                    z3 = false;
                } else {
                    this.viewPages[0].selectedType = currentTabId2;
                    z3 = true;
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
                this.filterTabsView.finishAddingTabs(z5);
                if (z3) {
                    switchToCurrentSelectedMode(false);
                }
                ActionBarLayout actionBarLayout = this.parentLayout;
                if (actionBarLayout != null) {
                    DrawerLayoutContainer drawerLayoutContainer = actionBarLayout.getDrawerLayoutContainer();
                    if (currentTabId2 != this.filterTabsView.getFirstTabId() && SharedConfig.getChatSwipeAction(this.currentAccount) == 4) {
                        z4 = false;
                    }
                    drawerLayoutContainer.setAllowOpenDrawerBySwipe(z4);
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
                    this.viewPages[1].setTranslationX(r9[0].getMeasuredWidth());
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
                updateFilterTabsVisibility(z2);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void finishFragment() {
        super.finishFragment();
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0147  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$15(int i) {
        this.askAboutContacts = i != 0;
        MessagesController.getGlobalNotificationsSettings().edit().putBoolean("askAboutContacts", this.askAboutContacts).apply();
        askForPermissons(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$16(DialogInterface dialogInterface, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onResume$17(DialogInterface dialogInterface, int i) {
        MessagesController.getGlobalNotificationsSettings().edit().putBoolean("askedAboutMiuiLockscreen", true).commit();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean presentFragment(BaseFragment baseFragment) {
        boolean zPresentFragment = super.presentFragment(baseFragment);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        getDialogsProxy().stopChatList();
        MyLog.e("Dialogs", "Stopped Update");
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        ChatActivityEnterView chatActivityEnterView = this.commentView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.onResume();
        }
        UndoView[] undoViewArr = this.undoView;
        int i = 0;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        Bulletin.removeDelegate(this);
        if (this.viewPages == null) {
            return;
        }
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                return;
            }
            viewPageArr[i].dialogsAdapter.pause();
            i++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            return false;
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null && actionBar.isSearchFieldVisible()) {
            this.actionBar.closeSearchField(true);
            return false;
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null && filterTabsView.isEditing()) {
            this.filterTabsView.setIsEditing(false);
            showDoneItem(false);
            return false;
        }
        ActionBar actionBar2 = this.actionBar;
        if (actionBar2 != null && actionBar2.isActionModeShowed()) {
            if (this.searchViewPager.getVisibility() == 0) {
                this.searchViewPager.hideActionMode();
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void setInPreviewMode(boolean z) {
        super.setInPreviewMode(z);
        if (z || this.avatarContainer == null) {
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

    public boolean addOrRemoveSelectedDialog(long j, View view) {
        if (this.selectedDialogs.contains(Long.valueOf(j))) {
            this.selectedDialogs.remove(Long.valueOf(j));
            if (view instanceof DialogCell) {
                ((DialogCell) view).setChecked(false, true);
            }
            return false;
        }
        this.selectedDialogs.add(Long.valueOf(j));
        if (view instanceof DialogCell) {
            ((DialogCell) view).setChecked(true, true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearch(final boolean z, boolean z2) {
        FilterTabsView filterTabsView;
        int i = this.initialDialogsType;
        if (i != 0 && i != 3) {
            z2 = false;
        }
        AnimatorSet animatorSet = this.searchAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.searchAnimator = null;
        }
        Animator animator = this.tabsAlphaAnimator;
        if (animator != null) {
            animator.cancel();
            this.tabsAlphaAnimator = null;
        }
        this.searchIsShowed = z;
        if (z) {
            if (!this.searchFiltersWasShowed) {
                onlyDialogsAdapter();
            }
            this.searchViewPager.showOnlyDialogsAdapter(true);
            this.whiteActionBar = false;
            ViewPagerFixed.TabsView tabsView = this.searchTabsView;
            if (tabsView != null) {
                ViewParent parent = tabsView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.searchTabsView);
                }
                this.searchTabsView = null;
            }
            EditTextBoldCursor searchField = this.searchItem.getSearchField();
            if (this.whiteActionBar) {
                searchField.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
                searchField.setHintTextColor(Theme.getColor(Theme.key_player_time));
                searchField.setCursorColor(Theme.getColor(Theme.key_chat_messagePanelCursor));
            } else {
                int i2 = Theme.key_actionBarDefaultSearch;
                searchField.setCursorColor(Theme.getColor(i2));
                searchField.setHintTextColor(Theme.getColor(Theme.key_actionBarDefaultSearchPlaceholder));
                searchField.setTextColor(Theme.getColor(i2));
            }
            this.searchViewPager.setKeyboardHeight(((ContentView) this.fragmentView).getKeyboardHeight());
            this.parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(true);
        } else if (this.filterTabsView != null) {
            this.parentLayout.getDrawerLayoutContainer().setAllowOpenDrawerBySwipe(this.viewPages[0].selectedType == this.filterTabsView.getFirstTabId() || SharedConfig.getChatSwipeAction(this.currentAccount) != 4);
        }
        if (z2 && this.searchViewPager.dialogsSearchAdapter.hasRecentSearch()) {
            AndroidUtilities.setAdjustResizeToNothing(getParentActivity(), this.classGuid);
        } else {
            AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        }
        if (!z && (filterTabsView = this.filterTabsView) != null && this.canShowFilterTabsView) {
            filterTabsView.setVisibility(0);
        }
        if (z2) {
            if (!z) {
                this.viewPages[0].listView.setVisibility(0);
                this.viewPages[0].setVisibility(0);
            } else {
                this.searchViewPager.setVisibility(0);
                this.searchViewPager.reset();
                updateFiltersView(true, null, null, false);
                ViewPagerFixed.TabsView tabsView2 = this.searchTabsView;
                if (tabsView2 != null) {
                    tabsView2.hide(false, false);
                    this.searchTabsView.setVisibility(0);
                }
            }
            setDialogsListFrozen(true);
            this.viewPages[0].listView.setVerticalScrollBarEnabled(false);
            SearchViewPager searchViewPager = this.searchViewPager;
            int i3 = Theme.key_windowBackgroundWhite;
            searchViewPager.setBackgroundColor(Theme.getColor(i3));
            this.searchAnimator = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            ViewPage viewPage = this.viewPages[0];
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(viewPage, (Property<ViewPage, Float>) property, fArr));
            ViewPage viewPage2 = this.viewPages[0];
            Property property2 = View.SCALE_X;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 0.9f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(viewPage2, (Property<ViewPage, Float>) property2, fArr2));
            ViewPage viewPage3 = this.viewPages[0];
            Property property3 = View.SCALE_Y;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 0.9f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(viewPage3, (Property<ViewPage, Float>) property3, fArr3));
            SearchViewPager searchViewPager2 = this.searchViewPager;
            Property property4 = View.ALPHA;
            float[] fArr4 = new float[1];
            fArr4[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(searchViewPager2, (Property<SearchViewPager, Float>) property4, fArr4));
            SearchViewPager searchViewPager3 = this.searchViewPager;
            Property property5 = View.SCALE_X;
            float[] fArr5 = new float[1];
            fArr5[0] = z ? 1.0f : 1.05f;
            arrayList.add(ObjectAnimator.ofFloat(searchViewPager3, (Property<SearchViewPager, Float>) property5, fArr5));
            SearchViewPager searchViewPager4 = this.searchViewPager;
            Property property6 = View.SCALE_Y;
            float[] fArr6 = new float[1];
            fArr6[0] = z ? 1.0f : 1.05f;
            arrayList.add(ObjectAnimator.ofFloat(searchViewPager4, (Property<SearchViewPager, Float>) property6, fArr6));
            ActionBarMenuItem actionBarMenuItem = this.passcodeItem;
            if (actionBarMenuItem != null) {
                RLottieImageView iconView = actionBarMenuItem.getIconView();
                Property property7 = View.ALPHA;
                float[] fArr7 = new float[1];
                fArr7[0] = z ? 0.0f : 1.0f;
                arrayList.add(ObjectAnimator.ofFloat(iconView, (Property<RLottieImageView, Float>) property7, fArr7));
            }
            FilterTabsView filterTabsView2 = this.filterTabsView;
            if (filterTabsView2 != null && filterTabsView2.getVisibility() == 0) {
                RecyclerListView tabsContainer = this.filterTabsView.getTabsContainer();
                Property property8 = View.ALPHA;
                float[] fArr8 = new float[1];
                fArr8[0] = z ? 0.0f : 1.0f;
                ObjectAnimator duration = ObjectAnimator.ofFloat(tabsContainer, (Property<RecyclerListView, Float>) property8, fArr8).setDuration(100L);
                this.tabsAlphaAnimator = duration;
                duration.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        DialogsActivity.this.tabsAlphaAnimator = null;
                    }
                });
            }
            float[] fArr9 = new float[2];
            fArr9[0] = this.searchAnimationProgress;
            fArr9[1] = z ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr9);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showSearch$18(valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat);
            this.searchAnimator.playTogether(arrayList);
            this.searchAnimator.setDuration(z ? 200L : 180L);
            this.searchAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            if (this.filterTabsViewIsVisible) {
                int color = Theme.getColor(this.folderId == 0 ? Theme.key_actionBarDefault : Theme.key_actionBarDefaultArchived);
                int color2 = Theme.getColor(i3);
                this.searchAnimationTabsDelayedCrossfade = ((float) ((Math.abs(Color.red(color) - Color.red(color2)) + Math.abs(Color.green(color) - Color.green(color2))) + Math.abs(Color.blue(color) - Color.blue(color2)))) / 255.0f > 0.3f;
            } else {
                this.searchAnimationTabsDelayedCrossfade = true;
            }
            if (!z) {
                this.searchAnimator.setStartDelay(20L);
                Animator animator2 = this.tabsAlphaAnimator;
                if (animator2 != null) {
                    if (this.searchAnimationTabsDelayedCrossfade) {
                        animator2.setStartDelay(80L);
                        this.tabsAlphaAnimator.setDuration(100L);
                    } else {
                        animator2.setDuration(z ? 200L : 180L);
                    }
                }
            }
            this.searchAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.26
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                    DialogsActivity.this.getNotificationCenter().onAnimationFinish(DialogsActivity.this.animationIndex);
                    if (DialogsActivity.this.searchAnimator != animator3) {
                        return;
                    }
                    DialogsActivity.this.setDialogsListFrozen(false);
                    if (!z) {
                        DialogsActivity.this.searchItem.collapseSearchFilters();
                        DialogsActivity.this.whiteActionBar = false;
                        DialogsActivity.this.searchViewPager.setVisibility(8);
                        if (DialogsActivity.this.searchTabsView != null) {
                            DialogsActivity.this.searchTabsView.setVisibility(8);
                        }
                        DialogsActivity.this.searchItem.clearSearchFilters();
                        DialogsActivity.this.searchViewPager.clear();
                        DialogsActivity.this.filtersView.setVisibility(8);
                        DialogsActivity.this.viewPages[0].listView.show();
                        if (!DialogsActivity.this.onlySelect) {
                            DialogsActivity.this.hideFloatingButton(false);
                        }
                        DialogsActivity.this.searchWasFullyShowed = false;
                    } else {
                        DialogsActivity.this.viewPages[0].listView.hide();
                        if (DialogsActivity.this.filterTabsView != null) {
                            DialogsActivity.this.filterTabsView.setVisibility(8);
                        }
                        DialogsActivity.this.searchWasFullyShowed = true;
                        AndroidUtilities.requestAdjustResize(DialogsActivity.this.getParentActivity(), ((BaseFragment) DialogsActivity.this).classGuid);
                        DialogsActivity.this.searchItem.setVisibility(8);
                    }
                    View view = DialogsActivity.this.fragmentView;
                    if (view != null) {
                        view.requestLayout();
                    }
                    DialogsActivity.this.setSearchAnimationProgress(z ? 1.0f : 0.0f);
                    DialogsActivity.this.viewPages[0].listView.setVerticalScrollBarEnabled(true);
                    DialogsActivity.this.searchViewPager.setBackground(null);
                    DialogsActivity.this.searchAnimator = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator3) {
                    DialogsActivity.this.getNotificationCenter().onAnimationFinish(DialogsActivity.this.animationIndex);
                    if (DialogsActivity.this.searchAnimator == animator3) {
                        if (z) {
                            DialogsActivity.this.viewPages[0].listView.hide();
                        } else {
                            DialogsActivity.this.viewPages[0].listView.show();
                        }
                        DialogsActivity.this.searchAnimator = null;
                    }
                }
            });
            this.animationIndex = getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
            this.searchAnimator.start();
            Animator animator3 = this.tabsAlphaAnimator;
            if (animator3 != null) {
                animator3.start();
            }
        } else {
            setDialogsListFrozen(false);
            if (z) {
                this.viewPages[0].listView.hide();
            } else {
                this.viewPages[0].listView.show();
            }
            this.viewPages[0].setAlpha(z ? 0.0f : 1.0f);
            this.viewPages[0].setScaleX(z ? 0.9f : 1.0f);
            this.viewPages[0].setScaleY(z ? 0.9f : 1.0f);
            this.searchViewPager.setAlpha(z ? 1.0f : 0.0f);
            this.filtersView.setAlpha(z ? 1.0f : 0.0f);
            this.searchViewPager.setScaleX(z ? 1.0f : 1.1f);
            this.searchViewPager.setScaleY(z ? 1.0f : 1.1f);
            FilterTabsView filterTabsView3 = this.filterTabsView;
            if (filterTabsView3 != null && filterTabsView3.getVisibility() == 0) {
                this.filterTabsView.setTranslationY(z ? -AndroidUtilities.dp(44.0f) : 0.0f);
                this.filterTabsView.getTabsContainer().setAlpha(z ? 0.0f : 1.0f);
            }
            FilterTabsView filterTabsView4 = this.filterTabsView;
            if (filterTabsView4 != null) {
                if (this.canShowFilterTabsView && !z) {
                    filterTabsView4.setVisibility(0);
                } else {
                    filterTabsView4.setVisibility(8);
                }
            }
            this.searchViewPager.setVisibility(z ? 0 : 8);
            setSearchAnimationProgress(z ? 1.0f : 0.0f);
            this.fragmentView.invalidate();
        }
        int i4 = this.initialSearchType;
        if (i4 >= 0) {
            this.searchViewPager.setPosition(i4);
        }
        if (z) {
            return;
        }
        this.initialSearchType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSearch$18(ValueAnimator valueAnimator) {
        setSearchAnimationProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public boolean onlyDialogsAdapter() {
        return this.onlySelect || !this.searchViewPager.dialogsSearchAdapter.hasRecentSearch() || getMessagesController().getTotalDialogsCount() <= 10;
    }

    private void updateFilterTabsVisibility(boolean z) {
        if (this.isPaused) {
            z = false;
        }
        if (this.searchIsShowed) {
            ValueAnimator valueAnimator = this.filtersTabAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            boolean z2 = this.canShowFilterTabsView;
            this.filterTabsViewIsVisible = z2;
            this.filterTabsProgress = z2 ? 1.0f : 0.0f;
            return;
        }
        final boolean z3 = this.canShowFilterTabsView;
        if (this.filterTabsViewIsVisible != z3) {
            ValueAnimator valueAnimator2 = this.filtersTabAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            this.filterTabsViewIsVisible = z3;
            if (z) {
                if (z3) {
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
                this.filtersTabAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.27
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        DialogsActivity.this.filtersTabAnimator = null;
                        DialogsActivity.this.scrollAdditionalOffset = AndroidUtilities.dp(44.0f) - DialogsActivity.this.filterTabsMoveFrom;
                        if (!z3) {
                            DialogsActivity.this.filterTabsView.setVisibility(8);
                        }
                        View view = DialogsActivity.this.fragmentView;
                        if (view != null) {
                            view.requestLayout();
                        }
                        DialogsActivity.this.getNotificationCenter().onAnimationFinish(DialogsActivity.this.animationIndex);
                    }
                });
                this.filtersTabAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$updateFilterTabsVisibility$19(z3, translationY, valueAnimator3);
                    }
                });
                this.filtersTabAnimator.setDuration(220L);
                this.filtersTabAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.animationIndex = getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
                this.filtersTabAnimator.start();
                this.fragmentView.requestLayout();
                return;
            }
            this.filterTabsProgress = z3 ? 1.0f : 0.0f;
            this.filterTabsView.setVisibility(z3 ? 0 : 8);
            View view = this.fragmentView;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFilterTabsVisibility$19(boolean z, float f, ValueAnimator valueAnimator) {
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
    public void setSearchAnimationProgress(float f) {
        this.searchAnimationProgress = f;
        if (this.whiteActionBar) {
            int color = Theme.getColor(this.folderId != 0 ? Theme.key_actionBarDefaultArchivedIcon : Theme.key_actionBarDefaultIcon);
            ActionBar actionBar = this.actionBar;
            int i = Theme.key_windowBackgroundWhiteGrayText2;
            actionBar.setItemsColor(ColorUtils.blendARGB(color, Theme.getColor(i), this.searchAnimationProgress), false);
            this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), Theme.getColor(i), this.searchAnimationProgress), true);
            this.actionBar.setItemsBackgroundColor(ColorUtils.blendARGB(Theme.getColor(this.folderId != 0 ? Theme.key_actionBarDefaultArchivedSelector : Theme.key_actionBarDefaultSelector), Theme.getColor(Theme.key_actionBarActionModeDefaultSelector), this.searchAnimationProgress), false);
        }
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
        updateContextViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findAndUpdateCheckBox(long j, boolean z) {
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
                        if (dialogCell.getDialogId() == j) {
                            dialogCell.setChecked(z, true);
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
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkListLoad(org.rbmain.ui.DialogsActivity.ViewPage r12) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.checkListLoad(org.rbmain.ui.DialogsActivity$ViewPage):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkListLoad$20(boolean z, boolean z2) {
        if (z) {
            getDialogsProxy().loadDialogs(this.folderId, -1, 100, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onItemClick(android.view.View r18, int r19, androidx.recyclerview.widget.RecyclerView.Adapter r20) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.onItemClick(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Adapter):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onItemLongClick(android.view.View r6, int r7, float r8, float r9, int r10, androidx.recyclerview.widget.RecyclerView.Adapter r11) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.onItemLongClick(android.view.View, int, float, float, int, androidx.recyclerview.widget.RecyclerView$Adapter):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemLongClick$21(long j, DialogInterface dialogInterface, int i) {
        this.searchViewPager.dialogsSearchAdapter.removeRecentSearch(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemLongClick$22(TLRPC$Dialog tLRPC$Dialog, DialogInterface dialogInterface, int i) {
        getDialogsProxy().onAdsAction(tLRPC$Dialog.id, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemLongClick$23(DialogInterface dialogInterface, int i) {
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
    public boolean showChatPreview(DialogCell dialogCell) {
        TLRPC$Chat chat;
        long dialogId = dialogCell.getDialogId();
        Bundle bundle = new Bundle();
        int i = (int) dialogId;
        long messageId = dialogCell.getMessageId();
        if (i == 0) {
            return false;
        }
        if (i > 0) {
            bundle.putInt("user_id", i);
        } else if (i < 0) {
            if (messageId != 0 && (chat = getMessagesController().getChat(Integer.valueOf(-i))) != null && chat.migrated_to != null) {
                bundle.putInt("migrated_to", i);
                i = -chat.migrated_to.channel_id;
            }
            bundle.putInt("chat_id", -i);
        }
        if (messageId != 0) {
            bundle.putLong("message_id", messageId);
        }
        if (this.searchString != null) {
            if (getMessagesController().checkCanOpenChat(bundle, this)) {
                getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
                prepareBlurBitmap();
                presentFragmentAsPreview(new ChatActivity(bundle));
            }
        } else if (getMessagesController().checkCanOpenChat(bundle, this)) {
            prepareBlurBitmap();
            presentFragmentAsPreview(new ChatActivity(bundle));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatingButtonOffset() {
        this.floatingButtonContainer.setTranslationY(this.floatingButtonTranslation - (this.additionalFloatingTranslation * (1.0f - this.floatingButtonHideProgress)));
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDialogAnimationFinished$24();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDialogAnimationFinished$24() {
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
    public void setScrollY(float f) {
        View view = this.scrimView;
        if (view != null) {
            view.getLocationInWindow(this.scrimViewLocation);
        }
        this.actionBar.setTranslationY(f);
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            filterTabsView.setTranslationY(f);
        }
        updateContextViewPosition();
        if (this.viewPages != null) {
            int i = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i >= viewPageArr.length) {
                    break;
                }
                viewPageArr[i].listView.setTopGlowOffset(this.viewPages[i].listView.getPaddingTop() + ((int) f));
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationProgress(boolean z, float f) {
        View view = this.blurredView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (z) {
            this.blurredView.setAlpha(1.0f - f);
        } else {
            this.blurredView.setAlpha(f);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        View view;
        if (z && (view = this.blurredView) != null && view.getVisibility() == 0) {
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
    public void hideActionMode(boolean z) {
        this.actionBar.hideActionMode();
        if (this.menuDrawable != null) {
            this.actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrOpenMenu", R.string.AccDescrOpenMenu));
        }
        this.selectedDialogs.clear();
        MenuDrawable menuDrawable = this.menuDrawable;
        if (menuDrawable != null) {
            menuDrawable.setRotation(0.0f, true);
            this.actionBar.backButtonImageView.setVisibility(4);
        } else {
            BackDrawable backDrawable = this.backDrawable;
            if (backDrawable != null) {
                backDrawable.setRotation(0.0f, true);
            }
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            filterTabsView.animateColorsTo(Theme.key_actionBarTabLine, Theme.key_actionBarTabActiveText, Theme.key_actionBarTabUnactiveText, Theme.key_actionBarTabSelector, Theme.key_actionBarDefault);
        }
        ValueAnimator valueAnimator = this.actionBarColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progressToActionMode, 0.0f);
        this.actionBarColorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$hideActionMode$25(valueAnimator2);
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
        updateVisibleRows(196608 | (z ? 8192 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideActionMode$25(ValueAnimator valueAnimator) {
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
        ArrayList<TLRPC$Dialog> dialogsArray;
        if (this.viewPages[0].dialogsType == 7 || this.viewPages[0].dialogsType == 8) {
            dialogsArray = getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, this.dialogsListFrozen);
        } else {
            dialogsArray = getMessagesController().getDialogs(this.folderId);
        }
        int size = dialogsArray.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$Dialog tLRPC$Dialog = dialogsArray.get(i2);
            if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogFolder)) {
                long j = tLRPC$Dialog.id;
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
    public boolean isDialogPinned(TLRPC$Dialog tLRPC$Dialog) {
        MessagesController.DialogFilter dialogFilter;
        if (this.viewPages[0].dialogsType == 7 || this.viewPages[0].dialogsType == 8) {
            dialogFilter = getMessagesController().selectedDialogFilter[this.viewPages[0].dialogsType == 8 ? (char) 1 : (char) 0];
        } else {
            dialogFilter = null;
        }
        if (dialogFilter != null) {
            return dialogFilter.pinnedDialogs.indexOfKey(tLRPC$Dialog.id) >= 0;
        }
        return tLRPC$Dialog.pinned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:150:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0609  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void perfromSelectedDialogsAction(final java.util.ArrayList<java.lang.Long> r41, final int r42, boolean r43) {
        /*
            Method dump skipped, instructions count: 1813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.perfromSelectedDialogsAction(java.util.ArrayList, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$26(ArrayList arrayList) {
        getMessagesController().addDialogToFolder(arrayList, this.folderId == 0 ? 0 : 1, -1, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$27(DialogInterface dialogInterface, int i) {
        presentFragment(new FiltersSetupActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$28(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
        getMessagesController().setDialogsInTransaction(true);
        perfromSelectedDialogsAction(arrayList, i, false);
        getMessagesController().setDialogsInTransaction(false);
        getMessagesController().checkIfFolderEmpty(this.folderId);
        if (this.folderId == 0 || getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, false).size() != 0) {
            return;
        }
        this.viewPages[0].listView.setEmptyView(null);
        this.viewPages[0].progressView.setVisibility(4);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$29(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
        perfromSelectedDialogsAction(arrayList, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$30(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
        perfromSelectedDialogsAction(arrayList, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$31(ArrayList arrayList, boolean z, boolean z2) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) arrayList.get(i)).longValue();
            int i2 = (int) jLongValue;
            if (z) {
                getMessagesController().reportSpam(jLongValue, getMessagesController().getUser(Integer.valueOf(i2)), null, null, false);
            }
            if (z2) {
                getMessagesController().deleteDialog(jLongValue, 0, true);
            }
            getMessagesController().blockPeer(i2);
        }
        hideActionMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$32(DialogInterface dialogInterface, int i) {
        getMessagesController().hidePromoDialog();
        hideActionMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$34(final int r17, final org.rbmain.tgnet.TLRPC$Chat r18, final long r19, final boolean r21) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.lambda$perfromSelectedDialogsAction$34(int, org.rbmain.tgnet.TLRPC$Chat, long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$perfromSelectedDialogsAction$33(int i, long j, boolean z, TLRPC$Chat tLRPC$Chat) {
        if (i == 103) {
            getMessagesController().deleteDialog(j, 1, z);
            return;
        }
        if (tLRPC$Chat != null) {
            getMessagesController().deleteParticipantFromChat((int) (-j), getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId())), null, null, z, false);
        } else {
            getMessagesController().deleteDialog(j, 0, z);
        }
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, Long.valueOf(j));
        }
        getMessagesController().checkIfFolderEmpty(this.folderId);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pinDialog(long r16, boolean r18, org.rbmain.messenger.MessagesController.DialogFilter r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.pinDialog(long, boolean, org.rbmain.messenger.MessagesController$DialogFilter, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pinDialog$35() {
        setDialogsListFrozen(false);
    }

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
    public void updateCounters(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        TLRPC$User user;
        this.canDeletePsaSelected = false;
        this.canUnarchiveCount = 0;
        this.canUnmuteCount = 0;
        this.canMuteCount = 0;
        this.canPinCount = 0;
        this.canReadCount = 0;
        this.canClearCacheCount = 0;
        this.canReportSpamCount = 0;
        if (z) {
            return;
        }
        int size = this.selectedDialogs.size();
        int clientUserId = getUserConfig().getClientUserId();
        SharedPreferences notificationsSettings = getNotificationsSettings();
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        boolean z4 = false;
        int i9 = 0;
        int i10 = 0;
        while (i6 < size) {
            TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(this.selectedDialogs.get(i6).longValue());
            if (tLRPC$Dialog == null) {
                i5 = size;
            } else {
                long j = tLRPC$Dialog.id;
                boolean zIsDialogPinned = isDialogPinned(tLRPC$Dialog);
                boolean z5 = tLRPC$Dialog.unread_count != 0 || tLRPC$Dialog.unread_mark;
                if (getMessagesController().isDialogMuted(j)) {
                    z2 = z3;
                    i3 = 1;
                    this.canUnmuteCount++;
                } else {
                    z2 = z3;
                    i3 = 1;
                    this.canMuteCount++;
                }
                if (z5) {
                    this.canReadCount += i3;
                }
                if (this.folderId == i3 || tLRPC$Dialog.folder_id == i3) {
                    i4 = size;
                    this.canUnarchiveCount++;
                } else {
                    i4 = size;
                    if (j != clientUserId && j != 777000) {
                        getMessagesController().isPromoDialog(j, false);
                    }
                }
                int i11 = (int) j;
                i5 = i4;
                int i12 = i8;
                int i13 = (int) (j >> 32);
                if (i11 <= 0 || i11 == clientUserId || MessagesController.isSupportUser(getMessagesController().getUser(Integer.valueOf(i11)))) {
                    i10++;
                } else {
                    if (notificationsSettings.getBoolean("dialog_bar_report" + j, true)) {
                        this.canReportSpamCount++;
                    }
                }
                if (DialogObject.isChannel(tLRPC$Dialog)) {
                    TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(-i11));
                    if (getMessagesController().isPromoDialog(tLRPC$Dialog.id, true)) {
                        this.canClearCacheCount++;
                        if (getMessagesController().promoDialogType == 1) {
                            i7++;
                            this.canDeletePsaSelected = true;
                        }
                        i8 = i12;
                        z3 = z2;
                    } else {
                        if (zIsDialogPinned) {
                            i9++;
                        } else {
                            this.canPinCount++;
                        }
                        if (chat != null && chat.megagroup && getDialogsProxy().isPrivateChannel(chat)) {
                            i8 = i12 + 1;
                            z3 = z2;
                        } else {
                            i8 = i12;
                            z3 = true;
                        }
                        i7++;
                    }
                } else {
                    boolean z6 = i11 < 0 && i13 != 1;
                    if (z6) {
                        getMessagesController().getChat(Integer.valueOf(-i11));
                    }
                    if (i11 == 0) {
                        TLRPC$EncryptedChat encryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf(i13));
                        if (encryptedChat != null) {
                            user = getMessagesController().getUser(Integer.valueOf(encryptedChat.user_id));
                        } else {
                            user = new TLRPC$TL_userEmpty();
                        }
                    } else {
                        user = (z6 || i11 <= 0 || i13 == 1) ? null : getMessagesController().getUser(Integer.valueOf(i11));
                    }
                    boolean z7 = (user == null || !user.bot || MessagesController.isSupportUser(user)) ? false : true;
                    if (zIsDialogPinned) {
                        i9++;
                    } else {
                        this.canPinCount++;
                    }
                    i8 = i12 + 1;
                    i7++;
                    if (z4 || !z7) {
                        z3 = z2;
                    } else {
                        z3 = z2;
                        z4 = true;
                    }
                }
            }
            i6++;
            size = i5;
        }
        boolean z8 = z3;
        int i14 = i8;
        if (i7 != size) {
            this.deleteItem.setVisibility(8);
        } else {
            this.deleteItem.setVisibility(0);
        }
        if (z8 || (((i2 = this.canClearCacheCount) != 0 && i2 != size) || ((i14 != 0 && i14 != size) || z4))) {
            this.clearItem.setVisibility(8);
        } else {
            this.clearItem.setVisibility(0);
            if (this.canClearCacheCount != 0) {
                this.clearItem.setText(LocaleController.getString("ClearHistoryCache", R.string.ClearHistoryCache));
            } else {
                this.clearItem.setText(LocaleController.getString("ClearHistory", R.string.ClearHistory));
            }
        }
        if (this.canPinCount + i9 != size) {
            this.pinItem.setVisibility(8);
            this.pin2Item.setVisibility(8);
            i = 0;
        } else {
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView != null && filterTabsView.getVisibility() == 0) {
                i = 0;
                this.pin2Item.setVisibility(0);
                this.pinItem.setVisibility(8);
            } else {
                i = 0;
                this.pinItem.setVisibility(0);
                this.pin2Item.setVisibility(8);
            }
        }
        if (i10 != 0) {
            this.blockItem.setVisibility(8);
        } else {
            this.blockItem.setVisibility(i);
        }
        FilterTabsView filterTabsView2 = this.filterTabsView;
        if (filterTabsView2 == null || filterTabsView2.getVisibility() != 0 || this.filterTabsView.getCurrentTabId() == Integer.MAX_VALUE) {
            this.removeFromFolderItem.setVisibility(8);
        } else {
            this.removeFromFolderItem.setVisibility(0);
        }
        FilterTabsView filterTabsView3 = this.filterTabsView;
        if (filterTabsView3 != null && filterTabsView3.getVisibility() == 0 && this.filterTabsView.getCurrentTabId() == Integer.MAX_VALUE && !FiltersListBottomSheet.getCanAddDialogFilters(this, this.selectedDialogs).isEmpty()) {
            this.addToFolderItem.setVisibility(0);
        } else {
            this.addToFolderItem.setVisibility(8);
        }
        if (this.canUnmuteCount != 0) {
            this.muteItem.setIcon(R.drawable.msg_unmute);
            this.muteItem.setContentDescription(LocaleController.getString("ChatsUnmute", R.string.ChatsUnmute));
        } else {
            this.muteItem.setIcon(R.drawable.msg_mute);
            this.muteItem.setContentDescription(LocaleController.getString("ChatsMute", R.string.ChatsMute));
        }
        if (this.canReadCount != 0) {
            this.readItem.setVisibility(0);
            this.readItem.setTextAndIcon(LocaleController.getString("MarkAsRead", R.string.MarkAsRead), R.drawable.msg_markread);
        } else {
            this.readItem.setVisibility(8);
            this.readItem.setTextAndIcon(LocaleController.getString("MarkAsUnread", R.string.MarkAsUnread), R.drawable.msg_markunread);
        }
        if (this.canPinCount != 0) {
            this.pinItem.setIcon(R.drawable.msg_pin);
            this.pinItem.setContentDescription(LocaleController.getString("PinToTop", R.string.PinToTop));
            this.pin2Item.setText(LocaleController.getString("DialogPin", R.string.DialogPin));
        } else {
            this.pinItem.setIcon(R.drawable.msg_unpin);
            this.pinItem.setContentDescription(LocaleController.getString("UnpinFromTop", R.string.UnpinFromTop));
            this.pin2Item.setText(LocaleController.getString("DialogUnpin", R.string.DialogUnpin));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateSlowModeDialog(long j) {
        int i;
        TLRPC$Chat chat;
        ChatActivityEnterView chatActivityEnterView;
        if ((this.messagesCount <= 1 && ((chatActivityEnterView = this.commentView) == null || chatActivityEnterView.getVisibility() != 0 || TextUtils.isEmpty(this.commentView.getFieldText()))) || (i = (int) j) >= 0 || (chat = getMessagesController().getChat(Integer.valueOf(-i))) == null || ChatObject.hasAdminRights(chat) || !chat.slowmode_enabled) {
            return true;
        }
        AlertsCreator.showSimpleAlert(this, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError));
        return false;
    }

    private void showOrUpdateActionMode(TLRPC$Dialog tLRPC$Dialog, View view) {
        addOrRemoveSelectedDialog(tLRPC$Dialog.id, view);
        boolean z = true;
        if (this.actionBar.isActionModeShowed()) {
            if (this.selectedDialogs.isEmpty()) {
                hideActionMode(true);
                return;
            }
        } else {
            createActionMode();
            this.actionBar.setActionModeOverrideColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.actionModeViews.size(); i2++) {
                View view2 = this.actionModeViews.get(i2);
                view2.setPivotY(ActionBar.getCurrentActionBarHeight() / 2);
                AndroidUtilities.clearDrawableAnimation(view2);
                arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, 0.1f, 1.0f));
            }
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(200L);
            animatorSet.start();
            ValueAnimator valueAnimator = this.actionBarColorAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.progressToActionMode, 1.0f);
            this.actionBarColorAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$showOrUpdateActionMode$36(valueAnimator2);
                }
            });
            this.actionBarColorAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.actionBarColorAnimator.setDuration(200L);
            this.actionBarColorAnimator.start();
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView != null) {
                filterTabsView.animateColorsTo(Theme.key_profile_tabSelectedLine, Theme.key_profile_tabSelectedText, Theme.key_profile_tabText, Theme.key_profile_tabSelector, Theme.key_actionBarActionModeDefault);
            }
            MenuDrawable menuDrawable = this.menuDrawable;
            if (menuDrawable != null) {
                menuDrawable.setRotateToBack(false);
                this.actionBar.backButtonImageView.setVisibility(0);
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
    public /* synthetic */ void lambda$showOrUpdateActionMode$36(ValueAnimator valueAnimator) {
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

    private void updateProxyButton(boolean z) {
        ActionBarMenuItem actionBarMenuItem;
        if (this.proxyDrawable != null) {
            ActionBarMenuItem actionBarMenuItem2 = this.doneItem;
            if (actionBarMenuItem2 == null || actionBarMenuItem2.getVisibility() != 0) {
                SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
                boolean z2 = sharedPreferences.getBoolean("proxy_enabled", false) && !TextUtils.isEmpty(sharedPreferences.getString("proxy_ip", BuildConfig.FLAVOR));
                if (z2 || (getMessagesController().blockedCountry && !SharedConfig.proxyList.isEmpty())) {
                    if (!this.actionBar.isSearchFieldVisible() && ((actionBarMenuItem = this.doneItem) == null || actionBarMenuItem.getVisibility() != 0)) {
                        this.proxyItem.setVisibility(0);
                    }
                    this.proxyItemVisible = true;
                    ProxyDrawable proxyDrawable = this.proxyDrawable;
                    int i = this.currentConnectionState;
                    proxyDrawable.setConnected(z2, i == 3 || i == 5, z);
                    return;
                }
                this.proxyItemVisible = false;
                this.proxyItem.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneItem(final boolean z) {
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
        if (z) {
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
        fArr[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem4, (Property<ActionBarMenuItem, Float>) property, fArr));
        if (this.proxyItemVisible) {
            ActionBarMenuItem actionBarMenuItem5 = this.proxyItem;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 0.0f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem5, (Property<ActionBarMenuItem, Float>) property2, fArr2));
        }
        if (this.passcodeItemVisible) {
            ActionBarMenuItem actionBarMenuItem6 = this.passcodeItem;
            Property property3 = View.ALPHA;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 0.0f : 1.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem6, (Property<ActionBarMenuItem, Float>) property3, fArr3));
        }
        ActionBarMenuItem actionBarMenuItem7 = this.searchItem;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem7, (Property<ActionBarMenuItem, Float>) property4, fArr4));
        this.doneItemAnimator.playTogether(arrayList);
        this.doneItemAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.28
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DialogsActivity.this.doneItemAnimator = null;
                if (z) {
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
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.29
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
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
                this.commentView.setFieldText(BuildConfig.FLAVOR);
                this.commentView.setVisibility(0);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.commentView, (Property<ChatActivityEnterView, Float>) View.TRANSLATION_Y, r8.getMeasuredHeight(), 0.0f));
                animatorSet2.setDuration(180L);
                animatorSet2.setInterpolator(new DecelerateInterpolator());
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.DialogsActivity.30
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
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

    private void askForPermissons(boolean z) {
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (getUserConfig().syncContacts && this.askAboutContacts && parentActivity.checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
            if (z) {
                AlertDialog alertDialogCreate = AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda42
                    @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                    public final void run(int i) {
                        this.f$0.lambda$askForPermissons$37(i);
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
        if (parentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
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
        try {
            parentActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), 1);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$askForPermissons$37(int i) {
        this.askAboutContacts = i != 0;
        MessagesController.getGlobalNotificationsSettings().edit().putBoolean("askAboutContacts", this.askAboutContacts).apply();
        askForPermissons(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        super.onDialogDismiss(dialog);
        AlertDialog alertDialog = this.permissionDialog;
        if (alertDialog == null || dialog != alertDialog || getParentActivity() == null) {
            return;
        }
        askForPermissons(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        FrameLayout frameLayout;
        super.onConfigurationChanged(configuration);
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        if (this.onlySelect || (frameLayout = this.floatingButtonContainer) == null) {
            return;
        }
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: org.rbmain.ui.DialogsActivity.31
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr.length > i2) {
                    String str = strArr[i2];
                    str.hashCode();
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (iArr[i2] == 0) {
                            ImageLoader.getInstance().checkMediaPaths();
                        }
                    } else if (str.equals("android.permission.READ_CONTACTS")) {
                        if (iArr[i2] == 0) {
                            getContactsController().forceImportContacts();
                        } else {
                            SharedPreferences.Editor editorEdit = MessagesController.getGlobalNotificationsSettings().edit();
                            this.askAboutContacts = false;
                            editorEdit.putBoolean("askAboutContacts", false).apply();
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        DialogsSearchAdapter dialogsSearchAdapter;
        DialogsSearchAdapter dialogsSearchAdapter2;
        DialogsSearchAdapter dialogsSearchAdapter3;
        int i3;
        int i4;
        int i5 = 0;
        if (i == NotificationCenter.dialogsLoadingChange) {
            this.isLoadingChats = ((Boolean) objArr[0]).booleanValue();
            setActionbarCenterAndLoading();
            return;
        }
        if (i == NotificationCenter.dialogsNeedReload) {
            if (this.viewPages == null || this.dialogsListFrozen) {
                return;
            }
            AccountInstance.getInstance(this.currentAccount).getMessagesController().getDialogs(this.folderId);
            int i6 = 0;
            while (true) {
                ViewPage[] viewPageArr = this.viewPages;
                if (i6 >= viewPageArr.length) {
                    break;
                }
                if (viewPageArr[i6].getVisibility() == 0) {
                    int currentCount = this.viewPages[i6].dialogsAdapter.getCurrentCount();
                    if (this.viewPages[i6].dialogsType == 0 && hasHiddenArchive() && this.viewPages[i6].listView.getChildCount() == 0) {
                        ((LinearLayoutManager) this.viewPages[i6].listView.getLayoutManager()).scrollToPositionWithOffset(1, 0);
                    }
                    if (this.viewPages[i6].dialogsAdapter.isDataSetChanged() || objArr.length > 0) {
                        this.viewPages[i6].dialogsAdapter.notifyDataSetChanged();
                        if (this.viewPages[i6].dialogsAdapter.getItemCount() > currentCount && (i3 = this.initialDialogsType) != 11 && i3 != 12 && i3 != 13) {
                            this.viewPages[i6].recyclerItemsEnterAnimator.showItemsAnimated(currentCount);
                        }
                    } else {
                        updateVisibleRows(2048);
                        if (this.viewPages[i6].dialogsAdapter.getItemCount() > currentCount && (i4 = this.initialDialogsType) != 11 && i4 != 12 && i4 != 13) {
                            this.viewPages[i6].recyclerItemsEnterAnimator.showItemsAnimated(currentCount);
                        }
                    }
                    try {
                        this.viewPages[i6].listView.setEmptyView(this.folderId == 0 ? this.viewPages[i6].progressView : null);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    checkListLoad(this.viewPages[i6]);
                }
                i6++;
            }
            FilterTabsView filterTabsView = this.filterTabsView;
            if (filterTabsView == null || filterTabsView.getVisibility() != 0) {
                return;
            }
            this.filterTabsView.checkTabsCounter();
            return;
        }
        if (i == NotificationCenter.dialogsUnreadCounterChanged) {
            FilterTabsView filterTabsView2 = this.filterTabsView;
            if (filterTabsView2 == null || filterTabsView2.getVisibility() != 0) {
                return;
            }
            this.filterTabsView.notifyTabCounterChanged(ConnectionsManager.DEFAULT_DATACENTER_ID);
            return;
        }
        if (i == NotificationCenter.emojiDidLoad) {
            updateVisibleRows(0);
            FilterTabsView filterTabsView3 = this.filterTabsView;
            if (filterTabsView3 != null) {
                filterTabsView3.getTabsContainer().invalidateViews();
                return;
            }
            return;
        }
        if (i == NotificationCenter.closeSearchByActiveAction) {
            ActionBar actionBar = this.actionBar;
            if (actionBar != null) {
                actionBar.closeSearchField();
                return;
            }
            return;
        }
        if (i == NotificationCenter.proxySettingsChanged) {
            updateProxyButton(false);
            return;
        }
        if (i == NotificationCenter.updateInterfaces) {
            Integer num = (Integer) objArr[0];
            updateVisibleRows(num.intValue());
            FilterTabsView filterTabsView4 = this.filterTabsView;
            if (filterTabsView4 != null && filterTabsView4.getVisibility() == 0 && (num.intValue() & 256) != 0) {
                this.filterTabsView.checkTabsCounter();
            }
            if (this.viewPages != null) {
                while (i5 < this.viewPages.length) {
                    if ((num.intValue() & 4) != 0) {
                        this.viewPages[i5].dialogsAdapter.sortOnlineContacts(true);
                    }
                    i5++;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.appDidLogout) {
            dialogsLoaded[this.currentAccount] = false;
            return;
        }
        if (i == NotificationCenter.encryptedChatUpdated) {
            updateVisibleRows(0);
            return;
        }
        if (i == NotificationCenter.contactsDidLoad) {
            if (this.viewPages == null || this.dialogsListFrozen) {
                return;
            }
            int i7 = 0;
            boolean z = false;
            while (true) {
                ViewPage[] viewPageArr2 = this.viewPages;
                if (i7 >= viewPageArr2.length) {
                    break;
                }
                if (!viewPageArr2[i7].isDefaultDialogType() || getMessagesController().getDialogs(this.folderId).size() > 10) {
                    z = true;
                } else {
                    this.viewPages[i7].dialogsAdapter.notifyDataSetChanged();
                }
                i7++;
            }
            if (z) {
                updateVisibleRows(0);
                return;
            }
            return;
        }
        if (i == NotificationCenter.openedChatChanged) {
            if (this.viewPages == null) {
                return;
            }
            int i8 = 0;
            while (true) {
                ViewPage[] viewPageArr3 = this.viewPages;
                if (i8 < viewPageArr3.length) {
                    if (viewPageArr3[i8].isDefaultDialogType() && AndroidUtilities.isTablet()) {
                        boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
                        long jLongValue = ((Long) objArr[0]).longValue();
                        if (!zBooleanValue) {
                            this.openedDialogId = jLongValue;
                        } else if (jLongValue == this.openedDialogId) {
                            this.openedDialogId = 0L;
                        }
                        this.viewPages[i8].dialogsAdapter.setOpenedDialogId(this.openedDialogId);
                    }
                    i8++;
                } else {
                    updateVisibleRows(512);
                    return;
                }
            }
        } else {
            if (i == NotificationCenter.notificationsSettingsUpdated) {
                updateVisibleRows(0);
                return;
            }
            if (i == NotificationCenter.messageReceivedByAck || i == NotificationCenter.messageReceivedByServer || i == NotificationCenter.messageSendError) {
                updateVisibleRows(4096);
                return;
            }
            if (i == NotificationCenter.didSetPasscode) {
                updatePasscodeButton(true);
                return;
            }
            if (i == NotificationCenter.needReloadRecentDialogsSearch) {
                SearchViewPager searchViewPager = this.searchViewPager;
                if (searchViewPager == null || (dialogsSearchAdapter3 = searchViewPager.dialogsSearchAdapter) == null) {
                    return;
                }
                dialogsSearchAdapter3.loadRecentSearch();
                return;
            }
            if (i == NotificationCenter.lastOnlineUpdated) {
                SearchViewPager searchViewPager2 = this.searchViewPager;
                if (searchViewPager2 == null || (dialogsSearchAdapter2 = searchViewPager2.dialogsSearchAdapter) == null) {
                    return;
                }
                dialogsSearchAdapter2.loadRecentSearch();
                return;
            }
            if (i == NotificationCenter.replyMessagesDidLoad) {
                updateVisibleRows(32768);
                return;
            }
            if (i == NotificationCenter.reloadHints) {
                SearchViewPager searchViewPager3 = this.searchViewPager;
                if (searchViewPager3 == null || (dialogsSearchAdapter = searchViewPager3.dialogsSearchAdapter) == null) {
                    return;
                }
                dialogsSearchAdapter.notifyDataSetChanged();
                return;
            }
            if (i == NotificationCenter.didUpdateConnectionState) {
                int connectionState = AccountInstance.getInstance(i2).getConnectionsManager().getConnectionState();
                if (this.currentConnectionState != connectionState) {
                    this.currentConnectionState = connectionState;
                    updateProxyButton(true);
                    return;
                }
                return;
            }
            if (i == NotificationCenter.needDeleteDialog) {
                if (this.fragmentView == null || this.isPaused) {
                    return;
                }
                final long jLongValue2 = ((Long) objArr[0]).longValue();
                final TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) objArr[2];
                final boolean zBooleanValue2 = ((Boolean) objArr[3]).booleanValue();
                Runnable runnable = new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda35
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$38(tLRPC$Chat, jLongValue2, zBooleanValue2);
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
            if (i == NotificationCenter.folderBecomeEmpty) {
                int iIntValue = ((Integer) objArr[0]).intValue();
                int i9 = this.folderId;
                if (i9 != iIntValue || i9 == 0) {
                    return;
                }
                finishFragment();
                return;
            }
            if (i == NotificationCenter.dialogFiltersUpdated) {
                updateFilterTabs(true, true);
                return;
            }
            if (i == NotificationCenter.filterSettingsUpdated) {
                showFiltersHint();
                return;
            }
            if (i == NotificationCenter.newSuggestionsAvailable) {
                showNextSupportedSuggestion();
                return;
            }
            if (i == NotificationCenter.messagesDeleted) {
                if (!this.searchIsShowed || this.searchViewPager == null) {
                    return;
                }
                this.searchViewPager.messagesDeleted(((Integer) objArr[1]).intValue(), (ArrayList) objArr[0]);
                return;
            }
            if (i != NotificationCenter.didClearDatabase || this.viewPages == null) {
                return;
            }
            while (true) {
                ViewPage[] viewPageArr4 = this.viewPages;
                if (i5 >= viewPageArr4.length) {
                    return;
                }
                viewPageArr4[i5].dialogsAdapter.didDatabaseCleared();
                i5++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$38(TLRPC$Chat tLRPC$Chat, long j, boolean z) {
        if (tLRPC$Chat != null) {
            getMessagesController().deleteParticipantFromChat((int) (-j), getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId())), null, null, z, z);
        } else {
            getMessagesController().deleteDialog(j, 0, z);
        }
        getMessagesController().checkIfFolderEmpty(this.folderId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionbarCenterAndLoading() {
        if (!this.actionBar.isSearchFieldVisible() && !this.searching) {
            if (!this.isLoadingChats) {
                TextView textView = this.actionBar.centerTitleTextView1;
                if (textView != null) {
                    textView.setText(BuildConfig.FLAVOR);
                }
                FrameLayout frameLayout = this.actionBar.centerImageFrameLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                    return;
                }
                return;
            }
            TextView textView2 = this.actionBar.centerTitleTextView1;
            if (textView2 != null) {
                textView2.setText(LocaleController.getString("Updating", R.string.Updating));
            }
            FrameLayout frameLayout2 = this.actionBar.centerImageFrameLayout;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView3 = this.actionBar.centerTitleTextView1;
        if (textView3 != null) {
            textView3.setText(BuildConfig.FLAVOR);
        }
        FrameLayout frameLayout3 = this.actionBar.centerImageFrameLayout;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(4);
        }
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

    private boolean showSuggestion(String str) {
        if (!"AUTOARCHIVE_POPULAR".equals(str)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("HideNewChatsAlertTitle", R.string.HideNewChatsAlertTitle));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("HideNewChatsAlertText", R.string.HideNewChatsAlertText)));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("GoToSettings", R.string.GoToSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showSuggestion$39(dialogInterface, i);
            }
        });
        showDialog(builder.create(), new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showSuggestion$40(dialogInterface);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestion$39(DialogInterface dialogInterface, int i) {
        presentFragment(new PrivacySettingsActivity());
        AndroidUtilities.scrollToFragmentRow(this.parentLayout, "newChatsRow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestion$40(DialogInterface dialogInterface) {
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
        globalMainSettings.edit().putBoolean("filterhint", true).apply();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showFiltersHint$42();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFiltersHint$41() {
        presentFragment(new FiltersSetupActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFiltersHint$42() {
        getUndoView().showWithAction(0L, 15, null, new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showFiltersHint$41();
            }
        });
    }

    private void setDialogsListFrozen(boolean z, boolean z2) {
        if (this.viewPages == null || this.dialogsListFrozen == z) {
            return;
        }
        if (z) {
            this.frozenDialogsList = new ArrayList<>(getDialogsArray(this.currentAccount, this.viewPages[0].dialogsType, this.folderId, false));
        } else {
            this.frozenDialogsList = null;
        }
        this.dialogsListFrozen = z;
        this.viewPages[0].dialogsAdapter.setDialogsListFrozen(z);
        if (z || !z2) {
            return;
        }
        this.viewPages[0].dialogsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialogsListFrozen(boolean z) {
        setDialogsListFrozen(z, true);
    }

    public ArrayList<TLRPC$Dialog> getDialogsArray(int i, int i2, int i3, boolean z) {
        ArrayList<TLRPC$Dialog> arrayList;
        if (z && (arrayList = this.frozenDialogsList) != null) {
            return arrayList;
        }
        MessagesController messagesController = AccountInstance.getInstance(i).getMessagesController();
        if (i2 == 0) {
            return messagesController.getDialogs(i3);
        }
        if (i2 == 1 || i2 == 10 || i2 == 13) {
            return messagesController.dialogsServerOnly;
        }
        if (i2 == 2) {
            return messagesController.dialogsCanAddUsers;
        }
        if (i2 == 3) {
            return messagesController.dialogsForward;
        }
        if (i2 == 4 || i2 == 12) {
            return messagesController.dialogsUsersOnly;
        }
        if (i2 == 5) {
            return messagesController.dialogsChannelsOnly;
        }
        if (i2 == 6 || i2 == 11) {
            return messagesController.dialogsGroupsOnly;
        }
        if (i2 != 7 && i2 != 8) {
            if (i2 == 9) {
                return messagesController.dialogsForBlock;
            }
            return new ArrayList<>();
        }
        MessagesController.DialogFilter dialogFilter = messagesController.selectedDialogFilter[i2 == 7 ? (char) 0 : (char) 1];
        if (dialogFilter == null) {
            return messagesController.getDialogs(i3);
        }
        return dialogFilter.dialogs;
    }

    public void setSideMenu(RecyclerView recyclerView) {
        this.sideMenu = recyclerView;
        int i = Theme.key_chats_menuBackground;
        recyclerView.setBackgroundColor(Theme.getColor(i));
        this.sideMenu.setGlowColor(Theme.getColor(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePasscodeButton(boolean z) {
        if (this.passcodeItem == null) {
            return;
        }
        if (this.isPaused) {
            z = false;
        }
        if (SharedConfig.passcodeHash.length() != 0 && !this.searching) {
            ActionBarMenuItem actionBarMenuItem = this.doneItem;
            if (actionBarMenuItem == null || actionBarMenuItem.getVisibility() != 0) {
                this.passcodeItem.setVisibility(0);
            }
            this.passcodeItemVisible = true;
            if (SharedConfig.appLocked) {
                this.passcodeItem.setContentDescription(LocaleController.getString("AccDescrPasscodeUnlock", R.string.AccDescrPasscodeUnlock));
                this.passcodeItem.setIcon(this.passcodeDrawable2);
                if (z) {
                    this.passcodeDrawable2.setCurrentFrame(0, false);
                    this.passcodeItem.getIconView().playAnimation();
                    return;
                } else {
                    this.passcodeDrawable2.setCurrentFrame(38, false);
                    return;
                }
            }
            this.passcodeItem.setContentDescription(LocaleController.getString("AccDescrPasscodeLock", R.string.AccDescrPasscodeLock));
            this.passcodeItem.setIcon(this.passcodeDrawable);
            if (z) {
                this.passcodeDrawable.setCurrentFrame(0, false);
                this.passcodeItem.getIconView().playAnimation();
                return;
            } else {
                this.passcodeDrawable.setCurrentFrame(31, false);
                return;
            }
        }
        this.passcodeItem.setVisibility(8);
        this.passcodeItemVisible = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean z) {
        if (this.floatingHidden != z) {
            if (z && this.floatingForceVisible) {
                return;
            }
            this.floatingHidden = z;
            AnimatorSet animatorSet = new AnimatorSet();
            float[] fArr = new float[2];
            fArr[0] = this.floatingButtonHideProgress;
            fArr[1] = this.floatingHidden ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$hideFloatingButton$43(valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(this.floatingInterpolator);
            this.floatingButtonContainer.setClickable(!z);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideFloatingButton$43(ValueAnimator valueAnimator) {
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
    /* JADX WARN: Removed duplicated region for block: B:100:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateVisibleRows(int r15) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.updateVisibleRows(int):void");
    }

    public void setDelegate(DialogsActivityDelegate dialogsActivityDelegate) {
        this.delegate = dialogsActivityDelegate;
    }

    public void setSearchString(String str) {
        this.searchString = str;
    }

    public boolean isMainDialogList() {
        return this.delegate == null && this.searchString == null;
    }

    public void setInitialSearchType(int i) {
        this.initialSearchType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didSelectResult(final long j, boolean z, final boolean z2) {
        final TLRPC$Chat tLRPC$Chat;
        String string;
        String stringSimple;
        String string2;
        final TLRPC$User tLRPC$User = null;
        if (this.addToGroupAlertString == null && this.checkCanWrite) {
            int i = (int) j;
            if (i < 0) {
                int i2 = -i;
                TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(i2));
                if (ChatObject.isChannel(chat) && !chat.megagroup && (this.cantSendToChannels || !ChatObject.isCanWriteToChannel(i2, this.currentAccount) || this.hasPoll == 2)) {
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
            } else if (i == 0 && (this.hasPoll != 0 || this.hasInvoice)) {
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
        int i3 = this.initialDialogsType;
        if (i3 == 11 || i3 == 12 || i3 == 13) {
            if (this.checkingImportDialog) {
                return;
            }
            int i4 = (int) j;
            if (i4 > 0) {
                TLRPC$User user = getMessagesController().getUser(Integer.valueOf(i4));
                if (!user.mutual_contact) {
                    getUndoView().showWithAction(j, 45, (Runnable) null);
                    return;
                } else {
                    tLRPC$Chat = null;
                    tLRPC$User = user;
                }
            } else {
                TLRPC$Chat chat2 = getMessagesController().getChat(Integer.valueOf(-i4));
                if (!ChatObject.hasAdminRights(chat2) || !ChatObject.canChangeChatInfo(chat2)) {
                    getUndoView().showWithAction(j, 46, (Runnable) null);
                    return;
                }
                tLRPC$Chat = chat2;
            }
            final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            final TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer = new TLRPC$TL_messages_checkHistoryImportPeer();
            tLRPC$TL_messages_checkHistoryImportPeer.peer = getMessagesController().getInputPeer(i4);
            getConnectionsManager().sendRequest(tLRPC$TL_messages_checkHistoryImportPeer, new RequestDelegate() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda43
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didSelectResult$46(alertDialog, tLRPC$User, tLRPC$Chat, j, z2, tLRPC$TL_messages_checkHistoryImportPeer, tLObject, tLRPC$TL_error);
                }
            });
            try {
                alertDialog.showDelayed(300L);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (z && ((this.selectAlertString != null && this.selectAlertStringGroup != null) || this.addToGroupAlertString != null)) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
            int i5 = (int) j;
            int i6 = (int) (j >> 32);
            if (i5 != 0) {
                if (i5 == getUserConfig().getClientUserId()) {
                    string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                    stringSimple = LocaleController.formatStringSimple(this.selectAlertStringGroup, LocaleController.getString("SavedMessages", R.string.SavedMessages));
                    string2 = LocaleController.getString("Send", R.string.Send);
                } else if (i5 > 0) {
                    TLRPC$User user2 = getMessagesController().getUser(Integer.valueOf(i5));
                    if (user2 == null || this.selectAlertString == null) {
                        return;
                    }
                    string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                    stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(user2));
                    string2 = LocaleController.getString("Send", R.string.Send);
                } else {
                    TLRPC$Chat chat3 = getMessagesController().getChat(Integer.valueOf(-i5));
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
                }
            } else {
                TLRPC$User user3 = getMessagesController().getUser(Integer.valueOf(getMessagesController().getEncryptedChat(Integer.valueOf(i6)).user_id));
                if (user3 == null) {
                    return;
                }
                string = LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle);
                stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(user3));
                string2 = LocaleController.getString("Send", R.string.Send);
            }
            builder3.setTitle(string);
            builder3.setMessage(AndroidUtilities.replaceTags(stringSimple));
            builder3.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    this.f$0.lambda$didSelectResult$47(j, dialogInterface, i7);
                }
            });
            builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder3.create());
            return;
        }
        if (this.delegate != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(j));
            this.delegate.didSelectDialogs(this, arrayList, null, z2);
            if (this.resetDelegate) {
                this.delegate = null;
                return;
            }
            return;
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$46(final AlertDialog alertDialog, final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final long j, final boolean z, final TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didSelectResult$45(alertDialog, tLObject, tLRPC$User, tLRPC$Chat, j, z, tLRPC$TL_error, tLRPC$TL_messages_checkHistoryImportPeer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$45(AlertDialog alertDialog, TLObject tLObject, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, final long j, final boolean z, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_checkHistoryImportPeer tLRPC$TL_messages_checkHistoryImportPeer) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.checkingImportDialog = false;
        if (tLObject != null) {
            AlertsCreator.createImportDialogAlert(this, this.arguments.getString("importTitle"), ((TLRPC$TL_messages_checkedHistoryImportPeer) tLObject).confirm_text, tLRPC$User, tLRPC$Chat, new Runnable() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didSelectResult$44(j, z);
                }
            });
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_messages_checkHistoryImportPeer, new Object[0]);
            getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(j), tLRPC$TL_messages_checkHistoryImportPeer, tLRPC$TL_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$44(long j, boolean z) {
        setDialogsListFrozen(true);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j));
        this.delegate.didSelectDialogs(this, arrayList, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$47(long j, DialogInterface dialogInterface, int i) {
        didSelectResult(j, false, false);
    }

    public RLottieImageView getFloatingButton() {
        return this.floatingButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x08c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0402  */
    /* JADX WARN: Type inference failed for: r4v165, types: [org.rbmain.ui.Components.RecyclerListView] */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<org.rbmain.ui.ActionBar.ThemeDescription> getThemeDescriptions() {
        /*
            Method dump skipped, instructions count: 6765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.getThemeDescriptions():java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getThemeDescriptions$48() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DialogsActivity.lambda$getThemeDescriptions$48():void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected Animator getCustomSlideTransition(boolean z, boolean z2, float f) {
        if (z2) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.slideFragmentProgress, 1.0f);
            this.slideBackTransitionAnimator = valueAnimatorOfFloat;
            return valueAnimatorOfFloat;
        }
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.slideFragmentProgress, 1.0f);
        this.slideBackTransitionAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.DialogsActivity$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$getCustomSlideTransition$49(valueAnimator);
            }
        });
        this.slideBackTransitionAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.slideBackTransitionAnimator.setDuration((int) (Math.max((int) ((200.0f / getLayoutContainer().getMeasuredWidth()) * f), 80) * 1.2f));
        this.slideBackTransitionAnimator.start();
        return this.slideBackTransitionAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCustomSlideTransition$49(ValueAnimator valueAnimator) {
        setSlideTransitionProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void prepareFragmentToSlide(boolean z, boolean z2) {
        if (!z && z2) {
            this.isSlideBackTransition = true;
            setFragmentIsSliding(true);
        } else {
            this.slideBackTransitionAnimator = null;
            this.isSlideBackTransition = false;
            setFragmentIsSliding(false);
            setSlideTransitionProgress(1.0f);
        }
    }

    private void setFragmentIsSliding(boolean z) {
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            return;
        }
        if (z) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onSlideProgress(boolean z, float f) {
        if (SharedConfig.getDevicePerformanceClass() != 0 && this.isSlideBackTransition && this.slideBackTransitionAnimator == null) {
            setSlideTransitionProgress(f);
        }
    }

    private void setSlideTransitionProgress(float f) {
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            return;
        }
        this.slideFragmentProgress = f;
        View view = this.fragmentView;
        if (view != null) {
            view.invalidate();
        }
        FilterTabsView filterTabsView = this.filterTabsView;
        if (filterTabsView != null) {
            float f2 = 1.0f - ((1.0f - this.slideFragmentProgress) * 0.05f);
            filterTabsView.getListView().setScaleX(f2);
            this.filterTabsView.getListView().setScaleY(f2);
            this.filterTabsView.getListView().setTranslationX((this.isDrawerTransition ? AndroidUtilities.dp(4.0f) : -AndroidUtilities.dp(4.0f)) * (1.0f - this.slideFragmentProgress));
            this.filterTabsView.getListView().setPivotX(this.isDrawerTransition ? this.filterTabsView.getMeasuredWidth() : 0.0f);
            this.filterTabsView.getListView().setPivotY(0.0f);
            this.filterTabsView.invalidate();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void setProgressToDrawerOpened(float f) {
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            return;
        }
        boolean z = f > 0.0f;
        if (this.searchIsShowed) {
            f = 0.0f;
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
        setSlideTransitionProgress(1.0f - f);
    }
}
