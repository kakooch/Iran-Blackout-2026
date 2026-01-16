package ir.nasim;

import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public abstract class QN {
    protected String a;
    protected String b;
    protected long c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected short h;
    protected String i;
    protected String j;
    protected short k;
    protected short l;
    protected short m;
    protected short n;
    protected String o;
    protected String p;
    protected String q;
    protected boolean r;
    protected String s;
    protected Bitmap t;
    protected Bitmap u;

    public static QN d(File file) throws IOException {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        try {
            bArr = new byte[12];
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.readFully(bArr, 0, 8);
            randomAccessFile.close();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Exception unused) {
        }
        if (bArr[4] == 102 && bArr[5] == 116 && bArr[6] == 121 && bArr[7] == 112) {
            return new C21236tL3(bufferedInputStream);
        }
        if (file.getAbsolutePath().endsWith("mp3")) {
            return new AL3(bufferedInputStream, file.length());
        }
        return null;
    }

    public static QN o(String str) {
        return new C19609qe4(str);
    }

    public String a() {
        return this.g;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.e;
    }

    public String e() {
        return this.j;
    }

    public String f() {
        return this.p;
    }

    public String g() {
        return this.o;
    }

    public Bitmap h() {
        return this.t;
    }

    public short i() {
        return this.m;
    }

    public short j() {
        return this.n;
    }

    public long k() {
        return this.c;
    }

    public String l() {
        return this.i;
    }

    public String m() {
        return this.q;
    }

    public String n() {
        return this.s;
    }

    public Bitmap p() {
        return this.u;
    }

    public String q() {
        return this.d;
    }

    public short r() {
        return this.k;
    }

    public short s() {
        return this.l;
    }

    public short t() {
        return this.h;
    }

    public boolean u() {
        return this.r;
    }
}
