package org.rbmain.ui.Adapters;

import android.location.Location;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineMessage;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaVenue;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputGeoPoint;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.tgnet.TLRPC$TL_messages_getInlineBotResults;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$messages_BotResults;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public abstract class BaseLocationAdapter extends RecyclerListView.SelectionAdapter {
    private int currentRequestNum;
    private BaseLocationAdapterDelegate delegate;
    private long dialogId;
    private String lastFoundQuery;
    private Location lastSearchLocation;
    private String lastSearchQuery;
    private boolean searchInProgress;
    private Runnable searchRunnable;
    protected boolean searching;
    private boolean searchingUser;
    protected ArrayList<TLRPC$TL_messageMediaVenue> places = new ArrayList<>();
    protected ArrayList<String> iconUrls = new ArrayList<>();
    private int currentAccount = UserConfig.selectedAccount;

    public interface BaseLocationAdapterDelegate {
        void didLoadSearchResult(ArrayList<TLRPC$TL_messageMediaVenue> arrayList);
    }

    public void destroy() {
        if (this.currentRequestNum != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.currentRequestNum, true);
            this.currentRequestNum = 0;
        }
    }

    public void setDelegate(long j, BaseLocationAdapterDelegate baseLocationAdapterDelegate) {
        this.dialogId = j;
        this.delegate = baseLocationAdapterDelegate;
    }

    public void searchDelayed(final String str, final Location location) {
        if (str == null || str.length() == 0) {
            this.places.clear();
            this.searchInProgress = false;
            notifyDataSetChanged();
            return;
        }
        if (this.searchRunnable != null) {
            Utilities.searchQueue.cancelRunnable(this.searchRunnable);
            this.searchRunnable = null;
        }
        this.searchInProgress = true;
        DispatchQueue dispatchQueue = Utilities.searchQueue;
        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDelayed$1(str, location);
            }
        };
        this.searchRunnable = runnable;
        dispatchQueue.postRunnable(runnable, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDelayed$1(final String str, final Location location) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDelayed$0(str, location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDelayed$0(String str, Location location) {
        this.searchRunnable = null;
        this.lastSearchLocation = null;
        searchPlacesWithQuery(str, location, true);
    }

    private void searchBotUser() {
        if (this.searchingUser) {
            return;
        }
        this.searchingUser = true;
        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
        tLRPC$TL_contacts_resolveUsername.username = MessagesController.getInstance(this.currentAccount).venueSearchBot;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda4
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchBotUser$3(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchBotUser$3(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchBotUser$2(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchBotUser$2(TLObject tLObject) {
        TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
        MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
        MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
        MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
        Location location = this.lastSearchLocation;
        this.lastSearchLocation = null;
        searchPlacesWithQuery(this.lastSearchQuery, location, false);
    }

    public boolean isSearching() {
        return this.searchInProgress;
    }

    public String getLastSearchString() {
        return this.lastFoundQuery;
    }

    public void searchPlacesWithQuery(String str, Location location, boolean z) {
        searchPlacesWithQuery(str, location, z, false);
    }

    public void searchPlacesWithQuery(final String str, Location location, boolean z, boolean z2) {
        if (location != null) {
            Location location2 = this.lastSearchLocation;
            if (location2 == null || location.distanceTo(location2) >= 200.0f) {
                this.lastSearchLocation = new Location(location);
                this.lastSearchQuery = str;
                if (this.searching) {
                    this.searching = false;
                    if (this.currentRequestNum != 0) {
                        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.currentRequestNum, true);
                        this.currentRequestNum = 0;
                    }
                }
                int itemCount = getItemCount();
                boolean z3 = this.searching;
                this.searching = true;
                TLObject userOrChat = MessagesController.getInstance(this.currentAccount).getUserOrChat(MessagesController.getInstance(this.currentAccount).venueSearchBot);
                if (!(userOrChat instanceof TLRPC$User)) {
                    if (z) {
                        searchBotUser();
                    }
                    if (z2 && Build.VERSION.SDK_INT >= 19) {
                        if (this.places.isEmpty() || z3) {
                            if (z3) {
                                return;
                            }
                            notifyItemChanged(getItemCount() - 1);
                            return;
                        } else {
                            int size = this.places.size() + 1;
                            int i = itemCount - size;
                            notifyItemInserted(i);
                            notifyItemRangeRemoved(i, size);
                            return;
                        }
                    }
                    notifyDataSetChanged();
                    return;
                }
                TLRPC$User tLRPC$User = (TLRPC$User) userOrChat;
                TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
                tLRPC$TL_messages_getInlineBotResults.query = str == null ? BuildConfig.FLAVOR : str;
                tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(this.currentAccount).getInputUser(tLRPC$User);
                tLRPC$TL_messages_getInlineBotResults.offset = BuildConfig.FLAVOR;
                TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
                tLRPC$TL_messages_getInlineBotResults.geo_point = tLRPC$TL_inputGeoPoint;
                tLRPC$TL_inputGeoPoint.lat = AndroidUtilities.fixLocationCoord(location.getLatitude());
                tLRPC$TL_messages_getInlineBotResults.geo_point._long = AndroidUtilities.fixLocationCoord(location.getLongitude());
                tLRPC$TL_messages_getInlineBotResults.flags |= 1;
                int i2 = (int) this.dialogId;
                if (i2 != 0) {
                    tLRPC$TL_messages_getInlineBotResults.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(i2);
                } else {
                    tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
                }
                this.currentRequestNum = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, new RequestDelegate() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda5
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$searchPlacesWithQuery$5(str, tLObject, tLRPC$TL_error);
                    }
                });
                if (z2 && Build.VERSION.SDK_INT >= 19) {
                    if (this.places.isEmpty() || z3) {
                        if (z3) {
                            return;
                        }
                        notifyItemChanged(getItemCount() - 1);
                        return;
                    } else {
                        int size2 = this.places.size() + 1;
                        int i3 = itemCount - size2;
                        notifyItemInserted(i3);
                        notifyItemRangeRemoved(i3, size2);
                        return;
                    }
                }
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchPlacesWithQuery$5(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.BaseLocationAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchPlacesWithQuery$4(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchPlacesWithQuery$4(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.currentRequestNum = 0;
        this.searching = false;
        this.places.clear();
        this.iconUrls.clear();
        this.searchInProgress = false;
        this.lastFoundQuery = str;
        if (tLRPC$TL_error == null) {
            TLRPC$messages_BotResults tLRPC$messages_BotResults = (TLRPC$messages_BotResults) tLObject;
            int size = tLRPC$messages_BotResults.results.size();
            for (int i = 0; i < size; i++) {
                TLRPC$BotInlineResult tLRPC$BotInlineResult = tLRPC$messages_BotResults.results.get(i);
                if ("venue".equals(tLRPC$BotInlineResult.type)) {
                    TLRPC$BotInlineMessage tLRPC$BotInlineMessage = tLRPC$BotInlineResult.send_message;
                    if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaVenue) {
                        TLRPC$TL_botInlineMessageMediaVenue tLRPC$TL_botInlineMessageMediaVenue = (TLRPC$TL_botInlineMessageMediaVenue) tLRPC$BotInlineMessage;
                        this.iconUrls.add("https://ss3.4sqi.net/img/categories_v2/" + tLRPC$TL_botInlineMessageMediaVenue.venue_type + "_64.png");
                        TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue = new TLRPC$TL_messageMediaVenue();
                        tLRPC$TL_messageMediaVenue.geo = tLRPC$TL_botInlineMessageMediaVenue.geo;
                        tLRPC$TL_messageMediaVenue.address = tLRPC$TL_botInlineMessageMediaVenue.address;
                        tLRPC$TL_messageMediaVenue.title = tLRPC$TL_botInlineMessageMediaVenue.title;
                        tLRPC$TL_messageMediaVenue.venue_type = tLRPC$TL_botInlineMessageMediaVenue.venue_type;
                        tLRPC$TL_messageMediaVenue.venue_id = tLRPC$TL_botInlineMessageMediaVenue.venue_id;
                        tLRPC$TL_messageMediaVenue.provider = tLRPC$TL_botInlineMessageMediaVenue.provider;
                        this.places.add(tLRPC$TL_messageMediaVenue);
                    }
                }
            }
        }
        BaseLocationAdapterDelegate baseLocationAdapterDelegate = this.delegate;
        if (baseLocationAdapterDelegate != null) {
            baseLocationAdapterDelegate.didLoadSearchResult(this.places);
        }
        notifyDataSetChanged();
    }
}
