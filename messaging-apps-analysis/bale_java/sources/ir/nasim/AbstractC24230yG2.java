package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C17448mz0;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24230yG2 {

    /* renamed from: ir.nasim.yG2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C17448mz0.a.values().length];
            try {
                iArr[C17448mz0.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C17448mz0.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C17448mz0.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C17448mz0.a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[C17448mz0.a.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[C17448mz0.a.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[C17448mz0.a.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[C17448mz0.a.i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[C17448mz0.a.h.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[C17448mz0.a.l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[C17448mz0.a.j.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[C17448mz0.a.k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[C17448mz0.a.m.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[C17448mz0.a.n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[C17448mz0.a.o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            a = iArr;
        }
    }

    public static final String a(C17448mz0.a aVar, AbstractC7031Pz0 abstractC7031Pz0, boolean z, String str) throws Resources.NotFoundException {
        AbstractC13042fc3.i(aVar, "callState");
        AbstractC13042fc3.i(str, "remoteParticipantName");
        switch (a.a[aVar.ordinal()]) {
            case 1:
            case 2:
                String string = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_outgoing_requested);
                AbstractC13042fc3.f(string);
                return string;
            case 3:
                String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_outgoing_recieved);
                AbstractC13042fc3.f(string2);
                return string2;
            case 4:
            case 14:
            case 15:
                return "";
            case 5:
                if (abstractC7031Pz0 == null) {
                    return "";
                }
                String string3 = C5721Ko.a.d().getString(AbstractC13042fc3.d(abstractC7031Pz0, AbstractC7031Pz0.c.b) ? AbstractC12217eE5.video_call_state_incoming : AbstractC12217eE5.voice_call_state_incoming);
                return string3 == null ? "" : string3;
            case 6:
                String string4 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_incoming_accepted);
                AbstractC13042fc3.f(string4);
                return string4;
            case 7:
                if (!z) {
                    return "";
                }
                Resources resources = C5721Ko.a.d().getResources();
                DY6 dy6 = DY6.a;
                String string5 = resources.getString(AbstractC12217eE5.voice_call_state_remote_reconnectiong);
                AbstractC13042fc3.h(string5, "getString(...)");
                String str2 = String.format(string5, Arrays.copyOf(new Object[]{str}, 1));
                AbstractC13042fc3.h(str2, "format(...)");
                return str2;
            case 8:
                String string6 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_on_hold);
                AbstractC13042fc3.f(string6);
                return string6;
            case 9:
                String string7 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_reconnecting);
                AbstractC13042fc3.f(string7);
                return string7;
            case 10:
                String string8 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_busy);
                AbstractC13042fc3.f(string8);
                return string8;
            case 11:
                String string9 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_declined);
                AbstractC13042fc3.f(string9);
                return string9;
            case 12:
                String string10 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_not_answered);
                AbstractC13042fc3.f(string10);
                return string10;
            case 13:
                String string11 = C5721Ko.a.d().getString(AbstractC12217eE5.voice_call_state_not_connected);
                AbstractC13042fc3.f(string11);
                return string11;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
