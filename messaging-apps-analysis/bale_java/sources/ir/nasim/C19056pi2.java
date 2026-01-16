package ir.nasim;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C23345wl7;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.pi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19056pi2 extends JA2 {
    public static final a O0 = new a(null);
    public static final int P0 = 8;
    private final C11258ci2 M0;
    private AbstractC15520jj2.f N0;

    /* renamed from: ir.nasim.pi2$a */
    public static final class a {
        private a() {
        }

        public final C19056pi2 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2, O98 o98) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11258ci2 c11258ci2C = C11258ci2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11258ci2C, "inflate(...)");
            return new C19056pi2(c11258ci2C, interfaceC13138fj2, o98);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19056pi2(C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2, O98 o98) {
        super(o98, c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.M0 = c11258ci2;
        TextView textView = l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        textView.setVisibility(8);
        NestedScrollView nestedScrollView = l1().v;
        AbstractC13042fc3.h(nestedScrollView, "fullScreenTextParent");
        nestedScrollView.setVisibility(0);
        l1().u.setMovementMethod(t1());
        l1().v.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.oi2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C19056pi2.K3(this.a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K3(C19056pi2 c19056pi2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c19056pi2, "this$0");
        C4485Fi2 c4485Fi2Q1 = c19056pi2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2Q1.onTouchEvent(motionEvent);
    }

    public void M3(C5886Lg2 c5886Lg2, AbstractC15520jj2.f fVar) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(fVar, DialogEntity.COLUMN_MESSAGE);
        super.H2(c5886Lg2, fVar);
        this.N0 = fVar;
        l1().u.setText(p1().e(fVar.c()));
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        C23345wl7.a aVar = C23345wl7.g;
        AbstractC15520jj2.f fVar = this.N0;
        if (fVar == null) {
            AbstractC13042fc3.y("feedTextMessage");
            fVar = null;
        }
        return C23345wl7.a.c(aVar, fVar.c(), null, 2, null);
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: l3 */
    public C11258ci2 l1() {
        return this.M0;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.f fVar = this.N0;
        if (fVar == null) {
            AbstractC13042fc3.y("feedTextMessage");
            fVar = null;
        }
        return !(fVar.c().length() == 0);
    }
}
