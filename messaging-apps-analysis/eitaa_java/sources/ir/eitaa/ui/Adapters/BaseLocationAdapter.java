package ir.eitaa.ui.Adapters;

import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaVenue;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class BaseLocationAdapter extends RecyclerListView.SelectionAdapter {
    private int currentRequestNum;
    protected boolean searching;
    protected ArrayList<TLRPC$TL_messageMediaVenue> places = new ArrayList<>();
    protected ArrayList<String> iconUrls = new ArrayList<>();
    private int currentAccount = UserConfig.selectedAccount;

    public void destroy() {
        if (this.currentRequestNum != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.currentRequestNum, true);
            this.currentRequestNum = 0;
        }
    }
}
