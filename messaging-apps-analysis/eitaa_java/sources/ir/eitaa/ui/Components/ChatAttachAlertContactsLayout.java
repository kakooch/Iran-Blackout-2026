package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChatAttachAlertContactsLayout extends ChatAttachAlert.AttachAlertLayout implements NotificationCenter.NotificationCenterDelegate {
    private PhonebookShareAlertDelegate delegate;
    private EmptyTextProgressView emptyView;
    private FrameLayout frameLayout;
    private boolean ignoreLayout;
    private LinearLayoutManager layoutManager;
    private ShareAdapter listAdapter;
    private RecyclerListView listView;
    private ShareSearchAdapter searchAdapter;
    private SearchField searchField;
    private View shadow;
    private AnimatorSet shadowAnimation;

    public interface PhonebookShareAlertDelegate {
        void didSelectContact(TLRPC$User user, boolean notify, int scheduleDate);
    }

    public static class UserCell extends FrameLayout {
        private AvatarDrawable avatarDrawable;
        private BackupImageView avatarImageView;
        private int currentAccount;
        private int currentId;
        private CharSequence currentName;
        private CharSequence currentStatus;
        private TLRPC$User currentUser;
        private TLRPC$FileLocation lastAvatar;
        private String lastName;
        private int lastStatus;
        private SimpleTextView nameTextView;
        private boolean needDivider;
        private final Theme.ResourcesProvider resourcesProvider;
        private SimpleTextView statusTextView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public UserCell(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.currentAccount = UserConfig.selectedAccount;
            this.resourcesProvider = resourcesProvider;
            this.avatarDrawable = new AvatarDrawable(resourcesProvider);
            BackupImageView backupImageView = new BackupImageView(context);
            this.avatarImageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(23.0f));
            BackupImageView backupImageView2 = this.avatarImageView;
            boolean z = LocaleController.isRTL;
            addView(backupImageView2, LayoutHelper.createFrame(46, 46.0f, (z ? 5 : 3) | 48, z ? 0.0f : 14.0f, 9.0f, z ? 14.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.nameTextView = simpleTextView;
            simpleTextView.setTextColor(getThemedColor("dialogTextBlack"));
            this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.nameTextView.setTextSize(16);
            this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            SimpleTextView simpleTextView2 = this.nameTextView;
            boolean z2 = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z2 ? 5 : 3) | 48, z2 ? 28.0f : 72.0f, 12.0f, z2 ? 72.0f : 28.0f, 0.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.statusTextView = simpleTextView3;
            simpleTextView3.setTextSize(13);
            this.statusTextView.setTextColor(getThemedColor("dialogTextGray2"));
            this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            SimpleTextView simpleTextView4 = this.statusTextView;
            boolean z3 = LocaleController.isRTL;
            addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? 28.0f : 72.0f, 36.0f, z3 ? 72.0f : 28.0f, 0.0f));
        }

        public void setCurrentId(int id) {
            this.currentId = id;
        }

        public void setData(TLRPC$User user, CharSequence name, CharSequence status, boolean divider) {
            if (user == null && name == null && status == null) {
                this.currentStatus = null;
                this.currentName = null;
                this.nameTextView.setText("");
                this.statusTextView.setText("");
                this.avatarImageView.setImageDrawable(null);
                return;
            }
            this.currentStatus = status;
            this.currentName = name;
            this.currentUser = user;
            this.needDivider = divider;
            setWillNotDraw(!divider);
            update(0);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x006f A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void update(int r12) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.UserCell.update(int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(70.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(70.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    public ChatAttachAlertContactsLayout(ChatAttachAlert alert, Context context, final Theme.ResourcesProvider resourcesProvider) {
        super(alert, context, resourcesProvider);
        this.searchAdapter = new ShareSearchAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setBackgroundColor(getThemedColor("dialogBackground"));
        SearchField searchField = new SearchField(context, false, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.1
            @Override // ir.eitaa.ui.Components.SearchField
            public void onTextChange(String text) throws InterruptedException {
                if (text.length() != 0) {
                    if (ChatAttachAlertContactsLayout.this.emptyView != null) {
                        ChatAttachAlertContactsLayout.this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                    }
                } else if (ChatAttachAlertContactsLayout.this.listView.getAdapter() != ChatAttachAlertContactsLayout.this.listAdapter) {
                    int currentTop = ChatAttachAlertContactsLayout.this.getCurrentTop();
                    ChatAttachAlertContactsLayout.this.emptyView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
                    ChatAttachAlertContactsLayout.this.emptyView.showTextView();
                    ChatAttachAlertContactsLayout.this.listView.setAdapter(ChatAttachAlertContactsLayout.this.listAdapter);
                    ChatAttachAlertContactsLayout.this.listAdapter.notifyDataSetChanged();
                    if (currentTop > 0) {
                        ChatAttachAlertContactsLayout.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                    }
                }
                if (ChatAttachAlertContactsLayout.this.searchAdapter != null) {
                    ChatAttachAlertContactsLayout.this.searchAdapter.search(text);
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                ChatAttachAlertContactsLayout.this.parentAlert.makeFocusable(getSearchEditText(), true);
                return super.onInterceptTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.SearchField
            public void processTouchEvent(MotionEvent event) {
                MotionEvent motionEventObtain = MotionEvent.obtain(event);
                motionEventObtain.setLocation(motionEventObtain.getRawX(), (motionEventObtain.getRawY() - ChatAttachAlertContactsLayout.this.parentAlert.getSheetContainer().getTranslationY()) - AndroidUtilities.dp(58.0f));
                ChatAttachAlertContactsLayout.this.listView.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }

            @Override // ir.eitaa.ui.Components.SearchField
            protected void onFieldTouchUp(EditTextBoldCursor editText) {
                ChatAttachAlertContactsLayout.this.parentAlert.makeFocusable(editText, true);
            }
        };
        this.searchField = searchField;
        searchField.setHint(LocaleController.getString("SearchFriends", R.string.SearchFriends));
        this.frameLayout.addView(this.searchField, LayoutHelper.createFrame(-1, -1, 51));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, null, resourcesProvider);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showTextView();
        this.emptyView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
        addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 52.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.2
            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) ((ChatAttachAlertContactsLayout.this.parentAlert.scrollOffsetY[0] + AndroidUtilities.dp(30.0f)) + ((Build.VERSION.SDK_INT < 21 || ChatAttachAlertContactsLayout.this.parentAlert.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight)));
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(getContext(), 1, false, AndroidUtilities.dp(9.0f), this.listView) { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.3.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, snapPreference) - (ChatAttachAlertContactsLayout.this.listView.getPaddingTop() - AndroidUtilities.dp(8.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int dx) {
                        return super.calculateTimeForDeceleration(dx) * 2;
                    }
                };
                linearSmoothScroller.setTargetPosition(position);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView2.setLayoutManager(fillLastLinearLayoutManager);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView3 = this.listView;
        ShareAdapter shareAdapter = new ShareAdapter(context);
        this.listAdapter = shareAdapter;
        recyclerListView3.setAdapter(shareAdapter);
        this.listView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$vEtFuFC9alkULUXfv_nPrsrRfoQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$1$ChatAttachAlertContactsLayout(resourcesProvider, view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ChatAttachAlertContactsLayout chatAttachAlertContactsLayout = ChatAttachAlertContactsLayout.this;
                chatAttachAlertContactsLayout.parentAlert.updateLayout(chatAttachAlertContactsLayout, true, dy);
                ChatAttachAlertContactsLayout.this.updateEmptyViewPosition();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(58.0f);
        View view = new View(context);
        this.shadow = view;
        view.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.shadow.setAlpha(0.0f);
        this.shadow.setTag(1);
        addView(this.shadow, layoutParams);
        addView(this.frameLayout, LayoutHelper.createFrame(-1, 58, 51));
        NotificationCenter.getInstance(this.parentAlert.currentAccount).addObserver(this, NotificationCenter.contactsDidLoad);
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlertContactsLayout(Theme.ResourcesProvider resourcesProvider, View view, int i) {
        Object item;
        ContactsController.Contact contact;
        String str;
        String str2;
        String str3;
        String str4;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ShareSearchAdapter shareSearchAdapter = this.searchAdapter;
        if (adapter == shareSearchAdapter) {
            item = shareSearchAdapter.getItem(i);
        } else {
            int sectionForPosition = this.listAdapter.getSectionForPosition(i);
            int positionInSectionForPosition = this.listAdapter.getPositionInSectionForPosition(i);
            if (positionInSectionForPosition < 0 || sectionForPosition < 0) {
                return;
            } else {
                item = this.listAdapter.getItem(sectionForPosition, positionInSectionForPosition);
            }
        }
        if (item != null) {
            if (item instanceof ContactsController.Contact) {
                ContactsController.Contact contact2 = (ContactsController.Contact) item;
                TLRPC$User tLRPC$User = contact2.user;
                if (tLRPC$User != null) {
                    str3 = tLRPC$User.first_name;
                    str4 = tLRPC$User.last_name;
                } else {
                    str3 = contact2.first_name;
                    str4 = contact2.last_name;
                }
                contact = contact2;
                str2 = str4;
                str = str3;
            } else {
                TLRPC$User tLRPC$User2 = (TLRPC$User) item;
                ContactsController.Contact contact3 = new ContactsController.Contact();
                String str5 = tLRPC$User2.first_name;
                contact3.first_name = str5;
                String str6 = tLRPC$User2.last_name;
                contact3.last_name = str6;
                contact3.phones.add(tLRPC$User2.phone);
                contact3.user = tLRPC$User2;
                contact = contact3;
                str = str5;
                str2 = str6;
            }
            PhonebookShareAlert phonebookShareAlert = new PhonebookShareAlert(this.parentAlert.baseFragment, contact, null, null, null, str, str2, resourcesProvider);
            phonebookShareAlert.setDelegate(new PhonebookShareAlertDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$g2V2vKcAH8_O95gF0B-x3GhaOSs
                @Override // ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate
                public final void didSelectContact(TLRPC$User tLRPC$User3, boolean z, int i2) {
                    this.f$0.lambda$new$0$ChatAttachAlertContactsLayout(tLRPC$User3, z, i2);
                }
            });
            phonebookShareAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAttachAlertContactsLayout(TLRPC$User tLRPC$User, boolean z, int i) {
        this.parentAlert.dismiss();
        this.delegate.didSelectContact(tLRPC$User, z, i);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.listView.getChildCount() <= 0) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        int i = (top <= 0 || holder == null || holder.getAdapterPosition() != 0) ? 0 : top;
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(false);
        } else {
            runShadowAnimation(true);
            top = i;
        }
        this.frameLayout.setTranslationY(top);
        return top + AndroidUtilities.dp(12.0f);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(4.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            ir.eitaa.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r0 = 1101004800(0x41a00000, float:20.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            r1 = 1
            r2 = 0
            if (r4 <= r0) goto L1e
            r4 = 1090519040(0x41000000, float:8.0)
            int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r2)
            goto L3c
        L1e:
            boolean r4 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L32
            android.graphics.Point r4 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r0 = r4.x
            int r4 = r4.y
            if (r0 <= r4) goto L32
            float r4 = (float) r5
            r5 = 1080033280(0x40600000, float:3.5)
            float r4 = r4 / r5
            int r4 = (int) r4
            goto L37
        L32:
            int r5 = r5 / 5
            int r5 = r5 * 2
            r4 = r5
        L37:
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L3c:
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L4d
            r3.ignoreLayout = r1
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            r5.setPadding(r2, r4, r2, r2)
            r3.ignoreLayout = r2
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.onPreMeasure(int, int):void");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    private void runShadowAnimation(final boolean show) {
        if ((!show || this.shadow.getTag() == null) && (show || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(show ? null : 1);
        if (show) {
            this.shadow.setVisibility(0);
        }
        AnimatorSet animatorSet = this.shadowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.shadowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ChatAttachAlertContactsLayout.this.shadowAnimation == null || !ChatAttachAlertContactsLayout.this.shadowAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    ChatAttachAlertContactsLayout.this.shadow.setVisibility(4);
                }
                ChatAttachAlertContactsLayout.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (ChatAttachAlertContactsLayout.this.shadowAnimation == null || !ChatAttachAlertContactsLayout.this.shadowAnimation.equals(animation)) {
                    return;
                }
                ChatAttachAlertContactsLayout.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentTop() {
        if (this.listView.getChildCount() == 0) {
            return -1000;
        }
        int top = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        if (holder == null) {
            return -1000;
        }
        int paddingTop = this.listView.getPaddingTop();
        if (holder.getAdapterPosition() == 0 && childAt.getTop() >= 0) {
            top = childAt.getTop();
        }
        return paddingTop - top;
    }

    public void setDelegate(PhonebookShareAlertDelegate phonebookShareAlertDelegate) {
        this.delegate = phonebookShareAlertDelegate;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ShareAdapter shareAdapter;
        if (id != NotificationCenter.contactsDidLoad || (shareAdapter = this.listAdapter) == null) {
            return;
        }
        shareAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() {
        NotificationCenter.getInstance(this.parentAlert.currentAccount).removeObserver(this, NotificationCenter.contactsDidLoad);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        this.layoutManager.scrollToPositionWithOffset(0, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateEmptyViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyViewPosition() {
        View childAt;
        if (this.emptyView.getVisibility() == 0 && (childAt = this.listView.getChildAt(0)) != null) {
            this.emptyView.setTranslationY(((r1.getMeasuredHeight() - getMeasuredHeight()) + childAt.getTop()) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        this.emptyView.setVisibility(this.listView.getAdapter().getItemCount() == 2 ? 0 : 8);
        updateEmptyViewPosition();
    }

    public class ShareAdapter extends RecyclerListView.SectionsAdapter {
        private int currentAccount = UserConfig.selectedAccount;
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            return null;
        }

        public ShareAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            if (section == 0) {
                return null;
            }
            int i = section - 1;
            HashMap<String, ArrayList<Object>> map = ContactsController.getInstance(this.currentAccount).phoneBookSectionsDict;
            ArrayList<String> arrayList = ContactsController.getInstance(this.currentAccount).phoneBookSectionsArray;
            if (i < arrayList.size()) {
                ArrayList<Object> arrayList2 = map.get(arrayList.get(i));
                if (position < arrayList2.size()) {
                    return arrayList2.get(position);
                }
            }
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            if (section == 0 || section == getSectionCount() - 1) {
                return false;
            }
            return row < ContactsController.getInstance(this.currentAccount).phoneBookSectionsDict.get(ContactsController.getInstance(this.currentAccount).phoneBookSectionsArray.get(section + (-1))).size();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            return ContactsController.getInstance(this.currentAccount).phoneBookSectionsArray.size() + 2;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if (section == 0 || section == getSectionCount() - 1) {
                return 1;
            }
            int i = section - 1;
            HashMap<String, ArrayList<Object>> map = ContactsController.getInstance(this.currentAccount).phoneBookSectionsDict;
            ArrayList<String> arrayList = ContactsController.getInstance(this.currentAccount).phoneBookSectionsArray;
            if (i < arrayList.size()) {
                return map.get(arrayList.get(i)).size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View userCell;
            if (viewType == 0) {
                userCell = new UserCell(this.mContext, ChatAttachAlertContactsLayout.this.resourcesProvider);
            } else if (viewType == 1) {
                userCell = new View(this.mContext);
                userCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
            } else {
                userCell = new View(this.mContext);
            }
            return new RecyclerListView.Holder(userCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            TLRPC$User tLRPC$User;
            if (holder.getItemViewType() == 0) {
                UserCell userCell = (UserCell) holder.itemView;
                Object item = getItem(section, position);
                boolean z = true;
                if (section == getSectionCount() - 2 && position == getCountForSection(section) - 1) {
                    z = false;
                }
                if (item instanceof ContactsController.Contact) {
                    ContactsController.Contact contact = (ContactsController.Contact) item;
                    tLRPC$User = contact.user;
                    if (tLRPC$User == null) {
                        userCell.setCurrentId(contact.contact_id);
                        userCell.setData(null, ContactsController.formatName(contact.first_name, contact.last_name), contact.phones.isEmpty() ? "" : PhoneFormat.getInstance().format(contact.phones.get(0)), z);
                        tLRPC$User = null;
                    }
                } else {
                    tLRPC$User = (TLRPC$User) item;
                }
                if (tLRPC$User != null) {
                    userCell.setData(tLRPC$User, null, PhoneFormat.getInstance().format("+" + tLRPC$User.phone), z);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (section == 0) {
                return 1;
            }
            return section == getSectionCount() - 1 ? 2 : 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertContactsLayout.this.updateEmptyView();
        }
    }

    public class ShareSearchAdapter extends RecyclerListView.SelectionAdapter {
        private int lastSearchId;
        private Context mContext;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private Runnable searchRunnable;

        public ShareSearchAdapter(Context context) {
            this.mContext = context;
        }

        public void search(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (query == null) {
                this.searchResult.clear();
                this.searchResultNames.clear();
                notifyDataSetChanged();
            } else {
                final int i = this.lastSearchId + 1;
                this.lastSearchId = i;
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$ShareSearchAdapter$O4KUIlvUGxcF5MKMc8Ouxsirx7s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$0$ChatAttachAlertContactsLayout$ShareSearchAdapter(query, i);
                    }
                };
                this.searchRunnable = runnable;
                dispatchQueue.postRunnable(runnable, 300L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$search$0$ChatAttachAlertContactsLayout$ShareSearchAdapter(final String query, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$ShareSearchAdapter$sZaraZ8ZyjEaXh8KSDQipFl9vDU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2$ChatAttachAlertContactsLayout$ShareSearchAdapter(query, searchId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$2$ChatAttachAlertContactsLayout$ShareSearchAdapter(final String str, final int i) {
            final int i2 = UserConfig.selectedAccount;
            final ArrayList arrayList = new ArrayList(ContactsController.getInstance(i2).contactsBook.values());
            final ArrayList arrayList2 = new ArrayList(ContactsController.getInstance(i2).contacts);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$ShareSearchAdapter$gM9PC0KLQP-Jzpsnzqt4pCIUZeg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$1$ChatAttachAlertContactsLayout$ShareSearchAdapter(str, arrayList, arrayList2, i2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0231  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0270 A[LOOP:3: B:85:0x01e8->B:108:0x0270, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0134 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0234 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x018c A[LOOP:1: B:29:0x00a5->B:73:0x018c, LOOP_END] */
        /* JADX WARN: Type inference failed for: r18v0, types: [ir.eitaa.ui.Components.ChatAttachAlertContactsLayout$ShareSearchAdapter] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* renamed from: lambda$processSearch$1, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$1$ChatAttachAlertContactsLayout$ShareSearchAdapter(java.lang.String r19, java.util.ArrayList r20, java.util.ArrayList r21, int r22, int r23) {
            /*
                Method dump skipped, instructions count: 644
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.ShareSearchAdapter.lambda$processSearch$1$ChatAttachAlertContactsLayout$ShareSearchAdapter(java.lang.String, java.util.ArrayList, java.util.ArrayList, int, int):void");
        }

        private void updateSearchResults(final String query, final ArrayList<Object> users, final ArrayList<CharSequence> names, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$ShareSearchAdapter$y1Kz1qRvmhs-SNXbliMn6cO8HFY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$3$ChatAttachAlertContactsLayout$ShareSearchAdapter(searchId, users, names);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$3$ChatAttachAlertContactsLayout$ShareSearchAdapter(int i, ArrayList arrayList, ArrayList arrayList2) {
            if (i != this.lastSearchId) {
                return;
            }
            if (i != -1 && ChatAttachAlertContactsLayout.this.listView.getAdapter() != ChatAttachAlertContactsLayout.this.searchAdapter) {
                ChatAttachAlertContactsLayout.this.listView.setAdapter(ChatAttachAlertContactsLayout.this.searchAdapter);
            }
            this.searchResult = arrayList;
            this.searchResultNames = arrayList2;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.searchResult.size() + 2;
        }

        public Object getItem(int position) {
            int i = position - 1;
            if (i < 0 || i >= this.searchResult.size()) {
                return null;
            }
            return this.searchResult.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View userCell;
            if (viewType == 0) {
                userCell = new UserCell(this.mContext, ChatAttachAlertContactsLayout.this.resourcesProvider);
            } else if (viewType == 1) {
                userCell = new View(this.mContext);
                userCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
            } else {
                userCell = new View(this.mContext);
            }
            return new RecyclerListView.Holder(userCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLRPC$User tLRPC$User;
            if (holder.getItemViewType() == 0) {
                UserCell userCell = (UserCell) holder.itemView;
                boolean z = position != getItemCount() + (-2);
                Object item = getItem(position);
                if (item instanceof ContactsController.Contact) {
                    ContactsController.Contact contact = (ContactsController.Contact) item;
                    tLRPC$User = contact.user;
                    if (tLRPC$User == null) {
                        userCell.setCurrentId(contact.contact_id);
                        userCell.setData(null, this.searchResultNames.get(position - 1), contact.phones.isEmpty() ? "" : PhoneFormat.getInstance().format(contact.phones.get(0)), z);
                        tLRPC$User = null;
                    }
                } else {
                    tLRPC$User = (TLRPC$User) item;
                }
                if (tLRPC$User != null) {
                    userCell.setData(tLRPC$User, this.searchResultNames.get(position - 1), PhoneFormat.getInstance().format("+" + tLRPC$User.phone), z);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 1;
            }
            return position == getItemCount() - 1 ? 2 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertContactsLayout.this.updateEmptyView();
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertContactsLayout$oiGyeNODprjzM6lCml_g2bc0Zk4
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$2$ChatAttachAlertContactsLayout();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.frameLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.shadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchBackground(), ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogSearchBackground"));
        arrayList.add(new ThemeDescription(this.searchField, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SearchField.class}, new String[]{"searchIconImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogSearchIcon"));
        arrayList.add(new ThemeDescription(this.searchField, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SearchField.class}, new String[]{"clearSearchImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogSearchIcon"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogSearchText"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "dialogSearchHint"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "featuredStickers_addedIcon"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogTextGray2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "dialogTextGray2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$2$ChatAttachAlertContactsLayout() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(0);
                }
            }
        }
    }
}
