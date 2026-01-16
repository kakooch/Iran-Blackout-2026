package ir.nasim.features.media;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22632va0;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C15225jD4;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.TA5;
import ir.nasim.XY6;
import ir.nasim.features.media.Actionbar.ActionBar;
import ir.nasim.features.media.c;
import ir.nasim.features.media.components.PhotoPickerAlbumsCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class a extends ir.nasim.features.media.Actionbar.b implements C15225jD4.b {
    private ImageButton A;
    private TextView B;
    private final boolean D;
    private final boolean G;
    private final boolean H;
    private ActionBar.b J;
    private f Y;
    private TabLayout p;
    private TextView q;
    private TextView r;
    private ListView s;
    private e t;
    private FrameLayout u;
    private TextView v;
    private boolean w;
    private final boolean x;
    private final boolean y;
    private int z;
    private ArrayList i = null;
    private ArrayList j = null;
    private final HashMap k = new HashMap();
    private final HashMap l = new HashMap();
    private final ArrayList m = new ArrayList();
    private boolean n = false;
    private int o = 2;
    private final TabLayout.d Z = new b();

    /* renamed from: ir.nasim.features.media.a$a, reason: collision with other inner class name */
    class C1177a extends ActionBar.b {
        C1177a() {
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public void b(int i) {
            if (i == -1) {
                a.this.d();
                return;
            }
            if (i == 1) {
                if (a.this.Y != null) {
                    a.this.Y.c();
                }
            } else {
                if (i == 2) {
                    if (a.this.z == 0) {
                        return;
                    }
                    a.this.z = 0;
                    a.this.v.setText(AbstractC12217eE5.NoPhotos);
                    a.this.t.notifyDataSetChanged();
                    return;
                }
                if (i != 3 || a.this.z == 1) {
                    return;
                }
                a.this.z = 1;
                a.this.v.setText(AbstractC12217eE5.NoVideo);
                a.this.t.notifyDataSetChanged();
            }
        }
    }

    class b implements TabLayout.d {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            int iC = AbstractC4043Dl1.c(a.this.f(), TA5.s7);
            int iC2 = AbstractC4043Dl1.c(a.this.f(), TA5.c2);
            a.this.z = ((Integer) gVar.j()).intValue();
            int i = a.this.z;
            if (i == 0) {
                a.this.q.setTextColor(iC2);
                a.this.r.setTextColor(iC);
                a.this.v.setText(AbstractC12217eE5.NoPhotos);
            } else if (i == 1) {
                a.this.q.setTextColor(iC);
                a.this.r.setTextColor(iC2);
                a.this.v.setText(AbstractC12217eE5.NoVideo);
            }
            try {
                a.this.s.smoothScrollToPosition(0);
            } catch (Exception unused) {
            }
            a.this.t.notifyDataSetChanged();
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.R();
            if (a.this.s == null) {
                return true;
            }
            a.this.s.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    class d implements c.g {
        d() {
        }

        @Override // ir.nasim.features.media.c.g
        public boolean a(String str) {
            a.this.r();
            return a.this.Y.b(str, null);
        }

        @Override // ir.nasim.features.media.c.g
        public void b() {
            a aVar = a.this;
            aVar.c0(aVar.k.size() + a.this.l.size());
        }

        @Override // ir.nasim.features.media.c.g
        public void c(boolean z) {
            a.this.r();
            if (z) {
                return;
            }
            a.this.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e extends AbstractC22632va0 {
        private final Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (!a.this.x && a.this.z != 0) {
                if (a.this.j != null) {
                    return (int) Math.ceil(a.this.j.size() / a.this.o);
                }
                return 0;
            }
            if (a.this.x) {
                if (a.this.i != null) {
                    return (int) Math.ceil(a.this.i.size() / a.this.o);
                }
                return 0;
            }
            if (a.this.i != null) {
                return (int) Math.ceil(a.this.i.size() / a.this.o);
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            PhotoPickerAlbumsCell photoPickerAlbumsCell;
            if (view == null) {
                photoPickerAlbumsCell = new PhotoPickerAlbumsCell(this.a);
                final a aVar = a.this;
                photoPickerAlbumsCell.setDelegate(new PhotoPickerAlbumsCell.PhotoPickerAlbumsCellDelegate() { // from class: ir.nasim.features.media.b
                    @Override // ir.nasim.features.media.components.PhotoPickerAlbumsCell.PhotoPickerAlbumsCellDelegate
                    public final void didSelectAlbum(AbstractC14815iX3.a aVar2) {
                        aVar.a0(aVar2);
                    }
                });
            } else {
                photoPickerAlbumsCell = (PhotoPickerAlbumsCell) view;
            }
            photoPickerAlbumsCell.setAlbumsCount(a.this.o);
            for (int i2 = 0; i2 < a.this.o; i2++) {
                int i3 = (a.this.o * i) + i2;
                if (a.this.x || a.this.z == 0) {
                    if (i3 < a.this.i.size()) {
                        photoPickerAlbumsCell.setAlbum(i2, (AbstractC14815iX3.a) a.this.i.get(i3));
                    } else {
                        photoPickerAlbumsCell.setAlbum(i2, null);
                    }
                } else if (i3 < a.this.j.size()) {
                    photoPickerAlbumsCell.setAlbum(i2, (AbstractC14815iX3.a) a.this.j.get(i3));
                } else {
                    photoPickerAlbumsCell.setAlbum(i2, null);
                }
            }
            photoPickerAlbumsCell.requestLayout();
            return photoPickerAlbumsCell;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return (a.this.x || a.this.z == 1) ? 1 : 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return true;
        }
    }

    public interface f {
        void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3);

        boolean b(String str, String str2);

        void c();
    }

    public a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.x = z;
        this.y = z2;
        this.D = z3;
        this.G = z4;
        this.H = z5;
    }

    private void Q() {
        ListView listView = this.s;
        if (listView != null) {
            listView.getViewTreeObserver().addOnPreDrawListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (f() == null) {
            return;
        }
        int rotation = ((WindowManager) C5721Ko.b.getSystemService("window")).getDefaultDisplay().getRotation();
        this.o = 2;
        if (rotation == 3 || rotation == 1) {
            this.o = 4;
        }
        this.t.notifyDataSetChanged();
    }

    private TextView S(Context context) {
        int iC = AbstractC4043Dl1.c(context, TA5.s7);
        TextView textView = new TextView(context);
        textView.setText(AbstractC12217eE5.PickerPhotos);
        textView.setTextSize(14.0f);
        textView.setTypeface(C6011Lu2.i());
        textView.setTextColor(iC);
        textView.setGravity(17);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private TextView T(Context context) {
        int iC = AbstractC4043Dl1.c(context, TA5.s7);
        TextView textView = new TextView(context);
        textView.setText(AbstractC12217eE5.PickerVideo);
        textView.setTextSize(14.0f);
        textView.setTypeface(C6011Lu2.i());
        textView.setTextColor(iC);
        textView.setGravity(17);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private void U(Context context, FrameLayout frameLayout) {
        View viewInflate = View.inflate(context, AbstractC12208eD5.bottom_bar_gallery, null);
        frameLayout.addView(viewInflate);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = C22078ud6.a(58.0f);
        layoutParams.gravity = 80;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(BC5.send_button);
        this.A = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.e85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Y(view);
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(BC5.badge_txt);
        this.B = textView;
        textView.setTypeface(C6011Lu2.i());
        c0(0);
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.cancel_button);
        textView2.setTypeface(C6011Lu2.i());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.f85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z(view);
            }
        });
    }

    private void V(Context context) {
        this.p.setLayoutDirection(0);
        TabLayout tabLayout = this.p;
        tabLayout.e(tabLayout.B().x(AbstractC12217eE5.PickerVideo).w(1).r(this.r));
        TabLayout tabLayout2 = this.p;
        tabLayout2.g(tabLayout2.B().x(AbstractC12217eE5.PickerPhotos).w(0).r(this.q), true);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 48;
        this.p.setLayoutParams(layoutParams);
        this.p.setSelectedTabIndicatorColor(AbstractC4043Dl1.c(context, TA5.c2));
        this.p.setTabGravity(0);
        this.p.setBackgroundColor(AbstractC4043Dl1.c(context, TA5.s2));
    }

    private void W(Context context, FrameLayout frameLayout) {
        if (!this.x) {
            TabLayout tabLayout = new TabLayout(context);
            this.p = tabLayout;
            frameLayout.addView(tabLayout);
            this.q = S(context);
            this.r = T(context);
            V(context);
            this.p.d(this.Z);
        }
        this.e.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Gallery));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean X(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        b0();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(AbstractC14815iX3.a aVar) {
        ir.nasim.features.media.c cVar = new ir.nasim.features.media.c(aVar, this.k, this.l, aVar == null ? this.m : null, this.x, this.y, this.D, this.G, this.H);
        cVar.i0(new d());
        q(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if ((this.k.isEmpty() && this.l.isEmpty()) || this.Y == null || this.w) {
            return;
        }
        this.w = true;
        if (this.k.size() == 1) {
            AbstractC14815iX3.b bVar = ((AbstractC14815iX3.b[]) this.k.values().toArray(new AbstractC14815iX3.b[0]))[0];
            if (bVar.D) {
                String str = bVar.A;
                if (str == null) {
                    str = bVar.c;
                }
                CharSequence charSequence = bVar.a;
                this.Y.b(str, charSequence != null ? charSequence.toString() : null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            AbstractC14815iX3.b bVar2 = (AbstractC14815iX3.b) ((Map.Entry) it.next()).getValue();
            String str2 = bVar2.c;
            if (str2 != null) {
                arrayList.add(str2);
                arrayList3.add(Boolean.valueOf(bVar2.D));
                CharSequence charSequence2 = bVar2.a;
                arrayList2.add(charSequence2 != null ? charSequence2.toString() : null);
            } else {
                String str3 = bVar2.A;
                if (str3 != null) {
                    arrayList.add(str3);
                    arrayList3.add(Boolean.valueOf(bVar2.D));
                    CharSequence charSequence3 = bVar2.a;
                    arrayList2.add(charSequence3 != null ? charSequence3.toString() : null);
                }
            }
        }
        Iterator it2 = this.l.entrySet().iterator();
        if (it2.hasNext()) {
            AbstractC18350oW3.a(((Map.Entry) it2.next()).getValue());
            throw null;
        }
        this.Y.a(arrayList, arrayList2, arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i) {
        int i2 = i == 0 ? 8 : 0;
        this.A.setVisibility(i2);
        this.B.setVisibility(i2);
        this.B.setText(XY6.e(String.valueOf(i)));
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public View b(Context context) {
        ArrayList arrayList;
        this.e.setBackgroundColor(AbstractC4043Dl1.c(context, TA5.s2));
        ActionBar actionBar = this.e;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        actionBar.setItemsBackgroundColor(c5495Jo7.p2());
        this.e.setBackButtonImage(KB5.ic_arrow_back_white_24dp);
        ActionBar actionBar2 = this.e;
        C1177a c1177a = new C1177a();
        this.J = c1177a;
        actionBar2.a(c1177a);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        frameLayout.setBackgroundColor(c5495Jo7.j2());
        W(context, frameLayout);
        ListView listView = new ListView(context);
        this.s = listView;
        listView.setPadding(C22078ud6.a(4.0f), 0, C22078ud6.a(4.0f), C22078ud6.a(4.0f));
        this.s.setClipToPadding(false);
        this.s.setHorizontalScrollBarEnabled(false);
        this.s.setVerticalScrollBarEnabled(false);
        this.s.setSelector(new ColorDrawable(0));
        this.s.setDividerHeight(0);
        this.s.setDivider(null);
        this.s.setDrawingCacheEnabled(false);
        this.s.setScrollingCacheEnabled(false);
        frameLayout.addView(this.s);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (!this.x) {
            layoutParams.topMargin = C22078ud6.a(48.0f);
        }
        layoutParams.bottomMargin = C22078ud6.a(48.0f);
        this.s.setLayoutParams(layoutParams);
        ListView listView2 = this.s;
        e eVar = new e(context);
        this.t = eVar;
        listView2.setAdapter((ListAdapter) eVar);
        TextView textView = new TextView(context);
        this.v = textView;
        textView.setTypeface(C6011Lu2.k());
        this.v.setTextColor(c5495Jo7.n2());
        this.v.setTextSize(20.0f);
        this.v.setGravity(17);
        this.v.setVisibility(8);
        this.v.setText(AbstractC12217eE5.NoPhotos);
        frameLayout.addView(this.v);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.v.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.bottomMargin = C22078ud6.a(48.0f);
        this.v.setLayoutParams(layoutParams2);
        this.v.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.d85
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ir.nasim.features.media.a.X(view, motionEvent);
            }
        });
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.u = frameLayout2;
        frameLayout2.setVisibility(8);
        frameLayout.addView(this.u);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        layoutParams3.bottomMargin = C22078ud6.a(48.0f);
        this.u.setLayoutParams(layoutParams3);
        this.u.addView(new ProgressBar(context));
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams4.width = -2;
        layoutParams4.height = -2;
        layoutParams4.gravity = 17;
        this.u.setLayoutParams(layoutParams4);
        U(context, frameLayout);
        if (this.n && ((arrayList = this.i) == null || arrayList.isEmpty())) {
            this.u.setVisibility(0);
            this.s.setEmptyView(null);
        } else {
            this.u.setVisibility(8);
            this.s.setEmptyView(this.v);
        }
        return this.c;
    }

    public void d0(f fVar) {
        this.Y = fVar;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i, Object... objArr) {
        if (i == C15225jD4.w) {
            if (this.f == ((Integer) objArr[0]).intValue()) {
                this.i = (ArrayList) objArr[1];
                this.j = (ArrayList) objArr[3];
                FrameLayout frameLayout = this.u;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                ListView listView = this.s;
                if (listView != null && listView.getEmptyView() == null) {
                    this.s.setEmptyView(this.v);
                }
                e eVar = this.t;
                if (eVar != null) {
                    eVar.notifyDataSetChanged();
                }
                this.n = false;
            }
        }
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void j(Configuration configuration) {
        super.j(configuration);
        Q();
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public boolean l() {
        this.n = true;
        AbstractC14815iX3.l(this.f);
        C15225jD4.b().a(this, C15225jD4.w);
        return super.l();
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void m() {
        C15225jD4.b().e(this, C15225jD4.w);
        ActionBar actionBar = this.e;
        if (actionBar != null) {
            actionBar.i(this.J);
        }
        super.m();
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void o() {
        super.o();
        e eVar = this.t;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
        Q();
    }
}
