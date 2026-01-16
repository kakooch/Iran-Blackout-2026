package io.appmetrica.analytics.modulesapi.internal.service;

import android.gov.nist.javax.sip.parser.TokenNames;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", TokenNames.S, "", "getBlocks", "", "", "", "getFeatures", "", "getJsonParser", "Lio/appmetrica/analytics/coreapi/internal/data/JsonParser;", "getProtobufConverter", "Lio/appmetrica/analytics/coreapi/internal/data/Converter;", "", "getRemoteConfigUpdateListener", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigUpdateListener;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteConfigExtensionConfiguration<S> {
    Map<String, Integer> getBlocks();

    List<String> getFeatures();

    JsonParser<S> getJsonParser();

    Converter<S, byte[]> getProtobufConverter();

    RemoteConfigUpdateListener<S> getRemoteConfigUpdateListener();
}
