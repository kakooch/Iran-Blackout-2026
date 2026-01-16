package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class SearchAdapter extends RecyclerListView.SelectionAdapter {
    private boolean allowBots;
    private boolean allowChats;
    private boolean allowPhoneNumbers;
    private boolean allowSelf;
    private boolean allowUsernameSearch;
    private CallOutManager.CallOutDelegate callOutDelegate;
    private long channelId;
    private LongSparseArray<?> checkedMap;
    private LongSparseArray<TLRPC$User> ignoreUsers;
    private Context mContext;
    private boolean onlyMutual;
    private SearchAdapterHelper searchAdapterHelper;
    private boolean searchInProgress;
    private int searchPointer;
    private int searchReqId;
    private ArrayList<Object> searchResult = new ArrayList<>();
    private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
    private Timer searchTimer;
    private boolean useUserCell;

    protected void onSearchProgressChanged() {
        throw null;
    }

    public SearchAdapter(Context context, LongSparseArray<TLRPC$User> arg1, boolean usernameSearch, boolean mutual, boolean chats, boolean bots, boolean self, boolean phones, int searchChannelId) {
        this.mContext = context;
        this.ignoreUsers = arg1;
        this.onlyMutual = mutual;
        this.allowUsernameSearch = usernameSearch;
        this.allowChats = chats;
        this.allowBots = bots;
        this.channelId = searchChannelId;
        this.allowSelf = self;
        this.allowPhoneNumbers = phones;
        SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
        this.searchAdapterHelper = searchAdapterHelper;
        searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.Adapters.SearchAdapter.1
            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ boolean canApplySearchResults(int i) {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onDataSetChanged(int searchId) {
                SearchAdapter.this.notifyDataSetChanged();
                if (searchId != 0) {
                    SearchAdapter.this.onSearchProgressChanged();
                }
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public LongSparseArray<TLRPC$User> getExcludeUsers() {
                return SearchAdapter.this.ignoreUsers;
            }
        });
    }

    public void searchDialogs(final String query) {
        try {
            Timer timer = this.searchTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.searchResult.clear();
        this.searchResultNames.clear();
        if (this.allowUsernameSearch) {
            this.searchAdapterHelper.queryServerSearch(null, true, this.allowChats, this.allowBots, this.allowSelf, false, this.channelId, this.allowPhoneNumbers, 0, 0);
        }
        notifyDataSetChanged();
        if (TextUtils.isEmpty(query)) {
            return;
        }
        Timer timer2 = new Timer();
        this.searchTimer = timer2;
        timer2.schedule(new TimerTask() { // from class: ir.eitaa.ui.Adapters.SearchAdapter.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    SearchAdapter.this.searchTimer.cancel();
                    SearchAdapter.this.searchTimer = null;
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
                SearchAdapter.this.processSearch(query);
            }
        }, 200L, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSearch(final String query) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapter$DUOEBfN3pnGFzQRMrnE3pN7f8aQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSearch$1$SearchAdapter(query);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSearch$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSearch$1$SearchAdapter(final String str) {
        if (this.allowUsernameSearch) {
            this.searchAdapterHelper.queryServerSearch(str, true, this.allowChats, this.allowBots, this.allowSelf, false, this.channelId, this.allowPhoneNumbers, -1, 1);
        }
        final int i = UserConfig.selectedAccount;
        final ArrayList arrayList = new ArrayList(ContactsController.getInstance(i).contacts);
        this.searchInProgress = true;
        final int i2 = this.searchPointer;
        this.searchPointer = i2 + 1;
        this.searchReqId = i2;
        Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapter$PU1uKJzZNHTfk_ITXdUkdnJ0haA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSearch$0$SearchAdapter(str, i2, arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSearch$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSearch$0$SearchAdapter(String str, int i, ArrayList arrayList, int i2) {
        LongSparseArray<TLRPC$User> longSparseArray;
        int i3;
        String str2;
        String str3;
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.length() == 0) {
            updateSearchResults(i, new ArrayList<>(), new ArrayList<>());
            return;
        }
        String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
        String str4 = null;
        if (lowerCase.equals(translitString) || translitString.length() == 0) {
            translitString = null;
        }
        char c = 0;
        char c2 = 1;
        int i4 = (translitString != null ? 1 : 0) + 1;
        String[] strArr = new String[i4];
        strArr[0] = lowerCase;
        if (translitString != null) {
            strArr[1] = translitString;
        }
        ArrayList<Object> arrayList2 = new ArrayList<>();
        ArrayList<CharSequence> arrayList3 = new ArrayList<>();
        int i5 = 0;
        while (i5 < arrayList.size()) {
            TLRPC$TL_contact tLRPC$TL_contact = (TLRPC$TL_contact) arrayList.get(i5);
            TLRPC$User user = MessagesController.getInstance(i2).getUser(Long.valueOf(tLRPC$TL_contact.user_id));
            if ((this.allowSelf || !user.self) && ((!this.onlyMutual || user.mutual_contact) && ((longSparseArray = this.ignoreUsers) == null || longSparseArray.indexOfKey(tLRPC$TL_contact.user_id) < 0))) {
                int i6 = 3;
                String[] strArr2 = new String[3];
                strArr2[c] = ContactsController.formatName(user.first_name, user.last_name).toLowerCase();
                strArr2[c2] = LocaleController.getInstance().getTranslitString(strArr2[c]);
                if (strArr2[c].equals(strArr2[c2])) {
                    strArr2[c2] = str4;
                }
                if (UserObject.isReplyUser(user)) {
                    strArr2[2] = LocaleController.getString("RepliesTitle", R.string.RepliesTitle).toLowerCase();
                } else if (user.self) {
                    strArr2[2] = LocaleController.getString("SavedMessages", R.string.SavedMessages).toLowerCase();
                }
                int i7 = 0;
                char c3 = 0;
                while (i7 < i4) {
                    String str5 = strArr[i7];
                    int i8 = 0;
                    while (i8 < i6) {
                        String str6 = strArr2[i8];
                        if (str6 != null) {
                            if (str6.startsWith(str5)) {
                                i3 = i4;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                i3 = i4;
                                sb.append(" ");
                                sb.append(str5);
                                if (str6.contains(sb.toString())) {
                                }
                            }
                            c3 = 1;
                            break;
                        }
                        i3 = i4;
                        i8++;
                        i4 = i3;
                        i6 = 3;
                    }
                    i3 = i4;
                    if (c3 == 0 && (str3 = user.username) != null && str3.startsWith(str5)) {
                        c3 = 2;
                    }
                    if (c3 != 0) {
                        if (c3 == 1) {
                            arrayList3.add(AndroidUtilities.generateSearchName(user.first_name, user.last_name, str5));
                            str2 = null;
                        } else {
                            str2 = null;
                            arrayList3.add(AndroidUtilities.generateSearchName("@" + user.username, null, "@" + str5));
                        }
                        arrayList2.add(user);
                    } else {
                        i7++;
                        str4 = null;
                        i4 = i3;
                        i6 = 3;
                    }
                }
                i3 = i4;
                str2 = str4;
            } else {
                i3 = i4;
                str2 = str4;
            }
            i5++;
            str4 = str2;
            i4 = i3;
            c = 0;
            c2 = 1;
        }
        updateSearchResults(i, arrayList2, arrayList3);
    }

    private void updateSearchResults(final int searchReqIdFinal, final ArrayList<Object> users, final ArrayList<CharSequence> names) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapter$BWxI6uV235L7pvqZuMNTdvFw48Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateSearchResults$2$SearchAdapter(searchReqIdFinal, users, names);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSearchResults$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSearchResults$2$SearchAdapter(int i, ArrayList arrayList, ArrayList arrayList2) {
        if (i == this.searchReqId) {
            this.searchResult = arrayList;
            this.searchResultNames = arrayList2;
            this.searchAdapterHelper.mergeResults(arrayList);
            this.searchInProgress = false;
            notifyDataSetChanged();
            onSearchProgressChanged();
        }
    }

    public boolean searchInProgress() {
        return this.searchInProgress || this.searchAdapterHelper.isSearchInProgress();
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        int itemViewType = holder.getItemViewType();
        return itemViewType == 0 || itemViewType == 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.searchResult.size();
        int size2 = this.searchAdapterHelper.getGlobalSearch().size();
        if (size2 != 0) {
            size += size2 + 1;
        }
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        return size3 != 0 ? size + size3 : size;
    }

    public boolean isGlobalSearch(int i) {
        int size = this.searchResult.size();
        int size2 = this.searchAdapterHelper.getGlobalSearch().size();
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        if (i < 0 || i >= size) {
            return (i <= size || i >= size + size3) && i > size + size3 && i <= (size2 + size3) + size;
        }
        return false;
    }

    public Object getItem(int i) {
        int size = this.searchResult.size();
        int size2 = this.searchAdapterHelper.getGlobalSearch().size();
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        if (i >= 0 && i < size) {
            return this.searchResult.get(i);
        }
        int i2 = i - size;
        if (i2 >= 0 && i2 < size3) {
            return this.searchAdapterHelper.getPhoneSearch().get(i2);
        }
        int i3 = i2 - size3;
        if (i3 <= 0 || i3 > size2) {
            return null;
        }
        return this.searchAdapterHelper.getGlobalSearch().get(i3 - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View profileSearchCell;
        if (i != 0) {
            if (i == 1) {
                profileSearchCell = new GraySectionCell(this.mContext);
            } else {
                profileSearchCell = new TextCell(this.mContext, 16, false);
            }
        } else if (this.useUserCell) {
            UserCell userCell = new UserCell(this.mContext, 1, 1, false, true);
            profileSearchCell = userCell;
            if (this.checkedMap != null) {
                userCell.setChecked(false, false);
                profileSearchCell = userCell;
            }
        } else {
            profileSearchCell = new ProfileSearchCell(this.mContext);
        }
        return new RecyclerListView.Holder(profileSearchCell);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.SearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item == null) {
            return 1;
        }
        if (item instanceof String) {
            return "section".equals((String) item) ? 1 : 2;
        }
        return 0;
    }

    public void setCallOutDelegate(CallOutManager.CallOutDelegate callOutDelegate) {
        this.callOutDelegate = callOutDelegate;
    }
}
