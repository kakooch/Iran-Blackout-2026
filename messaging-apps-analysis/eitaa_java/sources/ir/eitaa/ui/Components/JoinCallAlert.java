package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_phone_getGroupCallJoinAs;
import ir.eitaa.tgnet.TLRPC$TL_phone_joinAsPeers;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GroupCreateUserCell;
import ir.eitaa.ui.Cells.ShareDialogCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class JoinCallAlert extends BottomSheet {
    private static ArrayList<TLRPC$Peer> cachedChats;
    private static long lastCacheDid;
    private static long lastCacheTime;
    private static int lastCachedAccount;
    private boolean animationInProgress;
    private ArrayList<TLRPC$Peer> chats;
    private TLRPC$Peer currentPeer;
    private int currentType;
    private JoinCallAlertDelegate delegate;
    private BottomSheetCell doneButton;
    private boolean ignoreLayout;
    private RecyclerListView listView;
    private int[] location;
    private TextView messageTextView;
    private boolean schedule;
    private int scrollOffsetY;
    private TLRPC$InputPeer selectAfterDismiss;
    private TLRPC$Peer selectedPeer;
    private Drawable shadowDrawable;
    private TextView textView;

    public interface JoinCallAlertDelegate {
        void didSelectChat(TLRPC$InputPeer peer, boolean hasFewPeers, boolean schedule);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public static void resetCache() {
        cachedChats = null;
    }

    public static void processDeletedChat(int account, long did) {
        ArrayList<TLRPC$Peer> arrayList;
        if (lastCachedAccount != account || (arrayList = cachedChats) == null || did > 0) {
            return;
        }
        int i = 0;
        int size = arrayList.size();
        while (true) {
            if (i >= size) {
                break;
            }
            if (MessageObject.getPeerId(cachedChats.get(i)) == did) {
                cachedChats.remove(i);
                break;
            }
            i++;
        }
        if (cachedChats.isEmpty()) {
            cachedChats = null;
        }
    }

    public class BottomSheetCell extends FrameLayout {
        private View background;
        private boolean hasBackground;
        private TextView[] textView;

        public BottomSheetCell(Context context, boolean withoutBackground) {
            super(context);
            this.textView = new TextView[2];
            this.hasBackground = !withoutBackground;
            setBackground(null);
            View view = new View(context);
            this.background = view;
            if (this.hasBackground) {
                view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            }
            addView(this.background, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, withoutBackground ? 0.0f : 16.0f, 16.0f, 16.0f));
            for (int i = 0; i < 2; i++) {
                this.textView[i] = new TextView(context);
                this.textView[i].setLines(1);
                this.textView[i].setSingleLine(true);
                this.textView[i].setGravity(1);
                this.textView[i].setEllipsize(TextUtils.TruncateAt.END);
                this.textView[i].setGravity(17);
                if (this.hasBackground) {
                    this.textView[i].setTextColor(Theme.getColor("featuredStickers_buttonText"));
                    this.textView[i].setTypeface(AndroidUtilities.getFontFamily(true));
                } else {
                    this.textView[i].setTextColor(Theme.getColor("featuredStickers_addButton"));
                }
                this.textView[i].setTextSize(1, 14.0f);
                this.textView[i].setPadding(0, 0, 0, this.hasBackground ? 0 : AndroidUtilities.dp(13.0f));
                addView(this.textView[i], LayoutHelper.createFrame(-2, -2.0f, 17, 24.0f, 0.0f, 24.0f, 0.0f));
                if (i == 1) {
                    this.textView[i].setAlpha(0.0f);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.hasBackground ? 80.0f : 50.0f), 1073741824));
        }

        public void setText(CharSequence text, boolean animated) {
            if (!animated) {
                this.textView[0].setText(text);
                return;
            }
            this.textView[1].setText(text);
            JoinCallAlert.this.animationInProgress = true;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(180L);
            animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.textView[0], (Property<TextView, Float>) View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.textView[0], (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f, -AndroidUtilities.dp(10.0f)), ObjectAnimator.ofFloat(this.textView[1], (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.textView[1], (Property<TextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(10.0f), 0.0f));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.JoinCallAlert.BottomSheetCell.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    JoinCallAlert.this.animationInProgress = false;
                    TextView textView = BottomSheetCell.this.textView[0];
                    BottomSheetCell.this.textView[0] = BottomSheetCell.this.textView[1];
                    BottomSheetCell.this.textView[1] = textView;
                }
            });
            animatorSet.start();
        }
    }

    public static void checkFewUsers(Context context, final long did, final AccountInstance accountInstance, final MessagesStorage.BooleanCallback callback) {
        if (lastCachedAccount == accountInstance.getCurrentAccount() && lastCacheDid == did && cachedChats != null && SystemClock.elapsedRealtime() - lastCacheTime < 240000) {
            callback.run(cachedChats.size() == 1);
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(context, 3);
        TLRPC$TL_phone_getGroupCallJoinAs tLRPC$TL_phone_getGroupCallJoinAs = new TLRPC$TL_phone_getGroupCallJoinAs();
        tLRPC$TL_phone_getGroupCallJoinAs.peer = accountInstance.getMessagesController().getInputPeer(did);
        final int iSendRequest = accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupCallJoinAs, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$uTp_vgqO4snuWCMyFP5kXj17GAs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$j_1hPvJzjV1tICcrvaoFSdZjFnY
                    @Override // java.lang.Runnable
                    public final void run() {
                        JoinCallAlert.lambda$checkFewUsers$0(alertDialog, tLObject, j, accountInstance, booleanCallback);
                    }
                });
            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$tOJULyvrERHBKFP9pQwLPL2TSVI
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                accountInstance.getConnectionsManager().cancelRequest(iSendRequest, true);
            }
        });
        try {
            alertDialog.showDelayed(500L);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$checkFewUsers$0(AlertDialog alertDialog, TLObject tLObject, long j, AccountInstance accountInstance, MessagesStorage.BooleanCallback booleanCallback) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject != null) {
            TLRPC$TL_phone_joinAsPeers tLRPC$TL_phone_joinAsPeers = (TLRPC$TL_phone_joinAsPeers) tLObject;
            cachedChats = tLRPC$TL_phone_joinAsPeers.peers;
            lastCacheDid = j;
            lastCacheTime = SystemClock.elapsedRealtime();
            lastCachedAccount = accountInstance.getCurrentAccount();
            accountInstance.getMessagesController().putChats(tLRPC$TL_phone_joinAsPeers.chats, false);
            accountInstance.getMessagesController().putUsers(tLRPC$TL_phone_joinAsPeers.users, false);
            booleanCallback.run(tLRPC$TL_phone_joinAsPeers.peers.size() == 1);
        }
    }

    public static void open(final Context context, final long did, final AccountInstance accountInstance, final BaseFragment fragment, final int type, final TLRPC$Peer scheduledPeer, final JoinCallAlertDelegate delegate) {
        if (context == null || delegate == null) {
            return;
        }
        if (lastCachedAccount == accountInstance.getCurrentAccount() && lastCacheDid == did && cachedChats != null && SystemClock.elapsedRealtime() - lastCacheTime < 300000) {
            if (cachedChats.size() == 1 && type != 0) {
                delegate.didSelectChat(accountInstance.getMessagesController().getInputPeer(MessageObject.getPeerId(cachedChats.get(0))), false, false);
                return;
            } else {
                showAlert(context, did, cachedChats, fragment, type, scheduledPeer, delegate);
                return;
            }
        }
        final AlertDialog alertDialog = new AlertDialog(context, 3);
        TLRPC$TL_phone_getGroupCallJoinAs tLRPC$TL_phone_getGroupCallJoinAs = new TLRPC$TL_phone_getGroupCallJoinAs();
        tLRPC$TL_phone_getGroupCallJoinAs.peer = accountInstance.getMessagesController().getInputPeer(did);
        final int iSendRequest = accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupCallJoinAs, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$HUAcezU5zKWfS50IxZbVO95DMnI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$3bNoqRUXEOXy4GdKBSbAf8RjhvQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        JoinCallAlert.lambda$open$3(alertDialog, tLObject, accountInstance, joinCallAlertDelegate, j, context, baseFragment, i, tLRPC$Peer);
                    }
                });
            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$mRA_KguCXj8N8imPvuqjF4y5pVQ
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                accountInstance.getConnectionsManager().cancelRequest(iSendRequest, true);
            }
        });
        try {
            alertDialog.showDelayed(500L);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$open$3(AlertDialog alertDialog, TLObject tLObject, AccountInstance accountInstance, JoinCallAlertDelegate joinCallAlertDelegate, long j, Context context, BaseFragment baseFragment, int i, TLRPC$Peer tLRPC$Peer) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject != null) {
            TLRPC$TL_phone_joinAsPeers tLRPC$TL_phone_joinAsPeers = (TLRPC$TL_phone_joinAsPeers) tLObject;
            if (tLRPC$TL_phone_joinAsPeers.peers.size() == 1) {
                joinCallAlertDelegate.didSelectChat(accountInstance.getMessagesController().getInputPeer(MessageObject.getPeerId(tLRPC$TL_phone_joinAsPeers.peers.get(0))), false, false);
                return;
            }
            cachedChats = tLRPC$TL_phone_joinAsPeers.peers;
            lastCacheDid = j;
            lastCacheTime = SystemClock.elapsedRealtime();
            lastCachedAccount = accountInstance.getCurrentAccount();
            accountInstance.getMessagesController().putChats(tLRPC$TL_phone_joinAsPeers.chats, false);
            accountInstance.getMessagesController().putUsers(tLRPC$TL_phone_joinAsPeers.users, false);
            showAlert(context, j, tLRPC$TL_phone_joinAsPeers.peers, baseFragment, i, tLRPC$Peer, joinCallAlertDelegate);
        }
    }

    private static void showAlert(Context context, long dialogId, ArrayList<TLRPC$Peer> peers, BaseFragment fragment, int type, TLRPC$Peer scheduledPeer, JoinCallAlertDelegate delegate) {
        JoinCallAlert joinCallAlert = new JoinCallAlert(context, dialogId, peers, type, scheduledPeer, delegate);
        if (fragment != null) {
            if (fragment.getParentActivity() != null) {
                fragment.showDialog(joinCallAlert);
                return;
            }
            return;
        }
        joinCallAlert.show();
    }

    private JoinCallAlert(Context context, long j, ArrayList<TLRPC$Peer> arrayList, int i, TLRPC$Peer tLRPC$Peer, final JoinCallAlertDelegate joinCallAlertDelegate) {
        ViewGroup viewGroup;
        boolean z;
        super(context, false);
        this.location = new int[2];
        setApplyBottomPadding(false);
        this.chats = new ArrayList<>(arrayList);
        this.delegate = joinCallAlertDelegate;
        this.currentType = i;
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        if (i == 2) {
            if (VoIPService.getSharedInstance() != null) {
                long selfId = VoIPService.getSharedInstance().getSelfId();
                int size = this.chats.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    TLRPC$Peer tLRPC$Peer2 = this.chats.get(i2);
                    if (MessageObject.getPeerId(tLRPC$Peer2) == selfId) {
                        this.currentPeer = tLRPC$Peer2;
                        this.selectedPeer = tLRPC$Peer2;
                        break;
                    }
                    i2++;
                }
            } else if (tLRPC$Peer != null) {
                long peerId = MessageObject.getPeerId(tLRPC$Peer);
                int size2 = this.chats.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    TLRPC$Peer tLRPC$Peer3 = this.chats.get(i3);
                    if (MessageObject.getPeerId(tLRPC$Peer3) == peerId) {
                        this.currentPeer = tLRPC$Peer3;
                        this.selectedPeer = tLRPC$Peer3;
                        break;
                    }
                    i3++;
                }
            } else {
                this.selectedPeer = this.chats.get(0);
            }
            this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("voipgroup_inviteMembersBackground"), PorterDuff.Mode.MULTIPLY));
        } else {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
            this.selectedPeer = this.chats.get(0);
        }
        if (this.currentType == 0) {
            LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.JoinCallAlert.1
                boolean sorted;

                @Override // android.widget.LinearLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    if (JoinCallAlert.this.currentType == 0) {
                        int size3 = View.MeasureSpec.getSize(widthMeasureSpec);
                        int size4 = JoinCallAlert.this.chats.size() * AndroidUtilities.dp(95.0f);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) JoinCallAlert.this.listView.getLayoutParams();
                        if (size4 > size3) {
                            layoutParams.width = -1;
                            layoutParams.gravity = 51;
                            if (!this.sorted) {
                                if (JoinCallAlert.this.selectedPeer != null) {
                                    JoinCallAlert.this.chats.remove(JoinCallAlert.this.selectedPeer);
                                    JoinCallAlert.this.chats.add(0, JoinCallAlert.this.selectedPeer);
                                }
                                this.sorted = true;
                            }
                        } else {
                            layoutParams.width = -2;
                            layoutParams.gravity = 49;
                            if (!this.sorted) {
                                if (JoinCallAlert.this.selectedPeer != null) {
                                    int iMax = JoinCallAlert.this.chats.size() % 2 == 0 ? Math.max(0, (JoinCallAlert.this.chats.size() / 2) - 1) : JoinCallAlert.this.chats.size() / 2;
                                    JoinCallAlert.this.chats.remove(JoinCallAlert.this.selectedPeer);
                                    JoinCallAlert.this.chats.add(iMax, JoinCallAlert.this.selectedPeer);
                                }
                                this.sorted = true;
                            }
                        }
                    }
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            };
            linearLayout.setOrientation(1);
            NestedScrollView nestedScrollView = new NestedScrollView(context);
            nestedScrollView.addView(linearLayout);
            setCustomView(nestedScrollView);
            viewGroup = linearLayout;
        } else {
            FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.JoinCallAlert.2
                @Override // android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent ev) {
                    if (ev.getAction() == 0 && JoinCallAlert.this.scrollOffsetY != 0 && ev.getY() < JoinCallAlert.this.scrollOffsetY) {
                        JoinCallAlert.this.dismiss();
                        return true;
                    }
                    return super.onInterceptTouchEvent(ev);
                }

                @Override // android.view.View
                public boolean onTouchEvent(MotionEvent e) {
                    return !JoinCallAlert.this.isDismissed() && super.onTouchEvent(e);
                }

                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int size3 = View.MeasureSpec.getSize(heightMeasureSpec);
                    if (Build.VERSION.SDK_INT >= 21) {
                        size3 -= AndroidUtilities.statusBarHeight;
                    }
                    measureChildWithMargins(JoinCallAlert.this.messageTextView, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    int measuredHeight = JoinCallAlert.this.messageTextView.getMeasuredHeight();
                    ((FrameLayout.LayoutParams) JoinCallAlert.this.listView.getLayoutParams()).topMargin = AndroidUtilities.dp(65.0f) + measuredHeight;
                    getMeasuredWidth();
                    int iDp = AndroidUtilities.dp(80.0f) + (JoinCallAlert.this.chats.size() * AndroidUtilities.dp(58.0f)) + ((BottomSheet) JoinCallAlert.this).backgroundPaddingTop + AndroidUtilities.dp(55.0f) + measuredHeight;
                    int i4 = size3 / 5;
                    int i5 = iDp < i4 * 3 ? size3 - iDp : i4 * 2;
                    if (JoinCallAlert.this.listView.getPaddingTop() != i5) {
                        JoinCallAlert.this.ignoreLayout = true;
                        JoinCallAlert.this.listView.setPadding(0, i5, 0, 0);
                        JoinCallAlert.this.ignoreLayout = false;
                    }
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size3, 1073741824));
                }

                @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                    super.onLayout(changed, left, top, right, bottom);
                    JoinCallAlert.this.updateLayout();
                }

                @Override // android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (JoinCallAlert.this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    JoinCallAlert.this.shadowDrawable.setBounds(0, JoinCallAlert.this.scrollOffsetY - ((BottomSheet) JoinCallAlert.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                    JoinCallAlert.this.shadowDrawable.draw(canvas);
                }
            };
            this.containerView = frameLayout;
            frameLayout.setWillNotDraw(false);
            ViewGroup viewGroup2 = this.containerView;
            int i4 = this.backgroundPaddingLeft;
            viewGroup2.setPadding(i4, 0, i4, 0);
            viewGroup = frameLayout;
        }
        final TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-j));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.JoinCallAlert.3
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (JoinCallAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), this.currentType == 0 ? 0 : 1, false));
        this.listView.setAdapter(new ListAdapter(context));
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setClipToPadding(false);
        this.listView.setEnabled(true);
        this.listView.setGlowColor(Theme.getColor("dialogScrollGlow"));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.JoinCallAlert.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                JoinCallAlert.this.updateLayout();
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$4E7hIjlwRP8AMENzhUxgip6X0us
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i5) {
                this.f$0.lambda$new$6$JoinCallAlert(chat, view, i5);
            }
        });
        if (i != 0) {
            viewGroup.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 100.0f, 0.0f, 80.0f));
        } else {
            this.listView.setSelectorDrawableColor(0);
            this.listView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        }
        if (i == 0) {
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            rLottieImageView.setAutoRepeat(true);
            rLottieImageView.setAnimation(R.raw.utyan_schedule, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
            rLottieImageView.playAnimation();
            viewGroup.addView(rLottieImageView, LayoutHelper.createLinear(160, 160, 49, 17, 8, 17, 0));
        }
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setTextSize(1, 20.0f);
        if (i == 2) {
            this.textView.setTextColor(Theme.getColor("voipgroup_nameText"));
        } else {
            this.textView.setTextColor(Theme.getColor("dialogTextBlack"));
        }
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        if (i == 0) {
            if (ChatObject.isChannelOrGiga(chat)) {
                this.textView.setText(LocaleController.getString("StartVoipChannelTitle", R.string.StartVoipChannelTitle));
            } else {
                this.textView.setText(LocaleController.getString("StartVoipChatTitle", R.string.StartVoipChatTitle));
            }
            viewGroup.addView(this.textView, LayoutHelper.createLinear(-2, -2, 49, 23, 16, 23, 0));
        } else {
            if (i == 2) {
                this.textView.setText(LocaleController.getString("VoipGroupDisplayAs", R.string.VoipGroupDisplayAs));
            } else if (ChatObject.isChannelOrGiga(chat)) {
                this.textView.setText(LocaleController.getString("VoipChannelJoinAs", R.string.VoipChannelJoinAs));
            } else {
                this.textView.setText(LocaleController.getString("VoipGroupJoinAs", R.string.VoipGroupJoinAs));
            }
            viewGroup.addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 51, 23.0f, 8.0f, 23.0f, 0.0f));
        }
        TextView textView2 = new TextView(getContext());
        this.messageTextView = textView2;
        if (i == 2) {
            textView2.setTextColor(Theme.getColor("voipgroup_lastSeenText"));
        } else {
            textView2.setTextColor(Theme.getColor("dialogTextGray3"));
        }
        this.messageTextView.setTextSize(1, 14.0f);
        int size3 = this.chats.size();
        for (int i5 = 0; i5 < size3; i5++) {
            long peerId2 = MessageObject.getPeerId(this.chats.get(i5));
            if (peerId2 < 0) {
                TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-peerId2));
                if (!ChatObject.isChannel(chat2) || chat2.megagroup) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        this.messageTextView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.messageTextView.setLinkTextColor(Theme.getColor("dialogTextLink"));
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            if (ChatObject.isChannel(chat) && !chat.megagroup) {
                sb.append(LocaleController.getString("VoipChannelStart2", R.string.VoipChannelStart2));
            } else {
                sb.append(LocaleController.getString("VoipGroupStart2", R.string.VoipGroupStart2));
            }
            if (this.chats.size() > 1) {
                sb.append("\n\n");
                sb.append(LocaleController.getString("VoipChatDisplayedAs", R.string.VoipChatDisplayedAs));
            } else {
                this.listView.setVisibility(8);
            }
            this.messageTextView.setText(sb);
            this.messageTextView.setGravity(49);
            viewGroup.addView(this.messageTextView, LayoutHelper.createLinear(-2, -2, 49, 23, 0, 23, 5));
        } else {
            if (z) {
                this.messageTextView.setText(LocaleController.getString("VoipGroupStartAsInfoGroup", R.string.VoipGroupStartAsInfoGroup));
            } else {
                this.messageTextView.setText(LocaleController.getString("VoipGroupStartAsInfo", R.string.VoipGroupStartAsInfo));
            }
            this.messageTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            viewGroup.addView(this.messageTextView, LayoutHelper.createFrame(-2, -2.0f, 51, 23.0f, 0.0f, 23.0f, 5.0f));
        }
        if (i == 0) {
            viewGroup.addView(this.listView, LayoutHelper.createLinear(this.chats.size() < 5 ? -2 : -1, 95, 49, 0, 6, 0, 0));
        }
        BottomSheetCell bottomSheetCell = new BottomSheetCell(context, false);
        this.doneButton = bottomSheetCell;
        bottomSheetCell.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$pcJi7_AXMkCAc7jc1smaTFoYLQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$7$JoinCallAlert(joinCallAlertDelegate, view);
            }
        });
        if (this.currentType == 0) {
            viewGroup.addView(this.doneButton, LayoutHelper.createLinear(-1, 50, 51, 0, 0, 0, 0));
            BottomSheetCell bottomSheetCell2 = new BottomSheetCell(context, true);
            if (ChatObject.isChannelOrGiga(chat)) {
                bottomSheetCell2.setText(LocaleController.getString("VoipChannelScheduleVoiceChat", R.string.VoipChannelScheduleVoiceChat), false);
            } else {
                bottomSheetCell2.setText(LocaleController.getString("VoipGroupScheduleVoiceChat", R.string.VoipGroupScheduleVoiceChat), false);
            }
            bottomSheetCell2.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallAlert$mTKkP9g6bbmb05I75WxcCGaKmYE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$8$JoinCallAlert(view);
                }
            });
            viewGroup.addView(bottomSheetCell2, LayoutHelper.createLinear(-1, 50, 51, 0, 0, 0, 0));
        } else {
            viewGroup.addView(this.doneButton, LayoutHelper.createFrame(-1, 50.0f, 83, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        updateDoneButton(false, chat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$JoinCallAlert(TLRPC$Chat tLRPC$Chat, View view, int i) {
        if (this.animationInProgress || this.chats.get(i) == this.selectedPeer) {
            return;
        }
        this.selectedPeer = this.chats.get(i);
        boolean z = view instanceof GroupCreateUserCell;
        if (z) {
            ((GroupCreateUserCell) view).setChecked(true, true);
        } else if (view instanceof ShareDialogCell) {
            ((ShareDialogCell) view).setChecked(true, true);
            view.invalidate();
        }
        int childCount = this.listView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt != view) {
                if (z) {
                    ((GroupCreateUserCell) childAt).setChecked(false, true);
                } else if (view instanceof ShareDialogCell) {
                    ((ShareDialogCell) childAt).setChecked(false, true);
                }
            }
        }
        if (this.currentType != 0) {
            updateDoneButton(true, tLRPC$Chat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$7$JoinCallAlert(JoinCallAlertDelegate joinCallAlertDelegate, View view) {
        TLRPC$InputPeer inputPeer = MessagesController.getInstance(this.currentAccount).getInputPeer(MessageObject.getPeerId(this.selectedPeer));
        if (this.currentType == 2) {
            if (this.selectedPeer != this.currentPeer) {
                joinCallAlertDelegate.didSelectChat(inputPeer, this.chats.size() > 1, false);
            }
        } else {
            this.selectAfterDismiss = inputPeer;
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$8$JoinCallAlert(View view) {
        this.selectAfterDismiss = MessagesController.getInstance(this.currentAccount).getInputPeer(MessageObject.getPeerId(this.selectedPeer));
        this.schedule = true;
        dismiss();
    }

    private void updateDoneButton(boolean animated, TLRPC$Chat chat) {
        if (this.currentType == 0) {
            if (ChatObject.isChannelOrGiga(chat)) {
                this.doneButton.setText(LocaleController.formatString("VoipChannelStartVoiceChat", R.string.VoipChannelStartVoiceChat, new Object[0]), animated);
                return;
            } else {
                this.doneButton.setText(LocaleController.formatString("VoipGroupStartVoiceChat", R.string.VoipGroupStartVoiceChat, new Object[0]), animated);
                return;
            }
        }
        long peerId = MessageObject.getPeerId(this.selectedPeer);
        if (DialogObject.isUserDialog(peerId)) {
            this.doneButton.setText(LocaleController.formatString("VoipGroupContinueAs", R.string.VoipGroupContinueAs, UserObject.getFirstName(MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(peerId)))), animated);
            return;
        }
        TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-peerId));
        BottomSheetCell bottomSheetCell = this.doneButton;
        Object[] objArr = new Object[1];
        objArr[0] = chat2 != null ? chat2.title : "";
        bottomSheetCell.setText(LocaleController.formatString("VoipGroupContinueAs", R.string.VoipGroupContinueAs, objArr), animated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.currentType == 0) {
            return;
        }
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(9.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (this.scrollOffsetY != i) {
            this.textView.setTranslationY(AndroidUtilities.dp(19.0f) + top);
            this.messageTextView.setTranslationY(top + AndroidUtilities.dp(56.0f));
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            this.containerView.invalidate();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        TLRPC$InputPeer tLRPC$InputPeer = this.selectAfterDismiss;
        if (tLRPC$InputPeer != null) {
            this.delegate.didSelectChat(tLRPC$InputPeer, this.chats.size() > 1, this.schedule);
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return JoinCallAlert.this.chats.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View groupCreateUserCell;
            if (JoinCallAlert.this.currentType == 0) {
                groupCreateUserCell = new ShareDialogCell(this.context, 2, null);
                groupCreateUserCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(80.0f), AndroidUtilities.dp(100.0f)));
            } else {
                groupCreateUserCell = new GroupCreateUserCell(this.context, 2, 0, false, JoinCallAlert.this.currentType == 2);
            }
            return new RecyclerListView.Holder(groupCreateUserCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            holder.getAdapterPosition();
            long peerId = MessageObject.getPeerId(JoinCallAlert.this.selectedPeer);
            View view = holder.itemView;
            if (view instanceof GroupCreateUserCell) {
                GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) view;
                Object object = groupCreateUserCell.getObject();
                long j = 0;
                if (object != null) {
                    if (object instanceof TLRPC$Chat) {
                        j = -((TLRPC$Chat) object).id;
                    } else {
                        j = ((TLRPC$User) object).id;
                    }
                }
                groupCreateUserCell.setChecked(peerId == j, false);
                return;
            }
            ShareDialogCell shareDialogCell = (ShareDialogCell) view;
            shareDialogCell.setChecked(peerId == shareDialogCell.getCurrentDialog(), false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLObject chat;
            String string;
            long peerId = MessageObject.getPeerId((TLRPC$Peer) JoinCallAlert.this.chats.get(position));
            if (peerId > 0) {
                chat = MessagesController.getInstance(((BottomSheet) JoinCallAlert.this).currentAccount).getUser(Long.valueOf(peerId));
                string = LocaleController.getString("VoipGroupPersonalAccount", R.string.VoipGroupPersonalAccount);
            } else {
                chat = MessagesController.getInstance(((BottomSheet) JoinCallAlert.this).currentAccount).getChat(Long.valueOf(-peerId));
                string = null;
            }
            if (JoinCallAlert.this.currentType == 0) {
                ((ShareDialogCell) holder.itemView).setDialog(peerId, peerId == MessageObject.getPeerId(JoinCallAlert.this.selectedPeer), null);
            } else {
                ((GroupCreateUserCell) holder.itemView).setObject(chat, null, string, position != getItemCount() - 1);
            }
        }
    }
}
