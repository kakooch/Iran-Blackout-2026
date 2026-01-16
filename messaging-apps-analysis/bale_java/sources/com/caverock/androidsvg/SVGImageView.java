package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import ir.nasim.AE5;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SVGImageView extends ImageView {
    private static Method c;
    private g a;
    private f b;

    private class b extends AsyncTask {
        private Context a;
        private int b;

        b(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g doInBackground(Integer... numArr) {
            try {
                return g.m(this.a, this.b);
            } catch (SVGParseException e) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.b), e.getMessage()));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(g gVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SVGImageView.this.a = gVar;
            SVGImageView.this.c();
        }
    }

    private class c extends AsyncTask {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g doInBackground(InputStream... inputStreamArr) throws IOException {
            try {
                try {
                    return g.l(inputStreamArr[0]);
                } catch (SVGParseException e) {
                    Log.e("SVGImageView", "Parse error loading URI: " + e.getMessage());
                    try {
                        inputStreamArr[0].close();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                }
            } finally {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(g gVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SVGImageView.this.a = gVar;
            SVGImageView.this.c();
        }
    }

    static {
        try {
            c = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
        this.a = null;
        this.b = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        g gVar = this.a;
        if (gVar == null) {
            return;
        }
        Picture pictureV = gVar.v(this.b);
        g();
        setImageDrawable(new PictureDrawable(pictureV));
    }

    private void d(AttributeSet attributeSet, int i) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, AE5.SVGImageView, i, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(AE5.SVGImageView_css);
            if (string != null) {
                this.b.a(string);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(AE5.SVGImageView_svg, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            String string2 = typedArrayObtainStyledAttributes.getString(AE5.SVGImageView_svg);
            if (string2 != null) {
                if (f(Uri.parse(string2))) {
                    typedArrayObtainStyledAttributes.recycle();
                    return;
                } else {
                    if (e(string2)) {
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                    setFromString(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private boolean e(String str) throws IOException {
        try {
            new c().execute(getContext().getAssets().open(str));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean f(Uri uri) throws FileNotFoundException {
        try {
            new c().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private void g() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (c == null) {
            return;
        }
        try {
            c.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
        }
    }

    private void setFromString(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.a = g.o(str);
            c();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    public void setCSS(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.b.a(str);
        c();
    }

    public void setImageAsset(String str) {
        if (e(str)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        new b(getContext(), i).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (f(uri)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + uri);
    }

    public void setSVG(g gVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (gVar == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.a = gVar;
        c();
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = null;
        this.b = new f();
        d(attributeSet, 0);
    }

    public void setSVG(g gVar, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (gVar != null) {
            this.a = gVar;
            this.b.a(str);
            c();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = new f();
        d(attributeSet, i);
    }
}
