package com.brad.SnakeGDX.framework;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by brad on 3/15/15.
 */
public class GameClock
{
    private double t;
    private int tps;           // Logic updates per second
    private int dt;            // Time between logic updates in milliseconds
    private int maxFps;       // Max render frames per second
    private int fdt;           // Minimum time between render frames
    private long current_time;
    private long newTime;
    private double accumulator;
    private long frameTime;
    private long drawTime;
    public boolean drawReady;

    public GameClock(int tps, int maxFps) {
        this.t = 0.0;
        this.accumulator = 0.0;
        this.current_time = TimeUtils.nanoTime();
        this.tps = tps;
        this.maxFps = maxFps;
        if (this.tps != 0) {
            this.dt = 1000 / this.tps;
        } else {
            this.dt = 16;
        }
        if (this.maxFps != 0) {
            this.fdt = 1000 / this.maxFps;
        } else {
            this.fdt = 0;
        }
        this.drawReady = true;
    }

    public void update() {
        this.newTime = TimeUtils.nanoTime();
        this.frameTime = TimeUtils.nanosToMillis(this.newTime - this.current_time);
        if (this.frameTime > 5 * this.dt) {
            this.frameTime = 5 * this.dt;
        }
        this.drawTime += frameTime;
        if ((this.drawTime > this.fdt) || (this.fdt == 0)) {
            this.drawTime = 0;
            this.drawReady = true;
        }
        this.current_time = this.newTime;
        this.accumulator += frameTime;
    }

    public boolean runLogic() {
        if (this.accumulator >= this.dt) {
            this.accumulator -= this.dt;
            this.t += this.dt;
            return true;
        } else {
            return false;
        }
    }

    public double getT() {
        return this.t;
    }

    public double getAccumulator() {
        return this.accumulator;
    }
}
