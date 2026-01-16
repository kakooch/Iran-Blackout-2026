package ir.nasim;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import ir.nasim.C24303yO3;
import ir.nasim.C3917Cx1;
import ir.nasim.KO3;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.ChromeCustomTabReceiver;

/* renamed from: ir.nasim.Kp, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5730Kp {
    public static KO3.a a;

    public static C3917Cx1 a() {
        C3917Cx1.a aVar = new C3917Cx1.a();
        PendingIntent broadcast = PendingIntent.getBroadcast(C5721Ko.b, 0, new Intent(C5721Ko.b, (Class<?>) ChromeCustomTabReceiver.class), 67108864);
        aVar.f(C5495Jo7.a.e2()).b(BitmapFactory.decodeResource(C5721Ko.b.getResources(), KB5.ic_share_white_24dp), "Share", broadcast).d(BitmapFactory.decodeResource(C5721Ko.b.getResources(), KB5.ic_arrow_back_white_24dp));
        return aVar.a();
    }

    public static void b(Context context) {
        if (a == null) {
            a = ((InterfaceC24897zO3) C92.a(context, InterfaceC24897zO3.class)).D0();
        }
    }

    public static Spannable c(String str) {
        KO3.a aVar = a;
        C24303yO3.a aVar2 = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        return new SpannableStringBuilder(aVar.a(aVar2.l(bool).m(bool).e(bool).a()).k().b(str));
    }

    public static Spannable d(Spannable spannable) {
        KO3.a aVar = a;
        C24303yO3.a aVar2 = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        return new SpannableStringBuilder(aVar.a(aVar2.l(bool).m(bool).h(bool).e(bool).i(bool).g(bool).b(bool).c(bool).a()).k().b(spannable.toString()));
    }

    public static Spannable e(String str) {
        KO3.a aVar = a;
        C24303yO3.a aVar2 = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        return new SpannableStringBuilder(aVar.a(aVar2.l(bool).m(bool).h(bool).e(bool).i(bool).g(bool).b(bool).c(bool).a()).k().b(str));
    }

    public static Spannable f(String str, ExPeerType exPeerType, C11458d25 c11458d25, J44 j44) {
        KO3.a aVar = a;
        C24303yO3.a aVarD = new C24303yO3.a().k(c11458d25).f(exPeerType).j(j44).d(Boolean.valueOf(C8386Vt0.z5()));
        Boolean bool = Boolean.TRUE;
        return new SpannableStringBuilder(aVar.a(aVarD.l(bool).m(bool).h(bool).e(bool).i(bool).g(bool).b(bool).c(bool).a()).k().b(str));
    }

    public static Spannable g(String str) {
        KO3.a aVar = a;
        C24303yO3.a aVar2 = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        return new SpannableStringBuilder(aVar.a(aVar2.l(bool).h(bool).e(bool).m(bool).i(bool).g(bool).b(bool).c(bool).a()).k().b(str));
    }
}
