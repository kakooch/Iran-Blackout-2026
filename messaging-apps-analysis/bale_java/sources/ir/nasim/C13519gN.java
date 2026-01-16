package ir.nasim;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.InterfaceC2037k;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.file.entity.FileReference;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.gN, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13519gN {
    private static C11458d25 c;
    private static C19024pf0 d;
    private static final C14970in2 g;
    private static final E84 h;
    private static final C4471Fg6 i;
    public static final int j;
    public static final C13519gN a = new C13519gN();
    private static List b = new ArrayList();
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UM
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13519gN.U();
        }
    });
    private static final InterfaceC9173Yu3 f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XM
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13519gN.B();
        }
    });

    /* renamed from: ir.nasim.gN$b */
    static final class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ InterfaceC20295rm1 c;

        b(String str, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = str;
            this.b = c12889fL5;
            this.c = interfaceC20295rm1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                QN qnD = QN.d(new File(this.a));
                if (qnD == null) {
                    qnD = QN.o(this.a);
                }
                this.b.a = qnD;
            } catch (Exception e) {
                this.b.a = null;
                C19406qI3.a("baleMessages", e.getMessage(), new Object[0]);
            }
            InterfaceC20295rm1 interfaceC20295rm1 = this.c;
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(this.b.a));
        }
    }

    static {
        C5721Ko c5721Ko = C5721Ko.a;
        g = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).B0();
        h = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).O0();
        i = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).O();
        j = 8;
    }

    private C13519gN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        InterfaceC2037k interfaceC2037kV = C23709xO.a.V();
        if (interfaceC2037kV != null) {
            interfaceC2037kV.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4787Go1 B() {
        return InterfaceC4787Go1.INSTANCE.a(C5721Ko.a.d());
    }

    private final List C(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C18823pJ2 c18823pJ2 = (C18823pJ2) it.next();
            long jI = c18823pJ2.i();
            long jU = c18823pJ2.u();
            Long lR = c18823pJ2.r();
            AbstractC13042fc3.h(lR, "getDate(...)");
            long jLongValue = lR.longValue();
            int iS = c18823pJ2.s();
            EnumC23558x74 enumC23558x74 = EnumC23558x74.SENT;
            AbstractC17457n0 abstractC17457n0Q = c18823pJ2.q();
            AbstractC13042fc3.h(abstractC17457n0Q, "getContent(...)");
            arrayList.add(new J44(jI, jU, jLongValue, iS, enumC23558x74, abstractC17457n0Q, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(final VL vl, final String str) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.aN
            @Override // java.lang.Runnable
            public final void run() {
                C13519gN.F(vl, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final VL vl, final String str) {
        AbstractC13042fc3.i(vl, "$audio");
        AbstractC13042fc3.i(str, "$filePath");
        if (!(vl instanceof C8552Wl4)) {
            if (!(vl instanceof QZ7)) {
                throw new NoWhenBranchMatchedException();
            }
            a.X(QZ7.g((QZ7) vl, str, null, 0L, 0, null, 30, null));
            return;
        }
        C8552Wl4 c8552Wl4 = (C8552Wl4) vl;
        final C8552Wl4 c8552Wl4F = c8552Wl4.f((127 & 1) != 0 ? c8552Wl4.e : null, (127 & 2) != 0 ? c8552Wl4.f : null, (127 & 4) != 0 ? c8552Wl4.g : null, (127 & 8) != 0 ? c8552Wl4.h : null, (127 & 16) != 0 ? c8552Wl4.i : 0L, (127 & 32) != 0 ? c8552Wl4.j : null, (127 & 64) != 0 ? c8552Wl4.k : null);
        if (c8552Wl4.i() == null || TextUtils.isEmpty(c8552Wl4.j()) || TextUtils.isEmpty(c8552Wl4.h())) {
            a.K(str, new UA2() { // from class: ir.nasim.eN
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13519gN.G(c8552Wl4F, vl, str, (QN) obj);
                }
            });
        } else {
            c8552Wl4F.e(str);
            a.X(c8552Wl4F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(C8552Wl4 c8552Wl4, VL vl, String str, QN qn) {
        AbstractC13042fc3.i(c8552Wl4, "$copyAudio");
        AbstractC13042fc3.i(vl, "$audio");
        AbstractC13042fc3.i(str, "$filePath");
        if (qn != null) {
            VL vlA = RN.a((C8552Wl4) vl, qn);
            AbstractC13042fc3.g(vlA, "null cannot be cast to non-null type ir.nasim.features.audioplayer.entity.Music");
            c8552Wl4 = (C8552Wl4) vlA;
        }
        c8552Wl4.e(str);
        a.X(c8552Wl4);
        return C19938rB7.a;
    }

    private final MediaMetadataCompat H(VL vl) {
        MediaMetadataCompat.b bVar = new MediaMetadataCompat.b();
        if (vl instanceof C8552Wl4) {
            C8552Wl4 c8552Wl4 = (C8552Wl4) vl;
            MediaMetadataCompat mediaMetadataCompatA = bVar.e("android.media.metadata.MEDIA_ID", T(c8552Wl4.d())).e("android.media.metadata.MEDIA_URI", c8552Wl4.c()).e("android.media.metadata.TITLE", c8552Wl4.j()).e("android.media.metadata.DISPLAY_TITLE", c8552Wl4.j()).e("android.media.metadata.ARTIST", c8552Wl4.h()).b("android.media.metadata.ALBUM_ART", c8552Wl4.i()).e("android.media.metadata.DISPLAY_SUBTITLE", c8552Wl4.h()).e("android.media.metadata.DISPLAY_DESCRIPTION", "").a();
            AbstractC13042fc3.f(mediaMetadataCompatA);
            return mediaMetadataCompatA;
        }
        if (!(vl instanceof QZ7)) {
            throw new NoWhenBranchMatchedException();
        }
        QZ7 qz7 = (QZ7) vl;
        MediaMetadataCompat mediaMetadataCompatA2 = bVar.e("android.media.metadata.MEDIA_ID", T(qz7.d())).e("android.media.metadata.MEDIA_URI", qz7.c()).e("android.media.metadata.TITLE", "Voice").e("android.media.metadata.DISPLAY_TITLE", "Voice").e("android.media.metadata.ARTIST", String.valueOf(qz7.h())).b("android.media.metadata.ALBUM_ART", null).e("android.media.metadata.DISPLAY_SUBTITLE", "").e("android.media.metadata.DISPLAY_DESCRIPTION", "").a();
        AbstractC13042fc3.f(mediaMetadataCompatA2);
        return mediaMetadataCompatA2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(String str, C12889fL5 c12889fL5, UA2 ua2) {
        AbstractC13042fc3.i(str, "$currentAudio");
        AbstractC13042fc3.i(c12889fL5, "$res");
        AbstractC13042fc3.i(ua2, "$callback");
        try {
            QN qnD = QN.d(new File(str));
            if (qnD == null) {
                qnD = QN.o(str);
            }
            c12889fL5.a = qnD;
        } catch (Exception e2) {
            c12889fL5.a = null;
            C19406qI3.a("baleMessages", e2.getMessage(), new Object[0]);
        }
        ua2.invoke(c12889fL5.a);
    }

    private final InterfaceC4787Go1 N() {
        return (InterfaceC4787Go1) f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC24602yt4 Q() {
        return (InterfaceC24602yt4) e.getValue();
    }

    private final boolean S(C11458d25 c11458d25) {
        return (b.isEmpty() ^ true) && !AbstractC13042fc3.d(((VL) b.get(0)).d().e(), c11458d25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC24602yt4 U() {
        return (InterfaceC24602yt4) C92.a(C5721Ko.a.d(), InterfaceC24602yt4.class);
    }

    private final void V(List list, C11458d25 c11458d25) {
        InterfaceC18505om2 interfaceC18505om2Z;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (S(c11458d25)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) it.next();
            if (j44.U() != AbstractC5969Lp4.f() || j44.e0()) {
                AbstractC17457n0 abstractC17457n0F = j44.F();
                if (abstractC17457n0F instanceof TM) {
                    interfaceC18505om2Z = ((TM) abstractC17457n0F).z();
                } else {
                    if (!(abstractC17457n0F instanceof J08)) {
                        C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("unknown file type in source"));
                        return;
                    }
                    interfaceC18505om2Z = ((J08) abstractC17457n0F).z();
                }
                T74 t74 = new T74(c11458d25, j44.i(), j44.h());
                VL vlB = null;
                if (interfaceC18505om2Z instanceof C4512Fl2) {
                    vlB = RN.b(((C4512Fl2) interfaceC18505om2Z).c, abstractC17457n0F instanceof J08, j44, t74, null);
                } else if (interfaceC18505om2Z instanceof C11920dm2) {
                    vlB = RN.b(C18274oO.a.a(), abstractC17457n0F instanceof J08, j44, t74, null);
                }
                if (vlB != null && !b.contains(vlB)) {
                    arrayList.add(vlB);
                    AbstractC13042fc3.f(interfaceC18505om2Z);
                    arrayList2.add(interfaceC18505om2Z);
                }
            }
        }
        b.addAll(arrayList);
        final List listS = s(arrayList);
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.bN
            @Override // java.lang.Runnable
            public final void run() {
                C13519gN.W(listS, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(List list, List list2, List list3) {
        AbstractC13042fc3.i(list, "$mediaItems");
        AbstractC13042fc3.i(list2, "$newAudios");
        AbstractC13042fc3.i(list3, "$sources");
        C23709xO c23709xO = C23709xO.a;
        InterfaceC2037k interfaceC2037kV = c23709xO.V();
        if (interfaceC2037kV != null) {
            interfaceC2037kV.u0(list);
        }
        VL vlM = c23709xO.M();
        VL vlR = AbstractC13042fc3.d(vlM != null ? vlM.c() : null, C18274oO.a.a()) ^ true ? a.R() : null;
        Iterator it = list2.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            VL vl = (VL) it.next();
            InterfaceC18505om2 interfaceC18505om2 = (InterfaceC18505om2) list3.get(i2);
            if (!(interfaceC18505om2 instanceof C4512Fl2) && (interfaceC18505om2 instanceof C11920dm2)) {
                a.t(((C11920dm2) interfaceC18505om2).b(), vl, AbstractC13042fc3.d(vl, vlR));
            }
            i2 = i3;
        }
    }

    private final void X(final VL vl) {
        if (b.contains(vl)) {
            final C9663aL5 c9663aL5 = new C9663aL5();
            Object obj = null;
            if (vl instanceof C8552Wl4) {
                Iterator it = b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (AbstractC13042fc3.d(((VL) next).d(), ((C8552Wl4) vl).d())) {
                        obj = next;
                        break;
                    }
                }
                VL vl2 = (VL) obj;
                if (vl2 != null) {
                    C8552Wl4 c8552Wl4 = (C8552Wl4) vl;
                    if (!AbstractC13042fc3.d(vl2.c(), c8552Wl4.c()) && AbstractC13042fc3.d(vl2.c(), C18274oO.a.a())) {
                        c9663aL5.a = true;
                    }
                    vl2.e(c8552Wl4.c());
                    if (vl2 instanceof C8552Wl4) {
                        C8552Wl4 c8552Wl42 = (C8552Wl4) vl2;
                        c8552Wl42.l(c8552Wl4.i());
                        c8552Wl42.m(c8552Wl4.j());
                        c8552Wl42.k(c8552Wl4.h());
                    }
                }
            } else if (vl instanceof QZ7) {
                Iterator it2 = b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (AbstractC13042fc3.d(((VL) next2).d(), ((QZ7) vl).d())) {
                        obj = next2;
                        break;
                    }
                }
                VL vl3 = (VL) obj;
                if (vl3 != null) {
                    QZ7 qz7 = (QZ7) vl;
                    if (!AbstractC13042fc3.d(vl3.c(), qz7.c()) && AbstractC13042fc3.d(vl3.c(), C18274oO.a.a())) {
                        c9663aL5.a = true;
                    }
                    vl3.e(qz7.c());
                }
            }
            final InterfaceC2037k interfaceC2037kV = C23709xO.a.V();
            if (interfaceC2037kV != null) {
                AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.WM
                    @Override // java.lang.Runnable
                    public final void run() {
                        C13519gN.Y(vl, interfaceC2037kV, c9663aL5);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(VL vl, InterfaceC2037k interfaceC2037k, C9663aL5 c9663aL5) {
        AbstractC13042fc3.i(vl, "$audio");
        AbstractC13042fc3.i(interfaceC2037k, "$player");
        AbstractC13042fc3.i(c9663aL5, "$isAudioPathChanged");
        C13519gN c13519gN = a;
        String strT = c13519gN.T(vl.d());
        int iO = c13519gN.O(strT);
        C2018a0 c2018a0Q = c13519gN.q(vl);
        int i2 = iO + 1;
        int iY = interfaceC2037k.y();
        if (i2 < iY) {
            interfaceC2037k.B0(i2, c2018a0Q);
        } else {
            interfaceC2037k.c0(c2018a0Q);
        }
        if (c9663aL5.a) {
            C2018a0 c2018a0N = interfaceC2037k.n();
            if (AbstractC13042fc3.d(c2018a0N != null ? c2018a0N.a : null, strT)) {
                C23709xO c23709xO = C23709xO.a;
                c23709xO.h0(vl);
                c23709xO.Z(vl, true);
            }
        }
        if (iO < iY) {
            interfaceC2037k.w(iO);
        }
    }

    private final void Z(C11458d25 c11458d25, long j2, boolean z) {
        i.R(c11458d25, j2, z ? EnumC19631qg6.a : EnumC19631qg6.b, z ? EnumC7325Rf6.e : EnumC7325Rf6.d).m0(new InterfaceC24449ye1() { // from class: ir.nasim.fN
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13519gN.a0((C22372v74) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(C22372v74 c22372v74) {
        AbstractC13042fc3.i(c22372v74, "messageSearchResult");
        C19406qI3.a("AudioDataBase", "searchAudios result count: " + c22372v74.a().size(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(FileReference fileReference, VL vl) {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = g.D(fileReference, false, new c(c12889fL5, vl), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        C10249bK6.b(Q().t(), fileReference, null, false, 6, null);
    }

    private final C2018a0 q(VL vl) {
        String strT = T(vl.d());
        boolean z = vl instanceof QZ7;
        C2018a0.c cVarI = new C2018a0.c().e(strT).k(vl.c()).i(Boolean.valueOf(z));
        AbstractC13042fc3.h(cVarI, "setTag(...)");
        if (z) {
            QZ7 qz7 = (QZ7) vl;
            if (AbstractC20153rZ6.B(qz7.c(), ".mp4", true)) {
                Bundle bundle = new Bundle();
                bundle.putLong("durationInMillis", qz7.b());
                cVarI.b("fragmented_mp4_" + strT);
                cVarI.f(new C2020b0.b().X(bundle).H());
            }
        }
        C2018a0 c2018a0A = cVarI.a();
        AbstractC13042fc3.h(c2018a0A, "build(...)");
        return c2018a0A;
    }

    private final List s(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(q((VL) it.next()));
        }
        return AbstractC15401jX0.m1(linkedHashSet);
    }

    private final void t(FileReference fileReference, VL vl, boolean z) {
        AbstractC10533bm0.d(N().y0(), null, null, new a(fileReference, z, vl, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object v(C11458d25 c11458d25, List list, Object obj) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(list, "items");
        List listY0 = obj instanceof List ? AbstractC15401jX0.Y0(list, AbstractC23053wG5.y(list.size() - ((List) obj).size(), list.size())) : list;
        C13519gN c13519gN = a;
        c13519gN.V(c13519gN.C(listY0), c11458d25);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(C19024pf0 c19024pf0, C11458d25 c11458d25, long j2, VL vl, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c19024pf0, "$displayList");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(vl, "$audio");
        if (c19024pf0.r() <= 0) {
            a.Z(c11458d25, j2, vl instanceof QZ7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(C11458d25 c11458d25, List list) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        List list2 = b;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((VL) it.next()) instanceof C8552Wl4) {
                    C19406qI3.a("AudioDataBase", "Return from getVoiceMessages then because it contains music!", new Object[0]);
                    return;
                }
            }
        }
        C13519gN c13519gN = a;
        AbstractC13042fc3.f(list);
        c13519gN.V(list, c11458d25);
    }

    public final void D(VL vl) {
        C24967zW1 c24967zW1H;
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        J44 j44A = vl.a();
        if (j44A == null || (c24967zW1H = j44A.H()) == null || !(c24967zW1H.z() instanceof C11920dm2)) {
            return;
        }
        InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        a.t(((C11920dm2) interfaceC18505om2Z).b(), vl, true);
    }

    public final VL I(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null) {
            return null;
        }
        for (VL vl : b) {
            if (AbstractC13042fc3.d(T(vl.d()), mediaMetadataCompat.h("android.media.metadata.MEDIA_ID"))) {
                return vl;
            }
        }
        return null;
    }

    public final Object J(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        C12889fL5 c12889fL5 = new C12889fL5();
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        AbstractC20507s76.k(new b(str, c12889fL5, c16963m96));
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    public final void K(final String str, final UA2 ua2) {
        AbstractC13042fc3.i(str, "currentAudio");
        AbstractC13042fc3.i(ua2, "callback");
        final C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.VM
            @Override // java.lang.Runnable
            public final void run() {
                C13519gN.L(str, c12889fL5, ua2);
            }
        });
    }

    public final List M() {
        return b;
    }

    public final int O(String str) {
        AbstractC13042fc3.i(str, "mediaId");
        Iterator it = b.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            int i3 = i2 + 1;
            if (AbstractC13042fc3.d(T(((VL) it.next()).d()), str)) {
                break;
            }
            i2 = i3;
        }
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public final MediaMetadataCompat P(int i2) {
        if (i2 < b.size()) {
            return H((VL) b.get(i2));
        }
        VL vl = (VL) AbstractC15401jX0.t0(b, 0);
        if (vl != null) {
            return H(vl);
        }
        return null;
    }

    public final VL R() {
        InterfaceC2037k interfaceC2037kV = C23709xO.a.V();
        Integer numValueOf = interfaceC2037kV != null ? Integer.valueOf(interfaceC2037kV.s0()) : null;
        if (numValueOf == null || numValueOf.intValue() == -1 || numValueOf.intValue() >= b.size()) {
            return null;
        }
        return (VL) b.get(numValueOf.intValue());
    }

    public final String T(T74 t74) {
        AbstractC13042fc3.i(t74, "messageUniqueId");
        return t74.e().u() + "_" + t74.f() + "_" + t74.d();
    }

    public final boolean b0(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        return !b.contains(vl) || S(vl.d().e());
    }

    public final boolean c0(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if (b.isEmpty()) {
            return false;
        }
        return b0(vl);
    }

    public final void e0(VL vl) {
        C24967zW1 c24967zW1H;
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        J44 j44A = vl.a();
        if (j44A == null || (c24967zW1H = j44A.H()) == null || !(c24967zW1H.z() instanceof C11920dm2)) {
            return;
        }
        InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        AbstractC10533bm0.d(a.N().y0(), null, null, new d(((C11920dm2) interfaceC18505om2Z).b(), null), 3, null);
    }

    public final void f0() {
        C19024pf0 c19024pf0 = d;
        if (c19024pf0 != null) {
            c19024pf0.v(null);
        }
        d = null;
        c = null;
    }

    public final void p(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if (b.contains(vl)) {
            return;
        }
        b.add(vl);
    }

    public final List r() {
        return s(b);
    }

    public final void u(final VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        final C11458d25 c11458d25E = vl.d().e();
        if (AbstractC13042fc3.d(c11458d25E, c)) {
            return;
        }
        f0();
        final long jD = vl.d().d();
        final C19024pf0 c19024pf0Z1 = AbstractC5969Lp4.d().Z1(c11458d25E);
        AbstractC13042fc3.h(c19024pf0Z1, "buildPeerAudiosSearchList(...)");
        c19024pf0Z1.v(new VB3() { // from class: ir.nasim.cN
            @Override // ir.nasim.VB3
            public final Object a(List list, Object obj) {
                return C13519gN.v(c11458d25E, list, obj);
            }
        });
        c19024pf0Z1.Z(jD).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dN
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13519gN.w(c19024pf0Z1, c11458d25E, jD, vl, (C14505i18) obj);
            }
        });
        d = c19024pf0Z1;
        c = c11458d25E;
    }

    public final void x(QZ7 qz7) {
        AbstractC13042fc3.i(qz7, "voice");
        final C11458d25 c11458d25E = qz7.d().e();
        h.V0(c11458d25E, qz7.d().d(), 50).m0(new InterfaceC24449ye1() { // from class: ir.nasim.YM
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13519gN.y(c11458d25E, (List) obj);
            }
        });
    }

    public final void z(boolean z) {
        try {
            f0();
            b.clear();
            if (z) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ir.nasim.ZM
                    @Override // java.lang.Runnable
                    public final void run() {
                        C13519gN.A();
                    }
                });
            } else {
                InterfaceC2037k interfaceC2037kV = C23709xO.a.V();
                if (interfaceC2037kV != null) {
                    interfaceC2037kV.m();
                }
            }
        } catch (Exception e2) {
            C19406qI3.j("AudioDataBase", "Error in clear audio database: " + e2.getMessage(), new Object[0]);
        }
    }

    /* renamed from: ir.nasim.gN$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = C13519gN.a.Q().C0();
                long fileId = this.c.getFileId();
                long accessHash = this.c.getAccessHash();
                a aVar = new a(this.c);
                this.b = 1;
                if (qf2C0.m(fileId, accessHash, aVar, (8 & 8) != 0 ? false : false, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.gN$d$a */
        public static final class a implements InterfaceC8807Xk2 {
            final /* synthetic */ FileReference a;

            a(FileReference fileReference) {
                this.a = fileReference;
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void c(float f) {
                C13519gN.a.Q().J0().c(this.a);
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void e() {
            }
        }
    }

    /* renamed from: ir.nasim.gN$c */
    public static final class c implements InterfaceC8091Um2 {
        final /* synthetic */ C12889fL5 a;
        final /* synthetic */ VL b;

        c(C12889fL5 c12889fL5, VL vl) {
            this.a = c12889fL5;
            this.b = vl;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            InterfaceC7857Tm2 interfaceC7857Tm2 = (InterfaceC7857Tm2) this.a.a;
            if (interfaceC7857Tm2 != null) {
                interfaceC7857Tm2.b();
            }
            C13519gN.a.E(this.b, interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }

    /* renamed from: ir.nasim.gN$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference c;
        final /* synthetic */ boolean d;
        final /* synthetic */ VL e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FileReference fileReference, boolean z, VL vl, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = fileReference;
            this.d = z;
            this.e = vl;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QF2 qf2C0 = C13519gN.a.Q().C0();
                long fileId = this.c.getFileId();
                long accessHash = this.c.getAccessHash();
                C1251a c1251a = new C1251a(this.d, this.c, this.e);
                this.b = 1;
                if (qf2C0.m(fileId, accessHash, c1251a, (8 & 8) != 0 ? false : false, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.gN$a$a, reason: collision with other inner class name */
        public static final class C1251a implements InterfaceC8807Xk2 {
            final /* synthetic */ boolean a;
            final /* synthetic */ FileReference b;
            final /* synthetic */ VL c;

            C1251a(boolean z, FileReference fileReference, VL vl) {
                this.a = z;
                this.b = fileReference;
                this.c = vl;
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                C13519gN.a.E(this.c, interfaceC3346Am2.getDescriptor());
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void e() {
                if (this.a) {
                    C13519gN.a.d0(this.b, this.c);
                }
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void c(float f) {
            }
        }
    }
}
