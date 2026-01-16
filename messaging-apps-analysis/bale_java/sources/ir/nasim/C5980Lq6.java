package ir.nasim;

import android.content.Context;
import java.util.Locale;

/* renamed from: ir.nasim.Lq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5980Lq6 extends AbstractC12586er6 {
    private int d;
    private Long e;
    private EnumC5091Hw f;

    /* renamed from: ir.nasim.Lq6$a */
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5980Lq6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contactContent");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExPhoneCall");
        C18757pC c18757pC = (C18757pC) vbU;
        this.d = c18757pC.w();
        this.e = c18757pC.y();
        this.f = c18757pC.u();
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return s(context, i, AbstractC12217eE5.dialog_call_type_voice);
    }

    protected final String s(Context context, int i, int i2) {
        int i3;
        AbstractC13042fc3.i(context, "context");
        boolean z = i == AbstractC5969Lp4.f();
        String string = context.getString(i2);
        AbstractC13042fc3.h(string, "getString(...)");
        int i4 = a.a[this.f.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                i3 = i4 != 3 ? i4 != 4 ? AbstractC12217eE5.dialog_call_ended : AbstractC12217eE5.dialog_call_disconnected : z ? AbstractC12217eE5.dialog_call_ended_unsuccessful : AbstractC12217eE5.dialog_call_rejected;
            } else if (this.d > 0) {
                string = string.toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(string, "toLowerCase(...)");
                i3 = z ? AbstractC12217eE5.dialog_call_ended_successful_outgoing : AbstractC12217eE5.dialog_call_ended_successful_incoming;
            } else {
                i3 = z ? AbstractC12217eE5.dialog_call_cancelled : AbstractC12217eE5.dialog_call_missed;
            }
        } else {
            if (z) {
                String string2 = context.getString(AbstractC12217eE5.dialog_call_ended_unresponsive);
                AbstractC13042fc3.h(string2, "getString(...)");
                return string2;
            }
            i3 = AbstractC12217eE5.dialog_call_missed;
        }
        String string3 = context.getString(i3, string);
        AbstractC13042fc3.h(string3, "getString(...)");
        return string3;
    }

    public final EnumC5091Hw t() {
        return this.f;
    }

    public final int u() {
        return this.d;
    }
}
