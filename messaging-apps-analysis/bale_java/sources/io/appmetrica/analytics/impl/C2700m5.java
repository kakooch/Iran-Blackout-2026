package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
import ir.nasim.AbstractC15401jX0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.m5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2700m5 implements ModuleAdRevenueProcessor, ModuleAdRevenueProcessorsHolder {
    public final ArrayList a = new ArrayList();

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return AbstractC15401jX0.A0(this.a, null, "Composite processor with " + this.a.size() + " children: [", "]", 0, null, C2676l5.a, 25, null);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        Object next;
        boolean zProcess;
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Processing Ad Revenue for " + Arrays.toString(objArr), new Object[0]);
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ModuleAdRevenueProcessor moduleAdRevenueProcessor = (ModuleAdRevenueProcessor) next;
            try {
                zProcess = moduleAdRevenueProcessor.process(Arrays.copyOf(objArr, objArr.length));
                if (!zProcess) {
                    LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue was not processed by " + moduleAdRevenueProcessor.getDescription(), new Object[0]);
                }
            } catch (Throwable th) {
                LoggerStorage.getMainPublicOrAnonymousLogger().error(th, "Got exception from processor " + moduleAdRevenueProcessor.getDescription(), new Object[0]);
            }
            if (zProcess) {
                break;
            }
        }
        boolean z = ((ModuleAdRevenueProcessor) next) != null;
        if (!z) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue was not processed by " + getDescription() + " since processor for " + Arrays.toString(objArr) + " was not found", new Object[0]);
        }
        return z;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder
    public final void register(ModuleAdRevenueProcessor moduleAdRevenueProcessor) {
        this.a.add(moduleAdRevenueProcessor);
    }
}
