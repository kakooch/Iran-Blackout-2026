package ir.nasim;

import android.view.View;
import ja.burhanrashid52.photoeditor.DrawingView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

/* renamed from: ir.nasim.gl0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13747gl0 implements InterfaceC16129kl0 {
    private final PhotoEditorView a;
    private final C24159y85 b;
    private LJ4 c;

    public C13747gl0(PhotoEditorView photoEditorView, C24159y85 c24159y85) {
        AbstractC13042fc3.i(photoEditorView, "mPhotoEditorView");
        AbstractC13042fc3.i(c24159y85, "mViewState");
        this.a = photoEditorView;
        this.b = c24159y85;
    }

    @Override // ir.nasim.InterfaceC16129kl0
    public void a() {
        LJ4 lj4 = this.c;
        if (lj4 == null) {
            return;
        }
        lj4.F1(ZX7.BRUSH_DRAWING);
    }

    @Override // ir.nasim.InterfaceC16129kl0
    public void b() {
        LJ4 lj4 = this.c;
        if (lj4 == null) {
            return;
        }
        lj4.O1(ZX7.BRUSH_DRAWING);
    }

    @Override // ir.nasim.InterfaceC16129kl0
    public void c(DrawingView drawingView) {
        AbstractC13042fc3.i(drawingView, "drawingView");
        if (this.b.g() > 0) {
            View viewL = this.b.l(r3.g() - 1);
            if (!(viewL instanceof DrawingView)) {
                this.a.removeView(viewL);
            }
            this.b.k(viewL);
        }
        LJ4 lj4 = this.c;
        if (lj4 == null) {
            return;
        }
        lj4.z0(ZX7.BRUSH_DRAWING, this.b.g());
    }

    @Override // ir.nasim.InterfaceC16129kl0
    public void d(DrawingView drawingView) {
        AbstractC13042fc3.i(drawingView, "drawingView");
        if (this.b.i() > 0) {
            this.b.j();
        }
        this.b.a(drawingView);
        LJ4 lj4 = this.c;
        if (lj4 == null) {
            return;
        }
        lj4.E3(ZX7.BRUSH_DRAWING, this.b.g());
    }

    public final void e(LJ4 lj4) {
        this.c = lj4;
    }
}
