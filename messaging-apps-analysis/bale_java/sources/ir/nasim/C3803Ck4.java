package ir.nasim;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.File;
import java.util.ArrayList;

/* renamed from: ir.nasim.Ck4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3803Ck4 {
    private BV3 a = BV3.j;
    private ArrayList b = new ArrayList();
    private File c;
    private int d;
    private int e;

    public void a(int i, long j, MediaCodec.BufferInfo bufferInfo) {
        if (i < 0 || i >= this.b.size()) {
            return;
        }
        ((C22239ut7) this.b.get(i)).b(j, bufferInfo);
    }

    public int b(MediaFormat mediaFormat, boolean z) {
        this.b.add(new C22239ut7(this.b.size(), mediaFormat, z));
        return this.b.size() - 1;
    }

    public File c() {
        return this.c;
    }

    public long d(int i) {
        if (i < 0 || i >= this.b.size()) {
            return 0L;
        }
        return ((C22239ut7) this.b.get(i)).g();
    }

    public BV3 e() {
        return this.a;
    }

    public ArrayList f() {
        return this.b;
    }

    public void g(File file) {
        this.c = file;
    }

    public void h(int i) {
        if (i == 0) {
            this.a = BV3.j;
            return;
        }
        if (i == 90) {
            this.a = BV3.k;
        } else if (i == 180) {
            this.a = BV3.l;
        } else if (i == 270) {
            this.a = BV3.m;
        }
    }

    public void i(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}
