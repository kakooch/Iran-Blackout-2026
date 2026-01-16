package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.TrackGroup;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC20563sD5;
import ir.nasim.C6241Mt7;
import ir.nasim.InterfaceC4355Et7;
import ir.nasim.OF1;
import ir.nasim.XC5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TrackSelectionView extends LinearLayout {
    private final int a;
    private final LayoutInflater b;
    private final CheckedTextView c;
    private final CheckedTextView d;
    private final b e;
    private final List f;
    private final Map g;
    private boolean h;
    private boolean i;
    private InterfaceC4355Et7 j;
    private CheckedTextView[][] k;
    private boolean l;
    private Comparator m;

    private class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.c(view);
        }
    }

    private static final class c {
        public final K0.a a;
        public final int b;

        public c(K0.a aVar, int i) {
            this.a = aVar;
            this.b = i;
        }

        public X a() {
            return this.a.d(this.b);
        }
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public static Map b(Map map, List list, boolean z) {
        HashMap map2 = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            C6241Mt7 c6241Mt7 = (C6241Mt7) map.get(((K0.a) list.get(i)).c());
            if (c6241Mt7 != null && (z || map2.isEmpty())) {
                map2.put(c6241Mt7.a, c6241Mt7);
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        if (view == this.c) {
            e();
        } else if (view == this.d) {
            d();
        } else {
            f(view);
        }
        i();
    }

    private void d() {
        this.l = false;
        this.g.clear();
    }

    private void e() {
        this.l = true;
        this.g.clear();
    }

    private void f(View view) {
        this.l = false;
        c cVar = (c) AbstractC20011rK.e(view.getTag());
        TrackGroup trackGroupC = cVar.a.c();
        int i = cVar.b;
        C6241Mt7 c6241Mt7 = (C6241Mt7) this.g.get(trackGroupC);
        if (c6241Mt7 == null) {
            if (!this.i && this.g.size() > 0) {
                this.g.clear();
            }
            this.g.put(trackGroupC, new C6241Mt7(trackGroupC, AbstractC12710f43.W(Integer.valueOf(i))));
            return;
        }
        ArrayList arrayList = new ArrayList(c6241Mt7.b);
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zG = g(cVar.a);
        boolean z = zG || h();
        if (zIsChecked && z) {
            arrayList.remove(Integer.valueOf(i));
            if (arrayList.isEmpty()) {
                this.g.remove(trackGroupC);
                return;
            } else {
                this.g.put(trackGroupC, new C6241Mt7(trackGroupC, arrayList));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (!zG) {
            this.g.put(trackGroupC, new C6241Mt7(trackGroupC, AbstractC12710f43.W(Integer.valueOf(i))));
        } else {
            arrayList.add(Integer.valueOf(i));
            this.g.put(trackGroupC, new C6241Mt7(trackGroupC, arrayList));
        }
    }

    private boolean g(K0.a aVar) {
        return this.h && aVar.f();
    }

    private boolean h() {
        return this.i && this.f.size() > 1;
    }

    private void i() {
        this.c.setChecked(this.l);
        this.d.setChecked(!this.l && this.g.size() == 0);
        for (int i = 0; i < this.k.length; i++) {
            C6241Mt7 c6241Mt7 = (C6241Mt7) this.g.get(((K0.a) this.f.get(i)).c());
            int i2 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.k[i];
                if (i2 < checkedTextViewArr.length) {
                    if (c6241Mt7 != null) {
                        this.k[i][i2].setChecked(c6241Mt7.b.contains(Integer.valueOf(((c) AbstractC20011rK.e(checkedTextViewArr[i2].getTag())).b)));
                    } else {
                        checkedTextViewArr[i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    private void j() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f.isEmpty()) {
            this.c.setEnabled(false);
            this.d.setEnabled(false);
            return;
        }
        this.c.setEnabled(true);
        this.d.setEnabled(true);
        this.k = new CheckedTextView[this.f.size()][];
        boolean zH = h();
        for (int i = 0; i < this.f.size(); i++) {
            K0.a aVar = (K0.a) this.f.get(i);
            boolean zG = g(aVar);
            CheckedTextView[][] checkedTextViewArr = this.k;
            int i2 = aVar.a;
            checkedTextViewArr[i] = new CheckedTextView[i2];
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < aVar.a; i3++) {
                cVarArr[i3] = new c(aVar, i3);
            }
            Comparator comparator = this.m;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                if (i4 == 0) {
                    addView(this.b.inflate(XC5.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.b.inflate((zG || zH) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.a);
                checkedTextView.setText(this.j.a(cVarArr[i4].a()));
                checkedTextView.setTag(cVarArr[i4]);
                if (aVar.i(i4)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.k[i][i4] = checkedTextView;
                addView(checkedTextView);
            }
        }
        i();
    }

    public boolean getIsDisabled() {
        return this.l;
    }

    public Map<TrackGroup, C6241Mt7> getOverrides() {
        return this.g;
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.h != z) {
            this.h = z;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.i != z) {
            this.i = z;
            if (!z && this.g.size() > 1) {
                Map mapB = b(this.g, this.f, false);
                this.g.clear();
                this.g.putAll(mapB);
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(InterfaceC4355Et7 interfaceC4355Et7) {
        this.j = (InterfaceC4355Et7) AbstractC20011rK.e(interfaceC4355Et7);
        j();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.b = layoutInflaterFrom;
        b bVar = new b();
        this.e = bVar;
        this.j = new OF1(getResources());
        this.f = new ArrayList();
        this.g = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(AbstractC20563sD5.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(XC5.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(AbstractC20563sD5.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
