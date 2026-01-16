package ir.nasim;

/* renamed from: ir.nasim.Cq2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3855Cq2 extends AbstractC4089Dq2 {
    public static int a(float f) {
        return Float.valueOf(f).hashCode();
    }

    public static String b(String str, float... fArr) {
        AbstractC4029Dj5.j(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            sb.append(str);
            sb.append(fArr[i]);
        }
        return sb.toString();
    }
}
