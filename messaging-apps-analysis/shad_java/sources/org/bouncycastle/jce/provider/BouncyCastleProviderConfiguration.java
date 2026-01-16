package org.bouncycastle.jce.provider;

import java.util.HashMap;
import java.util.HashSet;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;

/* loaded from: classes4.dex */
class BouncyCastleProviderConfiguration {
    static {
        new ProviderConfigurationPermission("BC", "threadLocalEcImplicitlyCa");
        new ProviderConfigurationPermission("BC", "ecImplicitlyCa");
        new ProviderConfigurationPermission("BC", "threadLocalDhDefaultParams");
        new ProviderConfigurationPermission("BC", "DhDefaultParams");
        new ProviderConfigurationPermission("BC", "acceptableEcCurves");
        new ProviderConfigurationPermission("BC", "additionalEcParameters");
    }

    BouncyCastleProviderConfiguration() {
        new ThreadLocal();
        new ThreadLocal();
        new HashSet();
        new HashMap();
    }
}
