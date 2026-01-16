package ir.nasim.features.media;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20488s57;
import ir.nasim.AbstractC22632va0;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C10743c74;
import ir.nasim.C20171rb5;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.S23;
import ir.nasim.TA5;
import ir.nasim.XY6;
import ir.nasim.features.media.Actionbar.ActionBar;
import ir.nasim.features.media.Actionbar.ActionBarMenuItem;
import ir.nasim.features.media.components.BackupImageView;
import ir.nasim.features.media.components.PhotoPickerPhotoCell;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class c extends ir.nasim.features.media.Actionbar.b implements PhotoViewerAbs.PhotoViewerProviderAbs {
    private boolean B;
    private boolean D;
    private boolean G;
    private final boolean H;
    private final boolean J;
    private final boolean Y;
    private g Z;
    private String i;
    private ImageButton j;
    private TextView k;
    private final HashMap m;
    private final HashMap n;
    private final ArrayList o;
    private boolean q;
    private String r;
    private String s;
    private boolean t;
    private final AbstractC14815iX3.a u;
    private GridView v;
    private f w;
    private FrameLayout x;
    private TextView y;
    private ActionBarMenuItem z;
    private ActionBar.b z0;
    private final int l = 0;
    private final ArrayList p = new ArrayList();
    private int A = 100;

    class a extends ActionBar.b {
        a() {
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public void b(int i) {
            if (i == -1) {
                c.this.d();
            }
        }
    }

    class b extends ActionBarMenuItem.a {
        b() {
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem.a
        public boolean a() {
            c.this.d();
            return false;
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem.a
        public void b(EditText editText) {
            if (editText.getText().toString().length() == 0) {
                return;
            }
            c.this.p.clear();
            c.this.r = null;
            c.this.s = editText.getText().toString();
            if (c.this.s.length() == 0) {
                c.this.s = null;
                c.this.y.setText(AbstractC12217eE5.NoRecentPhotos);
            } else {
                c.this.y.setText(AbstractC12217eE5.NoResult);
            }
            c.this.j0();
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBarMenuItem.a
        public void c(EditText editText) {
            if (editText.getText().length() == 0) {
                c.this.p.clear();
                c.this.s = null;
                c.this.r = null;
                c.this.q = false;
                c.this.y.setText(AbstractC12217eE5.NoRecentPhotos);
                c.this.j0();
            }
        }
    }

    /* renamed from: ir.nasim.features.media.c$c, reason: collision with other inner class name */
    class C1178c implements AdapterView.OnItemClickListener {
        C1178c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (c.this.u != null && c.this.u.e && c.this.G) {
                if (i < 0 || i >= c.this.u.c.size() || !c.this.Z.a(((AbstractC14815iX3.b) c.this.u.c.get(i)).A)) {
                    return;
                }
                c.this.d();
                return;
            }
            ArrayList<Object> arrayList = c.this.u != null ? c.this.u.c : (c.this.p.isEmpty() && c.this.s == null) ? c.this.o : c.this.p;
            if (i < 0 || i >= arrayList.size()) {
                return;
            }
            if (c.this.z != null) {
                C23381wp3.f(c.this.z.getSearchField());
            }
            if (PhotoViewerAbs.getInstance() instanceof C20171rb5) {
                ((C20171rb5) PhotoViewerAbs.getInstance()).c = true;
            }
            PhotoViewerAbs.getInstance().setParentActivity(c.this.f());
            PhotoViewerAbs.getInstance().openPhotoForSelect(arrayList, i, c.this.D ? 1 : 0, c.this.J, c.this.Y, c.this, null, null);
        }
    }

    class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                C23381wp3.f(c.this.f().getCurrentFocus());
            }
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.this.Y();
            if (c.this.v == null) {
                return true;
            }
            c.this.v.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    private class f extends AbstractC22632va0 {
        private Context a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) ((View) view.getParent()).getTag()).intValue();
                if (c.this.u == null) {
                    C23381wp3.f(c.this.f().getCurrentFocus());
                    if (c.this.p.isEmpty() && c.this.s == null) {
                        AbstractC18350oW3.a(c.this.o.get(((Integer) ((View) view.getParent()).getTag()).intValue()));
                    } else {
                        AbstractC18350oW3.a(c.this.p.get(((Integer) ((View) view.getParent()).getTag()).intValue()));
                    }
                    HashMap unused = c.this.m;
                    throw null;
                }
                AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) c.this.u.c.get(iIntValue);
                if (c.this.n.containsKey(Integer.valueOf(bVar.u))) {
                    c.this.n.remove(Integer.valueOf(bVar.u));
                    bVar.c = null;
                    bVar.b = null;
                    c.this.updatePhotoAtIndex(iIntValue);
                } else {
                    c.this.n.put(Integer.valueOf(bVar.u), bVar);
                }
                ((PhotoPickerPhotoCell) view.getParent()).setChecked(c.this.n.containsKey(Integer.valueOf(bVar.u)), true);
                c cVar = c.this;
                cVar.h0(cVar.n.size() + c.this.m.size());
                c.this.Z.b();
            }
        }

        public f(Context context) {
            this.a = context;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return c.this.u != null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (c.this.u != null) {
                return c.this.u.c.size();
            }
            if (c.this.p.isEmpty() && c.this.s == null) {
                return c.this.o.size();
            }
            return c.this.p.size() + (c.this.r == null ? 0 : 1);
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
            if (c.this.u == null) {
                return (!(c.this.p.isEmpty() && c.this.s == null && i < c.this.o.size()) && i >= c.this.p.size()) ? 1 : 0;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            View view2 = view;
            View viewInflate = view;
            if (itemViewType == 0) {
                PhotoPickerPhotoCell photoPickerPhotoCell = (PhotoPickerPhotoCell) view;
                View view3 = view;
                if (view == null) {
                    PhotoPickerPhotoCell photoPickerPhotoCell2 = new PhotoPickerPhotoCell(this.a, c.this.i);
                    photoPickerPhotoCell2.checkFrame.setOnClickListener(new a());
                    photoPickerPhotoCell2.checkFrame.setVisibility(c.this.D ? 8 : 0);
                    photoPickerPhotoCell = photoPickerPhotoCell2;
                    view3 = photoPickerPhotoCell2;
                }
                photoPickerPhotoCell.itemWidth = c.this.A;
                BackupImageView backupImageView = ((PhotoPickerPhotoCell) view3).photoImage;
                backupImageView.setTag(Integer.valueOf(i));
                view3.setTag(Integer.valueOf(i));
                backupImageView.setOrientation(0, true);
                if (c.this.u == null) {
                    if (c.this.p.isEmpty() && c.this.s == null) {
                        AbstractC18350oW3.a(c.this.o.get(i));
                        throw null;
                    }
                    AbstractC18350oW3.a(c.this.p.get(i));
                    throw null;
                }
                AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) c.this.u.c.get(i);
                String str = bVar.b;
                if (str != null) {
                    backupImageView.setImage(str, (String) null, this.a.getResources().getDrawable(KB5.nophotos));
                } else if (bVar.A == null) {
                    backupImageView.setImageResource(KB5.nophotos);
                } else if (bVar.D) {
                    backupImageView.setImage("vthumb://" + bVar.u + ":" + bVar.A, (String) null, this.a.getResources().getDrawable(KB5.nophotos));
                } else {
                    backupImageView.setImage("thumb://" + bVar.u + ":" + bVar.A, (String) null, this.a.getResources().getDrawable(KB5.nophotos));
                }
                photoPickerPhotoCell.setChecked(c.this.n.containsKey(Integer.valueOf(bVar.u)), false);
                boolean zIsShowingImage = PhotoViewerAbs.getInstance().isShowingImage(bVar.A);
                backupImageView.getImageReceiver().Z(!zIsShowingImage, true);
                photoPickerPhotoCell.checkBox.setVisibility((c.this.D || zIsShowingImage) ? 8 : 0);
                view2 = view3;
            } else if (itemViewType == 1) {
                if (view == null) {
                    viewInflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(AbstractC12208eD5.media_loading_layout, viewGroup, false);
                }
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                layoutParams.width = c.this.A;
                layoutParams.height = c.this.A;
                viewInflate.setLayoutParams(layoutParams);
                view2 = viewInflate;
            }
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return c.this.u != null ? c.this.u.c.isEmpty() : (c.this.p.isEmpty() && c.this.s == null) ? c.this.o.isEmpty() : c.this.p.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            if (c.this.u == null) {
                return (c.this.p.isEmpty() && c.this.s == null) ? i < c.this.o.size() : i < c.this.p.size();
            }
            return true;
        }
    }

    public interface g {
        boolean a(String str);

        void b();

        void c(boolean z);
    }

    public c(AbstractC14815iX3.a aVar, HashMap map, HashMap map2, ArrayList arrayList, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.u = aVar;
        this.n = map;
        this.m = map2;
        this.o = arrayList;
        this.H = z3;
        this.J = z4;
        this.Y = z5;
        if (aVar == null || !aVar.e) {
            this.D = z;
        } else {
            this.D = z2;
        }
        this.G = z2;
    }

    private void X() {
        GridView gridView = this.v;
        if (gridView != null) {
            gridView.getViewTreeObserver().addOnPreDrawListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (f() == null) {
            return;
        }
        int firstVisiblePosition = this.v.getFirstVisiblePosition();
        int rotation = ((WindowManager) C5721Ko.b.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = (rotation == 3 || rotation == 1) ? 5 : 3;
        this.v.setNumColumns(i);
        int iA = (AbstractC7426Rr.C().x - ((i + 1) * C22078ud6.a(4.0f))) / i;
        this.A = iA;
        this.v.setColumnWidth(iA);
        this.w.notifyDataSetChanged();
        this.v.setSelection(firstVisiblePosition);
        if (this.u == null) {
            this.y.setPadding(0, 0, 0, (int) ((AbstractC7426Rr.C().y - ActionBar.getCurrentActionBarHeight()) * 0.4f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.features.media.components.PhotoPickerPhotoCell Z(int r6) {
        /*
            r5 = this;
            android.widget.GridView r0 = r5.v
            int r0 = r0.getChildCount()
            r1 = 0
        L7:
            if (r1 >= r0) goto L50
            android.widget.GridView r2 = r5.v
            android.view.View r2 = r2.getChildAt(r1)
            boolean r3 = r2 instanceof ir.nasim.features.media.components.PhotoPickerPhotoCell
            if (r3 == 0) goto L4d
            ir.nasim.features.media.components.PhotoPickerPhotoCell r2 = (ir.nasim.features.media.components.PhotoPickerPhotoCell) r2
            ir.nasim.features.media.components.BackupImageView r3 = r2.photoImage
            java.lang.Object r3 = r3.getTag()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            ir.nasim.iX3$a r4 = r5.u
            if (r4 == 0) goto L30
            if (r3 < 0) goto L4d
            java.util.ArrayList r4 = r4.c
            int r4 = r4.size()
            if (r3 < r4) goto L4a
            goto L4d
        L30:
            java.util.ArrayList r4 = r5.p
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L3f
            java.lang.String r4 = r5.s
            if (r4 != 0) goto L3f
            java.util.ArrayList r4 = r5.o
            goto L41
        L3f:
            java.util.ArrayList r4 = r5.p
        L41:
            if (r3 < 0) goto L4d
            int r4 = r4.size()
            if (r3 < r4) goto L4a
            goto L4d
        L4a:
            if (r3 != r6) goto L4d
            return r2
        L4d:
            int r1 = r1 + 1
            goto L7
        L50:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.c.Z(int):ir.nasim.features.media.components.PhotoPickerPhotoCell");
    }

    private void a0(Context context, FrameLayout frameLayout) {
        View viewInflate = View.inflate(context, AbstractC12208eD5.bottom_bar_gallery, null);
        frameLayout.addView(viewInflate);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = C22078ud6.a(58.0f);
        layoutParams.gravity = 80;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(BC5.send_button);
        this.j = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.y95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e0(view);
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(BC5.badge_txt);
        this.k = textView;
        textView.setTypeface(C6011Lu2.i());
        h0(0);
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.cancel_button);
        textView2.setTypeface(C6011Lu2.i());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.z95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i) {
        this.o.clear();
        f fVar = this.w;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c0(AdapterView adapterView, View view, int i, long j) {
        if (!this.p.isEmpty() || this.s != null) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f(), AbstractC23035wE5.AlertDialogStyle);
        builder.setTitle(AbstractC12217eE5.app_name);
        builder.setMessage(AbstractC12217eE5.ClearSearch);
        builder.setPositiveButton(C5721Ko.b.getString(AbstractC12217eE5.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.nasim.x95
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.b0(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(AbstractC12217eE5.Cancel, (DialogInterface.OnClickListener) null);
        t(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        this.Z.c(true);
        d();
    }

    private void g0() {
        g gVar;
        if ((this.n.isEmpty() && this.m.isEmpty()) || (gVar = this.Z) == null || this.B) {
            return;
        }
        this.B = true;
        gVar.c(false);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i) {
        int i2 = i == 0 ? 8 : 0;
        this.j.setVisibility(i2);
        this.k.setVisibility(i2);
        this.k.setText(XY6.e(String.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        f fVar = this.w;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        if ((this.q && this.p.isEmpty()) || (this.t && this.s == null)) {
            this.x.setVisibility(0);
            this.v.setEmptyView(null);
            this.y.setVisibility(8);
        } else {
            this.x.setVisibility(8);
            this.y.setVisibility(0);
            this.v.setEmptyView(this.y);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean allowCaption() {
        return this.H;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean allowSendingSubmenu() {
        return false;
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public View b(Context context) {
        this.e.setBackgroundColor(AbstractC4043Dl1.c(context, TA5.s2));
        this.i = context.getString(TA5.secondary);
        ActionBar actionBar = this.e;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        actionBar.setItemsBackgroundColor(c5495Jo7.p2());
        this.e.setBackButtonImage(KB5.ic_arrow_back_white_24dp);
        AbstractC14815iX3.a aVar = this.u;
        if (aVar != null) {
            this.e.setTitle(aVar.a);
        } else {
            this.e.setTitle(context.getString(AbstractC12217eE5.SearchImagesTitle));
        }
        ActionBar actionBar2 = this.e;
        a aVar2 = new a();
        this.z0 = aVar2;
        actionBar2.a(aVar2);
        if (this.u == null) {
            this.z = this.e.d().a(0, KB5.ic_search_white_24dp).h(true).g(new b());
        }
        if (this.u == null) {
            this.z.getSearchField().setHint(AbstractC12217eE5.SearchImagesTitle);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        frameLayout.setBackgroundColor(c5495Jo7.j2());
        GridView gridView = new GridView(context);
        this.v = gridView;
        gridView.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f));
        this.v.setClipToPadding(false);
        this.v.setDrawSelectorOnTop(true);
        this.v.setStretchMode(2);
        this.v.setHorizontalScrollBarEnabled(false);
        this.v.setVerticalScrollBarEnabled(false);
        this.v.setNumColumns(-1);
        this.v.setVerticalSpacing(C22078ud6.a(4.0f));
        this.v.setHorizontalSpacing(C22078ud6.a(4.0f));
        this.v.setSelector(KB5.list_selector);
        frameLayout.addView(this.v);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.bottomMargin = this.D ? 0 : C22078ud6.a(48.0f);
        this.v.setLayoutParams(layoutParams);
        GridView gridView2 = this.v;
        f fVar = new f(context);
        this.w = fVar;
        gridView2.setAdapter((ListAdapter) fVar);
        this.v.setOnItemClickListener(new C1178c());
        if (this.u == null) {
            this.v.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: ir.nasim.v95
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                    return this.a.c0(adapterView, view, i, j);
                }
            });
        }
        TextView textView = new TextView(context);
        this.y = textView;
        textView.setTextColor(c5495Jo7.n2());
        this.y.setTextSize(20.0f);
        this.y.setGravity(17);
        this.y.setVisibility(8);
        if (this.u != null) {
            this.y.setText(AbstractC12217eE5.NoPhotos);
        } else {
            this.y.setText(AbstractC12217eE5.NoRecentPhotos);
        }
        frameLayout.addView(this.y);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.bottomMargin = this.D ? 0 : C22078ud6.a(48.0f);
        this.y.setLayoutParams(layoutParams2);
        this.y.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.w95
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ir.nasim.features.media.c.d0(view, motionEvent);
            }
        });
        if (this.u == null) {
            this.v.setOnScrollListener(new d());
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.x = frameLayout2;
            frameLayout2.setVisibility(8);
            frameLayout.addView(this.x);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams3.bottomMargin = this.D ? 0 : C22078ud6.a(48.0f);
            this.x.setLayoutParams(layoutParams3);
            ProgressBar progressBar = new ProgressBar(context);
            this.x.addView(progressBar);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams4.width = -2;
            layoutParams4.height = -2;
            layoutParams4.gravity = 17;
            progressBar.setLayoutParams(layoutParams4);
            j0();
        }
        a0(context, frameLayout);
        this.v.setEmptyView(this.y);
        h0(this.n.size() + this.m.size());
        return this.c;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean canCaptureMorePhotos() {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean canReplace(int i) {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean canScrollAway() {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean cancelButtonPressed() {
        this.Z.c(true);
        d();
        return true;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean closeKeyboard() {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void deleteImageAtIndex(int i) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public String getDeleteMessageString() {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public C10743c74 getEditingMessageObject() {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getPhotoIndex(int i) {
        return 0;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public PhotoViewerAbs.PlaceProviderObjectAbs getPlaceForPhoto(int i) {
        PhotoPickerPhotoCell photoPickerPhotoCellZ = Z(i);
        if (photoPickerPhotoCellZ == null) {
            return null;
        }
        int[] iArr = new int[2];
        photoPickerPhotoCellZ.photoImage.getLocationInWindow(iArr);
        PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs = new PhotoViewerAbs.PlaceProviderObjectAbs();
        placeProviderObjectAbs.viewX = iArr[0];
        placeProviderObjectAbs.viewY = iArr[1] - AbstractC7426Rr.H();
        placeProviderObjectAbs.parentView = this.v;
        S23 imageReceiver = photoPickerPhotoCellZ.photoImage.getImageReceiver();
        placeProviderObjectAbs.imageReceiverOld = imageReceiver;
        placeProviderObjectAbs.thumbBitmap = imageReceiver.g();
        placeProviderObjectAbs.scale = photoPickerPhotoCellZ.photoImage.getScaleX();
        photoPickerPhotoCellZ.checkBox.setVisibility(8);
        return placeProviderObjectAbs;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getSelectedCount() {
        return this.n.size() + this.m.size();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public HashMap getSelectedPhotos() {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public ArrayList getSelectedPhotosOrder() {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public CharSequence getSubtitleFor(int i) {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public Bitmap getThumbForPhoto(int i) {
        PhotoPickerPhotoCell photoPickerPhotoCellZ = Z(i);
        if (photoPickerPhotoCellZ != null) {
            return photoPickerPhotoCellZ.photoImage.getImageReceiver().g();
        }
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public CharSequence getTitleFor(int i) {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getTotalImageCount() {
        return 0;
    }

    public void i0(g gVar) {
        this.Z = gVar;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean isPhotoChecked(int i) {
        AbstractC14815iX3.a aVar = this.u;
        if (aVar != null) {
            return i >= 0 && i < aVar.c.size() && this.n.containsKey(Integer.valueOf(((AbstractC14815iX3.b) this.u.c.get(i)).u));
        }
        ArrayList arrayList = (this.p.isEmpty() && this.s == null) ? this.o : this.p;
        if (i < 0 || i >= arrayList.size()) {
            return false;
        }
        AbstractC18350oW3.a(arrayList.get(i));
        throw null;
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void j(Configuration configuration) {
        super.j(configuration);
        X();
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public boolean l() {
        if (this.u == null && this.o.isEmpty()) {
            this.t = true;
        }
        return super.l();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean loadMore() {
        return false;
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void m() {
        ActionBar actionBar = this.e;
        if (actionBar != null) {
            actionBar.i(this.z0);
        }
        super.m();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void needAddMorePhotos() {
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void o() {
        super.o();
        f fVar = this.w;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        ActionBarMenuItem actionBarMenuItem = this.z;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.f(true);
            f().getWindow().setSoftInputMode(32);
        }
        X();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onApplyCaption(CharSequence charSequence) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void onCaptionChanged(int i, CharSequence charSequence) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onClose() {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onOpen() {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void openPhotoForEdit(String str, String str2, boolean z) {
    }

    @Override // ir.nasim.features.media.Actionbar.b
    public void p(boolean z) {
        ActionBarMenuItem actionBarMenuItem;
        if (!z || (actionBarMenuItem = this.z) == null) {
            return;
        }
        C23381wp3.g(actionBarMenuItem.getSearchField());
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void replaceButtonPressed(int i, H h) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean scaleToFill() {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void sendButtonPressed(int i, H h, boolean z, int i2, boolean z2) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int setPhotoChecked(int i, H h) {
        return 0;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int setPhotoUnchecked(Object obj) {
        return 0;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void updatePhotoAtIndex(int i) {
        PhotoPickerPhotoCell photoPickerPhotoCellZ = Z(i);
        if (photoPickerPhotoCellZ != null) {
            if (this.u == null) {
                AbstractC18350oW3.a(((this.p.isEmpty() && this.s == null) ? this.o : this.p).get(i));
                throw null;
            }
            photoPickerPhotoCellZ.photoImage.setOrientation(0, true);
            AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) this.u.c.get(i);
            String str = bVar.b;
            if (str != null) {
                photoPickerPhotoCellZ.photoImage.setImage(str, (String) null, photoPickerPhotoCellZ.getContext().getResources().getDrawable(KB5.nophotos));
                return;
            }
            if (bVar.A == null) {
                photoPickerPhotoCellZ.photoImage.setImageResource(KB5.nophotos);
                return;
            }
            photoPickerPhotoCellZ.photoImage.setOrientation(bVar.B, true);
            if (bVar.D) {
                photoPickerPhotoCellZ.photoImage.setImage("vthumb://" + bVar.u + ":" + bVar.A, (String) null, photoPickerPhotoCellZ.getContext().getResources().getDrawable(KB5.nophotos));
                return;
            }
            photoPickerPhotoCellZ.photoImage.setImage("thumb://" + bVar.u + ":" + bVar.A, (String) null, photoPickerPhotoCellZ.getContext().getResources().getDrawable(KB5.nophotos));
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean validateGroupId(long j) {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void willHidePhotoViewer() {
        f fVar = this.w;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void willSwitchFromPhoto(int r7) {
        /*
            r6 = this;
            android.widget.GridView r0 = r6.v
            int r0 = r0.getChildCount()
            r1 = 0
            r2 = r1
        L8:
            if (r2 >= r0) goto L58
            android.widget.GridView r3 = r6.v
            android.view.View r3 = r3.getChildAt(r2)
            java.lang.Object r4 = r3.getTag()
            if (r4 != 0) goto L17
            goto L55
        L17:
            r4 = r3
            ir.nasim.features.media.components.PhotoPickerPhotoCell r4 = (ir.nasim.features.media.components.PhotoPickerPhotoCell) r4
            java.lang.Object r3 = r3.getTag()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            ir.nasim.iX3$a r5 = r6.u
            if (r5 == 0) goto L33
            if (r3 < 0) goto L55
            java.util.ArrayList r5 = r5.c
            int r5 = r5.size()
            if (r3 < r5) goto L4d
            goto L55
        L33:
            java.util.ArrayList r5 = r6.p
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L42
            java.lang.String r5 = r6.s
            if (r5 != 0) goto L42
            java.util.ArrayList r5 = r6.o
            goto L44
        L42:
            java.util.ArrayList r5 = r6.p
        L44:
            if (r3 < 0) goto L55
            int r5 = r5.size()
            if (r3 < r5) goto L4d
            goto L55
        L4d:
            if (r3 != r7) goto L55
            ir.nasim.components.checkbox.view.CheckBox r7 = r4.checkBox
            r7.setVisibility(r1)
            goto L58
        L55:
            int r2 = r2 + 1
            goto L8
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.c.willSwitchFromPhoto(int):void");
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onCaptionChanged(CharSequence charSequence) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void sendButtonPressed(int i, H h) {
        if (this.u != null) {
            if (this.n.isEmpty()) {
                if (i < 0 || i >= this.u.c.size()) {
                    return;
                }
                AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) this.u.c.get(i);
                this.n.put(Integer.valueOf(bVar.u), bVar);
            }
        } else if (this.n.isEmpty()) {
            ArrayList arrayList = (this.p.isEmpty() && this.s == null) ? this.o : this.p;
            if (i < 0 || i >= arrayList.size()) {
                return;
            }
            AbstractC18350oW3.a(arrayList.get(i));
            throw null;
        }
        g0();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean setPhotoChecked(int i) {
        boolean z;
        AbstractC14815iX3.a aVar = this.u;
        if (aVar == null) {
            ArrayList arrayList = (this.p.isEmpty() && this.s == null) ? this.o : this.p;
            if (i < 0 || i >= arrayList.size()) {
                return false;
            }
            AbstractC18350oW3.a(arrayList.get(i));
            throw null;
        }
        if (i < 0 || i >= aVar.c.size()) {
            return false;
        }
        AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) this.u.c.get(i);
        if (this.n.containsKey(Integer.valueOf(bVar.u))) {
            this.n.remove(Integer.valueOf(bVar.u));
            z = false;
        } else {
            this.n.put(Integer.valueOf(bVar.u), bVar);
            z = true;
        }
        int childCount = this.v.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = this.v.getChildAt(i2);
            if (((Integer) childAt.getTag()).intValue() == i) {
                ((PhotoPickerPhotoCell) childAt).setChecked(z, false);
                break;
            }
            i2++;
        }
        h0(this.n.size() + this.m.size());
        this.Z.b();
        return z;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public PhotoViewer.D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z) {
        return null;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
    }
}
