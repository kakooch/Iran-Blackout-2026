package androidx.work;

import android.net.Network;
import ir.nasim.AbstractC22650vb8;
import ir.nasim.InterfaceC14442hv2;
import ir.nasim.InterfaceC15643jv5;
import ir.nasim.InterfaceC5684Kj7;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class WorkerParameters {
    private UUID a;
    private b b;
    private Set c;
    private a d;
    private int e;
    private Executor f;
    private InterfaceC5684Kj7 g;
    private AbstractC22650vb8 h;
    private InterfaceC15643jv5 i;
    private InterfaceC14442hv2 j;

    public static class a {
        public List a = Collections.emptyList();
        public List b = Collections.emptyList();
        public Network c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection collection, a aVar, int i, Executor executor, InterfaceC5684Kj7 interfaceC5684Kj7, AbstractC22650vb8 abstractC22650vb8, InterfaceC15643jv5 interfaceC15643jv5, InterfaceC14442hv2 interfaceC14442hv2) {
        this.a = uuid;
        this.b = bVar;
        this.c = new HashSet(collection);
        this.d = aVar;
        this.e = i;
        this.f = executor;
        this.g = interfaceC5684Kj7;
        this.h = abstractC22650vb8;
        this.i = interfaceC15643jv5;
        this.j = interfaceC14442hv2;
    }

    public Executor a() {
        return this.f;
    }

    public InterfaceC14442hv2 b() {
        return this.j;
    }

    public UUID c() {
        return this.a;
    }

    public b d() {
        return this.b;
    }

    public InterfaceC5684Kj7 e() {
        return this.g;
    }

    public AbstractC22650vb8 f() {
        return this.h;
    }
}
