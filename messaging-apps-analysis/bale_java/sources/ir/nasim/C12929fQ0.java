package ir.nasim;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import ir.nasim.chat.ChatFragment;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import ir.nasim.features.share.ShareData;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.fQ0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12929fQ0 implements InterfaceC11677dQ0 {
    @Override // ir.nasim.InterfaceC11677dQ0
    public Fragment a(C11458d25 c11458d25, ExPeerType exPeerType, Long l, Long l2, boolean z, AbstractC13089g.b bVar, ShareData shareData, List list, String str, long j, Long l3, Long l4, String str2, boolean z2, String str3, Long l5, Long l6, String str4, List list2, boolean z3, String str5, HQ0 hq0, C11458d25 c11458d252, Boolean bool, String str6, boolean z4, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(list2, "invitePeers");
        AbstractC13042fc3.i(hq0, "spot");
        AbstractC13042fc3.i(emptyStateOnboardingItemAction, "emptyStateOnboardingItemAction");
        ChatFragment chatFragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("ARGUMENT_KEY_PEER_ID", c11458d25.u());
        if (c11458d252 != null) {
            bundle.putLong("ARGUMENT_KEY_INTENDED_PEER_ID", c11458d252.u());
        }
        if (bool != null) {
            bundle.putBoolean("ARGUMENT_KEY_JOIN_VIA_LINK", bool.booleanValue());
        }
        bundle.putInt("ARGUMENT_KEY_EX_PEER_TYPE", exPeerType.getValue());
        if (l != null) {
            bundle.putLong("EXTRA_RID", l.longValue());
        }
        if (l2 != null) {
            bundle.putLong("EXTRA_SORT_KEY", l2.longValue());
        }
        if (bVar != null) {
            bundle.putInt("EXTRA_FORWARD_MODE", bVar.ordinal());
        }
        bundle.putBoolean("EXTRA_SHOULD_LOAD_MESSAGE", z);
        if (shareData != null) {
            bundle.putParcelable("EXTRA_SHARE_DATA", shareData);
        }
        if (list != null && C8386Vt0.ra()) {
            bundle.putParcelableArrayList("EXTRA_SHARED_CONTENTS", new ArrayList<>(list));
        }
        if (str != null) {
            bundle.putString("EXTRA_MESSAGE", str);
        }
        bundle.putLong("EXTRA_MESSAGE_DELAY", j);
        if (l3 != null) {
            bundle.putLong("LAST_READ", l3.longValue());
        }
        if (l4 != null) {
            bundle.putLong("LAST_RECEIVE", l4.longValue());
        }
        if (str2 != null) {
            bundle.putString("PARAM", str2);
        }
        if (str6 != null) {
            bundle.putString("DRAFT_TEXT", str6);
        }
        if (str3 != null) {
            bundle.putString("JARYAN_TAB_TYPE", str3);
        }
        if (l5 != null) {
            bundle.putLong("arg_comment_top_id", l5.longValue());
        }
        if (l6 != null) {
            bundle.putLong("arg_comment_top_date", l6.longValue());
        }
        bundle.putString("arg_chat_spot", hq0.toString());
        bundle.putBoolean("IS_FROM_JARYAN", z2);
        if (str4 != null) {
            bundle.putString("INVITE_LINK", str4);
        }
        List list3 = list2;
        if (!list3.isEmpty()) {
            bundle.putIntArray("INVITE_PEERS", AbstractC15401jX0.l1(list3));
        }
        bundle.putBoolean("ADD_MEMBER_BUTTON", z3);
        if (str5 != null) {
            bundle.putString("BOT_THAT_ADDED_NAME", str5);
        }
        bundle.putBoolean("ARGUMENT_KEY_IS_OPENED_FROM_DIALOG_LIST_ITEM_OR_DIALOG_AD", z4);
        bundle.putParcelable("ARGUMENT_KEY_IS_OPENED_FROM_DIALOG_LIST_EMPTY_STATE_ONBOARDING", emptyStateOnboardingItemAction);
        chatFragment.a8(bundle);
        return chatFragment;
    }
}
