package ir.nasim;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.snackbar.Snackbar;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.modal.dialog.AlertDialog;

/* renamed from: ir.nasim.Yd3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C9020Yd3 extends C22042ua0 {
    private int c1;
    private boolean d1;
    private boolean e1;
    private ZN2 f1;
    private ListView g1;
    private d h1;
    private String i1;
    private TextView j1;

    /* renamed from: ir.nasim.Yd3$a */
    class a implements InterfaceC15419jZ0 {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C4382Ew7 c4382Ew7) {
            C9020Yd3.this.i1 = (String) c4382Ew7.a();
            C9020Yd3.this.h1.notifyDataSetChanged();
            C9020Yd3 c9020Yd3 = C9020Yd3.this;
            c9020Yd3.d9(c9020Yd3.j1);
            C9020Yd3 c9020Yd32 = C9020Yd3.this;
            c9020Yd32.K9(c9020Yd32.g1);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            Snackbar.i0(this.a, C9020Yd3.this.h6(AbstractC12217eE5.invite_link_error_get_link), -1).W();
            C9020Yd3.this.h1.notifyDataSetChanged();
        }
    }

    /* renamed from: ir.nasim.Yd3$b */
    class b implements InterfaceC15419jZ0 {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C4382Ew7 c4382Ew7) {
            C9020Yd3.this.i1 = (String) c4382Ew7.a();
            C9020Yd3.this.h1.notifyDataSetChanged();
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            Snackbar.i0(this.a, UN2.a(exc, C9020Yd3.this.f1), -1).W();
        }
    }

    /* renamed from: ir.nasim.Yd3$c */
    private class c extends DW7 {
        private TextView b;
        private FrameLayout c;
        private View d;
        private View e;
        private View f;

        @Override // ir.nasim.DW7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(Void r5, int i, Context context) {
            if (i == 0) {
                this.b.setText(C9020Yd3.this.i1);
                this.b.setTextColor(C5495Jo7.a.t2());
            } else if (i == 1) {
                C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(C9020Yd3.this.c1);
                this.b.setText(AbstractC5969Lp4.a(C9020Yd3.this.h6(AbstractC12217eE5.invite_link_hint), c14733iO2 != null ? c14733iO2.q() : ZN2.GROUP).replace("{appName}", C5735Kp4.w().f()));
                this.b.setTextColor(C5495Jo7.a.t2());
            } else if (i == 2) {
                this.b.setText(C9020Yd3.this.h6(AbstractC12217eE5.invite_link_action_copy));
                this.b.setTextColor(C5495Jo7.a.t2());
            } else if (i == 3) {
                this.b.setText(C9020Yd3.this.h6(AbstractC12217eE5.invite_link_action_share));
                this.b.setTextColor(C5495Jo7.a.t2());
            } else if (i == 4) {
                TextView textView = this.b;
                C9020Yd3 c9020Yd3 = C9020Yd3.this;
                textView.setText(c9020Yd3.h6(c9020Yd3.Y9() ? AbstractC12217eE5.invite_link_action_revoke : AbstractC12217eE5.invite_link_action_share));
                this.b.setTextColor(C5495Jo7.a.B0());
            }
            if (i != 1) {
                this.c.setBackgroundColor(0);
                this.d.setVisibility(4);
                this.e.setVisibility(4);
                this.f.setVisibility(0);
                this.b.setTextSize(15.0f);
                return;
            }
            FrameLayout frameLayout = this.c;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            frameLayout.setBackgroundColor(c5495Jo7.j0());
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(4);
            this.b.setTextColor(c5495Jo7.n0());
            this.b.setTextSize(14.0f);
        }

        @Override // ir.nasim.DW7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public View c(Void r3, ViewGroup viewGroup, Context context) {
            View viewInflate = ((Activity) context).getLayoutInflater().inflate(AbstractC12208eD5.fragment_invite_link_item, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(BC5.action);
            this.b = textView;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.g0());
            this.c = (FrameLayout) viewInflate.findViewById(BC5.linksActionContainer);
            this.d = viewInflate.findViewById(BC5.top_shadow);
            this.e = viewInflate.findViewById(BC5.bot_shadow);
            View viewFindViewById = viewInflate.findViewById(BC5.divider);
            this.f = viewFindViewById;
            viewFindViewById.setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
            return viewInflate;
        }

        private c() {
        }
    }

    /* renamed from: ir.nasim.Yd3$d */
    class d extends DY2 {
        d(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.DY2
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public DW7 a(Void r3) {
            return new c();
        }

        @Override // ir.nasim.DY2, android.widget.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return C9020Yd3.this.Y9() ? 5 : 4;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y9() {
        return this.f1 == ZN2.GROUP ? this.e1 || this.d1 : this.e1;
    }

    public static C9020Yd3 Z9(int i, ZN2 zn2, boolean z, boolean z2) {
        C9020Yd3 c9020Yd3 = new C9020Yd3();
        c9020Yd3.c1 = i;
        c9020Yd3.d1 = z;
        c9020Yd3.e1 = z2;
        c9020Yd3.f1 = zn2;
        return c9020Yd3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(View view, DialogInterface dialogInterface, int i) {
        R8(AbstractC5969Lp4.d().w1(this.c1), AbstractC12217eE5.invite_link_action_revoke, new b(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(ClipboardManager clipboardManager, final View view, AdapterView adapterView, View view2, int i, long j) {
        String str = this.i1;
        if (str == null || str.isEmpty()) {
            return;
        }
        if (i == 0) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, this.i1));
            if (KV0.b()) {
                Snackbar.i0(view, h6(AbstractC12217eE5.invite_link_copied), -1).W();
                return;
            }
            return;
        }
        if (i == 2) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, this.i1));
            if (KV0.b()) {
                Snackbar.i0(view, h6(AbstractC12217eE5.invite_link_copied), -1).W();
                return;
            }
            return;
        }
        if (i == 3) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.i1);
            Intent intentCreateChooser = Intent.createChooser(intent, h6(AbstractC12217eE5.invite_link_chooser_title));
            if (intent.resolveActivity(A5().getPackageManager()) != null) {
                n8(intentCreateChooser);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        if (Y9()) {
            q9(new AlertDialog.a(A5()).i(h6(AbstractC12217eE5.alert_revoke_link_message)).j(h6(AbstractC12217eE5.dialog_cancel), null).l(h6(AbstractC12217eE5.alert_revoke_link_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.Xd3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.a.aa(view, dialogInterface, i2);
                }
            }).a());
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.TEXT", this.i1);
        Intent intentCreateChooser2 = Intent.createChooser(intent2, h6(AbstractC12217eE5.invite_link_chooser_title));
        if (intent2.resolveActivity(A5().getPackageManager()) != null) {
            n8(intentCreateChooser2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_list, viewGroup, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.j0());
        InterfaceC14830iZ0 interfaceC14830iZ0O1 = AbstractC5969Lp4.d().o1(this.c1);
        if (interfaceC14830iZ0O1 != null) {
            interfaceC14830iZ0O1.a(new a(viewInflate));
        }
        final ClipboardManager clipboardManager = (ClipboardManager) A5().getSystemService("clipboard");
        ((AppCompatCheckBox) viewInflate.findViewById(BC5.selectAllCheckbox)).setVisibility(8);
        viewInflate.findViewById(BC5.selectAllFrame).setVisibility(8);
        ListView listView = (ListView) viewInflate.findViewById(BC5.listView);
        this.g1 = listView;
        listView.setBackgroundColor(c5495Jo7.f0());
        TextView textView = (TextView) viewInflate.findViewById(BC5.emptyView);
        this.j1 = textView;
        textView.setText(h6(AbstractC12217eE5.invite_link_empty_view));
        this.j1.setTextColor(c5495Jo7.y0(c5495Jo7.g0(), 48));
        d dVar = new d(A5());
        this.h1 = dVar;
        this.g1.setAdapter((ListAdapter) dVar);
        this.g1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.Wd3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.a.ba(clipboardManager, viewInflate, adapterView, view, i, j);
            }
        });
        View viewInflate2 = layoutInflater.inflate(AbstractC12208eD5.fragment_link_item_footer, (ViewGroup) this.g1, false);
        viewInflate2.setBackgroundColor(c5495Jo7.j0());
        this.g1.addFooterView(viewInflate2, null, false);
        ((BaleToolbar) viewInflate.findViewById(BC5.invite_link_toolbar)).setHasBackButton(Q7(), true);
        return viewInflate;
    }
}
