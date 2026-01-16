package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$PhoneCallDiscardReason;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterPhoneCalls;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionHistoryClear;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_messages_affectedFoundMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_deletePhoneCallHistory;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import ir.eitaa.tgnet.TLRPC$TL_updateDeleteMessages;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.CallLogActivity;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.LocationCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.ProgressButton;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.ContactsActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class CallLogActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ArrayList<Long> activeGroupCalls;
    private EmptyTextProgressView emptyView;
    private boolean endReached;
    private boolean firstLoaded;
    private FlickerLoadingView flickerLoadingView;
    private ImageView floatingButton;
    private boolean floatingHidden;
    private Drawable greenDrawable;
    private Drawable greenDrawable2;
    private ImageSpan iconIn;
    private ImageSpan iconMissed;
    private ImageSpan iconOut;
    private TLRPC$Chat lastCallChat;
    private TLRPC$User lastCallUser;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private boolean loading;
    private boolean openTransitionStarted;
    private ActionBarMenuItem otherItem;
    private int prevPosition;
    private int prevTop;
    private Drawable redDrawable;
    private boolean scrollUpdated;
    private NumberTextView selectedDialogsCountTextView;
    private Long waitingForCallChatId;
    private ProgressButton waitingForLoadButton;
    private ArrayList<View> actionModeViews = new ArrayList<>();
    private ArrayList<CallLogRow> calls = new ArrayList<>();
    private ArrayList<Integer> selectedIds = new ArrayList<>();
    private final AccelerateDecelerateInterpolator floatingInterpolator = new AccelerateDecelerateInterpolator();

    static /* synthetic */ boolean lambda$createActionMode$7(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class EmptyTextProgressView extends FrameLayout {
        private TextView emptyTextView1;
        private TextView emptyTextView2;
        private RLottieImageView imageView;
        private View progressView;

        static /* synthetic */ boolean lambda$new$1(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public EmptyTextProgressView(Context context, View progressView) {
            super(context);
            addView(progressView, LayoutHelper.createFrame(-1, -1.0f));
            this.progressView = progressView;
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setAnimation(R.raw.utyan_call, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
            this.imageView.setAutoRepeat(false);
            addView(this.imageView, LayoutHelper.createFrame(140, 140.0f, 17, 52.0f, 4.0f, 52.0f, 60.0f));
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$EmptyTextProgressView$JdxKuCH78iQqPzobcg6c6U6-SlQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$CallLogActivity$EmptyTextProgressView(view);
                }
            });
            TextView textView = new TextView(context);
            this.emptyTextView1 = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.emptyTextView1.setText(LocaleController.getString("NoRecentCalls", R.string.NoRecentCalls));
            this.emptyTextView1.setTextSize(1, 20.0f);
            this.emptyTextView1.setTypeface(AndroidUtilities.getFontFamily(true));
            this.emptyTextView1.setGravity(17);
            addView(this.emptyTextView1, LayoutHelper.createFrame(-1, -2.0f, 17, 17.0f, 40.0f, 17.0f, 0.0f));
            this.emptyTextView2 = new TextView(context);
            String string = LocaleController.getString("NoRecentCallsInfo", R.string.NoRecentCallsInfo);
            if (AndroidUtilities.isTablet() && !AndroidUtilities.isSmallTablet()) {
                string = string.replace('\n', ' ');
            }
            this.emptyTextView2.setText(string);
            this.emptyTextView2.setTextColor(Theme.getColor("emptyListPlaceholder"));
            this.emptyTextView2.setTextSize(1, 14.0f);
            this.emptyTextView2.setGravity(17);
            this.emptyTextView2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.emptyTextView2, LayoutHelper.createFrame(-1, -2.0f, 17, 17.0f, 80.0f, 17.0f, 0.0f));
            progressView.setAlpha(0.0f);
            this.imageView.setAlpha(0.0f);
            this.emptyTextView1.setAlpha(0.0f);
            this.emptyTextView2.setAlpha(0.0f);
            setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$EmptyTextProgressView$domxJcRTR7y_sFWX5KYoDfPFKQ0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CallLogActivity.EmptyTextProgressView.lambda$new$1(view, motionEvent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$CallLogActivity$EmptyTextProgressView(View view) {
            if (this.imageView.isPlaying()) {
                return;
            }
            this.imageView.setProgress(0.0f);
            this.imageView.playAnimation();
        }

        public void showProgress() {
            this.imageView.animate().alpha(0.0f).setDuration(150L).start();
            this.emptyTextView1.animate().alpha(0.0f).setDuration(150L).start();
            this.emptyTextView2.animate().alpha(0.0f).setDuration(150L).start();
            this.progressView.animate().alpha(1.0f).setDuration(150L).start();
        }

        public void showTextView() {
            this.imageView.animate().alpha(1.0f).setDuration(150L).start();
            this.emptyTextView1.animate().alpha(1.0f).setDuration(150L).start();
            this.emptyTextView2.animate().alpha(1.0f).setDuration(150L).start();
            this.progressView.animate().alpha(0.0f).setDuration(150L).start();
            this.imageView.playAnimation();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        Long l;
        ListAdapter listAdapter;
        if (id == NotificationCenter.didReceiveNewMessages) {
            if (this.firstLoaded && !((Boolean) args[2]).booleanValue()) {
                Iterator it = ((ArrayList) args[1]).iterator();
                while (it.hasNext()) {
                    MessageObject messageObject = (MessageObject) it.next();
                    if (messageObject.messageOwner.action instanceof TLRPC$TL_messageActionPhoneCall) {
                        long fromChatId = messageObject.getFromChatId();
                        long j = fromChatId == getUserConfig().getClientUserId() ? messageObject.messageOwner.peer_id.user_id : fromChatId;
                        int i = fromChatId == getUserConfig().getClientUserId() ? 0 : 1;
                        TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = messageObject.messageOwner.action.reason;
                        if (i == 1 && ((tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed) || (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy))) {
                            i = 2;
                        }
                        if (this.calls.size() > 0) {
                            CallLogRow callLogRow = this.calls.get(0);
                            if (callLogRow.user.id == j && callLogRow.type == i) {
                                callLogRow.calls.add(0, messageObject.messageOwner);
                                this.listViewAdapter.notifyItemChanged(0);
                            }
                        }
                        CallLogRow callLogRow2 = new CallLogRow();
                        ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
                        callLogRow2.calls = arrayList;
                        arrayList.add(messageObject.messageOwner);
                        callLogRow2.user = getMessagesController().getUser(Long.valueOf(j));
                        callLogRow2.type = i;
                        callLogRow2.video = messageObject.isVideoCall();
                        this.calls.add(0, callLogRow2);
                        this.listViewAdapter.notifyItemInserted(0);
                    }
                }
                ActionBarMenuItem actionBarMenuItem = this.otherItem;
                if (actionBarMenuItem != null) {
                    actionBarMenuItem.setVisibility(this.calls.isEmpty() ? 8 : 0);
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagesDeleted) {
            if (this.firstLoaded && !((Boolean) args[2]).booleanValue()) {
                ArrayList arrayList2 = (ArrayList) args[0];
                Iterator<CallLogRow> it2 = this.calls.iterator();
                while (it2.hasNext()) {
                    CallLogRow next = it2.next();
                    Iterator<TLRPC$Message> it3 = next.calls.iterator();
                    while (it3.hasNext()) {
                        if (arrayList2.contains(Integer.valueOf(it3.next().id))) {
                            it3.remove();
                            i = 1;
                        }
                    }
                    if (next.calls.size() == 0) {
                        it2.remove();
                    }
                }
                if (i == 0 || (listAdapter = this.listViewAdapter) == null) {
                    return;
                }
                listAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (id == NotificationCenter.activeGroupCallsUpdated) {
            this.activeGroupCalls = getMessagesController().getActiveGroupCalls();
            ListAdapter listAdapter2 = this.listViewAdapter;
            if (listAdapter2 != null) {
                listAdapter2.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (id == NotificationCenter.chatInfoDidLoad) {
            Long l2 = this.waitingForCallChatId;
            if (l2 == null || ((TLRPC$ChatFull) args[0]).id != l2.longValue() || getMessagesController().getGroupCall(this.waitingForCallChatId.longValue(), true) == null) {
                return;
            }
            ProgressButton progressButton = this.waitingForLoadButton;
            if (progressButton != null) {
                progressButton.setDrawProgress(false, false);
            }
            VoIPHelper.startCall(this.lastCallChat, null, null, false, getParentActivity(), this, getAccountInstance());
            this.waitingForCallChatId = null;
            return;
        }
        if (id == NotificationCenter.groupCallUpdated && (l = this.waitingForCallChatId) != null && l.equals((Long) args[0])) {
            ProgressButton progressButton2 = this.waitingForLoadButton;
            if (progressButton2 != null) {
                progressButton2.setDrawProgress(false, false);
            }
            VoIPHelper.startCall(this.lastCallChat, null, null, false, getParentActivity(), this, getAccountInstance());
            this.waitingForCallChatId = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CallCell extends FrameLayout {
        private CheckBox2 checkBox;
        private ImageView imageView;
        private ProfileSearchCell profileSearchCell;

        public CallCell(Context context) {
            super(context);
            setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            ProfileSearchCell profileSearchCell = new ProfileSearchCell(context);
            this.profileSearchCell = profileSearchCell;
            profileSearchCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(32.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(32.0f), 0);
            this.profileSearchCell.setSublabelOffset(AndroidUtilities.dp(LocaleController.isRTL ? 2.0f : -2.0f), -AndroidUtilities.dp(4.0f));
            addView(this.profileSearchCell, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setAlpha(214);
            this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("featuredStickers_addButton"), PorterDuff.Mode.MULTIPLY));
            this.imageView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 1));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$CallCell$x_K5YG6Ksw7BxnprVoRkygYiewI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$CallLogActivity$CallCell(view);
                }
            });
            this.imageView.setContentDescription(LocaleController.getString("Call", R.string.Call));
            addView(this.imageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 3 : 5) | 16, 8.0f, 0.0f, 8.0f, 0.0f));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox, LayoutHelper.createFrame(24, 24.0f, (LocaleController.isRTL ? 5 : 3) | 48, 42.0f, 32.0f, 42.0f, 0.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$CallLogActivity$CallCell(View view) {
            CallLogRow callLogRow = (CallLogRow) view.getTag();
            TLRPC$UserFull userFull = CallLogActivity.this.getMessagesController().getUserFull(callLogRow.user.id);
            TLRPC$User tLRPC$User = CallLogActivity.this.lastCallUser = callLogRow.user;
            boolean z = callLogRow.video;
            VoIPHelper.startCall(tLRPC$User, z, z || (userFull != null && userFull.video_calls_available), CallLogActivity.this.getParentActivity(), null, CallLogActivity.this.getAccountInstance());
        }

        public void setChecked(boolean checked, boolean animated) {
            CheckBox2 checkBox2 = this.checkBox;
            if (checkBox2 == null) {
                return;
            }
            checkBox2.setChecked(checked, animated);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GroupCallCell extends FrameLayout {
        private ProgressButton button;
        private TLRPC$Chat currentChat;
        private ProfileSearchCell profileSearchCell;

        public GroupCallCell(Context context) {
            super(context);
            setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            String string = LocaleController.getString("VoipChatJoin", R.string.VoipChatJoin);
            this.button = new ProgressButton(context);
            int iCeil = (int) Math.ceil(r0.getPaint().measureText(string));
            ProfileSearchCell profileSearchCell = new ProfileSearchCell(context);
            this.profileSearchCell = profileSearchCell;
            profileSearchCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(44.0f) + iCeil : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(44.0f) + iCeil, 0);
            this.profileSearchCell.setSublabelOffset(0, -AndroidUtilities.dp(1.0f));
            addView(this.profileSearchCell, LayoutHelper.createFrame(-1, -1.0f));
            this.button.setText(string);
            this.button.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            this.button.setProgressColor(Theme.getColor("featuredStickers_buttonProgress"));
            this.button.setBackgroundRoundRect(Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed"));
            addView(this.button, LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 18.0f, 14.0f, 0.0f));
            this.button.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$GroupCallCell$UjoH9K3qmDMQ4cHlCK6QHXbRIks
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$CallLogActivity$GroupCallCell(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$CallLogActivity$GroupCallCell(View view) {
            if (CallLogActivity.this.waitingForLoadButton != null) {
                CallLogActivity.this.waitingForLoadButton.setDrawProgress(false, true);
            }
            Long l = (Long) view.getTag();
            ChatObject.Call groupCall = CallLogActivity.this.getMessagesController().getGroupCall(l.longValue(), false);
            CallLogActivity callLogActivity = CallLogActivity.this;
            callLogActivity.lastCallChat = callLogActivity.getMessagesController().getChat(l);
            if (groupCall != null) {
                TLRPC$Chat tLRPC$Chat = CallLogActivity.this.lastCallChat;
                Activity parentActivity = CallLogActivity.this.getParentActivity();
                CallLogActivity callLogActivity2 = CallLogActivity.this;
                VoIPHelper.startCall(tLRPC$Chat, null, null, false, parentActivity, callLogActivity2, callLogActivity2.getAccountInstance());
                return;
            }
            CallLogActivity.this.waitingForCallChatId = l;
            CallLogActivity.this.getMessagesController().loadFullChat(l.longValue(), 0, true);
            this.button.setDrawProgress(true, true);
            CallLogActivity.this.waitingForLoadButton = this.button;
        }

        public void setChat(TLRPC$Chat chat) {
            this.currentChat = chat;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getCalls(0, 50);
        this.activeGroupCalls = getMessagesController().getActiveGroupCalls();
        getNotificationCenter().addObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(this, NotificationCenter.messagesDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.activeGroupCallsUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.groupCallUpdated);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().removeObserver(this, NotificationCenter.messagesDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.activeGroupCallsUpdated);
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.groupCallUpdated);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Drawable drawableMutate = getParentActivity().getResources().getDrawable(R.drawable.ic_call_made_green_18dp).mutate();
        this.greenDrawable = drawableMutate;
        drawableMutate.setBounds(0, 0, drawableMutate.getIntrinsicWidth(), this.greenDrawable.getIntrinsicHeight());
        this.greenDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("calls_callReceivedGreenIcon"), PorterDuff.Mode.MULTIPLY));
        this.iconOut = new ImageSpan(this.greenDrawable, 0);
        Drawable drawableMutate2 = getParentActivity().getResources().getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
        this.greenDrawable2 = drawableMutate2;
        drawableMutate2.setBounds(0, 0, drawableMutate2.getIntrinsicWidth(), this.greenDrawable2.getIntrinsicHeight());
        this.greenDrawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("calls_callReceivedGreenIcon"), PorterDuff.Mode.MULTIPLY));
        this.iconIn = new ImageSpan(this.greenDrawable2, 0);
        Drawable drawableMutate3 = getParentActivity().getResources().getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
        this.redDrawable = drawableMutate3;
        drawableMutate3.setBounds(0, 0, drawableMutate3.getIntrinsicWidth(), this.redDrawable.getIntrinsicHeight());
        this.redDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("calls_callReceivedRedIcon"), PorterDuff.Mode.MULTIPLY));
        this.iconMissed = new ImageSpan(this.redDrawable, 0);
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Calls", R.string.Calls));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.CallLogActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (((BaseFragment) CallLogActivity.this).actionBar.isActionModeShowed()) {
                        CallLogActivity.this.hideActionMode(true);
                        return;
                    } else {
                        CallLogActivity.this.finishFragment();
                        return;
                    }
                }
                if (id == 1) {
                    CallLogActivity.this.showDeleteAlert(true);
                } else if (id == 2) {
                    CallLogActivity.this.showDeleteAlert(false);
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(10, R.drawable.ic_ab_other);
        this.otherItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.otherItem.addSubItem(1, R.drawable.msg_delete, LocaleController.getString("DeleteAllCalls", R.string.DeleteAllCalls));
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        this.flickerLoadingView = flickerLoadingView;
        flickerLoadingView.setViewType(8);
        this.flickerLoadingView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.flickerLoadingView.showDate(false);
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, this.flickerLoadingView);
        this.emptyView = emptyTextProgressView;
        frameLayout2.addView(emptyTextProgressView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$TNoew8L_hGhSDIJgW2qUb6TPcVs
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$CallLogActivity(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$G9TJDt5Fwpd4F6HMsBsRUQVWEpI
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$1$CallLogActivity(view, i);
            }
        });
        this.listView.setOnScrollListener(new AnonymousClass2());
        if (this.loading) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
        ImageView imageView = new ImageView(context);
        this.floatingButton = imageView;
        imageView.setVisibility(0);
        this.floatingButton.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor("chats_actionBackground"), Theme.getColor("chats_actionPressedBackground"));
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            Drawable drawableMutate4 = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate4.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate4, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionIcon"), PorterDuff.Mode.MULTIPLY));
        this.floatingButton.setImageResource(R.drawable.ic_call);
        this.floatingButton.setContentDescription(LocaleController.getString("Call", R.string.Call));
        if (i >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButton.setStateListAnimator(stateListAnimator);
            this.floatingButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.CallLogActivity.3
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        ImageView imageView2 = this.floatingButton;
        int i2 = i >= 21 ? 56 : 60;
        float f = i >= 21 ? 56.0f : 60.0f;
        boolean z = LocaleController.isRTL;
        frameLayout2.addView(imageView2, LayoutHelper.createFrame(i2, f, (z ? 3 : 5) | 80, z ? 14.0f : 0.0f, 0.0f, z ? 0.0f : 14.0f, 14.0f));
        this.floatingButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$g7ukxb5pGyDGkfE8Zr9039KINWQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3$CallLogActivity(view);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$CallLogActivity(View view, int i) {
        if (!(view instanceof CallCell)) {
            if (view instanceof GroupCallCell) {
                Bundle bundle = new Bundle();
                bundle.putLong("chat_id", ((GroupCallCell) view).currentChat.id);
                getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
                presentFragment(new ChatActivity(bundle), true);
                return;
            }
            return;
        }
        CallLogRow callLogRow = this.calls.get(i - this.listViewAdapter.callsStartRow);
        if (this.actionBar.isActionModeShowed()) {
            addOrRemoveSelectedDialog(callLogRow.calls, (CallCell) view);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("user_id", callLogRow.user.id);
        bundle2.putInt("message_id", callLogRow.calls.get(0).id);
        getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
        presentFragment(new ChatActivity(bundle2), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$CallLogActivity(View view, int i) {
        if (!(view instanceof CallCell)) {
            return false;
        }
        addOrRemoveSelectedDialog(this.calls.get(i - this.listViewAdapter.callsStartRow).calls, (CallCell) view);
        return true;
    }

    /* renamed from: ir.eitaa.ui.CallLogActivity$2, reason: invalid class name */
    class AnonymousClass2 extends RecyclerView.OnScrollListener {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            boolean z;
            int iFindFirstVisibleItemPosition = CallLogActivity.this.layoutManager.findFirstVisibleItemPosition();
            int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(CallLogActivity.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
            if (iAbs > 0) {
                int itemCount = CallLogActivity.this.listViewAdapter.getItemCount();
                if (!CallLogActivity.this.endReached && !CallLogActivity.this.loading && !CallLogActivity.this.calls.isEmpty() && iAbs + iFindFirstVisibleItemPosition >= itemCount - 5) {
                    final CallLogRow callLogRow = (CallLogRow) CallLogActivity.this.calls.get(CallLogActivity.this.calls.size() - 1);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$2$8Qn7EAE1_dSr8T0TEddvgprpDLs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onScrolled$0$CallLogActivity$2(callLogRow);
                        }
                    });
                }
            }
            if (CallLogActivity.this.floatingButton.getVisibility() != 8) {
                View childAt = recyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                if (CallLogActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                    int i = CallLogActivity.this.prevTop - top;
                    z = top < CallLogActivity.this.prevTop;
                    if (Math.abs(i) > 1) {
                    }
                    if (z && CallLogActivity.this.scrollUpdated) {
                        CallLogActivity.this.hideFloatingButton(z);
                    }
                    CallLogActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                    CallLogActivity.this.prevTop = top;
                    CallLogActivity.this.scrollUpdated = true;
                }
                z = iFindFirstVisibleItemPosition > CallLogActivity.this.prevPosition;
                z = true;
                if (z) {
                    CallLogActivity.this.hideFloatingButton(z);
                }
                CallLogActivity.this.prevPosition = iFindFirstVisibleItemPosition;
                CallLogActivity.this.prevTop = top;
                CallLogActivity.this.scrollUpdated = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onScrolled$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onScrolled$0$CallLogActivity$2(CallLogRow callLogRow) {
            CallLogActivity.this.getCalls(callLogRow.calls.get(r3.size() - 1).id, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$CallLogActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("destroyAfterSelect", true);
        bundle.putBoolean("returnAsResult", true);
        bundle.putBoolean("onlyUsers", true);
        bundle.putBoolean("allowSelf", false);
        ContactsActivity contactsActivity = new ContactsActivity(bundle);
        contactsActivity.setDelegate(new ContactsActivity.ContactsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$iGrDPyz4htV5A1gCKtTT5Ryf2i4
            @Override // ir.eitaa.ui.ContactsActivity.ContactsActivityDelegate
            public final void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity2) {
                this.f$0.lambda$createView$2$CallLogActivity(tLRPC$User, str, contactsActivity2);
            }
        });
        presentFragment(contactsActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$CallLogActivity(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity) {
        TLRPC$UserFull userFull = getMessagesController().getUserFull(tLRPC$User.id);
        this.lastCallUser = tLRPC$User;
        VoIPHelper.startCall(tLRPC$User, false, userFull != null && userFull.video_calls_available, getParentActivity(), null, getAccountInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteAlert(final boolean all) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (all) {
            builder.setTitle(LocaleController.getString("DeleteAllCalls", R.string.DeleteAllCalls));
            builder.setMessage(LocaleController.getString("DeleteAllCallsText", R.string.DeleteAllCallsText));
        } else {
            builder.setTitle(LocaleController.getString("DeleteCalls", R.string.DeleteCalls));
            builder.setMessage(LocaleController.getString("DeleteSelectedCallsText", R.string.DeleteSelectedCallsText));
        }
        final boolean[] zArr = {false};
        FrameLayout frameLayout = new FrameLayout(getParentActivity());
        CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1);
        checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        checkBoxCell.setText(LocaleController.getString("DeleteCallsForEveryone", R.string.DeleteCallsForEveryone), "", false, false);
        checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(8.0f), 0);
        frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 8.0f, 0.0f, 8.0f, 0.0f));
        checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$5rlchflp9ZR4K_OuDBPSEMqo3I4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallLogActivity.lambda$showDeleteAlert$4(zArr, view);
            }
        });
        builder.setView(frameLayout);
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$oLwHwZbsp1ZlgGiIGKIkZaqZXe0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDeleteAlert$5$CallLogActivity(all, zArr, dialogInterface, i);
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

    static /* synthetic */ void lambda$showDeleteAlert$4(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showDeleteAlert$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showDeleteAlert$5$CallLogActivity(boolean z, boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (z) {
            deleteAllMessages(zArr[0]);
            this.calls.clear();
            this.loading = false;
            this.endReached = true;
            this.otherItem.setVisibility(8);
            this.listViewAdapter.notifyDataSetChanged();
        } else {
            getMessagesController().deleteMessages(new ArrayList<>(this.selectedIds), null, null, 0L, zArr[0], false);
        }
        hideActionMode(false);
    }

    private void deleteAllMessages(final boolean revoke) {
        TLRPC$TL_messages_deletePhoneCallHistory tLRPC$TL_messages_deletePhoneCallHistory = new TLRPC$TL_messages_deletePhoneCallHistory();
        tLRPC$TL_messages_deletePhoneCallHistory.revoke = revoke;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deletePhoneCallHistory, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$ERhwA3yGqbO59lOurOl7WSakaL4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteAllMessages$6$CallLogActivity(revoke, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteAllMessages$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteAllMessages$6$CallLogActivity(boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$TL_messages_affectedFoundMessages tLRPC$TL_messages_affectedFoundMessages = (TLRPC$TL_messages_affectedFoundMessages) tLObject;
            TLRPC$TL_updateDeleteMessages tLRPC$TL_updateDeleteMessages = new TLRPC$TL_updateDeleteMessages();
            tLRPC$TL_updateDeleteMessages.messages = tLRPC$TL_messages_affectedFoundMessages.messages;
            tLRPC$TL_updateDeleteMessages.pts = tLRPC$TL_messages_affectedFoundMessages.pts;
            tLRPC$TL_updateDeleteMessages.pts_count = tLRPC$TL_messages_affectedFoundMessages.pts_count;
            TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
            tLRPC$TL_updates.updates.add(tLRPC$TL_updateDeleteMessages);
            getMessagesController().processUpdates(tLRPC$TL_updates, false);
            if (tLRPC$TL_messages_affectedFoundMessages.offset != 0) {
                deleteAllMessages(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideActionMode(boolean animated) {
        this.actionBar.hideActionMode();
        this.selectedIds.clear();
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof CallCell) {
                ((CallCell) childAt).setChecked(false, animated);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSelected(ArrayList<TLRPC$Message> messages) {
        int size = messages.size();
        for (int i = 0; i < size; i++) {
            if (this.selectedIds.contains(Integer.valueOf(messages.get(i).id))) {
                return true;
            }
        }
        return false;
    }

    private void createActionMode() {
        if (this.actionBar.actionModeIsExist(null)) {
            return;
        }
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode();
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedDialogsCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedDialogsCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.selectedDialogsCountTextView.setTextColor(Theme.getColor("actionBarActionModeDefaultIcon"));
        actionBarMenuCreateActionMode.addView(this.selectedDialogsCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedDialogsCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$8gfO_6l5mDXBlbVoiQs5qZ4UmeM
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CallLogActivity.lambda$createActionMode$7(view, motionEvent);
            }
        });
        this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(2, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete)));
    }

    private boolean addOrRemoveSelectedDialog(ArrayList<TLRPC$Message> messages, CallCell cell) {
        if (messages.isEmpty()) {
            return false;
        }
        if (isSelected(messages)) {
            int size = messages.size();
            for (int i = 0; i < size; i++) {
                this.selectedIds.remove(Integer.valueOf(messages.get(i).id));
            }
            cell.setChecked(false, true);
            showOrUpdateActionMode();
            return false;
        }
        int size2 = messages.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Integer numValueOf = Integer.valueOf(messages.get(i2).id);
            if (!this.selectedIds.contains(numValueOf)) {
                this.selectedIds.add(numValueOf);
            }
        }
        cell.setChecked(true, true);
        showOrUpdateActionMode();
        return true;
    }

    private void showOrUpdateActionMode() {
        boolean z = false;
        if (this.actionBar.isActionModeShowed()) {
            if (this.selectedIds.isEmpty()) {
                hideActionMode(true);
                return;
            }
            z = true;
        } else {
            createActionMode();
            this.actionBar.showActionMode();
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.actionModeViews.size(); i++) {
                View view = this.actionModeViews.get(i);
                view.setPivotY(ActionBar.getCurrentActionBarHeight() / 2);
                AndroidUtilities.clearDrawableAnimation(view);
                arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.1f, 1.0f));
            }
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(200L);
            animatorSet.start();
        }
        this.selectedDialogsCountTextView.setNumber(this.selectedIds.size(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean hide) {
        if (this.floatingHidden == hide) {
            return;
        }
        this.floatingHidden = hide;
        ImageView imageView = this.floatingButton;
        float[] fArr = new float[1];
        fArr[0] = hide ? AndroidUtilities.dp(100.0f) : 0.0f;
        ObjectAnimator duration = ObjectAnimator.ofFloat(imageView, "translationY", fArr).setDuration(300L);
        duration.setInterpolator(this.floatingInterpolator);
        this.floatingButton.setClickable(!hide);
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCalls(int max_id, final int count) {
        if (this.loading) {
            return;
        }
        this.loading = true;
        EmptyTextProgressView emptyTextProgressView = this.emptyView;
        if (emptyTextProgressView != null && !this.firstLoaded) {
            emptyTextProgressView.showProgress();
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
        tLRPC$TL_messages_search.limit = count;
        tLRPC$TL_messages_search.peer = new TLRPC$TL_inputPeerEmpty();
        tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterPhoneCalls();
        tLRPC$TL_messages_search.q = "";
        tLRPC$TL_messages_search.offset_id = max_id;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_search, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$VueUpQTAqk2HtOhZhSXQ-c3rBpk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getCalls$9$CallLogActivity(tLObject, tLRPC$TL_error);
            }
        }, 2), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getCalls$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getCalls$9$CallLogActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$Xq4W8mLwMBVB5IsMTfx5UCoSBCM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCalls$8$CallLogActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getCalls$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getCalls$8$CallLogActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        CallLogRow callLogRow;
        int iMax = Math.max(this.listViewAdapter.callsStartRow, 0) + this.calls.size();
        if (tLRPC$TL_error == null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            this.endReached = tLRPC$messages_Messages.messages.isEmpty();
            for (int i = 0; i < tLRPC$messages_Messages.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i);
                longSparseArray.put(tLRPC$User.id, tLRPC$User);
            }
            if (this.calls.size() > 0) {
                ArrayList<CallLogRow> arrayList = this.calls;
                callLogRow = arrayList.get(arrayList.size() - 1);
            } else {
                callLogRow = null;
            }
            for (int i2 = 0; i2 < tLRPC$messages_Messages.messages.size(); i2++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i2);
                TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
                if (tLRPC$MessageAction != null && !(tLRPC$MessageAction instanceof TLRPC$TL_messageActionHistoryClear)) {
                    int i3 = MessageObject.getFromChatId(tLRPC$Message) == getUserConfig().getClientUserId() ? 0 : 1;
                    TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = tLRPC$Message.action.reason;
                    if (i3 == 1 && ((tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed) || (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy))) {
                        i3 = 2;
                    }
                    long fromChatId = MessageObject.getFromChatId(tLRPC$Message);
                    if (fromChatId == getUserConfig().getClientUserId()) {
                        fromChatId = tLRPC$Message.peer_id.user_id;
                    }
                    if (callLogRow == null || callLogRow.user.id != fromChatId || callLogRow.type != i3) {
                        if (callLogRow != null && !this.calls.contains(callLogRow)) {
                            this.calls.add(callLogRow);
                        }
                        callLogRow = new CallLogRow();
                        callLogRow.calls = new ArrayList<>();
                        callLogRow.user = (TLRPC$User) longSparseArray.get(fromChatId);
                        callLogRow.type = i3;
                        TLRPC$MessageAction tLRPC$MessageAction2 = tLRPC$Message.action;
                        callLogRow.video = tLRPC$MessageAction2 != null && tLRPC$MessageAction2.video;
                    }
                    callLogRow.calls.add(tLRPC$Message);
                }
            }
            if (callLogRow != null && callLogRow.calls.size() > 0 && !this.calls.contains(callLogRow)) {
                this.calls.add(callLogRow);
            }
        } else {
            this.endReached = true;
        }
        this.loading = false;
        showItemsAnimated(iMax);
        if (!this.firstLoaded) {
            resumeDelayedFragmentAnimation();
        }
        this.firstLoaded = true;
        this.otherItem.setVisibility(this.calls.isEmpty() ? 8 : 0);
        EmptyTextProgressView emptyTextProgressView = this.emptyView;
        if (emptyTextProgressView != null) {
            emptyTextProgressView.showTextView();
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        boolean z;
        if (requestCode == 101 || requestCode == 102 || requestCode == 103) {
            int i = 0;
            while (true) {
                if (i >= grantResults.length) {
                    z = true;
                    break;
                } else {
                    if (grantResults[i] != 0) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (grantResults.length <= 0 || !z) {
                VoIPHelper.permissionDenied(getParentActivity(), null, requestCode);
            } else if (requestCode == 103) {
                VoIPHelper.startCall(this.lastCallChat, null, null, false, getParentActivity(), this, getAccountInstance());
            } else {
                TLRPC$UserFull userFull = this.lastCallUser != null ? getMessagesController().getUserFull(this.lastCallUser.id) : null;
                VoIPHelper.startCall(this.lastCallUser, requestCode == 102, requestCode == 102 || (userFull != null && userFull.video_calls_available), getParentActivity(), null, getAccountInstance());
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private int activeEndRow;
        private int activeHeaderRow;
        private int activeStartRow;
        private int callsEndRow;
        private int callsHeaderRow;
        private int callsStartRow;
        private int loadingCallsRow;
        private Context mContext;
        private int rowsCount;
        private int sectionRow;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        private void updateRows() {
            this.activeHeaderRow = -1;
            this.callsHeaderRow = -1;
            this.activeStartRow = -1;
            this.activeEndRow = -1;
            this.callsStartRow = -1;
            this.callsEndRow = -1;
            this.loadingCallsRow = -1;
            this.sectionRow = -1;
            this.rowsCount = 0;
            if (!CallLogActivity.this.activeGroupCalls.isEmpty()) {
                int i = this.rowsCount;
                int i2 = i + 1;
                this.rowsCount = i2;
                this.activeHeaderRow = i;
                this.activeStartRow = i2;
                int size = i2 + CallLogActivity.this.activeGroupCalls.size();
                this.rowsCount = size;
                this.activeEndRow = size;
            }
            if (CallLogActivity.this.calls.isEmpty()) {
                return;
            }
            if (this.activeHeaderRow != -1) {
                int i3 = this.rowsCount;
                int i4 = i3 + 1;
                this.rowsCount = i4;
                this.sectionRow = i3;
                this.rowsCount = i4 + 1;
                this.callsHeaderRow = i4;
            }
            int i5 = this.rowsCount;
            this.callsStartRow = i5;
            int size2 = i5 + CallLogActivity.this.calls.size();
            this.rowsCount = size2;
            this.callsEndRow = size2;
            if (CallLogActivity.this.endReached) {
                return;
            }
            int i6 = this.rowsCount;
            this.rowsCount = i6 + 1;
            this.loadingCallsRow = i6;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRows();
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int position) {
            updateRows();
            super.notifyItemChanged(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            updateRows();
            super.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemInserted(int position) {
            updateRows();
            super.notifyItemInserted(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemMoved(int fromPosition, int toPosition) {
            updateRows();
            super.notifyItemMoved(fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            updateRows();
            super.notifyItemRemoved(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowsCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View callCell;
            View view;
            if (i != 0) {
                if (i == 1) {
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(8);
                    flickerLoadingView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    flickerLoadingView.showDate(false);
                    view = flickerLoadingView;
                } else if (i == 2) {
                    callCell = new TextInfoPrivacyCell(this.mContext);
                    callCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                } else if (i == 3) {
                    HeaderCell headerCell = new HeaderCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    view = headerCell;
                } else if (i == 4) {
                    callCell = CallLogActivity.this.new GroupCallCell(this.mContext);
                } else {
                    callCell = new ShadowSectionCell(this.mContext);
                }
                callCell = view;
            } else {
                callCell = CallLogActivity.this.new CallCell(this.mContext);
            }
            return new RecyclerListView.Holder(callCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof CallCell) {
                ((CallCell) holder.itemView).setChecked(CallLogActivity.this.isSelected(((CallLogRow) CallLogActivity.this.calls.get(holder.getAdapterPosition() - this.callsStartRow)).calls), false);
                return;
            }
            if (view instanceof GroupCallCell) {
                GroupCallCell groupCallCell = (GroupCallCell) view;
                TLRPC$Chat chat = groupCallCell.profileSearchCell.getChat();
                if (CallLogActivity.this.waitingForCallChatId == null || chat.id != CallLogActivity.this.waitingForCallChatId.longValue()) {
                    groupCallCell.button.setDrawProgress(false, false);
                    return;
                }
                CallLogActivity.this.waitingForLoadButton = groupCallCell.button;
                groupCallCell.button.setDrawProgress(true, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            SpannableString spannableString;
            String lowerCase;
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 3) {
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position == this.activeHeaderRow) {
                        headerCell.setText(LocaleController.getString("VoipChatActiveChats", R.string.VoipChatActiveChats));
                        return;
                    } else {
                        if (position == this.callsHeaderRow) {
                            headerCell.setText(LocaleController.getString("VoipChatRecentCalls", R.string.VoipChatRecentCalls));
                            return;
                        }
                        return;
                    }
                }
                if (itemViewType != 4) {
                    return;
                }
                int i = position - this.activeStartRow;
                TLRPC$Chat chat = CallLogActivity.this.getMessagesController().getChat((Long) CallLogActivity.this.activeGroupCalls.get(i));
                GroupCallCell groupCallCell = (GroupCallCell) holder.itemView;
                groupCallCell.setChat(chat);
                groupCallCell.button.setTag(Long.valueOf(chat.id));
                if (ChatObject.isChannel(chat) && !chat.megagroup) {
                    if (TextUtils.isEmpty(chat.username)) {
                        lowerCase = LocaleController.getString("ChannelPrivate", R.string.ChannelPrivate).toLowerCase();
                    } else {
                        lowerCase = LocaleController.getString("ChannelPublic", R.string.ChannelPublic).toLowerCase();
                    }
                } else if (chat.has_geo) {
                    lowerCase = LocaleController.getString("MegaLocation", R.string.MegaLocation);
                } else if (TextUtils.isEmpty(chat.username)) {
                    lowerCase = LocaleController.getString("MegaPrivate", R.string.MegaPrivate).toLowerCase();
                } else {
                    lowerCase = LocaleController.getString("MegaPublic", R.string.MegaPublic).toLowerCase();
                }
                groupCallCell.profileSearchCell.setData(chat, null, null, lowerCase, false, false);
                groupCallCell.profileSearchCell.useSeparator = (i == CallLogActivity.this.activeGroupCalls.size() - 1 && CallLogActivity.this.endReached) ? false : true;
                return;
            }
            int i2 = position - this.callsStartRow;
            CallLogRow callLogRow = (CallLogRow) CallLogActivity.this.calls.get(i2);
            CallCell callCell = (CallCell) holder.itemView;
            callCell.imageView.setImageResource(callLogRow.video ? R.drawable.profile_video : R.drawable.profile_phone);
            TLRPC$Message tLRPC$Message = callLogRow.calls.get(0);
            String str = LocaleController.isRTL ? "\u202b" : "";
            if (callLogRow.calls.size() == 1) {
                spannableString = new SpannableString(str + "  " + LocaleController.formatDateCallLog(tLRPC$Message.date));
            } else {
                spannableString = new SpannableString(String.format(str + "  (%d) %s", Integer.valueOf(callLogRow.calls.size()), LocaleController.formatDateCallLog(tLRPC$Message.date)));
            }
            SpannableString spannableString2 = spannableString;
            int i3 = callLogRow.type;
            if (i3 == 0) {
                spannableString2.setSpan(CallLogActivity.this.iconOut, str.length(), str.length() + 1, 0);
            } else if (i3 == 1) {
                spannableString2.setSpan(CallLogActivity.this.iconIn, str.length(), str.length() + 1, 0);
            } else if (i3 == 2) {
                spannableString2.setSpan(CallLogActivity.this.iconMissed, str.length(), str.length() + 1, 0);
            }
            callCell.profileSearchCell.setData(callLogRow.user, null, null, spannableString2, false, false);
            callCell.profileSearchCell.useSeparator = (i2 == CallLogActivity.this.calls.size() - 1 && CallLogActivity.this.endReached) ? false : true;
            callCell.imageView.setTag(callLogRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.activeHeaderRow || i == this.callsHeaderRow) {
                return 3;
            }
            if (i >= this.callsStartRow && i < this.callsEndRow) {
                return 0;
            }
            if (i >= this.activeStartRow && i < this.activeEndRow) {
                return 4;
            }
            if (i == this.loadingCallsRow) {
                return 1;
            }
            return i == this.sectionRow ? 5 : 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class CallLogRow {
        public ArrayList<TLRPC$Message> calls;
        public int type;
        public TLRPC$User user;
        public boolean video;

        private CallLogRow() {
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        super.onTransitionAnimationStart(isOpen, backward);
        if (isOpen) {
            this.openTransitionStarted = true;
        }
    }

    private void showItemsAnimated(final int from) {
        if (this.isPaused || !this.openTransitionStarted) {
            return;
        }
        final View view = null;
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            this.listView.removeView(view);
        }
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.CallLogActivity.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                CallLogActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = CallLogActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = CallLogActivity.this.listView.getChildAt(i2);
                    RecyclerView.ViewHolder childViewHolder = CallLogActivity.this.listView.getChildViewHolder(childAt2);
                    if (childAt2 != view && CallLogActivity.this.listView.getChildAdapterPosition(childAt2) >= from && !(childAt2 instanceof GroupCallCell) && (!(childAt2 instanceof HeaderCell) || childViewHolder.getAdapterPosition() != CallLogActivity.this.listViewAdapter.activeHeaderRow)) {
                        childAt2.setAlpha(0.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay((int) ((Math.min(CallLogActivity.this.listView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / CallLogActivity.this.listView.getMeasuredHeight()) * 100.0f));
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                }
                View view2 = view;
                if (view2 != null && view2.getParent() == null) {
                    CallLogActivity.this.listView.addView(view);
                    final RecyclerView.LayoutManager layoutManager = CallLogActivity.this.listView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.ignoreView(view);
                        View view3 = view;
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.CallLogActivity.4.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                view.setAlpha(1.0f);
                                layoutManager.stopIgnoringView(view);
                                CallLogActivity.this.listView.removeView(view);
                            }
                        });
                        objectAnimatorOfFloat2.start();
                    }
                }
                animatorSet.start();
                return true;
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CallLogActivity$bkxu6zVOOTwOuwtDEWUoWQDCBD8
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$10$CallLogActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{LocationCell.class, CallCell.class, HeaderCell.class, GroupCallCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EmptyTextProgressView.class}, new String[]{"emptyTextView1"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EmptyTextProgressView.class}, new String[]{"emptyTextView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionIcon"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "chats_actionBackground"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "chats_actionPressedBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, "chats_verifiedCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, "chats_verifiedBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, Theme.dialogs_offlinePaint, null, null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, Theme.dialogs_onlinePaint, null, null, "windowBackgroundWhiteBlueText3"));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_name"));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_secretName"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CallCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, new Drawable[]{this.greenDrawable, this.greenDrawable2, Theme.calllog_msgCallUpRedDrawable, Theme.calllog_msgCallDownRedDrawable}, null, "calls_callReceivedGreenIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, new Drawable[]{this.redDrawable, Theme.calllog_msgCallUpGreenDrawable, Theme.calllog_msgCallDownGreenDrawable}, null, "calls_callReceivedRedIcon"));
        arrayList.add(new ThemeDescription(this.flickerLoadingView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$10$CallLogActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof CallCell) {
                    ((CallCell) childAt).profileSearchCell.update(0);
                }
            }
        }
    }
}
