package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.gov.nist.core.Separators;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import ir.nasim.AbstractC4373Ev7;
import ir.nasim.AbstractC8958Xy7;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TransitionSet extends Transition {
    private ArrayList A0;
    private boolean B0;
    int C0;
    boolean D0;
    private int E0;

    class a extends q {
        final /* synthetic */ Transition a;

        a(Transition transition) {
            this.a = transition;
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            this.a.a0();
            transition.W(this);
        }
    }

    static class b extends q {
        TransitionSet a;

        b(TransitionSet transitionSet) {
            this.a = transitionSet;
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void b(Transition transition) {
            TransitionSet transitionSet = this.a;
            if (transitionSet.D0) {
                return;
            }
            transitionSet.j0();
            this.a.D0 = true;
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            TransitionSet transitionSet = this.a;
            int i = transitionSet.C0 - 1;
            transitionSet.C0 = i;
            if (i == 0) {
                transitionSet.D0 = false;
                transitionSet.s();
            }
            transition.W(this);
        }
    }

    public TransitionSet() {
        this.A0 = new ArrayList();
        this.B0 = true;
        this.D0 = false;
        this.E0 = 0;
    }

    private void o0(Transition transition) {
        this.A0.add(transition);
        transition.r = this;
    }

    private void z0() {
        b bVar = new b(this);
        Iterator it = this.A0.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).b(bVar);
        }
        this.C0 = this.A0.size();
    }

    @Override // androidx.transition.Transition
    public void U(View view) {
        super.U(view);
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).U(view);
        }
    }

    @Override // androidx.transition.Transition
    public void Y(View view) {
        super.Y(view);
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).Y(view);
        }
    }

    @Override // androidx.transition.Transition
    protected void a0() {
        if (this.A0.isEmpty()) {
            j0();
            s();
            return;
        }
        z0();
        if (this.B0) {
            Iterator it = this.A0.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).a0();
            }
            return;
        }
        for (int i = 1; i < this.A0.size(); i++) {
            ((Transition) this.A0.get(i - 1)).b(new a((Transition) this.A0.get(i)));
        }
        Transition transition = (Transition) this.A0.get(0);
        if (transition != null) {
            transition.a0();
        }
    }

    @Override // androidx.transition.Transition
    public void c0(Transition.e eVar) {
        super.c0(eVar);
        this.E0 |= 8;
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).c0(eVar);
        }
    }

    @Override // androidx.transition.Transition
    protected void cancel() {
        super.cancel();
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void g0(PathMotion pathMotion) {
        super.g0(pathMotion);
        this.E0 |= 4;
        if (this.A0 != null) {
            for (int i = 0; i < this.A0.size(); i++) {
                ((Transition) this.A0.get(i)).g0(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void h0(AbstractC4373Ev7 abstractC4373Ev7) {
        super.h0(abstractC4373Ev7);
        this.E0 |= 2;
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).h0(abstractC4373Ev7);
        }
    }

    @Override // androidx.transition.Transition
    public void i(t tVar) {
        if (K(tVar.b)) {
            Iterator it = this.A0.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.K(tVar.b)) {
                    transition.i(tVar);
                    tVar.c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    String k0(String str) {
        String strK0 = super.k0(str);
        for (int i = 0; i < this.A0.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strK0);
            sb.append(Separators.RETURN);
            sb.append(((Transition) this.A0.get(i)).k0(str + "  "));
            strK0 = sb.toString();
        }
        return strK0;
    }

    @Override // androidx.transition.Transition
    void l(t tVar) {
        super.l(tVar);
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.A0.get(i)).l(tVar);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public TransitionSet b(Transition.f fVar) {
        return (TransitionSet) super.b(fVar);
    }

    @Override // androidx.transition.Transition
    public void m(t tVar) {
        if (K(tVar.b)) {
            Iterator it = this.A0.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.K(tVar.b)) {
                    transition.m(tVar);
                    tVar.c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public TransitionSet c(View view) {
        for (int i = 0; i < this.A0.size(); i++) {
            ((Transition) this.A0.get(i)).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    public TransitionSet n0(Transition transition) {
        o0(transition);
        long j = this.c;
        if (j >= 0) {
            transition.b0(j);
        }
        if ((this.E0 & 1) != 0) {
            transition.e0(w());
        }
        if ((this.E0 & 2) != 0) {
            transition.h0(z());
        }
        if ((this.E0 & 4) != 0) {
            transition.g0(y());
        }
        if ((this.E0 & 8) != 0) {
            transition.c0(v());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.A0 = new ArrayList();
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            transitionSet.o0(((Transition) this.A0.get(i)).clone());
        }
        return transitionSet;
    }

    public Transition p0(int i) {
        if (i < 0 || i >= this.A0.size()) {
            return null;
        }
        return (Transition) this.A0.get(i);
    }

    public int q0() {
        return this.A0.size();
    }

    @Override // androidx.transition.Transition
    protected void r(ViewGroup viewGroup, u uVar, u uVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jB = B();
        int size = this.A0.size();
        for (int i = 0; i < size; i++) {
            Transition transition = (Transition) this.A0.get(i);
            if (jB > 0 && (this.B0 || i == 0)) {
                long jB2 = transition.B();
                if (jB2 > 0) {
                    transition.i0(jB2 + jB);
                } else {
                    transition.i0(jB);
                }
            }
            transition.r(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public TransitionSet W(Transition.f fVar) {
        return (TransitionSet) super.W(fVar);
    }

    @Override // androidx.transition.Transition
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public TransitionSet X(View view) {
        for (int i = 0; i < this.A0.size(); i++) {
            ((Transition) this.A0.get(i)).X(view);
        }
        return (TransitionSet) super.X(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public TransitionSet b0(long j) {
        ArrayList arrayList;
        super.b0(j);
        if (this.c >= 0 && (arrayList = this.A0) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.A0.get(i)).b0(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public TransitionSet e0(TimeInterpolator timeInterpolator) {
        this.E0 |= 1;
        ArrayList arrayList = this.A0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.A0.get(i)).e0(timeInterpolator);
            }
        }
        return (TransitionSet) super.e0(timeInterpolator);
    }

    public TransitionSet w0(int i) {
        if (i == 0) {
            this.B0 = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.B0 = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public TransitionSet i0(long j) {
        return (TransitionSet) super.i0(j);
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A0 = new ArrayList();
        this.B0 = true;
        this.D0 = false;
        this.E0 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.i);
        w0(AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
