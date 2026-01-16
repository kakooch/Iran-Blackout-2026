package io.livekit.android.room;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11279ck3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC23697xM5;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.UI3;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class h {
    private final URI a;
    private String b;
    private final OkHttpClient c;
    private final AbstractC11279ck3 d;
    private RegionSettings e;
    private long f;
    private int g;
    private Set h;

    public interface a {
        h a(URI uri, String str);
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return h.this.f(this);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return h.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List listB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!h.this.i()) {
                    throw new IllegalStateException("Region availability is only supported for LiveKit Cloud domains");
                }
                if (h.this.e == null || SystemClock.elapsedRealtime() - h.this.f > h.this.g) {
                    h hVar = h.this;
                    this.b = 1;
                    if (hVar.f(this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            RegionSettings regionSettings = h.this.e;
            if (regionSettings == null || (listB = regionSettings.getRegions()) == null) {
                return null;
            }
            h hVar2 = h.this;
            ArrayList arrayList = new ArrayList();
            Iterator it = listB.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                RegionInfo regionInfo = (RegionInfo) next;
                Set set = hVar2.h;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator it2 = set.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (AbstractC13042fc3.d(((RegionInfo) it2.next()).getUrl(), regionInfo.getUrl())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            RegionInfo regionInfo2 = (RegionInfo) AbstractC15401jX0.q0(arrayList);
            h.this.h.add(regionInfo2);
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "next region: " + regionInfo2, new Object[0]);
            }
            return regionInfo2.getUrl();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public h(URI uri, String str, OkHttpClient okHttpClient, AbstractC11279ck3 abstractC11279ck3) {
        AbstractC13042fc3.i(uri, "serverUrl");
        AbstractC13042fc3.i(str, "token");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        this.a = uri;
        this.b = str;
        this.c = okHttpClient;
        this.d = abstractC11279ck3;
        this.g = 30000;
        this.h = new LinkedHashSet();
    }

    public final void e() {
        this.h.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.h.f(ir.nasim.rm1):java.lang.Object");
    }

    public final Object g(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new c(null), interfaceC20295rm1);
    }

    public final URI h() {
        return this.a;
    }

    public final boolean i() {
        return AbstractC23697xM5.b(this.a);
    }

    public final void j(RegionSettings regionSettings) {
        AbstractC13042fc3.i(regionSettings, "regionSettings");
        this.e = regionSettings;
        this.f = SystemClock.elapsedRealtime();
    }

    public final void k(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.b = str;
    }
}
