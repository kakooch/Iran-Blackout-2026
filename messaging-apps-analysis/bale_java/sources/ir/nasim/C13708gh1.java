package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: ir.nasim.gh1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13708gh1 extends AbstractC21435tf0 {
    private final HashSet g;
    private final InterfaceC22483vJ4 h;
    private boolean i;
    private boolean j;
    private final Context k;
    private String l;
    private int m;

    public C13708gh1(C19024pf0 c19024pf0, Context context, boolean z, int i, InterfaceC22483vJ4 interfaceC22483vJ4, boolean z2) {
        super(c19024pf0, true);
        this.g = new HashSet();
        this.l = "";
        this.k = context;
        this.i = z;
        this.h = interfaceC22483vJ4;
        this.m = i;
        this.j = z2;
    }

    private String J(String str) {
        return (str.length() <= 1 || !Character.isLetter(str.charAt(0))) ? Separators.POUND : str.substring(0, 1).toUpperCase(Locale.getDefault());
    }

    private boolean L(C3512Be1 c3512Be1) {
        if (this.m != -1) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c3512Be1.r());
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(this.m);
            if (c14733iO2 != null && c14733iO2.t().b() != null) {
                Iterator it = ((HashSet) c14733iO2.t().b()).iterator();
                while (it.hasNext()) {
                    C23104wM2 c23104wM2 = (C23104wM2) it.next();
                    if (c21231tK7 != null && c23104wM2.f() == c21231tK7.o()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Integer[] K() {
        HashSet hashSet = this.g;
        return (Integer[]) hashSet.toArray(new Integer[hashSet.size()]);
    }

    public boolean M(int i) {
        return this.g.contains(Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(ir.nasim.C11849df1 r9, int r10, ir.nasim.C3512Be1 r11) {
        /*
            r8 = this;
            if (r10 != 0) goto Lc
            java.lang.String r0 = r11.getName()
            java.lang.String r0 = r8.J(r0)
        La:
            r3 = r0
            goto L2e
        Lc:
            int r0 = r10 + (-1)
            ir.nasim.nl0 r0 = r8.C(r0)
            ir.nasim.Be1 r0 = (ir.nasim.C3512Be1) r0
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r8.J(r0)
            java.lang.String r1 = r11.getName()
            java.lang.String r1 = r8.J(r1)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2c
            r3 = r1
            goto L2e
        L2c:
            r0 = 0
            goto La
        L2e:
            java.lang.String r4 = r8.l
            java.util.HashSet r0 = r8.g
            int r1 = r11.r()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r5 = r0.contains(r1)
            int r0 = r8.getItemCount()
            r1 = 1
            int r0 = r0 - r1
            if (r10 != r0) goto L48
            r6 = r1
            goto L4a
        L48:
            r10 = 0
            r6 = r10
        L4a:
            boolean r7 = r8.L(r11)
            r1 = r9
            r2 = r11
            r1.J0(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13708gh1.G(ir.nasim.df1, int, ir.nasim.Be1):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public C11849df1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C11849df1(new FrameLayout(this.k), this.i, this.k, this.h, this.j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(C11849df1 c11849df1) {
        super.onViewAttachedToWindow(c11849df1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C11849df1 c11849df1) {
        c11849df1.a();
    }

    public void R(int i) {
        this.g.add(Integer.valueOf(i));
    }

    public void S(String str) {
        this.l = str;
        notifyDataSetChanged();
    }

    public void T(int i) {
        this.g.remove(Integer.valueOf(i));
    }

    public int getSelectedCount() {
        return this.g.size();
    }
}
