package org.rbmain.ui.Adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.DividerCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LetterSectionCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.ContactsEmptyView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class ContactsAdapter extends RecyclerListView.SectionsAdapter {
    private SparseArray<?> checkedMap;
    private int currentAccount = UserConfig.selectedAccount;
    private boolean disableSections;
    private boolean hasGps;
    private SparseArray<TLRPC$User> ignoreUsers;
    private boolean isAdmin;
    private boolean isChannel;
    private boolean isEmpty;
    private Context mContext;
    private boolean needPhonebook;
    private ArrayList<TLRPC$TL_contact> onlineContacts;
    private int onlyUsers;
    private boolean scrolling;
    private int sortType;

    public ContactsAdapter(Context context, int i, boolean z, SparseArray<TLRPC$User> sparseArray, int i2, boolean z2) {
        this.mContext = context;
        this.onlyUsers = i;
        this.needPhonebook = z;
        this.ignoreUsers = sparseArray;
        this.isAdmin = i2 != 0;
        this.isChannel = i2 == 2;
        this.hasGps = false;
    }

    public void setDisableSections(boolean z) {
        this.disableSections = z;
    }

    public void setSortType(int i, boolean z) {
        this.sortType = i;
        if (i == 2) {
            if (this.onlineContacts == null || z) {
                this.onlineContacts = new ArrayList<>(ContactsController.getInstance(this.currentAccount).contacts);
                int i2 = UserConfig.getInstance(this.currentAccount).clientUserId;
                int i3 = 0;
                int size = this.onlineContacts.size();
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (this.onlineContacts.get(i3).user_id == i2) {
                        this.onlineContacts.remove(i3);
                        break;
                    }
                    i3++;
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
            final int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
            final MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
            Collections.sort(this.onlineContacts, new Comparator() { // from class: org.rbmain.ui.Adapters.ContactsAdapter$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ContactsAdapter.lambda$sortOnlineContacts$0(messagesController, currentTime, (TLRPC$TL_contact) obj, (TLRPC$TL_contact) obj2);
                }
            });
            notifyDataSetChanged();
        } catch (Exception e) {
            FileLog.e(e);
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Adapters.ContactsAdapter.lambda$sortOnlineContacts$0(org.rbmain.messenger.MessagesController, int, org.rbmain.tgnet.TLRPC$TL_contact, org.rbmain.tgnet.TLRPC$TL_contact):int");
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public Object getItem(int i, int i2) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers != 0 && !this.isAdmin) {
            if (this.sortType == 2) {
                if (i != 0 || i2 >= this.onlineContacts.size()) {
                    return null;
                }
                return MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.onlineContacts.get(i2).user_id));
            }
            if (i < arrayList.size()) {
                ArrayList<TLRPC$TL_contact> arrayList2 = map.get(arrayList.get(i));
                if (i2 < arrayList2.size()) {
                    return MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(arrayList2.get(i2).user_id));
                }
            }
            return null;
        }
        if (i == 0) {
            return null;
        }
        if (this.sortType != 2) {
            int i3 = i - 1;
            if (i3 < arrayList.size()) {
                ArrayList<TLRPC$TL_contact> arrayList3 = map.get(arrayList.get(i3));
                if (i2 < arrayList3.size()) {
                    return MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(arrayList3.get(i2).user_id));
                }
                return null;
            }
        } else if (i == 1) {
            if (i2 < this.onlineContacts.size()) {
                return MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.onlineContacts.get(i2).user_id));
            }
            return null;
        }
        if (!this.needPhonebook || i2 < 0 || i2 >= ContactsController.getInstance(this.currentAccount).phoneBookContacts.size()) {
            return null;
        }
        return ContactsController.getInstance(this.currentAccount).phoneBookContacts.get(i2);
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers != 0 && !this.isAdmin) {
            return !this.isEmpty && i2 < map.get(arrayList.get(i)).size();
        }
        if (i == 0) {
            if (this.isAdmin) {
                return i2 != 1;
            }
            if (!this.needPhonebook) {
                return i2 != 3;
            }
            boolean z = this.hasGps;
            return (z && i2 != 2) || !(z || i2 == 1);
        }
        if (this.isEmpty) {
            return false;
        }
        if (this.sortType == 2) {
            return i != 1 || i2 < this.onlineContacts.size();
        }
        int i3 = i - 1;
        return i3 >= arrayList.size() || i2 < map.get(arrayList.get(i3)).size();
        return true;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
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

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public int getCountForSection(int i) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers == 0 || this.isAdmin) {
            if (i == 0) {
                if (this.isAdmin) {
                    return 2;
                }
                return (!this.needPhonebook || this.hasGps) ? 3 : 2;
            }
            if (this.isEmpty) {
                return 1;
            }
            if (this.sortType != 2) {
                int i2 = i - 1;
                if (i2 < arrayList.size()) {
                    int size = map.get(arrayList.get(i2)).size();
                    return (i2 != arrayList.size() - 1 || this.needPhonebook) ? size + 1 : size;
                }
            } else if (i == 1) {
                if (this.onlineContacts.isEmpty()) {
                    return 0;
                }
                return this.onlineContacts.size() + 1;
            }
        } else {
            if (this.isEmpty) {
                return 1;
            }
            if (this.sortType == 2) {
                if (i == 0) {
                    if (this.onlineContacts.isEmpty()) {
                        return 0;
                    }
                    return this.onlineContacts.size() + 1;
                }
            } else if (i < arrayList.size()) {
                int size2 = map.get(arrayList.get(i)).size();
                return (i != arrayList.size() - 1 || this.needPhonebook) ? size2 + 1 : size2;
            }
        }
        if (this.needPhonebook) {
            return ContactsController.getInstance(this.currentAccount).phoneBookContacts.size();
        }
        return 0;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public View getSectionHeaderView(int i, View view) {
        int i2;
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
            letterSectionCell.setLetter(BuildConfig.FLAVOR);
        } else if (this.onlyUsers != 0 && !this.isAdmin) {
            if (i < arrayList.size()) {
                letterSectionCell.setLetter(arrayList.get(i));
            } else {
                letterSectionCell.setLetter(BuildConfig.FLAVOR);
            }
        } else if (i != 0 && i - 1 < arrayList.size()) {
            letterSectionCell.setLetter(arrayList.get(i2));
        } else {
            letterSectionCell.setLetter(BuildConfig.FLAVOR);
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View userCell;
        if (i == 0) {
            userCell = new UserCell(this.mContext, 58, 1, false);
        } else if (i == 1) {
            userCell = new TextCell(this.mContext);
        } else if (i == 2) {
            userCell = new GraySectionCell(this.mContext);
        } else if (i == 3) {
            userCell = new DividerCell(this.mContext);
            userCell.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 28.0f : 72.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 28.0f), AndroidUtilities.dp(8.0f));
        } else if (i == 4) {
            FrameLayout frameLayout = new FrameLayout(this.mContext) { // from class: org.rbmain.ui.Adapters.ContactsAdapter.1
                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int i2, int i3) {
                    int size = View.MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = viewGroup.getMeasuredHeight();
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
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824), View.MeasureSpec.makeMeasureSpec(iDp2 < size ? size - iDp2 : 0, 1073741824));
                }
            };
            frameLayout.addView(new ContactsEmptyView(this.mContext), LayoutHelper.createFrame(-2, -2, 17));
            userCell = frameLayout;
        } else {
            userCell = new ShadowSectionCell(this.mContext);
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
            combinedDrawable.setFullsize(true);
            userCell.setBackgroundDrawable(combinedDrawable);
        }
        return new RecyclerListView.Holder(userCell);
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
        ArrayList<TLRPC$TL_contact> arrayList;
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            UserCell userCell = (UserCell) viewHolder.itemView;
            userCell.setAvatarPadding((this.sortType == 2 || this.disableSections) ? 6 : 58);
            if (this.sortType == 2) {
                arrayList = this.onlineContacts;
            } else {
                arrayList = (this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict).get((this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray).get(i - ((this.onlyUsers == 0 || this.isAdmin) ? 1 : 0)));
            }
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(arrayList.get(i2).user_id));
            userCell.setData(user, null, null, 0);
            SparseArray<?> sparseArray = this.checkedMap;
            if (sparseArray != null) {
                userCell.setChecked(sparseArray.indexOfKey(user.id) >= 0, !this.scrolling);
            }
            SparseArray<TLRPC$User> sparseArray2 = this.ignoreUsers;
            if (sparseArray2 != null) {
                if (sparseArray2.indexOfKey(user.id) >= 0) {
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
            GraySectionCell graySectionCell = (GraySectionCell) viewHolder.itemView;
            int i3 = this.sortType;
            if (i3 == 0) {
                graySectionCell.setText(LocaleController.getString("Contacts", R.string.Contacts));
                return;
            } else if (i3 == 1) {
                graySectionCell.setText(LocaleController.getString("SortedByName", R.string.SortedByName));
                return;
            } else {
                graySectionCell.setText(LocaleController.getString("SortedByLastSeen", R.string.SortedByLastSeen));
                return;
            }
        }
        TextCell textCell = (TextCell) viewHolder.itemView;
        if (i == 0) {
            if (this.needPhonebook) {
                if (i2 == 0) {
                    textCell.setTextAndIcon(LocaleController.getString("InviteFriends", R.string.InviteFriends), R.drawable.menu_invite, false);
                    return;
                } else {
                    if (i2 == 1) {
                        textCell.setTextAndIcon(LocaleController.getString("AddPeopleNearby", R.string.AddPeopleNearby), R.drawable.menu_location, false);
                        return;
                    }
                    return;
                }
            }
            if (this.isAdmin) {
                if (this.isChannel) {
                    textCell.setTextAndIcon(LocaleController.getString("ChannelInviteViaLink", R.string.ChannelInviteViaLink), R.drawable.profile_link, false);
                    return;
                } else {
                    textCell.setTextAndIcon(LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink), R.drawable.profile_link, false);
                    return;
                }
            }
            if (i2 == 0) {
                textCell.setTextAndIcon(LocaleController.getString("NewGroup", R.string.NewGroup), R.drawable.menu_groups, false);
                return;
            } else {
                if (i2 == 1) {
                    textCell.setTextAndIcon(LocaleController.getString("NewChannel", R.string.NewChannel), R.drawable.menu_broadcast, false);
                    return;
                }
                return;
            }
        }
        ContactsController.Contact contact = ContactsController.getInstance(this.currentAccount).phoneBookContacts.get(i2);
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

    @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
    public int getItemViewType(int i, int i2) {
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).usersMutualSectionsDict : ContactsController.getInstance(this.currentAccount).usersSectionsDict;
        ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
        if (this.onlyUsers == 0 || this.isAdmin) {
            if (i == 0) {
                if (this.isAdmin) {
                    if (i2 == 1) {
                        return 2;
                    }
                } else if (this.needPhonebook) {
                    boolean z = this.hasGps;
                    if ((z && i2 == 2) || (!z && i2 == 1)) {
                        return this.isEmpty ? 5 : 2;
                    }
                } else if (i2 == 2) {
                    return this.isEmpty ? 5 : 2;
                }
            } else {
                if (this.isEmpty) {
                    return 4;
                }
                if (this.sortType != 2) {
                    int i3 = i - 1;
                    if (i3 < arrayList.size()) {
                        return i2 < map.get(arrayList.get(i3)).size() ? 0 : 3;
                    }
                } else if (i == 1) {
                    return i2 < this.onlineContacts.size() ? 0 : 3;
                }
            }
        } else {
            if (this.isEmpty) {
                return 4;
            }
            if (this.sortType != 2) {
                return i2 < map.get(arrayList.get(i)).size() ? 0 : 3;
            }
            if (i == 0) {
                return i2 < this.onlineContacts.size() ? 0 : 3;
            }
        }
        return 1;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
    public String getLetter(int i) {
        if (this.sortType != 2 && !this.isEmpty) {
            ArrayList<String> arrayList = this.onlyUsers == 2 ? ContactsController.getInstance(this.currentAccount).sortedUsersMutualSectionsArray : ContactsController.getInstance(this.currentAccount).sortedUsersSectionsArray;
            int sectionForPosition = getSectionForPosition(i);
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

    @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
    public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
        iArr[0] = (int) (getItemCount() * f);
        iArr[1] = 0;
    }
}
