package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.ContextThemeWrapper;
import ir.nasim.R62;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class K74 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final Context a;
    private final InterfaceC14123hO3 b;

    public static final class a {

        /* renamed from: ir.nasim.K74$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0456a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[LA7.values().length];
                try {
                    iArr[LA7.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LA7.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LA7.e.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LA7.c.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[LA7.d.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        private final int d(int i) {
            return i * AbstractC8943Xx1.c(1);
        }

        private final ArrayList e(boolean z, Context context, int i, Long l, boolean z2, boolean z3) {
            Spannable spannableH;
            a aVar;
            Spannable spannableR;
            ArrayList arrayList = new ArrayList();
            arrayList.add(AbstractC17636nI6.b(10));
            SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.blocked_message));
            spannableString.setSpan(new C22749vl7(i, z ? 1 : AbstractC8943Xx1.c(1)), 0, spannableString.length(), 17);
            arrayList.add(spannableString);
            if (l != null && (spannableR = (aVar = K74.c).r(context, i, z)) != null) {
                arrayList.add(AbstractC17636nI6.b(10));
                SpannableString spannableStringQ = aVar.q(l.longValue());
                if (z) {
                    AbstractC17636nI6.d(spannableStringQ, 12, true, 0, 0, 12, null);
                }
                arrayList.add(spannableStringQ);
                arrayList.add(AbstractC17636nI6.b(2));
                arrayList.add(spannableR);
            }
            if (z2) {
                arrayList.add(AbstractC17636nI6.b(10));
                SpannableString spannableString2 = new SpannableString(context.getString(AbstractC12217eE5.message_edited));
                spannableString2.setSpan(new C22749vl7(i, z ? 1 : AbstractC8943Xx1.c(1)), 0, spannableString2.length(), 17);
                arrayList.add(spannableString2);
            }
            if (z3 && (spannableH = K74.c.h(context, i)) != null) {
                arrayList.add(AbstractC17636nI6.b(10));
                arrayList.add(spannableH);
            }
            return arrayList;
        }

        private final Spannable f(long j, boolean z) {
            SpannableString spannableString = new SpannableString(C14593iA1.A(j));
            if (z) {
                AbstractC17636nI6.d(spannableString, 12, true, 0, 0, 12, null);
            }
            return spannableString;
        }

        private final Spannable g(boolean z, String str) {
            SpannableString spannableString = new SpannableString(str);
            if (z) {
                AbstractC17636nI6.d(spannableString, 12, true, 0, 0, 12, null);
            }
            return spannableString;
        }

        private final Spannable h(Context context, int i) {
            Drawable drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_pin, i);
            if (drawableD == null) {
                return null;
            }
            drawableD.setBounds(0, 0, AbstractC8943Xx1.c(14), AbstractC8943Xx1.c(14));
            ImageSpan imageSpan = Build.VERSION.SDK_INT >= 29 ? new ImageSpan(drawableD, 2) : new ImageSpan(drawableD, 1);
            SpannableString spannableString = new SpannableString(Separators.SP);
            spannableString.setSpan(imageSpan, 0, spannableString.length(), 17);
            return spannableString;
        }

        private final SpannableString i(Context context, GG5 gg5, int i) {
            VH5 vh5;
            SpannableString spannableString = new SpannableString(gg5.u() + "-" + gg5.s());
            R62.b bVarA = R62.A(gg5.u());
            if (bVarA != null) {
                vh5 = new VH5(gg5.s() == 1 ? "" : XY6.v("2"), bVarA, AbstractC4043Dl1.c(context, TA5.transparent), null, i, AbstractC8943Xx1.c(12), Float.valueOf(C22078ud6.e(12.0f)), 0.0f, AbstractC8943Xx1.a(2.5d), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), 0, 0, 0, 28800, null);
            } else {
                vh5 = null;
            }
            spannableString.setSpan(vh5, 0, spannableString.length(), 17);
            return spannableString;
        }

        private final Spannable j(boolean z, Context context) {
            SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.advertise));
            if (z) {
                AbstractC17636nI6.d(spannableString, 12, true, 0, 0, 12, null);
            }
            return spannableString;
        }

        private final Spannable k(boolean z, LA7 la7, Context context, int i, int i2) {
            Spannable spannableM;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            a aVar = K74.c;
            spannableStringBuilder.append((CharSequence) aVar.j(z, context));
            if (la7 != null && (spannableM = aVar.m(context, la7, i, i2)) != null) {
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableM);
            }
            return spannableStringBuilder;
        }

        private final ImageSpan l(Context context, LA7 la7, int i, int i2) {
            Drawable drawableD;
            int iD;
            int i3 = C0456a.a[la7.ordinal()];
            if (i3 == 1) {
                int iB = OY0.b(context, AbstractC21139tA5.colorError);
                int iD2 = d(10) + 2;
                drawableD = AbstractC6713Oq7.d(context, KB5.ic_alert, iB);
                iD = iD2;
            } else if (i3 == 2) {
                iD = d(10) + 2;
                drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_pending, i);
            } else if (i3 == 3) {
                iD = d(10);
                drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_sent, i);
            } else {
                if (i3 != 4 && i3 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                iD = d(10);
                drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_seen, i2);
            }
            if (drawableD == null) {
                return null;
            }
            drawableD.setBounds(0, 0, AbstractC8943Xx1.c(15), AbstractC8943Xx1.c(15));
            return new C12109e33(drawableD, -iD);
        }

        private final Spannable m(Context context, LA7 la7, int i, int i2) {
            ImageSpan imageSpanL = l(context, la7, i, i2);
            if (imageSpanL == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(la7.name());
            spannableString.setSpan(imageSpanL, 0, spannableString.length(), 17);
            return spannableString;
        }

        private final Spannable n(long j, boolean z, LA7 la7, String str, Context context, int i, int i2) {
            Spannable spannableM;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            a aVar = K74.c;
            spannableStringBuilder.append((CharSequence) aVar.f(j, z));
            if (la7 != null && (spannableM = aVar.m(context, la7, i, i2)) != null) {
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableM);
            }
            if (str != null) {
                spannableStringBuilder.append((CharSequence) aVar.g(z, str));
            }
            return spannableStringBuilder;
        }

        private final ArrayList p(String str, boolean z, boolean z2, LA7 la7, Context context, int i, int i2, long j, Long l, boolean z3, boolean z4, JM3 jm3, GG5 gg5) {
            Spannable spannableS;
            Spannable spannableH;
            a aVar;
            Spannable spannableR;
            ArrayList arrayList = new ArrayList();
            arrayList.add(AbstractC17636nI6.b(8));
            if (z) {
                arrayList.add(K74.c.k(z2, la7, context, i, i2));
            } else {
                arrayList.add(K74.c.n(j, z2, la7, str, context, i, i2));
            }
            if (l != null && (spannableR = (aVar = K74.c).r(context, i, z2)) != null) {
                arrayList.add(AbstractC17636nI6.b(10));
                SpannableString spannableStringQ = aVar.q(l.longValue());
                if (z2) {
                    AbstractC17636nI6.d(spannableStringQ, 12, true, 0, 0, 12, null);
                }
                arrayList.add(spannableStringQ);
                arrayList.add(AbstractC17636nI6.b(2));
                arrayList.add(spannableR);
            }
            if (z3) {
                arrayList.add(AbstractC17636nI6.b(10));
                SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.message_edited));
                spannableString.setSpan(new C22749vl7(i, z2 ? 1 : AbstractC8943Xx1.c(1)), 0, spannableString.length(), 17);
                arrayList.add(spannableString);
            }
            if (z4 && (spannableH = K74.c.h(context, i)) != null) {
                arrayList.add(AbstractC17636nI6.b(10));
                arrayList.add(spannableH);
            }
            if (jm3 != null && (spannableS = K74.c.s(context)) != null && jm3 == JM3.a) {
                arrayList.add(AbstractC17636nI6.b(10));
                arrayList.add(spannableS);
            }
            if (gg5 != null) {
                arrayList.add(K74.c.i(context, gg5, i));
            } else {
                arrayList.add(AbstractC17636nI6.b(8));
            }
            return arrayList;
        }

        private final SpannableString q(long j) {
            return new SpannableString(AbstractC20655sN7.g(j));
        }

        private final Spannable r(Context context, int i, boolean z) {
            Drawable drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_view, i);
            if (drawableD == null) {
                return null;
            }
            drawableD.setBounds(0, 0, AbstractC8943Xx1.c(15), AbstractC8943Xx1.c(15));
            int i2 = -K74.c.d(10);
            if (!z) {
                i2 -= 2;
            }
            C12109e33 c12109e33 = new C12109e33(drawableD, i2);
            SpannableString spannableString = new SpannableString(Separators.SP);
            spannableString.setSpan(c12109e33, 0, spannableString.length(), 17);
            return spannableString;
        }

        private final Spannable s(Context context) {
            Drawable drawableF = AbstractC4043Dl1.f(context, KB5.bubble_state_up_vote_by_me);
            if (drawableF == null) {
                return null;
            }
            drawableF.setBounds(0, 0, AbstractC8943Xx1.c(14), AbstractC8943Xx1.c(14));
            ImageSpan imageSpan = Build.VERSION.SDK_INT >= 29 ? new ImageSpan(drawableF, 2) : new ImageSpan(drawableF, 1);
            SpannableString spannableString = new SpannableString(Separators.SP);
            spannableString.setSpan(imageSpan, 0, spannableString.length(), 17);
            return spannableString;
        }

        public final SpannableStringBuilder a(Context context, long j, LA7 la7, boolean z, Long l, boolean z2, int i, int i2, int i3, GG5 gg5, String str, boolean z3, JM3 jm3, boolean z4) throws IOException {
            AbstractC13042fc3.i(context, "context");
            boolean zG = JF5.g();
            ArrayList arrayListP = !z4 ? p(str, z3, zG, la7, context, i, i3, j, l, z, z2, jm3, gg5) : e(zG, context, i, l, z, z2);
            if (!JF5.g()) {
                AbstractC14812iX0.b0(arrayListP);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Spannable[] spannableArr = (Spannable[]) arrayListP.toArray(new Spannable[0]);
            AbstractC15425jZ6.a(spannableStringBuilder, (CharSequence[]) Arrays.copyOf(spannableArr, spannableArr.length));
            AbstractC17636nI6.f(spannableStringBuilder, i, 0, 0, 6, null);
            AbstractC17636nI6.h(spannableStringBuilder, i2, 0, 0, 0, 14, null);
            return spannableStringBuilder;
        }

        public final ReplacementSpan c(ContextThemeWrapper contextThemeWrapper, int i) {
            AbstractC13042fc3.i(contextThemeWrapper, "context");
            Drawable drawableF = AbstractC4043Dl1.f(contextThemeWrapper, i);
            if (drawableF == null) {
                return null;
            }
            drawableF.setBounds(AbstractC8943Xx1.c(-2), 0, AbstractC8943Xx1.c(13), AbstractC8943Xx1.c(15));
            drawableF.setTint(OY0.b(contextThemeWrapper, AbstractC21139tA5.bubble_low_text));
            return new C12109e33(drawableF, -32);
        }

        public final int o(boolean z, Context context) {
            AbstractC13042fc3.i(context, "context");
            return z ? OY0.b(context, AbstractC21139tA5.colorOnPrimary) : OY0.b(context, AbstractC21139tA5.bubble_low_text);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public K74(Context context, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC14123hO3, "messageToUiMessageStateMapper");
        this.a = context;
        this.b = interfaceC14123hO3;
    }

    private final Long b(J44 j44) {
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
            return Long.valueOf(Math.max(gg5.s(), gg5.y().size()));
        }
        return null;
    }

    public final SpannableStringBuilder a(J44 j44, boolean z, boolean z2, boolean z3, GG5 gg5, JM3 jm3, boolean z4) {
        C5118Hz c5118HzU;
        C5118Hz c5118HzW;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        String strQ = null;
        LA7 la7 = z ? (LA7) this.b.a(j44) : null;
        a aVar = c;
        int iO = aVar.o(z2, this.a);
        int iB = z2 ? OY0.b(this.a, AbstractC21139tA5.bubble_background_icon) : C5495Jo7.a.B2();
        int iB2 = z2 ? OY0.b(this.a, AbstractC21139tA5.bubble_seen_in_dark_bg) : OY0.b(this.a, AbstractC21139tA5.colorSuccess);
        Long lB = b(j44);
        if (j44.F().m()) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            C24967zW1 c24967zW1 = abstractC17457n0F instanceof C24967zW1 ? (C24967zW1) abstractC17457n0F : null;
            if (c24967zW1 != null && (c5118HzW = c24967zW1.w()) != null) {
                strQ = c5118HzW.q();
            }
        } else {
            AbstractC17457n0 abstractC17457n0F2 = j44.F();
            C23345wl7 c23345wl7 = abstractC17457n0F2 instanceof C23345wl7 ? (C23345wl7) abstractC17457n0F2 : null;
            if (c23345wl7 != null && (c5118HzU = c23345wl7.u()) != null) {
                strQ = c5118HzU.q();
            }
        }
        return aVar.a(this.a, j44.h(), la7, j44.b0(), lB, z3, iO, iB, iB2, gg5, strQ, j44.F() instanceof C12872fJ6, jm3, z4);
    }
}
