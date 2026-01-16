package ir.nasim.tgwidgets.editor.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSlider;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSubItem;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.C21506a;
import ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout;

/* renamed from: ir.nasim.tgwidgets.editor.ui.a, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21506a {
    ActionBarPopupWindow.ActionBarPopupWindowLayout a;
    ActionBarMenuSlider.SpeedSlider b;
    ActionBarMenuSubItem[] c = new ActionBarMenuSubItem[5];

    /* renamed from: ir.nasim.tgwidgets.editor.ui.a$a, reason: collision with other inner class name */
    class C1596a extends FrameLayout {
        C1596a(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.a$b */
    class b extends FrameLayout {
        b(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.a$c */
    public interface c {
        void a(float f, boolean z, boolean z2);
    }

    public C21506a(Context context, final PopupSwipeBackLayout popupSwipeBackLayout, final c cVar) {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(context, 0, null);
        this.a = actionBarPopupWindowLayout;
        actionBarPopupWindowLayout.setFitItems(true);
        ActionBarMenuSubItem actionBarMenuSubItemD = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_arrow_back, FH3.E("Back", TD5.tgwidget_Back), false, null);
        actionBarMenuSubItemD.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                popupSwipeBackLayout.s();
            }
        });
        actionBarMenuSubItemD.d(-328966, -328966);
        actionBarMenuSubItemD.setSelectorColor(268435455);
        C1596a c1596a = new C1596a(context);
        c1596a.setMinimumWidth(AbstractC21455b.F(196.0f));
        c1596a.setBackgroundColor(-15198184);
        this.a.addView(c1596a);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1596a.getLayoutParams();
        if (FH3.D) {
            layoutParams.gravity = 5;
        }
        layoutParams.width = -1;
        layoutParams.height = AbstractC21455b.F(8.0f);
        c1596a.setLayoutParams(layoutParams);
        ActionBarMenuSlider.SpeedSlider speedSlider = new ActionBarMenuSlider.SpeedSlider(context, null);
        this.b = speedSlider;
        speedSlider.setMinimumWidth(AbstractC21455b.F(196.0f));
        this.b.setDrawShadow(false);
        this.b.setBackgroundColor(-14540254);
        this.b.setTextColor(-1);
        this.b.setOnValueChange(new Utilities.a() { // from class: ir.nasim.CT0
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.a
            public final void a(Object obj, Object obj2) {
                C21506a.i(cVar, (Float) obj, (Boolean) obj2);
            }
        });
        this.a.j(this.b, AbstractC13840gu3.g(-1, 44));
        b bVar = new b(context);
        bVar.setMinimumWidth(AbstractC21455b.F(196.0f));
        bVar.setBackgroundColor(-15198184);
        this.a.addView(bVar);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.getLayoutParams();
        if (FH3.D) {
            layoutParams2.gravity = 5;
        }
        layoutParams2.width = -1;
        layoutParams2.height = AbstractC21455b.F(8.0f);
        bVar.setLayoutParams(layoutParams2);
        ActionBarMenuSubItem actionBarMenuSubItemD2 = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_speed_0_2, FH3.E("SpeedVerySlow", TD5.tgwidget_SpeedVerySlow), false, null);
        actionBarMenuSubItemD2.d(-328966, -328966);
        actionBarMenuSubItemD2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a(0.2f, true, true);
            }
        });
        actionBarMenuSubItemD2.setSelectorColor(268435455);
        this.c[0] = actionBarMenuSubItemD2;
        ActionBarMenuSubItem actionBarMenuSubItemD3 = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_speed_slow, FH3.E("SpeedSlow", TD5.tgwidget_SpeedSlow), false, null);
        actionBarMenuSubItemD3.d(-328966, -328966);
        actionBarMenuSubItemD3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ET0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a(0.5f, true, true);
            }
        });
        actionBarMenuSubItemD3.setSelectorColor(268435455);
        this.c[1] = actionBarMenuSubItemD3;
        ActionBarMenuSubItem actionBarMenuSubItemD4 = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_speed_normal, FH3.E("SpeedNormal", TD5.tgwidget_SpeedNormal), false, null);
        actionBarMenuSubItemD4.d(-328966, -328966);
        actionBarMenuSubItemD4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a(1.0f, true, true);
            }
        });
        actionBarMenuSubItemD4.setSelectorColor(268435455);
        this.c[2] = actionBarMenuSubItemD4;
        ActionBarMenuSubItem actionBarMenuSubItemD5 = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_speed_fast, FH3.E("SpeedFast", TD5.tgwidget_SpeedFast), false, null);
        actionBarMenuSubItemD5.d(-328966, -328966);
        actionBarMenuSubItemD5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a(1.5f, true, true);
            }
        });
        actionBarMenuSubItemD5.setSelectorColor(268435455);
        this.c[3] = actionBarMenuSubItemD5;
        ActionBarMenuSubItem actionBarMenuSubItemD6 = ActionBarMenuItem.D(this.a, AbstractC23598xB5.msg_speed_superfast, FH3.E("SpeedVeryFast", TD5.tgwidget_SpeedVeryFast), false, null);
        actionBarMenuSubItemD6.d(-328966, -328966);
        actionBarMenuSubItemD6.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HT0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cVar.a(2.0f, true, true);
            }
        });
        actionBarMenuSubItemD6.setSelectorColor(268435455);
        this.c[4] = actionBarMenuSubItemD6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(c cVar, Float f, Boolean bool) {
        cVar.a((f.floatValue() * 2.3f) + 0.2f, bool.booleanValue(), false);
    }

    public void o(float f, boolean z) {
        for (int i = 0; i < this.c.length; i++) {
            if (!z || ((i != 0 || Math.abs(f - 0.2f) >= 0.01f) && ((i != 1 || Math.abs(f - 0.5f) >= 0.1f) && ((i != 2 || Math.abs(f - 1.0f) >= 0.1f) && ((i != 3 || Math.abs(f - 1.5f) >= 0.1f) && (i != 4 || Math.abs(f - 2.0f) >= 0.1f)))))) {
                this.c[i].d(-328966, -328966);
            } else {
                this.c[i].d(-9718023, -9718023);
            }
        }
        this.b.setSpeed(f, true);
    }
}
