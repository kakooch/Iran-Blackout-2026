package org.acra.config;

import org.acra.sender.HttpSender;

/* loaded from: classes.dex */
public interface HttpSenderConfigurationBuilder extends ConfigurationBuilder {
    HttpSenderConfigurationBuilder setEnabled(boolean z);

    HttpSenderConfigurationBuilder setHttpMethod(HttpSender.Method method);

    HttpSenderConfigurationBuilder setUri(String str);
}
