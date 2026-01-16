package ir.nasim.tgwidgets.editor.messenger;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.QY0;
import ir.nasim.tgwidgets.editor.messenger.G;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.SAXParserFactory;
import okio.Utf8;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes7.dex */
public abstract class G {
    private static final double[] a = new double[128];

    public static class a {
        float a;
        float b;
        float c;

        public a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    private static class b {
        float a;
        float b;
        float c;
        float d;

        public b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }
    }

    private static class c {
        private ArrayList a;
        private int b;

        public c(ArrayList arrayList, int i) {
            this.a = arrayList;
            this.b = i;
        }
    }

    private static class d {
        RectF a;

        public d(RectF rectF) {
            this.a = rectF;
        }
    }

    public static class e {
        private char a;
        private CharSequence b;
        public int c;
        private int d;

        public e(CharSequence charSequence, int i) {
            this.b = charSequence;
            this.c = i;
            this.d = charSequence.length();
            this.a = charSequence.charAt(i);
        }

        private char e() {
            int i = this.c;
            int i2 = this.d;
            if (i < i2) {
                this.c = i + 1;
            }
            int i3 = this.c;
            if (i3 == i2) {
                return (char) 0;
            }
            return this.b.charAt(i3);
        }

        private void f(char c) {
            throw new RuntimeException("Unexpected char '" + c + "'.");
        }

        public void a() {
            this.a = e();
        }

        public float b(int i, int i2) {
            if (i2 < -125 || i == 0) {
                return 0.0f;
            }
            if (i2 >= 128) {
                return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
            }
            if (i2 == 0) {
                return i;
            }
            if (i >= 67108864) {
                i++;
            }
            double d = i;
            double[] dArr = G.a;
            return (float) (i2 > 0 ? d * dArr[i2] : d / dArr[-i2]);
        }

        public float c() {
            h();
            float fD = d();
            g();
            return fD;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[LOOP:0: B:13:0x0028->B:84:?, LOOP_START] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[PHI: r4
          0x00ae: PHI (r4v1 boolean) = (r4v0 boolean), (r4v3 boolean) binds: [B:49:0x00a2, B:54:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00bb A[PHI: r4
          0x00bb: PHI (r4v2 boolean) = (r4v1 boolean), (r4v0 boolean) binds: [B:56:0x00b4, B:51:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public float d() {
            /*
                Method dump skipped, instructions count: 506
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.G.e.d():float");
        }

        public void g() {
            while (true) {
                int i = this.c;
                if (i >= this.d) {
                    return;
                }
                char cCharAt = this.b.charAt(i);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != ' ' && cCharAt != ',') {
                    return;
                } else {
                    a();
                }
            }
        }

        public void h() {
            while (true) {
                int i = this.c;
                if (i >= this.d || !Character.isWhitespace(this.b.charAt(i))) {
                    return;
                } else {
                    a();
                }
            }
        }
    }

    private static class f {
        ArrayList a;
        Attributes b;

        public String a(String str) {
            ArrayList arrayList = this.a;
            String strA = null;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    strA = ((i) this.a.get(i)).a(str);
                    if (strA != null) {
                        break;
                    }
                }
            }
            return strA == null ? G.q(str, this.b) : strA;
        }

        public Float b(String str) {
            String strA = a(str);
            if (strA == null) {
                return null;
            }
            try {
                return Float.valueOf(Float.parseFloat(strA));
            } catch (NumberFormatException unused) {
                return null;
            }
        }

        public Integer c(String str) {
            String strA = a(str);
            if (strA == null) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(strA.substring(1), 16));
            } catch (NumberFormatException unused) {
                return G.m(strA);
            }
        }

        public String d(String str) {
            return a(str);
        }

        private f(Attributes attributes, HashMap map) {
            this.b = attributes;
            String strQ = G.q("style", attributes);
            if (strQ != null) {
                ArrayList arrayList = new ArrayList();
                this.a = arrayList;
                arrayList.add(new i(strQ));
                return;
            }
            String strQ2 = G.q("class", attributes);
            if (strQ2 != null) {
                this.a = new ArrayList();
                for (String str : strQ2.split(Separators.SP)) {
                    i iVar = (i) map.get(str.trim());
                    if (iVar != null) {
                        this.a.add(iVar);
                    }
                }
            }
        }
    }

    private static class g {
        RectF a;
        float b;

        public g(RectF rectF, float f) {
            this.a = rectF;
            this.b = f;
        }
    }

    private static class h extends DefaultHandler {
        private Canvas a;
        private Bitmap b;
        private j c;
        private int d;
        private int e;
        private float f;
        private Paint g;
        private RectF h;
        private RectF i;
        private Integer j;
        private float k;
        boolean l;
        private HashMap m;
        private boolean n;
        private StringBuilder o;

        private void a(f fVar, Integer num, boolean z) {
            Integer num2 = this.j;
            if (num2 != null) {
                this.g.setColor(num2.intValue());
            } else {
                this.g.setColor((num.intValue() & 16777215) | (-16777216));
            }
            Float fB = fVar.b("opacity");
            if (fB == null) {
                fB = fVar.b(z ? "fill-opacity" : "stroke-opacity");
            }
            if (fB == null) {
                this.g.setAlpha(255);
            } else {
                this.g.setAlpha((int) (fB.floatValue() * 255.0f));
            }
        }

        private boolean b(f fVar) {
            if ("none".equals(fVar.d("display"))) {
                return false;
            }
            String strD = fVar.d("fill");
            if (strD != null && strD.startsWith("url(#")) {
                strD.substring(5, strD.length() - 1);
                return false;
            }
            Integer numC = fVar.c("fill");
            if (numC != null) {
                a(fVar, numC, true);
                this.g.setStyle(Paint.Style.FILL);
                return true;
            }
            if (fVar.d("fill") != null || fVar.d("stroke") != null) {
                return false;
            }
            this.g.setStyle(Paint.Style.FILL);
            Integer num = this.j;
            if (num != null) {
                this.g.setColor(num.intValue());
            } else {
                this.g.setColor(-16777216);
            }
            return true;
        }

        private boolean c(f fVar) {
            Integer numC;
            if ("none".equals(fVar.d("display")) || (numC = fVar.c("stroke")) == null) {
                return false;
            }
            a(fVar, numC, false);
            Float fB = fVar.b("stroke-width");
            if (fB != null) {
                this.g.setStrokeWidth(fB.floatValue());
            }
            String strD = fVar.d("stroke-linecap");
            if ("round".equals(strD)) {
                this.g.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(strD)) {
                this.g.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(strD)) {
                this.g.setStrokeCap(Paint.Cap.BUTT);
            }
            String strD2 = fVar.d("stroke-linejoin");
            if ("miter".equals(strD2)) {
                this.g.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(strD2)) {
                this.g.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(strD2)) {
                this.g.setStrokeJoin(Paint.Join.BEVEL);
            }
            this.g.setStyle(Paint.Style.STROKE);
            return true;
        }

        private void e() {
            if (this.l) {
                j jVar = this.c;
                if (jVar != null) {
                    jVar.d(null);
                } else {
                    this.a.restore();
                }
            }
        }

        private void f(Attributes attributes) {
            String strQ = G.q("transform", attributes);
            boolean z = strQ != null;
            this.l = z;
            if (z) {
                Matrix matrixS = G.s(strQ);
                j jVar = this.c;
                if (jVar != null) {
                    jVar.d(matrixS);
                } else {
                    this.a.save();
                    this.a.concat(matrixS);
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            StringBuilder sb = this.o;
            if (sb != null) {
                sb.append(cArr, i, i2);
            }
        }

        public Bitmap d() {
            return this.b;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            int iIndexOf;
            str2.hashCode();
            switch (str2) {
                case "g":
                case "defs":
                case "clipPath":
                    this.n = false;
                    break;
                case "style":
                    StringBuilder sb = this.o;
                    if (sb != null) {
                        String[] strArrSplit = sb.toString().split("\\}");
                        int i = 0;
                        while (true) {
                            if (i >= strArrSplit.length) {
                                this.o = null;
                                break;
                            } else {
                                String strReplace = strArrSplit[i].trim().replace(Separators.HT, "").replace(Separators.RETURN, "");
                                strArrSplit[i] = strReplace;
                                if (strReplace.length() != 0 && strArrSplit[i].charAt(0) == '.' && (iIndexOf = strArrSplit[i].indexOf(123)) >= 0) {
                                    this.m.put(strArrSplit[i].substring(1, iIndexOf).trim(), new i(strArrSplit[i].substring(iIndexOf + 1)));
                                }
                                i++;
                            }
                        }
                    }
                    break;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            String strQ;
            int i;
            if (!this.n || str2.equals("style")) {
                str2.hashCode();
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1656480802:
                        if (str2.equals("ellipse")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1360216880:
                        if (str2.equals("circle")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -397519558:
                        if (str2.equals("polygon")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 103:
                        if (str2.equals("g")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 114276:
                        if (str2.equals("svg")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3079438:
                        if (str2.equals("defs")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3321844:
                        if (str2.equals("line")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3433509:
                        if (str2.equals("path")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 3496420:
                        if (str2.equals("rect")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 109780401:
                        if (str2.equals("style")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 561938880:
                        if (str2.equals("polyline")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 917656469:
                        if (str2.equals("clipPath")) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Float fN = G.n("cx", attributes);
                        Float fN2 = G.n("cy", attributes);
                        Float fN3 = G.n("rx", attributes);
                        Float fN4 = G.n("ry", attributes);
                        if (fN != null && fN2 != null && fN3 != null && fN4 != null) {
                            f(attributes);
                            f fVar = new f(attributes, this.m);
                            this.h.set(fN.floatValue() - fN3.floatValue(), fN2.floatValue() - fN4.floatValue(), fN.floatValue() + fN3.floatValue(), fN2.floatValue() + fN4.floatValue());
                            if (b(fVar)) {
                                j jVar = this.c;
                                if (jVar != null) {
                                    jVar.e(new d(this.h), this.g);
                                } else {
                                    this.a.drawOval(this.h, this.g);
                                }
                            }
                            if (c(fVar)) {
                                j jVar2 = this.c;
                                if (jVar2 != null) {
                                    jVar2.e(new d(this.h), this.g);
                                } else {
                                    this.a.drawOval(this.h, this.g);
                                }
                            }
                            e();
                            break;
                        }
                        break;
                    case 1:
                        Float fN5 = G.n("cx", attributes);
                        Float fN6 = G.n("cy", attributes);
                        Float fN7 = G.n("r", attributes);
                        if (fN5 != null && fN6 != null && fN7 != null) {
                            f(attributes);
                            f fVar2 = new f(attributes, this.m);
                            if (b(fVar2)) {
                                j jVar3 = this.c;
                                if (jVar3 != null) {
                                    jVar3.e(new a(fN5.floatValue(), fN6.floatValue(), fN7.floatValue()), this.g);
                                } else {
                                    this.a.drawCircle(fN5.floatValue(), fN6.floatValue(), fN7.floatValue(), this.g);
                                }
                            }
                            if (c(fVar2)) {
                                j jVar4 = this.c;
                                if (jVar4 != null) {
                                    jVar4.e(new a(fN5.floatValue(), fN6.floatValue(), fN7.floatValue()), this.g);
                                } else {
                                    this.a.drawCircle(fN5.floatValue(), fN6.floatValue(), fN7.floatValue(), this.g);
                                }
                            }
                            e();
                            break;
                        }
                        break;
                    case 2:
                    case '\n':
                        c cVarP = G.p("points", attributes);
                        if (cVarP != null) {
                            Path path = new Path();
                            ArrayList arrayList = cVarP.a;
                            if (arrayList.size() > 1) {
                                f(attributes);
                                f fVar3 = new f(attributes, this.m);
                                path.moveTo(((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
                                for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
                                    path.lineTo(((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue());
                                }
                                if (str2.equals("polygon")) {
                                    path.close();
                                }
                                if (b(fVar3)) {
                                    j jVar5 = this.c;
                                    if (jVar5 != null) {
                                        jVar5.e(path, this.g);
                                    } else {
                                        this.a.drawPath(path, this.g);
                                    }
                                }
                                if (c(fVar3)) {
                                    j jVar6 = this.c;
                                    if (jVar6 != null) {
                                        jVar6.e(path, this.g);
                                    } else {
                                        this.a.drawPath(path, this.g);
                                    }
                                }
                                e();
                                break;
                            }
                        }
                        break;
                    case 3:
                        if ("bounds".equalsIgnoreCase(G.q("id", attributes))) {
                            this.n = true;
                            break;
                        }
                        break;
                    case 4:
                        Float fN8 = G.n("width", attributes);
                        Float fN9 = G.n("height", attributes);
                        if ((fN8 == null || fN9 == null) && (strQ = G.q("viewBox", attributes)) != null) {
                            String[] strArrSplit = strQ.split(Separators.SP);
                            Float fValueOf = Float.valueOf(Float.parseFloat(strArrSplit[2]));
                            fN9 = Float.valueOf(Float.parseFloat(strArrSplit[3]));
                            fN8 = fValueOf;
                        }
                        if (fN8 == null || fN9 == null) {
                            fN8 = Float.valueOf(this.d);
                            fN9 = Float.valueOf(this.e);
                        }
                        int iCeil = (int) Math.ceil(fN8.floatValue());
                        int iCeil2 = (int) Math.ceil(fN9.floatValue());
                        if (iCeil == 0 || iCeil2 == 0) {
                            iCeil = this.d;
                            iCeil2 = this.e;
                        } else {
                            int i3 = this.d;
                            if (i3 != 0 && (i = this.e) != 0) {
                                float f = iCeil;
                                float f2 = iCeil2;
                                float fMin = Math.min(i3 / f, i / f2);
                                this.f = fMin;
                                iCeil = (int) (f * fMin);
                                iCeil2 = (int) (f2 * fMin);
                            }
                        }
                        j jVar7 = this.c;
                        if (jVar7 == null) {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
                            this.b = bitmapCreateBitmap;
                            bitmapCreateBitmap.eraseColor(0);
                            Canvas canvas = new Canvas(this.b);
                            this.a = canvas;
                            float f3 = this.f;
                            if (f3 != 0.0f) {
                                float f4 = this.k;
                                canvas.scale(f4 * f3, f4 * f3);
                                break;
                            }
                        } else {
                            jVar7.e = iCeil;
                            jVar7.f = iCeil2;
                            break;
                        }
                        break;
                    case 5:
                    case 11:
                        this.n = true;
                        break;
                    case 6:
                        Float fN10 = G.n("x1", attributes);
                        Float fN11 = G.n("x2", attributes);
                        Float fN12 = G.n("y1", attributes);
                        Float fN13 = G.n("y2", attributes);
                        if (c(new f(attributes, this.m))) {
                            f(attributes);
                            j jVar8 = this.c;
                            if (jVar8 != null) {
                                jVar8.e(new b(fN10.floatValue(), fN12.floatValue(), fN11.floatValue(), fN13.floatValue()), this.g);
                            } else {
                                this.a.drawLine(fN10.floatValue(), fN12.floatValue(), fN11.floatValue(), fN13.floatValue(), this.g);
                            }
                            e();
                            break;
                        }
                        break;
                    case 7:
                        Path pathI = G.i(G.q("d", attributes));
                        f(attributes);
                        f fVar4 = new f(attributes, this.m);
                        if (b(fVar4)) {
                            j jVar9 = this.c;
                            if (jVar9 != null) {
                                jVar9.e(pathI, this.g);
                            } else {
                                this.a.drawPath(pathI, this.g);
                            }
                        }
                        if (c(fVar4)) {
                            j jVar10 = this.c;
                            if (jVar10 != null) {
                                jVar10.e(pathI, this.g);
                            } else {
                                this.a.drawPath(pathI, this.g);
                            }
                        }
                        e();
                        break;
                    case '\b':
                        Float fN14 = G.n("x", attributes);
                        if (fN14 == null) {
                            fN14 = Float.valueOf(0.0f);
                        }
                        Float fN15 = G.n("y", attributes);
                        if (fN15 == null) {
                            fN15 = Float.valueOf(0.0f);
                        }
                        Float fN16 = G.n("width", attributes);
                        Float fN17 = G.n("height", attributes);
                        Float fO = G.o("rx", attributes, null);
                        f(attributes);
                        f fVar5 = new f(attributes, this.m);
                        if (b(fVar5)) {
                            j jVar11 = this.c;
                            if (jVar11 != null) {
                                if (fO != null) {
                                    jVar11.e(new g(new RectF(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue()), fO.floatValue()), this.g);
                                } else {
                                    jVar11.e(new RectF(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue()), this.g);
                                }
                            } else if (fO != null) {
                                this.i.set(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue());
                                this.a.drawRoundRect(this.i, fO.floatValue(), fO.floatValue(), this.g);
                            } else {
                                this.a.drawRect(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue(), this.g);
                            }
                        }
                        if (c(fVar5)) {
                            j jVar12 = this.c;
                            if (jVar12 != null) {
                                if (fO != null) {
                                    jVar12.e(new g(new RectF(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue()), fO.floatValue()), this.g);
                                } else {
                                    jVar12.e(new RectF(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue()), this.g);
                                }
                            } else if (fO != null) {
                                this.i.set(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue());
                                this.a.drawRoundRect(this.i, fO.floatValue(), fO.floatValue(), this.g);
                            } else {
                                this.a.drawRect(fN14.floatValue(), fN15.floatValue(), fN14.floatValue() + fN16.floatValue(), fN15.floatValue() + fN17.floatValue(), this.g);
                            }
                        }
                        e();
                        break;
                    case '\t':
                        this.o = new StringBuilder();
                        break;
                }
            }
        }

        private h(int i, int i2, Integer num, boolean z, float f) {
            this.f = 1.0f;
            this.g = new Paint(1);
            this.h = new RectF();
            this.i = new RectF();
            this.k = 1.0f;
            this.l = false;
            this.m = new HashMap();
            this.k = f;
            this.d = i;
            this.e = i2;
            this.j = num;
            if (z) {
                this.c = new j();
            }
        }
    }

    private static class i {
        HashMap a;

        public String a(String str) {
            return (String) this.a.get(str);
        }

        private i(String str) {
            this.a = new HashMap();
            for (String str2 : str.split(Separators.SEMICOLON)) {
                String[] strArrSplit = str2.split(":");
                if (strArrSplit.length == 2) {
                    this.a.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                }
            }
        }
    }

    public static class j extends Drawable {
        private static float v;
        private static float w;
        private static long x;
        private static Runnable y;
        private static WeakReference z;
        private Paint c;
        private Paint d;
        protected int e;
        protected int f;
        private ImageReceiver k;
        private int m;
        private Integer n;
        private m.h o;
        private float p;
        private static int[] u = new int[2];
        private static boolean A = v.e(32);
        protected ArrayList a = new ArrayList();
        protected HashMap b = new HashMap();
        private Bitmap[] g = new Bitmap[3];
        private Canvas[] h = new Canvas[3];
        private LinearGradient[] i = new LinearGradient[3];
        private Matrix[] j = new Matrix[3];
        private int[] l = new int[2];
        private float q = 1.0f;
        SparseArray r = new SparseArray();
        private boolean s = true;
        private boolean t = false;

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Object obj) {
            this.a.add(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Object obj, Paint paint) {
            this.a.add(obj);
            this.b.put(obj, new Paint(paint));
        }

        public static void l() {
            A = v.e(32);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            g(canvas, false, 0, System.currentTimeMillis(), getBounds().left, getBounds().top, getBounds().width(), getBounds().height());
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public j clone() {
            j jVar = new j();
            for (int i = 0; i < this.a.size(); i++) {
                jVar.a.add(this.a.get(i));
                Paint paint = (Paint) this.b.get(this.a.get(i));
                if (paint != null) {
                    Paint paint2 = new Paint();
                    paint2.setColor(paint.getColor());
                    paint2.setStrokeCap(paint.getStrokeCap());
                    paint2.setStrokeJoin(paint.getStrokeJoin());
                    paint2.setStrokeWidth(paint.getStrokeWidth());
                    paint2.setStyle(paint.getStyle());
                    jVar.b.put(this.a.get(i), paint2);
                }
            }
            jVar.e = this.e;
            jVar.f = this.f;
            return jVar;
        }

        public void g(Canvas canvas, boolean z2, int i, long j, float f, float f2, float f3, float f4) {
            long j2;
            int i2;
            int i3 = this.m;
            if (i3 >= 0) {
                k(i3, this.o, this.p, z2);
            }
            float fH = h((int) f3, (int) f4);
            if (this.i[i] != null) {
                float f5 = w;
                if (f5 > 0.0f && A) {
                    if (z2) {
                        long j3 = j - x;
                        j2 = j3 <= 64 ? j3 : 64L;
                        if (j2 > 0) {
                            x = j;
                            v += (j2 * f5) / 1800.0f;
                            while (true) {
                                float f6 = v;
                                float f7 = w;
                                if (f6 < f7 * 2.0f) {
                                    break;
                                } else {
                                    v = f6 - (f7 * 2.0f);
                                }
                            }
                        }
                    } else if (y == null || z.get() == this) {
                        long j4 = j - x;
                        j2 = j4 <= 64 ? j4 : 64L;
                        long j5 = j2 >= 0 ? j2 : 0L;
                        x = j;
                        v += (j5 * w) / 1800.0f;
                        while (true) {
                            float f8 = v;
                            float f9 = w;
                            if (f8 < f9 / 2.0f) {
                                break;
                            } else {
                                v = f8 - f9;
                            }
                        }
                        z = new WeakReference(this);
                        Runnable runnable = y;
                        if (runnable != null) {
                            AbstractC21455b.t(runnable);
                        }
                        Runnable runnable2 = new Runnable() { // from class: ir.nasim.E37
                            @Override // java.lang.Runnable
                            public final void run() {
                                G.j.y = null;
                            }
                        };
                        y = runnable2;
                        AbstractC21455b.n1(runnable2, ((int) (1000.0f / AbstractC21455b.i)) - 1);
                    }
                    ImageReceiver imageReceiver = this.k;
                    if (imageReceiver == null || z2) {
                        i2 = 0;
                    } else {
                        imageReceiver.T(u);
                        i2 = u[0];
                    }
                    int i4 = z2 ? i + 1 : 0;
                    Matrix matrix = this.j[i4];
                    if (matrix != null) {
                        matrix.reset();
                        if (z2) {
                            this.j[i4].postTranslate(((-i2) + v) - f, 0.0f);
                        } else {
                            this.j[i4].postTranslate(((-i2) + v) - f, 0.0f);
                        }
                        float f10 = 1.0f / fH;
                        this.j[i4].postScale(f10, f10);
                        this.i[i4].setLocalMatrix(this.j[i4]);
                        ImageReceiver imageReceiver2 = this.k;
                        if (imageReceiver2 != null && !z2) {
                            imageReceiver2.h0();
                        }
                    }
                }
            }
            canvas.save();
            canvas.translate(f, f2);
            if (!this.s || this.t) {
                canvas.translate((f3 - (this.e * fH)) / 2.0f, (f4 - (this.f * fH)) / 2.0f);
            }
            canvas.scale(fH, fH);
            int size = this.a.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = this.a.get(i5);
                if (obj instanceof Matrix) {
                    canvas.save();
                    canvas.concat((Matrix) obj);
                } else if (obj == null) {
                    canvas.restore();
                } else {
                    Paint paint = (Paint) this.r.get(i5);
                    if (paint == null) {
                        paint = this.c;
                    }
                    if (z2) {
                        paint = this.d;
                    } else if (paint == null) {
                        paint = (Paint) this.b.get(obj);
                    }
                    int alpha = paint.getAlpha();
                    paint.setAlpha((int) (this.q * alpha));
                    if (obj instanceof Path) {
                        canvas.drawPath((Path) obj, paint);
                    } else if (obj instanceof Rect) {
                        canvas.drawRect((Rect) obj, paint);
                    } else if (obj instanceof RectF) {
                        canvas.drawRect((RectF) obj, paint);
                    } else if (obj instanceof b) {
                        b bVar = (b) obj;
                        canvas.drawLine(bVar.a, bVar.b, bVar.c, bVar.d, paint);
                    } else if (obj instanceof a) {
                        a aVar = (a) obj;
                        canvas.drawCircle(aVar.a, aVar.b, aVar.c, paint);
                    } else if (obj instanceof d) {
                        canvas.drawOval(((d) obj).a, paint);
                    } else if (obj instanceof g) {
                        g gVar = (g) obj;
                        RectF rectF = gVar.a;
                        float f11 = gVar.b;
                        canvas.drawRoundRect(rectF, f11, f11, paint);
                    }
                    paint.setAlpha(alpha);
                }
            }
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.e;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        public float h(int i, int i2) {
            float f = i / this.e;
            float f2 = i2 / this.f;
            return this.s ? Math.max(f, f2) : Math.min(f, f2);
        }

        public void j(ImageReceiver imageReceiver) {
            this.k = imageReceiver;
        }

        public void k(int i, m.h hVar, float f, boolean z2) {
            Shader bitmapShader;
            Integer num = this.n;
            int iJ0 = num == null ? ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, hVar) : num.intValue();
            this.o = hVar;
            int[] iArr = this.l;
            if (iArr[z2 ? 1 : 0] != iJ0) {
                this.p = f;
                this.m = i;
                iArr[z2 ? 1 : 0] = iJ0;
                w = AbstractC21455b.h.x * 2;
                if (!A) {
                    int iK = QY0.k(iJ0, 70);
                    if (z2) {
                        if (this.d == null) {
                            this.d = new Paint(1);
                        }
                        this.d.setShader(null);
                        this.d.setColor(iK);
                        return;
                    }
                    for (Paint paint : this.b.values()) {
                        paint.setShader(null);
                        paint.setColor(iK);
                    }
                    return;
                }
                float F = AbstractC21455b.F(180.0f) / w;
                int iArgb = Color.argb((int) ((Color.alpha(iJ0) / 2) * this.p), Color.red(iJ0), Color.green(iJ0), Color.blue(iJ0));
                float f2 = (1.0f - F) / 2.0f;
                LinearGradient[] linearGradientArr = this.i;
                float f3 = F / 2.0f;
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                linearGradientArr[z2 ? 1 : 0] = new LinearGradient(0.0f, 0.0f, w, 0.0f, new int[]{0, 0, iArgb, 0, 0}, new float[]{0.0f, f2 - f3, f2, f3 + f2, 1.0f}, tileMode);
                if (Build.VERSION.SDK_INT >= 28) {
                    bitmapShader = new LinearGradient(0.0f, 0.0f, w, 0.0f, new int[]{iArgb, iArgb}, (float[]) null, tileMode);
                } else {
                    Bitmap[] bitmapArr = this.g;
                    if (bitmapArr[z2 ? 1 : 0] == null) {
                        bitmapArr[z2 ? 1 : 0] = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        this.h[z2 ? 1 : 0] = new Canvas(this.g[z2 ? 1 : 0]);
                    }
                    this.h[z2 ? 1 : 0].drawColor(iArgb);
                    bitmapShader = new BitmapShader(this.g[z2 ? 1 : 0], tileMode, tileMode);
                }
                this.j[z2 ? 1 : 0] = new Matrix();
                this.i[z2 ? 1 : 0].setLocalMatrix(this.j[z2 ? 1 : 0]);
                if (z2) {
                    if (this.d == null) {
                        this.d = new Paint(1);
                    }
                    this.d.setShader(new ComposeShader(this.i[z2 ? 1 : 0], bitmapShader, PorterDuff.Mode.ADD));
                } else {
                    Iterator it = this.b.values().iterator();
                    while (it.hasNext()) {
                        ((Paint) it.next()).setShader(new ComposeShader(this.i[z2 ? 1 : 0], bitmapShader, PorterDuff.Mode.ADD));
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.q = i / 255.0f;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static {
        int i2 = 0;
        while (true) {
            double[] dArr = a;
            if (i2 >= dArr.length) {
                return;
            }
            dArr[i2] = Math.pow(10.0d, i2);
            i2++;
        }
    }

    public static String h(byte[] bArr) {
        try {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            sb.append('M');
            for (byte b2 : bArr) {
                int i2 = b2 & 255;
                if (i2 >= 192) {
                    sb.append("AACAAAAHAAALMAAAQASTAVAAAZaacaaaahaaalmaaaqastava.az0123456789-,".charAt(i2 - 192));
                } else {
                    if (i2 >= 128) {
                        sb.append(',');
                    } else if (i2 >= 64) {
                        sb.append('-');
                    }
                    sb.append(b2 & Utf8.REPLACEMENT_BYTE);
                }
            }
            sb.append('z');
            return sb.toString();
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Path i(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.G.i(java.lang.String):android.graphics.Path");
    }

    private static void j(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2, int i3) {
    }

    public static Bitmap k(File file, int i2, int i3, boolean z) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                h hVar = new h(i2, i3, z ? -1 : null, false, 1.0f);
                xMLReader.setContentHandler(hVar);
                xMLReader.parse(new InputSource(fileInputStream));
                Bitmap bitmapD = hVar.d();
                fileInputStream.close();
                return bitmapD;
            } finally {
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return null;
        }
    }

    public static Bitmap l(String str, int i2, int i3, boolean z) throws SAXException, IOException {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            h hVar = new h(i2, i3, z ? -1 : null, false, 1.0f);
            xMLReader.setContentHandler(hVar);
            xMLReader.parse(new InputSource(new StringReader(str)));
            return hVar.d();
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer m(java.lang.String r2) {
        /*
            java.lang.String r2 = r2.toLowerCase()
            r2.hashCode()
            int r0 = r2.hashCode()
            r1 = -1
            switch(r0) {
                case -734239628: goto L6c;
                case 112785: goto L61;
                case 3027034: goto L56;
                case 3068707: goto L4b;
                case 3181155: goto L40;
                case 93818879: goto L35;
                case 98619139: goto L2a;
                case 113101865: goto L1f;
                case 828922025: goto L12;
                default: goto Lf;
            }
        Lf:
            r2 = r1
            goto L76
        L12:
            java.lang.String r0 = "magenta"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L1b
            goto Lf
        L1b:
            r2 = 8
            goto L76
        L1f:
            java.lang.String r0 = "white"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L28
            goto Lf
        L28:
            r2 = 7
            goto L76
        L2a:
            java.lang.String r0 = "green"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L33
            goto Lf
        L33:
            r2 = 6
            goto L76
        L35:
            java.lang.String r0 = "black"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3e
            goto Lf
        L3e:
            r2 = 5
            goto L76
        L40:
            java.lang.String r0 = "gray"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L49
            goto Lf
        L49:
            r2 = 4
            goto L76
        L4b:
            java.lang.String r0 = "cyan"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L54
            goto Lf
        L54:
            r2 = 3
            goto L76
        L56:
            java.lang.String r0 = "blue"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5f
            goto Lf
        L5f:
            r2 = 2
            goto L76
        L61:
            java.lang.String r0 = "red"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L6a
            goto Lf
        L6a:
            r2 = 1
            goto L76
        L6c:
            java.lang.String r0 = "yellow"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L75
            goto Lf
        L75:
            r2 = 0
        L76:
            switch(r2) {
                case 0: goto Lb6;
                case 1: goto Laf;
                case 2: goto La7;
                case 3: goto L9f;
                case 4: goto L97;
                case 5: goto L90;
                case 6: goto L88;
                case 7: goto L83;
                case 8: goto L7b;
                default: goto L79;
            }
        L79:
            r2 = 0
            return r2
        L7b:
            r2 = -65281(0xffffffffffff00ff, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L83:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            return r2
        L88:
            r2 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L90:
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L97:
            r2 = -7829368(0xffffffffff888888, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L9f:
            r2 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        La7:
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        Laf:
            r2 = -65536(0xffffffffffff0000, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        Lb6:
            r2 = -256(0xffffffffffffff00, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.G.m(java.lang.String):java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float n(String str, Attributes attributes) {
        return o(str, attributes, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Float o(String str, Attributes attributes, Float f2) {
        String strQ = q(str, attributes);
        if (strQ == null) {
            return f2;
        }
        if (strQ.endsWith("px")) {
            strQ = strQ.substring(0, strQ.length() - 2);
        } else if (strQ.endsWith("mm")) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(strQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c p(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            if (attributes.getLocalName(i2).equals(str)) {
                return r(attributes.getValue(i2));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            if (attributes.getLocalName(i2).equals(str)) {
                return attributes.getValue(i2);
            }
        }
        return null;
    }

    private static c r(String str) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int length2 = 0;
        boolean z = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (z) {
                z = false;
            } else {
                char cCharAt = str.charAt(i2);
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                    case '-':
                        if (cCharAt != '-' || str.charAt(i2 - 1) != 'e') {
                            String strSubstring = str.substring(length2, i2);
                            if (strSubstring.trim().length() > 0) {
                                arrayList.add(Float.valueOf(Float.parseFloat(strSubstring)));
                                if (cCharAt == '-') {
                                    length2 = i2;
                                    break;
                                } else {
                                    length2 = i2 + 1;
                                    z = true;
                                    break;
                                }
                            } else {
                                length2++;
                                break;
                            }
                        } else {
                            break;
                        }
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                    case 'M':
                    case 'Q':
                    case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                    case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                    case 'V':
                    case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                    case WKSRecord.Service.SWIFT_RVF /* 97 */:
                    case 'c':
                    case 'h':
                    case Type.EUI48 /* 108 */:
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER /* 118 */:
                    case 'z':
                        String strSubstring2 = str.substring(length2, i2);
                        if (strSubstring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(strSubstring2)));
                        }
                        return new c(arrayList, i2);
                }
            }
        }
        String strSubstring3 = str.substring(length2);
        if (strSubstring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(strSubstring3)));
            } catch (NumberFormatException unused) {
            }
            length2 = str.length();
        }
        return new c(arrayList, length2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Matrix s(String str) {
        float fFloatValue;
        if (str.startsWith("matrix(")) {
            c cVarR = r(str.substring(7));
            if (cVarR.a.size() != 6) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{((Float) cVarR.a.get(0)).floatValue(), ((Float) cVarR.a.get(2)).floatValue(), ((Float) cVarR.a.get(4)).floatValue(), ((Float) cVarR.a.get(1)).floatValue(), ((Float) cVarR.a.get(3)).floatValue(), ((Float) cVarR.a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
            return matrix;
        }
        if (str.startsWith("translate(")) {
            c cVarR2 = r(str.substring(10));
            if (cVarR2.a.size() <= 0) {
                return null;
            }
            float fFloatValue2 = ((Float) cVarR2.a.get(0)).floatValue();
            fFloatValue = cVarR2.a.size() > 1 ? ((Float) cVarR2.a.get(1)).floatValue() : 0.0f;
            Matrix matrix2 = new Matrix();
            matrix2.postTranslate(fFloatValue2, fFloatValue);
            return matrix2;
        }
        if (str.startsWith("scale(")) {
            c cVarR3 = r(str.substring(6));
            if (cVarR3.a.size() <= 0) {
                return null;
            }
            float fFloatValue3 = ((Float) cVarR3.a.get(0)).floatValue();
            fFloatValue = cVarR3.a.size() > 1 ? ((Float) cVarR3.a.get(1)).floatValue() : 0.0f;
            Matrix matrix3 = new Matrix();
            matrix3.postScale(fFloatValue3, fFloatValue);
            return matrix3;
        }
        if (str.startsWith("skewX(")) {
            c cVarR4 = r(str.substring(6));
            if (cVarR4.a.size() <= 0) {
                return null;
            }
            float fFloatValue4 = ((Float) cVarR4.a.get(0)).floatValue();
            Matrix matrix4 = new Matrix();
            matrix4.postSkew((float) Math.tan(fFloatValue4), 0.0f);
            return matrix4;
        }
        if (str.startsWith("skewY(")) {
            c cVarR5 = r(str.substring(6));
            if (cVarR5.a.size() <= 0) {
                return null;
            }
            float fFloatValue5 = ((Float) cVarR5.a.get(0)).floatValue();
            Matrix matrix5 = new Matrix();
            matrix5.postSkew(0.0f, (float) Math.tan(fFloatValue5));
            return matrix5;
        }
        if (!str.startsWith("rotate(")) {
            return null;
        }
        c cVarR6 = r(str.substring(7));
        if (cVarR6.a.size() <= 0) {
            return null;
        }
        float fFloatValue6 = ((Float) cVarR6.a.get(0)).floatValue();
        if (cVarR6.a.size() > 2) {
            fFloatValue = ((Float) cVarR6.a.get(1)).floatValue();
            fFloatValue = ((Float) cVarR6.a.get(2)).floatValue();
        } else {
            fFloatValue = 0.0f;
        }
        Matrix matrix6 = new Matrix();
        matrix6.postTranslate(fFloatValue, fFloatValue);
        matrix6.postRotate(fFloatValue6);
        matrix6.postTranslate(-fFloatValue, -fFloatValue);
        return matrix6;
    }
}
