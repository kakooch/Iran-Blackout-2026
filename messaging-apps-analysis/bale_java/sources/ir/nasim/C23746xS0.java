package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.ClickableSpan;
import android.view.View;
import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.xS0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23746xS0 implements InterfaceC24357yU3.c {
    private final Context a;
    private final InterfaceC20315ro1 b;
    private final E84 c;
    private final SettingsModule d;
    private final C10299bQ2 e;

    /* renamed from: ir.nasim.xS0$a */
    public static final class a extends ClickableSpan {
        final /* synthetic */ C23156wS0 a;
        final /* synthetic */ C23746xS0 b;

        /* renamed from: ir.nasim.xS0$a$a, reason: collision with other inner class name */
        static final class C1771a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C23746xS0 c;
            final /* synthetic */ C23156wS0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1771a(C23746xS0 c23746xS0, C23156wS0 c23156wS0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c23746xS0;
                this.d = c23156wS0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1771a(this.c, this.d, interfaceC20295rm1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
            
                if (r8.c.h(r9) == true) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    Method dump skipped, instructions count: 385
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23746xS0.a.C1771a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1771a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(C23156wS0 c23156wS0, C23746xS0 c23746xS0) {
            this.a = c23156wS0;
            this.b = c23746xS0;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            if (this.a.o() == null || this.a.n() == null) {
                return;
            }
            AbstractC10533bm0.d(this.b.b, null, null, new C1771a(this.b, this.a, null), 3, null);
        }
    }

    public C23746xS0(Context context, InterfaceC20315ro1 interfaceC20315ro1, E84 e84, SettingsModule settingsModule, C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = context;
        this.b = interfaceC20315ro1;
        this.c = e84;
        this.d = settingsModule;
        this.e = c10299bQ2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(C11907dl c11907dl) {
        int i;
        List listR = c11907dl.r();
        if ((listR instanceof Collection) && listR.isEmpty()) {
            i = 0;
        } else {
            Iterator it = listR.iterator();
            i = 0;
            while (it.hasNext()) {
                C23345wl7 c23345wl7L = ((J44) it.next()).F().l();
                String strV = c23345wl7L != null ? c23345wl7L.v() : null;
                if ((!(strV == null || strV.length() == 0)) && (i = i + 1) < 0) {
                    AbstractC10360bX0.v();
                }
            }
        }
        return i <= 1;
    }

    private final a i(C23156wS0 c23156wS0) {
        return new a(c23156wS0, this);
    }

    private final C12109e33 j(C23156wS0 c23156wS0) {
        Drawable drawableF = AbstractC4043Dl1.f(this.a, c23156wS0.m() ? KB5.tick_square_check : KB5.ic_checkbox_unchecked);
        if (drawableF != null) {
            drawableF.setBounds(0, 0, drawableF.getIntrinsicWidth() - AbstractC8943Xx1.c(2), drawableF.getIntrinsicHeight() - AbstractC8943Xx1.c(2));
        } else {
            drawableF = null;
        }
        if (drawableF != null) {
            return new C12109e33(drawableF, -(AbstractC8943Xx1.c(1) * 12));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final J44 k(J44 j44) {
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.AlbumContent");
        List listR = ((C11907dl) abstractC17457n0F).r();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Object obj : listR) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            C23345wl7 c23345wl7L = ((J44) obj).F().l();
            String strV = c23345wl7L != null ? c23345wl7L.v() : null;
            if (strV != null && strV.length() != 0) {
                i3++;
                if (i3 > 1) {
                    return null;
                }
                i = i2;
            }
            i2 = i4;
        }
        return (J44) listR.get(i);
    }

    @Override // ir.nasim.InterfaceC24357yU3.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(InterfaceC24357yU3 interfaceC24357yU3, C23156wS0 c23156wS0) {
        AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
        AbstractC13042fc3.i(c23156wS0, "node");
        C15272jI6 c15272jI6M = interfaceC24357yU3.m();
        AbstractC13042fc3.h(c15272jI6M, "builder(...)");
        C12109e33 c12109e33J = j(c23156wS0);
        a aVarI = i(c23156wS0);
        int length = c15272jI6M.length();
        c15272jI6M.d("-");
        int length2 = c15272jI6M.length();
        if (c12109e33J != null) {
            c15272jI6M.j(aVarI, length, length2, 33);
            c15272jI6M.j(c12109e33J, length, length2, 33);
        }
    }
}
