package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import ja.burhanrashid52.photoeditor.DrawingView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

/* renamed from: ir.nasim.u85, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC21793u85 {

    /* renamed from: ir.nasim.u85$a */
    public static final class a {
        private Context a;
        private PhotoEditorView b;
        public ImageView c;
        public View d;
        public DrawingView e;
        public Typeface f;
        public Typeface g;
        public boolean h;
        public boolean i;

        public a(Context context, PhotoEditorView photoEditorView) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(photoEditorView, "parentView");
            this.a = context;
            this.b = photoEditorView;
            this.h = true;
            this.c = photoEditorView == null ? null : photoEditorView.getSource();
            PhotoEditorView photoEditorView2 = this.b;
            this.e = photoEditorView2 != null ? photoEditorView2.getDrawingView() : null;
        }

        public final InterfaceC21793u85 a() {
            return new C23569x85(this);
        }

        public final Context b() {
            return this.a;
        }

        public final PhotoEditorView c() {
            return this.b;
        }

        public final a d(boolean z) {
            this.i = z;
            return this;
        }

        public final a e(Typeface typeface) {
            this.f = typeface;
            return this;
        }

        public final a f(boolean z) {
            this.h = z;
            return this;
        }
    }

    /* renamed from: ir.nasim.u85$b */
    public interface b {
        void a(Exception exc);

        void b(String str);
    }

    void a(boolean z);

    void b(String str, C8975Ya6 c8975Ya6, b bVar);

    void c(LJ4 lj4);

    boolean d();

    void e(C12645ex6 c12645ex6);

    void f();

    void g(String str, C9940ao7 c9940ao7);

    boolean h();

    void i(View view, String str, C9940ao7 c9940ao7);
}
