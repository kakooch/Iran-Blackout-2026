package ir.eitaa.features.ChatLock;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.explore.cells.KavoshCell;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LockedChatsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static boolean ignoreLock = false;
    private ArrayList<Long> dialogs;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private AnimatorSet scrimAnimatorSet;
    private Paint scrimPaint;
    private ActionBarPopupWindow scrimPopupWindow;
    private ActionBarMenuSubItem[] scrimPopupWindowItems;
    private int scrimPopupX;
    private int scrimPopupY;
    private View scrimView;
    private TLRPC$Dialog selectedDialog = null;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        ignoreLock = true;
        this.dialogs = MessagesController.getInstance(UserConfig.selectedAccount).getLockedDialogs();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        getNotificationCenter().addObserver(this, NotificationCenter.emojiLoaded);
        getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().addObserver(this, NotificationCenter.messageReceivedByAck);
        getNotificationCenter().addObserver(this, NotificationCenter.messageReceivedByServer);
        getNotificationCenter().addObserver(this, NotificationCenter.messageSendError);
        getNotificationCenter().addObserver(this, NotificationCenter.replyMessagesDidLoad);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        ignoreLock = false;
        getNotificationCenter().removeObserver(this, NotificationCenter.emojiLoaded);
        getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().removeObserver(this, NotificationCenter.messageReceivedByAck);
        getNotificationCenter().removeObserver(this, NotificationCenter.messageReceivedByServer);
        getNotificationCenter().removeObserver(this, NotificationCenter.messageSendError);
        getNotificationCenter().removeObserver(this, NotificationCenter.replyMessagesDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setTitle(LocaleController.getString("LockedChats", R.string.LockedChats));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    LockedChatsActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setTag("windowBackgroundGray");
        frameLayout2.setBackgroundColor(Theme.getColor("actionBarDefaultSubmenuBackground"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false) { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$LockedChatsActivity$0xrJsToGRnHKzveDl2gMOMFgoQk
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$LockedChatsActivity(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.3
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public boolean onItemClick(View view, int position) {
                LockedChatsActivity.this.createMenu(LockedChatsActivity.this.getMessagesController().dialogs_dict.get(((Long) LockedChatsActivity.this.dialogs.get(position)).longValue()), view, view.getX(), view.getY());
                return true;
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$LockedChatsActivity(View view, int i) {
        long dialogId = ((DialogCell) view).getDialogId();
        Bundle bundle = new Bundle();
        long j = dialogId >> 32;
        if (dialogId != 0) {
            if (j == 1) {
                bundle.putLong("chat_id", dialogId);
            } else if (dialogId > 0) {
                bundle.putLong("user_id", dialogId);
            } else if (dialogId < 0) {
                bundle.putLong("chat_id", -dialogId);
            }
            ChatLockHelper.setChatAsUnlocked(Long.valueOf(dialogId));
        } else {
            bundle.putLong("enc_id", j);
        }
        if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle, this)) {
            presentFragment(new ChatActivity(bundle));
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.emojiLoaded) {
            updateVisibleRows();
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            updateVisibleRows();
            return;
        }
        if (id == NotificationCenter.messageReceivedByAck || id == NotificationCenter.messageReceivedByServer || id == NotificationCenter.messageSendError) {
            updateVisibleRows();
        } else if (id == NotificationCenter.replyMessagesDidLoad) {
            updateVisibleRows();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMenu(final TLRPC$Dialog selectedDialog, View v, float x, float y) {
        int y2;
        this.selectedDialog = selectedDialog;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        arrayList2.add(LocaleController.getString("UnlockThisChat", R.string.UnlockThisChat));
        arrayList3.add(1380);
        arrayList.add(Integer.valueOf(R.drawable.menu_locked_chats));
        this.scrimPaint = new Paint() { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.4
            @Override // android.graphics.Paint
            public void setAlpha(int a) {
                super.setAlpha(a);
                if (((BaseFragment) LockedChatsActivity.this).fragmentView != null) {
                    ((BaseFragment) LockedChatsActivity.this).fragmentView.invalidate();
                }
            }
        };
        final Rect rect = new Rect();
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getParentActivity(), R.drawable.popup_fixed_alert, null);
        actionBarPopupWindowLayout.setMinimumWidth(AndroidUtilities.dp(200.0f));
        Rect rect2 = new Rect();
        getParentActivity().getResources().getDrawable(R.drawable.popup_fixed_alert).mutate().getPadding(rect2);
        actionBarPopupWindowLayout.setBackgroundColor(getThemedColor("actionBarDefaultSubmenuBackground"));
        this.scrimPopupWindowItems = new ActionBarMenuSubItem[arrayList2.size()];
        int size = arrayList2.size();
        final int i = 0;
        while (i < size) {
            ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(getParentActivity(), i == 0, i == size + (-1), (Theme.ResourcesProvider) null);
            actionBarMenuSubItem.setMinimumWidth(AndroidUtilities.dp(200.0f));
            actionBarMenuSubItem.setTextAndIcon((CharSequence) arrayList2.get(i), ((Integer) arrayList.get(i)).intValue());
            this.scrimPopupWindowItems[i] = actionBarMenuSubItem;
            actionBarPopupWindowLayout.addView(actionBarMenuSubItem);
            actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$LockedChatsActivity$4N1udG45nzqMjG6zKZ2BJ9wliAI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createMenu$1$LockedChatsActivity(selectedDialog, i, arrayList3, view);
                }
            });
            i++;
        }
        LinearLayout linearLayout = new LinearLayout(getParentActivity()) { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.5
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent event) {
                if (event.getKeyCode() == 4 && event.getRepeatCount() == 0 && LockedChatsActivity.this.scrimPopupWindow != null && LockedChatsActivity.this.scrimPopupWindow.isShowing()) {
                    LockedChatsActivity.this.scrimPopupWindow.dismiss();
                }
                return super.dispatchKeyEvent(event);
            }
        };
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.6
            private int[] pos = new int[2];

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v2, MotionEvent event) {
                if (event.getActionMasked() == 0) {
                    if (LockedChatsActivity.this.scrimPopupWindow != null && LockedChatsActivity.this.scrimPopupWindow.isShowing()) {
                        View contentView = LockedChatsActivity.this.scrimPopupWindow.getContentView();
                        contentView.getLocationInWindow(this.pos);
                        Rect rect3 = rect;
                        int[] iArr = this.pos;
                        rect3.set(iArr[0], iArr[1], iArr[0] + contentView.getMeasuredWidth(), this.pos[1] + contentView.getMeasuredHeight());
                        if (!rect.contains((int) event.getX(), (int) event.getY())) {
                            LockedChatsActivity.this.scrimPopupWindow.dismiss();
                        }
                    }
                } else if (event.getActionMasked() == 4 && LockedChatsActivity.this.scrimPopupWindow != null && LockedChatsActivity.this.scrimPopupWindow.isShowing()) {
                    LockedChatsActivity.this.scrimPopupWindow.dismiss();
                }
                return false;
            }
        });
        linearLayout.setOrientation(1);
        linearLayout.addView(actionBarPopupWindowLayout, LayoutHelper.createLinear(-1, -2, 0, 0, 0, 0, 0));
        int i2 = -2;
        ActionBarPopupWindow actionBarPopupWindow = new ActionBarPopupWindow(linearLayout, i2, i2) { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.7
            @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
            public void dismiss() {
                super.dismiss();
                if (LockedChatsActivity.this.scrimPopupWindow != this) {
                    return;
                }
                LockedChatsActivity.this.scrimPopupWindow = null;
                LockedChatsActivity.this.scrimPopupWindowItems = null;
                if (LockedChatsActivity.this.scrimAnimatorSet != null) {
                    LockedChatsActivity.this.scrimAnimatorSet.cancel();
                    LockedChatsActivity.this.scrimAnimatorSet = null;
                }
                if (LockedChatsActivity.this.scrimView instanceof KavoshCell) {
                    ((KavoshCell) LockedChatsActivity.this.scrimView).setInvalidatesParent(false);
                }
                LockedChatsActivity.this.scrimAnimatorSet = new AnimatorSet();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(ObjectAnimator.ofInt(LockedChatsActivity.this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0));
                LockedChatsActivity.this.scrimAnimatorSet.playTogether(arrayList4);
                LockedChatsActivity.this.scrimAnimatorSet.setDuration(220L);
                LockedChatsActivity.this.scrimAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.features.ChatLock.LockedChatsActivity.7.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        LockedChatsActivity.this.scrimView = null;
                        ((BaseFragment) LockedChatsActivity.this).fragmentView.invalidate();
                        LockedChatsActivity.this.listView.invalidate();
                    }
                });
                LockedChatsActivity.this.scrimAnimatorSet.start();
            }
        };
        this.scrimPopupWindow = actionBarPopupWindow;
        actionBarPopupWindow.setPauseNotifications(true);
        this.scrimPopupWindow.setDismissAnimationDuration(220);
        this.scrimPopupWindow.setOutsideTouchable(true);
        this.scrimPopupWindow.setClippingEnabled(true);
        this.scrimPopupWindow.setAnimationStyle(R.style.PopupContextAnimation);
        this.scrimPopupWindow.setFocusable(true);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        this.scrimPopupWindow.setInputMethodMode(2);
        this.scrimPopupWindow.setSoftInputMode(0);
        this.scrimPopupWindow.getContentView().setFocusableInTouchMode(true);
        actionBarPopupWindowLayout.setFitItems(true);
        int left = (((v.getLeft() + ((int) x)) - linearLayout.getMeasuredWidth()) + rect2.left) - AndroidUtilities.dp(28.0f);
        if (left < AndroidUtilities.dp(6.0f)) {
            left = AndroidUtilities.dp(6.0f);
        } else if (left > (this.listView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - linearLayout.getMeasuredWidth()) {
            left = (this.listView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - linearLayout.getMeasuredWidth();
        }
        if (AndroidUtilities.isTablet()) {
            int[] iArr = new int[2];
            this.fragmentView.getLocationInWindow(iArr);
            left += iArr[0];
        }
        int height = this.fragmentView.getHeight();
        int measuredHeight = linearLayout.getMeasuredHeight();
        if (measuredHeight < height) {
            y2 = (int) (this.listView.getY() + v.getTop() + y);
            if ((measuredHeight - rect2.top) - rect2.bottom > AndroidUtilities.dp(240.0f)) {
                y2 += AndroidUtilities.dp(240.0f) - measuredHeight;
            }
            if (y2 < this.listView.getY() + AndroidUtilities.dp(24.0f)) {
                y2 = (int) (this.listView.getY() + AndroidUtilities.dp(24.0f));
            } else {
                int i3 = height - measuredHeight;
                if (y2 > i3 - AndroidUtilities.dp(8.0f)) {
                    y2 = i3 - AndroidUtilities.dp(8.0f);
                }
            }
        } else {
            y2 = this.inBubbleMode ? 0 : AndroidUtilities.statusBarHeight;
        }
        ActionBarPopupWindow actionBarPopupWindow2 = this.scrimPopupWindow;
        RecyclerListView recyclerListView = this.listView;
        this.scrimPopupX = left;
        this.scrimPopupY = y2;
        actionBarPopupWindow2.showAtLocation(recyclerListView, 51, left, y2);
        this.listView.stopScroll();
        this.scrimView = v;
        if (v instanceof KavoshCell) {
            ((KavoshCell) v).setInvalidatesParent(true);
        }
        this.fragmentView.invalidate();
        this.listView.invalidate();
        AnimatorSet animatorSet = this.scrimAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.scrimAnimatorSet = new AnimatorSet();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(ObjectAnimator.ofInt(this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0, 50));
        this.scrimAnimatorSet.playTogether(arrayList4);
        this.scrimAnimatorSet.setDuration(150L);
        this.scrimAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenu$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenu$1$LockedChatsActivity(TLRPC$Dialog tLRPC$Dialog, int i, ArrayList arrayList, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        this.fragmentView.invalidate();
        this.listView.invalidate();
        if (tLRPC$Dialog == null || i >= arrayList.size()) {
            return;
        }
        processSelectedOption(((Integer) arrayList.get(i)).intValue());
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        updateVisibleRows();
    }

    private void processSelectedOption(int option) {
        if (this.selectedDialog == null || getParentActivity() == null || option != 1380) {
            return;
        }
        getMessagesController().updateDialogLockState(this.selectedDialog, false);
        this.listAdapter.notifyDataSetChanged();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LockedChatsActivity.this.dialogs.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new DialogCell(null, this.mContext, true, false, ((BaseFragment) LockedChatsActivity.this).currentAccount, null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() != 0) {
                return;
            }
            DialogCell dialogCell = (DialogCell) holder.itemView;
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) getItem(position);
            dialogCell.useSeparator = ((TLRPC$Dialog) getItem(position + 1)) != null;
            dialogCell.fullSeparator = false;
            tLRPC$Dialog.isLocked = false;
            dialogCell.setDialog(tLRPC$Dialog, 0, 0);
        }

        public TLObject getItem(int i) {
            if (i >= LockedChatsActivity.this.dialogs.size()) {
                return null;
            }
            return MessagesController.getInstance(UserConfig.selectedAccount).dialogs_dict.get(((Long) LockedChatsActivity.this.dialogs.get(i)).longValue());
        }
    }

    private void updateVisibleRows() {
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }
}
