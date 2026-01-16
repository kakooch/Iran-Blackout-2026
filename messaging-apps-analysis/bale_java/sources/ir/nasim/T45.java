package ir.nasim;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class T45 {
    private static final List k = Arrays.asList(-16777216, -1, -14837249, -16532268, -12994005, -417009, -365034, -1559228, -5091841, -2645892, -5475508, -7319252, -11325921, -8289919);
    private static final Integer l = -16087809;
    private static T45[] m = new T45[1];
    private SharedPreferences a;
    private List b = new ArrayList(14);
    private List c = new ArrayList(14);
    private Integer d;
    private int e;
    private int f;
    private int g;
    private float h;
    private String i;
    private boolean j;

    public T45(int i) {
        SharedPreferences sharedPreferences = AbstractC14047hG.a.getSharedPreferences("photo_color_palette_" + i, 0);
        this.a = sharedPreferences;
        this.e = sharedPreferences.getInt("brush", 0);
        this.h = this.a.getFloat("weight", 0.5f);
        this.i = this.a.getString("typeface", "raviSemiBold");
        this.f = this.a.getInt("text_alignment", 2);
        this.g = this.a.getInt("text_type", 0);
        this.j = this.a.getBoolean("fill_shapes", false);
        j();
    }

    private void a(int i) {
        if (i < 0 || i >= 14) {
            throw new IndexOutOfBoundsException("Color palette index should be in range 0 ... 14");
        }
    }

    public static T45 h(int i) {
        T45[] t45Arr = m;
        if (t45Arr[i] == null) {
            t45Arr[i] = new T45(i);
        }
        return m[i];
    }

    private void j() {
        for (int i = 0; i < 14; i++) {
            this.b.add(Integer.valueOf((int) this.a.getLong("color_" + i, ((Integer) k.get(i)).intValue())));
        }
        this.d = Integer.valueOf((int) this.a.getLong("color_marker", l.intValue()));
    }

    public int b(int i) {
        a(i);
        if (i >= 0 && i < this.b.size()) {
            return ((Integer) this.b.get(i)).intValue();
        }
        if (i >= 0) {
            List list = k;
            if (i < list.size()) {
                return ((Integer) list.get(i)).intValue();
            }
        }
        return ((Integer) k.get(0)).intValue();
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public String e() {
        return this.i;
    }

    public float f() {
        return this.h;
    }

    public boolean g() {
        return this.j;
    }

    public float i(String str, float f) {
        return this.a.getFloat("weight_" + str, f);
    }

    public void k() {
        if (this.c.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        int i = 0;
        while (i < 14) {
            editorEdit.putLong("color_" + i, ((Integer) (i < this.c.size() ? this.c : k).get(i)).intValue());
            i++;
        }
        editorEdit.apply();
        this.b.clear();
        this.b.addAll(this.c);
        this.c.clear();
    }

    public void l(int i) {
        int iIndexOf = this.b.indexOf(Integer.valueOf(i));
        if (iIndexOf != -1) {
            m(iIndexOf);
            return;
        }
        ArrayList arrayList = new ArrayList(this.c.isEmpty() ? this.b : this.c);
        this.c.clear();
        this.c.add(Integer.valueOf(i));
        this.c.addAll(arrayList);
        int size = this.c.size();
        List list = k;
        if (size >= list.size()) {
            if (this.c.size() > list.size()) {
                this.c = this.c.subList(0, list.size());
            }
        } else {
            int size2 = this.c.size();
            while (true) {
                List list2 = k;
                if (size2 >= list2.size()) {
                    return;
                }
                this.c.add((Integer) list2.get(size2));
                size2++;
            }
        }
    }

    public void m(int i) {
        Integer num = (Integer) ((i < 0 || i >= this.b.size()) ? k : this.b).get(i);
        int iIntValue = num.intValue();
        ArrayList arrayList = new ArrayList(this.c.isEmpty() ? this.b : this.c);
        this.c.clear();
        this.c.add(num);
        for (int i2 = 0; i2 < 14; i2++) {
            if (i2 >= arrayList.size()) {
                this.c.add((Integer) k.get(i2));
            } else if (((Integer) arrayList.get(i2)).intValue() != iIntValue) {
                this.c.add((Integer) arrayList.get(i2));
            }
        }
        int size = this.c.size();
        List list = k;
        if (size >= list.size()) {
            if (this.c.size() > list.size()) {
                this.c = this.c.subList(0, list.size());
            }
        } else {
            int size2 = this.c.size();
            while (true) {
                List list2 = k;
                if (size2 >= list2.size()) {
                    return;
                }
                this.c.add((Integer) list2.get(size2));
                size2++;
            }
        }
    }

    public void n(int i) {
        this.f = i;
        this.a.edit().putInt("text_alignment", i).apply();
    }

    public void o(int i) {
        this.e = i;
        this.a.edit().putInt("brush", i).apply();
    }

    public void p(int i) {
        this.g = i;
        this.a.edit().putInt("text_type", i).apply();
    }

    public void q(String str) {
        this.i = str;
        this.a.edit().putString("typeface", str).apply();
    }

    public void r(float f) {
        this.h = f;
        this.a.edit().putFloat("weight", f).apply();
    }

    public void s(String str, float f) {
        this.a.edit().putFloat("weight_" + str, f).apply();
    }

    public void t() {
        this.j = !this.j;
        this.a.edit().putBoolean("fill_shapes", this.j).apply();
    }
}
