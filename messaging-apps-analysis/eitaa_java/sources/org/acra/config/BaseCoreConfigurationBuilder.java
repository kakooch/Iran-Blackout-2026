package org.acra.config;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.plugins.PluginLoader;
import org.acra.plugins.ServicePluginLoader;
import org.acra.util.StubCreator;

/* loaded from: classes.dex */
public final class BaseCoreConfigurationBuilder {
    private final Context app;
    private List<ConfigurationBuilder> configurationBuilders;
    private List<Configuration> configurations;
    private final Map<ReportField, Boolean> reportContentChanges = new EnumMap(ReportField.class);
    private PluginLoader pluginLoader = new ServicePluginLoader();

    static /* synthetic */ Object lambda$getPluginConfigurationBuilder$0(Object obj, Method method, Object[] objArr) throws Throwable {
        return obj;
    }

    BaseCoreConfigurationBuilder(Context context) {
        this.app = context;
    }

    private List<ConfigurationBuilder> configurationBuilders() {
        if (this.configurationBuilders == null) {
            List listLoad = this.pluginLoader.load(ConfigurationBuilderFactory.class);
            this.configurationBuilders = new ArrayList(listLoad.size());
            Iterator it = listLoad.iterator();
            while (it.hasNext()) {
                this.configurationBuilders.add(((ConfigurationBuilderFactory) it.next()).create(this.app));
            }
        }
        return this.configurationBuilders;
    }

    PluginLoader pluginLoader() {
        return this.pluginLoader;
    }

    void preBuild() throws ACRAConfigurationException {
        this.configurations = new ArrayList();
        Iterator<ConfigurationBuilder> it = configurationBuilders().iterator();
        while (it.hasNext()) {
            this.configurations.add(it.next().build());
        }
    }

    Set<ReportField> transformReportContent(ReportField[] reportFieldArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (reportFieldArr.length != 0) {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Using custom Report Fields");
            }
            linkedHashSet.addAll(Arrays.asList(reportFieldArr));
        } else {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "Using default Report Fields");
            }
            linkedHashSet.addAll(Arrays.asList(ACRAConstants.DEFAULT_REPORT_FIELDS));
        }
        for (Map.Entry<ReportField, Boolean> entry : this.reportContentChanges.entrySet()) {
            if (entry.getValue().booleanValue()) {
                linkedHashSet.add(entry.getKey());
            } else {
                linkedHashSet.remove(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    List<Configuration> pluginConfigurations() {
        return this.configurations;
    }

    public <R extends ConfigurationBuilder> R getPluginConfigurationBuilder(Class<R> cls) {
        Iterator<ConfigurationBuilder> it = configurationBuilders().iterator();
        while (it.hasNext()) {
            R r = (R) it.next();
            if (cls.isAssignableFrom(r.getClass())) {
                return r;
            }
        }
        if (cls.isInterface()) {
            ACRA.log.w(ACRA.LOG_TAG, "Couldn't find ConfigurationBuilder " + cls.getSimpleName() + ". ALL CALLS TO IT WILL BE IGNORED!");
            return (R) StubCreator.createStub(cls, new InvocationHandler() { // from class: org.acra.config.-$$Lambda$BaseCoreConfigurationBuilder$hpei-npQAfsFJ4SHi3ZncQup9KY
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    BaseCoreConfigurationBuilder.lambda$getPluginConfigurationBuilder$0(obj, method, objArr);
                    return obj;
                }
            });
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a registered ConfigurationBuilder");
    }
}
