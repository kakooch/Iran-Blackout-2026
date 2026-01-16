package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$TL_channels_createChannel;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.GroupCreateSectionCell;
import org.rbmain.ui.Cells.GroupCreateUserCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.GroupCreateDividerItemDecoration;
import org.rbmain.ui.Components.GroupCreateSpan;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PermanentLinkBottomSheet;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.StickerEmptyView;
import org.rbmain.ui.Components.TypefaceSpan;
import org.rbmain.ui.Components.VerticalPositionAutoAnimator;

/* loaded from: classes4.dex */
public class GroupCreateActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, View.OnClickListener {
    private String about;
    private GroupCreateAdapter adapter;
    private boolean addToGroup;
    private ArrayList<GroupCreateSpan> allSpans;
    private int channelId;
    private int chatAddType;
    private int chatId;
    private int chatType;
    private int containerHeight;
    private AnimatorSet currentAnimation;
    private GroupCreateSpan currentDeletingSpan;
    private AnimatorSet currentDoneButtonAnimation;
    private GroupCreateActivityDelegate delegate;
    private ContactsAddActivityDelegate delegate2;
    private boolean doneButtonVisible;
    private EditTextBoldCursor editText;
    private StickerEmptyView emptyView;
    private int fieldY;
    private ImageView floatingButton;
    private boolean forImport;
    private boolean ignoreScrollEvent;
    private SparseArray<TLObject> ignoreUsers;
    private TLRPC$ChatFull info;
    private boolean isAlwaysShare;
    private boolean isNeverShare;
    private boolean isPublic;
    private GroupCreateDividerItemDecoration itemDecoration;
    private RecyclerListView listView;
    private int maxCount;
    int maxSize;
    private int measuredContainerHeight;
    private long photoId;
    private AlertDialog progressDialog;
    private ScrollView scrollView;
    private boolean searchWas;
    private boolean searching;
    private SparseArray<GroupCreateSpan> selectedContacts;
    private PermanentLinkBottomSheet sharedLinkBottomSheet;
    private long smallPhotoId;
    private SpansContainer spansContainer;
    private String title;

    public interface ContactsAddActivityDelegate {

        /* renamed from: org.rbmain.ui.GroupCreateActivity$ContactsAddActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$needAddBot(ContactsAddActivityDelegate contactsAddActivityDelegate, TLRPC$User tLRPC$User) {
            }
        }

        void didSelectUsers(ArrayList<TLRPC$User> arrayList, int i);

        void needAddBot(TLRPC$User tLRPC$User);
    }

    public interface GroupCreateActivityDelegate {
        void didSelectUsers(ArrayList<Integer> arrayList);
    }

    private class SpansContainer extends ViewGroup {
        private View addingSpan;
        private int animationIndex;
        private boolean animationStarted;
        private ArrayList<Animator> animators;
        private View removingSpan;

        public SpansContainer(Context context) {
            super(context);
            this.animators = new ArrayList<>();
            this.animationIndex = -1;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int iMin;
            boolean z;
            char c;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i);
            int iDp = size - AndroidUtilities.dp(26.0f);
            int iDp2 = AndroidUtilities.dp(10.0f);
            int iDp3 = AndroidUtilities.dp(10.0f);
            int measuredWidth = 0;
            int measuredWidth2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof GroupCreateSpan) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                    if (childAt != this.removingSpan && childAt.getMeasuredWidth() + measuredWidth > iDp) {
                        iDp2 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth = 0;
                    }
                    if (childAt.getMeasuredWidth() + measuredWidth2 > iDp) {
                        iDp3 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth2 = 0;
                    }
                    int iDp4 = AndroidUtilities.dp(13.0f) + measuredWidth;
                    if (!this.animationStarted) {
                        View view = this.removingSpan;
                        if (childAt == view) {
                            childAt.setTranslationX(AndroidUtilities.dp(13.0f) + measuredWidth2);
                            childAt.setTranslationY(iDp3);
                        } else if (view != null) {
                            float f = iDp4;
                            if (childAt.getTranslationX() != f) {
                                c = 0;
                                this.animators.add(ObjectAnimator.ofFloat(childAt, "translationX", f));
                            } else {
                                c = 0;
                            }
                            float f2 = iDp2;
                            if (childAt.getTranslationY() != f2) {
                                ArrayList<Animator> arrayList = this.animators;
                                float[] fArr = new float[1];
                                fArr[c] = f2;
                                arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", fArr));
                            }
                        } else {
                            childAt.setTranslationX(iDp4);
                            childAt.setTranslationY(iDp2);
                        }
                    }
                    if (childAt != this.removingSpan) {
                        measuredWidth += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                    }
                    measuredWidth2 += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                }
            }
            if (AndroidUtilities.isTablet()) {
                iMin = AndroidUtilities.dp(372.0f) / 3;
            } else {
                Point point = AndroidUtilities.displaySize;
                iMin = (Math.min(point.x, point.y) - AndroidUtilities.dp(158.0f)) / 3;
            }
            if (iDp - measuredWidth < iMin) {
                iDp2 += AndroidUtilities.dp(40.0f);
                measuredWidth = 0;
            }
            if (iDp - measuredWidth2 < iMin) {
                iDp3 += AndroidUtilities.dp(40.0f);
            }
            GroupCreateActivity.this.editText.measure(View.MeasureSpec.makeMeasureSpec(iDp - measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
            if (this.animationStarted) {
                if (GroupCreateActivity.this.currentAnimation != null && !GroupCreateActivity.this.ignoreScrollEvent && this.removingSpan == null) {
                    GroupCreateActivity.this.editText.bringPointIntoView(GroupCreateActivity.this.editText.getSelectionStart());
                }
            } else {
                int iDp5 = iDp3 + AndroidUtilities.dp(42.0f);
                int iDp6 = measuredWidth + AndroidUtilities.dp(16.0f);
                GroupCreateActivity.this.fieldY = iDp2;
                if (GroupCreateActivity.this.currentAnimation != null) {
                    int iDp7 = iDp2 + AndroidUtilities.dp(42.0f);
                    if (GroupCreateActivity.this.containerHeight != iDp7) {
                        this.animators.add(ObjectAnimator.ofInt(GroupCreateActivity.this, "containerHeight", iDp7));
                    }
                    GroupCreateActivity groupCreateActivity = GroupCreateActivity.this;
                    groupCreateActivity.measuredContainerHeight = Math.max(groupCreateActivity.containerHeight, iDp7);
                    float f3 = iDp6;
                    if (GroupCreateActivity.this.editText.getTranslationX() != f3) {
                        this.animators.add(ObjectAnimator.ofFloat(GroupCreateActivity.this.editText, "translationX", f3));
                    }
                    if (GroupCreateActivity.this.editText.getTranslationY() != GroupCreateActivity.this.fieldY) {
                        z = false;
                        this.animators.add(ObjectAnimator.ofFloat(GroupCreateActivity.this.editText, "translationY", GroupCreateActivity.this.fieldY));
                    } else {
                        z = false;
                    }
                    GroupCreateActivity.this.editText.setAllowDrawCursor(z);
                    GroupCreateActivity.this.currentAnimation.playTogether(this.animators);
                    GroupCreateActivity.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCreateActivity.SpansContainer.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            GroupCreateActivity.this.getNotificationCenter().onAnimationFinish(SpansContainer.this.animationIndex);
                            SpansContainer.this.requestLayout();
                        }
                    });
                    this.animationIndex = GroupCreateActivity.this.getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
                    GroupCreateActivity.this.currentAnimation.start();
                    this.animationStarted = true;
                } else {
                    GroupCreateActivity groupCreateActivity2 = GroupCreateActivity.this;
                    groupCreateActivity2.measuredContainerHeight = groupCreateActivity2.containerHeight = iDp5;
                    GroupCreateActivity.this.editText.setTranslationX(iDp6);
                    GroupCreateActivity.this.editText.setTranslationY(GroupCreateActivity.this.fieldY);
                }
            }
            setMeasuredDimension(size, GroupCreateActivity.this.measuredContainerHeight);
            GroupCreateActivity.this.listView.setTranslationY(0.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        public void addSpan(GroupCreateSpan groupCreateSpan) {
            GroupCreateActivity.this.allSpans.add(groupCreateSpan);
            GroupCreateActivity.this.selectedContacts.put(groupCreateSpan.getUid(), groupCreateSpan);
            GroupCreateActivity.this.editText.setHintVisible(false);
            if (GroupCreateActivity.this.currentAnimation != null) {
                GroupCreateActivity.this.currentAnimation.setupEndValues();
                GroupCreateActivity.this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            GroupCreateActivity.this.currentAnimation = new AnimatorSet();
            GroupCreateActivity.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCreateActivity.SpansContainer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.addingSpan = null;
                    GroupCreateActivity.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                    GroupCreateActivity.this.editText.setAllowDrawCursor(true);
                }
            });
            GroupCreateActivity.this.currentAnimation.setDuration(150L);
            this.addingSpan = groupCreateSpan;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.SCALE_X, 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.SCALE_Y, 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
            addView(groupCreateSpan);
        }

        public void removeSpan(final GroupCreateSpan groupCreateSpan) {
            GroupCreateActivity.this.ignoreScrollEvent = true;
            GroupCreateActivity.this.selectedContacts.remove(groupCreateSpan.getUid());
            GroupCreateActivity.this.allSpans.remove(groupCreateSpan);
            groupCreateSpan.setOnClickListener(null);
            if (GroupCreateActivity.this.currentAnimation != null) {
                GroupCreateActivity.this.currentAnimation.setupEndValues();
                GroupCreateActivity.this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            GroupCreateActivity.this.currentAnimation = new AnimatorSet();
            GroupCreateActivity.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCreateActivity.SpansContainer.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.removeView(groupCreateSpan);
                    SpansContainer.this.removingSpan = null;
                    GroupCreateActivity.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                    GroupCreateActivity.this.editText.setAllowDrawCursor(true);
                    if (GroupCreateActivity.this.allSpans.isEmpty()) {
                        GroupCreateActivity.this.editText.setHintVisible(true);
                    }
                }
            });
            GroupCreateActivity.this.currentAnimation.setDuration(150L);
            this.removingSpan = groupCreateSpan;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_X, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
            requestLayout();
        }
    }

    public GroupCreateActivity() {
        this.maxCount = getMessagesController().maxMegagroupCount;
        this.chatType = 0;
        this.selectedContacts = new SparseArray<>();
        this.allSpans = new ArrayList<>();
    }

    public GroupCreateActivity(Bundle bundle) {
        super(bundle);
        this.maxCount = getMessagesController().maxMegagroupCount;
        this.chatType = 0;
        this.selectedContacts = new SparseArray<>();
        this.allSpans = new ArrayList<>();
        this.chatType = bundle.getInt("chatType", 0);
        this.forImport = bundle.getBoolean("forImport", false);
        this.isAlwaysShare = bundle.getBoolean("isAlwaysShare", false);
        this.isNeverShare = bundle.getBoolean("isNeverShare", false);
        this.addToGroup = bundle.getBoolean("addToGroup", false);
        this.chatAddType = bundle.getInt("chatAddType", 0);
        this.chatId = bundle.getInt("chatId");
        this.channelId = bundle.getInt("channelId");
        if (this.isAlwaysShare || this.isNeverShare) {
            this.maxCount = 0;
        } else if (this.addToGroup || this.chatType == 2) {
            this.maxCount = 25;
        } else {
            this.maxCount = 100;
        }
        if (this.chatType == 2) {
            this.title = bundle.getString("title", null);
            this.about = bundle.getString("about", null);
            this.photoId = bundle.getLong("photo_id", 0L);
            this.smallPhotoId = bundle.getLong("small_photo_id", 0L);
            this.isPublic = bundle.getBoolean("isPublic", false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.contactsDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().addObserver(this, NotificationCenter.chatDidCreated);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.contactsDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().removeObserver(this, NotificationCenter.chatDidCreated);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GroupCreateSpan groupCreateSpan = (GroupCreateSpan) view;
        if (groupCreateSpan.isDeleting()) {
            this.currentDeletingSpan = null;
            this.spansContainer.removeSpan(groupCreateSpan);
            updateHint();
            checkVisibleRows();
            return;
        }
        GroupCreateSpan groupCreateSpan2 = this.currentDeletingSpan;
        if (groupCreateSpan2 != null) {
            groupCreateSpan2.cancelDeleteAnimation();
        }
        this.currentDeletingSpan = groupCreateSpan;
        groupCreateSpan.startDeleteAnimation();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) throws NoSuchFieldException {
        int i;
        String str;
        this.searching = false;
        this.searchWas = false;
        this.allSpans.clear();
        this.selectedContacts.clear();
        this.currentDeletingSpan = null;
        this.doneButtonVisible = this.chatType == 2;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i2 = this.chatType;
        if (i2 == 2) {
            this.actionBar.setTitle(LocaleController.getString("ChannelAddSubscribers", R.string.ChannelAddSubscribers));
        } else if (this.addToGroup) {
            if (this.channelId != 0) {
                this.actionBar.setTitle(LocaleController.getString("ChannelAddSubscribers", R.string.ChannelAddSubscribers));
            } else {
                this.actionBar.setTitle(LocaleController.getString("GroupAddMembers", R.string.GroupAddMembers));
            }
        } else if (this.isAlwaysShare) {
            int i3 = this.chatAddType;
            if (i3 == 2) {
                this.actionBar.setTitle(LocaleController.getString("FilterAlwaysShow", R.string.FilterAlwaysShow));
            } else if (i3 == 1) {
                this.actionBar.setTitle(LocaleController.getString("AlwaysAllow", R.string.AlwaysAllow));
            } else {
                this.actionBar.setTitle(LocaleController.getString("AlwaysShareWithTitle", R.string.AlwaysShareWithTitle));
            }
        } else if (this.isNeverShare) {
            int i4 = this.chatAddType;
            if (i4 == 2) {
                this.actionBar.setTitle(LocaleController.getString("FilterNeverShow", R.string.FilterNeverShow));
            } else if (i4 == 1) {
                this.actionBar.setTitle(LocaleController.getString("NeverAllow", R.string.NeverAllow));
            } else {
                this.actionBar.setTitle(LocaleController.getString("NeverShareWithTitle", R.string.NeverShareWithTitle));
            }
        } else {
            ActionBar actionBar = this.actionBar;
            if (i2 == 0) {
                i = R.string.NewGroup;
                str = "NewGroup";
            } else {
                i = R.string.NewBroadcastList;
                str = "NewBroadcastList";
            }
            actionBar.setTitle(LocaleController.getString(str, i));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.GroupCreateActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i5) {
                if (i5 == -1) {
                    GroupCreateActivity.this.finishFragment();
                } else if (i5 == 1) {
                    GroupCreateActivity.this.onDonePressed(true);
                }
            }
        });
        ViewGroup viewGroup = new ViewGroup(context) { // from class: org.rbmain.ui.GroupCreateActivity.2
            private VerticalPositionAutoAnimator verticalPositionAutoAnimator;

            @Override // android.view.ViewGroup
            public void onViewAdded(View view) {
                if (view == GroupCreateActivity.this.floatingButton && this.verticalPositionAutoAnimator == null) {
                    this.verticalPositionAutoAnimator = VerticalPositionAutoAnimator.attach(view);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                VerticalPositionAutoAnimator verticalPositionAutoAnimator = this.verticalPositionAutoAnimator;
                if (verticalPositionAutoAnimator != null) {
                    verticalPositionAutoAnimator.ignoreNextLayout();
                }
            }

            @Override // android.view.View
            protected void onMeasure(int i5, int i6) {
                int size = View.MeasureSpec.getSize(i5);
                int size2 = View.MeasureSpec.getSize(i6);
                setMeasuredDimension(size, size2);
                if (AndroidUtilities.isTablet() || size2 > size) {
                    GroupCreateActivity.this.maxSize = AndroidUtilities.dp(144.0f);
                } else {
                    GroupCreateActivity.this.maxSize = AndroidUtilities.dp(56.0f);
                }
                GroupCreateActivity.this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(GroupCreateActivity.this.maxSize, Integer.MIN_VALUE));
                GroupCreateActivity.this.listView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - GroupCreateActivity.this.scrollView.getMeasuredHeight(), 1073741824));
                GroupCreateActivity.this.emptyView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - GroupCreateActivity.this.scrollView.getMeasuredHeight(), 1073741824));
                if (GroupCreateActivity.this.floatingButton != null) {
                    int iDp = AndroidUtilities.dp(Build.VERSION.SDK_INT < 21 ? 60.0f : 56.0f);
                    GroupCreateActivity.this.floatingButton.measure(View.MeasureSpec.makeMeasureSpec(iDp, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp, 1073741824));
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i5, int i6, int i7, int i8) {
                GroupCreateActivity.this.scrollView.layout(0, 0, GroupCreateActivity.this.scrollView.getMeasuredWidth(), GroupCreateActivity.this.scrollView.getMeasuredHeight());
                GroupCreateActivity.this.listView.layout(0, GroupCreateActivity.this.scrollView.getMeasuredHeight(), GroupCreateActivity.this.listView.getMeasuredWidth(), GroupCreateActivity.this.scrollView.getMeasuredHeight() + GroupCreateActivity.this.listView.getMeasuredHeight());
                GroupCreateActivity.this.emptyView.layout(0, GroupCreateActivity.this.scrollView.getMeasuredHeight(), GroupCreateActivity.this.emptyView.getMeasuredWidth(), GroupCreateActivity.this.scrollView.getMeasuredHeight() + GroupCreateActivity.this.emptyView.getMeasuredHeight());
                if (GroupCreateActivity.this.floatingButton != null) {
                    int iDp = LocaleController.isRTL ? AndroidUtilities.dp(14.0f) : ((i7 - i5) - AndroidUtilities.dp(14.0f)) - GroupCreateActivity.this.floatingButton.getMeasuredWidth();
                    int iDp2 = ((i8 - i6) - AndroidUtilities.dp(14.0f)) - GroupCreateActivity.this.floatingButton.getMeasuredHeight();
                    GroupCreateActivity.this.floatingButton.layout(iDp, iDp2, GroupCreateActivity.this.floatingButton.getMeasuredWidth() + iDp, GroupCreateActivity.this.floatingButton.getMeasuredHeight() + iDp2);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                ActionBarLayout actionBarLayout = ((BaseFragment) GroupCreateActivity.this).parentLayout;
                GroupCreateActivity groupCreateActivity = GroupCreateActivity.this;
                actionBarLayout.drawHeaderShadow(canvas, Math.min(groupCreateActivity.maxSize, (groupCreateActivity.measuredContainerHeight + GroupCreateActivity.this.containerHeight) - GroupCreateActivity.this.measuredContainerHeight));
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (view != GroupCreateActivity.this.listView) {
                    if (view == GroupCreateActivity.this.scrollView) {
                        canvas.save();
                        int left = view.getLeft();
                        int top = view.getTop();
                        int right = view.getRight();
                        GroupCreateActivity groupCreateActivity = GroupCreateActivity.this;
                        canvas.clipRect(left, top, right, Math.min(groupCreateActivity.maxSize, (groupCreateActivity.measuredContainerHeight + GroupCreateActivity.this.containerHeight) - GroupCreateActivity.this.measuredContainerHeight));
                        boolean zDrawChild = super.drawChild(canvas, view, j);
                        canvas.restore();
                        return zDrawChild;
                    }
                    return super.drawChild(canvas, view, j);
                }
                canvas.save();
                int left2 = view.getLeft();
                GroupCreateActivity groupCreateActivity2 = GroupCreateActivity.this;
                canvas.clipRect(left2, Math.min(groupCreateActivity2.maxSize, (groupCreateActivity2.measuredContainerHeight + GroupCreateActivity.this.containerHeight) - GroupCreateActivity.this.measuredContainerHeight), view.getRight(), view.getBottom());
                boolean zDrawChild2 = super.drawChild(canvas, view, j);
                canvas.restore();
                return zDrawChild2;
            }
        };
        this.fragmentView = viewGroup;
        ViewGroup viewGroup2 = viewGroup;
        viewGroup2.setFocusableInTouchMode(true);
        viewGroup2.setDescendantFocusability(MessagesController.UPDATE_MASK_REORDER);
        ScrollView scrollView = new ScrollView(context) { // from class: org.rbmain.ui.GroupCreateActivity.3
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                if (GroupCreateActivity.this.ignoreScrollEvent) {
                    GroupCreateActivity.this.ignoreScrollEvent = false;
                    return false;
                }
                rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
                rect.top += GroupCreateActivity.this.fieldY + AndroidUtilities.dp(20.0f);
                rect.bottom += GroupCreateActivity.this.fieldY + AndroidUtilities.dp(50.0f);
                return super.requestChildRectangleOnScreen(view, rect, z);
            }
        };
        this.scrollView = scrollView;
        scrollView.setClipChildren(false);
        viewGroup2.setClipChildren(false);
        this.scrollView.setVerticalScrollBarEnabled(false);
        AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor(Theme.key_windowBackgroundWhite));
        viewGroup2.addView(this.scrollView);
        SpansContainer spansContainer = new SpansContainer(context);
        this.spansContainer = spansContainer;
        this.scrollView.addView(spansContainer, LayoutHelper.createFrame(-1, -2.0f));
        this.spansContainer.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: org.rbmain.ui.GroupCreateActivity.4
            @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (GroupCreateActivity.this.currentDeletingSpan != null) {
                    GroupCreateActivity.this.currentDeletingSpan.cancelDeleteAnimation();
                    GroupCreateActivity.this.currentDeletingSpan = null;
                }
                if (motionEvent.getAction() == 0 && !AndroidUtilities.showKeyboard(this)) {
                    clearFocus();
                    requestFocus();
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 16.0f);
        this.editText.setHintColor(Theme.getColor(Theme.key_groupcreate_hintText));
        this.editText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.editText.setCursorColor(Theme.getColor(Theme.key_groupcreate_cursor));
        this.editText.setCursorWidth(1.5f);
        this.editText.setInputType(655536);
        this.editText.setSingleLine(true);
        this.editText.setBackgroundDrawable(null);
        this.editText.setVerticalScrollBarEnabled(false);
        this.editText.setHorizontalScrollBarEnabled(false);
        this.editText.setTextIsSelectable(false);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setImeOptions(268435462);
        this.editText.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.spansContainer.addView(this.editText);
        updateEditTextHint();
        this.editText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: org.rbmain.ui.GroupCreateActivity.5
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1(textView, i5, keyEvent);
            }
        });
        this.editText.setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.GroupCreateActivity.6
            private boolean wasEmpty;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i5, KeyEvent keyEvent) {
                if (i5 == 67) {
                    if (keyEvent.getAction() == 0) {
                        this.wasEmpty = GroupCreateActivity.this.editText.length() == 0;
                    } else if (keyEvent.getAction() == 1 && this.wasEmpty && !GroupCreateActivity.this.allSpans.isEmpty()) {
                        GroupCreateActivity.this.spansContainer.removeSpan((GroupCreateSpan) GroupCreateActivity.this.allSpans.get(GroupCreateActivity.this.allSpans.size() - 1));
                        GroupCreateActivity.this.updateHint();
                        GroupCreateActivity.this.checkVisibleRows();
                        return true;
                    }
                }
                return false;
            }
        });
        this.editText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.GroupCreateActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (GroupCreateActivity.this.editText.length() == 0) {
                    GroupCreateActivity.this.closeSearch();
                    return;
                }
                if (!GroupCreateActivity.this.adapter.searching) {
                    GroupCreateActivity.this.searching = true;
                    GroupCreateActivity.this.searchWas = true;
                    GroupCreateActivity.this.adapter.setSearching(true);
                    GroupCreateActivity.this.itemDecoration.setSearching(true);
                    GroupCreateActivity.this.listView.setFastScrollVisible(false);
                    GroupCreateActivity.this.listView.setVerticalScrollBarEnabled(true);
                }
                GroupCreateActivity.this.adapter.searchDialogs(GroupCreateActivity.this.editText.getText().toString());
                GroupCreateActivity.this.emptyView.showProgress(true, false);
            }
        });
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        flickerLoadingView.setViewType(6);
        flickerLoadingView.showDate(false);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, flickerLoadingView, 1);
        this.emptyView = stickerEmptyView;
        stickerEmptyView.addView(flickerLoadingView);
        this.emptyView.showProgress(true, false);
        this.emptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
        viewGroup2.addView(this.emptyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFastScrollEnabled(0);
        this.listView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView2 = this.listView;
        GroupCreateAdapter groupCreateAdapter = new GroupCreateAdapter(context);
        this.adapter = groupCreateAdapter;
        recyclerListView2.setAdapter(groupCreateAdapter);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        RecyclerListView recyclerListView3 = this.listView;
        GroupCreateDividerItemDecoration groupCreateDividerItemDecoration = new GroupCreateDividerItemDecoration();
        this.itemDecoration = groupCreateDividerItemDecoration;
        recyclerListView3.addItemDecoration(groupCreateDividerItemDecoration);
        viewGroup2.addView(this.listView);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda11
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i5) {
                this.f$0.lambda$createView$3(context, view, i5);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.GroupCreateActivity.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
                if (i5 == 1) {
                    GroupCreateActivity.this.editText.hideActionMode();
                    AndroidUtilities.hideKeyboard(GroupCreateActivity.this.editText);
                }
            }
        });
        this.listView.setAnimateEmptyView(true, 0);
        ImageView imageView = new ImageView(context);
        this.floatingButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(Theme.key_chats_actionBackground), Theme.getColor(Theme.key_chats_actionPressedBackground));
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionIcon), PorterDuff.Mode.MULTIPLY));
        if (this.isNeverShare || this.isAlwaysShare || this.addToGroup) {
            this.floatingButton.setImageResource(R.drawable.floating_check);
        } else {
            BackDrawable backDrawable = new BackDrawable(false);
            backDrawable.setArrowRotation(180);
            backDrawable.setColor(-1);
            this.floatingButton.setImageDrawable(backDrawable);
        }
        if (i5 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButton.setStateListAnimator(stateListAnimator);
            this.floatingButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.GroupCreateActivity.9
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        viewGroup2.addView(this.floatingButton);
        this.floatingButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$4(view);
            }
        });
        if (this.chatType != 2) {
            this.floatingButton.setVisibility(4);
            this.floatingButton.setScaleX(0.0f);
            this.floatingButton.setScaleY(0.0f);
            this.floatingButton.setAlpha(0.0f);
        }
        this.floatingButton.setContentDescription(LocaleController.getString("Next", R.string.Next));
        updateHint();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        this.editText.clearFocus();
        this.editText.requestFocus();
        AndroidUtilities.showKeyboard(this.editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(TextView textView, int i, KeyEvent keyEvent) {
        return i == 6 && onDonePressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(Context context, View view, int i) {
        int i2;
        if (i == 0 && this.adapter.inviteViaLink != 0 && !this.adapter.searching) {
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            int i3 = this.channelId;
            PermanentLinkBottomSheet permanentLinkBottomSheet = new PermanentLinkBottomSheet(context, false, this, tLRPC$ChatFull, i3 != 0 ? i3 : this.chatId, i3 != 0);
            this.sharedLinkBottomSheet = permanentLinkBottomSheet;
            showDialog(permanentLinkBottomSheet);
            return;
        }
        if (view instanceof GroupCreateUserCell) {
            GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) view;
            Object object = groupCreateUserCell.getObject();
            boolean z = object instanceof TLRPC$User;
            if (z) {
                i2 = ((TLRPC$User) object).id;
            } else if (!(object instanceof TLRPC$Chat)) {
                return;
            } else {
                i2 = -((TLRPC$Chat) object).id;
            }
            SparseArray<TLObject> sparseArray = this.ignoreUsers;
            if (sparseArray == null || sparseArray.indexOfKey(i2) < 0) {
                boolean z2 = this.selectedContacts.indexOfKey(i2) >= 0;
                if (z2) {
                    this.spansContainer.removeSpan(this.selectedContacts.get(i2));
                } else {
                    if (this.maxCount != 0 && this.selectedContacts.size() == this.maxCount) {
                        return;
                    }
                    if (this.chatType == 0 && this.selectedContacts.size() == getMessagesController().maxGroupCount) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setMessage(LocaleController.getString("SoftUserLimitAlert", R.string.SoftUserLimitAlert));
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                        showDialog(builder.create());
                        return;
                    }
                    if (z) {
                        final TLRPC$User tLRPC$User = (TLRPC$User) object;
                        if (this.addToGroup && tLRPC$User.bot) {
                            int i4 = this.channelId;
                            if (i4 == 0 && tLRPC$User.bot_nochats) {
                                try {
                                    BulletinFactory.of(this).createErrorBulletin(LocaleController.getString("BotCantJoinGroups", R.string.BotCantJoinGroups)).show();
                                    return;
                                } catch (Exception e) {
                                    FileLog.e(e);
                                    return;
                                }
                            }
                            if (i4 != 0) {
                                TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.channelId));
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                                if (ChatObject.canAddAdmins(chat)) {
                                    builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
                                    builder2.setMessage(LocaleController.getString("AddBotAsAdmin", R.string.AddBotAsAdmin));
                                    builder2.setPositiveButton(LocaleController.getString("MakeAdmin", R.string.MakeAdmin), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda1
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i5) {
                                            this.f$0.lambda$createView$2(tLRPC$User, dialogInterface, i5);
                                        }
                                    });
                                    builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                                } else {
                                    builder2.setMessage(LocaleController.getString("CantAddBotAsAdmin", R.string.CantAddBotAsAdmin));
                                    builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                                }
                                showDialog(builder2.create());
                                return;
                            }
                        }
                        getMessagesController().putUser(tLRPC$User, !this.searching);
                    } else {
                        getMessagesController().putChat((TLRPC$Chat) object, !this.searching);
                    }
                    GroupCreateSpan groupCreateSpan = new GroupCreateSpan(this.editText.getContext(), object);
                    this.spansContainer.addSpan(groupCreateSpan);
                    groupCreateSpan.setOnClickListener(this);
                }
                updateHint();
                if (this.searching || this.searchWas) {
                    AndroidUtilities.showKeyboard(this.editText);
                } else {
                    groupCreateUserCell.setChecked(!z2, true);
                }
                if (this.editText.length() > 0) {
                    this.editText.setText((CharSequence) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
        this.delegate2.needAddBot(tLRPC$User);
        if (this.editText.length() > 0) {
            this.editText.setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view) {
        onDonePressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEditTextHint() {
        GroupCreateAdapter groupCreateAdapter;
        EditTextBoldCursor editTextBoldCursor = this.editText;
        if (editTextBoldCursor == null) {
            return;
        }
        if (this.chatType == 2) {
            editTextBoldCursor.setHintText(LocaleController.getString("AddMutual", R.string.AddMutual));
            return;
        }
        if (this.addToGroup || ((groupCreateAdapter = this.adapter) != null && groupCreateAdapter.noContactsStubRow == 0)) {
            this.editText.setHintText(LocaleController.getString("SearchForPeople", R.string.SearchForPeople));
        } else if (this.isAlwaysShare || this.isNeverShare) {
            this.editText.setHintText(LocaleController.getString("SearchForPeopleAndGroups", R.string.SearchForPeopleAndGroups));
        } else {
            this.editText.setHintText(LocaleController.getString("SendMessageTo", R.string.SendMessageTo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemsAnimated(final int i) {
        if (this.isPaused) {
            return;
        }
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.GroupCreateActivity.10
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                GroupCreateActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = GroupCreateActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = GroupCreateActivity.this.listView.getChildAt(i2);
                    if (GroupCreateActivity.this.listView.getChildAdapterPosition(childAt) >= i) {
                        childAt.setAlpha(0.0f);
                        int iMin = (int) ((Math.min(GroupCreateActivity.this.listView.getMeasuredHeight(), Math.max(0, childAt.getTop())) / GroupCreateActivity.this.listView.getMeasuredHeight()) * 100.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay(iMin);
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                }
                animatorSet.start();
                return true;
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        getContactProxy().updateContactsLastOnline();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.contactsDidLoad) {
            GroupCreateAdapter groupCreateAdapter = this.adapter;
            if (groupCreateAdapter != null) {
                groupCreateAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i == NotificationCenter.updateInterfaces) {
            GroupCreateAdapter groupCreateAdapter2 = this.adapter;
            if (groupCreateAdapter2 != null) {
                groupCreateAdapter2.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i == NotificationCenter.chatDidCreated) {
            removeSelfFromStack();
        }
    }

    public void setIgnoreUsers(SparseArray<TLObject> sparseArray) {
        this.ignoreUsers = sparseArray;
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
    }

    @Keep
    public void setContainerHeight(int i) {
        int i2 = this.containerHeight - i;
        this.containerHeight = i;
        int iMin = Math.min(this.maxSize, this.measuredContainerHeight);
        int iMin2 = Math.min(this.maxSize, this.containerHeight);
        ScrollView scrollView = this.scrollView;
        scrollView.scrollTo(0, Math.max(0, scrollView.getScrollY() - i2));
        this.listView.setTranslationY(iMin2 - iMin);
        this.fragmentView.invalidate();
    }

    @Keep
    public int getContainerHeight() {
        return this.containerHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVisibleRows() {
        int i;
        int childCount = this.listView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof GroupCreateUserCell) {
                GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) childAt;
                Object object = groupCreateUserCell.getObject();
                if (object instanceof TLRPC$User) {
                    i = ((TLRPC$User) object).id;
                } else {
                    i = object instanceof TLRPC$Chat ? -((TLRPC$Chat) object).id : 0;
                }
                if (i != 0) {
                    SparseArray<TLObject> sparseArray = this.ignoreUsers;
                    if (sparseArray != null && sparseArray.indexOfKey(i) >= 0) {
                        groupCreateUserCell.setChecked(true, false);
                        groupCreateUserCell.setCheckBoxEnabled(false);
                    } else {
                        groupCreateUserCell.setChecked(this.selectedContacts.indexOfKey(i) >= 0, true);
                        groupCreateUserCell.setCheckBoxEnabled(true);
                    }
                }
            }
        }
    }

    private void onAddToGroupDone(int i) {
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.selectedContacts.size(); i2++) {
            arrayList.add(getMessagesController().getUser(Integer.valueOf(this.selectedContacts.keyAt(i2))));
        }
        ContactsAddActivityDelegate contactsAddActivityDelegate = this.delegate2;
        if (contactsAddActivityDelegate != null) {
            contactsAddActivityDelegate.didSelectUsers(arrayList, i);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDonePressed(boolean z) {
        int i = 0;
        if (this.selectedContacts.size() == 0 && this.chatType != 2) {
            return false;
        }
        if (z && this.addToGroup) {
            if (getParentActivity() == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            if (this.selectedContacts.size() == 1) {
                builder.setTitle(LocaleController.getString("AddOneMemberAlertTitle", R.string.AddOneMemberAlertTitle));
            } else {
                builder.setTitle(LocaleController.formatString("AddMembersAlertTitle", R.string.AddMembersAlertTitle, LocaleController.formatPluralString("Members", this.selectedContacts.size())));
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.selectedContacts.size(); i2++) {
                TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.selectedContacts.keyAt(i2)));
                if (user != null) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append("**");
                    sb.append(ContactsController.formatName(user.first_name, user.last_name));
                    sb.append("**");
                }
            }
            MessagesController messagesController = getMessagesController();
            int i3 = this.chatId;
            if (i3 == 0) {
                i3 = this.channelId;
            }
            TLRPC$Chat chat = messagesController.getChat(Integer.valueOf(i3));
            if (this.selectedContacts.size() > 5) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(AndroidUtilities.replaceTags(LocaleController.formatString("AddMembersAlertNamesText", R.string.AddMembersAlertNamesText, LocaleController.formatPluralString("Members", this.selectedContacts.size()), chat.title)));
                String str = String.format("%d", Integer.valueOf(this.selectedContacts.size()));
                int iIndexOf = TextUtils.indexOf(spannableStringBuilder, str);
                if (iIndexOf >= 0) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), iIndexOf, str.length() + iIndexOf, 33);
                }
                builder.setMessage(spannableStringBuilder);
            } else {
                builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("AddMembersAlertNamesText", R.string.AddMembersAlertNamesText, sb, chat.title)));
            }
            final CheckBoxCell[] checkBoxCellArr = new CheckBoxCell[1];
            if (!ChatObject.isChannel(chat)) {
                LinearLayout linearLayout = new LinearLayout(getParentActivity());
                linearLayout.setOrientation(1);
                checkBoxCellArr[0] = new CheckBoxCell(getParentActivity(), 1);
                checkBoxCellArr[0].setBackgroundDrawable(Theme.getSelectorDrawable(false));
                checkBoxCellArr[0].setMultiline(true);
                if (this.selectedContacts.size() == 1) {
                    checkBoxCellArr[0].setText(AndroidUtilities.replaceTags(LocaleController.formatString("AddOneMemberForwardMessages", R.string.AddOneMemberForwardMessages, UserObject.getFirstName(getMessagesController().getUser(Integer.valueOf(this.selectedContacts.keyAt(0)))))), BuildConfig.FLAVOR, true, false);
                } else {
                    checkBoxCellArr[0].setText(LocaleController.getString("AddMembersForwardMessages", R.string.AddMembersForwardMessages), BuildConfig.FLAVOR, true, false);
                }
                checkBoxCellArr[0].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                linearLayout.addView(checkBoxCellArr[0], LayoutHelper.createLinear(-1, -2));
                checkBoxCellArr[0].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GroupCreateActivity.lambda$onDonePressed$5(checkBoxCellArr, view);
                    }
                });
                builder.setCustomViewOffset(12);
                builder.setView(linearLayout);
            }
            builder.setPositiveButton(LocaleController.getString("Add", R.string.Add), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$onDonePressed$6(checkBoxCellArr, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        } else if (this.chatType == 2) {
            ArrayList<TLRPC$InputUser> arrayList = new ArrayList<>();
            while (i < this.selectedContacts.size()) {
                TLRPC$InputUser inputUser = getMessagesController().getInputUser(getMessagesController().getUser(Integer.valueOf(this.selectedContacts.keyAt(i))));
                if (inputUser != null) {
                    arrayList.add(inputUser);
                }
                i++;
            }
            AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            this.progressDialog = alertDialog;
            alertDialog.show();
            final int iCreateChannel = getDialogsProxy().createChannel(this.title, this.about, this.photoId, this.smallPhotoId, this.isPublic, arrayList, new RequestDelegate() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda9
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onDonePressed$9(tLObject, tLRPC$TL_error);
                }
            });
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$onDonePressed$10(iCreateChannel, dialogInterface);
                }
            });
        } else {
            if (!this.doneButtonVisible || this.selectedContacts.size() == 0) {
                return false;
            }
            if (this.addToGroup) {
                onAddToGroupDone(0);
            } else {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                while (i < this.selectedContacts.size()) {
                    arrayList2.add(Integer.valueOf(this.selectedContacts.keyAt(i)));
                    i++;
                }
                if (this.isAlwaysShare || this.isNeverShare) {
                    GroupCreateActivityDelegate groupCreateActivityDelegate = this.delegate;
                    if (groupCreateActivityDelegate != null) {
                        groupCreateActivityDelegate.didSelectUsers(arrayList2);
                    }
                    finishFragment();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("result", arrayList2);
                    bundle.putInt("chatType", this.chatType);
                    bundle.putBoolean("forImport", this.forImport);
                    presentFragment(new GroupCreateFinalActivity(bundle));
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDonePressed$5(CheckBoxCell[] checkBoxCellArr, View view) {
        checkBoxCellArr[0].setChecked(!checkBoxCellArr[0].isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$6(CheckBoxCell[] checkBoxCellArr, DialogInterface dialogInterface, int i) {
        int i2 = 0;
        if (checkBoxCellArr[0] != null && checkBoxCellArr[0].isChecked()) {
            i2 = 100;
        }
        onAddToGroupDone(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$9(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDonePressed$7(tLRPC$TL_error);
                }
            });
        } else {
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDonePressed$8(tLRPC$Updates);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$7(TLRPC$TL_error tLRPC$TL_error) {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, new TLRPC$TL_channels_createChannel(), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$8(TLRPC$Updates tLRPC$Updates) {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        ArrayList<TLRPC$Chat> arrayList = tLRPC$Updates.chats;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", tLRPC$Updates.chats.get(0).id);
        presentFragment(new ChatActivity(bundle), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$10(int i, DialogInterface dialogInterface) {
        this.progressDialog = null;
        getConnectionsManager().cancelRequest(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSearch() {
        this.searching = false;
        this.searchWas = false;
        this.itemDecoration.setSearching(false);
        this.adapter.setSearching(false);
        this.adapter.searchDialogs(null);
        this.listView.setFastScrollVisible(true);
        this.listView.setVerticalScrollBarEnabled(false);
        showItemsAnimated(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHint() {
        if (!this.isAlwaysShare && !this.isNeverShare && !this.addToGroup) {
            if (this.chatType == 2) {
                this.actionBar.setSubtitle(LocaleController.formatPluralString("Members", this.selectedContacts.size()));
            } else if (this.selectedContacts.size() == 0) {
                this.actionBar.setSubtitle(LocaleController.formatString("MembersCountZero", R.string.MembersCountZero, LocaleController.formatPluralString("Members", this.maxCount)));
            } else {
                this.actionBar.setSubtitle(String.format(LocaleController.getPluralString("MembersCountSelected", this.selectedContacts.size()), Integer.valueOf(this.selectedContacts.size()), Integer.valueOf(this.maxCount)));
            }
        }
        if (this.chatType != 2) {
            if (this.doneButtonVisible && this.allSpans.isEmpty()) {
                AnimatorSet animatorSet = this.currentDoneButtonAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.currentDoneButtonAnimation = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                this.currentDoneButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCreateActivity.11
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GroupCreateActivity.this.floatingButton.setVisibility(4);
                    }
                });
                this.currentDoneButtonAnimation.setDuration(180L);
                this.currentDoneButtonAnimation.start();
                this.doneButtonVisible = false;
                return;
            }
            if (this.doneButtonVisible || this.allSpans.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet3 = this.currentDoneButtonAnimation;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            this.currentDoneButtonAnimation = new AnimatorSet();
            this.floatingButton.setVisibility(0);
            this.currentDoneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            this.currentDoneButtonAnimation.setDuration(180L);
            this.currentDoneButtonAnimation.start();
            this.doneButtonVisible = true;
        }
    }

    public void setDelegate(GroupCreateActivityDelegate groupCreateActivityDelegate) {
        this.delegate = groupCreateActivityDelegate;
    }

    public void setDelegate(ContactsAddActivityDelegate contactsAddActivityDelegate) {
        this.delegate2 = contactsAddActivityDelegate;
    }

    public class GroupCreateAdapter extends RecyclerListView.FastScrollAdapter {
        private Context context;
        private int currentItemsCount;
        private int inviteViaLink;
        private int noContactsStubRow;
        private SearchAdapterHelper searchAdapterHelper;
        private Runnable searchRunnable;
        private boolean searching;
        private int usersStartRow;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private ArrayList<TLObject> contacts = new ArrayList<>();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            GroupCreateActivity.this.updateEditTextHint();
        }

        public GroupCreateAdapter(Context context) {
            TLRPC$Chat chat;
            this.context = context;
            ArrayList<TLRPC$TL_contact> arrayList = GroupCreateActivity.this.getContactsController().contacts;
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$User user = GroupCreateActivity.this.getMessagesController().getUser(Integer.valueOf(arrayList.get(i).user_id));
                if (user != null && !user.self && !user.deleted) {
                    this.contacts.add(user);
                }
            }
            if (GroupCreateActivity.this.isNeverShare || GroupCreateActivity.this.isAlwaysShare) {
                ArrayList<TLRPC$Dialog> allDialogs = GroupCreateActivity.this.getMessagesController().getAllDialogs();
                int size = allDialogs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = (int) allDialogs.get(i2).id;
                    if (i3 < 0 && (chat = GroupCreateActivity.this.getMessagesController().getChat(Integer.valueOf(-i3))) != null && chat.migrated_to == null && (!ChatObject.isChannel(chat) || chat.megagroup)) {
                        this.contacts.add(chat);
                    }
                }
                Collections.sort(this.contacts, new Comparator<TLObject>(this, GroupCreateActivity.this) { // from class: org.rbmain.ui.GroupCreateActivity.GroupCreateAdapter.1
                    private String getName(TLObject tLObject) {
                        if (tLObject instanceof TLRPC$User) {
                            TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                            return ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                        }
                        return ((TLRPC$Chat) tLObject).title;
                    }

                    @Override // java.util.Comparator
                    public int compare(TLObject tLObject, TLObject tLObject2) {
                        return getName(tLObject).compareTo(getName(tLObject2));
                    }
                });
            }
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.GroupCreateActivity$GroupCreateAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i4) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i4);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i4) {
                    this.f$0.lambda$new$0(i4);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList2, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList2, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i) {
            GroupCreateActivity.this.showItemsAnimated(this.currentItemsCount);
            if (this.searchRunnable == null && !this.searchAdapterHelper.isSearchInProgress() && getItemCount() == 0) {
                GroupCreateActivity.this.emptyView.showProgress(false, true);
            }
            notifyDataSetChanged();
        }

        public void setSearching(boolean z) {
            if (this.searching == z) {
                return;
            }
            this.searching = z;
            notifyDataSetChanged();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            String str;
            String str2;
            if (this.searching || i < this.usersStartRow) {
                return null;
            }
            int size = this.contacts.size();
            int i2 = this.usersStartRow;
            if (i >= size + i2) {
                return null;
            }
            TLObject tLObject = this.contacts.get(i - i2);
            if (tLObject instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                str = tLRPC$User.first_name;
                str2 = tLRPC$User.last_name;
            } else {
                str = ((TLRPC$Chat) tLObject).title;
                str2 = BuildConfig.FLAVOR;
            }
            if (LocaleController.nameDisplayOrder == 1) {
                if (!TextUtils.isEmpty(str)) {
                    return str.substring(0, 1).toUpperCase();
                }
                if (!TextUtils.isEmpty(str2)) {
                    return str2.substring(0, 1).toUpperCase();
                }
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    return str2.substring(0, 1).toUpperCase();
                }
                if (!TextUtils.isEmpty(str)) {
                    return str.substring(0, 1).toUpperCase();
                }
            }
            return BuildConfig.FLAVOR;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            this.noContactsStubRow = -1;
            if (this.searching) {
                int size = this.searchResult.size();
                int size2 = this.searchAdapterHelper.getLocalServerSearch().size();
                int size3 = this.searchAdapterHelper.getGlobalSearch().size();
                int i = size + size2;
                if (size3 != 0) {
                    i += size3 + 1;
                }
                this.currentItemsCount = i;
                return i;
            }
            int size4 = this.contacts.size();
            if (GroupCreateActivity.this.addToGroup) {
                if (GroupCreateActivity.this.chatId != 0) {
                    this.inviteViaLink = ChatObject.canUserDoAdminAction(GroupCreateActivity.this.getMessagesController().getChat(Integer.valueOf(GroupCreateActivity.this.chatId)), 3) ? 1 : 0;
                } else if (GroupCreateActivity.this.channelId != 0) {
                    TLRPC$Chat chat = GroupCreateActivity.this.getMessagesController().getChat(Integer.valueOf(GroupCreateActivity.this.channelId));
                    this.inviteViaLink = (ChatObject.canUserDoAdminAction(chat, 3) && GroupCreateActivity.this.getDialogsProxy().isPrivateChannel(chat)) ? 2 : 0;
                } else {
                    this.inviteViaLink = 0;
                }
                if (this.inviteViaLink != 0) {
                    this.usersStartRow = 1;
                    size4++;
                }
            }
            if (size4 == 0) {
                this.noContactsStubRow = 0;
                size4++;
            }
            this.currentItemsCount = size4;
            return size4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View groupCreateSectionCell;
            GroupCreateUserCell groupCreateUserCell;
            if (i != 0) {
                int i2 = 0;
                if (i == 1) {
                    groupCreateUserCell = new GroupCreateUserCell(this.context, 1, 0, false);
                } else if (i == 3) {
                    StickerEmptyView stickerEmptyView = new StickerEmptyView(this, this.context, null, i2) { // from class: org.rbmain.ui.GroupCreateActivity.GroupCreateAdapter.2
                        @Override // org.rbmain.ui.Components.StickerEmptyView, android.view.ViewGroup, android.view.View
                        protected void onAttachedToWindow() {
                            super.onAttachedToWindow();
                            this.stickerView.getImageReceiver().startAnimation();
                        }
                    };
                    stickerEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    stickerEmptyView.subtitle.setVisibility(8);
                    stickerEmptyView.title.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
                    stickerEmptyView.setAnimateLayoutChange(true);
                    groupCreateUserCell = stickerEmptyView;
                } else {
                    groupCreateSectionCell = new TextCell(this.context);
                }
                groupCreateSectionCell = groupCreateUserCell;
            } else {
                groupCreateSectionCell = new GroupCreateSectionCell(this.context);
            }
            return new RecyclerListView.Holder(groupCreateSectionCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0123  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r11, int r12) {
            /*
                Method dump skipped, instructions count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCreateActivity.GroupCreateAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (this.searching) {
                return i == this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size() ? 0 : 1;
            }
            if (this.inviteViaLink == 0 || i != 0) {
                return this.noContactsStubRow == i ? 3 : 1;
            }
            return 2;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
            iArr[0] = (int) (getItemCount() * f);
            iArr[1] = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof GroupCreateUserCell) {
                ((GroupCreateUserCell) view).recycle();
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            if (GroupCreateActivity.this.ignoreUsers == null) {
                return true;
            }
            View view = viewHolder.itemView;
            if (!(view instanceof GroupCreateUserCell)) {
                return true;
            }
            Object object = ((GroupCreateUserCell) view).getObject();
            return !(object instanceof TLRPC$User) || GroupCreateActivity.this.ignoreUsers.indexOfKey(((TLRPC$User) object).id) < 0;
        }

        public void searchDialogs(final String str) {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            this.searchResult.clear();
            this.searchResultNames.clear();
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, true, GroupCreateActivity.this.isAlwaysShare || GroupCreateActivity.this.isNeverShare, false, false, false, 0, false, 0, 0);
            notifyDataSetChanged();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$GroupCreateAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 600L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$3(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$GroupCreateAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$2(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$2(final String str) {
            this.searchAdapterHelper.queryServerSearch(str, true, GroupCreateActivity.this.isAlwaysShare || GroupCreateActivity.this.isNeverShare, true, false, false, 0, false, 0, 0);
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$GroupCreateAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$1(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0128 A[LOOP:1: B:29:0x008c->B:54:0x0128, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00d8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$searchDialogs$1(java.lang.String r18) {
            /*
                Method dump skipped, instructions count: 316
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCreateActivity.GroupCreateAdapter.lambda$searchDialogs$1(java.lang.String):void");
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final ArrayList<CharSequence> arrayList2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCreateActivity$GroupCreateAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList, arrayList2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList, ArrayList arrayList2) {
            if (this.searching) {
                this.searchRunnable = null;
                this.searchResult = arrayList;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList);
                GroupCreateActivity.this.showItemsAnimated(this.currentItemsCount);
                notifyDataSetChanged();
                if (this.searching && !this.searchAdapterHelper.isSearchInProgress() && getItemCount() == 0) {
                    GroupCreateActivity.this.emptyView.showProgress(false, true);
                }
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.GroupCreateActivity$$ExternalSyntheticLambda10
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$11();
            }
        };
        View view = this.fragmentView;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(view, i, null, null, null, null, i2));
        ActionBar actionBar = this.actionBar;
        int i3 = ThemeDescription.FLAG_BACKGROUND;
        int i4 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollActive));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollInactive));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        EditTextBoldCursor editTextBoldCursor = this.editText;
        int i5 = ThemeDescription.FLAG_TEXTCOLOR;
        int i6 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i5, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_groupcreate_hintText));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, Theme.key_groupcreate_cursor));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GroupCreateSectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GroupCreateSectionCell.class}, new String[]{"drawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_groupcreate_sectionShadow));
        int i7 = Theme.key_groupcreate_sectionText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkbox));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxDisabled));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxCheck));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{GroupCreateUserCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText));
        int i8 = Theme.key_windowBackgroundWhiteGrayText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{GroupCreateUserCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GroupCreateUserCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        int i9 = Theme.key_avatar_backgroundBlue;
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i9));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, Theme.key_groupcreate_spanBackground));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, Theme.key_groupcreate_spanText));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, Theme.key_groupcreate_spanDelete));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i8));
        PermanentLinkBottomSheet permanentLinkBottomSheet = this.sharedLinkBottomSheet;
        if (permanentLinkBottomSheet != null) {
            arrayList.addAll(permanentLinkBottomSheet.getThemeDescriptions());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$11() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof GroupCreateUserCell) {
                    ((GroupCreateUserCell) childAt).update(0);
                }
            }
        }
    }
}
