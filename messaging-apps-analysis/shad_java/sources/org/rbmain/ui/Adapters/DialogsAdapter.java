package org.rbmain.ui.Adapters;

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
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.utilites.ChatConverter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$RecentMeUrl;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ArchiveHintCell;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Cells.DialogMeUrlCell;
import org.rbmain.ui.Cells.DialogsEmptyCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PullForegroundDrawable;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes4.dex */
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
    private boolean hasHints;
    private boolean isOnlySelect;
    private boolean isReordering;
    private long lastSortTime;
    private Context mContext;
    private ArrayList<TLRPC$TL_contact> onlineContacts;
    private long openedDialogId;
    private DialogsActivity parentFragment;
    private DialogsPreloader preloader;
    private int prevContactsCount;
    private int prevDialogsCount;
    private PullForegroundDrawable pullForegroundDrawable;
    private ArrayList<Long> selectedDialogs;
    private boolean showArchiveHint;

    public DialogsAdapter(DialogsActivity dialogsActivity, Context context, int i, int i2, boolean z, ArrayList<Long> arrayList, int i3) {
        this.mContext = context;
        this.parentFragment = dialogsActivity;
        this.dialogsType = i;
        this.folderId = i2;
        this.isOnlySelect = z;
        this.hasHints = i2 == 0 && i == 0 && !z;
        this.selectedDialogs = arrayList;
        this.currentAccount = i3;
        if (i2 == 1) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            this.showArchiveHint = globalMainSettings.getBoolean("archivehint", true);
            globalMainSettings.edit().putBoolean("archivehint", false).apply();
            if (this.showArchiveHint) {
                this.archiveHintCell = new ArchiveHintCell(context);
            }
        }
        if (i2 == 0) {
            this.preloader = new DialogsPreloader();
        }
    }

    public void setOpenedDialogId(long j) {
        this.openedDialogId = j;
    }

    public void onReorderStateChanged(boolean z) {
        this.isReordering = z;
    }

    public int fixPosition(int i) {
        int i2;
        if (this.hasHints) {
            i -= MessagesController.getInstance(this.currentAccount).hintDialogs.size() + 2;
        }
        return (this.showArchiveHint || (i2 = this.dialogsType) == 11 || i2 == 13) ? i - 2 : i2 == 12 ? i - 1 : i;
    }

    public boolean isDataSetChanged() {
        int i = this.currentCount;
        return i != getItemCount() || i == 1;
    }

    public void setDialogsType(int i) {
        this.dialogsType = i;
        notifyDataSetChanged();
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
        boolean z = false;
        if (!this.forceShowEmptyCell && (i3 = this.dialogsType) != 7 && i3 != 8 && i3 != 11 && size == 0 && ((i4 = this.folderId) != 0 || messagesController.isLoadingDialogs(i4) || !MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId))) {
            this.onlineContacts = null;
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
        } else if (this.dialogsType == 0 && messagesController.dialogs_dict.size() <= 10 && (i = this.folderId) == 0 && messagesController.isDialogsEndReached(i)) {
            if (ContactsController.getInstance(this.currentAccount).contacts.isEmpty() && ContactsController.getInstance(this.currentAccount).isLoadingContacts()) {
                this.onlineContacts = null;
                this.currentCount = 0;
                return 0;
            }
            if (!ContactsController.getInstance(this.currentAccount).contacts.isEmpty()) {
                if (this.onlineContacts == null || this.prevDialogsCount != messagesController.dialogs_dict.size() || this.prevContactsCount != ContactsController.getInstance(this.currentAccount).contacts.size()) {
                    ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>(ContactsController.getInstance(this.currentAccount).contacts);
                    this.onlineContacts = arrayList;
                    this.prevContactsCount = arrayList.size();
                    this.prevDialogsCount = messagesController.dialogs_dict.size();
                    int i6 = UserConfig.getInstance(this.currentAccount).clientUserId;
                    int size3 = this.onlineContacts.size();
                    int i7 = 0;
                    while (i7 < size3) {
                        int i8 = this.onlineContacts.get(i7).user_id;
                        if (i8 == i6 || messagesController.dialogs_dict.get(i8) != null) {
                            this.onlineContacts.remove(i7);
                            i7--;
                            size3--;
                        }
                        i7++;
                    }
                    if (this.onlineContacts.isEmpty()) {
                        this.onlineContacts = null;
                    }
                    sortOnlineContacts(false);
                }
                ArrayList<TLRPC$TL_contact> arrayList2 = this.onlineContacts;
                if (arrayList2 != null) {
                    size2 += arrayList2.size() + 2;
                    z = true;
                }
            }
        }
        int i9 = this.folderId;
        if (i9 == 0 && this.onlineContacts != null && !z) {
            this.onlineContacts = null;
        }
        if (i9 == 1 && this.showArchiveHint) {
            size2 += 2;
        }
        if (i9 == 0 && (i2 = this.dialogsCount) != 0) {
            size2++;
            if (i2 > 10 && this.dialogsType == 0) {
                size2++;
            }
        }
        int i10 = this.dialogsType;
        if (i10 == 11 || i10 == 13) {
            size2 += 2;
        } else if (i10 == 12) {
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
            return MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.onlineContacts.get(i4).user_id));
        }
        if (this.showArchiveHint || (i2 = this.dialogsType) == 11 || i2 == 13) {
            i -= 2;
        } else if (i2 == 12) {
            i--;
        }
        ArrayList<TLRPC$Dialog> dialogsArray = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, this.dialogsListFrozen);
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

    public void sortOnlineContacts(boolean z) {
        if (this.onlineContacts != null) {
            if (!z || SystemClock.elapsedRealtime() - this.lastSortTime >= 2000) {
                this.lastSortTime = SystemClock.elapsedRealtime();
                try {
                    final int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
                    final MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
                    Collections.sort(this.onlineContacts, new Comparator() { // from class: org.rbmain.ui.Adapters.DialogsAdapter$$ExternalSyntheticLambda1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return DialogsAdapter.lambda$sortOnlineContacts$0(messagesController, currentTime, (TLRPC$TL_contact) obj, (TLRPC$TL_contact) obj2);
                        }
                    });
                    if (z) {
                        notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ int lambda$sortOnlineContacts$0(org.rbmain.messenger.MessagesController r2, int r3, org.rbmain.tgnet.TLRPC$TL_contact r4, org.rbmain.tgnet.TLRPC$TL_contact r5) {
        /*
            int r5 = r5.user_id
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            org.rbmain.tgnet.TLRPC$User r5 = r2.getUser(r5)
            int r4 = r4.user_id
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            org.rbmain.tgnet.TLRPC$User r2 = r2.getUser(r4)
            r4 = 50000(0xc350, float:7.0065E-41)
            r0 = 0
            if (r5 == 0) goto L28
            boolean r1 = r5.self
            if (r1 == 0) goto L21
            int r5 = r3 + r4
            goto L29
        L21:
            org.rbmain.tgnet.TLRPC$UserStatus r5 = r5.status
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
            org.rbmain.tgnet.TLRPC$UserStatus r2 = r2.status
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Adapters.DialogsAdapter.lambda$sortOnlineContacts$0(org.rbmain.messenger.MessagesController, int, org.rbmain.tgnet.TLRPC$TL_contact, org.rbmain.tgnet.TLRPC$TL_contact):int");
    }

    public void setDialogsListFrozen(boolean z) {
        this.dialogsListFrozen = z;
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
        super.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view instanceof DialogCell) {
            DialogCell dialogCell = (DialogCell) view;
            dialogCell.onReorderStateChanged(this.isReordering, false);
            dialogCell.setDialogIndex(fixPosition(viewHolder.getAdapterPosition()));
            dialogCell.checkCurrentDialogIndex(this.dialogsListFrozen);
            dialogCell.setChecked(this.selectedDialogs.contains(Long.valueOf(dialogCell.getDialogId())), false);
        }
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return (itemViewType == 1 || itemViewType == 5 || itemViewType == 3 || itemViewType == 8 || itemViewType == 7 || itemViewType == 9 || itemViewType == 10 || itemViewType == 11) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
        MessagesController.getInstance(this.currentAccount).hintDialogs.clear();
        MessagesController.getGlobalMainSettings().edit().remove("installReferer").apply();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View dialogMeUrlCell;
        switch (i) {
            case 0:
                DialogCell dialogCell = new DialogCell(this.parentFragment, this.mContext, true, false, this.currentAccount);
                dialogCell.setArchivedPullAnimation(this.pullForegroundDrawable);
                dialogCell.setPreloader(this.preloader);
                dialogMeUrlCell = dialogCell;
                break;
            case 1:
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(7);
                dialogMeUrlCell = flickerLoadingView;
                break;
            case 2:
                HeaderCell headerCell = new HeaderCell(this.mContext);
                headerCell.setText(LocaleController.getString("RecentlyViewed", R.string.RecentlyViewed));
                TextView textView = new TextView(this.mContext);
                textView.setTextSize(1, 15.0f);
                textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueHeader));
                textView.setText(LocaleController.getString("RecentlyViewedHide", R.string.RecentlyViewedHide));
                textView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
                headerCell.addView(textView, LayoutHelper.createFrame(-1, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, 17.0f, 15.0f, 17.0f, 0.0f));
                textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Adapters.DialogsAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$1(view);
                    }
                });
                dialogMeUrlCell = headerCell;
                break;
            case 3:
                FrameLayout frameLayout = new FrameLayout(this, this.mContext) { // from class: org.rbmain.ui.Adapters.DialogsAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i2, int i3) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(12.0f), 1073741824));
                    }
                };
                frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
                View view = new View(this.mContext);
                view.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f));
                dialogMeUrlCell = frameLayout;
                break;
            case 4:
                dialogMeUrlCell = new DialogMeUrlCell(this.mContext);
                break;
            case 5:
                dialogMeUrlCell = new DialogsEmptyCell(this.mContext);
                break;
            case 6:
                dialogMeUrlCell = new UserCell(this.mContext, 8, 0, false);
                break;
            case 7:
                dialogMeUrlCell = new HeaderCell(this.mContext);
                break;
            case 8:
                View shadowSectionCell = new ShadowSectionCell(this.mContext);
                CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                combinedDrawable.setFullsize(true);
                shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                dialogMeUrlCell = shadowSectionCell;
                break;
            case 9:
                ArchiveHintCell archiveHintCell = this.archiveHintCell;
                ViewParent parent = archiveHintCell.getParent();
                dialogMeUrlCell = archiveHintCell;
                if (parent != null) {
                    ((ViewGroup) this.archiveHintCell.getParent()).removeView(this.archiveHintCell);
                    dialogMeUrlCell = archiveHintCell;
                    break;
                }
                break;
            case 10:
                dialogMeUrlCell = new LastEmptyView(this.mContext);
                break;
            case 11:
                View view2 = new TextInfoPrivacyCell(this.mContext) { // from class: org.rbmain.ui.Adapters.DialogsAdapter.2
                    private long lastUpdateTime;
                    private float moveProgress;
                    private int movement;
                    private int x;
                    private int y;

                    @Override // org.rbmain.ui.Cells.TextInfoPrivacyCell
                    protected void onTextDraw() {
                        if (DialogsAdapter.this.arrowDrawable != null) {
                            Rect bounds = DialogsAdapter.this.arrowDrawable.getBounds();
                            int iDp = (int) (this.moveProgress * AndroidUtilities.dp(3.0f));
                            DialogsAdapter.this.arrowDrawable.setBounds(this.x + iDp, this.y + AndroidUtilities.dp(1.0f), this.x + iDp + bounds.width(), this.y + AndroidUtilities.dp(1.0f) + bounds.height());
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

                    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                        super.onLayout(z, i2, i3, i4, i5);
                        if (DialogsAdapter.this.arrowDrawable != null) {
                            this.x = DialogsAdapter.this.arrowDrawable.getBounds().left;
                            this.y = DialogsAdapter.this.arrowDrawable.getBounds().top;
                        }
                    }
                };
                CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                combinedDrawable2.setFullsize(true);
                view2.setBackgroundDrawable(combinedDrawable2);
                dialogMeUrlCell = view2;
                break;
            default:
                dialogMeUrlCell = new TextCell(this.mContext);
                break;
        }
        dialogMeUrlCell.setLayoutParams(new RecyclerView.LayoutParams(-1, i == 5 ? -1 : -2));
        return new RecyclerListView.Holder(dialogMeUrlCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            DialogCell dialogCell = (DialogCell) viewHolder.itemView;
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) getItem(i);
            TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) getItem(i + 1);
            dialogCell.useSeparator = tLRPC$Dialog2 != null;
            dialogCell.fullSeparator = (!tLRPC$Dialog.pinned || tLRPC$Dialog2 == null || tLRPC$Dialog2.pinned) ? false : true;
            if (this.dialogsType == 0 && AndroidUtilities.isTablet()) {
                dialogCell.setDialogSelected(tLRPC$Dialog.id == this.openedDialogId);
            }
            dialogCell.setChecked(this.selectedDialogs.contains(Long.valueOf(tLRPC$Dialog.id)), false);
            if (DialogObject.isAdsDialog(tLRPC$Dialog)) {
                dialogCell.setDialog(ChatConverter.createAdDialog(tLRPC$Dialog));
                DialogsProxy.getInstance(this.currentAccount).onAdsAction(tLRPC$Dialog.id, 2);
            } else {
                dialogCell.setDialog(tLRPC$Dialog, this.dialogsType, this.folderId);
            }
            DialogsPreloader dialogsPreloader = this.preloader;
            if (dialogsPreloader == null || i >= 10) {
                return;
            }
            dialogsPreloader.add(tLRPC$Dialog.id);
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
            dialogsEmptyCell.setType(this.onlineContacts == null ? 0 : 1);
            return;
        }
        if (itemViewType == 6) {
            UserCell userCell = (UserCell) viewHolder.itemView;
            int i3 = this.dialogsCount;
            int i4 = i3 == 0 ? i - 3 : (i - i3) - 2;
            FirebaseCrashlytics.getInstance().setCustomKey("dialogsAdapter", " dialogsCount " + this.dialogsCount);
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(" onlineContacts: ");
            ArrayList<TLRPC$TL_contact> arrayList = this.onlineContacts;
            sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : "null");
            firebaseCrashlytics.setCustomKey("dialogsAdapter2", sb.toString());
            userCell.setData(MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.onlineContacts.get(i4).user_id)), null, null, 0);
            return;
        }
        if (itemViewType == 7) {
            HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
            int i5 = this.dialogsType;
            if (i5 != 11 && i5 != 12 && i5 != 13) {
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
            int i6 = Theme.key_windowBackgroundWhiteBlueText4;
            textCell.setColors(i6, i6);
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
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText4), PorterDuff.Mode.MULTIPLY));
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
            int i3 = this.dialogsCount;
            if (i3 == 0) {
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
        if (i != size2) {
            return i > size2 ? 10 : 0;
        }
        if (this.forceShowEmptyCell || (i2 = this.dialogsType) == 7 || i2 == 8 || MessagesController.getInstance(this.currentAccount).isDialogsEndReached(this.folderId)) {
            return size2 == 0 ? 5 : 10;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyItemMoved(int i, int i2) {
        ArrayList<TLRPC$Dialog> dialogsArray = this.parentFragment.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, false);
        int iFixPosition = fixPosition(i);
        int iFixPosition2 = fixPosition(i2);
        TLRPC$Dialog tLRPC$Dialog = dialogsArray.get(iFixPosition);
        TLRPC$Dialog tLRPC$Dialog2 = dialogsArray.get(iFixPosition2);
        int i3 = this.dialogsType;
        if (i3 == 7 || i3 == 8) {
            MessagesController.DialogFilter dialogFilter = MessagesController.getInstance(this.currentAccount).selectedDialogFilter[this.dialogsType == 8 ? (char) 1 : (char) 0];
            int iIntValue = dialogFilter.pinnedDialogs.get(tLRPC$Dialog.id).intValue();
            dialogFilter.pinnedDialogs.put(tLRPC$Dialog.id, Integer.valueOf(dialogFilter.pinnedDialogs.get(tLRPC$Dialog2.id).intValue()));
            dialogFilter.pinnedDialogs.put(tLRPC$Dialog2.id, Integer.valueOf(iIntValue));
        } else {
            int i4 = tLRPC$Dialog.pinnedNum;
            tLRPC$Dialog.pinnedNum = tLRPC$Dialog2.pinnedNum;
            tLRPC$Dialog2.pinnedNum = i4;
        }
        Collections.swap(dialogsArray, iFixPosition, iFixPosition2);
        super.notifyItemMoved(i, i2);
    }

    public void setArchivedPullDrawable(PullForegroundDrawable pullForegroundDrawable) {
        this.pullForegroundDrawable = pullForegroundDrawable;
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
        HashSet<Long> dialogsReadyMap = new HashSet<>();
        HashSet<Long> preloadedErrorMap = new HashSet<>();
        HashSet<Long> loadingDialogs = new HashSet<>();
        ArrayList<Long> preloadDialogsPool = new ArrayList<>();
        Runnable clearNetworkRequestCount = new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsAdapter$DialogsPreloader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };

        private boolean preloadIsAvilable() {
            return false;
        }

        public void updateList() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            this.networkRequestCount = 0;
            start();
        }

        public void add(long j) {
            if (isReady(j) || this.preloadedErrorMap.contains(Long.valueOf(j)) || this.loadingDialogs.contains(Long.valueOf(j)) || this.preloadDialogsPool.contains(Long.valueOf(j))) {
                return;
            }
            this.preloadDialogsPool.add(Long.valueOf(j));
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
            MessagesController.getInstance(UserConfig.selectedAccount).ensureMessagesLoaded(jLongValue, 0L, new AnonymousClass1(jLongValue));
        }

        /* renamed from: org.rbmain.ui.Adapters.DialogsAdapter$DialogsPreloader$1, reason: invalid class name */
        class AnonymousClass1 implements MessagesController.MessagesLoadedCallback {
            final /* synthetic */ long val$dialog_id;

            AnonymousClass1(long j) {
                this.val$dialog_id = j;
            }

            @Override // org.rbmain.messenger.MessagesController.MessagesLoadedCallback
            public void onMessagesLoaded(final boolean z) {
                final long j = this.val$dialog_id;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsAdapter$DialogsPreloader$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMessagesLoaded$0(z, j);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onMessagesLoaded$0(boolean z, long j) {
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

            @Override // org.rbmain.messenger.MessagesController.MessagesLoadedCallback
            public void onError() {
                final long j = this.val$dialog_id;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsAdapter$DialogsPreloader$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$1(j);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onError$1(long j) {
                if (DialogsPreloader.this.loadingDialogs.remove(Long.valueOf(j))) {
                    DialogsPreloader.this.preloadedErrorMap.add(Long.valueOf(j));
                    r3.currentRequestCount--;
                    DialogsPreloader.this.start();
                }
            }
        }

        public boolean isReady(long j) {
            return this.dialogsReadyMap.contains(Long.valueOf(j));
        }

        public void remove(long j) {
            this.preloadDialogsPool.remove(Long.valueOf(j));
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

    public void setForceShowEmptyCell(boolean z) {
        this.forceShowEmptyCell = z;
    }

    public class LastEmptyView extends View {
        public boolean moving;

        public LastEmptyView(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size = DialogsAdapter.this.parentFragment.getDialogsArray(DialogsAdapter.this.currentAccount, DialogsAdapter.this.dialogsType, DialogsAdapter.this.folderId, DialogsAdapter.this.dialogsListFrozen).size();
            int i3 = 0;
            boolean z = DialogsAdapter.this.dialogsType == 0 && MessagesController.getInstance(DialogsAdapter.this.currentAccount).dialogs_dict.get(DialogObject.makeFolderDialogId(1)) != null;
            View view = (View) getParent();
            int paddingTop = view.getPaddingTop();
            if (size != 0 && (paddingTop != 0 || z)) {
                int size2 = View.MeasureSpec.getSize(i2);
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
                int i4 = z ? iDp + 1 : 0;
                if (size3 < size2) {
                    int i5 = (size2 - size3) + i4;
                    if (paddingTop == 0 || (i5 = i5 - AndroidUtilities.statusBarHeight) >= 0) {
                        i3 = i5;
                    }
                } else {
                    int i6 = size3 - size2;
                    if (i6 < i4) {
                        int i7 = i4 - i6;
                        if (paddingTop != 0) {
                            i7 -= AndroidUtilities.statusBarHeight;
                        }
                        if (i7 >= 0) {
                            i3 = i7;
                        }
                    }
                }
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i), i3);
        }
    }
}
