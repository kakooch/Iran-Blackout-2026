package ir.nasim;

import ai.bale.proto.PremiumStruct$Badge;
import ai.bale.proto.PremiumStruct$BadgeCategory;
import ir.nasim.AbstractC5909Li7;
import ir.nasim.HW;

/* loaded from: classes.dex */
public abstract class DW {
    public static final HW.a a(PremiumStruct$Badge premiumStruct$Badge, long j, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(premiumStruct$Badge, "<this>");
        AbstractC13042fc3.i(interfaceC4557Fq2, "downloadedBadgeUrlContent");
        String faName = premiumStruct$Badge.getFaName();
        AbstractC13042fc3.h(faName, "getFaName(...)");
        String enName = premiumStruct$Badge.getEnName();
        AbstractC13042fc3.h(enName, "getEnName(...)");
        String mediaUrl = premiumStruct$Badge.getMediaUrl();
        AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
        long badgeId = premiumStruct$Badge.getBadgeId();
        return new HW.a(faName, enName, mediaUrl, EnumC23191wW.b.a(premiumStruct$Badge.getMediaFormat().getNumber()), badgeId, j, premiumStruct$Badge.getBadgeId() + "-badges", AbstractC6459Nq2.v(interfaceC4557Fq2));
    }

    public static final HW.b b(PremiumStruct$BadgeCategory premiumStruct$BadgeCategory) {
        AbstractC13042fc3.i(premiumStruct$BadgeCategory, "<this>");
        String faName = premiumStruct$BadgeCategory.getFaName();
        AbstractC13042fc3.h(faName, "getFaName(...)");
        String enName = premiumStruct$BadgeCategory.getEnName();
        AbstractC13042fc3.h(enName, "getEnName(...)");
        return new HW.b(faName, enName, premiumStruct$BadgeCategory.getId(), premiumStruct$BadgeCategory.getId() + "-header");
    }

    public static final AbstractC5909Li7.a c(PremiumStruct$BadgeCategory premiumStruct$BadgeCategory, InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(premiumStruct$BadgeCategory, "<this>");
        AbstractC13042fc3.i(interfaceC4557Fq2, "downloadedBadgeUrlContent");
        long id = premiumStruct$BadgeCategory.getId();
        String faName = premiumStruct$BadgeCategory.getFaName();
        AbstractC13042fc3.h(faName, "getFaName(...)");
        String enName = premiumStruct$BadgeCategory.getEnName();
        AbstractC13042fc3.h(enName, "getEnName(...)");
        String mediaUrl = premiumStruct$BadgeCategory.getMediaUrl();
        AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
        return new AbstractC5909Li7.a(faName, enName, mediaUrl, EnumC23191wW.b.a(premiumStruct$BadgeCategory.getMediaFormat().getNumber()), id, AbstractC6459Nq2.v(interfaceC4557Fq2));
    }
}
