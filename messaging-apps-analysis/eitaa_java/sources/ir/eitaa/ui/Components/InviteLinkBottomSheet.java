package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_chatChannelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteImporter;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputUserEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_chatInviteImporters;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_editExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInviteReplaced;
import ir.eitaa.tgnet.TLRPC$TL_messages_getChatInviteImporters;
import ir.eitaa.tgnet.TLRPC$TL_users_getUsers;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.LinkActionView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.LinkEditActivity;
import ir.eitaa.ui.ManageLinksActivity;
import ir.eitaa.ui.ProfileActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InviteLinkBottomSheet extends BottomSheet {
    Adapter adapter;
    private boolean canEdit;
    private long chatId;
    int creatorHeaderRow;
    int creatorRow;
    int divider2Row;
    int dividerRow;
    int emptyHintRow;
    int emptyView;
    int emptyView2;
    BaseFragment fragment;
    boolean hasMore;
    private boolean ignoreLayout;
    TLRPC$ChatFull info;
    TLRPC$TL_chatInviteExported invite;
    InviteDelegate inviteDelegate;
    ArrayList<TLRPC$TL_chatInviteImporter> invitedUsers;
    private boolean isChannel;
    int linkActionRow;
    int linkInfoRow;
    private RecyclerListView listView;
    int loadingRow;
    private boolean permanent;
    int rowCount;
    private int scrollOffsetY;
    private View shadow;
    private AnimatorSet shadowAnimation;
    private final long timeDif;
    private TextView titleTextView;
    private boolean titleVisible;
    HashMap<Long, TLRPC$User> users;
    int usersEndRow;
    int usersHeaderRow;
    boolean usersLoading;
    int usersStartRow;

    public interface InviteDelegate {
        void linkRevoked(TLRPC$TL_chatInviteExported invite);

        void onLinkDeleted(TLRPC$TL_chatInviteExported invite);

        void onLinkEdited(TLRPC$TL_chatInviteExported invite);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public InviteLinkBottomSheet(Context context, final TLRPC$TL_chatInviteExported invite, TLRPC$ChatFull info, final HashMap<Long, TLRPC$User> users, final BaseFragment fragment, long chatId, boolean permanent, boolean isChannel) {
        super(context, false);
        this.invitedUsers = new ArrayList<>();
        this.canEdit = true;
        this.invite = invite;
        this.users = users;
        this.fragment = fragment;
        this.info = info;
        this.chatId = chatId;
        this.permanent = permanent;
        this.isChannel = isChannel;
        if (users == null) {
            this.users = new HashMap<>();
        }
        this.timeDif = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - (System.currentTimeMillis() / 1000);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.1
            private boolean fullHeight;
            private RectF rect = new RectF();

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && InviteLinkBottomSheet.this.scrollOffsetY != 0 && ev.getY() < InviteLinkBottomSheet.this.scrollOffsetY) {
                    InviteLinkBottomSheet.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !InviteLinkBottomSheet.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                if (Build.VERSION.SDK_INT >= 21) {
                    InviteLinkBottomSheet.this.ignoreLayout = true;
                    setPadding(((BottomSheet) InviteLinkBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) InviteLinkBottomSheet.this).backgroundPaddingLeft, 0);
                    InviteLinkBottomSheet.this.ignoreLayout = false;
                }
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
                this.fullHeight = true;
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                InviteLinkBottomSheet.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (InviteLinkBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x007d A[PHI: r0 r1
              0x007d: PHI (r0v4 int) = (r0v3 int), (r0v24 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]
              0x007d: PHI (r1v7 int) = (r1v6 int), (r1v17 int) binds: [B:3:0x002d, B:5:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r13) {
                /*
                    Method dump skipped, instructions count: 312
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.InviteLinkBottomSheet.AnonymousClass1.onDraw(android.graphics.Canvas):void");
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(48.0f);
        View view = new View(context);
        this.shadow = view;
        view.setAlpha(0.0f);
        this.shadow.setVisibility(4);
        this.shadow.setTag(1);
        this.containerView.addView(this.shadow, layoutParams);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.2
            int lastH;

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (InviteLinkBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            protected void onMeasure(int widthSpec, int heightSpec) {
                if (this.lastH != View.MeasureSpec.getSize(heightSpec)) {
                    this.lastH = View.MeasureSpec.getSize(heightSpec);
                    InviteLinkBottomSheet.this.ignoreLayout = true;
                    InviteLinkBottomSheet.this.listView.setPadding(0, 0, 0, 0);
                    InviteLinkBottomSheet.this.ignoreLayout = false;
                    measure(widthSpec, View.MeasureSpec.makeMeasureSpec(heightSpec, Integer.MIN_VALUE));
                    int measuredHeight = getMeasuredHeight();
                    int i = this.lastH;
                    int i2 = (int) ((i / 5.0f) * 2.0f);
                    if (i2 < (i - measuredHeight) + AndroidUtilities.dp(60.0f)) {
                        i2 = this.lastH - measuredHeight;
                    }
                    InviteLinkBottomSheet.this.ignoreLayout = true;
                    InviteLinkBottomSheet.this.listView.setPadding(0, i2, 0, 0);
                    InviteLinkBottomSheet.this.ignoreLayout = false;
                    measure(widthSpec, View.MeasureSpec.makeMeasureSpec(heightSpec, Integer.MIN_VALUE));
                }
                super.onMeasure(widthSpec, heightSpec);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setTag(14);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.listView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView2 = this.listView;
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setClipToPadding(false);
        this.listView.setNestedScrollingEnabled(true);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                InviteLinkBottomSheet.this.updateLayout();
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                if (!inviteLinkBottomSheet.hasMore || inviteLinkBottomSheet.usersLoading) {
                    return;
                }
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                if (inviteLinkBottomSheet2.rowCount - iFindLastVisibleItemPosition < 10) {
                    inviteLinkBottomSheet2.loadUsers();
                }
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.4
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view2, int position) {
                TLRPC$User tLRPC$User;
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                if (position == inviteLinkBottomSheet.creatorRow && invite.admin_id == UserConfig.getInstance(((BottomSheet) inviteLinkBottomSheet).currentAccount).clientUserId) {
                    return;
                }
                InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                int i = inviteLinkBottomSheet2.creatorRow;
                if (position == i || (position >= inviteLinkBottomSheet2.usersStartRow && position < inviteLinkBottomSheet2.usersEndRow)) {
                    if (position == i) {
                        tLRPC$User = (TLRPC$User) users.get(Long.valueOf(invite.admin_id));
                    } else {
                        tLRPC$User = (TLRPC$User) users.get(Long.valueOf(inviteLinkBottomSheet2.invitedUsers.get(position - inviteLinkBottomSheet2.usersStartRow).user_id));
                    }
                    if (tLRPC$User != null) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("user_id", tLRPC$User.id);
                        MessagesController.getInstance(UserConfig.selectedAccount).putUser(tLRPC$User, false);
                        fragment.presentFragment(new ProfileActivity(bundle));
                        InviteLinkBottomSheet.this.dismiss();
                    }
                }
            }
        });
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setTextSize(1, 20.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(16);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        if (!permanent) {
            if (invite.expired) {
                this.titleTextView.setText(LocaleController.getString("ExpiredLink", R.string.ExpiredLink));
            } else if (invite.revoked) {
                this.titleTextView.setText(LocaleController.getString("RevokedLink", R.string.RevokedLink));
            } else {
                this.titleTextView.setText(LocaleController.getString("InviteLink", R.string.InviteLink));
            }
            this.titleVisible = true;
        } else {
            this.titleTextView.setText(LocaleController.getString("InviteLink", R.string.InviteLink));
            this.titleVisible = false;
            this.titleTextView.setVisibility(4);
            this.titleTextView.setAlpha(0.0f);
        }
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, !this.titleVisible ? 0.0f : 48.0f, 0.0f, 0.0f));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, !this.titleVisible ? 48.0f : 50.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        updateRows();
        loadUsers();
        if (users == null || users.get(Long.valueOf(invite.admin_id)) == null) {
            loadCreator();
        }
        updateColors();
    }

    public void updateColors() {
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextBlack"));
            this.titleTextView.setLinkTextColor(Theme.getColor("dialogTextLink"));
            this.titleTextView.setHighlightColor(Theme.getColor("dialogLinkSelection"));
            if (!this.titleVisible) {
                this.titleTextView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
        }
        this.listView.setGlowColor(Theme.getColor("dialogScrollGlow"));
        this.shadow.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        setBackgroundColor(Theme.getColor("dialogBackground"));
        int hiddenChildCount = this.listView.getHiddenChildCount();
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            updateColorForView(this.listView.getChildAt(i));
        }
        for (int i2 = 0; i2 < hiddenChildCount; i2++) {
            updateColorForView(this.listView.getHiddenChildAt(i2));
        }
        int cachedChildCount = this.listView.getCachedChildCount();
        for (int i3 = 0; i3 < cachedChildCount; i3++) {
            updateColorForView(this.listView.getCachedChildAt(i3));
        }
        int attachedScrapChildCount = this.listView.getAttachedScrapChildCount();
        for (int i4 = 0; i4 < attachedScrapChildCount; i4++) {
            updateColorForView(this.listView.getAttachedScrapChildAt(i4));
        }
        this.containerView.invalidate();
    }

    private void updateColorForView(View view) {
        if (view instanceof HeaderCell) {
            ((HeaderCell) view).getTextView().setTextColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
        } else if (view instanceof LinkActionView) {
            ((LinkActionView) view).updateColors();
        } else if (view instanceof TextInfoPrivacyCell) {
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(view.getContext(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
            combinedDrawable.setFullsize(true);
            view.setBackground(combinedDrawable);
            ((TextInfoPrivacyCell) view).setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        } else if (view instanceof UserCell) {
            ((UserCell) view).update(0);
        }
        RecyclerView.ViewHolder childViewHolder = this.listView.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (childViewHolder.getItemViewType() == 7) {
                CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(view.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"), 0, 0);
                combinedDrawable2.setFullsize(true);
                view.setBackgroundDrawable(combinedDrawable2);
                return;
            }
            if (childViewHolder.getItemViewType() == 2) {
                CombinedDrawable combinedDrawable3 = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(view.getContext(), R.drawable.greydivider, "windowBackgroundGrayShadow"), 0, 0);
                combinedDrawable3.setFullsize(true);
                view.setBackgroundDrawable(combinedDrawable3);
            }
        }
    }

    private void loadCreator() {
        TLRPC$TL_users_getUsers tLRPC$TL_users_getUsers = new TLRPC$TL_users_getUsers();
        tLRPC$TL_users_getUsers.id.add(MessagesController.getInstance(UserConfig.selectedAccount).getInputUser(this.invite.admin_id));
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_users_getUsers, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$79T4QxWuPhEWxHZAreLSj8uLyvM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadCreator$0$InviteLinkBottomSheet(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadCreator$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadCreator$0$InviteLinkBottomSheet(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.5
            @Override // java.lang.Runnable
            public void run() {
                if (tLRPC$TL_error == null) {
                    TLRPC$User tLRPC$User = (TLRPC$User) ((TLRPC$Vector) tLObject).objects.get(0);
                    InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                    inviteLinkBottomSheet.users.put(Long.valueOf(inviteLinkBottomSheet.invite.admin_id), tLRPC$User);
                    InviteLinkBottomSheet.this.adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void updateRows() {
        this.rowCount = 0;
        this.dividerRow = -1;
        this.divider2Row = -1;
        this.usersHeaderRow = -1;
        this.usersStartRow = -1;
        this.usersEndRow = -1;
        this.emptyView2 = -1;
        this.linkActionRow = -1;
        this.linkInfoRow = -1;
        this.emptyHintRow = -1;
        if (!this.permanent) {
            int i = 0 + 1;
            this.rowCount = i;
            this.linkActionRow = 0;
            this.rowCount = i + 1;
            this.linkInfoRow = i;
        }
        int i2 = this.rowCount;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.creatorHeaderRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.creatorRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.emptyView = i4;
        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
        if (tLRPC$TL_chatInviteExported.usage != 0 || tLRPC$TL_chatInviteExported.usage_limit != 0) {
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.dividerRow = i5;
            this.rowCount = i6 + 1;
            this.usersHeaderRow = i6;
            if (!this.invitedUsers.isEmpty()) {
                int i7 = this.rowCount;
                this.usersStartRow = i7;
                int size = i7 + this.invitedUsers.size();
                this.rowCount = size;
                this.usersEndRow = size;
                this.rowCount = size + 1;
                this.emptyView2 = size;
            } else if (this.invite.usage > 0) {
                int i8 = this.rowCount;
                int i9 = i8 + 1;
                this.rowCount = i9;
                this.loadingRow = i8;
                this.rowCount = i9 + 1;
                this.emptyView2 = i9;
            } else {
                int i10 = this.rowCount;
                this.rowCount = i10 + 1;
                this.emptyHintRow = i10;
            }
        }
        if (this.emptyHintRow == -1) {
            int i11 = this.rowCount;
            this.rowCount = i11 + 1;
            this.divider2Row = i11;
        }
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class Adapter extends RecyclerListView.SelectionAdapter {
        private Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
            if (position == inviteLinkBottomSheet.creatorHeaderRow) {
                return 0;
            }
            if (position == inviteLinkBottomSheet.creatorRow) {
                return 1;
            }
            if (position >= inviteLinkBottomSheet.usersStartRow && position < inviteLinkBottomSheet.usersEndRow) {
                return 1;
            }
            if (position == inviteLinkBottomSheet.dividerRow) {
                return 2;
            }
            if (position == inviteLinkBottomSheet.linkActionRow) {
                return 3;
            }
            if (position == inviteLinkBottomSheet.linkInfoRow) {
                return 4;
            }
            if (position == inviteLinkBottomSheet.loadingRow) {
                return 5;
            }
            if (position == inviteLinkBottomSheet.emptyView || position == inviteLinkBottomSheet.emptyView2) {
                return 6;
            }
            if (position == inviteLinkBottomSheet.divider2Row) {
                return 7;
            }
            return position == inviteLinkBottomSheet.emptyHintRow ? 8 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View timerPrivacyCell;
            View userCell;
            Context context = viewGroup.getContext();
            switch (i) {
                case 1:
                    userCell = new UserCell(context, 12, 0, true);
                    break;
                case 2:
                    userCell = new ShadowSectionCell(context, 12, Theme.getColor("windowBackgroundGray"));
                    break;
                case 3:
                    InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                    LinkActionView linkActionView = new LinkActionView(context, inviteLinkBottomSheet.fragment, inviteLinkBottomSheet, inviteLinkBottomSheet.chatId, false, InviteLinkBottomSheet.this.isChannel);
                    linkActionView.setDelegate(new AnonymousClass1());
                    linkActionView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    userCell = linkActionView;
                    break;
                case 4:
                    timerPrivacyCell = InviteLinkBottomSheet.this.new TimerPrivacyCell(context);
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    combinedDrawable.setFullsize(true);
                    timerPrivacyCell.setBackground(combinedDrawable);
                    userCell = timerPrivacyCell;
                    break;
                case 5:
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(10);
                    flickerLoadingView.showDate(false);
                    userCell = flickerLoadingView;
                    break;
                case 6:
                    userCell = new View(context) { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.Adapter.2
                        @Override // android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(5.0f), 1073741824));
                        }
                    };
                    break;
                case 7:
                    timerPrivacyCell = new ShadowSectionCell(context, 12);
                    CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"), 0, 0);
                    combinedDrawable2.setFullsize(true);
                    timerPrivacyCell.setBackgroundDrawable(combinedDrawable2);
                    userCell = timerPrivacyCell;
                    break;
                case 8:
                    userCell = InviteLinkBottomSheet.this.new EmptyHintRow(context);
                    break;
                default:
                    HeaderCell headerCell = new HeaderCell(context, "windowBackgroundWhiteBlueHeader", 21, 15, true);
                    headerCell.getTextView2().setTextColor(Theme.getColor("windowBackgroundWhiteRedText"));
                    headerCell.getTextView2().setTextSize(15);
                    headerCell.getTextView2().setTypeface(AndroidUtilities.getFontFamily(true));
                    userCell = headerCell;
                    break;
            }
            userCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(userCell);
        }

        /* renamed from: ir.eitaa.ui.Components.InviteLinkBottomSheet$Adapter$1, reason: invalid class name */
        class AnonymousClass1 implements LinkActionView.Delegate {
            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void showUsersForPermanentLink() {
                LinkActionView.Delegate.CC.$default$showUsersForPermanentLink(this);
            }

            AnonymousClass1() {
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public void revokeLink() {
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                BaseFragment baseFragment = inviteLinkBottomSheet.fragment;
                if (baseFragment instanceof ManageLinksActivity) {
                    ((ManageLinksActivity) baseFragment).revokeLink(inviteLinkBottomSheet.invite);
                } else {
                    TLRPC$TL_messages_editExportedChatInvite tLRPC$TL_messages_editExportedChatInvite = new TLRPC$TL_messages_editExportedChatInvite();
                    InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                    tLRPC$TL_messages_editExportedChatInvite.link = inviteLinkBottomSheet2.invite.link;
                    tLRPC$TL_messages_editExportedChatInvite.revoked = true;
                    tLRPC$TL_messages_editExportedChatInvite.peer = MessagesController.getInstance(((BottomSheet) inviteLinkBottomSheet2).currentAccount).getInputPeer(-InviteLinkBottomSheet.this.chatId);
                    ConnectionsManager.getInstance(((BottomSheet) InviteLinkBottomSheet.this).currentAccount).sendRequest(tLRPC$TL_messages_editExportedChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$Adapter$1$XBN9FAZZajXAlzrP-p8-KrowQck
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$revokeLink$1$InviteLinkBottomSheet$Adapter$1(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                InviteLinkBottomSheet.this.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$revokeLink$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$revokeLink$1$InviteLinkBottomSheet$Adapter$1(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$Adapter$1$kemgNuNBAkdUzTtImx-afbS7zno
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$revokeLink$0$InviteLinkBottomSheet$Adapter$1(tLRPC$TL_error, tLObject);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$revokeLink$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$revokeLink$0$InviteLinkBottomSheet$Adapter$1(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
                if (tLRPC$TL_error == null) {
                    if (tLObject instanceof TLRPC$TL_messages_exportedChatInviteReplaced) {
                        TLRPC$TL_messages_exportedChatInviteReplaced tLRPC$TL_messages_exportedChatInviteReplaced = (TLRPC$TL_messages_exportedChatInviteReplaced) tLObject;
                        InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                        TLRPC$ChatFull tLRPC$ChatFull = inviteLinkBottomSheet.info;
                        if (tLRPC$ChatFull != null) {
                            tLRPC$ChatFull.exported_invite = (TLRPC$TL_chatInviteExported) tLRPC$TL_messages_exportedChatInviteReplaced.new_invite;
                        }
                        InviteDelegate inviteDelegate = inviteLinkBottomSheet.inviteDelegate;
                        return;
                    }
                    InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                    TLRPC$ChatFull tLRPC$ChatFull2 = inviteLinkBottomSheet2.info;
                    if (tLRPC$ChatFull2 != null) {
                        int i = tLRPC$ChatFull2.invitesCount - 1;
                        tLRPC$ChatFull2.invitesCount = i;
                        if (i < 0) {
                            tLRPC$ChatFull2.invitesCount = 0;
                        }
                        MessagesStorage.getInstance(((BottomSheet) inviteLinkBottomSheet2).currentAccount).saveChatLinksCount(InviteLinkBottomSheet.this.chatId, InviteLinkBottomSheet.this.info.invitesCount);
                    }
                    InviteLinkBottomSheet inviteLinkBottomSheet3 = InviteLinkBottomSheet.this;
                    InviteDelegate inviteDelegate2 = inviteLinkBottomSheet3.inviteDelegate;
                    if (inviteDelegate2 != null) {
                        inviteDelegate2.linkRevoked(inviteLinkBottomSheet3.invite);
                    }
                }
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public void editLink() {
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                BaseFragment baseFragment = inviteLinkBottomSheet.fragment;
                if (baseFragment instanceof ManageLinksActivity) {
                    ((ManageLinksActivity) baseFragment).editLink(inviteLinkBottomSheet.invite);
                } else {
                    LinkEditActivity linkEditActivity = new LinkEditActivity(1, inviteLinkBottomSheet.chatId);
                    linkEditActivity.setInviteToEdit(InviteLinkBottomSheet.this.invite);
                    linkEditActivity.setCallback(new LinkEditActivity.Callback() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.Adapter.1.1
                        @Override // ir.eitaa.ui.LinkEditActivity.Callback
                        public void onLinkCreated(TLObject response) {
                        }

                        @Override // ir.eitaa.ui.LinkEditActivity.Callback
                        public void onLinkRemoved(TLRPC$TL_chatInviteExported inviteFinal) {
                        }

                        @Override // ir.eitaa.ui.LinkEditActivity.Callback
                        public void revokeLink(TLRPC$TL_chatInviteExported inviteFinal) {
                        }

                        @Override // ir.eitaa.ui.LinkEditActivity.Callback
                        public void onLinkEdited(TLRPC$TL_chatInviteExported inviteToEdit, TLObject response) {
                            InviteDelegate inviteDelegate = InviteLinkBottomSheet.this.inviteDelegate;
                            if (inviteDelegate != null) {
                                inviteDelegate.onLinkEdited(inviteToEdit);
                            }
                        }
                    });
                    InviteLinkBottomSheet.this.fragment.presentFragment(linkEditActivity);
                }
                InviteLinkBottomSheet.this.dismiss();
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public void removeLink() {
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                BaseFragment baseFragment = inviteLinkBottomSheet.fragment;
                if (baseFragment instanceof ManageLinksActivity) {
                    ((ManageLinksActivity) baseFragment).deleteLink(inviteLinkBottomSheet.invite);
                } else {
                    TLRPC$TL_messages_deleteExportedChatInvite tLRPC$TL_messages_deleteExportedChatInvite = new TLRPC$TL_messages_deleteExportedChatInvite();
                    InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                    tLRPC$TL_messages_deleteExportedChatInvite.link = inviteLinkBottomSheet2.invite.link;
                    tLRPC$TL_messages_deleteExportedChatInvite.peer = MessagesController.getInstance(((BottomSheet) inviteLinkBottomSheet2).currentAccount).getInputPeer(-InviteLinkBottomSheet.this.chatId);
                    ConnectionsManager.getInstance(((BottomSheet) InviteLinkBottomSheet.this).currentAccount).sendRequest(tLRPC$TL_messages_deleteExportedChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$Adapter$1$u-YaILZJgy8sSbqrWzKy-h80abU
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$removeLink$3$InviteLinkBottomSheet$Adapter$1(tLObject, tLRPC$TL_error);
                        }
                    });
                }
                InviteLinkBottomSheet.this.dismiss();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$removeLink$3, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$removeLink$3$InviteLinkBottomSheet$Adapter$1(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$Adapter$1$xA5_YTv703XLgVHTDvl9QdON3RM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$removeLink$2$InviteLinkBottomSheet$Adapter$1(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$removeLink$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$removeLink$2$InviteLinkBottomSheet$Adapter$1(TLRPC$TL_error tLRPC$TL_error) {
                InviteLinkBottomSheet inviteLinkBottomSheet;
                InviteDelegate inviteDelegate;
                if (tLRPC$TL_error != null || (inviteDelegate = (inviteLinkBottomSheet = InviteLinkBottomSheet.this).inviteDelegate) == null) {
                    return;
                }
                inviteDelegate.onLinkDeleted(inviteLinkBottomSheet.invite);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int i;
            int i2;
            TLRPC$User tLRPC$User;
            String str;
            String string;
            int itemViewType = holder.getItemViewType();
            String string2 = null;
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                if (position == inviteLinkBottomSheet.creatorHeaderRow) {
                    headerCell.setText(LocaleController.getString("LinkCreatedeBy", R.string.LinkCreatedeBy));
                    headerCell.setText2(null);
                    return;
                }
                if (position == inviteLinkBottomSheet.usersHeaderRow) {
                    int i3 = inviteLinkBottomSheet.invite.usage;
                    if (i3 > 0) {
                        headerCell.setText(LocaleController.formatPluralString("PeopleJoined", i3));
                    } else {
                        headerCell.setText(LocaleController.getString("NoOneJoined", R.string.NoOneJoined));
                    }
                    TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = InviteLinkBottomSheet.this.invite;
                    if (!tLRPC$TL_chatInviteExported.expired && !tLRPC$TL_chatInviteExported.revoked && (i = tLRPC$TL_chatInviteExported.usage_limit) > 0 && (i2 = tLRPC$TL_chatInviteExported.usage) > 0) {
                        headerCell.setText2(LocaleController.formatPluralString("PeopleJoinedRemaining", i - i2));
                        return;
                    } else {
                        headerCell.setText2(null);
                        return;
                    }
                }
                return;
            }
            int i4 = 0;
            if (itemViewType == 1) {
                UserCell userCell = (UserCell) holder.itemView;
                InviteLinkBottomSheet inviteLinkBottomSheet2 = InviteLinkBottomSheet.this;
                if (position == inviteLinkBottomSheet2.creatorRow) {
                    TLRPC$User user = inviteLinkBottomSheet2.users.get(Long.valueOf(inviteLinkBottomSheet2.invite.admin_id));
                    if (user == null) {
                        user = MessagesController.getInstance(((BottomSheet) InviteLinkBottomSheet.this).currentAccount).getUser(Long.valueOf(InviteLinkBottomSheet.this.invite.admin_id));
                    }
                    String dateAudio = user != null ? LocaleController.formatDateAudio(InviteLinkBottomSheet.this.invite.date, false) : null;
                    TLRPC$ChatFull tLRPC$ChatFull = InviteLinkBottomSheet.this.info;
                    if (tLRPC$ChatFull != null && user != null && tLRPC$ChatFull.participants != null) {
                        while (true) {
                            if (i4 >= InviteLinkBottomSheet.this.info.participants.participants.size()) {
                                break;
                            }
                            if (InviteLinkBottomSheet.this.info.participants.participants.get(i4).user_id == user.id) {
                                TLRPC$ChatParticipant tLRPC$ChatParticipant = InviteLinkBottomSheet.this.info.participants.participants.get(i4);
                                if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatChannelParticipant) {
                                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = ((TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant).channelParticipant;
                                    if (!TextUtils.isEmpty(tLRPC$ChannelParticipant.rank)) {
                                        string2 = tLRPC$ChannelParticipant.rank;
                                    } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantCreator) {
                                        string2 = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                                    } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantAdmin) {
                                        string2 = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                                    }
                                } else {
                                    if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator) {
                                        string = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                                    } else if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin) {
                                        string = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                                    }
                                    string2 = string;
                                }
                            } else {
                                i4++;
                            }
                        }
                    }
                    tLRPC$User = user;
                    str = dateAudio;
                } else {
                    tLRPC$User = InviteLinkBottomSheet.this.users.get(Long.valueOf(inviteLinkBottomSheet2.invitedUsers.get(position - inviteLinkBottomSheet2.usersStartRow).user_id));
                    str = null;
                }
                userCell.setAdminRole(string2);
                userCell.setData(tLRPC$User, null, str, 0, false);
                return;
            }
            if (itemViewType == 3) {
                LinkActionView linkActionView = (LinkActionView) holder.itemView;
                linkActionView.setUsers(0, null);
                linkActionView.setLink(InviteLinkBottomSheet.this.invite.link);
                linkActionView.setRevoke(InviteLinkBottomSheet.this.invite.revoked);
                linkActionView.setPermanent(InviteLinkBottomSheet.this.invite.permanent);
                linkActionView.setCanEdit(InviteLinkBottomSheet.this.canEdit);
                linkActionView.hideRevokeOption(!InviteLinkBottomSheet.this.canEdit);
                return;
            }
            if (itemViewType != 4) {
                if (itemViewType != 8) {
                    return;
                }
                EmptyHintRow emptyHintRow = (EmptyHintRow) holder.itemView;
                int i5 = InviteLinkBottomSheet.this.invite.usage_limit;
                if (i5 > 0) {
                    emptyHintRow.textView.setText(LocaleController.formatPluralString("PeopleCanJoinViaLinkCount", i5));
                    emptyHintRow.textView.setVisibility(0);
                    return;
                } else {
                    emptyHintRow.textView.setVisibility(8);
                    return;
                }
            }
            TimerPrivacyCell timerPrivacyCell = (TimerPrivacyCell) holder.itemView;
            timerPrivacyCell.cancelTimer();
            timerPrivacyCell.timer = false;
            timerPrivacyCell.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
            timerPrivacyCell.setFixedSize(0);
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = InviteLinkBottomSheet.this.invite;
            if (tLRPC$TL_chatInviteExported2.revoked) {
                timerPrivacyCell.setText(LocaleController.getString("LinkIsNoActive", R.string.LinkIsNoActive));
                return;
            }
            if (tLRPC$TL_chatInviteExported2.expired) {
                int i6 = tLRPC$TL_chatInviteExported2.usage_limit;
                if (i6 > 0 && i6 == tLRPC$TL_chatInviteExported2.usage) {
                    timerPrivacyCell.setText(LocaleController.getString("LinkIsExpiredLimitReached", R.string.LinkIsExpiredLimitReached));
                    return;
                } else {
                    timerPrivacyCell.setText(LocaleController.getString("LinkIsExpired", R.string.LinkIsExpired));
                    timerPrivacyCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText"));
                    return;
                }
            }
            if (tLRPC$TL_chatInviteExported2.expire_date > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() + (InviteLinkBottomSheet.this.timeDif * 1000);
                int i7 = InviteLinkBottomSheet.this.invite.expire_date;
                long j = (i7 * 1000) - jCurrentTimeMillis;
                if (j < 0) {
                    j = 0;
                }
                if (j > 86400000) {
                    timerPrivacyCell.setText(LocaleController.formatString("LinkExpiresIn", R.string.LinkExpiresIn, LocaleController.formatDateAudio(i7, false)));
                    return;
                }
                long j2 = j / 1000;
                int i8 = (int) (j2 % 60);
                long j3 = j2 / 60;
                int i9 = (int) (j3 % 60);
                int i10 = (int) (j3 / 60);
                StringBuilder sb = new StringBuilder();
                Locale locale = Locale.ENGLISH;
                sb.append(String.format(locale, "%02d", Integer.valueOf(i10)));
                sb.append(String.format(locale, ":%02d", Integer.valueOf(i9)));
                sb.append(String.format(locale, ":%02d", Integer.valueOf(i8)));
                String string3 = sb.toString();
                timerPrivacyCell.timer = true;
                timerPrivacyCell.runTimer();
                timerPrivacyCell.setText(LocaleController.formatString("LinkExpiresInTime", R.string.LinkExpiresInTime, string3));
                return;
            }
            timerPrivacyCell.setFixedSize(12);
            timerPrivacyCell.setText(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return InviteLinkBottomSheet.this.rowCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
            return adapterPosition == inviteLinkBottomSheet.creatorRow ? inviteLinkBottomSheet.invite.admin_id != UserConfig.getInstance(((BottomSheet) inviteLinkBottomSheet).currentAccount).clientUserId : adapterPosition >= inviteLinkBottomSheet.usersStartRow && adapterPosition < inviteLinkBottomSheet.usersEndRow;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.titleTextView.setTranslationY(this.scrollOffsetY);
            this.shadow.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(false);
            i = top;
        } else {
            runShadowAnimation(true);
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            TextView textView = this.titleTextView;
            if (textView != null) {
                textView.setTranslationY(this.scrollOffsetY);
            }
            this.shadow.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }
    }

    private void runShadowAnimation(final boolean show) {
        if ((!show || this.shadow.getTag() == null) && (show || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(show ? null : 1);
        if (show) {
            this.shadow.setVisibility(0);
            this.titleTextView.setVisibility(0);
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
        if (!this.titleVisible) {
            AnimatorSet animatorSet3 = this.shadowAnimation;
            Animator[] animatorArr2 = new Animator[1];
            TextView textView = this.titleTextView;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 1.0f : 0.0f;
            animatorArr2[0] = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr2);
        }
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (InviteLinkBottomSheet.this.shadowAnimation == null || !InviteLinkBottomSheet.this.shadowAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    InviteLinkBottomSheet.this.shadow.setVisibility(4);
                    InviteLinkBottomSheet.this.titleTextView.setVisibility(4);
                }
                InviteLinkBottomSheet.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (InviteLinkBottomSheet.this.shadowAnimation == null || !InviteLinkBottomSheet.this.shadowAnimation.equals(animation)) {
                    return;
                }
                InviteLinkBottomSheet.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    public void loadUsers() {
        if (this.invite.usage <= 0 || this.usersLoading) {
            return;
        }
        TLRPC$TL_messages_getChatInviteImporters tLRPC$TL_messages_getChatInviteImporters = new TLRPC$TL_messages_getChatInviteImporters();
        tLRPC$TL_messages_getChatInviteImporters.link = this.invite.link;
        tLRPC$TL_messages_getChatInviteImporters.peer = MessagesController.getInstance(UserConfig.selectedAccount).getInputPeer(-this.chatId);
        if (this.invitedUsers.isEmpty()) {
            tLRPC$TL_messages_getChatInviteImporters.offset_user = new TLRPC$TL_inputUserEmpty();
        } else {
            ArrayList<TLRPC$TL_chatInviteImporter> arrayList = this.invitedUsers;
            TLRPC$TL_chatInviteImporter tLRPC$TL_chatInviteImporter = arrayList.get(arrayList.size() - 1);
            tLRPC$TL_messages_getChatInviteImporters.offset_user = MessagesController.getInstance(this.currentAccount).getInputUser(this.users.get(Long.valueOf(tLRPC$TL_chatInviteImporter.user_id)));
            tLRPC$TL_messages_getChatInviteImporters.offset_date = tLRPC$TL_chatInviteImporter.date;
        }
        this.usersLoading = true;
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_messages_getChatInviteImporters, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$Z1NEXOxfyL3gDSObnQGuc3jfxSU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadUsers$2$InviteLinkBottomSheet(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUsers$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUsers$2$InviteLinkBottomSheet(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InviteLinkBottomSheet$LPDo-NtyXcwT3wmdaMpLlzmgxM8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUsers$1$InviteLinkBottomSheet(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUsers$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUsers$1$InviteLinkBottomSheet(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_chatInviteImporters tLRPC$TL_messages_chatInviteImporters = (TLRPC$TL_messages_chatInviteImporters) tLObject;
            this.invitedUsers.addAll(tLRPC$TL_messages_chatInviteImporters.importers);
            for (int i = 0; i < tLRPC$TL_messages_chatInviteImporters.users.size(); i++) {
                TLRPC$User tLRPC$User = tLRPC$TL_messages_chatInviteImporters.users.get(i);
                this.users.put(Long.valueOf(tLRPC$User.id), tLRPC$User);
            }
            this.hasMore = this.invitedUsers.size() < tLRPC$TL_messages_chatInviteImporters.count;
            updateRows();
        }
        this.usersLoading = false;
    }

    public void setInviteDelegate(InviteDelegate inviteDelegate) {
        this.inviteDelegate = inviteDelegate;
    }

    private class TimerPrivacyCell extends TextInfoPrivacyCell {
        boolean timer;
        Runnable timerRunnable;

        public TimerPrivacyCell(Context context) {
            super(context);
            this.timerRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.InviteLinkBottomSheet.TimerPrivacyCell.1
                @Override // java.lang.Runnable
                public void run() {
                    int childAdapterPosition;
                    if (InviteLinkBottomSheet.this.listView != null && InviteLinkBottomSheet.this.listView.getAdapter() != null && (childAdapterPosition = InviteLinkBottomSheet.this.listView.getChildAdapterPosition(TimerPrivacyCell.this)) >= 0) {
                        InviteLinkBottomSheet inviteLinkBottomSheet = InviteLinkBottomSheet.this;
                        inviteLinkBottomSheet.adapter.onBindViewHolder(inviteLinkBottomSheet.listView.getChildViewHolder(TimerPrivacyCell.this), childAdapterPosition);
                    }
                    AndroidUtilities.runOnUIThread(this);
                }
            };
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            runTimer();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            cancelTimer();
        }

        public void cancelTimer() {
            AndroidUtilities.cancelRunOnUIThread(this.timerRunnable);
        }

        public void runTimer() {
            cancelTimer();
            if (this.timer) {
                AndroidUtilities.runOnUIThread(this.timerRunnable, 500L);
            }
        }
    }

    private class EmptyHintRow extends FrameLayout {
        TextView textView;

        public EmptyHintRow(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            this.textView.setGravity(1);
            addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 16, 60.0f, 0.0f, 60.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(84.0f), 1073741824));
        }
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
}
