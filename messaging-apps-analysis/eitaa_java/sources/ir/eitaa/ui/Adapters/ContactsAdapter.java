package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.DividerCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LetterSectionCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.ContactsEmptyView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ContactsAdapter extends RecyclerListView.SectionsAdapter {
    private CallOutManager.CallOutDelegate callOutDelegate;
    private LongSparseArray<?> checkedMap;
    private int currentAccount = UserConfig.selectedAccount;
    private boolean disableSections;
    private boolean hasGps;
    private LongSparseArray<TLRPC$User> ignoreUsers;
    private boolean isAdmin;
    private boolean isChannel;
    private boolean isEmpty;
    private Context mContext;
    private MxbHelper.MxbDelegate mxbDelegate;
    private boolean needPhonebook;
    private ArrayList<TLRPC$TL_contact> onlineContacts;
    private int onlyUsers;
    private boolean scrolling;
    private int sortType;

    public ContactsAdapter(Context context, int onlyUsersType, boolean showPhoneBook, LongSparseArray<TLRPC$User> usersToIgnore, int flags, boolean gps) {
        this.mContext = context;
        this.onlyUsers = onlyUsersType;
        this.needPhonebook = showPhoneBook;
        this.ignoreUsers = usersToIgnore;
        this.isAdmin = flags != 0;
        this.isChannel = flags == 2;
        this.hasGps = gps;
    }

    public void setDisableSections(boolean value) {
        this.disableSections = value;
    }

    public void setSortType(int value, boolean force) {
        this.sortType = value;
        if (value == 2) {
            if (this.onlineContacts == null || force) {
                this.onlineContacts = new ArrayList<>(ContactsController.getInstance(this.currentAccount).contacts);
                long j = UserConfig.getInstance(this.currentAccount).clientUserId;
                int i = 0;
                int size = this.onlineContacts.size();
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (this.onlineContacts.get(i).user_id == j) {
                        this.onlineContacts.remove(i);
                        break;
                    }
                    i++;
                }
            }
            sortOnlineContacts();
            return;
        }
        notifyDataSetChanged();
    }

    public void sortOnlineContacts() {
        if (this.onlineContacts == null) {
            return;
        }
        try {
            int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
            Collections.sort(this.onlineContacts, new $$Lambda$ContactsAdapter$f9n6eDGDJKRNXX4L38gbFVO2Afw(MessagesController.getInstance(this.currentAccount), currentTime));
            notifyDataSetChanged();
        } catch (Exception e) {
            FileLog.e(e);
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
            if (r3 >= 0) goto L5e
            if (r5 > 0) goto L62
        L5e:
            if (r3 != 0) goto L63
            if (r5 == 0) goto L63
        L62:
            return r4
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.ContactsAdapter.lambda$sortOnlineContacts$0(ir.eitaa.messenger.MessagesController, int, ir.eitaa.tgnet.TLRPC$TL_contact, ir.eitaa.tgnet.TLRPC$TL_contact):int");
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public Object getItem(int section, int position) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers != 0 && !this.isAdmin) {
            if (section < arrayList.size()) {
                ArrayList<TLRPC$TL_contact> arrayList2 = map.get(arrayList.get(section));
                if (position < arrayList2.size()) {
                    return MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(arrayList2.get(position).user_id));
                }
            }
            return null;
        }
        if (section == 0) {
            return null;
        }
        if (this.sortType != 2) {
            int i = section - 1;
            if (i < arrayList.size()) {
                ArrayList<TLRPC$TL_contact> arrayList3 = map.get(arrayList.get(i));
                if (position < arrayList3.size()) {
                    return MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(arrayList3.get(position).user_id));
                }
                return null;
            }
        } else if (section == 1) {
            if (position < this.onlineContacts.size()) {
                return MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.onlineContacts.get(position).user_id));
            }
            return null;
        }
        if (!this.needPhonebook || position < 0 || position >= ContactsController.getInstance(this.currentAccount).phoneBookContacts.size()) {
            return null;
        }
        return ContactsController.getInstance(this.currentAccount).phoneBookContacts.get(position);
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers != 0 && !this.isAdmin) {
            return !this.isEmpty && row < map.get(arrayList.get(section)).size();
        }
        if (section == 0) {
            if (this.isAdmin) {
                return row != 1;
            }
            if (!this.needPhonebook) {
                return row != 3;
            }
            boolean z = this.hasGps;
            return (z && row != 2) || !(z || row == 1);
        }
        if (this.isEmpty) {
            return false;
        }
        if (this.sortType == 2) {
            return section != 1 || row < this.onlineContacts.size();
        }
        int i = section - 1;
        return i >= arrayList.size() || row < map.get(arrayList.get(i)).size();
        return true;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public int getSectionCount() {
        this.isEmpty = false;
        int i = 1;
        if (this.sortType == 2) {
            this.isEmpty = this.onlineContacts.isEmpty();
        } else {
            int size = (this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray).size();
            if (size == 0) {
                this.isEmpty = true;
            } else {
                i = size;
            }
        }
        if (this.onlyUsers == 0) {
            i++;
        }
        return this.isAdmin ? i + 1 : i;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public int getCountForSection(int section) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers == 0 || this.isAdmin) {
            if (section == 0) {
                return (this.isAdmin || this.needPhonebook) ? 2 : 3;
            }
            if (this.isEmpty) {
                return 1;
            }
            if (this.sortType != 2) {
                int i = section - 1;
                if (i < arrayList.size()) {
                    int size = map.get(arrayList.get(i)).size();
                    return (i != arrayList.size() - 1 || this.needPhonebook) ? size + 1 : size;
                }
            } else if (section == 1) {
                if (this.onlineContacts.isEmpty()) {
                    return 0;
                }
                return this.onlineContacts.size() + 1;
            }
        } else {
            if (this.isEmpty) {
                return 1;
            }
            if (section < arrayList.size()) {
                int size2 = map.get(arrayList.get(section)).size();
                return (section != arrayList.size() - 1 || this.needPhonebook) ? size2 + 1 : size2;
            }
        }
        if (this.needPhonebook) {
            return ContactsController.getInstance(this.currentAccount).phoneBookContacts.size();
        }
        return 0;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public View getSectionHeaderView(int section, View view) {
        int i;
        if (this.onlyUsers == 2) {
            HashMap<String, ArrayList<TLRPC$TL_contact>> map = ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict;
        } else {
            HashMap<String, ArrayList<TLRPC$TL_contact>> map2 = ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        }
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (view == null) {
            view = new LetterSectionCell(this.mContext);
        }
        LetterSectionCell letterSectionCell = (LetterSectionCell) view;
        if (this.sortType == 2 || this.disableSections || this.isEmpty) {
            letterSectionCell.setLetter("");
        } else if (this.onlyUsers != 0 && !this.isAdmin) {
            if (section < arrayList.size()) {
                letterSectionCell.setLetter(arrayList.get(section));
            } else {
                letterSectionCell.setLetter("");
            }
        } else if (section != 0 && section - 1 < arrayList.size()) {
            letterSectionCell.setLetter(arrayList.get(i));
        } else {
            letterSectionCell.setLetter("");
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View userCell;
        if (viewType == 0) {
            userCell = new UserCell(this.mContext, 58, 1, false, false, UserConfig.mxbState && MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled, MessagesController.getInstance(UserConfig.selectedAccount).callOutEnabled);
        } else if (viewType == 1) {
            userCell = new TextCell(this.mContext);
        } else if (viewType == 2) {
            userCell = new GraySectionCell(this.mContext);
        } else if (viewType == 3) {
            userCell = new DividerCell(this.mContext);
            userCell.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 28.0f : 72.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 28.0f), AndroidUtilities.dp(8.0f));
        } else if (viewType == 4) {
            FrameLayout frameLayout = new FrameLayout(this.mContext) { // from class: ir.eitaa.ui.Adapters.ContactsAdapter.1
                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int size = View.MeasureSpec.getSize(heightMeasureSpec);
                    if (size == 0) {
                        size = parent.getMeasuredHeight();
                    }
                    if (size == 0) {
                        size = (AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
                    }
                    int iDp = AndroidUtilities.dp(50.0f);
                    int iDp2 = ContactsAdapter.this.onlyUsers != 0 ? 0 : AndroidUtilities.dp(30.0f) + iDp;
                    if (ContactsAdapter.this.hasGps) {
                        iDp2 += iDp;
                    }
                    if (!ContactsAdapter.this.isAdmin && !ContactsAdapter.this.needPhonebook) {
                        iDp2 += iDp;
                    }
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(iDp2 < size ? size - iDp2 : 0, 1073741824));
                }
            };
            frameLayout.addView(new ContactsEmptyView(this.mContext), LayoutHelper.createFrame(-2, -2, 17));
            userCell = frameLayout;
        } else {
            userCell = new ShadowSectionCell(this.mContext);
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            combinedDrawable.setFullsize(true);
            userCell.setBackgroundDrawable(combinedDrawable);
        }
        return new RecyclerListView.Holder(userCell);
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
        ArrayList<TLRPC$TL_contact> arrayList;
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            UserCell userCell = (UserCell) holder.itemView;
            userCell.setAvatarPadding((this.sortType == 2 || this.disableSections) ? 6 : 58);
            if (this.sortType == 2) {
                arrayList = this.onlineContacts;
            } else {
                arrayList = (this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict).get((this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray).get(section - ((this.onlyUsers == 0 || this.isAdmin) ? 1 : 0)));
            }
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(arrayList.get(position).user_id));
            userCell.setData(user, null, null, 0);
            userCell.setMxbDelegate(new MxbHelper.MxbDelegate() { // from class: ir.eitaa.ui.Adapters.ContactsAdapter.2
                @Override // ir.eitaa.helper.MxbHelper.MxbDelegate
                public void onMxbPressed(String phone) {
                    ContactsAdapter.this.mxbDelegate.onMxbPressed(phone);
                }
            });
            userCell.setCallOutDelegate(new CallOutManager.CallOutDelegate() { // from class: ir.eitaa.ui.Adapters.ContactsAdapter.3
                @Override // ir.eitaa.features.CallOut.helper.CallOutManager.CallOutDelegate
                public void onCallOutPressed(ContactsController.Contact contact) {
                    if (ContactsAdapter.this.callOutDelegate != null) {
                        ContactsAdapter.this.callOutDelegate.onCallOutPressed(contact);
                    }
                }
            });
            LongSparseArray<?> longSparseArray = this.checkedMap;
            if (longSparseArray != null) {
                userCell.setChecked(longSparseArray.indexOfKey(user.id) >= 0, !this.scrolling);
            }
            LongSparseArray<TLRPC$User> longSparseArray2 = this.ignoreUsers;
            if (longSparseArray2 != null) {
                if (longSparseArray2.indexOfKey(user.id) >= 0) {
                    userCell.setAlpha(0.5f);
                    return;
                } else {
                    userCell.setAlpha(1.0f);
                    return;
                }
            }
            return;
        }
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            GraySectionCell graySectionCell = (GraySectionCell) holder.itemView;
            int i = this.sortType;
            if (i == 0) {
                graySectionCell.setText(LocaleController.getString("Contacts", R.string.Contacts));
                return;
            } else if (i == 1) {
                graySectionCell.setText(LocaleController.getString("SortedByName", R.string.SortedByName));
                return;
            } else {
                graySectionCell.setText(LocaleController.getString("SortedByLastSeen", R.string.SortedByLastSeen));
                return;
            }
        }
        TextCell textCell = (TextCell) holder.itemView;
        if (section == 0) {
            if (this.needPhonebook) {
                if (position == 0) {
                    textCell.setTextAndIcon(LocaleController.getString("InviteFriends", R.string.InviteFriends), R.drawable.menu_invite, false);
                    return;
                }
                return;
            } else {
                if (this.isAdmin) {
                    if (this.isChannel) {
                        textCell.setTextAndIcon(LocaleController.getString("ChannelInviteViaLink", R.string.ChannelInviteViaLink), R.drawable.profile_link, false);
                        return;
                    } else {
                        textCell.setTextAndIcon(LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink), R.drawable.profile_link, false);
                        return;
                    }
                }
                if (position == 0) {
                    textCell.setTextAndIcon(LocaleController.getString("NewGroup", R.string.NewGroup), R.drawable.menu_groups, false);
                    return;
                } else {
                    if (position == 1) {
                        textCell.setTextAndIcon(LocaleController.getString("NewChannel", R.string.NewChannel), R.drawable.menu_broadcast, false);
                        return;
                    }
                    return;
                }
            }
        }
        ContactsController.Contact contact = ContactsController.getInstance(this.currentAccount).phoneBookContacts.get(position);
        String str = contact.first_name;
        if (str != null && contact.last_name != null) {
            textCell.setText(contact.first_name + " " + contact.last_name, false);
            return;
        }
        if (str != null && contact.last_name == null) {
            textCell.setText(str, false);
        } else {
            textCell.setText(contact.last_name, false);
        }
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
    public int getItemViewType(int section, int position) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers != 0 && !this.isAdmin) {
            if (this.isEmpty) {
                return 4;
            }
            return position < map.get(arrayList.get(section)).size() ? 0 : 3;
        }
        if (section == 0) {
            if (this.isAdmin) {
                if (position == 1) {
                    return 2;
                }
            } else if (this.needPhonebook) {
                boolean z = this.hasGps;
                if ((z && position == 1) || (!z && position == 0)) {
                    return this.isEmpty ? 5 : 2;
                }
            } else if (position == 2) {
                return this.isEmpty ? 5 : 2;
            }
        } else {
            if (this.isEmpty) {
                return 4;
            }
            if (this.sortType != 2) {
                int i = section - 1;
                if (i < arrayList.size()) {
                    return position < map.get(arrayList.get(i)).size() ? 0 : 3;
                }
            } else if (section == 1) {
                return position < this.onlineContacts.size() ? 0 : 3;
            }
        }
        return 1;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
    public String getLetter(int position) {
        if (this.sortType != 2 && !this.isEmpty) {
            ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
            int sectionForPosition = getSectionForPosition(position);
            if (sectionForPosition == -1) {
                sectionForPosition = arrayList.size() - 1;
            }
            if (this.onlyUsers != 0 && !this.isAdmin) {
                if (sectionForPosition >= 0 && sectionForPosition < arrayList.size()) {
                    return arrayList.get(sectionForPosition);
                }
            } else if (sectionForPosition > 0 && sectionForPosition <= arrayList.size()) {
                return arrayList.get(sectionForPosition - 1);
            }
        }
        return null;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
    public int getPositionForScrollProgress(float progress) {
        return (int) (getItemCount() * progress);
    }

    public void setMxbDelegate(MxbHelper.MxbDelegate mxbDelegate) {
        this.mxbDelegate = mxbDelegate;
    }

    public void setCallOutDelegate(CallOutManager.CallOutDelegate callOutDelegate) {
        this.callOutDelegate = callOutDelegate;
    }
}
