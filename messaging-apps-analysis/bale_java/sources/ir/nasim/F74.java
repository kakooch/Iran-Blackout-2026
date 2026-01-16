package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Spannable;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class F74 {
    private final Context a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LA7.values().length];
            try {
                iArr[LA7.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LA7.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LA7.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(-((GG5) obj).w()), Long.valueOf(-((GG5) obj2).w()));
        }
    }

    public F74(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    private final StringBuilder b(C4602Fv2 c4602Fv2, ExPeerType exPeerType, Spannable spannable, AbstractC17457n0 abstractC17457n0) {
        Spannable spannableB;
        StringBuilder sb = new StringBuilder();
        if (exPeerType == ExPeerType.GROUP) {
            sb.append(Separators.SP);
            if (spannable == null || spannable.length() != 0) {
                sb.append(String.valueOf(spannable));
            } else {
                sb.append(this.a.getString(AbstractC12217eE5.you));
            }
        }
        String string = (c4602Fv2 == null || (spannableB = c4602Fv2.b()) == null) ? null : spannableB.toString();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        sb.append(Separators.SP);
        sb.append(abstractC17457n0.j(this.a));
        return sb;
    }

    private final XV4 c(C4602Fv2 c4602Fv2, ExPeerType exPeerType, Spannable spannable, AbstractC17457n0 abstractC17457n0) {
        StringBuilder sbB = b(c4602Fv2, exPeerType, spannable, abstractC17457n0);
        String string = sbB.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        String str = this.a.getString(AbstractC12217eE5.selected) + ((CharSequence) sbB);
        AbstractC13042fc3.h(str, "toString(...)");
        return AbstractC4616Fw7.a(string, str);
    }

    private final String d(List list, String str, ExPeerType exPeerType) {
        List listA1;
        String strE;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!AbstractC13042fc3.d(((GG5) obj).u(), "👁️")) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        if (arrayList.size() == 1 && ((GG5) AbstractC15401jX0.q0(arrayList)).w() == 1 && exPeerType.isPrivate().booleanValue() && str != null) {
            arrayList = null;
        }
        String string = (arrayList == null || (listA1 = AbstractC15401jX0.a1(arrayList, new b())) == null || (strE = AbstractC12806fC3.e(listA1, Separators.SP, null, null, 0, null, new UA2() { // from class: ir.nasim.E74
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return F74.e((GG5) obj2);
            }
        }, 30, null)) == null) ? null : this.a.getString(AbstractC12217eE5.chat_fragment_bubble_reaction_content_description, strE);
        if (string == null) {
            string = "";
        }
        String string2 = str != null ? this.a.getString(AbstractC12217eE5.chat_fragment_bubble_my_reaction_content_description, str) : null;
        return string + Separators.SP + (string2 != null ? string2 : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(GG5 gg5) {
        AbstractC13042fc3.i(gg5, "it");
        return gg5.w() + Separators.SP + gg5.u();
    }

    private final String f(int i, LA7 la7) {
        int i2;
        if (i == AbstractC5969Lp4.f()) {
            int i3 = a.a[la7.ordinal()];
            i2 = i3 != 1 ? i3 != 2 ? i3 != 3 ? AbstractC12217eE5.empty_text : AbstractC12217eE5.all_message_state_seen_content_description : AbstractC12217eE5.all_message_state_pending_content_description : AbstractC12217eE5.all_message_state_not_seen_content_description;
        } else {
            i2 = AbstractC12217eE5.all_message_state_received_content_description;
        }
        String string = this.a.getString(i2);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String g(long j) {
        String string = this.a.getString(AbstractC12217eE5.chat_fragment_bubble_time_content_description, C14593iA1.A(j));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String h(J44 j44) {
        Object next;
        Iterator it = j44.R().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((GG5) next).u(), "👁️")) {
                break;
            }
        }
        GG5 gg5 = (GG5) next;
        if (gg5 != null) {
            return this.a.getString(AbstractC12217eE5.view_count_content_description, AbstractC20655sN7.g(Math.max(gg5.s(), gg5.y().size())).toString());
        }
        return null;
    }

    public final XV4 i(J44 j44, LA7 la7, ExPeerType exPeerType, Spannable spannable, C4602Fv2 c4602Fv2, String str) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(la7, "state");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC17457n0 abstractC17457n0P = j44.P();
        if (abstractC17457n0P == null) {
            abstractC17457n0P = j44.F();
        }
        XV4 xv4C = c(c4602Fv2, exPeerType, spannable, abstractC17457n0P);
        String str2 = (String) xv4C.a();
        String str3 = (String) xv4C.b();
        String strG = g(j44.h());
        String strF = f(j44.U(), la7);
        String strD = d(j44.R(), str, exPeerType);
        String strH = h(j44);
        if (strH == null) {
            strH = "";
        }
        String string = j44.b0() ? this.a.getString(AbstractC12217eE5.message_edited) : "";
        AbstractC13042fc3.f(string);
        return AbstractC4616Fw7.a(str2 + Separators.SP + strG + Separators.SP + strF + Separators.SP + strD + Separators.SP + string + Separators.SP + strH, str3 + Separators.SP + strG + Separators.SP + strF + Separators.SP + strD + Separators.SP + string + Separators.SP + strH);
    }
}
