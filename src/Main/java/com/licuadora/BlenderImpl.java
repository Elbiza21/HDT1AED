package com.licuadora;

public class BlenderImpl implements IBlender {

    private byte powerStatus; // 0: Off, 1: On
    private String content;
    private float capacity;
    private float maxCapacity = 1000; // Max capacity in milliliters
    private byte speed; // Speed levels

    public BlenderImpl() {
        this.powerStatus = 0;
        this.content = "";
        this.capacity = 0;
        this.speed = 0;
    }

    @Override
    public byte checkPowerStatus() {
        return powerStatus;
    }

    @Override
    public byte switchPowerStatus() {
        powerStatus = (byte) (powerStatus == 0 ? 1 : 0);
        if (powerStatus == 0) {
            speed = 0; // Reset speed when turned off
        }
        return powerStatus;
    }

    @Override
    public void fillBlender(String prod, float ml) {
        if (capacity + ml > maxCapacity) {
            throw new IllegalArgumentException("La cantidad excede la capacidad máxima de la licuadora.");
        }
        this.content = prod;
        this.capacity += ml;
    }

    @Override
    public int actualCapacity() {
        return (int) capacity;
    }

    @Override
    public void fillBlender(String prod) {
        this.content = prod;
        this.capacity = maxCapacity;
    }

    @Override
    public void increaseSpeed() {
        if (powerStatus == 0) {
            throw new IllegalStateException("No se puede aumentar la velocidad mientras la licuadora está apagada.");
        }
        speed++;
    }

    @Override
    public void decreaseSpeed() {
        if (speed > 0) {
            speed--;
        }
    }

    @Override
    public byte checkSpeed() {
        return speed;
    }

    @Override
    public boolean isFull() {
        return capacity == maxCapacity;
    }

    @Override
    public void emptyBlender() {
        this.content = "";
        this.capacity = 0;
    }

    @Override
    public void emptyBlender(float ml) {
        if (ml > capacity) {
            throw new IllegalArgumentException("No se puede vaciar más de lo que contiene la licuadora.");
        }
        this.capacity -= ml;
        if (capacity == 0) {
            this.content = "";
        }
    }
}

