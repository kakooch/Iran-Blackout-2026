package ir.nasim;

import ai.bale.proto.PremiumOuterClass$ResponseGetPackages;
import ai.bale.proto.PremiumStruct$Bundle;
import ai.bale.proto.PremiumStruct$FeatureInfo;
import ai.bale.proto.PremiumStruct$PackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Nl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC6406Nl5 {

    /* renamed from: ir.nasim.Nl5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PremiumOuterClass$ResponseGetPackages c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = premiumOuterClass$ResponseGetPackages;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            long j;
            PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages;
            ArrayList arrayList;
            String str;
            String str2;
            boolean z;
            List listM;
            List<PremiumStruct$FeatureInfo> featuresList;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List<PremiumStruct$PackageInfo> packagesList = this.c.getPackagesList();
            AbstractC13042fc3.h(packagesList, "getPackagesList(...)");
            List<PremiumStruct$PackageInfo> list = packagesList;
            PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages2 = this.c;
            int i = 10;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PremiumStruct$PackageInfo premiumStruct$PackageInfo = (PremiumStruct$PackageInfo) it.next();
                long id = premiumStruct$PackageInfo.getId();
                String faTitle = premiumStruct$PackageInfo.getFaTitle();
                String str3 = "getFaTitle(...)";
                AbstractC13042fc3.h(faTitle, "getFaTitle(...)");
                String enTitle = premiumStruct$PackageInfo.getEnTitle();
                String str4 = "getEnTitle(...)";
                AbstractC13042fc3.h(enTitle, "getEnTitle(...)");
                String faDescription = premiumStruct$PackageInfo.getFaDescription();
                AbstractC13042fc3.h(faDescription, "getFaDescription(...)");
                String enDescription = premiumStruct$PackageInfo.getEnDescription();
                AbstractC13042fc3.h(enDescription, "getEnDescription(...)");
                boolean isSpecial = premiumStruct$PackageInfo.getIsSpecial();
                long duration = premiumStruct$PackageInfo.getDuration();
                Iterator it2 = it;
                long j2 = i;
                long price = premiumStruct$PackageInfo.getPrice() / j2;
                long finalPrice = premiumStruct$PackageInfo.getFinalPrice() / j2;
                PremiumStruct$Bundle premiumStruct$Bundle = premiumOuterClass$ResponseGetPackages2.getBundlesMap().get(AbstractC6392Nk0.e(premiumStruct$PackageInfo.getBundleId()));
                if (premiumStruct$Bundle == null || (featuresList = premiumStruct$Bundle.getFeaturesList()) == null) {
                    j = finalPrice;
                    premiumOuterClass$ResponseGetPackages = premiumOuterClass$ResponseGetPackages2;
                    arrayList = arrayList2;
                    str = faDescription;
                    str2 = enDescription;
                    z = isSpecial;
                    listM = AbstractC10360bX0.m();
                } else {
                    List<PremiumStruct$FeatureInfo> list2 = featuresList;
                    premiumOuterClass$ResponseGetPackages = premiumOuterClass$ResponseGetPackages2;
                    ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list2, i));
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        PremiumStruct$FeatureInfo premiumStruct$FeatureInfo = (PremiumStruct$FeatureInfo) it3.next();
                        long featureId = premiumStruct$FeatureInfo.getFeatureId();
                        String faTitle2 = premiumStruct$FeatureInfo.getFaTitle();
                        AbstractC13042fc3.h(faTitle2, str3);
                        Iterator it4 = it3;
                        String enTitle2 = premiumStruct$FeatureInfo.getEnTitle();
                        AbstractC13042fc3.h(enTitle2, str4);
                        String str5 = str3;
                        String faShortDescription = premiumStruct$FeatureInfo.getFaShortDescription();
                        String str6 = str4;
                        AbstractC13042fc3.h(faShortDescription, "getFaShortDescription(...)");
                        String enShortDescription = premiumStruct$FeatureInfo.getEnShortDescription();
                        ArrayList arrayList4 = arrayList2;
                        AbstractC13042fc3.h(enShortDescription, "getEnShortDescription(...)");
                        String faLongDescription = premiumStruct$FeatureInfo.getFaLongDescription();
                        long j3 = finalPrice;
                        AbstractC13042fc3.h(faLongDescription, "getFaLongDescription(...)");
                        String enLongDescription = premiumStruct$FeatureInfo.getEnLongDescription();
                        AbstractC13042fc3.h(enLongDescription, "getEnLongDescription(...)");
                        int minAppVersion = premiumStruct$FeatureInfo.getMinAppVersion();
                        String iconSvg = premiumStruct$FeatureInfo.getIconSvg();
                        boolean z2 = isSpecial;
                        AbstractC13042fc3.h(iconSvg, "getIconSvg(...)");
                        String mediaUrl = premiumStruct$FeatureInfo.getMediaUrl();
                        String str7 = enDescription;
                        AbstractC13042fc3.h(mediaUrl, "getMediaUrl(...)");
                        String str8 = faDescription;
                        EnumC17768nX3 enumC17768nX3 = premiumStruct$FeatureInfo.getMediaFormat() == EnumC4065Dn5.MediaFormat_GIF ? EnumC17768nX3.a : EnumC17768nX3.b;
                        long quota = premiumStruct$FeatureInfo.getQuota();
                        long resetPeriod = premiumStruct$FeatureInfo.getResetPeriod();
                        String faUnit = premiumStruct$FeatureInfo.getFaUnit();
                        AbstractC13042fc3.h(faUnit, "getFaUnit(...)");
                        String enUnit = premiumStruct$FeatureInfo.getEnUnit();
                        AbstractC13042fc3.h(enUnit, "getEnUnit(...)");
                        arrayList3.add(new C4950Hg2(featureId, faTitle2, enTitle2, faShortDescription, enShortDescription, faLongDescription, enLongDescription, faUnit, enUnit, minAppVersion, iconSvg, mediaUrl, enumC17768nX3, quota, resetPeriod));
                        it3 = it4;
                        str3 = str5;
                        str4 = str6;
                        arrayList2 = arrayList4;
                        finalPrice = j3;
                        isSpecial = z2;
                        enDescription = str7;
                        faDescription = str8;
                    }
                    j = finalPrice;
                    arrayList = arrayList2;
                    str = faDescription;
                    str2 = enDescription;
                    z = isSpecial;
                    listM = arrayList3;
                }
                ArrayList arrayList5 = arrayList;
                arrayList5.add(new C6167Ml5(id, faTitle, enTitle, str, str2, null, z, duration, price, j, listM, 32, null));
                arrayList2 = arrayList5;
                premiumOuterClass$ResponseGetPackages2 = premiumOuterClass$ResponseGetPackages;
                i = 10;
                it = it2;
            }
            return arrayList2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.a(), new a(premiumOuterClass$ResponseGetPackages, null), interfaceC20295rm1);
    }
}
