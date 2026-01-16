package ir.nasim;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.mr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17377mr6 extends AbstractC12586er6 {
    private final C11909dl1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17377mr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        this.d = c11909dl1;
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        List listU;
        Object next;
        AbstractC17566nB abstractC17566nBQ;
        C5577Jy c5577JyQ;
        String string;
        String string2;
        AbstractC13042fc3.i(context, "context");
        AbstractC24063xz abstractC24063xzC = this.d.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGroupCallEnded");
        C15211jC c15211jC = (C15211jC) vbU;
        if (!z) {
            return r();
        }
        C19811qz c19811qzU = c15211jC.u();
        if (c19811qzU != null && (listU = c19811qzU.u()) != null) {
            Iterator it = listU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((C20420rz) next).getKey(), "finisher")) {
                    break;
                }
            }
            C20420rz c20420rz = (C20420rz) next;
            if (c20420rz != null && (abstractC17566nBQ = c20420rz.q()) != null) {
                C5577Jy c5577Jy = abstractC17566nBQ instanceof C5577Jy ? (C5577Jy) abstractC17566nBQ : null;
                Integer numValueOf = c5577Jy != null ? Integer.valueOf(c5577Jy.u()) : null;
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    boolean z2 = iIntValue == AbstractC5969Lp4.f();
                    String strB = C24847zI7.b(C24847zI7.a, context, iIntValue, null, false, 12, null);
                    if (c15211jC.y()) {
                        string2 = context.getString(AbstractC12217eE5.group_call_missed_service_message, strB);
                    } else {
                        C24054xy c24054xyW = c15211jC.w();
                        if (c24054xyW == null || (c5577JyQ = c24054xyW.q()) == null) {
                            return r();
                        }
                        long jU = c5577JyQ.u();
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        long hours = timeUnit.toHours(jU);
                        long j = 60;
                        long minutes = timeUnit.toMinutes(jU) % j;
                        long seconds = timeUnit.toSeconds(jU) % j;
                        if (hours != 0) {
                            string = minutes != 0 ? context.getString(AbstractC12217eE5.time_duration_hours_minutes, Long.valueOf(hours), Long.valueOf(minutes)) : context.getString(AbstractC12217eE5.time_duration_hours, Long.valueOf(hours));
                            AbstractC13042fc3.f(string);
                        } else if (minutes != 0) {
                            string = seconds != 0 ? context.getString(AbstractC12217eE5.time_duration_minutes_seconds, Long.valueOf(minutes), Long.valueOf(seconds)) : context.getString(AbstractC12217eE5.time_duration_minutes, Long.valueOf(minutes));
                            AbstractC13042fc3.f(string);
                        } else {
                            string = context.getString(AbstractC12217eE5.time_duration_seconds, Long.valueOf(seconds));
                            AbstractC13042fc3.f(string);
                        }
                        string2 = context.getString(z2 ? AbstractC12217eE5.group_you_call_ended_service_message : AbstractC12217eE5.group_other_call_ended_service_message, strB, string);
                    }
                    AbstractC13042fc3.f(string2);
                    return XY6.v(string2);
                }
            }
        }
        return r();
    }

    public final C11909dl1 s() {
        return this.d;
    }
}
