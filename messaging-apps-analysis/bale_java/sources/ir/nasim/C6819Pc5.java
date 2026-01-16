package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lir/nasim/Pc5;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "R6", "Lir/nasim/Qx2;", "c1", "Lir/nasim/bW7;", "P9", "()Lir/nasim/Qx2;", "binding", "Lir/nasim/Pc5$a;", "d1", "Lir/nasim/Pc5$a;", "adapter", "a", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Pc5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6819Pc5 extends C22042ua0 {
    static final /* synthetic */ InterfaceC5239Im3[] e1 = {AbstractC10882cM5.i(new C25226zw5(C6819Pc5.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCountrySelectBinding;", 0))};
    public static final int f1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new b(), AbstractC20046rN7.c());

    /* renamed from: d1, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: ir.nasim.Pc5$a */
    private static final class a extends BaseAdapter {
        private final ArrayList a;

        /* renamed from: ir.nasim.Pc5$a$a, reason: collision with other inner class name */
        private static final class C0577a extends DW7 {
            private TextView b;
            private TextView c;

            @Override // ir.nasim.DW7
            public void d(boolean z) {
                TextView textView = this.b;
                if (textView != null) {
                    textView.setText("");
                }
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setText("");
                }
            }

            @Override // ir.nasim.DW7
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(C13197fp1 c13197fp1, int i, Context context) {
                AbstractC13042fc3.i(c13197fp1, "data");
                AbstractC13042fc3.i(context, "context");
                TextView textView = this.b;
                if (textView != null) {
                    textView.setText(context.getString(c13197fp1.e()));
                }
                String strE = JF5.g() ? XY6.e(c13197fp1.g()) : c13197fp1.g();
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setText("+" + strE);
                }
            }

            @Override // ir.nasim.DW7
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public View c(C13197fp1 c13197fp1, ViewGroup viewGroup, Context context) {
                AbstractC13042fc3.i(c13197fp1, "data");
                AbstractC13042fc3.i(context, "context");
                View viewInflate = LayoutInflater.from(context).inflate(AbstractC12208eD5.adapter_country_select, (ViewGroup) null);
                this.b = (TextView) viewInflate.findViewById(BC5.tv_country_name);
                this.c = (TextView) viewInflate.findViewById(BC5.tv_country_code);
                TextView textView = this.b;
                if (textView != null) {
                    textView.setTextColor(C5495Jo7.a.g0());
                }
                TextView textView2 = this.c;
                if (textView2 != null) {
                    C5495Jo7 c5495Jo7 = C5495Jo7.a;
                    textView2.setTextColor(c5495Jo7.y0(c5495Jo7.g0(), 48));
                }
                AbstractC13042fc3.f(viewInflate);
                return viewInflate;
            }
        }

        public a(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "countries");
            this.a = arrayList;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C13197fp1 getItem(int i) {
            Object obj = this.a.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            return (C13197fp1) obj;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.a.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0577a c0577a;
            AbstractC13042fc3.i(viewGroup, "parent");
            if (view == null || view.getTag() == null) {
                c0577a = new C0577a();
            } else {
                Object tag = view.getTag();
                AbstractC13042fc3.g(tag, "null cannot be cast to non-null type ir.nasim.auth.PickCountryFragment.CountryAdapter.CountryViewHolder");
                c0577a = (C0577a) tag;
            }
            C0577a c0577a2 = c0577a;
            C13197fp1 item = getItem(i);
            Context context = viewGroup.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            return c0577a2.b(view, item, i, viewGroup, context);
        }
    }

    /* renamed from: ir.nasim.Pc5$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C7249Qx2.a(fragment.V7());
        }
    }

    private final C7249Qx2 P9() {
        Object objA = this.binding.a(this, e1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C7249Qx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(C6819Pc5 c6819Pc5, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(c6819Pc5, "this$0");
        a aVar = c6819Pc5.adapter;
        if (aVar != null) {
            C13197fp1 item = aVar.getItem(i);
            String strA = item.a();
            c6819Pc5.Q7().setResult(-1, new Intent().putExtra("country_id", item.c()).putExtra("country_code", strA).putExtra("country_shortname", item.b()));
            c6819Pc5.Q7().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout root = C7249Qx2.c(inflater, container, false).getRoot();
        root.setBackgroundColor(C5495Jo7.a.f0());
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        this.adapter = null;
        P9().d.setAdapter((ListAdapter) null);
        super.R6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ListView listView = P9().d;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        listView.setDivider(new ColorDrawable(c5495Jo7.y0(c5495Jo7.g0(), 12)));
        P9().d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.Oc5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                C6819Pc5.Q9(this.a, adapterView, view2, i, j);
            }
        });
        C12561ep1 c12561ep1B = C12561ep1.a.b();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        this.adapter = new a(c12561ep1B.j(fragmentActivityQ7));
        P9().d.setAdapter((ListAdapter) this.adapter);
    }
}
