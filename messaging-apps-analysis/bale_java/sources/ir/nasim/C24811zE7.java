package ir.nasim;

import ai.bale.proto.ConfigsOuterClass$UpdateHashEndpointChanged;
import ai.bale.proto.ConfigsStruct$HashEndpoint;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24811zE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C24217yE7 a(ConfigsOuterClass$UpdateHashEndpointChanged configsOuterClass$UpdateHashEndpointChanged) {
        AbstractC13042fc3.i(configsOuterClass$UpdateHashEndpointChanged, "input");
        List<ConfigsStruct$HashEndpoint> hashEndpointsList = configsOuterClass$UpdateHashEndpointChanged.getHashEndpointsList();
        AbstractC13042fc3.h(hashEndpointsList, "getHashEndpointsList(...)");
        List<ConfigsStruct$HashEndpoint> list = hashEndpointsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (ConfigsStruct$HashEndpoint configsStruct$HashEndpoint : list) {
            String knownIp = configsStruct$HashEndpoint.getKnownIp();
            String host = configsStruct$HashEndpoint.getHost();
            if (host == null) {
                host = "";
            }
            List<String> tlsPublicKeyHashList = configsStruct$HashEndpoint.getTlsPublicKeyHashList();
            AbstractC13042fc3.h(tlsPublicKeyHashList, "getTlsPublicKeyHashList(...)");
            arrayList.add(new C20713sU2(host, knownIp, AbstractC15401jX0.n0(tlsPublicKeyHashList)));
        }
        return new C24217yE7(arrayList);
    }
}
