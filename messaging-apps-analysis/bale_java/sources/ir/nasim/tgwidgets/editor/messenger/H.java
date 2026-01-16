package ir.nasim.tgwidgets.editor.messenger;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC24721z57;
import ir.nasim.C4427Fb7;
import ir.nasim.LU4;
import ir.nasim.T1;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class H {
    public MediaController.i A;
    public boolean B;
    public boolean C;
    public l.b D;
    public ArrayList E;
    public Integer F;
    public Integer G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean O;
    public long a;
    public long b;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public long t;
    public AbstractC24721z57 u;
    public byte[] v;
    public byte[] w;
    public MediaController.n x;
    public String y;
    public ArrayList z;
    public long c = -1;
    public int n = 24;
    public boolean L = false;
    public boolean M = true;
    public boolean N = false;

    public static class a extends C4427Fb7 {
        public String i;
        public b j;
        public byte k;

        @Override // ir.nasim.C4427Fb7, ir.nasim.AbstractC12724f57
        public void b(T1 t1, boolean z) {
            super.b(t1, z);
            this.k = t1.b(z);
            if (t1.a(z)) {
                this.i = t1.g(z);
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = null;
            }
        }

        @Override // ir.nasim.C4427Fb7, ir.nasim.AbstractC12724f57
        public void c(T1 t1) {
            super.c(t1);
            t1.j(this.k);
            t1.i(!TextUtils.isEmpty(this.i));
            if (TextUtils.isEmpty(this.i)) {
                return;
            }
            t1.o(this.i);
        }
    }

    public static class b {
        public float A;
        public Bitmap B;
        public View C;
        public AnimatedFileDrawable D;
        public Canvas E;
        public byte a;
        public byte b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public String h;
        public ArrayList i = new ArrayList();
        public int j;
        public int k;
        public LU4 l;
        public int m;
        public int n;
        public int o;
        public float p;
        public float q;
        public float r;
        public float s;
        public float t;
        public float u;
        public AbstractC18106o57 v;
        public Object w;
        public int[] x;
        public long y;
        public float z;

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            bVar.e = this.e;
            bVar.f = this.f;
            bVar.g = this.g;
            bVar.h = this.h;
            bVar.i.addAll(this.i);
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.q = this.q;
            bVar.r = this.r;
            bVar.s = this.s;
            bVar.t = this.t;
            bVar.u = this.u;
            bVar.m = this.m;
            bVar.l = this.l;
            return bVar;
        }
    }

    public H a() {
        H h = new H();
        h.a = this.a;
        h.b = this.b;
        h.c = this.c;
        h.d = this.d;
        h.e = this.e;
        h.f = this.f;
        h.g = this.g;
        h.h = this.h;
        h.i = this.i;
        h.j = this.j;
        h.k = this.k;
        h.l = this.l;
        h.m = this.m;
        h.n = this.n;
        h.o = this.o;
        h.p = this.p;
        h.q = this.q;
        h.r = this.r;
        h.s = this.s;
        h.t = this.t;
        h.u = this.u;
        h.v = this.v;
        h.w = this.w;
        h.x = this.x;
        h.y = this.y;
        h.z = this.z;
        h.A = this.A;
        h.B = this.B;
        h.C = this.C;
        h.D = this.D;
        h.E = this.E;
        h.F = this.F;
        h.G = this.G;
        h.H = this.H;
        h.I = this.I;
        h.J = this.J;
        h.K = this.K;
        h.L = this.L;
        h.M = this.M;
        h.N = this.N;
        h.O = this.O;
        return h;
    }

    public boolean b() {
        File file = new File(this.o);
        if (file.exists()) {
            return this.p < file.length() || c();
        }
        return c();
    }

    public boolean c() {
        if (!this.C) {
            if (this.z != null || this.y != null || this.x != null || this.A != null || !this.r || this.a > 0) {
                return true;
            }
            long j = this.b;
            return (j == -1 || j == this.q) ? false : true;
        }
        if (this.z != null || this.y != null || this.x != null) {
            return true;
        }
        MediaController.i iVar = this.A;
        if ((iVar != null && !iVar.b()) || this.a > 0) {
            return true;
        }
        long j2 = this.b;
        return ((j2 == -1 || j2 == this.q) && this.i == this.l && this.h == this.k) ? false : true;
    }

    public String toString() {
        return "VideoEditedInfo{startTime=" + this.a + ", endTime=" + this.b + ", avatarStartTime=" + this.c + ", start=" + this.d + ", end=" + this.e + ", compressQuality=" + this.f + ", rotationValue=" + this.g + ", originalWidth=" + this.h + ", originalHeight=" + this.i + ", originalBitrate=" + this.j + ", resultWidth=" + this.k + ", resultHeight=" + this.l + ", bitrate=" + this.m + ", framerate=" + this.n + ", originalPath='" + this.o + ", estimatedSize=" + this.p + ", estimatedDuration=" + this.q + ", roundVideo=" + this.r + ", muted=" + this.s + ", originalDuration=" + this.t + ", file=" + this.u + ", encryptedFile=" + ((Object) null) + ", key=" + Arrays.toString(this.v) + ", iv=" + Arrays.toString(this.w) + ", filterState=" + this.x + ", paintPath='" + this.y + ", mediaEntities=" + this.z + ", cropState=" + this.A + ", isPhoto=" + this.B + ", isStory=" + this.C + ", hdrInfo=" + this.D + ", parts=" + this.E + ", gradientTopColor=" + this.F + ", gradientBottomColor=" + this.G + ", forceFragmenting=" + this.H + ", alreadyScheduledConverting=" + this.I + ", canceled=" + this.J + ", videoConvertFirstWrite=" + this.K + ", needUpdateProgress=" + this.L + ", shouldLimitFps=" + this.M + ", tryUseHevc=" + this.N + ", fromCamera=" + this.O + '}';
    }
}
