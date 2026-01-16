package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10613bu0;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.MW1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class H74 implements InterfaceC14123hO3 {
    private final Context a;
    private final Context b;
    private final SettingsModule c;
    private final C11458d25 d;
    private final int e;
    private final UA2 f;
    private final InterfaceC14603iB2 g;
    private final InterfaceC9173Yu3 h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5091Hw.values().length];
            try {
                iArr[EnumC5091Hw.MISSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5091Hw.HANGUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5091Hw.BUSY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5091Hw.DISCONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public H74(Context context, Context context2, SettingsModule settingsModule, C11458d25 c11458d25, int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(context, "incomingContext");
        AbstractC13042fc3.i(context2, "outgoingContext");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(ua2, "userProvider");
        AbstractC13042fc3.i(interfaceC14603iB2, "crowdfundingInfoProvider");
        this.a = context;
        this.b = context2;
        this.c = settingsModule;
        this.d = c11458d25;
        this.e = i;
        this.f = ua2;
        this.g = interfaceC14603iB2;
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.G74
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return H74.Q(this.a);
            }
        });
    }

    private final AbstractC17757nW1 A(Context context, C24967zW1 c24967zW1, J44 j44) {
        byte[] bArrC;
        MW1 mw1B = B(c24967zW1, j44);
        if (c24967zW1 instanceof C13388g85) {
            return J(mw1B, (C13388g85) c24967zW1);
        }
        if (c24967zW1 instanceof XG2) {
            XG2 xg2 = (XG2) c24967zW1;
            XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(xg2.G()), Integer.valueOf(xg2.F()));
            C22694vg2 c22694vg2V = xg2.v();
            bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
            String strX = xg2.x();
            AbstractC13042fc3.h(strX, "getMimeType(...)");
            return new AbstractC17757nW1.c.a(mw1B, xv4A, bArrC, strX);
        }
        if (c24967zW1 instanceof GS7) {
            GS7 gs7 = (GS7) c24967zW1;
            if (!gs7.J() || C8386Vt0.F5()) {
                XV4 xv4A2 = AbstractC4616Fw7.a(Integer.valueOf(gs7.I()), Integer.valueOf(gs7.H()));
                C22694vg2 c22694vg2V2 = gs7.v();
                bArrC = c22694vg2V2 != null ? c22694vg2V2.c() : null;
                String strX2 = gs7.x();
                AbstractC13042fc3.h(strX2, "getMimeType(...)");
                return new AbstractC17757nW1.c.d(mw1B, xv4A2, bArrC, strX2, gs7.G());
            }
            AbstractC13042fc3.g(mw1B, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.state.DocumentState.Local");
            MW1.a aVar = (MW1.a) mw1B;
            XV4 xv4A3 = AbstractC4616Fw7.a(Integer.valueOf(gs7.I()), Integer.valueOf(gs7.H()));
            C22694vg2 c22694vg2V3 = gs7.v();
            bArrC = c22694vg2V3 != null ? c22694vg2V3.c() : null;
            String strX3 = gs7.x();
            AbstractC13042fc3.h(strX3, "getMimeType(...)");
            return new AbstractC17757nW1.c.d.b(aVar, xv4A3, bArrC, strX3, gs7.G(), o(context));
        }
        boolean z = c24967zW1 instanceof J08;
        if (z || (c24967zW1 instanceof TM)) {
            return D(j44, mw1B, z);
        }
        String strU = c24967zW1.u();
        String strY = c24967zW1.y();
        AbstractC13042fc3.h(strY, "getName(...)");
        SpannableString spannableStringI = AbstractC17636nI6.i(AbstractC20762sZ6.E0(strY, Separators.DOT + strU));
        AbstractC13042fc3.f(strU);
        Locale locale = Locale.ROOT;
        String upperCase = strU.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        SpannableString spannableStringI2 = AbstractC17636nI6.i(upperCase);
        String lowerCase = strU.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC17757nW1.d.i.a().contains(lowerCase)) {
            return new AbstractC17757nW1.b(mw1B, spannableStringI, spannableStringI2);
        }
        C22694vg2 c22694vg2V4 = c24967zW1.v();
        return new AbstractC17757nW1.d(mw1B, spannableStringI, spannableStringI2, c22694vg2V4 != null ? c22694vg2V4.c() : null);
    }

    private final MW1 B(C24967zW1 c24967zW1, J44 j44) {
        InterfaceC18505om2 interfaceC18505om2Z = c24967zW1.z();
        if (interfaceC18505om2Z instanceof C11920dm2) {
            return new MW1.b((C11920dm2) interfaceC18505om2Z);
        }
        if (interfaceC18505om2Z instanceof C4512Fl2) {
            return new MW1.a(j44.i(), j44.L() != EnumC23558x74.ERROR, (C4512Fl2) interfaceC18505om2Z);
        }
        throw new IllegalStateException();
    }

    private final AbstractC17757nW1 C(C16799lt c16799lt) {
        FileReference fileReferenceB;
        A23 a23U = c16799lt.u();
        if (a23U == null || (fileReferenceB = a23U.b()) == null) {
            return null;
        }
        return new AbstractC17757nW1.c.AbstractC1416c.a(new MW1.b(new C11920dm2(fileReferenceB)), AbstractC4616Fw7.a(Integer.valueOf(a23U.c()), Integer.valueOf(a23U.a())), c16799lt.t(), c16799lt.s());
    }

    private final AbstractC17757nW1.a D(J44 j44, MW1 mw1, boolean z) {
        SpannableString spannableStringI;
        String strH;
        String strJ;
        T74 t74 = new T74(this.d, j44.i(), j44.h());
        VL vlB = RN.b(C18274oO.a.a(), z, j44, t74, null);
        C8552Wl4 c8552Wl4 = vlB instanceof C8552Wl4 ? (C8552Wl4) vlB : null;
        SpannableString spannableStringI2 = (c8552Wl4 == null || (strJ = c8552Wl4.j()) == null) ? null : AbstractC17636nI6.i(strJ);
        if (c8552Wl4 == null || (strH = c8552Wl4.h()) == null) {
            spannableStringI = null;
        } else {
            if (AbstractC20762sZ6.n0(strH)) {
                strH = "Unknown artist";
            }
            spannableStringI = AbstractC17636nI6.i(strH);
        }
        boolean z2 = !z;
        C24967zW1 c24967zW1H = j44.H();
        TM tm = c24967zW1H instanceof TM ? (TM) c24967zW1H : null;
        return new AbstractC17757nW1.a(mw1, t74, spannableStringI2, spannableStringI, z2, vlB, tm != null ? tm.J() : false);
    }

    private final AbstractC10613bu0 E(Context context, C5980Lq6 c5980Lq6, boolean z) {
        Spannable spannableN = n(context, z, c5980Lq6);
        Spannable spannableM = m(context, c5980Lq6.u());
        return c5980Lq6 instanceof C20360rs6 ? new AbstractC10613bu0.a(spannableN, spannableM) : new AbstractC10613bu0.b(spannableN, spannableM);
    }

    private final C12461ef1 F(C6833Pe1 c6833Pe1) {
        String strV = c6833Pe1.v();
        AbstractC13042fc3.h(strV, "getName(...)");
        SpannableString spannableStringI = AbstractC17636nI6.i(strV);
        Spannable spannableJ = j(c6833Pe1);
        ArrayList arrayListW = c6833Pe1.w();
        AbstractC13042fc3.h(arrayListW, "getPhones(...)");
        List listI = i(arrayListW);
        ArrayList arrayListT = c6833Pe1.t();
        AbstractC13042fc3.h(arrayListT, "getEmails(...)");
        return new C12461ef1(spannableStringI, spannableJ, listI, arrayListT, null, c6833Pe1.y(), this.e == c6833Pe1.y(), c6833Pe1.u(), c6833Pe1.s());
    }

    private final Object G(Context context, ir.nasim.core.modules.messaging.entity.content.a aVar, J44 j44) {
        CrowdfundingContentInfo crowdfundingContentInfoC;
        C8540Wk1 c8540Wk1U = aVar.u();
        if (c8540Wk1U != null) {
            AbstractC19230q0 abstractC19230q0C = c8540Wk1U.c();
            AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalCrowdfundingContent");
            crowdfundingContentInfoC = ((MG3) abstractC19230q0C).C();
        } else {
            CrowdfundingContentInfo crowdfundingContentInfoT = aVar.t();
            crowdfundingContentInfoC = (CrowdfundingContentInfo) this.g.invoke(j44, crowdfundingContentInfoT.b((14207 & 1) != 0 ? crowdfundingContentInfoT.isRemote : false, (14207 & 2) != 0 ? crowdfundingContentInfoT.title : null, (14207 & 4) != 0 ? crowdfundingContentInfoT.description : null, (14207 & 8) != 0 ? crowdfundingContentInfoT.startTime : 0L, (14207 & 16) != 0 ? crowdfundingContentInfoT.endTime : 0L, (14207 & 32) != 0 ? crowdfundingContentInfoT.amount : 0L, (14207 & 64) != 0 ? crowdfundingContentInfoT.quotaAmount : 0L, (14207 & 128) != 0 ? crowdfundingContentInfoT.payCount : 0, (14207 & 256) != 0 ? crowdfundingContentInfoT.cardNumber : null, (14207 & 512) != 0 ? crowdfundingContentInfoT.msg : null, (14207 & 1024) != 0 ? crowdfundingContentInfoT.status : null, (14207 & 2048) != 0 ? crowdfundingContentInfoT.senderId : j44.U(), (14207 & 4096) != 0 ? crowdfundingContentInfoT.photoContent : null, (14207 & 8192) != 0 ? crowdfundingContentInfoT.isForwarded : false));
        }
        CrowdfundingContentInfo crowdfundingContentInfo = crowdfundingContentInfoC;
        aVar.t().w(j44.toByteArray());
        int iB = OY0.b(context, AbstractC21139tA5.colorSecondary);
        int iB2 = OY0.b(context, AbstractC21139tA5.n500);
        SpannableStringBuilder spannableStringBuilderV = v(crowdfundingContentInfo);
        Spannable spannableL = l(crowdfundingContentInfo, context, iB, iB2);
        Spannable spannableT = t(crowdfundingContentInfo, context, iB, iB2);
        Spannable spannableR = r(crowdfundingContentInfo, context, iB, iB2);
        int iS = s(crowdfundingContentInfo);
        boolean zY = y(crowdfundingContentInfo);
        AbstractC17457n0 abstractC17457n0N = AbstractC17457n0.n(crowdfundingContentInfo.getPhotoContent());
        AbstractC13042fc3.h(abstractC17457n0N, "parse(...)");
        return new C6244Mu1(spannableStringBuilderV, spannableL, spannableT, spannableR, iS, zY, crowdfundingContentInfo, I(context, abstractC17457n0N, j44, KB5.message_holder_crowd_funding_place_holder));
    }

    private final C19405qI2 H(Context context, J44 j44, boolean z) {
        return new C19405qI2(h(context, (CI7) this.f.invoke(Integer.valueOf(j44.U()))), z);
    }

    private final AbstractC17757nW1.c.b I(Context context, AbstractC17457n0 abstractC17457n0, J44 j44, int i) {
        C24967zW1 c24967zW1F = abstractC17457n0.f();
        if (c24967zW1F == null) {
            return g(context, i);
        }
        return c24967zW1F instanceof C13388g85 ? J(B(c24967zW1F, j44), (C13388g85) c24967zW1F) : g(context, i);
    }

    private final AbstractC17757nW1.c.b J(MW1 mw1, C13388g85 c13388g85) {
        XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(c13388g85.E()), Integer.valueOf(c13388g85.D()));
        C22694vg2 c22694vg2V = c13388g85.v();
        byte[] bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
        String strX = c13388g85.x();
        AbstractC13042fc3.h(strX, "getMimeType(...)");
        return new AbstractC17757nW1.c.b(mw1, xv4A, bArrC, strX, null, 16, null);
    }

    private final C19943rC3 K(Context context, AbstractC17457n0 abstractC17457n0, J44 j44) {
        AbstractC13042fc3.g(abstractC17457n0, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.LiveContent");
        LC3 lc3 = (LC3) abstractC17457n0;
        C13388g85 c13388g85U = lc3.u();
        AbstractC13042fc3.f(c13388g85U);
        C24967zW1 c24967zW1F = c13388g85U.f();
        AbstractC13042fc3.f(c24967zW1F);
        MW1 mw1B = B(c24967zW1F, j44);
        Spannable spannableW = w(context, lc3.v());
        Spannable spannableQ = q(context, lc3.w());
        long jT = lc3.t();
        XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(c13388g85U.E()), Integer.valueOf(c13388g85U.D()));
        C22694vg2 c22694vg2V = c13388g85U.v();
        byte[] bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
        String strX = c13388g85U.x();
        AbstractC13042fc3.h(strX, "getMimeType(...)");
        return new C19943rC3(spannableW, spannableQ, jT, new AbstractC17757nW1.c.b(mw1B, xv4A, bArrC, strX, EnumC18310oS.d));
    }

    private final RH3 L(long j, C10844cI3 c10844cI3) {
        String strM = AbstractC20153rZ6.M(AbstractC20153rZ6.M(this.c.V2(), "{0}", String.valueOf(c10844cI3.s()), false, 4, null), "{1}", String.valueOf(c10844cI3.t()), false, 4, null);
        return new RH3(c10844cI3.s(), c10844cI3.t(), strM, j + "_map");
    }

    private final Object M(Context context, C18626oy5 c18626oy5, J44 j44) {
        SpannableString spannableStringI;
        AbstractC17757nW1.c.b bVarI = I(context, c18626oy5.t(), j44, KB5.message_holder_money_request_place_holder);
        AbstractC13130fi4 abstractC13130fi4U = c18626oy5.u();
        if (abstractC13130fi4U instanceof C17944np2) {
            String strC = XY6.c(XY6.v(String.valueOf(((C17944np2) abstractC13130fi4U).c())), (char) 0, 2, null);
            spannableStringI = AbstractC17636nI6.i(((Object) strC) + u());
        } else {
            String string = context.getString(AbstractC12217eE5.money_request_desired_amount);
            AbstractC13042fc3.h(string, "getString(...)");
            spannableStringI = AbstractC17636nI6.i(string);
        }
        SpannableString spannableString = spannableStringI;
        AbstractC4970Hi4 abstractC4970Hi4V = c18626oy5.v();
        String strX = c18626oy5.x();
        HashMap mapS = c18626oy5.s();
        return new C12494ei4(abstractC4970Hi4V, spannableString, strX, mapS != null ? mapS.containsKey("CHARGE_TYPE") : false, this.d, bVarI);
    }

    private final C13121fh5 N(C19049ph5 c19049ph5) {
        List listM;
        List listU;
        C20610sI7 c20610sI7;
        long jU = c19049ph5.u();
        String strV = c19049ph5.v();
        List listT = c19049ph5.t();
        boolean zY = c19049ph5.y();
        EnumC9058Yh5 enumC9058Yh5A = AbstractC9292Zh5.a(c19049ph5.w());
        C16885m18 c16885m18X = c19049ph5.x();
        C16885m18 c16885m18X2 = c19049ph5.x();
        if (c16885m18X2 == null || (listU = c16885m18X2.u()) == null) {
            listM = AbstractC10360bX0.m();
        } else {
            List list = listU;
            listM = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iLongValue = (int) ((Number) it.next()).longValue();
                CI7 ci7 = (CI7) this.f.invoke(Integer.valueOf(iLongValue));
                if (ci7 == null || (c20610sI7 = AbstractC13591gV.a(ci7, this.a)) == null) {
                    c20610sI7 = new C20610sI7(null, null, new WU("", iLongValue, 12.0f, this.a, false, true));
                }
                listM.add(c20610sI7);
            }
        }
        return new C13121fh5(jU, enumC9058Yh5A, zY, listT, strV, c16885m18X, listM);
    }

    private final C10240bJ6 O(C12872fJ6 c12872fJ6) {
        C12056dy fileLocation;
        C4626Fy c4626FyR = c12872fJ6.r();
        AbstractC17757nW1.c.b bVar = null;
        if (c4626FyR != null && (fileLocation = c4626FyR.getFileLocation()) != null && (c4626FyR.getFileSize() != 0 || fileLocation.getFileId() != 0)) {
            bVar = new AbstractC17757nW1.c.b(new MW1.b(new C11920dm2(new FileReference(fileLocation, "SponsoredMessageImage_" + fileLocation.getFileId(), c12872fJ6.s(), c4626FyR.getFileSize()))), new XV4(Integer.valueOf(c4626FyR.r()), Integer.valueOf(c4626FyR.q())), null, "", EnumC18310oS.d);
        }
        return new C10240bJ6(bVar, c12872fJ6.t(), c12872fJ6.w(), c12872fJ6.s(), c12872fJ6.x(), c12872fJ6.y(), c12872fJ6.u(), c12872fJ6.v());
    }

    private final AbstractC17757nW1 P(JM6 jm6) {
        A23 a23V = jm6.v();
        A23 a23U = jm6.u();
        if (a23V != null) {
            FileReference fileReferenceB = a23V.b();
            if (fileReferenceB == null) {
                fileReferenceB = f();
            }
            return new AbstractC17757nW1.c.AbstractC1416c.b(new MW1.b(new C11920dm2(fileReferenceB)), AbstractC4616Fw7.a(512, 512), jm6.t(), jm6.s());
        }
        if (a23U == null) {
            return new AbstractC17757nW1.c.AbstractC1416c.b(new MW1.b(new C11920dm2(f())), AbstractC4616Fw7.a(256, 256), null, null);
        }
        FileReference fileReferenceB2 = a23U.b();
        if (fileReferenceB2 == null) {
            fileReferenceB2 = f();
        }
        return new AbstractC17757nW1.c.AbstractC1416c.b(new MW1.b(new C11920dm2(fileReferenceB2)), AbstractC4616Fw7.a(256, 256), jm6.t(), jm6.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q(H74 h74) {
        AbstractC13042fc3.i(h74, "this$0");
        return Separators.SP + h74.a.getString(AbstractC12217eE5.rial);
    }

    private final String c(long j) {
        return XY6.v(GY6.g(String.valueOf(j))) + u();
    }

    private final void d(Spannable spannable, Typeface typeface, int i, int i2) {
        spannable.setSpan(new T10(typeface), i, i2, 33);
    }

    private final Spannable e(C20610sI7 c20610sI7) {
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(new C12973fV(c20610sI7, 0, 2, null), 0, spannableString.length(), 33);
        return spannableString;
    }

    private final FileReference f() {
        return new FileReference(0L, 0L, "", null, 0);
    }

    private final AbstractC17757nW1.c.b.C1415b g(Context context, int i) {
        Drawable drawableD = AbstractC6713Oq7.d(context, i, OY0.b(context, AbstractC21139tA5.bubble_secondary));
        AbstractC13042fc3.f(drawableD);
        return new AbstractC17757nW1.c.b.C1415b(drawableD, OY0.b(context, AbstractC21139tA5.bubble_third), new MW1.b(new C11920dm2(new FileReference(new C12056dy(), "", "", 0))), AbstractC4616Fw7.a(293, 160));
    }

    private final Spannable h(Context context, CI7 ci7) {
        if (ci7 == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) e(AbstractC13591gV.a(ci7, context)));
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.gift_packet_from));
        spannableStringBuilder.append((CharSequence) Separators.SP);
        spannableStringBuilder.append((CharSequence) ci7.b());
        return spannableStringBuilder;
    }

    private final List i(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC20153rZ6.M((String) it.next(), Separators.SP, "", false, 4, null));
        }
        return AbstractC15401jX0.j0(arrayList);
    }

    private final Spannable j(C6833Pe1 c6833Pe1) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<String> arrayListW = c6833Pe1.w();
        AbstractC13042fc3.h(arrayListW, "getPhones(...)");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(arrayListW, 10));
        for (String str : arrayListW) {
            AbstractC13042fc3.f(str);
            arrayList.add(AbstractC20153rZ6.M(str, Separators.SP, "", false, 4, null));
        }
        Iterator it = AbstractC15401jX0.j0(arrayList).iterator();
        while (it.hasNext()) {
            spannableStringBuilder.append((CharSequence) it.next());
            AbstractC13042fc3.h(spannableStringBuilder.append('\n'), "append(...)");
        }
        Iterator it2 = c6833Pe1.t().iterator();
        AbstractC13042fc3.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            spannableStringBuilder.append((CharSequence) it2.next());
            AbstractC13042fc3.h(spannableStringBuilder.append('\n'), "append(...)");
        }
        String string = spannableStringBuilder.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return AbstractC17636nI6.i(AbstractC20762sZ6.p1(string).toString());
    }

    private final String k(Context context, int i) {
        String string;
        if (i < 60) {
            string = context.getString(AbstractC12217eE5.time_duration_seconds, String.valueOf(i));
        } else if (i < 3600) {
            string = context.getString(AbstractC12217eE5.time_duration_minutes, String.valueOf(i / 60));
        } else {
            int i2 = i / 3600;
            int i3 = (i % 3600) / 60;
            string = i3 > 0 ? context.getString(AbstractC12217eE5.time_duration_hours_minutes, String.valueOf(i2), String.valueOf(i3)) : context.getString(AbstractC12217eE5.time_duration_hours, String.valueOf(i2));
        }
        AbstractC13042fc3.f(string);
        return XY6.v(string);
    }

    private final Spannable l(CrowdfundingContentInfo crowdfundingContentInfo, Context context, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String strC = c(crowdfundingContentInfo.k());
        spannableStringBuilder.append((CharSequence) strC);
        d(spannableStringBuilder, C6011Lu2.i(), spannableStringBuilder.length() - strC.length(), spannableStringBuilder.length());
        AbstractC17636nI6.e(spannableStringBuilder, i, spannableStringBuilder.length() - strC.length(), spannableStringBuilder.length());
        spannableStringBuilder.append((CharSequence) Separators.RETURN);
        String str = context.getString(AbstractC12217eE5.crowd_funding_out_of) + "  ";
        spannableStringBuilder.append((CharSequence) str);
        d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length());
        AbstractC17636nI6.e(spannableStringBuilder, i2, spannableStringBuilder.length() - str.length(), spannableStringBuilder.length());
        String strC2 = c(crowdfundingContentInfo.getAmount());
        spannableStringBuilder.append((CharSequence) strC2);
        d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - strC2.length(), spannableStringBuilder.length());
        AbstractC17636nI6.e(spannableStringBuilder, i2, spannableStringBuilder.length() - strC2.length(), spannableStringBuilder.length());
        return spannableStringBuilder;
    }

    private final Spannable m(Context context, int i) {
        if (i > 0) {
            return AbstractC17636nI6.i(k(context, i / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        }
        return null;
    }

    private final Spannable n(Context context, boolean z, C5980Lq6 c5980Lq6) {
        C12109e33 c12109e33;
        boolean z2 = c5980Lq6 instanceof C20360rs6;
        Drawable drawableD = AbstractC6713Oq7.d(context, z2 ? KB5.video_call_new_icon : KB5.voice_call_new_icon, (c5980Lq6.t() != EnumC5091Hw.HANGUP || c5980Lq6.u() <= 0) ? OY0.b(context, AbstractC21139tA5.colorError) : OY0.b(context, AbstractC21139tA5.colorSuccess));
        if (drawableD != null) {
            drawableD.setBounds(0, 0, AbstractC8943Xx1.c(24), AbstractC8943Xx1.c(24));
            c12109e33 = new C12109e33(drawableD, -((AbstractC8943Xx1.c(1) * 13) + 2));
        } else {
            c12109e33 = null;
        }
        int i = a.a[c5980Lq6.t().ordinal()];
        int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractC12217eE5.call_ended : z2 ? AbstractC12217eE5.video_call_disconnect_bubble : AbstractC12217eE5.title_call_disconnect_bubble : z ? z2 ? AbstractC12217eE5.video_call_unsuccessful_bubble : AbstractC12217eE5.title_call_unsuccessful_bubble : z2 ? AbstractC12217eE5.video_call_rejected_bubble : AbstractC12217eE5.title_call_rejected_bubble : c5980Lq6.u() > 0 ? z ? z2 ? AbstractC12217eE5.video_call_outgoing_successful_bubble : AbstractC12217eE5.title_call_outgoing_successful_bubble : z2 ? AbstractC12217eE5.video_call_incoming_successful_bubble : AbstractC12217eE5.title_call_incoming_successful_bubble : z ? z2 ? AbstractC12217eE5.video_call_cancellation_bubble : AbstractC12217eE5.title_call_cancellation_bubble : z2 ? AbstractC12217eE5.video_call_missed_bubble : AbstractC12217eE5.title_call_missed_bubble : z ? z2 ? AbstractC12217eE5.video_call_unresponsive_bubble : AbstractC12217eE5.title_call_unresponsive_bubble : z2 ? AbstractC12217eE5.video_call_missed_bubble : AbstractC12217eE5.title_call_missed_bubble;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (c12109e33 != null) {
            spannableStringBuilder.append((CharSequence) Separators.SP);
            spannableStringBuilder.setSpan(new C11376cu0(), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(c12109e33, 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(12));
        }
        spannableStringBuilder.append((CharSequence) context.getString(i2));
        return spannableStringBuilder;
    }

    private final SpannableStringBuilder o(Context context) {
        String string = context.getString(AbstractC12217eE5.message_holder_state_video_compression);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_background_icon), 0, 0, 0, 14, null);
        return spannableStringBuilder;
    }

    private final Spannable p(Context context, int i) {
        Drawable drawableD = AbstractC6713Oq7.d(context, KB5.crowd_funding_done, i);
        if (drawableD == null) {
            return null;
        }
        drawableD.setBounds(0, 0, AbstractC8943Xx1.c(22), AbstractC8943Xx1.c(22));
        C12109e33 c12109e33 = new C12109e33(drawableD, -((AbstractC8943Xx1.c(1) * 15) + 2));
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(c12109e33, 0, spannableString.length(), 33);
        return spannableString;
    }

    private final Spannable q(Context context, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) (z ? context.getString(AbstractC12217eE5.nasim_is_live) : context.getString(AbstractC12217eE5.nasim_live_ended)));
        int length2 = spannableStringBuilder.length();
        if (z) {
            spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
            Drawable drawableF = AbstractC4043Dl1.f(context, KB5.live);
            if (drawableF != null) {
                drawableF.setBounds(0, 0, AbstractC8943Xx1.c(20), AbstractC8943Xx1.c(20));
            }
            AbstractC13042fc3.f(drawableF);
            AbstractC21710u02.h(drawableF, OY0.b(context, AbstractC15199jA5.colorOnPrimary));
            spannableStringBuilder.setSpan(new ImageSpan(drawableF, 2), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
        spannableStringBuilder.setSpan(new NH0(), length, length2, 33);
        AbstractC17636nI6.h(spannableStringBuilder, C5495Jo7.a.y0(OY0.b(context, AbstractC15199jA5.bubble_background_icon), 65), 8, 0, 0, 12, null);
        return SpannableString.valueOf(spannableStringBuilder);
    }

    private final Spannable r(CrowdfundingContentInfo crowdfundingContentInfo, Context context, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (x(crowdfundingContentInfo)) {
            Spannable spannableP = p(context, i);
            if (spannableP != null) {
                spannableStringBuilder.append((CharSequence) spannableP);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
            }
            spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.crowd_funding_completed));
            d(spannableStringBuilder, C6011Lu2.i(), 0, spannableStringBuilder.length());
            AbstractC17636nI6.f(spannableStringBuilder, i, 0, 0, 6, null);
        } else {
            String str = Separators.PERCENT + XY6.v(String.valueOf(s(crowdfundingContentInfo)));
            spannableStringBuilder.append((CharSequence) str);
            d(spannableStringBuilder, C6011Lu2.i(), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i, spannableStringBuilder.length() - str.length(), spannableStringBuilder.length());
            spannableStringBuilder.append((CharSequence) Separators.RETURN);
            String string = context.getString(AbstractC12217eE5.crowd_funding_provided);
            spannableStringBuilder.append((CharSequence) string);
            d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - string.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i2, spannableStringBuilder.length() - string.length(), spannableStringBuilder.length());
        }
        return spannableStringBuilder;
    }

    private final int s(CrowdfundingContentInfo crowdfundingContentInfo) {
        return crowdfundingContentInfo.m(crowdfundingContentInfo.k());
    }

    private final Spannable t(CrowdfundingContentInfo crowdfundingContentInfo, Context context, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CrowdfundingContentInfo.c cVarP = crowdfundingContentInfo.p();
        if (x(crowdfundingContentInfo)) {
            return null;
        }
        if (crowdfundingContentInfo.getStatus() == EnumC16838lx.STOPPED) {
            spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.crowd_funding_stopped));
            d(spannableStringBuilder, C6011Lu2.i(), 0, spannableStringBuilder.length());
            AbstractC17636nI6.f(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.colorError), 0, 0, 6, null);
        } else if (crowdfundingContentInfo.getStatus() == EnumC16838lx.EXPIRED || cVarP == null) {
            spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.crowd_funding_expired));
            d(spannableStringBuilder, C6011Lu2.i(), 0, spannableStringBuilder.length());
            AbstractC17636nI6.f(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.colorError), 0, 0, 6, null);
        } else if (cVarP.a() > 0) {
            String strV = XY6.v(String.valueOf(cVarP.a()));
            spannableStringBuilder.append((CharSequence) strV);
            d(spannableStringBuilder, C6011Lu2.i(), spannableStringBuilder.length() - strV.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i, spannableStringBuilder.length() - strV.length(), spannableStringBuilder.length());
            spannableStringBuilder.append((CharSequence) Separators.RETURN);
            String string = context.getString(AbstractC12217eE5.crowd_funding_day_remained);
            spannableStringBuilder.append((CharSequence) string);
            d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - string.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i2, spannableStringBuilder.length() - string.length(), spannableStringBuilder.length());
        } else {
            String strV2 = XY6.v(cVarP.b() + ":" + cVarP.c());
            spannableStringBuilder.append((CharSequence) strV2);
            d(spannableStringBuilder, C6011Lu2.i(), spannableStringBuilder.length() - strV2.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i, spannableStringBuilder.length() - strV2.length(), spannableStringBuilder.length());
            spannableStringBuilder.append((CharSequence) Separators.RETURN);
            String string2 = context.getString(AbstractC12217eE5.crowd_funding_remained);
            spannableStringBuilder.append((CharSequence) string2);
            d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - string2.length(), spannableStringBuilder.length());
            AbstractC17636nI6.e(spannableStringBuilder, i2, spannableStringBuilder.length() - string2.length(), spannableStringBuilder.length());
        }
        return spannableStringBuilder;
    }

    private final String u() {
        return (String) this.h.getValue();
    }

    private final SpannableStringBuilder v(CrowdfundingContentInfo crowdfundingContentInfo) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) crowdfundingContentInfo.getTitle());
        d(spannableStringBuilder, C6011Lu2.i(), 0, spannableStringBuilder.length());
        spannableStringBuilder.append((CharSequence) Separators.RETURN);
        spannableStringBuilder.append((CharSequence) crowdfundingContentInfo.getDescription());
        d(spannableStringBuilder, C6011Lu2.k(), spannableStringBuilder.length() - crowdfundingContentInfo.getDescription().length(), spannableStringBuilder.length());
        return spannableStringBuilder;
    }

    private final Spannable w(Context context, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) XY6.v(XY6.c(String.valueOf(i), (char) 0, 2, null)));
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.ic_profile);
        if (drawableF != null) {
            drawableF.setBounds(0, 0, AbstractC8943Xx1.c(15), AbstractC8943Xx1.c(15));
        }
        AbstractC13042fc3.f(drawableF);
        AbstractC21710u02.h(drawableF, OY0.b(context, AbstractC15199jA5.colorOnPrimary));
        spannableStringBuilder.setSpan(new ImageSpan(drawableF, 2), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        AbstractC17636nI6.h(spannableStringBuilder, C5495Jo7.a.y0(OY0.b(context, AbstractC15199jA5.bubble_background_icon), 65), 100, 0, 0, 12, null);
        return SpannableString.valueOf(spannableStringBuilder);
    }

    private final boolean x(CrowdfundingContentInfo crowdfundingContentInfo) {
        return crowdfundingContentInfo.getStatus() == EnumC16838lx.DONE || crowdfundingContentInfo.t();
    }

    private final boolean y(CrowdfundingContentInfo crowdfundingContentInfo) {
        return crowdfundingContentInfo.getStatus() == EnumC16838lx.INPROGRESS && crowdfundingContentInfo.p() != null;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        boolean z = j44.U() == this.e;
        Context context = z ? this.b : this.a;
        AbstractC17457n0 abstractC17457n0P = j44.P();
        if (abstractC17457n0P == null) {
            abstractC17457n0P = j44.F();
        }
        if (abstractC17457n0P instanceof LC3) {
            return K(context, abstractC17457n0P, j44);
        }
        if (abstractC17457n0P instanceof C24967zW1) {
            return A(context, (C24967zW1) abstractC17457n0P, j44);
        }
        if (abstractC17457n0P instanceof C18626oy5) {
            return M(context, (C18626oy5) abstractC17457n0P, j44);
        }
        if (abstractC17457n0P instanceof JM6) {
            return P((JM6) abstractC17457n0P);
        }
        if (abstractC17457n0P instanceof C16799lt) {
            return C((C16799lt) abstractC17457n0P);
        }
        if (abstractC17457n0P instanceof C10844cI3) {
            return L(j44.i(), (C10844cI3) abstractC17457n0P);
        }
        if (abstractC17457n0P instanceof C5980Lq6) {
            return E(context, (C5980Lq6) abstractC17457n0P, z);
        }
        if (abstractC17457n0P instanceof C22472vI2) {
            return H(context, j44, false);
        }
        if (abstractC17457n0P instanceof BJ2) {
            return H(context, j44, true);
        }
        if (abstractC17457n0P instanceof ir.nasim.core.modules.messaging.entity.content.a) {
            return G(context, (ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0P, j44);
        }
        if (abstractC17457n0P instanceof C22149uk7) {
            C24967zW1 c24967zW1H = j44.H();
            if (c24967zW1H != null) {
                return A(context, c24967zW1H, j44);
            }
        } else {
            if (abstractC17457n0P instanceof C6833Pe1) {
                return F((C6833Pe1) abstractC17457n0P);
            }
            if (abstractC17457n0P instanceof C11907dl) {
                List listR = ((C11907dl) abstractC17457n0P).r();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
                Iterator it = listR.iterator();
                while (it.hasNext()) {
                    arrayList.add(a((J44) it.next()));
                }
                return arrayList;
            }
            if (abstractC17457n0P instanceof C12872fJ6) {
                return O((C12872fJ6) abstractC17457n0P);
            }
            if (abstractC17457n0P instanceof C19049ph5) {
                return N((C19049ph5) abstractC17457n0P);
            }
        }
        return null;
    }
}
