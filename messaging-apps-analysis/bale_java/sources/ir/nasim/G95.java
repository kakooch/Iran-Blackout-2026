package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import ir.nasim.C8975Ya6;
import ir.nasim.InterfaceC21793u85;
import ja.burhanrashid52.photoeditor.DrawingView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public final class G95 extends AsyncTask {
    public static final a g = new a(null);
    private C8975Ya6 a;
    private InterfaceC21793u85.b b;
    private VJ4 c;
    private final PhotoEditorView d;
    private final C5218Ik0 e;
    private final DrawingView f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private final Exception a;
        private final String b;
        private final Bitmap c;

        public b(Exception exc, String str, Bitmap bitmap) {
            this.a = exc;
            this.b = str;
            this.c = bitmap;
        }

        public final Bitmap a() {
            return this.c;
        }

        public final Exception b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }
    }

    public G95(PhotoEditorView photoEditorView, C5218Ik0 c5218Ik0) {
        AbstractC13042fc3.i(photoEditorView, "photoEditorView");
        AbstractC13042fc3.i(c5218Ik0, "boxHelper");
        this.d = photoEditorView;
        this.f = photoEditorView.getDrawingView();
        this.e = c5218Ik0;
        this.a = new C8975Ya6.a().a();
    }

    private final Bitmap a() {
        return this.a.d() ? C16079kg0.a.b(b(this.d)) : b(this.d);
    }

    private final Bitmap b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    private final void d(b bVar) {
        Bitmap bitmapA = bVar.a();
        if (bitmapA == null) {
            VJ4 vj4 = this.c;
            if (vj4 == null) {
                return;
            }
            vj4.a(new Exception("Failed to load the bitmap"));
            return;
        }
        if (this.a.c()) {
            this.e.a(this.f);
        }
        VJ4 vj42 = this.c;
        if (vj42 == null) {
            return;
        }
        vj42.b(bitmapA);
    }

    private final void e(b bVar) {
        Exception excB = bVar.b();
        String strC = bVar.c();
        if (excB != null) {
            InterfaceC21793u85.b bVar2 = this.b;
            if (bVar2 == null) {
                return;
            }
            bVar2.a(excB);
            return;
        }
        if (this.a.c()) {
            this.e.a(this.f);
        }
        InterfaceC21793u85.b bVar3 = this.b;
        if (bVar3 == null) {
            return;
        }
        AbstractC13042fc3.f(strC);
        bVar3.b(strC);
    }

    private final b g() {
        return new b(null, null, a());
    }

    private final b h(String str) throws IOException {
        Bitmap bitmapA;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str), false);
            if (this.d != null && (bitmapA = a()) != null) {
                bitmapA.compress(this.a.a(), this.a.b(), fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            Log.d("PhotoSaverTask", "Filed Saved Successfully");
            return new b(null, str, null);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("PhotoSaverTask", "Failed to save File");
            return new b(e, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b doInBackground(String... strArr) {
        AbstractC13042fc3.i(strArr, "inputs");
        return strArr.length == 0 ? g() : h(String.valueOf(AbstractC10242bK.b0(strArr)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(b bVar) {
        AbstractC13042fc3.i(bVar, "saveResult");
        super.onPostExecute(bVar);
        if (TextUtils.isEmpty(bVar.c())) {
            d(bVar);
        } else {
            e(bVar);
        }
    }

    public final void i(InterfaceC21793u85.b bVar) {
        this.b = bVar;
    }

    public final void j(C8975Ya6 c8975Ya6) {
        AbstractC13042fc3.i(c8975Ya6, "saveSettings");
        this.a = c8975Ya6;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.e.b();
        DrawingView drawingView = this.f;
        if (drawingView == null) {
            return;
        }
        drawingView.destroyDrawingCache();
    }
}
