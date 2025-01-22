package com.licuadora;

/**
 * Interface representing a Blender with various functionalities.
 */
public interface IBlender {

    /**
     * Checks the current power status of the blender.
     * @return byte representing power status (0 for off, 1 for on).
     */
    public byte checkPowerStatus();

    /**
     * Toggles the power status of the blender.
     * @return byte representing the new power status.
     */
    public byte switchPowerStatus();

    /**
     * Fills the blender with a product.
     * @param prod The product to be added.
     * @param ml The amount in milliliters.
     */
    public void fillBlender(String prod, float ml);

    /**
     * Returns the current capacity of the blender in milliliters.
     * @return The current capacity as an integer.
     */
    public int actualCapacity();

    /**
     * Fills the blender with a product to its maximum capacity.
     * @param prod The product to be added.
     */
    public void fillBlender(String prod);

    /**
     * Increases the speed of the blender by one unit.
     */
    public void increaseSpeed();

    /**
     * Decreases the speed of the blender by one unit.
     */
    public void decreaseSpeed();

    /**
     * Retrieves the current speed of the blender.
     * @return byte representing the current speed.
     */
    public byte checkSpeed();

    /**
     * Checks if the blender is full.
     * @return true if the blender is full, false otherwise.
     */
    public boolean isFull();

    /**
     * Empties the contents of the blender.
     */
    public void emptyBlender();

    /**
     * Empties a specific amount of the blender's contents.
     * @param ml The amount to remove in milliliters.
     */
    public void emptyBlender(float ml);
}
