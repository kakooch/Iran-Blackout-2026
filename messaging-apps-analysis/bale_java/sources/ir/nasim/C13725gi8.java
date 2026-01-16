package ir.nasim;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.gi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13725gi8 implements Qo8 {
    private final Context a;
    private final Rm8 b;
    private final C17880ni8 c;
    private final Executor d;
    private final Nu8 e;

    public C13725gi8(Context context, Executor executor, C17880ni8 c17880ni8, Rm8 rm8, Nu8 nu8, byte[] bArr) {
        this.a = context;
        this.b = rm8;
        this.c = c17880ni8;
        this.d = executor;
        this.e = nu8;
    }

    static /* bridge */ /* synthetic */ void c(C13725gi8 c13725gi8, List list, InterfaceC21590tn8 interfaceC21590tn8) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Integer numE = c13725gi8.e(list);
        if (numE == null) {
            return;
        }
        if (numE.intValue() == 0) {
            interfaceC21590tn8.e();
        } else {
            interfaceC21590tn8.l(numE.intValue());
        }
    }

    static /* bridge */ /* synthetic */ void d(C13725gi8 c13725gi8, InterfaceC21590tn8 interfaceC21590tn8) {
        try {
            if (NI6.d(AbstractC16718lk8.a(c13725gi8.a))) {
                Log.i("SplitCompat", "Splits installed.");
                interfaceC21590tn8.zza();
            } else {
                Log.e("SplitCompat", "Emulating splits failed.");
                interfaceC21590tn8.l(-12);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error emulating splits.", e);
            interfaceC21590tn8.l(-12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x013b A[Catch: Exception -> 0x0136, TRY_LEAVE, TryCatch #9 {Exception -> 0x0136, blocks: (B:3:0x0004, B:86:0x013b, B:84:0x0138, B:81:0x0132, B:78:0x012d, B:5:0x0016, B:11:0x0021, B:12:0x002a, B:14:0x0031, B:16:0x0059, B:23:0x006f, B:25:0x007b, B:36:0x009c, B:49:0x00b3, B:48:0x00b0, B:21:0x0069, B:50:0x00b4, B:51:0x00b9, B:53:0x00c5, B:55:0x00cd, B:57:0x00d5, B:58:0x00e3, B:60:0x00e7, B:64:0x00fa, B:75:0x0123, B:65:0x0100, B:69:0x0109, B:71:0x0110, B:73:0x0117, B:74:0x011d), top: B:107:0x0004, inners: #1, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Integer e(java.util.List r13) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13725gi8.e(java.util.List):java.lang.Integer");
    }

    @Override // ir.nasim.Qo8
    public final void a(List list, InterfaceC21590tn8 interfaceC21590tn8) {
        if (!NI6.e()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.d.execute(new RunnableC11886di8(this, list, interfaceC21590tn8));
    }
}
