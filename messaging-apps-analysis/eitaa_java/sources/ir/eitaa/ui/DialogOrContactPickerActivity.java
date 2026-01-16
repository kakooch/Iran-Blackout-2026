package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScrollSlidingTextTabStrip;
import ir.eitaa.ui.ContactsActivity;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DialogOrContactPickerActivity extends BaseFragment {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.-$$Lambda$DialogOrContactPickerActivity$XJuJicbfhkgwcYiGFkf_OxH_2Q0
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return DialogOrContactPickerActivity.lambda$static$0(f);
        }
    };
    private boolean animatingForward;
    private boolean backAnimation;
    private ContactsActivity contactsActivity;
    private DialogsActivity dialogsActivity;
    private int maximumVelocity;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private ActionBarMenuItem searchItem;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private Paint backgroundPaint = new Paint();
    private ViewPage[] viewPages = new ViewPage[2];
    private boolean swipeBackEnabled = true;

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    private static class ViewPage extends FrameLayout {
        private ActionBar actionBar;
        private FrameLayout fragmentView;
        private RecyclerListView listView;
        private RecyclerListView listView2;
        private BaseFragment parentFragment;
        private int selectedType;

        public ViewPage(Context context) {
            super(context);
        }
    }

    public DialogOrContactPickerActivity() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("onlySelect", true);
        bundle.putBoolean("checkCanWrite", false);
        bundle.putBoolean("resetDelegate", false);
        bundle.putInt("dialogsType", 9);
        DialogsActivity dialogsActivity = new DialogsActivity(bundle);
        this.dialogsActivity = dialogsActivity;
        dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogOrContactPickerActivity$WDXKz5jA0HIEsNPrqqrTSyeayEs
            @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
            public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                this.f$0.lambda$new$1$DialogOrContactPickerActivity(dialogsActivity2, arrayList, charSequence, z);
            }
        });
        this.dialogsActivity.onFragmentCreate();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("onlyUsers", true);
        bundle2.putBoolean("destroyAfterSelect", true);
        bundle2.putBoolean("returnAsResult", true);
        bundle2.putBoolean("disableSections", true);
        bundle2.putBoolean("needFinishFragment", false);
        bundle2.putBoolean("resetDelegate", false);
        bundle2.putBoolean("allowSelf", false);
        ContactsActivity contactsActivity = new ContactsActivity(bundle2);
        this.contactsActivity = contactsActivity;
        contactsActivity.setDelegate(new ContactsActivity.ContactsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$DialogOrContactPickerActivity$WnDaFOxdUUuTfB-JaHxcW77hrOI
            @Override // ir.eitaa.ui.ContactsActivity.ContactsActivityDelegate
            public final void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity2) {
                this.f$0.lambda$new$2$DialogOrContactPickerActivity(tLRPC$User, str, contactsActivity2);
            }
        });
        this.contactsActivity.onFragmentCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$DialogOrContactPickerActivity(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        if (DialogObject.isUserDialog(jLongValue)) {
            showBlockAlert(getMessagesController().getUser(Long.valueOf(jLongValue)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$DialogOrContactPickerActivity(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity) {
        showBlockAlert(tLRPC$User);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("BlockUserMultiTitle", R.string.BlockUserMultiTitle));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setAddToContainer(false);
        this.actionBar.setClipContent(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    DialogOrContactPickerActivity.this.finishFragment();
                }
            }
        });
        this.hasOwnBackground = true;
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                DialogOrContactPickerActivity.this.dialogsActivity.getActionBar().openSearchField("", false);
                DialogOrContactPickerActivity.this.contactsActivity.getActionBar().openSearchField("", false);
                DialogOrContactPickerActivity.this.searchItem.getSearchField().requestFocus();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                DialogOrContactPickerActivity.this.dialogsActivity.getActionBar().closeSearchField(false);
                DialogOrContactPickerActivity.this.contactsActivity.getActionBar().closeSearchField(false);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                DialogOrContactPickerActivity.this.dialogsActivity.getActionBar().setSearchFieldText(editText.getText().toString());
                DialogOrContactPickerActivity.this.contactsActivity.getActionBar().setSearchFieldText(editText.getText().toString());
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setUseSameWidth(true);
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.3
            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public /* synthetic */ void onSamePageSelected() {
                ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int id, boolean forward) {
                if (DialogOrContactPickerActivity.this.viewPages[0].selectedType == id) {
                    return;
                }
                DialogOrContactPickerActivity dialogOrContactPickerActivity = DialogOrContactPickerActivity.this;
                dialogOrContactPickerActivity.swipeBackEnabled = id == dialogOrContactPickerActivity.scrollSlidingTextTabStrip.getFirstTabId();
                DialogOrContactPickerActivity.this.viewPages[1].selectedType = id;
                DialogOrContactPickerActivity.this.viewPages[1].setVisibility(0);
                DialogOrContactPickerActivity.this.switchToCurrentSelectedMode(true);
                DialogOrContactPickerActivity.this.animatingForward = forward;
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float progress) {
                if (progress != 1.0f || DialogOrContactPickerActivity.this.viewPages[1].getVisibility() == 0) {
                    if (DialogOrContactPickerActivity.this.animatingForward) {
                        DialogOrContactPickerActivity.this.viewPages[0].setTranslationX((-progress) * DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                        DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() - (DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() * progress));
                    } else {
                        DialogOrContactPickerActivity.this.viewPages[0].setTranslationX(DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() * progress);
                        DialogOrContactPickerActivity.this.viewPages[1].setTranslationX((DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() * progress) - DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                    }
                    if (progress == 1.0f) {
                        ViewPage viewPage = DialogOrContactPickerActivity.this.viewPages[0];
                        DialogOrContactPickerActivity.this.viewPages[0] = DialogOrContactPickerActivity.this.viewPages[1];
                        DialogOrContactPickerActivity.this.viewPages[1] = viewPage;
                        DialogOrContactPickerActivity.this.viewPages[1].setVisibility(8);
                    }
                }
            }
        });
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.4
            private boolean globalIgnoreLayout;
            private boolean maybeStartTracking;
            private boolean startedTracking;
            private int startedTrackingPointerId;
            private int startedTrackingX;
            private int startedTrackingY;
            private VelocityTracker velocityTracker;

            private boolean prepareForMoving(MotionEvent ev, boolean forward) {
                int nextPageId = DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.getNextPageId(forward);
                if (nextPageId < 0) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                this.maybeStartTracking = false;
                this.startedTracking = true;
                this.startedTrackingX = (int) ev.getX();
                ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.setEnabled(false);
                DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
                DialogOrContactPickerActivity.this.viewPages[1].selectedType = nextPageId;
                DialogOrContactPickerActivity.this.viewPages[1].setVisibility(0);
                DialogOrContactPickerActivity.this.animatingForward = forward;
                DialogOrContactPickerActivity.this.switchToCurrentSelectedMode(true);
                if (forward) {
                    DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                } else {
                    DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(-DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                }
                return true;
            }

            @Override // android.view.View
            public void forceHasOverlappingRendering(boolean hasOverlappingRendering) {
                super.forceHasOverlappingRendering(hasOverlappingRendering);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                measureChildWithMargins(((BaseFragment) DialogOrContactPickerActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                int measuredHeight = ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getMeasuredHeight();
                this.globalIgnoreLayout = true;
                for (int i = 0; i < DialogOrContactPickerActivity.this.viewPages.length; i++) {
                    if (DialogOrContactPickerActivity.this.viewPages[i] != null) {
                        if (DialogOrContactPickerActivity.this.viewPages[i].listView != null) {
                            DialogOrContactPickerActivity.this.viewPages[i].listView.setPadding(0, measuredHeight, 0, 0);
                        }
                        if (DialogOrContactPickerActivity.this.viewPages[i].listView2 != null) {
                            DialogOrContactPickerActivity.this.viewPages[i].listView2.setPadding(0, measuredHeight, 0, 0);
                        }
                    }
                }
                this.globalIgnoreLayout = false;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) DialogOrContactPickerActivity.this).actionBar) {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (((BaseFragment) DialogOrContactPickerActivity.this).parentLayout != null) {
                    ((BaseFragment) DialogOrContactPickerActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getMeasuredHeight() + ((int) ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getTranslationY()));
                }
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.globalIgnoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean checkTabsAnimationInProgress() {
                /*
                    r7 = this;
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    boolean r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$1900(r0)
                    r1 = 0
                    if (r0 == 0) goto Lc3
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    boolean r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$2000(r0)
                    r2 = -1
                    r3 = 0
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 1
                    if (r0 == 0) goto L59
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r1]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r1]
                    r0.setTranslationX(r3)
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r5]
                    ir.eitaa.ui.DialogOrContactPickerActivity r3 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r3 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r3)
                    r3 = r3[r1]
                    int r3 = r3.getMeasuredWidth()
                    ir.eitaa.ui.DialogOrContactPickerActivity r4 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    boolean r4 = ir.eitaa.ui.DialogOrContactPickerActivity.access$800(r4)
                    if (r4 == 0) goto L52
                    r2 = 1
                L52:
                    int r3 = r3 * r2
                    float r2 = (float) r3
                    r0.setTranslationX(r2)
                    goto L9e
                L59:
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r5]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r1]
                    ir.eitaa.ui.DialogOrContactPickerActivity r4 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r4 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r4)
                    r4 = r4[r1]
                    int r4 = r4.getMeasuredWidth()
                    ir.eitaa.ui.DialogOrContactPickerActivity r6 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    boolean r6 = ir.eitaa.ui.DialogOrContactPickerActivity.access$800(r6)
                    if (r6 == 0) goto L8a
                    goto L8b
                L8a:
                    r2 = 1
                L8b:
                    int r4 = r4 * r2
                    float r2 = (float) r4
                    r0.setTranslationX(r2)
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity$ViewPage[] r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$300(r0)
                    r0 = r0[r5]
                    r0.setTranslationX(r3)
                    goto L9e
                L9d:
                    r5 = 0
                L9e:
                    if (r5 == 0) goto Lbc
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$2100(r0)
                    if (r0 == 0) goto Lb7
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$2100(r0)
                    r0.cancel()
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    r2 = 0
                    ir.eitaa.ui.DialogOrContactPickerActivity.access$2102(r0, r2)
                Lb7:
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    ir.eitaa.ui.DialogOrContactPickerActivity.access$1902(r0, r1)
                Lbc:
                    ir.eitaa.ui.DialogOrContactPickerActivity r0 = ir.eitaa.ui.DialogOrContactPickerActivity.this
                    boolean r0 = ir.eitaa.ui.DialogOrContactPickerActivity.access$1900(r0)
                    return r0
                Lc3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DialogOrContactPickerActivity.AnonymousClass4.checkTabsAnimationInProgress():boolean");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return checkTabsAnimationInProgress() || DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(ev);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                DialogOrContactPickerActivity.this.backgroundPaint.setColor(Theme.getColor("windowBackgroundWhite"));
                canvas.drawRect(0.0f, ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getTranslationY(), getMeasuredWidth(), getMeasuredHeight(), DialogOrContactPickerActivity.this.backgroundPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent ev) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (((BaseFragment) DialogOrContactPickerActivity.this).parentLayout.checkTransitionAnimation() || checkTabsAnimationInProgress()) {
                    return false;
                }
                if (ev != null) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(ev);
                }
                if (ev != null && ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                    this.startedTrackingPointerId = ev.getPointerId(0);
                    this.maybeStartTracking = true;
                    this.startedTrackingX = (int) ev.getX();
                    this.startedTrackingY = (int) ev.getY();
                    this.velocityTracker.clear();
                } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                    int x = (int) (ev.getX() - this.startedTrackingX);
                    int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                    if (this.startedTracking && ((DialogOrContactPickerActivity.this.animatingForward && x > 0) || (!DialogOrContactPickerActivity.this.animatingForward && x < 0))) {
                        if (!prepareForMoving(ev, x < 0)) {
                            this.maybeStartTracking = true;
                            this.startedTracking = false;
                            DialogOrContactPickerActivity.this.viewPages[0].setTranslationX(0.0f);
                            DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(DialogOrContactPickerActivity.this.animatingForward ? DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() : -DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                            DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DialogOrContactPickerActivity.this.viewPages[1].selectedType, 0.0f);
                        }
                    }
                    if (!this.maybeStartTracking || this.startedTracking) {
                        if (this.startedTracking) {
                            DialogOrContactPickerActivity.this.viewPages[0].setTranslationX(x);
                            if (DialogOrContactPickerActivity.this.animatingForward) {
                                DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() + x);
                            } else {
                                DialogOrContactPickerActivity.this.viewPages[1].setTranslationX(x - DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                            }
                            DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DialogOrContactPickerActivity.this.viewPages[1].selectedType, Math.abs(x) / DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                        }
                    } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                        prepareForMoving(ev, x < 0);
                    }
                } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                    this.velocityTracker.computeCurrentVelocity(1000, DialogOrContactPickerActivity.this.maximumVelocity);
                    if (ev == null || ev.getAction() == 3) {
                        xVelocity = 0.0f;
                        yVelocity = 0.0f;
                    } else {
                        xVelocity = this.velocityTracker.getXVelocity();
                        yVelocity = this.velocityTracker.getYVelocity();
                        if (!this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                            prepareForMoving(ev, xVelocity < 0.0f);
                        }
                    }
                    if (this.startedTracking) {
                        float x2 = DialogOrContactPickerActivity.this.viewPages[0].getX();
                        DialogOrContactPickerActivity.this.tabsAnimation = new AnimatorSet();
                        DialogOrContactPickerActivity.this.backAnimation = Math.abs(x2) < ((float) DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                        if (!DialogOrContactPickerActivity.this.backAnimation) {
                            measuredWidth = DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth() - Math.abs(x2);
                            if (DialogOrContactPickerActivity.this.animatingForward) {
                                DialogOrContactPickerActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, -DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            } else {
                                DialogOrContactPickerActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            }
                        } else {
                            measuredWidth = Math.abs(x2);
                            if (DialogOrContactPickerActivity.this.animatingForward) {
                                DialogOrContactPickerActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, DialogOrContactPickerActivity.this.viewPages[1].getMeasuredWidth()));
                            } else {
                                DialogOrContactPickerActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(DialogOrContactPickerActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, -DialogOrContactPickerActivity.this.viewPages[1].getMeasuredWidth()));
                            }
                        }
                        DialogOrContactPickerActivity.this.tabsAnimation.setInterpolator(DialogOrContactPickerActivity.interpolator);
                        int measuredWidth3 = getMeasuredWidth();
                        float f = measuredWidth3 / 2;
                        float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                        float fAbs = Math.abs(xVelocity);
                        if (fAbs > 0.0f) {
                            measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                        } else {
                            measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                        }
                        DialogOrContactPickerActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                        DialogOrContactPickerActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.4.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                DialogOrContactPickerActivity.this.tabsAnimation = null;
                                if (DialogOrContactPickerActivity.this.backAnimation) {
                                    DialogOrContactPickerActivity.this.viewPages[1].setVisibility(8);
                                } else {
                                    ViewPage viewPage = DialogOrContactPickerActivity.this.viewPages[0];
                                    DialogOrContactPickerActivity.this.viewPages[0] = DialogOrContactPickerActivity.this.viewPages[1];
                                    DialogOrContactPickerActivity.this.viewPages[1] = viewPage;
                                    DialogOrContactPickerActivity.this.viewPages[1].setVisibility(8);
                                    DialogOrContactPickerActivity dialogOrContactPickerActivity = DialogOrContactPickerActivity.this;
                                    dialogOrContactPickerActivity.swipeBackEnabled = dialogOrContactPickerActivity.viewPages[0].selectedType == DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                    DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DialogOrContactPickerActivity.this.viewPages[0].selectedType, 1.0f);
                                }
                                DialogOrContactPickerActivity.this.tabsAnimationInProgress = false;
                                AnonymousClass4.this.maybeStartTracking = false;
                                AnonymousClass4.this.startedTracking = false;
                                ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.setEnabled(true);
                                DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                            }
                        });
                        DialogOrContactPickerActivity.this.tabsAnimation.start();
                        DialogOrContactPickerActivity.this.tabsAnimationInProgress = true;
                        this.startedTracking = false;
                    } else {
                        this.maybeStartTracking = false;
                        ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.setEnabled(true);
                        DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                return this.startedTracking;
            }
        };
        this.fragmentView = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.dialogsActivity.setParentFragment(this);
        this.contactsActivity.setParentFragment(this);
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                break;
            }
            viewPageArr[i] = new ViewPage(context) { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.5
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (DialogOrContactPickerActivity.this.tabsAnimationInProgress && DialogOrContactPickerActivity.this.viewPages[0] == this) {
                        DialogOrContactPickerActivity.this.scrollSlidingTextTabStrip.selectTabWithId(DialogOrContactPickerActivity.this.viewPages[1].selectedType, Math.abs(DialogOrContactPickerActivity.this.viewPages[0].getTranslationX()) / DialogOrContactPickerActivity.this.viewPages[0].getMeasuredWidth());
                    }
                }
            };
            frameLayout.addView(this.viewPages[i], LayoutHelper.createFrame(-1, -1.0f));
            if (i == 0) {
                this.viewPages[i].parentFragment = this.dialogsActivity;
                this.viewPages[i].listView = this.dialogsActivity.getListView();
                this.viewPages[i].listView2 = this.dialogsActivity.getSearchListView();
            } else if (i == 1) {
                this.viewPages[i].parentFragment = this.contactsActivity;
                this.viewPages[i].listView = this.contactsActivity.getListView();
                this.viewPages[i].setVisibility(8);
            }
            this.viewPages[i].listView.setScrollingTouchSlop(1);
            ViewPage[] viewPageArr2 = this.viewPages;
            viewPageArr2[i].fragmentView = (FrameLayout) viewPageArr2[i].parentFragment.getFragmentView();
            ViewPage[] viewPageArr3 = this.viewPages;
            viewPageArr3[i].actionBar = viewPageArr3[i].parentFragment.getActionBar();
            ViewPage[] viewPageArr4 = this.viewPages;
            viewPageArr4[i].addView(viewPageArr4[i].fragmentView, LayoutHelper.createFrame(-1, -1.0f));
            ViewPage[] viewPageArr5 = this.viewPages;
            viewPageArr5[i].addView(viewPageArr5[i].actionBar, LayoutHelper.createFrame(-1, -2.0f));
            this.viewPages[i].actionBar.setVisibility(8);
            int i2 = 0;
            while (i2 < 2) {
                ViewPage[] viewPageArr6 = this.viewPages;
                RecyclerListView recyclerListView = i2 == 0 ? viewPageArr6[i].listView : viewPageArr6[i].listView2;
                if (recyclerListView != null) {
                    recyclerListView.setClipToPadding(false);
                    final RecyclerView.OnScrollListener onScrollListener = recyclerListView.getOnScrollListener();
                    recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.DialogOrContactPickerActivity.6
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                            onScrollListener.onScrollStateChanged(recyclerView, newState);
                            if (newState != 1) {
                                int i3 = (int) (-((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getTranslationY());
                                int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                                if (i3 == 0 || i3 == currentActionBarHeight) {
                                    return;
                                }
                                if (i3 < currentActionBarHeight / 2) {
                                    int i4 = -i3;
                                    DialogOrContactPickerActivity.this.viewPages[0].listView.smoothScrollBy(0, i4);
                                    if (DialogOrContactPickerActivity.this.viewPages[0].listView2 != null) {
                                        DialogOrContactPickerActivity.this.viewPages[0].listView2.smoothScrollBy(0, i4);
                                        return;
                                    }
                                    return;
                                }
                                int i5 = currentActionBarHeight - i3;
                                DialogOrContactPickerActivity.this.viewPages[0].listView.smoothScrollBy(0, i5);
                                if (DialogOrContactPickerActivity.this.viewPages[0].listView2 != null) {
                                    DialogOrContactPickerActivity.this.viewPages[0].listView2.smoothScrollBy(0, i5);
                                }
                            }
                        }

                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            onScrollListener.onScrolled(recyclerView, dx, dy);
                            if (recyclerView == DialogOrContactPickerActivity.this.viewPages[0].listView || recyclerView == DialogOrContactPickerActivity.this.viewPages[0].listView2) {
                                float translationY = ((BaseFragment) DialogOrContactPickerActivity.this).actionBar.getTranslationY();
                                float f = translationY - dy;
                                if (f < (-ActionBar.getCurrentActionBarHeight())) {
                                    f = -ActionBar.getCurrentActionBarHeight();
                                } else if (f > 0.0f) {
                                    f = 0.0f;
                                }
                                if (f != translationY) {
                                    DialogOrContactPickerActivity.this.setScrollY(f);
                                }
                            }
                        }
                    });
                }
                i2++;
            }
            i++;
        }
        frameLayout.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        updateTabs();
        switchToCurrentSelectedMode(false);
        this.swipeBackEnabled = this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        DialogsActivity dialogsActivity = this.dialogsActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onResume();
        }
        ContactsActivity contactsActivity = this.contactsActivity;
        if (contactsActivity != null) {
            contactsActivity.onResume();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        DialogsActivity dialogsActivity = this.dialogsActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onPause();
        }
        ContactsActivity contactsActivity = this.contactsActivity;
        if (contactsActivity != null) {
            contactsActivity.onPause();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return this.swipeBackEnabled;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        DialogsActivity dialogsActivity = this.dialogsActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onFragmentDestroy();
        }
        ContactsActivity contactsActivity = this.contactsActivity;
        if (contactsActivity != null) {
            contactsActivity.onFragmentDestroy();
        }
        super.onFragmentDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollY(float value) {
        this.actionBar.setTranslationY(value);
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i < viewPageArr.length) {
                int i2 = (int) value;
                viewPageArr[i].listView.setPinnedSectionOffsetY(i2);
                if (this.viewPages[i].listView2 != null) {
                    this.viewPages[i].listView2.setPinnedSectionOffsetY(i2);
                }
                i++;
            } else {
                this.fragmentView.invalidate();
                return;
            }
        }
    }

    private void showBlockAlert(final TLRPC$User user) {
        if (user == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("BlockUser", R.string.BlockUser));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("AreYouSureBlockContact2", R.string.AreYouSureBlockContact2, ContactsController.formatName(user.first_name, user.last_name))));
        builder.setPositiveButton(LocaleController.getString("BlockContact", R.string.BlockContact), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$DialogOrContactPickerActivity$AZyr2stoCkkga8MIR9B7HAH_BLI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showBlockAlert$3$DialogOrContactPickerActivity(user, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showBlockAlert$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showBlockAlert$3$DialogOrContactPickerActivity(TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
        if (MessagesController.isSupportUser(tLRPC$User)) {
            AlertsCreator.showSimpleToast(this, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
        } else {
            MessagesController.getInstance(this.currentAccount).blockPeer(tLRPC$User.id);
            AlertsCreator.showSimpleToast(this, LocaleController.getString("UserBlocked", R.string.UserBlocked));
        }
        finishFragment();
    }

    private void updateTabs() {
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip == null) {
            return;
        }
        scrollSlidingTextTabStrip.addTextTab(0, LocaleController.getString("BlockUserChatsTitle", R.string.BlockUserChatsTitle));
        this.scrollSlidingTextTabStrip.addTextTab(1, LocaleController.getString("BlockUserContactsTitle", R.string.BlockUserContactsTitle));
        this.scrollSlidingTextTabStrip.setVisibility(0);
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        int currentTabId = this.scrollSlidingTextTabStrip.getCurrentTabId();
        if (currentTabId >= 0) {
            this.viewPages[0].selectedType = currentTabId;
        }
        this.scrollSlidingTextTabStrip.finishAddingTabs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                break;
            }
            viewPageArr[i].listView.stopScroll();
            if (this.viewPages[i].listView2 != null) {
                this.viewPages[i].listView2.stopScroll();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < 2) {
            ViewPage[] viewPageArr2 = this.viewPages;
            RecyclerListView recyclerListView = i2 == 0 ? viewPageArr2[z ? 1 : 0].listView : viewPageArr2[z ? 1 : 0].listView2;
            if (recyclerListView != null) {
                recyclerListView.getAdapter();
                recyclerListView.setPinnedHeaderShadowDrawable(null);
                if (this.actionBar.getTranslationY() != 0.0f) {
                    ((LinearLayoutManager) recyclerListView.getLayoutManager()).scrollToPositionWithOffset(0, (int) this.actionBar.getTranslationY());
                }
            }
            i2++;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabActiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "actionBarTabUnactiveText"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, "actionBarTabLine"));
        arrayList.add(new ThemeDescription(null, 0, null, null, new Drawable[]{this.scrollSlidingTextTabStrip.getSelectorDrawable()}, null, "actionBarTabSelector"));
        arrayList.addAll(this.dialogsActivity.getThemeDescriptions());
        arrayList.addAll(this.contactsActivity.getThemeDescriptions());
        return arrayList;
    }
}
