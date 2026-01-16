package ja.burhanrashid52.photoeditor;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C10648bx6;
import ir.nasim.C12645ex6;
import ir.nasim.C14948il0;
import ir.nasim.C5590Jz3;
import ir.nasim.ED1;
import ir.nasim.EnumC4624Fx6;
import ir.nasim.InterfaceC16129kl0;
import ir.nasim.KK5;
import ir.nasim.MN4;
import ir.nasim.V1;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001*B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0017¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020%¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u000e¢\u0006\u0004\b*\u0010\u0010J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020%¢\u0006\u0004\b,\u0010-R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00100R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00100R$\u00108\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u00020%2\u0006\u00109\u001a\u00020%8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\b;\u0010)R\u0018\u0010>\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010:R\"\u0010L\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR-\u0010P\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0.\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0.0M8F¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006Q"}, d2 = {"Lja/burhanrashid52/photoeditor/DrawingView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Paint;", "d", "()Landroid/graphics/Paint;", "c", "Lir/nasim/rB7;", "l", "()V", "", "touchX", "touchY", "i", "(FF)V", "j", "k", "e", "g", "b", "Lir/nasim/kl0;", "brushViewChangeListener", "setBrushViewChangeListener", "(Lir/nasim/kl0;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "m", "()Z", "a", "brushDrawMode", "f", "(Z)V", "Ljava/util/Stack;", "Lir/nasim/bx6;", "Ljava/util/Stack;", "drawShapes", "redoShapes", "Lir/nasim/bx6;", "getCurrentShape$photoeditor_release", "()Lir/nasim/bx6;", "setCurrentShape$photoeditor_release", "(Lir/nasim/bx6;)V", "currentShape", "<set-?>", "Z", "h", "isDrawingEnabled", "Lir/nasim/kl0;", "viewChangeListener", "Lir/nasim/ex6;", "Lir/nasim/ex6;", "getCurrentShapeBuilder", "()Lir/nasim/ex6;", "setCurrentShapeBuilder", "(Lir/nasim/ex6;)V", "currentShapeBuilder", "isErasing", TokenNames.F, "getEraserSize", "()F", "setEraserSize", "(F)V", "eraserSize", "Landroid/util/Pair;", "getDrawingPath", "()Landroid/util/Pair;", "drawingPath", "photoeditor_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class DrawingView extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private final Stack drawShapes;

    /* renamed from: b, reason: from kotlin metadata */
    private final Stack redoShapes;

    /* renamed from: c, reason: from kotlin metadata */
    private C10648bx6 currentShape;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isDrawingEnabled;

    /* renamed from: e, reason: from kotlin metadata */
    private InterfaceC16129kl0 viewChangeListener;

    /* renamed from: f, reason: from kotlin metadata */
    private C12645ex6 currentShapeBuilder;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean isErasing;

    /* renamed from: h, reason: from kotlin metadata */
    private float eraserSize;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4624Fx6.values().length];
            iArr[EnumC4624Fx6.OVAL.ordinal()] = 1;
            iArr[EnumC4624Fx6.BRUSH.ordinal()] = 2;
            iArr[EnumC4624Fx6.RECTANGLE.ordinal()] = 3;
            iArr[EnumC4624Fx6.LINE.ordinal()] = 4;
            a = iArr;
        }
    }

    public DrawingView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final Paint c() {
        Paint paintD = d();
        paintD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return paintD;
    }

    private final Paint d() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        C12645ex6 c12645ex6 = this.currentShapeBuilder;
        if (c12645ex6 != null) {
            paint.setStrokeWidth(c12645ex6.c());
            paint.setAlpha(c12645ex6.b());
            paint.setColor(c12645ex6.a());
        }
        return paint;
    }

    private final void e() {
        Paint paintD = d();
        V1 c14948il0 = new C14948il0();
        if (this.isErasing) {
            paintD = c();
        } else {
            C12645ex6 c12645ex6 = this.currentShapeBuilder;
            EnumC4624Fx6 enumC4624Fx6D = c12645ex6 == null ? null : c12645ex6.d();
            int i = enumC4624Fx6D == null ? -1 : b.a[enumC4624Fx6D.ordinal()];
            if (i == 1) {
                c14948il0 = new MN4();
            } else if (i == 2) {
                c14948il0 = new C14948il0();
            } else if (i == 3) {
                c14948il0 = new KK5();
            } else if (i == 4) {
                c14948il0 = new C5590Jz3();
            }
        }
        C10648bx6 c10648bx6 = new C10648bx6(c14948il0, paintD);
        this.currentShape = c10648bx6;
        this.drawShapes.push(c10648bx6);
        InterfaceC16129kl0 interfaceC16129kl0 = this.viewChangeListener;
        if (interfaceC16129kl0 == null) {
            return;
        }
        interfaceC16129kl0.b();
    }

    private final void g(float touchX, float touchY) {
        V1 v1B;
        C10648bx6 c10648bx6 = this.currentShape;
        if (c10648bx6 != null && (v1B = c10648bx6.b()) != null && v1B.l()) {
            this.drawShapes.remove(this.currentShape);
        }
        InterfaceC16129kl0 interfaceC16129kl0 = this.viewChangeListener;
        if (interfaceC16129kl0 == null) {
            return;
        }
        interfaceC16129kl0.a();
        interfaceC16129kl0.d(this);
    }

    private final void i(float touchX, float touchY) {
        V1 v1B;
        e();
        C10648bx6 c10648bx6 = this.currentShape;
        if (c10648bx6 == null || (v1B = c10648bx6.b()) == null) {
            return;
        }
        v1B.b(touchX, touchY);
    }

    private final void j(float touchX, float touchY) {
        V1 v1B;
        C10648bx6 c10648bx6 = this.currentShape;
        if (c10648bx6 == null || (v1B = c10648bx6.b()) == null) {
            return;
        }
        v1B.a(touchX, touchY);
    }

    private final void k(float touchX, float touchY) {
        C10648bx6 c10648bx6 = this.currentShape;
        if (c10648bx6 == null) {
            return;
        }
        c10648bx6.b().c();
        g(touchX, touchY);
    }

    private final void l() {
        setLayerType(2, null);
        setVisibility(8);
        this.currentShapeBuilder = new C12645ex6();
    }

    public final void a() {
        this.isDrawingEnabled = true;
        this.isErasing = true;
    }

    public final void b() {
        this.drawShapes.clear();
        this.redoShapes.clear();
        invalidate();
    }

    public final void f(boolean brushDrawMode) {
        this.isDrawingEnabled = brushDrawMode;
        this.isErasing = !brushDrawMode;
        if (brushDrawMode) {
            setVisibility(0);
        }
    }

    /* renamed from: getCurrentShape$photoeditor_release, reason: from getter */
    public final C10648bx6 getCurrentShape() {
        return this.currentShape;
    }

    public final C12645ex6 getCurrentShapeBuilder() {
        return this.currentShapeBuilder;
    }

    public final Pair<Stack<C10648bx6>, Stack<C10648bx6>> getDrawingPath() {
        return new Pair<>(this.drawShapes, this.redoShapes);
    }

    public final float getEraserSize() {
        return this.eraserSize;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsDrawingEnabled() {
        return this.isDrawingEnabled;
    }

    public final boolean m() {
        if (!this.drawShapes.empty()) {
            this.redoShapes.push(this.drawShapes.pop());
            invalidate();
        }
        InterfaceC16129kl0 interfaceC16129kl0 = this.viewChangeListener;
        if (interfaceC16129kl0 != null) {
            interfaceC16129kl0.c(this);
        }
        return !this.drawShapes.empty();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        V1 v1B;
        AbstractC13042fc3.i(canvas, "canvas");
        Iterator it = this.drawShapes.iterator();
        while (it.hasNext()) {
            C10648bx6 c10648bx6 = (C10648bx6) it.next();
            if (c10648bx6 != null && (v1B = c10648bx6.b()) != null) {
                v1B.d(canvas, c10648bx6.a());
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        AbstractC13042fc3.i(event, "event");
        if (!this.isDrawingEnabled) {
            return false;
        }
        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();
        if (action == 0) {
            i(x, y);
        } else if (action == 1) {
            k(x, y);
        } else if (action == 2) {
            j(x, y);
        }
        invalidate();
        return true;
    }

    public final void setBrushViewChangeListener(InterfaceC16129kl0 brushViewChangeListener) {
        this.viewChangeListener = brushViewChangeListener;
    }

    public final void setCurrentShape$photoeditor_release(C10648bx6 c10648bx6) {
        this.currentShape = c10648bx6;
    }

    public final void setCurrentShapeBuilder(C12645ex6 c12645ex6) {
        this.currentShapeBuilder = c12645ex6;
    }

    public final void setEraserSize(float f) {
        this.eraserSize = f;
    }

    public DrawingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DrawingView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public DrawingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawShapes = new Stack();
        this.redoShapes = new Stack();
        this.eraserSize = 50.0f;
        l();
    }
}
