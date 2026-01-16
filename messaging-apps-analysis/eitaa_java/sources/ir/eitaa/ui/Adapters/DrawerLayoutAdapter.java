package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.DividerCell;
import ir.eitaa.ui.Cells.DrawerActionCell;
import ir.eitaa.ui.Cells.DrawerAddCell;
import ir.eitaa.ui.Cells.DrawerProfileCell;
import ir.eitaa.ui.Cells.DrawerUserCell;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SideMenultItemAnimator;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class DrawerLayoutAdapter extends RecyclerListView.SelectionAdapter {
    private boolean accountsShown;
    private boolean hasGps;
    private SideMenultItemAnimator itemAnimator;
    private Context mContext;
    private DrawerProfileCell profileCell;
    private ArrayList<Item> items = new ArrayList<>(12);
    private ArrayList<Integer> accountNumbers = new ArrayList<>();

    public DrawerLayoutAdapter(Context context, SideMenultItemAnimator animator) {
        this.mContext = context;
        this.itemAnimator = animator;
        this.accountsShown = UserConfig.getActivatedAccountsCount() > 1 && MessagesController.getGlobalMainSettings().getBoolean("accountsShown", true);
        Theme.createCommonDialogResources(context);
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

    public void setAccountsShown(boolean value, boolean animated) {
        if (this.accountsShown == value || this.itemAnimator.isRunning()) {
            return;
        }
        this.accountsShown = value;
        DrawerProfileCell drawerProfileCell = this.profileCell;
        if (drawerProfileCell != null) {
            drawerProfileCell.setAccountsShown(value, animated);
        }
        MessagesController.getGlobalMainSettings().edit().putBoolean("accountsShown", this.accountsShown).commit();
        if (animated) {
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

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        int itemViewType = holder.getItemViewType();
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            ((DrawerProfileCell) holder.itemView).setUser(MessagesController.getInstance(UserConfig.selectedAccount).getUser(Long.valueOf(UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId())), this.accountsShown);
            return;
        }
        if (itemViewType != 3) {
            if (itemViewType != 4) {
                return;
            }
            ((DrawerUserCell) holder.itemView).setAccount(this.accountNumbers.get(position - 2).intValue());
        } else {
            DrawerActionCell drawerActionCell = (DrawerActionCell) holder.itemView;
            int accountRowsCount = position - 2;
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
        return (accountRowsCount < 0 || accountRowsCount >= this.items.size() || this.items.get(accountRowsCount) != null) ? 3 : 2;
    }

    public void swapElements(int fromIndex, int toIndex) {
        int i = fromIndex - 2;
        int i2 = toIndex - 2;
        if (i < 0 || i2 < 0 || i >= this.accountNumbers.size() || i2 >= this.accountNumbers.size()) {
            return;
        }
        UserConfig userConfig = UserConfig.getInstance(this.accountNumbers.get(i).intValue());
        UserConfig userConfig2 = UserConfig.getInstance(this.accountNumbers.get(i2).intValue());
        int i3 = userConfig.loginTime;
        userConfig.loginTime = userConfig2.loginTime;
        userConfig2.loginTime = i3;
        userConfig.saveConfig(false);
        userConfig2.saveConfig(false);
        Collections.swap(this.accountNumbers, i, i2);
        notifyItemMoved(fromIndex, toIndex);
    }

    private void resetItems() {
        this.accountNumbers.clear();
        for (int i = 0; i < 3; i++) {
            if (UserConfig.getInstance(i).isClientActivated()) {
                this.accountNumbers.add(Integer.valueOf(i));
            }
        }
        Collections.sort(this.accountNumbers, $$Lambda$DrawerLayoutAdapter$jgYUUmf0uNU8VWINmtqF_CgriyA.INSTANCE);
        this.items.clear();
        if (UserConfig.getInstance(UserConfig.selectedAccount).isClientActivated()) {
            Theme.getEventType();
            this.items.add(new Item(2, LocaleController.getString("NewGroup", R.string.NewGroup), R.drawable.menu_groups));
            this.items.add(new Item(4, LocaleController.getString("NewChannel", R.string.NewChannel), R.drawable.menu_broadcast));
            this.items.add(new Item(6, LocaleController.getString("Contacts", R.string.Contacts), R.drawable.menu_contacts));
            if (MessagesController.getInstance(UserConfig.selectedAccount).callsEnabled) {
                this.items.add(new Item(10, LocaleController.getString("Calls", R.string.Calls), R.drawable.menu_calls));
            }
            if (!MessagesController.getInstance(UserConfig.selectedAccount).isLockedDialog(Long.valueOf(UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id))) {
                this.items.add(new Item(11, LocaleController.getString("SavedMessages", R.string.SavedMessages), R.drawable.menu_saved));
            }
            this.items.add(new Item(15, LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.msg_clear));
            this.items.add(new Item(8, LocaleController.getString("Settings", R.string.Settings), R.drawable.menu_settings));
            if (SharedConfig.chatLockPasscodeHash.length() != 0) {
                this.items.add(new Item(1381, LocaleController.getString("LockedChats", R.string.LockedChats), R.drawable.menu_locked_chats));
            }
            if (MessagesController.getInstance(UserConfig.selectedAccount).callOutEnabled) {
                this.items.add(new Item(1383, LocaleController.getString("CallOutTitle", R.string.CallOutTitle), R.drawable.menu_calls));
            }
            this.items.add(null);
            if (MessagesController.getInstance(UserConfig.selectedAccount).payEnabled) {
                this.items.add(new Item(14, LocaleController.getString("EitaaServices", R.string.EitaaServices), R.drawable.payment_card));
                this.items.add(null);
            }
            this.items.add(new Item(7, LocaleController.getString("InviteFriends", R.string.InviteFriends), R.drawable.menu_invite));
            this.items.add(new Item(13, LocaleController.getString("EitaaFeatures", R.string.EitaaFeatures), R.drawable.menu_help));
            if (MessagesController.getInstance(0).update_available) {
                this.items.add(new Item(1380, LocaleController.getString("AppUpdate", R.string.AppUpdate), R.drawable.msg_retry));
            }
            if (MessagesController.getInstance(UserConfig.selectedAccount).reportVersion) {
                this.items.add(new Item(1382, LocaleController.getString("Reset", R.string.Reset), R.drawable.msg_reset));
            }
        }
    }

    static /* synthetic */ int lambda$resetItems$0(Integer num, Integer num2) {
        long j = UserConfig.getInstance(num.intValue()).loginTime;
        long j2 = UserConfig.getInstance(num2.intValue()).loginTime;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public int getId(int position) {
        Item item;
        int accountRowsCount = position - 2;
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

        public Item(int id, String text, int icon) {
            this.icon = icon;
            this.id = id;
            this.text = text;
        }

        public void bind(DrawerActionCell actionCell) {
            actionCell.setTextAndIcon(this.id, this.text, this.icon);
        }
    }
}
