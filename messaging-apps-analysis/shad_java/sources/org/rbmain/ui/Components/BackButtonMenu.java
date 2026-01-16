package org.rbmain.ui.Components;

import android.os.Bundle;
import android.view.View;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.BackButtonMenu;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes5.dex */
public class BackButtonMenu {

    public static class PulledDialog<T> {
        Class<T> activity;
        TLRPC$Chat chat;
        long dialogId;
        int filterId;
        int folderId;
        int stackIndex;
        TLRPC$User user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.graphics.drawable.BitmapDrawable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, android.widget.FrameLayout, org.rbmain.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.rbmain.ui.ActionBar.ActionBarPopupWindow show(final org.rbmain.ui.ActionBar.BaseFragment r26, android.view.View r27, long r28, int r30, org.rbmain.ui.ActionBar.Theme.ResourcesProvider r31) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.BackButtonMenu.show(org.rbmain.ui.ActionBar.BaseFragment, android.view.View, long, int, org.rbmain.ui.ActionBar.Theme$ResourcesProvider):org.rbmain.ui.ActionBar.ActionBarPopupWindow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$show$0(AtomicReference atomicReference, PulledDialog pulledDialog, ActionBarLayout actionBarLayout, BaseFragment baseFragment, View view) {
        int i;
        Long lValueOf = null;
        if (atomicReference.get() != null) {
            ((ActionBarPopupWindow) atomicReference.getAndSet(null)).dismiss();
        }
        if (pulledDialog.stackIndex >= 0) {
            if (actionBarLayout != null && actionBarLayout.getFragmentStack() != null && pulledDialog.stackIndex < actionBarLayout.getFragmentStack().size()) {
                BaseFragment baseFragment2 = actionBarLayout.getFragmentStack().get(pulledDialog.stackIndex);
                if (baseFragment2 instanceof ChatActivity) {
                    lValueOf = Long.valueOf(((ChatActivity) baseFragment2).getDialogId());
                } else if (baseFragment2 instanceof ProfileActivity) {
                    lValueOf = Long.valueOf(((ProfileActivity) baseFragment2).getDialogId());
                }
            }
            if (lValueOf != null && lValueOf.longValue() != pulledDialog.dialogId) {
                for (int size = actionBarLayout.getFragmentStack().size() - 2; size > pulledDialog.stackIndex; size--) {
                    actionBarLayout.removeFragmentFromStack(size);
                }
            } else if (actionBarLayout != null && actionBarLayout.getFragmentStack() != null) {
                ArrayList arrayList = new ArrayList(actionBarLayout.getFragmentStack());
                int size2 = arrayList.size() - 2;
                while (true) {
                    i = pulledDialog.stackIndex;
                    if (size2 <= i) {
                        break;
                    }
                    ((BaseFragment) arrayList.get(size2)).removeSelfFromStack();
                    size2--;
                }
                if (i < actionBarLayout.getFragmentStack().size()) {
                    actionBarLayout.closeLastFragment(true);
                    return;
                }
            }
        }
        goToPulledDialog(baseFragment, pulledDialog);
    }

    private static ArrayList<PulledDialog> getStackedHistoryForTopic(BaseFragment baseFragment, long j, int i) {
        return new ArrayList<>();
    }

    public static void goToPulledDialog(BaseFragment baseFragment, PulledDialog pulledDialog) {
        if (pulledDialog == null) {
            return;
        }
        GenericDeclaration genericDeclaration = pulledDialog.activity;
        if (genericDeclaration == ChatActivity.class) {
            Bundle bundle = new Bundle();
            TLRPC$Chat tLRPC$Chat = pulledDialog.chat;
            if (tLRPC$Chat != null) {
                bundle.putInt("chat_id", tLRPC$Chat.id);
            } else {
                TLRPC$User tLRPC$User = pulledDialog.user;
                if (tLRPC$User != null) {
                    bundle.putInt("user_id", tLRPC$User.id);
                }
            }
            bundle.putInt("dialog_folder_id", pulledDialog.folderId);
            bundle.putInt("dialog_filter_id", pulledDialog.filterId);
            baseFragment.presentFragment(new ChatActivity(bundle), true);
        } else if (genericDeclaration == ProfileActivity.class) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("dialog_id", pulledDialog.dialogId);
            baseFragment.presentFragment(new ProfileActivity(bundle2), true);
        }
        if (pulledDialog.activity == DialogsActivity.class) {
            baseFragment.presentFragment(new DialogsActivity(null), true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<PulledDialog> getStackedHistoryDialogs(BaseFragment baseFragment, long j) {
        ActionBarLayout parentLayout;
        boolean z;
        long dialogId;
        int dialogFilterId;
        int dialogFolderId;
        TLRPC$User currentUser;
        Class<T> cls;
        TLRPC$Chat currentChat;
        int i;
        boolean z2;
        ArrayList<PulledDialog> arrayList = new ArrayList<>();
        if (baseFragment == null || (parentLayout = baseFragment.getParentLayout()) == null) {
            return arrayList;
        }
        List<BaseFragment> fragmentStack = parentLayout.getFragmentStack();
        List<PulledDialog> pulledDialogs = parentLayout.getPulledDialogs();
        if (fragmentStack != null) {
            int size = fragmentStack.size();
            int i2 = 0;
            while (i2 < size) {
                BaseFragment baseFragment2 = fragmentStack.get(i2);
                TLRPC$User tLRPC$User = null;
                if (baseFragment2 instanceof ChatActivity) {
                    Class<ChatActivity> cls2 = ChatActivity.class;
                    ChatActivity chatActivity = (ChatActivity) baseFragment2;
                    if (chatActivity.getChatMode() == 0 && !chatActivity.isReport()) {
                        currentChat = chatActivity.getCurrentChat();
                        currentUser = chatActivity.getCurrentUser();
                        dialogId = chatActivity.getDialogId();
                        dialogFolderId = chatActivity.getDialogFolderId();
                        dialogFilterId = chatActivity.getDialogFilterId();
                        cls = cls2;
                        if (dialogId == j && (j != 0 || !UserObject.isUserSelf(currentUser))) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= arrayList.size()) {
                                    i = size;
                                    z2 = false;
                                    break;
                                }
                                i = size;
                                if (arrayList.get(i3).dialogId == dialogId) {
                                    z2 = true;
                                    break;
                                }
                                i3++;
                                size = i;
                            }
                            if (!z2) {
                                PulledDialog pulledDialog = new PulledDialog();
                                pulledDialog.activity = cls;
                                pulledDialog.stackIndex = i2;
                                pulledDialog.chat = currentChat;
                                pulledDialog.user = currentUser;
                                pulledDialog.dialogId = dialogId;
                                pulledDialog.folderId = dialogFolderId;
                                pulledDialog.filterId = dialogFilterId;
                                if (currentChat != null || currentUser != null) {
                                    arrayList.add(pulledDialog);
                                }
                            }
                        }
                    }
                    i = size;
                } else {
                    if (baseFragment2 instanceof ProfileActivity) {
                        ProfileActivity profileActivity = (ProfileActivity) baseFragment2;
                        TLRPC$Chat currentChat2 = profileActivity.getCurrentChat();
                        try {
                            tLRPC$User = profileActivity.getUserInfo().user;
                        } catch (Exception unused) {
                        }
                        dialogId = profileActivity.getDialogId();
                        dialogFilterId = 0;
                        dialogFolderId = 0;
                        currentUser = tLRPC$User;
                        cls = ProfileActivity.class;
                        currentChat = currentChat2;
                        if (dialogId == j) {
                        }
                    }
                    i = size;
                }
                i2++;
                size = i;
            }
        }
        if (pulledDialogs != null) {
            for (int size2 = pulledDialogs.size() - 1; size2 >= 0; size2--) {
                PulledDialog pulledDialog2 = pulledDialogs.get(size2);
                if (pulledDialog2.dialogId != j) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= arrayList.size()) {
                            z = false;
                            break;
                        }
                        if (arrayList.get(i4).dialogId == pulledDialog2.dialogId) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (!z) {
                        arrayList.add(pulledDialog2);
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.ui.Components.BackButtonMenu$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackButtonMenu.lambda$getStackedHistoryDialogs$1((BackButtonMenu.PulledDialog) obj, (BackButtonMenu.PulledDialog) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getStackedHistoryDialogs$1(PulledDialog pulledDialog, PulledDialog pulledDialog2) {
        return pulledDialog2.stackIndex - pulledDialog.stackIndex;
    }

    public static void addToPulledDialogs(BaseFragment baseFragment, int i, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, long j, int i2, int i3) {
        ActionBarLayout parentLayout;
        if ((tLRPC$Chat == null && tLRPC$User == null) || baseFragment == null || (parentLayout = baseFragment.getParentLayout()) == null) {
            return;
        }
        if (parentLayout.getPulledDialogs() == null) {
            parentLayout.setPulledDialogs(new ArrayList());
        }
        boolean z = false;
        Iterator<PulledDialog> it = parentLayout.getPulledDialogs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dialogId == j) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        PulledDialog pulledDialog = new PulledDialog();
        pulledDialog.activity = ChatActivity.class;
        pulledDialog.stackIndex = i;
        pulledDialog.dialogId = j;
        pulledDialog.filterId = i3;
        pulledDialog.folderId = i2;
        pulledDialog.chat = tLRPC$Chat;
        pulledDialog.user = tLRPC$User;
        parentLayout.getPulledDialogs().add(pulledDialog);
    }

    public static void clearPulledDialogs(BaseFragment baseFragment, int i) {
        ActionBarLayout parentLayout;
        if (baseFragment == null || (parentLayout = baseFragment.getParentLayout()) == null || parentLayout.getPulledDialogs() == null) {
            return;
        }
        int i2 = 0;
        while (i2 < parentLayout.getPulledDialogs().size()) {
            if (parentLayout.getPulledDialogs().get(i2).stackIndex > i) {
                parentLayout.getPulledDialogs().remove(i2);
                i2--;
            }
            i2++;
        }
    }
}
