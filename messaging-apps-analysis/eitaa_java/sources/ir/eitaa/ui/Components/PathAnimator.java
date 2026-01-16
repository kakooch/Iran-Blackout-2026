package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PathAnimator {
    private float durationScale;
    private float scale;
    private float tx;
    private float ty;
    private Path path = new Path();
    private float pathTime = -1.0f;
    private ArrayList<KeyFrame> keyFrames = new ArrayList<>();

    private static class KeyFrame {
        public ArrayList<Object> commands;
        public float time;

        private KeyFrame() {
            this.commands = new ArrayList<>();
        }
    }

    private static class MoveTo {
        public float x;
        public float y;

        private MoveTo() {
        }
    }

    private static class LineTo {
        public float x;
        public float y;

        private LineTo() {
        }
    }

    private static class CurveTo {
        public float x;
        public float x1;
        public float x2;
        public float y;
        public float y1;
        public float y2;

        private CurveTo() {
        }
    }

    public PathAnimator(float sc, float x, float y, float dsc) {
        this.scale = sc;
        this.tx = x;
        this.ty = y;
        this.durationScale = dsc;
    }

    public void addSvgKeyFrame(String svg, float ms) {
        if (svg == null) {
            return;
        }
        try {
            KeyFrame keyFrame = new KeyFrame();
            keyFrame.time = ms * this.durationScale;
            String[] strArrSplit = svg.split(" ");
            int i = 0;
            while (i < strArrSplit.length) {
                char cCharAt = strArrSplit[i].charAt(0);
                if (cCharAt == 'C') {
                    CurveTo curveTo = new CurveTo();
                    curveTo.x1 = (Float.parseFloat(strArrSplit[i + 1]) + this.tx) * this.scale;
                    curveTo.y1 = (Float.parseFloat(strArrSplit[i + 2]) + this.ty) * this.scale;
                    curveTo.x2 = (Float.parseFloat(strArrSplit[i + 3]) + this.tx) * this.scale;
                    curveTo.y2 = (Float.parseFloat(strArrSplit[i + 4]) + this.ty) * this.scale;
                    curveTo.x = (Float.parseFloat(strArrSplit[i + 5]) + this.tx) * this.scale;
                    i += 6;
                    curveTo.y = (Float.parseFloat(strArrSplit[i]) + this.ty) * this.scale;
                    keyFrame.commands.add(curveTo);
                } else if (cCharAt == 'L') {
                    LineTo lineTo = new LineTo();
                    lineTo.x = (Float.parseFloat(strArrSplit[i + 1]) + this.tx) * this.scale;
                    i += 2;
                    lineTo.y = (Float.parseFloat(strArrSplit[i]) + this.ty) * this.scale;
                    keyFrame.commands.add(lineTo);
                } else if (cCharAt == 'M') {
                    MoveTo moveTo = new MoveTo();
                    moveTo.x = (Float.parseFloat(strArrSplit[i + 1]) + this.tx) * this.scale;
                    i += 2;
                    moveTo.y = (Float.parseFloat(strArrSplit[i]) + this.ty) * this.scale;
                    keyFrame.commands.add(moveTo);
                }
                i++;
            }
            this.keyFrames.add(keyFrame);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void draw(Canvas canvas, Paint paint, float time) {
        float f;
        if (this.pathTime != time) {
            this.pathTime = time;
            int size = this.keyFrames.size();
            KeyFrame keyFrame = null;
            KeyFrame keyFrame2 = null;
            for (int i = 0; i < size; i++) {
                KeyFrame keyFrame3 = this.keyFrames.get(i);
                if ((keyFrame2 == null || keyFrame2.time < keyFrame3.time) && keyFrame3.time <= time) {
                    keyFrame2 = keyFrame3;
                }
                if ((keyFrame == null || keyFrame.time > keyFrame3.time) && keyFrame3.time >= time) {
                    keyFrame = keyFrame3;
                }
            }
            if (keyFrame == keyFrame2) {
                keyFrame2 = null;
            }
            if (keyFrame2 != null && keyFrame == null) {
                keyFrame = keyFrame2;
                keyFrame2 = null;
            }
            if (keyFrame == null) {
                return;
            }
            if (keyFrame2 != null && keyFrame2.commands.size() != keyFrame.commands.size()) {
                return;
            }
            this.path.reset();
            int size2 = keyFrame.commands.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Object obj = keyFrame2 != null ? keyFrame2.commands.get(i2) : null;
                Object obj2 = keyFrame.commands.get(i2);
                if (obj != null && obj.getClass() != obj2.getClass()) {
                    return;
                }
                if (keyFrame2 != null) {
                    float f2 = keyFrame2.time;
                    f = (time - f2) / (keyFrame.time - f2);
                } else {
                    f = 1.0f;
                }
                if (obj2 instanceof MoveTo) {
                    MoveTo moveTo = (MoveTo) obj2;
                    MoveTo moveTo2 = (MoveTo) obj;
                    if (moveTo2 != null) {
                        Path path = this.path;
                        float f3 = moveTo2.x;
                        float fDpf2 = AndroidUtilities.dpf2(f3 + ((moveTo.x - f3) * f));
                        float f4 = moveTo2.y;
                        path.moveTo(fDpf2, AndroidUtilities.dpf2(f4 + ((moveTo.y - f4) * f)));
                    } else {
                        this.path.moveTo(AndroidUtilities.dpf2(moveTo.x), AndroidUtilities.dpf2(moveTo.y));
                    }
                } else if (obj2 instanceof LineTo) {
                    LineTo lineTo = (LineTo) obj2;
                    LineTo lineTo2 = (LineTo) obj;
                    if (lineTo2 != null) {
                        Path path2 = this.path;
                        float f5 = lineTo2.x;
                        float fDpf22 = AndroidUtilities.dpf2(f5 + ((lineTo.x - f5) * f));
                        float f6 = lineTo2.y;
                        path2.lineTo(fDpf22, AndroidUtilities.dpf2(f6 + ((lineTo.y - f6) * f)));
                    } else {
                        this.path.lineTo(AndroidUtilities.dpf2(lineTo.x), AndroidUtilities.dpf2(lineTo.y));
                    }
                } else if (obj2 instanceof CurveTo) {
                    CurveTo curveTo = (CurveTo) obj2;
                    CurveTo curveTo2 = (CurveTo) obj;
                    if (curveTo2 != null) {
                        Path path3 = this.path;
                        float f7 = curveTo2.x1;
                        float fDpf23 = AndroidUtilities.dpf2(f7 + ((curveTo.x1 - f7) * f));
                        float f8 = curveTo2.y1;
                        float fDpf24 = AndroidUtilities.dpf2(f8 + ((curveTo.y1 - f8) * f));
                        float f9 = curveTo2.x2;
                        float fDpf25 = AndroidUtilities.dpf2(f9 + ((curveTo.x2 - f9) * f));
                        float f10 = curveTo2.y2;
                        float fDpf26 = AndroidUtilities.dpf2(f10 + ((curveTo.y2 - f10) * f));
                        float f11 = curveTo2.x;
                        float fDpf27 = AndroidUtilities.dpf2(f11 + ((curveTo.x - f11) * f));
                        float f12 = curveTo2.y;
                        path3.cubicTo(fDpf23, fDpf24, fDpf25, fDpf26, fDpf27, AndroidUtilities.dpf2(f12 + ((curveTo.y - f12) * f)));
                    } else {
                        this.path.cubicTo(AndroidUtilities.dpf2(curveTo.x1), AndroidUtilities.dpf2(curveTo.y1), AndroidUtilities.dpf2(curveTo.x2), AndroidUtilities.dpf2(curveTo.y2), AndroidUtilities.dpf2(curveTo.x), AndroidUtilities.dpf2(curveTo.y));
                    }
                }
            }
            this.path.close();
        }
        canvas.drawPath(this.path, paint);
    }
}
