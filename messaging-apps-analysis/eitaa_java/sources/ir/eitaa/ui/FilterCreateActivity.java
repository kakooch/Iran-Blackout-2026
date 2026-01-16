package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$TL_dialogFilter;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFilter;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.PollEditTextCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.FilterUsersActivity;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class FilterCreateActivity extends BaseFragment {
    private ListAdapter adapter;
    private boolean creatingNew;
    private ActionBarMenuItem doneItem;
    private int excludeAddRow;
    private int excludeArchivedRow;
    private int excludeEndRow;
    private boolean excludeExpanded;
    private int excludeHeaderRow;
    private int excludeMutedRow;
    private int excludeReadRow;
    private int excludeSectionRow;
    private int excludeShowMoreRow;
    private int excludeStartRow;
    private MessagesController.DialogFilter filter;
    private boolean hasUserChanged;
    private int imageRow;
    private int includeAddRow;
    private int includeAdminRow;
    private int includeBotsRow;
    private int includeChannelsRow;
    private int includeContactsRow;
    private int includeEndRow;
    private boolean includeExpanded;
    private int includeFavoriteRow;
    private int includeGroupsRow;
    private int includeHeaderRow;
    private int includeMediaChannelRow;
    private int includeNonContactsRow;
    private int includeSectionRow;
    private int includeShowMoreRow;
    private int includeStartRow;
    private RecyclerListView listView;
    private boolean nameChangedManually;
    private int namePreSectionRow;
    private int nameRow;
    private int nameSectionRow;
    private ArrayList<Long> newAlwaysShow;
    private int newFilterFlags;
    private String newFilterName;
    private ArrayList<Long> newNeverShow;
    private LongSparseIntArray newPinned;
    private int removeRow;
    private int removeSectionRow;
    private int rowCount;

    public static class HintInnerCell extends FrameLayout {
        private RLottieImageView imageView;

        public HintInnerCell(Context context) {
            super(context);
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setAnimation(R.raw.filter_new, 100, 100);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.playAnimation();
            addView(this.imageView, LayoutHelper.createFrame(100, 100.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$HintInnerCell$Kgd_u795ySYh3ml08A8-AhsLi3Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$FilterCreateActivity$HintInnerCell(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$FilterCreateActivity$HintInnerCell(View view) {
            if (this.imageView.isPlaying()) {
                return;
            }
            this.imageView.setProgress(0.0f);
            this.imageView.playAnimation();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(156.0f), 1073741824));
        }
    }

    public FilterCreateActivity() {
        this(null, null);
    }

    public FilterCreateActivity(MessagesController.DialogFilter dialogFilter) {
        this(dialogFilter, null);
    }

    public FilterCreateActivity(MessagesController.DialogFilter dialogFilter, ArrayList<Long> alwaysShow) {
        this.includeBotsRow = -1;
        this.rowCount = 0;
        this.filter = dialogFilter;
        if (dialogFilter == null) {
            MessagesController.DialogFilter dialogFilter2 = new MessagesController.DialogFilter();
            this.filter = dialogFilter2;
            dialogFilter2.id = 2;
            while (getMessagesController().dialogFiltersById.get(this.filter.id) != null) {
                this.filter.id++;
            }
            this.filter.name = "";
            this.creatingNew = true;
        }
        MessagesController.DialogFilter dialogFilter3 = this.filter;
        this.newFilterName = dialogFilter3.name;
        this.newFilterFlags = dialogFilter3.flags;
        ArrayList<Long> arrayList = new ArrayList<>(this.filter.alwaysShow);
        this.newAlwaysShow = arrayList;
        if (alwaysShow != null) {
            arrayList.addAll(alwaysShow);
        }
        this.newNeverShow = new ArrayList<>(this.filter.neverShow);
        this.newPinned = this.filter.pinnedDialogs.m16clone();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        updateRows();
        return super.onFragmentCreate();
    }

    private void updateRows() {
        this.rowCount = 0;
        if (this.creatingNew) {
            this.rowCount = 0 + 1;
            this.imageRow = 0;
            this.namePreSectionRow = -1;
        } else {
            this.imageRow = -1;
            this.rowCount = 0 + 1;
            this.namePreSectionRow = 0;
        }
        int i = this.rowCount;
        int i2 = i + 1;
        this.rowCount = i2;
        this.nameRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.nameSectionRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.includeHeaderRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.includeAddRow = i4;
        int i6 = this.newFilterFlags;
        if ((MessagesController.DIALOG_FILTER_FLAG_CONTACTS & i6) != 0) {
            this.rowCount = i5 + 1;
            this.includeContactsRow = i5;
        } else {
            this.includeContactsRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS & i6) != 0) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            this.includeNonContactsRow = i7;
        } else {
            this.includeNonContactsRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_GROUPS & i6) != 0) {
            int i8 = this.rowCount;
            this.rowCount = i8 + 1;
            this.includeGroupsRow = i8;
        } else {
            this.includeGroupsRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_CHANNELS & i6) != 0) {
            int i9 = this.rowCount;
            this.rowCount = i9 + 1;
            this.includeChannelsRow = i9;
        } else {
            this.includeChannelsRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL & i6) != 0) {
            int i10 = this.rowCount;
            this.rowCount = i10 + 1;
            this.includeMediaChannelRow = i10;
        } else {
            this.includeMediaChannelRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_ADMIN & i6) != 0) {
            int i11 = this.rowCount;
            this.rowCount = i11 + 1;
            this.includeAdminRow = i11;
        } else {
            this.includeAdminRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_FAVORITE & i6) != 0) {
            int i12 = this.rowCount;
            this.rowCount = i12 + 1;
            this.includeFavoriteRow = i12;
        } else {
            this.includeFavoriteRow = -1;
        }
        if (!this.newAlwaysShow.isEmpty()) {
            this.includeStartRow = this.rowCount;
            int size = (this.includeExpanded || this.newAlwaysShow.size() < 8) ? this.newAlwaysShow.size() : Math.min(5, this.newAlwaysShow.size());
            int i13 = this.rowCount + size;
            this.rowCount = i13;
            this.includeEndRow = i13;
            if (size != this.newAlwaysShow.size()) {
                int i14 = this.rowCount;
                this.rowCount = i14 + 1;
                this.includeShowMoreRow = i14;
            } else {
                this.includeShowMoreRow = -1;
            }
        } else {
            this.includeStartRow = -1;
            this.includeEndRow = -1;
            this.includeShowMoreRow = -1;
        }
        int i15 = this.rowCount;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.includeSectionRow = i15;
        int i17 = i16 + 1;
        this.rowCount = i17;
        this.excludeHeaderRow = i16;
        int i18 = i17 + 1;
        this.rowCount = i18;
        this.excludeAddRow = i17;
        int i19 = this.newFilterFlags;
        if ((MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED & i19) != 0) {
            this.rowCount = i18 + 1;
            this.excludeMutedRow = i18;
        } else {
            this.excludeMutedRow = -1;
        }
        if ((MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ & i19) != 0) {
            int i20 = this.rowCount;
            this.rowCount = i20 + 1;
            this.excludeReadRow = i20;
        } else {
            this.excludeReadRow = -1;
        }
        if ((i19 & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED) != 0) {
            int i21 = this.rowCount;
            this.rowCount = i21 + 1;
            this.excludeArchivedRow = i21;
        } else {
            this.excludeArchivedRow = -1;
        }
        if (!this.newNeverShow.isEmpty()) {
            this.excludeStartRow = this.rowCount;
            int size2 = (this.excludeExpanded || this.newNeverShow.size() < 8) ? this.newNeverShow.size() : Math.min(5, this.newNeverShow.size());
            int i22 = this.rowCount + size2;
            this.rowCount = i22;
            this.excludeEndRow = i22;
            if (size2 != this.newNeverShow.size()) {
                int i23 = this.rowCount;
                this.rowCount = i23 + 1;
                this.excludeShowMoreRow = i23;
            } else {
                this.excludeShowMoreRow = -1;
            }
        } else {
            this.excludeStartRow = -1;
            this.excludeEndRow = -1;
            this.excludeShowMoreRow = -1;
        }
        int i24 = this.rowCount;
        int i25 = i24 + 1;
        this.rowCount = i25;
        this.excludeSectionRow = i24;
        if (!this.creatingNew) {
            int i26 = i25 + 1;
            this.rowCount = i26;
            this.removeRow = i25;
            this.rowCount = i26 + 1;
            this.removeSectionRow = i26;
        } else {
            this.removeRow = -1;
            this.removeSectionRow = -1;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        if (this.creatingNew) {
            this.actionBar.setTitle(LocaleController.getString("FilterNew", R.string.FilterNew));
        } else {
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTextSize(AndroidUtilities.dp(20.0f));
            this.actionBar.setTitle(Emoji.replaceEmoji(this.filter.name, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.FilterCreateActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (FilterCreateActivity.this.checkDiscard()) {
                        FilterCreateActivity.this.finishFragment();
                    }
                } else if (id == 1) {
                    FilterCreateActivity.this.processDone();
                }
            }
        });
        this.doneItem = actionBarMenuCreateMenu.addItem(1, LocaleController.getString("Save", R.string.Save).toUpperCase());
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.FilterCreateActivity.2
            @Override // android.view.ViewGroup, android.view.View
            public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
                return false;
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$CmsRmpDCqxpFWR0v5yI9enTHz2I
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$4$FilterCreateActivity(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$nqh99WooTcJmd8OUl2aaZB2IOBs
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$5$FilterCreateActivity(view, i);
            }
        });
        checkDoneButton(false);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$FilterCreateActivity(View view, final int i) {
        if (getParentActivity() == null) {
            return;
        }
        if (i == this.includeShowMoreRow) {
            this.includeExpanded = true;
            updateRows();
            return;
        }
        if (i == this.excludeShowMoreRow) {
            this.excludeExpanded = true;
            updateRows();
            return;
        }
        int i2 = this.includeAddRow;
        if (i == i2 || i == this.excludeAddRow) {
            FilterUsersActivity filterUsersActivity = new FilterUsersActivity(i == i2, i == this.excludeAddRow ? this.newNeverShow : this.newAlwaysShow, this.newFilterFlags);
            filterUsersActivity.setDelegate(new FilterUsersActivity.FilterUsersActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$oH4hpkGm5p2Iq2OWV-HpEnNn5bg
                @Override // ir.eitaa.ui.FilterUsersActivity.FilterUsersActivityDelegate
                public final void didSelectChats(ArrayList arrayList, int i3) {
                    this.f$0.lambda$createView$0$FilterCreateActivity(i, arrayList, i3);
                }
            });
            presentFragment(filterUsersActivity);
            return;
        }
        if (i == this.removeRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("FilterDelete", R.string.FilterDelete));
            builder.setMessage(LocaleController.getString("FilterDeleteAlert", R.string.FilterDeleteAlert));
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$516VzvwCFuUxsF7Iqdf-b6AuoDU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$createView$3$FilterCreateActivity(dialogInterface, i3);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
                return;
            }
            return;
        }
        if (i == this.nameRow) {
            PollEditTextCell pollEditTextCell = (PollEditTextCell) view;
            pollEditTextCell.getTextView().requestFocus();
            AndroidUtilities.showKeyboard(pollEditTextCell.getTextView());
        } else if (view instanceof UserCell) {
            UserCell userCell = (UserCell) view;
            showRemoveAlert(i, userCell.getName(), userCell.getCurrentObject(), i < this.includeSectionRow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$FilterCreateActivity(int i, ArrayList arrayList, int i2) {
        this.newFilterFlags = i2;
        if (i == this.excludeAddRow) {
            this.newNeverShow = arrayList;
            for (int i3 = 0; i3 < this.newNeverShow.size(); i3++) {
                Long l = this.newNeverShow.get(i3);
                this.newAlwaysShow.remove(l);
                this.newPinned.delete(l.longValue());
            }
        } else {
            this.newAlwaysShow = arrayList;
            for (int i4 = 0; i4 < this.newAlwaysShow.size(); i4++) {
                this.newNeverShow.remove(this.newAlwaysShow.get(i4));
            }
            ArrayList arrayList2 = new ArrayList();
            int size = this.newPinned.size();
            for (int i5 = 0; i5 < size; i5++) {
                Long lValueOf = Long.valueOf(this.newPinned.keyAt(i5));
                if (!DialogObject.isEncryptedDialog(lValueOf.longValue()) && !this.newAlwaysShow.contains(lValueOf)) {
                    arrayList2.add(lValueOf);
                }
            }
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                this.newPinned.delete(((Long) arrayList2.get(i6)).longValue());
            }
        }
        fillFilterName();
        checkDoneButton(false);
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$FilterCreateActivity(DialogInterface dialogInterface, int i) {
        final AlertDialog alertDialog;
        if (getParentActivity() != null) {
            alertDialog = new AlertDialog(getParentActivity(), 3);
            alertDialog.setCanCacnel(false);
            alertDialog.show();
        } else {
            alertDialog = null;
        }
        TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
        tLRPC$TL_messages_updateDialogFilter.id = this.filter.id;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$lbisNg4UGe4_FiC37uZaauKiD4c
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$2$FilterCreateActivity(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$FilterCreateActivity(final AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$USd7wLcLNTqLtjOJ6bUI4G8O8aI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1$FilterCreateActivity(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$FilterCreateActivity(AlertDialog alertDialog) {
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        getMessagesController().removeFilter(this.filter);
        getMessagesStorage().deleteDialogFilter(this.filter);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$5$FilterCreateActivity(View view, int i) {
        if (!(view instanceof UserCell)) {
            return false;
        }
        UserCell userCell = (UserCell) view;
        showRemoveAlert(i, userCell.getName(), userCell.getCurrentObject(), i < this.includeSectionRow);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return checkDiscard();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fillFilterName() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilterCreateActivity.fillFilterName():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        if (this.doneItem.getAlpha() != 1.0f) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (this.creatingNew) {
            builder.setTitle(LocaleController.getString("FilterDiscardNewTitle", R.string.FilterDiscardNewTitle));
            builder.setMessage(LocaleController.getString("FilterDiscardNewAlert", R.string.FilterDiscardNewAlert));
            builder.setPositiveButton(LocaleController.getString("FilterDiscardNewSave", R.string.FilterDiscardNewSave), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$ZOn-Ry2yiRom73hK9q4910Epxfg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$checkDiscard$6$FilterCreateActivity(dialogInterface, i);
                }
            });
        } else {
            builder.setTitle(LocaleController.getString("FilterDiscardTitle", R.string.FilterDiscardTitle));
            builder.setMessage(LocaleController.getString("FilterDiscardAlert", R.string.FilterDiscardAlert));
            builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$8oGAeec_bhgcKK1xOphTPxD8i88
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$checkDiscard$7$FilterCreateActivity(dialogInterface, i);
                }
            });
        }
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$FW-NkWTW6UUATZB4-zxzCyR44cg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$8$FilterCreateActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$6$FilterCreateActivity(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$7$FilterCreateActivity(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$8$FilterCreateActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    private void showRemoveAlert(final int position, CharSequence name, Object object, final boolean include) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (include) {
            builder.setTitle(LocaleController.getString("FilterRemoveInclusionTitle", R.string.FilterRemoveInclusionTitle));
            if (object instanceof String) {
                builder.setMessage(LocaleController.formatString("FilterRemoveInclusionText", R.string.FilterRemoveInclusionText, name));
            } else if (object instanceof TLRPC$User) {
                builder.setMessage(LocaleController.formatString("FilterRemoveInclusionUserText", R.string.FilterRemoveInclusionUserText, name));
            } else {
                builder.setMessage(LocaleController.formatString("FilterRemoveInclusionChatText", R.string.FilterRemoveInclusionChatText, name));
            }
        } else {
            builder.setTitle(LocaleController.getString("FilterRemoveExclusionTitle", R.string.FilterRemoveExclusionTitle));
            if (object instanceof String) {
                builder.setMessage(LocaleController.formatString("FilterRemoveExclusionText", R.string.FilterRemoveExclusionText, name));
            } else if (object instanceof TLRPC$User) {
                builder.setMessage(LocaleController.formatString("FilterRemoveExclusionUserText", R.string.FilterRemoveExclusionUserText, name));
            } else {
                builder.setMessage(LocaleController.formatString("FilterRemoveExclusionChatText", R.string.FilterRemoveExclusionChatText, name));
            }
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("StickersRemove", R.string.StickersRemove), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$Q1DPUpAKdZ9uFyIqu9RDkjZh6xk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showRemoveAlert$9$FilterCreateActivity(position, include, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showRemoveAlert$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showRemoveAlert$9$FilterCreateActivity(int i, boolean z, DialogInterface dialogInterface, int i2) {
        if (i == this.includeContactsRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_CONTACTS ^ (-1);
        } else if (i == this.includeNonContactsRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS ^ (-1);
        } else if (i == this.includeGroupsRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_GROUPS ^ (-1);
        } else if (i == this.includeChannelsRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_CHANNELS ^ (-1);
        } else if (i == this.includeMediaChannelRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL ^ (-1);
        } else if (i == this.includeAdminRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_ADMIN ^ (-1);
        } else if (i == this.includeFavoriteRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_FAVORITE ^ (-1);
        } else if (i == this.excludeArchivedRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED ^ (-1);
        } else if (i == this.excludeMutedRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED ^ (-1);
        } else if (i == this.excludeReadRow) {
            this.newFilterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ ^ (-1);
        } else if (z) {
            this.newAlwaysShow.remove(i - this.includeStartRow);
        } else {
            this.newNeverShow.remove(i - this.excludeStartRow);
        }
        fillFilterName();
        updateRows();
        checkDoneButton(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        saveFilterToServer(this.filter, this.newFilterFlags, this.newFilterName, this.newAlwaysShow, this.newNeverShow, this.newPinned, this.creatingNew, false, this.hasUserChanged, true, true, this, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$IHfiY_cZnUTwYH_I6CibaBe8K_I
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$10$FilterCreateActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$10$FilterCreateActivity() {
        getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
        finishFragment();
    }

    private static void processAddFilter(MessagesController.DialogFilter filter, int newFilterFlags, String newFilterName, ArrayList<Long> newAlwaysShow, ArrayList<Long> newNeverShow, boolean creatingNew, boolean atBegin, boolean hasUserChanged, boolean resetUnreadCounter, BaseFragment fragment, Runnable onFinish) {
        if (filter.flags != newFilterFlags || hasUserChanged) {
            filter.pendingUnreadCount = -1;
            if (resetUnreadCounter) {
                filter.unreadCount = -1;
            }
        }
        filter.flags = newFilterFlags;
        filter.name = newFilterName;
        filter.neverShow = newNeverShow;
        filter.alwaysShow = newAlwaysShow;
        if (creatingNew) {
            fragment.getMessagesController().addFilter(filter, atBegin);
        } else {
            fragment.getMessagesController().onFilterUpdate(filter);
        }
        fragment.getMessagesStorage().saveDialogFilter(filter, atBegin, true);
        if (onFinish != null) {
            onFinish.run();
        }
    }

    public static void saveFilterToServer(final MessagesController.DialogFilter filter, final int newFilterFlags, final String newFilterName, final ArrayList<Long> newAlwaysShow, final ArrayList<Long> newNeverShow, LongSparseIntArray newPinned, final boolean creatingNew, final boolean atBegin, final boolean hasUserChanged, final boolean resetUnreadCounter, final boolean progress, final BaseFragment fragment, final Runnable onFinish) {
        AlertDialog alertDialog;
        ArrayList<TLRPC$InputPeer> arrayList;
        ArrayList<Long> arrayList2;
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        int i = 3;
        if (progress) {
            alertDialog = new AlertDialog(fragment.getParentActivity(), 3);
            alertDialog.setCanCacnel(false);
            alertDialog.show();
        } else {
            alertDialog = null;
        }
        TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
        tLRPC$TL_messages_updateDialogFilter.id = filter.id;
        int i2 = 1;
        tLRPC$TL_messages_updateDialogFilter.flags |= 1;
        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = new TLRPC$TL_dialogFilter();
        tLRPC$TL_messages_updateDialogFilter.filter = tLRPC$TL_dialogFilter;
        tLRPC$TL_dialogFilter.contacts = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_CONTACTS) != 0;
        tLRPC$TL_dialogFilter.non_contacts = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0;
        tLRPC$TL_dialogFilter.groups = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_GROUPS) != 0;
        tLRPC$TL_dialogFilter.broadcasts = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_CHANNELS) != 0;
        tLRPC$TL_dialogFilter.bots = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_BOTS) != 0;
        tLRPC$TL_dialogFilter.admin = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_ADMIN) != 0;
        tLRPC$TL_dialogFilter.favourite = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_FAVORITE) != 0;
        tLRPC$TL_dialogFilter.media_channel = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL) != 0;
        tLRPC$TL_dialogFilter.exclude_muted = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED) != 0;
        tLRPC$TL_dialogFilter.exclude_read = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0;
        tLRPC$TL_dialogFilter.exclude_archived = (newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED) != 0;
        tLRPC$TL_dialogFilter.id = filter.id;
        tLRPC$TL_dialogFilter.title = newFilterName;
        MessagesController messagesController = fragment.getMessagesController();
        ArrayList<Long> arrayList3 = new ArrayList<>();
        if (newPinned.size() != 0) {
            int size = newPinned.size();
            for (int i3 = 0; i3 < size; i3++) {
                long jKeyAt = newPinned.keyAt(i3);
                if (!DialogObject.isEncryptedDialog(jKeyAt)) {
                    arrayList3.add(Long.valueOf(jKeyAt));
                }
            }
            Collections.sort(arrayList3, new $$Lambda$FilterCreateActivity$z3dgDfu4CrYzAHV21dxJPMPBeu8(newPinned));
        }
        int i4 = 0;
        while (i4 < i) {
            if (i4 == 0) {
                arrayList = tLRPC$TL_messages_updateDialogFilter.filter.include_peers;
                arrayList2 = newAlwaysShow;
            } else if (i4 == i2) {
                arrayList = tLRPC$TL_messages_updateDialogFilter.filter.exclude_peers;
                arrayList2 = newNeverShow;
            } else {
                arrayList = tLRPC$TL_messages_updateDialogFilter.filter.pinned_peers;
                arrayList2 = arrayList3;
            }
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                long jLongValue = arrayList2.get(i5).longValue();
                if ((i4 != 0 || newPinned.indexOfKey(jLongValue) < 0) && !DialogObject.isEncryptedDialog(jLongValue)) {
                    if (jLongValue > 0) {
                        TLRPC$User user = messagesController.getUser(Long.valueOf(jLongValue));
                        if (user != null) {
                            TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                            tLRPC$TL_inputPeerUser.user_id = jLongValue;
                            tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
                            arrayList.add(tLRPC$TL_inputPeerUser);
                        }
                    } else {
                        long j = -jLongValue;
                        TLRPC$Chat chat = messagesController.getChat(Long.valueOf(j));
                        if (chat != null) {
                            if (ChatObject.isChannel(chat)) {
                                TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                                tLRPC$TL_inputPeerChannel.channel_id = j;
                                tLRPC$TL_inputPeerChannel.access_hash = chat.access_hash;
                                arrayList.add(tLRPC$TL_inputPeerChannel);
                            } else {
                                TLRPC$TL_inputPeerChat tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                                tLRPC$TL_inputPeerChat.chat_id = j;
                                arrayList.add(tLRPC$TL_inputPeerChat);
                            }
                        }
                    }
                }
            }
            i4++;
            i = 3;
            i2 = 1;
        }
        final AlertDialog alertDialog2 = alertDialog;
        fragment.getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$XYpNWZLs7U7SzW2jBPX34dmiuMU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$JhfF2SAhj0xki1OsviQCael9hlM
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterCreateActivity.lambda$saveFilterToServer$12(z, alertDialog, dialogFilter, i, str, arrayList, arrayList, z, z, z, z, baseFragment, runnable);
                    }
                });
            }
        });
        if (progress) {
            return;
        }
        processAddFilter(filter, newFilterFlags, newFilterName, newAlwaysShow, newNeverShow, creatingNew, atBegin, hasUserChanged, resetUnreadCounter, fragment, onFinish);
    }

    static /* synthetic */ int lambda$saveFilterToServer$11(LongSparseIntArray longSparseIntArray, Long l, Long l2) {
        int i = longSparseIntArray.get(l.longValue());
        int i2 = longSparseIntArray.get(l2.longValue());
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    static /* synthetic */ void lambda$saveFilterToServer$12(boolean z, AlertDialog alertDialog, MessagesController.DialogFilter dialogFilter, int i, String str, ArrayList arrayList, ArrayList arrayList2, boolean z2, boolean z3, boolean z4, boolean z5, BaseFragment baseFragment, Runnable runnable) {
        if (z) {
            if (alertDialog != null) {
                try {
                    alertDialog.dismiss();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            processAddFilter(dialogFilter, i, str, arrayList, arrayList2, z2, z3, z4, z5, baseFragment, runnable);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean canBeginSlide() {
        return checkDiscard();
    }

    private boolean hasChanges() {
        this.hasUserChanged = false;
        if (this.filter.alwaysShow.size() != this.newAlwaysShow.size()) {
            this.hasUserChanged = true;
        }
        if (this.filter.neverShow.size() != this.newNeverShow.size()) {
            this.hasUserChanged = true;
        }
        if (!this.hasUserChanged) {
            Collections.sort(this.filter.alwaysShow);
            Collections.sort(this.newAlwaysShow);
            if (!this.filter.alwaysShow.equals(this.newAlwaysShow)) {
                this.hasUserChanged = true;
            }
            Collections.sort(this.filter.neverShow);
            Collections.sort(this.newNeverShow);
            if (!this.filter.neverShow.equals(this.newNeverShow)) {
                this.hasUserChanged = true;
            }
        }
        if (TextUtils.equals(this.filter.name, this.newFilterName) && this.filter.flags == this.newFilterFlags) {
            return this.hasUserChanged;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDoneButton(boolean animated) {
        boolean z = true;
        boolean zHasChanges = !TextUtils.isEmpty(this.newFilterName) && this.newFilterName.length() <= 12;
        if (zHasChanges) {
            if ((this.newFilterFlags & MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS) == 0 && this.newAlwaysShow.isEmpty()) {
                z = false;
            }
            zHasChanges = (!z || this.creatingNew) ? z : hasChanges();
        }
        if (this.doneItem.isEnabled() == zHasChanges) {
            return;
        }
        this.doneItem.setEnabled(zHasChanges);
        if (animated) {
            this.doneItem.animate().alpha(zHasChanges ? 1.0f : 0.0f).scaleX(zHasChanges ? 1.0f : 0.0f).scaleY(zHasChanges ? 1.0f : 0.0f).setDuration(180L).start();
            return;
        }
        this.doneItem.setAlpha(zHasChanges ? 1.0f : 0.0f);
        this.doneItem.setScaleX(zHasChanges ? 1.0f : 0.0f);
        this.doneItem.setScaleY(zHasChanges ? 1.0f : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextLeft(View cell) {
        if (cell instanceof PollEditTextCell) {
            PollEditTextCell pollEditTextCell = (PollEditTextCell) cell;
            String str = this.newFilterName;
            int length = 12 - (str != null ? str.length() : 0);
            if (length <= 3.6000004f) {
                pollEditTextCell.setText2(String.format("%d", Integer.valueOf(length)));
                SimpleTextView textView2 = pollEditTextCell.getTextView2();
                String str2 = length < 0 ? "windowBackgroundWhiteRedText5" : "windowBackgroundWhiteGrayText3";
                textView2.setTextColor(Theme.getColor(str2));
                textView2.setTag(str2);
                textView2.setAlpha((pollEditTextCell.getTextView().isFocused() || length < 0) ? 1.0f : 0.0f);
                return;
            }
            pollEditTextCell.setText2("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return (itemViewType == 3 || itemViewType == 0 || itemViewType == 2 || itemViewType == 5) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FilterCreateActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$FilterCreateActivity$ListAdapter(PollEditTextCell pollEditTextCell, View view, boolean z) {
            pollEditTextCell.getTextView2().setAlpha((z || FilterCreateActivity.this.newFilterName.length() > 12) ? 1.0f : 0.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            View shadowSectionCell;
            if (i == 0) {
                FrameLayout headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = headerCell;
            } else if (i == 1) {
                UserCell userCell = new UserCell(this.mContext, 6, 0, false);
                userCell.setSelfAsSavedMessages(true);
                userCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = userCell;
            } else if (i == 2) {
                final PollEditTextCell pollEditTextCell = new PollEditTextCell(this.mContext, null);
                pollEditTextCell.createErrorTextView();
                pollEditTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.FilterCreateActivity.ListAdapter.1
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        if (pollEditTextCell.getTag() != null) {
                            return;
                        }
                        String string = s.toString();
                        if (!TextUtils.equals(string, FilterCreateActivity.this.newFilterName)) {
                            FilterCreateActivity.this.nameChangedManually = !TextUtils.isEmpty(string);
                            FilterCreateActivity.this.newFilterName = string;
                        }
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = FilterCreateActivity.this.listView.findViewHolderForAdapterPosition(FilterCreateActivity.this.nameRow);
                        if (viewHolderFindViewHolderForAdapterPosition != null) {
                            FilterCreateActivity.this.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView);
                        }
                        FilterCreateActivity.this.checkDoneButton(true);
                    }
                });
                EditTextBoldCursor textView = pollEditTextCell.getTextView();
                pollEditTextCell.setShowNextButton(true);
                textView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$ListAdapter$9VZYv-gVpFL60bBPG-eQ8-LIFJ8
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        this.f$0.lambda$onCreateViewHolder$0$FilterCreateActivity$ListAdapter(pollEditTextCell, view, z);
                    }
                });
                textView.setImeOptions(268435462);
                frameLayout = pollEditTextCell;
            } else {
                if (i == 3) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                } else if (i == 4) {
                    FrameLayout textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    frameLayout = textCell;
                } else if (i == 5) {
                    shadowSectionCell = new HintInnerCell(this.mContext);
                } else {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                }
                return new RecyclerListView.Holder(shadowSectionCell);
            }
            shadowSectionCell = frameLayout;
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 2) {
                FilterCreateActivity.this.setTextLeft(holder.itemView);
                PollEditTextCell pollEditTextCell = (PollEditTextCell) holder.itemView;
                pollEditTextCell.setTag(1);
                pollEditTextCell.setTextAndHint(FilterCreateActivity.this.newFilterName != null ? FilterCreateActivity.this.newFilterName : "", LocaleController.getString("FilterNameHint", R.string.FilterNameHint), false);
                pollEditTextCell.setTag(null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 2) {
                EditTextBoldCursor textView = ((PollEditTextCell) holder.itemView).getTextView();
                if (textView.isFocused()) {
                    textView.clearFocus();
                    AndroidUtilities.hideKeyboard(textView);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0183 A[PHI: r11
          0x0183: PHI (r11v53 java.lang.Long) = (r11v52 java.lang.Long), (r11v52 java.lang.Long), (r11v87 java.lang.Long), (r11v87 java.lang.Long) binds: [B:65:0x01b0, B:67:0x01b9, B:55:0x0178, B:57:0x0181] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r11, int r12) {
            /*
                Method dump skipped, instructions count: 973
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilterCreateActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == FilterCreateActivity.this.includeHeaderRow || position == FilterCreateActivity.this.excludeHeaderRow) {
                return 0;
            }
            if (position >= FilterCreateActivity.this.includeStartRow && position < FilterCreateActivity.this.includeEndRow) {
                return 1;
            }
            if ((position >= FilterCreateActivity.this.excludeStartRow && position < FilterCreateActivity.this.excludeEndRow) || position == FilterCreateActivity.this.includeContactsRow || position == FilterCreateActivity.this.includeNonContactsRow || position == FilterCreateActivity.this.includeGroupsRow || position == FilterCreateActivity.this.includeChannelsRow || position == FilterCreateActivity.this.includeBotsRow || position == FilterCreateActivity.this.includeAdminRow || position == FilterCreateActivity.this.includeMediaChannelRow || position == FilterCreateActivity.this.includeFavoriteRow || position == FilterCreateActivity.this.excludeReadRow || position == FilterCreateActivity.this.excludeArchivedRow || position == FilterCreateActivity.this.excludeMutedRow) {
                return 1;
            }
            if (position == FilterCreateActivity.this.nameRow) {
                return 2;
            }
            if (position == FilterCreateActivity.this.nameSectionRow || position == FilterCreateActivity.this.namePreSectionRow || position == FilterCreateActivity.this.removeSectionRow) {
                return 3;
            }
            if (position == FilterCreateActivity.this.imageRow) {
                return 5;
            }
            return (position == FilterCreateActivity.this.includeSectionRow || position == FilterCreateActivity.this.excludeSectionRow) ? 6 : 4;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterCreateActivity$S3s4NX-A5zFpWpdHMV8KLojg8_E
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$14$FilterCreateActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, PollEditTextCell.class, UserCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"ImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{UserCell.class}, new String[]{"adminTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "profile_creatorIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
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
    /* renamed from: lambda$getThemeDescriptions$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$14$FilterCreateActivity() {
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
