package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.C22383v85;
import ir.nasim.InterfaceC21793u85;
import ja.burhanrashid52.photoeditor.DrawingView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

/* renamed from: ir.nasim.x85, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23569x85 implements InterfaceC21793u85 {
    public static final a n = new a(null);
    private final PhotoEditorView a;
    private final C24159y85 b;
    private final ImageView c;
    private final View d;
    private final DrawingView e;
    private final C13747gl0 f;
    private final C5218Ik0 g;
    private LJ4 h;
    private final boolean i;
    private final Typeface j;
    private final Typeface k;
    private final C19423qK2 l;
    private final Context m;

    /* renamed from: ir.nasim.x85$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.x85$b */
    public static final class b implements C22383v85.a {
        b() {
        }

        @Override // ir.nasim.C22383v85.a
        public void a() {
            C23569x85.this.o();
        }
    }

    /* renamed from: ir.nasim.x85$c */
    public static final class c implements VJ4 {
        final /* synthetic */ InterfaceC21793u85.b b;
        final /* synthetic */ C8975Ya6 c;
        final /* synthetic */ String d;

        c(InterfaceC21793u85.b bVar, C8975Ya6 c8975Ya6, String str) {
            this.b = bVar;
            this.c = c8975Ya6;
            this.d = str;
        }

        @Override // ir.nasim.VJ4
        public void a(Exception exc) {
            if (exc == null) {
                return;
            }
            this.b.a(exc);
        }

        @Override // ir.nasim.VJ4
        public void b(Bitmap bitmap) {
            G95 g95 = new G95(C23569x85.this.a, C23569x85.this.g);
            g95.i(this.b);
            g95.j(this.c);
            g95.execute(this.d);
        }
    }

    public C23569x85(InterfaceC21793u85.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        PhotoEditorView photoEditorViewC = aVar.c();
        this.a = photoEditorViewC;
        C24159y85 c24159y85 = new C24159y85();
        this.b = c24159y85;
        ImageView imageView = aVar.c;
        this.c = imageView;
        this.d = aVar.d;
        DrawingView drawingView = aVar.e;
        this.e = drawingView;
        C13747gl0 c13747gl0 = new C13747gl0(aVar.c(), c24159y85);
        this.f = c13747gl0;
        this.g = new C5218Ik0(aVar.c(), c24159y85);
        this.i = aVar.h;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = new C19423qK2(aVar.c(), c24159y85);
        Context contextB = aVar.b();
        this.m = contextB;
        if (drawingView != null) {
            drawingView.setBrushViewChangeListener(c13747gl0);
        }
        final GestureDetector gestureDetector = new GestureDetector(contextB, new C22383v85(c24159y85, new b()));
        if (imageView != null) {
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.w85
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return C23569x85.k(this.a, gestureDetector, view, motionEvent);
                }
            });
        }
        photoEditorViewC.setClipSourceImage(aVar.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(C23569x85 c23569x85, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c23569x85, "this$0");
        AbstractC13042fc3.i(gestureDetector, "$mDetector");
        LJ4 lj4 = c23569x85.h;
        if (lj4 != null) {
            lj4.Y0(motionEvent);
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final void n(AbstractC18241oK2 abstractC18241oK2) {
        o();
        this.l.a(abstractC18241oK2);
        this.b.o(abstractC18241oK2.d());
    }

    private final ViewOnTouchListenerC5933Ll4 p(boolean z) {
        return new ViewOnTouchListenerC5933Ll4(this.d, this.a, this.c, z, this.h, this.b);
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void a(boolean z) {
        DrawingView drawingView = this.e;
        if (drawingView == null) {
            return;
        }
        drawingView.f(z);
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void b(String str, C8975Ya6 c8975Ya6, InterfaceC21793u85.b bVar) {
        AbstractC13042fc3.i(str, "imagePath");
        AbstractC13042fc3.i(c8975Ya6, "saveSettings");
        AbstractC13042fc3.i(bVar, "onSaveListener");
        Log.d("PhotoEditor", AbstractC13042fc3.q("Image Path: ", str));
        this.a.c(new c(bVar, c8975Ya6, str));
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void c(LJ4 lj4) {
        AbstractC13042fc3.i(lj4, "onPhotoEditorListener");
        this.h = lj4;
        this.l.d(lj4);
        this.f.e(this.h);
    }

    @Override // ir.nasim.InterfaceC21793u85
    public boolean d() {
        return this.b.g() == 0 && this.b.i() == 0;
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void e(C12645ex6 c12645ex6) {
        DrawingView drawingView = this.e;
        if (drawingView == null) {
            return;
        }
        drawingView.setCurrentShapeBuilder(c12645ex6);
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void f() {
        DrawingView drawingView = this.e;
        if (drawingView == null) {
            return;
        }
        drawingView.a();
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void g(String str, C9940ao7 c9940ao7) {
        DrawingView drawingView = this.e;
        if (drawingView != null) {
            drawingView.f(false);
        }
        C5927Lk7 c5927Lk7 = new C5927Lk7(this.a, p(this.i), this.b, this.j, this.l);
        c5927Lk7.k(str, c9940ao7);
        n(c5927Lk7);
    }

    @Override // ir.nasim.InterfaceC21793u85
    public boolean h() {
        return this.l.e();
    }

    @Override // ir.nasim.InterfaceC21793u85
    public void i(View view, String str, C9940ao7 c9940ao7) {
        AbstractC13042fc3.i(view, "view");
        TextView textView = (TextView) view.findViewById(AbstractC20554sC5.tvPhotoEditorText);
        if (textView == null || !this.b.e(view) || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
        if (c9940ao7 != null) {
            c9940ao7.e(textView);
        }
        this.l.f(view);
    }

    public void o() {
        this.g.b();
    }
}
