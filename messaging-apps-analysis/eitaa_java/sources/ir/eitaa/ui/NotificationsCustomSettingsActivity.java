package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.NotificationsCheckCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextColorCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.NotificationsSettingsActivity;
import ir.eitaa.ui.ProfileNotificationsActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class NotificationsCustomSettingsActivity extends BaseFragment {
    private ListAdapter adapter;
    private int alertRow;
    private int alertSection2Row;
    private AnimatorSet animatorSet;
    private int currentType;
    private int deleteAllRow;
    private int deleteAllSectionRow;
    private EmptyTextProgressView emptyView;
    private ArrayList<NotificationsSettingsActivity.NotificationException> exceptions;
    private int exceptionsAddRow;
    private HashMap<Long, NotificationsSettingsActivity.NotificationException> exceptionsDict;
    private int exceptionsEndRow;
    private int exceptionsSection2Row;
    private int exceptionsStartRow;
    private int groupSection2Row;
    private RecyclerListView listView;
    private int messageLedRow;
    private int messagePopupNotificationRow;
    private int messagePriorityRow;
    private int messageSectionRow;
    private int messageSoundRow;
    private int messageVibrateRow;
    private int previewRow;
    private int rowCount;
    private SearchAdapter searchAdapter;
    private boolean searchWas;
    private boolean searching;

    public NotificationsCustomSettingsActivity(int type, ArrayList<NotificationsSettingsActivity.NotificationException> notificationExceptions) {
        this(type, notificationExceptions, false);
    }

    public NotificationsCustomSettingsActivity(int type, ArrayList<NotificationsSettingsActivity.NotificationException> notificationExceptions, boolean load) {
        this.rowCount = 0;
        this.exceptionsDict = new HashMap<>();
        this.currentType = type;
        this.exceptions = notificationExceptions;
        int size = notificationExceptions.size();
        for (int i = 0; i < size; i++) {
            NotificationsSettingsActivity.NotificationException notificationException = this.exceptions.get(i);
            this.exceptionsDict.put(Long.valueOf(notificationException.did), notificationException);
        }
        if (load) {
            loadExceptions();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        updateRows(true);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.searching = false;
        this.searchWas = false;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == -1) {
            this.actionBar.setTitle(LocaleController.getString("NotificationsExceptions", R.string.NotificationsExceptions));
        } else {
            this.actionBar.setTitle(LocaleController.getString("Notifications", R.string.Notifications));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.NotificationsCustomSettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    NotificationsCustomSettingsActivity.this.finishFragment();
                }
            }
        });
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList = this.exceptions;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.NotificationsCustomSettingsActivity.2
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                    NotificationsCustomSettingsActivity.this.searching = true;
                    NotificationsCustomSettingsActivity.this.emptyView.setShowAtCenter(true);
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchCollapse() throws InterruptedException {
                    NotificationsCustomSettingsActivity.this.searchAdapter.searchDialogs(null);
                    NotificationsCustomSettingsActivity.this.searching = false;
                    NotificationsCustomSettingsActivity.this.searchWas = false;
                    NotificationsCustomSettingsActivity.this.emptyView.setText(LocaleController.getString("NoExceptions", R.string.NoExceptions));
                    NotificationsCustomSettingsActivity.this.listView.setAdapter(NotificationsCustomSettingsActivity.this.adapter);
                    NotificationsCustomSettingsActivity.this.adapter.notifyDataSetChanged();
                    NotificationsCustomSettingsActivity.this.listView.setFastScrollVisible(true);
                    NotificationsCustomSettingsActivity.this.listView.setVerticalScrollBarEnabled(false);
                    NotificationsCustomSettingsActivity.this.emptyView.setShowAtCenter(false);
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) throws InterruptedException {
                    if (NotificationsCustomSettingsActivity.this.searchAdapter == null) {
                        return;
                    }
                    String string = editText.getText().toString();
                    if (string.length() != 0) {
                        NotificationsCustomSettingsActivity.this.searchWas = true;
                        if (NotificationsCustomSettingsActivity.this.listView != null) {
                            NotificationsCustomSettingsActivity.this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                            NotificationsCustomSettingsActivity.this.emptyView.showProgress();
                            NotificationsCustomSettingsActivity.this.listView.setAdapter(NotificationsCustomSettingsActivity.this.searchAdapter);
                            NotificationsCustomSettingsActivity.this.searchAdapter.notifyDataSetChanged();
                            NotificationsCustomSettingsActivity.this.listView.setFastScrollVisible(false);
                            NotificationsCustomSettingsActivity.this.listView.setVerticalScrollBarEnabled(true);
                        }
                    }
                    NotificationsCustomSettingsActivity.this.searchAdapter.searchDialogs(string);
                }
            }).setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        }
        this.searchAdapter = new SearchAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.setTextSize(18);
        this.emptyView.setText(LocaleController.getString("NoExceptions", R.string.NoExceptions));
        this.emptyView.showTextView();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$w-PKjvIQj07onryew1-mKYQKd54
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) throws Resources.NotFoundException {
                this.f$0.lambda$createView$9$NotificationsCustomSettingsActivity(view, i, f, f2);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.NotificationsCustomSettingsActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(NotificationsCustomSettingsActivity.this.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$NotificationsCustomSettingsActivity(View view, final int i, float f, float f2) throws Resources.NotFoundException {
        final ArrayList<NotificationsSettingsActivity.NotificationException> arrayList;
        final NotificationsSettingsActivity.NotificationException notificationException;
        long j;
        NotificationsSettingsActivity.NotificationException notificationException2;
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2;
        String string;
        boolean z;
        if (getParentActivity() == null) {
            return;
        }
        final boolean z2 = false;
        if (this.listView.getAdapter() == this.searchAdapter || (i >= this.exceptionsStartRow && i < this.exceptionsEndRow)) {
            RecyclerView.Adapter adapter = this.listView.getAdapter();
            SearchAdapter searchAdapter = this.searchAdapter;
            if (adapter == searchAdapter) {
                Object object = searchAdapter.getObject(i);
                if (!(object instanceof NotificationsSettingsActivity.NotificationException)) {
                    boolean z3 = object instanceof TLRPC$User;
                    if (z3) {
                        j = ((TLRPC$User) object).id;
                    } else {
                        j = -((TLRPC$Chat) object).id;
                    }
                    if (this.exceptionsDict.containsKey(Long.valueOf(j))) {
                        notificationException2 = this.exceptionsDict.get(Long.valueOf(j));
                    } else {
                        NotificationsSettingsActivity.NotificationException notificationException3 = new NotificationsSettingsActivity.NotificationException();
                        notificationException3.did = j;
                        if (z3) {
                            notificationException3.did = ((TLRPC$User) object).id;
                        } else {
                            notificationException3.did = -((TLRPC$Chat) object).id;
                        }
                        notificationException2 = notificationException3;
                        z2 = true;
                    }
                    arrayList2 = this.exceptions;
                } else {
                    arrayList2 = this.searchAdapter.searchResult;
                    notificationException2 = (NotificationsSettingsActivity.NotificationException) object;
                }
                notificationException = notificationException2;
                arrayList = arrayList2;
            } else {
                ArrayList<NotificationsSettingsActivity.NotificationException> arrayList3 = this.exceptions;
                int i2 = i - this.exceptionsStartRow;
                if (i2 < 0 || i2 >= arrayList3.size()) {
                    return;
                }
                arrayList = arrayList3;
                notificationException = arrayList3.get(i2);
            }
            if (notificationException == null) {
                return;
            }
            AlertsCreator.showCustomNotificationsDialog(this, notificationException.did, -1, null, this.currentAccount, null, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$c0WR42_jlktAjRL5zSM0D3W3FGU
                @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                public final void run(int i3) {
                    this.f$0.lambda$createView$0$NotificationsCustomSettingsActivity(z2, arrayList, notificationException, i, i3);
                }
            });
            return;
        }
        if (i == this.exceptionsAddRow) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putBoolean("checkCanWrite", false);
            int i3 = this.currentType;
            if (i3 == 0) {
                bundle.putInt("dialogsType", 6);
            } else if (i3 == 2) {
                bundle.putInt("dialogsType", 5);
            } else {
                bundle.putInt("dialogsType", 4);
            }
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$ZD14P40KxvX1Y8t-QjtL-xYA2Oo
                @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList4, CharSequence charSequence, boolean z4) {
                    this.f$0.lambda$createView$2$NotificationsCustomSettingsActivity(dialogsActivity2, arrayList4, charSequence, z4);
                }
            });
            presentFragment(dialogsActivity);
        } else {
            Parcelable parcelable = null;
            if (i == this.deleteAllRow) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("NotificationsDeleteAllExceptionTitle", R.string.NotificationsDeleteAllExceptionTitle));
                builder.setMessage(LocaleController.getString("NotificationsDeleteAllExceptionAlert", R.string.NotificationsDeleteAllExceptionAlert));
                builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$8v_PW3kvolrcCSNQ-U6T_q1Xyws
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$createView$3$NotificationsCustomSettingsActivity(dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
            } else if (i == this.alertRow) {
                boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(this.currentType);
                final NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
                final RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
                if (!zIsGlobalNotificationsEnabled) {
                    getNotificationsController().setGlobalNotificationsEnabled(this.currentType, 0);
                    notificationsCheckCell.setChecked(true);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
                    }
                    checkRowsEnabled();
                } else {
                    AlertsCreator.showCustomNotificationsDialog(this, 0L, this.currentType, this.exceptions, this.currentAccount, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$sHxqyAhqb-AFWNPmNrFpiQbowQ4
                        @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                        public final void run(int i4) {
                            this.f$0.lambda$createView$4$NotificationsCustomSettingsActivity(notificationsCheckCell, viewHolderFindViewHolderForAdapterPosition, i, i4);
                        }
                    });
                }
                z2 = zIsGlobalNotificationsEnabled;
            } else if (i == this.previewRow) {
                if (!view.isEnabled()) {
                    return;
                }
                SharedPreferences notificationsSettings = getNotificationsSettings();
                SharedPreferences.Editor editorEdit = notificationsSettings.edit();
                int i4 = this.currentType;
                if (i4 == 1) {
                    z = notificationsSettings.getBoolean("EnablePreviewAll", true);
                    editorEdit.putBoolean("EnablePreviewAll", !z);
                } else if (i4 == 0) {
                    z = notificationsSettings.getBoolean("EnablePreviewGroup", true);
                    editorEdit.putBoolean("EnablePreviewGroup", !z);
                } else {
                    z = notificationsSettings.getBoolean("EnablePreviewChannel", true);
                    editorEdit.putBoolean("EnablePreviewChannel", !z);
                }
                z2 = z;
                editorEdit.commit();
                getNotificationsController().updateServerNotificationsSettings(this.currentType);
            } else if (i == this.messageSoundRow) {
                if (!view.isEnabled()) {
                    return;
                }
                try {
                    SharedPreferences notificationsSettings2 = getNotificationsSettings();
                    Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                    intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                    intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(2));
                    Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                    String path = uri != null ? uri.getPath() : null;
                    int i5 = this.currentType;
                    if (i5 == 1) {
                        string = notificationsSettings2.getString("GlobalSoundPath", path);
                    } else if (i5 == 0) {
                        string = notificationsSettings2.getString("GroupSoundPath", path);
                    } else {
                        string = notificationsSettings2.getString("ChannelSoundPath", path);
                    }
                    if (string != null && !string.equals("NoSound")) {
                        parcelable = string.equals(path) ? uri : Uri.parse(string);
                    }
                    intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", parcelable);
                    startActivityForResult(intent, i);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (i == this.messageLedRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createColorSelectDialog(getParentActivity(), 0L, this.currentType, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$p49-IAh2E0ad1B_m6XF6qSTUz60
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$5$NotificationsCustomSettingsActivity(i);
                        }
                    }));
                }
            } else if (i == this.messagePopupNotificationRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createPopupSelectDialog(getParentActivity(), this.currentType, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$qE_s5K4hrQRLARgh43MuBWlQygc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$6$NotificationsCustomSettingsActivity(i);
                        }
                    }));
                }
            } else if (i == this.messageVibrateRow) {
                if (!view.isEnabled()) {
                    return;
                }
                int i6 = this.currentType;
                showDialog(AlertsCreator.createVibrationSelectDialog(getParentActivity(), 0L, i6 == 1 ? "vibrate_messages" : i6 == 0 ? "vibrate_group" : "vibrate_channel", new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$JFIQEOptgShRM-sMiobHggQyfDs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createView$7$NotificationsCustomSettingsActivity(i);
                    }
                }));
            } else if (i == this.messagePriorityRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createPrioritySelectDialog(getParentActivity(), 0L, this.currentType, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$v4rXbq1wxnPcgtneeTuN6sjkXAE
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$8$NotificationsCustomSettingsActivity(i);
                        }
                    }));
                }
            }
        }
        if (view instanceof TextCheckCell) {
            ((TextCheckCell) view).setChecked(!z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$NotificationsCustomSettingsActivity(boolean z, ArrayList arrayList, NotificationsSettingsActivity.NotificationException notificationException, int i, int i2) {
        int iIndexOf;
        if (i2 == 0) {
            if (z) {
                return;
            }
            ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2 = this.exceptions;
            if (arrayList != arrayList2 && (iIndexOf = arrayList2.indexOf(notificationException)) >= 0) {
                this.exceptions.remove(iIndexOf);
                this.exceptionsDict.remove(Long.valueOf(notificationException.did));
            }
            arrayList.remove(notificationException);
            if (arrayList == this.exceptions) {
                if (this.exceptionsAddRow != -1 && arrayList.isEmpty()) {
                    this.listView.getAdapter().notifyItemChanged(this.exceptionsAddRow);
                    this.listView.getAdapter().notifyItemRemoved(this.deleteAllRow);
                    this.listView.getAdapter().notifyItemRemoved(this.deleteAllSectionRow);
                }
                this.listView.getAdapter().notifyItemRemoved(i);
                updateRows(false);
                checkRowsEnabled();
            } else {
                updateRows(true);
                this.searchAdapter.notifyDataSetChanged();
            }
            this.actionBar.closeSearchField();
            return;
        }
        SharedPreferences notificationsSettings = getNotificationsSettings();
        notificationException.hasCustom = notificationsSettings.getBoolean("custom_" + notificationException.did, false);
        int i3 = notificationsSettings.getInt("notify2_" + notificationException.did, 0);
        notificationException.notify = i3;
        if (i3 != 0) {
            int i4 = notificationsSettings.getInt("notifyuntil_" + notificationException.did, -1);
            if (i4 != -1) {
                notificationException.muteUntil = i4;
            }
        }
        if (z) {
            this.exceptions.add(notificationException);
            this.exceptionsDict.put(Long.valueOf(notificationException.did), notificationException);
            updateRows(true);
        } else {
            this.listView.getAdapter().notifyItemChanged(i);
        }
        this.actionBar.closeSearchField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$NotificationsCustomSettingsActivity(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putLong("dialog_id", ((Long) arrayList.get(0)).longValue());
        bundle.putBoolean("exception", true);
        ProfileNotificationsActivity profileNotificationsActivity = new ProfileNotificationsActivity(bundle);
        profileNotificationsActivity.setDelegate(new ProfileNotificationsActivity.ProfileNotificationsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$LzqR1wMeG3FJ2kEWO0vNtNFu76s
            @Override // ir.eitaa.ui.ProfileNotificationsActivity.ProfileNotificationsActivityDelegate
            public final void didCreateNewException(NotificationsSettingsActivity.NotificationException notificationException) {
                this.f$0.lambda$createView$1$NotificationsCustomSettingsActivity(notificationException);
            }
        });
        presentFragment(profileNotificationsActivity, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$NotificationsCustomSettingsActivity(NotificationsSettingsActivity.NotificationException notificationException) {
        this.exceptions.add(0, notificationException);
        updateRows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$NotificationsCustomSettingsActivity(DialogInterface dialogInterface, int i) {
        SharedPreferences.Editor editorEdit = getNotificationsSettings().edit();
        int size = this.exceptions.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationsSettingsActivity.NotificationException notificationException = this.exceptions.get(i2);
            editorEdit.remove("notify2_" + notificationException.did).remove("custom_" + notificationException.did);
            getMessagesStorage().setDialogNotificationFlags(notificationException.did, 0L);
            TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(notificationException.did);
            if (tLRPC$Dialog != null) {
                tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
        }
        editorEdit.commit();
        int size2 = this.exceptions.size();
        for (int i3 = 0; i3 < size2; i3++) {
            getNotificationsController().updateServerNotificationsSettings(this.exceptions.get(i3).did, false);
        }
        this.exceptions.clear();
        this.exceptionsDict.clear();
        updateRows(true);
        getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$NotificationsCustomSettingsActivity(NotificationsCheckCell notificationsCheckCell, RecyclerView.ViewHolder viewHolder, int i, int i2) {
        int i3;
        SharedPreferences notificationsSettings = getNotificationsSettings();
        int i4 = this.currentType;
        int i5 = 0;
        if (i4 == 1) {
            i3 = notificationsSettings.getInt("EnableAll2", 0);
        } else if (i4 == 0) {
            i3 = notificationsSettings.getInt("EnableGroup2", 0);
        } else {
            i3 = notificationsSettings.getInt("EnableChannel2", 0);
        }
        int currentTime = getConnectionsManager().getCurrentTime();
        if (i3 >= currentTime && i3 - 31536000 < currentTime) {
            i5 = 2;
        }
        notificationsCheckCell.setChecked(getNotificationsController().isGlobalNotificationsEnabled(this.currentType), i5);
        if (viewHolder != null) {
            this.adapter.onBindViewHolder(viewHolder, i);
        }
        checkRowsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$NotificationsCustomSettingsActivity(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$NotificationsCustomSettingsActivity(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$NotificationsCustomSettingsActivity(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$NotificationsCustomSettingsActivity(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    private void checkRowsEnabled() {
        if (this.exceptions.isEmpty()) {
            int childCount = this.listView.getChildCount();
            ArrayList<Animator> arrayList = new ArrayList<>();
            boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(this.currentType);
            for (int i = 0; i < childCount; i++) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.getChildViewHolder(this.listView.getChildAt(i));
                int itemViewType = holder.getItemViewType();
                if (itemViewType == 0) {
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (holder.getAdapterPosition() == this.messageSectionRow) {
                        headerCell.setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                    }
                } else if (itemViewType == 1) {
                    ((TextCheckCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                } else if (itemViewType == 3) {
                    ((TextColorCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                } else if (itemViewType == 5) {
                    ((TextSettingsCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.NotificationsCustomSettingsActivity.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(NotificationsCustomSettingsActivity.this.animatorSet)) {
                        NotificationsCustomSettingsActivity.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.setDuration(150L);
            this.animatorSet.start();
        }
    }

    private void loadExceptions() {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$O7tYtBgRa6rSjqGW3D9yHq51vYQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadExceptions$11$NotificationsCustomSettingsActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0117, code lost:
    
        if (r4.deleted != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0141, code lost:
    
        if (r4.deleted != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0260 A[LOOP:3: B:113:0x025e->B:114:0x0260, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0207  */
    /* renamed from: lambda$loadExceptions$11, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadExceptions$11$NotificationsCustomSettingsActivity() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.NotificationsCustomSettingsActivity.lambda$loadExceptions$11$NotificationsCustomSettingsActivity():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadExceptions$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadExceptions$10$NotificationsCustomSettingsActivity(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        int i = this.currentType;
        if (i == 1) {
            this.exceptions = arrayList4;
        } else if (i == 0) {
            this.exceptions = arrayList5;
        } else {
            this.exceptions = arrayList6;
        }
        updateRows(true);
    }

    private void updateRows(boolean notify) {
        ListAdapter listAdapter;
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList;
        this.rowCount = 0;
        int i = this.currentType;
        if (i != -1) {
            int i2 = 0 + 1;
            this.rowCount = i2;
            this.alertRow = 0;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.alertSection2Row = i2;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.messageSectionRow = i3;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.previewRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.messageLedRow = i5;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.messageVibrateRow = i6;
            if (i == 2) {
                this.messagePopupNotificationRow = -1;
            } else {
                this.rowCount = i7 + 1;
                this.messagePopupNotificationRow = i7;
            }
            int i8 = this.rowCount;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.messageSoundRow = i8;
            if (Build.VERSION.SDK_INT >= 21) {
                this.rowCount = i9 + 1;
                this.messagePriorityRow = i9;
            } else {
                this.messagePriorityRow = -1;
            }
            int i10 = this.rowCount;
            int i11 = i10 + 1;
            this.rowCount = i11;
            this.groupSection2Row = i10;
            this.rowCount = i11 + 1;
            this.exceptionsAddRow = i11;
        } else {
            this.alertRow = -1;
            this.alertSection2Row = -1;
            this.messageSectionRow = -1;
            this.previewRow = -1;
            this.messageLedRow = -1;
            this.messageVibrateRow = -1;
            this.messagePopupNotificationRow = -1;
            this.messageSoundRow = -1;
            this.messagePriorityRow = -1;
            this.groupSection2Row = -1;
            this.exceptionsAddRow = -1;
        }
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2 = this.exceptions;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int i12 = this.rowCount;
            this.exceptionsStartRow = i12;
            int size = i12 + this.exceptions.size();
            this.rowCount = size;
            this.exceptionsEndRow = size;
        } else {
            this.exceptionsStartRow = -1;
            this.exceptionsEndRow = -1;
        }
        if (this.currentType != -1 || ((arrayList = this.exceptions) != null && !arrayList.isEmpty())) {
            int i13 = this.rowCount;
            this.rowCount = i13 + 1;
            this.exceptionsSection2Row = i13;
        } else {
            this.exceptionsSection2Row = -1;
        }
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList3 = this.exceptions;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int i14 = this.rowCount;
            int i15 = i14 + 1;
            this.rowCount = i15;
            this.deleteAllRow = i14;
            this.rowCount = i15 + 1;
            this.deleteAllSectionRow = i15;
        } else {
            this.deleteAllRow = -1;
            this.deleteAllSectionRow = -1;
        }
        if (!notify || (listAdapter = this.adapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        Ringtone ringtone;
        if (resultCode == -1) {
            Uri uri = (Uri) data.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            String title = null;
            if (uri != null && (ringtone = RingtoneManager.getRingtone(getParentActivity(), uri)) != null) {
                if (uri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
                    title = LocaleController.getString("SoundDefault", R.string.SoundDefault);
                } else {
                    title = ringtone.getTitle(getParentActivity());
                }
                ringtone.stop();
            }
            SharedPreferences.Editor editorEdit = getNotificationsSettings().edit();
            int i = this.currentType;
            if (i == 1) {
                if (title != null && uri != null) {
                    editorEdit.putString("GlobalSound", title);
                    editorEdit.putString("GlobalSoundPath", uri.toString());
                } else {
                    editorEdit.putString("GlobalSound", "NoSound");
                    editorEdit.putString("GlobalSoundPath", "NoSound");
                }
            } else if (i == 0) {
                if (title != null && uri != null) {
                    editorEdit.putString("GroupSound", title);
                    editorEdit.putString("GroupSoundPath", uri.toString());
                } else {
                    editorEdit.putString("GroupSound", "NoSound");
                    editorEdit.putString("GroupSoundPath", "NoSound");
                }
            } else if (i == 2) {
                if (title != null && uri != null) {
                    editorEdit.putString("ChannelSound", title);
                    editorEdit.putString("ChannelSoundPath", uri.toString());
                } else {
                    editorEdit.putString("ChannelSound", "NoSound");
                    editorEdit.putString("ChannelSoundPath", "NoSound");
                }
            }
            getNotificationsController().deleteNotificationChannelGlobal(this.currentType);
            editorEdit.commit();
            getNotificationsController().updateServerNotificationsSettings(this.currentType);
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(requestCode);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, requestCode);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private SearchAdapterHelper searchAdapterHelper;
        private ArrayList<NotificationsSettingsActivity.NotificationException> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private Runnable searchRunnable;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public SearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$SearchAdapter$Q9v_Ia6u0iSeJkOArd5NU7_ldiY
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0$NotificationsCustomSettingsActivity$SearchAdapter(i);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$NotificationsCustomSettingsActivity$SearchAdapter(int i) {
            if (this.searchRunnable == null && !this.searchAdapterHelper.isSearchInProgress()) {
                NotificationsCustomSettingsActivity.this.emptyView.showTextView();
            }
            notifyDataSetChanged();
        }

        public void searchDialogs(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (query == null) {
                this.searchResult.clear();
                this.searchResultNames.clear();
                this.searchAdapterHelper.mergeResults(null);
                this.searchAdapterHelper.queryServerSearch(null, true, NotificationsCustomSettingsActivity.this.currentType != 1, true, false, false, 0L, false, 0, 0);
                notifyDataSetChanged();
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$SearchAdapter$GOMHJOKL9odYLNw05MaPFBjSkrc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$1$NotificationsCustomSettingsActivity$SearchAdapter(query);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$searchDialogs$1$NotificationsCustomSettingsActivity$SearchAdapter(final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$SearchAdapter$HV23XMqlpB0OKV1skrUedaZYpPc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$3$NotificationsCustomSettingsActivity$SearchAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$3$NotificationsCustomSettingsActivity$SearchAdapter(final String str) {
            this.searchAdapterHelper.queryServerSearch(str, true, NotificationsCustomSettingsActivity.this.currentType != 1, true, false, false, 0L, false, 0, 0);
            final ArrayList arrayList = new ArrayList(NotificationsCustomSettingsActivity.this.exceptions);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$SearchAdapter$K4jDBLYZ1n_LFteuZL99YDwJs9Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2$NotificationsCustomSettingsActivity$SearchAdapter(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01e0 A[LOOP:1: B:56:0x013e->B:84:0x01e0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01a1 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v9, types: [ir.eitaa.tgnet.TLRPC$User] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$2$NotificationsCustomSettingsActivity$SearchAdapter(java.lang.String r20, java.util.ArrayList r21) {
            /*
                Method dump skipped, instructions count: 513
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.NotificationsCustomSettingsActivity.SearchAdapter.lambda$processSearch$2$NotificationsCustomSettingsActivity$SearchAdapter(java.lang.String, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<Object> result, final ArrayList<NotificationsSettingsActivity.NotificationException> exceptions, final ArrayList<CharSequence> names) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$SearchAdapter$ohkTFkq8Wamct4T9T0w_WdaCKmM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4$NotificationsCustomSettingsActivity$SearchAdapter(exceptions, names, result);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$4$NotificationsCustomSettingsActivity$SearchAdapter(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            if (NotificationsCustomSettingsActivity.this.searching) {
                this.searchRunnable = null;
                this.searchResult = arrayList;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList3);
                if (NotificationsCustomSettingsActivity.this.searching && !this.searchAdapterHelper.isSearchInProgress()) {
                    NotificationsCustomSettingsActivity.this.emptyView.showTextView();
                }
                notifyDataSetChanged();
            }
        }

        public Object getObject(int position) {
            if (position >= 0 && position < this.searchResult.size()) {
                return this.searchResult.get(position);
            }
            int size = position - (this.searchResult.size() + 1);
            ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
            if (size < 0 || size >= globalSearch.size()) {
                return null;
            }
            return this.searchAdapterHelper.getGlobalSearch().get(size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size();
            ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
            return !globalSearch.isEmpty() ? size + globalSearch.size() + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View userCell;
            if (viewType == 0) {
                userCell = new UserCell(this.mContext, 4, 0, false, true);
                userCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                userCell = new GraySectionCell(this.mContext);
            }
            return new RecyclerListView.Holder(userCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                ((GraySectionCell) holder.itemView).setText(LocaleController.getString("AddToExceptions", R.string.AddToExceptions));
                return;
            }
            UserCell userCell = (UserCell) holder.itemView;
            if (position < this.searchResult.size()) {
                userCell.setException(this.searchResult.get(position), this.searchResultNames.get(position), position != this.searchResult.size() - 1);
                userCell.setAddButtonVisible(false);
            } else {
                int size = position - (this.searchResult.size() + 1);
                ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
                userCell.setData(globalSearch.get(size), null, LocaleController.getString("NotificationsOn", R.string.NotificationsOn), 0, size != globalSearch.size() - 1);
                userCell.setAddButtonVisible(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position == this.searchResult.size() ? 1 : 0;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return (itemViewType == 0 || itemViewType == 4) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NotificationsCustomSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View headerCell;
            switch (viewType) {
                case 0:
                    headerCell = new HeaderCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 1:
                    headerCell = new TextCheckCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 2:
                    headerCell = new UserCell(this.mContext, 6, 0, false);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 3:
                    headerCell = new TextColorCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 4:
                    headerCell = new ShadowSectionCell(this.mContext);
                    break;
                case 5:
                    headerCell = new TextSettingsCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 6:
                    headerCell = new NotificationsCheckCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                default:
                    headerCell = new TextCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            boolean z;
            int i2;
            int i3;
            String string;
            int i4;
            int i5;
            String string2;
            String string3;
            int i6;
            int i7;
            int i8 = 0;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                        headerCell.setText(LocaleController.getString("SETTINGS", R.string.SETTINGS));
                        break;
                    }
                    break;
                case 1:
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (i == NotificationsCustomSettingsActivity.this.previewRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                z = notificationsSettings.getBoolean("EnablePreviewGroup", true);
                            } else {
                                z = notificationsSettings.getBoolean("EnablePreviewChannel", true);
                            }
                        } else {
                            z = notificationsSettings.getBoolean("EnablePreviewAll", true);
                        }
                        textCheckCell.setTextAndCheck(LocaleController.getString("MessagePreview", R.string.MessagePreview), z, true);
                        break;
                    }
                    break;
                case 2:
                    ((UserCell) viewHolder.itemView).setException((NotificationsSettingsActivity.NotificationException) NotificationsCustomSettingsActivity.this.exceptions.get(i - NotificationsCustomSettingsActivity.this.exceptionsStartRow), null, i != NotificationsCustomSettingsActivity.this.exceptionsEndRow - 1);
                    break;
                case 3:
                    TextColorCell textColorCell = (TextColorCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings2 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                        if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                            i2 = notificationsSettings2.getInt("GroupLed", -16776961);
                        } else {
                            i2 = notificationsSettings2.getInt("ChannelLed", -16776961);
                        }
                    } else {
                        i2 = notificationsSettings2.getInt("MessagesLed", -16776961);
                    }
                    while (true) {
                        if (i8 < 9) {
                            if (TextColorCell.colorsToSave[i8] == i2) {
                                i2 = TextColorCell.colors[i8];
                            } else {
                                i8++;
                            }
                        }
                    }
                    textColorCell.setTextAndColor(LocaleController.getString("LedColor", R.string.LedColor), i2, true);
                    break;
                case 4:
                    if (i == NotificationsCustomSettingsActivity.this.deleteAllSectionRow || ((i == NotificationsCustomSettingsActivity.this.groupSection2Row && NotificationsCustomSettingsActivity.this.exceptionsSection2Row == -1) || (i == NotificationsCustomSettingsActivity.this.exceptionsSection2Row && NotificationsCustomSettingsActivity.this.deleteAllRow == -1))) {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        break;
                    } else {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        break;
                    }
                case 5:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings3 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (i == NotificationsCustomSettingsActivity.this.messageSoundRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                string2 = notificationsSettings3.getString("GroupSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                            } else {
                                string2 = notificationsSettings3.getString("ChannelSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                            }
                        } else {
                            string2 = notificationsSettings3.getString("GlobalSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                        }
                        if (string2.equals("NoSound")) {
                            string2 = LocaleController.getString("NoSound", R.string.NoSound);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("Sound", R.string.Sound), string2, true);
                        break;
                    } else if (i == NotificationsCustomSettingsActivity.this.messageVibrateRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i5 = notificationsSettings3.getInt("vibrate_group", 0);
                            } else {
                                i5 = notificationsSettings3.getInt("vibrate_channel", 0);
                            }
                        } else {
                            i5 = notificationsSettings3.getInt("vibrate_messages", 0);
                        }
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        if (i5 == 4) {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("OnlyIfSilent", R.string.OnlyIfSilent), true);
                                            break;
                                        }
                                    } else {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Long", R.string.Long), true);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled), true);
                                    break;
                                }
                            } else {
                                textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Short", R.string.Short), true);
                                break;
                            }
                        } else {
                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDefault", R.string.VibrationDefault), true);
                            break;
                        }
                    } else if (i == NotificationsCustomSettingsActivity.this.messagePriorityRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i4 = notificationsSettings3.getInt("priority_group", 1);
                            } else {
                                i4 = notificationsSettings3.getInt("priority_channel", 1);
                            }
                        } else {
                            i4 = notificationsSettings3.getInt("priority_messages", 1);
                        }
                        if (i4 != 0) {
                            if (i4 != 1 && i4 != 2) {
                                if (i4 != 4) {
                                    if (i4 == 5) {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium), false);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow), false);
                                    break;
                                }
                            } else {
                                textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent), false);
                                break;
                            }
                        } else {
                            textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh), false);
                            break;
                        }
                    } else if (i == NotificationsCustomSettingsActivity.this.messagePopupNotificationRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i3 = notificationsSettings3.getInt("popupGroup", 0);
                            } else {
                                i3 = notificationsSettings3.getInt("popupChannel", 0);
                            }
                        } else {
                            i3 = notificationsSettings3.getInt("popupAll", 0);
                        }
                        if (i3 == 0) {
                            string = LocaleController.getString("NoPopup", R.string.NoPopup);
                        } else if (i3 == 1) {
                            string = LocaleController.getString("OnlyWhenScreenOn", R.string.OnlyWhenScreenOn);
                        } else if (i3 == 2) {
                            string = LocaleController.getString("OnlyWhenScreenOff", R.string.OnlyWhenScreenOff);
                        } else {
                            string = LocaleController.getString("AlwaysShowPopup", R.string.AlwaysShowPopup);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("PopupNotification", R.string.PopupNotification), string, true);
                        break;
                    }
                    break;
                case 6:
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                    notificationsCheckCell.setDrawLine(false);
                    StringBuilder sb = new StringBuilder();
                    SharedPreferences notificationsSettings4 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                        if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                            string3 = LocaleController.getString("NotificationsForGroups", R.string.NotificationsForGroups);
                            i6 = notificationsSettings4.getInt("EnableGroup2", 0);
                        } else {
                            string3 = LocaleController.getString("NotificationsForChannels", R.string.NotificationsForChannels);
                            i6 = notificationsSettings4.getInt("EnableChannel2", 0);
                        }
                    } else {
                        string3 = LocaleController.getString("NotificationsForPrivateChats", R.string.NotificationsForPrivateChats);
                        i6 = notificationsSettings4.getInt("EnableAll2", 0);
                    }
                    String str = string3;
                    int currentTime = NotificationsCustomSettingsActivity.this.getConnectionsManager().getCurrentTime();
                    boolean z2 = i6 < currentTime;
                    if (!z2) {
                        if (i6 - 31536000 >= currentTime) {
                            sb.append(LocaleController.getString("NotificationsOff", R.string.NotificationsOff));
                        } else {
                            sb.append(LocaleController.formatString("NotificationsOffUntil", R.string.NotificationsOffUntil, LocaleController.stringForMessageListDate(i6)));
                            i7 = 2;
                            notificationsCheckCell.setTextAndValueAndCheck(str, sb, z2, i7, false);
                            break;
                        }
                    } else {
                        sb.append(LocaleController.getString("NotificationsOn", R.string.NotificationsOn));
                    }
                    i7 = 0;
                    notificationsCheckCell.setTextAndValueAndCheck(str, sb, z2, i7, false);
                case 7:
                    TextCell textCell = (TextCell) viewHolder.itemView;
                    if (i == NotificationsCustomSettingsActivity.this.exceptionsAddRow) {
                        textCell.setTextAndIcon(LocaleController.getString("NotificationsAddAnException", R.string.NotificationsAddAnException), R.drawable.actions_addmember2, NotificationsCustomSettingsActivity.this.exceptionsStartRow != -1);
                        textCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
                        break;
                    } else if (i == NotificationsCustomSettingsActivity.this.deleteAllRow) {
                        textCell.setText(LocaleController.getString("NotificationsDeleteAllException", R.string.NotificationsDeleteAllException), false);
                        textCell.setColors(null, "windowBackgroundWhiteRedText5");
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (NotificationsCustomSettingsActivity.this.exceptions == null || !NotificationsCustomSettingsActivity.this.exceptions.isEmpty()) {
                return;
            }
            boolean zIsGlobalNotificationsEnabled = NotificationsCustomSettingsActivity.this.getNotificationsController().isGlobalNotificationsEnabled(NotificationsCustomSettingsActivity.this.currentType);
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (holder.getAdapterPosition() == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                    headerCell.setEnabled(zIsGlobalNotificationsEnabled, null);
                    return;
                } else {
                    headerCell.setEnabled(true, null);
                    return;
                }
            }
            if (itemViewType == 1) {
                ((TextCheckCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            } else if (itemViewType == 3) {
                ((TextColorCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            } else {
                if (itemViewType != 5) {
                    return;
                }
                ((TextSettingsCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                return 0;
            }
            if (position == NotificationsCustomSettingsActivity.this.previewRow) {
                return 1;
            }
            if (position >= NotificationsCustomSettingsActivity.this.exceptionsStartRow && position < NotificationsCustomSettingsActivity.this.exceptionsEndRow) {
                return 2;
            }
            if (position == NotificationsCustomSettingsActivity.this.messageLedRow) {
                return 3;
            }
            if (position == NotificationsCustomSettingsActivity.this.groupSection2Row || position == NotificationsCustomSettingsActivity.this.alertSection2Row || position == NotificationsCustomSettingsActivity.this.exceptionsSection2Row || position == NotificationsCustomSettingsActivity.this.deleteAllSectionRow) {
                return 4;
            }
            if (position == NotificationsCustomSettingsActivity.this.alertRow) {
                return 6;
            }
            return (position == NotificationsCustomSettingsActivity.this.exceptionsAddRow || position == NotificationsCustomSettingsActivity.this.deleteAllRow) ? 7 : 5;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsCustomSettingsActivity$TYimE0SaMWrEjqnB4BndDBujB3A
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$12$NotificationsCustomSettingsActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCheckCell.class, TextColorCell.class, TextSettingsCell.class, UserCell.class, NotificationsCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
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
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextColorCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$12$NotificationsCustomSettingsActivity() {
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
