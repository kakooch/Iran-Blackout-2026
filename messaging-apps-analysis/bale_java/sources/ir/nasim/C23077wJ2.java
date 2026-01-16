package ir.nasim;

import android.content.Context;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.wJ2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23077wJ2 {
    public static final C23077wJ2 a = new C23077wJ2();
    private static final Map b = new LinkedHashMap();
    private static final Map c = new LinkedHashMap();
    public static final int d = 8;

    private C23077wJ2() {
    }

    private final int c(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? C5495Jo7.a.q1() : C5495Jo7.a.q1() : C5495Jo7.a.p1() : C5495Jo7.a.o1() : C5495Jo7.a.n1() : C5495Jo7.a.m1();
    }

    public static final PFMTag d(EnumC14437hu7 enumC14437hu7) {
        AbstractC13042fc3.i(enumC14437hu7, "transactionType");
        return enumC14437hu7 == EnumC14437hu7.a ? new PFMTag(0, 1L, null, EnumC18897pR4.c, null, KB5.ic_deposit_no_tag, C5495Jo7.a.a2(), null, WKSRecord.Service.CISCO_SYS, null) : new PFMTag(0, -1L, null, EnumC18897pR4.d, null, KB5.ic_withdraw_no_tag, C5495Jo7.a.b2(), null, WKSRecord.Service.CISCO_SYS, null);
    }

    public static final PFMTag g(String str, EnumC18897pR4 enumC18897pR4, PFMTag pFMTag) {
        AbstractC13042fc3.i(str, "label");
        AbstractC13042fc3.i(enumC18897pR4, "transactionType");
        Object obj = null;
        if (pFMTag == null) {
            Iterator it = a.f().values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                PFMTag pFMTag2 = (PFMTag) next;
                if (AbstractC13042fc3.d(pFMTag2.getLabel(), str) && pFMTag2.getTransactionType() == enumC18897pR4) {
                    obj = next;
                    break;
                }
            }
            return (PFMTag) obj;
        }
        List list = (List) a.e().get(pFMTag);
        if (list == null) {
            return null;
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            PFMTag pFMTag3 = (PFMTag) next2;
            if (AbstractC13042fc3.d(pFMTag3.getLabel(), str) && pFMTag3.getTransactionType() == enumC18897pR4) {
                obj = next2;
                break;
            }
        }
        return (PFMTag) obj;
    }

    public static final List h(EnumC18897pR4 enumC18897pR4) {
        AbstractC13042fc3.i(enumC18897pR4, "pfmTransactionType");
        Collection collectionValues = a.f().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((PFMTag) obj).getTransactionType() == enumC18897pR4) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void i() {
        Context contextD = C5721Ko.a.d();
        Map map = b;
        String string = contextD.getString(AbstractC12217eE5.pfm_tag2_food);
        AbstractC13042fc3.h(string, "getString(...)");
        EnumC18897pR4 enumC18897pR4 = EnumC18897pR4.d;
        int i = KB5.ic_tag2_food;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        map.put(2L, new PFMTag(0, 2L, string, enumC18897pR4, null, i, c5495Jo7.B1(), null, 128, null));
        String string2 = contextD.getString(AbstractC12217eE5.pfm_tag10_installment);
        AbstractC13042fc3.h(string2, "getString(...)");
        map.put(10L, new PFMTag(0, 10L, string2, enumC18897pR4, null, KB5.ic_tag10_installment, c5495Jo7.r1(), null, 128, null));
        String string3 = contextD.getString(AbstractC12217eE5.pfm_tag4_internet);
        AbstractC13042fc3.h(string3, "getString(...)");
        map.put(4L, new PFMTag(0, 4L, string3, enumC18897pR4, null, KB5.ic_tag4_internet, c5495Jo7.U1(), null, 128, null));
        String string4 = contextD.getString(AbstractC12217eE5.pfm_tag3_transport);
        AbstractC13042fc3.h(string4, "getString(...)");
        map.put(3L, new PFMTag(0, 3L, string4, enumC18897pR4, null, KB5.ic_tag3_transport, c5495Jo7.M1(), null, 128, null));
        String string5 = contextD.getString(AbstractC12217eE5.pfm_tag6_car_services);
        AbstractC13042fc3.h(string5, "getString(...)");
        map.put(6L, new PFMTag(0, 6L, string5, enumC18897pR4, null, KB5.ic_tag6_car_services, c5495Jo7.W1(), null, 128, null));
        String string6 = contextD.getString(AbstractC12217eE5.pfm_tag5_bill);
        AbstractC13042fc3.h(string6, "getString(...)");
        map.put(5L, new PFMTag(0, 5L, string6, enumC18897pR4, null, KB5.ic_tag5_bill, c5495Jo7.V1(), null, 128, null));
        String string7 = contextD.getString(AbstractC12217eE5.pfm_tag8_health);
        AbstractC13042fc3.h(string7, "getString(...)");
        map.put(8L, new PFMTag(0, 8L, string7, enumC18897pR4, null, KB5.ic_tag8_health, c5495Jo7.Y1(), null, 128, null));
        String string8 = contextD.getString(AbstractC12217eE5.pfm_tag13_personal);
        AbstractC13042fc3.h(string8, "getString(...)");
        map.put(13L, new PFMTag(0, 13L, string8, enumC18897pR4, null, KB5.ic_tag13_personal, c5495Jo7.u1(), null, 128, null));
        String string9 = contextD.getString(AbstractC12217eE5.pfm_tag7_makeup);
        AbstractC13042fc3.h(string9, "getString(...)");
        map.put(7L, new PFMTag(0, 7L, string9, enumC18897pR4, null, KB5.ic_tag7_makeup, c5495Jo7.X1(), null, 128, null));
        String string10 = contextD.getString(AbstractC12217eE5.pfm_tag11_furniture);
        AbstractC13042fc3.h(string10, "getString(...)");
        map.put(11L, new PFMTag(0, 11L, string10, enumC18897pR4, null, KB5.ic_tag11_furniture, c5495Jo7.s1(), null, 128, null));
        String string11 = contextD.getString(AbstractC12217eE5.pfm_tag35_digital);
        AbstractC13042fc3.h(string11, "getString(...)");
        map.put(35L, new PFMTag(0, 35L, string11, enumC18897pR4, null, KB5.ic_tag35_digital, c5495Jo7.S1(), null, 128, null));
        String string12 = contextD.getString(AbstractC12217eE5.pfm_tag19_lend);
        AbstractC13042fc3.h(string12, "getString(...)");
        map.put(19L, new PFMTag(0, 19L, string12, enumC18897pR4, null, KB5.ic_tag19_lend, c5495Jo7.A1(), null, 128, null));
        String string13 = contextD.getString(AbstractC12217eE5.pfm_tag15_kheirieh);
        AbstractC13042fc3.h(string13, "getString(...)");
        map.put(15L, new PFMTag(0, 15L, string13, enumC18897pR4, null, KB5.ic_tag15_kheirieh, c5495Jo7.w1(), null, 128, null));
        String string14 = contextD.getString(AbstractC12217eE5.pfm_tag12_entertainment);
        AbstractC13042fc3.h(string14, "getString(...)");
        map.put(12L, new PFMTag(0, 12L, string14, enumC18897pR4, null, KB5.ic_tag12_entertainment, c5495Jo7.t1(), null, 128, null));
        String string15 = contextD.getString(AbstractC12217eE5.pfm_tag9_housing);
        AbstractC13042fc3.h(string15, "getString(...)");
        map.put(9L, new PFMTag(0, 9L, string15, enumC18897pR4, null, KB5.ic_tag9_housing, c5495Jo7.Z1(), null, 128, null));
        String string16 = contextD.getString(AbstractC12217eE5.pfm_tag18_invest);
        AbstractC13042fc3.h(string16, "getString(...)");
        map.put(18L, new PFMTag(0, 18L, string16, enumC18897pR4, null, KB5.ic_tag18_invest, c5495Jo7.z1(), null, 128, null));
        String string17 = contextD.getString(AbstractC12217eE5.pfm_tag14_education);
        AbstractC13042fc3.h(string17, "getString(...)");
        map.put(14L, new PFMTag(0, 14L, string17, enumC18897pR4, null, KB5.ic_tag14_education, c5495Jo7.v1(), null, 128, null));
        String string18 = contextD.getString(AbstractC12217eE5.pfm_tag17_travel);
        AbstractC13042fc3.h(string18, "getString(...)");
        map.put(17L, new PFMTag(0, 17L, string18, enumC18897pR4, null, KB5.ic_tag17_travel, c5495Jo7.y1(), null, 128, null));
        String string19 = contextD.getString(AbstractC12217eE5.pfm_tag36_sport);
        AbstractC13042fc3.h(string19, "getString(...)");
        map.put(36L, new PFMTag(0, 36L, string19, enumC18897pR4, null, KB5.ic_tag36_sport, c5495Jo7.T1(), null, 128, null));
        String string20 = contextD.getString(AbstractC12217eE5.pfm_tag16_gift);
        AbstractC13042fc3.h(string20, "getString(...)");
        map.put(16L, new PFMTag(0, 16L, string20, enumC18897pR4, null, KB5.ic_tag16_gift, c5495Jo7.x1(), null, 128, null));
        String string21 = contextD.getString(AbstractC12217eE5.pfm_tag33_jib_be_jib);
        AbstractC13042fc3.h(string21, "getString(...)");
        map.put(33L, new PFMTag(0, 33L, string21, enumC18897pR4, null, KB5.ic_pfm_jib_be_jib, c5495Jo7.Q1(), null, 128, null));
        String string22 = contextD.getString(AbstractC12217eE5.pfm_tag31_withdraw_other);
        AbstractC13042fc3.h(string22, "getString(...)");
        map.put(31L, new PFMTag(0, 31L, string22, enumC18897pR4, null, KB5.ic_tag_withdraw_other, c5495Jo7.O1(), null, 128, null));
        String string23 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag20_salary);
        AbstractC13042fc3.h(string23, "getString(...)");
        EnumC18897pR4 enumC18897pR42 = EnumC18897pR4.c;
        map.put(20L, new PFMTag(0, 20L, string23, enumC18897pR42, null, KB5.ic_tag20_salary, c5495Jo7.C1(), null, 128, null));
        String string24 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag25_dong);
        AbstractC13042fc3.h(string24, "getString(...)");
        map.put(25L, new PFMTag(0, 25L, string24, enumC18897pR42, null, KB5.ic_tag25_dong, c5495Jo7.H1(), null, 128, null));
        String string25 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag22_profit);
        AbstractC13042fc3.h(string25, "getString(...)");
        map.put(22L, new PFMTag(0, 22L, string25, enumC18897pR42, null, KB5.ic_tag22_profit, c5495Jo7.E1(), null, 128, null));
        String string26 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag24_pocket_money);
        AbstractC13042fc3.h(string26, "getString(...)");
        map.put(24L, new PFMTag(0, 24L, string26, enumC18897pR42, null, KB5.ic_tag24_pocket_money, c5495Jo7.G1(), null, 128, null));
        String string27 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag34_jib_be_jib);
        AbstractC13042fc3.h(string27, "getString(...)");
        map.put(34L, new PFMTag(0, 34L, string27, enumC18897pR42, null, KB5.ic_pfm_jib_be_jib, c5495Jo7.R1(), null, 128, null));
        String string28 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag26_loan);
        AbstractC13042fc3.h(string28, "getString(...)");
        map.put(26L, new PFMTag(0, 26L, string28, enumC18897pR42, null, KB5.ic_tag26_loan, c5495Jo7.I1(), null, 128, null));
        String string29 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag21_yaraneh);
        AbstractC13042fc3.h(string29, "getString(...)");
        map.put(21L, new PFMTag(0, 21L, string29, enumC18897pR42, null, KB5.ic_tag21_yaraneh, c5495Jo7.D1(), null, 128, null));
        String string30 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag27_sell);
        AbstractC13042fc3.h(string30, "getString(...)");
        map.put(27L, new PFMTag(0, 27L, string30, enumC18897pR42, null, KB5.ic_tag27_sell, c5495Jo7.J1(), null, 128, null));
        String string31 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag23_rent);
        AbstractC13042fc3.h(string31, "getString(...)");
        map.put(23L, new PFMTag(0, 23L, string31, enumC18897pR42, null, KB5.ic_tag23_rent, c5495Jo7.F1(), null, 128, null));
        String string32 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag28_gift);
        AbstractC13042fc3.h(string32, "getString(...)");
        map.put(28L, new PFMTag(0, 28L, string32, enumC18897pR42, null, KB5.ic_tag28_gift, c5495Jo7.K1(), null, 128, null));
        String string33 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag30_compensation);
        AbstractC13042fc3.h(string33, "getString(...)");
        map.put(30L, new PFMTag(0, 30L, string33, enumC18897pR42, null, KB5.ic_tag30_compensation, c5495Jo7.N1(), null, 128, null));
        String string34 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag29_reward);
        AbstractC13042fc3.h(string34, "getString(...)");
        map.put(29L, new PFMTag(0, 29L, string34, enumC18897pR42, null, KB5.ic_tag29_reward, c5495Jo7.L1(), null, 128, null));
        String string35 = contextD.getString(AbstractC12217eE5.pfm_deposit_tag32_other);
        AbstractC13042fc3.h(string35, "getString(...)");
        map.put(32L, new PFMTag(0, 32L, string35, enumC18897pR42, null, KB5.ic_tag_deposit_other, c5495Jo7.P1(), null, 128, null));
    }

    public static final void j(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        if (pFMTag.getParentTag() == null) {
            b.remove(Long.valueOf(pFMTag.getId()));
            return;
        }
        List list = (List) c.get(pFMTag.getParentTag());
        if (list != null) {
            list.remove(pFMTag);
        }
    }

    public final void a(List list) {
        List list2;
        AbstractC13042fc3.i(list, "tagList");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PFMTag pFMTag = (PFMTag) it.next();
            PFMTag parentTag = pFMTag.getParentTag();
            if (parentTag != null) {
                Map map = c;
                if (map.containsKey(parentTag)) {
                    Object obj = map.get(parentTag);
                    AbstractC13042fc3.f(obj);
                    if (!((List) obj).contains(pFMTag) && (list2 = (List) map.get(parentTag)) != null) {
                        list2.add(pFMTag);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(pFMTag);
                    map.put(parentTag, arrayList);
                }
            } else {
                Map map2 = c;
                if (!map2.containsKey(pFMTag)) {
                    map2.put(pFMTag, new ArrayList());
                }
                if (pFMTag.getColor() == 0) {
                    pFMTag.i(c(pFMTag.getColor()));
                }
                if (pFMTag.getIconId() == 0) {
                    pFMTag.j(KB5.pfm_default_tag);
                }
                b.put(Long.valueOf(pFMTag.getId()), pFMTag);
            }
        }
    }

    public final void b() {
        Map map = b;
        if (!map.isEmpty()) {
            map.clear();
            c.clear();
        }
    }

    public final Map e() {
        return c;
    }

    public final Map f() {
        Map map = b;
        if (map.isEmpty()) {
            i();
        }
        return map;
    }
}
