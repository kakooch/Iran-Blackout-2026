package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventsFilter;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.CheckBoxUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ContentPreviewViewer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AdminLogFilterAlert extends BottomSheet {
    private ListAdapter adapter;
    private int adminsRow;
    private int allAdminsRow;
    private int callsRow;
    private ArrayList<TLRPC$ChannelParticipant> currentAdmins;
    private TLRPC$TL_channelAdminLogEventsFilter currentFilter;
    private AdminLogFilterAlertDelegate delegate;
    private int deleteRow;
    private int editRow;
    private boolean ignoreLayout;
    private int infoRow;
    private int invitesRow;
    private boolean isMegagroup;
    private int leavingRow;
    private RecyclerListView listView;
    private int membersRow;
    private int pinnedRow;
    private int restrictionsRow;
    private BottomSheet.BottomSheetCell saveButton;
    private int scrollOffsetY;
    private LongSparseArray<TLRPC$User> selectedAdmins;
    private Drawable shadowDrawable;

    public interface AdminLogFilterAlertDelegate {
        void didSelectRights(TLRPC$TL_channelAdminLogEventsFilter filter, LongSparseArray<TLRPC$User> admins);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public AdminLogFilterAlert(Context context, TLRPC$TL_channelAdminLogEventsFilter filter, LongSparseArray<TLRPC$User> admins, boolean megagroup) {
        int i;
        super(context, false);
        if (filter != null) {
            TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter = new TLRPC$TL_channelAdminLogEventsFilter();
            this.currentFilter = tLRPC$TL_channelAdminLogEventsFilter;
            tLRPC$TL_channelAdminLogEventsFilter.join = filter.join;
            tLRPC$TL_channelAdminLogEventsFilter.leave = filter.leave;
            tLRPC$TL_channelAdminLogEventsFilter.invite = filter.invite;
            tLRPC$TL_channelAdminLogEventsFilter.ban = filter.ban;
            tLRPC$TL_channelAdminLogEventsFilter.unban = filter.unban;
            tLRPC$TL_channelAdminLogEventsFilter.kick = filter.kick;
            tLRPC$TL_channelAdminLogEventsFilter.unkick = filter.unkick;
            tLRPC$TL_channelAdminLogEventsFilter.promote = filter.promote;
            tLRPC$TL_channelAdminLogEventsFilter.demote = filter.demote;
            tLRPC$TL_channelAdminLogEventsFilter.info = filter.info;
            tLRPC$TL_channelAdminLogEventsFilter.settings = filter.settings;
            tLRPC$TL_channelAdminLogEventsFilter.pinned = filter.pinned;
            tLRPC$TL_channelAdminLogEventsFilter.edit = filter.edit;
            tLRPC$TL_channelAdminLogEventsFilter.delete = filter.delete;
            tLRPC$TL_channelAdminLogEventsFilter.group_call = filter.group_call;
            tLRPC$TL_channelAdminLogEventsFilter.invites = filter.invites;
        }
        if (admins != null) {
            this.selectedAdmins = admins.m1clone();
        }
        this.isMegagroup = megagroup;
        if (megagroup) {
            i = 2;
            this.restrictionsRow = 1;
        } else {
            this.restrictionsRow = -1;
            i = 1;
        }
        int i2 = i + 1;
        this.adminsRow = i;
        int i3 = i2 + 1;
        this.membersRow = i2;
        int i4 = i3 + 1;
        this.invitesRow = i3;
        int i5 = i4 + 1;
        this.infoRow = i4;
        int i6 = i5 + 1;
        this.deleteRow = i5;
        int i7 = i6 + 1;
        this.editRow = i6;
        if (megagroup) {
            this.pinnedRow = i7;
            i7++;
        } else {
            this.pinnedRow = -1;
        }
        int i8 = i7 + 1;
        this.leavingRow = i7;
        this.callsRow = i8;
        this.allAdminsRow = i8 + 1 + 1;
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AdminLogFilterAlert.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && AdminLogFilterAlert.this.scrollOffsetY != 0 && ev.getY() < AdminLogFilterAlert.this.scrollOffsetY) {
                    AdminLogFilterAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !AdminLogFilterAlert.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                getMeasuredWidth();
                int iDp = AndroidUtilities.dp(48.0f) + ((AdminLogFilterAlert.this.isMegagroup ? 11 : 8) * AndroidUtilities.dp(48.0f)) + ((BottomSheet) AdminLogFilterAlert.this).backgroundPaddingTop + AndroidUtilities.dp(17.0f);
                if (AdminLogFilterAlert.this.currentAdmins != null) {
                    iDp += ((AdminLogFilterAlert.this.currentAdmins.size() + 1) * AndroidUtilities.dp(48.0f)) + AndroidUtilities.dp(20.0f);
                }
                int i9 = size / 5;
                int i10 = ((float) iDp) < ((float) i9) * 3.2f ? 0 : i9 * 2;
                if (i10 != 0 && iDp < size) {
                    i10 -= size - iDp;
                }
                if (i10 == 0) {
                    i10 = ((BottomSheet) AdminLogFilterAlert.this).backgroundPaddingTop;
                }
                if (AdminLogFilterAlert.this.listView.getPaddingTop() != i10) {
                    AdminLogFilterAlert.this.ignoreLayout = true;
                    AdminLogFilterAlert.this.listView.setPadding(0, i10, 0, 0);
                    AdminLogFilterAlert.this.ignoreLayout = false;
                }
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                AdminLogFilterAlert.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (AdminLogFilterAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                AdminLogFilterAlert.this.shadowDrawable.setBounds(0, AdminLogFilterAlert.this.scrollOffsetY - ((BottomSheet) AdminLogFilterAlert.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                AdminLogFilterAlert.this.shadowDrawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i9 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i9, 0, i9, 0);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.AdminLogFilterAlert.2
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent event) {
                return super.onInterceptTouchEvent(event) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, AdminLogFilterAlert.this.listView, 0, null, this.resourcesProvider);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (AdminLogFilterAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setClipToPadding(false);
        this.listView.setEnabled(true);
        this.listView.setGlowColor(Theme.getColor("dialogScrollGlow"));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.AdminLogFilterAlert.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                AdminLogFilterAlert.this.updateLayout();
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AdminLogFilterAlert$kBCDPhw19MWjNKt5lcEANXHYRvQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i10) {
                this.f$0.lambda$new$0$AdminLogFilterAlert(view, i10);
            }
        });
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        View view = new View(context);
        view.setBackgroundResource(R.drawable.header_shadow_reverse);
        this.containerView.addView(view, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        BottomSheet.BottomSheetCell bottomSheetCell = new BottomSheet.BottomSheetCell(context, 1);
        this.saveButton = bottomSheetCell;
        bottomSheetCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        this.saveButton.setTextAndIcon(LocaleController.getString("Save", R.string.Save).toUpperCase(), 0);
        this.saveButton.setTextColor(Theme.getColor("dialogTextBlue2"));
        this.saveButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AdminLogFilterAlert$BSoYzuYjSFp6nPDN6jDPXpxz1RY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1$AdminLogFilterAlert(view2);
            }
        });
        this.containerView.addView(this.saveButton, LayoutHelper.createFrame(-1, 48, 83));
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$AdminLogFilterAlert(View view, int i) {
        if (view instanceof CheckBoxCell) {
            CheckBoxCell checkBoxCell = (CheckBoxCell) view;
            boolean zIsChecked = checkBoxCell.isChecked();
            checkBoxCell.setChecked(!zIsChecked, true);
            if (i == 0) {
                if (zIsChecked) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter = new TLRPC$TL_channelAdminLogEventsFilter();
                    this.currentFilter = tLRPC$TL_channelAdminLogEventsFilter;
                    tLRPC$TL_channelAdminLogEventsFilter.invites = false;
                    tLRPC$TL_channelAdminLogEventsFilter.group_call = false;
                    tLRPC$TL_channelAdminLogEventsFilter.delete = false;
                    tLRPC$TL_channelAdminLogEventsFilter.edit = false;
                    tLRPC$TL_channelAdminLogEventsFilter.pinned = false;
                    tLRPC$TL_channelAdminLogEventsFilter.settings = false;
                    tLRPC$TL_channelAdminLogEventsFilter.info = false;
                    tLRPC$TL_channelAdminLogEventsFilter.demote = false;
                    tLRPC$TL_channelAdminLogEventsFilter.promote = false;
                    tLRPC$TL_channelAdminLogEventsFilter.unkick = false;
                    tLRPC$TL_channelAdminLogEventsFilter.kick = false;
                    tLRPC$TL_channelAdminLogEventsFilter.unban = false;
                    tLRPC$TL_channelAdminLogEventsFilter.ban = false;
                    tLRPC$TL_channelAdminLogEventsFilter.invite = false;
                    tLRPC$TL_channelAdminLogEventsFilter.leave = false;
                    tLRPC$TL_channelAdminLogEventsFilter.join = false;
                } else {
                    this.currentFilter = null;
                }
                int childCount = this.listView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.listView.getChildAt(i2);
                    RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt);
                    int adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
                    if (viewHolderFindContainingViewHolder.getItemViewType() == 0 && adapterPosition > 0 && adapterPosition < this.allAdminsRow - 1) {
                        ((CheckBoxCell) childAt).setChecked(!zIsChecked, true);
                    }
                }
            } else if (i == this.allAdminsRow) {
                if (zIsChecked) {
                    this.selectedAdmins = new LongSparseArray<>();
                } else {
                    this.selectedAdmins = null;
                }
                int childCount2 = this.listView.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = this.listView.getChildAt(i3);
                    RecyclerView.ViewHolder viewHolderFindContainingViewHolder2 = this.listView.findContainingViewHolder(childAt2);
                    viewHolderFindContainingViewHolder2.getAdapterPosition();
                    if (viewHolderFindContainingViewHolder2.getItemViewType() == 2) {
                        ((CheckBoxUserCell) childAt2).setChecked(!zIsChecked, true);
                    }
                }
            } else {
                if (this.currentFilter == null) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter2 = new TLRPC$TL_channelAdminLogEventsFilter();
                    this.currentFilter = tLRPC$TL_channelAdminLogEventsFilter2;
                    tLRPC$TL_channelAdminLogEventsFilter2.invites = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.group_call = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.delete = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.edit = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.pinned = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.settings = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.info = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.demote = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.promote = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.unkick = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.kick = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.unban = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.ban = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.invite = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.leave = true;
                    tLRPC$TL_channelAdminLogEventsFilter2.join = true;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(0);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        ((CheckBoxCell) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(false, true);
                    }
                }
                if (i == this.restrictionsRow) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter3 = this.currentFilter;
                    boolean z = !tLRPC$TL_channelAdminLogEventsFilter3.kick;
                    tLRPC$TL_channelAdminLogEventsFilter3.unban = z;
                    tLRPC$TL_channelAdminLogEventsFilter3.unkick = z;
                    tLRPC$TL_channelAdminLogEventsFilter3.ban = z;
                    tLRPC$TL_channelAdminLogEventsFilter3.kick = z;
                } else if (i == this.adminsRow) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter4 = this.currentFilter;
                    boolean z2 = !tLRPC$TL_channelAdminLogEventsFilter4.demote;
                    tLRPC$TL_channelAdminLogEventsFilter4.demote = z2;
                    tLRPC$TL_channelAdminLogEventsFilter4.promote = z2;
                } else if (i == this.membersRow) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter5 = this.currentFilter;
                    boolean z3 = !tLRPC$TL_channelAdminLogEventsFilter5.join;
                    tLRPC$TL_channelAdminLogEventsFilter5.join = z3;
                    tLRPC$TL_channelAdminLogEventsFilter5.invite = z3;
                } else if (i == this.infoRow) {
                    TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter6 = this.currentFilter;
                    boolean z4 = !tLRPC$TL_channelAdminLogEventsFilter6.info;
                    tLRPC$TL_channelAdminLogEventsFilter6.settings = z4;
                    tLRPC$TL_channelAdminLogEventsFilter6.info = z4;
                } else if (i == this.deleteRow) {
                    this.currentFilter.delete = !r7.delete;
                } else if (i == this.editRow) {
                    this.currentFilter.edit = !r7.edit;
                } else if (i == this.pinnedRow) {
                    this.currentFilter.pinned = !r7.pinned;
                } else if (i == this.leavingRow) {
                    this.currentFilter.leave = !r7.leave;
                } else if (i == this.callsRow) {
                    this.currentFilter.group_call = !r7.group_call;
                } else if (i == this.invitesRow) {
                    this.currentFilter.invites = !r7.invites;
                }
            }
            TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter7 = this.currentFilter;
            if (tLRPC$TL_channelAdminLogEventsFilter7 != null && !tLRPC$TL_channelAdminLogEventsFilter7.join && !tLRPC$TL_channelAdminLogEventsFilter7.leave && !tLRPC$TL_channelAdminLogEventsFilter7.invite && !tLRPC$TL_channelAdminLogEventsFilter7.ban && !tLRPC$TL_channelAdminLogEventsFilter7.invites && !tLRPC$TL_channelAdminLogEventsFilter7.unban && !tLRPC$TL_channelAdminLogEventsFilter7.kick && !tLRPC$TL_channelAdminLogEventsFilter7.unkick && !tLRPC$TL_channelAdminLogEventsFilter7.promote && !tLRPC$TL_channelAdminLogEventsFilter7.demote && !tLRPC$TL_channelAdminLogEventsFilter7.info && !tLRPC$TL_channelAdminLogEventsFilter7.settings && !tLRPC$TL_channelAdminLogEventsFilter7.pinned && !tLRPC$TL_channelAdminLogEventsFilter7.edit && !tLRPC$TL_channelAdminLogEventsFilter7.delete && !tLRPC$TL_channelAdminLogEventsFilter7.group_call) {
                this.saveButton.setEnabled(false);
                this.saveButton.setAlpha(0.5f);
                return;
            } else {
                this.saveButton.setEnabled(true);
                this.saveButton.setAlpha(1.0f);
                return;
            }
        }
        if (view instanceof CheckBoxUserCell) {
            CheckBoxUserCell checkBoxUserCell = (CheckBoxUserCell) view;
            if (this.selectedAdmins == null) {
                this.selectedAdmins = new LongSparseArray<>();
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.allAdminsRow);
                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                    ((CheckBoxCell) viewHolderFindViewHolderForAdapterPosition2.itemView).setChecked(false, true);
                }
                for (int i4 = 0; i4 < this.currentAdmins.size(); i4++) {
                    TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(MessageObject.getPeerId(this.currentAdmins.get(i4).peer)));
                    this.selectedAdmins.put(user.id, user);
                }
            }
            boolean zIsChecked2 = checkBoxUserCell.isChecked();
            TLRPC$User currentUser = checkBoxUserCell.getCurrentUser();
            if (zIsChecked2) {
                this.selectedAdmins.remove(currentUser.id);
            } else {
                this.selectedAdmins.put(currentUser.id, currentUser);
            }
            checkBoxUserCell.setChecked(!zIsChecked2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$AdminLogFilterAlert(View view) {
        this.delegate.didSelectRights(this.currentFilter, this.selectedAdmins);
        dismiss();
    }

    public void setCurrentAdmins(ArrayList<TLRPC$ChannelParticipant> admins) {
        this.currentAdmins = admins;
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public void setAdminLogFilterAlertDelegate(AdminLogFilterAlertDelegate adminLogFilterAlertDelegate) {
        this.delegate = adminLogFilterAlertDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void updateLayout() {
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
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            this.containerView.invalidate();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (AdminLogFilterAlert.this.isMegagroup ? 11 : 8) + (AdminLogFilterAlert.this.currentAdmins != null ? AdminLogFilterAlert.this.currentAdmins.size() + 2 : 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position < AdminLogFilterAlert.this.allAdminsRow - 1 || position == AdminLogFilterAlert.this.allAdminsRow) {
                return 0;
            }
            return position == AdminLogFilterAlert.this.allAdminsRow - 1 ? 1 : 2;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout checkBoxCell;
            FrameLayout frameLayout;
            if (viewType == 0) {
                checkBoxCell = new CheckBoxCell(this.context, 1, 21, ((BottomSheet) AdminLogFilterAlert.this).resourcesProvider);
            } else if (viewType == 1) {
                View shadowSectionCell = new ShadowSectionCell(this.context, 18);
                checkBoxCell = new FrameLayout(this.context);
                checkBoxCell.addView(shadowSectionCell, LayoutHelper.createFrame(-1, -1.0f));
                checkBoxCell.setBackgroundColor(Theme.getColor("dialogBackgroundGray"));
            } else if (viewType == 2) {
                checkBoxCell = new CheckBoxUserCell(this.context, true);
            } else {
                frameLayout = null;
                return new RecyclerListView.Holder(frameLayout);
            }
            frameLayout = checkBoxCell;
            return new RecyclerListView.Holder(frameLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 2) {
                    return;
                }
                CheckBoxUserCell checkBoxUserCell = (CheckBoxUserCell) holder.itemView;
                long peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) AdminLogFilterAlert.this.currentAdmins.get((adapterPosition - AdminLogFilterAlert.this.allAdminsRow) - 1)).peer);
                if (AdminLogFilterAlert.this.selectedAdmins != null && AdminLogFilterAlert.this.selectedAdmins.indexOfKey(peerId) < 0) {
                    z = false;
                }
                checkBoxUserCell.setChecked(z, false);
                return;
            }
            CheckBoxCell checkBoxCell = (CheckBoxCell) holder.itemView;
            if (adapterPosition == 0) {
                checkBoxCell.setChecked(AdminLogFilterAlert.this.currentFilter == null, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.restrictionsRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && (!AdminLogFilterAlert.this.currentFilter.kick || !AdminLogFilterAlert.this.currentFilter.ban || !AdminLogFilterAlert.this.currentFilter.unkick || !AdminLogFilterAlert.this.currentFilter.unban)) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.adminsRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && (!AdminLogFilterAlert.this.currentFilter.promote || !AdminLogFilterAlert.this.currentFilter.demote)) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.membersRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && (!AdminLogFilterAlert.this.currentFilter.invite || !AdminLogFilterAlert.this.currentFilter.join)) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.infoRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.info) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.deleteRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.delete) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.editRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.edit) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.pinnedRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.pinned) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.leavingRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.leave) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.callsRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.group_call) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.invitesRow) {
                if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.invites) {
                    z = false;
                }
                checkBoxCell.setChecked(z, false);
                return;
            }
            if (adapterPosition == AdminLogFilterAlert.this.allAdminsRow) {
                checkBoxCell.setChecked(AdminLogFilterAlert.this.selectedAdmins == null, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            boolean z = true;
            if (itemViewType != 0) {
                if (itemViewType != 2) {
                    return;
                }
                CheckBoxUserCell checkBoxUserCell = (CheckBoxUserCell) holder.itemView;
                long peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) AdminLogFilterAlert.this.currentAdmins.get((position - AdminLogFilterAlert.this.allAdminsRow) - 1)).peer);
                checkBoxUserCell.setUser(MessagesController.getInstance(((BottomSheet) AdminLogFilterAlert.this).currentAccount).getUser(Long.valueOf(peerId)), AdminLogFilterAlert.this.selectedAdmins == null || AdminLogFilterAlert.this.selectedAdmins.indexOfKey(peerId) >= 0, position != getItemCount() - 1);
                return;
            }
            CheckBoxCell checkBoxCell = (CheckBoxCell) holder.itemView;
            if (position == 0) {
                checkBoxCell.setText(LocaleController.getString("EventLogFilterAll", R.string.EventLogFilterAll), "", AdminLogFilterAlert.this.currentFilter == null, true);
                return;
            }
            if (position != AdminLogFilterAlert.this.restrictionsRow) {
                if (position != AdminLogFilterAlert.this.adminsRow) {
                    if (position != AdminLogFilterAlert.this.membersRow) {
                        if (position == AdminLogFilterAlert.this.infoRow) {
                            if (AdminLogFilterAlert.this.isMegagroup) {
                                checkBoxCell.setText(LocaleController.getString("EventLogFilterGroupInfo", R.string.EventLogFilterGroupInfo), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.info, true);
                                return;
                            } else {
                                checkBoxCell.setText(LocaleController.getString("EventLogFilterChannelInfo", R.string.EventLogFilterChannelInfo), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.info, true);
                                return;
                            }
                        }
                        if (position == AdminLogFilterAlert.this.deleteRow) {
                            checkBoxCell.setText(LocaleController.getString("EventLogFilterDeletedMessages", R.string.EventLogFilterDeletedMessages), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.delete, true);
                            return;
                        }
                        if (position == AdminLogFilterAlert.this.editRow) {
                            checkBoxCell.setText(LocaleController.getString("EventLogFilterEditedMessages", R.string.EventLogFilterEditedMessages), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.edit, true);
                            return;
                        }
                        if (position == AdminLogFilterAlert.this.pinnedRow) {
                            checkBoxCell.setText(LocaleController.getString("EventLogFilterPinnedMessages", R.string.EventLogFilterPinnedMessages), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.pinned, true);
                            return;
                        }
                        if (position == AdminLogFilterAlert.this.leavingRow) {
                            checkBoxCell.setText(LocaleController.getString("EventLogFilterLeavingMembers", R.string.EventLogFilterLeavingMembers), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.leave, AdminLogFilterAlert.this.callsRow != -1);
                            return;
                        }
                        if (position != AdminLogFilterAlert.this.callsRow) {
                            if (position == AdminLogFilterAlert.this.invitesRow) {
                                checkBoxCell.setText(LocaleController.getString("EventLogFilterInvites", R.string.EventLogFilterInvites), "", AdminLogFilterAlert.this.currentFilter == null || AdminLogFilterAlert.this.currentFilter.invites, true);
                                return;
                            } else {
                                if (position == AdminLogFilterAlert.this.allAdminsRow) {
                                    checkBoxCell.setText(LocaleController.getString("EventLogAllAdmins", R.string.EventLogAllAdmins), "", AdminLogFilterAlert.this.selectedAdmins == null, true);
                                    return;
                                }
                                return;
                            }
                        }
                        String string = LocaleController.getString("EventLogFilterCalls", R.string.EventLogFilterCalls);
                        if (AdminLogFilterAlert.this.currentFilter != null && !AdminLogFilterAlert.this.currentFilter.group_call) {
                            z = false;
                        }
                        checkBoxCell.setText(string, "", z, false);
                        return;
                    }
                    String string2 = LocaleController.getString("EventLogFilterNewMembers", R.string.EventLogFilterNewMembers);
                    if (AdminLogFilterAlert.this.currentFilter == null || (AdminLogFilterAlert.this.currentFilter.invite && AdminLogFilterAlert.this.currentFilter.join)) {
                        z = true;
                    }
                    checkBoxCell.setText(string2, "", z, true);
                    return;
                }
                String string3 = LocaleController.getString("EventLogFilterNewAdmins", R.string.EventLogFilterNewAdmins);
                if (AdminLogFilterAlert.this.currentFilter == null || (AdminLogFilterAlert.this.currentFilter.promote && AdminLogFilterAlert.this.currentFilter.demote)) {
                    z = true;
                }
                checkBoxCell.setText(string3, "", z, true);
                return;
            }
            String string4 = LocaleController.getString("EventLogFilterNewRestrictions", R.string.EventLogFilterNewRestrictions);
            if (AdminLogFilterAlert.this.currentFilter == null || (AdminLogFilterAlert.this.currentFilter.kick && AdminLogFilterAlert.this.currentFilter.ban && AdminLogFilterAlert.this.currentFilter.unkick && AdminLogFilterAlert.this.currentFilter.unban)) {
                z = true;
            }
            checkBoxCell.setText(string4, "", z, true);
        }
    }
}
