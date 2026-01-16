package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;

/* renamed from: ir.nasim.t93, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21127t93 implements InterfaceC19915r93 {
    private final View a;
    private final InterfaceC9173Yu3 b = AbstractC13269fw3.b(EnumC4870Gx3.c, new a());
    private final C21877uH6 c;

    /* renamed from: ir.nasim.t93$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InputMethodManager invoke() {
            Object systemService = C21127t93.this.a.getContext().getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            return (InputMethodManager) systemService;
        }
    }

    public C21127t93(View view) {
        this.a = view;
        this.c = new C21877uH6(view);
    }

    private final InputMethodManager h() {
        return (InputMethodManager) this.b.getValue();
    }

    @Override // ir.nasim.InterfaceC19915r93
    public void a(int i, ExtractedText extractedText) {
        h().updateExtractedText(this.a, i, extractedText);
    }

    @Override // ir.nasim.InterfaceC19915r93
    public boolean b() {
        return h().isActive(this.a);
    }

    @Override // ir.nasim.InterfaceC19915r93
    public void c(int i, int i2, int i3, int i4) {
        h().updateSelection(this.a, i, i2, i3, i4);
    }

    @Override // ir.nasim.InterfaceC19915r93
    public void d() {
        h().restartInput(this.a);
    }

    @Override // ir.nasim.InterfaceC19915r93
    public void e(CursorAnchorInfo cursorAnchorInfo) {
        h().updateCursorAnchorInfo(this.a, cursorAnchorInfo);
    }

    @Override // ir.nasim.InterfaceC19915r93
    public void f() {
        if (Build.VERSION.SDK_INT >= 34) {
            C24027xv.a.a(h(), this.a);
        }
    }
}
