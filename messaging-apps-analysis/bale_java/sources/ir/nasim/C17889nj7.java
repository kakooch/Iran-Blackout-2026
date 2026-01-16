package ir.nasim;

import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.nj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17889nj7 implements e.a {
    final A13 b;
    E23 c;
    private AbstractC17761nW5 d;
    private final List e;
    final Deque a = new ArrayDeque();
    boolean f = false;

    /* renamed from: ir.nasim.nj7$a */
    static abstract class a {
        a() {
        }

        static a c(int i, ImageCaptureException imageCaptureException) {
            return new KT(i, imageCaptureException);
        }

        abstract ImageCaptureException a();

        abstract int b();
    }

    public C17889nj7(A13 a13) {
        AbstractC17949np7.a();
        this.b = a13;
        this.e = new ArrayList();
    }

    @Override // androidx.camera.core.e.a
    public void a(androidx.camera.core.f fVar) {
        AbstractC20567sE0.c().execute(new Runnable() { // from class: ir.nasim.mj7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
    }

    public void b() {
        AbstractC17949np7.a();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        this.a.clear();
        Iterator it2 = new ArrayList(this.e).iterator();
        while (it2.hasNext()) {
            ((AbstractC17761nW5) it2.next()).a(imageCaptureException);
        }
    }

    boolean c() {
        return false;
    }

    void d() {
        AbstractC17949np7.a();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (c()) {
            Log.d("TakePictureManager", "There is already a request in-flight.");
            return;
        }
        if (this.f) {
            Log.d("TakePictureManager", "The class is paused.");
        } else if (this.c.c() == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
        } else {
            AbstractC18350oW3.a(this.a.poll());
            Log.d("TakePictureManager", "No new request.");
        }
    }

    public void e() {
        AbstractC17949np7.a();
        this.f = true;
    }

    public void f() {
        AbstractC17949np7.a();
        this.f = false;
        d();
    }

    public void g(E23 e23) {
        AbstractC17949np7.a();
        this.c = e23;
        e23.e(this);
    }
}
