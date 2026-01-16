package ir.nasim.videoplayer.ui.component;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC24379yW7;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.EnumC7541Sd6;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J95;
import ir.nasim.SA2;
import ir.nasim.YT7;
import ir.nasim.videoplayer.ui.component.ThumbnailContainer;
import ir.nasim.videoplayer.ui.component.photoview.PhotoView;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0011R\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010;\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010\u001cR\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u001cR\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010\u001cR\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0015\u0010I\u001a\u00020F8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lir/nasim/videoplayer/ui/component/ThumbnailContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onInterceptTouchEvent", "disallowIntercept", "Lir/nasim/rB7;", "requestDisallowInterceptTouchEvent", "(Z)V", "onTouchEvent", "Lir/nasim/YT7;", "a", "Lir/nasim/YT7;", "getVideoPlayerGestureListener", "()Lir/nasim/YT7;", "setVideoPlayerGestureListener", "(Lir/nasim/YT7;)V", "videoPlayerGestureListener", "b", "Z", "isTouchable", "()Z", "setTouchable", "Lir/nasim/videoplayer/ui/component/photoview/PhotoView;", "c", "Lir/nasim/Yu3;", "getPhotoView", "()Lir/nasim/videoplayer/ui/component/photoview/PhotoView;", "photoView", "ir/nasim/videoplayer/ui/component/ThumbnailContainer$a", "d", "Lir/nasim/videoplayer/ui/component/ThumbnailContainer$a;", "gestureDetectorListener", "Landroid/view/GestureDetector;", "e", "Landroid/view/GestureDetector;", "gestureDetector", "", "f", TokenNames.F, "lastX", "g", "lastY", "h", "prevLastX", "i", "prevLastY", "j", "touchDownX", "k", "touchDownY", "l", "hasBeenMoving", "m", "needToInterceptTouch", "n", "dispatchingTouchToChildren", "Lir/nasim/Sd6;", "o", "Lir/nasim/Sd6;", "scrollDirection", "Lir/nasim/J95;", "getAttacher", "()Lir/nasim/J95;", "attacher", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class ThumbnailContainer extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private YT7 videoPlayerGestureListener;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isTouchable;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 photoView;

    /* renamed from: d, reason: from kotlin metadata */
    private final a gestureDetectorListener;

    /* renamed from: e, reason: from kotlin metadata */
    private final GestureDetector gestureDetector;

    /* renamed from: f, reason: from kotlin metadata */
    private float lastX;

    /* renamed from: g, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: h, reason: from kotlin metadata */
    private float prevLastX;

    /* renamed from: i, reason: from kotlin metadata */
    private float prevLastY;

    /* renamed from: j, reason: from kotlin metadata */
    private float touchDownX;

    /* renamed from: k, reason: from kotlin metadata */
    private float touchDownY;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean hasBeenMoving;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean needToInterceptTouch;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean dispatchingTouchToChildren;

    /* renamed from: o, reason: from kotlin metadata */
    private EnumC7541Sd6 scrollDirection;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: ir.nasim.videoplayer.ui.component.ThumbnailContainer$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1722a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC7541Sd6.values().length];
                try {
                    iArr[EnumC7541Sd6.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC7541Sd6.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        a() {
        }

        private final void a() {
            ThumbnailContainer.this.scrollDirection = null;
            ThumbnailContainer.this.dispatchingTouchToChildren = true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float y;
            float x;
            InterfaceC15796kB2 interfaceC15796kB2R;
            AbstractC13042fc3.i(motionEvent2, "e2");
            EnumC7541Sd6 enumC7541Sd6 = ThumbnailContainer.this.scrollDirection;
            if (motionEvent == null || ThumbnailContainer.this.getPhotoView().getAttacher().M() > 1.0f || enumC7541Sd6 == null) {
                return false;
            }
            int i = C1722a.a[enumC7541Sd6.ordinal()];
            if (i == 1) {
                float f3 = ThumbnailContainer.this.prevLastX - ThumbnailContainer.this.lastX;
                y = motionEvent2.getY() - motionEvent.getY();
                x = f3;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                x = motionEvent2.getX() - motionEvent.getX();
                y = ThumbnailContainer.this.prevLastY - ThumbnailContainer.this.lastY;
            }
            YT7 videoPlayerGestureListener = ThumbnailContainer.this.getVideoPlayerGestureListener();
            return (videoPlayerGestureListener == null || (interfaceC15796kB2R = videoPlayerGestureListener.r()) == null || !((Boolean) interfaceC15796kB2R.q(enumC7541Sd6, Float.valueOf(x), Float.valueOf(y))).booleanValue()) ? false : true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterfaceC15796kB2 interfaceC15796kB2T;
            float translationX;
            InterfaceC15796kB2 interfaceC15796kB2T2;
            float translationY;
            AbstractC13042fc3.i(motionEvent2, "e2");
            EnumC7541Sd6 enumC7541Sd6 = ThumbnailContainer.this.scrollDirection;
            if (motionEvent == null || enumC7541Sd6 == null) {
                return false;
            }
            int i = C1722a.a[enumC7541Sd6.ordinal()];
            if (i == 1) {
                float x = motionEvent2.getX() - motionEvent.getX();
                if (ThumbnailContainer.this.getPhotoView().getAttacher().M() > 1.0f) {
                    if (x > 0.0f && ThumbnailContainer.this.getTranslationX() < 0.0f && ThumbnailContainer.this.getTranslationX() + x > 0.0f) {
                        a();
                        translationX = ThumbnailContainer.this.getTranslationX();
                    } else if (x < 0.0f && ThumbnailContainer.this.getTranslationX() > 0.0f && ThumbnailContainer.this.getTranslationX() + x < 0.0f) {
                        a();
                        translationX = ThumbnailContainer.this.getTranslationX();
                    }
                    x = -translationX;
                }
                ThumbnailContainer thumbnailContainer = ThumbnailContainer.this;
                thumbnailContainer.hasBeenMoving = thumbnailContainer.hasBeenMoving || ThumbnailContainer.this.scrollDirection != null;
                YT7 videoPlayerGestureListener = ThumbnailContainer.this.getVideoPlayerGestureListener();
                if (videoPlayerGestureListener == null || (interfaceC15796kB2T = videoPlayerGestureListener.t()) == null || !((Boolean) interfaceC15796kB2T.q(enumC7541Sd6, Float.valueOf(x), Float.valueOf(motionEvent2.getY() - motionEvent.getY()))).booleanValue()) {
                    return false;
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                float y = motionEvent2.getY() - motionEvent.getY();
                if (ThumbnailContainer.this.getPhotoView().getAttacher().M() > 1.0f) {
                    if (y > 0.0f && ThumbnailContainer.this.getTranslationY() < 0.0f && ThumbnailContainer.this.getTranslationY() + y > 0.0f) {
                        a();
                        translationY = ThumbnailContainer.this.getTranslationY();
                    } else if (y < 0.0f && ThumbnailContainer.this.getTranslationY() > 0.0f && ThumbnailContainer.this.getTranslationY() + y < 0.0f) {
                        a();
                        translationY = ThumbnailContainer.this.getTranslationY();
                    }
                    y = -translationY;
                }
                ThumbnailContainer thumbnailContainer2 = ThumbnailContainer.this;
                thumbnailContainer2.hasBeenMoving = thumbnailContainer2.hasBeenMoving || ThumbnailContainer.this.scrollDirection != null;
                YT7 videoPlayerGestureListener2 = ThumbnailContainer.this.getVideoPlayerGestureListener();
                if (videoPlayerGestureListener2 == null || (interfaceC15796kB2T2 = videoPlayerGestureListener2.t()) == null || !((Boolean) interfaceC15796kB2T2.q(enumC7541Sd6, Float.valueOf(motionEvent2.getX() - motionEvent.getX()), Float.valueOf(y))).booleanValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.photoView = AbstractC13269fw3.b(EnumC4870Gx3.c, new SA2() { // from class: ir.nasim.xp7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ThumbnailContainer.l(this.a);
            }
        });
        a aVar = new a();
        this.gestureDetectorListener = aVar;
        GestureDetector gestureDetector = new GestureDetector(context, aVar);
        gestureDetector.setIsLongpressEnabled(false);
        this.gestureDetector = gestureDetector;
    }

    private final J95 getAttacher() {
        return getPhotoView().getAttacher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhotoView getPhotoView() {
        return (PhotoView) this.photoView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhotoView l(ThumbnailContainer thumbnailContainer) {
        AbstractC13042fc3.i(thumbnailContainer, "this$0");
        for (Object obj : AbstractC24379yW7.b(thumbnailContainer)) {
            if (((View) obj) instanceof PhotoView) {
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.videoplayer.ui.component.photoview.PhotoView");
                return (PhotoView) obj;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        AbstractC13042fc3.i(ev, "ev");
        if (!this.isTouchable) {
            return false;
        }
        if (getPhotoView().getVisibility() != 0) {
            return super.dispatchTouchEvent(ev);
        }
        this.prevLastX = this.lastX;
        this.prevLastY = this.lastY;
        if (ev.getAction() == 0) {
            this.hasBeenMoving = false;
            this.scrollDirection = null;
            this.touchDownX = ev.getX();
            this.touchDownY = ev.getY();
        }
        this.lastX = ev.getX();
        this.lastY = ev.getY();
        return super.dispatchTouchEvent(ev);
    }

    public final YT7 getVideoPlayerGestureListener() {
        return this.videoPlayerGestureListener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean zX;
        EnumC7541Sd6 enumC7541Sd6;
        AbstractC13042fc3.i(ev, "ev");
        if (getPhotoView().getVisibility() != 0) {
            return super.onInterceptTouchEvent(ev);
        }
        if (ev.getAction() == 2) {
            float x = ev.getX() - this.prevLastX;
            float y = ev.getY() - this.prevLastY;
            if (Math.abs(x) > Math.abs(y)) {
                enumC7541Sd6 = EnumC7541Sd6.a;
                zX = getPhotoView().getAttacher().x(x);
            } else {
                EnumC7541Sd6 enumC7541Sd62 = EnumC7541Sd6.b;
                boolean zY = getPhotoView().getAttacher().y(y);
                enumC7541Sd6 = enumC7541Sd62;
                zX = zY;
            }
            if (zX) {
                this.scrollDirection = enumC7541Sd6;
                getParent().requestDisallowInterceptTouchEvent(true);
                MotionEvent motionEventObtain = MotionEvent.obtain(ev);
                motionEventObtain.setAction(0);
                motionEventObtain.setLocation(this.prevLastX, this.prevLastY);
                this.gestureDetector.onTouchEvent(motionEventObtain);
            } else {
                this.scrollDirection = null;
            }
        } else {
            zX = false;
        }
        return zX || super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        YT7 yt7;
        InterfaceC15796kB2 interfaceC15796kB2U;
        AbstractC13042fc3.i(ev, "ev");
        if (getPhotoView().getVisibility() != 0) {
            return super.onTouchEvent(ev);
        }
        if (this.needToInterceptTouch) {
            this.needToInterceptTouch = false;
            return onInterceptTouchEvent(ev);
        }
        if (this.scrollDirection == null && this.dispatchingTouchToChildren) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return getPhotoView().dispatchTouchEvent(ev);
        }
        int action = ev.getAction();
        if (action != 1) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return this.gestureDetector.onTouchEvent(ev);
            }
            if (action != 3) {
                return super.onTouchEvent(ev);
            }
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        boolean zOnTouchEvent = this.gestureDetector.onTouchEvent(ev);
        if (!zOnTouchEvent && this.hasBeenMoving && (yt7 = this.videoPlayerGestureListener) != null && (interfaceC15796kB2U = yt7.u()) != null) {
            interfaceC15796kB2U.q(this.scrollDirection, Float.valueOf(ev.getX() - this.prevLastX), Float.valueOf(ev.getY() - this.prevLastY));
        }
        return zOnTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        if (!this.dispatchingTouchToChildren || disallowIntercept) {
            return;
        }
        this.dispatchingTouchToChildren = false;
        this.needToInterceptTouch = true;
    }

    public final void setTouchable(boolean z) {
        this.isTouchable = z;
    }

    public final void setVideoPlayerGestureListener(YT7 yt7) {
        this.videoPlayerGestureListener = yt7;
    }
}
