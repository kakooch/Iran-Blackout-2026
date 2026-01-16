package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.core.network.util.TlsHash;
import ir.nasim.core.network.util.TlsHashItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.vU2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22580vU2 {
    public static final b c = new b(null);
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(a.h);
    private final InterfaceC9173Yu3 a;
    private final InterfaceC9173Yu3 b;

    /* renamed from: ir.nasim.vU2$a */
    /* synthetic */ class a extends C23553x7 implements SA2 {
        public static final a h = new a();

        a() {
            super(0, C22580vU2.class, "<init>", "<init>(Lkotlin/Lazy;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C22580vU2 invoke() {
            return new C22580vU2(null, 1, 0 == true ? 1 : 0);
        }
    }

    /* renamed from: ir.nasim.vU2$b */
    public static final class b {
        private b() {
        }

        public final C22580vU2 a() {
            return (C22580vU2) C22580vU2.d.getValue();
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C22580vU2(InterfaceC9173Yu3 interfaceC9173Yu3) {
        AbstractC13042fc3.i(interfaceC9173Yu3, "lazyPreferences");
        this.a = interfaceC9173Yu3;
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.uU2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22580vU2.h(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 c() {
        return C7183Qq.q(EnumC18608ow5.m);
    }

    private final Map f() {
        return (Map) this.b.getValue();
    }

    public static final C22580vU2 g() {
        return c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap h(C22580vU2 c22580vU2) {
        Map mapB;
        AbstractC13042fc3.i(c22580vU2, "this$0");
        Map mapI = c22580vU2.i("[\n  {\n    \"host\": \"hash.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"ghapoo.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"api.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"tooshle.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"rpc-ssl.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"web.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"ep.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"rpc-ssl-c002.bale.ai\",\n    \"known_ip\": \"2.189.68.117\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"rpc-ssl-c001.bale.ai\",\n    \"known_ip\": \"2.189.68.117\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"assets.bale.ai\",\n    \"known_ip\": \"2.189.68.126\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"siloo.bale.ai\",\n    \"known_ip\": \"2.189.68.109\",\n    \"hashes\": [\n      \"6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444\",\n      \"edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3\",\n      \"d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b\"\n    ]\n  },\n  {\n    \"host\": \"nasim-bam.sadad.co.ir\",\n    \"known_ip\": \"89.235.65.214\",\n    \"hashes\": [\n      \"321bd197b2f2e5a2af181f79330a9a87503709ab0af92840b68d54ecf05483fb\",\n      \"45a4df7fe330c05067d62586f8ccf3568cf60acffa8864dc0a80d526c35b5d56\",\n      \"067aaba02062076a35a6c5e30ea90ee0d2787c4f851c2346454f2134b0fb4a65\",\n      \"144c6338137be526264e3c53a1bb8ef895ceb3789aad426a624137f33f0d8fe1\"\n    ]\n  },\n  {\n    \"host\": \"arbaeen.ble.ir\",\n    \"known_ip\": \"2.189.68.122\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\",\n      \"af41cb4e1a9b9df71a5a8de93d39714fb86386cde3642fc4e66608b3d9d20ee5\"\n    ]\n  },\n  {\n    \"host\": \"sadad.shaparak.ir\",\n    \"known_ip\": \"185.203.160.31\",\n    \"hashes\": [\n      \"2ab0fc96c67bf649b24a541f0dde1c4c37677feec5506f4b4021ba1d52593997\"\n    ]\n  },\n  {\n    \"host\": \"rpc-ssl-c002.ble.ir\",\n    \"known_ip\": \"2.189.68.117\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.94\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.94\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.94\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.94\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download2-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.98\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download2-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.98\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video2-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.98\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video2-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.98\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download3-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.99\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"download3-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.99\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video3-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.99\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  },\n  {\n    \"host\": \"video3-hot-siloo.ble.ir\",\n    \"known_ip\": \"2.189.68.99\", \n    \"hashes\": [\n      \"5a014dd8d328331c06380bd5d2c1ac6d693f8dae7d8a96ecdfc2cf600276bcae\",\n      \"7e0dbcbe4b961cdab76c0fe05ea3f245bd8e4b5e1f041dac757c02f853040ed7\"\n    ]       \n  }\n]");
        String strE = ((InterfaceC3570Bk5) c22580vU2.a.getValue()).e("hashes");
        if (strE != null) {
            try {
                C9475a16.a aVar = C9475a16.b;
                mapB = C9475a16.b(c22580vU2.i(strE));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                mapB = C9475a16.b(AbstractC10685c16.a(th));
            }
            Throwable thE = C9475a16.e(mapB);
            if (thE != null) {
                C19406qI3.c("TlsHashStorage", "Failed to load hashes from persisted json", thE);
            }
            mapK = C9475a16.g(mapB) ? null : mapB;
        }
        if (mapK == null) {
            mapK = AbstractC20051rO3.k();
        }
        return new HashMap(AbstractC20051rO3.t(mapI, mapK));
    }

    private final Map i(String str) {
        TlsHash tlsHash = (TlsHash) C19231q00.b.a().k(str, TlsHash.class);
        AbstractC13042fc3.f(tlsHash);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(tlsHash, 10));
        for (TlsHashItem tlsHashItem : tlsHash) {
            arrayList.add(new C20713sU2(tlsHashItem.getHost(), tlsHashItem.getKnownIp(), tlsHashItem.getHashes()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((C20713sU2) obj).b(), obj);
        }
        return linkedHashMap;
    }

    private final Object k() {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            ((InterfaceC3570Bk5) this.a.getValue()).m("hashes", l());
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.c("TlsHashStorage", "Failed to store hash endpoints", thE);
        }
        return objB;
    }

    private final String l() {
        TlsHash tlsHash = new TlsHash();
        for (C20713sU2 c20713sU2 : f().values()) {
            tlsHash.add(new TlsHashItem(c20713sU2.a(), c20713sU2.b(), c20713sU2.c()));
        }
        String strT = C19231q00.b.a().t(tlsHash);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }

    public final synchronized Map e() {
        return AbstractC20051rO3.y(f());
    }

    public final synchronized void j(List list) {
        try {
            AbstractC13042fc3.i(list, "endpoints");
            if (list.isEmpty()) {
                return;
            }
            f().clear();
            Map mapF = f();
            List list2 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list2, 10)), 16));
            for (Object obj : list2) {
                linkedHashMap.put(((C20713sU2) obj).b(), obj);
            }
            mapF.putAll(linkedHashMap);
            k();
            C19406qI3.a("TlsHashStorage", "HashEndpoints updated", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ C22580vU2(InterfaceC9173Yu3 interfaceC9173Yu3, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.tU2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22580vU2.c();
            }
        }) : interfaceC9173Yu3);
    }
}
