package net.purpleguy.longspoon.item.custom;

import net.minecraft.item.Item;
import net.purpleguy.longspoon.LongSpoon; // Make sure to import

public class LongSpoonItem extends Item {
    public LongSpoonItem(Settings settings) {
        super(settings);
    }

    // No need for finishUsing here if its only effect is via the mixin when in offhand
    // If it HAS its own direct use (e.g. it's edible itself), then keep finishUsing here.
}