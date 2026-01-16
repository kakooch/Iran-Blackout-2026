package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;

/* renamed from: ir.nasim.ro6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20320ro6 {
    public static final C20320ro6 a = new C20320ro6();

    private C20320ro6() {
    }

    public static final void b(long j, int i, long j2, boolean z, String str, HQ0 hq0) {
        AbstractC13042fc3.i(str, "msgType");
        AbstractC13042fc3.i(hq0, "spot");
        HashMap map = new HashMap();
        map.put("comment_rid", Long.valueOf(j));
        map.put(DialogEntity.COLUMN_RID, Long.valueOf(j2));
        map.put("peer_id", Integer.valueOf(i));
        map.put("peer_type", "channel");
        map.put("action_type", 2);
        map.put("is_reply", Boolean.valueOf(z));
        map.put("message_type", str);
        map.put("spot", hq0.toString());
        C3343Am.i("comment", map);
    }

    public final void a(long j, int i) {
        HashMap map = new HashMap();
        map.put(DialogEntity.COLUMN_RID, Long.valueOf(j));
        map.put("peer_id", Integer.valueOf(i));
        map.put("peer_type", "channel");
        map.put("action_type", 1);
        C3343Am.i("comment", map);
    }
}
