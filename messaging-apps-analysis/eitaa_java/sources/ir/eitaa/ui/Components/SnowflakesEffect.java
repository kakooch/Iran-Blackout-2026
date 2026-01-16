package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SnowflakesEffect {
    private int color;
    private long lastAnimationTime;
    private Paint particlePaint;
    private Paint particleThinPaint;
    private String colorKey = "actionBarDefaultTitle";
    final float angleDiff = 1.0471976f;
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
            if (this.type != 0) {
                SnowflakesEffect.this.particleThinPaint.setAlpha((int) (this.alpha * 255.0f));
                float f = -1.5707964f;
                float fDpf2 = AndroidUtilities.dpf2(2.0f) * 2.0f * this.scale;
                float f2 = (-AndroidUtilities.dpf2(0.57f)) * 2.0f * this.scale;
                float fDpf22 = AndroidUtilities.dpf2(1.55f) * 2.0f * this.scale;
                int i = 0;
                while (i < 6) {
                    double d = f;
                    float fCos = ((float) Math.cos(d)) * fDpf2;
                    float fSin = ((float) Math.sin(d)) * fDpf2;
                    float f3 = fCos * 0.66f;
                    float f4 = 0.66f * fSin;
                    float f5 = this.x;
                    float f6 = this.y;
                    canvas.drawLine(f5, f6, f5 + fCos, f6 + fSin, SnowflakesEffect.this.particleThinPaint);
                    Double.isNaN(d);
                    double d2 = (float) (d - 1.5707963267948966d);
                    double dCos = Math.cos(d2);
                    double d3 = f2;
                    Double.isNaN(d3);
                    double dSin = Math.sin(d2);
                    float f7 = fDpf2;
                    float f8 = f2;
                    double d4 = fDpf22;
                    Double.isNaN(d4);
                    float f9 = (float) ((dCos * d3) - (dSin * d4));
                    double dSin2 = Math.sin(d2);
                    Double.isNaN(d3);
                    double dCos2 = Math.cos(d2);
                    Double.isNaN(d4);
                    float f10 = (float) ((dSin2 * d3) + (dCos2 * d4));
                    float f11 = this.x;
                    float f12 = this.y;
                    canvas.drawLine(f11 + f3, f12 + f4, f11 + f9, f12 + f10, SnowflakesEffect.this.particleThinPaint);
                    double d5 = -Math.cos(d2);
                    Double.isNaN(d3);
                    double dSin3 = Math.sin(d2);
                    Double.isNaN(d4);
                    float f13 = (float) ((d5 * d3) - (dSin3 * d4));
                    double d6 = -Math.sin(d2);
                    Double.isNaN(d3);
                    double dCos3 = Math.cos(d2);
                    Double.isNaN(d4);
                    float f14 = (float) ((d6 * d3) + (dCos3 * d4));
                    float f15 = this.x;
                    float f16 = this.y;
                    canvas.drawLine(f15 + f3, f16 + f4, f15 + f13, f16 + f14, SnowflakesEffect.this.particleThinPaint);
                    f += 1.0471976f;
                    i++;
                    fDpf2 = f7;
                    f2 = f8;
                }
                return;
            }
            SnowflakesEffect.this.particlePaint.setAlpha((int) (this.alpha * 255.0f));
            canvas.drawPoint(this.x, this.y, SnowflakesEffect.this.particlePaint);
        }
    }

    public SnowflakesEffect() {
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
        for (int i = 0; i < 20; i++) {
            this.freeParticles.add(new Particle());
        }
    }

    public void setColorKey(String key) {
        this.colorKey = key;
        updateColors();
    }

    public void updateColors() {
        int color = Theme.getColor(this.colorKey) & (-1644826);
        if (this.color != color) {
            this.color = color;
            this.particlePaint.setColor(color);
            this.particleThinPaint.setColor(color);
        }
    }

    private void updateParticles(long dt) {
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
                if (f < 200.0f) {
                    particle.alpha = AndroidUtilities.accelerateInterpolator.getInterpolation(f / 200.0f);
                } else {
                    particle.alpha = 1.0f - AndroidUtilities.decelerateInterpolator.getInterpolation((f - 200.0f) / (f2 - 200.0f));
                }
                float f3 = particle.x;
                float f4 = particle.vx;
                float f5 = particle.velocity;
                float f6 = dt;
                particle.x = f3 + (((f4 * f5) * f6) / 500.0f);
                particle.y += ((particle.vy * f5) * f6) / 500.0f;
                particle.currentTime += f6;
            }
            i++;
        }
    }

    public void onDraw(View parent, Canvas canvas) {
        Particle particle;
        if (parent == null || canvas == null) {
            return;
        }
        int size = this.particles.size();
        for (int i = 0; i < size; i++) {
            this.particles.get(i).draw(canvas);
        }
        if (Utilities.random.nextFloat() > 0.7f && this.particles.size() < 100) {
            int i2 = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            float fNextFloat = Utilities.random.nextFloat() * parent.getMeasuredWidth();
            float fNextFloat2 = i2 + (Utilities.random.nextFloat() * ((parent.getMeasuredHeight() - AndroidUtilities.dp(20.0f)) - i2));
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
            particle.lifeTime = Utilities.random.nextInt(100) + 2000;
            particle.velocity = (Utilities.random.nextFloat() * 4.0f) + 20.0f;
            this.particles.add(particle);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        updateParticles(Math.min(17L, jCurrentTimeMillis - this.lastAnimationTime));
        this.lastAnimationTime = jCurrentTimeMillis;
        parent.invalidate();
    }
}
