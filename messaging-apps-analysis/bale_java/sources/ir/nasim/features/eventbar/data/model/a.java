package ir.nasim.features.eventbar.data.model;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC22735vk3;
import ir.nasim.C19406qI3;
import ir.nasim.C8542Wk3;
import ir.nasim.InterfaceC21555tk3;
import ir.nasim.InterfaceC22145uk3;
import ir.nasim.features.eventbar.data.model.EventBarData;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class a implements InterfaceC22145uk3 {
    @Override // ir.nasim.InterfaceC22145uk3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EventBarData a(AbstractC22735vk3 abstractC22735vk3, Type type, InterfaceC21555tk3 interfaceC21555tk3) throws NumberFormatException {
        C8542Wk3 c8542Wk3O;
        String name;
        if (abstractC22735vk3 != null) {
            try {
                c8542Wk3O = abstractC22735vk3.o();
                if (c8542Wk3O == null) {
                    c8542Wk3O = new C8542Wk3();
                }
            } catch (Exception e) {
                if (a.class.isAnonymousClass()) {
                    name = a.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = a.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, e);
                return EventBarData.Disabled.INSTANCE;
            }
        } else {
            c8542Wk3O = new C8542Wk3();
        }
        EventBarData.Enabled.a aVar = EventBarData.Enabled.a.a;
        String strV = c8542Wk3O.L("event_bar_id").v();
        AbstractC13042fc3.h(strV, "getAsString(...)");
        long j = Long.parseLong(strV);
        String strV2 = c8542Wk3O.L("title_text").v();
        AbstractC13042fc3.h(strV2, "getAsString(...)");
        String strV3 = c8542Wk3O.L("button_text").v();
        AbstractC13042fc3.h(strV3, "getAsString(...)");
        String strV4 = c8542Wk3O.L("content_link").v();
        AbstractC13042fc3.h(strV4, "getAsString(...)");
        String strV5 = c8542Wk3O.L("colors_set_number").v();
        AbstractC13042fc3.h(strV5, "getAsString(...)");
        int i = Integer.parseInt(strV5);
        String strV6 = c8542Wk3O.L("expire_time_in_mills").v();
        AbstractC13042fc3.h(strV6, "getAsString(...)");
        EventBarData.Enabled enabled = new EventBarData.Enabled(aVar, j, strV2, strV3, strV4, i, Long.parseLong(strV6), Boolean.parseBoolean(c8542Wk3O.L("has_timer").v()));
        List listP = AbstractC10360bX0.p(enabled.getTitleText(), enabled.getButtonText(), enabled.getContentLink());
        if ((listP instanceof Collection) && listP.isEmpty()) {
            return enabled;
        }
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).length() == 0) {
                return EventBarData.Disabled.INSTANCE;
            }
        }
        return enabled;
    }
}
