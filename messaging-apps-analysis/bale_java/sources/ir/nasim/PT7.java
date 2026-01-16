package ir.nasim;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* loaded from: classes8.dex */
public final class PT7 extends GestureDetector {
    private final YT7 a;
    private float b;
    private float c;
    private float d;
    private float e;
    private boolean f;
    private final int g;
    private final int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PT7(Context context, float f, float f2, YT7 yt7) {
        super(context, yt7);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(yt7, "listener");
        this.a = yt7;
        float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h = AbstractC20723sV3.d(f * scaledTouchSlop);
        this.g = AbstractC20723sV3.d(scaledTouchSlop * f2);
    }

    private final EnumC7541Sd6 a(MotionEvent motionEvent) {
        float fAbs = Math.abs(motionEvent.getX() - this.d);
        float fAbs2 = Math.abs(motionEvent.getY() - this.e);
        if (fAbs > fAbs2 && fAbs > this.g) {
            return EnumC7541Sd6.a;
        }
        if (fAbs2 > this.h) {
            return EnumC7541Sd6.b;
        }
        return null;
    }

    private final void b(MotionEvent motionEvent, boolean z) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
            return;
        }
        if (action != 1) {
            if (action == 2) {
                EnumC7541Sd6 enumC7541Sd6V = this.a.v();
                if (enumC7541Sd6V == null) {
                    enumC7541Sd6V = a(motionEvent);
                    this.a.E(enumC7541Sd6V);
                }
                if (!z && !this.a.p() && enumC7541Sd6V != null) {
                    this.f = ((Boolean) this.a.t().q(enumC7541Sd6V, Float.valueOf(motionEvent.getX() - this.b), Float.valueOf(motionEvent.getY() - this.c))).booleanValue();
                }
                this.b = motionEvent.getX();
                this.c = motionEvent.getY();
                return;
            }
            if (action != 3) {
                return;
            }
        }
        if (this.a.p()) {
            this.a.q().invoke(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
            this.a.w(false);
        } else if (!z && this.f) {
            this.a.u().q(this.a.v(), Float.valueOf(motionEvent.getX() - this.b), Float.valueOf(motionEvent.getY() - this.c));
        }
        this.b = 0.0f;
        this.c = 0.0f;
        this.f = false;
        this.a.E(null);
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "ev");
        b(motionEvent, super.onTouchEvent(motionEvent));
        return true;
    }
}
