package ir.nasim;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes8.dex */
public abstract class La8 {
    public static ThreadLocal a = new a();
    public static ThreadLocal b = new b();
    public static ThreadLocal c = new c();
    public static ThreadLocal d = new d();
    public static ThreadLocal e = new e();
    public static ThreadLocal f = new f();

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] initialValue() {
            return new byte[16384];
        }
    }

    class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Paint initialValue() {
            return new Paint();
        }
    }

    class c extends ThreadLocal {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect initialValue() {
            return new Rect();
        }
    }

    class d extends ThreadLocal {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect initialValue() {
            return new Rect();
        }
    }

    class e extends ThreadLocal {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RectF initialValue() {
            return new RectF();
        }
    }

    class f extends ThreadLocal {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RectF initialValue() {
            return new RectF();
        }
    }
}
