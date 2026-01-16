package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManagerTgwidget;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.LU4;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;

/* loaded from: classes7.dex */
public class PaintTypefaceListView extends RecyclerListView implements E.d {
    private Path T2;
    private InterfaceC25043ze1 U2;

    class a extends RecyclerListView.n {
        a() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.n
        public boolean A(RecyclerView.C c) {
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return LU4.n().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) {
            ((PaintTextOptionsView.TypefaceCell) c.a).r((LU4) LU4.n().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            PaintTextOptionsView.TypefaceCell typefaceCell = new PaintTextOptionsView.TypefaceCell(viewGroup.getContext());
            typefaceCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.g(typefaceCell);
        }
    }

    public PaintTypefaceListView(Context context) {
        super(context);
        this.T2 = new Path();
        setWillNotDraw(false);
        setLayoutManager(new LinearLayoutManagerTgwidget(context));
        setAdapter(new a());
        setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        setClipToPadding(false);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView
    public Integer M1(int i) {
        return 285212671;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        InterfaceC25043ze1 interfaceC25043ze1 = this.U2;
        if (interfaceC25043ze1 != null) {
            interfaceC25043ze1.accept(this.T2);
            canvas.save();
            canvas.clipPath(this.T2);
        }
        super.draw(canvas);
        if (this.U2 != null) {
            canvas.restore();
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        E.j().e(this, E.a4);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E.j().u(this, E.a4);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((Math.min(LU4.n().size(), 6) * AbstractC21455b.F(48.0f)) + AbstractC21455b.F(16.0f), 1073741824));
    }

    public void setMaskProvider(InterfaceC25043ze1 interfaceC25043ze1) {
        this.U2 = interfaceC25043ze1;
        invalidate();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        if (i == E.a4) {
            getAdapter().notifyDataSetChanged();
        }
    }
}
