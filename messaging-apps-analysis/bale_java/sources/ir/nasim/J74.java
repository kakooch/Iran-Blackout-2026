package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import ir.nasim.PO5;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes5.dex */
public final class J74 implements InterfaceC14123hO3 {
    private final Context a;
    private final int b;
    private final SettingsModule c;
    private final ZN2 d;
    private final C22161um e;

    public J74(Context context, int i, SettingsModule settingsModule, ZN2 zn2, C22161um c22161um) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(zn2, "groupType");
        this.a = context;
        this.b = i;
        this.c = settingsModule;
        this.d = zn2;
        this.e = c22161um;
    }

    private final PO5.a b(C24967zW1 c24967zW1, Integer num, Spannable spannable) {
        String strY = c24967zW1.y();
        AbstractC13042fc3.h(strY, "getName(...)");
        return new PO5.a(num, spannable, AbstractC17636nI6.i(strY));
    }

    private final PO5.b c(AbstractC17457n0 abstractC17457n0, Integer num, Spannable spannable, String str) {
        C24967zW1 c24967zW1F;
        C22694vg2 c22694vg2V;
        return new PO5.b(num, spannable, AbstractC17636nI6.i(str), (abstractC17457n0 == null || (c24967zW1F = abstractC17457n0.f()) == null || (c22694vg2V = c24967zW1F.v()) == null) ? null : c22694vg2V.c());
    }

    static /* synthetic */ PO5.b d(J74 j74, AbstractC17457n0 abstractC17457n0, Integer num, Spannable spannable, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = abstractC17457n0 instanceof C13388g85 ? j74.g(AbstractC12217eE5.media_picture) : abstractC17457n0 instanceof XG2 ? j74.g(AbstractC12217eE5.gif) : j74.g(AbstractC12217eE5.media_video);
        }
        return j74.c(abstractC17457n0, num, spannable, str);
    }

    private final PO5.c e(C10844cI3 c10844cI3, Integer num, Spannable spannable) {
        return new PO5.c(num, spannable, AbstractC17636nI6.i(g(AbstractC12217eE5.media_location)), AbstractC20153rZ6.M(AbstractC20153rZ6.M(this.c.V2(), "{0}", String.valueOf(c10844cI3.s()), false, 4, null), "{1}", String.valueOf(c10844cI3.t()), false, 4, null));
    }

    private final PO5 f(C8445Vz5 c8445Vz5, boolean z) {
        String strG;
        C23345wl7 c23345wl7L;
        C22161um c22161um = this.e;
        Integer numValueOf = c22161um != null ? Integer.valueOf(c22161um.a(c8445Vz5.z())) : null;
        Spannable spannableJ = j(c8445Vz5, numValueOf);
        AbstractC17457n0 abstractC17457n0R = c8445Vz5.r();
        if (abstractC17457n0R instanceof NH1) {
            strG = g(AbstractC12217eE5.reply_deleted_chat);
        } else if (abstractC17457n0R instanceof C23345wl7) {
            strG = c8445Vz5.D() != null ? g(AbstractC12217eE5.story) : ((C23345wl7) abstractC17457n0R).v();
        } else if ((abstractC17457n0R instanceof JM6) || (abstractC17457n0R instanceof C16799lt)) {
            strG = g(AbstractC12217eE5.media_sticker);
        } else if ((abstractC17457n0R instanceof TM) || (abstractC17457n0R instanceof J08)) {
            strG = g(AbstractC12217eE5.media_audio);
        } else {
            if (abstractC17457n0R instanceof C10844cI3) {
                return e((C10844cI3) abstractC17457n0R, numValueOf, spannableJ);
            }
            if ((abstractC17457n0R instanceof C13388g85) || (abstractC17457n0R instanceof XG2) || (abstractC17457n0R instanceof GS7)) {
                return d(this, abstractC17457n0R, numValueOf, spannableJ, null, 8, null);
            }
            if (abstractC17457n0R instanceof C24967zW1) {
                return b((C24967zW1) abstractC17457n0R, numValueOf, spannableJ);
            }
            if (abstractC17457n0R instanceof C20360rs6) {
                strG = g(AbstractC12217eE5.media_video_call);
            } else if (abstractC17457n0R instanceof C5980Lq6) {
                strG = g(AbstractC12217eE5.media_voice_call);
            } else {
                if (abstractC17457n0R instanceof C11907dl) {
                    return c(((J44) AbstractC15401jX0.C0(((C11907dl) abstractC17457n0R).r())).F(), numValueOf, spannableJ, g(AbstractC12217eE5.media_album));
                }
                if (abstractC17457n0R instanceof C6833Pe1) {
                    strG = g(AbstractC12217eE5.media_contact);
                } else if (abstractC17457n0R instanceof C22149uk7) {
                    C23345wl7 c23345wl7L2 = ((C22149uk7) abstractC17457n0R).l();
                    strG = c23345wl7L2 != null ? c23345wl7L2.v() : null;
                    if (strG == null) {
                        strG = "";
                    }
                } else if (abstractC17457n0R instanceof AbstractC12586er6) {
                    strG = ((AbstractC12586er6) abstractC17457n0R).a(this.a, c8445Vz5.z(), c8445Vz5.C(), this.d == ZN2.GROUP);
                } else if (abstractC17457n0R instanceof C18626oy5) {
                    strG = g(AbstractC12217eE5.money_request);
                } else if (abstractC17457n0R instanceof C22472vI2) {
                    strG = g(AbstractC12217eE5.gift_packet);
                } else if (abstractC17457n0R instanceof BJ2) {
                    strG = g(AbstractC12217eE5.gold_gift_packet);
                } else if (abstractC17457n0R instanceof ir.nasim.core.modules.messaging.entity.content.a) {
                    strG = g(AbstractC12217eE5.crowd_funding);
                } else if (abstractC17457n0R instanceof C19049ph5) {
                    strG = g(AbstractC12217eE5.poll);
                } else if (!(abstractC17457n0R instanceof C5331Iw5) || (c23345wl7L = ((C5331Iw5) abstractC17457n0R).l()) == null || (strG = c23345wl7L.v()) == null) {
                    strG = g(AbstractC12217eE5.messages_quoted);
                }
            }
        }
        Spannable spannableI = strG != null ? i(strG, z) : null;
        if (c8445Vz5.D() == null) {
            return new PO5.d(numValueOf, spannableJ, spannableI);
        }
        String string = this.a.getString(AbstractC12217eE5.story);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableString spannableStringI = AbstractC17636nI6.i(string);
        int iZ = c8445Vz5.z();
        String strD = c8445Vz5.D();
        AbstractC13042fc3.h(strD, "getStoryId(...)");
        return new PO5.e(numValueOf, spannableJ, spannableStringI, iZ, strD);
    }

    private final String g(int i) {
        String string = this.a.getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final Spannable i(String str, boolean z) {
        return AbstractC5730Kp.f(str, null, null, null);
    }

    private final Spannable j(C8445Vz5 c8445Vz5, Integer num) {
        String strC;
        C10410bZ6 c10410bZ6R;
        Spannable spannableF;
        if (c8445Vz5.C() != null) {
            strC = c8445Vz5.C();
        } else {
            if (c8445Vz5.z() == 0) {
                return AbstractC17636nI6.i("");
            }
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c8445Vz5.z());
            strC = (c21231tK7 == null || (c10410bZ6R = c21231tK7.r()) == null) ? null : (String) c10410bZ6R.b();
            if (strC == null) {
                strC = "";
            }
        }
        AbstractC13042fc3.f(strC);
        SpannableString spannableStringI = AbstractC17636nI6.i(strC);
        return (num == null || (spannableF = AbstractC17636nI6.f(spannableStringI, num.intValue(), 0, 0, 6, null)) == null) ? spannableStringI : spannableF;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public PO5 a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q == null || c8445Vz5Q.E()) {
            return null;
        }
        return f(c8445Vz5Q, j44.U() == this.b);
    }
}
