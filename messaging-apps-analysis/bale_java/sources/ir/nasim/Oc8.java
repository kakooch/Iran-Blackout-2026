package ir.nasim;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class Oc8 {
    public static final a k = new a(null);
    private final Context a;
    private final int b;
    private final int c;
    private final b d;
    private boolean e;
    private boolean f;
    private float g;
    private float h;
    private int i;
    private GestureDetector j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            Oc8.this.g = motionEvent.getX();
            Oc8.this.h = motionEvent.getY();
            Oc8.this.i = 1;
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Oc8(Context context, b bVar) {
        this(context, 0, 0, bVar, 6, null);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(bVar, "listener");
    }

    public Oc8(Context context, int i, int i2, b bVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(bVar, "listener");
        this.a = context;
        this.b = i;
        this.c = i2;
        this.d = bVar;
        this.e = true;
        this.f = true;
        this.j = new GestureDetector(context, new c());
    }

    public /* synthetic */ Oc8(Context context, int i, int i2, b bVar, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? ViewConfiguration.get(context).getScaledTouchSlop() * 2 : i, (i3 & 4) != 0 ? 0 : i2, bVar);
    }
}
