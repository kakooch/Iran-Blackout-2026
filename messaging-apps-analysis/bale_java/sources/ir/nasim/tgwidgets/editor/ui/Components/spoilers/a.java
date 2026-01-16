package ir.nasim.tgwidgets.editor.ui.Components.spoilers;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import ir.nasim.TI6;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private GestureDetectorCompat a;
    private boolean b;

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.spoilers.a$a, reason: collision with other inner class name */
    class C1595a extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ View a;
        final /* synthetic */ boolean b;
        final /* synthetic */ List c;
        final /* synthetic */ b d;

        C1595a(View view, boolean z, List list, b bVar) {
            this.a = view;
            this.b = z;
            this.c = list;
            this.d = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = ((int) motionEvent.getY()) + this.a.getScrollY();
            if (this.b) {
                x -= this.a.getPaddingLeft();
                y -= this.a.getPaddingTop();
            }
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                if (((TI6) it.next()).getBounds().contains(x, y)) {
                    a.this.b = true;
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (a.this.b) {
                this.a.playSoundEffect(0);
                a.this.b = false;
                int x = (int) motionEvent.getX();
                int y = ((int) motionEvent.getY()) + this.a.getScrollY();
                if (this.b) {
                    x -= this.a.getPaddingLeft();
                    y -= this.a.getPaddingTop();
                }
                for (TI6 ti6 : this.c) {
                    if (ti6.getBounds().contains(x, y)) {
                        this.d.a(ti6, x, y);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public interface b {
        void a(TI6 ti6, float f, float f2);
    }

    public a(View view, List list, b bVar) {
        this(view, list, true, bVar);
    }

    public boolean c(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public a(View view, List list, boolean z, b bVar) {
        this.a = new GestureDetectorCompat(view.getContext(), new C1595a(view, z, list, bVar));
    }
}
