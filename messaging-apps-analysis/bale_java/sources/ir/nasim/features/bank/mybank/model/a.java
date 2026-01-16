package ir.nasim.features.bank.mybank.model;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC6277Mx7;
import ir.nasim.C12523el3;
import ir.nasim.C22155ul3;
import ir.nasim.EnumC16723ll3;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class a extends AbstractC6277Mx7 {

    /* renamed from: ir.nasim.features.bank.mybank.model.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C1118a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16723ll3.values().length];
            try {
                iArr[EnumC16723ll3.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16723ll3.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16723ll3.BEGIN_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ServicesPageSectionEntity b(C12523el3 c12523el3) throws IOException, NumberFormatException {
        AbstractC13042fc3.i(c12523el3, "reader");
        c12523el3.B();
        c12523el3.R();
        String strT0 = c12523el3.T0();
        ServicesPageSectionEntity botsVitrineExtra = null;
        if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.Wallet.class.getName())) {
            String strT02 = null;
            Integer numValueOf = null;
            while (c12523el3.l()) {
                EnumC16723ll3 enumC16723ll3G = c12523el3.G();
                int i = enumC16723ll3G == null ? -1 : C1118a.a[enumC16723ll3G.ordinal()];
                if (i == 1) {
                    strT02 = c12523el3.T0();
                } else if (i != 2) {
                    c12523el3.R();
                } else {
                    numValueOf = Integer.valueOf(c12523el3.r0());
                }
            }
            if (strT02 != null && numValueOf != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.Wallet(numValueOf.intValue(), strT02);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.Shortcut.class.getName())) {
            String strT03 = null;
            Integer numValueOf2 = null;
            while (c12523el3.l()) {
                EnumC16723ll3 enumC16723ll3G2 = c12523el3.G();
                int i2 = enumC16723ll3G2 == null ? -1 : C1118a.a[enumC16723ll3G2.ordinal()];
                if (i2 == 1) {
                    strT03 = c12523el3.T0();
                } else if (i2 != 2) {
                    c12523el3.R();
                } else {
                    numValueOf2 = Integer.valueOf(c12523el3.r0());
                }
            }
            if (strT03 != null && numValueOf2 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.Shortcut(numValueOf2.intValue(), strT03);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.CustomServices.class.getName())) {
            ArrayList arrayList = new ArrayList();
            String strT04 = null;
            Integer numValueOf3 = null;
            while (c12523el3.l()) {
                EnumC16723ll3 enumC16723ll3G3 = c12523el3.G();
                int i3 = enumC16723ll3G3 == null ? -1 : C1118a.a[enumC16723ll3G3.ordinal()];
                if (i3 == 1) {
                    strT04 = c12523el3.T0();
                } else if (i3 == 2) {
                    numValueOf3 = Integer.valueOf(c12523el3.r0());
                } else if (i3 != 3) {
                    c12523el3.R();
                } else {
                    c12523el3.a();
                    while (c12523el3.l()) {
                        arrayList.add(Integer.valueOf(c12523el3.r0()));
                    }
                    c12523el3.e();
                }
            }
            if ((!arrayList.isEmpty()) && strT04 != null && numValueOf3 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.CustomServices(numValueOf3.intValue(), strT04, arrayList);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.Banner.class.getName())) {
            String strT05 = null;
            Integer numValueOf4 = null;
            while (c12523el3.l()) {
                EnumC16723ll3 enumC16723ll3G4 = c12523el3.G();
                int i4 = enumC16723ll3G4 == null ? -1 : C1118a.a[enumC16723ll3G4.ordinal()];
                if (i4 == 1) {
                    strT05 = c12523el3.T0();
                } else if (i4 != 2) {
                    c12523el3.R();
                } else {
                    numValueOf4 = Integer.valueOf(c12523el3.r0());
                }
            }
            if (strT05 != null && numValueOf4 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.Banner(numValueOf4.intValue(), strT05);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.BotsVitrine.class.getName())) {
            ArrayList arrayList2 = new ArrayList();
            String strT06 = null;
            Integer numValueOf5 = null;
            while (c12523el3.l()) {
                EnumC16723ll3 enumC16723ll3G5 = c12523el3.G();
                int i5 = enumC16723ll3G5 == null ? -1 : C1118a.a[enumC16723ll3G5.ordinal()];
                if (i5 == 1) {
                    strT06 = c12523el3.T0();
                } else if (i5 == 2) {
                    numValueOf5 = Integer.valueOf(c12523el3.r0());
                } else if (i5 != 3) {
                    c12523el3.R();
                } else {
                    c12523el3.a();
                    while (c12523el3.l()) {
                        arrayList2.add(Integer.valueOf(c12523el3.r0()));
                    }
                    c12523el3.e();
                }
            }
            if ((!arrayList2.isEmpty()) && strT06 != null && numValueOf5 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.BotsVitrine(numValueOf5.intValue(), strT06, arrayList2);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.ServiceItemsExtra.class.getName())) {
            ArrayList arrayList3 = new ArrayList();
            Integer numValueOf6 = null;
            String strT07 = null;
            String strT08 = "";
            int iR0 = 0;
            int iR02 = 0;
            int iR03 = 0;
            while (c12523el3.l()) {
                if (c12523el3.G() == EnumC16723ll3.NAME) {
                    String strN0 = c12523el3.n0();
                    if (strN0 != null) {
                        switch (strN0.hashCode()) {
                            case -2098833600:
                                if (!strN0.equals("buttonNavigationType")) {
                                    break;
                                } else {
                                    iR03 = c12523el3.r0();
                                    break;
                                }
                            case -1927494246:
                                if (!strN0.equals("servicesIDs")) {
                                    break;
                                } else {
                                    c12523el3.a();
                                    while (c12523el3.l()) {
                                        arrayList3.add(Integer.valueOf(c12523el3.r0()));
                                    }
                                    c12523el3.e();
                                    break;
                                }
                            case -1433402578:
                                if (!strN0.equals("serviceCategoryID")) {
                                    break;
                                } else {
                                    iR02 = c12523el3.r0();
                                    break;
                                }
                            case -678731072:
                                if (!strN0.equals("sectionID")) {
                                    break;
                                } else {
                                    numValueOf6 = Integer.valueOf(c12523el3.r0());
                                    break;
                                }
                            case 110371416:
                                if (!strN0.equals("title")) {
                                    break;
                                } else {
                                    strT07 = c12523el3.T0();
                                    break;
                                }
                            case 358545279:
                                if (!strN0.equals("buttonText")) {
                                    break;
                                } else {
                                    strT08 = c12523el3.T0();
                                    break;
                                }
                            case 2112755069:
                                if (!strN0.equals("badgeType")) {
                                    break;
                                } else {
                                    iR0 = c12523el3.r0();
                                    break;
                                }
                        }
                    }
                    c12523el3.R();
                }
            }
            if ((!arrayList3.isEmpty()) && strT07 != null && numValueOf6 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.ServiceItemsExtra(numValueOf6.intValue(), strT07, iR0, iR02, iR03, strT08, arrayList3);
            }
        } else if (AbstractC13042fc3.d(strT0, ServicesPageSectionEntity.BotsVitrineExtra.class.getName())) {
            ArrayList arrayList4 = new ArrayList();
            Integer numValueOf7 = null;
            String strT09 = null;
            String strT010 = "";
            String strT011 = strT010;
            int iR04 = 0;
            int iR05 = 0;
            int iR06 = 0;
            while (c12523el3.l()) {
                if (c12523el3.G() == EnumC16723ll3.NAME) {
                    String strN02 = c12523el3.n0();
                    if (strN02 != null) {
                        switch (strN02.hashCode()) {
                            case -2098833600:
                                if (!strN02.equals("buttonNavigationType")) {
                                    break;
                                } else {
                                    iR06 = c12523el3.r0();
                                    break;
                                }
                            case -1822630137:
                                if (!strN02.equals("buttonNavigationDestinationUrl")) {
                                    break;
                                } else {
                                    strT010 = c12523el3.T0();
                                    break;
                                }
                            case -1433402578:
                                if (!strN02.equals("serviceCategoryID")) {
                                    break;
                                } else {
                                    iR05 = c12523el3.r0();
                                    break;
                                }
                            case -678731072:
                                if (!strN02.equals("sectionID")) {
                                    break;
                                } else {
                                    numValueOf7 = Integer.valueOf(c12523el3.r0());
                                    break;
                                }
                            case 69510060:
                                if (!strN02.equals("botsIDs")) {
                                    break;
                                } else {
                                    c12523el3.a();
                                    while (c12523el3.l()) {
                                        arrayList4.add(Integer.valueOf(c12523el3.r0()));
                                    }
                                    c12523el3.e();
                                    break;
                                }
                            case 110371416:
                                if (!strN02.equals("title")) {
                                    break;
                                } else {
                                    strT09 = c12523el3.T0();
                                    break;
                                }
                            case 358545279:
                                if (!strN02.equals("buttonText")) {
                                    break;
                                } else {
                                    strT011 = c12523el3.T0();
                                    break;
                                }
                            case 2112755069:
                                if (!strN02.equals("badgeType")) {
                                    break;
                                } else {
                                    iR04 = c12523el3.r0();
                                    break;
                                }
                        }
                    }
                    c12523el3.R();
                }
            }
            if ((!arrayList4.isEmpty()) && strT09 != null && numValueOf7 != null) {
                botsVitrineExtra = new ServicesPageSectionEntity.BotsVitrineExtra(numValueOf7.intValue(), strT09, iR04, iR05, iR06, strT010, strT011, arrayList4);
            }
        }
        c12523el3.F();
        return botsVitrineExtra;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, ServicesPageSectionEntity servicesPageSectionEntity) throws IOException {
        AbstractC13042fc3.i(c22155ul3, "writer");
        if (servicesPageSectionEntity == null) {
            return;
        }
        c22155ul3.d();
        if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Wallet) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.Wallet wallet = (ServicesPageSectionEntity.Wallet) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(wallet.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(wallet.getTitle());
        } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Shortcut) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.Shortcut shortcut = (ServicesPageSectionEntity.Shortcut) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(shortcut.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(shortcut.getTitle());
        } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.CustomServices) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.CustomServices customServices = (ServicesPageSectionEntity.CustomServices) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(customServices.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(customServices.getTitle());
            c22155ul3.p("servicesIDs");
            c22155ul3.c();
            Iterator<T> it = customServices.getServicesIDs().iterator();
            while (it.hasNext()) {
                c22155ul3.U(Integer.valueOf(((Number) it.next()).intValue()));
            }
            c22155ul3.g();
        } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.Banner) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.Banner banner = (ServicesPageSectionEntity.Banner) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(banner.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(banner.getTitle());
        } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.BotsVitrine) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.BotsVitrine botsVitrine = (ServicesPageSectionEntity.BotsVitrine) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(botsVitrine.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(botsVitrine.getTitle());
            c22155ul3.p("botsIDs");
            c22155ul3.c();
            Iterator<T> it2 = botsVitrine.getBotsIDs().iterator();
            while (it2.hasNext()) {
                c22155ul3.U(Integer.valueOf(((Number) it2.next()).intValue()));
            }
            c22155ul3.g();
        } else if (servicesPageSectionEntity instanceof ServicesPageSectionEntity.ServiceItemsExtra) {
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.ServiceItemsExtra serviceItemsExtra = (ServicesPageSectionEntity.ServiceItemsExtra) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(serviceItemsExtra.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(serviceItemsExtra.getTitle());
            c22155ul3.p("badgeType");
            c22155ul3.U(Integer.valueOf(serviceItemsExtra.getBadgeType()));
            c22155ul3.p("serviceCategoryID");
            c22155ul3.U(Integer.valueOf(serviceItemsExtra.getServiceCategoryID()));
            c22155ul3.p("buttonNavigationType");
            c22155ul3.U(Integer.valueOf(serviceItemsExtra.getButtonNavigationType()));
            c22155ul3.p("buttonText");
            c22155ul3.X(serviceItemsExtra.getButtonText());
            c22155ul3.p("servicesIDs");
            c22155ul3.c();
            Iterator<T> it3 = serviceItemsExtra.getServicesIDs().iterator();
            while (it3.hasNext()) {
                c22155ul3.U(Integer.valueOf(((Number) it3.next()).intValue()));
            }
            c22155ul3.g();
        } else {
            if (!(servicesPageSectionEntity instanceof ServicesPageSectionEntity.BotsVitrineExtra)) {
                throw new NoWhenBranchMatchedException();
            }
            c22155ul3.p("type");
            c22155ul3.X(servicesPageSectionEntity.getClass().getName());
            c22155ul3.p("sectionID");
            ServicesPageSectionEntity.BotsVitrineExtra botsVitrineExtra = (ServicesPageSectionEntity.BotsVitrineExtra) servicesPageSectionEntity;
            c22155ul3.U(Integer.valueOf(botsVitrineExtra.getSectionID()));
            c22155ul3.p("title");
            c22155ul3.X(botsVitrineExtra.getTitle());
            c22155ul3.p("badgeType");
            c22155ul3.U(Integer.valueOf(botsVitrineExtra.getBadgeType()));
            c22155ul3.p("serviceCategoryID");
            c22155ul3.U(Integer.valueOf(botsVitrineExtra.getServiceCategoryID()));
            c22155ul3.p("buttonNavigationType");
            c22155ul3.U(Integer.valueOf(botsVitrineExtra.getButtonNavigationType()));
            c22155ul3.p("buttonNavigationDestinationUrl");
            c22155ul3.X(botsVitrineExtra.getButtonNavigationDestinationUrl());
            c22155ul3.p("buttonText");
            c22155ul3.X(botsVitrineExtra.getButtonText());
            c22155ul3.p("botsIDs");
            c22155ul3.c();
            Iterator<T> it4 = botsVitrineExtra.getBotsIDs().iterator();
            while (it4.hasNext()) {
                c22155ul3.U(Integer.valueOf(((Number) it4.next()).intValue()));
            }
            c22155ul3.g();
        }
        c22155ul3.j();
    }
}
