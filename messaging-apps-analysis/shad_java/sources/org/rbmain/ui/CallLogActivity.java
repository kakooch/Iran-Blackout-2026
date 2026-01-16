package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
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
import android.text.style.ImageSpan;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.activity.MainTabFragment;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$PhoneCallDiscardReason;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterPhoneCalls;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageActionHistoryClear;
import org.rbmain.tgnet.TLRPC$TL_messageActionPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_messages_affectedFoundMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_deletePhoneCallHistory;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import org.rbmain.tgnet.TLRPC$TL_updateDeleteMessages;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.LocationCell;
import org.rbmain.ui.Cells.ProfileSearchCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberTextView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.voip.VoIPHelper;
import org.rbmain.ui.ContactsActivity;

/* loaded from: classes4.dex */
public class CallLogActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
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
    private TLRPC$User lastCallUser;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private boolean loading;
    private boolean openTransitionStarted;
    private int prevPosition;
    private int prevTop;
    private Drawable redDrawable;
    private boolean scrollUpdated;
    private NumberTextView selectedDialogsCountTextView;
    private ArrayList<View> actionModeViews = new ArrayList<>();
    private ArrayList<CallLogRow> calls = new ArrayList<>();
    private ArrayList<Long> selectedIds = new ArrayList<>();
    private final AccelerateDecelerateInterpolator floatingInterpolator = new AccelerateDecelerateInterpolator();
    private String nextStartId = null;
    private View.OnClickListener callBtnClickListener = new View.OnClickListener() { // from class: org.rbmain.ui.CallLogActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CallLogRow callLogRow = (CallLogRow) view.getTag();
            TLRPC$UserFull userFull = CallLogActivity.this.getMessagesController().getUserFull(callLogRow.user.id);
            TLRPC$User tLRPC$User = CallLogActivity.this.lastCallUser = callLogRow.user;
            boolean z = callLogRow.video;
            VoIPHelper.startCall(tLRPC$User, z, z || (userFull != null && userFull.video_calls_available), CallLogActivity.this.getParentActivity(), null, CallLogActivity.this.getAccountInstance());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createActionMode$8(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return true;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ListAdapter listAdapter;
        boolean z = false;
        if (i == NotificationCenter.didReceiveNewMessages && this.firstLoaded) {
            if (((Boolean) objArr[2]).booleanValue()) {
                return;
            }
            Iterator it = ((ArrayList) objArr[1]).iterator();
            while (it.hasNext()) {
                MessageObject messageObject = (MessageObject) it.next();
                if (messageObject.messageOwner.action instanceof TLRPC$TL_messageActionPhoneCall) {
                    int fromChatId = messageObject.getFromChatId();
                    int i3 = fromChatId == UserConfig.getInstance(this.currentAccount).getClientUserId() ? messageObject.messageOwner.peer_id.user_id : fromChatId;
                    int i4 = fromChatId == UserConfig.getInstance(this.currentAccount).getClientUserId() ? 0 : 1;
                    TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = messageObject.messageOwner.action.reason;
                    if (i4 == 1 && ((tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed) || (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy))) {
                        i4 = 2;
                    }
                    if (this.calls.size() > 0) {
                        CallLogRow callLogRow = this.calls.get(0);
                        if (callLogRow.user.id == i3 && callLogRow.type == i4) {
                            callLogRow.calls.add(0, messageObject.messageOwner);
                            this.listViewAdapter.notifyItemChanged(0);
                        }
                    }
                    CallLogRow callLogRow2 = new CallLogRow();
                    ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
                    callLogRow2.calls = arrayList;
                    arrayList.add(messageObject.messageOwner);
                    callLogRow2.user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i3));
                    callLogRow2.type = i4;
                    callLogRow2.video = messageObject.isVideoCall();
                    this.calls.add(0, callLogRow2);
                    this.listViewAdapter.notifyItemInserted(0);
                }
            }
            return;
        }
        if (i == NotificationCenter.messagesDeleted && this.firstLoaded && !((Boolean) objArr[2]).booleanValue()) {
            ArrayList arrayList2 = (ArrayList) objArr[0];
            Iterator<CallLogRow> it2 = this.calls.iterator();
            while (it2.hasNext()) {
                CallLogRow next = it2.next();
                Iterator<TLRPC$Message> it3 = next.calls.iterator();
                while (it3.hasNext()) {
                    if (arrayList2.contains(Long.valueOf(it3.next().id))) {
                        it3.remove();
                        z = true;
                    }
                }
                if (next.calls.size() == 0) {
                    it2.remove();
                }
            }
            if (!z || (listAdapter = this.listViewAdapter) == null) {
                return;
            }
            listAdapter.notifyDataSetChanged();
        }
    }

    private class CustomCell extends FrameLayout {
        private CheckBox2 checkBox;
        private ImageView imageView;
        private ProfileSearchCell profileSearchCell;

        public CustomCell(CallLogActivity callLogActivity, Context context) {
            super(context);
            int i = Theme.key_windowBackgroundWhite;
            setBackgroundColor(Theme.getColor(i));
            ProfileSearchCell profileSearchCell = new ProfileSearchCell(context);
            this.profileSearchCell = profileSearchCell;
            profileSearchCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(32.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(32.0f), 0);
            this.profileSearchCell.setSublabelOffset(AndroidUtilities.dp(LocaleController.isRTL ? 2.0f : -2.0f), -AndroidUtilities.dp(4.0f));
            addView(this.profileSearchCell, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setAlpha(214);
            this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_featuredStickers_addButton), PorterDuff.Mode.MULTIPLY));
            this.imageView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 1));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setOnClickListener(callLogActivity.callBtnClickListener);
            this.imageView.setContentDescription(LocaleController.getString("Call", R.string.Call));
            addView(this.imageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 3 : 5) | 16, 8.0f, 0.0f, 8.0f, 0.0f));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(-1, i, Theme.key_checkboxCheck);
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox, LayoutHelper.createFrame(24, 24.0f, (LocaleController.isRTL ? 5 : 3) | 48, 42.0f, 32.0f, 42.0f, 0.0f));
        }

        public void setChecked(boolean z, boolean z2) {
            CheckBox2 checkBox2 = this.checkBox;
            if (checkBox2 == null) {
                return;
            }
            checkBox2.setChecked(z, z2);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getCalls(0L, 50);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Drawable drawableMutate = getParentActivity().getResources().getDrawable(R.drawable.ic_call_made_green_18dp).mutate();
        this.greenDrawable = drawableMutate;
        drawableMutate.setBounds(0, 0, drawableMutate.getIntrinsicWidth(), this.greenDrawable.getIntrinsicHeight());
        Drawable drawable = this.greenDrawable;
        int i = Theme.key_calls_callReceivedGreenIcon;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        this.iconOut = new ImageSpan(this.greenDrawable, 0);
        Drawable drawableMutate2 = getParentActivity().getResources().getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
        this.greenDrawable2 = drawableMutate2;
        drawableMutate2.setBounds(0, 0, drawableMutate2.getIntrinsicWidth(), this.greenDrawable2.getIntrinsicHeight());
        this.greenDrawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        this.iconIn = new ImageSpan(this.greenDrawable2, 0);
        Drawable drawableMutate3 = getParentActivity().getResources().getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
        this.redDrawable = drawableMutate3;
        drawableMutate3.setBounds(0, 0, drawableMutate3.getIntrinsicWidth(), this.redDrawable.getIntrinsicHeight());
        this.redDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_calls_callReceivedRedIcon), PorterDuff.Mode.MULTIPLY));
        this.iconMissed = new ImageSpan(this.redDrawable, 0);
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Calls", R.string.Calls));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.CallLogActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    if (((BaseFragment) CallLogActivity.this).actionBar.isActionModeShowed()) {
                        CallLogActivity.this.hideActionMode(true);
                        return;
                    } else {
                        ApplicationLoader.applicationActivity.onBackPressed();
                        return;
                    }
                }
                if (i2 == 1) {
                    CallLogActivity.this.showDeleteAlert(true);
                } else if (i2 == 2) {
                    CallLogActivity.this.showDeleteAlert(false);
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        this.flickerLoadingView = flickerLoadingView;
        flickerLoadingView.setViewType(8);
        this.flickerLoadingView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.flickerLoadingView.showDate(false);
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, this.flickerLoadingView);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.setText(LocaleController.getString("NoCallLog", R.string.NoCallLog));
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda9
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$0(view, i2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda10
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$createView$1(view, i2);
            }
        });
        this.listView.setOnScrollListener(new AnonymousClass3());
        if (this.loading) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
        ImageView imageView = new ImageView(context);
        this.floatingButton = imageView;
        imageView.setVisibility(0);
        this.floatingButton.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(Theme.key_chats_actionBackground), Theme.getColor(Theme.key_chats_actionPressedBackground));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            Drawable drawableMutate4 = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate4.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate4, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionIcon), PorterDuff.Mode.MULTIPLY));
        this.floatingButton.setImageResource(R.drawable.ic_call);
        this.floatingButton.setContentDescription(LocaleController.getString("Call", R.string.Call));
        if (i2 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButton.setStateListAnimator(stateListAnimator);
            this.floatingButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.CallLogActivity.4
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        ImageView imageView2 = this.floatingButton;
        int i3 = i2 >= 21 ? 56 : 60;
        float f = i2 >= 21 ? 56.0f : 60.0f;
        boolean z = LocaleController.isRTL;
        frameLayout2.addView(imageView2, LayoutHelper.createFrame(i3, f, (z ? 3 : 5) | 80, z ? 14.0f : 0.0f, 0.0f, z ? 0.0f : 14.0f, 14.0f));
        this.floatingButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3(view);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        if (i < 0 || i >= this.calls.size()) {
            return;
        }
        CallLogRow callLogRow = this.calls.get(i);
        if (this.actionBar.isActionModeShowed()) {
            addOrRemoveSelectedDialog(callLogRow.calls, (CustomCell) view);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("user_id", callLogRow.user.id);
        bundle.putLong("message_id", callLogRow.calls.get(0).id);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
        presentFragment(new ChatActivity(bundle), !(ApplicationLoader.applicationActivity.getLastFragment() instanceof MainTabFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(View view, int i) {
        if (i < 0 || i >= this.calls.size()) {
            return false;
        }
        showDeleteAlert(this.calls.get(i).calls);
        return true;
    }

    /* renamed from: org.rbmain.ui.CallLogActivity$3, reason: invalid class name */
    class AnonymousClass3 extends RecyclerView.OnScrollListener {
        AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            int iFindFirstVisibleItemPosition = CallLogActivity.this.layoutManager.findFirstVisibleItemPosition();
            int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(CallLogActivity.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
            if (iAbs > 0) {
                int itemCount = CallLogActivity.this.listViewAdapter.getItemCount();
                if (!CallLogActivity.this.endReached && !CallLogActivity.this.loading && !CallLogActivity.this.calls.isEmpty() && iAbs + iFindFirstVisibleItemPosition >= itemCount - 5) {
                    final CallLogRow callLogRow = (CallLogRow) CallLogActivity.this.calls.get(CallLogActivity.this.calls.size() - 1);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CallLogActivity$3$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onScrolled$0(callLogRow);
                        }
                    });
                }
            }
            if (CallLogActivity.this.floatingButton.getVisibility() != 8) {
                View childAt = recyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                if (CallLogActivity.this.prevPosition == iFindFirstVisibleItemPosition) {
                    int i3 = CallLogActivity.this.prevTop - top;
                    z = top < CallLogActivity.this.prevTop;
                    if (Math.abs(i3) > 1) {
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
        public /* synthetic */ void lambda$onScrolled$0(CallLogRow callLogRow) {
            CallLogActivity.this.getCalls(callLogRow.calls.get(r4.size() - 1).id, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("destroyAfterSelect", true);
        bundle.putBoolean("returnAsResult", true);
        bundle.putBoolean("onlyUsers", true);
        bundle.putBoolean("allowSelf", false);
        ContactsActivity contactsActivity = new ContactsActivity(bundle);
        contactsActivity.setDelegate(new ContactsActivity.ContactsActivityDelegate() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda11
            @Override // org.rbmain.ui.ContactsActivity.ContactsActivityDelegate
            public final void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity2) {
                this.f$0.lambda$createView$2(tLRPC$User, str, contactsActivity2);
            }
        });
        presentFragment(contactsActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity) {
        TLRPC$UserFull userFull = getMessagesController().getUserFull(tLRPC$User.id);
        this.lastCallUser = tLRPC$User;
        VoIPHelper.startCall(tLRPC$User, false, userFull != null && userFull.video_calls_available, getParentActivity(), null, getAccountInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteAlert(final boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (z) {
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
        checkBoxCell.setText(LocaleController.getString("DeleteCallsForEveryone", R.string.DeleteCallsForEveryone), BuildConfig.FLAVOR, false, false);
        checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : 0, 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(8.0f), 0);
        frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 8.0f, 0.0f, 8.0f, 0.0f));
        checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallLogActivity.lambda$showDeleteAlert$4(zArr, view);
            }
        });
        builder.setView(frameLayout);
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDeleteAlert$5(z, zArr, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showDeleteAlert$4(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteAlert$5(boolean z, boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (z) {
            deleteAllMessages(zArr[0]);
            this.calls.clear();
            this.loading = false;
            this.endReached = true;
            this.listViewAdapter.notifyDataSetChanged();
        } else {
            getMessagesController().deleteMessages(new ArrayList<>(this.selectedIds), null, null, 0L, 0, zArr[0], false);
        }
        hideActionMode(false);
    }

    private void showDeleteAlert(final ArrayList<TLRPC$Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("DeleteCalls", R.string.DeleteCalls));
        builder.setMessage(LocaleController.getString("DeleteSelectedCallsText", R.string.DeleteSelectedCallsText));
        builder.setView(new FrameLayout(getParentActivity()));
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDeleteAlert$6(arrayList, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteAlert$6(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        TLRPC$Message tLRPC$Message;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            while (it.hasNext()) {
                tLRPC$Message = (TLRPC$Message) it.next();
                if (tLRPC$Message != null) {
                    break;
                }
            }
            getMessagesController().deleteMessages(new ArrayList<>(arrayList2), null, null, j2, 0, false, false);
            return;
            arrayList2.add(Long.valueOf(tLRPC$Message.id));
            j = tLRPC$Message.dialog_id;
        }
    }

    private void deleteAllMessages(final boolean z) {
        TLRPC$TL_messages_deletePhoneCallHistory tLRPC$TL_messages_deletePhoneCallHistory = new TLRPC$TL_messages_deletePhoneCallHistory();
        tLRPC$TL_messages_deletePhoneCallHistory.revoke = z;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deletePhoneCallHistory, new RequestDelegate() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda7
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteAllMessages$7(z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAllMessages$7(boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
    public void hideActionMode(boolean z) {
        this.actionBar.hideActionMode();
        this.selectedIds.clear();
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((CustomCell) this.listView.getChildAt(i)).setChecked(false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSelected(ArrayList<TLRPC$Message> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (this.selectedIds.contains(Long.valueOf(arrayList.get(i).id))) {
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
        this.selectedDialogsCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedDialogsCountTextView.setTextColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon));
        actionBarMenuCreateActionMode.addView(this.selectedDialogsCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
        this.selectedDialogsCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CallLogActivity.lambda$createActionMode$8(view, motionEvent);
            }
        });
        this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(2, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete)));
    }

    private boolean addOrRemoveSelectedDialog(ArrayList<TLRPC$Message> arrayList, CustomCell customCell) {
        if (arrayList.isEmpty()) {
            return false;
        }
        if (isSelected(arrayList)) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.selectedIds.remove(Long.valueOf(arrayList.get(i).id));
            }
            customCell.setChecked(false, true);
            showOrUpdateActionMode();
            return false;
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Long lValueOf = Long.valueOf(arrayList.get(i2).id);
            if (!this.selectedIds.contains(lValueOf)) {
                this.selectedIds.add(lValueOf);
            }
        }
        customCell.setChecked(true, true);
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
    public void hideFloatingButton(boolean z) {
        if (this.floatingHidden == z) {
            return;
        }
        this.floatingHidden = z;
        ImageView imageView = this.floatingButton;
        float[] fArr = new float[1];
        fArr[0] = z ? AndroidUtilities.dp(100.0f) : 0.0f;
        ObjectAnimator duration = ObjectAnimator.ofFloat(imageView, "translationY", fArr).setDuration(300L);
        duration.setInterpolator(this.floatingInterpolator);
        this.floatingButton.setClickable(!z);
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCalls(long j, int i) {
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
        tLRPC$TL_messages_search.limit = i;
        tLRPC$TL_messages_search.peer = new TLRPC$TL_inputPeerEmpty();
        tLRPC$TL_messages_search.filter = new TLRPC$TL_inputMessagesFilterPhoneCalls();
        tLRPC$TL_messages_search.q = BuildConfig.FLAVOR;
        tLRPC$TL_messages_search.offset_id = j;
        tLRPC$TL_messages_search.nextStartId = this.nextStartId;
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().getCalls(tLRPC$TL_messages_search, new RequestDelegate() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda6
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getCalls$10(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCalls$10(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCalls$9(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCalls$9(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        CallLogRow callLogRow;
        int size = this.calls.size();
        if (tLRPC$TL_error == null) {
            SparseArray sparseArray = new SparseArray();
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            this.endReached = !tLRPC$messages_Messages.hasContinue;
            this.nextStartId = tLRPC$messages_Messages.nextStartId;
            for (int i = 0; i < tLRPC$messages_Messages.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i);
                sparseArray.put(tLRPC$User.id, tLRPC$User);
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
                    int i3 = MessageObject.getFromChatId(tLRPC$Message) == UserConfig.getInstance(this.currentAccount).getClientUserId() ? 0 : 1;
                    TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = tLRPC$Message.action.reason;
                    if (i3 == 1 && ((tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed) || (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy))) {
                        i3 = 2;
                    }
                    int fromChatId = MessageObject.getFromChatId(tLRPC$Message);
                    if (fromChatId == UserConfig.getInstance(this.currentAccount).getClientUserId()) {
                        fromChatId = tLRPC$Message.peer_id.user_id;
                    }
                    if (callLogRow == null || callLogRow.user.id != fromChatId || callLogRow.type != i3) {
                        if (callLogRow != null && !this.calls.contains(callLogRow)) {
                            this.calls.add(callLogRow);
                        }
                        callLogRow = new CallLogRow();
                        callLogRow.calls = new ArrayList<>();
                        callLogRow.user = (TLRPC$User) sparseArray.get(fromChatId);
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
        showItemsAnimated(size);
        if (!this.firstLoaded) {
            resumeDelayedFragmentAnimation();
        }
        this.firstLoaded = true;
        EmptyTextProgressView emptyTextProgressView = this.emptyView;
        if (emptyTextProgressView != null) {
            emptyTextProgressView.showTextView();
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        boolean z;
        if (i == 101 || i == 102) {
            int i2 = 0;
            while (true) {
                if (i2 >= iArr.length) {
                    z = true;
                    break;
                } else {
                    if (iArr[i2] != 0) {
                        z = false;
                        break;
                    }
                    i2++;
                }
            }
            if (iArr.length > 0 && z) {
                TLRPC$UserFull userFull = this.lastCallUser != null ? getMessagesController().getUserFull(this.lastCallUser.id) : null;
                VoIPHelper.startCall(this.lastCallUser, i == 102, i == 102 || (userFull != null && userFull.video_calls_available), getParentActivity(), null, getAccountInstance());
            } else {
                VoIPHelper.permissionDenied(getParentActivity(), null, i);
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getAdapterPosition() != CallLogActivity.this.calls.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = CallLogActivity.this.calls.size();
            return (CallLogActivity.this.calls.isEmpty() || CallLogActivity.this.endReached) ? size : size + 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            if (i == 0) {
                CustomCell customCell = new CustomCell(CallLogActivity.this, this.mContext);
                customCell.setTag(new ViewItem(customCell.imageView, customCell.profileSearchCell));
                frameLayout = customCell;
            } else if (i == 1) {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(8);
                flickerLoadingView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                flickerLoadingView.showDate(false);
                frameLayout = flickerLoadingView;
            } else {
                FrameLayout textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                frameLayout = textInfoPrivacyCell;
            }
            return new RecyclerListView.Holder(frameLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof CustomCell) {
                ((CustomCell) viewHolder.itemView).setChecked(CallLogActivity.this.isSelected(((CallLogRow) CallLogActivity.this.calls.get(viewHolder.getAdapterPosition())).calls), false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            SpannableString spannableString;
            if (viewHolder.getItemViewType() == 0) {
                CustomCell customCell = (CustomCell) viewHolder.itemView;
                ViewItem viewItem = (ViewItem) customCell.getTag();
                CallLogRow callLogRow = (CallLogRow) CallLogActivity.this.calls.get(i);
                customCell.imageView.setImageResource(callLogRow.video ? R.drawable.profile_video : R.drawable.profile_phone);
                ProfileSearchCell profileSearchCell = viewItem.cell;
                TLRPC$Message tLRPC$Message = callLogRow.calls.get(0);
                String str = LocaleController.isRTL ? "\u202b" : BuildConfig.FLAVOR;
                if (callLogRow.calls.size() == 1) {
                    spannableString = new SpannableString(str + "  " + LocaleController.formatDateCallLog(tLRPC$Message.date));
                } else {
                    spannableString = new SpannableString(String.format(str + "  (%d) %s", Integer.valueOf(callLogRow.calls.size()), LocaleController.formatDateCallLog(tLRPC$Message.date)));
                }
                SpannableString spannableString2 = spannableString;
                int i2 = callLogRow.type;
                if (i2 == 0) {
                    spannableString2.setSpan(CallLogActivity.this.iconOut, str.length(), str.length() + 1, 0);
                } else if (i2 == 1) {
                    spannableString2.setSpan(CallLogActivity.this.iconIn, str.length(), str.length() + 1, 0);
                } else if (i2 == 2) {
                    spannableString2.setSpan(CallLogActivity.this.iconMissed, str.length(), str.length() + 1, 0);
                }
                profileSearchCell.setData(callLogRow.user, null, null, spannableString2, false, false);
                profileSearchCell.useSeparator = (i == CallLogActivity.this.calls.size() - 1 && CallLogActivity.this.endReached) ? false : true;
                viewItem.button.setTag(callLogRow);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i < CallLogActivity.this.calls.size()) {
                return 0;
            }
            return (CallLogActivity.this.endReached || i != CallLogActivity.this.calls.size()) ? 2 : 1;
        }
    }

    private static class ViewItem {
        public ImageView button;
        public ProfileSearchCell cell;

        public ViewItem(ImageView imageView, ProfileSearchCell profileSearchCell) {
            this.button = imageView;
            this.cell = profileSearchCell;
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.CallLogActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$11();
            }
        };
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{LocationCell.class, CustomCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
        EmptyTextProgressView emptyTextProgressView = this.emptyView;
        int i4 = ThemeDescription.FLAG_PROGRESSBAR;
        int i5 = Theme.key_progressCircle;
        arrayList.add(new ThemeDescription(emptyTextProgressView, i4, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionIcon));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_chats_actionBackground));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_chats_actionPressedBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, Theme.key_chats_verifiedCheck));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, Theme.key_chats_verifiedBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, Theme.dialogs_offlinePaint, null, null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, Theme.dialogs_onlinePaint, null, null, Theme.key_windowBackgroundWhiteBlueText3));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_name));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_secretName));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{CustomCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, new Drawable[]{this.greenDrawable, this.greenDrawable2, Theme.calllog_msgCallUpRedDrawable, Theme.calllog_msgCallDownRedDrawable}, null, Theme.key_calls_callReceivedGreenIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, new Drawable[]{this.redDrawable, Theme.calllog_msgCallUpGreenDrawable, Theme.calllog_msgCallDownGreenDrawable}, null, Theme.key_calls_callReceivedRedIcon));
        arrayList.add(new ThemeDescription(this.flickerLoadingView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$11() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof CustomCell) {
                    ((CustomCell) childAt).profileSearchCell.update(0);
                }
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean z, boolean z2) {
        super.onTransitionAnimationStart(z, z2);
        if (z) {
            this.openTransitionStarted = true;
        }
    }

    private void showItemsAnimated(final int i) {
        if (this.isPaused || !this.openTransitionStarted) {
            return;
        }
        final View view = null;
        for (int i2 = 0; i2 < this.listView.getChildCount(); i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof FlickerLoadingView) {
                view = childAt;
            }
        }
        if (view != null) {
            this.listView.removeView(view);
        }
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.CallLogActivity.5
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                CallLogActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = CallLogActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = CallLogActivity.this.listView.getChildAt(i3);
                    if (childAt2 != view && CallLogActivity.this.listView.getChildAdapterPosition(childAt2) >= i) {
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
                        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.CallLogActivity.5.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
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
}
