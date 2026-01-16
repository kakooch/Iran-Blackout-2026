package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ir.nasim.C20919sp4;
import ir.nasim.PI7;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00060\tR\u00020\n\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015JY\u0010\u001c\u001a\f\u0012\b\u0012\u00060\tR\u00020\n0\u001b\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0087\u0001\u0010#\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u001e\"\u0004\b\u0003\u0010\u001f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00052\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00052 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\"¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0013H\u0016¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0013H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010\u0003J\r\u0010(\u001a\u00020\u0013¢\u0006\u0004\b(\u0010\u0003R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020-8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001b\u0010=\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lir/nasim/wf0;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", TokenNames.T, "Lir/nasim/qQ7;", "value", "Lir/nasim/iQ7;", "listener", "Lir/nasim/sp4$b;", "Lir/nasim/sp4;", "s8", "(Lir/nasim/qQ7;Lir/nasim/iQ7;)Lir/nasim/sp4$b;", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "imageView", "Lir/nasim/PI7;", "userPresence", "Lir/nasim/rB7;", "v8", "(Landroid/widget/TextView;Landroid/widget/ImageView;Lir/nasim/PI7;)V", "T1", "T2", "value1", "value2", "Lir/nasim/lQ7;", "", "u8", "(Lir/nasim/qQ7;Lir/nasim/qQ7;Lir/nasim/lQ7;)[Lir/nasim/sp4$b;", "T3", "T4", "value3", "value4", "Lir/nasim/CQ7;", "t8", "(Lir/nasim/qQ7;Lir/nasim/qQ7;Lir/nasim/qQ7;Lir/nasim/qQ7;Lir/nasim/CQ7;)V", "c7", "h7", "T6", "C8", "Lir/nasim/Ea0;", "W0", "Lir/nasim/Ea0;", "basePresenter", "", "X0", "Z", "z8", "()Z", "B8", "(Z)V", "unbindOnPause", "Y0", "y8", "A8", "unSubscribeOnPause", "Z0", "Lir/nasim/Yu3;", "x8", "()Lir/nasim/sp4;", "binder", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.wf0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23278wf0 extends Fragment {

    /* renamed from: W0, reason: from kotlin metadata */
    protected AbstractC4177Ea0 basePresenter;

    /* renamed from: X0, reason: from kotlin metadata */
    private boolean unbindOnPause;

    /* renamed from: Y0, reason: from kotlin metadata */
    private boolean unSubscribeOnPause;

    /* renamed from: Z0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binder = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vf0
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C23278wf0.w8();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20919sp4 w8() {
        return new C20919sp4();
    }

    private final C20919sp4 x8() {
        return (C20919sp4) this.binder.getValue();
    }

    protected final void A8(boolean z) {
        this.unSubscribeOnPause = z;
    }

    protected final void B8(boolean z) {
        this.unbindOnPause = z;
    }

    public final void C8() {
        x8().d0();
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        if (!this.unbindOnPause) {
            x8().d0();
        }
        AbstractC4177Ea0 abstractC4177Ea0 = this.basePresenter;
        if (abstractC4177Ea0 != null) {
            AbstractC13042fc3.f(abstractC4177Ea0);
            abstractC4177Ea0.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        if (this.unbindOnPause) {
            x8().d0();
        } else if (this.unSubscribeOnPause) {
            x8().b0();
        }
        AbstractC4177Ea0 abstractC4177Ea0 = this.basePresenter;
        if (abstractC4177Ea0 != null) {
            AbstractC13042fc3.f(abstractC4177Ea0);
            abstractC4177Ea0.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        if (this.unSubscribeOnPause) {
            x8().Y();
        }
    }

    public final C20919sp4.b s8(C19482qQ7 value, InterfaceC14756iQ7 listener) {
        C20919sp4.b bVarR = x8().r(value, listener);
        AbstractC13042fc3.h(bVarR, "bind(...)");
        return bVarR;
    }

    public final void t8(C19482qQ7 value1, C19482qQ7 value2, C19482qQ7 value3, C19482qQ7 value4, CQ7 listener) {
        x8().v(value1, value2, value3, value4, listener);
    }

    public final C20919sp4.b[] u8(C19482qQ7 value1, C19482qQ7 value2, InterfaceC16527lQ7 listener) {
        C20919sp4.b[] bVarArrY = x8().y(value1, value2, listener);
        AbstractC13042fc3.h(bVarArrY, "bind(...)");
        return bVarArrY;
    }

    public final void v8(TextView textView, ImageView imageView, PI7 userPresence) {
        Context context;
        AbstractC13042fc3.i(userPresence, "userPresence");
        if (textView == null || (context = textView.getContext()) == null) {
            context = imageView != null ? imageView.getContext() : null;
            if (context == null) {
                return;
            }
        }
        String strY = C14593iA1.y(context, userPresence, false, 4, null);
        if (userPresence.u() == PI7.a.ONLINE) {
            if (textView != null) {
                textView.setTextColor(C5495Jo7.a.e2());
            }
            if (imageView != null) {
                imageView.setImageResource(KB5.ic_online_circle);
            }
        } else {
            if (textView != null) {
                textView.setTextColor(C5495Jo7.a.n0());
            }
            if (imageView != null) {
                imageView.setImageResource(KB5.ic_online_circle_gray);
            }
        }
        if (textView != null) {
            textView.setText(strY);
        }
    }

    /* renamed from: y8, reason: from getter */
    protected final boolean getUnSubscribeOnPause() {
        return this.unSubscribeOnPause;
    }

    /* renamed from: z8, reason: from getter */
    protected final boolean getUnbindOnPause() {
        return this.unbindOnPause;
    }
}
