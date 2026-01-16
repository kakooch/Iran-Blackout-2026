package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
import io.appmetrica.analytics.modulesapi.internal.service.LocationServiceExtension;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleLocationSourcesServiceController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerFactory;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC21263tO3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C19938rB7;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.appmetrica.analytics.impl.yj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3001yj implements InterfaceC2970xc, InterfaceC2668kl, AskForPermissionStrategyModuleProvider {
    public final String a = "rp";
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public volatile AskForPermissionStrategyModuleProvider c = new C2989y7();

    @Override // io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
        SdkIdentifiers sdkIdentifiers = new SdkIdentifiers(c2549fl.f(), c2549fl.b(), c2549fl.c());
        Zf zf = new Zf(c2549fl.d(), c2549fl.e());
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : this.b) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration != null) {
                remoteConfigExtensionConfiguration.getRemoteConfigUpdateListener().onRemoteConfigUpdated(new C2977xj(sdkIdentifiers, zf, c2549fl.B.get(moduleServiceEntryPoint.getIdentifier())));
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final Map<String, Fc> b() {
        CopyOnWriteArrayList<ModuleServiceEntryPoint> copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        for (ModuleServiceEntryPoint moduleServiceEntryPoint : copyOnWriteArrayList) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = moduleServiceEntryPoint.getRemoteConfigExtensionConfiguration();
            XV4 xv4A = remoteConfigExtensionConfiguration != null ? AbstractC4616Fw7.a(moduleServiceEntryPoint.getIdentifier(), new Fc(remoteConfigExtensionConfiguration)) : null;
            if (xv4A != null) {
                arrayList.add(xv4A);
            }
        }
        return AbstractC20051rO3.w(arrayList);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final Map<String, Integer> c() {
        List listM;
        Map<String, Integer> blocks;
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = ((ModuleServiceEntryPoint) it.next()).getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (blocks = remoteConfigExtensionConfiguration.getBlocks()) == null || (listM = AbstractC21263tO3.C(blocks)) == null) {
                listM = AbstractC10360bX0.m();
            }
            AbstractC13610gX0.D(arrayList, listM);
        }
        return AbstractC20051rO3.w(arrayList);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final List<Consumer<Location>> d() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            LocationServiceExtension locationServiceExtension = ((ModuleServiceEntryPoint) it.next()).getLocationServiceExtension();
            Consumer<Location> locationConsumer = locationServiceExtension != null ? locationServiceExtension.getLocationConsumer() : null;
            if (locationConsumer != null) {
                arrayList.add(locationConsumer);
            }
        }
        return arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final ModuleLocationSourcesServiceController e() {
        ModuleLocationSourcesServiceController locationSourcesController;
        Iterator it = this.b.iterator();
        do {
            locationSourcesController = null;
            if (!it.hasNext()) {
                break;
            }
            LocationServiceExtension locationServiceExtension = ((ModuleServiceEntryPoint) it.next()).getLocationServiceExtension();
            if (locationServiceExtension != null) {
                locationSourcesController = locationServiceExtension.getLocationSourcesController();
            }
        } while (locationSourcesController == null);
        return locationSourcesController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final Toggle f() {
        Toggle locationControllerAppStateToggle;
        Iterator it = this.b.iterator();
        do {
            locationControllerAppStateToggle = null;
            if (!it.hasNext()) {
                break;
            }
            LocationServiceExtension locationServiceExtension = ((ModuleServiceEntryPoint) it.next()).getLocationServiceExtension();
            if (locationServiceExtension != null) {
                locationControllerAppStateToggle = locationServiceExtension.getLocationControllerAppStateToggle();
            }
        } while (locationControllerAppStateToggle == null);
        return locationControllerAppStateToggle;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final List<String> g() {
        List<String> listM;
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            RemoteConfigExtensionConfiguration remoteConfigExtensionConfiguration = ((ModuleServiceEntryPoint) it.next()).getRemoteConfigExtensionConfiguration();
            if (remoteConfigExtensionConfiguration == null || (listM = remoteConfigExtensionConfiguration.getFeatures()) == null) {
                listM = AbstractC10360bX0.m();
            }
            AbstractC13610gX0.D(arrayList, listM);
        }
        return arrayList;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public final PermissionStrategy getAskForPermissionStrategy() {
        return this.c.getAskForPermissionStrategy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2970xc
    public final List<ModuleServicesDatabase> a() {
        Object objValueOf;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            ModuleServiceEntryPoint moduleServiceEntryPoint = (ModuleServiceEntryPoint) it.next();
            try {
                ModuleServicesDatabase moduleServicesDatabase = moduleServiceEntryPoint.getModuleServicesDatabase();
                objValueOf = moduleServicesDatabase != null ? Boolean.valueOf(arrayList.add(moduleServicesDatabase)) : null;
            } catch (Throwable th) {
                hashSet.add(moduleServiceEntryPoint);
                String identifier = moduleServiceEntryPoint.getIdentifier();
                C2523ej c2523ej = Ei.a;
                Map mapG = AbstractC19460qO3.g(AbstractC4616Fw7.a(identifier, AbstractC19460qO3.g(AbstractC4616Fw7.a("db", AbstractC16632lc2.b(th)))));
                c2523ej.getClass();
                c2523ej.a(new C2473cj("service_module_errors", mapG));
                objValueOf = C19938rB7.a;
            }
            if (objValueOf != null) {
                arrayList2.add(objValueOf);
            }
        }
        this.b.removeAll(hashSet);
        return arrayList;
    }

    public final void a(ModuleServiceEntryPoint<Object> moduleServiceEntryPoint) {
        this.b.add(moduleServiceEntryPoint);
        if (AbstractC13042fc3.d(this.a, moduleServiceEntryPoint.getIdentifier()) && (moduleServiceEntryPoint instanceof AskForPermissionStrategyModuleProvider)) {
            this.c = (AskForPermissionStrategyModuleProvider) moduleServiceEntryPoint;
        }
    }

    public final void a(ServiceContext serviceContext, C2549fl c2549fl) {
        HashSet hashSet = new HashSet();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ModuleServiceEntryPoint moduleServiceEntryPoint = (ModuleServiceEntryPoint) it.next();
            try {
                moduleServiceEntryPoint.initServiceSide(serviceContext, new C2977xj(new SdkIdentifiers(c2549fl.d, c2549fl.a, c2549fl.b), new Zf(c2549fl.v, c2549fl.u), c2549fl.B.get(moduleServiceEntryPoint.getIdentifier())));
                ModuleEventServiceHandlerFactory moduleEventServiceHandlerFactory = moduleServiceEntryPoint.getModuleEventServiceHandlerFactory();
                if (moduleEventServiceHandlerFactory != null) {
                    Bc bc = C2586ha.C.t;
                    String identifier = moduleServiceEntryPoint.getIdentifier();
                    synchronized (bc) {
                        bc.a.put(identifier, moduleEventServiceHandlerFactory);
                    }
                } else {
                    continue;
                }
            } catch (Throwable th) {
                String identifier2 = moduleServiceEntryPoint.getIdentifier();
                C2523ej c2523ej = Ei.a;
                Map mapG = AbstractC19460qO3.g(AbstractC4616Fw7.a(identifier2, AbstractC19460qO3.g(AbstractC4616Fw7.a("init", AbstractC16632lc2.b(th)))));
                c2523ej.getClass();
                c2523ej.a(new C2473cj("service_module_errors", mapG));
                hashSet.add(moduleServiceEntryPoint);
            }
        }
        this.b.removeAll(hashSet);
    }
}
