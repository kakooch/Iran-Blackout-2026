package org.rbmain.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class SnowflakesEffect {
    private int color;
    private long lastAnimationTime;
    Bitmap particleBitmap;
    private Paint particlePaint;
    private Paint particleThinPaint;
    private int viewType;
    private Paint bitmapPaint = new Paint();
    private int colorKey = Theme.key_actionBarDefaultTitle;
    private ArrayList<Particle> particles = new ArrayList<>();
    private ArrayList<Particle> freeParticles = new ArrayList<>();

    private class Particle {
        float alpha;
        float currentTime;
        float lifeTime;
        float scale;
        int type;
        float velocity;
        float vx;
        float vy;
        float x;
        float y;

        private Particle() {
        }

        public void draw(Canvas canvas) {
            if (this.type == 0) {
                SnowflakesEffect.this.particlePaint.setAlpha((int) (this.alpha * 255.0f));
                canvas.drawPoint(this.x, this.y, SnowflakesEffect.this.particlePaint);
                return;
            }
            float f = -1.5707964f;
            SnowflakesEffect snowflakesEffect = SnowflakesEffect.this;
            if (snowflakesEffect.particleBitmap == null) {
                snowflakesEffect.particleThinPaint.setAlpha(255);
                SnowflakesEffect.this.particleBitmap = Bitmap.createBitmap(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(SnowflakesEffect.this.particleBitmap);
                float fDpf2 = AndroidUtilities.dpf2(2.0f) * 2.0f;
                float f2 = (-AndroidUtilities.dpf2(0.57f)) * 2.0f;
                float fDpf22 = 2.0f * AndroidUtilities.dpf2(1.55f);
                int i = 0;
                while (i < 6) {
                    float fDp = AndroidUtilities.dp(8.0f);
                    float fDp2 = AndroidUtilities.dp(8.0f);
                    double d = f;
                    float fCos = ((float) Math.cos(d)) * fDpf2;
                    float fSin = ((float) Math.sin(d)) * fDpf2;
                    float f3 = fCos * 0.66f;
                    canvas2.drawLine(fDp, fDp2, fDp + fCos, fDp2 + fSin, SnowflakesEffect.this.particleThinPaint);
                    Double.isNaN(d);
                    double d2 = (float) (d - 1.5707963267948966d);
                    double dCos = Math.cos(d2);
                    double d3 = f2;
                    Double.isNaN(d3);
                    double dSin = Math.sin(d2);
                    Canvas canvas3 = canvas2;
                    double d4 = fDpf22;
                    Double.isNaN(d4);
                    float f4 = (float) ((dCos * d3) - (dSin * d4));
                    double dSin2 = Math.sin(d2);
                    Double.isNaN(d3);
                    double dCos2 = Math.cos(d2);
                    Double.isNaN(d4);
                    float f5 = fDp + f3;
                    float f6 = fDp2 + (fSin * 0.66f);
                    canvas3.drawLine(f5, f6, fDp + f4, fDp2 + ((float) ((dSin2 * d3) + (dCos2 * d4))), SnowflakesEffect.this.particleThinPaint);
                    double d5 = -Math.cos(d2);
                    Double.isNaN(d3);
                    double d6 = d5 * d3;
                    double dSin3 = Math.sin(d2);
                    Double.isNaN(d4);
                    double d7 = -Math.sin(d2);
                    Double.isNaN(d3);
                    double dCos3 = Math.cos(d2);
                    Double.isNaN(d4);
                    canvas3.drawLine(f5, f6, fDp + ((float) (d6 - (dSin3 * d4))), fDp2 + ((float) ((d7 * d3) + (dCos3 * d4))), SnowflakesEffect.this.particleThinPaint);
                    f += 1.0471976f;
                    i++;
                    canvas2 = canvas3;
                }
            }
            SnowflakesEffect.this.bitmapPaint.setAlpha((int) (this.alpha * 255.0f));
            canvas.save();
            float f7 = this.scale;
            canvas.scale(f7, f7, this.x, this.y);
            SnowflakesEffect snowflakesEffect2 = SnowflakesEffect.this;
            canvas.drawBitmap(snowflakesEffect2.particleBitmap, this.x, this.y, snowflakesEffect2.bitmapPaint);
            canvas.restore();
        }
    }

    public SnowflakesEffect(int i) {
        this.viewType = i;
        Paint paint = new Paint(1);
        this.particlePaint = paint;
        paint.setStrokeWidth(AndroidUtilities.dp(1.5f));
        this.particlePaint.setStrokeCap(Paint.Cap.ROUND);
        this.particlePaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.particleThinPaint = paint2;
        paint2.setStrokeWidth(AndroidUtilities.dp(0.5f));
        this.particleThinPaint.setStrokeCap(Paint.Cap.ROUND);
        this.particleThinPaint.setStyle(Paint.Style.STROKE);
        updateColors();
        for (int i2 = 0; i2 < 20; i2++) {
            this.freeParticles.add(new Particle());
        }
    }

    public void setColorKey(int i) {
        this.colorKey = i;
        updateColors();
    }

    public void updateColors() {
        int color = Theme.getColor(this.colorKey) & (-1644826);
        if (CallProxy$$ExternalSyntheticBackport0.m(Integer.valueOf(this.color), Integer.valueOf(color))) {
            return;
        }
        this.color = color;
        this.particlePaint.setColor(color);
        this.particleThinPaint.setColor(color);
    }

    private void updateParticles(long j) {
        int size = this.particles.size();
        int i = 0;
        while (i < size) {
            Particle particle = this.particles.get(i);
            float f = particle.currentTime;
            float f2 = particle.lifeTime;
            if (f >= f2) {
                if (this.freeParticles.size() < 40) {
                    this.freeParticles.add(particle);
                }
                this.particles.remove(i);
                i--;
                size--;
            } else {
                if (this.viewType == 0) {
                    if (f < 200.0f) {
                        particle.alpha = AndroidUtilities.accelerateInterpolator.getInterpolation(f / 200.0f);
                    } else {
                        particle.alpha = 1.0f - AndroidUtilities.decelerateInterpolator.getInterpolation((f - 200.0f) / (f2 - 200.0f));
                    }
                } else if (f < 200.0f) {
                    particle.alpha = AndroidUtilities.accelerateInterpolator.getInterpolation(f / 200.0f);
                } else if (f2 - f < 2000.0f) {
                    particle.alpha = AndroidUtilities.decelerateInterpolator.getInterpolation((f2 - f) / 2000.0f);
                }
                float f3 = particle.x;
                float f4 = particle.vx;
                float f5 = particle.velocity;
                float f6 = j;
                particle.x = f3 + (((f4 * f5) * f6) / 500.0f);
                particle.y += ((particle.vy * f5) * f6) / 500.0f;
                particle.currentTime += f6;
            }
            i++;
        }
    }

    public void onDraw(View view, Canvas canvas) {
        Particle particle;
        if (view == null || canvas == null || !LiteMode.isEnabled(32)) {
            return;
        }
        int size = this.particles.size();
        for (int i = 0; i < size; i++) {
            this.particles.get(i).draw(canvas);
        }
        int i2 = this.viewType;
        int i3 = i2 == 0 ? 100 : 300;
        int i4 = i2 == 0 ? 1 : 10;
        if (this.particles.size() < i3) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.particles.size() < i3 && Utilities.random.nextFloat() > 0.7f) {
                    int i6 = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
                    float fNextFloat = Utilities.random.nextFloat() * view.getMeasuredWidth();
                    float fNextFloat2 = i6 + (Utilities.random.nextFloat() * ((view.getMeasuredHeight() - AndroidUtilities.dp(20.0f)) - i6));
                    double dNextInt = (Utilities.random.nextInt(40) - 20) + 90;
                    Double.isNaN(dNextInt);
                    double d = dNextInt * 0.017453292519943295d;
                    float fCos = (float) Math.cos(d);
                    float fSin = (float) Math.sin(d);
                    if (!this.freeParticles.isEmpty()) {
                        particle = this.freeParticles.get(0);
                        this.freeParticles.remove(0);
                    } else {
                        particle = new Particle();
                    }
                    particle.x = fNextFloat;
                    particle.y = fNextFloat2;
                    particle.vx = fCos;
                    particle.vy = fSin;
                    particle.alpha = 0.0f;
                    particle.currentTime = 0.0f;
                    particle.scale = Utilities.random.nextFloat() * 1.2f;
                    particle.type = Utilities.random.nextInt(2);
                    if (this.viewType == 0) {
                        particle.lifeTime = Utilities.random.nextInt(100) + 2000;
                    } else {
                        particle.lifeTime = Utilities.random.nextInt(2000) + 3000;
                    }
                    particle.velocity = (Utilities.random.nextFloat() * 4.0f) + 20.0f;
                    this.particles.add(particle);
                }
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        updateParticles(Math.min(17L, jCurrentTimeMillis - this.lastAnimationTime));
        this.lastAnimationTime = jCurrentTimeMillis;
        view.invalidate();
    }
}
