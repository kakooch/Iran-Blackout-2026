package ir.nasim;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.settings.component.AutoDownloadSeekBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lir/nasim/DS;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/kz2;", "h1", "Lir/nasim/kz2;", "binding", "", "Landroid/widget/CheckBox;", "i1", "Ljava/util/List;", "checkBoxes", "Lir/nasim/core/modules/settings/SettingsModule;", "j1", "Lir/nasim/core/modules/settings/SettingsModule;", "ea", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class DS extends PV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private C16268kz2 binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private List checkBoxes;

    /* renamed from: j1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().k6(!ds.ea().l5());
        checkBox.setChecked(ds.ea().l5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().l6(!ds.ea().m5());
        checkBox.setChecked(ds.ea().m5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().i6(!ds.ea().j5());
        checkBox.setChecked(ds.ea().j5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().j6(!ds.ea().k5());
        checkBox.setChecked(ds.ea().k5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().r6(!ds.ea().s5());
        checkBox.setChecked(ds.ea().s5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().p6(!ds.ea().q5());
        checkBox.setChecked(ds.ea().q5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().m6(!ds.ea().n5());
        checkBox.setChecked(ds.ea().n5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(DS ds, CompoundButton compoundButton, boolean z) {
        boolean z2;
        AbstractC13042fc3.i(ds, "this$0");
        List list = ds.checkBoxes;
        C16268kz2 c16268kz2 = null;
        if (list == null) {
            AbstractC13042fc3.y("checkBoxes");
            list = null;
        }
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z2 = false;
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((CheckBox) it.next()).isChecked()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        C16268kz2 c16268kz22 = ds.binding;
        if (c16268kz22 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16268kz2 = c16268kz22;
        }
        LinearLayout linearLayout = c16268kz2.c;
        AbstractC13042fc3.h(linearLayout, "autoDownloadConfig");
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().q6(!ds.ea().r5());
        checkBox.setChecked(ds.ea().r5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().n6(!ds.ea().o5());
        checkBox.setChecked(ds.ea().o5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(DS ds, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(ds, "this$0");
        AbstractC13042fc3.i(checkBox, "$this_apply");
        ds.ea().o6(!ds.ea().p5());
        checkBox.setChecked(ds.ea().p5());
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C16731lm1 c16731lm1 = new C16731lm1(G5(), AbstractC23035wE5.Theme_Bale_Base);
        int iB = OY0.b(c16731lm1, AbstractC21139tA5.colorPrimary);
        C16268kz2 c16268kz2C = C16268kz2.c(Q5(), container, false);
        this.binding = c16268kz2C;
        C16268kz2 c16268kz2 = null;
        if (c16268kz2C == null) {
            AbstractC13042fc3.y("binding");
            c16268kz2C = null;
        }
        BaleToolbar baleToolbar = c16268kz2C.n;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        FrameLayout frameLayout = c16268kz2C.v;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        frameLayout.setBackgroundColor(c5495Jo7.o());
        c16268kz2C.t.setTextColor(iB);
        c16268kz2C.i.setTextColor(iB);
        c16268kz2C.k.setTextColor(iB);
        c16268kz2C.t.setBackgroundColor(c5495Jo7.O0());
        c16268kz2C.i.setBackgroundColor(c5495Jo7.O0());
        c16268kz2C.k.setBackgroundColor(c5495Jo7.O0());
        c16268kz2C.p.setBackgroundColor(c5495Jo7.O0());
        c16268kz2C.e.setBackgroundColor(c5495Jo7.O0());
        c16268kz2C.c.setBackgroundColor(c5495Jo7.O0());
        C16268kz2 c16268kz22 = this.binding;
        if (c16268kz22 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz22 = null;
        }
        final CheckBox checkBox = c16268kz22.s;
        checkBox.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox.setChecked(ea().q5());
        checkBox.setTextColor(c5495Jo7.g1());
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.ka(this.a, checkBox, view);
            }
        });
        C16268kz2 c16268kz23 = this.binding;
        if (c16268kz23 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz23 = null;
        }
        final CheckBox checkBox2 = c16268kz23.u;
        checkBox2.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox2.setChecked(ea().r5());
        checkBox2.setTextColor(c5495Jo7.g1());
        checkBox2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.na(this.a, checkBox2, view);
            }
        });
        C16268kz2 c16268kz24 = this.binding;
        if (c16268kz24 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz24 = null;
        }
        final CheckBox checkBox3 = c16268kz24.q;
        checkBox3.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox3.setChecked(ea().o5());
        checkBox3.setTextColor(c5495Jo7.g1());
        checkBox3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.oa(this.a, checkBox3, view);
            }
        });
        C16268kz2 c16268kz25 = this.binding;
        if (c16268kz25 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz25 = null;
        }
        final CheckBox checkBox4 = c16268kz25.r;
        checkBox4.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox4.setVisibility(0);
        checkBox4.setChecked(ea().p5());
        checkBox4.setTextColor(c5495Jo7.g1());
        checkBox4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.pa(this.a, checkBox4, view);
            }
        });
        C16268kz2 c16268kz26 = this.binding;
        if (c16268kz26 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz26 = null;
        }
        final CheckBox checkBox5 = c16268kz26.h;
        checkBox5.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox5.setChecked(ea().l5());
        checkBox5.setTextColor(c5495Jo7.g1());
        checkBox5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.fa(this.a, checkBox5, view);
            }
        });
        C16268kz2 c16268kz27 = this.binding;
        if (c16268kz27 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz27 = null;
        }
        final CheckBox checkBox6 = c16268kz27.j;
        checkBox6.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox6.setChecked(ea().m5());
        checkBox6.setTextColor(c5495Jo7.g1());
        checkBox6.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.ga(this.a, checkBox6, view);
            }
        });
        C16268kz2 c16268kz28 = this.binding;
        if (c16268kz28 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz28 = null;
        }
        final CheckBox checkBox7 = c16268kz28.f;
        checkBox7.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox7.setChecked(ea().j5());
        checkBox7.setTextColor(c5495Jo7.g1());
        checkBox7.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.AS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.ha(this.a, checkBox7, view);
            }
        });
        C16268kz2 c16268kz29 = this.binding;
        if (c16268kz29 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz29 = null;
        }
        final CheckBox checkBox8 = c16268kz29.g;
        checkBox8.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox8.setVisibility(0);
        checkBox8.setChecked(ea().k5());
        checkBox8.setTextColor(c5495Jo7.g1());
        checkBox8.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.ia(this.a, checkBox8, view);
            }
        });
        final CheckBox checkBox9 = new CheckBox(c16731lm1);
        checkBox9.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox9.setChecked(ea().s5());
        checkBox9.setTextColor(c5495Jo7.g1());
        checkBox9.setText(checkBox9.getResources().getString(AbstractC12217eE5.media_audio));
        checkBox9.setGravity(16);
        checkBox9.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.ja(this.a, checkBox9, view);
            }
        });
        C16268kz2 c16268kz210 = this.binding;
        if (c16268kz210 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz210 = null;
        }
        c16268kz210.p.addView(checkBox9);
        ViewGroup.LayoutParams layoutParams = checkBox9.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(C22078ud6.a(8.0f), 0, C22078ud6.a(8.0f), 0);
        checkBox9.setLayoutParams(marginLayoutParams);
        final CheckBox checkBox10 = new CheckBox(c16731lm1);
        checkBox10.setButtonTintList(ColorStateList.valueOf(iB));
        checkBox10.setChecked(ea().n5());
        checkBox10.setTextColor(c5495Jo7.g1());
        checkBox10.setText(checkBox10.getResources().getString(AbstractC12217eE5.media_audio));
        checkBox10.setGravity(16);
        checkBox10.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tS
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DS.la(this.a, checkBox10, view);
            }
        });
        C16268kz2 c16268kz211 = this.binding;
        if (c16268kz211 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz211 = null;
        }
        c16268kz211.e.addView(checkBox10);
        ViewGroup.LayoutParams layoutParams2 = checkBox10.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.setMargins(C22078ud6.a(8.0f), 0, C22078ud6.a(8.0f), 0);
        checkBox10.setLayoutParams(marginLayoutParams2);
        C16268kz2 c16268kz212 = this.binding;
        if (c16268kz212 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz212 = null;
        }
        c16268kz212.o.setVisibility(8);
        C16268kz2 c16268kz213 = this.binding;
        if (c16268kz213 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz213 = null;
        }
        LinearLayout linearLayout = c16268kz213.e;
        AbstractC13042fc3.h(linearLayout, "autoDownloadData");
        List listK = AbstractC11342cq6.K(AbstractC24379yW7.b(linearLayout));
        LinearLayout linearLayout2 = c16268kz213.p;
        AbstractC13042fc3.h(linearLayout2, "autoDownloadWifi");
        List listR0 = AbstractC15401jX0.R0(listK, AbstractC11342cq6.K(AbstractC24379yW7.b(linearLayout2)));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR0) {
            if (obj instanceof CheckBox) {
                arrayList.add(obj);
            }
        }
        this.checkBoxes = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CheckBox) it.next()).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.uS
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DS.ma(this.a, compoundButton, z);
                }
            });
        }
        int iD0 = AbstractC5969Lp4.e().S().D0();
        int iB0 = AbstractC5969Lp4.e().S().B0();
        int iC0 = AbstractC5969Lp4.e().S().C0();
        int i = iC0 - iD0;
        C16268kz2 c16268kz214 = this.binding;
        if (c16268kz214 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz214 = null;
        }
        Integer numValueOf = Integer.valueOf(c16268kz214.y.getMax());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        boolean z = true;
        int iIntValue = i / (numValueOf != null ? numValueOf.intValue() : 1);
        C16268kz2 c16268kz215 = this.binding;
        if (c16268kz215 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz215 = null;
        }
        TextView textView = c16268kz215.m;
        C5495Jo7 c5495Jo72 = C5495Jo7.a;
        textView.setTextColor(c5495Jo72.g1());
        textView.setText(XY6.v(iD0 + "MB"));
        C16268kz2 c16268kz216 = this.binding;
        if (c16268kz216 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz216 = null;
        }
        TextView textView2 = c16268kz216.d;
        textView2.setTextColor(c5495Jo72.g1());
        textView2.setText(XY6.v(iB0 + "MB"));
        C16268kz2 c16268kz217 = this.binding;
        if (c16268kz217 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz217 = null;
        }
        AutoDownloadSeekBar autoDownloadSeekBar = c16268kz217.y;
        autoDownloadSeekBar.setProgress(Integer.min(autoDownloadSeekBar.getMax(), (iB0 - iD0) / iIntValue));
        autoDownloadSeekBar.setOnSeekBarChangeListener(new a(iD0, iIntValue, this));
        C16268kz2 c16268kz218 = this.binding;
        if (c16268kz218 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz218 = null;
        }
        TextView textView3 = c16268kz218.l;
        textView3.setTextColor(c5495Jo72.g1());
        textView3.setText(XY6.v(iC0 + "MB"));
        List list = this.checkBoxes;
        if (list == null) {
            AbstractC13042fc3.y("checkBoxes");
            list = null;
        }
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z = false;
        } else {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((CheckBox) it2.next()).isChecked()) {
                    break;
                }
            }
            z = false;
        }
        C16268kz2 c16268kz219 = this.binding;
        if (c16268kz219 == null) {
            AbstractC13042fc3.y("binding");
            c16268kz219 = null;
        }
        LinearLayout linearLayout3 = c16268kz219.c;
        AbstractC13042fc3.h(linearLayout3, "autoDownloadConfig");
        linearLayout3.setVisibility(z ? 0 : 8);
        C16268kz2 c16268kz220 = this.binding;
        if (c16268kz220 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16268kz2 = c16268kz220;
        }
        LinearLayout root = c16268kz2.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final SettingsModule ea() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ DS c;

        a(int i, int i2, DS ds) {
            this.a = i;
            this.b = i2;
            this.c = ds;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int i2 = this.a + (i * this.b);
            if (z) {
                AbstractC5969Lp4.e().S().h6(i2);
            }
            C16268kz2 c16268kz2 = this.c.binding;
            if (c16268kz2 == null) {
                AbstractC13042fc3.y("binding");
                c16268kz2 = null;
            }
            c16268kz2.d.setText(XY6.v(i2 + "MB"));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
