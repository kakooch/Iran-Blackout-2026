package ir.nasim;

import androidx.work.WorkerParameters;

/* loaded from: classes2.dex */
public class MK6 implements Runnable {
    private Za8 a;
    private String b;
    private WorkerParameters.a c;

    public MK6(Za8 za8, String str, WorkerParameters.a aVar) {
        this.a = za8;
        this.b = str;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.m().k(this.b, this.c);
    }
}
