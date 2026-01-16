package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.widget.RemoteViews;
import ir.nasim.features.MainActivity;
import ir.nasim.features.firebase.newPush.receiver.PfmSetTagActionReceiver;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public final class VP4 {
    public static final VP4 a = new VP4();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("SAPTA", 0);
        public static final a b = new a("MESSAGING", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    private VP4() {
    }

    private final PendingIntent a(Context context, int i, PFMTransaction pFMTransaction, int i2) {
        PFMTag pFMTag;
        Map mapF = C23077wJ2.a.f();
        Intent intent = new Intent(context, (Class<?>) PfmSetTagActionReceiver.class);
        intent.setAction(pFMTransaction.getDate() + "| ");
        boolean z = true;
        if (i2 == BC5.tag2_food) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG2");
            pFMTag = (PFMTag) mapF.get(2L);
        } else if (i2 == BC5.tag3_transport) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG3");
            pFMTag = (PFMTag) mapF.get(3L);
        } else if (i2 == BC5.tag4_internet) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG4");
            pFMTag = (PFMTag) mapF.get(4L);
        } else if (i2 == BC5.tag5_bill) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG5");
            pFMTag = (PFMTag) mapF.get(5L);
        } else if (i2 == BC5.tag10_installment) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG10");
            pFMTag = (PFMTag) mapF.get(10L);
        } else if (i2 == BC5.tag20_salary) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG20");
            pFMTag = (PFMTag) mapF.get(20L);
        } else if (i2 == BC5.tag22_profit) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG22");
            pFMTag = (PFMTag) mapF.get(22L);
        } else if (i2 == BC5.tag25_dong) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG25");
            pFMTag = (PFMTag) mapF.get(25L);
        } else if (i2 == BC5.tag24_pocket) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG24");
            pFMTag = (PFMTag) mapF.get(24L);
        } else if (i2 == BC5.tag33_jib_be_jib) {
            intent.setAction(intent.getAction() + "ir.nasim.intent.receiver.PFM_SET_TAG.TAG33");
            pFMTag = (PFMTag) mapF.get(33L);
        } else {
            z = false;
            pFMTag = null;
        }
        if (z) {
            intent.putExtra("PEER_ID", i);
            intent.putExtra("PFM_TAG", pFMTag);
            intent.putExtra("PFM_TRANSACTION", pFMTransaction);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 201326592);
            AbstractC13042fc3.h(broadcast, "getBroadcast(...)");
            return broadcast;
        }
        Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
        intent2.setAction("android.intent.action.VIEW");
        intent2.setData(Uri.parse("https://ble.ir/open_pfm_text/" + pFMTransaction.getDate()));
        intent2.putExtra("extra_transaction", pFMTransaction);
        PendingIntent activity = PendingIntent.getActivity(C5721Ko.a.d(), i, intent2, 201326592);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final String e(C8455Wa6 c8455Wa6) {
        return c8455Wa6.e() + ": " + XY6.e(c8455Wa6.g()) + " ریال";
    }

    private final String f(C8455Wa6 c8455Wa6) {
        return g(c8455Wa6);
    }

    private final String g(C8455Wa6 c8455Wa6) {
        return AbstractC16016kZ6.g("\n                                        " + c8455Wa6.e() + ": " + XY6.e(c8455Wa6.g()) + " ریال\n                                       حساب: xxxxx " + XY6.e(String.valueOf(c8455Wa6.f())) + " \n                                       مانده: " + XY6.e(c8455Wa6.h()) + " ریال\n        ");
    }

    private final void l(RemoteViews remoteViews, Context context, int i, C8455Wa6 c8455Wa6) {
        Iterator it = AbstractC10360bX0.p(Integer.valueOf(BC5.tag20_salary), Integer.valueOf(BC5.tag25_dong), Integer.valueOf(BC5.tag24_pocket), Integer.valueOf(BC5.tag33_jib_be_jib), Integer.valueOf(BC5.tag22_profit), Integer.valueOf(BC5.add_more_top_up_tag)).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            remoteViews.setOnClickPendingIntent(iIntValue, a(context, i, c8455Wa6.i(), iIntValue));
        }
        remoteViews.setViewVisibility(BC5.top_up_tags, 0);
        remoteViews.setViewVisibility(BC5.withdraw_tags, 8);
    }

    private final void m(RemoteViews remoteViews, Context context, int i, C8455Wa6 c8455Wa6) {
        Iterator it = AbstractC10360bX0.p(Integer.valueOf(BC5.tag2_food), Integer.valueOf(BC5.tag3_transport), Integer.valueOf(BC5.tag10_installment), Integer.valueOf(BC5.tag4_internet), Integer.valueOf(BC5.tag5_bill), Integer.valueOf(BC5.add_more_withdraw_tag)).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            remoteViews.setOnClickPendingIntent(iIntValue, a(context, i, c8455Wa6.i(), iIntValue));
        }
        remoteViews.setViewVisibility(BC5.top_up_tags, 8);
        remoteViews.setViewVisibility(BC5.withdraw_tags, 0);
    }

    public final RemoteViews b(Context context, C8455Wa6 c8455Wa6) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8455Wa6, "saptaPushModel");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.pfm_notification_collapsed);
        int i = BC5.title;
        VP4 vp4 = a;
        remoteViews.setTextViewText(i, vp4.k());
        remoteViews.setTextViewText(BC5.content, vp4.e(c8455Wa6));
        return remoteViews;
    }

    public final RemoteViews c(Context context, int i, C8455Wa6 c8455Wa6) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8455Wa6, "saptaPushModel");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.pfm_notification_expanded);
        int i2 = BC5.title;
        VP4 vp4 = a;
        remoteViews.setTextViewText(i2, vp4.k());
        remoteViews.setTextViewText(BC5.content, vp4.f(c8455Wa6));
        if (c8455Wa6.i().getTransactionType() == EnumC18897pR4.d) {
            vp4.m(remoteViews, context, i, c8455Wa6);
        } else {
            vp4.l(remoteViews, context, i, c8455Wa6);
        }
        return remoteViews;
    }

    public final RemoteViews d(Context context, C8455Wa6 c8455Wa6) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8455Wa6, "saptaPushModel");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.pfm_notification_heads_up);
        int i = BC5.title;
        VP4 vp4 = a;
        remoteViews.setTextViewText(i, vp4.k());
        remoteViews.setTextViewText(BC5.content, vp4.g(c8455Wa6));
        return remoteViews;
    }

    public final String h(C8455Wa6 c8455Wa6) {
        AbstractC13042fc3.i(c8455Wa6, "<this>");
        return c8455Wa6.e() + ": " + XY6.e(c8455Wa6.g()) + " ریال";
    }

    public final int i(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
        long id = pFMTag.getId();
        int i = 1;
        if (id != 20 && id != 24 && id != 22 && id != 2 && id != 10 && id != 5) {
            i = 2;
            if (id != 25 && id != 33 && id != 3 && id != 4) {
                return -1;
            }
        }
        return i;
    }

    public final int j(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
        long id = pFMTag.getId();
        int i = 1;
        if (id != 20 && id != 25 && id != 2 && id != 3) {
            i = 2;
            if (id != 24 && id != 33 && id != 10 && id != 4) {
                return (id == 22 || id == 5) ? 3 : -1;
            }
        }
        return i;
    }

    public final String k() {
        return "تراکنش بانک ملّی ایران";
    }
}
