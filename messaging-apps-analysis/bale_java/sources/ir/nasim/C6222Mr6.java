package ir.nasim;

import ai.bale.proto.GarsonStruct$GarsonActionPayload;
import ai.bale.proto.GarsonStruct$GarsonMenuItem;
import ai.bale.proto.GarsonStruct$GarsonServiceItem;
import ai.bale.proto.PeersStruct$OutPeer;
import ir.nasim.database.entity.ServiceItemMenuItemEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Mr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6222Mr6 {
    public final C5988Lr6 a(GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem, int i) {
        ArrayList arrayList;
        PeersStruct$OutPeer peer;
        EnumC16311l35 type;
        PeersStruct$OutPeer peer2;
        AbstractC13042fc3.i(garsonStruct$GarsonServiceItem, "input");
        if (garsonStruct$GarsonServiceItem.getPayload().hasMenu()) {
            List<GarsonStruct$GarsonMenuItem> itemsList = garsonStruct$GarsonServiceItem.getPayload().getMenu().getItemsList();
            AbstractC13042fc3.h(itemsList, "getItemsList(...)");
            List<GarsonStruct$GarsonMenuItem> list = itemsList;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (GarsonStruct$GarsonMenuItem garsonStruct$GarsonMenuItem : list) {
                int id = garsonStruct$GarsonMenuItem.getId();
                String title = garsonStruct$GarsonMenuItem.getTitle();
                AbstractC13042fc3.h(title, "getTitle(...)");
                String icon = garsonStruct$GarsonMenuItem.getIcon();
                AbstractC13042fc3.h(icon, "getIcon(...)");
                arrayList2.add(new ServiceItemMenuItemEntity(id, title, icon, garsonStruct$GarsonMenuItem.getAction().getNumber(), garsonStruct$GarsonMenuItem.getPayload().getUrl()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        int number = garsonStruct$GarsonServiceItem.getAction().getNumber();
        String badge = garsonStruct$GarsonServiceItem.getBadge();
        String icon2 = garsonStruct$GarsonServiceItem.getIcon();
        AbstractC13042fc3.h(icon2, "getIcon(...)");
        String customIcon = garsonStruct$GarsonServiceItem.getCustomIcon();
        int id2 = garsonStruct$GarsonServiceItem.getId();
        GarsonStruct$GarsonActionPayload payload = garsonStruct$GarsonServiceItem.getPayload();
        Integer numValueOf = (payload == null || (peer2 = payload.getPeer()) == null) ? null : Integer.valueOf(peer2.getId());
        GarsonStruct$GarsonActionPayload payload2 = garsonStruct$GarsonServiceItem.getPayload();
        Integer numValueOf2 = (payload2 == null || (peer = payload2.getPeer()) == null || (type = peer.getType()) == null) ? null : Integer.valueOf(type.getNumber());
        GarsonStruct$GarsonActionPayload payload3 = garsonStruct$GarsonServiceItem.getPayload();
        String url = payload3 != null ? payload3.getUrl() : null;
        String title2 = garsonStruct$GarsonServiceItem.getTitle();
        AbstractC13042fc3.h(title2, "getTitle(...)");
        return new C5988Lr6(id2, title2, icon2, customIcon, badge, number, numValueOf, numValueOf2, url, null, null, i, garsonStruct$GarsonServiceItem.getMinAppVersion(), garsonStruct$GarsonServiceItem.getMaxAppVersion(), arrayList);
    }
}
