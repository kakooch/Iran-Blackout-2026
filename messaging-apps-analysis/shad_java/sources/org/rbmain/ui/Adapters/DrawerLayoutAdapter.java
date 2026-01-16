package org.rbmain.ui.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.DividerCell;
import org.rbmain.ui.Cells.DrawerActionCell;
import org.rbmain.ui.Cells.DrawerAddCell;
import org.rbmain.ui.Cells.DrawerProfileCell;
import org.rbmain.ui.Cells.DrawerUserCell;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SideMenultItemAnimator;

/* loaded from: classes4.dex */
public class DrawerLayoutAdapter extends RecyclerListView.SelectionAdapter {
    private boolean accountsShown;
    private boolean hasGps;
    private SideMenultItemAnimator itemAnimator;
    private Context mContext;
    private DrawerProfileCell profileCell;
    private ArrayList<Item> items = new ArrayList<>(11);
    private ArrayList<Integer> accountNumbers = new ArrayList<>();

    public DrawerLayoutAdapter(Context context, SideMenultItemAnimator sideMenultItemAnimator) throws Resources.NotFoundException {
        this.mContext = context;
        this.itemAnimator = sideMenultItemAnimator;
        this.accountsShown = UserConfig.getActivatedAccountsCount() > 1 && MessagesController.getGlobalMainSettings().getBoolean("accountsShown", true);
        Theme.createDialogsResources(context);
        resetItems();
        try {
            this.hasGps = ApplicationLoader.applicationContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
        } catch (Throwable unused) {
            this.hasGps = false;
        }
    }

    private int getAccountRowsCount() {
        int size = this.accountNumbers.size() + 1;
        return this.accountNumbers.size() < 3 ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.items.size() + 2;
        return this.accountsShown ? size + getAccountRowsCount() : size;
    }

    public void setAccountsShown(boolean z, boolean z2) {
        if (this.accountsShown == z || this.itemAnimator.isRunning()) {
            return;
        }
        this.accountsShown = z;
        DrawerProfileCell drawerProfileCell = this.profileCell;
        if (drawerProfileCell != null) {
            drawerProfileCell.setAccountsShown(z, z2);
        }
        MessagesController.getGlobalMainSettings().edit().putBoolean("accountsShown", this.accountsShown).apply();
        if (z2) {
            this.itemAnimator.setShouldClipChildren(false);
            if (this.accountsShown) {
                notifyItemRangeInserted(2, getAccountRowsCount());
                return;
            } else {
                notifyItemRangeRemoved(2, getAccountRowsCount());
                return;
            }
        }
        notifyDataSetChanged();
    }

    public boolean isAccountsShown() {
        return this.accountsShown;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyDataSetChanged() {
        resetItems();
        super.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 3 || itemViewType == 4 || itemViewType == 5 || itemViewType == 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View dividerCell;
        if (i == 0) {
            DrawerProfileCell drawerProfileCell = new DrawerProfileCell(this.mContext);
            this.profileCell = drawerProfileCell;
            dividerCell = drawerProfileCell;
        } else if (i == 2) {
            dividerCell = new DividerCell(this.mContext);
        } else if (i == 3) {
            dividerCell = new DrawerActionCell(this.mContext);
        } else if (i == 4) {
            dividerCell = new DrawerUserCell(this.mContext);
        } else if (i == 5) {
            dividerCell = new DrawerAddCell(this.mContext);
        } else {
            dividerCell = new EmptyCell(this.mContext, AndroidUtilities.dp(8.0f));
        }
        dividerCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new RecyclerListView.Holder(dividerCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            ((DrawerProfileCell) viewHolder.itemView).setUser(MessagesController.getInstance(UserConfig.selectedAccount).getUser(Integer.valueOf(UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId())), this.accountsShown);
            return;
        }
        if (itemViewType != 3) {
            if (itemViewType != 4) {
                return;
            }
            ((DrawerUserCell) viewHolder.itemView).setAccount(this.accountNumbers.get(i - 2).intValue());
        } else {
            DrawerActionCell drawerActionCell = (DrawerActionCell) viewHolder.itemView;
            int accountRowsCount = i - 2;
            if (this.accountsShown) {
                accountRowsCount -= getAccountRowsCount();
            }
            this.items.get(accountRowsCount).bind(drawerActionCell);
            drawerActionCell.setPadding(0, 0, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        int accountRowsCount = i - 2;
        if (this.accountsShown) {
            if (accountRowsCount < this.accountNumbers.size()) {
                return 4;
            }
            if (this.accountNumbers.size() < 3) {
                if (accountRowsCount == this.accountNumbers.size()) {
                    return 5;
                }
                if (accountRowsCount == this.accountNumbers.size() + 1) {
                    return 2;
                }
            } else if (accountRowsCount == this.accountNumbers.size()) {
                return 2;
            }
            accountRowsCount -= getAccountRowsCount();
        }
        return this.items.get(accountRowsCount) == null ? 2 : 3;
    }

    public void swapElements(int i, int i2) {
        int i3 = i - 2;
        int i4 = i2 - 2;
        if (i3 < 0 || i4 < 0 || i3 >= this.accountNumbers.size() || i4 >= this.accountNumbers.size()) {
            return;
        }
        UserConfig userConfig = UserConfig.getInstance(this.accountNumbers.get(i3).intValue());
        UserConfig userConfig2 = UserConfig.getInstance(this.accountNumbers.get(i4).intValue());
        int i5 = userConfig.loginTime;
        userConfig.loginTime = userConfig2.loginTime;
        userConfig2.loginTime = i5;
        userConfig.saveConfig(false);
        userConfig2.saveConfig(false);
        Collections.swap(this.accountNumbers, i3, i4);
        notifyItemMoved(i, i2);
    }

    private void resetItems() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        this.accountNumbers.clear();
        for (int i8 = 0; i8 < 3; i8++) {
            if (UserConfig.getInstance(i8).isClientActivated()) {
                this.accountNumbers.add(Integer.valueOf(i8));
            }
        }
        Collections.sort(this.accountNumbers, new Comparator() { // from class: org.rbmain.ui.Adapters.DrawerLayoutAdapter$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DrawerLayoutAdapter.lambda$resetItems$0((Integer) obj, (Integer) obj2);
            }
        });
        this.items.clear();
        if (UserConfig.getInstance(UserConfig.selectedAccount).isClientActivated()) {
            int eventType = Theme.getEventType();
            if (eventType == 0) {
                i = R.drawable.menu_groups_ny;
                i2 = R.drawable.menu_channel_ny;
                i3 = R.drawable.menu_contacts_ny;
                i4 = R.drawable.menu_calls_ny;
                i5 = R.drawable.menu_bookmarks_ny;
                i6 = R.drawable.menu_settings_ny;
                i7 = R.drawable.menu_invite_ny;
            } else if (eventType == 1) {
                i = R.drawable.menu_groups_14;
                i2 = R.drawable.menu_broadcast_14;
                i3 = R.drawable.menu_contacts_14;
                i4 = R.drawable.menu_calls_14;
                i5 = R.drawable.menu_bookmarks_14;
                i6 = R.drawable.menu_settings_14;
                i7 = R.drawable.menu_secret_ny;
            } else if (eventType == 2) {
                i = R.drawable.menu_groups_hw;
                i2 = R.drawable.menu_broadcast_hw;
                i3 = R.drawable.menu_contacts_hw;
                i4 = R.drawable.menu_calls_hw;
                i5 = R.drawable.menu_bookmarks_hw;
                i6 = R.drawable.menu_settings_hw;
                i7 = R.drawable.menu_invite_hw;
            } else {
                i = R.drawable.menu_groups;
                i2 = R.drawable.menu_broadcast;
                i3 = R.drawable.menu_contacts;
                i4 = R.drawable.menu_calls;
                i5 = R.drawable.menu_saved;
                i6 = R.drawable.menu_settings;
                i7 = R.drawable.menu_invite;
            }
            this.items.add(new Item(2, LocaleController.getString("NewGroup", R.string.NewGroup), i));
            this.items.add(new Item(4, LocaleController.getString("NewChannel", R.string.NewChannel), i2));
            this.items.add(new Item(6, LocaleController.getString("Contacts", R.string.Contacts), i3));
            this.items.add(new Item(10, LocaleController.getString("Calls", R.string.Calls), i4));
            this.items.add(new Item(11, LocaleController.getString("SavedMessages", R.string.SavedMessages), i5));
            this.items.add(new Item(15, LocaleController.getString("Language", R.string.Language), R.drawable.menu_language));
            this.items.add(new Item(8, LocaleController.getString("Settings", R.string.Settings), i6));
            this.items.add(null);
            this.items.add(new Item(7, LocaleController.getString("InviteFriends", R.string.InviteFriends), i7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$resetItems$0(Integer num, Integer num2) {
        long j = UserConfig.getInstance(num.intValue()).loginTime;
        long j2 = UserConfig.getInstance(num2.intValue()).loginTime;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public int getId(int i) {
        Item item;
        int accountRowsCount = i - 2;
        if (this.accountsShown) {
            accountRowsCount -= getAccountRowsCount();
        }
        if (accountRowsCount < 0 || accountRowsCount >= this.items.size() || (item = this.items.get(accountRowsCount)) == null) {
            return -1;
        }
        return item.id;
    }

    public int getFirstAccountPosition() {
        return !this.accountsShown ? -1 : 2;
    }

    public int getLastAccountPosition() {
        if (this.accountsShown) {
            return this.accountNumbers.size() + 1;
        }
        return -1;
    }

    private static class Item {
        public int icon;
        public int id;
        public String text;

        public Item(int i, String str, int i2) {
            this.icon = i2;
            this.id = i;
            this.text = str;
        }

        public void bind(DrawerActionCell drawerActionCell) {
            drawerActionCell.setTextAndIcon(this.text, this.icon);
        }
    }
}
