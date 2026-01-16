package ir.nasim;

import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: ir.nasim.wh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23300wh2 {
    private final InterfaceC19567qa2 a;

    public C23300wh2(InterfaceC19567qa2 interfaceC19567qa2) {
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        this.a = interfaceC19567qa2;
    }

    private final void a(int i, K5 k5, XH6 xh6, String str, WH5 wh5, boolean z, C5886Lg2 c5886Lg2, int i2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action_type", Integer.valueOf(k5.j()));
        linkedHashMap.put("message_type", c5886Lg2.i().b());
        linkedHashMap.put(SearchSuggestion.CATEGORY_ICON, c5886Lg2.d());
        linkedHashMap.put("peer_id", Integer.valueOf(i));
        linkedHashMap.put("category_id", Integer.valueOf(i2));
        String strName = c5886Lg2.f().getExPeerType().name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        linkedHashMap.put("peer_type", lowerCase);
        if (xh6 != null) {
            String lowerCase2 = xh6.name().toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            linkedHashMap.put("source_type", lowerCase2);
        }
        if (str != null) {
            linkedHashMap.put("reaction_emoji", str);
        }
        if (wh5 != null) {
            linkedHashMap.put("reaction_type", Integer.valueOf(wh5.j()));
        }
        linkedHashMap.put(DialogEntity.COLUMN_RID, Long.valueOf(c5886Lg2.m()));
        linkedHashMap.put("msg_date", Long.valueOf(c5886Lg2.e()));
        CW4 cw4J = c5886Lg2.j();
        linkedHashMap.put("parent_peed_id", Integer.valueOf(cw4J != null ? cw4J.b() : 0));
        CW4 cw4J2 = c5886Lg2.j();
        linkedHashMap.put("parent_rid", Long.valueOf(cw4J2 != null ? cw4J2.c() : 0L));
        CW4 cw4J3 = c5886Lg2.j();
        linkedHashMap.put("parent_msg_date", Long.valueOf(cw4J3 != null ? cw4J3.a() : 0L));
        Long lH = c5886Lg2.h();
        linkedHashMap.put("album_id", Long.valueOf(lH != null ? lH.longValue() : 0L));
        linkedHashMap.put("is_fullscreen", Integer.valueOf(z ? 1 : 0));
        this.a.a("flow_post_action", AbstractC20051rO3.y(linkedHashMap));
    }

    private final void e(boolean z, Integer num, Integer num2, int i, C5886Lg2 c5886Lg2, int i2) {
        if (i > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(DialogEntity.COLUMN_RID, Long.valueOf(c5886Lg2.m()));
            linkedHashMap.put("msg_date", Long.valueOf(c5886Lg2.e()));
            linkedHashMap.put("message_type", c5886Lg2.i().b());
            linkedHashMap.put(SearchSuggestion.CATEGORY_ICON, c5886Lg2.d());
            linkedHashMap.put("peer_id", Integer.valueOf(c5886Lg2.f().getPeerId()));
            linkedHashMap.put("duration_seconds", Integer.valueOf(i));
            String lowerCase = c5886Lg2.f().getExPeerType().name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            linkedHashMap.put("peer_type", lowerCase);
            linkedHashMap.put("category_id", Integer.valueOf(i2));
            CW4 cw4J = c5886Lg2.j();
            linkedHashMap.put("parent_peed_id", Integer.valueOf(cw4J != null ? cw4J.b() : 0));
            CW4 cw4J2 = c5886Lg2.j();
            linkedHashMap.put("parent_rid", Long.valueOf(cw4J2 != null ? cw4J2.c() : 0L));
            CW4 cw4J3 = c5886Lg2.j();
            linkedHashMap.put("parent_msg_date", Long.valueOf(cw4J3 != null ? cw4J3.a() : 0L));
            linkedHashMap.put("is_fullscreen", Integer.valueOf(z ? 1 : 0));
            if (num != null) {
                linkedHashMap.put("file_duration", Integer.valueOf(num.intValue()));
            }
            if (num2 != null) {
                linkedHashMap.put("duration", Integer.valueOf(num2.intValue()));
            }
            Long lH = c5886Lg2.h();
            linkedHashMap.put("album_id", Long.valueOf(lH != null ? lH.longValue() : 0L));
            this.a.a("flow_post_duration", AbstractC20051rO3.y(linkedHashMap));
        }
    }

    public final void b(int i, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2, int i2) {
        AbstractC13042fc3.i(k5, "actionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        a(i, k5, xh6, str, wh5, true, c5886Lg2, i2);
    }

    public final void c(int i, K5 k5, XH6 xh6, String str, WH5 wh5, C5886Lg2 c5886Lg2, int i2) {
        AbstractC13042fc3.i(k5, "actionType");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        a(i, k5, xh6, str, wh5, false, c5886Lg2, i2);
    }

    public final void d(int i, int i2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action_type", Integer.valueOf(i));
        linkedHashMap.put("category_id", Integer.valueOf(i2));
        this.a.a("flow_category_action", linkedHashMap);
    }

    public final void f(int i, Integer num, Integer num2, C5886Lg2 c5886Lg2, int i2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        e(true, num, num2, i, c5886Lg2, i2);
    }

    public final void g(int i, Integer num, Integer num2, C5886Lg2 c5886Lg2, int i2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        e(false, num, num2, i, c5886Lg2, i2);
    }

    public final void h(long j) {
        this.a.a("flow_shimmer_duration", AbstractC19460qO3.g(AbstractC4616Fw7.a("duration_seconds", Integer.valueOf((int) j))));
    }
}
