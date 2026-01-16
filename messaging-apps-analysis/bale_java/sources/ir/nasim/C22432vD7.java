package ir.nasim;

import ai.bale.proto.ConfigsOuterClass$UpdateEndpointChanged;
import ai.bale.proto.ConfigsStruct$Endpoint;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.vD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22432vD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21842uD7 a(ConfigsOuterClass$UpdateEndpointChanged configsOuterClass$UpdateEndpointChanged) {
        AbstractC13042fc3.i(configsOuterClass$UpdateEndpointChanged, "input");
        List<ConfigsStruct$Endpoint> endpointsList = configsOuterClass$UpdateEndpointChanged.getEndpointsList();
        AbstractC13042fc3.h(endpointsList, "getEndpointsList(...)");
        List<ConfigsStruct$Endpoint> list = endpointsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (ConfigsStruct$Endpoint configsStruct$Endpoint : list) {
            int port = configsStruct$Endpoint.getPort();
            long id = configsStruct$Endpoint.getId();
            String knownIp = configsStruct$Endpoint.getKnownIp();
            String host = configsStruct$Endpoint.getHost();
            if (host == null) {
                host = "";
            }
            String str = host;
            List<String> tlsPublicKeyHashList = configsStruct$Endpoint.getTlsPublicKeyHashList();
            AbstractC13042fc3.h(tlsPublicKeyHashList, "getTlsPublicKeyHashList(...)");
            arrayList.add(new ConnectionEndpoint(str, port, (List<String>) AbstractC15401jX0.n0(tlsPublicKeyHashList), knownIp, configsStruct$Endpoint.getType() == EnumC7293Rc1.EndpointType_TLS ? 1 : 0, id));
        }
        return new C21842uD7(arrayList);
    }
}
