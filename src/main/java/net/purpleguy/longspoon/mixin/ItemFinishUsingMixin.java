// src/main/java/net/purpleguy/longspoon/mixin/ItemFinishUsingMixin.java
package net.purpleguy.longspoon.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodComponent; // Important for checking if it's food
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.purpleguy.longspoon.LongSpoon;
import net.purpleguy.longspoon.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class) // Target the Item class
public abstract class ItemFinishUsingMixin {

    // Inject after the original finishUsing method returns
    @Inject(method = "finishUsing", at = @At("RETURN"))
    private void longspoon_onFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        // Only proceed if the user is a PlayerEntity and it's on the server side
        if (user instanceof PlayerEntity player && !world.isClient()) {
            // Check if the item just finished using was actually food
            // We cast (Item)(Object)this because the mixin is applied to Item.class
            if (((Item)(Object)this).isFood()) {
                ItemStack offhandStack = player.getOffHandStack();

                // Check if the offhand item is the Long Spoon
                if (offhandStack.isOf(ModItems.LONG_SPOON)) {
                    LongSpoon.LOGGER.info("Player finished eating food with Long Spoon in offhand!");

                    // Apply the desired effects
                    player.getHungerManager().setFoodLevel(20);
                    player.getHungerManager().setSaturationLevel(20);

                    // Damage the Long Spoon in the offhand
                    // The damage method takes (amount, entity, consumer for sending break status)
                    offhandStack.damage(1, player, (p) -> p.sendToolBreakStatus(Hand.OFF_HAND));
                }
            }
        }
    }
}