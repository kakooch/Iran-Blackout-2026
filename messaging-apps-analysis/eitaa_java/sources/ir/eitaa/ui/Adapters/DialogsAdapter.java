package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$RecentMeUrl;
import ir.eitaa.tgnet.TLRPC$TL_ads_dialogAd;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationDialog;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ArchiveHintCell;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.DialogMeUrlCell;
import ir.eitaa.ui.Cells.DialogsEmptyCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PullForegroundDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class DialogsAdapter extends RecyclerListView.SelectionAdapter {
    private ArchiveHintCell archiveHintCell;
    private Drawable arrowDrawable;
    private int currentAccount;
    private int currentCount;
    private int dialogsCount;
    private boolean dialogsListFrozen;
    private int dialogsType;
    private int folderId;
    private boolean forceShowEmptyCell;
    public boolean hasDialogAd;
    private boolean hasHints;
    private boolean isForward;
    private boolean isOnlySelect;
    private boolean isReordering;
    private long lastSortTime;
    private Context mContext;
    private ArrayList<TLRPC$TL_contact> onlineContacts;
    private long openedDialogId;
    private DialogsActivity parentFragment;
    private DialogsPreloader preloader;
    private PullForegroundDrawable pullForegroundDrawable;
    private ArrayList<Long> selectedDialogs;
    private boolean showArchiveHint;

    public DialogsAdapter(DialogsActivity fragment, Context context, int type, int folder, boolean onlySelect, ArrayList<Long> selected, int account, boolean forward) {
        this.mContext = context;
        this.parentFragment = fragment;
        this.dialogsType = type;
        this.folderId = folder;
        this.isForward = forward;
        this.isOnlySelect = onlySelect;
        this.hasHints = folder == 0 && type == 0 && !onlySelect;
        this.selectedDialogs = selected;
        this.currentAccount = account;
        if (folder == 1) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            this.showArchiveHint = globalMainSettings.getBoolean("archivehint", true);
            globalMainSettings.edit().putBoolean("archivehint", false).commit();
            if (this.showArchiveHint) {
                this.archiveHintCell = new ArchiveHintCell(context);
            }
        }
        if (folder == 0) {
            this.preloader = new DialogsPreloader();
        }
    }

    public void setOpenedDialogId(long id) {
        this.openedDialogId = id;
    }

    public void onReorderStateChanged(boolean reordering) {
        this.isReordering = reordering;
    }

    public int fixPosition(int position) {
        int i;
        if (this.hasHints) {
            position -= MessagesController.getInstance(this.currentAccount).hintDialogs.size() + 2;
        }
        if (this.showArchiveHint || (i = this.dialogsType) == 11 || i == 13) {
            position -= 2;
        } else if (i == 12) {
            position--;
        }
        return (!this.hasDialogAd || this.folderId == 1 || position == 0) ? position : position - 1;
    }

    public boolean isDataSetChanged() {
        int i = this.currentCount;
        return i != getItemCount() || i == 1;
    }

    public void setDialogsType(int type) {
        this.dialogsType = type;
        notifyDataSetChanged();
    }

    public int getDialogsType() {
        return this.dialogsType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i;
        int i2;
        int i3;
        int i4;
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        int size = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, this.dialogsListFrozen).size();
        this.dialogsCount = size;
        if (this.hasDialogAd && this.folderId != 1) {
            this.dialogsCount = size + 1;
        }
        if (!this.forceShowEmptyCell && (i3 = this.dialogsType) != 7 && i3 != 8 && i3 != 11 && this.dialogsCount == 0 && ((i4 = this.folderId) != 0 || messagesController.isLoadingDialogs(i4) || !MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId))) {
            this.onlineContacts = null;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("DialogsAdapter dialogsCount=" + this.dialogsCount + " dialogsType=" + this.dialogsType + " isLoadingDialogs=" + messagesController.isLoadingDialogs(this.folderId) + " isDialogsEndReached=" + MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId));
            }
            if (this.folderId == 1 && this.showArchiveHint) {
                this.currentCount = 2;
                return 2;
            }
            this.currentCount = 0;
            return 0;
        }
        int size2 = this.dialogsCount;
        int i5 = this.dialogsType;
        if (i5 == 7 || i5 == 8 ? size2 == 0 : !(messagesController.isDialogsEndReached(this.folderId) && this.dialogsCount != 0)) {
            size2++;
        }
        if (this.hasHints) {
            size2 += messagesController.hintDialogs.size() + 2;
        } else if (this.dialogsType == 0 && messagesController.dialogs_dict.size() <= 10 && (i = this.folderId) == 0 && messagesController.isDialogsEndReached(i) && ContactsController.getInstance(this.currentAccount).contacts.isEmpty() && !ContactsController.getInstance(this.currentAccount).doneLoadingContacts) {
            this.onlineContacts = null;
            if (BuildVars.LOGS_ENABLED) {
                StringBuilder sb = new StringBuilder();
                sb.append("DialogsAdapter loadingContacts=");
                sb.append(ContactsController.getInstance(this.currentAccount).contacts.isEmpty() && !ContactsController.getInstance(this.currentAccount).doneLoadingContacts);
                sb.append("dialogsCount=");
                sb.append(this.dialogsCount);
                sb.append(" dialogsType=");
                sb.append(this.dialogsType);
                FileLog.d(sb.toString());
            }
            this.currentCount = 0;
            return 0;
        }
        int i6 = this.folderId;
        if (i6 == 0 && this.onlineContacts != null) {
            this.onlineContacts = null;
        }
        if (i6 == 1 && this.showArchiveHint) {
            size2 += 2;
        }
        if (i6 == 0 && (i2 = this.dialogsCount) != 0) {
            size2++;
            if (i2 > 10 && this.dialogsType == 0) {
                size2++;
            }
        }
        int i7 = this.dialogsType;
        if (i7 == 11 || i7 == 13) {
            size2 += 2;
        } else if (i7 == 12) {
            size2++;
        }
        this.currentCount = size2;
        return size2;
    }

    public TLObject getItem(int i) {
        int i2;
        int i3;
        ArrayList<TLRPC$TL_contact> arrayList = this.onlineContacts;
        if (arrayList != null && ((i3 = this.dialogsCount) == 0 || i >= i3)) {
            int i4 = i3 == 0 ? i - 3 : i - (i3 + 2);
            if (i4 < 0 || i4 >= arrayList.size()) {
                return null;
            }
            return MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.onlineContacts.get(i4).user_id));
        }
        if (this.showArchiveHint || (i2 = this.dialogsType) == 11 || i2 == 13) {
            i -= 2;
        } else if (i2 == 12) {
            i--;
        }
        ArrayList<TLRPC$Dialog> dialogsArray = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, this.dialogsListFrozen);
        if (this.hasDialogAd && this.folderId != 1) {
            if (hasArchive()) {
                if (i != 0) {
                    if (i == 1) {
                        return MessagesController.getInstance(this.currentAccount).dialogAd;
                    }
                }
            } else if (i == 0) {
                return MessagesController.getInstance(this.currentAccount).dialogAd;
            }
            i--;
        }
        if (this.hasHints) {
            int size = MessagesController.getInstance(this.currentAccount).hintDialogs.size() + 2;
            if (i < size) {
                return MessagesController.getInstance(this.currentAccount).hintDialogs.get(i - 1);
            }
            i -= size;
        }
        if (i < 0 || i >= dialogsArray.size()) {
            return null;
        }
        return dialogsArray.get(i);
    }

    public void sortOnlineContacts(boolean notify) {
        if (this.onlineContacts != null) {
            if (!notify || SystemClock.elapsedRealtime() - this.lastSortTime >= 2000) {
                this.lastSortTime = SystemClock.elapsedRealtime();
                try {
                    int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
                    Collections.sort(this.onlineContacts, new $$Lambda$DialogsAdapter$Ffc8LVpDgIa364cQKq8GrPs3CQg(MessagesController.getInstance(this.currentAccount), currentTime));
                    if (notify) {
                        notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ int lambda$sortOnlineContacts$0(ir.eitaa.messenger.MessagesController r2, int r3, ir.eitaa.tgnet.TLRPC$TL_contact r4, ir.eitaa.tgnet.TLRPC$TL_contact r5) {
        /*
            long r0 = r5.user_id
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$User r5 = r2.getUser(r5)
            long r0 = r4.user_id
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$User r2 = r2.getUser(r4)
            r4 = 50000(0xc350, float:7.0065E-41)
            r0 = 0
            if (r5 == 0) goto L28
            boolean r1 = r5.self
            if (r1 == 0) goto L21
            int r5 = r3 + r4
            goto L29
        L21:
            ir.eitaa.tgnet.TLRPC$UserStatus r5 = r5.status
            if (r5 == 0) goto L28
            int r5 = r5.expires
            goto L29
        L28:
            r5 = 0
        L29:
            if (r2 == 0) goto L38
            boolean r1 = r2.self
            if (r1 == 0) goto L31
            int r3 = r3 + r4
            goto L39
        L31:
            ir.eitaa.tgnet.TLRPC$UserStatus r2 = r2.status
            if (r2 == 0) goto L38
            int r3 = r2.expires
            goto L39
        L38:
            r3 = 0
        L39:
            r2 = -1
            r4 = 1
            if (r5 <= 0) goto L46
            if (r3 <= 0) goto L46
            if (r5 <= r3) goto L42
            return r4
        L42:
            if (r5 >= r3) goto L45
            return r2
        L45:
            return r0
        L46:
            if (r5 >= 0) goto L51
            if (r3 >= 0) goto L51
            if (r5 <= r3) goto L4d
            return r4
        L4d:
            if (r5 >= r3) goto L50
            return r2
        L50:
            return r0
        L51:
            if (r5 >= 0) goto L55
            if (r3 > 0) goto L59
        L55:
            if (r5 != 0) goto L5a
            if (r3 == 0) goto L5a
        L59:
            return r2
        L5a:
            if (r3 < 0) goto L60
            if (r5 == 0) goto L5f
            goto L60
        L5f:
            return r0
        L60:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.DialogsAdapter.lambda$sortOnlineContacts$0(ir.eitaa.messenger.MessagesController, int, ir.eitaa.tgnet.TLRPC$TL_contact, ir.eitaa.tgnet.TLRPC$TL_contact):int");
    }

    public void setDialogsListFrozen(boolean frozen) {
        this.dialogsListFrozen = frozen;
    }

    public ViewPager getArchiveHintCellPager() {
        ArchiveHintCell archiveHintCell = this.archiveHintCell;
        if (archiveHintCell != null) {
            return archiveHintCell.getViewPager();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyDataSetChanged() {
        this.hasHints = this.folderId == 0 && this.dialogsType == 0 && !this.isOnlySelect && !MessagesController.getInstance(this.currentAccount).hintDialogs.isEmpty();
        this.hasDialogAd = false;
        if (MessagesController.getInstance(this.currentAccount).dialogAd != null && !this.isForward) {
            this.hasDialogAd = true;
        }
        super.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        View view = holder.itemView;
        if (view instanceof DialogCell) {
            DialogCell dialogCell = (DialogCell) view;
            dialogCell.onReorderStateChanged(this.isReordering, false);
            dialogCell.setDialogIndex(fixPosition(holder.getAdapterPosition()));
            dialogCell.checkCurrentDialogIndex(this.dialogsListFrozen);
            dialogCell.setChecked(this.selectedDialogs.contains(Long.valueOf(dialogCell.getDialogId())), false);
        }
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        int itemViewType = holder.getItemViewType();
        return (itemViewType == 1 || itemViewType == 5 || itemViewType == 3 || itemViewType == 8 || itemViewType == 7 || itemViewType == 9 || itemViewType == 10 || itemViewType == 11) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreateViewHolder$1$DialogsAdapter(View view) {
        MessagesController.getInstance(this.currentAccount).hintDialogs.clear();
        MessagesController.getGlobalMainSettings().edit().remove("installReferer").commit();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View dialogCell;
        View view;
        if (i != 1399) {
            switch (i) {
                case 0:
                    DialogCell dialogCell2 = new DialogCell(this.parentFragment, this.mContext, true, false, this.currentAccount, null);
                    dialogCell2.setArchivedPullAnimation(this.pullForegroundDrawable);
                    dialogCell2.setPreloader(this.preloader);
                    dialogCell = dialogCell2;
                    break;
                case 1:
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(7);
                    dialogCell = flickerLoadingView;
                    break;
                case 2:
                    HeaderCell headerCell = new HeaderCell(this.mContext);
                    headerCell.setText(LocaleController.getString("RecentlyViewed", R.string.RecentlyViewed));
                    TextView textView = new TextView(this.mContext);
                    textView.setTextSize(1, 15.0f);
                    textView.setTypeface(AndroidUtilities.getFontFamily(true));
                    textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
                    textView.setText(LocaleController.getString("RecentlyViewedHide", R.string.RecentlyViewedHide));
                    textView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
                    headerCell.addView(textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, 17.0f, 15.0f, 17.0f, 0.0f));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsAdapter$e8NRgk7_wR-my-ecFu3l34mJsi8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$onCreateViewHolder$1$DialogsAdapter(view2);
                        }
                    });
                    dialogCell = headerCell;
                    break;
                case 3:
                    FrameLayout frameLayout = new FrameLayout(this.mContext) { // from class: ir.eitaa.ui.Adapters.DialogsAdapter.1
                        @Override // android.widget.FrameLayout, android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(12.0f), 1073741824));
                        }
                    };
                    frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
                    View view2 = new View(this.mContext);
                    view2.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    frameLayout.addView(view2, LayoutHelper.createFrame(-1, -1.0f));
                    view = frameLayout;
                    dialogCell = view;
                    break;
                case 4:
                    dialogCell = new DialogMeUrlCell(this.mContext);
                    break;
                case 5:
                    dialogCell = new DialogsEmptyCell(this.mContext);
                    break;
                case 6:
                    dialogCell = new UserCell(this.mContext, 8, 0, false);
                    break;
                case 7:
                    dialogCell = new HeaderCell(this.mContext);
                    break;
                case 8:
                    View shadowSectionCell = new ShadowSectionCell(this.mContext);
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    combinedDrawable.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                    view = shadowSectionCell;
                    dialogCell = view;
                    break;
                case 9:
                    ArchiveHintCell archiveHintCell = this.archiveHintCell;
                    ViewParent parent = archiveHintCell.getParent();
                    dialogCell = archiveHintCell;
                    if (parent != null) {
                        ((ViewGroup) this.archiveHintCell.getParent()).removeView(this.archiveHintCell);
                        dialogCell = archiveHintCell;
                        break;
                    }
                    break;
                case 10:
                    dialogCell = new LastEmptyView(this.mContext);
                    break;
                case 11:
                    View view3 = new TextInfoPrivacyCell(this.mContext) { // from class: ir.eitaa.ui.Adapters.DialogsAdapter.2
                        private long lastUpdateTime;
                        private float moveProgress;
                        private int movement;
                        private int originalX;
                        private int originalY;

                        @Override // ir.eitaa.ui.Cells.TextInfoPrivacyCell
                        protected void afterTextDraw() {
                            if (DialogsAdapter.this.arrowDrawable != null) {
                                Rect bounds = DialogsAdapter.this.arrowDrawable.getBounds();
                                Drawable drawable = DialogsAdapter.this.arrowDrawable;
                                int i2 = this.originalX;
                                drawable.setBounds(i2, this.originalY, bounds.width() + i2, this.originalY + bounds.height());
                            }
                        }

                        @Override // ir.eitaa.ui.Cells.TextInfoPrivacyCell
                        protected void onTextDraw() {
                            if (DialogsAdapter.this.arrowDrawable != null) {
                                Rect bounds = DialogsAdapter.this.arrowDrawable.getBounds();
                                int iDp = (int) (this.moveProgress * AndroidUtilities.dp(3.0f));
                                this.originalX = bounds.left;
                                this.originalY = bounds.top;
                                DialogsAdapter.this.arrowDrawable.setBounds(this.originalX + iDp, this.originalY + AndroidUtilities.dp(1.0f), this.originalX + iDp + bounds.width(), this.originalY + AndroidUtilities.dp(1.0f) + bounds.height());
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                long j = jElapsedRealtime - this.lastUpdateTime;
                                if (j > 17) {
                                    j = 17;
                                }
                                this.lastUpdateTime = jElapsedRealtime;
                                if (this.movement == 0) {
                                    float f = this.moveProgress + (j / 664.0f);
                                    this.moveProgress = f;
                                    if (f >= 1.0f) {
                                        this.movement = 1;
                                        this.moveProgress = 1.0f;
                                    }
                                } else {
                                    float f2 = this.moveProgress - (j / 664.0f);
                                    this.moveProgress = f2;
                                    if (f2 <= 0.0f) {
                                        this.movement = 0;
                                        this.moveProgress = 0.0f;
                                    }
                                }
                                getTextView().invalidate();
                            }
                        }
                    };
                    CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    combinedDrawable2.setFullsize(true);
                    view3.setBackgroundDrawable(combinedDrawable2);
                    view = view3;
                    dialogCell = view;
                    break;
                default:
                    dialogCell = new TextCell(this.mContext);
                    break;
            }
        } else {
            dialogCell = new DialogCell(this.parentFragment, this.mContext, false, false);
        }
        dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, i == 5 ? -1 : -2));
        return new RecyclerListView.Holder(dialogCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        TLRPC$TL_ads_dialogAd tLRPC$TL_ads_dialogAd;
        int itemViewType = viewHolder.getItemViewType();
        TLRPC$Dialog tLRPC$Dialog = null;
        if (itemViewType == 0) {
            DialogCell dialogCell = (DialogCell) viewHolder.itemView;
            TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) getItem(i);
            if (!this.hasDialogAd || this.folderId == 1) {
                tLRPC$TL_ads_dialogAd = null;
            } else if (hasArchive() && i == 0) {
                tLRPC$TL_ads_dialogAd = (TLRPC$TL_ads_dialogAd) getItem(i + 1);
            } else {
                tLRPC$TL_ads_dialogAd = null;
                tLRPC$Dialog = (TLRPC$Dialog) getItem(i + 1);
            }
            dialogCell.useSeparator = (tLRPC$Dialog == null && tLRPC$TL_ads_dialogAd == null) ? false : true;
            if (tLRPC$Dialog != null) {
                dialogCell.fullSeparator = tLRPC$Dialog2.pinned && !tLRPC$Dialog.pinned;
            } else {
                dialogCell.fullSeparator = tLRPC$Dialog2.pinned && tLRPC$TL_ads_dialogAd != null;
            }
            if (this.hasDialogAd && this.folderId != 1 && !hasArchive()) {
                i--;
            }
            if (this.dialogsType == 0 && AndroidUtilities.isTablet()) {
                dialogCell.setDialogSelected(tLRPC$Dialog2.id == this.openedDialogId);
            }
            dialogCell.setChecked(this.selectedDialogs.contains(Long.valueOf(tLRPC$Dialog2.id)), false);
            dialogCell.setDialog(tLRPC$Dialog2, this.dialogsType, this.folderId);
            DialogsPreloader dialogsPreloader = this.preloader;
            if (dialogsPreloader == null || i >= 10) {
                return;
            }
            dialogsPreloader.add(tLRPC$Dialog2.id);
            return;
        }
        if (itemViewType == 1399) {
            DialogCell dialogCell2 = (DialogCell) viewHolder.itemView;
            dialogCell2.useSeparator = true;
            TLRPC$TL_ads_dialogAd tLRPC$TL_ads_dialogAd2 = MessagesController.getInstance(this.currentAccount).dialogAd;
            if (tLRPC$TL_ads_dialogAd2 != null) {
                DialogCell.CustomDialog customDialog = new DialogCell.CustomDialog();
                customDialog.name = tLRPC$TL_ads_dialogAd2.title;
                customDialog.message = tLRPC$TL_ads_dialogAd2.message;
                customDialog.badge = tLRPC$TL_ads_dialogAd2.badge;
                customDialog.id = tLRPC$TL_ads_dialogAd2.id;
                customDialog.unread_count = tLRPC$TL_ads_dialogAd2.unreadCount;
                customDialog.pinnedBackground = tLRPC$TL_ads_dialogAd2.pinnedBackground;
                customDialog.muted = tLRPC$TL_ads_dialogAd2.muted;
                customDialog.type = 0;
                customDialog.date = (int) (System.currentTimeMillis() / 1000);
                customDialog.verified = tLRPC$TL_ads_dialogAd2.verified;
                customDialog.isMedia = false;
                customDialog.sent = false;
                dialogCell2.setContentDescription("تبلیغات" + tLRPC$TL_ads_dialogAd2.title + " " + tLRPC$TL_ads_dialogAd2.message);
                if (!tLRPC$TL_ads_dialogAd2.photos.isEmpty()) {
                    customDialog.photoSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_ads_dialogAd2.photos, 90);
                }
                dialogCell2.setDialog(customDialog, customDialog.message.length() > 100);
                if (MessagesController.getInstance(this.currentAccount).reportedDialogAdId != tLRPC$TL_ads_dialogAd2.id) {
                    MessagesController.getInstance(this.currentAccount).reportedDialogAdId = tLRPC$TL_ads_dialogAd2.id;
                    MessagesController.getInstance(this.currentAccount).addToAdViewsQueue(tLRPC$TL_ads_dialogAd2.id, new TLRPC$TL_ads_inputAdsLocationDialog());
                    return;
                }
                return;
            }
            return;
        }
        if (itemViewType == 4) {
            ((DialogMeUrlCell) viewHolder.itemView).setRecentMeUrl((TLRPC$RecentMeUrl) getItem(i));
            return;
        }
        if (itemViewType == 5) {
            DialogsEmptyCell dialogsEmptyCell = (DialogsEmptyCell) viewHolder.itemView;
            int i2 = this.dialogsType;
            if (i2 == 7 || i2 == 8) {
                if (MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId)) {
                    dialogsEmptyCell.setType(2);
                    return;
                } else {
                    dialogsEmptyCell.setType(3);
                    return;
                }
            }
            dialogsEmptyCell.setType(this.onlineContacts != null ? 1 : 0);
            return;
        }
        if (itemViewType == 6) {
            UserCell userCell = (UserCell) viewHolder.itemView;
            int i3 = this.dialogsCount;
            userCell.setData(MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.onlineContacts.get(i3 == 0 ? i - 3 : (i - i3) - 2).user_id)), null, null, 0);
            return;
        }
        if (itemViewType == 7) {
            HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
            int i4 = this.dialogsType;
            if (i4 != 11 && i4 != 12 && i4 != 13) {
                headerCell.setText(LocaleController.getString("YourContacts", R.string.YourContacts));
                return;
            } else if (i == 0) {
                headerCell.setText(LocaleController.getString("ImportHeader", R.string.ImportHeader));
                return;
            } else {
                headerCell.setText(LocaleController.getString("ImportHeaderContacts", R.string.ImportHeaderContacts));
                return;
            }
        }
        if (itemViewType != 11) {
            if (itemViewType != 12) {
                return;
            }
            TextCell textCell = (TextCell) viewHolder.itemView;
            textCell.setColors("windowBackgroundWhiteBlueText4", "windowBackgroundWhiteBlueText4");
            textCell.setTextAndIcon(LocaleController.getString("CreateGroupForImport", R.string.CreateGroupForImport), R.drawable.groups_create, this.dialogsCount != 0);
            textCell.setIsInDialogs();
            textCell.setOffsetFromImage(75);
            return;
        }
        TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
        textInfoPrivacyCell.setText(LocaleController.getString("TapOnThePencil", R.string.TapOnThePencil));
        if (this.arrowDrawable == null) {
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.arrow_newchat);
            this.arrowDrawable = drawable;
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayText4"), PorterDuff.Mode.MULTIPLY));
        }
        TextView textView = textInfoPrivacyCell.getTextView();
        textView.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.arrowDrawable, (Drawable) null);
        textView.getLayoutParams().width = -2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2;
        if (this.onlineContacts != null) {
            if (this.hasDialogAd && this.folderId != 1) {
                if (i == 0 && !hasArchive()) {
                    return 1399;
                }
                if (i == 1 && hasArchive()) {
                    return 1399;
                }
            }
            int i3 = this.dialogsCount;
            if (i3 == 0 && this.hasDialogAd) {
                if (i == 1) {
                    return 5;
                }
                if (i == 2) {
                    return 8;
                }
                return i == 3 ? 7 : 6;
            }
            if (i3 == 0 && !this.hasDialogAd) {
                if (i == 0) {
                    return 5;
                }
                if (i == 1) {
                    return 8;
                }
                return i == 2 ? 7 : 6;
            }
            if (i < i3) {
                return 0;
            }
            if (i == i3) {
                return 8;
            }
            if (i == i3 + 1) {
                return 7;
            }
            return i == this.currentCount - 1 ? 10 : 6;
        }
        if (this.hasHints) {
            int size = MessagesController.getInstance(this.currentAccount).hintDialogs.size();
            int i4 = size + 2;
            if (i < i4) {
                if (i == 0) {
                    return 2;
                }
                return i == size + 1 ? 3 : 4;
            }
            i -= i4;
        } else {
            if (!this.showArchiveHint) {
                int i5 = this.dialogsType;
                if (i5 == 11 || i5 == 13) {
                    if (i == 0) {
                        return 7;
                    }
                    if (i == 1) {
                        return 12;
                    }
                } else if (i5 == 12) {
                    if (i == 0) {
                        return 7;
                    }
                    i--;
                }
            } else {
                if (i == 0) {
                    return 9;
                }
                if (i == 1) {
                    return 8;
                }
            }
            i -= 2;
        }
        int i6 = this.folderId;
        if (i6 == 0 && this.dialogsCount > 10 && i == this.currentCount - 2 && this.dialogsType == 0) {
            return 11;
        }
        int size2 = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, i6, this.dialogsListFrozen).size();
        boolean z = this.hasDialogAd;
        if (z && this.folderId != 1) {
            size2++;
        }
        if (i == size2) {
            if (this.forceShowEmptyCell || (i2 = this.dialogsType) == 7 || i2 == 8 || MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId)) {
                return size2 == 0 ? 5 : 10;
            }
            return 1;
        }
        if (i > size2) {
            return 10;
        }
        if (z && this.folderId != 1) {
            if (i == 0 && !hasArchive()) {
                return 1399;
            }
            if (i == 1 && hasArchive()) {
                return 1399;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyItemMoved(int fromPosition, int toPosition) {
        ArrayList<TLRPC$Dialog> dialogsArray = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, false);
        int iFixPosition = fixPosition(fromPosition);
        int iFixPosition2 = fixPosition(toPosition);
        TLRPC$Dialog tLRPC$Dialog = dialogsArray.get(iFixPosition);
        TLRPC$Dialog tLRPC$Dialog2 = dialogsArray.get(iFixPosition2);
        int i = this.dialogsType;
        if (i == 7 || i == 8) {
            MessagesController.DialogFilter dialogFilter = MessagesController.getInstance(this.currentAccount).selectedDialogFilter[this.dialogsType == 8 ? (char) 1 : (char) 0];
            int i2 = dialogFilter.pinnedDialogs.get(tLRPC$Dialog.id);
            dialogFilter.pinnedDialogs.put(tLRPC$Dialog.id, dialogFilter.pinnedDialogs.get(tLRPC$Dialog2.id));
            dialogFilter.pinnedDialogs.put(tLRPC$Dialog2.id, i2);
        } else {
            int i3 = tLRPC$Dialog.pinnedNum;
            tLRPC$Dialog.pinnedNum = tLRPC$Dialog2.pinnedNum;
            tLRPC$Dialog2.pinnedNum = i3;
        }
        Collections.swap(dialogsArray, iFixPosition, iFixPosition2);
        super.notifyItemMoved(fromPosition, toPosition);
    }

    public void setArchivedPullDrawable(PullForegroundDrawable drawable) {
        this.pullForegroundDrawable = drawable;
    }

    public void didDatabaseCleared() {
        DialogsPreloader dialogsPreloader = this.preloader;
        if (dialogsPreloader != null) {
            dialogsPreloader.clear();
        }
    }

    public void resume() {
        DialogsPreloader dialogsPreloader = this.preloader;
        if (dialogsPreloader != null) {
            dialogsPreloader.resume();
        }
    }

    public void pause() {
        DialogsPreloader dialogsPreloader = this.preloader;
        if (dialogsPreloader != null) {
            dialogsPreloader.pause();
        }
    }

    public static class DialogsPreloader {
        int currentRequestCount;
        int networkRequestCount;
        boolean resumed;
        private final int MAX_REQUEST_COUNT = 4;
        private final int MAX_NETWORK_REQUEST_COUNT = 6;
        private final int NETWORK_REQUESTS_RESET_TIME = 60000;
        HashSet<Long> dialogsReadyMap = new HashSet<>();
        HashSet<Long> preloadedErrorMap = new HashSet<>();
        HashSet<Long> loadingDialogs = new HashSet<>();
        ArrayList<Long> preloadDialogsPool = new ArrayList<>();
        Runnable clearNetworkRequestCount = new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsAdapter$DialogsPreloader$32PraSKg5meqpWYRcRhUPC0_Ii4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$DialogsAdapter$DialogsPreloader();
            }
        };

        private boolean preloadIsAvilable() {
            return false;
        }

        public void updateList() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$DialogsAdapter$DialogsPreloader() {
            this.networkRequestCount = 0;
            start();
        }

        public void add(long dialog_id) {
            if (isReady(dialog_id) || this.preloadedErrorMap.contains(Long.valueOf(dialog_id)) || this.loadingDialogs.contains(Long.valueOf(dialog_id)) || this.preloadDialogsPool.contains(Long.valueOf(dialog_id))) {
                return;
            }
            this.preloadDialogsPool.add(Long.valueOf(dialog_id));
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            if (!preloadIsAvilable() || !this.resumed || this.preloadDialogsPool.isEmpty() || this.currentRequestCount >= 4 || this.networkRequestCount > 6) {
                return;
            }
            long jLongValue = this.preloadDialogsPool.remove(0).longValue();
            this.currentRequestCount++;
            this.loadingDialogs.add(Long.valueOf(jLongValue));
            MessagesController.getInstance(UserConfig.selectedAccount).ensureMessagesLoaded(jLongValue, 0, new AnonymousClass1(jLongValue));
        }

        /* renamed from: ir.eitaa.ui.Adapters.DialogsAdapter$DialogsPreloader$1, reason: invalid class name */
        class AnonymousClass1 implements MessagesController.MessagesLoadedCallback {
            final /* synthetic */ long val$dialog_id;

            AnonymousClass1(final long val$dialog_id) {
                this.val$dialog_id = val$dialog_id;
            }

            @Override // ir.eitaa.messenger.MessagesController.MessagesLoadedCallback
            public void onMessagesLoaded(final boolean fromCache) {
                final long j = this.val$dialog_id;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsAdapter$DialogsPreloader$1$IWsRNoIYrZfgCNEBXk965uKsmIE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMessagesLoaded$0$DialogsAdapter$DialogsPreloader$1(fromCache, j);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onMessagesLoaded$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onMessagesLoaded$0$DialogsAdapter$DialogsPreloader$1(boolean z, long j) {
                if (!z) {
                    DialogsPreloader dialogsPreloader = DialogsPreloader.this;
                    int i = dialogsPreloader.networkRequestCount + 1;
                    dialogsPreloader.networkRequestCount = i;
                    if (i >= 6) {
                        AndroidUtilities.cancelRunOnUIThread(dialogsPreloader.clearNetworkRequestCount);
                        AndroidUtilities.runOnUIThread(DialogsPreloader.this.clearNetworkRequestCount, 60000L);
                    }
                }
                if (DialogsPreloader.this.loadingDialogs.remove(Long.valueOf(j))) {
                    DialogsPreloader.this.dialogsReadyMap.add(Long.valueOf(j));
                    DialogsPreloader.this.updateList();
                    r3.currentRequestCount--;
                    DialogsPreloader.this.start();
                }
            }

            @Override // ir.eitaa.messenger.MessagesController.MessagesLoadedCallback
            public void onError() {
                final long j = this.val$dialog_id;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsAdapter$DialogsPreloader$1$m1h_QJD_9hUCaLvOLzRacFGZXX8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$1$DialogsAdapter$DialogsPreloader$1(j);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onError$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onError$1$DialogsAdapter$DialogsPreloader$1(long j) {
                if (DialogsPreloader.this.loadingDialogs.remove(Long.valueOf(j))) {
                    DialogsPreloader.this.preloadedErrorMap.add(Long.valueOf(j));
                    r3.currentRequestCount--;
                    DialogsPreloader.this.start();
                }
            }
        }

        public boolean isReady(long currentDialogId) {
            return this.dialogsReadyMap.contains(Long.valueOf(currentDialogId));
        }

        public void remove(long currentDialogId) {
            this.preloadDialogsPool.remove(Long.valueOf(currentDialogId));
        }

        public void clear() {
            this.dialogsReadyMap.clear();
            this.preloadedErrorMap.clear();
            this.loadingDialogs.clear();
            this.preloadDialogsPool.clear();
            this.currentRequestCount = 0;
            this.networkRequestCount = 0;
            AndroidUtilities.cancelRunOnUIThread(this.clearNetworkRequestCount);
            updateList();
        }

        public void resume() {
            this.resumed = true;
            start();
        }

        public void pause() {
            this.resumed = false;
        }
    }

    public int getCurrentCount() {
        return this.currentCount;
    }

    public void setForceShowEmptyCell(boolean forceShowEmptyCell) {
        this.forceShowEmptyCell = forceShowEmptyCell;
    }

    public class LastEmptyView extends View {
        public boolean moving;

        public LastEmptyView(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = DialogsAdapter.this.parentFragment.getDialogsArray(DialogsAdapter.this.currentAccount, DialogsAdapter.this.dialogsType, DialogsAdapter.this.folderId, DialogsAdapter.this.dialogsListFrozen).size();
            int i = 0;
            boolean z = DialogsAdapter.this.dialogsType == 0 && MessagesController.getInstance(DialogsAdapter.this.currentAccount).dialogs_dict.get(DialogObject.makeFolderDialogId(1)) != null;
            View view = (View) getParent();
            int paddingTop = view.getPaddingTop();
            if (size != 0 && (paddingTop != 0 || z)) {
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                if (size2 == 0) {
                    size2 = view.getMeasuredHeight();
                }
                if (size2 == 0) {
                    size2 = (AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
                }
                int iDp = AndroidUtilities.dp(SharedConfig.useThreeLinesLayout ? 78.0f : 72.0f);
                int size3 = (size * iDp) + (size - 1);
                if (DialogsAdapter.this.onlineContacts != null) {
                    size3 += (DialogsAdapter.this.onlineContacts.size() * AndroidUtilities.dp(58.0f)) + (DialogsAdapter.this.onlineContacts.size() - 1) + AndroidUtilities.dp(52.0f);
                }
                int i2 = z ? iDp + 1 : 0;
                if (size3 < size2) {
                    int i3 = (size2 - size3) + i2;
                    if (paddingTop == 0 || (i3 = i3 - AndroidUtilities.statusBarHeight) >= 0) {
                        i = i3;
                    }
                } else {
                    int i4 = size3 - size2;
                    if (i4 < i2) {
                        int i5 = i2 - i4;
                        if (paddingTop != 0) {
                            i5 -= AndroidUtilities.statusBarHeight;
                        }
                        if (i5 >= 0) {
                            i = i5;
                        }
                    }
                }
            }
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), i);
        }
    }

    public boolean hasArchive() {
        return this.dialogsType == 0 && MessagesController.getInstance(this.currentAccount).dialogs_dict.get(DialogObject.makeFolderDialogId(1)) != null;
    }
}
